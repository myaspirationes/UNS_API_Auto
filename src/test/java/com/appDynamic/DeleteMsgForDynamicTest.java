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

public class DeleteMsgForDynamicTest extends HttpUtil {
//动态消息全部清空（清空某个）
	String url = "/UU/deleteMsg";

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
		head.put("cmd", 3906);
	}

	/**
	 * 清除指定消息
	 */
	@Test
	public void postDeleteMsgForDynamicTestClearTheSpecifiedMessage() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("msgId", 888888);
		con.put("type", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("清除指定消息" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 清除全部消息
	 */
	@Test
	public void postDeleteMsgForDynamicTestClearAllMessages() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("type", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("清除全部消息" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postDeleteMsgForDynamicTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 1.1);
		con.put("msgId", 888888);
		con.put("type", 1);

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
	public void postDeleteMsgForDynamicTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -1);
		con.put("msgId", 888888);
		con.put("type", 1);

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
	public void postDeleteMsgForDynamicTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
		con.put("msgId", 888888);
		con.put("type", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为错误
	 */
	@Test
	public void postDeleteMsgForDynamicTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 123);
		con.put("msgId", 888888);
		con.put("type", 1);

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
	 * 用户ID未登录
	 */
	@Test
	public void postDeleteMsgForDynamicTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("msgId", 888888);
		con.put("type", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID未登录" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为字符串
	 */
	@Test
	public void postDeleteMsgForDynamicTestUserIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "uuid");
		con.put("msgId", 888888);
		con.put("type", 1);

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
	 * 用户ID为null
	 */
	@Test
	public void postDeleteMsgForDynamicTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		con.put("msgId", 888888);
		con.put("type", 1);

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
	 * 用户ID为空
	 */
	@Test
	public void postDeleteMsgForDynamicTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("msgId", 888888);
		con.put("type", 1);

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
	public void postDeleteMsgForDynamicTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("msgId", 888888);
		con.put("type", 1);

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
	 * 用户ID为超长
	 */
	@Test
	public void postDeleteMsgForDynamicTestUserIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 123123123123123L);
		con.put("msgId", 888888);
		con.put("type", 1);

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
	public void postDeleteMsgForDynamicTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("msgId", 888888);
		con.put("type", 1);

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
	 * 某个消息的ID为小数
	 */
	@Test
	public void postDeleteMsgForDynamicTestMsgIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("msgId", 9.9);
		con.put("type", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("某个消息的ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 某个消息的ID为负数
	 */
	@Test
	public void postDeleteMsgForDynamicTestMsgIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("msgId", -99);
		con.put("type", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("某个消息的ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 某个消息的ID为0
	 */
	@Test
	public void postDeleteMsgForDynamicTestMsgIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("msgId", 0);
		con.put("type", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("某个消息的ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 某个消息的ID为字符串
	 */
	@Test
	public void postDeleteMsgForDynamicTestMsgIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("msgId", "msgId");
		con.put("type", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("某个消息的ID为字符串" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 某个消息的ID为空格
	 */
	@Test
	public void postDeleteMsgForDynamicTestMsgIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("msgId", " ");
		con.put("type", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("某个消息的ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 某个消息的ID为空
	 */
	@Test
	public void postDeleteMsgForDynamicTestMsgIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("msgId", "");
		con.put("type", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("某个消息的ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 某个消息的ID为null
	 */
	@Test
	public void postDeleteMsgForDynamicTestMsgIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("msgId", null);
		con.put("type", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("某个消息的ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 某个消息的ID为超长
	 */
	@Test
	public void postDeleteMsgForDynamicTestMsgIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("msgId", 9999999999999L);
		con.put("type", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("某个消息的ID为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 某个消息的ID不传该参数
	 */
	@Test
	public void postDeleteMsgForDynamicTestMsgIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("type", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("某个消息的ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 消息提醒类型为错误
	 */
	@Test
	public void postDeleteMsgForDynamicTestTypeIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("msgId", 888888);
		con.put("type", 99);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("消息提醒类型为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 消息提醒类型为小数
	 */
	@Test
	public void postDeleteMsgForDynamicTestTypeIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("msgId", 888888);
		con.put("type", 1.1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("消息提醒类型为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 消息提醒类型为负数
	 */
	@Test
	public void postDeleteMsgForDynamicTestTypeIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("msgId", 888888);
		con.put("type", -1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("消息提醒类型为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 消息提醒类型为null
	 */
	@Test
	public void postDeleteMsgForDynamicTestTypeIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("msgId", 888888);
		con.put("type", null);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("消息提醒类型为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 消息提醒类型为空
	 */
	@Test
	public void postDeleteMsgForDynamicTestTypeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("msgId", 888888);
		con.put("type", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("消息提醒类型为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 消息提醒类型为空格
	 */
	@Test
	public void postDeleteMsgForDynamicTestTypeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("msgId", 888888);
		con.put("type", " ");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("消息提醒类型为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 消息提醒类型为字符串
	 */
	@Test
	public void postDeleteMsgForDynamicTestTypeIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("msgId", 888888);
		con.put("type", "aaa");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("消息提醒类型为字符串" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 消息提醒类型为超长
	 */
	@Test
	public void postDeleteMsgForDynamicTestTypeIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("msgId", 888888);
		con.put("type", 11111111111111111L);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("消息提醒类型为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 消息提醒类型不传该参数
	 */
	@Test
	public void postDeleteMsgForDynamicTestTypeNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("msgId", 888888);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("消息提醒类型不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}



	


}