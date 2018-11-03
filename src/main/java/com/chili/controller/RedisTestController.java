package com.chili.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.chili.pojo.Goods;
import com.chili.pojo.User;
import com.chili.service.GoodsService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * controller�� ע��controller
 *
 */
@Controller
public class RedisTestController {
	@Autowired
	private JedisPool pool;

	private Integer exp = 30;

	@RequestMapping(value = "/addRedis")
	public ModelAndView addRedis() {
		ModelAndView mav = new ModelAndView();
		Jedis jedis = null;
		try {
			jedis = pool.getResource(); 
			jedis.set("chili" + ":", UUID.randomUUID().toString());
			mav.setViewName("addSuccess"); 

			return mav;

			
			// jedis.expire(key + ":" + Constants.ADMIN_SESSION, 60 * exp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null) {
				
				jedis.close();
			}
		}
		mav.setViewName("addFailed"); 
		return mav;

	}
	
	@RequestMapping(value = "/getRedis")
	public ModelAndView getRedis() {
		ModelAndView mav = new ModelAndView();
		Jedis jedis = null;
		try {
			jedis = pool.getResource(); 
			String username = jedis.get("chili" + ":");
			if (null != username) {
				
				System.out.println(username);
				mav.setViewName("addSuccess"); 

				return mav;
			}
			mav.setViewName("addSuccess"); 

			return mav;

			
			// jedis.expire(key + ":" + Constants.ADMIN_SESSION, 60 * exp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null) {
				
				jedis.close();
			}
		}
		mav.setViewName("addFailed"); 
		return mav;

	}
}
