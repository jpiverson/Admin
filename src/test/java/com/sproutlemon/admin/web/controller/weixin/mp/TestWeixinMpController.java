package com.sproutlemon.admin.web.controller.weixin.mp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestWeixinMpController {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Value("${weixin.mp.accessTokenUrl}")
	String accessTokenUrl;

	@Test
	public void testAccessToken() throws Exception {

		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/weixin/mp/accessToken")
						.accept(org.springframework.http.MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();

		int status = mvcResult.getResponse().getStatus(); // 得到返回代码
		Assert.assertEquals(200, status); // 断言，判断返回代码是否正确
//		String content = mvcResult.getResponse().getContentAsString(); // 得到返回结果
//		Assert.assertEquals(accessTokenUrl, content);

	}

}
