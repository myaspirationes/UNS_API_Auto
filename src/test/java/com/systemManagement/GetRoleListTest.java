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

public class GetRoleListTest extends HttpUtil {
// 搜索获取角色列表接口
	String url = "/uu-admin/SystemManager/getRoleList/";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetRoleListTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
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
	public void postGetRoleListTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495323);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID未登录" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为错误ID
	 */
	@Test
	public void postGetRoleListTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 95323);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误ID" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postGetRoleListTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<$%^>");
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postGetRoleListTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1249.5323);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postGetRoleListTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -12495323);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postGetRoleListTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postGetRoleListTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "AAA");
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postGetRoleListTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postGetRoleListTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postGetRoleListTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postGetRoleListTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色名称超长
	 */
	@Test
	public void postGetRoleListTestRoleNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
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
	public void postGetRoleListTestRoleNameIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "<.#$%>");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
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
	public void postGetRoleListTestRoleNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", null);
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色名称为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色名称为空
	 */
	@Test
	public void postGetRoleListTestRoleNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
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
	public void postGetRoleListTestRoleNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", " ");
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
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
	public void postGetRoleListTestRoleNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("creatTimeStart", "1991-08-06 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色名称不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建时间为超长
	 */
	@Test
	public void postGetRoleListTestCreatTimeStartIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "191111111912-028-026 1222:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建时间为大于结束时间
	 */
	@Test
	public void postGetRoleListTestCreatTimeStartGreaterThanCreatTimeEnd() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-07-12 12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
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
	public void postGetRoleListTestCreatTimeStartIsTimeStamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "1529338959000");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建时间为时间戳" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建时间为空
	 */
	@Test
	public void postGetRoleListTestCreatTimeStartIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
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
	public void postGetRoleListTestCreatTimeStartIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", " ");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
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
	public void postGetRoleListTestCreatTimeStartIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", null);
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
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
	public void postGetRoleListTestCreatTimeStartNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
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
	public void postGetRoleListTestCreatTimeStartIsYYYYMMDD() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-07-06");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建时间为年月日" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建时间为时分秒
	 */
	@Test
	public void postGetRoleListTestCreatTimeStartIsHHMMSS() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "12:13:14");
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建时间为时分秒" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建时间为0
	 */
	@Test
	public void postGetRoleListTestCreatTimeStartIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", 0);
		request.put("creatTimeEnd", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建时间为时分秒" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}


	/**
	 * 结束时间为超长
	 */
	@Test
	public void postGetRoleListTestCreatTimeEndIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeEnd", "191111111912-028-026 1222:13:14");
		request.put("creatTimeStart", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * 结束时间为时间戳
	 */
	@Test
	public void postGetRoleListTestCreatTimeEndIsTimeStamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeEnd", "1529338959000");
		request.put("creatTimeStart", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间为时间戳" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 结束时间为空
	 */
	@Test
	public void postGetRoleListTestCreatTimeEndIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeEnd", "");
		request.put("creatTimeStart", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
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
	public void postGetRoleListTestCreatTimeEndIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeEnd", " ");
		request.put("creatTimeStart", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
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
	public void postGetRoleListTestCreatTimeEndIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeEnd", null);
		request.put("creatTimeStart", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
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
	public void postGetRoleListTestCreatTimeEndNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
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
	public void postGetRoleListTestCreatTimeEndIsYYYYMMDD() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeEnd", "2018-07-06");
		request.put("creatTimeStart", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间为年月日" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 结束时间为时分秒
	 */
	@Test
	public void postGetRoleListTestCreatTimeEndIsHHMMSS() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeEnd", "12:13:14");
		request.put("creatTimeStart", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间为时分秒" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 结束时间为0
	 */
	@Test
	public void postGetRoleListTestCreatTimeEndIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeEnd", 0);
		request.put("creatTimeStart", "2018-08-06 12:13:14");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间为时分秒" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
}