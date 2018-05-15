package com.homePage;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;

public class GetPlateDefaultParameterTest extends HttpUtil {
// 获取板块参数接口
	String url = "/container/getDefaultParameters";


	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetPlateDefaultParameterTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");				
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为未登录用户
	 */
	//@Test
	public void postGetPlateDefaultParameterTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324123");		
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为错误用户
	 */
	//@Test
	public void postGetPlateDefaultParameterTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12312sd313");		
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为非法字符
	 */
	//@Test
	public void postGetPlateDefaultParameterTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "<$%^>");				
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为小数
	 */
	//@Test
	public void postGetPlateDefaultParameterTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 121123.33);			
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为负数
	 */
	//@Test
	public void postGetPlateDefaultParameterTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -121312);				
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为空格
	 */
	//@Test
	public void postGetPlateDefaultParameterTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");					
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为空
	 */
	//@Test
	public void postGetPlateDefaultParameterTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");				
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为null
	 */
	//@Test
	public void postGetPlateDefaultParameterTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);		
			
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为0
	 */
	//@Test
	public void postGetPlateDefaultParameterTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);			
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID不传该参数
	 */
	//@Test
	public void postGetPlateDefaultParameterTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();		
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);

		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	
	
}