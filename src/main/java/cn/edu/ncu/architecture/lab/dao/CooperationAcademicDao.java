package cn.edu.ncu.architecture.lab.dao;

import cn.edu.ncu.architecture.lab.model.CooperationAcademic;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 交流合作-学术交流
 * table:cooperation_communication_academic
 */
public interface CooperationAcademicDao {
    /**
     * 添加学术交流
     */
    @Insert("insert into cooperation_communication_academic (time, publisher,title,content) " +
            "values (#{time}, #{publisher}, #{title}, #{content})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
    boolean insertAcademic(CooperationAcademic cooperationAcademic);

    /**
     * 获取学术交流
     */
    @Select("select * from cooperation_communication_academic where id = #{id}")
    CooperationAcademic findAcademicById(Integer id);

    /**
     * 获取所有学术交流
     */
    @Select("select * from cooperation_communication_academic")
    List<CooperationAcademic> findAllCooperationAcademic();

    /**
     * 删除学术交流
     */
    @Delete("delete from cooperation_communication_academic where id = #{id}")
    boolean deleteAcademic(Integer id);

    /**
     * 修改学术交流
     */
    @Update("update cooperation_communication_academic set time = #{time} , publisher = #{publisher} , title = #{title} , content = #{content} where id = #{id}")
    boolean updateAcademic(CooperationAcademic cooperationAcademic);
}
