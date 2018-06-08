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

public class AssignPermissionsForRolesTest extends HttpUtil {
// 为角色配置权限接口
	String url = "/uu-admin/BackUser/setRoleAuthTree";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postAssignPermissionsForRolesTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID未登录
	 */
	@Test
	public void postAssignPermissionsForRolesTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495323);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID未登录" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为错误ID
	 */
	@Test
	public void postAssignPermissionsForRolesTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 95323);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误ID" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postAssignPermissionsForRolesTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<$%^>");
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postAssignPermissionsForRolesTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1249.5323);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postAssignPermissionsForRolesTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -12495323);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postAssignPermissionsForRolesTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postAssignPermissionsForRolesTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "AAA");
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postAssignPermissionsForRolesTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postAssignPermissionsForRolesTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postAssignPermissionsForRolesTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postAssignPermissionsForRolesTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postAssignPermissionsForRolesTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 999999999999999999L);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色id为错误
	 */
	@Test
	public void postAssignPermissionsForRolesTestRoleIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 999);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id为错误" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色id为小数
	 */
	@Test
	public void postAssignPermissionsForRolesTestRoleIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 1.10);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id为小数" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色id为负数
	 */
	@Test
	public void postAssignPermissionsForRolesTestRoleIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", -11);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id为负数" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色id传非法字符
	 */
	@Test
	public void postAssignPermissionsForRolesTestRoleIdIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", "<#%%>");
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id传非法字符" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色id传空
	 */
	@Test
	public void postAssignPermissionsForRolesTestRoleIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", "");
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id传空" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色id传空格
	 */
	@Test
	public void postAssignPermissionsForRolesTestRoleIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", " ");
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id传空格" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色id传String
	 */
	@Test
	public void postAssignPermissionsForRolesTestRoleIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", "fgsdfs");
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id传String" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色id不传参数
	 */
	@Test
	public void postAssignPermissionsForRolesTestRoleIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id不传参数" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色id传0
	 */
	@Test
	public void postAssignPermissionsForRolesTestRoleIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id传0" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单名称menuName传超长
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单ds的广东分公司郭德纲符合国家科技撒发射点发射点广泛大锅饭个");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单名称menuName传超长" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单名称menuName传空
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单名称menuName传空" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单名称menuName传空格
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", " ");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单名称menuName传空格" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单名称menuName传null
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", null);
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单名称menuName传null" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单名称menuName传错误值
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuNameIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 999);
		request.put("menuName", "测试菜单ds的广东分公司郭德纲符合国家科技撒发射点发射点广泛大锅饭个");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单名称menuName传错误值" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单名称menuName不传参数
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单名称menuName不传参数" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单id传错误值
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 888);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单id传错误值" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单id传小数
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 2.33);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单id传小数" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单id传负数
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", -2);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单id传负数" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单id传空
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", "");
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单id传空" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单id传空格
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", " ");
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单id传空格" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单id传null
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", null);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单id传null" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单id不传参数
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单id不传参数" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单是否被选中menuStatus传错误值
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuStatusIError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 99);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单是否被选中menuStatus传错误值" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单是否被选中menuStatus传小数
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuStatusIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1.22);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单是否被选中menuStatus传小数" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单是否被选中menuStatus传负数
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuStatusIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", -1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单是否被选中menuStatus传负数" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单是否被选中menuStatus传空格
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuStatusIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", " ");
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单是否被选中menuStatus传空格" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单是否被选中menuStatus传null
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuStatusIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", null);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单是否被选中menuStatus传null" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单是否被选中menuStatus传非法字符
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuStatusIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", "<#%@>");
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单是否被选中menuStatus传非法字符" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单是否被选中menuStatusbuchuan 不传参数
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuStatusNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单是否被选中menuStatusbuchuan 不传参数" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单是否被选中menuStatus传0未被选中
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuStatusIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 0);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单是否被选中menuStatus传0未被选中" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单是否被选中menuStatus传1被选中
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuStatusIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单是否被选中menuStatus传1被选中" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单是否被选中menuStatus先传1再传0
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuStatusIs1Again0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 0);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单是否被选中menuStatus先传1再传0" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单是否被选中menuStatus先传0再传1
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuStatusIs0Again1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单是否被选中menuStatus先传0再传1" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能描述function传超长
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述dfs打个复活复活复活合格符合符合韩国的凤凰股份回购共和党和");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能描述function传超长" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能描述function传空
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能描述function传空" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能描述function传空格
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", " ");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能描述function传空格" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能描述function传null
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", null);
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能描述function传null" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能描述function传0
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", 0);
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能描述function传0" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能描述function不传参数
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能描述function不传参数" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能名称funcitonName传超长字符
	 */
	@Test
	public void postAssignPermissionsForRolesTestFuncitonNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称的犯得上方法方法反对呱呱呱呱呱呱呱呱呱呱呱呱呱呱呱顶顶顶顶顶顶顶");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能名称funcitonName传超长字符" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能名称funcitonName传空
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能名称funcitonName传空" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能名称funcitonName传空格
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", " ");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能名称funcitonName传空格" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能名称funcitonName传null
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", null);
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能名称funcitonName传null" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能名称funcitonName不传参数
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能名称funcitonName不传参数" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能id传错误
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 99);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能id传错误" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能id传小数
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2.23);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能id传小数" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 功能id传负数
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", -23);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能id传负数" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能id传空
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", "");
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能id传空" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能id传空格
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", " ");
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能id传空格" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能id传null
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", null);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能id传null" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能id传String
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", "dfsdd");
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能id传String" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能id不传参数
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能id不传参数" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能id传0
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 0);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能id传0" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态funcitonStatus传错误值
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 33);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态funcitonStatus传错误值" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态funcitonStatus传小数
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 3.3);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态funcitonStatus传小数" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态funcitonStatus传负数
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", -5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态funcitonStatus传负数" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态funcitonStatus传空
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态funcitonStatus传空" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态funcitonStatus传空格
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态funcitonStatus传空格" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态funcitonStatus传null
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态funcitonStatus传null" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态funcitonStatus传String
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", "fgdgd");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态funcitonStatus传String" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态funcitonStatus不传参数
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
   		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态funcitonStatus不传参数" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态funcitonStatus传1被选中
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态funcitonStatus传1被选中" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态funcitonStatus传0未被选中
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态funcitonStatus传0未被选中" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态funcitonStatus先传1再传0
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIs1Again0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态funcitonStatus先传1再传0" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态funcitonStatus先传0再传1
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIs0Again1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态funcitonStatus先传0再传1" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态先传0再传0
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIs0Again0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态先传0再传0" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态先传1再传1
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIs1Again1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 110);
		request.put("menuName", "测试菜单");
		request.put("menuId", 3);
		request.put("menuStatus", 1);
		request.put("function", "测试功能描述");
		request.put("funcitonName", "测试功能名称");
		request.put("funcitonId", 2);
		request.put("funcitonStatus", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态先传1再传1" + post);

		assertThat(post.get("status")).isEqualTo("0");
		assertThat(post.get("msg")).isEqualTo("成功");
	}
}