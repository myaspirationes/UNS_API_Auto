package com.homePage;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;

public class ObtainPlateParametersTest extends HttpUtil {
// 获取板块参数接口
	String url = "/uu-admin/container/getContainerParam";


	/**
	 * 提交正确参数
	 */
	@Test
	public void postObtainPlateParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "12495324");
						
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postObtainPlateParametersTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495321);		
			
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postObtainPlateParametersTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 123123131);
						
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postObtainPlateParametersTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<$%^>");									
			    						
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postObtainPlateParametersTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 121123.33);		
		
			
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
		
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postObtainPlateParametersTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -121312);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postObtainPlateParametersTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");		
		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postObtainPlateParametersTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");		
		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postObtainPlateParametersTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);		
				
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postObtainPlateParametersTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);
	
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postObtainPlateParametersTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();	
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	
	
}