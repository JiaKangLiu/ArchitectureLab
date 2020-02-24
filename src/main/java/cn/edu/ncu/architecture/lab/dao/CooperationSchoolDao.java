package cn.edu.ncu.architecture.lab.dao;

import cn.edu.ncu.architecture.lab.model.CooperationSchool;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 交流合作-校企合作
 * table:cooperation_communication_school
 */
public interface CooperationSchoolDao {
    /**
     * 添加校企合作
     */
    @Insert("insert into cooperation_communication_school (time, publisher,title,content) " +
            "values (#{time}, #{publisher}, #{title}, #{content})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
    boolean insertSchool(CooperationSchool cooperationSchool);

    /**
     * 获取校企合作
     */
    @Select("select * from cooperation_communication_school where id = #{id}")
    CooperationSchool findSchoolById(Integer id);

    /**
     * 获取所有校企合作
     */
    @Select("select * from cooperation_communication_school")
    List<CooperationSchool> findAllSchools();

    /**
     * 删除校企合作
     */
    @Delete("delete from cooperation_communication_school where id = #{id}")
    boolean deleteSchool(Integer id);

    /**
     * 修改校企合作
     */
    @Update("update cooperation_communication_school set time = #{time} , publisher = #{publisher} , title = #{title} , content = #{content} where id = #{id}")
    boolean updateSchool(CooperationSchool cooperationSchool);
}
