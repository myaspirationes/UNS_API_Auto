package com.webDynamic.dynamicManagement;

import com.example.HttpUtil;
import com.example.LoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class GetDynamicDetailsTest extends HttpUtil {
//获取动态详情接口
	String url = "/uu-admin/dynamicManage/getDynamicDesc";

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetDynamicDetailsTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", 1141);
		request.put("userId", 1000000);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postGetDynamicDetailsTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1.1);
		request.put("dynamicId", 1141);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postGetDynamicDetailsTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", -1);
		request.put("dynamicId", 1141);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postGetDynamicDetailsTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 0);
		request.put("dynamicId", 1141);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为错误
	 */
	@Test
	public void postGetDynamicDetailsTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 123);
		request.put("dynamicId", 1141);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID未登录
	 */
	@Test
	public void postGetDynamicDetailsTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1000001);
		request.put("dynamicId", 1141);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID未登录" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为字符串
	 */
	@Test
	public void postGetDynamicDetailsTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "1000000");
		request.put("dynamicId", 1141);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postGetDynamicDetailsTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", null);
		request.put("dynamicId", 1141);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postGetDynamicDetailsTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "");
		request.put("dynamicId", 1141);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postGetDynamicDetailsTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", " ");
		request.put("dynamicId", 1141);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postGetDynamicDetailsTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 123123123123123L);
		request.put("dynamicId", 1141);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postGetDynamicDetailsTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", 1141);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态id为错误
	 */
	@Test
	public void postGetDynamicDetailsTestDynamicIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", 1141111);
		request.put("userId", 1000000);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态id为负数
	 */
	@Test
	public void postGetDynamicDetailsTestDynamicIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", -1141);
		request.put("userId", 1000000);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态id为小数
	 */
	@Test
	public void postGetDynamicDetailsTestDynamicIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", 11.41);
		request.put("userId", 1000000);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态id为String
	 */
	@Test
	public void postGetDynamicDetailsTestDynamicIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", "hgfhgf");
		request.put("userId", 1000000);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态id为0
	 */
	@Test
	public void postGetDynamicDetailsTestDynamicIdIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", 0);
		request.put("userId", 1000000);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态id为空
	 */
	@Test
	public void postGetDynamicDetailsTestDynamicIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", "");
		request.put("userId", 1000000);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态id为空格
	 */
	@Test
	public void postGetDynamicDetailsTestDynamicIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", " ");
		request.put("userId", 1000000);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态id为null
	 */
	@Test
	public void postGetDynamicDetailsTestDynamicIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", null);
		request.put("userId", 1000000);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态id不传参数
	 */
	@Test
	public void postGetDynamicDetailsTestDynamicIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1000000);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id不传参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态id为超长
	 */
	@Test
	public void postGetDynamicDetailsTestDynamicIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", 999999999999999999L);
		request.put("userId", 1000000);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}


}