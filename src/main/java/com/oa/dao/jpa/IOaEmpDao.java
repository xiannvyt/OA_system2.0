package com.oa.dao.jpa;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oa.pojos.OaEmp;

public interface IOaEmpDao extends JpaSpecificationExecutor<OaEmp>,JpaRepository<OaEmp, String>{
	
	@Query("select e from OaEmp e")
	public List<OaEmp> queryEmp(Pageable p);
	//select d.deptName,e.empName,e.empId,e.empSex,e.empBirth,e.empType,e.empState,j.jobName,j.jobLevel,e.empEntry from OaEmp e inner join e.oaDept d and inner join e.oaJob j
	
	@Query("select count(e) from OaEmp e")
	public int queryEmpcount();
	
	/**
	 * 根据用户编号查询所有角色
	 * @param empId
	 * @return
	 */
	@Query(value="SELECT * from oa_role WHERE role_id in(SELECT role_id FROM oa_role_emp WHERE emp_id=(:empId))",nativeQuery=true)
	public List<Object[]> findRolesByEmpId(@Param("empId")String empId);
}