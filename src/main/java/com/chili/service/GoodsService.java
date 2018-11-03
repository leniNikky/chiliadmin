package com.chili.service;

import java.util.List;

import com.chili.pojo.Goods;

public interface GoodsService {
	public List<Goods> AllGoodsList();
	public void DeleteGoods(int goodsID);
	public List<Goods> findGoodsByName(String goodsName);
	void insertGoods(Goods goods);
	public int countGoods();
	public void addGoods(Goods goods);
	public void updateGoods(Goods goods);
	public Goods goodsDetail(int goodsID);
}
