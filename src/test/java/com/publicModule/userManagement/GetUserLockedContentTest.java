package com.publicModule.userManagement;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class GetUserLockedContentTest extends HttpUtil {
// 获取用户已锁定的内容列表接口
	String url = "/uu-admin/UUuserManage/getUserLockedContent";
	String userId;
	String deleteSql = "delete FROM T_USER_LOCK where LOCKED_USER_ID = 12495396 or MSG = '测试3' or MSG = '测试4'";
	String dataType = "perCenter81";
	String selectSql = "SELECT * FROM T_USER_LOCK WHERE  MSG = '测试3'";
	List<Map<String,Object>> list ;

	@AfterClass
	public void afterClass()
	{
		MetaOper.delete(deleteSql, dataType);
	}
	@BeforeClass
	public void beforeClass(){
		userId = new BackUserLoginTest().userId;
	}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetManagerParaSpecialTestCorrectParameter() throws Exception {
		new LockUserTest().postLockUserTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorId", userId);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("LOCK_ID").toString()).isNotEqualTo(4311);
	}
	/**
	 *用户ID未登录用户
	 */
	@Test
	public void postGetManagerParaSpecialTestOperatorIdNotLoggedIn() throws Exception {
		new LockUserTest().postLockUserTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorId", userId);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID未登录用户" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作成功");

	}
	/**
	 *用户ID为错误
	 */
	@Test
	public void postGetManagerParaSpecialTestOperatorIdIsError() throws Exception {
		new LockUserTest().postLockUserTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorId", 123123);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作成功");

	}
	/**
	 *用户ID为非法字符
	 */
	@Test
	public void postGetManagerParaSpecialTestOperatorIdIllegalCharacters() throws Exception {
		new LockUserTest().postLockUserTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorId", "<.#$%>");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);

	}
	/**
	 *用户ID为小数
	 */
	@Test
	public void postGetManagerParaSpecialTestOperatorIdIsDecimal() throws Exception {
		new LockUserTest().postLockUserTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorId", 1.3);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作成功");

	}
	/**
	 *用户ID为负数
	 */
	@Test
	public void postGetManagerParaSpecialTestOperatorIdIsNegativeNumber() throws Exception {
		new LockUserTest().postLockUserTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorId", -1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("处理人id格式错误！");

	}
	/**
	 *用户ID为0
	 */
	@Test
	public void postGetManagerParaSpecialTestOperatorIdIsZero() throws Exception {
		new LockUserTest().postLockUserTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("处理人id格式错误！");

	}
	/**
	 *用户ID为String
	 */
	@Test
	public void postGetManagerParaSpecialTestOperatorIdIsString() throws Exception {
		new LockUserTest().postLockUserTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorId", "userId");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(400);

	}
	/**
	 *用户ID为空
	 */
	@Test
	public void postGetManagerParaSpecialTestOperatorIdIsEmpty() throws Exception {
		new LockUserTest().postLockUserTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorId", "");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("处理人id不能为空！");

	}/**
	 *用户ID为空格
	 */
	@Test
	public void postGetManagerParaSpecialTestOperatorIdIsSpace() throws Exception {
		new LockUserTest().postLockUserTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorId", " ");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("处理人id不能为空！");

	}/**
	 *用户ID为null
	 */
	@Test
	public void postGetManagerParaSpecialTestOperatorIdIsNull() throws Exception {
		new LockUserTest().postLockUserTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorId", null);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("处理人id不能为空！");

	}
	/**
	 *用户ID不传该参数
	 */
	@Test
	public void postGetManagerParaSpecialTestOperatorIdNonSubmissionParameters() throws Exception {
		new LockUserTest().postLockUserTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("处理人id不能为空！");

	}
	/**
	 * 被查询用户ID超长
	 */
	@Test
	public void postGetManagerParaSpecialTestUserIdIsLong() throws Exception {
		new LockUserTest().postLockUserTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1231231231231231L);
		request.put("operatorId", userId);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查询用户ID超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("LOCK_ID").toString()).isNotEqualTo(null);
	}
	/**
	 * 被查询用户ID为非法字符
	 */
	@Test
	public void postGetManagerParaSpecialTestUserIdIllegalCharacters() throws Exception {
		new LockUserTest().postLockUserTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<.#$%>");
		request.put("operatorId", userId);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查询用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);

	}
	/**
	 * 被查询用户ID为错误
	 */
	@Test
	public void postGetManagerParaSpecialTestUserIdIsError() throws Exception {
		new LockUserTest().postLockUserTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 123123);
		request.put("operatorId", userId);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查询用户ID为错误" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("LOCK_ID").toString()).isNotEqualTo(null);
	}
	/**
	 * 被查询用户ID为空
	 */
	@Test
	public void postGetManagerParaSpecialTestUserIdIsEmpty() throws Exception {
		new LockUserTest().postLockUserTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("operatorId", userId);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查询用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 被查询用户ID为空格
	 */
	@Test
	public void postGetManagerParaSpecialTestUserIdIsSpace() throws Exception {
		new LockUserTest().postLockUserTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("operatorId", userId);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查询用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 被查询用户ID为String
	 */
	@Test
	public void postGetManagerParaSpecialTestUserIdIsString() throws Exception {
		new LockUserTest().postLockUserTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "userId");
		request.put("operatorId", userId);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查询用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 被查询用户ID为null
	 */
	@Test
	public void postGetManagerParaSpecialTestUserIdIsNull() throws Exception {
		new LockUserTest().postLockUserTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("operatorId", userId);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查询用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 被查询用户ID不传该参数
	 */
	@Test
	public void postGetManagerParaSpecialTestUserIdNonSubmissionParameters() throws Exception {
		new LockUserTest().postLockUserTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("operatorId", userId);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查询用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 被查询用户ID为小数
	 */
	@Test
	public void postGetManagerParaSpecialTestUserIdIsDecimal() throws Exception {
		new LockUserTest().postLockUserTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495.396);
		request.put("operatorId", userId);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查询用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}/**
	 * 被查询用户ID为负数
	 */
	@Test
	public void postGetManagerParaSpecialTestUserIdIsNegativeNumber() throws Exception {
		new LockUserTest().postLockUserTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -12495396);
		request.put("operatorId", userId);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查询用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id格式错误！");
	}
	/**
	 * 被查询用户ID为0
	 */
	@Test
	public void postGetManagerParaSpecialTestUserIdIsZero() throws Exception {
		new LockUserTest().postLockUserTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);
		request.put("operatorId", userId);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查询用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id格式错误！");
	}


	
}