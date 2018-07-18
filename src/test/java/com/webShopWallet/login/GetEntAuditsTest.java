package com.webShopWallet.login;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class GetEntAuditsTest extends HttpUtil {
// 获取审核通过企业列表接口
	String url = "/wallet-admin/deposit/exportDepositList";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetEntAuditsTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * userId传空
	 */
	@Test
	public void postGetEntAuditsTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("userId传空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * userId传空格
	 */
	@Test
	public void postGetEntAuditsTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("type", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("userId传空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * userId传null
	 */
	@Test
	public void postGetEntAuditsTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("userId传null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * userId不传
	 */
	@Test
	public void postGetEntAuditsTestUserIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("type", 0);	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("userId不传" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * userId传最大值
	 */
	@Test
	public void postGetEntAuditsTestUserIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 999999999999999999L);
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("userId传最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type传null
	 */
	@Test
	public void postGetEntAuditsTestTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("type", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传空
	 */
	@Test
	public void postGetEntAuditsTestTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("type", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传空格
	 */
	@Test
	public void postGetEntAuditsTestTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("type", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type不传
	 */
	@Test
	public void postGetEntAuditsTestTypeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传最大值
	 */
	@Test
	public void postGetEntAuditsTestTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("type", 999999999);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传1审核中
	 */
	@Test
	public void postGetEntAuditsTestTypeIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传1审核中" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传2审核成功
	 */
	@Test
	public void postGetEntAuditsTestTypeIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("type", 2);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传2审核成功" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传3审核失败
	 */
	@Test
	public void postGetEntAuditsTestTypeIs3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("type", 3);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传3审核失败" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
}
