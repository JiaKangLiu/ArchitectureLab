package cn.edu.ncu.architecture.lab.dao;

import cn.edu.ncu.architecture.lab.model.Work;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 工作条例
 * table：work
 */
public interface WorkDao {
    /**
     * 添加工作条例
     */
    @Insert("insert into work (time, publisher, title, content) " +
            "values (#{time}, #{publisher}, #{title}, #{content})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
    boolean insertWork(Work work);

    /**
     * 获取相应id工作条例
     */
    @Select("select * from work where id = #{id}")
    Work findWorkById(Integer id);

    /**
     * 删除工作条例
     */
    @Delete("delete from work where id = #{id}")
    boolean deleteWork(Integer id);

    /**
     * 修改工作条例
     */
    @Update("update work set time = #{time} , publisher = #{publisher}, title = #{title}, content = #{content} where id = #{id}")
    boolean updateWork(Work work);

    /**
     * 获取所有工作条例
     */
    @Select("select * from work")
    List<Work> findAllWorks();
}
