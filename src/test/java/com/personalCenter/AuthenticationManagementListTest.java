package com.personalCenter;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;
import com.example.LoginTest;
import com.google.gson.Gson;

public class AuthenticationManagementListTest extends HttpUtil {
//认证管理列表接口
	String url = "/UU/authenticate";
	
	JSONObject body;
	String uuid;
	String chcode;
	@BeforeClass
	public void  beforeClass(){
		LoginTest login = new LoginTest();
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
	public void postAuthenticationManagementListTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "3909");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 用户为未认证
	 */
	@Test
	public void postAuthenticationManagementListTestUserIdIsNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "3909");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户为未认证" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		String body1 = post.get("body").toString();
		Map<String, Object> map = new Gson().fromJson(body1, Map.class);
		System.out.println(map);
		List<Map<String, Object>> list = new Gson().fromJson(map.get("recordList").toString(), List.class);
		/*for (Map<String, Object> m : list) {
			System.out.println("每行的值=" + m);
			System.out.println("行字段=" + m.get("authTitle"));
		}*/
		//System.out.println("recordList======"+list.get(0).get("authTitle"));
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(list.get(0).get("authTitle")).isEqualTo("实名认证");
		
		
		
	}
	/**
	 * 用户ID为与登录用户不符
	 */
	@Test
	public void postAuthenticationManagementListTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492211);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "3909");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID存在小数
	 */
	@Test
	public void postAuthenticationManagementListTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12.492125);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "3909");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID存在小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 
	 * 用户ID存在非法字符  
	 */
	@Test
	public void postAuthenticationManagementListTestUserIdIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "<#@$%*&','>");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "3909");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID存在非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID存在负数
	 */
	@Test
	public void postAuthenticationManagementListTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -1249125);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "3909");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID存在负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("请输入有效的用户id");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postAuthenticationManagementListTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "3909");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("请输入有效的用户id");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postAuthenticationManagementListTestUserIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "abdgfhGH");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "3909");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postAuthenticationManagementListTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId","" );
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "3909");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("请输入有效的用户id");
	}
	/**
	 * 用户ID为空格 
	 */
	@Test
	public void postAuthenticationManagementListTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "3909");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postAuthenticationManagementListTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "3909");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("请输入有效的用户id");
	}
	/**
	 * 用户ID不传该 参数
	 */
	@Test
	public void postAuthenticationManagementListTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "3909");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该 参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("请输入有效的用户id");
	}
	
	
	
}