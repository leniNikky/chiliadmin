package com.chili.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.chili.pojo.Goods;
import com.chili.service.GoodsService;
import com.chili.util.Upload;

/**
 * controller�� ע��controller
 *
 */
@Controller
public class UploadController {
	@Autowired
	private GoodsService goodsService;

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public ModelAndView upload() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("upload"); // ���ص��ļ���
		return mav;

	}

	@RequestMapping(value = "/formUpload")
	public ModelAndView formUpload(@RequestParam(required = false) MultipartFile pic, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String url = null;
		String path = request.getSession().getServletContext().getRealPath("/res/other");
		CommonsMultipartFile cf = (CommonsMultipartFile) pic;
		DiskFileItem fi = (DiskFileItem) cf.getFileItem();
		File f = fi.getStoreLocation();
		String filename = UUID.randomUUID().toString().replaceAll("-", "")
				+ pic.getOriginalFilename().substring(pic.getOriginalFilename().lastIndexOf('.'));
		try {
			url = Upload.uploader(f, path, filename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mav.addObject("url", url);
		mav.setViewName("addSuccess"); // ���ص��ļ���
		return mav;

	}

	@RequestMapping(value = "/ajaxUpload")
	public void ajaxUpload(@RequestParam(required = false) MultipartFile pic, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JSONObject jo = new JSONObject();
		String url = null;
		String path = request.getSession().getServletContext().getRealPath("/res/other");
		CommonsMultipartFile cf = (CommonsMultipartFile) pic;
		DiskFileItem fi = (DiskFileItem) cf.getFileItem();
		File f = fi.getStoreLocation();
		String filename = UUID.randomUUID().toString().replaceAll("-", "")
				+ pic.getOriginalFilename().substring(pic.getOriginalFilename().lastIndexOf('.'));
		if (pic.getSize() > 4000000) {
			jo.put("max", "ͼƬ�޷��ϴ�����ȷ����С��3MB���ڡ�");
		} else {
			url = Upload.uploader(f, path, filename);
			jo.put("url", url);
		}
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(jo.toString());

	}

	@RequestMapping(value = "/formUpload_1")
	public ModelAndView formUpload_1(Goods goods) {
		ModelAndView mav = new ModelAndView();
		Date time = new Date(System.currentTimeMillis());
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String current = sdf.format(time);
		goods.setTime(current.toString());
		System.out.println(goods.toString());
		goodsService.addGoods(goods);
		/*System.out.println(name);
		System.out.println(picUrl);
		System.out.println(pic1Url);
		System.out.println(goodsNo);
		System.out.println(goodsName);
		System.out.println(gclass);
		System.out.println(goodsPrice);
		System.out.println(goodsCount);
		System.out.println(goodsimg);
		System.out.println(pictext);
		System.out.println(gimg1);
		System.out.println(gimg2);
		System.out.println(gimg3);
		mav.addObject("url", goodsimg);*/
		mav.addObject("msg", "��ӳɹ���");
		mav.setViewName("msg"); // ���ص��ļ���
		return mav;

	}
	@RequestMapping(value = "/formUpload_2")
	public ModelAndView formUpload_2(Goods goods) {
		ModelAndView mav = new ModelAndView();
		Date time = new Date(System.currentTimeMillis());
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String current = sdf.format(time);
		goods.setTime(current.toString());
		System.out.println(goods.toString());
		goodsService.updateGoods(goods);
		/*System.out.println(name);
		System.out.println(picUrl);
		System.out.println(pic1Url);
		System.out.println(goodsNo);
		System.out.println(goodsName);
		System.out.println(gclass);
		System.out.println(goodsPrice);
		System.out.println(goodsCount);
		System.out.println(goodsimg);
		System.out.println(pictext);
		System.out.println(gimg1);
		System.out.println(gimg2);
		System.out.println(gimg3);
		mav.addObject("url", goodsimg);*/
		mav.addObject("msg", "�޸ĳɹ���");
		mav.setViewName("msg"); // ���ص��ļ���
		return mav;

	}

}
