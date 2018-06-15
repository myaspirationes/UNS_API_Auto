package com.systemManagement;

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

public class DeleteSystemUserTest extends HttpUtil {
// 删除系统用户接口
	String url = "/uu-admin/BackUser/deleteUser";
	String userId;
	String dataType = "perCenter81";
	String selectSql = "SELECT * FROM T_WEB_USER WHERE USER_NAME = 'lingfeng'";
	List<Map<String,Object>> list ;
	String sysUserId;
	@BeforeClass
	public void beforeClass() {
		userId =new BackUserLoginTest().userId;
		
		list = MetaOper.read(selectSql,dataType);
		sysUserId = list.get(0).get("USER_ID").toString();
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postDeleteSystemUserTestCorrectParameter() throws Exception {
//		new AddOrUpdateUserTest().postAddOrUpdateUserTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", sysUserId);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postDeleteSystemUserTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 100001142);
		request.put("sysUserId", sysUserId);
		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 用户ID为错误
	 */
	@Test
	public void postDeleteSystemUserTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 13);
		request.put("sysUserId", sysUserId);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postDeleteSystemUserTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<.@#$%>");
		request.put("sysUserId", sysUserId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postDeleteSystemUserTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 123.123);
		request.put("sysUserId", sysUserId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postDeleteSystemUserTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -345);
		request.put("sysUserId", sysUserId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postDeleteSystemUserTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);
		request.put("sysUserId", sysUserId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postDeleteSystemUserTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "userId");
		request.put("sysUserId", sysUserId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postDeleteSystemUserTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("sysUserId", sysUserId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postDeleteSystemUserTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("sysUserId", sysUserId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postDeleteSystemUserTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("sysUserId", sysUserId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postDeleteSystemUserTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("sysUserId", sysUserId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 用户ID超长
	 */
	@Test
	public void postDeleteSystemUserTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 123123123123213L);
		request.put("sysUserId", sysUserId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID超长" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 被删除用户ID为非法字符
	 */
	@Test
	public void postDeleteSystemUserTestSysUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", "<$$*((>");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被删除用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 被删除用户ID为错误
	 */
	@Test
	public void postDeleteSystemUserTestSysUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", "111111111");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被删除用户ID为错误" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("删除用户不存在");
	}
	/**
	 * 被删除用户ID为空
	 */
	@Test
	public void postDeleteSystemUserTestSysUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被删除用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 被删除用户ID为空格
	 */
	@Test
	public void postDeleteSystemUserTestSysUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被删除用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 被删除用户ID为null
	 */
	@Test
	public void postDeleteSystemUserTestSysUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被删除用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 被删除用户ID为String
	 */
	@Test
	public void postDeleteSystemUserTestSysUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", "aaa");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被删除用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 被删除用户ID为不传该参数
	 */
	@Test
	public void postDeleteSystemUserTestSysUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被删除用户ID为不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 被删除用户ID为小数
	 */
	@Test
	public void postDeleteSystemUserTestSysUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 9.9);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被删除用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("删除用户不存在");
	}
	/**
	 * 被删除用户ID为负数
	 */
	@Test
	public void postDeleteSystemUserTestSysUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", -9);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被删除用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("删除用户不存在");
	}
	/**
	 * 被删除用户ID为不存在的
	 */
	@Test
	public void postDeleteSystemUserTestSysUserIdNonExistent() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 999999);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被删除用户ID为存在的" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("删除用户不存在");
	}
	/**
	 * 被删除用户ID为0
	 */
	@Test
	public void postDeleteSystemUserTestSysUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("sysUserId", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被删除用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("删除用户不存在");
	}

}