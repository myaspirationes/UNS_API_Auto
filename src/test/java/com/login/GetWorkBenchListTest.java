package com.login;

import com.example.HttpUtil;
import com.example.MetaOper;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GetWorkBenchListTest extends HttpUtil {
	// 获取待处理工作列表接口
	String url = "/uu-admin/workBench/workBenchList";

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetWorkBenchListTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "12495324");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * 用户ID为未登录的运营后台用户
	 */
	@Test
	public void postGetWorkBenchListTestBackUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "12495324123");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录的运营后台用户" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}

	/**
	 * 用户ID非运营后台用户
	 */
	@Test
	public void postGetWorkBenchListTestUserIdIsNotBack() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "12312312345");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID非运营后台用户" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postGetWorkBenchListTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "12312312345");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	

	/**
	 * 用户ID为非法字符
	 */
//	@Test
	public void postGetWorkBenchListTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<$%^>");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
		// assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}

	/**
	 * 用户ID为小数
	 */
//	@Test
	public void postGetWorkBenchListTestUserIdIsDecimal() throws Exception {
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
//	@Test
	public void postGetWorkBenchListTestUserIdIsNegativeNumber() throws Exception {
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
//	@Test
	public void postGetWorkBenchListTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("缺少参数:userId");
	}

	/**
	 * 用户ID为空
	 */
//	@Test
	public void postGetWorkBenchListTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("缺少参数:userId");
	}

	/**
	 * 用户ID为null
	 */
//	@Test
	public void postGetWorkBenchListTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("缺少参数:userId");
	}

	/**
	 * 用户ID为0
	 */
//	@Test
	public void postGetWorkBenchListTestUserIdIsZero() throws Exception {
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
//	@Test
	public void postGetWorkBenchListTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("缺少参数:userId");
	}

}