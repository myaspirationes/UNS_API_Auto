package com.publicModule.systemManagement;

import com.example.HttpUtil;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class GetUserOperateLogTest extends HttpUtil {
// 搜索获取日志列表接口
	String url = "/uu-admin/BackUser/getUserOperateLog";

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetUserOperateLogTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * 每页显示记录数为0
	 */
	@Test
	public void postGetUserOperateLogTestPageSizeIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 0);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录数为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录数为小数
	 */
	@Test
	public void postGetUserOperateLogTestPageSizeIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 1.4);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录数为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录数为非法字符
	 */
	@Test
	public void postGetUserOperateLogTestPageSizeIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", "<.$%^&>");
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录数为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 每页显示记录数为负数
	 */
	@Test
	public void postGetUserOperateLogTestPageSizeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", -10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录数为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录数为String
	 */
	@Test
	public void postGetUserOperateLogTestPageSizeIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", "pageSize");
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录数为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 每页显示记录数为空格
	 */
	@Test
	public void postGetUserOperateLogTestPageSizeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", " ");
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录数为空格" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 每页显示记录数为空
	 */
	@Test
	public void postGetUserOperateLogTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", "");
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录数为空" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 每页显示记录数为null
	 */
	@Test
	public void postGetUserOperateLogTestPageSizeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", null);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录数为null" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 每页显示记录数不传该参数
	 */
	@Test
	public void postGetUserOperateLogTestPageSizeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录数不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 当前页码为0
	 */
	@Test
	public void postGetUserOperateLogTestPageNowIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 0);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页码传负数
	 */
	@Test
	public void postGetUserOperateLogTestPageNowIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", -1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码传负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页码传小数
	 */
	@Test
	public void postGetUserOperateLogTestPageNowIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1.5);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码传小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页码传String
	 */
	@Test
	public void postGetUserOperateLogTestPageNowIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", "pageNow");
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码传String" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 当前页码为空
	 */
	@Test
	public void postGetUserOperateLogTestPageNowIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", "");
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为空" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 当前页码为空格
	 */
	@Test
	public void postGetUserOperateLogTestPageNowIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", " ");
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为空格" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 当前页码为null
	 */
	@Test
	public void postGetUserOperateLogTestPageNowIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", null);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为null" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 当前页码为最大值
	 */
	@Test
	public void postGetUserOperateLogTestPageNowIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1999999999);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页码不传该参数
	 */
	@Test
	public void postGetUserOperateLogTestPageNowNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 分类为小数
	 */
	@Test
	public void postGetUserOperateLogTestCategoryIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 1.3);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("分类为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 分类为负数
	 */
	@Test
	public void postGetUserOperateLogTestCategoryIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", -1);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("分类为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 分类为String
	 */
	@Test
	public void postGetUserOperateLogTestCategoryIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", "String");
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("分类为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 分类为空
	 */
	@Test
	public void postGetUserOperateLogTestCategoryIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", "");
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("分类为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 分类为空格
	 */
	@Test
	public void postGetUserOperateLogTestCategoryIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", " ");
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("分类为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 分类为null
	 */
	@Test
	public void postGetUserOperateLogTestCategoryIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", null);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("分类" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 分类传0操作日志
	 */
	@Test
	public void postGetUserOperateLogTestCategoryIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("分类传0操作日志" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 分类传1业务日志
	 */
	@Test
	public void postGetUserOperateLogTestCategoryIsOne() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("分类传1业务日志" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 分类传-1全部日志
	 */
	@Test
	public void postGetUserOperateLogTestCategoryIsNegative() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", -1);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("分类传-1全部日志" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 分类不传该参数
	 */
	@Test
	public void postGetUserOperateLogTestCategoryNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("分类不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户登录账号为未登录账号
	 */
	@Test
	public void postGetUserOperateLogTestuserNameNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登录账号为未登录账号" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户登录账号错误用户名
	 */
	@Test
	public void postGetUserOperateLogTestuserNameIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admina");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登录账号错误用户名" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户登录账号为空
	 */
	@Test
	public void postGetUserOperateLogTestuserNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登录账号为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户登录账号为空格
	 */
	@Test
	public void postGetUserOperateLogTestuserNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", " ");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登录账号为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户登录账号为null
	 */
	@Test
	public void postGetUserOperateLogTestuserNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", null);
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登录账号为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户登录账号为非法字符串
	 */
	@Test
	public void postGetUserOperateLogTestuserNameIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "<.#$%>");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登录账号为非法字符串" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户登录账号为0
	 */
	@Test
	public void postGetUserOperateLogTestuserNameIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", 0);
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登录账号为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户登录账号为小数
	 */
	@Test
	public void postGetUserOperateLogTestuserNameIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", 1.5);
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登录账号为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户登录账号为负数
	 */
	@Test
	public void postGetUserOperateLogTestuserNameIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", -1);
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登录账号为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户登录账号不传该参数
	 */
	@Test
	public void postGetUserOperateLogTestuserNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登录账号不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户真实姓名为错误
	 */
	@Test
	public void postGetUserOperateLogTestRealNameIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "adminw");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户真实姓名为错误" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户真实姓名为空
	 */
	@Test
	public void postGetUserOperateLogTestRealNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户真实姓名为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户真实姓名为空格
	 */
	@Test
	public void postGetUserOperateLogTestRealNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", " ");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户真实姓名为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户真实姓名为0
	 */
	@Test
	public void postGetUserOperateLogTestRealNameIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", 0);
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户真实姓名为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户真实姓名为小数
	 */
	@Test
	public void postGetUserOperateLogTestRealNameIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", 1.4);
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户真实姓名为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户真实姓名为负数
	 */
	@Test
	public void postGetUserOperateLogTestRealNameIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", -1);
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户真实姓名为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户真实姓名为null
	 */
	@Test
	public void postGetUserOperateLogTestRealNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", null);
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户真实姓名为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户真实姓名为非法字符
	 */
	@Test
	public void postGetUserOperateLogTestRealNameIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "<.$%^>");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户真实姓名为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户真实姓名为超长
	 */
	@Test
	public void postGetUserOperateLogTestRealNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "adminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadmin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户真实姓名为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户真实姓名为不传该参数
	 */
	@Test
	public void postGetUserOperateLogTestRealNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户真实姓名为不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * 操作开始时间传错误格式
	 */
	@Test
	public void postGetUserOperateLogTestOperateStartTimeIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "201805-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作开始时间传错误格式" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作开始时间大于结束时间
	 */
	@Test
	public void postGetUserOperateLogTestOperateStartTimeGreaterThanOperateEndTime() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2020-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作开始时间大于结束时间" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作开始时间传时间戳
	 */
	@Test
	public void postGetUserOperateLogTestOperateStartTimeIsTimeStamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "1528248480000");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作开始时间传时间戳" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作开始时间传年月日
	 */
	@Test
	public void postGetUserOperateLogTestOperateStartTimeIsYYYYMMDD() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作开始时间传年月日" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作开始时间传时分秒
	 */
	@Test
	public void postGetUserOperateLogTestOperateStartTimeIsHHMMSS() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "13:13:13");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作开始时间传时分秒" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作开始时间传空格
	 */
	@Test
	public void postGetUserOperateLogTestOperateStartTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", " ");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作开始时间传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作开始时间去掉格式
	 */
	@Test
	public void postGetUserOperateLogTestOperateStartTimeRemoveTheFormat() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "20180503");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作开始时间去掉格式" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作开始时间为空
	 */
	@Test
	public void postGetUserOperateLogTestOperateStartTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作开始时间为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作开始时间传null
	 */
	@Test
	public void postGetUserOperateLogTestOperateStartTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", null);
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作开始时间传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作开始时间传负数
	 */
	@Test
	public void postGetUserOperateLogTestOperateStartTimeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", -1);
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作开始时间传负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作开始时间传年月日最大值
	 */
	@Test
	public void postGetUserOperateLogTestOperateStartTimeYMDIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "9999-12-31");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作开始时间传年月日最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作开始时间传年月日最小值
	 */
	@Test
	public void postGetUserOperateLogTestOperateStartTimeIsMin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "0000-01-01");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作开始时间传年月日最小值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作开始时间传时分秒最大值
	 */
	@Test
	public void postGetUserOperateLogTestOperateStartTimeHMSIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "23:59:59");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作开始时间传时分秒最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作开始时间传时分秒最小值
	 */
	@Test
	public void postGetUserOperateLogTestOperateStartTimeHMSIsMin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "00:00:00");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作开始时间传时分秒最小值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作开始时间传年月日时分秒
	 */
	@Test
	public void postGetUserOperateLogTestOperateStartTimeIsYMDHMS() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03 13:13:13");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作开始时间传年月日时分秒" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作开始时间不传该参数
	 */
	@Test
	public void postGetUserOperateLogTestOperateStartTimeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作开始时间不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作开始时间闰年2月
	 */
	@Test
	public void postGetUserOperateLogTestOperateStartTimeIsLeapYear() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2016-02-29");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作开始时间闰年2月" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作开始时间非论年2月
	 */
	@Test
	public void postGetUserOperateLogTestOperateStartTimeNonLeapYear() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-02-29");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作开始时间非论年2月" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作结束时间传错误格式
	 */
	@Test
	public void postGetUserOperateLogTestOperateEndTimeIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateEndTime", "201805-03");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作结束时间传错误格式" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * 操作结束时间传时间戳
	 */
	@Test
	public void postGetUserOperateLogTestOperateEndTimeIsTimeStamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "1528248480000");
		request.put("operateEndTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作结束时间传时间戳" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作结束时间传年月日
	 */
	@Test
	public void postGetUserOperateLogTestOperateEndTimeIsYYYYMMDD() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateEndTime", "2018-05-03");
		request.put("operateStartTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作结束时间传年月日" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作结束时间传时分秒
	 */
	@Test
	public void postGetUserOperateLogTestOperateEndTimeIsHHMMSS() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateEndTime", "13:13:13");
		request.put("operateStartTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作结束时间传时分秒" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作结束时间传空格
	 */
	@Test
	public void postGetUserOperateLogTestOperateEndTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateEndTime", " ");
		request.put("operateStartTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作结束时间传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作结束时间去掉格式
	 */
	@Test
	public void postGetUserOperateLogTestOperateEndTimeRemoveTheFormat() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateEndTime", "20180503");
		request.put("operateStartTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作结束时间去掉格式" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作结束时间为空
	 */
	@Test
	public void postGetUserOperateLogTestOperateEndTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateEndTime", "");
		request.put("operateStartTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作结束时间为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作结束时间传null
	 */
	@Test
	public void postGetUserOperateLogTestOperateEndTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateEndTime", null);
		request.put("operateStartTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作结束时间传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作结束时间传负数
	 */
	@Test
	public void postGetUserOperateLogTestOperateEndTimeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateEndTime", -1);
		request.put("operateStartTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作结束时间传负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作结束时间传年月日最大值
	 */
	@Test
	public void postGetUserOperateLogTestOperateEndTimeYMDIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateEndTime", "9999-12-31");
		request.put("operateStartTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作结束时间传年月日最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作结束时间传年月日最小值
	 */
	@Test
	public void postGetUserOperateLogTestOperateEndTimeIsMin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateEndTime", "0000-01-01");
		request.put("operateStartTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作结束时间传年月日最小值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作结束时间传时分秒最大值
	 */
	@Test
	public void postGetUserOperateLogTestOperateEndTimeHMSIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateEndTime", "23:59:59");
		request.put("operateStartTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作结束时间传时分秒最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作结束时间传时分秒最小值
	 */
	@Test
	public void postGetUserOperateLogTestOperateEndTimeHMSIsMin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateEndTime", "00:00:00");
		request.put("operateStartTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作结束时间传时分秒最小值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作结束时间传年月日时分秒
	 */
	@Test
	public void postGetUserOperateLogTestOperateEndTimeIsYMDHMS() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateEndTime", "2018-05-03 13:13:13");
		request.put("operateStartTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作结束时间传年月日时分秒" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作结束时间不传该参数
	 */
	@Test
	public void postGetUserOperateLogTestOperateEndTimeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作结束时间不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作结束时间闰年2月
	 */
	@Test
	public void postGetUserOperateLogTestOperateEndTimeIsLeapYear() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateEndTime", "2016-02-29");
		request.put("operateStartTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作结束时间闰年2月" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作结束时间非论年2月
	 */
	@Test
	public void postGetUserOperateLogTestOperateEndTimeNonLeapYear() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateEndTime", "2018-02-29");
		request.put("operateStartTime", "2018-05-29");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作结束时间非论年2月" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

}
