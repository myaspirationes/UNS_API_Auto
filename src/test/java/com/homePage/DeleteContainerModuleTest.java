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

public class DeleteContainerModuleTest extends HttpUtil {
// 删除容器模块接口
	String url = "/uu-admin/container/deleteHomePageContainer";


	/**
	 * 提交正确参数
	 */
	@Test
	public void postDeleteContainerModuleTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "12495324");				
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为未登录用户
	 */
	//@Test
	public void postDeleteContainerModuleTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "12495324123");		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为错误用户
	 */
	//@Test
	public void postDeleteContainerModuleTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "12312313");		
		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为非法字符
	 */
	//@Test
	public void postDeleteContainerModuleTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<$%^>");				
		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为小数
	 */
	//@Test
	public void postDeleteContainerModuleTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 121123.33);			
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为负数
	 */
	//@Test
	public void postDeleteContainerModuleTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -121312);				
				
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为空格
	 */
	//@Test
	public void postDeleteContainerModuleTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");					
			
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为空
	 */
	//@Test
	public void postDeleteContainerModuleTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");				
		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为null
	 */
	//@Test
	public void postDeleteContainerModuleTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);		
					
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为0
	 */
	//@Test
	public void postDeleteContainerModuleTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);			
		

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID不传该参数
	 */
	//@Test
	public void postDeleteContainerModuleTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为超长
	 */
	//@Test
	public void postDeleteContainerModuleTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", "12495324121222221111122222222");	
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	
	
}