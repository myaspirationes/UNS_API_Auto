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
import com.example.LoginTest;
import com.example.MetaOper;

public class ObtainDetailsOfDocumentPhotosTest extends HttpUtil {
//获取件照详情接口
	String url = "/UU/authenticate";
	
	String dataType = "perCenter81";
	String chcode;
	@BeforeClass
	public void  beforeClass(){
		LoginTest login = new LoginTest();
		try {
			chcode = login.getLoginTestChcodeBy137();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 提交审核中的参数
	 */
	@Test
	public void postObtainDetailsOfDocumentPhotosTestIsAudit() throws Exception {
		String updateSql = "UPDATE \"T_AUTH_PHOTO\" SET \"STATUS\"='0' WHERE USER_ID = '12495417'";
		IdPhotoAuthenticateTest ida = new IdPhotoAuthenticateTest();
		ida.postIdPhotoAuthenticateTestCorrectParameter();
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495417);

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3907");
		head.put("uuid", "12495417");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交审核中的参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body1 = (JSONObject) post.get("body");
		
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(body1.get("statusTitle")).isEqualTo("你的照片正在审核中，请耐心等待~~");
	}
	/**
	 * 提交成功的参数
	 */
	@Test
	public void postObtainDetailsOfDocumentPhotosTestIsSuccess() throws Exception {
		String updateSql = "UPDATE \"T_AUTH_PHOTO\" SET \"STATUS\"='1' WHERE USER_ID = '12495417'";
		IdPhotoAuthenticateTest ida = new IdPhotoAuthenticateTest();
		ida.postIdPhotoAuthenticateTestCorrectParameter();
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495417);

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3907");
		head.put("uuid", "12495417");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交成功的参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body1 = (JSONObject) post.get("body");
		
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(body1.get("statusTitle")).isEqualTo("审核通过");
	}
	/**
	 * 提交审核失败的参数
	 */
	@Test
	public void postObtainDetailsOfDocumentPhotosTestIsFail() throws Exception {
		String updateSql = "UPDATE \"T_AUTH_PHOTO\" SET \"STATUS\"='2' WHERE USER_ID = '12495417'";
		IdPhotoAuthenticateTest ida = new IdPhotoAuthenticateTest();
		ida.postIdPhotoAuthenticateTestCorrectParameter();
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495417);

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3907");
		head.put("uuid", "12495417");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交审核失败的参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body1 = (JSONObject) post.get("body");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(body1.get("statusTitle")).isEqualTo("您的照片没有审核通过");
		
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postObtainDetailsOfDocumentPhotosTestUserIdNotLoggedIn() throws Exception {
		String updateSql = "UPDATE \"T_AUTH_PHOTO\" SET \"STATUS\"='0' WHERE USER_ID = '12495417'";
		IdPhotoAuthenticateTest ida = new IdPhotoAuthenticateTest();
		ida.postIdPhotoAuthenticateTestCorrectParameter();
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3907");
		head.put("uuid", "12495417");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postObtainDetailsOfDocumentPhotosTestUserIdIsError() throws Exception {
		String updateSql = "UPDATE \"T_AUTH_PHOTO\" SET \"STATUS\"='0' WHERE USER_ID = '12495417'";
		IdPhotoAuthenticateTest ida = new IdPhotoAuthenticateTest();
		ida.postIdPhotoAuthenticateTestCorrectParameter();
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 1249115417);

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3907");
		head.put("uuid", "12495417");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postObtainDetailsOfDocumentPhotosTestUserIdIllegalCharacters() throws Exception {
		String updateSql = "UPDATE \"T_AUTH_PHOTO\" SET \"STATUS\"='0' WHERE USER_ID = '12495417'";
		IdPhotoAuthenticateTest ida = new IdPhotoAuthenticateTest();
		ida.postIdPhotoAuthenticateTestCorrectParameter();
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "<@$%^&*(_>");

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3907");
		head.put("uuid", "12495417");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId数据格式不对");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postObtainDetailsOfDocumentPhotosTestUserIdIsDecimal() throws Exception {
		String updateSql = "UPDATE \"T_AUTH_PHOTO\" SET \"STATUS\"='0' WHERE USER_ID = '12495417'";
		IdPhotoAuthenticateTest ida = new IdPhotoAuthenticateTest();
		ida.postIdPhotoAuthenticateTestCorrectParameter();
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12.499);

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3907");
		head.put("uuid", "12495417");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId数据格式不对");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postObtainDetailsOfDocumentPhotosTestUserIdIsNegativeNumbe() throws Exception {
		String updateSql = "UPDATE \"T_AUTH_PHOTO\" SET \"STATUS\"='0' WHERE USER_ID = '12495417'";
		IdPhotoAuthenticateTest ida = new IdPhotoAuthenticateTest();
		ida.postIdPhotoAuthenticateTestCorrectParameter();
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -1991L);

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3907");
		head.put("uuid", "12495417");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId数据格式不对");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postObtainDetailsOfDocumentPhotosTestUserIdIsSpace() throws Exception {
		String updateSql = "UPDATE \"T_AUTH_PHOTO\" SET \"STATUS\"='0' WHERE USER_ID = '12495417'";
		IdPhotoAuthenticateTest ida = new IdPhotoAuthenticateTest();
		ida.postIdPhotoAuthenticateTestCorrectParameter();
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3907");
		head.put("uuid", "12495417");
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
		assertThat(head1.get("msg")).isEqualTo("userId数据格式不对");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postObtainDetailsOfDocumentPhotosTestUserIdIsEmpty() throws Exception {
		String updateSql = "UPDATE \"T_AUTH_PHOTO\" SET \"STATUS\"='0' WHERE USER_ID = '12495417'";
		IdPhotoAuthenticateTest ida = new IdPhotoAuthenticateTest();
		ida.postIdPhotoAuthenticateTestCorrectParameter();
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3907");
		head.put("uuid", "12495417");
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
		assertThat(head1.get("msg")).isEqualTo("userId数据格式不对");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postObtainDetailsOfDocumentPhotosTestUserIdIsNull() throws Exception {
		String updateSql = "UPDATE \"T_AUTH_PHOTO\" SET \"STATUS\"='0' WHERE USER_ID = '12495417'";
		IdPhotoAuthenticateTest ida = new IdPhotoAuthenticateTest();
		ida.postIdPhotoAuthenticateTestCorrectParameter();
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3907");
		head.put("uuid", "12495417");
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
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postObtainDetailsOfDocumentPhotosTestUserIdNonSubmissionParameters() throws Exception {
		String updateSql = "UPDATE \"T_AUTH_PHOTO\" SET \"STATUS\"='0' WHERE USER_ID = '12495417'";
		IdPhotoAuthenticateTest ida = new IdPhotoAuthenticateTest();
		ida.postIdPhotoAuthenticateTestCorrectParameter();
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3907");
		head.put("uuid", "12495417");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postObtainDetailsOfDocumentPhotosTestUserIdIsZero() throws Exception {
		String updateSql = "UPDATE \"T_AUTH_PHOTO\" SET \"STATUS\"='0' WHERE USER_ID = '12495417'";
		IdPhotoAuthenticateTest ida = new IdPhotoAuthenticateTest();
		ida.postIdPhotoAuthenticateTestCorrectParameter();
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3907");
		head.put("uuid", "12495417");
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
		assertThat(head1.get("msg")).isEqualTo("userId数据格式不对");
	}
	
	
	
		
	
}