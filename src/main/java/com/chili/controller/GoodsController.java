package com.chili.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.chili.pojo.Goods;
import com.chili.pojo.User;
import com.chili.service.GoodsService;

/**
 * controller�� ע��controller
 *
 */
@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;

	// ��Ʒ�б�
	@RequestMapping(value = "/AllGoodsList")
	public ModelAndView AllGoodsList() {
		ModelAndView mav = new ModelAndView();
		List<Goods> goods = goodsService.AllGoodsList();
		mav.addObject("goods", goods);
		mav.setViewName("product_list"); // ���ص��ļ���
		return mav;

	}

	// ɾ����Ʒ
	@RequestMapping(value = "/DeleteGoods")
	public ModelAndView DeleteGoods(int goodsID) {
		ModelAndView mav = new ModelAndView();
		goodsService.DeleteGoods(goodsID);
		mav.addObject("msg", "ɾ���ɹ�");
		mav.setViewName("msg"); // ���ص��ļ���
		return mav;

	}
	
	// �鿴��ƷԔ��
		@RequestMapping(value = "/goodsDetail")
		public ModelAndView goodsDetail(int goodsID) {
			ModelAndView mav = new ModelAndView();
			Goods goods = goodsService.goodsDetail(goodsID);
			mav.addObject("goods", goods);
			mav.setViewName("edit_product"); // ���ص��ļ���
			return mav;

		}

	// ������Ʒ��������Ʒ
	@RequestMapping(value = "/findGoodsByName", method = RequestMethod.GET)
	public ModelAndView findGoodsByName() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error"); // ���ص��ļ���
		return mav;

	}

	@RequestMapping(value = "/findGoodsByName", method = RequestMethod.POST)
	public ModelAndView findGoodsByName(String goodsName) {
		ModelAndView mav = new ModelAndView();

		try {
			List<Goods> goods = goodsService.findGoodsByName(goodsName);
			System.out.println(goods);
			mav.addObject("goods", goods);
			mav.setViewName("product_list"); // ���ص��ļ���
			return mav;

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("msg", "����ʧ�ܣ�");
			mav.setViewName("msg"); // ���ص��ļ���
			return mav;
		}

	}

	@RequestMapping(value = "/addGoods", method = RequestMethod.POST)
	public ModelAndView addGoods(Goods goods) {
		ModelAndView mav = new ModelAndView();

		try {
			goodsService.insertGoods(goods);
			mav.addObject("goods", goods);
			return mav;

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("msg", "����ʧ�ܣ�");
			mav.setViewName("msg"); // ���ص��ļ���
			return mav;
		}

	}
}
