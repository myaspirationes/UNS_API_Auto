package com.publicModule.userManagement;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class UnLockedUserTest extends HttpUtil {
// 解锁用户锁定内容接口
	String url = "/uu-admin/UUuserManage/unLockedUser";
	String userId;
	String deleteSql = "delete FROM T_USER_LOCK where LOCKED_USER_ID = 12495396 or MSG = '测试3' or MSG = '测试4'";
	String dataType = "perCenter81";
	String selectSql = "SELECT * FROM T_USER_LOCK WHERE  MSG = '测试3'";
	String lockId;
	String lockedUserId;
	List<Map<String,Object>> list ;
	@BeforeClass
	public void beforeClass(){

		userId = new BackUserLoginTest().userId;

	}
	@BeforeMethod
	public void beforeMethod()throws Exception{
		new	LockUserTest().postLockUserTestCorrectParameter();
		list = MetaOper.read(selectSql,dataType);
		lockId = list.get(0).get("LOCK_ID").toString();

	}
	@AfterMethod
	public void afterMethod(){

		MetaOper.delete(deleteSql, dataType);
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetUserOperateLogTestCorrectParameter() throws Exception {
		String LuidSql = "SELECT * FROM T_USER_LOCK WHERE LOCK_ID ="+lockId;
		list = MetaOper.read(selectSql,dataType);
		lockedUserId = list.get(0).get("LOCKED_USER_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", lockedUserId);
		request.put("operatorId", userId);
		request.put("lockId", lockId);

		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("STATUS").toString()).isEqualTo("0");

	}
	/**
	 * 用户ID为未登录
	 */
	@Test
	public void postGetUserOperateLogTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", lockedUserId);
		request.put("operatorId", userId);
		request.put("lockId", lockId);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");

	}
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postGetUserOperateLogTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "123123");
		request.put("operatorId", userId);
		request.put("lockId", lockId);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");

	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postGetUserOperateLogTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<!@#$>");
		request.put("operatorId", userId);
		request.put("lockId", lockId);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");

	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postGetUserOperateLogTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12.12);
		request.put("operatorId", userId);
		request.put("lockId", lockId);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");

	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postGetUserOperateLogTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -11);
		request.put("operatorId", userId);
		request.put("lockId", lockId);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");

	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postGetUserOperateLogTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);
		request.put("operatorId", userId);
		request.put("lockId", lockId);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");

	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postGetUserOperateLogTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "lockedUserId");
		request.put("operatorId", userId);
		request.put("lockId", lockId);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");

	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postGetUserOperateLogTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("operatorId", userId);
		request.put("lockId", lockId);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");

	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postGetUserOperateLogTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("operatorId", userId);
		request.put("lockId", lockId);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");

	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postGetUserOperateLogTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("operatorId", userId);
		request.put("lockId", lockId);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");

	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postGetUserOperateLogTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("operatorId", userId);
		request.put("lockId", lockId);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");

	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postGetUserOperateLogTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12312312312312313L);
		request.put("operatorId", userId);
		request.put("lockId", lockId);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");

	}

	/**
	 * 被锁定用户ID超长
	 */
	@Test
	public void postGetUserOperateLogTestOperatorIdIsLong() throws Exception {
		String LuidSql = "SELECT * FROM T_USER_LOCK WHERE LOCK_ID ="+lockId;
		list = MetaOper.read(selectSql,dataType);
		lockedUserId = list.get(0).get("LOCKED_USER_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", lockedUserId);
		request.put("operatorId", 123442223334422334L);
		request.put("lockId", lockId);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("被锁定用户ID超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("STATUS").toString()).isEqualTo("0");

	}
	/**
	 * 被锁定用户ID非法字符
	 */
	@Test
	public void postGetUserOperateLogTestOperatorIdIllegalCharacters() throws Exception {
		String LuidSql = "SELECT * FROM T_USER_LOCK WHERE LOCK_ID ="+lockId;
		list = MetaOper.read(selectSql,dataType);
		lockedUserId = list.get(0).get("LOCKED_USER_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", lockedUserId);
		request.put("operatorId", "<.#$%>");
		request.put("lockId", lockId);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("被锁定用户ID非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("STATUS").toString()).isEqualTo("0");

	}
	/**
	 * 被锁定用户ID错误
	 */
	@Test
	public void postGetUserOperateLogTestOperatorIdIsError() throws Exception {
		String LuidSql = "SELECT * FROM T_USER_LOCK WHERE LOCK_ID ="+lockId;
		list = MetaOper.read(selectSql,dataType);
		lockedUserId = list.get(0).get("LOCKED_USER_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", lockedUserId);
		request.put("operatorId", 2111);
		request.put("lockId", lockId);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("被锁定用户ID错误" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("STATUS").toString()).isEqualTo("0");

	}
	/**
	 * 被锁定用户ID为空
	 */
	@Test
	public void postGetUserOperateLogTestOperatorIdIsEmpty() throws Exception {
		String LuidSql = "SELECT * FROM T_USER_LOCK WHERE LOCK_ID ="+lockId;
		list = MetaOper.read(selectSql,dataType);
		lockedUserId = list.get(0).get("LOCKED_USER_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", lockedUserId);
		request.put("operatorId", "");
		request.put("lockId", lockId);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("被锁定用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("STATUS").toString()).isEqualTo("0");

	}
	/**
	 * 被锁定用户ID为空格
	 */
	@Test
	public void postGetUserOperateLogTestOperatorIdIsSpace() throws Exception {
		String LuidSql = "SELECT * FROM T_USER_LOCK WHERE LOCK_ID ="+lockId;
		list = MetaOper.read(selectSql,dataType);
		lockedUserId = list.get(0).get("LOCKED_USER_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", lockedUserId);
		request.put("operatorId", " ");
		request.put("lockId", lockId);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("被锁定用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("STATUS").toString()).isEqualTo("0");

	}
	/**
	 * 被锁定用户ID为String
	 */
	@Test
	public void postGetUserOperateLogTestOperatorIdIsString() throws Exception {
		String LuidSql = "SELECT * FROM T_USER_LOCK WHERE LOCK_ID ="+lockId;
		list = MetaOper.read(selectSql,dataType);
		lockedUserId = list.get(0).get("LOCKED_USER_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", lockedUserId);
		request.put("operatorId", "userId");
		request.put("lockId", lockId);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("被锁定用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("STATUS").toString()).isEqualTo("0");

	}
	/**
	 * 被锁定用户ID为null
	 */
	@Test
	public void postGetUserOperateLogTestOperatorINull() throws Exception {
		String LuidSql = "SELECT * FROM T_USER_LOCK WHERE LOCK_ID ="+lockId;
		list = MetaOper.read(selectSql,dataType);
		lockedUserId = list.get(0).get("LOCKED_USER_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", lockedUserId);
		request.put("operatorId", null);
		request.put("lockId", lockId);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("被锁定用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("STATUS").toString()).isEqualTo("0");

	}
	/**
	 * 被锁定用户ID不传该参数
	 */
	@Test
	public void postGetUserOperateLogTestOperatorIdNonSubmissionParameters() throws Exception {
		String LuidSql = "SELECT * FROM T_USER_LOCK WHERE LOCK_ID ="+lockId;
		list = MetaOper.read(selectSql,dataType);
		lockedUserId = list.get(0).get("LOCKED_USER_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", lockedUserId);
		request.put("lockId", lockId);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("被锁定用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("STATUS").toString()).isEqualTo("0");

	}
	/**
	 * 被锁定用户ID小数
	 */
	@Test
	public void postGetUserOperateLogTestOperatorIdIsDecimal() throws Exception {
		String LuidSql = "SELECT * FROM T_USER_LOCK WHERE LOCK_ID ="+lockId;
		list = MetaOper.read(selectSql,dataType);
		lockedUserId = list.get(0).get("LOCKED_USER_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", lockedUserId);
		request.put("operatorId", 1.2);
		request.put("lockId", lockId);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("被锁定用户ID小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("STATUS").toString()).isEqualTo("0");

	}
	/**
	 * 被锁定用户ID为负数
	 */
	@Test
	public void postGetUserOperateLogTestOperatorIdIsNegativeNumber() throws Exception {
		String LuidSql = "SELECT * FROM T_USER_LOCK WHERE LOCK_ID ="+lockId;
		list = MetaOper.read(selectSql,dataType);
		lockedUserId = list.get(0).get("LOCKED_USER_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", lockedUserId);
		request.put("operatorId", -1);
		request.put("lockId", lockId);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("被锁定用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("STATUS").toString()).isEqualTo("0");

	}
	/**
	 * 被锁定用户ID为0
	 */
	@Test
	public void postGetUserOperateLogTestOperatorIdIsZero() throws Exception {
		String LuidSql = "SELECT * FROM T_USER_LOCK WHERE LOCK_ID ="+lockId;
		list = MetaOper.read(selectSql,dataType);
		lockedUserId = list.get(0).get("LOCKED_USER_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", lockedUserId);
		request.put("operatorId", 0);
		request.put("lockId", lockId);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("被锁定用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("STATUS").toString()).isEqualTo("0");

	}
	/**
	 * 锁定内容ID错误
	 */
	@Test
	public void postGetUserOperateLogTestLockIdIsError() throws Exception {
		String LuidSql = "SELECT * FROM T_USER_LOCK WHERE LOCK_ID ="+lockId;
		list = MetaOper.read(selectSql,dataType);
		lockedUserId = list.get(0).get("LOCKED_USER_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", lockedUserId);
		request.put("operatorId", userId);
		request.put("lockId", 1000);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定内容ID错误" + post);

		assertThat(post.get("status")).isEqualTo(500);

	}
	/**
	 * 锁定内容ID为空
	 */
	@Test
	public void postGetUserOperateLogTestLockIdIsEmpty() throws Exception {
		String LuidSql = "SELECT * FROM T_USER_LOCK WHERE LOCK_ID ="+lockId;
		list = MetaOper.read(selectSql,dataType);
		lockedUserId = list.get(0).get("LOCKED_USER_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", lockedUserId);
		request.put("operatorId", userId);
		request.put("lockId", "");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定内容ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("锁定内容Id不能为空！");

	}
	/**
	 * 锁定内容ID空格
	 */
	@Test
	public void postGetUserOperateLogTestLockIdIsSpace() throws Exception {
		String LuidSql = "SELECT * FROM T_USER_LOCK WHERE LOCK_ID ="+lockId;
		list = MetaOper.read(selectSql,dataType);
		lockedUserId = list.get(0).get("LOCKED_USER_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", lockedUserId);
		request.put("operatorId", userId);
		request.put("lockId", " ");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定内容ID空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("STATUS").toString()).isEqualTo("0");

	}
	/**
	 * 锁定内容ID为0
	 */
	@Test
	public void postGetUserOperateLogTestLockIdIsZero() throws Exception {
		String LuidSql = "SELECT * FROM T_USER_LOCK WHERE LOCK_ID ="+lockId;
		list = MetaOper.read(selectSql,dataType);
		lockedUserId = list.get(0).get("LOCKED_USER_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", lockedUserId);
		request.put("operatorId", userId);
		request.put("lockId", 0);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定内容ID为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("STATUS").toString()).isEqualTo("0");

	}
	/**
	 * 锁定内容ID为小数
	 */
	@Test
	public void postGetUserOperateLogTestLockIdIsDecimal() throws Exception {
		String LuidSql = "SELECT * FROM T_USER_LOCK WHERE LOCK_ID ="+lockId;
		list = MetaOper.read(selectSql,dataType);
		lockedUserId = list.get(0).get("LOCKED_USER_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", lockedUserId);
		request.put("operatorId", userId);
		request.put("lockId", 1.1);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定内容ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(500);

	}
	/**
	 * 锁定内容ID为负数
	 */
	@Test
	public void postGetUserOperateLogTestLockIdIsNegativeNumber() throws Exception {
		String LuidSql = "SELECT * FROM T_USER_LOCK WHERE LOCK_ID ="+lockId;
		list = MetaOper.read(selectSql,dataType);
		lockedUserId = list.get(0).get("LOCKED_USER_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", lockedUserId);
		request.put("operatorId", userId);
		request.put("lockId", -1);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定内容ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("STATUS").toString()).isEqualTo("0");

	}
	/**
	 * 锁定内容ID为String
	 */
	@Test
	public void postGetUserOperateLogTestLockIdIsString() throws Exception {
		String LuidSql = "SELECT * FROM T_USER_LOCK WHERE LOCK_ID ="+lockId;
		list = MetaOper.read(selectSql,dataType);
		lockedUserId = list.get(0).get("LOCKED_USER_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", lockedUserId);
		request.put("operatorId", userId);
		request.put("lockId", "lockId");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定内容ID为String" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("STATUS").toString()).isEqualTo("0");

	}
	/**
	 * 锁定内容ID为null
	 */
	@Test
	public void postGetUserOperateLogTestLockIdIsNull() throws Exception {
		String LuidSql = "SELECT * FROM T_USER_LOCK WHERE LOCK_ID ="+lockId;
		list = MetaOper.read(selectSql,dataType);
		lockedUserId = list.get(0).get("LOCKED_USER_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", lockedUserId);
		request.put("operatorId", userId);
		request.put("lockId", null);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定内容ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("STATUS").toString()).isEqualTo("0");

	}
	/**
	 * 锁定内容ID为非法字符
	 */
	@Test
	public void postGetUserOperateLogTestLockIdIllegalCharacters() throws Exception {
		String LuidSql = "SELECT * FROM T_USER_LOCK WHERE LOCK_ID ="+lockId;
		list = MetaOper.read(selectSql,dataType);
		lockedUserId = list.get(0).get("LOCKED_USER_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", lockedUserId);
		request.put("operatorId", userId);
		request.put("lockId", "<.@#$>");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定内容ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);

	}
	/**
	 * 锁定内容ID为超长
	 */
	@Test
	public void postGetUserOperateLogTestLockIdIsLong() throws Exception {
		String LuidSql = "SELECT * FROM T_USER_LOCK WHERE LOCK_ID ="+lockId;
		list = MetaOper.read(selectSql,dataType);
		lockedUserId = list.get(0).get("LOCKED_USER_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", lockedUserId);
		request.put("operatorId", userId);
		request.put("lockId", 1234123412341231234L);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定内容ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("STATUS").toString()).isEqualTo("0");

	}
	/**
	 * 锁定内容ID不传该参数
	 */
	@Test
	public void postGetUserOperateLogTestLockIdNonSubmissionParameters() throws Exception {
		String LuidSql = "SELECT * FROM T_USER_LOCK WHERE LOCK_ID ="+lockId;
		list = MetaOper.read(selectSql,dataType);
		lockedUserId = list.get(0).get("LOCKED_USER_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", lockedUserId);
		request.put("operatorId", userId);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定内容ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(500);

	}
	
}