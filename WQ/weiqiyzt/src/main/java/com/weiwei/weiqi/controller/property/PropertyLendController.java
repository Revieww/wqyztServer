package com.weiwei.weiqi.controller.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weiwei.weiqi.annotation.AccessControl;
import com.weiwei.weiqi.request.base.BaseEnter;
import com.weiwei.weiqi.request.base.MyPageRequest;
import com.weiwei.weiqi.request.patented.ListEnter;
import com.weiwei.weiqi.request.property.LendDetailEnter;
import com.weiwei.weiqi.request.property.LendListEnter;
import com.weiwei.weiqi.request.property.LendSaveEnter;
import com.weiwei.weiqi.response.base.GeneralResult;
import com.weiwei.weiqi.service.property.api.PropertyLendService;

@AccessControl(noSessionLogin = true)
@RestController
@RequestMapping("/property/lend")
public class PropertyLendController {

	@Autowired
	private PropertyLendService propertyLendService;
	
	
	@PostMapping("/save")
	public GeneralResult save(@RequestBody LendSaveEnter saveEnter,BaseEnter baseEnter){
		return propertyLendService.save(saveEnter,baseEnter);
	}
	
	@GetMapping("/list")
	public GeneralResult list(MyPageRequest request,LendListEnter listEnter){
		return propertyLendService.list(request,listEnter);
	}
	
	@GetMapping("/detail")
	public GeneralResult detail(LendDetailEnter detailEnter){
		return propertyLendService.detail(detailEnter);
	}
}
