package com.chili.dao;
import java.util.List;

import com.chili.pojo.Goods;

public interface GoodsDao {
	List<Goods> AllGoodsList();
	void DeleteGoods(int goodsID);
	List<Goods> findGoodsByName(String goodsName);
	void insertGoods(Goods goods);
	int countGoods();
	int countOrdersPrice();
	void addGoods(Goods goods);
	void updateGoods(Goods goods);
	Goods goodsDetail(int goodsID);
}
