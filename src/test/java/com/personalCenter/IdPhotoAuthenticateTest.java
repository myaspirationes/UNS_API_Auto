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

public class IdPhotoAuthenticateTest extends HttpUtil {
//证件照认证接口
	String url = "/UU/register";
	

	/**
	 * 提交正确参数
	 */
	@Test
	public void postIdPhotoAuthenticateTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("positiveId", 33333);
		con.put("reverseId", 44444);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
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
	 * 用户ID为未登录用户
	 */
	@Test
	public void postIdPhotoAuthenticateTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 111111);
		con.put("positiveId", 33333);
		con.put("reverseId", 44444);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
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
	public void postIdPhotoAuthenticateTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "231231233rf3");
		con.put("positiveId", 33333);
		con.put("reverseId", 44444);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
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
	public void postIdPhotoAuthenticateTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "<@#$%^&>");
		con.put("positiveId", 33333);
		con.put("reverseId", 44444);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
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
	public void postIdPhotoAuthenticateTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125.1);
		con.put("positiveId", 33333);
		con.put("reverseId", 44444);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
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
	public void postIdPhotoAuthenticateTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -12492125);
		con.put("positiveId", 33333);
		con.put("reverseId", 44444);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
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
	public void postIdPhotoAuthenticateTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("positiveId", 33333);
		con.put("reverseId", 44444);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
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
	public void postIdPhotoAuthenticateTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("positiveId", 33333);
		con.put("reverseId", 44444);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
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
	public void postIdPhotoAuthenticateTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		con.put("positiveId", 33333);
		con.put("reverseId", 44444);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
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
	public void postIdPhotoAuthenticateTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
		con.put("positiveId", 33333);
		con.put("reverseId", 44444);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
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
	public void postIdPhotoAuthenticateTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("positiveId", 33333);
		con.put("reverseId", 44444);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
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
	 * 正面图ID为错误
	 */
	@Test
	public void postIdPhotoAuthenticateTestPositiveIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("positiveId", "56s654d");
		con.put("reverseId", 44444);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("正面图ID为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 正面图ID与反面图ID不符
	 */
	@Test
	public void postIdPhotoAuthenticateTestPositiveIdNotTheSameAsReverseId() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("positiveId", 11133333);
		con.put("reverseId", 44444);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("正面图ID与反面图ID不符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 正面图ID为空
	 */
	@Test
	public void postIdPhotoAuthenticateTestPositiveIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("positiveId", "");
		con.put("reverseId", 44444);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("正面图ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 正面图ID为空格
	 */
	@Test
	public void postIdPhotoAuthenticateTestPositiveIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("positiveId", " ");
		con.put("reverseId", 44444);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("正面图ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 正面图ID为nul
	 */
	@Test
	public void postIdPhotoAuthenticateTestPositiveIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("positiveId", null);
		con.put("reverseId", 44444);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("正面图ID为nul" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 正面图ID不传该参数
	 */
	@Test
	public void postIdPhotoAuthenticateTestPositiveIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("reverseId", 44444);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("正面图ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 正面图ID超长
	 */
	@Test
	public void postIdPhotoAuthenticateTestPositiveIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("positiveId", 88888888);
		con.put("reverseId", 44444);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("正面图ID超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 正面ID为小数
	 */
	@Test
	public void postIdPhotoAuthenticateTestPositiveIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("positiveId", 33333.3);
		con.put("reverseId", 44444);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("正面ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 正面ID为负数
	 */
	@Test
	public void postIdPhotoAuthenticateTestPositiveIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("positiveId", -33333);
		con.put("reverseId", 44444);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("正面ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 正面ID为0
	 */
	@Test
	public void postIdPhotoAuthenticateTestPositiveIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("positiveId", 0);
		con.put("reverseId", 44444);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("正面ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 反面图ID为错误
	 */
	@Test
	public void postIdPhotoAuthenticateTestReverseIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("positiveId", 33333);
		con.put("reverseId", "44fg444");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("反面图ID为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 反面图ID为空
	 */
	@Test
	public void postIdPhotoAuthenticateTestReverseIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("positiveId", 33333);
		con.put("reverseId", "");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("反面图ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 反面图ID为空格
	 */
	@Test
	public void postIdPhotoAuthenticateTestReverseIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("positiveId", 33333);
		con.put("reverseId", " ");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("反面图ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 反面图ID为null
	 */
	@Test
	public void postIdPhotoAuthenticateTestReverseIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("positiveId", 33333);
		con.put("reverseId", null);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("反面图ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 反面图ID不传该参数
	 */
	@Test
	public void postIdPhotoAuthenticateTestreverseIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("positiveId", 33333);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("反面图ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 反面图ID超长
	 */
	@Test
	public void postIdPhotoAuthenticateTestReverseIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("positiveId", 33333);
		con.put("reverseId", 444444444);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("反面图ID超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 反面ID为0
	 */
	@Test
	public void postIdPhotoAuthenticateTestReverseIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("positiveId", 33333);
		con.put("reverseId", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("反面ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 反面ID为负数
	 */
	@Test
	public void postIdPhotoAuthenticateTestReverseIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("positiveId", 33333);
		con.put("reverseId", -44444);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("反面ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 反面ID为小数
	 */
	@Test
	public void postIdPhotoAuthenticateTestReverseIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("positiveId", 33333);
		con.put("reverseId", 44444.4);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "ios");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVr6C2/i63ZvVn9i2yraEAND");
		head.put("sync", 1);
		head.put("aid", "lan66");
		head.put("ver", "1.0");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("反面ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	
	
	
}