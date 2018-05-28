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

public class GetTheHomePageAllPlateContainersTest extends HttpUtil {
// 获取首页所有板块容器接口
	String url = "/uu-admin/container/getHomePageContainer";


	/**
	 * 提交正确参数
	 */
	//@Test
	public void postGetTheHomePageAllPlateContainersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postGetTheHomePageAllPlateContainersTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1249532412);	
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为错误用户
	 */
	//@Test
	public void postGetTheHomePageAllPlateContainersTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12312313);	
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为非法字符
	 */
	//@Test
	public void postGetTheHomePageAllPlateContainersTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<$%^>");			
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为小数
	 */
	//@Test
	public void postGetTheHomePageAllPlateContainersTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 121123.33);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为负数
	 */
	//@Test
	public void postGetTheHomePageAllPlateContainersTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -121312);	
				
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为空格
	 */
	//@Test
	public void postGetTheHomePageAllPlateContainersTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");		
			
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为空
	 */
	//@Test
	public void postGetTheHomePageAllPlateContainersTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");	
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为null
	 */
	//@Test
	public void postGetTheHomePageAllPlateContainersTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);	
					
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为0
	 */
	//@Test
	public void postGetTheHomePageAllPlateContainersTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);	

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为String
	 */
	//@Test
	public void postGetTheHomePageAllPlateContainersTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "fsddf");	

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID不传该参数
	 */
	//@Test
	public void postGetTheHomePageAllPlateContainersTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();				
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为超长
	 */
	//@Test
	public void postGetTheHomePageAllPlateContainersTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 999999999999999999L);	
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	
	
}