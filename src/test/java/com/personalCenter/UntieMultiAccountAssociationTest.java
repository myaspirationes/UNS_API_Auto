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

public class UntieMultiAccountAssociationTest extends HttpUtil {
//解除第三方账户关联接口(由于需要第三方接口获取信息所以暂时未做测试)
	String url = "/UU/user";
	

	/**
	 * 提交正确参数
	 */
	@Test
	public void postAuthenticationManagementListTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("type", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
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
	 * 用户ID错误
	 */
	//@Test
	public void postAuthenticationManagementListTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 124932827);
		con.put("type", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	/**
	 * 用户ID用户未登录
	 */
	//@Test
	public void postAuthenticationManagementListTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12345678);
		con.put("type", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID用户未登录" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID超长
	 */
	//@Test
	public void postAuthenticationManagementListTestUserIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 124931111827L);
		con.put("type", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为0
	 */
	//@Test
	public void postAuthenticationManagementListTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
		con.put("type", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
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
	 * 用户ID为负数
	 */
	//@Test
	public void postAuthenticationManagementListTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -12495324);
		con.put("type", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
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
	 * 用户ID为小数
	 */
	//@Test
	public void postAuthenticationManagementListTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 1249.3827);
		con.put("type", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
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
	 * 用户ID为空
	 */
	//@Test
	public void postAuthenticationManagementListTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("type", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
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
	//@Test
	public void postAuthenticationManagementListTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("type", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
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
	 * 用户ID存在非法字符
	 */
	//@Test
	public void postAuthenticationManagementListTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "<$%^>");
		con.put("type", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
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
	 * 用户ID为null
	 */
	//@Test
	public void postAuthenticationManagementListTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		con.put("type", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
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
	//@Test
	public void postAuthenticationManagementListTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("type", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
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
	 * 解绑账户类型为1：QQ
	 */
	//@Test
	public void postAuthenticationManagementListTestTypeIsQQ() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("type", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("解绑账户类型为1：QQ" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 解绑账户类型为2：wechat
	 */
	//@Test
	public void postAuthenticationManagementListTestTypeIsWechat() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("type", 2);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("解绑账户类型为2：wechat" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 解绑账户类型3.sina
	 */
	//@Test
	public void postAuthenticationManagementListTestTypeIsSina() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("type", 3);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("解绑账户类型3.sina" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	/**
	 * 解绑账户类型4.kabao
	 */
	//@Test
	public void postAuthenticationManagementListTestTypeIsKabao() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("type", 4);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("解绑账户类型4.kabao" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	/**
	 * 解绑账户类型为0
	 */
	//@Test
	public void postAuthenticationManagementListTestTypeIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("type", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("解绑账户类型为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 解绑账户类型为小数
	 */
	//@Test
	public void postAuthenticationManagementListTestTypeIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("type", 1.5);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("解绑账户类型为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 解绑账户类型为负数
	 */
	//@Test
	public void postAuthenticationManagementListTestTypeIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("type", -1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("解绑账户类型为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 解绑账户类型为字符串
	 */
	//@Test
	public void postAuthenticationManagementListTestTypeIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("type", "a");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("解绑账户类型为字符串" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 解绑账户类型为最大值
	 */
	//@Test
	public void postAuthenticationManagementListTestTypeMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("type", 11111111);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("解绑账户类型为最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 解绑账户类型为非法字符
	 */
	//@Test
	public void postAuthenticationManagementListTestTypeIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("type", "<&$#.>");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("解绑账户类型为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	/**
	 * 解绑账户类型为空
	 */
	//@Test
	public void postAuthenticationManagementListTestTypeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("type", "");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("解绑账户类型为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	/**
	 * 解绑账户类型为空格
	 */
	//@Test
	public void postAuthenticationManagementListTestTypeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("type", " ");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("解绑账户类型为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 解绑账户类型为null
	 */
	//@Test
	public void postAuthenticationManagementListTestIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("type", null);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("解绑账户类型为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 解绑账户类型为不传该参数
	 */
	//@Test
	public void postAuthenticationManagementListTestTypeNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("解绑账户类型为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 解绑账户类型为原本就为解绑
	 */
	//@Test
	public void postAuthenticationManagementListTestTypeIsUntie() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("type", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "223");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("解绑账户类型为原本就为解绑" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	
}