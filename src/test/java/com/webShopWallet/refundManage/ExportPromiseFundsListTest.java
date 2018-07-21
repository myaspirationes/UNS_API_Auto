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

public class ExportPromiseFundsListTest extends HttpUtil {
// 导出保证金列表接口
	String url = "/wallet-admin/deposit/exportDepositList";
	/**
	 * 提交正确参数
	 */
	@Test
	public void postExportPromiseFundsListTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("type", 1);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * userId传空
	 */
	@Test
	public void postExportPromiseFundsListTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("walletId", 24);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("userId传空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * userId传空格
	 */
	@Test
	public void postExportPromiseFundsListTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("walletId", 24);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("userId传空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * userId传null
	 */
	@Test
	public void postExportPromiseFundsListTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("walletId", 24);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("userId传null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * userId不传
	 */
	@Test
	public void postExportPromiseFundsListTestUserIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 24);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("userId不传" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * userId传最大值
	 */
	@Test
	public void postExportPromiseFundsListTestUserIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 999999999999999999L);
		request.put("walletId", 24);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("userId传最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * minDealTime传空
	 */
	@Test
	public void postExportPromiseFundsListTestMinDealTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("type", 0);
		request.put("minDealTime", "");
		request.put("maxDealTime", "2018-10-10");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minDealTime传空" + post);

		assertThat(post.get("status")).isIn(1,-1);
		assertThat(post.get("msg")).isEqualTo("id为：999的角色不存在");
	}
	/**
	 * minDealTime传空格
	 */
	@Test
	public void postExportPromiseFundsListTestMinDealTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("type", 0);
		request.put("minDealTime", " ");
		request.put("maxDealTime", "2018-10-10");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minDealTime传空格" + post);

		assertThat(post.get("status")).isIn(1,-1);
		assertThat(post.get("msg")).isEqualTo("id为：1的角色不存在");
	}
	/**
	 * minDealTime传null
	 */
	@Test
	public void postExportPromiseFundsListTestMinDealTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("type", 0);
		request.put("minDealTime", null);
		request.put("maxDealTime", "2018-10-10");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minDealTime传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * minDealTime不传参数
	 */
	@Test
	public void postExportPromiseFundsListTestMinDealTimeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("type", 0);
		request.put("maxDealTime", "2018-10-10");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minDealTime不传参数" + post);

		assertThat(post.get("status")).isEqualTo(400);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * minDealTime传超长
	 */
	@Test
	public void postExportPromiseFundsListTestMinDealTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("type", 0);
		request.put("minDealTime", "12345678945612312346");
		request.put("maxDealTime", "2018-10-10");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minDealTime不传参数" + post);

		assertThat(post.get("status")).isEqualTo(400);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * minDealTime传最大值
	 */
	@Test
	public void postExportPromiseFundsListTestMinDealTimeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("type", 0);
		request.put("minDealTime", "9999-12-31");
		request.put("maxDealTime", "2018-10-10");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minDealTime传最大值" + post);

		assertThat(post.get("status")).isEqualTo(400);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * maxDealTime传空
	 */
	@Test
	public void postExportPromiseFundsListTestMaxDealTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxDealTime传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id不能为空！");
	}
	/**
	 * maxDealTime传空格
	 */
	@Test
	public void postExportPromiseFundsListTestMaxDealTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxDealTime传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id不能为空！");
	}
	/**
	 * maxDealTime传null
	 */
	@Test
	public void postExportPromiseFundsListTestMaxDealTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxDealTime传null" + post);

		assertThat(post.get("status")).isEqualTo(400);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * maxDealTime不传参数
	 */
	@Test
	public void postExportPromiseFundsListTestMaxDealTimeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxDealTime不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id不能为空！");
	}
	/**
	 * maxDealTime传超长
	 */
	@Test
	public void postExportPromiseFundsListTestMaxDealTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "1234567984531215464");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxDealTime传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * maxDealTime传最大值
	 */
	@Test
	public void postExportPromiseFundsListTestMaxDealTimeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "9999-12-31");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxDealTime传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空
	 */
	@Test
	public void postExportPromiseFundsListTestWalletIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", "");
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空格
	 */
	@Test
	public void postExportPromiseFundsListTestWalletIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", " ");
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传null
	 */
	@Test
	public void postExportPromiseFundsListTestWalletIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", null);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传最大值
	 */
	@Test
	public void postExportPromiseFundsListTestWalletIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 999999999999999999L);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * type传null
	 */
	@Test
	public void postExportPromiseFundsListTestTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("type", null);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传空
	 */
	@Test
	public void postExportPromiseFundsListTestTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("type", "");
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传空格
	 */
	@Test
	public void postExportPromiseFundsListTestTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("type", " ");
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type不传
	 */
	@Test
	public void postExportPromiseFundsListTestTypeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传最大值
	 */
	@Test
	public void postExportPromiseFundsListTestTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("type", 999999999);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传1缴纳/冻结
	 */
	@Test
	public void postExportPromiseFundsListTestTypeIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("type", 1);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传1缴纳/冻结" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传2解冻并转出
	 */
	@Test
	public void postExportPromiseFundsListTestTypeIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("type", 2);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传2解冻并转出" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传3赔付
	 */
	@Test
	public void postExportPromiseFundsListTestTypeIs3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("type", 3);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传3赔付" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
}
