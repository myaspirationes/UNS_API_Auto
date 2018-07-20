package com.webShopWallet.companyWalletEnter;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class GetPersonCheckResultDetailsTest extends HttpUtil {
// 获取用户审核结果详情接口
	String url = "/wallet-admin/enterprise/getAudltList";


	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetPersonCheckResultDetailsTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 3);
		request.put("enterpriseId", 2);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	

	
	/**
	 * walletId不传参数
	 */
	@Test
	public void postGetPersonCheckResultDetailsTestWalletIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("enterpriseId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空
	 */
	@Test
	public void postGetPersonCheckResultDetailsTestWalletIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", "");
		request.put("enterpriseId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空格
	 */
	@Test
	public void postGetPersonCheckResultDetailsTestWalletIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", " ");
		request.put("enterpriseId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传null
	 */
	@Test
	public void postGetPersonCheckResultDetailsTestWalletIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", null);
		request.put("enterpriseId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传最大值
	 */
	@Test
	public void postGetPersonCheckResultDetailsTestWalletIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 999999999999999999L);
		request.put("enterpriseId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传最大值
	 */
	@Test
	public void postGetPersonCheckResultDetailsTestEnterpriseIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("enterpriseId", 999999999999999999L);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * enterpriseId传空
	 */
	@Test
	public void postGetPersonCheckResultDetailsTestEnterpriseIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("enterpriseId", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传空格
	 */
	@Test
	public void postGetPersonCheckResultDetailsTestentErpriseIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("enterpriseId", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传null
	 */
	@Test
	public void postGetPersonCheckResultDetailsTestEnterpriseIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("enterpriseId", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId不传参数
	 */
	@Test
	public void postGetPersonCheckResultDetailsTestEnterpriseIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}

	
}
