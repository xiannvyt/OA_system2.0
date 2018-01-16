package com.oa.controller.zmy;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.pojos.OaEmp;
import com.oa.service.zmy.LoginService;
import com.oa.service.zmy.RoleService;
import com.oa.vo.ResultMap;
import com.xiaoleilu.hutool.captcha.CaptchaUtil;
import com.xiaoleilu.hutool.captcha.LineCaptcha;
import com.xiaoleilu.hutool.util.RandomUtil;

/**
 * index页面控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginService lService;
	@Autowired
	RoleService rService;
	/**
	 * 登录验证
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/valiator",method=RequestMethod.POST)
	
	public @ResponseBody HashMap<String,Object> toIndex(HttpServletRequest req){
		try{
			String userName=req.getParameter("username");
			String password=req.getParameter("password");
			String code=req.getParameter("code");
			Object attribute = req.getSession().getAttribute("code");
			HashMap<String, Object> map=new HashMap<>();
			if(code.equals(attribute)){
				OaEmp emp = lService.vaildatorLogin(userName, password);
				if(emp!=null){
					rService.getRoleMenusByEmp(emp.getEmpId());
					req.getSession().setAttribute("emp", emp);
					map.put("msg", "登录成功");
					map.put("result", true);
				}else{
					map.put("msg", "登录失败");
					map.put("result", false);
				}
			}else{
				map.put("msg", "验证码错误");
				map.put("result", false);
			}
			return map;
		}catch(Exception e){
			e.printStackTrace();
			ResultMap.putObj(false,null,e.getMessage());
			return ResultMap.getResultMap();
		}
	}
	/**
	 * 登出清除session
	 * @param req
	 * @return
	 */
	@RequestMapping("/logout")
	public String  logout(HttpServletRequest req){
		req.getSession().invalidate();
		return "redirect:/login";
	}	
	/**
	 * 生成验证码
	 * @param req
	 * @param resp
	 */
	@RequestMapping(params="code")
 	public void VerificationCode(HttpServletRequest req,HttpServletResponse resp){
		// 设置页面不缓存
		resp.setHeader("Pragma", "No-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);
		//创建生成验证码图片类
		LineCaptcha captcha = CaptchaUtil.createLineCaptcha(116, 36);
		//随机生成长度为5的字符串
		String code=RandomUtil.randomString(5);
		//将验证码存入session中
		req.getSession().setAttribute("code",code);
		captcha.createImage(code);
		try {
			ServletOutputStream outputStream = resp.getOutputStream();
			captcha.write(outputStream);
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
