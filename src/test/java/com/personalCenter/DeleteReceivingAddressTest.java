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

public class DeleteReceivingAddressTest extends HttpUtil {
//获取多账号关联接口
	String url = "/UU/user";
	

	/**
	 * 提交正确参数
	 */
	@Test
	public void postDeleteReceivingAddressTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
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
	public void postDeleteReceivingAddressTestAddressIdNotTheUser() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
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
	public void postDeleteReceivingAddressTestAddressIdError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
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
	public void postDeleteReceivingAddressTestAddressIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", "vfgdfg");
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
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
	public void postDeleteReceivingAddressTestAddressIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12.4);
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
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
	public void postDeleteReceivingAddressTestAddressIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", -124);
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
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
	public void postDeleteReceivingAddressTestAddressIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 0);
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
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
	public void postDeleteReceivingAddressTestAddressIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", " ");
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
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
	public void postDeleteReceivingAddressTestAddressIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", "");
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
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
		System.out.println("地址id 为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 地址id不传该参数
	 */
	//@Test
	public void postDeleteReceivingAddressTestAddressIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
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
	public void postDeleteReceivingAddressTestAddressIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 45232555558L);
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
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
	 * 地址不属于这个用户
	 */
	//@Test
	public void postDeleteReceivingAddressTestAddressIdIsNotBelongUser() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
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
	public void postDeleteReceivingAddressTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
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
	 * 用户id不存在
	 */
	//@Test
	public void postDeleteReceivingAddressTestUserIdIsNotExist() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", 1249212);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
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
		System.out.println("用户id不存在" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID超长
	 */
	//@Test
	public void postDeleteReceivingAddressTestUserIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", 12492122235L);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
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
	 * 用户ID为空
	 */
	//@Test
	public void postDeleteReceivingAddressTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", "");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
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
	public void postDeleteReceivingAddressTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", " ");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
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
	 * 用户ID为null
	 */
	//@Test
	public void postDeleteReceivingAddressTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", null);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
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
	 * 用户ID不提交
	 */
	//@Test
	public void postDeleteReceivingAddressTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
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
		System.out.println("用户ID不提交" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为0
	 */
	//@Test
	public void postDeleteReceivingAddressTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
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
	 * 用户ID为小数
	 */
	//@Test
	public void postDeleteReceivingAddressTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", 12.69);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
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
	 * 用户ID为负数
	 */
	//@Test
	public void postDeleteReceivingAddressTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12492125);
		con.put("userId", -56);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
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
	
	
	
}