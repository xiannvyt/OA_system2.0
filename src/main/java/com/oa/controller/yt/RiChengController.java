package com.oa.controller.yt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oa.pojos.OaMenu;
import com.oa.service.zmy.MenuService;
import com.oa.vo.yt.Week;
/**
 * index页面控制器
 * @author Administrator
 *
 */
@Controller
public class RiChengController {
	/**
	 * 日程界面
	 * @return
	 */
	@RequestMapping("/richeng")
	public String richeng(){
		return "riCheng";
	}
	
	@RequestMapping("/getRiCheng")
	public void getRiCheng(String time){
		System.out.println("asadasa");
		System.out.println(time);
	}
	@RequestMapping("/test")
	@ResponseBody
	public Map<String, Object> test(){
		Week week=new Week("<div style='border:1px solid red;width:100%;height:100%;'><span style='border:1px solid black;position:relative;left:76px;bottom:25px;'>1</span><span>8:00-17:00 开会</span><div>","1a","1b","1c","1d","1e","1f");
		Week week2=new Week("2","2a","2b","2c","2d","2e","2f");
		Week week3=new Week("3","3a","3b","3c","3d","3e","3f");
		Week week4=new Week("4","4a","4b","4c","4d","4e","4f");
		List<Week> data=new ArrayList<>();
		data.add(week);
		data.add(week2);
		data.add(week3);
		data.add(week4);
		Map<String, Object> map=new HashMap<>();
		map.put("data", data);
		map.put("count", data.size());
		map.put("code", 0);
		return map;
	}
	
	
}
