package com.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;

public class RegisterTest extends HttpUtil {

	String url = "/UU/register";
	@BeforeClass
	@AfterClass

	/**
	 * 登录验证不存在用户
	 * @return 
	 * @return 
	 * 1sss
	 * @throws Exception
	 */
	@Test
	public void registerTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("phoneType", 0);
		con.put("token", "(HONOR)DUK-AL20001249774500001");
		con.put("password", "1b8a994a442e2cece2ab9b419af29b29");
		con.put("userMark", "13774323645");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12491610);
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("cmd", "3906");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("登录验证不存在用户参数正确" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("msg")).isEqualTo("没有此用户!");
		
		//assertThat(post.get("message")).isEqualTo("success");
		
	}
	
	
}