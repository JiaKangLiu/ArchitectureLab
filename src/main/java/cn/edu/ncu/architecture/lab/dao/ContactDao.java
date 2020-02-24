package cn.edu.ncu.architecture.lab.dao;

import cn.edu.ncu.architecture.lab.model.Contact;
import org.apache.ibatis.annotations.*;

/**
 * 联系我们
 * table:contact
 */
public interface ContactDao {
    /**
     * 添加联系我们
     */
    @Insert("insert into contact (time, publisher, title, content) " +
            "values (#{time}, #{publisher}, #{title}, #{content})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
    boolean insertContact(Contact contact);

    /**
     * 获取联系我们
     */
    @Select("select * from contact where id = #{id}")
    Contact findContactById(Integer id);

    /**
     * 删除联系我们
     */
    @Delete("delete from contact where id = #{id}")
    boolean deleteContact(Integer id);

    /**
     * 修改联系我们
     */
    @Update("update contact set time = #{time} , publisher = #{publisher}, title = #{title}, content = #{content} where id = #{id}")
    boolean updateContact(Contact contact);
}
