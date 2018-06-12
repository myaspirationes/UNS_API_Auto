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

public class DynamicRemarkTest extends HttpUtil {
//动态评论回复接口
	String url = "/UU/dynamicRemark";

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
		head.put("ver", "1.2.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", chcode);
		head.put("cmd", 1702);
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postDynamicRemarkTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);
		

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
	 * 评论ID超长
	 */
	@Test
	public void postDynamicRemarkTestRemarkIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 111111111111L);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 评论ID为小数
	 */
	@Test
	public void postDynamicRemarkTestRemarkIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 15.11);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}

	/**
	 * 评论ID为0
	 */
	@Test
	public void postDynamicRemarkTestRemarkIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 0);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}

	/**
	 * 评论ID为负数
	 */
	@Test
	public void postDynamicRemarkTestRemarkIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", -1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}

	/**
	 * 评论ID为空
	 */
	@Test
	public void postDynamicRemarkTestRemarkIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", "");
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}

	/**
	 * 评论ID为空格
	 */
	@Test
	public void postDynamicRemarkTestRemarkIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", " ");
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}

	/**
	 * 评论ID为null
	 */
	@Test
	public void postDynamicRemarkTestRemarkIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", null);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}

	/**
	 * 评论ID为字符串
	 */
	@Test
	public void postDynamicRemarkTestRemarkIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", "aa");
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID为字符串" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}

	/**
	 * 评论ID不传该参数
	 */
	@Test
	public void postDynamicRemarkTestRemarkIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}

	/**
	 * 评论ID不存在
	 */
	@Test
	public void postDynamicRemarkTestRemarkIdNonExistent() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 999999999);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("评论ID超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}


	/**
	 * 用户ID为未登录
	 */
	@Test
	public void postDynamicRemarkTestReplyUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", 12491672);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为错误
	 */
	@Test
	public void postDynamicRemarkTestReplyUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", 11671);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为字符串
	 */
	@Test
	public void postDynamicRemarkTestReplyUserIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", "ssss");
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为字符串" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}

	/**
	 * 用户ID为小数
	 */
	@Test
	public void postDynamicRemarkTestReplyUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", 1.1);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}

	/**
	 * 用户ID为负数
	 */
	@Test
	public void postDynamicRemarkTestReplyUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", -9);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}

	/**
	 * 用户ID为0
	 */
	@Test
	public void postDynamicRemarkTestReplyUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", 0);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}

	/**
	 * 用户ID为空
	 */
	@Test
	public void postDynamicRemarkTestReplyUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", "");
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}

	/**
	 * 用户ID为空格
	 */
	@Test
	public void postDynamicRemarkTestReplyUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", " ");
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}

	/**
	 * 用户ID为null
	 */
	@Test
	public void postDynamicRemarkTestReplyUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", null);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}

	/**
	 * 用户ID为超长
	 */
	@Test
	public void postDynamicRemarkTestReplyUserIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", 12491672231231L);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}

	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postDynamicRemarkTestReplyUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}

	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postDynamicRemarkTestReplyUserIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", "<.#$%>");
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 回复内容非法字符
	 */
	@Test
	public void postDynamicRemarkTestContentIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "<.#$%^&>");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("回复内容非法字符" + post);
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
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("回复内容为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 回复内容为空格
	 */
	@Test
	public void postDynamicRemarkTestContentIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", " ");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("回复内容为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 回复内容为null
	 */
	@Test
	public void postDynamicRemarkTestContentIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", null);
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("回复内容为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 回复内容超长
	 */
	@Test
	public void postDynamicRemarkTestContentIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("回复内容超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 回复内容不传该参数
	 */
	@Test
	public void postDynamicRemarkTestContentNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("回复内容不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}

	/**
	 * 被回复人ID和内容不符
	 */
	@Test
	public void postDynamicRemarkTestReplyTargetIdNotTheSameAsRemarkContent() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 124912122);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被回复人ID和内容不符" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 被回复人ID为小数
	 */
	@Test
	public void postDynamicRemarkTestReplyTargetIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 1.12);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被回复人ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 被回复人ID为0
	 */
	@Test
	public void postDynamicRemarkTestReplyTargetIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 0);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被回复人ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 被回复人ID为负数
	 */
	@Test
	public void postDynamicRemarkTestReplyTargetIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", -22);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被回复人ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 被回复人ID为空
	 */
	@Test
	public void postDynamicRemarkTestReplyTargetIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", "");
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被回复人ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 被回复人ID为空格
	 */
	@Test
	public void postDynamicRemarkTestReplyTargetIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", " ");
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被回复人ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 被回复人ID为null
	 */
	@Test
	public void postDynamicRemarkTestReplyTargetIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", null);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被回复人ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 被回复人ID为字符串
	 */
	@Test
	public void postDynamicRemarkTestReplyTargetIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", "aaa");
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被回复人ID为字符串" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 被回复人ID不传该参数
	 */
	@Test
	public void postDynamicRemarkTestReplyTargetIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被回复人ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 被回复者的评论超长
	 */
	@Test
	public void postDynamicRemarkTestRemarkContentIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "被回复者的评论超长被回复者的评论超长被回复者的评论超长被回复者的评论超长被回复者的评论超长被回复者的评论超长被回复者的评论超长被回复者的评论超长被回复者的评论超长被回复者的评论超长被回复者的评论超长被回复者的评论超长被回复者的评论超长被回复者的评论超长被回复者的评论超长被回复者的评论超长被回复者的评论超长被回复者的评论超长被回复者的评论超长被回复者的评论超长被回复者的评论超长被回复者的评论超长被回复者的评论超长被回复者的评论超长被回复者的评论超长");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被回复者的评论超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 被回复者的评论非法字符
	 */
	@Test
	public void postDynamicRemarkTestRemarkContentIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "<.@#$$#>");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被回复者的评论非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 被回复者的评论为空
	 */
	@Test
	public void postDynamicRemarkTestRemarkContentIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被回复者的评论为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 被回复者的评论为空格
	 */
	@Test
	public void postDynamicRemarkTestRemarkContentIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", " ");
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被回复者的评论为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 被回复者的评论为null
	 */
	@Test
	public void postDynamicRemarkTestRemarkContentIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", null);
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被回复者的评论为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 被回复者的评论不传该参数
	 */
	@Test
	public void postDynamicRemarkTestRemarkContentNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("dynamicId", 1319);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("被回复者的评论不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}

	/**
	 * 动态ID为小数
	 */
	@Test
	public void postDynamicRemarkTestDynamicIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 1.9);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态ID为负数
	 */
	@Test
	public void postDynamicRemarkTestDynamicIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", -19);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态ID为0
	 */
	@Test
	public void postDynamicRemarkTestDynamicIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 0);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态ID为字符串
	 */
	@Test
	public void postDynamicRemarkTestDynamicIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", "aaa");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为字符串" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态ID为超长
	 */
	@Test
	public void postDynamicRemarkTestDynamicIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", 131313131313131313L);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态ID为空
	 */
	@Test
	public void postDynamicRemarkTestDynamicIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", "");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态ID为空格
	 */
	@Test
	public void postDynamicRemarkTestDynamicIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", " ");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态ID为null
	 */
	@Test
	public void postDynamicRemarkTestDynamicIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");
		con.put("dynamicId", null);


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态ID不传该参数
	 */
	@Test
	public void postDynamicRemarkTestDynamicIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("remarkId", 1511);
		con.put("replyUserId", uuid);
		con.put("content", "老铁6666");
		con.put("replyTargetId", 12491622);
		con.put("remarkContent", "名哦尼");


		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}







}