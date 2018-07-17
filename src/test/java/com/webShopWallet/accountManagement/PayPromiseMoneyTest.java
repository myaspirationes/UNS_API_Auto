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

public class PayPromiseMoneyTest extends HttpUtil {
// 缴纳保证金接口
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
		request.put("walletId", 123456);
		request.put("assetsId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
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
		request.put("walletId", 123456);
		request.put("assetsId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
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
		request.put("walletId", 123456);
		request.put("assetsId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
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
		request.put("walletId", 123456);
		request.put("assetsId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
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
		request.put("walletId", 123456);
		request.put("assetsId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
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
		request.put("walletId", 123456);
		request.put("assetsId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * walletId为最大值
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestWalletIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 999999999999999999L);
		request.put("assetsId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletId为空
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestWalletIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", "");
		request.put("assetsId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletId为空格
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestWalletIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", " ");
		request.put("assetsId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletId为null
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestWalletIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", null);
		request.put("assetsId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletId为不传
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestWalletIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("assetsId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * assetsId为空
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestAssetsIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123456);
		request.put("assetsId", "");
		request.put("money", 100);
		request.put("passWord", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("assetsId为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * assetsId为空格
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestAssetsIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123456);
		request.put("assetsId", " ");
		request.put("money", 100);
		request.put("passWord", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("assetsId为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * assetsId为null
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestAssetsIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123456);
		request.put("assetsId", null);
		request.put("money", 100);
		request.put("passWord", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("assetsId为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * assetsId为不传
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestAssetsIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123456);
		request.put("money", 100);
		request.put("passWord", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("assetsId为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * money为null
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestMoneyIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123456);
		request.put("assetsId", 456789);
		request.put("money", null);
		request.put("passWord", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("money为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * money为空
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestMoneyIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123456);
		request.put("assetsId", 456789);
		request.put("money", "");
		request.put("passWord", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("money为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * money为空格
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestMoneyIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123456);
		request.put("assetsId", 456789);
		request.put("money", " ");
		request.put("passWord", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("money为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * money为不传
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestMoneyIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123456);
		request.put("assetsId", 456789);
		request.put("passWord", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("money为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * money为最大值
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestMoneyIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123456);
		request.put("assetsId", 456789);
		request.put("money", 999999999);
		request.put("passWord", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("money为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * passWord为null
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestPassWordIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123456);
		request.put("assetsId", 456789);
		request.put("money", 100);
		request.put("passWord", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("passWord为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * passWord为空
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestPassWordIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123456);
		request.put("assetsId", 456789);
		request.put("money", 100);
		request.put("passWord", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("passWord为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * passWord为空格
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestPassWordIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123456);
		request.put("assetsId", 456789);
		request.put("money", 100);
		request.put("passWord", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("passWord为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * passWord为不传
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestPassWordIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123456);
		request.put("assetsId", 456789);
		request.put("money", 100);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("passWord为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * passWord为超长
	 */
	@Test
	public void postSonAccountTurnToFundsAccountTestPassWordIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123456);
		request.put("assetsId", 456789);
		request.put("money", 100);
		request.put("passWord", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("passWord为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
}
