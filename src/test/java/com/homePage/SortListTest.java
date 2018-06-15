package com.homePage;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.MetaOper;
import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;

public class SortListTest extends HttpUtil {
// 容器板块排序接口
	String url = "/uu-admin/container/sortList";
	List<Map> lis = new ArrayList<Map>();
	Map<Object, Object> map1 = new HashMap<Object, Object>();
	Map<Object, Object> map2 = new HashMap<Object, Object>();
	Map<Object, Object> map3 = new HashMap<Object, Object>();
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSortListTestCorrectParameter() throws Exception {
		map1.put("containerId", "6");
		map2.put("containerId", "4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("homePageParameterPojos", lis);
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
		map1.put("containerId", "6");
		map2.put("containerId", "4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495325);
		request.put("homePageParameterPojos", lis);		
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
		map1.put("containerId", "6");
		map2.put("containerId", "4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1111111);
		request.put("homePageParameterPojos", lis);
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
		map1.put("containerId", "6");
		map2.put("containerId", "4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "<$%^&>");
		request.put("homePageParameterPojos", lis);
		
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
		map1.put("containerId", "6");
		map2.put("containerId", "4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1.5);
		request.put("homePageParameterPojos", lis);
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
		map1.put("containerId", "6");
		map2.put("containerId", "4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", -12);
		request.put("homePageParameterPojos", lis);
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
		map1.put("containerId", "6");
		map2.put("containerId", "4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", " ");
		request.put("homePageParameterPojos", lis);
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
		map1.put("containerId", "6");
		map2.put("containerId", "4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "");
		request.put("homePageParameterPojos", lis);
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
		map1.put("containerId", "6");
		map2.put("containerId", "4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", null);
		request.put("homePageParameterPojos", lis);
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
		map1.put("containerId", "6");
		map2.put("containerId", "4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("homePageParameterPojos", lis);
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
		map1.put("containerId", "aa");
		map2.put("containerId", "4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("homePageParameterPojos", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器集合其中一个为字符" + post);
		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器集合其中一个为为空
	 */
	@Test
	public void postSortListTestContainerIdIsEmpty() throws Exception {
		map1.put("containerId", "");
		map2.put("containerId", "4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("homePageParameterPojos", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器集合其中一个为为空" + post);
		assertThat(post.get("status")).isEqualTo(500);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器集合其中一个为为空格
	 */
	@Test
	public void postSortListTestContainerIdIsSpace() throws Exception {
		map1.put("containerId", " ");
		map2.put("containerId", "4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("homePageParameterPojos", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器集合其中一个为为空格" + post);
		assertThat(post.get("status")).isEqualTo(500);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器集合其中一个为为小数
	 */
	@Test
	public void postSortListTestContainerIdIsDecimal() throws Exception {
		map1.put("containerId", "5.6");
		map2.put("containerId", "4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("homePageParameterPojos", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器集合其中一个为为小数" + post);
		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器集合其中一个为负数
	 */
	@Test
	public void postSortListTestContainerIdIsNegativeNumber() throws Exception {
		map1.put("containerId", "-6");
		map2.put("containerId", "4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("homePageParameterPojos", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器集合其中一个为负数" + post);
		assertThat(post.get("status")).isEqualTo(500);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器集合其中一个为0
	 */
	@Test
	public void postSortListTestContainerIdIsZero() throws Exception {
		map1.put("containerId", "0");
		map2.put("containerId", "4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("homePageParameterPojos", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器集合其中一个为0" + post);
		assertThat(post.get("status")).isEqualTo(500);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器集合其中一个为null
	 */
	@Test
	public void postSortListTestContainerIdIsNull() throws Exception {
		map1.put("containerId", null);
		map2.put("containerId", "4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("homePageParameterPojos", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器集合其中一个为null" + post);
		assertThat(post.get("status")).isEqualTo(500);
		//assertThat(post.get("msg")).isEqualTo("成功");
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
		assertThat(post.get("status")).isEqualTo(500);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 输入3个以上容器ID
	 */
	@Test
	public void postSortListTestContainerIdMoreThan3() throws Exception {
		map1.put("containerId", "6");
		map2.put("containerId", "4");
		map3.put("containerId", "4");
		lis.add(map1);
		lis.add(map2);
		lis.add(map3);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("homePageParameterPojos", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("输入3个以上容器ID" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	
	
	
}