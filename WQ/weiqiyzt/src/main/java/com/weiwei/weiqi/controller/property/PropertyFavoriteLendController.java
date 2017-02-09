package com.weiwei.weiqi.controller.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weiwei.weiqi.request.base.BaseEnter;
import com.weiwei.weiqi.request.property.FavoriteLendEnter;
import com.weiwei.weiqi.request.property.LendSaveEnter;
import com.weiwei.weiqi.response.base.GeneralResult;
import com.weiwei.weiqi.service.property.api.PropertyFavoriteLendService;

@RestController
@RequestMapping("/favorite/lend")
public class PropertyFavoriteLendController {
	
	@Autowired
	private PropertyFavoriteLendService favoriteLendService;
	
	/**
	 * 
	 * @Title: collect   
	 * @Description: 添加或者取消收藏出租
	 * @param @param favoriteLendEnter
	 * @param @return    设定文件   
	 * @return GeneralResult    返回类型   
	 * @throws 
	 * @version V1.0
	 */
	@GetMapping("/collect")
	public GeneralResult collect(FavoriteLendEnter favoriteLendEnter){
		return favoriteLendService.collect(favoriteLendEnter);
	}
	 
	
}
