package com.chili.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chili.dao.GoodsDao;
import com.chili.pojo.Goods;
import com.chili.service.GoodsService;
/**
 * Service实现类 注解service和transactional事务开启
 *
 */
@Service("GoodsService")
@Transactional
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDao goodsDao;
	public List<Goods> AllGoodsList() {
		List<Goods> goods = goodsDao.AllGoodsList();
		return goods;
	}
	
	public void DeleteGoods(int goodsID) {
		goodsDao.DeleteGoods(goodsID);
	}
	
	public List<Goods> findGoodsByName(String goodsName){
		List<Goods> goods = goodsDao.findGoodsByName(goodsName);
		return goods;
	}

	public void insertGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsDao.insertGoods(goods);
	}
	public int countGoods() {
		int a = goodsDao.countGoods();
		return a;
	}
	public void addGoods(Goods goods) {
		goodsDao.addGoods(goods);
	}
	public void updateGoods(Goods goods) {
		goodsDao.updateGoods(goods);
	}
	public Goods goodsDetail(int goodsID) {
		Goods goods = goodsDao.goodsDetail(goodsID);
		return goods;
	}
}
