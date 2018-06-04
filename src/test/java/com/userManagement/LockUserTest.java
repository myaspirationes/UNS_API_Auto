package com.userManagement;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;

public class LockUserTest extends HttpUtil {
// 获取用户详情接口
	String url = "/uu-admin/UUuserManage/lockedUser/";


	/**
	 * 提交正确参数
	 */
	@Test
	public void postLockUserTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postLockUserTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495329);
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postLockUserTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 124953999);
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postLockUserTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<#%%#$>");
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postLockUserTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 121123.33);
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postLockUserTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -121312);	
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");			
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postLockUserTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");		
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户不能为空");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postLockUserTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");	
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户不能为空");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postLockUserTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);	
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");			
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户不能为空");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postLockUserTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);	
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postLockUserTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "fsddf");	
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
		
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postLockUserTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户不能为空");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postLockUserTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 999999999999999999L);	
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定类型为小数
	 */
	@Test
	public void postLockUserTestLockTypeIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 1.2);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为小数" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定类型为负数
	 */
	@Test
	public void postLockUserTestLockTypeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", -1);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为负数" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定类型为0
	 */
	@Test
	public void postLockUserTestLockTypeIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为0" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定类型为1禁止交易
	 */
	@Test
	public void postLockUserTestLockTypeIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 1);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为1禁止交易" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定类型为2禁止评论
	 */
	@Test
	public void postLockUserTestLockTypeIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 2);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为2禁止评论" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定类型为3禁止发动态
	 */
	@Test
	public void postLockUserTestLockTypeIs3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 3);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为3禁止发动态" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定类型为4禁号
	 */
	@Test
	public void postLockUserTestLockTypeIs4() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 4);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为4禁号" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定类型为5封号
	 */
	@Test
	public void postLockUserTestLockTypeIs5() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 5);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为5封号" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定类型先传1再传1
	 */
	@Test
	public void postLockUserTestLockTypeIs1Again1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 1);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型先传1再传1" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定类型先传1再传3
	 */
	@Test
	public void postLockUserTestLockTypeIs1Again3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 3);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型先传1再传3" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定类型为String
	 */
	@Test
	public void postLockUserTestLockTypeIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", "sfdf");
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为String" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定类型为空格
	 */
	@Test
	public void postLockUserTestLockTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", " ");
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为空格" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定类型为空
	 */
	@Test
	public void postLockUserTestLockTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", "");
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为空" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 锁定类型为null
	 */
	@Test
	public void postLockUserTestLockTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", null);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为null" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定类型为超长
	 */
	@Test
	public void postLockUserTestLockTypeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 999999999999999999L);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型为超长" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定类型不提交
	 */
	@Test
	public void postLockUserTestLockTypeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定类型不提交" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定时长为错误
	 */
	@Test
	public void postLockUserTestLockTimeIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", 99);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为错误" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定时长为1
	 */
	@Test
	public void postLockUserTestLockTimeIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为1" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定时长为3
	 */
	@Test
	public void postLockUserTestLockTimeIs3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", 3);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为3" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定时长为7
	 */
	@Test
	public void postLockUserTestLockTimeIs7() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", 7);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为7" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定时长为15
	 */
	@Test
	public void postLockUserTestLockTimeIs15() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", 15);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为15" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定时长为30
	 */
	@Test
	public void postLockUserTestLockTimeIs30() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", 30);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为30" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定时长为100（永久）
	 */
	@Test
	public void postLockUserTestLockTimeIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", 100);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为100（永久）" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定时长先传1再传3
	 */
	@Test
	public void postLockUserTestLockTimeIs1Again3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", 3);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长先传1再传3" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定时长先传3再传3
	 */
	@Test
	public void postLockUserTestLockTimeIs3Again3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", 3);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长先传3再传3" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定时长为负数
	 */
	@Test
	public void postLockUserTestLockTimeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", -3);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为负数" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定时长为小数
	 */
	@Test
	public void postLockUserTestLockTimeIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", 1.2);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
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
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", " ");
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为空格" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定时长为null
	 */
	@Test
	public void postLockUserTestLockTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", null);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为null" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定时长为String
	 */
	@Test
	public void postLockUserTestLockTimeIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", "fsgffg");
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为String" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定时长为超长
	 */
	@Test
	public void postLockUserTestLockTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", 999999999999999999L);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为超长" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 锁定时长为不传
	 */
	@Test
	public void postLockUserTestLockTimeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("锁定时长为不传" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 处理意见为超长
	 */
	@Test
	public void postLockUserTesTOpinionIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", "意见的反对犯得上发射点发发的顺丰顺丰发地方大师傅犯得上发射点发生");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为超长" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 处理意见为空
	 */
	@Test
	public void postLockUserTestOpinionIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", "");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为空" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 处理意见为null
	 */
	@Test
	public void postLockUserTestOpinionIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", null);
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为null" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 处理意见为空格
	 */
	@Test
	public void postLockUserTestOpinionIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", " ");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为空格" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 处理意见为非法字符
	 */
	@Test
	public void postLockUserOpinionIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", "<@%^&%$>");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为非法字符" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 处理意见不提交
	 */
	@Test
	public void postLockUserTestOpinionNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见不提交" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 处理人姓名为错误
	 */
	@Test
	public void postLockUserTestUserNameIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理人姓名为错误" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 处理人姓名为空
	 */
	@Test
	public void postLockUserTestUserNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理人姓名为空" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 处理人姓名为空格
	 */
	@Test
	public void postLockUserTestUserNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "无名氏");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理人姓名为空格" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 处理人姓名为null
	 */
	@Test
	public void postLockUserTestUserNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理人姓名为null" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 处理人姓名非法字符
	 */
	@Test
	public void postLockUserTestUserNameIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		request.put("userName", "<@$^%$>");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理人姓名非法字符" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 处理人姓名不传
	 */
	@Test
	public void postLockUserTestUserNameIsNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);
		request.put("lockType", 0);
		request.put("lockTime", 1);
		request.put("opinion", "意见");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理人姓名不传" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	
	
}