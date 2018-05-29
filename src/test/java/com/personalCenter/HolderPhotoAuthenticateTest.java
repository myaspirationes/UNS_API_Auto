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

public class HolderPhotoAuthenticateTest extends HttpUtil {
//持件照接口
	WalletTest walletTest = new WalletTest();
	String url = "/UU/authenticate";
	String deleteSql0 = "DELETE FROM T_AUTH_JUNIOR_REAL_NAME WHERE USER_ID = 12495079";
	String deleteSql1 = "DELETE FROM t_wallet where USER_ID =12495079";
	String dataType0 = "perCenter81";
	String dataType1 = "wallet81";
	String deleteSql2 = "DELETE FROM T_AUTH_HOLD_PHOTO WHERE USER_ID = '12495079'";
	String updateSql0 = "UPDATE \"T_AUTH_HOLD_PHOTO\" SET \"STATUS\"='1' WHERE USER_ID = '12495079'";
	String updateSql1 = "UPDATE \"T_AUTH_HOLD_PHOTO\" SET \"STATUS\"='2' WHERE USER_ID = '12495079'";
	JSONObject body;
	String uuid;
	String chcode;
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
	/**
	 * 提交正确参数
	 */
	@Test
	public void postHolderPhotoAuthenticateTestCorrectParameter() throws Exception {
		walletTest.postWalletTestCorrectParameter();
		MetaOper.delete(deleteSql2, dataType0);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("holdId", 10000159);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2018-03-26 18:03:43");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("sync", "");
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("chcode", chcode);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body1 = (JSONObject) post.get("body");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(body1.get("autoMsg")).isEqualTo("持证照审核中");
	}
	/**
	 * 用户ID审核中
	 */
	@Test
	public void postHolderPhotoAuthenticateTestIsReview() throws Exception {
		walletTest.postWalletTestCorrectParameter();
		MetaOper.delete(deleteSql2, dataType0);
		WalletTest walletTest = new WalletTest();
		walletTest.postWalletTestCorrectParameter();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("holdId", 10000159);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2018-03-26 18:03:43");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", "7.0");
		head.put("sync", "");
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("chcode", chcode);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID审核中" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body1 = (JSONObject) post.get("body");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(body1.get("autoMsg")).isEqualTo("持证照审核中");
	}
	
	/**
	 * 用户ID审核成功
	 */
	@Test
	public void postHolderPhotoAuthenticateTestIsSuccess() throws Exception {
		walletTest.postWalletTestCorrectParameter();
		MetaOper.delete(deleteSql2, dataType0);
		MetaOper.update(updateSql0, dataType0);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("holdId", 10000159);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2018-03-26 18:03:43");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", "7.0");
		head.put("sync", "");
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("chcode", chcode);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID审核成功" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body1 = (JSONObject) post.get("body");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(body1.get("autoMsg")).isEqualTo("持证照审核中");
	}
	
	
	/**
	 * 用户ID审核失败
	 */
	@Test
	public void postHolderPhotoAuthenticateTestIsFail() throws Exception {
		walletTest.postWalletTestCorrectParameter();
		MetaOper.delete(deleteSql2, dataType0);
		MetaOper.update(updateSql1, dataType0);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("holdId", 10000159);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("cmd", "3906");
		head.put("de", "2018-03-26 18:03:43");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", "7.0");
		head.put("sync", "");
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("chcode", chcode);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID审核失败" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body1 = (JSONObject) post.get("body");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(body1.get("autoMsg")).isEqualTo("持证照审核中");
	}
	
	/**
	 * 持证图片ID为错误格式
	 */
	@Test
	public void postHolderPhotoAuthenticateTestholdIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("holdId", "888888");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("cmd", "106");
		head.put("de", "2018-03-26 18:03:43");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", "7.0");
		head.put("sync", "");
		head.put("aid", "lan66");
		head.put("ver", "2.1.1");
		head.put("chcode", chcode);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("持证图片ID为错误格式" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
		
		
	}
	/**
	 * 持证图片ID存在非法字符
	 */
	@Test
	public void postHolderPhotoAuthenticateTestholdIdIllegalCharacters() throws Exception {
		walletTest.postWalletTestCorrectParameter();
		MetaOper.delete(deleteSql2, dataType0);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("holdId", "<><@#$");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("cmd", "106");
		head.put("de", "2018-03-26 18:03:43");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", "7.0");
		head.put("sync", "");
		head.put("aid", "lan66");
		head.put("ver", "2.1.1");
		head.put("chcode", chcode);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("持证图片ID存在非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 持证图片ID超长字符
	 */
	@Test
	public void postHolderPhotoAuthenticateTestholdIdIsLong() throws Exception {
		walletTest.postWalletTestCorrectParameter();
		MetaOper.delete(deleteSql2, dataType0);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("holdId", 888888888);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("cmd", "106");
		head.put("de", "2018-03-26 18:03:43");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", "7.0");
		head.put("sync", "");
		head.put("aid", "lan66");
		head.put("ver", "2.1.1");
		head.put("chcode", chcode);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("持证图片ID超长字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 持证图片ID为空格
	 */
	@Test
	public void postHolderPhotoAuthenticateTestholdIdIsSpace() throws Exception {
		walletTest.postWalletTestCorrectParameter();
		MetaOper.delete(deleteSql2, dataType0);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("holdId", " ");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("cmd", "106");
		head.put("de", "2018-03-26 18:03:43");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", "7.0");
		head.put("sync", "");
		head.put("aid", "lan66");
		head.put("ver", "2.1.1");
		head.put("chcode", chcode);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("持证图片ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 持证图片ID为空
	 */
	@Test
	public void postHolderPhotoAuthenticateTestholdIdIsEmpty() throws Exception {
		walletTest.postWalletTestCorrectParameter();
		MetaOper.delete(deleteSql2, dataType0);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("holdId", "");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("cmd", "106");
		head.put("de", "2018-03-26 18:03:43");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", "7.0");
		head.put("sync", "");
		head.put("aid", "lan66");
		head.put("ver", "2.1.1");
		head.put("chcode", chcode);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("持证图片ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 持证图片ID为null
	 */
	@Test
	public void postHolderPhotoAuthenticateTestholdIdIsNull() throws Exception {
		walletTest.postWalletTestCorrectParameter();
		MetaOper.delete(deleteSql2, dataType0);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("holdId", null);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("cmd", "106");
		head.put("de", "2018-03-26 18:03:43");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", "7.0");
		head.put("sync", "");
		head.put("aid", "lan66");
		head.put("ver", "2.1.1");
		head.put("chcode", chcode);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("持证图片ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 持证图片ID不提交该参数
	 */
	@Test
	public void postHolderPhotoAuthenticateTestholdIdNonSubmissionParameters() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("cmd", "106");
		head.put("de", "2018-03-26 18:03:43");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", "7.0");
		head.put("sync", "");
		head.put("aid", "lan66");
		head.put("ver", "2.1.1");
		head.put("chcode", chcode);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("持证图片ID不提交该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postHolderPhotoAuthenticateTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("holdId", 8888888);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("cmd", "106");
		head.put("de", "2018-03-26 18:03:43");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", "7.0");
		head.put("sync", "");
		head.put("aid", "lan66");
		head.put("ver", "2.1.1");
		head.put("chcode", chcode);
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
	public void postHolderPhotoAuthenticateTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("holdId", 8888888);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("cmd", "106");
		head.put("de", "2018-03-26 18:03:43");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", "7.0");
		head.put("sync", "");
		head.put("aid", "lan66");
		head.put("ver", "2.1.1");
		head.put("chcode", chcode);
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
	public void postHolderPhotoAuthenticateTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "<>#$%^");
		con.put("holdId", 8888888);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("cmd", "106");
		head.put("de", "2018-03-26 18:03:43");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", "7.0");
		head.put("sync", "");
		head.put("aid", "lan66");
		head.put("ver", "2.1.1");
		head.put("chcode", chcode);
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
	public void postHolderPhotoAuthenticateTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495417.1);
		con.put("holdId", 8888888);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("cmd", "106");
		head.put("de", "2018-03-26 18:03:43");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", "7.0");
		head.put("sync", "");
		head.put("aid", "lan66");
		head.put("ver", "2.1.1");
		head.put("chcode", chcode);
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
	public void postHolderPhotoAuthenticateTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -12495417);
		con.put("holdId", 8888888);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("cmd", "106");
		head.put("de", "2018-03-26 18:03:43");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", "7.0");
		head.put("sync", "");
		head.put("aid", "lan66");
		head.put("ver", "2.1.1");
		head.put("chcode", chcode);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postHolderPhotoAuthenticateTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("holdId", 8888888);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("cmd", "106");
		head.put("de", "2018-03-26 18:03:43");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", "7.0");
		head.put("sync", "");
		head.put("aid", "lan66");
		head.put("ver", "2.1.1");
		head.put("chcode", chcode);
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
	public void postHolderPhotoAuthenticateTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("holdId", 8888888);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("cmd", "106");
		head.put("de", "2018-03-26 18:03:43");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", "7.0");
		head.put("sync", "");
		head.put("aid", "lan66");
		head.put("ver", "2.1.1");
		head.put("chcode", chcode);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postHolderPhotoAuthenticateTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		con.put("holdId", 8888888);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("cmd", "106");
		head.put("de", "2018-03-26 18:03:43");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", "7.0");
		head.put("sync", "");
		head.put("aid", "lan66");
		head.put("ver", "2.1.1");
		head.put("chcode", chcode);
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
	public void postHolderPhotoAuthenticateTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("holdId", 8888888);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("cmd", "106");
		head.put("de", "2018-03-26 18:03:43");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", "7.0");
		head.put("sync", "");
		head.put("aid", "lan66");
		head.put("ver", "2.1.1");
		head.put("chcode", chcode);
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
	public void postHolderPhotoAuthenticateTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
		con.put("holdId", 8888888);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("cmd", "106");
		head.put("de", "2018-03-26 18:03:43");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", "7.0");
		head.put("sync", "");
		head.put("aid", "lan66");
		head.put("ver", "2.1.1");
		head.put("chcode", chcode);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 持证图片ID为小数
	 */
	@Test
	public void postHolderPhotoAuthenticateTestHoldIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("holdId", 8888888.8);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("cmd", "106");
		head.put("de", "2018-03-26 18:03:43");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", "7.0");
		head.put("sync", "");
		head.put("aid", "lan66");
		head.put("ver", "2.1.1");
		head.put("chcode", chcode);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("持证图片ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 持证图片ID为负数
	 */
	@Test
	public void postHolderPhotoAuthenticateTestHoldIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("holdId", -8888888);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("cmd", "106");
		head.put("de", "2018-03-26 18:03:43");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", "7.0");
		head.put("sync", "");
		head.put("aid", "lan66");
		head.put("ver", "2.1.1");
		head.put("chcode", chcode);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("持证图片ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 持证图片ID为0
	 */
	@Test
	public void postHolderPhotoAuthenticateTestHoldIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("holdId", 8888888);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("mod", "(HONOR)DUK-AL20");
		head.put("mos", "7.0");
		head.put("cmd", "106");
		head.put("de", "2018-03-26 18:03:43");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", "7.0");
		head.put("sync", "");
		head.put("aid", "lan66");
		head.put("ver", "2.1.1");
		head.put("chcode", chcode);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("持证图片ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	
	
	
}