package com.weiwei.weiqi.controller.patented;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weiwei.weiqi.annotation.AccessControl;
import com.weiwei.weiqi.request.base.MyPageRequest;
import com.weiwei.weiqi.request.login.LoginEnter;
import com.weiwei.weiqi.request.patented.ListEnter;
import com.weiwei.weiqi.response.base.GeneralResult;
import com.weiwei.weiqi.service.patented.api.AchievementTransformService;

@AccessControl(noSessionLogin = true)
@RestController
@RequestMapping("/achievementTransform")
public class AchievementTransformController {
	
	@Autowired
	private AchievementTransformService transformService;
	
	/**
	  * 
	  * @Title: list   
	  * @Description: 专利列表
	  * @param @param page	分页信息
	  * @param @param listEnter	参数信息
	  * @param @return   
	  * @return GeneralResult    
	  * @throws
	  */
	@RequestMapping(value = "/list")
	public GeneralResult list(MyPageRequest page,ListEnter listEnter){
		return transformService.list(page,listEnter);
	}
}	
