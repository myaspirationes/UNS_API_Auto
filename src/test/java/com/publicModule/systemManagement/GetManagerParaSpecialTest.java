package com.publicModule.systemManagement;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class GetManagerParaSpecialTest extends HttpUtil {
// 获取参数配置详情接口
	String url = "/uu-admin/SystemManager/getManagerParaSpecial";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetManagerParaSpecialTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 10000000);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postGetManagerParaSpecialTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 10000000);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为错误
	 */
	@Test
	public void postGetManagerParaSpecialTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 10);
		request.put("paraId", 10000000);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不存在数据库中");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postGetManagerParaSpecialTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<.@#$%>");
		request.put("paraId", 10000000);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postGetManagerParaSpecialTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 123.123);
		request.put("paraId", 10000000);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postGetManagerParaSpecialTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -345);
		request.put("paraId", 10000000);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不存在数据库中");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postGetManagerParaSpecialTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);
		request.put("paraId", 10000000);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不存在数据库中");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postGetManagerParaSpecialTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "userId");
		request.put("paraId", 10000000);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postGetManagerParaSpecialTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("paraId", 10000000);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postGetManagerParaSpecialTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("paraId", 10000000);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postGetManagerParaSpecialTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("paraId", 10000000);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postGetManagerParaSpecialTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("paraId", 10000000);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 参数ID传错误
	 */
	@Test
	public void postGetManagerParaSpecialTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 999);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数ID传错误" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 参数id传负数
	 */
	@Test
	public void postGetManagerParaSpecialTestParaIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", -2);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id传负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id或者参数id格式是不正确的");
	}
	/**
	 * 参数id传小数
	 */
	@Test
	public void postGetManagerParaSpecialTestParaIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1.23);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id传小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id或者参数id格式是不正确的");
	}
	/**
	 * 参数id传非法字符
	 */
	@Test
	public void postGetManagerParaSpecialTestParaIdIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", "<@$%^>");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id传非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id或者参数id格式是不正确的");
	}
	/**
	 * 参数id传String
	 */
	@Test
	public void postGetManagerParaSpecialTestParaIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", "GDFD");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id传String" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id或者参数id格式是不正确的");
	}
	/**
	 * 参数id传空
	 */
	@Test
	public void postGetManagerParaSpecialTestParaIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id或者参数id格式是不正确的");
	}
	/**
	 * 参数id传空格
	 */
	@Test
	public void postGetManagerParaSpecialTestParaIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id或者参数id格式是不正确的");
	}
	/**
	 * 参数id传null
	 */
	@Test
	public void postGetManagerParaSpecialTestParaIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id传null" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 参数id不传参数
	 */
	@Test
	public void postGetManagerParaSpecialTestParaIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id不传参数" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 参数id传超长
	 */
	@Test
	public void postGetManagerParaSpecialTestParaIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 999999999999999999L);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id传超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	
}