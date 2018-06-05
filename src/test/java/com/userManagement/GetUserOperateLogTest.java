package com.userManagement;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
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

		assertThat(post.get("status")).isEqualTo(0);
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

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 每页显示记录数为非法字符
	 */
	@Test
	public void postGetUserOperateLogTestPageSizeIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", "<.#$%>");
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录数为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 每页显示记录数为负数
	 */
	@Test
	public void postGetUserOperateLogTestPageSizeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", -1);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录数为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 每页显示记录数为String
	 */
	@Test
	public void postGetUserOperateLogTestPageSizeIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", "String");
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录数为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
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
		System.out.println("每页显示记录数为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
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
		System.out.println("每页显示记录数为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
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

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}/**
	 * 每页显示记录数为不传该参数
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
		System.out.println("每页显示记录数为不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}

	/**
	 * 当前页码为0
	 */
	@Test
	public void postGetUserOperateLogTestPageNowIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageNow", 0);
		request.put("pageSize", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 当前页码为小数
	 */
	@Test
	public void postGetUserOperateLogTestPageNowIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageNow", 1.4);
		request.put("pageSize", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 当前页码为非法字符
	 */
	@Test
	public void postGetUserOperateLogTestPageNowIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageNow", "<.#$%>");
		request.put("pageSize", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 当前页码为负数
	 */
	@Test
	public void postGetUserOperateLogTestPageNowIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageNow", -1);
		request.put("pageSize", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 当前页码为String
	 */
	@Test
	public void postGetUserOperateLogTestPageNowIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageNow", "String");
		request.put("pageSize", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 当前页码为空格
	 */
	@Test
	public void postGetUserOperateLogTestPageNowIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageNow", " ");
		request.put("pageSize", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 当前页码为空
	 */
	@Test
	public void postGetUserOperateLogTestPageNowIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageNow", "");
		request.put("pageSize", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 当前页码为null
	 */
	@Test
	public void postGetUserOperateLogTestPageNowIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageNow", null);
		request.put("pageSize", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}/**
	 * 当前页码为不传该参数
	 */
	@Test
	public void postGetUserOperateLogTestPageNowNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
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

		assertThat(post.get("status")).isEqualTo(0);
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

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 分类为string
	 */
	@Test
	public void postGetUserOperateLogTestCategoryIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", "aaa");
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("分类为String" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
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

		assertThat(post.get("status")).isEqualTo(0);
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

		assertThat(post.get("status")).isEqualTo(0);
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
		System.out.println("分类为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 分类为0
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
		System.out.println("分类为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 分类为1
	 */
	@Test
	public void postGetUserOperateLogTestCategoryIsOne() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 1);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("分类为1" + post);

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

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 用户登入账号未登录
	 */
	@Test
	public void postGetUserOperateLogTestUserNameNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登入账号未登录" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 用户登入账号错误
	 */
	@Test
	public void postGetUserOperateLogTestUserNameIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "adminqq");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登入账号错误" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 用户登入账号为空
	 */
	@Test
	public void postGetUserOperateLogTestUserNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登入账号为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 用户登入账号空格
	 */
	@Test
	public void postGetUserOperateLogTestUserNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", " ");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登入账号空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 用户登入账号为null
	 */
	@Test
	public void postGetUserOperateLogTestUserNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", null);
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登入账号为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 用户登入账号为非法字符
	 */
	@Test
	public void postGetUserOperateLogTestUserNameIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "<.@#$%^>");
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登入账号为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 用户登入账号为0
	 */
	@Test
	public void postGetUserOperateLogTestUserNameIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", 0);
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登入账号为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 用户登入账号为小数
	 */
	@Test
	public void postGetUserOperateLogTestUserNameIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", 1.5);
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登入账号为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 用户登入账号为负数
	 */
	@Test
	public void postGetUserOperateLogTestUserNameIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", -1);
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登入账号为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 用户登入账号不提交该参数
	 */
	@Test
	public void postGetUserOperateLogTestUserNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("realName", "admin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登入账号不提交该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 用户真实姓名错误
	 */
	@Test
	public void postGetUserOperateLogTestRealNameIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "adminaa");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户真实姓名错误" + post);

		assertThat(post.get("status")).isEqualTo(0);
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

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 用户真实姓名空格
	 */
	@Test
	public void postGetUserOperateLogTestRealNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", " ");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户真实姓名空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 用户真实姓名为0
	 */
	@Test
	public void postGetUserOperateLogTestRealNameIsZreo() throws Exception {
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

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 用户真实姓名小数
	 */
	@Test
	public void postGetUserOperateLogTestRealNameIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", 1.1);
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户真实姓名小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 用户真实姓名负数
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
		System.out.println("用户真实姓名负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
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

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 用户真实姓名非法字符
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
		System.out.println("用户真实姓名非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 用户真实姓名超长
	 */
	@Test
	public void postGetUserOperateLogTestRealNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "adminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadminadmin");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户真实姓名超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 用户真实姓名不传该参数
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
		System.out.println("用户真实姓名不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
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
		request.put("operateStartTime", "201A8-0a5-0A3");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作开始时间传错误格式" + post);

		assertThat(post.get("status")).isEqualTo(0);
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
		request.put("operateStartTime", "1525327856000");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作开始时间传时间戳" + post);

		assertThat(post.get("status")).isEqualTo(0);
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
	public void postGetUserOperateLogTestOperateStartTime() throws Exception {
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

		assertThat(post.get("status")).isEqualTo(0);
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

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 操作开始时间去掉中间格式
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
		System.out.println("操作开始时间去掉中间格式" + post);

		assertThat(post.get("status")).isEqualTo(0);
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

		assertThat(post.get("status")).isEqualTo(0);
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
		request.put("operateStartTime", "null");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作开始时间传null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 操作开始时间传负数传年月日最大值
	 */
	@Test
	public void postGetUserOperateLogTestOperateStartTimeYMDISMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateStartTime", "9999-12-31");
		request.put("operateEndTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作开始时间传负数传年月日最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 操作开始时间传年月日最小值
	 */
	@Test
	public void postGetUserOperateLogTestOperateStartTimeYMDISMin() throws Exception {
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

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 操作开始时间传时分秒最大时间
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
		System.out.println("操作开始时间传时分秒最大时间" + post);

		assertThat(post.get("status")).isEqualTo(0);
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
		System.out.println("操作开始时间" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 操作开始时间传年月日时分秒
	 */
	@Test
	public void postGetUserOperateLogTestOperateStartTimeIsYYYYMMDDHHMMSS() throws Exception {
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

		assertThat(post.get("status")).isEqualTo(0);
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
		System.out.println("操作开始时间" + post);

		assertThat(post.get("status")).isEqualTo(0);
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
		request.put("operateEndTime", "201A8-0a5-0A3");
		request.put("operateStartTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作结束时间传错误格式" + post);

		assertThat(post.get("status")).isEqualTo(0);
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
		request.put("operateEndTime", "1525327856000");
		request.put("operateStartTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作结束时间传时间戳" + post);

		assertThat(post.get("status")).isEqualTo(0);
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
	public void postGetUserOperateLogTestOperateEndTime() throws Exception {
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

		assertThat(post.get("status")).isEqualTo(0);
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

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 操作结束时间去掉中间格式
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
		System.out.println("操作结束时间去掉中间格式" + post);

		assertThat(post.get("status")).isEqualTo(0);
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

		assertThat(post.get("status")).isEqualTo(0);
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
		request.put("operateEndTime", "null");
		request.put("operateStartTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作结束时间传null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 操作结束时间传负数传年月日最大值
	 */
	@Test
	public void postGetUserOperateLogTestOperateEndTimeYMDISMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("category", 0);
		request.put("userName", "admin");
		request.put("realName", "admin");
		request.put("operateEndTime", "9999-12-31");
		request.put("operateStartTime", "2018-05-29");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作结束时间传负数传年月日最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 操作结束时间传年月日最小值
	 */
	@Test
	public void postGetUserOperateLogTestOperateEndTimeYMDISMin() throws Exception {
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

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 操作结束时间传时分秒最大时间
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
		System.out.println("操作结束时间传时分秒最大时间" + post);

		assertThat(post.get("status")).isEqualTo(0);
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
		System.out.println("操作结束时间" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 操作结束时间传年月日时分秒
	 */
	@Test
	public void postGetUserOperateLogTestOperateEndTimeIsYYYYMMDDHHMMSS() throws Exception {
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

		assertThat(post.get("status")).isEqualTo(0);
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
		System.out.println("操作结束时间" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}

	
}