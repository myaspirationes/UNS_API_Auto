package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

public class LoginTest extends HttpUtil {
//登录接口
	String url = "/UU/register";

	

	public JSONObject getLoginTestChcodeBy137() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("password", "1b8a994a442e2cece2ab9b419af29b29");
		con.put("phoneType", 0);
		con.put("token", "0");
		con.put("userMark", "13774323645");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("uuid", -1);
		head.put("ln", "cn");
		head.put("chcode", "");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("cmd", "106");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("登录参数查询" + post);
		JSONObject body = (JSONObject) post.get("body");
		return body;
	}
	public JSONObject getLoginTestChcodeBy177() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("password", "1b8a994a442e2cece2ab9b419af29b29");
		con.put("phoneType", 0);
		con.put("token", "0");
		con.put("userMark", "17740800827");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("uuid", -1);
		head.put("ln", "cn");
		head.put("chcode", "");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("cmd", "106");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("登录参数查询" + post);
		JSONObject body = (JSONObject) post.get("body");
		return body;
	}
	
}