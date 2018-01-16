package com.oa.service.yt;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;




@Service
public class RiChengService {
	//需要年月 日历点击时会有年月选择
	public void spellHTML() {
		//首先 通过参数年月循环 调用spellRiCheng 把拼出来的字符串 存在对象中，然后把对象保存在集合中
		//得到这个月有几天
		Calendar   cal   =   Calendar.getInstance(); 
		  cal.set(Calendar.YEAR,2002);   
		  cal.set(Calendar.MONTH,6);//7月   
		  int   maxDate   =   cal.getActualMaximum(Calendar.DATE);
		//得到今天是星期几
		 Calendar calendar = Calendar.getInstance(); 
		 calendar.setTime(new Date());    
		 int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;  
		 //调用spellricheng后记得封装到week对象中
	}
//参数需要日期
public String spellRiCheng() {
	//从DAO层查询该天的日程信息 
	//通过得到的日程信息集合循环 生成html
	//需要今天是星期几，日程内容
	String ret="<div style='width:100%;height:100%;'>"
			+ "<span style='position:relative;left:76px;bottom:25px;'>1</span>"
			+ "<span>8:00-17:00 开会</span>"
			+ "<div>";
	return ret;
	}

}
