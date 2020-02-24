package cn.edu.ncu.architecture.lab.dao;

import cn.edu.ncu.architecture.lab.model.Organization;
import org.apache.ibatis.annotations.*;

/**
 * 组织机构
 * table:organization
 */
public interface OrganizationDao {
    /**
     * 添加组织机构
     */
    @Insert("insert into organization (time, publisher, title, content) " +
            "values (#{time}, #{publisher}, #{title}, #{content})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
    boolean insertOrganization(Organization organization);

    /**
     * 获取组织机构
     */
    @Select("select * from organization where id = #{id}")
    Organization findOrganizationById(Integer id);

    /**
     * 删除组织机构
     */
    @Delete("delete from organization where id = #{id}")
    boolean deleteOrganization(Integer id);

    /**
     * 修改组织机构
     */
    @Update("update organization set time = #{time} , publisher = #{publisher} , title = #{title}, content = #{content} where id = #{id}")
    boolean updateOrganization(Organization organization);
}
