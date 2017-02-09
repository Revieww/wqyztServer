package com.weiwei.weiqi.jdbc.dao.property;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.weiwei.weiqi.jdbc.dao.base.BaseJpaRepository;
import com.weiwei.weiqi.jdbc.dbmodel.property.PropertyFavoriteLend;

public interface PropertyFavoriteLendDao extends  BaseJpaRepository<PropertyFavoriteLend, Integer>{

	@Query("from PropertyFavoriteLend p where p.propertyLend.id = ?1 and p.customerId = ?2")
	List<PropertyFavoriteLend> getByUserAndLend(Integer lendId, int userId);

	@Query("update PropertyFavoriteLend p set p.isCancelled = ?1")
	void updateCacelled(boolean b);

}
