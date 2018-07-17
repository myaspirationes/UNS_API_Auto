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

public class WithdrawToBankTest extends HttpUtil {
// 提现到银行卡接口
	String url = "/asset/WithdrawToBank";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postWithdrawToBankTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID最大值
	 */
	@Test
	public void postWithdrawToBankTestUserIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1231231231231231231L);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postWithdrawToBankTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postWithdrawToBankTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postWithdrawToBankTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为不传
	 */
	@Test
	public void postWithdrawToBankTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * bankCardId为最大值
	 */
	@Test
	public void postWithdrawToBankTestBankCardIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", 999999999999999999L);
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("bankCardId为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * bankCardId为空
	 */
	@Test
	public void postWithdrawToBankTestBankCardIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("bankCardId为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * bankCardId为空格
	 */
	@Test
	public void postWithdrawToBankTestBankCardIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", " ");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("bankCardId为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * bankCardId为null
	 */
	@Test
	public void postWithdrawToBankTestBankCardIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", null);
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("bankCardId为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * bankCardId为不传
	 */
	@Test
	public void postWithdrawToBankTestBankCardIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("bankCardId为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletId为空
	 */
	@Test
	public void postWithdrawToBankTestWalletIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", "");
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletId为空格
	 */
	@Test
	public void postWithdrawToBankTestWalletIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", " ");
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletId为null
	 */
	@Test
	public void postWithdrawToBankTestWalletIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", null);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletId为最大值
	 */
	@Test
	public void postWithdrawToBankTestWalletIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 999999999999999999L);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletId为不传
	 */
	@Test
	public void postWithdrawToBankTestWalletIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * amount为空
	 */
	@Test
	public void postWithdrawToBankTestAmountIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("amount为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * amount为空格
	 */
	@Test
	public void postWithdrawToBankTestAmountIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", " ");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("amount为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * amount为null
	 */
	@Test
	public void postWithdrawToBankTestAmountIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", null);
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("amount为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * amount为最大值
	 */
	@Test
	public void postWithdrawToBankTestAmountIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("amount为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * amount为不传
	 */
	@Test
	public void postWithdrawToBankTestAmountNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("amount为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * remark为超长
	 */
	@Test
	public void postWithdrawToBankTestRemarkIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现对方回答说九分电视剧法律合法的客家话分厘卡圣诞节发电量数据放到开了四间房");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("remark为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * remark为空
	 */
	@Test
	public void postWithdrawToBankTestRemarkIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("remark为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * remark为空格
	 */
	@Test
	public void postWithdrawToBankTestRemarkIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", " ");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("remark为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * remark为null
	 */
	@Test
	public void postWithdrawToBankTestRemarkIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", null);
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("remark为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * remark为不传
	 */
	@Test
	public void postWithdrawToBankTestRemarkIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("remark为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为最大值
	 */
	@Test
	public void postWithdrawToBankTestTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 999999999);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为空
	 */
	@Test
	public void postWithdrawToBankTestTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", "");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为空格
	 */
	@Test
	public void postWithdrawToBankTestTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", " ");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为null
	 */
	@Test
	public void postWithdrawToBankTestTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", null);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type不传
	 */
	@Test
	public void postWithdrawToBankTestTypeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * passWord为超长
	 */
	@Test
	public void postWithdrawToBankTestPassWordIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "12345678945613213213dfddadsd");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("passWord为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * passWord为空
	 */
	@Test
	public void postWithdrawToBankTestPassWordIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("passWord为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * passWord为空格
	 */
	@Test
	public void postWithdrawToBankTestPassWordIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", " ");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("passWord为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * passWord为null
	 */
	@Test
	public void postWithdrawToBankTestPassWordIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", null);
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("passWord为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * passWord为不传
	 */
	@Test
	public void postWithdrawToBankTestPassWordIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("passWord为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * mobile为超长
	 */
	@Test
	public void postWithdrawToBankTestMobileIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910123456789");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * mobile为空
	 */
	@Test
	public void postWithdrawToBankTestMobileIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * mobile为空格
	 */
	@Test
	public void postWithdrawToBankTestMobileIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", " ");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * mobile为null
	 */
	@Test
	public void postWithdrawToBankTestMobileIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", null);
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * mobile为不传
	 */
	@Test
	public void postWithdrawToBankTestMobileIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * code为超长
	 */
	@Test
	public void postWithdrawToBankTestCodeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "222212345464546456456466");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("code为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * code为空
	 */
	@Test
	public void postWithdrawToBankTestCodeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("code为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * code为空格
	 */
	@Test
	public void postWithdrawToBankTestCodeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", " ");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("code为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * code为null
	 */
	@Test
	public void postWithdrawToBankTestCodeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", null);
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("code为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * code为不传
	 */
	@Test
	public void postWithdrawToBankTestCodeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("code为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手续费为空
	 */
	@Test
	public void postWithdrawToBankTestFeeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
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
	public void postWithdrawToBankTestFeeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
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
	public void postWithdrawToBankTestFeeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
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
	public void postWithdrawToBankTestFeeisMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "99999999999999");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手续费为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手续费为不传
	 */
	@Test
	public void postWithdrawToBankTestFeeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("bankCardId", "bankCardId");
		request.put("walletId", 100);
		request.put("amount", "100");
		request.put("remark", "自动化测试提现");
		request.put("type", 1);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手续费为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	
}
