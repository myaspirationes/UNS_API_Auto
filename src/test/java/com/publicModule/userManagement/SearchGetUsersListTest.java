package com.publicModule.userManagement;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;

public class SearchGetUsersListTest extends HttpUtil {
// 搜索获取用户列表接口
	String url = "/uu-admin/UUuserManage/getUserList";
	String userId;
	String selectSql = "SELECT * FROM T_USERINFO WHERE USER_ID= 12495396";
	String updateSql = "UPDATE T_USERINFO SET STATUS = 0 WHERE USER_ID= 12495396";
	String dataType = "perCenter81";
	List<Map<String,Object>> list ;
	@BeforeClass
	public void beforeClass(){
		 userId = new BackUserLoginTest().userId;
		 list = MetaOper.read(selectSql, dataType);
		 MetaOper.update(updateSql, dataType);
	}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postSearchGetUsersListTestCorrectParameter() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postSearchGetUsersListTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495325);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
	
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);		
				
	}
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postSearchGetUsersListTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postSearchGetUsersListTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<@%^&*(>");				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
		
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postSearchGetUsersListTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 121123.33);
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postSearchGetUsersListTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -121312);	
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);				
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postSearchGetUsersListTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");		
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
			
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postSearchGetUsersListTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");	
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postSearchGetUsersListTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);	
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
					
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postSearchGetUsersListTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);	
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);		

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postSearchGetUsersListTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "fsddf");	
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);		

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
		
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postSearchGetUsersListTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postSearchGetUsersListTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 999999999999999999L);	
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");		
	}
	/**
	 * 昵称为超长
	 */
	@Test
	public void postSearchGetUsersListTestNickNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);	
		request.put("nickname", "测试DDDDddd顶顶顶顶顶顶顶顶顶打发打发发士大夫十分犯得上方法犯得上方法是打发士大夫");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
			
	}
	
	/**
	 * 昵称为空
	 */
	@Test
	public void postSearchGetUsersListTestNickNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);	
		request.put("nickname", "");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 昵称为空格
	 */
	@Test
	public void postSearchGetUsersListTestNickNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);	
		request.put("nickname", " ");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 昵称为null
	 */
	@Test
	public void postSearchGetUsersListTestNickNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);	
		request.put("nickname", null);
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 昵称为不传该参数
	 */
	@Test
	public void postSearchGetUsersListTestNickNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);	
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 手机号为超11位
	 */
	@Test
	public void postSearchGetUsersListTestMobileIsOver11() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "15617843828456");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号为超11位" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 手机号小于11位
	 */
	@Test
	public void postSearchGetUsersListTestMobileIsLeast11() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "15617");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号小于11位" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 手机号码为区号加固话（02160790211）
	 */
	@Test
	public void postSearchGetUsersListTestMobileIsAreaCodePlusSolid() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "02160790211");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为区号加固话（02160790211）" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 手机号前+86
	 */
	@Test
	public void postSearchGetUsersListTestMobileBeforeAdd86() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "+8615617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号前+86" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 手机号前加00
	 */
	@Test
	public void postSearchGetUsersListTestMobileBeforeAdd00() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "0015617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号前加00" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 手机号码前面加长途号码17951
	 */
	@Test
	public void postSearchGetUsersListTestMobileBeforeAdd17951() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "1795115617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码前面加长途号码17951" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 手机号含有非法字符
	 */
	@Test
	public void postSearchGetUsersListTestMobileIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "<167%#$^8&>");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号含有非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 手机号为0
	 */
	@Test
	public void postSearchGetUsersListTestMobileIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", 0);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号为0" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 手机号为null
	 */
	@Test
	public void postSearchGetUsersListTestMobileIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", null);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 手机号为空
	 */
	@Test
	public void postSearchGetUsersListTestMobileIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 手机号为空格
	 */
	@Test
	public void postSearchGetUsersListTestMobileIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", " ");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 手机号为小数
	 */
	@Test
	public void postSearchGetUsersListTestMobileIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "12.56894512");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 手机号为负数
	 */
	@Test
	public void postSearchGetUsersListTestMobileIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "-12452");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 手机号码为非1开头
	 */
	@Test
	public void postSearchGetUsersListTestMobileIsStartNon1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "45617843828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为非1开头" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 手机号码格式为xxx-xxxx-xxxx
	 */
	@Test
	public void postSearchGetUsersListTestMobileIsFormat344() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "156-1784-3828");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码格式为xxx-xxxx-xxxx" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 手机号不传该参数
	 */
	@Test
	public void postSearchGetUsersListTestMobileNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 注册时间(开始) 传错误格式
	 */
	@Test
	public void postSearchGetUsersListTestStartTimeIsErrorFormat() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018/01/01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("注册时间(开始) 传错误格式" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 开始时间小于结束时间
	 */
	@Test
	public void postSearchGetUsersListTestStartTimeIsLeastEndTime() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间小于结束时间" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
		
	}
	/**
	 * 开始时间大于结束时间
	 */
	@Test
	public void postSearchGetUsersListTestStartTimeIsMoreEndTime() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-03-01");
		request.put("endTime", "2018-01-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间大于结束时间" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 开始时间传时间戳
	 */
	@Test
	public void postSearchGetUsersListTestStartTimeIsTimeStamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "1525139662000");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传时间戳" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 开始时间传年月日
	 */
	@Test
	public void postSearchGetUsersListTestStartTimeIsYearMonthDay() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传年月日" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 开始时间传时分秒
	 */
	@Test
	public void postSearchGetUsersListTestStartTimeIsHourMinSec() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "12:00:12");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传时分秒" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 开始时间传空格
	 */
	@Test
	public void postSearchGetUsersListTestStartTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", " ");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 开始时间传数字去掉中间格式
	 */
	@Test
	public void postSearchGetUsersListTestStartTimeIsNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "20180101");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传数字去掉中间格式" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 开始时间传空
	 */
	@Test
	public void postSearchGetUsersListTestStartTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 开始时间传null
	 */
	@Test
	public void postSearchGetUsersListTestStartTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", null);
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 开始时间不传该参数
	 */
	@Test
	public void postSearchGetUsersListTestStartTimeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 开始时间传负数
	 */
	@Test
	public void postSearchGetUsersListTestStartTimeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "-2018");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传负数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 开始时间传年月日最大值
	 */
	@Test
	public void postSearchGetUsersListTestStartTimeIsYearMonthDayMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "9999-12-31");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传年月日最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 开始时间传年月日最小时间
	 */
	@Test
	public void postSearchGetUsersListTestStartTimeIsYearMonthDayMin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "0001-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传年月日最小时间" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 开始时间传时分秒最大时间
	 */
	@Test
	public void postSearchGetUsersListTestStartTimeIsHourMinSecMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "23:59:59");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传时分秒最大时间" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 开始时间传时分秒最小时间
	 */
	@Test
	public void postSearchGetUsersListTestStartTimeIsHourMinSecMin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "00:00:00");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传时分秒最小时间" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 开始时间传年月日时分秒
	 */
	@Test
	public void postSearchGetUsersListTestStartTimeIsYearMonthDayHourMinSec() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01 12:12:12");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传年月日时分秒" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		}
	/**
	 * 结束时间传错误格式
	 */
	@Test
	public void postSearchGetUsersListTestEndTimeIsErrorFormat() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018/05/17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传错误格式" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 结束时间传时间戳
	 */
	@Test
	public void postSearchGetUsersListTestEndTimeIsTimeStamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "1526522062000");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传时间戳" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 结束时间传年月日
	 */
	@Test
	public void postSearchGetUsersListTestEndTimeIsYearMonthDay() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传年月日" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 结束时间传时分秒
	 */
	@Test
	public void postSearchGetUsersListTestEndTimeIsHourMinSec() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "10:22:11");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传时分秒" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 结束时间传空格
	 */
	@Test
	public void postSearchGetUsersListTestEndTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", " ");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 结束时间传数字去掉中间格式
	 */
	@Test
	public void postSearchGetUsersListTestEndTimeIsNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "20180517");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传数字去掉中间格式" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 结束时间传空
	 */
	@Test
	public void postSearchGetUsersListTestEndTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 结束时间传null
	 */
	@Test
	public void postSearchGetUsersListTestEndTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", null);
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 结束时间不传该参数
	 */
	@Test
	public void postSearchGetUsersListTestEndTimeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 结束时间传负数
	 */
	@Test
	public void postSearchGetUsersListTestEndTimeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "-12345");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传负数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 结束时间传小数
	 */
	@Test
	public void postSearchGetUsersListTestEndTimeIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "12.564");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传小数" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 结束时间传年月日最大值
	 */
	@Test
	public void postSearchGetUsersListTestEndTimeIsYearMonDayMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传年月日最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 结束时间传时分秒最大时间
	 */
	@Test
	public void postSearchGetUsersListTestEndTimeIsHourMinSecMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "23:59:59");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传时分秒最大时间" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 结束时间传时分秒最小时间
	 */
	@Test
	public void postSearchGetUsersListTestEndTimeIsHourMinSecLeast() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "00:00:00");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传时分秒最小时间" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 结束时间传年月日最小时间
	 */
	@Test
	public void postSearchGetUsersListTestEndTimeIsYearMonDayLeast() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "0001-01-01");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传年月日最小时间" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 结束时间传年月日时分秒
	 */
	@Test
	public void postSearchGetUsersListTestEndTimeIsYearMonDayHourMinSec() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17 14:12:10");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传年月日时分秒" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 状态为0未锁定
	 */
	@Test
	public void postSearchGetUsersListTestStatusIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为0未锁定" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 状态为1锁定
	 */
	@Test
	public void postSearchGetUsersListTestStatusIsOne() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为1锁定" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 状态为2全部
	 */
	@Test
	public void postSearchGetUsersListTestStatusIsTwo() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 2);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为2全部" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 状态为错误
	 */
	@Test
	public void postSearchGetUsersListTestStatusIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 99);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为错误" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 状态为负数
	 */
	@Test
	public void postSearchGetUsersListTestStatusIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", -2);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 状态为小数
	 */
	@Test
	public void postSearchGetUsersListTestStatusIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1.2);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 状态为空格
	 */
	@Test
	public void postSearchGetUsersListTestStatusIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", " ");
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 状态为空
	 */
	@Test
	public void postSearchGetUsersListTestStatusIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", "");
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 状态为null
	 */
	@Test
	public void postSearchGetUsersListTestStatusIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", null);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * 状态为String
	 */
	@Test
	public void postSearchGetUsersListTestStatusIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", "gdgfd");
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为String" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 状态为最大值
	 */
	@Test
	public void postSearchGetUsersListTestStatusIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 999999999);
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 状态为不传
	 */
	@Test
	public void postSearchGetUsersListTestStatusNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("uid", 12495396);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为不传" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * app端用户id错误
	 */
	@Test
	public void postSearchGetUsersListTestUidIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495688);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("app端用户id错误" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * app端用户id超长
	 */
	@Test
	public void postSearchGetUsersListTestUidIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 124953962222222222L);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("app端用户id超长" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * app端用户id传空
	 */
	@Test
	public void postSearchGetUsersListTestUidIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", "");
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("app端用户id传空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * app端用户id传空格
	 */
	@Test
	public void postSearchGetUsersListTestUidIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", " ");
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("app端用户id传空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * app端用户id传null
	 */
	@Test
	public void postSearchGetUsersListTestUidIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("uid", null);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("app端用户id传null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	/**
	 * app端用户id传0
	 */
	@Test
	public void postSearchGetUsersListTestUidIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 0);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("app端用户id传0" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * App端用户id传负数
	 */
	@Test
	public void postSearchGetUsersListTestUidIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", -123456);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("App端用户id传负数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * app端用户id传小数
	 */
	@Test
	public void postSearchGetUsersListTestUidIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12.456);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("app端用户id传小数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * app端用户id传String
	 */
	@Test
	public void postSearchGetUsersListTestUidIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", "grrtwe");
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("app端用户id传String" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * app端用户id不传
	 */
	@Test
	public void postSearchGetUsersListTestUidNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 0);
		request.put("pageSize", 2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("app端用户id不传" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(1);
	}
	
	/**
	 * 每页显示行数pageSize为超长
	 */
	@Test
	public void postSearchGetUsersListTestPageSizeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495396);
		request.put("pageSize", 999999999999999999L);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示行数pageSize为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 每页显示行数pageSize为0
	 */
	@Test
	public void postSearchGetUsersListTestPageSizeIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495396);
		request.put("pageSize", 0);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示行数pageSize为0" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 每页显示行数pageSize为String
	 */
	@Test
	public void postSearchGetUsersListTestPageSizeIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495396);
		request.put("pageSize", "DSFSAS");
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示行数pageSize为String" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 每页显示行数pageSize为空
	 */
	@Test
	public void postSearchGetUsersListTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495396);
		request.put("pageSize", "");
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示行数pageSize为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("页码和分页数不能为空");
	}
	/**
	 * 每页显示行数pageSize为空格
	 */
	@Test
	public void postSearchGetUsersListTestPageSizeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495396);
		request.put("pageSize", " ");
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示行数pageSize为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("页码和分页数不能为空");
	}
	/**
	 * 每页显示行数pageSize为null
	 */
	@Test
	public void postSearchGetUsersListTestPageSizeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495396);
		request.put("pageSize", null);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示行数pageSize为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("页码和分页数不能为空");
	}
	/**
	 * 每页显示行数pageSize为负数
	 */
	@Test
	public void postSearchGetUsersListTestPageSizeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495396);
		request.put("pageSize", -3);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示行数pageSize为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	
	/**
	 * 每页显示行数pageSize为小数
	 */
	@Test
	public void postSearchGetUsersListTestPageSizeIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495396);
		request.put("pageSize", 1.3);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示行数pageSize为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 每页显示行数pageSize不传
	 */
	@Test
	public void postSearchGetUsersListTestPageSizeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495396);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示行数pageSize不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("页码和分页数不能为空");
	}
	/**
	 * 当前页pageNow传空
	 */
	@Test
	public void postSearchGetUsersListTestPageNowIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495396);
		request.put("pageSize", 1);
		request.put("pageNow", "");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页pageNow传空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("页码和分页数不能为空");
	}
	/**
	 * 当前页pageNow传空格
	 */
	@Test
	public void postSearchGetUsersListTestPageNowIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495396);
		request.put("pageSize", 1);
		request.put("pageNow", " ");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页pageNow传空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("页码和分页数不能为空");
	}
	/**
	 * 当前页pageNow传null
	 */
	@Test
	public void postSearchGetUsersListTestPageNowIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495396);
		request.put("pageSize", 1);
		request.put("pageNow", null);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页pageNow传null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("页码和分页数不能为空");
	}
	/**
	 * 当前页pageNow传小数
	 */
	@Test
	public void postSearchGetUsersListTestPageNowIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495396);
		request.put("pageSize", 1);
		request.put("pageNow", 1.2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页pageNow传小数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 当前页pageNow传0
	 */
	@Test
	public void postSearchGetUsersListTestPageNowIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495396);
		request.put("pageSize", 1);
		request.put("pageNow", 0);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页pageNow传0" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 当前页pageNow不传
	 */
	@Test
	public void postSearchGetUsersListTestPageNowNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("nickname", "梦想家Even");
		request.put("mobile", "17740800827");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-05-17");
		request.put("status", 1);
		request.put("uid", 12495396);
		request.put("pageSize", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页pageNow不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("页码和分页数不能为空");
	}
	
}