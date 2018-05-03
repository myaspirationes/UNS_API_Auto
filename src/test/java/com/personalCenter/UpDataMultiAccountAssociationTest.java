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

public class UpDataMultiAccountAssociationTest extends HttpUtil {
//多账号关联接口修改
	String url = "/UU/user";
	

	/**
	 * 提交正确参数
	 */
	@Test
	public void postMultiAccountAssociationTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("uniqueId", 12492125);
		con.put("type", 12492125);
		con.put("bind", 12492125);
		con.put("nickName", 12492125);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "215");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "188111");
		head.put("ln", "cn");
		head.put("chcode", "ef19843298ae8f2134f");
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
	 * 用户为未登录
	 */
	//@Test
	public void postMultiAccountAssociationTestUserIdIsNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "208");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "188111");
		head.put("ln", "cn");
		head.put("chcode", "ef19843298ae8f2134f");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户为未登录" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
		
		
	}
	/**
	 * 用户为错误
	 */
	//@Test
	public void postMultiAccountAssociationTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "208");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "188111");
		head.put("ln", "cn");
		head.put("chcode", "ef19843298ae8f2134f");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID存在小数
	 */
	//@Test
	public void postMultiAccountAssociationTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12.492125);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "208");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "188111");
		head.put("ln", "cn");
		head.put("chcode", "ef19843298ae8f2134f");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID存在小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 
	 * 用户ID存在非法字符  
	 */
	//@Test
	public void postMultiAccountAssociationTestUserIdIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "<#@$%*&','>");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "208");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "188111");
		head.put("ln", "cn");
		head.put("chcode", "ef19843298ae8f2134f");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID存在非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID存在负数
	 */
	//@Test
	public void postMultiAccountAssociationTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -1249125);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "208");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "188111");
		head.put("ln", "cn");
		head.put("chcode", "ef19843298ae8f2134f");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID存在负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为0
	 */
	//@Test
	public void postMultiAccountAssociationTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "208");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "188111");
		head.put("ln", "cn");
		head.put("chcode", "ef19843298ae8f2134f");
		head.put("sync", "1");
		head.put("mod", "ios");
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
	 * 用户ID为String
	 */
	//@Test
	public void postMultiAccountAssociationTestUserIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "abdgfhGH");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "208");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "188111");
		head.put("ln", "cn");
		head.put("chcode", "ef19843298ae8f2134f");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postMultiAccountAssociationTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId","" );
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "208");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "188111");
		head.put("ln", "cn");
		head.put("chcode", "ef19843298ae8f2134f");
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
	 * 用户ID为空格
	 */
	@Test
	public void postMultiAccountAssociationTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "208");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "188111");
		head.put("ln", "cn");
		head.put("chcode", "ef19843298ae8f2134f");
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
	 * 用户ID为null
	 */
	@Test
	public void postMultiAccountAssociationTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "208");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "188111");
		head.put("ln", "cn");
		head.put("chcode", "ef19843298ae8f2134f");
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
	 * 用户ID不传该 参数
	 */
	@Test
	public void postMultiAccountAssociationTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "208");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "188111");
		head.put("ln", "cn");
		head.put("chcode", "ef19843298ae8f2134f");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该 参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	
	
}