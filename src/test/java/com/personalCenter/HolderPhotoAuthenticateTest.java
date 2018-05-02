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

public class HolderPhotoAuthenticateTest extends HttpUtil {
//持件照接口
	String url = "/UU/register";
	@BeforeClass
	@AfterClass

	/**
	 * 提交正确参数
	 */
	@Test
	public void requestHolderPhotoAuthenticateTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("holdId", 8888888);
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
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	/**
	 * 持证图片ID为错误格式
	 */
	//@Test
	public void requestHolderPhotoAuthenticateTestholdIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("holdId", "888888");
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
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("持证图片ID为错误格式" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
		
		
	}
	/**
	 * 持证图片ID存在非法字符
	 */
	//@Test
	public void requestHolderPhotoAuthenticateTestholdIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("holdId", "<><@#$");
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
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("持证图片ID为错误格式" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 持证图片ID超长字符
	 */
	//@Test
	public void requestHolderPhotoAuthenticateTestholdIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("holdId", 888888888);
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
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("持证图片ID超长字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 持证图片ID为空格
	 */
	//@Test
	public void requestHolderPhotoAuthenticateTestholdIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("holdId", " ");
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
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("持证图片ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 持证图片ID为空
	 */
	//@Test
	public void requestHolderPhotoAuthenticateTestholdIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("holdId", "");
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
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("持证图片ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 持证图片ID为null
	 */
	//@Test
	public void requestHolderPhotoAuthenticateTestholdIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("holdId", null);
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
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("持证图片ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 持证图片ID不提交该参数
	 */
	//@Test
	public void requestHolderPhotoAuthenticateTestholdIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
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
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("持证图片ID不提交该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void requestHolderPhotoAuthenticateTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("holdId", 8888888);
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
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void requestHolderPhotoAuthenticateTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("holdId", 8888888);
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
	public void requestHolderPhotoAuthenticateTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "<>#$%^");
		con.put("holdId", 8888888);
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
	public void requestHolderPhotoAuthenticateTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125.1);
		con.put("holdId", 8888888);
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
	public void requestHolderPhotoAuthenticateTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -12492125);
		con.put("holdId", 8888888);
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
	public void requestHolderPhotoAuthenticateTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("holdId", 8888888);
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
	public void requestHolderPhotoAuthenticateTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("holdId", 8888888);
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
	public void requestHolderPhotoAuthenticateTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		con.put("holdId", 8888888);
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
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void requestHolderPhotoAuthenticateTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("holdId", 8888888);
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
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void requestHolderPhotoAuthenticateTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
		con.put("holdId", 8888888);
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
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 持证图片ID为小数
	 */
	@Test
	public void requestHolderPhotoAuthenticateTestHoldIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("holdId", 8888888.8);
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
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("持证图片ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 持证图片ID为负数
	 */
	@Test
	public void requestHolderPhotoAuthenticateTestHoldIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("holdId", -8888888);
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
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 持证图片ID为0
	 */
	@Test
	public void requestHolderPhotoAuthenticateTestHoldIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("holdId", 8888888);
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
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("持证图片ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	
	
}