package com.webShopWallet.LogsManagement;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class GetOperationRecordListTest extends HttpUtil {
// 获取操作日志列表接口
	String url = "/wallet-admin/operationRecord/getOperationRecordList";


	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetOperationRecordListTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 6);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 12491671);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 999999999999999999L);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * beginTime传空
	 */
	@Test
	public void postGetOperationRecordListTestBeginTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "");
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
	public void postGetOperationRecordListTestBeginTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", " ");
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
	public void postGetOperationRecordListTestBeginTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", null);
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
	public void postGetOperationRecordListTestBeginTimeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
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
	public void postGetOperationRecordListTestBeginTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "13245678454321213121345123456789");
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
	public void postGetOperationRecordListTestBeginTimeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "9999-12-31");
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
	public void postGetOperationRecordListTestEndTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestEndTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestEndTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestEndTimeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestEndTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "13456789123546789123456789");
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
	public void postGetOperationRecordListTestroleIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestPageSizeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestPageSizeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestPageSizeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestPageSizeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestPageNowIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestPageNowIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestPageNowIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestPageNowIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestPageNowIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestWalletIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestWalletIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", "");
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestWalletIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", " ");
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestWalletIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", null);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestWalletIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 999999999999999999L);
		request.put("enterpriseId", 1);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestEnterpriseIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 999999999999999999L);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestEnterpriseIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", "");
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestEnterpriseIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", " ");
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestEnterpriseIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", null);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
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
	public void postGetOperationRecordListTestEnterpriseIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("operationAccount", 1);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * operationAccount传null
	 */
	@Test
	public void postGetOperationRecordListTestOperationAccountIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("operationAccount", null);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operationAccount传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * operationAccount传空
	 */
	@Test
	public void postGetOperationRecordListTestOperationAccountIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("operationAccount", "");
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operationAccount传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * operationAccount传空格
	 */
	@Test
	public void postGetOperationRecordListTestOperationAccountIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("operationAccount", " ");
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operationAccount传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * operationAccount不传
	 */
	@Test
	public void postGetOperationRecordListTestOperationAccountIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operationAccount不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * operationAccount传最大值
	 */
	@Test
	public void postGetOperationRecordListTestOperationAccountIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("operationAccount", 999999999999999999L);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operationAccount传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
}
