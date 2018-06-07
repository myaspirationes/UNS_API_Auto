package com.userManagement;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;
import com.example.LoginTest;
import com.example.MetaOper;
import com.login.BackUserLoginTest;

public class LockUserTest extends HttpUtil {
// 锁定用户接口
	String url = "/uu-admin/UUuserManage/lockedUser/";
	String selectSql = "SELECT * FROM T_USER_LOCK order by CREATE_TIME DESC";
	String deleteSql = "delete FROM T_USER_LOCK where LOCKED_USER_ID = 12495396 or MSG = '测试3' or MSG = '测试4'";
	String updateSql = "update T_USER_LOCK set LOCK_DURATION = 1 where LOCKED_USER_ID = 12495396 ";
	List<Map<String,Object>> list ;
	String dataType = "perCenter81";
	List<Map> lis = new ArrayList<Map>();
	Map<Object, Object> map1 = new HashMap<Object, Object>();
	Map<Object, Object> map2 = new HashMap<Object, Object>();
	BackUserLoginTest login = new BackUserLoginTest();
	String userId=login.userId;
		
	@AfterMethod
	public void afterMethod()
	{
		MetaOper.delete(deleteSql, dataType);
	}
	
	/**
	 * 提交正确参数
	 */
	@Test
	public void postLockUserTestCorrectParameter() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");	
		lis.add(map1);		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", userId);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("LOCK_TYPE").toString()).isEqualTo("0");
		assertThat(list.get(0).get("LOCK_DURATION").toString()).isEqualTo("1");
		assertThat(list.get(0).get("MSG").toString()).isEqualTo("测试3");		
	}
	/**
	 * 用户ID为未登录用户
	 */
	////@Test
	public void postLockUserTestUserIdNotLoggedIn() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		map2.put("lockType", 2);
		map2.put("lockTime", 1);
		map2.put("opinion", "测试4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495333);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
		
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		MetaOper.read(selectSql, dataType);
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("LOCK_TYPE").toString()).isEqualTo("2");
		assertThat(list.get(0).get("LOCK_DURATION").toString()).isEqualTo("1");
		assertThat(list.get(0).get("MSG").toString()).isEqualTo("测试4");
		assertThat(list.get(1).get("LOCK_TYPE").toString()).isEqualTo("0");
		assertThat(list.get(1).get("LOCK_DURATION").toString()).isEqualTo("1");
		assertThat(list.get(1).get("MSG").toString()).isEqualTo("测试3");
		MetaOper.delete(deleteSql, dataType);
	}
	/**
	 * 用户ID为错误用户
	 */
    ////@Test
	public void postLockUserTestUserIdIsError() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		map2.put("lockType", 2);
		map2.put("lockTime", 1);
		map2.put("opinion", "测试4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1249);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 用户ID为非法字符
	 */
	////@Test
	public void postLockUserTestUserIdIllegalCharacters() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		map2.put("lockType", 2);
		map2.put("lockTime", 1);
		map2.put("opinion", "测试4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<#%%#$>");
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 用户ID为小数
	 */
	////@Test
	public void postLockUserTestUserIdIsDecimal() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		map2.put("lockType", 2);
		map2.put("lockTime", 1);
		map2.put("opinion", "测试4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "12.361245");
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 用户ID为负数
	 */
	////@Test
	public void postLockUserTestUserIdIsNegativeNumber() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		map2.put("lockType", 2);
		map2.put("lockTime", 1);
		map2.put("opinion", "测试4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -12495326);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);			
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 用户ID为空格
	 */
	////@Test
	public void postLockUserTestUserIdIsSpace() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		map2.put("lockType", 2);
		map2.put("lockTime", 1);
		map2.put("opinion", "测试4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
	
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为空
	 */
	////@Test
	public void postLockUserTestUserIdIsEmpty() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		map2.put("lockType", 2);
		map2.put("lockTime", 1);
		map2.put("opinion", "测试4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为null
	 */
	////@Test
	public void postLockUserTestUserIdIsNull() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		map2.put("lockType", 2);
		map2.put("lockTime", 1);
		map2.put("opinion", "测试4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);			
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为0
	 */
	////@Test
	public void postLockUserTestUserIdIsZero() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		map2.put("lockType", 2);
		map2.put("lockTime", 1);
		map2.put("opinion", "测试4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(500);
		//assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为String
	 */
	////@Test
	public void postLockUserTestUserIdIsString() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		map2.put("lockType", 2);
		map2.put("lockTime", 1);
		map2.put("opinion", "测试4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "dfdsfdsd");
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
		
		
	}
	/**
	 * 用户ID不传该参数
	 */
	////@Test
	public void postLockUserTestUserIdNonSubmissionParameters() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		map2.put("lockType", 2);
		map2.put("lockTime", 1);
		map2.put("opinion", "测试4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为超长
	 */
	////@Test
	public void postLockUserTestUserIdIsLong() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		map2.put("lockType", 2);
		map2.put("lockTime", 1);
		map2.put("opinion", "测试4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 999999999999999999L);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(500);
		}
	/**
	 * 锁定类型为小数
	 */
	////@Test
	public void postLockUserTestLockTypeIsDecimal() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 1.23);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		map2.put("lockType", 2.3);
		map2.put("lockTime", 1);
		map2.put("opinion", "测试4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为小数" + post);
	
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
		}
	/**
	 * 锁定类型为负数
	 */
	////@Test
	public void postLockUserTestLockTypeIsNegativeNumber() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", -1);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		map2.put("lockType", 2.3);
		map2.put("lockTime", -3);
		map2.put("opinion", "测试4");
		lis.add(map1);
		lis.add(map2);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为负数" + post);
	
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定类型为0
	 */
	//@Test
	public void postLockUserTestLockTypeIsZero() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为0" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		MetaOper.read(selectSql, dataType);
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("LOCK_TYPE").toString()).isEqualTo("0");
		assertThat(list.get(0).get("LOCK_DURATION").toString()).isEqualTo("1");
		assertThat(list.get(0).get("MSG").toString()).isEqualTo("测试3");
		
		MetaOper.delete(deleteSql, dataType);
	}
	/**
	 * 锁定类型为1禁止交易
	 */
	//@Test
	public void postLockUserTestLockTypeIs1() throws Exception {
		//MetaOper.read(selectSql, dataType);
		map1.put("lockType", 1);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为1" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		MetaOper.read(selectSql, dataType);
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("LOCK_TYPE").toString()).isEqualTo("1");
			
		MetaOper.delete(deleteSql, dataType);
	}
	/**
	 * 锁定类型为2禁止评论
	 */
	//@Test
	public void postLockUserTestLockTypeIs2() throws Exception {
		//MetaOper.read(selectSql, dataType);
		map1.put("lockType", 2);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为2" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		MetaOper.read(selectSql, dataType);
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("LOCK_TYPE").toString()).isEqualTo("2");
		assertThat(list.get(0).get("LOCK_DURATION").toString()).isEqualTo("1");
		assertThat(list.get(0).get("MSG").toString()).isEqualTo("测试3");
		
		MetaOper.delete(deleteSql, dataType);
	}
	/**
	 * 锁定类型为3禁止发动态
	 */
	//@Test
	public void postLockUserTestLockTypeIs3() throws Exception {
		
		map1.put("lockType", 3);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为3" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		MetaOper.read(selectSql, dataType);
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("LOCK_TYPE").toString()).isEqualTo("3");		
		MetaOper.delete(deleteSql, dataType);
	}
	/**
	 * 锁定类型为4禁号
	 */
	//@Test
	public void postLockUserTestLockTypeIs4() throws Exception {
		//MetaOper.read(selectSql, dataType);
		map1.put("lockType", 4);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为4" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		MetaOper.read(selectSql, dataType);
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("LOCK_TYPE").toString()).isEqualTo("4");
		
		MetaOper.delete(deleteSql, dataType);
	}
	/**
	 * 锁定类型为5封号
	 */
	//@Test
	public void postLockUserTestLockTypeIs5() throws Exception {
		//MetaOper.read(selectSql, dataType);
		map1.put("lockType", 5);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为5" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		MetaOper.read(selectSql, dataType);
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("LOCK_TYPE").toString()).isEqualTo("5");
		
		MetaOper.delete(deleteSql, dataType);
	}
	
	/**
	 * 锁定类型为String
	 */
	//@Test
	public void postLockUserTestLockTypeIsString() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", "dfdfds");
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为String" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 锁定类型为空格
	 */
	//@Test
	public void postLockUserTestLockTypeIsSpace() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", " ");
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为空格" + post);
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("锁定类型不能为空！");
	}
	/**
	 * 锁定类型为空
	 */
	//@Test
	public void postLockUserTestLockTypeIsEmpty() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", "");
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为空" + post);
	
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("锁定类型不能为空！");
	}
	/**
	 * 锁定类型为null
	 */
	//@Test
	public void postLockUserTestLockTypeIsNull() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", null);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为null" + post);
	
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("锁定类型不能为空！");
	}
	/**
	 * 锁定类型为超长
	 */
	//@Test
	public void postLockUserTestLockTypeIsLong() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 999999999999999999L);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为超长" + post);
	
	
		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定类型不提交
	 */
	//@Test
	public void postLockUserTestLockTypeNonSubmissionParameters() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型不提交" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定时长为错误
	 */
	//@Test
	public void postLockUserTestLockTimeIsError() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 99);
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为错误" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定时长为1
	 */
	//@Test
	public void postLockUserTestLockTimeIs1() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为1" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		MetaOper.read(selectSql, dataType);
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("LOCK_TYPE").toString()).isEqualTo("0");
		assertThat(list.get(0).get("LOCK_DURATION").toString()).isEqualTo("1");
		assertThat(list.get(0).get("MSG").toString()).isEqualTo("测试3");
		MetaOper.delete(deleteSql, dataType);
		
	}
	/**
	 * 锁定时长为3
	 */
	//@Test
	public void postLockUserTestLockTimeIs3() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 3);
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为3" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		MetaOper.read(selectSql, dataType);
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("LOCK_TYPE").toString()).isEqualTo("0");
		assertThat(list.get(0).get("LOCK_DURATION").toString()).isEqualTo("3");
		assertThat(list.get(0).get("MSG").toString()).isEqualTo("测试3");
		MetaOper.delete(deleteSql, dataType);
		
	}
	/**
	 * 锁定时长为7
	 */
	//@Test
	public void postLockUserTestLockTimeIs7() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 7);
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为7" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		MetaOper.read(selectSql, dataType);
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("LOCK_TYPE").toString()).isEqualTo("0");
		assertThat(list.get(0).get("LOCK_DURATION").toString()).isEqualTo("7");
		assertThat(list.get(0).get("MSG").toString()).isEqualTo("测试3");
		MetaOper.delete(deleteSql, dataType);
	}
	/**
	 * 锁定时长为15
	 */
	//@Test
	public void postLockUserTestLockTimeIs15() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 15);
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为15" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		MetaOper.read(selectSql, dataType);
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("LOCK_TYPE").toString()).isEqualTo("0");
		assertThat(list.get(0).get("LOCK_DURATION").toString()).isEqualTo("15");
		assertThat(list.get(0).get("MSG").toString()).isEqualTo("测试3");
		MetaOper.delete(deleteSql, dataType);
	}
	/**
	 * 锁定时长为30
	 */
	//@Test
	public void postLockUserTestLockTimeIs30() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 30);
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为30" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		MetaOper.read(selectSql, dataType);
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("LOCK_TYPE").toString()).isEqualTo("0");
		assertThat(list.get(0).get("LOCK_DURATION").toString()).isEqualTo("30");
		assertThat(list.get(0).get("MSG").toString()).isEqualTo("测试3");
		MetaOper.delete(deleteSql, dataType);
	}
	/**
	 * 锁定时长为100（永久）
	 */
	//@Test
	public void postLockUserTestLockTimeIs0() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 100);
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为100" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		MetaOper.read(selectSql, dataType);
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("LOCK_TYPE").toString()).isEqualTo("0");
		assertThat(list.get(0).get("LOCK_DURATION").toString()).isEqualTo("100");
		assertThat(list.get(0).get("MSG").toString()).isEqualTo("测试3");
		MetaOper.delete(deleteSql, dataType);
	}
	
	/**
	 * 锁定时长为负数
	 */
	//@Test
	public void postLockUserTestLockTimeIsNegativeNumber() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", -15);
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为负数" + post);
	
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定时长为小数
	 */
	//@Test
	public void postLockUserTestLockTimeIsDecimal() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 3.26);
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为小数" + post);
		
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定时长为空格
	 */
	@Test
	public void postLockUserTestLockTimeIsSpace() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", " ");
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为空格" + post);
	
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("锁定时长不能为空！");
	}
	/**
	 * 锁定时长为null
	 */
	@Test
	public void postLockUserTestLockTimeIsNull() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", null);
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为null" + post);
	
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("锁定时长不能为空！");
	}
	/**
	 * 锁定时长为String
	 */
	@Test
	public void postLockUserTestLockTimeIsString() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", "dfdsfs");
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为String" + post);
	
	
		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定时长为超长
	 */
	@Test
	public void postLockUserTestLockTimeIsLong() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 999999999999999999L);
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为超长" + post);
	
	
		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定时长为不传
	 */
	@Test
	public void postLockUserTestLockTimeNonSubmissionParameters() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("opinion", "测试3");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为不传" + post);
	
	
		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("锁定时长不能为空！");
	}
	/**
	 * 处理意见为超长
	 */
	@Test
	public void postLockUserTesTOpinionIsLong() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3fdsfgs犯得上广泛的更高的灌灌灌灌官方规定和国防会议u盈亏焊接方法的身份");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为超长" + post);
	
	
		assertThat(post.get("status")).isEqualTo(500);
		//assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 处理意见为空
	 */
	@Test
	public void postLockUserTestOpinionIsEmpty() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", "");		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为空" + post);
		
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");	
		MetaOper.read(selectSql, dataType);
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("MSG")).isEqualTo("");
		
		MetaOper.delete(deleteSql, dataType);
	}
	/**
	 * 处理意见为null
	 */
	@Test
	public void postLockUserTestOpinionIsNull() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", null);
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为null" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		MetaOper.read(selectSql, dataType);
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("MSG")).isEqualTo(null);
		
		MetaOper.delete(deleteSql, dataType);
	}
	/**
	 * 处理意见为空格
	 */
	@Test
	public void postLockUserTestOpinionIsSpace() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", " ");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为空格" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		MetaOper.read(selectSql, dataType);
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("MSG")).isEqualTo(" ");
		
		MetaOper.delete(deleteSql, dataType);
	}
	/**
	 * 处理意见为非法字符
	 */
	@Test
	public void postLockUserOpinionIsIllegalCharacters() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", "<#%@%@>");
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为非法字符" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		MetaOper.read(selectSql, dataType);
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("MSG").toString()).isEqualTo("<#%@%@>");
		
		MetaOper.delete(deleteSql, dataType);
	}
	/**
	 * 处理意见不提交
	 */
	@Test
	public void postLockUserTestOpinionNonSubmissionParameters() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJson");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见不提交" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("操作成功");
		MetaOper.read(selectSql, dataType);
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("MSG").toString()).isEqualTo("");
		
		MetaOper.delete(deleteSql, dataType);
	}
	/**
	 * 处理人姓名为错误
	 */
	@Test
	public void postLockUserTestOperatorNameIsError() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "BeJsonfsdf");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理人姓名为错误" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 处理人姓名为空
	 */
	@Test
	public void postLockOperatorTestUserNameIsEmpty() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理人姓名为空" + post);
	
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 处理人姓名为空格
	 */
	@Test
	public void postLockOperatorTestUserNameIsSpace() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", " ");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理人姓名为空格" + post);
	
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 处理人姓名为null
	 */
	@Test
	public void postLockOperatorTestUserNameIsNull() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", null);
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理人姓名为null" + post);
	
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("处理人姓名不能为空！");
	}
	/**
	 * 处理人姓名非法字符
	 */
	@Test
	public void postLockOperatorTestUserNameIsIllegalCharacters() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorName", "<$%@$>");
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理人姓名非法字符" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 处理人姓名不传
	 */
	@Test
	public void postLockOperatorTestUserNameIsNonSubmissionParameters() throws Exception {
		MetaOper.read(selectSql, dataType);
		map1.put("lockType", 0);
		map1.put("lockTime", 1);
		map1.put("opinion", "测试3");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("operatorId", 12491738);
		request.put("userLockDTO", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理人姓名不传" + post);
	
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("处理人姓名不能为空！");
	}
	
	
}