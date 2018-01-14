package com.oa.dao.jpa;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oa.pojos.OaMenu;
import com.oa.pojos.OaRole;

public interface IOaRoleDao extends JpaRepository<OaRole, Integer>{
	
	/**
	 * 查找所有角色
	 * @return
	 */
	@Query("select new com.oa.pojos.OaRole(r.roleId,r.deptId,r.roleName) from OaRole r")
	public List<OaRole> findOaRoles();

	
	@Query(value="SELECT * FROM oa_menu WHERE menu_id IN (SELECT menu_id FROM oa_role_menu WHERE role_id = (:id))",nativeQuery=true)
	public List<Object[]> findRoleMenus(@Param("id")Object roleId);
	
}
