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

public class GetPlateContentDetailsTest extends HttpUtil {
// 获取板块内容详情接口
	String url = "/uu-admin/container/containerInfo";


	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetPlateContentDetailsTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("containerId", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postGetPlateContentDetailsTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1249);	
		request.put("containerId", 22);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postGetPlateContentDetailsTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12312313);	
		request.put("containerId", 22);
		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postGetPlateContentDetailsTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<$%^>");	
		request.put("containerId", 22);
		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postGetPlateContentDetailsTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 121123.33);
		request.put("containerId", 22);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postGetPlateContentDetailsTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -121312);	
		request.put("containerId", 22);
				
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postGetPlateContentDetailsTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");		
		request.put("containerId", 22);
			
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户不能为空");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postGetPlateContentDetailsTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");	
		request.put("containerId", 22);
		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户不能为空");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postGetPlateContentDetailsTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);	
		request.put("containerId", 22);
					
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户不能为空");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postGetPlateContentDetailsTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);	
		request.put("containerId", 2);
		

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为String
	 */
	//@Test
	public void postGetPlateContentDetailsTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "fsddf");	
		request.put("containerId", 22);
		

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 用户ID不传该参数
	 */
	//@Test
	public void postGetPlateContentDetailsTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("containerId", 22);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户不能为空");
	}
	/**
	 * 用户ID为超长
	 */
	//@Test
	public void postGetPlateContentDetailsTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 999999999999999999L);	
		request.put("containerId", 22);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 容器ID为错误
	 */
	//@Test
	public void postGetPlateContentDetailsTestContainerIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		request.put("containerId", 8888888);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID为错误" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 容器ID超长
	 */
	//@Test
	public void postGetPlateContentDetailsTestContainerIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		request.put("containerId", 999999999999999999L);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID超长" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 容器ID为空
	 */
	//@Test
	public void postGetPlateContentDetailsTestContainerIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		request.put("containerId", "");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("容器id不能为空");
	}
	/**
	 * 容器ID存在非法字符
	 */
	//@Test
	public void postGetPlateContentDetailsTestContainerIdIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		request.put("containerId", "<@$^*_>");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 容器ID为小数
	 */
	//@Test
	public void postGetPlateContentDetailsTestContainerIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		request.put("containerId", 2.36);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 容器ID为负数
	 */
	//@Test
	public void postGetPlateContentDetailsTestContainerIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		request.put("containerId", -23);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 容器ID为空格
	 */
	//@Test
	public void postGetPlateContentDetailsTestContainerIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		request.put("containerId", " ");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("容器id不能为空");
	}
	/**
	 * 容器ID为null
	 */
	//@Test
	public void postGetPlateContentDetailsTestContainerIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		request.put("containerId", null);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("容器id不能为空");
	}
	/**
	 * 容器ID为String
	 */
	//@Test
	public void postGetPlateContentDetailsTestContainerIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		request.put("containerId", "gsd");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 容器ID不传该参数
	 */
	//@Test
	public void postGetPlateContentDetailsTestContainerIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("容器id不能为空");
	}
	
	
}