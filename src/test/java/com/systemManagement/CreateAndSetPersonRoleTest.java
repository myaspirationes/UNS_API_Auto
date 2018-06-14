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
	public void postCreateAndSetPersonRoleTestCorrectParameter() throws Exception {
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
	public void postCreateAndSetPersonRoleTestUserIdNotLoggedIn() throws Exception {
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
	public void postCreateAndSetPersonRoleTestUserIdIsError() throws Exception {
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
	public void postCreateAndSetPersonRoleTestUserIdIllegalCharacters() throws Exception {
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
	public void postCreateAndSetPersonRoleTestUserIdIsDecimal() throws Exception {
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
	public void postCreateAndSetPersonRoleTestUserIdIsNegativeNumber() throws Exception {
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
	public void postCreateAndSetPersonRoleTestUserIdIsZero() throws Exception {
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
	public void postCreateAndSetPersonRoleTestUserIdIsString() throws Exception {
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
	public void postCreateAndSetPersonRoleTestUserIdIsSpace() throws Exception {
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
	public void postCreateAndSetPersonRoleTestUserIdIsEmpty() throws Exception {
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
	public void postCreateAndSetPersonRoleTestUserIdIsNull() throws Exception {
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
	public void postCreateAndSetPersonRoleTestUserIdNonSubmissionParameters() throws Exception {
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
	public void postCreateAndSetPersonRoleTestUserIdIsLong() throws Exception {
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
	public void postCreateAndSetPersonRoleTestRoleIdIllegalCharacters() throws Exception {
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
	public void postCreateAndSetPersonRoleTestRoleIdIsError() throws Exception {
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
	public void postCreateAndSetPersonRoleTestRoleIdIsEmpty() throws Exception {
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
	public void postCreateAndSetPersonRoleTestRoleIdIsSpace() throws Exception {
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
	public void postCreateAndSetPersonRoleTestRoleIdIsNull() throws Exception {
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
	public void postCreateAndSetPersonRoleTestRoleIdIsString() throws Exception {
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
	public void postCreateAndSetPersonRoleTestRoleIdNonSubmissionParameters() throws Exception {
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
	public void postCreateAndSetPersonRoleTestRoleIdIsDecimal() throws Exception {
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
	public void postCreateAndSetPersonRoleTestRoleIdIsNegativeNumber() throws Exception {
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
	public void postCreateAndSetPersonRoleTestRoleIdNonExistent() throws Exception {
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
	public void postCreateAndSetPersonRoleTestRoleIdIsZero() throws Exception {
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
	public void postCreateAndSetPersonRoleTestRoleNameIsEmpty() throws Exception {
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
	public void postCreateAndSetPersonRoleTestRoleNameIsSpace() throws Exception {
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
	public void postCreateAndSetPersonRoleTestRoleNameIsNull() throws Exception {
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
	public void postCreateAndSetPersonRoleTestRoleNameIsLong() throws Exception {
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
	public void postCreateAndSetPersonRoleTestRoleNameIllegalCharacters() throws Exception {
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
	public void postCreateAndSetPersonRoleTestRoleNameNonSubmissionParameters() throws Exception {
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
	public void postCreateAndSetPersonRoleTestRoleDescNonSubmissionParameters() throws Exception {
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
	public void postCreateAndSetPersonRoleTestRoleDescIsEmpty() throws Exception {
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
	public void postCreateAndSetPersonRoleTestRoleDescIsSpace() throws Exception {
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
	public void postCreateAndSetPersonRoleTestRoleDescIsNull() throws Exception {
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
	public void postCreateAndSetPersonRoleTestRoleDescIsLong() throws Exception {
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
	public void postCreateAndSetPersonRoleTestRoleDescIllegalCharacters() throws Exception {
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
	public void postCreateAndSetPersonRoleTestStatusIsLong() throws Exception {
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
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("1");
	}
	/**
	 * 角色状态非法字符
	 */
	@Test
	public void postCreateAndSetPersonRoleTestStatusIllegalCharacters() throws Exception {
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
	public void postCreateAndSetPersonRoleTestStatus() throws Exception {
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
	public void postCreateAndSetPersonRoleTestStatusIsEmpty() throws Exception {
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
	public void postCreateAndSetPersonRoleTestStatusIsSpace() throws Exception {
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
	public void postCreateAndSetPersonRoleTestStatusIsNull() throws Exception {
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
	public void postCreateAndSetPersonRoleTestStatusIsString() throws Exception {
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
	public void postCreateAndSetPersonRoleTestStatusNonSubmissionParameters() throws Exception {
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
	public void postCreateAndSetPersonRoleTestStatusIsDecimal() throws Exception {
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
	public void postCreateAndSetPersonRoleTestStatusIsNegativeNumber() throws Exception {

		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("roleName", "自动化测试角色");
		request.put("roleDesc", "自动化测试用请勿删除");
		request.put("status", -1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("新增成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("ROLE_STATUS").toString()).isEqualTo("1");
	}
	/**
	 * 角色状态为0
	 */
	@Test
	public void postCreateAndSetPersonRoleTestStatusIsZero() throws Exception {
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
	public void postCreateAndSetPersonRoleTestStatusIsOne() throws Exception {
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
