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
import com.example.LoginTest;

public class GetMultiAccountAssociationTest extends HttpUtil {
//获取多账号关联接口
	String url = "/UU/user";
	
	String chcode;
	@BeforeClass
	public void  beforeClass(){
		LoginTest login = new LoginTest();
		try {
			chcode = login.getLoginTestChcodeBy177();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postMultiAccountAssociationTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	 * 用户ID为未登录用户
	 */
	//@Test
	public void postMultiAccountAssociationTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
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
	//@Test
	public void postMultiAccountAssociationTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
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
	//@Test
	public void postMultiAccountAssociationTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "<#$%.>");
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
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
	//@Test
	public void postMultiAccountAssociationTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492.125);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
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
	//@Test
	public void postMultiAccountAssociationTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
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
	//@Test
	public void postMultiAccountAssociationTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
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
	//@Test
	public void postMultiAccountAssociationTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
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
	//@Test
	public void postMultiAccountAssociationTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
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
	 * 用户ID为0
	 */
	//@Test
	public void postMultiAccountAssociationTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	 * 用户ID不传该参数
	 */
	//@Test
	public void postMultiAccountAssociationTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
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
	/**
	 * 唯一标识错误
	 */
	//@Test
	public void postMultiAccountAssociationTestUniqueIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF55123124edfgdfgwe424 3A44B143DE188");
		con.put("type", 1);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	 *唯一标识超长
	 */
	//@Test
	public void postMultiAccountAssociationTestUniqueIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5Esdasdasdasdasdasdasdaaaaaaassssssssssssssssssssssssssssssssssssssssssssssssssssss2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	//@Test
	public void postMultiAccountAssociationTestUniqueIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "");
		con.put("type", 1);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	//@Test
	public void postMultiAccountAssociationTestUniqueIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "<$%^.>");
		con.put("type", 1);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	//@Test
	public void postMultiAccountAssociationTestUniqueIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	//@Test
	public void postMultiAccountAssociationTestUniqueIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("type", 1);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	//@Test
	public void postMultiAccountAssociationTestTypeIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 123123);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	//@Test
	public void postMultiAccountAssociationTestTypeIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", "asas");
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	//@Test
	public void postMultiAccountAssociationTestTypeIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1.5);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	//@Test
	public void postMultiAccountAssociationTestTypeIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", -1);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	//@Test
	public void postMultiAccountAssociationTestTypeIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 0);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	//@Test
	public void postMultiAccountAssociationTestTypeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	//@Test
	public void postMultiAccountAssociationTesttypeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", " ");
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	//@Test
	public void postMultiAccountAssociationTestTypeIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 999999999);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	//@Test
	public void postMultiAccountAssociationTestTypeIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", null);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	 * 账户类型传1QQ
	 */
	//@Test
	public void postMultiAccountAssociationTestTypeIsQQ() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账户类型传1QQ" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 账户类型传2weichat
	 */
	//@Test
	public void postMultiAccountAssociationTestTypeIsWeichat() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 2);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账户类型传2weichat" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 账户类型传3微博
	 */
	//@Test
	public void postMultiAccountAssociationTesttypeIsSina() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 3);
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("账户类型传3微博" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 不传账户类型
	 */
	//@Test
	public void postMultiAccountAssociationTestTypeNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("bind", "bind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	 * 绑定信息为空
	 */
	//@Test
	public void postMultiAccountAssociationTestBindIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", "");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	//@Test
	public void postMultiAccountAssociationTestBindIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", " ");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	//@Test
	public void postMultiAccountAssociationTestBindIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", "bindbindbindbindbindbindbindbindbindbindbindbindbindbindbindbindbindbindbindbindbindbindbindbindbindbindbindbind");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	//@Test
	public void postMultiAccountAssociationTestBindIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", null);
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("绑定信息为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 绑定信息存在非法字符
	 */
	//@Test
	public void postMultiAccountAssociationTestBind() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", "<$%^.>");
		con.put("nickName", "nickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	 * 昵称超长
	 */
	//@Test
	public void postMultiAccountAssociationTestNickNameIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", "bind");
		con.put("nickName", "nickNamenickNamenickNamenickNamenickNamenickNamenickNamenickNamenickNamenickNamenickNamenickNamenickNamenickNamenickNamenickName");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	//@Test
	public void postMultiAccountAssociationTestNickNameIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", "bind");
		con.put("nickName", "");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	//@Test
	public void postMultiAccountAssociationTestNickNameIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", "bind");
		con.put("nickName", " ");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	//@Test
	public void postMultiAccountAssociationTestNickNameIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", "bind");
		con.put("nickName", null);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	 * 昵称存在非法字符
	 */
	//@Test
	public void postMultiAccountAssociationTestNickNameIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", "bind");
		con.put("nickName", "<@#$.>");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称存在非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 不传昵称
	 */
	//@Test
	public void postMultiAccountAssociationTestNickNameNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("uniqueId", "14715291A5E2A40EF553A44B143DE188");
		con.put("type", 1);
		con.put("bind", "bind");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "222");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
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
	
}