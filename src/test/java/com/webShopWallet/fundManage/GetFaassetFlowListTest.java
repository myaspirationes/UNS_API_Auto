package com.webShopWallet.fundManage;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class GetFaassetFlowListTest extends HttpUtil {
//  默认页获取资金交易流水列表接口
	String url = "/wallet-admin/enterpriseWalletRefundRecord/getFaassetFlowList";

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetFaassetFlowListTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postGetFaassetFlowListTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postGetFaassetFlowListTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postGetFaassetFlowListTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postGetFaassetFlowListTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postGetFaassetFlowListTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 999999999999999999L);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * tradeMethods为最大值
	 */
	@Test
	public void postGetFaassetFlowListTestTradeMethodsIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 999999999);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradeMethods为最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * tradeMethods为空
	 */
	@Test
	public void postGetFaassetFlowListTestTradeMethodsIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", "");
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradeMethods为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * tradeMethods为空格
	 */
	@Test
	public void postGetFaassetFlowListTestTradeMethodsIsSpeace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", " ");
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradeMethods为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * tradeMethods为null
	 */
	@Test
	public void postGetFaassetFlowListTestTradeMethodsIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", null);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradeMethods为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * tradeMethods为1余额
	 */
	@Test
	public void postGetFaassetFlowListTestTradeMethodsIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradeMethods为1余额" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isIn("成功");
	}
	/**
	 * tradeMethods为2银行卡
	 */
	@Test
	public void postGetFaassetFlowListTestTradeMethodsIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 2);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradeMethods为2银行卡" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isIn("成功");
	}
	/**
	 * tradeMethods为3担保中间账户
	 */
	@Test
	public void postGetFaassetFlowListTestTradeMethodsIs3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 3);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradeMethods为3担保中间账户" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isIn("成功");
	}
	/**
	 * tradeMethods为4服务费余额
	 */
	@Test
	public void postGetFaassetFlowListTestTradeMethodsIs4() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 4);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradeMethods为4服务费余额" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isIn("成功");
	}
	/**
	 * tradeMethods为 5微信
	 */
	@Test
	public void postGetFaassetFlowListTestTradeMethodsIs5() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 5);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradeMethods为 5微信" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isIn("成功");
	}
	/**
	 * tradeMethods为不传
	 */
	@Test
	public void postGetFaassetFlowListTestTradeMethodsIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradeMethods为不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * accountName为最大值
	 */
	@Test
	public void postGetFaassetFlowListTestAccountNameIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 999999999);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountName为最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * accountName为空
	 */
	@Test
	public void postGetFaassetFlowListTestAccountNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", "");
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountName为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * accountName为空格
	 */
	@Test
	public void postGetFaassetFlowListTestAccountNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", " ");
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountName为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * accountName为null
	 */
	@Test
	public void postGetFaassetFlowListTestAccountNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", null);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountName为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * accountName为1现金账户
	 */
	@Test
	public void postGetFaassetFlowListTestAccountNameIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountName为1现金账户" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isIn("成功");
	}
	/**
	 * accountName为2保证金
	 */
	@Test
	public void postGetFaassetFlowListTestAccountNameIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 2);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountName为2保证金" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isIn("成功");
	}
	/**
	 * accountName为3服务费
	 */
	@Test
	public void postGetFaassetFlowListTestAccountNameIs3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 3);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountName为3服务费," + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isIn("成功");
	}
	/**
	 * accountName为4营销账户
	 */
	@Test
	public void postGetFaassetFlowListTestAccountNameIs4() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 4);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountName为4营销账户" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isIn("成功");
	}
	/**
	 * accountName为不传
	 */
	@Test
	public void postGetFaassetFlowListTestAccountNameIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountName为不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * moneyFlow为最大值
	 */
	@Test
	public void postGetFaassetFlowListTestMoneyFlowIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 999999999);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("moneyFlow为最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * moneyFlow为空
	 */
	@Test
	public void postGetFaassetFlowListTestMoneyFlowIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", "");
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("moneyFlow为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * moneyFlow为空格
	 */
	@Test
	public void postGetFaassetFlowListTestMoneyFlowIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", " ");
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("moneyFlow为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * moneyFlow为null
	 */
	@Test
	public void postGetFaassetFlowListTestMoneyFlowIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", null);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("moneyFlow为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * moneyFlow为不传
	 */
	@Test
	public void postGetFaassetFlowListTestMoneyFlowIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("moneyFlow为不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * accountType为最大值
	 */
	@Test
	public void postGetFaassetFlowListTestAccountTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 999999999);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountType为最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * accountType为空
	 */
	@Test
	public void postGetFaassetFlowListTestAccountTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", "");
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountType为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * accountType为空格
	 */
	@Test
	public void postGetFaassetFlowListTestAccountTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", " ");
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountType为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * accountType为null
	 */
	@Test
	public void postGetFaassetFlowListTestAccountTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", null);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountType为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * accountType不传
	 */
	@Test
	public void postGetFaassetFlowListTestAccountTypeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountType不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * accountType为1充值
	 */
	@Test
	public void postGetFaassetFlowListTestAccountTypeIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountType为1充值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isIn("成功");
	}
	/**
	 * accountType为2提现
	 */
	@Test
	public void postGetFaassetFlowListTestAccountTypeIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 2);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountType为2提现" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isIn("成功");
	}
	/**
	 * accountType为3付款
	 */
	@Test
	public void postGetFaassetFlowListTestAccountTypeIs3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 3);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountType为3付款" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isIn("成功");
	}
	/**
	 * accountType为4退款
	 */
	@Test
	public void postGetFaassetFlowListTestAccountTypeIs4() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 4);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountType为4退款" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isIn("成功");
	}
	/**
	 * accountType为5转出
	 */
	@Test
	public void postGetFaassetFlowListTestAccountTypeIs5() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 5);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountType为5转出" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isIn("成功");
	}
	/**
	 * accountType为6收款
	 */
	@Test
	public void postGetFaassetFlowListTestAccountTypeIs6() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 6);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountType为6收款" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isIn("成功");
	}
	/**
	 * accountType为7应收账款
	 */
	@Test
	public void postGetFaassetFlowListTestAccountTypeIs7() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 7);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountType为7应收账款" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isIn("成功");
	}
	/**
	 * tradeStatus为空
	 */
	@Test
	public void postGetFaassetFlowListTestTradeStatusIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", "");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradeStatus为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * tradeStatus为空格
	 */
	@Test
	public void postGetFaassetFlowListTestTradeStatusIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", " ");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradeStatus为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * tradeStatus为null
	 */
	@Test
	public void postGetFaassetFlowListTestTradeStatusIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", null);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradeStatus为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * tradeStatus不传
	 */
	@Test
	public void postGetFaassetFlowListTestTradeStatusIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradeStatus不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * tradeStatus为最大值
	 */
	@Test
	public void postGetFaassetFlowListTestTradeStatusIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 999999999);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradeStatus为最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * tradeStatus为0进行中
	 */
	@Test
	public void postGetFaassetFlowListTestTradeStatusIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 0);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradeStatus为0进行中" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isIn("成功");
	}
	/**
	 * tradeStatus为1操作成功
	 */
	@Test
	public void postGetFaassetFlowListTestTradeStatusIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradeStatus为1操作成功" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isIn("成功");
	}
	/**
	 * tradeStatus为2操作失败
	 */
	@Test
	public void postGetFaassetFlowListTestTradeStatusIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 2);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradeStatus为2操作失败" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isIn("成功");
	}
	/**
	 * beginTime传空
	 */
	@Test
	public void postGetFaassetFlowListTestBeginTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("beginTime传空" + post);

		assertThat(post.get("status")).isIn(1,-1);
		assertThat(post.get("msg")).isEqualTo("id为：999的角色不存在");
	}
	/**
	 * beginTime传空格
	 */
	@Test
	public void postGetFaassetFlowListTestBeginTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", " ");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("beginTime传空格" + post);

		assertThat(post.get("status")).isIn(1,-1);
		assertThat(post.get("msg")).isEqualTo("id为：1的角色不存在");
	}
	/**
	 * beginTime传null
	 */
	@Test
	public void postGetFaassetFlowListTestBeginTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", null);
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("beginTime传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * beginTime不传参数
	 */
	@Test
	public void postGetFaassetFlowListTestBeginTimeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("beginTime不传参数" + post);

		assertThat(post.get("status")).isEqualTo(400);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * beginTime传超长
	 */
	@Test
	public void postGetFaassetFlowListTestBeginTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "1231345431321326548787532135546546");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("beginTime不传参数" + post);

		assertThat(post.get("status")).isEqualTo(400);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * beginTime传最大值
	 */
	@Test
	public void postGetFaassetFlowListTestBeginTimeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "9999-12-31");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("beginTime传最大值" + post);

		assertThat(post.get("status")).isEqualTo(400);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * endTime传空
	 */
	@Test
	public void postGetFaassetFlowListTestEndTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id不能为空！");
	}
	/**
	 * endTime传空格
	 */
	@Test
	public void postGetFaassetFlowListTestEndTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", " ");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id不能为空！");
	}
	/**
	 * endTime传null
	 */
	@Test
	public void postGetFaassetFlowListTestEndTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", null);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime传null" + post);

		assertThat(post.get("status")).isEqualTo(400);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * endTime不传参数
	 */
	@Test
	public void postGetFaassetFlowListTestEndTimeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id不能为空！");
	}
	/**
	 * endTime传超长
	 */
	@Test
	public void postGetFaassetFlowListTestEndTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "1234567896563212345678946541321215479846543");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * endTime传最大值
	 */
	@Test
	public void postGetFaassetFlowListTestroleIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * pageSize传空
	 */
	@Test
	public void postGetFaassetFlowListTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
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
	public void postGetFaassetFlowListTestPageSizeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
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
	public void postGetFaassetFlowListTestPageSizeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
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
	public void postGetFaassetFlowListTestPageSizeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
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
	public void postGetFaassetFlowListTestPageSizeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
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
	public void postGetFaassetFlowListTestPageNowIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
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
	public void postGetFaassetFlowListTestPageNowIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
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
	public void postGetFaassetFlowListTestPageNowIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
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
	public void postGetFaassetFlowListTestPageNowIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
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
	public void postGetFaassetFlowListTestPageNowIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
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
	public void postGetFaassetFlowListTestWalletIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
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
	public void postGetFaassetFlowListTestWalletIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", "");
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
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
	public void postGetFaassetFlowListTestWalletIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", " ");
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
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
	public void postGetFaassetFlowListTestWalletIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", null);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
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
	public void postGetFaassetFlowListTestWalletIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 999999999999999999L);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传最大值
	 */
	@Test
	public void postGetFaassetFlowListTestEnterpriseIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 999999999999999999L);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传空
	 */
	@Test
	public void postGetFaassetFlowListTestEnterpriseIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", "");
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传空格
	 */
	@Test
	public void postGetFaassetFlowListTestEnterpriseIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", " ");
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传null
	 */
	@Test
	public void postGetFaassetFlowListTestEnterpriseIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", null);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId不传参数
	 */
	@Test
	public void postGetFaassetFlowListTestEnterpriseIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * type传null
	 */
	@Test
	public void postGetFaassetFlowListTestTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
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
	public void postGetFaassetFlowListTestTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
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
	public void postGetFaassetFlowListTestTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
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
	public void postGetFaassetFlowListTestTypeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
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
	public void postGetFaassetFlowListTestTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 24);
		request.put("enterpriseId", 19);
		request.put("tradeMethods", 1);
		request.put("accountName", 1);
		request.put("moneyFlow", 1);
		request.put("accountType", 1);
		request.put("tradeStatus", 1);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
}
