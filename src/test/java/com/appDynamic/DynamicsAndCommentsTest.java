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

public class DynamicsAndCommentsTest extends HttpUtil {
//动态和评论接口
	String url = "/UU/dynamic";
	String dataType = "perCenter81";
	String selectSql = "SELECT * FROM T_DYNAMIC WHERE DESCRIPTION = '自动化测试' AND USER_ID = 12495396";
	String selectSql1 = "SELECT * FROM T_COMMENTBACK WHERE CONTENT = '自动化评论'";
	String delDynamic = "DELETE FROM T_DYNAMIC WHERE DESCRIPTION = '自动化测试'";
	String delComment = "DELETE FROM T_COMMENTBACK WHERE CONTENT in ('自动化评论','<#$%^&**^%$#>','自动化评论回复')";
	List<Map<String,Object>> list ;
	List<Map<String,Object>> list1 ;
	List<Map<String,Object>> list2 ;
	List<Map<String,Object>> list3 ;
	String commentId;
	String targetId;
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
	}
	@AfterClass
	public void afterClass(){
		MetaOper.delete(delComment,dataType);
		MetaOper.delete(delDynamic,dataType);

	}
	/**
	 * 提交正确参数:点赞动态
	 */
	@Test
	public void postDynamicsAndCommentsTestCorrectParameterPraiseDynamic() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("operate", 0);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数:点赞动态" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		list2 =MetaOper.read(selectSql,dataType);
		assertThat(list2.get(0).get("PRAISE_COUNT").toString()).isEqualTo("1");
	}
	/**
	 * 提交正确参数:点赞评论
	 */
	@Test
	public void postDynamicsAndCommentsTestCorrectParameterPraiseComment() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("targetId", commentId);
		con.put("operate", 0);
		con.put("type", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数:点赞评论" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		list3 =MetaOper.read(selectSql1,dataType);
		assertThat(list3.get(0).get("PRAISE_NUM").toString()).isEqualTo("1");
	}
	/**
	 * 提交正确参数:取消点赞动态
	 */
	@Test
	public void postDynamicsAndCommentsTestCorrectParameterCancelPraiseDynamic() throws Exception {
		postDynamicsAndCommentsTestCorrectParameterPraiseDynamic();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("operate", 1);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数:取消点赞动态" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		list2 =MetaOper.read(selectSql,dataType);
		assertThat(list2.get(0).get("PRAISE_COUNT").toString()).isEqualTo("0");
	}
	/**
	 * 提交正确参数:取消点赞评论
	 */
	@Test
	public void postDynamicsAndCommentsTestCorrectParameterCancelPraiseComment() throws Exception {
		postDynamicsAndCommentsTestCorrectParameterPraiseComment();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("targetId", commentId);
		con.put("operate", 1);
		con.put("type", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数:取消点赞评论" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		list3 =MetaOper.read(selectSql1,dataType);
		assertThat(list3.get(0).get("PRAISE_NUM").toString()).isEqualTo("0");
	}
	/**
	 * 点赞动态之后再次点赞
	 */
	@Test
	public void postDynamicsAndCommentsTestCorrectParameterPraiseDynamicAgainPraise() throws Exception {
		postDynamicsAndCommentsTestCorrectParameterPraiseDynamic();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("operate", 0);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("点赞动态之后再次点赞" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("已经赞过！");
		list2 =MetaOper.read(selectSql,dataType);
		assertThat(list2.get(0).get("PRAISE_COUNT").toString()).isEqualTo("1");
	}
	/**
	 * 点赞评论之后再次点赞
	 */
	@Test
	public void postDynamicsAndCommentsTestCorrectParameterPraiseCommentAgainPraise() throws Exception {
		postDynamicsAndCommentsTestCorrectParameterPraiseComment();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("targetId", commentId);
		con.put("operate", 0);
		con.put("type", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("点赞评论之后再次点赞" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("已经赞过！");
		list3 =MetaOper.read(selectSql1,dataType);
		assertThat(list3.get(0).get("PRAISE_NUM").toString()).isEqualTo("1");
	}
	/**
	 * 取消点赞动态后再次取消点赞
	 */
	@Test
	public void postDynamicsAndCommentsTestCorrectParameterCancelPraiseDynamicAgainCancel() throws Exception {
		postDynamicsAndCommentsTestCorrectParameterCancelPraiseDynamic();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("operate", 1);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("取消点赞动态后再次取消点赞" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		list2 =MetaOper.read(selectSql,dataType);
		assertThat(list2.get(0).get("PRAISE_COUNT").toString()).isEqualTo("-1");
	}
	/**
	 * 取消点赞动态后再点赞
	 */
	@Test
	public void postDynamicsAndCommentsTestCorrectParameterCancelPraiseDynamicAgainPraise() throws Exception {
		postDynamicsAndCommentsTestCorrectParameterCancelPraiseDynamic();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("operate", 0);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("取消点赞动态后再点赞" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		list2 =MetaOper.read(selectSql,dataType);
		assertThat(list2.get(0).get("PRAISE_COUNT").toString()).isEqualTo("1");
	}
	/**
	 * 用户id传负数
	 */
	@Test
	public void postDynamicsAndCommentsTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", -12495396);
		con.put("targetId", targetId);
		con.put("operate", 0);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 用户id传小数
	 */
	@Test
	public void postDynamicsAndCommentsTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", 1249.5396);
		con.put("targetId", targetId);
		con.put("operate", 0);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id传小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 用户id传最大值
	 */
	@Test
	public void postDynamicsAndCommentsTestUserIdIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", 999999999);
		con.put("targetId", targetId);
		con.put("operate", 0);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id传最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 用户id为未登录用户
	 */
	@Test
	public void postDynamicsAndCommentsTestUserIdIsNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", 12495397);
		con.put("targetId", targetId);
		con.put("operate", 0);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为未登录用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 用户id为错误用户
	 */
	@Test
	public void postDynamicsAndCommentsTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", 124953968);
		con.put("targetId", targetId);
		con.put("operate", 0);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为错误用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 用户id为空
	 */
	@Test
	public void postDynamicsAndCommentsTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", "");
		con.put("targetId", targetId);
		con.put("operate", 0);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 用户id为空格
	 */
	@Test
	public void postDynamicsAndCommentsTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", " ");
		con.put("targetId", targetId);
		con.put("operate", 0);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 用户id为null
	 */
	@Test
	public void postDynamicsAndCommentsTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", null);
		con.put("targetId", targetId);
		con.put("operate", 0);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 用户id不传参数
	 */
	@Test
	public void postDynamicsAndCommentsTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("targetId", targetId);
		con.put("operate", 0);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id不传参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 用户id为0
	 */
	@Test
	public void postDynamicsAndCommentsTestUserIdIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", 0);
		con.put("targetId", targetId);
		con.put("operate", 0);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 目标Id传负数
	 */
	@Test
	public void postDynamicsAndCommentsTestTargetIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", -123456);
		con.put("operate", 0);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("目标Id传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("没有此动态！");
	}
	/**
	 * 目标Id传小数
	 */
	@Test
	public void postDynamicsAndCommentsTestTargetIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 12.491621);
		con.put("operate", 0);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("目标Id传小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("没有此动态！");
	}
	/**
	 * 目标Id传0
	 */
	@Test
	public void postDynamicsAndCommentsTestTargetIdIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 0);
		con.put("operate", 0);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("目标Id传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("没有此动态！");
	}
	/**
	 * 目标Id传空
	 */
	@Test
	public void postDynamicsAndCommentsTestTargetIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", "");
		con.put("operate", 0);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("目标Id传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("没有此动态！");
	}
	/**
	 * 目标Id传空格
	 */
	@Test
	public void postDynamicsAndCommentsTestTargetIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", " ");
		con.put("operate", 0);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("目标Id传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 目标Id传null
	 */
	@Test
	public void postDynamicsAndCommentsTestTargetIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", null);
		con.put("operate", 0);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("目标Id传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 目标Id传String
	 */
	@Test
	public void postDynamicsAndCommentsTestTargetIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", "dfsdffsf");
		con.put("operate", 0);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("目标Id传String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 目标Id传最大值
	 */
	@Test
	public void postDynamicsAndCommentsTestTargetIdIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", 999999999999999999L);
		con.put("operate", 0);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("目标Id传最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("没有此动态！");
	}
	/**
	 * 目标Id不传
	 */
	@Test
	public void postDynamicsAndCommentsTestTargetIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("operate", 0);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("目标Id不传" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 操作传负数
	 */
	@Test
	public void postDynamicsAndCommentsTestOperateIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("operate", -1);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("赞操作错误！");
	}
	/**
	 * 操作传小数
	 */
	@Test
	public void postDynamicsAndCommentsTestOperateIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("operate", 2.3);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作传小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("赞操作错误！");
	}
	/**
	 * 操作传空格
	 */
	@Test
	public void postDynamicsAndCommentsTestOperateIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("operate", " ");
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 操作传null
	 */
	@Test
	public void postDynamicsAndCommentsTestOperateIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("operate", null);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 操作传String
	 */
	@Test
	public void postDynamicsAndCommentsTestOperateIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("operate", "GFGDFG");
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作传String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 操作不传
	 */
	@Test
	public void postDynamicsAndCommentsTestOperateNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作不传" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 操作传错误
	 */
	@Test
	public void postDynamicsAndCommentsTestOperateIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("operate", 22);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作传错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("赞操作错误！");
	}
	/**
	 * 类型type传负数
	 */
	@Test
	public void postDynamicsAndCommentsTestTypeIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("operate", 0);
		con.put("type", -2);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作先传1再传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("没有此动态评论");
	}
	/**
	 * 类型type传小数
	 */
	@Test
	public void postDynamicsAndCommentsTestTypeIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("operate", 0);
		con.put("type", 2.3);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型type传小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 类型type传空
	 */
	@Test
	public void postDynamicsAndCommentsTestTypeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("operate", 0);
		con.put("type", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型type传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 类型type传空格
	 */
	@Test
	public void postDynamicsAndCommentsTestTypeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("operate", 0);
		con.put("type", " ");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型type传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 类型type传null
	 */
	@Test
	public void postDynamicsAndCommentsTestTypeIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("operate", 0);
		con.put("type", null);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型type传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 类型type传String
	 */
	@Test
	public void postDynamicsAndCommentsTestTypeIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("operate", 0);
		con.put("type", "dfdf");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型type传String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 类型type不传
	 */
	@Test
	public void postDynamicsAndCommentsTestTypeNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("operate", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型type不传" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 类型type传错误
	 */
	@Test
	public void postDynamicsAndCommentsTestTypeIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("targetId", targetId);
		con.put("operate", 0);
		con.put("type", 20000000);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型type传错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("没有此动态评论");
	}


}