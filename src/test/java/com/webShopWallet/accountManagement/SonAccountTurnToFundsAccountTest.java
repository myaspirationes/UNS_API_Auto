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

public class SonAccountTurnToFundsAccountTest extends HttpUtil {
// 子账户转出（解冻）到现金账户接口
	String url = "/";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletEnterpriseId", 123456);
		request.put("accountId", 456789);
		request.put("amount", 100);
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID最大值
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestUserIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1231231231231231231L);
		request.put("walletEnterpriseId", 123456);
		request.put("accountId", 456789);
		request.put("amount", 100);
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("walletEnterpriseId", 123456);
		request.put("accountId", 456789);
		request.put("amount", 100);
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("walletEnterpriseId", 123456);
		request.put("accountId", 456789);
		request.put("amount", 100);
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("walletEnterpriseId", 123456);
		request.put("accountId", 456789);
		request.put("amount", 100);
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为不传
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletEnterpriseId", 123456);
		request.put("accountId", 456789);
		request.put("amount", 100);
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * walletEnterpriseId为最大值
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestWalletEnterpriseIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletEnterpriseId", 999999999999999999L);
		request.put("accountId", 456789);
		request.put("amount", 100);
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletEnterpriseId为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletEnterpriseId为空
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestWalletEnterpriseIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletEnterpriseId", "");
		request.put("accountId", 456789);
		request.put("amount", 100);
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletEnterpriseId为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletEnterpriseId为空格
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestWalletEnterpriseIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletEnterpriseId", " ");
		request.put("accountId", 456789);
		request.put("amount", 100);
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletEnterpriseId为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletEnterpriseId为null
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestWalletEnterpriseIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletEnterpriseId", null);
		request.put("accountId", 456789);
		request.put("amount", 100);
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletEnterpriseId为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletEnterpriseId为不传
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestWalletEnterpriseIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("accountId", 456789);
		request.put("amount", 100);
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletEnterpriseId为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * accountId为空
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestAccountIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletEnterpriseId", 123456);
		request.put("accountId", "");
		request.put("amount", 100);
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountId为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * accountId为空格
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestAccountIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletEnterpriseId", 123456);
		request.put("accountId", " ");
		request.put("amount", 100);
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountId为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * accountId为null
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestAccountIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletEnterpriseId", 123456);
		request.put("accountId", null);
		request.put("amount", 100);
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountId为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * accountId为不传
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestAccountIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletEnterpriseId", 123456);
		request.put("amount", 100);
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountId为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * amount为null
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestAmountIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletEnterpriseId", 123456);
		request.put("accountId", 456789);
		request.put("amount", null);
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("amount为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * amount为空
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestAmountIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletEnterpriseId", 123456);
		request.put("accountId", 456789);
		request.put("amount", "");
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("amount为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * amount为空格
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestAmountIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletEnterpriseId", 123456);
		request.put("accountId", 456789);
		request.put("amount", " ");
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("amount为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * amount为不传
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestAmountIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletEnterpriseId", 123456);
		request.put("accountId", 456789);
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("amount为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * amount为最大值
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestAmountIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletEnterpriseId", 123456);
		request.put("accountId", 456789);
		request.put("amount", 999999999);
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("amount为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为null
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletEnterpriseId", 123456);
		request.put("accountId", 456789);
		request.put("amount", 100);
		request.put("type", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为空
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletEnterpriseId", 123456);
		request.put("accountId", 456789);
		request.put("amount", 100);
		request.put("type", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为空格
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletEnterpriseId", 123456);
		request.put("accountId", 456789);
		request.put("amount", 100);
		request.put("type", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为不传
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestTypeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletEnterpriseId", 123456);
		request.put("accountId", 456789);
		request.put("amount", 100);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为最大值
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletEnterpriseId", 123456);
		request.put("accountId", 456789);
		request.put("amount", 100);
		request.put("type", 999999999);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为0转出
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestTypeIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletEnterpriseId", 123456);
		request.put("accountId", 456789);
		request.put("amount", 100);
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为0转出" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为1解冻
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestTypeIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletEnterpriseId", 123456);
		request.put("accountId", 456789);
		request.put("amount", 100);
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为1解冻" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
}
