package com.weiwei.weiqi.controller.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weiwei.weiqi.request.property.FavoriteLendEnter;
import com.weiwei.weiqi.response.base.GeneralResult;
import com.weiwei.weiqi.service.property.api.PropertyFavoriteSellService;

@RestController
@RequestMapping("/favorite/sell")
public class PropertyFavoriteSellController {
	
	@Autowired
	private PropertyFavoriteSellService favoriteSellService;
	
	/**
	 * 
	 * @Title: collect   
	 * @Description: 添加或者取消收藏出售
	 * @param @param favoriteLendEnter
	 * @param @return    设定文件   
	 * @return GeneralResult    返回类型   
	 * @throws 
	 * @version V1.0
	 */
	@GetMapping("/collect")
	public GeneralResult collect(FavoriteLendEnter favoriteLendEnter){
		return favoriteSellService.collect(favoriteLendEnter);
	}
	 
	
}
