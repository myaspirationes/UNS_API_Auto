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

public class CreateAndSetPersonRoleTest extends HttpUtil {
// 添加/编辑角色接口
	String url = "/uu-admin/SystemManager/createAndSetPersonRole";
	String userId;
	String deleteSql = "DELETE FROM T_ROLES WHERE ROLE_NAME = '自动化测试角色' OR ROLE_DESC = '自动化测试用请勿删除'";
	String dataType = "perCenter81";
	String selectSql = "SELECT * FROM T_ROLES WHERE ROLE_NAME = '自动化测试角色' OR ROLE_DESC = '自动化测试用请勿删除'";
	List<Map<String,Object>> list ;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}
	@BeforeMethod
	public void beforeMethod(){
		MetaOper.delete(deleteSql,dataType);
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetRoleListTestCorrectParameter() throws Exception {
		userId =new BackUserLoginTest().userId;
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postGetRoleListTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为错误
	 */
	@Test
	public void postGetRoleListTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12345);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postGetRoleListTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<.@#$%>");
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postGetRoleListTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 123.123);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postGetRoleListTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -345);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postGetRoleListTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postGetRoleListTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "userId");
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postGetRoleListTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postGetRoleListTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId为空");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postGetRoleListTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId为空");

	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postGetRoleListTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId为空");
	}
	/**
	 * 用户ID超长
	 */
	@Test
	public void postGetRoleListTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 123123123123213L);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 角色ID为非法字符
	 */
	@Test
	public void postGetRoleListTestRoleIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", "<$$*((>");
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("roleId或者userId格式不正确");
	}
	/**
	 * 角色ID为错误
	 */
	@Test
	public void postGetRoleListTestRoleIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", "111111111");
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为错误" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("不存在此角色信息");
	}
	/**
	 * 角色ID为空
	 */
	@Test
	public void postGetRoleListTestRoleIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", "");
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("roleId为空");
	}
	/**
	 * 角色ID为空格
	 */
	@Test
	public void postGetRoleListTestRoleIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", " ");
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("roleId或者userId格式不正确");
	}
	/**
	 * 角色ID为null
	 */
	@Test
	public void postGetRoleListTestRoleIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", null);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("roleId为空");
	}
	/**
	 * 角色ID为String
	 */
	@Test
	public void postGetRoleListTestRoleIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", "aaa");
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为String" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("roleId或者userId格式不正确");
	}
	/**
	 * 角色ID为不传该参数
	 */
	@Test
	public void postGetRoleListTestRoleIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("roleId为空");
	}
	/**
	 * 角色ID为小数
	 */
	@Test
	public void postGetRoleListTestRoleIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 9.9);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("roleId或者userId格式不正确");
	}
	/**
	 * 角色ID为负数
	 */
	@Test
	public void postGetRoleListTestRoleIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", -9);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("roleId或者userId格式不正确");
	}
	/**
	 * 角色ID为存在的
	 */
	@Test
	public void postGetRoleListTestRoleIdNonExistent() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 999999);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为存在的" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("不存在此角色信息");
	}
	/**
	 * 角色ID为0
	 */
	@Test
	public void postGetRoleListTestRoleIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
	}

	/**
	 * 角色名称为空
	 */
	@Test
	public void postGetRoleListTestRoleNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", "");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色名称为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("roleName为空");

	}
	/**
	 * 角色名称为空格
	 */
	@Test
	public void postGetRoleListTestRoleNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", " ");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色名称为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
	}
	/**
	 * 角色名称为null
	 */
	@Test
	public void postGetRoleListTestRoleNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", null);
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色名称为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("roleName为空");

	}
	/**
	 * 角色名称为超长
	 */
	@Test
	public void postGetRoleListTestRoleNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色名称为超长" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 角色名称为非法字符
	 */
	@Test
	public void postGetRoleListTestRoleNameIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", "<.#$%^&>");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色名称为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
	}
	/**
	 * 角色名称不传该参数
	 */
	@Test
	public void postGetRoleListTestRoleNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色名称不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("roleName为空");
	}
	/**
	 * 角色描述不传该参数
	 */
	@Test
	public void postGetRoleListTestRoleDescNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色描述不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
	}
	/**
	 * 角色描述为空
	 */
	@Test
	public void postGetRoleListTestRoleDescIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色描述为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
	}
	/**
	 * 角色描述为空格
	 */
	@Test
	public void postGetRoleListTestRoleDescIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", " ");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色描述为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
	}
	/**
	 * 角色描述为null
	 */
	@Test
	public void postGetRoleListTestRoleDescIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", null);
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色描述为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
	}
	/**
	 * 角色描述为超长
	 */
	@Test
	public void postGetRoleListTestRoleDescIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除自动化测试用请勿删除自动化测试用请勿删除自动化测试用请勿删除自动化测试用请勿删除自动化测试用请勿删除自动化测试用请勿删除自动化测试用请勿删除自动化测试用请勿删除自动化测试用请勿删除自动化测试用请勿删除自动化测试用请勿删除自动化测试用请勿删除自动化测试用请勿删除自动化测试用请勿删除自动化测试用请勿删除自动化测试用请勿删除自动化测试用请勿删除自动化测试用请勿删除自动化测试用请勿删除自动化测试用请勿删除自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色描述为超长" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 角色描述为非法字符
	 */
	@Test
	public void postGetRoleListTestRoleDescIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "<.@#$%>");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色描述为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
	}
	/**
	 * 角色状态为超长
	 */
	@Test
	public void postGetRoleListTestStatusIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", "11111111111111111111111111111111111111");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("11111111111111");
	}
	/**
	 * 角色状态非法字符
	 */
	@Test
	public void postGetRoleListTestStatusIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", "<#$%>");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
	}
	/**
	 * 角色状态为错误
	 */
	@Test
	public void postGetRoleListTestStatus() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 99);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为错误" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
	}
	/**
	 * 角色状态为空
	 */
	@Test
	public void postGetRoleListTestStatusIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("status为空");
	}
	/**
	 * 角色状态为空格
	 */
	@Test
	public void postGetRoleListTestStatusIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色状态为null
	 */
	@Test
	public void postGetRoleListTestStatusIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("status为空");
	}
	/**
	 * 角色状态为String
	 */
	@Test
	public void postGetRoleListTestStatusIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", "aaa");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为String" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
	}
	/**
	 * 角色状态不传该参数
	 */
	@Test
	public void postGetRoleListTestStatusNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("status为空");
	}
	/**
	 * 角色状态小数
	 */
	@Test
	public void postGetRoleListTestStatusIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1.8);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
	}
	/**
	 * 角色状态负数
	 */
	@Test
	public void postGetRoleListTestStatusIsNegativeNumber() throws Exception {

		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", -1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("-1");
	}
	/**
	 * 角色状态为0
	 */
	@Test
	public void postGetRoleListTestStatusIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("0");
	}
	/**
	 * 角色状态为1
	 */
	@Test
	public void postGetRoleListTestStatusIsOne() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为1" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
	}
	@AfterClass
	public void afterClass(){
			MetaOper.delete(deleteSql,dataType);

	}
}
