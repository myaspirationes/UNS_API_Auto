package com.personalCenter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;

public class WalletTest extends HttpUtil {
//实名认证接口
	String url = "/UU/wallet";


	/**
	 * 提交正确参数
	 */
	@Test
	public void postWalletTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("realName", "刘靖宇");
		con.put("papersNo", "310112198708273611");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postWalletTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12312313);
		con.put("realName", "刘靖宇");
		con.put("papersNo", "310112198708273611");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postWalletTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12312sd313");
		con.put("realName", "刘靖宇");
		con.put("papersNo", "310112198708273611");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postWalletTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "<$%^>");
		con.put("realName", "刘靖宇");
		con.put("papersNo", "310112198708273611");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
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
	public void postWalletTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12123123.33);
		con.put("realName", "刘靖宇");
		con.put("papersNo", "310112198708273611");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
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
	public void postWalletTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -121312);
		con.put("realName", "刘靖宇");
		con.put("papersNo", "310112198708273611");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
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
	public void postWalletTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("realName", "刘靖宇");
		con.put("papersNo", "310112198708273611");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
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
	public void postWalletTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("realName", "刘靖宇");
		con.put("papersNo", "310112198708273611");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
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
	public void postWalletTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		con.put("realName", "刘靖宇");
		con.put("papersNo", "310112198708273611");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
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
	 * 用户ID为0
	 */
	@Test
	public void postWalletTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
		con.put("realName", "刘靖宇");
		con.put("papersNo", "310112198708273611");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postWalletTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("realName", "刘靖宇");
		con.put("papersNo", "310112198708273611");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	/**
	 * 用户的姓名为错误
	 */
	@Test
	public void postWalletTestRealNameIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("realName", "刘靖宇123123");
		con.put("papersNo", "310112198708273611");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户的姓名为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户的姓名与身份证ID不符
	 */
	@Test
	public void postWalletTestUserIdNotTheSameAsRealName() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 124925111);
		con.put("realName", "刘靖宇");
		con.put("papersNo", "310112198708273611");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户的姓名与身份证ID不符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户的姓名为空
	 */
	@Test
	public void postWalletTestRealNameIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("realName", "");
		con.put("papersNo", "310112198708273611");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户的姓名为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户的姓名为空格
	 */
	@Test
	public void postWalletTestRealNameIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("realName", "刘靖宇");
		con.put("papersNo", "310112198708273611");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户的姓名为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户的姓名为null
	 */
	@Test
	public void postWalletTestRealNameIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("realName", "刘靖宇");
		con.put("papersNo", "310112198708273611");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户的姓名为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户的姓名不传该参数
	 */
	@Test
	public void postWalletTestRealNameNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("papersNo", "310112198708273611");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户的姓名不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户的姓名超长
	 */
	@Test
	public void postWalletTestRealNameIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("realName", "刘靖宇刘靖宇刘靖宇刘靖宇刘靖宇刘靖宇刘靖宇刘靖宇刘靖宇刘靖宇刘靖宇刘靖宇刘靖宇刘靖宇刘靖宇刘靖宇刘靖宇刘靖宇刘靖宇刘靖宇刘靖宇刘靖宇刘靖宇刘靖宇刘靖宇");
		con.put("papersNo", "310112198708273611");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户的姓名超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户的姓名为非法字符
	 */
	@Test
	public void postWalletTestRealNameIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("realName", "刘靖宇<!@#!23>");
		con.put("papersNo", "310112198708273611");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户的姓名为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户的身份证号为小于18位
	 */
	@Test
	public void postWalletTestPapersNoLessThan18() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("realName", "刘靖宇");
		con.put("papersNo", "3101121987082731");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户的身份证号为小于18位" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户的身份证号为空
	 */
	@Test
	public void postWalletTestPapersNoIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("realName", "刘靖宇");
		con.put("papersNo", "");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户的身份证号为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户的身份证号为空格
	 */
	@Test
	public void postWalletTestPapersNoIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("realName", "刘靖宇");
		con.put("papersNo", " ");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户的身份证号为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户的身份证号为null
	 */
	@Test
	public void postWalletTestPapersNoIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("realName", "刘靖宇");
		con.put("papersNo", null);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户的身份证号不传该参数
	 */
	@Test
	public void postWalletTestPapersNoNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("realName", "刘靖宇");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户的身份证号不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户的身份证号超长
	 */
	@Test
	public void postWalletTestPapersNoIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("realName", "刘靖宇");
		con.put("papersNo", "31011219228708273611");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户的身份证号超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户的身份证号为0
	 */
	@Test
	public void postWalletTestPapersNoIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("realName", "刘靖宇");
		con.put("papersNo", "0");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户的身份证号为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户的身份证号为负数
	 */
	@Test
	public void postWalletTestPapersNoIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("realName", "刘靖宇");
		con.put("papersNo", -310273611);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户的身份证号为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户的身份证号为小数
	 */
	@Test
	public void postWalletTestPapersNoIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("realName", "刘靖宇");
		con.put("papersNo", 1.52);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("mos", "iphone");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491751);
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("cmd", 3002);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户的身份证号为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	
	
}