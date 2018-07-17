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

public class GetWalletServiceChargesTest extends HttpUtil {
// 获取手续费标准详情接口
	String url = "/wallet-admin/enterpriseWallet/GetWalletServiceChargesy";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetWalletServiceChargesTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("transactionType", 1);
		request.put("accoutType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID最大值
	 */
	@Test
	public void postGetWalletServiceChargesTestUserIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1231231231231231231L);
		request.put("transactionType", 1);
		request.put("accoutType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postGetWalletServiceChargesTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("transactionType", 1);
		request.put("accoutType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postGetWalletServiceChargesTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("transactionType", 1);
		request.put("accoutType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postGetWalletServiceChargesTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("transactionType", 1);
		request.put("accoutType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为不传
	 */
	@Test
	public void postGetWalletServiceChargesTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("transactionType", 1);
		request.put("accoutType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * transactionType为最大值
	 */
	@Test
	public void postGetWalletServiceChargesTestTransactionTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("transactionType", 999999999);
		request.put("accoutType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * transactionType为空
	 */
	@Test
	public void postGetWalletServiceChargesTestTransactionTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("transactionType", "");
		request.put("accoutType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("transactionType为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * transactionType为空格
	 */
	@Test
	public void postGetWalletServiceChargesTestTransactionTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("transactionType", " ");
		request.put("accoutType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("transactionType为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * transactionType为null
	 */
	@Test
	public void postGetWalletServiceChargesTestTransactionTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("transactionType", null);
		request.put("accoutType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("transactionType为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * transactionType为1入金
	 */
	@Test
	public void postGetWalletServiceChargesTestTransactionTypeIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("transactionType", 1);
		request.put("accoutType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("transactionType为1入金" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * transactionType为2出金
	 */
	@Test
	public void postGetWalletServiceChargesTestTransactionTypeIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("transactionType", 2);
		request.put("accoutType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("transactionType为2出金" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * transactionType为3账户间流转
	 */
	@Test
	public void postGetWalletServiceChargesTestTransactionTypeIs3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("transactionType", 3);
		request.put("accoutType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("transactionType为3账户间流转" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * transactionType为不传
	 */
	@Test
	public void postGetWalletServiceChargesTestTransactionTypeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("accoutType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("transactionType为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * accoutType为空
	 */
	@Test
	public void postGetWalletServiceChargesTestAccoutTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("transactionType", 1);
		request.put("accoutType", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accoutType为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * accoutType为空格
	 */
	@Test
	public void postGetWalletServiceChargesTestAccoutTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("transactionType", 1);
		request.put("accoutType", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accoutType为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * accoutType为null
	 */
	@Test
	public void postGetWalletServiceChargesTestAccoutTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("transactionType", 1);
		request.put("accoutType", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accoutType为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * accoutType为不传
	 */
	@Test
	public void postGetWalletServiceChargesTestAccoutTypeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("transactionType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accoutType为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * accoutType为最大值
	 */
	@Test
	public void postGetWalletServiceChargesTestAccoutTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("transactionType", 1);
		request.put("accoutType", 999999999);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accoutType为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * accoutType为1个人
	 */
	@Test
	public void postGetWalletServiceChargesTestAccoutTypeIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("transactionType", 1);
		request.put("accoutType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accoutType为1个人" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * accoutType为2企业
	 */
	@Test
	public void postGetWalletServiceChargesTestAccoutTypeIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("transactionType", 1);
		request.put("accoutType", 2);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accoutType为2企业" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
}
