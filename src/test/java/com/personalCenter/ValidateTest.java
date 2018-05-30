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

public class ValidateTest extends HttpUtil {
//账号查询接口
	String url = "/UU/authorize/validate";
	JSONObject body;
	String chcode;
	String uuid;
	@BeforeClass
	public void  beforeClass(){
		LoginTest login = new LoginTest();
		try {
			body = login.getLoginTestChcodeBy137();
			uuid = (body.get("userId")).toString();
			chcode = (body.get("checkCode")).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postValidateTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "13774323645");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "4801");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
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
	 * 手机号码错误
	 */
	@Test
	public void postValidateTestMobileIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "12DF0");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "4801");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println(" 手机号码错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body1 = (JSONObject) post.get("body");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(body1.get("userId")).isEqualTo(0);
	}
	/**
	 * 手机号码超长
	 */
	@Test
	public void postValidateTestMobileIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", 1377432364511111L);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "4801");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body1 = (JSONObject) post.get("body");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(body1.get("userId")).isEqualTo(0);
	}
	/**
	 * 手机号码小于11位
	 */
	@Test
	public void postValidateTestMobileLessThan11() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "137743645");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "4801");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码小于11位" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body1 = (JSONObject) post.get("body");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(body1.get("userId")).isEqualTo(0);
	}
	/**
	 * 手机号码前面加00
	 */
	@Test
	public void postValidateTestMobilePrecede00() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "0013774323645");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "4801");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码前面加00" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body1 = (JSONObject) post.get("body");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(body1.get("userId")).isEqualTo(12495079);
	}
	/**
	 * 手机号码前面加+ 86
	 */
	@Test
	public void postValidateTestMobilePrecede86() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "+8613774323645");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "4801");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码前面加+ 86" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body1 = (JSONObject) post.get("body");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(body1.get("userId")).isEqualTo(0);
	}
	/**
	 * 输入11位的固话（固话+区号）
	 */
	@Test
	public void postValidateTestMobileIsTelephone() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "02154555455");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "4801");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("输入11位的固话（固话+区号）" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body1 = (JSONObject) post.get("body");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(body1.get("userId")).isEqualTo(0);
	}
	
	/**
	 * 输入手机号码存在小数
	 */
	@Test
	public void postValidateTestMobileIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", 1325.25);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "4801");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("输入手机号码存在小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body1 = (JSONObject) post.get("body");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(body1.get("userId")).isEqualTo(0);
	}
	/**
	 * 手机号码存在负数
	 */
	@Test
	public void postValidateTestMobileIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", -123);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "4801");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码存在负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body1 = (JSONObject) post.get("body");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(body1.get("userId")).isEqualTo(0);
	}
	/**
	 * 手机号码存在非法字符
	 */
	@Test
	public void postValidateTestMobileIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "<$$%^&.>");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "4801");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码存在非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body1 = (JSONObject) post.get("body");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(body1.get("userId")).isEqualTo(0);
	}
	/**
	 * 手机号码为空
	 */
	@Test
	public void postValidateTestMobileIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", "");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "4801");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body1 = (JSONObject) post.get("body");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(body1.get("userId")).isEqualTo(0);
	}
	/**
	 * 手机号码为null
	 */
	@Test
	public void postValidateTestMobileIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", null);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "4801");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 手机号码为空格
	 */
	@Test
	public void postValidateTestmobileIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", " ");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "4801");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body1 = (JSONObject) post.get("body");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(body1.get("userId")).isEqualTo(0);
	}
	/**
	 * 手机号码不传该参数
	 */
	@Test
	public void postValidateTestMobileNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "4801");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	
	
	
}