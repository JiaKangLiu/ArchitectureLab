package cn.edu.ncu.architecture.lab.dao;

import cn.edu.ncu.architecture.lab.model.Dynamic;
import cn.edu.ncu.architecture.lab.model.PersonnelTraining;
import org.apache.ibatis.annotations.*;

/**
 * 人才培养
 * table:personnel_training
 */
public interface PersonnelDao {
    /**
     * 添加人才培养
     */
    @Insert("insert into personnel_training (time, publisher,title,content) " +
            "values (#{time}, #{publisher}, #{title}, #{content})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
    boolean insertPersonnel(PersonnelTraining personnelTraining);

    /**
     * 获取人才培养
     */
    @Select("select * from personnel_training where id = #{id}")
    PersonnelTraining findPersonnelById(Integer id);

    /**
     * 删除人才培养
     */
    @Delete("delete from personnel_training where id = #{id}")
    boolean deletePersonnel(Integer id);

    /**
     * 修改人才培养
     */
    @Update("update personnel_training set time = #{time} , publisher = #{publisher} , title = #{title} , content = #{content} where id = #{id}")
    boolean updatePersonnel(PersonnelTraining personnelTraining);
}

