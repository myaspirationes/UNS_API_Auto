package com.login;

import com.example.HttpUtil;
import com.example.MetaOper;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class BackUserLoginTest extends HttpUtil {
	// 用户登录接口
	String url = "/uu-admin/BackUser/login";
	public String userId = "";{
		try {
			postBackUserLoginTestCorrectParameter();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postBackUserLoginTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userName", "admin");
		request.put("passWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		JSONObject user = (JSONObject)body.get("user");
		userId = (String)user.get("userId").toString();
	}
	
	/**
	 * 提交非运营后台用户登录名和密码
	 */
	@Test
	public void postBackUserLoginTestNotBackUser() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userName", "admin");
		request.put("passWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交非运营后台用户登录名和密码" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("无权限");
	}

	/**
	 * 提交错误的用户登录名
	 */
	@Test
	public void postBackUserLoginTestUserNameIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userName", "错误的");
		request.put("passWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登录名为错误的" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}

	/**
	 * 用户登录名为非法字符
	 */
	@Test
	public void postBackUserLoginTestUserNameIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userName", "<$%^>");
		request.put("passWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户名为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	
	/**
	 * 用户登录名超长
	 */
	@Test
	public void postBackUserLoginTestUserNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userName", "adminadminadminadmin");
		request.put("passWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户名超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	
	/**
	 * 用户登录名为null
	 */
	@Test
	public void postBackUserLoginTestUserNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userName", null);
		request.put("passWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户名为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	
	/**
	 * 用户登录名为空格
	 */
	@Test
	public void postBackUserLoginTestUserNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userName", " ");
		request.put("passWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户名为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	
	/**
	 * 用户登录名为空
	 */
	@Test
	public void postBackUserLoginTestUserNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userName", "");
		request.put("passWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户名为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	
	/**
	 * 不传用户登录名参数
	 */
	@Test
	public void postBackUserLoginTestUserNameUncommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("passWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("不传用户登录名" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	
	/**
	 * 用户登录名传long型
	 */
	@Test
	public void postBackUserLoginTestUserNameIsIntType() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userName", 12345676543L);
		request.put("passWord", "123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户登录名传long型" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	
	/**
	 * 密码错误
	 */
	@Test
	public void postBackUserLoginTestPasswordIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userName", "adm1in");
		request.put("passWord", "124156");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("密码错误" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	
	/**
	 * 密码为非法字符
	 */
	@Test
	public void postBackUserLoginTestPasswordIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userName", "admin");
		request.put("passWord", "<$%^>");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("密码为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	
	/**
	 * 密码为超长字符
	 */
	@Test
	public void postBackUserLoginTestPasswordIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userName", "admin");
		request.put("passWord", "adminabc123adminabc123adminabc123adminabc123");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("密码为超长字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	
	/**
	 * 密码为null
	 */
	@Test
	public void postBackUserLoginTestPasswordIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userName", "admin");
		request.put("passWord", null);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("密码为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	
	/**
	 * 密码为空格
	 */
	@Test
	public void postBackUserLoginTestPasswordIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userName", "admin");
		request.put("passWord", " ");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("密码为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	
	/**
	 * 密码为空
	 */
	@Test
	public void postBackUserLoginTestPasswordIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userName", "admin");
		request.put("passWord", "");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("密码为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	
	/**
	 * 不传密码参数
	 */
	@Test
	public void postBackUserLoginTestPasswordUncommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userName", "admin");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("不传密码参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	
	/**
	 * 把正确密码里的小写字母改成大写
	 */
	@Test
	public void postBackUserLoginTestPasswordChangeSmallerLetterToCapitalLetter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userName", "admin");
		request.put("passWord", "ABC123");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("把正确密码里的小写字母改成大写" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	

}