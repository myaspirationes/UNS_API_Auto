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
import com.example.LoginTest;
import com.example.MetaOper;

public class NoDisturbModeSetStateAcquisitionTest extends HttpUtil {
//勿扰模式设置状态获取接口
	String url = "/UU/user";
	String dataType = "perCenter81";
	String chcode;
	LoginTest login = new LoginTest();
	@BeforeClass
	public void  beforeClass(){
		LoginTest login = new LoginTest();
		try {
			chcode = login.getLoginTestChcodeBy177();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 提交正确参数
	 */
	//@Test
	public void postNoDisturbModeSetStateAcquisitionTestCorrectParameter() throws Exception {
		NoDisturbModeSettingTest hpa = new NoDisturbModeSettingTest();
		hpa.postNoDisturbModeSettingTestCorrectParameterNoOpen();
		chcode = login.getLoginTestChcodeBy177();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3711");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
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
	 * 用户ID错误
	 */
	@Test
	public void postNoDisturbModeSetStateAcquisitionTesUserIdIsError() throws Exception {
		NoDisturbModeSettingTest hpa = new NoDisturbModeSettingTest();
		hpa.postNoDisturbModeSettingTestCorrectParameterNoOpen();
		chcode = login.getLoginTestChcodeBy177();
		Map<String, Object> con = new HashMap<String, Object>();
		
		con.put("userId", "1249532456");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3711");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("没有对应用户id的用户");
	}
	/**
	 * 用户ID用户未登录
	 */
	//@Test
	public void postNoDisturbModeSetStateAcquisitionTestUserIdNotLoggedIn() throws Exception {
		NoDisturbModeSettingTest hpa = new NoDisturbModeSettingTest();
		hpa.postNoDisturbModeSettingTestCorrectParameterNoOpen();
		chcode = login.getLoginTestChcodeBy177();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "1249532333");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3711");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID用户未登录" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("没有对应用户id的用户");
	}
	/**
	 * 用户ID超长
	 */
	//@Test
	public void postNoDisturbModeSetStateAcquisitionTestUserIdIsLong() throws Exception {
		NoDisturbModeSettingTest hpa = new NoDisturbModeSettingTest();
		hpa.postNoDisturbModeSettingTestCorrectParameterNoOpen();
		chcode = login.getLoginTestChcodeBy177();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "1249532412345655552245445656789");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3711");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("没有对应用户id的用户");
	}
	/**
	 * 用户ID为0
	 */
	//@Test
	public void postNoDisturbModeSetStateAcquisitionTestUserIdIsZero() throws Exception {
		NoDisturbModeSettingTest hpa = new NoDisturbModeSettingTest();
		hpa.postNoDisturbModeSettingTestCorrectParameterNoOpen();
		chcode = login.getLoginTestChcodeBy177();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3711");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId格式不对");
	}
	/**
	 * 用户ID为负数
	 */
	//@Test
	public void postNoDisturbModeSetStateAcquisitionTestUserIdIsNegativeNumbe() throws Exception {
		NoDisturbModeSettingTest hpa = new NoDisturbModeSettingTest();
		hpa.postNoDisturbModeSettingTestCorrectParameterNoOpen();
		chcode = login.getLoginTestChcodeBy177();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "-234");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3711");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId格式不对");
	}
	/**
	 * 用户ID为小数
	 */
	//@Test
	public void postNoDisturbModeSetStateAcquisitionTestUserIdIsDecimal() throws Exception {
		NoDisturbModeSettingTest hpa = new NoDisturbModeSettingTest();
		hpa.postNoDisturbModeSettingTestCorrectParameterNoOpen();
		chcode = login.getLoginTestChcodeBy177();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "23.34");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3711");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId格式不对");
	}
	/**
	 * 用户ID为空
	 */
	//@Test
	public void postNoDisturbModeSetStateAcquisitionTestUserIdIsEmpty() throws Exception {
		NoDisturbModeSettingTest hpa = new NoDisturbModeSettingTest();
		hpa.postNoDisturbModeSettingTestCorrectParameterNoOpen();
		chcode = login.getLoginTestChcodeBy177();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3711");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId格式不对");
	}
	/**
	 * 用户ID为空格
	 */
	//@Test
	public void postNoDisturbModeSetStateAcquisitionTestUserIdIsSpace() throws Exception {
		NoDisturbModeSettingTest hpa = new NoDisturbModeSettingTest();
		hpa.postNoDisturbModeSettingTestCorrectParameterNoOpen();
		chcode = login.getLoginTestChcodeBy177();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3711");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId格式不对");
	}
	/**
	 * 用户ID存在非法字符
	 */
	//@Test
	public void postNoDisturbModeSetStateAcquisitionTestUserIdIllegalCharacters() throws Exception {
		NoDisturbModeSettingTest hpa = new NoDisturbModeSettingTest();
		hpa.postNoDisturbModeSettingTestCorrectParameterNoOpen();
		chcode = login.getLoginTestChcodeBy177();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "<#%^&(_>");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3711");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID存在非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId格式不对");
	}
	/**
	 * 用户ID为null
	 */
	//@Test
	public void postNoDisturbModeSetStateAcquisitionTestUserIdIsNull() throws Exception {
		NoDisturbModeSettingTest hpa = new NoDisturbModeSettingTest();
		hpa.postNoDisturbModeSettingTestCorrectParameterNoOpen();
		chcode = login.getLoginTestChcodeBy177();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3711");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId为空");
	}
	/**
	 * 用户ID不传该参数
	 */
	//@Test
	public void postNoDisturbModeSetStateAcquisitionTestUserIdNonSubmissionParameters() throws Exception {
		NoDisturbModeSettingTest hpa = new NoDisturbModeSettingTest();
		hpa.postNoDisturbModeSettingTestCorrectParameterNoOpen();
		chcode = login.getLoginTestChcodeBy177();
		Map<String, Object> con = new HashMap<String, Object>();
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3711");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId为空");
	}
	
		
	
}