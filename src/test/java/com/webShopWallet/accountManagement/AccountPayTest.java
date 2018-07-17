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

public class AccountPayTest extends HttpUtil {
// 现金账户充值到子账户接口或子账户转到现金账户
	String url = "/wallet-admin/enterpriseWallet/accountPay";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postAccountPayTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID最大值
	 */
	@Test
	public void postAccountPayTestUserIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1231231231231231231L);
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postAccountPayTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postAccountPayTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postAccountPayTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为不传
	 */
	@Test
	public void postAccountPayTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * walletId为最大值
	 */
	@Test
	public void postAccountPayTestWalletIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 999999999999999999L);
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletId为空
	 */
	@Test
	public void postAccountPayTestWalletIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", "");
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletId为空格
	 */
	@Test
	public void postAccountPayTestWalletIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", " ");
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletId为null
	 */
	@Test
	public void postAccountPayTestEalletIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", null);
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletId为不传
	 */
	@Test
	public void postAccountPayTestWalletIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为空
	 */
	@Test
	public void postAccountPayTestTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", "");
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为空格
	 */
	@Test
	public void postAccountPayTestTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", " ");
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为null
	 */
	@Test
	public void postAccountPayTestTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", null);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为不传
	 */
	@Test
	public void postAccountPayTestTypeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为最大值
	 */
	@Test
	public void postAccountPayTestTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", 999999999);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为 1现金账户往子账户充值
	 */
	@Test
	public void postAccountPayTestTypeIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为 1现金账户往子账户充值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为2子账户转出
	 */
	@Test
	public void postAccountPayTestTypeIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", 2);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为2子账户转出" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * assetId为空
	 */
	@Test
	public void postAccountPayTestAssetIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("assetId", "");
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("assetId为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * assetId为空格
	 */
	@Test
	public void postAccountPayTestAssetIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("assetId", " ");
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("assetId为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * assetId为null
	 */
	@Test
	public void postAccountPayTestAssetIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("assetId", null);
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("assetId为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * assetId为不传
	 */
	@Test
	public void postAccountPayTestAssetIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("assetId为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * money为null
	 */
	@Test
	public void postAccountPayTestMoneyIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", null);
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("money为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * money为空
	 */
	@Test
	public void postAccountPayTestMoneyIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", "");
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("money为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * money为空格
	 */
	@Test
	public void postAccountPayTestMoneyIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", " ");
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("money为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * money为不传
	 */
	@Test
	public void postAccountPayTestMoneyIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("money为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * money为最大值
	 */
	@Test
	public void postAccountPayTestMoneyIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", 999999999);
		request.put("passWord", "123456");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("money为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * passWord为null
	 */
	@Test
	public void postAccountPayTestPassWordIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", null);
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("passWord为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * passWord为空
	 */
	@Test
	public void postAccountPayTestPassWordIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", "");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("passWord为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * passWord为空格
	 */
	@Test
	public void postAccountPayTestPassWordIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", " ");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("passWord为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * passWord为不传
	 */
	@Test
	public void postAccountPayTestPassWordIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("passWord为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * passWord为超长
	 */
	@Test
	public void postAccountPayTestPassWordIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456456456df4546df4665445");
		request.put("pwdCr", "123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("passWord为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * pwdCr为null
	 */
	@Test
	public void postAccountPayTestPwdCrIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pwdCr为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * pwdCr为空
	 */
	@Test
	public void postAccountPayTestPwdCrIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pwdCr为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * pwdCr为空格
	 */
	@Test
	public void postAccountPayTestPwdCrIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pwdCr为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * pwdCr为不传
	 */
	@Test
	public void postAccountPayTestPwdCrIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pwdCr为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * pwdCr为超长
	 */
	@Test
	public void postAccountPayTestPwdCrIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("assetId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "12345464565644645");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pwdCr为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
}
