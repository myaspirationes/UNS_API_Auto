package com.personalCenter;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
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

public class ObtainDetailsOfHolderPhotosTest extends HttpUtil {
//获取手持件照详情接口
	String url = "/UU/authenticate";
	String dataType = "perCenter81";
	JSONObject body;
	String uuid;
	String chcode;
	LoginTest login = new LoginTest();
	@BeforeClass
	public void  beforeClass(){
		LoginTest login = new LoginTest();
		try {
			body = login.getLoginTestChcodeBy137();
			uuid= (body.get("userId")).toString();
			chcode= (body.get("checkCode")).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//成功  1 失败2
	/**
	 * 审核中获取信息
	 */
	@Test
	public void postObtainDetailsOfHolderPhotosTestInReview() throws Exception {
		HolderPhotoAuthenticateTest hpa = new HolderPhotoAuthenticateTest();
		hpa.postHolderPhotoAuthenticateTestCorrectParameter();
		body = login.getLoginTestChcodeBy137();
		uuid= (body.get("userId")).toString();
		chcode= (body.get("checkCode")).toString();
		String updateSql = "UPDATE \"T_AUTH_HOLD_PHOTO\" SET \"STATUS\"='0' WHERE USER_ID = '12495079'";
		MetaOper.update(updateSql, dataType);

		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", 3908);
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", 1);
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核中获取信息" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body1 = (JSONObject) post.get("body");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(body1.get("statusTitle")).isEqualTo("您的照片正在审核中，请耐心等待~~");
	}
	/**
	 * 审核成功获取信息
	 */
	@Test
	public void postObtainDetailsOfHolderPhotosTestReviewSuccess() throws Exception {
		HolderPhotoAuthenticateTest hpa = new HolderPhotoAuthenticateTest();
		hpa.postHolderPhotoAuthenticateTestCorrectParameter();
		String updateSql = "UPDATE \"T_AUTH_HOLD_PHOTO\" SET \"STATUS\"='1' WHERE USER_ID = '12495079'";
		MetaOper.update(updateSql, dataType);

		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", 3908);
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", 1);
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核成功获取信息" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body1 = (JSONObject) post.get("body");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(body1.get("statusTitle")).isEqualTo("审核通过");
	}
	/**
	 * 审核失败获取信息
	 */
	@Test
	public void postObtainDetailsOfHolderPhotosTestReviewFail() throws Exception {
		HolderPhotoAuthenticateTest hpa = new HolderPhotoAuthenticateTest();
		hpa.postHolderPhotoAuthenticateTestCorrectParameter();
		String updateSql = "UPDATE \"T_AUTH_HOLD_PHOTO\" SET \"STATUS\"='2' WHERE USER_ID = '12495079'";
		MetaOper.update(updateSql, dataType);

		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", 3908);
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", 1);
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核失败获取信息" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body1 = (JSONObject) post.get("body");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(body1.get("statusTitle")).isEqualTo(null);
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postObtainDetailsOfHolderPhotosTestUserIdNotLoggedIn() throws Exception {
		HolderPhotoAuthenticateTest hpa = new HolderPhotoAuthenticateTest();
		hpa.postHolderPhotoAuthenticateTestCorrectParameter();
		String updateSql = "UPDATE \"T_AUTH_HOLD_PHOTO\" SET \"STATUS\"='1' WHERE USER_ID = '12495079'";
		MetaOper.update(updateSql, dataType);
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 1249541766);

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3908");
		head.put("uuid", uuid);
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
		assertThat(head1.get("msg")).isEqualTo("数据为空");
	}
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postObtainDetailsOfHolderPhotosTestUserIdIsError() throws Exception {
		HolderPhotoAuthenticateTest hpa = new HolderPhotoAuthenticateTest();
		hpa.postHolderPhotoAuthenticateTestCorrectParameter();
		String updateSql = "UPDATE \"T_AUTH_HOLD_PHOTO\" SET \"STATUS\"='1' WHERE USER_ID = '12495079'";
		MetaOper.update(updateSql, dataType);
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 1249541756);

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3908");
		head.put("uuid", uuid);
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
		assertThat(head1.get("msg")).isEqualTo("数据为空");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postObtainDetailsOfHolderPhotosTestUserIdIllegalCharacters() throws Exception {
		HolderPhotoAuthenticateTest hpa = new HolderPhotoAuthenticateTest();
		hpa.postHolderPhotoAuthenticateTestCorrectParameter();
		String updateSql = "UPDATE \"T_AUTH_HOLD_PHOTO\" SET \"STATUS\"='1' WHERE USER_ID = '12495079'";
		MetaOper.update(updateSql, dataType);
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "<@$%^&*(_>");

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3908");
		head.put("uuid", uuid);
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
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postObtainDetailsOfHolderPhotosTestUserIdIsDecimal() throws Exception {
		HolderPhotoAuthenticateTest hpa = new HolderPhotoAuthenticateTest();
		hpa.postHolderPhotoAuthenticateTestCorrectParameter();
		String updateSql = "UPDATE \"T_AUTH_HOLD_PHOTO\" SET \"STATUS\"='1' WHERE USER_ID = '12495079'";
		MetaOper.update(updateSql, dataType);
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12.499);

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3908");
		head.put("uuid", uuid);
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
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postObtainDetailsOfHolderPhotosTestUserIdIsNegativeNumbe() throws Exception {
		HolderPhotoAuthenticateTest hpa = new HolderPhotoAuthenticateTest();
		hpa.postHolderPhotoAuthenticateTestCorrectParameter();
		String updateSql = "UPDATE \"T_AUTH_HOLD_PHOTO\" SET \"STATUS\"='1' WHERE USER_ID = '12495079'";
		MetaOper.update(updateSql, dataType);
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -1991L);

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3908");
		head.put("uuid", uuid);
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
		assertThat(head1.get("msg")).isEqualTo("请输入有效的用户id");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postObtainDetailsOfHolderPhotosTestUserIdIsSpace() throws Exception {
		HolderPhotoAuthenticateTest hpa = new HolderPhotoAuthenticateTest();
		hpa.postHolderPhotoAuthenticateTestCorrectParameter();
		String updateSql = "UPDATE \"T_AUTH_HOLD_PHOTO\" SET \"STATUS\"='1' WHERE USER_ID = '12495079'";
		MetaOper.update(updateSql, dataType);
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3908");
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
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postObtainDetailsOfHolderPhotosTestUserIdIsEmpty() throws Exception {
		HolderPhotoAuthenticateTest hpa = new HolderPhotoAuthenticateTest();
		hpa.postHolderPhotoAuthenticateTestCorrectParameter();
		String updateSql = "UPDATE \"T_AUTH_HOLD_PHOTO\" SET \"STATUS\"='1' WHERE USER_ID = '12495079'";
		MetaOper.update(updateSql, dataType);
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3908");
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
		assertThat(head1.get("msg")).isEqualTo("请输入有效的用户id");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postObtainDetailsOfHolderPhotosTestUserIdIsNull() throws Exception {
		HolderPhotoAuthenticateTest hpa = new HolderPhotoAuthenticateTest();
		hpa.postHolderPhotoAuthenticateTestCorrectParameter();
		String updateSql = "UPDATE \"T_AUTH_HOLD_PHOTO\" SET \"STATUS\"='1' WHERE USER_ID = '12495079'";
		MetaOper.update(updateSql, dataType);
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3908");
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
		assertThat(head1.get("msg")).isEqualTo("请输入有效的用户id");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postObtainDetailsOfHolderPhotosTestUserIdNonSubmissionParameters() throws Exception {
		HolderPhotoAuthenticateTest hpa = new HolderPhotoAuthenticateTest();
		hpa.postHolderPhotoAuthenticateTestCorrectParameter();
		String updateSql = "UPDATE \"T_AUTH_HOLD_PHOTO\" SET \"STATUS\"='1' WHERE USER_ID = '12495079'";
		MetaOper.update(updateSql, dataType);
		
		Map<String, Object> con = new HashMap<String, Object>();
		

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3908");
		head.put("uuid", uuid);
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
		assertThat(head1.get("msg")).isEqualTo("请输入有效的用户id");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postObtainDetailsOfHolderPhotosTestUserIdIsZero() throws Exception {
		HolderPhotoAuthenticateTest hpa = new HolderPhotoAuthenticateTest();
		hpa.postHolderPhotoAuthenticateTestCorrectParameter();
		String updateSql = "UPDATE \"T_AUTH_HOLD_PHOTO\" SET \"STATUS\"='1' WHERE USER_ID = '12495079'";
		MetaOper.update(updateSql, dataType);
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3908");
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
		assertThat(head1.get("msg")).isEqualTo("请输入有效的用户id");
	}
	
	
	
		
	
}