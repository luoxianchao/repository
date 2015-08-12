package com.github.flux.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.flux.entity.User;
import com.github.flux.service.UserService;
import com.github.flux.util.result.MapResult;

@Controller
@RequestMapping("/rest/user/")
public class UserController extends BaseController {
	
	@Resource
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("save")
	public Map<String, Object> save(HttpServletRequest req,
			@RequestParam(value = "mobile", required = true) String mobile) {
		try {
	        User user = new User();
	        user.setAccount(10l);
	        user.setAddSum(10l);
	        user.setCreateTime(System.currentTimeMillis());
	        user.setGender(1);
	        user.setIndustry("inde");
	        user.setLogo("http://aa.jpg");
	        user.setMobile(mobile);
	        user.setNickname("xiaozhang");
	        user.setSignature("fff");
	        user.setSubSum(12l);
	        user.setYear(201508);
	        
	        
	        userService.add(user);
			return MapResult.successMap();
		} catch (Exception ex) {
			return MapResult.failMap();
		}
	}

}
