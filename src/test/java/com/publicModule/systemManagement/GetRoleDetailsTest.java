package com.publicModule.systemManagement;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class GetRoleDetailsTest extends HttpUtil {
// 获取角色详情接口
	String url = "/uu-admin/SystemManager/getRoleSpecial/";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetRoleDetailsTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 10000001);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID未登录
	 */
	@Test
	public void postGetRoleDetailsTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 10000012);
		request.put("roleId", 10000037);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID未登录" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为错误ID
	 */
	@Test
	public void postGetRoleDetailsTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 001);
		request.put("roleId", 10000001);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误ID" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数错误");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postGetRoleDetailsTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<$%^>");
		request.put("roleId", 10000001);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
//		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postGetRoleDetailsTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1249.5323);
		request.put("roleId", 10000001);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("参数错误");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postGetRoleDetailsTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -12495323);
		request.put("roleId", 10000001);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postGetRoleDetailsTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);
		request.put("roleId", 10000001);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postGetRoleDetailsTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "AAA");
		request.put("roleId", 10000001);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
//		assertThat(post.get("msg")).isEqualTo("参数错误");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postGetRoleDetailsTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("roleId", 10000001);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postGetRoleDetailsTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("roleId", 10000001);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postGetRoleDetailsTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("roleId", 10000001);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postGetRoleDetailsTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("roleId", 10000001);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postGetRoleDetailsTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 999999999999999999L);
		request.put("roleId", 10000001);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * 角色id为错误
	 */
	@Test
	public void postGetRoleDetailsTestroleIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 999);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id为错误" + post);

		assertThat(post.get("status")).isIn(1,-1);
		assertThat(post.get("msg")).isEqualTo("id为：999的角色不存在");
	}
	/**
	 * 角色id为小数
	 */
	@Test
	public void postGetRoleDetailsTestroleIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 1.10);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id为小数" + post);

		assertThat(post.get("status")).isIn(1,-1);
		assertThat(post.get("msg")).isEqualTo("id为：1的角色不存在");
	}
	/**
	 * 角色id为负数
	 */
	@Test
	public void postGetRoleDetailsTestroleIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", -11);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * 角色id传非法字符
	 */
	@Test
	public void postGetRoleDetailsTestroleIdIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", "<#%%>");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id传非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
//		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色id传空
	 */
	@Test
	public void postGetRoleDetailsTestroleIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id不能为空！");
	}
	/**
	 * 角色id传空格
	 */
	@Test
	public void postGetRoleDetailsTestroleIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id不能为空！");
	}
	/**
	 * 角色id传String
	 */
	@Test
	public void postGetRoleDetailsTestroleIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", "fgsdfs");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id传String" + post);

		assertThat(post.get("status")).isEqualTo(400);
//		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色id不传参数
	 */
	@Test
	public void postGetRoleDetailsTestroleIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id不能为空！");
	}
	/**
	 * 角色id传0
	 */
	@Test
	public void postGetRoleDetailsTestroleIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id传0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	
}
