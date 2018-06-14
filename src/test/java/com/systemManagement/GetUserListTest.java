package com.systemManagement;

import com.example.HttpUtil;
import com.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class GetUserListTest extends HttpUtil {
// 获取系统用户列表接口
	String url = "/uu-admin/SystemManager/getUserList";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId = new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetUserListTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "张");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID未登录
	 */
	@Test
	public void postGetUserListTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495323);
		request.put("userName", "张");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID未登录" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为错误ID
	 */
	@Test
	public void postGetUserListTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 95323);
		request.put("userName", "张");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误ID" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postGetUserListTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<$%^>");
		request.put("userName", "张");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postGetUserListTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1249.5323);
		request.put("userName", "张");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postGetUserListTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -12495323);
		request.put("userName", "张");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postGetUserListTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);
		request.put("userName", "张");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postGetUserListTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "AAA");
		request.put("userName", "张");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postGetUserListTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("userName", "张");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
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
	public void postGetUserListTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("userName", "张");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
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
	public void postGetUserListTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("userName", "张");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
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
	public void postGetUserListTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userName", "张");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 角色名称超长
	 */
	@Test
	public void postGetUserListTestuserNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色名称超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色名称为非法字符
	 */
	@Test
	public void postGetUserListTestuserNameIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "<.#$%>");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色名称为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色名称为null
	 */
	@Test
	public void postGetUserListTestuserNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", null);
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色名称为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户名称不能为空！");
	}
	/**
	 * 角色名称为空
	 */
	@Test
	public void postGetUserListTestuserNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色名称为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色名称为空格
	 */
	@Test
	public void postGetUserListTestuserNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", " ");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色名称为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色名称不传该参数
	 */
	@Test
	public void postGetUserListTestuserNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色名称不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户名称不能为空！");
	}
	/**
	 * 创建时间为超长
	 */
	@Test
	public void postGetUserListTestCreatTimeStartIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "191111111912-028-026 1222:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 创建时间为大于结束时间
	 */
	@Test
	public void postGetUserListTestCreatTimeStartGreaterThanCreatTimeEnd() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "2019-07-12 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建时间为时间戳
	 */
	@Test
	public void postGetUserListTestCreatTimeStartIsTimeStamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1529338959000");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建时间为时间戳" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 创建时间为空
	 */
	@Test
	public void postGetUserListTestCreatTimeStartIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建时间为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建时间为空格
	 */
	@Test
	public void postGetUserListTestCreatTimeStartIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", " ");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建时间为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建时间为null
	 */
	@Test
	public void postGetUserListTestCreatTimeStartIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", null);
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建时间为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建时间不传该参数
	 */
	@Test
	public void postGetUserListTestCreatTimeStartNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建时间不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建时间为年月日
	 */
	@Test
	public void postGetUserListTestCreatTimeStartIsYYYYMMDD() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "2018-07-06");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建时间为年月日" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 创建时间为时分秒
	 */
	@Test
	public void postGetUserListTestCreatTimeStartIsHHMMSS() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建时间为时分秒" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 创建时间为0
	 */
	@Test
	public void postGetUserListTestCreatTimeStartIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", 0);
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建时间为时分秒" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}


	/**
	 * 结束时间为超长
	 */
	@Test
	public void postGetUserListTestCreatTimeEndIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeEnd", "191111111912-028-026 1222:13:14");
		request.put("creatTimeStart", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}

	/**
	 * 结束时间为时间戳
	 */
	@Test
	public void postGetUserListTestCreatTimeEndIsTimeStamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeEnd", "1529338959000");
		request.put("creatTimeStart", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间为时间戳" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 结束时间为空
	 */
	@Test
	public void postGetUserListTestCreatTimeEndIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeEnd", "");
		request.put("creatTimeStart", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 结束时间为空格
	 */
	@Test
	public void postGetUserListTestCreatTimeEndIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeEnd", " ");
		request.put("creatTimeStart", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 结束时间为null
	 */
	@Test
	public void postGetUserListTestCreatTimeEndIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeEnd", null);
		request.put("creatTimeStart", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 结束时间不传该参数
	 */
	@Test
	public void postGetUserListTestCreatTimeEndNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 结束时间为年月日
	 */
	@Test
	public void postGetUserListTestCreatTimeEndIsYYYYMMDD() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeEnd", "2018-07-06");
		request.put("creatTimeStart", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间为年月日" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 结束时间为时分秒
	 */
	@Test
	public void postGetUserListTestCreatTimeEndIsHHMMSS() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeEnd", "12:13:14");
		request.put("creatTimeStart", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间为时分秒" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 结束时间为0
	 */
	@Test
	public void postGetUserListTestCreatTimeEndIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeEnd", 0);
		request.put("creatTimeStart", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间为时分秒" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	
	
	/**
	 * 账号为超长
	 */
	@Test
	public void postGetUserListTestAccountIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", 99999999999999999L);
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账号为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 账号为非法字符
	 */
	@Test
	public void postGetUserListTestAccountIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "<.@#$%>");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账号为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 账号为错误
	 */
	@Test
	public void postGetUserListTestAccountIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", 123456);
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账号为错误" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 账号为空
	 */
	@Test
	public void postGetUserListTestAccountIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账号为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 账号为空格
	 */
	@Test
	public void postGetUserListTestAccountIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", " ");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账号为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 账号为String
	 */
	@Test
	public void postGetUserListTestAccountIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账号为String" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 账号为null
	 */
	@Test
	public void postGetUserListTestAccountIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", null);
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账号为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 账号不传该参数
	 */
	@Test
	public void postGetUserListTestAccountNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账号不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 账号为小数
	 */
	@Test
	public void postGetUserListTestAccountIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", 0.8);
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账号为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 账号为负数
	 */
	@Test
	public void postGetUserListTestAccountIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", -1);
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账号为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 账号名称为0
	 */
	@Test
	public void postGetUserListTestAccountIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", 0);
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账号名称为0" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	
	/**
	 * 角色状态为超长
	 */
	@Test
	public void postGetUserListTestStatusIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 99999999999999999L);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 角色状态为非法字符
	 */
	@Test
	public void postGetUserListTestStatusIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", "<.@%$^>");
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 角色状态为错误
	 */
	@Test
	public void postGetUserListTestStatusIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 9999);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为错误" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色状态为空
	 */
	@Test
	public void postGetUserListTestStatusIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", "");
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色状态为空格
	 */
	@Test
	public void postGetUserListTestStatusIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", " ");
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色状态为String
	 */
	@Test
	public void postGetUserListTestStatusIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", "aa");
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为String" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 角色状态为null
	 */
	@Test
	public void postGetUserListTestStatusIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", null);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色状态不传该参数
	 */
	@Test
	public void postGetUserListTestStatusNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色状态为小数
	 */
	@Test
	public void postGetUserListTestStatusIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2.9);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色状态为负数
	 */
	@Test
	public void postGetUserListTestStatusIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", -2);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色状态名称为0
	 */
	@Test
	public void postGetUserListTestStatusIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 0);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态名称为0" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录集为负数
	 */
	@Test
	public void postGetUserListTestPageSizeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", -1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 每页显示记录集为小数
	 */
	@Test
	public void postGetUserListTestPageSizeIsIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 1.1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录集为String
	 */
	@Test
	public void postGetUserListTestPageSizeIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", "aaa");
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 每页显示记录集为空格
	 */
	@Test
	public void postGetUserListTestPageSizeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", " ");
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("每页获取的条数不能为空！");
	}
	/**
	 * 每页显示记录集为空
	 */
	@Test
	public void postGetUserListTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", "");
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("每页获取的条数不能为空！");
	}
	/**
	 * 每页显示记录集为null
	 */
	@Test
	public void postGetUserListTestPageSizeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", null);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("每页获取的条数不能为空！");
	}
	/**
	 * 每页显示记录集为超长
	 */
	@Test
	public void postGetUserListTestPageSizeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", -1);
		request.put("pageNow", 1111111111111111111L);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集为超长" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 每页显示记录集不传该参数
	 */
	@Test
	public void postGetUserListTestPageSizeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("每页获取的条数不能为空！");
	}
	/**
	 * 每页显示记录集为0
	 */
	@Test
	public void postGetUserListTestPageSizeIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 0);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集为0" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	
	/**
	 * 当前页数为负数
	 */
	@Test
	public void postGetUserListTestPageNowIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageNow", -1);
		request.put("pageSize", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为负数" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 当前页数为小数
	 */
	@Test
	public void postGetUserListTestPageNowIsIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageNow", 1.1);
		request.put("pageSize", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页数为String
	 */
	@Test
	public void postGetUserListTestPageNowIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageNow", "aaa");
		request.put("pageSize", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 当前页数为空格
	 */
	@Test
	public void postGetUserListTestPageNowIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageNow", " ");
		request.put("pageSize", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("当前请求第几页不能为空！");
	}
	/**
	 * 当前页数为空
	 */
	@Test
	public void postGetUserListTestPageNowIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageNow", "");
		request.put("pageSize", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("当前请求第几页不能为空！");
	}
	/**
	 * 当前页数为null
	 */
	@Test
	public void postGetUserListTestPageNowIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageNow", null);
		request.put("pageSize", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("当前请求第几页不能为空！");
	}
	/**
	 * 当前页数为超长
	 */
	@Test
	public void postGetUserListTestPageNowIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageNow", -1);
		request.put("pageSize", 1111111111111111111L);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为超长" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 当前页数不传该参数
	 */
	@Test
	public void postGetUserListTestPageNowNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageSize", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("当前请求第几页不能为空！");
	}
	/**
	 * 当前页数为0
	 */
	@Test
	public void postGetUserListTestPageNowIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("account", "lingfeng");
		request.put("status", 2);
		request.put("pageNow", 0);
		request.put("pageSize", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为0" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
}