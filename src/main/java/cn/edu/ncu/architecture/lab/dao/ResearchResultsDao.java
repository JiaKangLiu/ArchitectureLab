package cn.edu.ncu.architecture.lab.dao;

import cn.edu.ncu.architecture.lab.model.ResearchAreas;
import cn.edu.ncu.architecture.lab.model.ResearchResults;
import org.apache.ibatis.annotations.*;

/**
 * 研究领域
 * table:research_results
 */
public interface ResearchResultsDao {
    /**
     * 添加研究领域
     */
    @Insert("insert into research_results (time, publisher,title,content) " +
            "values (#{time}, #{publisher}, #{title}, #{content})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
    boolean insertResearchResults(ResearchResults researchResults);

    /**
     * 获取研究领域
     */
    @Select("select * from research_results where id = #{id}")
    ResearchResults findResearchResultsById(Integer id);

    /**
     * 删除研究领域
     */
    @Delete("delete from research_results where id = #{id}")
    boolean deleteResearchResults(Integer id);

    /**
     * 修改研究领域
     */
    @Update("update research_results set time = #{time} , publisher = #{publisher} , title = #{title} , content = #{content} where id = #{id}")
    boolean updateResearchResults(ResearchResults researchResults);
}

