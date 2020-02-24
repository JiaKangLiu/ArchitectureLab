package cn.edu.ncu.architecture.lab.dao;

import cn.edu.ncu.architecture.lab.model.Recruit;
import org.apache.ibatis.annotations.*;

/**
 * 英才招聘
 * table:recruit
 */
public interface RecruitDao {
    /**
     * 添加英才招聘
     */
    @Insert("insert into recruit (time, publisher, title, content) " +
            "values (#{time}, #{publisher}, #{title}, #{content})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
    boolean insertRecruit(Recruit recruit);

    /**
     * 获取英才招聘
     */
    @Select("select * from recruit where id = #{id}")
    Recruit findRecruitById(Integer id);

    /**
     * 删除英才招聘
     */
    @Delete("delete from recruit where id = #{id}")
    boolean deleteRecruit(Integer id);

    /**
     * 修改英才招聘
     */
    @Update("update recruit set time = #{time} , publisher = #{publisher} , title = #{title}, content = #{content} where id = #{id}")
    boolean updateRecruit(Recruit recruit);
}
