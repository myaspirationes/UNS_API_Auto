package com.homePage;

import com.example.HttpUtil;
import com.example.LoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class HomePageConfigurationParameterTest extends HttpUtil {
//获取首页UI的配置参数接口
	String url = "/UU/homepage";
	JSONObject body;
	String uuid;
	String chcode;
	LoginTest login = new LoginTest();
	@BeforeClass
	public void  beforeClass(){
		
		try {
			body = login.getLoginTestChcodeBy177();
			uuid= (body.get("userId")).toString();
			chcode= (body.get("checkCode")).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * 正确参数查询
	 */
	@Test
	public void postHomePageConfigurationParameterTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("keyWord", "苹果");

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("正确参数查询" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为未登陆
	 */
	@Test
	public void postHomePageConfigurationParameterTestUsrIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495325);
		con.put("keyWord", "苹果");

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登陆" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为为错误
	 */
	@Test
	public void postHomePageConfigurationParameterTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 1111);
		con.put("keyWord", "苹果");

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为为非法字符
	 */
	@Test
	public void postHomePageConfigurationParameterTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " <#$%^>");
		con.put("keyWord", "苹果");

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postHomePageConfigurationParameterTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 1.1);
		con.put("keyWord", "苹果");

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postHomePageConfigurationParameterTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -1);
		con.put("keyWord", "苹果");

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postHomePageConfigurationParameterTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("keyWord", "苹果");

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postHomePageConfigurationParameterTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("keyWord", "苹果");

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postHomePageConfigurationParameterTestuserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		con.put("keyWord", "苹果");

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postHomePageConfigurationParameterTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("keyWord", "苹果");

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}



}