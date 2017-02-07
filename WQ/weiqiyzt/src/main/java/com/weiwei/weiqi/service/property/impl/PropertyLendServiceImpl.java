package com.weiwei.weiqi.service.property.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.weiwei.common.constants.enums.ResultCodeEnum;
import com.weiwei.weiqi.jdbc.dao.property.PropertyLendDao;
import com.weiwei.weiqi.jdbc.dbmodel.patented.AchievementTransform;
import com.weiwei.weiqi.jdbc.dbmodel.property.PropertyLend;
import com.weiwei.weiqi.request.base.BaseEnter;
import com.weiwei.weiqi.request.base.MyPageRequest;
import com.weiwei.weiqi.request.property.LendDetailEnter;
import com.weiwei.weiqi.request.property.LendListEnter;
import com.weiwei.weiqi.request.property.LendSaveEnter;
import com.weiwei.weiqi.response.base.DataResult;
import com.weiwei.weiqi.response.base.GeneralResult;
import com.weiwei.weiqi.response.base.PageData;
import com.weiwei.weiqi.response.patented.AchievementTransformResult;
import com.weiwei.weiqi.response.property.LendDetailResult;
import com.weiwei.weiqi.response.property.LendlistResult;
import com.weiwei.weiqi.service.base.BaseServiceImpl;
import com.weiwei.weiqi.service.property.api.PropertyLendService;

@Component
public class PropertyLendServiceImpl extends BaseServiceImpl implements PropertyLendService {
	
	@Autowired
	private PropertyLendDao propertyLendDao;

	@Override
	public GeneralResult save(LendSaveEnter saveEnter, BaseEnter baseEnter) {
		PropertyLend propertyLend = new PropertyLend();
		BeanUtils.copyProperties(saveEnter, propertyLend);
		propertyLendDao.save(propertyLend);
		return new GeneralResult(ResultCodeEnum.RESULT_SUCCESS);
	}

	@Override
	public GeneralResult list(MyPageRequest myPageRequest, LendListEnter listEnter) {
		Map<String, String[]> params = new HashMap<String, String[]>();
		Specification<PropertyLend> spec = spec(params, PropertyLend.class);
		Pageable pageable = getPageable(myPageRequest);
		Page<PropertyLend> page = propertyLendDao.findAll(spec, pageable);
		List<LendlistResult> results = new ArrayList<LendlistResult>();
		for (PropertyLend lend : page.getContent()) {
			LendlistResult result = new LendlistResult();
			BeanUtils.copyProperties(lend, result);
			results.add(result);
		}
		PageData<LendlistResult> pdata = new PageData<LendlistResult>(page.getTotalPages(), page.getTotalElements(), results);
		return new DataResult<PageData<LendlistResult>>(ResultCodeEnum.RESULT_SUCCESS, pdata);
	}

	@Override
	public GeneralResult detail(LendDetailEnter detailEnter) {
		PropertyLend propertyLend = propertyLendDao.getOne(detailEnter.getId());
		LendDetailResult result = new LendDetailResult();
		BeanUtils.copyProperties(propertyLend, result);
		
		//TODO 缺少轮播图片
		return new DataResult<LendDetailResult>(ResultCodeEnum.RESULT_SUCCESS,result);
	}
}
