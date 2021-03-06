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
import com.example.LoginTest;
import com.publicModule.login.BackUserLoginTest;

public class ContainerEditingDetailsTest extends HttpUtil {
// 容器编辑详情接口
	String url = "/uu-admin/container/editContainer";
	JSONObject body;
	String uuid;
	String chcode;
	LoginTest login = new LoginTest();
	@BeforeClass
	public void  beforeClass(){
		
		try {
			body = login.getLoginTestChcodeBy177();
			uuid= (body.get("userId")).toString();
			chcode= (body.get("checkCode")).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postContainerEditingDetailsTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);	
		request.put("containerId", 3);
		
		JSONObject post = super.UNSPost(url, request);
		if (post!=null) {
			System.out.println("提交正确参数" + post);
		}else{
			System.out.println("post为空");
		}
		
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为未登录用户
	 */
	//@Test
	public void postContainerEditingDetailsTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495079);		
		request.put("containerId", 3);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为错误用户
	 */
	//@Test
	public void postContainerEditingDetailsTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 123);		
		request.put("containerId", 3);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userid不存在");
	}
	/**
	 * 用户ID为非法字符
	 */
	//@Test
	public void postContainerEditingDetailsTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<$%^>");				
		request.put("containerId", 3);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 用户ID为小数
	 */
	//@Test
	public void postContainerEditingDetailsTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 3.33);			
		request.put("containerId", 3);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userid不存在");
	}
	/**
	 * 用户ID为负数
	 */
	//@Test
	public void postContainerEditingDetailsTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -121312);				
		request.put("containerId", 3);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为负数");
	}
	/**
	 * 用户ID为空格
	 */
	//@Test
	public void postContainerEditingDetailsTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");					
		request.put("containerId", 3);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户不能为空");
	}
	/**
	 * 用户ID为空
	 */
	//@Test
	public void postContainerEditingDetailsTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");				
		request.put("containerId", 3);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户不能为空");
	}
	/**
	 * 用户ID为null
	 */
	//@Test
	public void postContainerEditingDetailsTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);		
		request.put("containerId", 3);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户不能为空");
	}
	/**
	 * 用户ID为0
	 */
	//@Test
	public void postContainerEditingDetailsTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);			
		request.put("containerId", 3);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userid不存在");
	}
	/**
	 * 用户ID不传该参数
	 */
	//@Test
	public void postContainerEditingDetailsTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("containerId", 3);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户不能为空");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postContainerEditingDetailsTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", "fggf");
		request.put("containerId", 3);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
		
		
	}
	/**
	 * 用户ID超长
	 */
	//@Test
	public void postContainerEditingDetailsTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 999999999999999999L);
		request.put("containerId", 3);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userid不存在");
	}
	/**
	 * 容器id为错误
	 */
	@Test
	public void postContainerEditingDetailsTestContainerIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);				
		request.put("containerId", 300);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为错误" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 容器id为超长
	 */
	@Test
	public void postContainerEditingDetailsTestContainerIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);				
		request.put("containerId", 999999999999999999L);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 容器id为String
	 */
	@Test
	public void postContainerEditingDetailsTestContainerIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);				
		request.put("containerId", "ghdg");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为String" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 容器id为空
	 */
	@Test
	public void postContainerEditingDetailsTestContainerIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);				
		request.put("containerId", "");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为空" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		//assertThat(post.get("msg")).isEqualTo("容器id不能为空");
	}
	/**
	 * 容器id为空格
	 */
	@Test
	public void postContainerEditingDetailsTestContainerIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);				
		request.put("containerId", " ");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		//assertThat(post.get("msg")).isEqualTo("容器id不能为空");
	}
	/**
	 * 容器id为null
	 */
	@Test
	public void postContainerEditingDetailsTestContainerIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);				
		request.put("containerId", null);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为null" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		//assertThat(post.get("msg")).isEqualTo("容器id不能为空");
	}
	/**
	 * 容器id为0
	 */
	@Test
	public void postContainerEditingDetailsTestContainerIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);				
		request.put("containerId", 0);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为0" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("容器id不能为0");
	}
	/**
	 * 容器id为非法字符
	 */
	@Test
	public void postContainerEditingDetailsTestContainerIdIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1249124);				
		request.put("containerId", "<@$%&*_>");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 容器id为小数
	 */
	@Test
	public void postContainerEditingDetailsTestContainerIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);				
		request.put("containerId", 10.3);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器id为负数
	 */
	@Test
	public void postContainerEditingDetailsTestContainerIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);				
		request.put("containerId", -125);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("容器id不能为负数");
	}
	/**
	 * 容器id不传
	 */
	@Test
	public void postContainerEditingDetailsTestContainerIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);				
		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id不传" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		//assertThat(post.get("msg")).isEqualTo("容器id不能为空");
	}
	
}