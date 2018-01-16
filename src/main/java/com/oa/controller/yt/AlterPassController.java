package com.oa.controller.yt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oa.pojos.OaMenu;
import com.oa.service.zmy.MenuService;
/**
 * index页面控制器
 * @author Administrator
 *
 */
@Controller
public class AlterPassController {
	/**
	 * 修改密码界面
	 * @return
	 */
	@RequestMapping("/alterpass")
	public String toAlterPass(){
		return "alterPassword";
	}
	
	
}
