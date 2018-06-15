package com.publicModule.login;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.example.CryptographyUtil;
import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ChangePasswordTest extends HttpUtil {
	// 用户登录接口
	String url = "/uu-admin/BackUser/changePassWord";
	
	String dataType = "perCenter81";
	String updatePasswordSql="UPDATE T_WEB_USER SET PASSWORD='6dc9dfd94b9485bbb4df440353efc4f5' WHERE USER_ID=10000000";
	String DBpassword="SELECT PASSWORD FROM T_WEB_USER WHERE USER_ID=10000000";
	
	BackUserLoginTest login = new BackUserLoginTest();
	String userId=login.userId;
	
	@AfterMethod
	public void afterMethod() 
	{
//		重置密码为123456
		MetaOper.update(updatePasswordSql, dataType);
	}
			
	
	/**
	 * 提交正确参数
	 */
	@Test
	public void postChangePasswordTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("oldPassWord", "123456");
		request.put("newPassWord", "111111");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
//		修改成功后与数据可库中的密码进行校验		
		String  password=CryptographyUtil.md5("111111", "naruto");
		System.out.println("md5加密后的字符串" + password);
		List<Map<String,Object>> list ;
		list=MetaOper.read(DBpassword, dataType);
		assertThat(list.get(0).get("PASSWORD").toString()).isEqualTo(password);		
				
		
	}
	
	/**
	 * 提交非运营后台用户登录名和密码
	 */
	@Test
	public void postChangePasswordTestNotBackUsernameAndPassword() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495511);
		request.put("userName", "18300001111");
		request.put("oldPassWord", "test123");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交非运营后台用户登录名和密码" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("用户不存在");
	}

	/**
	 * 提交错误的用户ID
	 */
	@Test
	public void postChangePasswordTestUserIIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0123);
		request.put("userName", "admin");
		request.put("oldPassWord", "123456");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交错误的用户ID" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("用户不存在");
	}

	/**
	 * 未登录的用户ID
	 */
	@Test
	public void postChangePasswordTestUserIdNotLogin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 10000004);
		request.put("userName", "naruto");
		request.put("oldPassWord", "123456");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("未登录的用户ID：" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postChangePasswordTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 10000.001);
		request.put("userName", "admin");
		request.put("oldPassWord", "123456");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("用户不存在");
		
	}
	
	/**
	 * 用户id为非法字符
	 */
	@Test
	public void postChangePasswordTestUserIdIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<$%^&>");
		request.put("userName", "admin");
		request.put("oldPassWord", "123456");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
//		assertThat(post.get("msg")).isEqualTo("参数有误");
		
	}
	
	/**
	 * 用户id为负数
	 */
	@Test
	public void postChangePasswordTestUserIdIsMinus() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -1000000);
		request.put("userName", "admin");
		request.put("oldPassWord", "123456");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("用户不存在");
		
	}
	
	/**
	 * 用户id为0
	 */
	@Test
	public void postChangePasswordTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);
		request.put("userName", "admin");
		request.put("oldPassWord", "123456");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为0" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("用户不存在");
		
	}
	
	/**
	 * 用户id为string型
	 */
	@Test
	public void postChangePasswordTestUserIdTypeIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "10000000");
		request.put("userName", "admin");
		request.put("oldPassWord", "123456");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为string型" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	
	/**
	 * 用户id为空格
	 */
	@Test
	public void postChangePasswordTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("userName", "admin");
		request.put("oldPassWord", "123456");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为空格" + post);

		assertThat(post.get("status")).isEqualTo(500);
//		assertThat(post.get("msg")).isEqualTo("参数有误");
		
	}
	
	/**
	 * 用户id为空
	 */
	@Test
	public void postChangePasswordTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("userName", "admin");
		request.put("oldPassWord", "123456");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为空" + post);

		assertThat(post.get("status")).isEqualTo(500);
//		assertThat(post.get("msg")).isEqualTo("参数有误");
		
	}
	
	/**
	 * 用户id为null
	 */
	@Test
	public void postChangePasswordTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("userName", "admin");
		request.put("oldPassWord", "123456");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为null" + post);

		assertThat(post.get("status")).isEqualTo(500);
//		assertThat(post.get("msg")).isEqualTo("参数有误");
		
	}
	
	/**
	 * 不提交用户id
	 */
	@Test
	public void postChangePasswordTestUserIdNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userName", "admin");
		request.put("oldPassWord", "123456");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("不提交用户id" + post);

		assertThat(post.get("status")).isEqualTo(500);
//		assertThat(post.get("msg")).isEqualTo("参数有误");
		
	}
	
	/**
	 * 提交错误的用户登录名
	 */
	@Test
	public void postChangePasswordTestUserNameIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "error");
		request.put("oldPassWord", "123456");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交错误的用户登录名" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("用户名及密码不符");
		
	}
	
	/**
	 * 用户登录名为非法字符
	 */
	@Test
	public void postChangePasswordTestUserNameIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "<$%^&>");
		request.put("oldPassWord", "123456");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登录名为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("用户名及密码不符");
		
	}
	
	/**
	 * 用户登录名超长
	 */
	@Test
	public void postChangePasswordTestUserNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "adminadminadminadminadminadminadminadmin");
		request.put("oldPassWord", "123456");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登录名超长" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("用户名及密码不符");
		
	}
	
	/**
	 * 用户登录名为null
	 */
	@Test
	public void postChangePasswordTestUserNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", null);
		request.put("oldPassWord", "123456");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登录名为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
		
	}
	
	/**
	 * 用户登录名为空格
	 */
	@Test
	public void postChangePasswordTestUserNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", " ");
		request.put("oldPassWord", "123456");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登录名为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
		
	}
	
	/**
	 * 用户登录名为空
	 */
	@Test
	public void postChangePasswordTestUserNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "");
		request.put("oldPassWord", "123456");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登录名为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
		
	}
	
	/**
	 * 不传用户登录名参数
	 */
	@Test
	public void postChangePasswordTestUserNameNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("oldPassWord", "123456");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("不传用户登录名参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
		
	}
	
	/**
	 * 用户登录名传int型
	 */
	@Test
	public void postChangePasswordTestUserNameTypeIsInt() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", 123456);
		request.put("oldPassWord", "123456");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登录名传int型" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("用户名及密码不符");
		
	}
	
	/**
	 * 旧密码错误
	 */
	@Test
	public void postChangePasswordTestOldPasswordIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("oldPassWord", "1234567");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("旧密码错误" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("用户名及密码不符");
		
	}
	
	/**
	 * 旧密码为非法字符
	 */
	@Test
	public void postChangePasswordTestOldPasswordIsIllegalCharacter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("oldPassWord", "<$%^&>");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("旧密码为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("用户名及密码不符");
		
		
	}
	
	/**
	 * 旧密码为超长字符
	 */
	@Test
	public void postChangePasswordTestOldPasswordIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("oldPassWord", "123456123456123456123456123456123456123456123456");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("旧密码为超长字符" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("用户名及密码不符");
		
	}
	
	
	/**
	 * 旧密码为null
	 */
	@Test
	public void postChangePasswordTestOldPasswordIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("oldPassWord", "null");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("旧密码为null" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("用户名及密码不符");
		
	}
	
	/**
	 * 旧密码为空格
	 */
	@Test
	public void postChangePasswordTestOldPasswordIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("oldPassWord", " ");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("旧密码为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
		
	}
	
	/**
	 * 旧密码为空
	 */
	@Test
	public void postChangePasswordTestOldPasswordIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("oldPassWord", "");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("旧密码为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
		
	}
	
	/**
	 * 不传旧密码参数
	 */
	@Test
	public void postChangePasswordTestOldPasswordNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("不传旧密码参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");	
		
		
	}
	
	/**
	 * 正确的int型旧密码
	 */
	@Test
	public void postChangePasswordTestOldPasswordTypeIsInt() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("oldPassWord", 123456);
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("正确的int型旧密码" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");	
		
		
	}
	
	/**
	 * 新密码与旧密码一致
	 */
	@Test
	public void postChangePasswordTestNewPasswordSameAsOldPassword() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("oldPassWord", "123456");
		request.put("newPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("新密码与旧密码一致" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");	
		
		
	}
	
	/**
	 * 新密码为非法字符
	 */
	@Test
	public void postChangePasswordTestNewPasswordIsIllegalCharacter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("oldPassWord", "123456");
		request.put("newPassWord", "<@#$%^&>");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("新密码为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	
	
	/**
	 * 新密码为超长字符
	 */
	@Test
	public void postChangePasswordTestNewPasswordIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("oldPassWord", "123456");
		request.put("newPassWord", "Abcdefg1234567890Abcdefg1234567890Abcdefg1234567890Abcdefg1234567890Abcdefg1234567890");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("新密码为超长字符" + post);
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");	

		
	}
	
	/**
	 * 新密码为null
	 */
	@Test
	public void postChangePasswordTestNewPasswordIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("oldPassWord", "123456");
		request.put("newPassWord", null);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("新密码为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");	
		
		
	}
	
	/**
	 * 新密码为空格
	 */
	@Test
	public void postChangePasswordTestNewPasswordIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("oldPassWord", "123456");
		request.put("newPassWord", " ");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("新密码为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");	
		
		
	}
	
	
	/**
	 * 新密码为空
	 */
	@Test
	public void postChangePasswordTestNewPasswordIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("oldPassWord", "123456");
		request.put("newPassWord", "");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("新密码为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");	
		
		
	}
	
	/**
	 * 不传新密码参数
	 */
	@Test
	public void postChangePasswordTestNewPasswordNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("oldPassWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("不传新密码参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");	
		
		
	}
	
	/**
	 * 提交int型新密码
	 */
	@Test
	public void postChangePasswordTestNewPasswordTypeIsInt() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("oldPassWord", "123456");
		request.put("newPassWord", 123456);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交int型新密码" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");	
		
		
	}
	

}