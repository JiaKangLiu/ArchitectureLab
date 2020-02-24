package cn.edu.ncu.architecture.lab.service.serviceImpl;

import cn.edu.ncu.architecture.lab.dao.UserDao;
import cn.edu.ncu.architecture.lab.model.User;
import cn.edu.ncu.architecture.lab.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Calendar;
import java.util.Date;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Value("application.secret")
    private String secret;
    /**
     * 用户注册
     *
     * @param username
     * @param password
     * @return
     */
    public boolean register(String username, String password) {
        String salt = BCrypt.gensalt();
        String pwdHash = BCrypt.hashpw(password, salt);

        User user = new User();
        user.setUsername(username);
        user.setPassword(pwdHash);

        // todo: check unique.
        userDao.addUser(user);

        return true;
    }

    /**
     * 生成Token
     *
     * @param user
     * @return
     */
    public String generateToken(User user) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.HOUR, 1);

        Date exp = now.getTime();

        return Jwts.builder()
                .claim(
                        "id", user.getId()
                ).setIssuedAt(Calendar.getInstance().getTime())
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.encode(secret)).compact();
    }

    /**
     * 验证Token
     *
     * @param token
     * @return
     */
    public User verifyToken(String token) {
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(TextCodec.BASE64.encode(secret))
                    .parseClaimsJws(token)
                    .getBody();

            Integer id = (Integer) body.get("id");

            return userDao.findUserById(id);
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 验证登录用户
     *
     * @param username
     * @param password
     * @return
     */
    public User checkUser(String username, String password) {
        User user = userDao.findByUsername(username);

        if (user == null) return null;

        if (BCrypt.checkpw(password, user.getPassword())) {
            return user;
        } else return null;
    }
}