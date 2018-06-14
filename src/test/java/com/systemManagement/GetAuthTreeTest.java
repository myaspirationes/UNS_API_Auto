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

public class GetAuthTreeTest extends HttpUtil {
// 获取权限树接口
	String url = "/uu-admin/BackUser/getAuthTree";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetAuthTreeTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 12495325);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为未登录用户
	 */
	//@Test
	public void postpostGetAuthTreeTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 12495325);	

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postGetAuthTreeTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12345678);
		request.put("roleId", 12495325);	

		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postGetAuthTreeTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "!@#$%%#");
		request.put("roleId", 12495325);	

		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postGetAuthTreeTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1238.456);
		request.put("roleId", 12495325);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postGetAuthTreeTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -45245545);
		request.put("roleId", 12495325);	

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postGetAuthTreeTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("roleId", 12495325);		

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
	
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postGetAuthTreeTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("roleId", 12495325);

		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postGetAuthTreeTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("roleId", 12495325);	

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postGetAuthTreeTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);
		request.put("roleId", 12495325);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postGetAuthTreeTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "ddjfsfsfs");
		request.put("roleId", 12495325);	


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postGetAuthTreeTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();	
		
		request.put("roleId", 12495325);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
		
	/**
	 * 角色ID为错误
	 */
	@Test
	public void postGetAuthTreeTestRoleIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 87654321);	

		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为错误用户" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 角色ID为非法字符
	 */
	@Test
	public void postGetAuthTreeTestRoleIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", "!@#$$%#@$");	

		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 角色ID为小数
	 */
	@Test
	public void postGetAuthTreeTestRoleIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 12345.678);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 角色ID为负数
	 */
	@Test
	public void postGetAuthTreeTestRoleIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", -12345678);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 角色ID为空格
	 */
	@Test
	public void postGetAuthTreeTestRoleIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", "  ");		

		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为空格" + post);
	
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 角色ID为空
	 */
	@Test
	public void postGetAuthTreeTestRoleIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", "");

		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为空" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
	
	}
	/**
	 * 角色ID为null
	 */
	@Test
	public void postGetAuthTreeTestRoleIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", null);	

		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为null" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 角色ID为0   //
	 */
	@Test
	public void postGetAuthTreeTestRoleIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 角色ID为String
	 */
	@Test
	public void postGetAuthTreeTestRoleIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", "dsjfsdskd");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 角色ID不传该参数
	 */
	@Test
	public void postGetAuthTreeTestRoleIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();	
		request.put("userId", userId);
		

		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(500);
		
	}
	
}