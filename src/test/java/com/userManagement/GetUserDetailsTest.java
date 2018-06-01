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

public class GetUserDetailsTest extends HttpUtil {
// 获取用户详情接口
	String url = "/uu-admin/UUuserManage/getUserDetails";


	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetUserDetailsTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("uid", 12495324);					
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postGetUserDetailsTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("uid", 12495329);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postGetUserDetailsTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("uid", 124953999);
		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postGetUserDetailsTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("uid", "");
		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postGetUserDetailsTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 121123.33);
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postGetUserDetailsTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -121312);	
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);				
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postGetUserDetailsTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");		
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
			
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户不能为空");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postGetUserDetailsTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");	
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户不能为空");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postGetUserDetailsTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);	
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
					
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户不能为空");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postGetUserDetailsTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);	
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);		

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postGetUserDetailsTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "fsddf");	
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);		

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postGetUserDetailsTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户不能为空");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postGetUserDetailsTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 999999999999999999L);	
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 昵称为超长
	 */
	@Test
	public void postGetUserDetailsTestNickNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		request.put("nickname", "测试DDDDddd顶顶顶顶顶顶顶顶顶打发打发发士大夫十分犯得上方法犯得上方法是打发士大夫");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为超长" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 昵称含有非法字符
	 */
	@Test
	public void postGetUserDetailsTestNickNameIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		request.put("nickname", "<@$%^&>");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称含有非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 昵称为空
	 */
	@Test
	public void postGetUserDetailsTestNickNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		request.put("nickname", "");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为空" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 昵称为空格
	 */
	@Test
	public void postGetUserDetailsTestNickNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		request.put("nickname", " ");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为空格" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 昵称为null
	 */
	@Test
	public void postGetUserDetailsTestNickNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		request.put("nickname", null);
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为null" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 昵称为不传该参数
	 */
	@Test
	public void postGetUserDetailsTestNickNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 手机号为超11位
	 */
	@Test
	public void postGetUserDetailsTestMobileIsOver11() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828456");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号为超11位" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手机号小于11位
	 */
	@Test
	public void postGetUserDetailsTestMobileIsLeast11() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号小于11位" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手机号码为区号加固话（02160790211）
	 */
	@Test
	public void postGetUserDetailsTestMobileIsAreaCodePlusSolid() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "02160790211");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为区号加固话（02160790211）" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手机号前+86
	 */
	@Test
	public void postGetUserDetailsTestMobileBeforeAdd86() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "+8615617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号前+86" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手机号前加00
	 */
	@Test
	public void postGetUserDetailsTestMobileBeforeAdd00() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "0015617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号前加00" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手机号码前面加长途号码17951
	 */
	@Test
	public void postGetUserDetailsTestMobileBeforeAdd17951() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "1795115617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码前面加长途号码17951" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手机号含有非法字符
	 */
	@Test
	public void postGetUserDetailsTestMobileIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "<167%#$^8&>");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号含有非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手机号为0
	 */
	@Test
	public void postGetUserDetailsTestMobileIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", 0);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号为0" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手机号为null
	 */
	@Test
	public void postGetUserDetailsTestMobileIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", null);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手机号为空
	 */
	@Test
	public void postGetUserDetailsTestMobileIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手机号为空格
	 */
	@Test
	public void postGetUserDetailsTestMobileIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", " ");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手机号为小数
	 */
	@Test
	public void postGetUserDetailsTestMobileIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "12.56894512");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手机号为负数
	 */
	@Test
	public void postGetUserDetailsTestMobileIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "-12452");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手机号码为非1开头
	 */
	@Test
	public void postGetUserDetailsTestMobileIsStartNon1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "45617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为非1开头" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手机号码格式为xxx-xxxx-xxxx
	 */
	@Test
	public void postGetUserDetailsTestMobileIsFormat344() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "156-1784-3828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码格式为xxx-xxxx-xxxx" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手机号不传该参数
	 */
	@Test
	public void postGetUserDetailsTestMobileNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 注册时间(开始) 传错误格式
	 */
	@Test
	public void postGetUserDetailsTestStartTimeIsErrorFormat() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018/01/01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("注册时间(开始) 传错误格式" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 开始时间小于结束时间
	 */
	@Test
	public void postGetUserDetailsTestStartTimeIsLeastEndTime() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间小于结束时间" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 开始时间大于结束时间
	 */
	@Test
	public void postGetUserDetailsTestStartTimeIsMoreEndTime() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-03-01");
		request.put("endTime", "2018-01-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间大于结束时间" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 开始时间传时间戳
	 */
	@Test
	public void postGetUserDetailsTestStartTimeIsTimeStamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "1527747350");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传时间戳" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 开始时间传年月日
	 */
	@Test
	public void postGetUserDetailsTestStartTimeIsYearMonthDay() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传年月日" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 开始时间传时分秒
	 */
	@Test
	public void postGetUserDetailsTestStartTimeIsHourMinSec() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "12:00:12");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传时分秒" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 开始时间传空格
	 */
	@Test
	public void postGetUserDetailsTestStartTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", " ");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 开始时间传数字去掉中间格式
	 */
	@Test
	public void postGetUserDetailsTestStartTimeIsNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "20180101");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传数字去掉中间格式" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 开始时间传空
	 */
	@Test
	public void postGetUserDetailsTestStartTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传空" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 开始时间传null
	 */
	@Test
	public void postGetUserDetailsTestStartTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", null);
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传null" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 开始时间不传该参数
	 */
	@Test
	public void postGetUserDetailsTestStartTimeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 开始时间传负数
	 */
	@Test
	public void postGetUserDetailsTestStartTimeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "-2018");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传空" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 开始时间传年月日最大值
	 */
	@Test
	public void postGetUserDetailsTestStartTimeIsYearMonthDayMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "9999-12-31");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传年月日最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 开始时间传年月日最小时间
	 */
	@Test
	public void postGetUserDetailsTestStartTimeIsYearMonthDayMin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "0001-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传年月日最小时间" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 开始时间传时分秒最大时间
	 */
	@Test
	public void postGetUserDetailsTestStartTimeIsHourMinSecMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "23:59:59");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传时分秒最大时间" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 开始时间传时分秒最小时间
	 */
	@Test
	public void postGetUserDetailsTestStartTimeIsHourMinSecMin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "00:00:00");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传时分秒最小时间" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 开始时间传年月日时分秒
	 */
	@Test
	public void postGetUserDetailsTestStartTimeIsYearMonthDayHourMinSec() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01 12:12:12");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传年月日时分秒" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 结束时间传错误格式
	 */
	@Test
	public void postGetUserDetailsTestEndTimeIsErrorFormat() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018/05/17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传错误格式" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 结束时间传时间戳
	 */
	@Test
	public void postGetUserDetailsTestEndTimeIsTimeStamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "1527747350");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传时间戳" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 结束时间传年月日
	 */
	@Test
	public void postGetUserDetailsTestEndTimeIsYearMonthDay() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传年月日" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 结束时间传时分秒
	 */
	@Test
	public void postGetUserDetailsTestEndTimeIsHourMinSec() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "10:22:11");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传时分秒" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 结束时间传空格
	 */
	@Test
	public void postGetUserDetailsTestEndTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", " ");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 结束时间传数字去掉中间格式
	 */
	@Test
	public void postGetUserDetailsTestEndTimeIsNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "20180517");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传数字去掉中间格式" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 结束时间传空
	 */
	@Test
	public void postGetUserDetailsTestEndTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传空" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 结束时间传null
	 */
	@Test
	public void postGetUserDetailsTestEndTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", null);
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传null" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 结束时间不传该参数
	 */
	@Test
	public void postGetUserDetailsTestEndTimeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 结束时间传负数
	 */
	@Test
	public void postGetUserDetailsTestEndTimeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "-12345");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传负数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 结束时间传小数
	 */
	@Test
	public void postGetUserDetailsTestEndTimeIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "12.564");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传小数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 结束时间传年月日最大值
	 */
	@Test
	public void postGetUserDetailsTestEndTimeIsYearMonDayMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传年月日最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 结束时间传时分秒最大时间
	 */
	@Test
	public void postGetUserDetailsTestEndTimeIsHourMinSecMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "23:59:59");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传时分秒最大时间" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 结束时间传时分秒最小时间
	 */
	@Test
	public void postGetUserDetailsTestEndTimeIsHourMinSecLeast() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "00:00:00");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传时分秒最小时间" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 结束时间传年月日最小时间
	 */
	@Test
	public void postGetUserDetailsTestEndTimeIsYearMonDayLeast() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "0001-01-01");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传年月日最小时间" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 结束时间传年月日时分秒
	 */
	@Test
	public void postGetUserDetailsTestEndTimeIsYearMonDayHourMinSec() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17 14:12:10");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传年月日时分秒" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为0未锁定
	 */
	@Test
	public void postGetUserDetailsTestStatusIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为0未锁定" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为1锁定
	 */
	@Test
	public void postGetUserDetailsTestStatusIsOne() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为1锁定" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为2全部
	 */
	@Test
	public void postGetUserDetailsTestStatusIsTwo() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 2);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为2全部" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为错误
	 */
	@Test
	public void postGetUserDetailsTestStatusIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 99);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为错误" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为负数
	 */
	@Test
	public void postGetUserDetailsTestStatusIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", -2);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为小数
	 */
	@Test
	public void postGetUserDetailsTestStatusIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1.2);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为空格
	 */
	@Test
	public void postGetUserDetailsTestStatusIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", " ");
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为空
	 */
	@Test
	public void postGetUserDetailsTestStatusIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", "");
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为null
	 */
	@Test
	public void postGetUserDetailsTestStatusIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", null);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为String
	 */
	@Test
	public void postGetUserDetailsTestStatusIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", "gdgfd");
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为String" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为最大值
	 */
	@Test
	public void postGetUserDetailsTestStatusIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 999999999);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为不传
	 */
	@Test
	public void postGetUserDetailsTestStatusNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为0未锁定，再传1
	 */
	@Test
	public void postGetUserDetailsTestStatusIsZeroAgainOne() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为0未锁定，再传1" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为0未锁定，再传0
	 */
	@Test
	public void postGetUserDetailsTestStatusIs0Again0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为0未锁定，再传0" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为1已锁定，再传0
	 */
	@Test
	public void postGetUserDetailsTestStatusIs1Again0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为1已锁定，再传0" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为1已锁定，再传1
	 */
	@Test
	public void postGetUserDetailsTestStatusIs1Again1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495682);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * app端用户id错误
	 */
	@Test
	public void postGetUserDetailsTestUidIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495688);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("app端用户id错误" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * app端用户id超长
	 */
	@Test
	public void postGetUserDetailsTestUidIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 124956822222222222L);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("app端用户id超长" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * app端用户id传空
	 */
	@Test
	public void postGetUserDetailsTestUidIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", "");
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("app端用户id传空" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * app端用户id传空格
	 */
	@Test
	public void postGetUserDetailsTestUidIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", " ");
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("app端用户id传空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * app端用户id传null
	 */
	@Test
	public void postGetUserDetailsTestUidIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", null);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("app端用户id传null" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * app端用户id传0
	 */
	@Test
	public void postGetUserDetailsTestUidIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 0);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("app端用户id传0" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * App端用户id传负数
	 */
	@Test
	public void postGetUserDetailsTestUidIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", -123456);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("App端用户id传负数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * app端用户id传小数
	 */
	@Test
	public void postGetUserDetailsTestUidIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12.456);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("app端用户id传小数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * app端用户id传String
	 */
	@Test
	public void postGetUserDetailsTestUidIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", "grrtwe");
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("app端用户id传String" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * app端用户id不传
	 */
	@Test
	public void postGetUserDetailsTestUidNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("app端用户id不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 每页显示行数pageSize为超长
	 */
	@Test
	public void postGetUserDetailsTestPageSizeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495682);
		request.put("pageSize", 999999999999999999L);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示行数pageSize为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示行数pageSize为0
	 */
	@Test
	public void postGetUserDetailsTestPageSizeIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495682);
		request.put("pageSize", 0);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示行数pageSize为0" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示行数pageSize为String
	 */
	@Test
	public void postGetUserDetailsTestPageSizeIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495682);
		request.put("pageSize", "DSFSAS");
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示行数pageSize为String" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示行数pageSize为空
	 */
	@Test
	public void postGetUserDetailsTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495682);
		request.put("pageSize", "");
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示行数pageSize为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示行数pageSize为空格
	 */
	@Test
	public void postGetUserDetailsTestPageSizeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495682);
		request.put("pageSize", " ");
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示行数pageSize为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示行数pageSize为null
	 */
	@Test
	public void postGetUserDetailsTestPageSizeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495682);
		request.put("pageSize", null);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示行数pageSize为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示行数pageSize为负数
	 */
	@Test
	public void postGetUserDetailsTestPageSizeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495682);
		request.put("pageSize", -3);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示行数pageSize为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 每页显示行数pageSize为小数
	 */
	@Test
	public void postGetUserDetailsTestPageSizeIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495682);
		request.put("pageSize", 1.3);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示行数pageSize为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示行数pageSize不传
	 */
	@Test
	public void postGetUserDetailsTestPageSizeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495682);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示行数pageSize不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页pageNow传空
	 */
	@Test
	public void postGetUserDetailsTestPageNowIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495682);
		request.put("pageSize", 1);
		request.put("pageNow", "");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页pageNow传空" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页pageNow传空格
	 */
	@Test
	public void postGetUserDetailsTestPageNowIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495682);
		request.put("pageSize", 1);
		request.put("pageNow", " ");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页pageNow传空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页pageNow传null
	 */
	@Test
	public void postGetUserDetailsTestPageNowIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495682);
		request.put("pageSize", 1);
		request.put("pageNow", null);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页pageNow传null" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页pageNow传小数
	 */
	@Test
	public void postGetUserDetailsTestPageNowIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495682);
		request.put("pageSize", 1);
		request.put("pageNow", 1.2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页pageNow传小数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页pageNow传0
	 */
	@Test
	public void postGetUserDetailsTestPageNowIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495682);
		request.put("pageSize", 1);
		request.put("pageNow", 0);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页pageNow传0" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页pageNow不传
	 */
	@Test
	public void postGetUserDetailsTestPageNowNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("nickname", "测试");
		request.put("mobile", "15617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495682);
		request.put("pageSize", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页pageNow不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
}