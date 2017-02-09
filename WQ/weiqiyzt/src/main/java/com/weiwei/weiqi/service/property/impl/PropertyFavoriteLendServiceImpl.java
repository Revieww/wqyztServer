package com.weiwei.weiqi.service.property.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.weiwei.common.constants.enums.ResultCodeEnum;
import com.weiwei.weiqi.jdbc.dao.property.PropertyFavoriteLendDao;
import com.weiwei.weiqi.jdbc.dao.property.PropertyLendDao;
import com.weiwei.weiqi.jdbc.dbmodel.property.PropertyFavoriteLend;
import com.weiwei.weiqi.request.property.FavoriteLendEnter;
import com.weiwei.weiqi.response.base.GeneralResult;
import com.weiwei.weiqi.service.base.BaseServiceImpl;
import com.weiwei.weiqi.service.property.api.PropertyFavoriteLendService;

@Component
public class PropertyFavoriteLendServiceImpl  extends BaseServiceImpl implements PropertyFavoriteLendService{
	
	@Autowired
	private PropertyFavoriteLendDao favoriteLendDao; 
	
	private PropertyLendDao lendDao;
	
	@Override
	public GeneralResult collect(FavoriteLendEnter favoriteLendEnter) {
		
		PropertyFavoriteLend myfavoritelend = getMyFavoriteLend(favoriteLendEnter.getId(),favoriteLendEnter.getUserId());
		//初次添加收藏
		if(myfavoritelend==null){
			myfavoritelend = new PropertyFavoriteLend();
			myfavoritelend.setCustomerId(favoriteLendEnter.getUserId());
			myfavoritelend.setPropertyLend(lendDao.getOne(favoriteLendEnter.getId()));
			favoriteLendDao.save(myfavoritelend);
		}else{
			favoriteLendDao.updateCacelled(!myfavoritelend.getIsCancelled());
		}
		return new GeneralResult(ResultCodeEnum.RESULT_SUCCESS);
	}

	private PropertyFavoriteLend getMyFavoriteLend(int lendId,int userId){
		List<PropertyFavoriteLend> myfavoritelends = favoriteLendDao.getByUserAndLend(lendId,userId);
		return myfavoritelends.size() > 0 ? myfavoritelends.get(0) : null;
	}
}
