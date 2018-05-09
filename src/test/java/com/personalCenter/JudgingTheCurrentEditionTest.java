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

public class JudgingTheCurrentEditionTest extends HttpUtil {
// 判断当前版本是否最新接口
	String url = "/UU/edition";


	/**
	 * 提交正确参数
	 */
	@Test
	public void postAuthenticateTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("systemType", 1);
		con.put("editionNumber", "1.2.1");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
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
	 * 用户ID为未登录用户
	 */
	@Test
	public void postAuthenticateTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12312313);
		con.put("systemType", 1);
		con.put("editionNumber", "1.2.1");
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postAuthenticateTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12312sd313");
		con.put("systemType", 1);
		con.put("editionNumber", "1.2.1");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postAuthenticateTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "<$%^>");
		con.put("systemType", 1);
		con.put("editionNumber", "1.2.1");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postAuthenticateTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12123123.33);
		con.put("systemType", 1);
		con.put("editionNumber", "1.2.1");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postAuthenticateTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -121312);
		con.put("systemType", 1);
		con.put("editionNumber", "1.2.1");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postAuthenticateTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("systemType", 1);
		con.put("editionNumber", "1.2.1");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
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
	 * 用户ID为空
	 */
	@Test
	public void postAuthenticateTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("systemType", 1);
		con.put("editionNumber", "1.2.1");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postAuthenticateTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		con.put("systemType", 1);
		con.put("editionNumber", "1.2.1");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postAuthenticateTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
		con.put("systemType", 1);
		con.put("editionNumber", "1.2.1");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postAuthenticateTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("systemType", 1);
		con.put("editionNumber", "1.2.1");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 系统类型为0IOS
	 */
	@Test
	public void postAuthenticateTestSystemTypeIsIOS() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("systemType", 0);
		con.put("editionNumber", "1.2.1");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提系统类型为0IOS" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 系统类型为1android
	 */
	@Test
	public void postAuthenticateTestSystemTypeIsAndroid() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("systemType", 1);
		con.put("editionNumber", "1.2.1");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("系统类型为1android" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 系统类型为错误
	 */
	@Test
	public void postAuthenticateTestSystemTypeIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("systemType", 999);
		con.put("editionNumber", "1.2.1");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("系统类型为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("不存在的设备类型");
	}
	/**
	 * 系统类型为String
	 */
	@Test
	public void postAuthenticateTestSystemTypeIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("systemType", "aaa");
		con.put("editionNumber", "1.2.1");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("系统类型为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 系统类型为空
	 */
	@Test
	public void postAuthenticateTestSystemTypeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("systemType", "");
		con.put("editionNumber", "1.2.1");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("系统类型为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 系统类型为空格
	 */
	@Test
	public void postAuthenticateTestSystemTypeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("systemType", " ");
		con.put("editionNumber", "1.2.1");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("系统类型为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 系统类型为null
	 */
	@Test
	public void postAuthenticateTeStsystemTypeIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("systemType", 1);
		con.put("editionNumber", "1.2.1");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("系统类型为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 系统类型为最大值
	 */
	@Test
	public void postAuthenticateTestSystemTypeIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("systemType", 999999999);
		con.put("editionNumber", "1.2.1");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("系统类型为最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("不存在的设备类型");
	}
	/**
	 * 系统类型为超长
	 */
	@Test
	public void postAuthenticateTestSystemTypeIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("systemType", 99999999999L);
		con.put("editionNumber", "1.2.1");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("系统类型为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("不存在的设备类型");
	}
	/**
	 * 系统类型为小数
	 */
	@Test
	public void postAuthenticateTestSystemTypeIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("systemType", 1.5);
		con.put("editionNumber", "1.2.1");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("系统类型为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 系统类型为负数
	 */
	@Test
	public void postAuthenticateTestSystemTypeIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("systemType", -1);
		con.put("editionNumber", "1.2.1");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("系统类型为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 系统类型不传该参数
	 */
	@Test
	public void postAuthenticateTestSystemTypeNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("editionNumber", "1.2.1");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("系统类型不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 版本号错误
	 */
	@Test
	public void postAuthenticateTestEditionNumberIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("systemType", 1);
		con.put("editionNumber", "9999");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("版本号错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 版本号超长
	 */
	@Test
	public void postAuthenticateTestEditionNumberIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("systemType", 1);
		con.put("editionNumber", "1111.111111112.1111111111111111111111111111111111111111111111");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("版本号超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 版本号为空
	 */
	@Test
	public void postAuthenticateTestEditionNumberIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("systemType", 1);
		con.put("editionNumber", "");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("版本号为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 版本号为空格
	 */
	@Test
	public void postAuthenticateTestEditionNumberIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("systemType", 1);
		con.put("editionNumber", " ");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("版本号为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 版本号为null
	 */
	@Test
	public void postAuthenticateTestEditionNumberIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("systemType", 1);
		con.put("editionNumber", null);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("版本号为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 版本号不传该参数
	 */
	@Test
	public void postAuthenticateTestEditionNumberNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("systemType", 1);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 3102);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("版本号不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	
}