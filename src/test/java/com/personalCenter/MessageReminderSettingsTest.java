package com.personalCenter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;
import com.example.LoginTest;
import com.example.MetaOper;

public class MessageReminderSettingsTest extends HttpUtil {
//消息提醒设置接口
	String url = "/UU/user";
	String selectSql = "SELECT * FROM T_MOBILE_SET WHERE USER_ID = 12495396";
	List<Map<String,Object>> list ;
	String dataType = "perCenter81";
	String chcode;
	String uuid;
	JSONObject body;
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
	 * 提交正确参数
	 */
	@Test
	public void postMessageReminderSettingsTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("isMsgNotice", "0");
		con.put("isVoiceNotice", "0");
		con.put("isShackNotice", "0");
		con.put("isMainMsgNotice", "0");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3710");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
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
	 * 用户为未登录
	 */
	@Test
	public void postMessageReminderSettingsTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("isMsgNotice", "0");
		con.put("isVoiceNotice", "0");
		con.put("isShackNotice", "0");
		con.put("isMainMsgNotice", "0");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3710");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户为未登录" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
			
	}
	/**
	 * 用户为错误
	 */
	@Test
	public void postMessageReminderSettingsTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "124951a4");
		con.put("isMsgNotice", "0");
		con.put("isVoiceNotice", "0");
		con.put("isShackNotice", "0");
		con.put("isMainMsgNotice", "0");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3710");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId格式不正确");
			
	}
	/**
	 * 用户ID存在小数
	 */
	@Test
	public void postMessageReminderSettingsTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "23.42");
		con.put("isMsgNotice", "0");
		con.put("isVoiceNotice", "0");
		con.put("isShackNotice", "0");
		con.put("isMainMsgNotice", "0");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3710");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID存在小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId格式不正确");
			
	}
	/**
	 * 用户ID存在非法字符
	 */
	@Test
	public void postMessageReminderSettingsTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "<$%(+!,=>");
		con.put("isMsgNotice", "0");
		con.put("isVoiceNotice", "0");
		con.put("isShackNotice", "0");
		con.put("isMainMsgNotice", "0");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3710");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID存在非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId格式不正确");
			
	}
	/**
	 * 用户ID存在负数
	 */
	@Test
	public void postMessageReminderSettingsTestUserIdIsNegativeNumbe() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "-234");
		con.put("isMsgNotice", "0");
		con.put("isVoiceNotice", "0");
		con.put("isShackNotice", "0");
		con.put("isMainMsgNotice", "0");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3710");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID存在负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId格式不正确");
			
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postMessageReminderSettingsTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "0");
		con.put("isMsgNotice", "0");
		con.put("isVoiceNotice", "0");
		con.put("isShackNotice", "0");
		con.put("isMainMsgNotice", "0");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3710");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId格式不正确");
			
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postMessageReminderSettingsTestUserIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "dfdfghju");
		con.put("isMsgNotice", "0");
		con.put("isVoiceNotice", "0");
		con.put("isShackNotice", "0");
		con.put("isMainMsgNotice", "0");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3710");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId格式不正确");
			
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postMessageReminderSettingsTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("isMsgNotice", "0");
		con.put("isVoiceNotice", "0");
		con.put("isShackNotice", "0");
		con.put("isMainMsgNotice", "0");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3710");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId格式不正确");
			
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postMessageReminderSettingsTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("isMsgNotice", "0");
		con.put("isVoiceNotice", "0");
		con.put("isShackNotice", "0");
		con.put("isMainMsgNotice", "0");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3710");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId格式不正确");
			
	}
	/**
	 * 用户ID为null
	 */
	@Test
		public void postMessageReminderSettingsTestUserIdIsNull() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", null);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("用户ID为null" + post);
			JSONObject head1 = (JSONObject) post.get("head");
		
			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("userId为空");
				
		}
		/**
		 * 用户ID不传该 参数
		 */
		@Test
		public void postMessageReminderSettingsTestUserIdNonSubmissionParameters() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
		
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("用户ID不传该 参数" + post);
			JSONObject head1 = (JSONObject) post.get("head");
		
			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("userId为空");
				
		}
		/**
		 * 信息提醒传0接收消息提醒
		 */
		@Test
		public void postMessageReminderSettingsTestIsMsgNoticeSetZeroReceive() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("信息提醒传0接收消息提醒" + post);
			JSONObject head1 = (JSONObject) post.get("head");
			list =MetaOper.read(selectSql,dataType);
			String isMsgNotice = list.get(0).get("IS_MSG_NOTICE").toString();
		
			assertThat(head1.get("st")).isEqualTo(0);
			assertThat(head1.get("msg")).isEqualTo("成功");
			assertThat(isMsgNotice).isEqualTo("0");
				
		}
		/**
		 * 设置信息提醒传1不接收消息提醒
		 */
		@Test
		public void postMessageReminderSettingsTestIsMsgNoticeSetOneNotReceive() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "1");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置信息提醒传1不接收消息提醒" + post);
			JSONObject head1 = (JSONObject) post.get("head");
			list =MetaOper.read(selectSql,dataType);
			String isMsgNotice = list.get(0).get("IS_MSG_NOTICE").toString();
		
			assertThat(head1.get("st")).isEqualTo(0);
			assertThat(head1.get("msg")).isEqualTo("成功");
			assertThat(isMsgNotice).isEqualTo("1");
				
		}
		/**
		 * 设置信息提醒传String
		 */
		@Test
		public void postMessageReminderSettingsTestIsMsgNoticeIsString() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "vhfdf");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置信息提醒传String" + post);
			JSONObject head1 = (JSONObject) post.get("head");
		
			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isMsgNotice不正确");
				
		}
		/**
		 * 设置信息提醒传小数
		 */
		@Test
		public void postMessageReminderSettingsTestIsMsgNoticeIsDecimal() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0.23");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置信息提醒传小数" + post);
			JSONObject head1 = (JSONObject) post.get("head");
		
			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isMsgNotice不正确");
				
		}
		/**
		 * 设置信息提醒传负数
		 */
		@Test
		public void postMessageReminderSettingsTestIsMsgNoticeIsNegativeNumbe() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "-8");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置信息提醒传负数" + post);
			JSONObject head1 = (JSONObject) post.get("head");
		
			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isMsgNotice不正确");
				
		}
		/**
		 * 设置信息提醒传空格
		 */
		@Test
		public void postMessageReminderSettingsTestIsMsgNoticeIsSpace() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", " ");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置信息提醒传空格" + post);
			JSONObject head1 = (JSONObject) post.get("head");
		
			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isMsgNotice不正确");
				
		}
		/**
		 * 设置信息提醒传空
		 */
		@Test
		public void postMessageReminderSettingsTestIsMsgNoticeIsEmpty() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置信息提醒传空" + post);
			JSONObject head1 = (JSONObject) post.get("head");

			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isMsgNotice不正确");
				
		}
		/**
		 * 设置信息提醒传null
		 */
		@Test
		public void postMessageReminderSettingsTestIsMsgNoticeIsNull() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", null);
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置信息提醒传null" + post);
			JSONObject head1 = (JSONObject) post.get("head");

			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isMsgNotice不正确");
				
		}
		/**
		 * 设置信息提醒不传该参数
		 */
		@Test
		public void postMessageReminderSettingsTestIsMsgNoticeNonSubmissionParameters() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置信息提醒不传该参数" + post);
			JSONObject head1 = (JSONObject) post.get("head");

			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isMsgNotice不正确");
				
		}
		/**
		 * 设置信息提醒为最大值
		 */
		@Test
		public void postMessageReminderSettingsTestIsMsgNoticeIsMax() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", 999999999);
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置信息提醒为最大值" + post);
			JSONObject head1 = (JSONObject) post.get("head");

			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isMsgNotice不正确");
				
		}
		/**
		 * 设置声音提醒传0接收声音提醒
		 */
		@Test
		public void postMessageReminderSettingsTestIsVoiceNoticeSetZeroReceive() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置声音提醒传0接收声音提醒" + post);
			JSONObject head1 = (JSONObject) post.get("head");
			list =MetaOper.read(selectSql,dataType);
			String isVoiceNotice = list.get(0).get("IS_VOICE_NOTICE").toString();
		
			assertThat(head1.get("st")).isEqualTo(0);
			assertThat(head1.get("msg")).isEqualTo("成功");
			assertThat(isVoiceNotice).isEqualTo("0");
				
		}
		/**
		 * 设置声音提醒传1不接收声音提醒
		 */
		@Test
		public void postMessageReminderSettingsTestIsVoiceNoticeSetOneNotReceive() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "1");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置声音提醒传1不接收声音提醒" + post);
			JSONObject head1 = (JSONObject) post.get("head");
			list =MetaOper.read(selectSql,dataType);
			String isVoiceNotice = list.get(0).get("IS_VOICE_NOTICE").toString();
		
			assertThat(head1.get("st")).isEqualTo(0);
			assertThat(head1.get("msg")).isEqualTo("成功");
			assertThat(isVoiceNotice).isEqualTo("1");
				
		}
		/**
		 * 设置声音提醒传String
		 */
		@Test
		public void postMessageReminderSettingsTestIsVoiceNoticeIsString() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "dfdfdsfs");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置声音提醒传String" + post);
			JSONObject head1 = (JSONObject) post.get("head");
		
			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isVoiceNotice不正确");
				
		}
		/**
		 * 设置声音提醒传小数
		 */
		@Test
		public void postMessageReminderSettingsTestIsVoiceNoticeIsDecimal() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "0.36");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置声音提醒传小数" + post);
			JSONObject head1 = (JSONObject) post.get("head");
		
			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isVoiceNotice不正确");
				
		}
		/**
		 * 设置声音提醒传负数
		 */
		@Test
		public void postMessageReminderSettingsTestIsVoiceNoticeIsNegativeNumbe() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "-23");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置声音提醒传负数" + post);
			JSONObject head1 = (JSONObject) post.get("head");

			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isVoiceNotice不正确");
				
		}
		/**
		 * 设置声音提醒传空格
		 */
		@Test
		public void postMessageReminderSettingsTestIsVoiceNoticeIsSpace() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", " ");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置声音提醒传空格" + post);
			JSONObject head1 = (JSONObject) post.get("head");

			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isVoiceNotice不正确");
				
		}
		/**
		 * 设置声音提醒传空
		 */
		@Test
		public void postMessageReminderSettingsTestIsVoiceNoticeIsEmpty() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置声音提醒传空" + post);
			JSONObject head1 = (JSONObject) post.get("head");

			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isVoiceNotice不正确");
				
		}
		/**
		 * 设置声音提醒传null
		 */
		@Test
		public void postMessageReminderSettingsTestIsVoiceNoticeIsNull() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", null);
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置声音提醒传null" + post);
			JSONObject head1 = (JSONObject) post.get("head");

			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isVoiceNotice不正确");
				
		}
		/**
		 * 设置声音提醒不传该参数
		 */
		@Test
		public void postMessageReminderSettingsTestIsVoiceNoticeNonSubmissionParameters() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置声音提醒不传该参数" + post);
			JSONObject head1 = (JSONObject) post.get("head");

			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isVoiceNotice不正确");
				
		}
		/**
		 * 设置声音提醒为最大值
		 */
		@Test
		public void postMessageReminderSettingsTestIsVoiceNoticeIsMax() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", 999999999);
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置声音提醒为最大值" + post);
			JSONObject head1 = (JSONObject) post.get("head");

			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isVoiceNotice不正确");
				
		}
		/**
		 * 设置震动提醒传0接收震动提醒
		 */
		@Test
		public void postMessageReminderSettingsTestIsShackNoticeSetZeroReceive() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置震动提醒传0接收震动提醒" + post);
			JSONObject head1 = (JSONObject) post.get("head");
			list =MetaOper.read(selectSql,dataType);
			String isShackNotice = list.get(0).get("IS_SHACK_NOTICE").toString();
		
			assertThat(head1.get("st")).isEqualTo(0);
			assertThat(head1.get("msg")).isEqualTo("成功");
			assertThat(isShackNotice).isEqualTo("0");
				
		}
		/**
		 * 设置震动提醒传1不接收震动提醒
		 */
		@Test
		public void postMessageReminderSettingsTestIsShackNoticeSetOneNotReceive() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "1");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置震动提醒传1不接收震动提醒" + post);
			JSONObject head1 = (JSONObject) post.get("head");
			list =MetaOper.read(selectSql,dataType);
			String isShackNotice = list.get(0).get("IS_SHACK_NOTICE").toString();
		
			assertThat(head1.get("st")).isEqualTo(0);
			assertThat(head1.get("msg")).isEqualTo("成功");
			assertThat(isShackNotice).isEqualTo("1");
				
		}
		/**
		 * 设置震动提醒传String
		 */
		@Test
		public void postMessageReminderSettingsTestIsShackNoticeIsString() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "dfggfh");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置震动提醒传String" + post);
			JSONObject head1 = (JSONObject) post.get("head");
		
			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isShackNotice不正确");
				
		}
		/**
		 * 设置震动提醒传小数
		 */
		@Test
		public void postMessageReminderSettingsTestIsShackNoticeIsDecimal() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", 0.69);
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置震动提醒传小数" + post);
			JSONObject head1 = (JSONObject) post.get("head");

			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isShackNotice不正确");
				
		}
		/**
		 * 设置震动提醒传负数
		 */
		@Test
		public void postMessageReminderSettingsTestIsShackNoticeIsNegativeNumbe() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", -23);
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置震动提醒传负数" + post);
			JSONObject head1 = (JSONObject) post.get("head");

			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isShackNotice不正确");
				
		}
		/**
		 * 设置震动提醒传空格
		 */
		@Test
		public void postMessageReminderSettingsTestIsShackNoticeIsSpace() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", " ");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置震动提醒传空格" + post);
			JSONObject head1 = (JSONObject) post.get("head");

			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isShackNotice不正确");
				
		}
		/**
		 * 设置震动提醒传空
		 */
		@Test
		public void postMessageReminderSettingsTestIsShackNoticeIsEmpty() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置震动提醒传空" + post);
			JSONObject head1 = (JSONObject) post.get("head");

			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isShackNotice不正确");
				
		}
		/**
		 * 设置震动提醒传null
		 */
		@Test
		public void postMessageReminderSettingsTestIsShackNoticeIsNull() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", null);
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置震动提醒传null" + post);
			JSONObject head1 = (JSONObject) post.get("head");

			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isShackNotice不正确");
				
		}
		/**
		 * 设置震动提醒不传该参数
		 */
		@Test
		public void postMessageReminderSettingsTestIsShackNoticeNonSubmissionParameters() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "0");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置震动提醒不传该参数" + post);
			JSONObject head1 = (JSONObject) post.get("head");

			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isShackNotice不正确");
				
		}
		/**
		 * 设置震动提醒为最大值
		 */
		@Test
		public void postMessageReminderSettingsTestIsShackNoticeIsMax() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", 999999999);
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置震动提醒为最大值" + post);
			JSONObject head1 = (JSONObject) post.get("head");

			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isShackNotice不正确");
				
		}
		/**
		 * 设置主信息提醒传0接收主信息提醒
		 */
		@Test
		public void postMessageReminderSettingsTestIsMainMsgNoticeSetZeroReceive() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置主信息提醒传0接收主信息提醒" + post);
			JSONObject head1 = (JSONObject) post.get("head");
			list =MetaOper.read(selectSql,dataType);
			String isMainMsgNotice = list.get(0).get("IS_MAINMSG_NOTICE").toString();
		
			assertThat(head1.get("st")).isEqualTo(0);
			assertThat(head1.get("msg")).isEqualTo("成功");
			assertThat(isMainMsgNotice).isEqualTo("0");
				
		}
		/**
		 * 设置主信息提醒传1不接收主信息提醒
		 */
		@Test
		public void postMessageReminderSettingsTestIsMainMsgNoticeSetOneNotReceive() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "1");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置主信息提醒传1不接收主信息提醒" + post);
			JSONObject head1 = (JSONObject) post.get("head");
			list =MetaOper.read(selectSql,dataType);
			System.out.println("数据查询结果" + list.toString());

			String isMainMsgNotice = list.get(0).get("IS_MAINMSG_NOTICE").toString();
		
			assertThat(head1.get("st")).isEqualTo(0);
			assertThat(head1.get("msg")).isEqualTo("成功");
			assertThat(isMainMsgNotice).isEqualTo("1");
		}
		/**
		 * 设置主信息提醒传String
		 */
		@Test
		public void postMessageReminderSettingsTestIsMainMsgNoticeIsString() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "gfjtytry");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置主信息提醒传String" + post);
			JSONObject head1 = (JSONObject) post.get("head");
		
			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isMainMsgNotice不正确");
				
		}
		/**
		 * 设置主信息提醒传小数
		 */
		@Test
		public void postMessageReminderSettingsTestIsMainMsgNoticeIsDecimal() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "2.36");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置主信息提醒传小数" + post);
			JSONObject head1 = (JSONObject) post.get("head");

			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isMainMsgNotice不正确");
				
		}
		/**
		 * 设置主信息提醒传负数
		 */
		@Test
		public void postMessageReminderSettingsTestIsMainMsgNoticeIsNegativeNumbe() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", -12);
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置主信息提醒传负数" + post);
			JSONObject head1 = (JSONObject) post.get("head");

			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isMainMsgNotice不正确");
				
		}
		/**
		 * 设置主信息提醒传空格
		 */
		@Test
		public void postMessageReminderSettingsTestIsMainMsgNoticeIsSpace() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", " ");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置主信息提醒传空格" + post);
			JSONObject head1 = (JSONObject) post.get("head");

			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isMainMsgNotice不正确");
				
		}
		/**
		 * 设置主信息提醒传空
		 */
		@Test
		public void postMessageReminderSettingsTestIsMainMsgNoticeIsEmpty() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", "");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置主信息提醒传空" + post);
			JSONObject head1 = (JSONObject) post.get("head");

			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isMainMsgNotice不正确");
				
		}
		/**
		 * 设置主信息提醒传null
		 */
		@Test
		public void postMessageReminderSettingsTestIsMainMsgNoticeIsNull() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", null);
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置主信息提醒传null" + post);
			JSONObject head1 = (JSONObject) post.get("head");

			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isMainMsgNotice不正确");
				
		}
		/**
		 * 设置主信息提醒不传该参数
		 */
		@Test
		public void postMessageReminderSettingsTestIsMainMsgNoticeNonSubmissionParameters() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "0");
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置主信息提醒不传该参数" + post);
			JSONObject head1 = (JSONObject) post.get("head");

			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isMainMsgNotice不正确");
				
		}
		/**
		 * 设置主信息提醒为最大值
		 */
		@Test
		public void postMessageReminderSettingsTestIsMainMsgNoticeIsMax() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", uuid);
			con.put("isMsgNotice", "0");
			con.put("isVoiceNotice", "0");
			con.put("isShackNotice", "0");
			con.put("isMainMsgNotice", 999999999);
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", uuid);
			head.put("ln", "cn");
			head.put("chcode", chcode);
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置主信息提醒为最大值" + post);
			JSONObject head1 = (JSONObject) post.get("head");

			assertThat(head1.get("st")).isEqualTo(-3);
			assertThat(head1.get("msg")).isEqualTo("isMainMsgNotice不正确");
				
		}
		
	
}