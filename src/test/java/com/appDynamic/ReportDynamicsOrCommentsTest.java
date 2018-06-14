package com.appDynamic;

import com.example.HttpUtil;
import com.example.LoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class ReportDynamicsOrCommentsTest extends HttpUtil {
//举报动态/评论接口
	String url = "/UU/dynamic";

	JSONObject body;
	String uuid;
	String chcode;
	Map<String, Object> head = new HashMap<String, Object>();
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
		head.put("aid", "lan6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", chcode);
		head.put("cmd", 506);
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postReportDynamicsOrCommentsTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
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
	 * 用户id为未登录用户
	 */
	@Test
	public void postReportDynamicsOrCommentsTestUserIdIsNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", 12495666);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为未登录用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为错误用户
	 */
	@Test
	public void postReportDynamicsOrCommentsTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", 1249);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为错误用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为负数
	 */
	@Test
	public void postReportDynamicsOrCommentsTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", -12495396);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为小数
	 */
	@Test
	public void postReportDynamicsOrCommentsTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", 124.95396);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为0
	 */
	@Test
	public void postReportDynamicsOrCommentsTestUserIdIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", 0);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为空
	 */
	@Test
	public void postReportDynamicsOrCommentsTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", "");
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为空格
	 */
	@Test
	public void postReportDynamicsOrCommentsTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", " ");
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为null
	 */
	@Test
	public void postReportDynamicsOrCommentsTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", null);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id不传参数
	 */
	@Test
	public void postReportDynamicsOrCommentsTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id不传参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为String
	 */
	@Test
	public void postReportDynamicsOrCommentsTestUserIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", "fgfggffg");
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态id传负数
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTargetIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", -12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态id传小数
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTargetIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 1249.1621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id传小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态id传0
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTargetIdIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 0);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态id传String
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTargetIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", "dvfdfds");
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id传String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态id传空
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTargetIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", "");
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态id传空格
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTargetIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", " ");
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态id传null
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTargetIdIsnull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", null);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态id不传
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTargetIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id不传" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 举报原因id传负数
	 */
	@Test
	public void postReportDynamicsOrCommentsTestReasonIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", -1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报原因id传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 举报原因id传小数
	 */
	@Test
	public void postReportDynamicsOrCommentsTestReasonIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", 1.23);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报原因id传小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 举报原因id传0
	 */
	@Test
	public void postReportDynamicsOrCommentsTestReasonIdIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", 0);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报原因id传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 举报原因id传空
	 */
	@Test
	public void postReportDynamicsOrCommentsTestReasonIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", "");
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报原因id传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 举报原因id传空格
	 */
	@Test
	public void postReportDynamicsOrCommentsTestReasonIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", " ");
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报原因id传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 举报原因id传null
	 */
	@Test
	public void postReportDynamicsOrCommentsTestReasonIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", null);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报原因id传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 举报原因id传错误的
	 */
	@Test
	public void postReportDynamicsOrCommentsTestReasonIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", 888);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报原因id传错误的" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 举报原因id不传
	 */
	@Test
	public void postReportDynamicsOrCommentsTestReasonIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报原因id不传" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 举报内容传超长
	 */
	@Test
	public void postReportDynamicsOrCommentsTestContentIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试d发顺丰的风格统一特，个人退热贴，天太热太热，而台湾太热太热太热特");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报内容传超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 举报内容传空格
	 */
	@Test
	public void postReportDynamicsOrCommentsTestContentIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", " ");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报内容传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 举报内容传空
	 */
	@Test
	public void postReportDynamicsOrCommentsTestContentIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报内容传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 举报内容传null
	 */
	@Test
	public void postReportDynamicsOrCommentsTestContentIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", null);
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报内容传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 举报内容传非法字符
	 */
	@Test
	public void postReportDynamicsOrCommentsTestContentIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "<#$$^#$^*&^*^>");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报内容传非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 举报内容不传
	 */
	@Test
	public void postReportDynamicsOrCommentsTestContentNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报内容不传" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 举报类型传负数
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTypeIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", -1);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报类型传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 举报类型传小数
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTypeIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 2.3);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报类型传小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 举报类型传空
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTypeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", "");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报类型传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 举报类型传空格
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTypeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", " ");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报类型传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 举报类型传null
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTypeIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", null);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报类型传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 举报类型传String
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTypeIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", "FSGDGDFG");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报类型传String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 举报类型传最大值
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTypeIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 999999999);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报类型传最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 举报类型不传
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTypeIsNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报类型不传" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 举报类型传错误
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTypeIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 6666);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报类型传错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 举报类型传0
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTypeIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报类型传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 举报类型传1
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTypeIs1() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 1);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报类型传1" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 举报类型传0targetId传评论id
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTypeIs0targetIdIsCommentId() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报类型传0targetId传评论id" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 举报类型传1targetId传动态id
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTypeIs1targetIdIsDynamicId() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12491621);
		con.put("reasonId", 1);
		con.put("reason", "举报");
		con.put("content", "自动化测试");
		con.put("type", 1);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报类型传1targetId传动态id" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	

}