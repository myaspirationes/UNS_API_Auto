package com.personalCenter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;
import com.example.LoginTest;
import com.example.MetaOper;

public class FeedbackTest extends HttpUtil {
//帮助与反馈接口
	String url = "/UU/feedback";
	String dataType = "perCenter81";
	String selectSql = "SELECT * FROM T_FEEDBACK WHERE USER_ID = '12495396'";
	String deleteSql = "DELETE T_FEEDBACK WHERE USER_ID IN('12495396','12495079')";
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
	 * 正确反馈问题
	 */
	@Test
	public void postFeedbackTestCorrectParameter() throws Exception {
		List<Map<String,Object>> list ;
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("content", "手机闪退手机闪退手机闪退手机闪退手机闪退手机闪退手机闪退");
		con.put("fileId", "10000159,10000160,10000161");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("正确反馈问题" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("反馈成功");
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("FEEDBACK_CONTENT").toString()).isEqualTo("手机闪退手机闪退手机闪退手机闪退手机闪退手机闪退手机闪退");
	}
	/**
	 * 用户ID错误
	 */
	@Test
	public void postFeedbackTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495325);
		con.put("content", "手机闪退手机闪退手机闪退手机闪退手机闪退");
		con.put("fileId", "10000159,10000160,10000161");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("用户不存在");
	}
	/**
	 * 用户id不存在
	 */
	@Test
	public void postFeedbackTestUserIdIsNotExist() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495AA324");
		con.put("content", "手机闪退手机闪退手机闪退手机闪退手机闪退");
		con.put("fileId", "10000159,10000160,10000161");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id不存在" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId非法");
	}
	/**
	 * 用户ID超长
	 */
	@Test
	public void postFeedbackTestUserIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324123123123123123123143415134513452346456345756478");
		con.put("content", "手机闪退手机闪退手机闪退手机闪退手机闪退");
		con.put("fileId", "10000159,10000160,10000161");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId非法");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postFeedbackTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("content", "手机闪退手机闪退手机闪退手机闪退手机闪退");
		con.put("fileId", "10000159,10000160,10000161");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId非法");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postFeedbackTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("content", "手机闪退手机闪退手机闪退手机闪退手机闪退");
		con.put("fileId", "10000159,10000160,10000161");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId非法");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postFeedbackTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		con.put("content", "手机闪退手机闪退手机闪退手机闪退手机闪退");
		con.put("fileId", "10000159,10000160,10000161");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不能为空");
	}
	/**
	 * 用户ID不提交
	 */
	@Test
	public void postFeedbackTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		
		con.put("content", "手机闪退手机闪退手机闪退手机闪退手机闪退");
		con.put("fileId", "10000159,10000160,10000161");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不提交" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不能为空");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postFeedbackTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
		con.put("content", "手机闪退手机闪退手机闪退手机闪退手机闪退");
		con.put("fileId", "10000159,10000160,10000161");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId非法");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postFeedbackTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12.3);
		con.put("content", "手机闪退手机闪退手机闪退手机闪退手机闪退");
		con.put("fileId", "10000159,10000160,10000161");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId非法");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postFeedbackTestUserIdIsNegativeNumbe() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -231L);
		con.put("content", "手机闪退手机闪退手机闪退手机闪退手机闪退");
		con.put("fileId", "10000159,10000160,10000161");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId非法");
	}
	/**
	 * 反馈描述超长
	 */
	@Test
	public void postFeedbackTestContentIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("content", "手机闪退的风格风格豆腐干大概的非官方的是是多少");
		con.put("fileId", "10000159,10000160,10000161");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("反馈描述超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("反馈成功");
	}
	/**
	 * 反馈描述存在非法字符
	 */
	@Test
	public void postFeedbackTestContentIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("content", "<@#%$%^&$#%^&$%^&*%^&^*)+>");
		con.put("fileId", "10000159,10000160,10000161");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("反馈描述存在非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("反馈成功");
	}
	/**
	 * 反馈描述为空
	 */
	@Test
	public void postFeedbackTestContentIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("content", "");
		con.put("fileId", "10000159,10000160,10000161");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("反馈描述为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("请填写大于10个字的反馈意见");
	}
	/**
	 * 反馈描述为null
	 */
	@Test
	public void postFeedbackTestContentIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("content", null);
		con.put("fileId", "10000159,10000160,10000161");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("反馈描述为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不能为空");
	}
	/**
	 * 反馈描述为空格
	 */
	@Test
	public void postFeedbackTestContentIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("content", "                                ");
		con.put("fileId", "10000159,10000160,10000161");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("反馈描述为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("反馈成功");
	}
	/**
	 * 反馈描述存在图片URL地址
	 */
	@Test
	public void postFeedbackTestContentIsURL() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("content", "https://www.2345.com/?k872897314");
		con.put("fileId", "10000159,10000160,10000161");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("反馈描述存在图片URL地址" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("反馈成功");
	}
	/**
	 * 反馈描述存在运算符
	 */
	@Test
	public void postFeedbackTestContentIsOperator() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("content", "2111111111+22222222223");
		con.put("fileId", "10000159,10000160,10000161");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("反馈描述存在运算符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("反馈成功");
	}
	/**
	 * 图片ID超过5张
	 */
	@Test
	public void postFeedbackTestFileIdIsMoreFive() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("content", "手机闪退手机闪退手机闪退手机闪退手机闪退");
		con.put("fileId", "10000159,10000160,10000161,10000158,10000157,10000156");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片ID超过5张" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("反馈图片最多上传五张");
	}
	/**
	 * 图片ID等于5张
	 */
	@Test
	public void postFeedbackTestFileIdIsFive() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("content", "手机闪退手机闪退手机闪退手机闪退手机闪退");
		con.put("fileId", "10000159,10000160,10000161,124,13343");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片ID等于5张" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("反馈成功");
	}
	/**
	 * 图片ID为6张其中1张为错误的
	 */
	@Test
	public void postFeedbackTestFileIdIsSixAndOneIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("content", "手机闪退手机闪退手机闪退手机闪退手机闪退");
		con.put("fileId", "10000159,10000160,10000161,asdasd,13343,13943");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片ID为6张其中1张为错误的" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 图片ID为5张其中一张为错误
	 */
	@Test
	public void postFeedbackTestFileIdIsFiveAndOneIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("content", "手机闪退手机闪退手机闪退手机闪退手机闪退");
		con.put("fileId", "10000159,10000160,10000161,asasas,13343");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片ID为5张其中一张为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 图片ID为1张
	 */
	@Test
	public void postFeedbackTestFileIdIsOne() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("content", "手机闪退手机闪退手机闪退手机闪退手机闪退");
		con.put("fileId", "1234");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片ID为1张" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("反馈成功");
	}
	/**
	 * 图片ID为0张
	 */
	@Test
	public void postFeedbackTestFileIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("content", "手机闪退手机闪退手机闪退手机闪退手机闪退");
		con.put("fileId", ",");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片ID为0张" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 图片Id之间的分隔符非法
	 */
	@Test
	public void postFeedbackTestFileIdSeparatorIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("content", "手机闪退手机闪退手机闪退手机闪退手机闪退");
		con.put("fileId", "1234￥132343%3434*124");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片Id之间的分隔符非法" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 图片ID存在小数
	 */
	@Test
	public void postFeedbackTestFileIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("content", "手机闪退手机闪退手机闪退手机闪退手机闪退");
		con.put("fileId", "12.34,13.2343,3.43");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片ID存在小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 图片ID存在负数
	 */
	@Test
	public void postFeedbackTestFileIdIsNegativeNumbe() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("content", "手机闪退手机闪退手机闪退手机闪退手机闪退");
		con.put("fileId", "-1234,-132343,343");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片ID存在负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 图片ID为空
	 */
	@Test
	public void postFeedbackTestFileIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("content", "手机闪退手机闪退手机闪退手机闪退手机闪退");
		con.put("fileId", "");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 图片ID为null
	 */
	@Test
	public void postFeedbackTestFileIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("content", "手机闪退手机闪退手机闪退手机闪退手机闪退");
		con.put("fileId", null);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("反馈成功");
	}
	/**
	 * 图片ID为空格
	 */
	@Test
	public void postFeedbackTestFileIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("content", "手机闪退手机闪退手机闪退手机闪退手机闪退");
		con.put("fileId", " ");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 图片ID不传该参数
	 */
	@Test
	public void postFeedbackTestFileIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("content", "手机闪退手机闪退手机闪退手机闪退手机闪退");
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "2.2.2");
		head.put("cmd", "4901");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		head.put("mos","iphone");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("图片ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("反馈成功");
	}
	
	@AfterMethod
	public void afterMethod(){
		
		
		MetaOper.delete(deleteSql, dataType);
		
	}
		
	
}