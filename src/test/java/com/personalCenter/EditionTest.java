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

public class EditionTest extends HttpUtil {
//获取版本主要更新记录接口
	String url = "/UU/edition";
	

	/**
	 * 正确参数查询
	 */
	@Test
	public void postEditionTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("systemType", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "3102");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("正确参数查询" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postEditionTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("systemType", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "3102");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postEditionTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("systemType", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "3102");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postEditionTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "<@#$%^&*)_>");
		con.put("systemType", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "3102");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postEditionTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12.49);
		con.put("systemType", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "3102");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postEditionTestUserIdIsNegativeNumbe() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -124L);
		con.put("systemType", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "3102");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postEditionTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("systemType", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "3102");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postEditionTestUserIdIsIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("systemType", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "3102");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postEditionTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		con.put("systemType", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "3102");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postEditionTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
		con.put("systemType", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "3102");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postEditionTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		
		con.put("systemType", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "3102");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 系统类型为0IOS
	 */
	@Test
	public void postEditionTestSystemTypeIsZeroIOS() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("systemType", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "3102");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("系统类型为0IOS" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 系统类型为1android
	 */
	@Test
	public void postEditionTestSystemTypeIsOneandroid() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("systemType", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "3102");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("系统类型为1android" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 系统类型为错误
	 */
	@Test
	public void postEditionTestSystemTypeIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("systemType", 3);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "3102");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("系统类型为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 系统类型为String
	 */
	@Test
	public void postEditionTestSystemTypeIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("systemType", "addffhj");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "3102");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("系统类型为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 系统类型为空
	 */
	@Test
	public void postEditionTestSystemTypeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("systemType", "");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "3102");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("系统类型为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 系统类型为空格
	 */
	@Test
	public void postEditionTestSystemTypeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("systemType", " ");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "3102");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("系统类型为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 系统类型为null
	 */
	@Test
	public void postEditionTestSystemTypeIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("systemType", null);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "3102");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("系统类型为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 系统类型为最大值
	 */
	@Test
	public void postEditionTestSystemTypeIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("systemType", 999999999);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "3102");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("系统类型为最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 系统类型为超长
	 */
	@Test
	public void postEditionTestSystemTypeIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("systemType", 12491740L);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "3102");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("系统类型为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 系统类型为小数
	 */
	@Test
	public void postEditionTestSystemTypeIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("systemType", 1.23);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "3102");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("系统类型为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 系统类型为负数
	 */
	@Test
	public void postEditionTestSystemTypeIsNegativeNumbe() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("systemType", -1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "3102");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("系统类型为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 系统类型不传该参数
	 */
	@Test
	public void postEditionTestSystemTypeNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "3102");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("系统类型不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	
	
	
	
}