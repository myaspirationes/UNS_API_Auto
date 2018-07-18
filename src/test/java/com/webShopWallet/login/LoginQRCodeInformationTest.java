package com.webShopWallet.login;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class LoginQRCodeInformationTest extends HttpUtil {
// 验证登录二维码信息接口
	String url = "/";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postLoginQRCodeInformationTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("Qrmessage", "Qrmessage");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * Qrmessage传空
	 */
	@Test
	public void postLoginQRCodeInformationTestQrmessageIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("Qrmessage", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("Qrmessage传空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * Qrmessage传空格
	 */
	@Test
	public void postLoginQRCodeInformationTestQrmessageIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("Qrmessage", " ");
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("Qrmessage传空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * Qrmessage传null
	 */
	@Test
	public void postLoginQRCodeInformationTestQrmessageIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("Qrmessage", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("Qrmessage传null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * Qrmessage不传
	 */
	@Test
	public void postLoginQRCodeInformationTestQrmessageIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();

		JSONObject post = super.UNSPost(url, request);
		System.out.println("Qrmessage不传" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * Qrmessage传最大值
	 */
	@Test
	public void postLoginQRCodeInformationTestQrmessageIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("Qrmessage", 999999999999999999L);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("Qrmessage传最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
}
