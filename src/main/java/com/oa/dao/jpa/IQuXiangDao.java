package com.oa.dao.jpa;



import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oa.pojos.OaWhereabout;

public interface IQuXiangDao extends JpaRepository<OaWhereabout, String>{

	/*@Query("select new com.oa.pojos.OaWhereabout(o.wheAbout,o.wheEnd,o.wheStart) from OaWhereabout o where o.oaEmp.Empid=:id")
	public List<OaWhereabout> findAllByEmpId(Pageable pageable,@Param("id") String id);*/
	

	
}
