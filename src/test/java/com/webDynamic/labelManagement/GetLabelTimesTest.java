package com.webDynamic.labelManagement;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;
//import com.example.LoginTest;

public class GetLabelTimesTest extends HttpUtil {
	// 获取年代列表接口
	String url = "/uu-admin/labelManage/getLabelSetting";
	String userid;
	@BeforeClass
	public void  beforeClass(){
		userid = new BackUserLoginTest().userId;
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetLabelTimesTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);

		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作用户ID为未登录
	 */
	@Test
	public void postGetLabelTimesTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495079);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为未登录" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID为错误用户
	 */
	@Test
	public void postGetLabelTimesTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1111111111);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为错误用户" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数异常");
	}
	/**
	 * 操作用户ID为非法字符
	 */
	@Test
	public void postGetLabelTimesTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "<.!@#!@#>");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 操作用户ID为小数
	 */
	@Test
	public void postGetLabelTimesTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1.5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID为负数
	 */
	@Test
	public void postGetLabelTimesTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", -9);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数异常");
	}
	/**
	 * 操作用户ID为空格
	 */
	@Test
	public void postGetLabelTimesTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg").toString()).isEqualTo("null");
	}
	/**
	 * 操作用户ID为null
	 */
	@Test
	public void postGetLabelTimesTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", null);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg").toString()).isEqualTo("null");
	}
	/**
	 * 操作用户ID为超长
	 */
	@Test
	public void postGetLabelTimesTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "112121212121212121212");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 操作用户ID为String
	 */
	@Test
	public void postGetLabelTimesTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "userId");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 操作用户ID为0
	 */
	@Test
	public void postGetLabelTimesTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID为空
	 */
	@Test
	public void postGetLabelTimesTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg").toString()).isEqualTo("null");
	}
	/**
	 * 操作用户ID不传该参数
	 */
	@Test
	public void postGetLabelTimesTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg").toString()).isEqualTo("null");
	}


}
