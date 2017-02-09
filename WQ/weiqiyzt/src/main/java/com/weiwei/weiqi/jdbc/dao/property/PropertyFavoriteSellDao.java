package com.weiwei.weiqi.jdbc.dao.property;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.weiwei.weiqi.jdbc.dao.base.BaseJpaRepository;
import com.weiwei.weiqi.jdbc.dbmodel.property.PropertyFavoriteSell;

public interface PropertyFavoriteSellDao extends  BaseJpaRepository<PropertyFavoriteSell, Integer>{

	@Query("from PropertyFavoriteSell p where p.propertySell.id = ?1 and p.customerId = ?2")
	List<PropertyFavoriteSell> getByUserAndLend(int lendId, int userId);

	@Query("update PropertyFavoriteSell p set p.isCancelled = ?1")
	void updateCacelled(boolean b);

}
