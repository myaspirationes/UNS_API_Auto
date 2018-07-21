package com.webShopWallet.accountManagement;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class GetBankSingleDayLimitMoneyTest extends HttpUtil {
// 获取银行单笔单日限额接口（暂时不用）
	String url = "/wallet-admin/enterpriseWallet/GetBankSingleDayLimitMoneyy";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetBankSingleDayLimitMoneyTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 123);
		request.put("bankId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID最大值
	 */
	@Test
	public void postGetBankSingleDayLimitMoneyTestUserIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1231231231231231231L);
		request.put("enterpriseId", 123);
		request.put("bankId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postGetBankSingleDayLimitMoneyTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("enterpriseId", 123);
		request.put("bankId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postGetBankSingleDayLimitMoneyTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("enterpriseId", 123);
		request.put("bankId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postGetBankSingleDayLimitMoneyTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("enterpriseId", 123);
		request.put("bankId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为不传
	 */
	@Test
	public void postGetBankSingleDayLimitMoneyTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("enterpriseId", 123);
		request.put("bankId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * enterpriseId为最大值
	 */
	@Test
	public void postGetBankSingleDayLimitMoneyTestEnterpriseIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 999999999999999999L);
		request.put("bankId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * enterpriseId为空
	 */
	@Test
	public void postGetBankSingleDayLimitMoneyTestEnterpriseIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", "");
		request.put("bankId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * enterpriseId为空格
	 */
	@Test
	public void postGetBankSingleDayLimitMoneyTestEnterpriseIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 123);
		request.put("bankId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * enterpriseId为null
	 */
	@Test
	public void postGetBankSingleDayLimitMoneyTestEnterpriseIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", null);
		request.put("bankId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * enterpriseId为不传
	 */
	@Test
	public void postGetBankSingleDayLimitMoneyTestEnterpriseIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * bankId为空
	 */
	@Test
	public void postGetBankSingleDayLimitMoneyTestBankIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 123);
		request.put("bankId", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("bankId为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * bankId为空格
	 */
	@Test
	public void postGetBankSingleDayLimitMoneyTestBankIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 123);
		request.put("bankId", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("bankId为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * bankId为null
	 */
	@Test
	public void postGetBankSingleDayLimitMoneyTestBankIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 123);
		request.put("bankId", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("bankId为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * bankId为不传
	 */
	@Test
	public void postGetBankSingleDayLimitMoneyTestBankIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 123);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("bankId为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * bankId为超长
	 */
	@Test
	public void postGetBankSingleDayLimitMoneyBankIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 123);
		request.put("bankId", 999999999999999999L);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("bankId为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
}
