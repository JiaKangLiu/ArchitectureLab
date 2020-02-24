package cn.edu.ncu.architecture.lab.dao;

import cn.edu.ncu.architecture.lab.model.CooperationInternational;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 交流合作-国际交流
 * table:cooperation_communication_international
 */
public interface CooperationInternationalDao {
    /**
     * 添加国际交流
     */
    @Insert("insert into cooperation_communication_international (time, publisher,title,content) " +
            "values (#{time}, #{publisher}, #{title}, #{content})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
    boolean insertInternational(CooperationInternational cooperationInternational);

    /**
     * 获取国际交流
     */
    @Select("select * from cooperation_communication_international where id = #{id}")
    CooperationInternational findInternationalById(Integer id);

    /**
     * 获取所有的国际交流
     */
    @Select("select * from cooperation_communication_international")
    List<CooperationInternational> findAllInternationals();

    /**
     * 删除国际交流
     */
    @Delete("delete from cooperation_communication_international where id = #{id}")
    boolean deleteInternational(Integer id);

    /**
     * 修改国际交流
     */
    @Update("update cooperation_communication_international set time = #{time} , publisher = #{publisher} , title = #{title} , content = #{content} where id = #{id}")
    boolean updateInternational(CooperationInternational cooperationInternational);
}
