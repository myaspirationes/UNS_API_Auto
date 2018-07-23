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

public class RechargeByBankTest extends HttpUtil {
// 调用登录网上银行接口
	String url = "/wallet-admin/asset/rechargeByBank";

	/**
	 * 提交正确参数
	 */
	@Test
	public void postRechargeByBankTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("bankCode", "ccb");
		request.put("amount", 100);
		request.put("assetId", "55");
		request.put("fee", "0");//企业入金
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID最大值
	 */
	@Test
	public void postRechargeByBankTestUserIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1231231231231231231L);
		request.put("bankCode", "bankCode");
		request.put("amount", 100);
		request.put("assrtId", "assrtId");
		request.put("fee", "fee");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postRechargeByBankTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("bankCode", "bankCode");
		request.put("amount", 100);
		request.put("assrtId", "assrtId");
		request.put("fee", "fee");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postRechargeByBankTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("bankCode", "bankCode");
		request.put("amount", 100);
		request.put("assrtId", "assrtId");
		request.put("fee", "fee");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postRechargeByBankTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("bankCode", "bankCode");
		request.put("amount", 100);
		request.put("assrtId", "assrtId");
		request.put("fee", "fee");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为不传
	 */
	@Test
	public void postRechargeByBankTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("bankCode", "bankCode");
		request.put("amount", 100);
		request.put("assrtId", "assrtId");
		request.put("fee", "fee");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * 银行ID为最大值
	 */
	@Test
	public void postRechargeByBankTestEnterpriseIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("bankCode", 2312312312312312312L);
		request.put("amount", 100);
		request.put("assrtId", "assrtId");
		request.put("fee", "fee");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("银行ID为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 银行ID为空
	 */
	@Test
	public void postRechargeByBankTestEnterpriseIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("bankCode", "");
		request.put("amount", 100);
		request.put("assrtId", "assrtId");
		request.put("fee", "fee");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("银行ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 银行ID为空格
	 */
	@Test
	public void postRechargeByBankTestEnterpriseIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("bankCode", " ");
		request.put("amount", 100);
		request.put("assrtId", "assrtId");
		request.put("fee", "fee");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("银行ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 银行ID为null
	 */
	@Test
	public void postRechargeByBankTestEnterpriseIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("bankCode", null);
		request.put("amount", 100);
		request.put("assrtId", "assrtId");
		request.put("fee", "fee");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("银行ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 银行ID为不传
	 */
	@Test
	public void postRechargeByBankTestEnterpriseIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("amount", 100);
		request.put("assrtId", "assrtId");
		request.put("fee", "fee");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("银行ID为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 金额为单笔最大值
	 */
	@Test
	public void postRechargeByBankTestAmountIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("bankCode", "bankCode");
		request.put("amount", 100000);
		request.put("assrtId", "assrtId");
		request.put("fee", "fee");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("金额为单笔最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 金额为空
	 */
	@Test
	public void postRechargeByBankTestAmountIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("bankCode", "bankCode");
		request.put("amount", "");
		request.put("assrtId", "assrtId");
		request.put("fee", "fee");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("金额为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 金额为空格
	 */
	@Test
	public void postRechargeByBankTestAmountIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("bankCode", "bankCode");
		request.put("amount", " ");
		request.put("assrtId", "assrtId");
		request.put("fee", "fee");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("金额为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 金额为null
	 */
	@Test
	public void postRechargeByBankTestAmountIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("bankCode", "bankCode");
		request.put("amount", null);
		request.put("assrtId", "assrtId");
		request.put("fee", "fee");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("金额为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 金额为不传
	 */
	@Test
	public void postRechargeByBankTestAmountNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("bankCode", "bankCode");
		request.put("amount", 100);
		request.put("assrtId", "assrtId");
		request.put("fee", "fee");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("金额为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 账户ID为空
	 */
	@Test
	public void postRechargeByBankTestssrtIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("bankCode", "bankCode");
		request.put("amount", 100);
		request.put("assrtId", "");
		request.put("fee", "fee");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 账户ID为空格
	 */
	@Test
	public void postRechargeByBankTestssrtIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("bankCode", "bankCode");
		request.put("amount", 100);
		request.put("assrtId", " ");
		request.put("fee", "fee");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 账户ID为null
	 */
	@Test
	public void postRechargeByBankTestssrtIdIsnull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("bankCode", "bankCode");
		request.put("amount", 100);
		request.put("assrtId", null);
		request.put("fee", "fee");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 账户ID为最大值
	 */
	@Test
	public void postRechargeByBankTestssrtIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("bankCode", "bankCode");
		request.put("amount", 100);
		request.put("assrtId", "assrtIdassrtIdassrtIdassrtIdassrtId");
		request.put("fee", "fee");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账户ID为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 账户ID为不传
	 */
	@Test
	public void postRechargeByBankTestssrtIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("bankCode", "bankCode");
		request.put("amount", 100);
		request.put("fee", "fee");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账户ID为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手续费为空
	 */
	@Test
	public void postRechargeByBankTestFeeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("bankCode", "bankCode");
		request.put("amount", 100);
		request.put("assrtId", "assrtId");
		request.put("fee", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手续费为空格
	 */
	@Test
	public void postRechargeByBankTestFeeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("bankCode", "bankCode");
		request.put("amount", 100);
		request.put("assrtId", "assrtId");
		request.put("fee", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手续费为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手续费为null
	 */
	@Test
	public void postRechargeByBankTestFeeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("bankCode", "bankCode");
		request.put("amount", 100);
		request.put("assrtId", "assrtId");
		request.put("fee", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手续费为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手续费为最大值
	 */
	@Test
	public void postRechargeByBankTestFeeisMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("bankCode", "bankCode");
		request.put("amount", 100);
		request.put("assrtId", "assrtId");
		request.put("fee", "feefeefeefeefeefeefeefee");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手续费为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手续费为不传
	 */
	@Test
	public void postRechargeByBankTestFeeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("bankCode", "bankCode");
		request.put("amount", 100);
		request.put("assrtId", "assrtId");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手续费为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	
}
