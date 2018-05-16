package com.homePage;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;

public class SortListTest extends HttpUtil {
// 容器板块排序接口
	String url = "/uu-admin/container/sortList";


	/**
	 * 提交正确参数
	 */
	@Test
	public void postSortListTestCorrectParameter() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("homePageParameterPojos[0].containerId", 1);
		request.put("homePageParameterPojos[1].containerId", 2);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postSortListTestUserIdNotLoggedIn() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495325);
		request.put("homePageParameterPojos[0].containerId", 1);
		request.put("homePageParameterPojos[1].containerId", 2);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postSortListTestUserIdIsError() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1111111);
		request.put("homePageParameterPojos[0].containerId", 1);
		request.put("homePageParameterPojos[1].containerId", 2);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postSortListTestUserIdIllegalCharacters() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "<$%^&>");
		request.put("homePageParameterPojos[0].containerId", 1);
		request.put("homePageParameterPojos[1].containerId", 2);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("Could not read document: Can not deserialize value of type java.lang.Long from String \"<$%^&>\": not a valid Long value\n at [Source: java.io.PushbackInputStream@4687d592; line: 1, column: 53] (through reference chain: com.uns.uu.pojo.HomePageParameterPojo[\"userId\"]); nested exception is com.fasterxml.jackson.databind.exc.InvalidFormatException: Can not deserialize value of type java.lang.Long from String \"<$%^&>\": not a valid Long value\n at [Source: java.io.PushbackInputStream@4687d592; line: 1, column: 53] (through reference chain: com.uns.uu.pojo.HomePageParameterPojo[\"userId\"])");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postSortListTestUserIdIsDecimal() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1.5);
		request.put("homePageParameterPojos[0].containerId", 1);
		request.put("homePageParameterPojos[1].containerId", 2);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postSortListTestUserIdIsNegativeNumber() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", -12);
		request.put("homePageParameterPojos[0].containerId", 1);
		request.put("homePageParameterPojos[1].containerId", 2);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postSortListTestUserIdIsSpace() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", " ");
		request.put("homePageParameterPojos[0].containerId", 1);
		request.put("homePageParameterPojos[1].containerId", 2);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postSortListTestUserIdIsEmpty() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "");
		request.put("homePageParameterPojos[0].containerId", 1);
		request.put("homePageParameterPojos[1].containerId", 2);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postSortListTestUserIdIsNull() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", null);
		request.put("homePageParameterPojos[0].containerId", 1);
		request.put("homePageParameterPojos[1].containerId", 2);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postSortListTestUserIdNonSubmissionParameters() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("homePageParameterPojos[0].containerId", 1);
		request.put("homePageParameterPojos[1].containerId", 2);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器集合其中一个为字符
	 */
	@Test
	public void postSortListTestContainerIdIsString() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("homePageParameterPojos[0].containerId", "aa");
		request.put("homePageParameterPojos[1].containerId", 2);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器集合其中一个为字符" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器集合其中一个为为空
	 */
	@Test
	public void postSortListTestContainerIdIsEmpty() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("homePageParameterPojos[0].containerId", "");
		request.put("homePageParameterPojos[1].containerId", 2);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器集合其中一个为为空" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器集合其中一个为为空格
	 */
	@Test
	public void postSortListTestContainerIdIsSpace() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("homePageParameterPojos[0].containerId", " ");
		request.put("homePageParameterPojos[1].containerId", 2);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器集合其中一个为为空格" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器集合其中一个为为小数
	 */
	@Test
	public void postSortListTestContainerIdIsDecimal() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("homePageParameterPojos[0].containerId", 1);
		request.put("homePageParameterPojos[1].containerId", 2.5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器集合其中一个为为小数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器集合其中一个为负数
	 */
	@Test
	public void postSortListTestContainerIdIsNegativeNumber() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("homePageParameterPojos[0].containerId", 1);
		request.put("homePageParameterPojos[1].containerId", -2);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器集合其中一个为负数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器集合其中一个为0
	 */
	@Test
	public void postSortListTestContainerIdIsZero() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("homePageParameterPojos[0].containerId", 0);
		request.put("homePageParameterPojos[1].containerId", 2);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器集合其中一个为0" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器集合其中一个为null
	 */
	@Test
	public void postSortListTestContainerIdIsNull() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("homePageParameterPojos[0].containerId", null);
		request.put("homePageParameterPojos[1].containerId", 2);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器集合其中一个为null" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器集合不传该参数
	 */
	@Test
	public void postSortListTestContainerIdNonSubmissionParameters() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器集合不传该参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 输入3个以上容器ID
	 */
	@Test
	public void postSortListTestContainerIdMoreThan3() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("homePageParameterPojos[0].containerId", 1);
		request.put("homePageParameterPojos[1].containerId", 2);
		request.put("homePageParameterPojos[2].containerId", 3);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("输入3个以上容器ID" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	
	
	
}