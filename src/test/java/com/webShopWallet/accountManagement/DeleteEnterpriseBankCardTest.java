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

public class DeleteEnterpriseBankCardTest extends HttpUtil {
// 获取企业钱包详情接口
	String url = "/enterpriseWalletAssets/deleteEnterpriseBankCard";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardId", "cardId");
		request.put("bankCardId", "bankCardId");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID最大值
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestUserIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1231231231231231231L);
		request.put("wallrtId", 17);
		request.put("cardId", "cardId");
		request.put("bankCardId", "bankCardId");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("wallrtId", 17);
		request.put("cardId", "cardId");
		request.put("bankCardId", "bankCardId");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("wallrtId", 17);
		request.put("cardId", "cardId");
		request.put("bankCardId", "bankCardId");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("wallrtId", 17);
		request.put("cardId", "cardId");
		request.put("bankCardId", "bankCardId");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为不传
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("wallrtId", 17);
		request.put("cardId", "cardId");
		request.put("bankCardId", "bankCardId");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * 钱包ID为最大值
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestWallrtIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 1717171717117171717L);
		request.put("cardId", "cardId");
		request.put("bankCardId", "bankCardId");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 钱包ID为空
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestWallrtIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", "");
		request.put("cardId", "cardId");
		request.put("bankCardId", "bankCardId");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("钱包ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 钱包ID为空格
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestWallrtIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", " ");
		request.put("cardId", "cardId");
		request.put("bankCardId", "bankCardId");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("钱包ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 钱包ID为null
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestWallrtIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", null);
		request.put("cardId", "cardId");
		request.put("bankCardId", "bankCardId");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("钱包ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 钱包ID为不传
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestWallrtIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("cardId", "cardId");
		request.put("bankCardId", "bankCardId");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("钱包ID为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 银行卡ID为空
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestCardIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardId", "");
		request.put("bankCardId", "bankCardId");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("银行卡ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 银行卡ID为空格
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestCardIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardId", " ");
		request.put("bankCardId", "bankCardId");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("银行卡ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 银行卡ID为null
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestCardIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardId", null);
		request.put("bankCardId", "bankCardId");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("银行卡ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 银行卡ID为最大值
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestCardIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardId", 1231231231231231231L);
		request.put("bankCardId", "bankCardId");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("银行卡ID为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 银行卡ID为不传
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestCardIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("bankCardId", "bankCardId");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("银行卡ID为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * 银生宝银行卡ID为最大值
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestBankCardIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardId", "cardId");
		request.put("bankCardId", 1231231211113123123L);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("银生宝银行卡ID为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 银生宝银行卡ID为空
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestBankCardIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardId", "cardId");
		request.put("bankCardId", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("银生宝银行卡ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 银生宝银行卡ID为空格
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestBankCardIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardId", "cardId");
		request.put("bankCardId", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("银生宝银行卡ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}/**
	 * 银生宝银行卡ID为null
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestBankCardIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardId", "cardId");
		request.put("bankCardId", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("银生宝银行卡ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 银生宝银行卡ID为不传
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestBankCardIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardId", "cardId");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("银生宝银行卡ID为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}


	
}
