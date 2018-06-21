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

public class DynamicRemarkTest extends HttpUtil {
//动态评论回复接口
	String url = "/UU/dynamicRemark";

	JSONObject body;
	String uuid;
	String chcode;
	Map<String, Object> head = new HashMap<String, Object>();
	String selectSql = "select * FROM T_COMMENTBACK WHERE CONTENT = '自动化评论'";
	String delDynamic = "DELETE FROM T_DYNAMIC WHERE DESCRIPTION = '自动化测试'";
	String delComment = "DELETE FROM T_COMMENTBACK WHERE CONTENT in ('自动化评论','<#$%^&**^%$#>','自动化评论回复')";
	String dataType = "perCenter81";
	List<Map<String,Object>> list ;
	String remarkId;
	String dynamicId;
	@BeforeClass
	public void  beforeClass() throws Exception {
		new PublishDynamicsTest().postPublishDynamicsTestCorrectParameter();
		new DynamicCommentTest().postDynamicCommentTestCorrectParameter();
		list = MetaOper.read(selectSql,dataType);
		remarkId = list.get(0).get("COMMENT_ID").toString();
		dynamicId = list.get(0).get("ORIGIN_ID").toString();
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
		head.put("cmd", 1702);
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
	public void postDynamicRemarkTestCorrectParameter() throws Exception {
		
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", uuid);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		String selSql = "select * from T_COMMENTBACK where COMMENT_ID ="+((JSONObject)post.get("body")).get("replyId").toString();
		list = MetaOper.read(selSql,dataType);
		assertThat(list.get(0).get("CONTENT").toString()).isEqualTo("自动化评论回复");
	}

	/**
	 * 评论ID超长
	 */
	@Test
	public void postDynamicRemarkTestRemarkIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 111111111111L);
		con.put("replyUserId", uuid);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("未知错误");
	}
	/**
	 * 评论ID为小数
	 */
	@Test
	public void postDynamicRemarkTestRemarkIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 15.11);
		con.put("replyUserId", uuid);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("评论id错误");
	}

	/**
	 * 评论ID为0
	 */
	@Test
	public void postDynamicRemarkTestRemarkIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 0);
		con.put("replyUserId", uuid);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("未知错误");
	}

	/**
	 * 评论ID为负数
	 */
	@Test
	public void postDynamicRemarkTestRemarkIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", -1453);
		con.put("replyUserId", uuid);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("评论id错误");
	}

	/**
	 * 评论ID为空
	 */
	@Test
	public void postDynamicRemarkTestRemarkIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", "");
		con.put("replyUserId", uuid);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("评论id错误");
	}

	/**
	 * 评论ID为空格
	 */
	@Test
	public void postDynamicRemarkTestRemarkIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", " ");
		con.put("replyUserId", uuid);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("评论id错误");
	}

	/**
	 * 评论ID为null
	 */
	@Test
	public void postDynamicRemarkTestRemarkIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", null);
		con.put("replyUserId", uuid);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("未知错误");
	}

	/**
	 * 评论ID为字符串
	 */
	@Test
	public void postDynamicRemarkTestRemarkIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", "aa");
		con.put("replyUserId", uuid);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID为字符串" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("评论id错误");
	}

	/**
	 * 评论ID不传该参数
	 */
	@Test
	public void postDynamicRemarkTestRemarkIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("replyUserId", uuid);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("未知错误");
	}

	/**
	 * 评论ID不存在
	 */
	@Test
	public void postDynamicRemarkTestRemarkIdNonExistent() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 999999999);
		con.put("replyUserId", uuid);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isIn("未知错误","失败");
	}


	/**
	 * 用户ID为未登录
	 */
	@Test
	public void postDynamicRemarkTestReplyUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", 12495079);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 用户ID为错误
	 */
	@Test
	public void postDynamicRemarkTestReplyUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", 11671);
		con.put("content", "自动化评论回复");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 用户ID为字符串
	 */
	@Test
	public void postDynamicRemarkTestReplyUserIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", "ssss");
		con.put("content", "自动化评论回复");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为字符串" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("回复人id错误");
	}

	/**
	 * 用户ID为小数
	 */
	@Test
	public void postDynamicRemarkTestReplyUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", 1.1);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("回复人id错误");
	}

	/**
	 * 用户ID为负数
	 */
	@Test
	public void postDynamicRemarkTestReplyUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", -9);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("回复人id错误");
	}

	/**
	 * 用户ID为0
	 */
	@Test
	public void postDynamicRemarkTestReplyUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", 0);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}

	/**
	 * 用户ID为空
	 */
	@Test
	public void postDynamicRemarkTestReplyUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", "");
		con.put("content", "自动化评论回复");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("回复人id错误");
	}

	/**
	 * 用户ID为空格
	 */
	@Test
	public void postDynamicRemarkTestReplyUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", " ");
		con.put("content", "自动化评论回复");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("回复人id错误");
	}

	/**
	 * 用户ID为null
	 */
	@Test
	public void postDynamicRemarkTestReplyUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", null);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("未知错误");
	}

	/**
	 * 用户ID为超长
	 */
	@Test
	public void postDynamicRemarkTestReplyUserIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", 12491672231231L);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}

	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postDynamicRemarkTestReplyUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("未知错误");
	}

	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postDynamicRemarkTestReplyUserIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", "<.#$%>");
		con.put("content", "自动化评论回复");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("回复人id错误");
	}

	/**
	 * 动态ID为小数
	 */
	@Test
	public void postDynamicRemarkTestDynamicIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", uuid);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", 1.9);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 动态ID为负数
	 */
	@Test
	public void postDynamicRemarkTestDynamicIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", uuid);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", -19);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 动态ID为0
	 */
	@Test
	public void postDynamicRemarkTestDynamicIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", uuid);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", 0);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 动态ID为字符串
	 */
	@Test
	public void postDynamicRemarkTestDynamicIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", uuid);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", "aaa");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为字符串" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("未知错误");
	}
	/**
	 * 动态ID为超长
	 */
	@Test
	public void postDynamicRemarkTestDynamicIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", uuid);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", 131313131313131313L);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 动态ID为空
	 */
	@Test
	public void postDynamicRemarkTestDynamicIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", uuid);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", "");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("动态id不能为空");
	}
	/**
	 * 动态ID为空格
	 */
	@Test
	public void postDynamicRemarkTestDynamicIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", uuid);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", " ");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("动态id不能为空");
	}
	/**
	 * 动态ID为null
	 */
	@Test
	public void postDynamicRemarkTestDynamicIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", uuid);
		con.put("content", "自动化评论回复");
		con.put("dynamicId", null);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("未知错误");
	}
	/**
	 * 动态ID不传该参数
	 */
	@Test
	public void postDynamicRemarkTestDynamicIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", uuid);
		con.put("content", "自动化评论回复");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("未知错误");
	}

	/**
	 * 回复内容超长
	 */
	@Test
	public void postDynamicRemarkTestContentIsLong() throws Exception {


		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", uuid);
		con.put("content", "自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复自动化评论回复");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("回复内容超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 回复内容为非法字符
	 */
	@Test
	public void postDynamicRemarkTestContentIllegalCharacters() throws Exception {


		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", uuid);
		con.put("content", "<.$%^&>");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("回复内容为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 回复内容为空
	 */
	@Test
	public void postDynamicRemarkTestContentIsEmpty() throws Exception {


		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", uuid);
		con.put("content", "");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("回复内容为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("回复内容不能为空");
	}
	/**
	 * 回复内容为空格
	 */
	@Test
	public void postDynamicRemarkTestContentIsSpace() throws Exception {


		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", uuid);
		con.put("content", " ");
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("回复内容为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("回复内容不能为空");
	}
	/**
	 * 回复内容为null
	 */
	@Test
	public void postDynamicRemarkTestContentIsNull() throws Exception {


		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", uuid);
		con.put("content", null);
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("回复内容为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("未知错误");
	}
	/**
	 * 回复内容不传该参数
	 */
	@Test
	public void postDynamicRemarkTestContentNonSubmissionParameters() throws Exception {


		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", remarkId);
		con.put("replyUserId", uuid);
		con.put("dynamicId", dynamicId);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("回复内容不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("未知错误");
	}






}