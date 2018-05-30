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

	/**
	 * 提交正确参数
	 */
	@Test
	public void postBackUserLoginTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userName", "18856785678");
		request.put("passWord", "abc123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交非运营后台用户登录名和密码
	 */
	@Test
	public void postBackUserLoginTestNotBackUser() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userName", "18300001111");
		request.put("passWord", "test123");

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
		request.put("passWord", "abc123456");

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
		request.put("passWord", "abc123456");

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
		request.put("userName", "18856785678188567856781885678567818856785678");
		request.put("passWord", "abc123456");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户名为" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}

}