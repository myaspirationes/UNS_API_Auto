package com.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;

public class RegisterTest extends HttpUtil {

	String url = "/UU/register";
	
	

	/**
	 * 登录验证不存在用户
	 * @return 
	 * @return 
	 * 
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
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("cmd", "106");
		head.put("de", "2018-03-26 18:03:43");
		head.put("uuid", "-1");
		head.put("ln", "cn");
		head.put("chcode", "7.0");
		head.put("sync", "");
		head.put("aid", "lan66");
		head.put("ver", "2.1.1");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.jfscPost(url, request);
		System.out.println("登录验证不存在用户参数正确" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("msg")).isEqualTo("没有此用户!");
		
		//assertThat(post.get("message")).isEqualTo("success");
		
	}
	
	
}