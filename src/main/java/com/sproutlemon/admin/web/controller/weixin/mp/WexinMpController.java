package com.sproutlemon.admin.web.controller.weixin.mp;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sproutlemon.admin.web.controller.AdminController;

@RestController
@RequestMapping("/weixin/mp")
public class WexinMpController extends AdminController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	@Value("${weixin.mp.appId}")
	String appId;

	@Value("${weixin.mp.accessTokenUrl}")
	String accessTokenUrl;

	@RequestMapping("/checkSignature")
	public String checkSignature(String signature, String timestamp, String nonce, String echostr) throws Exception {
		logger.info("收到微信服务器发来了验证消息");
		logger.info("signature:::" + signature);
		logger.info("timestamp:::" + timestamp);
		logger.info("nonce:::" + nonce);
		logger.info("echostr:::" + echostr);
		return echostr;
	}

	@RequestMapping("/accessToken")
	public String accessToken() throws Exception {
		String key = "accessToken_" + appId;
		logger.info("key:::" + key);
		boolean hasKey = redisTemplate.hasKey(key);
		logger.info("hasKey:::" + hasKey);
		if (hasKey) {
			String accessToken = (String) redisTemplate.opsForValue().get(key);
			long expires = redisTemplate.getExpire(key, TimeUnit.SECONDS);
			return "accessToken:::" + accessToken + ", exoires:::" + expires;
		}
		String resString = restTemplate.getForObject(accessTokenUrl, String.class);
		JSONObject resMap = JSON.parseObject(resString);
		String accessToken = resMap.getString("access_token");
		long expires = resMap.getLongValue("expires_in");
		redisTemplate.opsForValue().set(key, accessToken);
		redisTemplate.expire(key, expires - 60, TimeUnit.SECONDS);
		return "accessToken:::" + accessToken + ", exoires:::" + (expires - 60);
	}

}
