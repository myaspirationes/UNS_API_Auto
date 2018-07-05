package com.postcard;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;
import com.example.LoginTest;
//import com.example.LoginTest;

public class UserAgeEntryTest extends HttpUtil {
	//用户年龄录入情况（包含实名录入和自己选择）
	String url = "/uu-admin/sensitiveWord/addOrEditSensitiveWord";
	Map<String, Object> head = new HashMap<String, Object>();
	JSONObject body177;
	String uuid;
	String chcode;
	@BeforeClass
	public void  beforeClass() throws Exception {
		LoginTest login = new LoginTest();
		try {
			body177 = login.getLoginTestChcodeBy177();
			uuid= (body177.get("uuid")).toString();
			chcode= (body177.get("checkCode")).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		head.put("aid", "lan6uu");
		head.put("ver", "1.2.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", chcode);
		head.put("cmd", 224);
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postUserAgeEntryTestCorrectParameter() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 用户id为为最大值
	 */
	@Test
	public void postUserAgeEntryTestuuidIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", 999999999999999999L);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 用户id为为空
	 */
	@Test
	public void postUserAgeEntryTestuuidIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", "");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 用户id为为空格
	 */
	@Test
	public void postUserAgeEntryTestuuidIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", " ");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 用户id为null
	 */
	@Test
	public void postUserAgeEntryTestuuidIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", null);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 用户id为不传该参数
	 */
	@Test
	public void postUserAgeEntryTestuuidNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	
	
	
	
}