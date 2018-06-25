package com.appDynamic;

import com.example.HttpUtil;
import com.example.LoginTest;
import com.example.MetaOper;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class ReportDynamicsOrCommentsTest extends HttpUtil {
//举报动态/评论接口
	String url = "/UU/dynamic";
	String dataType = "perCenter81";
	String selectSql = "SELECT * FROM T_DYNAMIC WHERE DESCRIPTION = '自动化测试' AND USER_ID = 12495396";
	String selectSql1 = "SELECT * FROM T_COMMENTBACK WHERE CONTENT = '自动化评论'";
	String selectSql2 = "SELECT * FROM T_USER_COMPLAINT WHERE DESCRIBES = '自动化测试' OR USER_ID = 12495396";
	String delDynamic = "DELETE FROM T_DYNAMIC WHERE DESCRIPTION = '自动化测试'";
	String delComment = "DELETE FROM T_COMMENTBACK WHERE CONTENT in ('自动化评论','<#$%^&**^%$#>','自动化评论回复')";
	String delComplaint = "DELETE FROM T_USER_COMPLAINT WHERE DESCRIBES = '自动化测试'";
	List<Map<String,Object>> list ;
	List<Map<String,Object>> list1 ;
	List<Map<String,Object>> list2 ;
	String targetId;
	String commentId;
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
		head.put("cmd", 518);
	}
	@BeforeMethod
	public void  beforeMethod() throws Exception {
		new PublishDynamicsTest().postPublishDynamicsTestCorrectParameter();
		new DynamicCommentTest().postDynamicCommentTestCorrectParameter();
		list = MetaOper.read(selectSql, dataType);
		list1 = MetaOper.read(selectSql1, dataType);
		commentId = list1.get(0).get("COMMENT_ID").toString();
		targetId = list.get(0).get("DYNAMIC_ID").toString();
	}
	@AfterMethod
	public void afterMethod(){
		MetaOper.delete(delComment,dataType);
		MetaOper.delete(delDynamic,dataType);
		MetaOper.delete(delComplaint,dataType);
	}
	@AfterClass
	public void afterClass(){
		MetaOper.delete(delComment,dataType);
		MetaOper.delete(delDynamic,dataType);
		MetaOper.delete(delComplaint,dataType);

	}
	/**
	 * 提交正确参数：投诉动态
	 */
	@Test
	public void postReportDynamicsOrCommentsTestCorrectParameterReportDynamic() throws Exception {
		LoginTest login = new LoginTest();
		body = login.getLoginTestChcodeBy177();
		uuid= (body.get("userId")).toString();
		chcode= (body.get("checkCode")).toString();		
		head.put("aid", "lan6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", chcode);
		head.put("cmd", 518);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("reasonId", 2);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：投诉动态" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		list2 =MetaOper.read(selectSql2,dataType);
		assertThat(list2.get(0).get("TYPE").toString()).isEqualTo("9");
		assertThat(list2.get(0).get("REASON_TYPE").toString()).isEqualTo("2");
		assertThat(list2.get(0).get("REASON").toString()).isEqualTo("自动化测试举报");
		assertThat(list2.get(0).get("DESCRIBES").toString()).isEqualTo("自动化测试");
	}
	/**
	 * 提交正确参数：投诉评论
	 */
	@Test
	public void postReportDynamicsOrCommentsTestCorrectParameterReportComment() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", commentId);
		con.put("reasonId", 2);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 1);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：投诉评论" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		list2 =MetaOper.read(selectSql2,dataType);
		assertThat(list2.get(0).get("TYPE").toString()).isEqualTo("10");
		assertThat(list2.get(0).get("REASON_TYPE").toString()).isEqualTo("2");
		assertThat(list2.get(0).get("REASON").toString()).isEqualTo("自动化测试举报");
		assertThat(list2.get(0).get("DESCRIBES").toString()).isEqualTo("自动化测试");
	}
	/**
	 * 用户id为未登录用户
	 */
	@Test
	public void postReportDynamicsOrCommentsTestUserIdIsNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", 12495079);
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为未登录用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为错误用户
	 */
	@Test
	public void postReportDynamicsOrCommentsTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", 1249);
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为错误用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("用户不存在");
	}
	/**
	 * 用户id为负数
	 */
	@Test
	public void postReportDynamicsOrCommentsTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", -12495396);
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数非法!");
	}
	/**
	 * 用户id为小数
	 */
	@Test
	public void postReportDynamicsOrCommentsTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", 124.95396);
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数非法!");
	}
	/**
	 * 用户id为0
	 */
	@Test
	public void postReportDynamicsOrCommentsTestUserIdIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", 0);
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("用户不存在");
	}
	/**
	 * 用户id为空
	 */
	@Test
	public void postReportDynamicsOrCommentsTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", "");
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数非法!");
	}
	/**
	 * 用户id为空格
	 */
	@Test
	public void postReportDynamicsOrCommentsTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", " ");
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数非法!");
	}
	/**
	 * 用户id为null
	 */
	@Test
	public void postReportDynamicsOrCommentsTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", null);
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不能为空!");
	}
	/**
	 * 用户id不传参数
	 */
	@Test
	public void postReportDynamicsOrCommentsTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id不传参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不能为空!");
	}
	/**
	 * 用户id为String
	 */
	@Test
	public void postReportDynamicsOrCommentsTestUserIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", "fgfggffg");
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数非法!");
	}
	/**
	 * 动态id传负数
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTargetIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", -123);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数非法!");
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
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id传小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数非法!");
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
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态id传错误
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTargetIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 11111111);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id传错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
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
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id传String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数非法!");
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
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数非法!");
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
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数非法!");
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
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不能为空!");
	}
	/**
	 * 动态id不传
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTargetIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id不传" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不能为空!");
	}
	/**
	 * 举报原因id传负数
	 */
	@Test
	public void postReportDynamicsOrCommentsTestReasonIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("reasonId", -1);
		con.put("reason", "自动化测试举报");
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
		list2 =MetaOper.read(selectSql2,dataType);
		assertThat(list2.get(0).get("REASON_TYPE").toString()).isEqualTo("-1");
	}
	/**
	 * 举报原因id传小数
	 */
	@Test
	public void postReportDynamicsOrCommentsTestReasonIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("reasonId", 1.23);
		con.put("reason", "自动化测试举报");
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
		list2 =MetaOper.read(selectSql2,dataType);
		assertThat(list2.get(0).get("REASON_TYPE").toString()).isEqualTo("1");

	}
	/**
	 * 举报原因id传0
	 */
	@Test
	public void postReportDynamicsOrCommentsTestReasonIdIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("reasonId", 0);
		con.put("reason", "自动化测试举报");
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
		list2 =MetaOper.read(selectSql2,dataType);
		assertThat(list2.get(0).get("REASON_TYPE").toString()).isEqualTo("0");
	}
	/**
	 * 举报原因id传空
	 */
	@Test
	public void postReportDynamicsOrCommentsTestReasonIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("reasonId", "");
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报原因id传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数非法!");
		}
	
	/**
	 * 举报原因id传空格
	 */
	@Test
	public void postReportDynamicsOrCommentsTestReasonIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("reasonId", " ");
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报原因id传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 举报原因id传null
	 */
	@Test
	public void postReportDynamicsOrCommentsTestReasonIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("reasonId", null);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报原因id传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不能为空!");
	}
	
	/**
	 * 举报原因id不传
	 */
	@Test
	public void postReportDynamicsOrCommentsTestReasonIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报原因id不传" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不能为空!");
	}
	
	/**
	 * 举报内容传超长
	 */
	@Test
	public void postReportDynamicsOrCommentsTestContentIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试d发顺丰的风格统一特，个人退热贴，天太热太热，而台湾太热太热太热特.自动化测试d发顺丰的风格统一特，个人退热贴，天太热太热，而台湾太热太热太热特。自动化测试d发顺丰的风格统一特，个人退热贴，天太热太热，而台湾太热太热太热特。自动化测试d发顺丰的风格统一特，个人退热贴，天太热太热，而台湾太热太热太热特。自动化测试d发顺丰的风格统一特，个人退热贴，天太热太热，而台湾太热太热太热特。自动化测试d发顺丰的风格统一特，个人退热贴，天太热太热，而台湾太热太热太热特");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报内容传超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("输入内容最多为50个字");
	}
	/**
	 * 举报内容传空格
	 */
	@Test
	public void postReportDynamicsOrCommentsTestContentIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", " ");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报内容传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("输入内容最少为5个字");
		//list2 =MetaOper.read(selectSql2,dataType);
		//assertThat(list2.get(0).get("DESCRIBES").toString()).isEqualTo(" ");
	}
	/**
	 * 举报内容传空
	 */
	@Test
	public void postReportDynamicsOrCommentsTestContentIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
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
		list2 =MetaOper.read(selectSql2,dataType);
		assertThat(list2.get(0).get("DESCRIBES")).isEqualTo(null);
	}
	/**
	 * 举报内容传null
	 */
	@Test
	public void postReportDynamicsOrCommentsTestContentIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
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
		list2 =MetaOper.read(selectSql2,dataType);
		assertThat(list2.get(0).get("DESCRIBES")).isEqualTo(null);
	}
	/**
	 * 举报内容传非法字符
	 */
	@Test
	public void postReportDynamicsOrCommentsTestContentIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
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
		list2 =MetaOper.read(selectSql2,dataType);
		assertThat(list2.get(0).get("DESCRIBES").toString()).isEqualTo("<#$$^#$^*&^*^>");
	}
	/**
	 * 举报内容不传
	 */
	@Test
	public void postReportDynamicsOrCommentsTestContentNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报内容不传" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		list2 =MetaOper.read(selectSql2,dataType);
		assertThat(list2.get(0).get("DESCRIBES")).isEqualTo(null);
	}
	/**
	 * 举报类型传负数
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTypeIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", -1);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报类型传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数非法!");
	}
	/**
	 * 举报类型传小数
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTypeIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 2.3);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报类型传小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数非法!");
	}
	/**
	 * 举报类型传空
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTypeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", "");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报类型传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数非法!");
	}
	/**
	 * 举报类型传空格
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTypeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", " ");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报类型传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数非法!");
	}
	/**
	 * 举报类型传null
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTypeIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", null);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报类型传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不能为空!");
	}
	/**
	 * 举报类型传String
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTypeIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", "FSGDGDFG");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报类型传String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数非法!");
	}
	/**
	 * 举报类型传最大值
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTypeIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 999999999);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报类型传最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("type非法");
	}
	/**
	 * 举报类型不传
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTypeIsNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报类型不传" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不能为空!");
	}
	/**
	 * 举报类型传错误
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTypeIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 6);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报类型传错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("type非法");
	}
	/**
	 * 举报类型传0targetId传评论id
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTypeIs0targetIdIsCommentId() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", commentId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报类型传0targetId传评论id" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("动态不存在");
	}
	/**
	 * 举报类型传1targetId传动态id
	 */
	@Test
	public void postReportDynamicsOrCommentsTestTypeIs1targetIdIsDynamicId() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("reasonId", 1);
		con.put("reason", "自动化测试举报");
		con.put("content", "自动化测试");
		con.put("type", 1);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("举报类型传1targetId传动态id" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("评论不存在");
	}
	

}