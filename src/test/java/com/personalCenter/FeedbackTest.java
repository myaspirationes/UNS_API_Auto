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

public class FeedbackTest extends HttpUtil {
//帮助与反馈接口
	String url = "/UU/Feedback";
	

	/**
	 * 正确反馈问题
	 */
	@Test
	public void postFeedbackTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491661L);
		con.put("content", "手机闪退");
		con.put("fileId", "1234,132343,3434");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("正确反馈问题" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID错误
	 */
	@Test
	public void postFeedbackTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491661L);
		con.put("content", "手机闪退");
		con.put("fileId", "1234,132343,3434");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户id不存在
	 */
	@Test
	public void postFeedbackTestUserIdIsNotExist() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491661L);
		con.put("content", "手机闪退");
		con.put("fileId", "1234,132343,3434");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id不存在" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID超长
	 */
	@Test
	public void postFeedbackTestUserIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491661L);
		con.put("content", "手机闪退");
		con.put("fileId", "1234,132343,3434");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postFeedbackTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("content", "手机闪退");
		con.put("fileId", "1234,132343,3434");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
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
	 * 用户ID为空格
	 */
	@Test
	public void postFeedbackTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("content", "手机闪退");
		con.put("fileId", "1234,132343,3434");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
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
	 * 用户ID为null
	 */
	@Test
	public void postFeedbackTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		con.put("content", "手机闪退");
		con.put("fileId", "1234,132343,3434");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
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
	 * 用户ID不提交
	 */
	@Test
	public void postFeedbackTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		
		con.put("content", "手机闪退");
		con.put("fileId", "1234,132343,3434");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不提交" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postFeedbackTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
		con.put("content", "手机闪退");
		con.put("fileId", "1234,132343,3434");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
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
	 * 用户ID为小数
	 */
	@Test
	public void postFeedbackTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12.3);
		con.put("content", "手机闪退");
		con.put("fileId", "1234,132343,3434");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
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
	public void postFeedbackTestUserIdIsNegativeNumbe() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -231L);
		con.put("content", "手机闪退");
		con.put("fileId", "1234,132343,3434");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
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
	 * 反馈描述超长
	 */
	@Test
	public void postFeedbackTestContentIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491661L);
		con.put("content", "手机闪退的风格风格豆腐干大概的非官方的是是多少");
		con.put("fileId", "1234,132343,3434");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("反馈描述超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 反馈描述存在非法字符
	 */
	@Test
	public void postFeedbackTestContentIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491661L);
		con.put("content", "<@#%^*)+>");
		con.put("fileId", "1234,132343,3434");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("反馈描述存在非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 反馈描述为空
	 */
	@Test
	public void postFeedbackTestContentIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491661L);
		con.put("content", "");
		con.put("fileId", "1234,132343,3434");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("反馈描述为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 反馈描述为null
	 */
	@Test
	public void postFeedbackTestContentIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491661L);
		con.put("content", null);
		con.put("fileId", "1234,132343,3434");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
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
	 * 反馈描述为空格
	 */
	@Test
	public void postFeedbackTestContentIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491661L);
		con.put("content", " ");
		con.put("fileId", "1234,132343,3434");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("反馈描述为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 反馈描述存在图片URL地址
	 */
	@Test
	public void postFeedbackTestContentIsURL() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491661L);
		con.put("content", "https://www.2345.com/?k872897314");
		con.put("fileId", "1234,132343,3434");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("反馈描述存在图片URL地址" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 反馈描述存在运算符
	 */
	@Test
	public void postFeedbackTestContentIsOperator() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491661L);
		con.put("content", "2+3=5");
		con.put("fileId", "1234,132343,3434");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("反馈描述存在运算符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 图片ID超过5张
	 */
	@Test
	public void postFeedbackTestFileIdIsMoreFive() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491661L);
		con.put("content", "手机闪退");
		con.put("fileId", "1234,132343,3434,124,13343,13943");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片ID超过5张" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 图片ID等于5张
	 */
	@Test
	public void postFeedbackTestFileIdIsFive() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491661L);
		con.put("content", "手机闪退");
		con.put("fileId", "1234,132343,3434,124,13343");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片ID等于5张" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 图片ID为6张其中1张为错误的
	 */
	@Test
	public void postFeedbackTestFileIdIsSixAndOneIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491661L);
		con.put("content", "手机闪退");
		con.put("fileId", "1234,132343,3434,124,13343,13943");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片ID为6张其中1张为错误的" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 图片ID为5张其中一张为错误
	 */
	@Test
	public void postFeedbackTestFileIdIsFiveAndOneIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491661L);
		con.put("content", "手机闪退");
		con.put("fileId", "1234,132343,3434,124,13343");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片ID为5张其中一张为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 图片ID为1张
	 */
	@Test
	public void postFeedbackTestFileIdIsOne() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491661L);
		con.put("content", "手机闪退");
		con.put("fileId", "1234");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片ID为1张" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 图片ID为0张
	 */
	@Test
	public void postFeedbackTestFileIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491661L);
		con.put("content", "手机闪退");
		con.put("fileId", ",");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片ID为0张" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 图片Id之间的分隔符非法
	 */
	@Test
	public void postFeedbackTestFileIdSeparatorIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491661L);
		con.put("content", "手机闪退");
		con.put("fileId", "1234￥132343%3434*124");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片Id之间的分隔符非法" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 图片ID存在小数
	 */
	@Test
	public void postFeedbackTestFileIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491661L);
		con.put("content", "手机闪退");
		con.put("fileId", "12.34,13.2343,3.43");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片ID存在小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 图片ID存在负数
	 */
	@Test
	public void postFeedbackTestFileIdIsNegativeNumbe() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491661L);
		con.put("content", "手机闪退");
		con.put("fileId", "-1234,-132343,343");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片ID存在负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 图片ID为空
	 */
	@Test
	public void postFeedbackTestFileIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491661L);
		con.put("content", "手机闪退");
		con.put("fileId", "");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 图片ID为null
	 */
	@Test
	public void postFeedbackTestFileIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491661L);
		con.put("content", "手机闪退");
		con.put("fileId", null);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 图片ID为空格
	 */
	@Test
	public void postFeedbackTestFileIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491661L);
		con.put("content", "手机闪退");
		con.put("fileId", " ");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 图片ID不传该参数
	 */
	@Test
	public void postFeedbackTestFileIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491661L);
		con.put("content", "手机闪退");
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12491751");
		head.put("ln", "cn");
		head.put("chcode", "RhIdm0fijYBstecNo/BBAa+qVTEnjyqr");
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	
		
	
}