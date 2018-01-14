package com.oa.controller.zmy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.pojos.OaMenu;
import com.oa.pojos.OaRole;
import com.oa.service.zmy.RoleService;
import com.oa.vo.ResultMap;

@Controller
public class RoleController {
	
	@Autowired
	RoleService rService;
	
	/**
	 * 增加角色URL
	 * @param formRole
	 * @return
	 */
	@RequestMapping(value="/to_addRole.do",params={"roleName"})
	public @ResponseBody Map<String, Object> toAddRole(OaRole formRole){
		try {
			Boolean result = rService.addRole(formRole);
			ResultMap.putObj(result, "添加成功","添加失败");
			return ResultMap.getResultMap();
		} catch (Exception e) {
			e.printStackTrace();
			ResultMap.putObj(false,null,e.getMessage());
			return ResultMap.getResultMap();
		}
	}
	
	/**
	 * 获取所有角色URL
	 * @return
	 */
	@RequestMapping("/to_listRoles.do")
	public @ResponseBody Map<String, Object> getRoles(){
		try {
			List<OaRole> result = rService.getRoles();
			ResultMap.putObj("code",0);
			ResultMap.putObj("data", result);
			return ResultMap.getResultMap();
		} catch (Exception e) {
			e.printStackTrace();
			ResultMap.putObj(false,null,e.getMessage());
			return ResultMap.getResultMap();
		}
	}
	
	/**
	 * 编辑角色URL
	 * @param formRole
	 * @return
	 */
	@RequestMapping(value="/to_editRole.do",params={"roleId"})
	public @ResponseBody Map<String, Object> editRole(OaRole formRole){
		try {
			Boolean result = rService.editRole(formRole);
			ResultMap.putObj(result,"修改成功","修改失败");
			return ResultMap.getResultMap();
		} catch (Exception e) {
			e.printStackTrace();
			ResultMap.putObj(false,null,e.getMessage());
			return ResultMap.getResultMap();
		}
	}
	
	/**
	 * 角色授权URL
	 * @param roleId
	 * @param menuIds
	 * @return
	 */
	@RequestMapping(value="/to_authorization.do",params={"roleId"})
	public @ResponseBody Map<String, Object> authorization(@RequestParam("roleId")Integer roleId,@RequestParam(value = "menuIds", required = false) List<Integer> menuIds){
		try {
			Boolean result = rService.authorization(roleId, menuIds);
			ResultMap.putObj(result,"授权成功","授权失败");
			return ResultMap.getResultMap();
		} catch (Exception e) {
			e.printStackTrace();
			ResultMap.putObj(false,null,e.getMessage());
			return ResultMap.getResultMap();
		}
	}
	
	/**
	 * 获取角色所有权限URL
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value="/to_role_menus.do",params={"roleId"})
	public @ResponseBody Map<String, Object> roleMenus(@RequestParam("roleId")Integer roleId){
		try {
			List<Map<String, Object>> result = rService.getRoleMenus(roleId);
			ResultMap.putObj("menus",result);
			return ResultMap.getResultMap();
		} catch (Exception e) {
			e.printStackTrace();
			ResultMap.putObj(false,null,e.getMessage());
			return ResultMap.getResultMap();
		}
	}
	
	/**
	 * 根据用户编号获取用户所有权限
	 * @param empId
	 * @return
	 */
	@RequestMapping(value="/to_emp_menus.do",params={"empId"})
	public @ResponseBody Map<String, Object> empMenus(@RequestParam("empId")String empId){
		try {
			Set<Object> list = rService.getRoleMenusByEmp(empId);
			ResultMap.putObj("menus", list);
			return ResultMap.getResultMap();
		} catch (Exception e) {
			e.printStackTrace();
			ResultMap.putObj(false,null,e.getMessage());
			return ResultMap.getResultMap();
		}
	}
	
	
}
