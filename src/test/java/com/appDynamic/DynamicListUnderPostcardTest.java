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

public class DynamicListUnderPostcardTest extends HttpUtil {
//明信片下的动态列表接口
	String url = "/UU/nameCard";

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
		head.put("aid", "lan66");
		head.put("ver", "2.0.5");
		head.put("ln", "cn");
		head.put("mod", "(google)Pixel");
		head.put("mos", "7.1.2");
		head.put("de", "2017-08-12 14:40:10");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", chcode);
		head.put("cmd", 3417);
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postDynamicListUnderPostcardTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
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
	 * 用户id为错误
	 */
	@Test
	public void postDynamicListUnderPostcardTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", 124956665);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为负数
	 */
	@Test
	public void postDynamicListUnderPostcardTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", -12495396);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为小数
	 */
	@Test
	public void postDynamicListUnderPostcardTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", 1249.5396);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为String
	 */
	@Test
	public void postDynamicListUnderPostcardTestUserIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", "gfgdfdggd");
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为0
	 */
	@Test
	public void postDynamicListUnderPostcardTestUserIdIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", 0);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为空
	 */
	@Test
	public void postDynamicListUnderPostcardTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", "");
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为空格
	 */
	@Test
	public void postDynamicListUnderPostcardTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", " ");
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为null
	 */
	@Test
	public void postDynamicListUnderPostcardTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", null);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id不传参数
	 */
	@Test
	public void postDynamicListUnderPostcardTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id不传参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为超长
	 */
	@Test
	public void postDynamicListUnderPostcardTestUserIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", 999999999999999999L);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为未登录用户
	 */
	@Test
	public void postDynamicListUnderPostcardTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", 12495362);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为未登录用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页条数传负数
	 */
	@Test
	public void postDynamicListUnderPostcardTestPageSizeIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", -5);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页条数传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页条数传小数
	 */
	@Test
	public void postDynamicListUnderPostcardTestPageSizeIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 3.22);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页条数传小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页条数传0
	 */
	@Test
	public void postDynamicListUnderPostcardTestPageSizeIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 0);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页条数传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页条数传空
	 */
	@Test
	public void postDynamicListUnderPostcardTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", "");
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页条数传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页条数传空格
	 */
	@Test
	public void postDynamicListUnderPostcardTestPageSizeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", " ");
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页条数传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页条数传null
	 */
	@Test
	public void postDynamicListUnderPostcardTestPageSizeIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", null);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页条数传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页条数传String
	 */
	@Test
	public void postDynamicListUnderPostcardTestPageSizeIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", "fgfdd");
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页条数传String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页条数不传参数
	 */
	@Test
	public void postDynamicListUnderPostcardTestPageSizeNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页条数不传参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 页码传负数
	 */
	@Test
	public void postDynamicListUnderPostcardTestPageNowIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", -1);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("页码传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 页码传小数
	 */
	@Test
	public void postDynamicListUnderPostcardTestPageNowIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 2.3);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("页码传小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 页码传0
	 */
	@Test
	public void postDynamicListUnderPostcardTestPageNowIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", 0);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("页码传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 页码传空
	 */
	@Test
	public void postDynamicListUnderPostcardTestPageNowIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", "");
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("页码传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 页码传空格
	 */
	@Test
	public void postDynamicListUnderPostcardTestPageNowIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", " ");
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("页码传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 页码传null
	 */
	@Test
	public void postDynamicListUnderPostcardTestPageNowIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", null);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("页码传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 页码传传String
	 */
	@Test
	public void postDynamicListUnderPostcardTestPageNowIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", "DFDSFDS");
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("页码传传String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 页码传最大值
	 */
	@Test
	public void postDynamicListUnderPostcardTestPageNowIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", 999999999);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("页码传最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 页码不传参数
	 */
	@Test
	public void postDynamicListUnderPostcardTestPageNowNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("cardId", 1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("页码不传参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 明信片id传负数
	 */
	@Test
	public void postDynamicListUnderPostcardTestCardIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", -1234);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("明信片id传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 明信片id传小数
	 */
	@Test
	public void postDynamicListUnderPostcardTestCardIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", 12.34);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("明信片id传小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 明信片id传0
	 */
	@Test
	public void postDynamicListUnderPostcardTestCardIdIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", 0);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("明信片id传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 明信片id传空
	 */
	@Test
	public void postDynamicListUnderPostcardTestCardIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", "");
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("明信片id传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 明信片id传空格
	 */
	@Test
	public void postDynamicListUnderPostcardTestCardIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", " ");
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("明信片id传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 明信片id传null
	 */
	@Test
	public void postDynamicListUnderPostcardTestCardIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", null);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("明信片id传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 明信片id传最大值
	 */
	@Test
	public void postDynamicListUnderPostcardTestCardIdIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", 999999999999999999L);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("明信片id传最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 明信片id不传参数
	 */
	@Test
	public void postDynamicListUnderPostcardTestCardIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("targetId", 12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("明信片id不传参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 查看用户id传错误
	 */
	@Test
	public void postDynamicListUnderPostcardTestTargetIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", 124916213);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查看用户id传错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 查看用户id传小数
	 */
	@Test
	public void postDynamicListUnderPostcardTestTargetIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", 1324);
		con.put("targetId", 1249.1621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查看用户id传小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 查看用户id传负数
	 */
	@Test
	public void postDynamicListUnderPostcardTestTargetIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", "");
		con.put("targetId", -12491621);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查看用户id传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 查看用户id传0
	 */
	@Test
	public void postDynamicListUnderPostcardTestTargetIdIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查看用户id传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 查看用户id传空
	 */
	@Test
	public void postDynamicListUnderPostcardTestTargetIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", "");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查看用户id传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 查看用户id传空格
	 */
	@Test
	public void postDynamicListUnderPostcardTestTargetIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", " ");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查看用户id传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 查看用户id传null
	 */
	@Test
	public void postDynamicListUnderPostcardTestTargetIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", null);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查看用户id传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 查看用户id传String
	 */
	@Test
	public void postDynamicListUnderPostcardTestTargetIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", "FDDDGFDG");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查看用户id传String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 查看用户id传最大值
	 */
	@Test
	public void postDynamicListUnderPostcardTestTargetIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", 999999999999999999L);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查看用户id传最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 查看用户id为未登录
	 */
	@Test
	public void postDynamicListUnderPostcardTestTargetIdIsNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();

		con.put("userId", uuid);
		con.put("pageSize", 5);
		con.put("pageNow", 1);
		con.put("cardId", 1234);
		con.put("targetId", 12495555);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查看用户id为未登录" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	

}