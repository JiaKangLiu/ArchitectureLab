package cn.edu.ncu.architecture.lab.dao;

import cn.edu.ncu.architecture.lab.model.ResearchTeam;
import org.apache.ibatis.annotations.*;

/**
 * 研究领域
 * table:research_team
 */
public interface ResearchTeamDao {
    /**
     * 添加研究领域
     */
    @Insert("insert into research_team (time, publisher,title,content) " +
            "values (#{time}, #{publisher}, #{title}, #{content})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
    boolean insertResearchTeam(ResearchTeam researchTeam);

    /**
     * 获取研究领域
     */
    @Select("select * from research_team where id = #{id}")
    ResearchTeam findResearchTeamById(Integer id);

    /**
     * 删除研究领域
     */
    @Delete("delete from research_team where id = #{id}")
    boolean deleteResearchTeam(Integer id);

    /**
     * 修改研究领域
     */
    @Update("update research_team set time = #{time} , publisher = #{publisher} , title = #{title} , content = #{content} where id = #{id}")
    boolean updateResearchTeam(ResearchTeam researchTeam);
}

