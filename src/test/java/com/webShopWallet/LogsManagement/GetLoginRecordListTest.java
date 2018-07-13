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

public class GetLoginRecordListTest extends HttpUtil {
// 获取登录日志列表接口
	String url = "/wallet-admin/loginRecord/getLoginRecordList";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetLoginRecordListTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 999999999999999999L);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestBeginTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestBeginTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestBeginTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestBeginTimeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestBeginTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestBeginTimeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestEndTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestEndTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestEndTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestEndTimeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestEndTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestroleIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestPageSizeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestPageSizeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestPageSizeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestPageSizeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestPageNowIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestPageNowIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestPageNowIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestPageNowIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestPageNowIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestWalletIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestWalletIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", "");
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestWalletIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", " ");
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestWalletIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", null);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestWalletIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 999999999999999999L);
		request.put("enterpriseId", 1);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestEnterpriseIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 999999999999999999L);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestEnterpriseIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", "");
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestEnterpriseIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", " ");
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestEnterpriseIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", null);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	public void postGetLoginRecordListTestEnterpriseIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("loginAccount", 1);
		request.put("operateType", 1);
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
	 * loginAccount传null
	 */
	@Test
	public void postGetLoginRecordListTestLoginAccountIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("loginAccount", null);
		request.put("operateType", 1);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("loginAccount传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * loginAccount传空
	 */
	@Test
	public void postGetLoginRecordListTestLoginAccountIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("loginAccount", "");
		request.put("operateType", 1);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("loginAccount传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * loginAccount传空格
	 */
	@Test
	public void postGetLoginRecordListTestLoginAccountIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("loginAccount", " ");
		request.put("operateType", 1);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("loginAccount传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * loginAccount不传
	 */
	@Test
	public void postGetLoginRecordListTestLoginAccountIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("operateType", 1);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("loginAccount不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * loginAccount传最大值
	 */
	@Test
	public void postGetLoginRecordListTestLoginAccountIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("loginAccount", 999999999999999999L);
		request.put("operateType", 1);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("loginAccount传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * operateType传最大值
	 */
	@Test
	public void postGetLoginRecordListTestOperateTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("loginAccount", 1);
		request.put("operateType", 999999999999999999L);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operateType传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * operateType传空
	 */
	@Test
	public void postGetLoginRecordListTestOperateTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("loginAccount", 1);
		request.put("operateType", "");
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operateType传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * operateType传空格
	 */
	@Test
	public void postGetLoginRecordListTestOperateTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("loginAccount", 1);
		request.put("operateType", " ");
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operateType传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * operateType传null
	 */
	@Test
	public void postGetLoginRecordListTestOperateTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("loginAccount", 1);
		request.put("operateType", null);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operateType传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * operateType不传
	 */
	@Test
	public void postGetLoginRecordListTestOperateTypeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("loginAccount", 1);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operateType不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
}
