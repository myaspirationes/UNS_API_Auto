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

public class SearchGetPromiseFundsListTest extends HttpUtil {
// 搜索获取保证金列表接口
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
	public void postSearchGetPromiseFundsListTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * minDealTime传空
	 */
	@Test
	public void postSearchGetPromiseFundsListTestMinDealTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("type", 0);
		request.put("minDealTime", "");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minDealTime传空" + post);

		assertThat(post.get("status")).isIn(1,-1);
		assertThat(post.get("msg")).isEqualTo("id为：999的角色不存在");
	}
	/**
	 * minDealTime传空格
	 */
	@Test
	public void postSearchGetPromiseFundsListTestMinDealTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("type", 0);
		request.put("minDealTime", " ");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minDealTime传空格" + post);

		assertThat(post.get("status")).isIn(1,-1);
		assertThat(post.get("msg")).isEqualTo("id为：1的角色不存在");
	}
	/**
	 * minDealTime传null
	 */
	@Test
	public void postSearchGetPromiseFundsListTestMinDealTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("type", 0);
		request.put("minDealTime", null);
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minDealTime传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * minDealTime不传参数
	 */
	@Test
	public void postSearchGetPromiseFundsListTestMinDealTimeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		
		request.put("walletId", 123);
		request.put("type", 0);
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minDealTime不传参数" + post);

		assertThat(post.get("status")).isEqualTo(400);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * minDealTime传超长
	 */
	@Test
	public void postSearchGetPromiseFundsListTestMinDealTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("type", 0);
		request.put("minDealTime", "12345678945612312346");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minDealTime不传参数" + post);

		assertThat(post.get("status")).isEqualTo(400);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * minDealTime传最大值
	 */
	@Test
	public void postSearchGetPromiseFundsListTestMinDealTimeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		
		request.put("walletId", 123);
		request.put("type", 0);
		request.put("minDealTime", "9999-12-31");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minDealTime传最大值" + post);

		assertThat(post.get("status")).isEqualTo(400);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * maxDealTime传空
	 */
	@Test
	public void postSearchGetPromiseFundsListTestMaxDealTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		
		request.put("walletId", 123);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxDealTime传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id不能为空！");
	}
	/**
	 * maxDealTime传空格
	 */
	@Test
	public void postSearchGetPromiseFundsListTestMaxDealTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		
		request.put("walletId", 123);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", " ");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxDealTime传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id不能为空！");
	}
	/**
	 * maxDealTime传null
	 */
	@Test
	public void postSearchGetPromiseFundsListTestMaxDealTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		
		request.put("walletId", 123);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", null);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxDealTime传null" + post);

		assertThat(post.get("status")).isEqualTo(400);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * maxDealTime不传参数
	 */
	@Test
	public void postSearchGetPromiseFundsListTestMaxDealTimeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		
		request.put("walletId", 123);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxDealTime不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id不能为空！");
	}
	/**
	 * maxDealTime传超长
	 */
	@Test
	public void postSearchGetPromiseFundsListTestMaxDealTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		
		request.put("walletId", 123);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "1234567984531215464");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxDealTime传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * maxDealTime传最大值
	 */
	@Test
	public void postSearchGetPromiseFundsListTestMaxDealTimeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		
		request.put("walletId", 123);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "9999-12-31");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxDealTime传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * pageSize传空
	 */
	@Test
	public void postSearchGetPromiseFundsListTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", "");
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageSize传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * pageSize传空格
	 */
	@Test
	public void postSearchGetPromiseFundsListTestPageSizeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", " ");
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageSize传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * pageSize传null
	 */
	@Test
	public void postSearchGetPromiseFundsListTestPageSizeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", null);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageSize传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * pageSize不传参数
	 */
	@Test
	public void postSearchGetPromiseFundsListTestPageSizeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageSize不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * pageSize传最大值
	 */
	@Test
	public void postSearchGetPromiseFundsListTestPageSizeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 999999999);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageSize传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * pageNow传最大值
	 */
	@Test
	public void postSearchGetPromiseFundsListTestPageNowIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 999999999);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageNow传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * pageNow传空
	 */
	@Test
	public void postSearchGetPromiseFundsListTestPageNowIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageNow传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * pageNow传空格
	 */
	@Test
	public void postSearchGetPromiseFundsListTestPageNowIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageNow传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * pageNow传null
	 */
	@Test
	public void postSearchGetPromiseFundsListTestPageNowIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageNow传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * pageNow不传参数
	 */
	@Test
	public void postSearchGetPromiseFundsListTestPageNowIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageNow不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId不传参数
	 */
	@Test
	public void postSearchGetPromiseFundsListTestWalletIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空
	 */
	@Test
	public void postSearchGetPromiseFundsListTestWalletIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", "");
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空格
	 */
	@Test
	public void postSearchGetPromiseFundsListTestWalletIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", " ");
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传null
	 */
	@Test
	public void postSearchGetPromiseFundsListTestWalletIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", null);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传最大值
	 */
	@Test
	public void postSearchGetPromiseFundsListTestWalletIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 999999999999999999L);
		request.put("type", 0);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * type传null
	 */
	@Test
	public void postSearchGetPromiseFundsListTestTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("type", null);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传空
	 */
	@Test
	public void postSearchGetPromiseFundsListTestTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("type", "");
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传空格
	 */
	@Test
	public void postSearchGetPromiseFundsListTestTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("type", " ");
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type不传
	 */
	@Test
	public void postSearchGetPromiseFundsListTestTypeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传最大值
	 */
	@Test
	public void postSearchGetPromiseFundsListTestTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("type", 999999999);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传1缴纳/冻结
	 */
	@Test
	public void postSearchGetPromiseFundsListTestTypeIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("type", 1);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传1缴纳/冻结" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传2解冻并转出
	 */
	@Test
	public void postSearchGetPromiseFundsListTestTypeIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("type", 2);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传2解冻并转出" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传3赔付
	 */
	@Test
	public void postSearchGetPromiseFundsListTestTypeIs3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("type", 3);
		request.put("minDealTime", "2018-01-01");
		request.put("maxDealTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传3赔付" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
}
