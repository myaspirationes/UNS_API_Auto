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

public class JoinHomePageTest extends HttpUtil {
// 加入首页接口
	String url = "/uu-admin/container/containerInfo";


	/**
	 * 提交正确参数
	 */
	//@Test
	public void postJoinHomePageTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("type", 2);
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为未登录用户
	 */
	////@Test
	public void postJoinHomePageTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1249532423);				
		request.put("type", 2);
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为错误用户
	 */
	////@Test
	public void postJoinHomePageTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1249532466);				
		request.put("type", 2);
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为非法字符
	 */
	////@Test
	public void postJoinHomePageTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<@$%&*>");				
		request.put("type", 2);
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为小数
	 */
	////@Test
	public void postJoinHomePageTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -12.3);				
		request.put("type", 2);
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为负数
	 */
	////@Test
	public void postJoinHomePageTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -121312);				
		request.put("type", 2);
		request.put("containerId", 1);
				
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为空格
	 */
	////@Test
	public void postJoinHomePageTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");					
		request.put("type", 2);
		request.put("containerId", 1);
			
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为空
	 */
	////@Test
	public void postJoinHomePageTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");				
		request.put("type", 2);
		request.put("containerId", 1);
		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为null
	 */
	////@Test
	public void postJoinHomePageTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);		
		request.put("type", 2);
		request.put("containerId", 1);
					
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为0
	 */
	////@Test
	public void postJoinHomePageTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);			
		request.put("type", 2);
		request.put("containerId", 1);
		

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为String
	 */
	////@Test
	public void postJoinHomePageTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "dfdsf");			
		request.put("type", 2);
		request.put("containerId", 1);
		

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为超长
	 */
	////@Test
	public void postJoinHomePageTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "1111111111111111111111111");			
		request.put("type", 2);
		request.put("containerId", 1);
		

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID不传该参数
	 */
	////@Test
	public void postJoinHomePageTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("type", 2);
		request.put("containerId", 1);
		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 类型type为错误
	 */
	//@Test
	public void postJoinHomePageTestType() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("type", 88);
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型type为错误" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型type为超长
	 */
	//@Test
	public void postJoinHomePageTestTypeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("type", "2222222222222222222222222222222222222222");
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型type为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型type为String
	 */
	//@Test
	public void postJoinHomePageTestTypeIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("type", "ddddd");
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型type为String" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型type为非法字符
	 */
	//@Test
	public void postJoinHomePageTestTypeIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("type", "<@$^&>");
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型type为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型type为空
	 */
	//@Test
	public void postJoinHomePageTestTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("type", "");
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型type为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型type为空格
	 */
	//@Test
	public void postJoinHomePageTestTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("type", " ");
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型type为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型type为0
	 */
	//@Test
	public void postJoinHomePageTestTypeIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("type", 0);
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型type为0" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型type为负数
	 */
	//@Test
	public void postJoinHomePageTestTypeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("type", -2);
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型type为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型type为小数
	 */
	//@Test
	public void postJoinHomePageTestTypeIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("type", 2.36);
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型type为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型type为null
	 */
	//@Test
	public void postJoinHomePageTestTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("type", null);
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型type为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型type为1用户
	 */
	//@Test
	public void postJoinHomePageTestTypeIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("type", 1);
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型type为1用户" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型type为2商铺
	 */
	//@Test
	public void postJoinHomePageTestTypeIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("type", 2);
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型type为2商铺" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型type为3商品
	 */
	//@Test
	public void postJoinHomePageTesttypeIs3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("type", 3);
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型type为3商品" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型type不传该参数
	 */
	//@Test
	public void postJoinHomePageTesttypeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型type不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器ID为错误
	 */
	//@Test
	public void postJoinHomePageTestContainerIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("type", 2);
		request.put("containerId", 88);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID为错误" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器ID超长
	 */
	//@Test
	public void postJoinHomePageTestContainerIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("type", 2);
		request.put("containerId", "88111111111111111111111111111111111");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID超长" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器ID为空
	 */
	//@Test
	public void postJoinHomePageTestContainerIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("type", 2);
		request.put("containerId", "");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器ID存在非法字符
	 */
	//@Test
	public void postJoinHomePageTestContainerIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("type", 2);
		request.put("containerId", "<@&&>");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID存在非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器ID为小数
	 */
	//@Test
	public void postJoinHomePageTestContainerIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("type", 2);
		request.put("containerId", 1.22);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器ID为负数
	 */
	//@Test
	public void postJoinHomePageTestContainerIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("type", 2);
		request.put("containerId", -123);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器ID为空格
	 */
	//@Test
	public void postJoinHomePageTestContainerIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("type", 2);
		request.put("containerId", " ");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器ID为null
	 */
	//@Test
	public void postJoinHomePageTestContainerIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("type", 2);
		request.put("containerId", null);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器ID为String
	 */
	//@Test
	public void postJoinHomePageTestContainerIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("type", 2);
		request.put("containerId", "ddddddd");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID为String" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器ID不传该参数
	 */
	//@Test
	public void postJoinHomePageTestContainerIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("type", 2);
		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
}