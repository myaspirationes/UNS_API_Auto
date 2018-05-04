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

public class SettingDefaultReceivingAddressTest extends HttpUtil {
//设置默认收货地址
	String url = "/UU/user";
	

	/**
	 * 提交正确参数
	 */
	@Test
	public void postSettingDefaultReceivingAddressTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVofJYONk/2WNKsV0cl15KcM");
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
	 * 地址ID 非此用户
	 */
	//@Test
	public void postSettingDefaultReceivingAddressTestAddressIdNotTheUser() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVofJYONk/2WNKsV0cl15KcM");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址ID 非此用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
			
	}
	/**
	 * 地址id错误信息
	 */
	//@Test
	public void postSettingDefaultReceivingAddressTestAddressIdError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVofJYONk/2WNKsV0cl15KcM");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址id错误信息" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
			
	}
	/**
	 * 地址id为String类型
	 */
	//@Test
	public void postSettingDefaultReceivingAddressTestAddressIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", "fgdfggh");
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVofJYONk/2WNKsV0cl15KcM");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址id为String类型" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
			
	}
	/**
	 * 地址id为小数
	 */
	//@Test
	public void postSettingDefaultReceivingAddressTestAddressIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12.4);
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVofJYONk/2WNKsV0cl15KcM");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址id为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
			
	}
	/**
	 * 地址id为负数
	 */
	//@Test
	public void postSettingDefaultReceivingAddressTestAddressIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", -124);
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVofJYONk/2WNKsV0cl15KcM");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址id为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
			
	}
	/**
	 * 地址id为0
	 */
	//@Test
	public void postSettingDefaultReceivingAddressTestAddressIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 0);
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVofJYONk/2WNKsV0cl15KcM");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址id为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
			
	}
	/**
	 * 地址id为空格
	 */
	//@Test
	public void postSettingDefaultReceivingAddressTestAddressIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", " ");
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVofJYONk/2WNKsV0cl15KcM");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址id为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
			
	}
	/**
	 * 地址id 为空
	 */
	//@Test
	public void postSettingDefaultReceivingAddressTestAddressIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", "");
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVofJYONk/2WNKsV0cl15KcM");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址id为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
			
	}
	/**
	 * 地址id不传该参数
	 */
	//@Test
	public void postSettingDefaultReceivingAddressTestAddressIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVofJYONk/2WNKsV0cl15KcM");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址id不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
			
	}
	/**
	 * 地址id为超长
	 */
	//@Test
	public void postSettingDefaultReceivingAddressTestAddressIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 5645542132L);
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVofJYONk/2WNKsV0cl15KcM");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址id为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
			
	}
	/**
	 * 用户ID错误
	 */
	//@Test
	public void postSettingDefaultReceivingAddressTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVofJYONk/2WNKsV0cl15KcM");
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
	public void postSettingDefaultReceivingAddressTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVofJYONk/2WNKsV0cl15KcM");
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
	public void postSettingDefaultReceivingAddressTestUserIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", 5645542132L);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVofJYONk/2WNKsV0cl15KcM");
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
	public void postSettingDefaultReceivingAddressTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVofJYONk/2WNKsV0cl15KcM");
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
	public void postSettingDefaultReceivingAddressTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", -56);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVofJYONk/2WNKsV0cl15KcM");
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
	public void postSettingDefaultReceivingAddressTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", 12.45);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVofJYONk/2WNKsV0cl15KcM");
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
	public void postSettingDefaultReceivingAddressTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", "");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVofJYONk/2WNKsV0cl15KcM");
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
	public void postSettingDefaultReceivingAddressTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", " ");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVofJYONk/2WNKsV0cl15KcM");
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
	public void postSettingDefaultReceivingAddressTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", "<@#^*)_+>");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVofJYONk/2WNKsV0cl15KcM");
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
	public void postSettingDefaultReceivingAddressTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", null);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVofJYONk/2WNKsV0cl15KcM");
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
	public void postSettingDefaultReceivingAddressTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVofJYONk/2WNKsV0cl15KcM");
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
	 * 设置多个默认地址
	 */
	//@Test
	public void postSettingDefaultReceivingAddressTestSetMangDefaultAddress() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", 12492125);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVofJYONk/2WNKsV0cl15KcM");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("设置多个默认地址" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
			
	}
	/**
	 * 设置地址已是默认地址
	 */
	//@Test
	public void postSettingDefaultReceivingAddressTestSetAddressExisted() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", 12492125);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVofJYONk/2WNKsV0cl15KcM");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("设置地址已是默认地址" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
			
	}
	
	
	
	
}