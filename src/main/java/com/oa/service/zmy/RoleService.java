package com.oa.service.zmy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.lf5.viewer.configure.MRUFileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oa.dao.jpa.IOaEmpDao;
import com.oa.dao.jpa.IOaMenuDao;
import com.oa.dao.jpa.IOaRoleDao;
import com.oa.pojos.OaEmp;
import com.oa.pojos.OaMenu;
import com.oa.pojos.OaRole;
import com.oa.vo.ResultMap;

@Service
@Transactional
public class RoleService {
	
	@Autowired
	IOaRoleDao rDao;
	
	@Autowired
	IOaMenuDao mDao;
	
	@Autowired
	IOaEmpDao eDao;
	

	/**
	 * 增加角色
	 * @param r
	 * @return
	 * @throws Exception
	 */
	public Boolean addRole(OaRole r) throws Exception{
		if(r.getRoleName().equals("")){
			throw new Exception("请求参数为空");
		}
		try {
			OaRole role = rDao.save(r);
			if(role!=null){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			throw new Exception("角色添加错误");
		}
	}
	/**
	 * 查询所有角色
	 * @return
	 * @throws Exception
	 */
	public List<OaRole> getRoles() throws Exception{
		try{
			List<OaRole> list = rDao.findOaRoles();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("角色查询错误");
		}
	}
	/**
	 * 编辑角色
	 * @param formRole
	 * @return
	 * @throws Exception
	 */
	public Boolean editRole(OaRole formRole) throws Exception{
		try {
			OaRole role = rDao.findOne(formRole.getRoleId());
			if(role!=null){
				role.setRoleName(formRole.getRoleName());
				role.setDeptId(formRole.getDeptId());
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("角色编辑错误");
		}
	}
	/**
	 * 删除角色
	 * @param formRole
	 * @return
	 * @throws Exception
	 */
	public Boolean deleteRole(OaRole formRole) throws Exception{
		try {
			rDao.delete(formRole.getRoleId());
			return true;
		} catch (Exception e) {
			throw new Exception("角色删除错误");
		}
	}
	
	/**
	 * 授权
	 * @param roleId
	 * @param menuIds
	 * @return
	 * @throws Exception
	 */
	public Boolean authorization(Integer roleId,List<Integer> menuIds) throws Exception{
		try{
			OaRole role = rDao.findOne(roleId);
			List<OaMenu> menus = mDao.findAll(menuIds);
			role.setOaMenus(menus);
			OaRole result = rDao.save(role);
			if(result!=null){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("设置权限错误");
		}
	}
	
	/**
	 * 根据角色获取菜单权限封装menus
	 * @param roleId
	 * @return
	 * @throws Exception 
	 */
	public List<Map<String, Object>> getRoleMenus(int roleId) throws Exception{
		try{
			List<Object[]> menus = rDao.findRoleMenus(roleId);
			List<Map<String,Object>> maps=new ArrayList<>();
			for (Object[] objects : menus) {
				Map<String,Object> map=new HashMap<>();
				map.put("menuId", objects[0]);
				map.put("menuName", objects[1]);
				map.put("menuFather", objects[2]);
				map.put("menuLink", objects[3]);
				map.put("menuImg", objects[4]);
				map.put("menuIsvisible", objects[5]);
				maps.add(map);
			}
			return maps;
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("获取权限失败");
		}
		
	}
	
	/**
	 * 根据用户编号获取角色的所有权限
	 * @param empId
	 * @return
	 * @throws Exception
	 */
	public Set<Object> getRoleMenusByEmp(String empId) throws Exception {
		try {
			List<Object[]> roles = eDao.findRolesByEmpId(empId);
			Set<Object> menuList=new HashSet<>();
			for (Object[] role : roles) {
				System.out.println(role[0]);
				List<Object[]> menus = rDao.findRoleMenus(role[0]);
				for (Object[] menu : menus) {
						HashMap<String, Object> map=new HashMap<>();
						map.put("menuId", menu[0]);
						map.put("menuName", menu[1]);
						map.put("menuFather", menu[2]);
						map.put("menuLink", menu[3]);
						map.put("menuImg", menu[4]);
						map.put("menuIsvisible", menu[5]);
						menuList.add(map);
					}
				}
			return menuList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("根据用户所属权限获取所有权限错误");
		}
	}
	
}
