package com.webShopWallet.refundManage;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class RefundFailedRetryTest extends HttpUtil {
//  退款管理，保证金管理接口
	String url = "/wallet-admin/enterpriseWalletRefundRecord/retryEnterpriseWalletRefundRecord";


	/**
	 * 提交正确参数
	 */
	@Test
	public void postRefundFailedRetryTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("recordId", 1);
		request.put("tradePass", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postRefundFailedRetryTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("recordId", 1);
		request.put("tradePass", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postRefundFailedRetryTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("recordId", 1);
		request.put("tradePass", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postRefundFailedRetryTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("recordId", 1);
		request.put("tradePass", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postRefundFailedRetryTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("recordId", 1);
		request.put("tradePass", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postRefundFailedRetryTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 999999999999999999L);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("recordId", 1);
		request.put("tradePass", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * walletId不传参数
	 */
	@Test
	public void postRefundFailedRetryTestWalletIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("enterpriseId", 19);
		request.put("recordId", 1);
		request.put("tradePass", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空
	 */
	@Test
	public void postRefundFailedRetryTestWalletIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", "");
		request.put("enterpriseId", 19);
		request.put("recordId", 1);
		request.put("tradePass", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空格
	 */
	@Test
	public void postRefundFailedRetryTestWalletIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", " ");
		request.put("enterpriseId", 19);
		request.put("recordId", 1);
		request.put("tradePass", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传null
	 */
	@Test
	public void postRefundFailedRetryTestWalletIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", null);
		request.put("enterpriseId", 19);
		request.put("recordId", 1);
		request.put("tradePass", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传最大值
	 */
	@Test
	public void postRefundFailedRetryTestWalletIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 999999999999999999L);
		request.put("enterpriseId", 19);
		request.put("recordId", 1);
		request.put("tradePass", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传最大值
	 */
	@Test
	public void postRefundFailedRetryTestEnterpriseIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 999999999999999999L);
		request.put("recordId", 1);
		request.put("tradePass", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传空
	 */
	@Test
	public void postRefundFailedRetryTestEnterpriseIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", "");
		request.put("recordId", 1);
		request.put("tradePass", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传空格
	 */
	@Test
	public void postRefundFailedRetryTestEnterpriseIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", " ");
		request.put("recordId", 1);
		request.put("tradePass", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传null
	 */
	@Test
	public void postRefundFailedRetryTestEnterpriseIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", null);
		request.put("recordId", 1);
		request.put("tradePass", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId不传参数
	 */
	@Test
	public void postRefundFailedRetryTestEnterpriseIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("recordId", 1);
		request.put("tradePass", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * recordId传null
	 */
	@Test
	public void postRefundFailedRetryTestRecordIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("recordId", null);
		request.put("tradePass", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("recordId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * recordId传空
	 */
	@Test
	public void postRefundFailedRetryTestRecordIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("recordId", "");
		request.put("tradePass", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("recordId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * recordId传空格
	 */
	@Test
	public void postRefundFailedRetryTestRecordIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("recordId", " ");
		request.put("tradePass", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("recordId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * recordId不传
	 */
	@Test
	public void postRefundFailedRetryTestRecordIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradePass", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("recordId不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * recordId传最大值
	 */
	@Test
	public void postRefundFailedRetryTestRecordIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("recordId", 999999999999999999L);
		request.put("tradePass", "123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("recordId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * tradePass传超长
	 */
	@Test
	public void postRefundFailedRetryTestTradePassIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("recordId", 1);
		request.put("tradePass", "1234567894561346789");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradePass传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * tradePass传空
	 */
	@Test
	public void postRefundFailedRetryTestTradePassIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("recordId", 1);
		request.put("tradePass", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradePass传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * tradePass传空格
	 */
	@Test
	public void postRefundFailedRetryTestTradePassIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("recordId", 1);
		request.put("tradePass", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradePass传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * tradePass传null
	 */
	@Test
	public void postRefundFailedRetryTestTradePassIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("recordId", 1);
		request.put("tradePass", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradePass传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * tradePass不传
	 */
	@Test
	public void postRefundFailedRetryTestTradePassIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("recordId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradePass不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
}
