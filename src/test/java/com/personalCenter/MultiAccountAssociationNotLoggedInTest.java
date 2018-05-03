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

public class MultiAccountAssociationNotLoggedInTest extends HttpUtil {
//获取多账号关联接口(未登录)
	String url = "/UU/user";
	

	/**
	 * 提交正确参数
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
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
	 * 手机号码超11位
	 */
	//@Test
	public void postMultiAccountAssociationNotLoggedInTestMobileNumberMoreEleven() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027222");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码超11位" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
		
		
	}
	/**
	 * 手机号码小于11位
	 */
	//@Test
	public void postMultiAccountAssociationNotLoggedInTestMobileNumberLessEleven() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "139382");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码小于11位" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 手机号码为区号加固话（02160790211）
	 */
	//@Test
	public void postMultiAccountAssociationNotLoggedInTestMobileIsAreaCodePlusSolid() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "02160790211");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为区号加固话（02160790211）" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 
	 * 手机号码前面+86 
	 */
	//@Test
	public void postMultiAccountAssociationNotLoggedInTestMobileBeforePlusEightSix() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "+8613938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码前面+86" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 手机号码前面加00
	 */
	//@Test
	public void postMultiAccountAssociationNotLoggedInTestMobileBeforePlusZeroZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "0013938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码前面加00" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 手机号码前面加长途号码17951
	 */
	//@Test
	public void postMultiAccountAssociationNotLoggedInTestMobileBeforePlusTollNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "1795113938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码前面加长途号码17951" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 手机号码为字符
	 */
	//@Test
	public void postMultiAccountAssociationNotLoggedInTestMobileIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "<@$%^(,>");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 手机号码为小数
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestMobileIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", 139.3822);
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 手机号码为负数
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestMobileIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", -13938);
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 手机号码为0
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestMobileIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", 0);
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 手机号码为非1开头
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestMobileStartNotOne() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "33938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为非1开头" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 手机号码为空
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestMobileIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 手机号码为空格
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestMobileIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", " ");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 手机号码为null
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestMobileIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", null);
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 不传手机号码
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestMobileNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("不传手机号码" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 唯一标识错误
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestUniqueIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("唯一标识错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 唯一标识超长
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestUniqueIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007ddd");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("唯一标识超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 唯一标识为空
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestUniqueIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("唯一标识为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 唯一标识存在非法字符
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestUniqueIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "<@%*(_+>");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("唯一标识存在非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 唯一标识为空格
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestUniqueIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", " ");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("唯一标识为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 不传唯一标识
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestuniqueIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("不传唯一标识" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 账户类型为错误
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestTypeIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账户类型为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 账户类型为String
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestTypeIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", "adfdf");
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账户类型为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 账户类型为小数
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestTypeIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 13.4);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账户类型为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 账户类型为负数
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestTypeIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", -139);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账户类型为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 账户类型为0
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestTypeIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 0);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账户类型为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 账户类型为空
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestTypeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", "");
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账户类型为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 账户类型为空格
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestTypeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", " ");
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账户类型为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 账户类型为最大值
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestTypeIsTheMaxNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 999999999);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账户类型为最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 账户类型为null
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestTypeIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", null);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账户类型为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 不传账户类型
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestTypeNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("不传账户类型" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 账户类型为1QQ
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestTypeIsOneQQ() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", "1QQ");
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账户类型为1QQ" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 账户类型为2weichat
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestTypeIsTwoweichat() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", "2weichat");
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账户类型为2weichat" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 账户类型为3微博
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestTypeIsThreeweibo() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", "3微博");
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账户类型为3微博" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 绑定信息为空
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestBindIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("绑定信息为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 绑定信息为空格
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestBindIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", " ");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("绑定信息为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 绑定信息为超长
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestBindIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "98afa509d7ac716e9a537688fe02f5cf23");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("绑定信息为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 绑定信息为null
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestBindIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", null);
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("绑定信息为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 绑定信息存在非法字符
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestBindIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "<#^&*(_+>");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("绑定信息存在非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 不传绑定信息参数
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestBindNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("不传绑定信息参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 昵称超长
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestNickNamedIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "AB我是昵称FGHIGKLMNOPQRSTUVWXYZ00007");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 昵称为空
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestNickNamedIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 昵称为空格
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestNickNamedIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", " ");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 昵称为null
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestNickNamedIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", null);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 昵称存在非法字符
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestNickNamedIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "<@$^*(_+/>");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 不传昵称
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestNickNamedNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("不传昵称" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 密码错误
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestPasswordIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "98afa509d7ac716e9a537688fe02f5cf");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("密码错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 密码为空
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestPasswordIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", "");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("密码为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 密码为空格
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestPasswordIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", " ");
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("密码为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 密码为null
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestPasswordIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("password", null);
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("密码为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 不传密码
	 */
	@Test
	public void postMultiAccountAssociationNotLoggedInTestPasswordNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13938228027");
		con.put("uniqueId", "ABCDEFGHIGKLMNOPQRSTUVWXYZ00007");
		con.put("type", 1);
		con.put("bind", "sdgjhjk");
		con.put("nickNamed", "我是昵称");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "110");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491621");
		head.put("ln", "cn");
		head.put("chcode", "VoCbKw7Z/V7NL3fHrNQPMAED8vDL6wGk");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("不传密码" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	
	
}