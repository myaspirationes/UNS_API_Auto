package com.webOperateWallet.checkingManagement;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class ExportAccountDetailListTest extends HttpUtil {
// 导出对账明细列表接口
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
	public void postExportAccountDetailListTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestBeginTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "");
		request.put("endTime", "2018-10-10");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestBeginTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", " ");
		request.put("endTime", "2018-10-10");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestBeginTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", null);
		request.put("endTime", "2018-10-10");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestBeginTimeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("endTime", "2018-10-10");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestBeginTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "12123111214555555555555555555555555555555");
		request.put("endTime", "2018-10-10");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestBeginTimeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "9999-12-31");
		request.put("endTime", "2018-10-10");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestEndTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestEndTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", " ");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestEndTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", null);
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestEndTimeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestEndTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "213346554541222222222222222222222222222");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestroleIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestPageSizeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestPageSizeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestPageSizeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestPageSizeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
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
	public void postExportAccountDetailListTestPageNowIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestPageNowIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestPageNowIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestPageNowIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
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
	public void postExportAccountDetailListTestPageNowIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageNow不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * checkId不传参数
	 */
	@Test
	public void postExportAccountDetailListTestCheckIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("checkId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * checkId传空
	 */
	@Test
	public void postExportAccountDetailListTestCheckIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", "");
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("checkId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * checkId传空格
	 */
	@Test
	public void postExportAccountDetailListTestCheckIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", " ");
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("checkId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * checkId传null
	 */
	@Test
	public void postExportAccountDetailListTestCheckIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", null);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("checkId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * checkId传超长
	 */
	@Test
	public void postExportAccountDetailListTestCheckIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 999999999999999999L);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("checkId传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * WDId传超长
	 */
	@Test
	public void postExportAccountDetailListTestWDIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 999999999999999999L);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("WDId传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * WDId传空
	 */
	@Test
	public void postExportAccountDetailListTestWDIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", "");
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("WDId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * WDId传空格
	 */
	@Test
	public void postExportAccountDetailListTestWDIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", " ");
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("WDId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * WDId传null
	 */
	@Test
	public void postExportAccountDetailListTestWDIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", null);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("WDId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * WDId不传参数
	 */
	@Test
	public void postExportAccountDetailListTestWDIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("WDId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * feedback传null
	 */
	@Test
	public void postExportAccountDetailListTestFeedbackIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", null);
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("feedback传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * feedback传空
	 */
	@Test
	public void postExportAccountDetailListTestFeedbackIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("feedback传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * feedback传空格
	 */
	@Test
	public void postExportAccountDetailListTestFeedbackIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", " ");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("feedback传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * feedback不传参数
	 */
	@Test
	public void postExportAccountDetailListTestFeedbackIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("feedback不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * feedback传超长
	 */
	@Test
	public void postExportAccountDetailListTestFeedbackIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "djjhfjd回家后的花费很多考生飞机开始扩建恢复了的复活节酷酷酷酷酷酷酷酷酷发货的急急急急急急急急急");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2222");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("feedback传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * tradeNo传超长
	 */
	@Test
	public void postExportAccountDetailListTestTradeNoIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "11111321455555555555212333333333333333333334");
		request.put("YSBTradeNo", "2222");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradeNo传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * tradeNo传空
	 */
	@Test
	public void postExportAccountDetailListTestTradeNoIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "");
		request.put("YSBTradeNo", "2222");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradeNo传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * tradeNo传空格
	 */
	@Test
	public void postExportAccountDetailListTestTradeNoIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", " ");
		request.put("YSBTradeNo", "2222");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradeNo传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * tradeNo传null
	 */
	@Test
	public void postExportAccountDetailListTestTradeNoIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", null);
		request.put("YSBTradeNo", "2222");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradeNo传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * tradeNo不传参数
	 */
	@Test
	public void postExportAccountDetailListTestTradeNoIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("YSBTradeNo", "2222");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("tradeNo不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * YSBTradeNo传null
	 */
	@Test
	public void postExportAccountDetailListTestYSBTradeNoIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", null);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("YSBTradeNo传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * YSBTradeNo传空
	 */
	@Test
	public void postExportAccountDetailListTestYSBTradeNoIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("YSBTradeNo传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * YSBTradeNo传空格
	 */
	@Test
	public void postExportAccountDetailListTestYSBTradeNoIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", " ");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("YSBTradeNo传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * YSBTradeNo不传参数
	 */
	@Test
	public void postExportAccountDetailListTestYSBTradeNoIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("YSBTradeNo不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * YSBTradeNo传超长
	 */
	@Test
	public void postExportAccountDetailListTestYSBTradeNoIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("checkId", 123);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("WDId", 12495396);
		request.put("feedback", "自动化测试");
		request.put("tradeNo", "1111");
		request.put("YSBTradeNo", "2324534564543213213455412311312131324542121");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("YSBTradeNo传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
}
