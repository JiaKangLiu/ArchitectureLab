package cn.edu.ncu.architecture.lab.dao;

import cn.edu.ncu.architecture.lab.model.ResearchAreas;
import org.apache.ibatis.annotations.*;

/**
 * 研究领域
 * table:research_areas
 */
public interface ResearchAreasDao {
    /**
     * 添加研究领域
     */
    @Insert("insert into research_areas (time, publisher,title,content) " +
            "values (#{time}, #{publisher}, #{title}, #{content})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
    boolean insertResearchAreas(ResearchAreas researchAreas);

    /**
     * 获取研究领域
     */
    @Select("select * from research_areas where id = #{id}")
    ResearchAreas findResearchAreasById(Integer id);

    /**
     * 删除研究领域
     */
    @Delete("delete from research_areas where id = #{id}")
    boolean deleteResearchAreas(Integer id);

    /**
     * 修改研究领域
     */
    @Update("update research_areas set time = #{time} , publisher = #{publisher} , title = #{title} , content = #{content} where id = #{id}")
    boolean updateResearchAreas(ResearchAreas researchAreas);
}

