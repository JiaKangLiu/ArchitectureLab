package cn.edu.ncu.architecture.lab.dao;


import cn.edu.ncu.architecture.lab.model.Instrument;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 仪器平台
 * table:instrument
 */
public interface InstrumentDao {
    /**
     * 添加仪器
     */
    @Insert("insert into instrument (time, publisher, name, img, manager, tel, introduction) " +
            "values (#{time}, #{publisher}, #{name}, #{img}, #{manager}, #{tel}, #{introduction})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
    boolean insertInstrument(Instrument instrument);

    /**
     * 删除仪器
     */
    @Delete("delete from instrument where id = #{id}")
    boolean deleteInstrument(Integer id);

    /**
     * 修改仪器信息
     */
    @Update("update instrument set time = #{time}, publisher = #{publisher}, name = #{name}, img= #{img}, " +
            " manager = #{manager}, tel = #{tel}, introduction = #{introduction} where id = #{id}")
    boolean updateInstrument(Instrument instrument);

    /**
     * 查询所有仪器的信息
     */
    @Select("select * from instrument")
    List<Instrument> findAllInstrument();

    /**
     * 根据id查询仪器
     */
    @Select("select * from instrument where id = #{id}")
    Instrument findInstrumentById(Integer id);
}
