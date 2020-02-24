package cn.edu.ncu.architecture.lab.dao;

import cn.edu.ncu.architecture.lab.model.Introduction;
import org.apache.ibatis.annotations.*;

/**
 * 实验室简介
 * table：introduction
 */
public interface IntroductionDao {
    /**
     * 添加实验室简介
     */
    @Insert("insert into introduction (time, publisher, title, content) " +
            "values (#{time}, #{publisher}, #{title}, #{content})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
    boolean insertIntroduction(Introduction introduction);

    /**
     * 获取实验室简介
     */
    @Select("select * from introduction where id = #{id}")
    Introduction findIntroductionById(Integer id);

    /**
     * 删除实验室简介
     */
    @Delete("delete from introduction where id = #{id}")
    boolean deleteIntroduction(Integer id);

    /**
     * 修改实验室简介
     */
    @Update("update introduction set time = #{time} , publisher = #{publisher}, title = #{title}, content = #{content} where id = #{id}")
    boolean updateIntroduction(Introduction introduction);
}
