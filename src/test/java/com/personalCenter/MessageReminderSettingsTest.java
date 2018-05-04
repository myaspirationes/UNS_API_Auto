package com.personalCenter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;

public class MessageReminderSettingsTest extends HttpUtil {
//设置默认收货地址
	String url = "/UU/user";
	

	/**
	 * 提交正确参数
	 */
	@Test
	public void postMessageReminderSettingsTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "234234");
		con.put("isMsgNotice", 1);
		con.put("isVoiceNotice", 1);
		con.put("isShackNotice", 1);
		con.put("isMainMsgNotice", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3710");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "188111");
		head.put("ln", "cn");
		head.put("chcode", "ef19843298ae8f2134f");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	/**
	 * 用户为未登录
	 */
	//@Test
	public void postMessageReminderSettingsTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "234234");
		con.put("isMsgNotice", 1);
		con.put("isVoiceNotice", 1);
		con.put("isShackNotice", 1);
		con.put("isMainMsgNotice", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3710");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "188111");
		head.put("ln", "cn");
		head.put("chcode", "ef19843298ae8f2134f");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户为未登录" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
			
	}
	/**
	 * 用户为错误
	 */
	//@Test
	public void postMessageReminderSettingsTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "234234");
		con.put("isMsgNotice", 1);
		con.put("isVoiceNotice", 1);
		con.put("isShackNotice", 1);
		con.put("isMainMsgNotice", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3710");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "188111");
		head.put("ln", "cn");
		head.put("chcode", "ef19843298ae8f2134f");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
			
	}
	/**
	 * 用户ID存在小数
	 */
	//@Test
	public void postMessageReminderSettingsTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "23.42");
		con.put("isMsgNotice", 1);
		con.put("isVoiceNotice", 1);
		con.put("isShackNotice", 1);
		con.put("isMainMsgNotice", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3710");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "188111");
		head.put("ln", "cn");
		head.put("chcode", "ef19843298ae8f2134f");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID存在小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
			
	}
	/**
	 * 用户ID存在非法字符
	 */
	//@Test
	public void postMessageReminderSettingsTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "<$%(+!,=>");
		con.put("isMsgNotice", 1);
		con.put("isVoiceNotice", 1);
		con.put("isShackNotice", 1);
		con.put("isMainMsgNotice", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3710");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "188111");
		head.put("ln", "cn");
		head.put("chcode", "ef19843298ae8f2134f");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID存在非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
			
	}
	/**
	 * 用户ID存在负数
	 */
	//@Test
	public void postMessageReminderSettingsTestUserIdIsNegativeNumbe() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "-234");
		con.put("isMsgNotice", 1);
		con.put("isVoiceNotice", 1);
		con.put("isShackNotice", 1);
		con.put("isMainMsgNotice", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3710");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "188111");
		head.put("ln", "cn");
		head.put("chcode", "ef19843298ae8f2134f");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID存在负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
			
	}
	/**
	 * 用户ID为0
	 */
	//@Test
	public void postMessageReminderSettingsTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
		con.put("isMsgNotice", 1);
		con.put("isVoiceNotice", 1);
		con.put("isShackNotice", 1);
		con.put("isMainMsgNotice", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3710");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "188111");
		head.put("ln", "cn");
		head.put("chcode", "ef19843298ae8f2134f");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
			
	}
	/**
	 * 用户ID为String
	 */
	//@Test
	public void postMessageReminderSettingsTestUserIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "dfdfghju");
		con.put("isMsgNotice", 1);
		con.put("isVoiceNotice", 1);
		con.put("isShackNotice", 1);
		con.put("isMainMsgNotice", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3710");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "188111");
		head.put("ln", "cn");
		head.put("chcode", "ef19843298ae8f2134f");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
			
	}
	/**
	 * 用户ID为空
	 */
	//@Test
	public void postMessageReminderSettingsTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("isMsgNotice", 1);
		con.put("isVoiceNotice", 1);
		con.put("isShackNotice", 1);
		con.put("isMainMsgNotice", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3710");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "188111");
		head.put("ln", "cn");
		head.put("chcode", "ef19843298ae8f2134f");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
			
	}
	/**
	 * 用户ID为空格
	 */
	//@Test
	public void postMessageReminderSettingsTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("isMsgNotice", 1);
		con.put("isVoiceNotice", 1);
		con.put("isShackNotice", 1);
		con.put("isMainMsgNotice", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3710");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "188111");
		head.put("ln", "cn");
		head.put("chcode", "ef19843298ae8f2134f");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
			
	}
	/**
	 * 用户ID为null
	 */
	//@Test
		public void postMessageReminderSettingsTestUserIdIsNull() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", null);
			con.put("isMsgNotice", 1);
			con.put("isVoiceNotice", 1);
			con.put("isShackNotice", 1);
			con.put("isMainMsgNotice", 1);
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", "188111");
			head.put("ln", "cn");
			head.put("chcode", "ef19843298ae8f2134f");
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("用户ID为null" + post);
			JSONObject head1 = (JSONObject) post.get("head");
		
			assertThat(head1.get("st")).isEqualTo("0");
			assertThat(head1.get("msg")).isEqualTo("上传成功");
				
		}
		/**
		 * 用户ID不传该 参数
		 */
		//@Test
		public void postMessageReminderSettingsTestUserIdNonSubmissionParameters() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
		
			con.put("isMsgNotice", 1);
			con.put("isVoiceNotice", 1);
			con.put("isShackNotice", 1);
			con.put("isMainMsgNotice", 1);
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", "188111");
			head.put("ln", "cn");
			head.put("chcode", "ef19843298ae8f2134f");
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("用户ID不传该 参数" + post);
			JSONObject head1 = (JSONObject) post.get("head");
		
			assertThat(head1.get("st")).isEqualTo("0");
			assertThat(head1.get("msg")).isEqualTo("上传成功");
				
		}
		/**
		 * 信息提醒传0接收消息提醒
		 */
		//@Test
		public void postMessageReminderSettingsTestIsMsgNoticeSetZeroReceive() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", 234234);
			con.put("isMsgNotice", 0);
			con.put("isVoiceNotice", 1);
			con.put("isShackNotice", 1);
			con.put("isMainMsgNotice", 1);
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", "188111");
			head.put("ln", "cn");
			head.put("chcode", "ef19843298ae8f2134f");
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("信息提醒传0接收消息提醒" + post);
			JSONObject head1 = (JSONObject) post.get("head");
		
			assertThat(head1.get("st")).isEqualTo("0");
			assertThat(head1.get("msg")).isEqualTo("上传成功");
				
		}
		/**
		 * 设置信息提醒传1不接收消息提醒
		 */
		//@Test
		public void postMessageReminderSettingsTestIsMsgNoticeSetOneNotReceive() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", 234234);
			con.put("isMsgNotice", 1);
			con.put("isVoiceNotice", 1);
			con.put("isShackNotice", 1);
			con.put("isMainMsgNotice", 1);
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", "188111");
			head.put("ln", "cn");
			head.put("chcode", "ef19843298ae8f2134f");
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置信息提醒传1不接收消息提醒" + post);
			JSONObject head1 = (JSONObject) post.get("head");
		
			assertThat(head1.get("st")).isEqualTo("0");
			assertThat(head1.get("msg")).isEqualTo("上传成功");
				
		}
		/**
		 * 设置信息提醒传String
		 */
		//@Test
		public void postMessageReminderSettingsTestIsMsgNoticeIsString() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", 234234);
			con.put("isMsgNotice", "vhfdf");
			con.put("isVoiceNotice", 1);
			con.put("isShackNotice", 1);
			con.put("isMainMsgNotice", 1);
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", "188111");
			head.put("ln", "cn");
			head.put("chcode", "ef19843298ae8f2134f");
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置信息提醒传String" + post);
			JSONObject head1 = (JSONObject) post.get("head");
		
			assertThat(head1.get("st")).isEqualTo("0");
			assertThat(head1.get("msg")).isEqualTo("上传成功");
				
		}
		/**
		 * 设置信息提醒传小数
		 */
		//@Test
		public void postMessageReminderSettingsTestIsMsgNoticeIsDecimal() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", 234234);
			con.put("isMsgNotice", 1.23);
			con.put("isVoiceNotice", 1);
			con.put("isShackNotice", 1);
			con.put("isMainMsgNotice", 1);
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", "188111");
			head.put("ln", "cn");
			head.put("chcode", "ef19843298ae8f2134f");
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置信息提醒传小数" + post);
			JSONObject head1 = (JSONObject) post.get("head");
		
			assertThat(head1.get("st")).isEqualTo("0");
			assertThat(head1.get("msg")).isEqualTo("上传成功");
				
		}
		/**
		 * 设置信息提醒传负数
		 */
		//@Test
		public void postMessageReminderSettingsTestIsMsgNoticeIsNegativeNumbe() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", 234234);
			con.put("isMsgNotice", -8);
			con.put("isVoiceNotice", 1);
			con.put("isShackNotice", 1);
			con.put("isMainMsgNotice", 1);
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", "188111");
			head.put("ln", "cn");
			head.put("chcode", "ef19843298ae8f2134f");
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置信息提醒传负数" + post);
			JSONObject head1 = (JSONObject) post.get("head");
		
			assertThat(head1.get("st")).isEqualTo("0");
			assertThat(head1.get("msg")).isEqualTo("上传成功");
				
		}
		/**
		 * 设置信息提醒传空格
		 */
		//@Test
		public void postMessageReminderSettingsTestIsMsgNoticeIsSpace() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", 234234);
			con.put("isMsgNotice", " ");
			con.put("isVoiceNotice", 1);
			con.put("isShackNotice", 1);
			con.put("isMainMsgNotice", 1);
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", "188111");
			head.put("ln", "cn");
			head.put("chcode", "ef19843298ae8f2134f");
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置信息提醒传空格" + post);
			JSONObject head1 = (JSONObject) post.get("head");
		
			assertThat(head1.get("st")).isEqualTo("0");
			assertThat(head1.get("msg")).isEqualTo("上传成功");
				
		}
		/**
		 * 设置信息提醒传空
		 */
		//@Test
		public void postMessageReminderSettingsTestIsMsgNoticeIsEmpty() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", 234234);
			con.put("isMsgNotice", "");
			con.put("isVoiceNotice", 1);
			con.put("isShackNotice", 1);
			con.put("isMainMsgNotice", 1);
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", "188111");
			head.put("ln", "cn");
			head.put("chcode", "ef19843298ae8f2134f");
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置信息提醒传空" + post);
			JSONObject head1 = (JSONObject) post.get("head");
		
			assertThat(head1.get("st")).isEqualTo("0");
			assertThat(head1.get("msg")).isEqualTo("上传成功");
				
		}
		/**
		 * 设置信息提醒传null
		 */
		//@Test
		public void postMessageReminderSettingsTestIsMsgNoticeIsNull() throws Exception {
			Map<String, Object> con = new HashMap<String, Object>();
			con.put("userId", 234234);
			con.put("isMsgNotice", null);
			con.put("isVoiceNotice", 1);
			con.put("isShackNotice", 1);
			con.put("isMainMsgNotice", 1);
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("aid", "1and6uu");
			head.put("ver", "1.0");
			head.put("cmd", "3710");
			head.put("de", "2011-07-13 00:00:00");
			head.put("uuid", "188111");
			head.put("ln", "cn");
			head.put("chcode", "ef19843298ae8f2134f");
			head.put("sync", "1");
			head.put("mod", "ios");
			Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
			request.put("con", con);
			request.put("head", head);
			
			JSONObject post = super.UNSPost(url, request);
			System.out.println("设置信息提醒传null" + post);
			JSONObject head1 = (JSONObject) post.get("head");
		
			assertThat(head1.get("st")).isEqualTo("0");
			assertThat(head1.get("msg")).isEqualTo("上传成功");
				
		}
	
	
	
	
	
}