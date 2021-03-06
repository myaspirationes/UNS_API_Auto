package com.publicModule.systemManagement;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class DeletePersonRoleTest extends HttpUtil {
// 删除角色接口
	String url = "/uu-admin/SystemManager/deletePersonRole";
	String userId;
	String dataType = "perCenter81";
	String selectSql = "SELECT * FROM T_ROLES WHERE ROLE_NAME = '自动化测试角色' OR ROLE_DESC = '自动化测试用请勿删除'";
	String deleteSql = "DELETE FROM T_ROLES WHERE ROLE_NAME = '自动化测试角色' OR ROLE_DESC = '自动化测试用请勿删除'";
	List<Map<String,Object>> list ;
	String roleId;
	@BeforeClass
	public void beforeClass() throws Exception {
		MetaOper.delete(deleteSql,dataType);
		userId =new BackUserLoginTest().userId;
		new CreateAndSetPersonRoleTest().postCreateAndSetPersonRoleTestCorrectParameter();
		list = MetaOper.read(selectSql,dataType);
		roleId = list.get(0).get("ROLE_ID").toString();
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postDeletePersonRoleTestCorrectParameter() throws Exception {


		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", roleId);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postDeletePersonRoleTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", roleId);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为错误
	 */
	@Test
	public void postDeletePersonRoleTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 13);
		request.put("roleId", roleId);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postDeletePersonRoleTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<.@#$%>");
		request.put("roleId", roleId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postDeletePersonRoleTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 123.123);
		request.put("roleId", roleId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postDeletePersonRoleTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -345);
		request.put("roleId", roleId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postDeletePersonRoleTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", roleId);
		request.put("roleId", roleId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postDeletePersonRoleTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "userId");
		request.put("roleId", roleId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postDeletePersonRoleTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("roleId", roleId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postDeletePersonRoleTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("roleId", roleId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId为空");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postDeletePersonRoleTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("roleId", roleId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId为空");

	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postDeletePersonRoleTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("roleId", roleId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId为空");
	}
	/**
	 * 用户ID超长
	 */
	@Test
	public void postDeletePersonRoleTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 123123123123213L);
		request.put("roleId", roleId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 角色ID为非法字符
	 */
	@Test
	public void postDeletePersonRoleTestRoleIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", "<$$*((>");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("删除失败");
	}
	/**
	 * 角色ID为错误
	 */
	@Test
	public void postDeletePersonRoleTestRoleIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", "111111111");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为错误" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("没有此角色");
	}
	/**
	 * 角色ID为空
	 */
	@Test
	public void postDeletePersonRoleTestRoleIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("删除失败");
	}
	/**
	 * 角色ID为空格
	 */
	@Test
	public void postDeletePersonRoleTestRoleIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("删除失败");
	}
	/**
	 * 角色ID为null
	 */
	@Test
	public void postDeletePersonRoleTestRoleIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为null" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 角色ID为String
	 */
	@Test
	public void postDeletePersonRoleTestRoleIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", "aaa");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为String" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("删除失败");
	}
	/**
	 * 角色ID为不传该参数
	 */
	@Test
	public void postDeletePersonRoleTestRoleIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 角色ID为小数
	 */
	@Test
	public void postDeletePersonRoleTestRoleIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 9.9);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("删除失败");
	}
	/**
	 * 角色ID为负数
	 */
	@Test
	public void postDeletePersonRoleTestRoleIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", -9);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("删除失败");
	}
	/**
	 * 角色ID为存在的
	 */
	@Test
	public void postDeletePersonRoleTestRoleIdNonExistent() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 999999);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为存在的" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("没有此角色");
	}
	/**
	 * 角色ID为0
	 */
	@Test
	public void postDeletePersonRoleTestRoleIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleId", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("没有此角色");
	}

}
