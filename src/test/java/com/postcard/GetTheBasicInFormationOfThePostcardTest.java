package com.postcard;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;
import com.example.LoginTest;
//import com.example.LoginTest;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;

public class GetTheBasicInFormationOfThePostcardTest extends HttpUtil {
	//获取明信片基本信息修改
	String url = "/uu-admin/sensitiveWord/addOrEditSensitiveWord";
	Map<String, Object> head = new HashMap<String, Object>();
	JSONObject body177;
	JSONObject body137;
	String uuid;
	String viewuuid;
	String chcode;
	@BeforeClass
	public void  beforeClass() throws Exception {
		LoginTest login = new LoginTest();
		try {
			body177 = login.getLoginTestChcodeBy177();
			viewuuid= (body177.get("uuid")).toString();
			chcode= (body177.get("checkCode")).toString();
			body137 = login.getLoginTestChcodeBy137();
			uuid= (body137.get("uuid")).toString();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		head.put("aid", "lan6uu");
		head.put("ver", "1.2.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", chcode);
		head.put("cmd", 3402);
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetTheBasicInFormationOfThePostcardTestCorrectParameter() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("viewuuid", viewuuid);
		con.put("cardId ", "10000151");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 被查看人用户id为为最大值
	 */
	@Test
	public void postGetTheBasicInFormationOfThePostcardTestuuidIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", 999999999999999999L);
		con.put("viewuuid", viewuuid);
		con.put("cardId ", "10000151");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查看人用户id为为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 被查看人用户id为为空
	 */
	@Test
	public void postGetTheBasicInFormationOfThePostcardTestuuidIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", "");
		con.put("viewuuid", viewuuid);
		con.put("cardId ", "10000151");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查看人用户id为为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 被查看人用户id为为空格
	 */
	@Test
	public void postGetTheBasicInFormationOfThePostcardTestuuidIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", " ");
		con.put("viewuuid", viewuuid);
		con.put("cardId ", "10000151");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查看人用户id为为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 被查看人用户id为null
	 */
	@Test
	public void postGetTheBasicInFormationOfThePostcardTestuuidIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", null);
		con.put("viewuuid", viewuuid);
		con.put("cardId ", "10000151");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查看人用户id为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 被查看人用户id为不传该参数
	 */
	@Test
	public void postGetTheBasicInFormationOfThePostcardTestuuidNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("viewuuid", viewuuid);
		con.put("cardId ", "10000151");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查看人用户id为不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 查看人用户id为最大值
	 */
	@Test
	public void postGetTheBasicInFormationOfThePostcardTestViewuuidIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("viewuuid", 999999999999999999L);
		con.put("cardId ", "10000151");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查看人用户id为为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 查看人用户id为为空
	 */
	@Test
	public void postGetTheBasicInFormationOfThePostcardTestViewuuidIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("viewuuid", "");
		con.put("cardId ", "10000151");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查看人用户id为为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 查看人用户id为为空格
	 */
	@Test
	public void postGetTheBasicInFormationOfThePostcardTestViewuuidIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("viewuuid", " ");
		con.put("cardId ", "10000151");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查看人用户id为为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 查看人用户id为null
	 */
	@Test
	public void postGetTheBasicInFormationOfThePostcardTestViewuuidIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("viewuuid", null);
		con.put("cardId ", "10000151");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查看人用户id为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 查看人用户id为不传该参数
	 */
	@Test
	public void postGetTheBasicInFormationOfThePostcardTestViewuuidNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cardId ", "10000151");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查看人用户id为不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 名信片id为为最大值
	 */
	@Test
	public void postGetTheBasicInFormationOfThePostcardTestCardIdIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("viewuuid", viewuuid);
		con.put("cardId ", "9999999999999999999999999999");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("名信片id为为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 名信片id为为空
	 */
	@Test
	public void postGetTheBasicInFormationOfThePostcardTestCardIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("viewuuid", viewuuid);
		con.put("cardId ", "");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("名信片id为为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 名信片id为为空格
	 */
	@Test
	public void postGetTheBasicInFormationOfThePostcardTestCardIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("viewuuid", viewuuid);
		con.put("cardId ", " ");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("名信片id为为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 名信片id为null
	 */
	@Test
	public void postGetTheBasicInFormationOfThePostcardTestCardIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("viewuuid", viewuuid);
		con.put("cardId ", null);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("名信片id为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 名信片id为不传该参数
	 */
	@Test
	public void postGetTheBasicInFormationOfThePostcardTestCardIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("viewuuid", viewuuid);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("名信片id为不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	
	
	
}