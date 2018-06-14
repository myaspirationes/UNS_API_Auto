package com.systemManagement;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class AddOrUpdateUserTest extends HttpUtil {
// 添加/编辑系统用户接口
	String url = "/uu-admin/BackUser/addOrUpdateUser";
	String userId;
	String deleteSql = "DELETE FROM T_WEB_USER WHERE USER_NAME = 'lingfeng'";
	String dataType = "perCenter81";
	String selectSql = "SELECT * FROM T_WEB_USER WHERE USER_NAME = 'lingfeng'";
	List<Map<String,Object>> list ;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}
//	@BeforeMethod
//	public void beforeMethod(){
//		MetaOper.delete(deleteSql,dataType);
//	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postAddOrUpdateUserTestCorrectParameter() throws Exception {
		userId = new BackUserLoginTest().userId;
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postAddOrUpdateUserTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为错误
	 */
	@Test
	public void postAddOrUpdateUserTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12345);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postAddOrUpdateUserTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<.@#$%>");
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postAddOrUpdateUserTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 123.123);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postAddOrUpdateUserTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -345);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postAddOrUpdateUserTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postAddOrUpdateUserTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "userId");
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postAddOrUpdateUserTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postAddOrUpdateUserTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postAddOrUpdateUserTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postAddOrUpdateUserTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 用户ID超长
	 */
	@Test
	public void postAddOrUpdateUserTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 123123123123213L);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 角色ID为非法字符
	 */
	@Test
	public void postAddOrUpdateUserTestRoleIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", "<$$*((>");
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("roleId或者userId格式不正确");
	}
	/**
	 * 角色ID为错误
	 */
	@Test
	public void postAddOrUpdateUserTestRoleIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", "111111111");
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为错误" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("不存在此角色信息");
	}
	/**
	 * 角色ID为空
	 */
	@Test
	public void postAddOrUpdateUserTestRoleIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", "");
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("roleId或者userId格式不正确");
	}
	/**
	 * 角色ID为空格
	 */
	@Test
	public void postAddOrUpdateUserTestRoleIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", " ");
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 角色ID为null
	 */
	@Test
	public void postAddOrUpdateUserTestRoleIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", null);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为null" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 角色ID为String
	 */
	@Test
	public void postAddOrUpdateUserTestRoleIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", "aaa");
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为String" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("roleId或者userId格式不正确");
	}
	/**
	 * 角色ID为不传该参数
	 */
	@Test
	public void postAddOrUpdateUserTestRoleIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 角色ID为小数
	 */
	@Test
	public void postAddOrUpdateUserTestRoleIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 9.9);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("roleId或者userId格式不正确");
	}
	/**
	 * 角色ID为负数
	 */
	@Test
	public void postAddOrUpdateUserTestRoleIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", -9);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("roleId或者userId格式不正确");
	}
	/**
	 * 角色ID为存在的
	 */
	@Test
	public void postAddOrUpdateUserTestRoleIdNonExistent() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 999999);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为存在的" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("不存在此角色信息");
	}
	/**
	 * 角色ID为0
	 */
	@Test
	public void postAddOrUpdateUserTestRoleIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * 角色名称为空
	 */
	@Test
	public void postAddOrUpdateUserTestRoleNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("roleName", "");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色名称为空" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 角色名称为空格
	 */
	@Test
	public void postAddOrUpdateUserTestRoleNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("roleName", " ");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色名称为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
	}
	/**
	 * 角色名称为null
	 */
	@Test
	public void postAddOrUpdateUserTestRoleNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("roleName", null);
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色名称为null" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 角色名称为超长
	 */
	@Test
	public void postAddOrUpdateUserTestRoleNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("roleName", "自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色名称为超长" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 角色名称为非法字符
	 */
	@Test
	public void postAddOrUpdateUserTestRoleNameIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("roleName", "<.#$%^&>");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色名称为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
	}
	/**
	 * 角色名称不传该参数
	 */
	@Test
	public void postAddOrUpdateUserTestRoleNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色名称不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 用户登录密码不传该参数
	 */
	@Test
	public void postAddOrUpdateUserTestRoleDescNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登录密码不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
	}
	/**
	 * 用户登录密码为空
	 */
	@Test
	public void postAddOrUpdateUserTestRoleDescIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登录密码为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
	}
	/**
	 * 用户登录密码为空格
	 */
	@Test
	public void postAddOrUpdateUserTestRoleDescIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", " ");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登录密码为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
	}
	/**
	 * 用户登录密码为null
	 */
	@Test
	public void postAddOrUpdateUserTestRoleDescIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", null);
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登录密码为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
	}
	/**
	 * 用户登录密码为超长
	 */
	@Test
	public void postAddOrUpdateUserTestRoleDescIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "abcdefghijklmopqrstuvwxyz1234567890");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登录密码为超长" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 用户登录密码为非法字符
	 */
	@Test
	public void postAddOrUpdateUserTestRoleDescIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "<@#$%^&*!>");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登录密码为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
	}
	
	/**
	 * 用户姓名为超长
	 */
	@Test
	public void postAddOrUpdateUserTestRealNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰萨迪克拉斯蒂我饿哦请问萨市中心消息称王企鹅我怕是流动性权重拍咯点击查看城西小学");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户姓名为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	/**
	 * 用户姓名为非法字符
	 */
	@Test
	public void postAddOrUpdateUserTestRealNameIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "<.@#$%>");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户姓名为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	/**
	 * 用户姓名为null
	 */
	@Test
	public void postAddOrUpdateUserTestRealNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", null);
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户姓名为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	/**
	 * 用户姓名为空
	 */
	@Test
	public void postAddOrUpdateUserTestRealNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户姓名为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	/**
	 * 用户姓名为空格
	 */
	@Test
	public void postAddOrUpdateUserTestRealNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", " ");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户姓名为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	/**
	 * 用户姓名不传该参数
	 */
	@Test
	public void postAddOrUpdateUserTestRealNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户姓名不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	
	/**
	 * email地址为超长
	 */
	@Test
	public void postAddOrUpdateUserTestEmailIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlfasjioijweoijdasdasnxzmcksdlaweq0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户姓名为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	/**
	 * email地址为非法字符
	 */
	@Test
	public void postAddOrUpdateUserTestEmailIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "<.@#$%>");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户姓名为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	/**
	 * email地址为null
	 */
	@Test
	public void postAddOrUpdateUserTestEmailIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", null);
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("email地址为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	/**
	 * email地址为空
	 */
	@Test
	public void postAddOrUpdateUserTestEmailIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("email地址为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	/**
	 * email地址为空格
	 */
	@Test
	public void postAddOrUpdateUserTestEmailIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", " ");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("email地址为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	/**
	 * email地址不传该参数
	 */
	@Test
	public void postAddOrUpdateUserTestEmailNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("email地址不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	
	/**
	 * 手机号码为超长
	 */
	@Test
	public void postAddOrUpdateUserTestPhoneIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "1376477199519951995199519951995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	/**
	 * 手机号码为非法字符
	 */
	@Test
	public void postAddOrUpdateUserTestPhoneIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "<.@#$%>");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	/**
	 * 手机号码为null
	 */
	@Test
	public void postAddOrUpdateUserTestPhoneIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", null);
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	/**
	 * 手机号码为空
	 */
	@Test
	public void postAddOrUpdateUserTestPhoneIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	/**
	 * 手机号码为空格
	 */
	@Test
	public void postAddOrUpdateUserTestPhoneIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", " ");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	/**
	 * 手机号码不传该参数
	 */
	@Test
	public void postAddOrUpdateUserTestPhoneNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	
	/**
	 * 状态为超长
	 */
	@Test
	public void postAddOrUpdateUserTestStatusIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 1234567890);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	/**
	 * 状态为非法字符
	 */
	@Test
	public void postAddOrUpdateUserTestStatusIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
	}
	/**
	 * 状态为错误
	 */
	@Test
	public void postAddOrUpdateUserTestStatus() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 99);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为错误" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为空
	 */
	@Test
	public void postAddOrUpdateUserTestStatusIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", "");
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
	}
	/**
	 * 状态为空格
	 */
	@Test
	public void postAddOrUpdateUserTestStatusIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", " ");
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为null
	 */
	@Test
	public void postAddOrUpdateUserTestStatusIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", null);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为String
	 */
	@Test
	public void postAddOrUpdateUserTestStatusIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", "aaa");
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为String" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
	}
	/**
	 * 状态不传该参数
	 */
	@Test
	public void postAddOrUpdateUserTestStatusNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为小数
	 */
	@Test
	public void postAddOrUpdateUserTestStatusIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0.5);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
	}
	/**
	 * 状态为负数
	 */
	@Test
	public void postAddOrUpdateUserTestStatusIsNegativeNumber() throws Exception {

		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", -1);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("-1");
	}
	/**
	 * 状态为0
	 */
	@Test
	public void postAddOrUpdateUserTestStatusIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("0");
	}
	/**
	 * 状态为1
	 */
	@Test
	public void postAddOrUpdateUserTestStatusIsOne() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 1);
		request.put("roles", "10000003,10000037");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为1" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 角色为超长
	 */
	@Test
	public void postAddOrUpdateUserTestRolesIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "10000003123456788900987654321");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	/**
	 * 角色为非法字符
	 */
	@Test
	public void postAddOrUpdateUserTestRolesIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "<.@#$%>");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	/**
	 * 角色为null
	 */
	@Test
	public void postAddOrUpdateUserTestRolesIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	/**
	 * 角色为空
	 */
	@Test
	public void postAddOrUpdateUserTestRolesIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	/**
	 * 角色为空格
	 */
	@Test
	public void postAddOrUpdateUserTestRolesIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		request.put("roles", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	/**
	 * 角色不传该参数
	 */
	@Test
	public void postAddOrUpdateUserTestRolesNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		request.put("userName", "lingfeng");
		request.put("userPassword", "123456");
		request.put("realName", "张领峰");
		request.put("email", "zlf0923@126.com");
		request.put("phone", "13764771995");
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	
//	@AfterClass
//	public void afterClass(){
//			MetaOper.delete(deleteSql,dataType);
//
//	}
}