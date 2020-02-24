package cn.edu.ncu.architecture.lab.dao;

import cn.edu.ncu.architecture.lab.model.Dynamic;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 科技动态
 * table:dynamic
 */
public interface DynamicDao {
    /**
     * 添加科技动态
     */
    @Insert("insert into dynamic (time, publisher,title,content) " +
            "values (#{time}, #{publisher}, #{title}, #{content})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
    boolean insertDynamic(Dynamic dynamic);

    /**
     * 获取科技动态
     */
    @Select("select * from dynamic where id = #{id}")
    Dynamic findDynamicById(Integer id);

    /**
     * 获取所有科技动态
     */
    @Select("select * from dynamic")
    List<Dynamic> findAllDynamic();

    /**
     * 删除科技动态
     */
    @Delete("delete from dynamic where id = #{id}")
    boolean deleteDynamic(Integer id);

    /**
     * 修改科技动态
     */
    @Update("update dynamic set time = #{time} , publisher = #{publisher} , title = #{title} , content = #{content} where id = #{id}")
    boolean updateDynamic(Dynamic dynamic);
}

