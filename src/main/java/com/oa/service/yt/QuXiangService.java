package com.oa.service.yt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oa.dao.jpa.IEmpdao;
import com.oa.dao.jpa.IQuXiangDao;
import com.oa.pojos.OaDept;
import com.oa.pojos.OaEmp;
import com.oa.pojos.OaMenu;
import com.oa.pojos.OaWhereabout;
import com.oa.vo.fwt.OaEmpvo;
@Service
@Transactional
public class QuXiangService {
	@Autowired
	IQuXiangDao qDao;
	public Map<String, Object> getQuXiangInfo(int currentPage, int limit,String id) {
		//获取数据库所有菜单数据
		Pageable pageable=new PageRequest(currentPage-1, limit);
		/*List<OaWhereabout> findAllByEmpId = qDao.findAllByEmpId(pageable, id);*/
		Map<String, Object> dataMap=new HashMap<>();
		/*
	
		dataMap.put("code", 0);
		dataMap.put("count",findAllByEmpId.size());
		dataMap.put("data", findAllByEmpId);*/
		return dataMap;
	}

}
