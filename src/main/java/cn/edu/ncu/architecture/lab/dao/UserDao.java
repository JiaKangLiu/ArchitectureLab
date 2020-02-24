package cn.edu.ncu.architecture.lab.dao;

import cn.edu.ncu.architecture.lab.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * 管理员表
 * table:user
 */
public interface UserDao {
    /**
     * 获得id用户
     * @param id
     */
    @Select("select * from users where id = #{id}")
    User findUserById(Integer id);

    /**
     * 新建用户
     * @param user
     */
    @Insert("insert into users (username, password) values (#{username}, #{password})")
    boolean addUser(User user);

    /**
     * 根据用户名查找
     */
    @Select("select * from users where username = #{username}")
    User findByUsername(String username);
}
