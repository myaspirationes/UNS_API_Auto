package com.appDynamic;

import com.example.HttpUtil;
import com.example.LoginTest;
import com.example.MetaOper;
import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class DynamicCommentTest extends HttpUtil {
//评论接口
	String url = "/UU/dynamicRemark";

	JSONObject body;
	String uuid;
	String chcode;
	Map<String, Object> head = new HashMap<String, Object>();
	String seleceSql = "SELECT * FROM T_DYNAMIC WHERE DESCRIPTION = '自动化测试'";
	String delDynamic = "DELETE FROM T_DYNAMIC WHERE DESCRIPTION = '自动化测试'";
	String delComment = "DELETE FROM T_COMMENTBACK WHERE CONTENT in ('自动化评论','<#$%^&**^%$#>')";
	String dataType = "perCenter81";
	String dynamicId;
	List<Map<String,Object>> list ;
	@BeforeClass
	public void  beforeClass() throws Exception {
		new PublishDynamicsTest().postPublishDynamicsTestCorrectParameter();
		LoginTest login = new LoginTest();
		try {
			body = login.getLoginTestChcodeBy177();
			uuid= (body.get("userId")).toString();
			chcode= (body.get("checkCode")).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list = MetaOper.read(seleceSql,dataType);
		dynamicId = list.get(0).get("DYNAMIC_ID").toString();
		head.put("aid", "lan6uu");
		head.put("ver", "1.2.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", chcode);
		head.put("cmd", 1701);
	}
	@AfterClass
	public void afterClass(){
		MetaOper.delete(delDynamic,dataType);
		MetaOper.delete(delComment,dataType);

	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postDynamicCommentTestCorrectParameter() throws Exception {
		LoginTest login = new LoginTest();
		list = MetaOper.read(seleceSql,dataType);
		dynamicId = list.get(0).get("DYNAMIC_ID").toString();
		body = login.getLoginTestChcodeBy177();
		uuid= (body.get("userId")).toString();
		chcode= (body.get("checkCode")).toString();
		head.put("aid", "lan6uu");
		head.put("ver", "1.2.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", chcode);
		head.put("cmd", 1701);
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", dynamicId);
		con.put("remarkUser", uuid);
		con.put("content", "自动化评论");
		

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论提交正确参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态ID为错误
	 */
	@Test
	public void postDynamicCommentTestDynamicIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", 100);
		con.put("remarkUser", uuid);
		con.put("content", "自动化评论");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("没有此动态！");
	}

	/**
	 * 动态ID为负数
	 */
	@Test
	public void postDynamicCommentTestDynamicIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", -1319);
		con.put("remarkUser", uuid);
		con.put("content", "自动化评论");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("dynamicId不是数字类型");
	}

	/**
	 * 动态ID为小数
	 */
	@Test
	public void postDynamicCommentTestDynamicIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", 13.19);
		con.put("remarkUser", uuid);
		con.put("content", "自动化评论");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("dynamicId不是数字类型");
	}

	/**
	 * 动态ID为0
	 */
	@Test
	public void postDynamicCommentTestDynamicIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", 0);
		con.put("remarkUser", uuid);
		con.put("content", "自动化评论");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("没有此动态！");
	}

	/**
	 * 动态ID为字符串
	 */
	@Test
	public void postDynamicCommentTestDynamicIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", "dynamicId");
		con.put("remarkUser", uuid);
		con.put("content", "自动化评论");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("dynamicId不是数字类型");
	}

	/**
	 * 动态ID为空
	 */
	@Test
	public void postDynamicCommentTestDynamicIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", "");
		con.put("remarkUser", uuid);
		con.put("content", "自动化评论");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("dynamicId不是数字类型");
	}

	/**
	 * 动态ID为null
	 */
	@Test
	public void postDynamicCommentTestDynamicIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", null);
		con.put("remarkUser", uuid);
		con.put("content", "自动化评论");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("dynamicId不是数字类型");
	}

	/**
	 * 动态ID为空格
	 */
	@Test
	public void postDynamicCommentTestDynamicIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", " ");
		con.put("remarkUser", uuid);
		con.put("content", "自动化评论");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("dynamicId不是数字类型");
	}

	/**
	 * 动态ID为超长
	 */
	@Test
	public void postDynamicCommentTestDynamicIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", 1319131913191319L);
		con.put("remarkUser", uuid);
		con.put("content", "自动化评论");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("没有此动态！");
	}
	/**
	 * 动态ID不传该参数
	 */
	@Test
	public void postDynamicCommentTestDynamicIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("remarkUser", uuid);
		con.put("content", "自动化评论");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("dynamicId不是数字类型");
	}
	/**
	 * 评论人的ID为错误
	 */
	@Test
	public void postDynamicCommentTestremarkUserIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", dynamicId);
		con.put("remarkUser", 1212);
		con.put("content", "自动化评论");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论人的ID为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("未知错误");
	}
	/**
	 * 评论人的ID为字符串
	 */
	@Test
	public void postDynamicCommentTestremarkUserIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", dynamicId);
		con.put("remarkUser", "uuid");
		con.put("content", "自动化评论");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论人的ID为字符串" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("remarkUser不是数字类型");
	}
	/**
	 * 评论人的ID为小数
	 */
	@Test
	public void postDynamicCommentTestremarkUserIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", dynamicId);
		con.put("remarkUser", 13.19);
		con.put("content", "自动化评论");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论人的ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("remarkUser不是数字类型");
	}
	/**
	 * 评论人的ID为负数
	 */
	@Test
	public void postDynamicCommentTestremarkUserIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", dynamicId);
		con.put("remarkUser", -1);
		con.put("content", "自动化评论");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论人的ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("remarkUser不是数字类型");
	}
	/**
	 * 评论人的ID为0
	 */
	@Test
	public void postDynamicCommentTestremarkUserIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", dynamicId);
		con.put("remarkUser", 0);
		con.put("content", "自动化评论");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论人的ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("未知错误");
	}
	/**
	 * 评论人的ID为空格
	 */
	@Test
	public void postDynamicCommentTestremarkUserIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", dynamicId);
		con.put("remarkUser", " ");
		con.put("content", "自动化评论");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论人的ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("remarkUser不是数字类型");
	}
	/**
	 * 评论人的ID为空
	 */
	@Test
	public void postDynamicCommentTestremarkUserIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", dynamicId);
		con.put("remarkUser", "");
		con.put("content", "自动化评论");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论人的ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("remarkUser不是数字类型");
	}
	/**
	 * 评论人的ID为null
	 */
	@Test
	public void postDynamicCommentTestremarkUserIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", dynamicId);
		con.put("remarkUser", null);
		con.put("content", "自动化评论");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论人的ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("remarkUser不是数字类型");
	}
	/**
	 * 评论人的ID不传该参数
	 */
	@Test
	public void postDynamicCommentTestremarkUserNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", dynamicId);
		con.put("content", "自动化评论");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论人的ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("remarkUser不是数字类型");
	}
	/**
	 * 评论人的ID超长
	 */
	@Test
	public void postDynamicCommentTestremarkUserIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", dynamicId);
		con.put("remarkUser", 123123123123123L);
		con.put("content", "自动化评论");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论人的ID超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 评论人的ID未登录
	 */
	@Test
	public void postDynamicCommentTestremarkUserNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", dynamicId);
		con.put("remarkUser", 12495097);
		con.put("content", "自动化评论");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论人的ID未登录" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("shibai");
	}

	/**
	 * 评论内容为非法字符
	 */
	@Test
	public void postDynamicCommentTestContent() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", dynamicId);
		con.put("remarkUser", uuid);
		con.put("content", "<#$%^&**^%$#>");


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
	 * 评论内容为超长
	 */
	@Test
	public void postDynamicCommentTestContentIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", dynamicId);
		con.put("remarkUser", uuid);
		con.put("content", "自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论自动化评论");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 评论内容为空
	 */
	@Test
	public void postDynamicCommentTestContentIsEmpty() throws Exception {//需求是不可以发布的评论的
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", dynamicId);
		con.put("remarkUser", uuid);
		con.put("content", "");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论内容为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("评论内容不能为空");
	}
	/**
	 * 评论内容为空格
	 */
	@Test
	public void postDynamicCommentTestContentIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", dynamicId);
		con.put("remarkUser", uuid);
		con.put("content", " ");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论内容为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("评论内容不能为空");
	}
	/**
	 * 评论内容为null
	 */
	@Test
	public void postDynamicCommentTestContentIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", dynamicId);
		con.put("remarkUser", uuid);
		con.put("content", null);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论内容为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("未知错误");
	}
	/**
	 * 评论内容不传该参数
	 */
	@Test
	public void postDynamicCommentTestContentNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("dynamicId", dynamicId);
		con.put("remarkUser", uuid);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论内容不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("未知错误");
	}




}