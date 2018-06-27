package com.appDynamic;

import com.example.HttpUtil;
import com.example.LoginTest;
import com.example.MetaOper;
import org.json.JSONObject;
import org.testng.annotations.*;

import java.rmi.MarshalException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class DeleteCommentTest extends HttpUtil {
//删除评论
	String url = "/UU/comment";

	JSONObject body;
	String uuid;
	String chcode;
	Map<String, Object> head = new HashMap<String, Object>();
	String selectSql = "SELECT * FROM T_COMMENTBACK WHERE CONTENT = '自动化评论'";
	String dataType = "perCenter81";
	String delDynamic = "DELETE FROM T_DYNAMIC WHERE DESCRIPTION = '自动化测试'";
	String delComment = "DELETE FROM T_COMMENTBACK WHERE CONTENT in ('自动化评论','<#$%^&**^%$#>','自动化评论回复')";
	List<Map<String,Object>> list ;
	String commentId;
	String dynamicId;
	@BeforeClass
	public void  beforeClass() throws Exception {
//		new PublishDynamicsTest().postPublishDynamicsTestCorrectParameter();
//		new DynamicCommentTest().postDynamicCommentTestCorrectParameter();
//		list = MetaOper.read(selectSql,dataType);
//		commentId = list.get(0).get("COMMENT_ID").toString();
//		dynamicId = list.get(0).get("ORIGIN_ID").toString();
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
		head.put("ver", "1.2.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", chcode);
		head.put("cmd", 4002);
	}
	@BeforeMethod
	public void  beforeMethod() throws Exception {
		new PublishDynamicsTest().postPublishDynamicsTestCorrectParameter();
		new DynamicCommentTest().postDynamicCommentTestCorrectParameter();
		list = MetaOper.read(selectSql, dataType);
		commentId = list.get(0).get("COMMENT_ID").toString();
		dynamicId = list.get(0).get("ORIGIN_ID").toString();
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
	 * 提交正确参数
	 */
	@Test
	public void postDeleteCommentTestCorrectParameter() throws Exception {


		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", dynamicId);
		con.put("userId", uuid);
		con.put("commentId", commentId);

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
	 * 动态ID错误
	 */
	@Test
	public void postDeleteCommentTestDynamicIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", 0000001);
		con.put("userId", uuid);
		con.put("commentId", commentId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态ID负数
	 */
	@Test
	public void postDeleteCommentTestDynamicIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", -1);
		con.put("userId", uuid);
		con.put("commentId", commentId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("动态id错误");
	}
	/**
	 * 动态ID小数
	 */
	@Test
	public void postDeleteCommentTestDynamicIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", 9.9);
		con.put("userId", uuid);
		con.put("commentId", commentId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("动态id错误");
	}
	/**
	 * 动态ID为0
	 */
	@Test
	public void postDeleteCommentTestDynamicIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", 0);
		con.put("userId", uuid);
		con.put("commentId", commentId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 动态ID为字符串
	 */
	@Test
	public void postDeleteCommentTestDynamicIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", "dynamicId");
		con.put("userId", uuid);
		con.put("commentId", commentId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为字符串" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("动态id错误");
	}
	/**
	 * 动态ID为空
	 */
	@Test
	public void postDeleteCommentTestDynamicIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", "");
		con.put("userId", uuid);
		con.put("commentId", commentId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("动态id错误");
	}
	/**
	 * 动态ID为null
	 */
	@Test
	public void postDeleteCommentTestDynamicIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", null);
		con.put("userId", uuid);
		con.put("commentId", commentId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 动态ID空格
	 */
	@Test
	public void postDeleteCommentTestDynamicIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", " ");
		con.put("userId", uuid);
		con.put("commentId", commentId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("动态id错误");
	}
	/**
	 * 动态ID为超长
	 */
	@Test
	public void postDeleteCommentTestDynamicIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", 123123123123123123L);
		con.put("userId", uuid);
		con.put("commentId", commentId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("非法数据");
	}
	/**
	 * 动态ID不传该参数
	 */
	@Test
	public void postDeleteCommentTestDynamicIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("commentId", commentId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 评论人ID为未登录
	 */
	@Test
	public void postDeleteCommentTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", dynamicId);
		con.put("userId", 12495079);
		con.put("commentId", commentId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论人ID为未登录" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("shibai");
	}
	/**
	 * 评论人ID为空
	 */
	@Test
	public void postDeleteCommentTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", dynamicId);
		con.put("userId", "");
		con.put("commentId", commentId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论人ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 评论人ID为null
	 */
	@Test
	public void postDeleteCommentTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", dynamicId);
		con.put("userId", null);
		con.put("commentId", commentId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论人ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 评论人ID为超长
	 */
	@Test
	public void postDeleteCommentTestUserIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", dynamicId);
		con.put("userId", 1234561234512345L);
		con.put("commentId", commentId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论人ID为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("shibai");
	}
	/**
	 * 评论人ID不传该参数
	 */
	@Test
	public void postDeleteCommentTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", dynamicId);
		con.put("commentId", commentId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论人ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 评论人ID为0
	 */
	@Test
	public void postDeleteCommentTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", dynamicId);
		con.put("userId", 0);
		con.put("commentId", commentId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论人ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("shibai");
	}
	/**
	 * 评论人ID为负数
	 */
	@Test
	public void postDeleteCommentTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", dynamicId);
		con.put("userId", -9);
		con.put("commentId", commentId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论人ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 评论人ID为小数
	 */
	@Test
	public void postDeleteCommentTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", dynamicId);
		con.put("userId", 1.1);
		con.put("commentId", commentId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论人ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 评论人ID为字符串
	 */
	@Test
	public void postDeleteCommentTestUserIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", dynamicId);
		con.put("userId", "uuid");
		con.put("commentId", commentId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论人ID为字符串" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 评论人ID为错误
	 */
	@Test
	public void postDeleteCommentTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", dynamicId);
		con.put("userId", 121);
		con.put("commentId", commentId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论人ID为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("shibai");
	}
	/**
	 * 评论人ID为空格
	 */
	@Test
	public void postDeleteCommentTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", dynamicId);
		con.put("userId", " ");
		con.put("commentId", commentId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论人ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 评论ID为负数
	 */
	@Test
	public void postDeleteCommentTestCommentIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", dynamicId);
		con.put("userId", uuid);
		con.put("commentId", -2);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("没有数据");
	}

	/**
	 * 评论ID为0
	 */
	@Test
	public void postDeleteCommentTestCommentIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", dynamicId);
		con.put("userId", uuid);
		con.put("commentId", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("没有数据");
	}
	/**
	 * 评论ID为超长
	 */
	@Test
	public void postDeleteCommentTestCommentIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", dynamicId);
		con.put("userId", uuid);
		con.put("commentId", "9999999999999999999999");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 评论ID为小数
	 */
	@Test
	public void postDeleteCommentTestCommentIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", dynamicId);
		con.put("userId", uuid);
		con.put("commentId", 9.9);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 评论ID为最大值
	 */
	@Test
	public void postDeleteCommentTestCommentIdIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", dynamicId);
		con.put("userId", uuid);
		con.put("commentId", 999999999999999999L);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID为最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("没有数据");
	}
	/**
	 * 评论ID为空
	 */
	@Test
	public void postDeleteCommentTestCommentIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", dynamicId);
		con.put("userId", uuid);
		con.put("commentId", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 评论ID为空格
	 */
	@Test
	public void postDeleteCommentTestCommentIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", dynamicId);
		con.put("userId", uuid);
		con.put("commentId", " ");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 评论ID为null
	 */
	@Test
	public void postDeleteCommentTestCommentIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", dynamicId);
		con.put("userId", uuid);
		con.put("commentId", null);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 评论ID不传该参数
	 */
	@Test
	public void postDeleteCommentTestCommentIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", dynamicId);
		con.put("userId", uuid);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}

	


}