package com.oa.controller.yt;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oa.pojos.OaMenu;
import com.oa.service.yt.QuXiangService;
import com.oa.service.zmy.MenuService;
/**
 * index页面控制器
 * @author Administrator
 *
 */
@Controller
public class QuXiangController {
	@Autowired
	QuXiangService  qService;
	/**
	 * 修改密码界面
	 * @return
	 */
	@RequestMapping("/to_quxiang")
	public String toQuXiang(){
		return "quXiang";
	}
	@RequestMapping("/to_quxiangadd")
	public String toQuXiangAdd(){
		return "quXiangAdd";
	}
	
	@RequestMapping("/to_myqx")
	public @ResponseBody Map<String, Object> toMyQx(int page,int limit){
			Map<String, Object> table = qService.getQuXiangInfo(page,limit, "emp2018001");
			return table;
		}
	}
	

