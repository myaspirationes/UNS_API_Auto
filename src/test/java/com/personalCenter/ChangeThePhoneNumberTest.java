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

public class ChangeThePhoneNumberTest extends HttpUtil {
//更改手机号码接口
	String url = "/UU/user";
	

	/**
	 * 提交正确参数
	 */
	@Test
	public void postAuthenticationManagementListTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492211);
		con.put("mobile", 13774323645L);
		con.put("checkMsg", 478193);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.0");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "8.1.0");
		head.put("mod", "(google)Nexus 5X");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("1");
		assertThat(head1.get("msg")).isEqualTo("该手机号已被注册过不允许更换");
	}
	/**
	 * 用户ID错误
	 */
	@Test
	public void postAuthenticationManagementListTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 124921125);
		con.put("mobile", 13774323645L);
		con.put("checkMsg", 478193);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.0");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "8.1.0");
		head.put("mod", "(google)Nexus 5X");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("-1");
		assertThat(head1.get("msg")).isEqualTo("账户不存在");
	}
	/**
	 * 用户id不存在
	 */
	@Test
	public void postAuthenticationManagementListTestUserIdNonExistent() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "sd212d");
		con.put("mobile", 13774323645L);
		con.put("checkMsg", 478193);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.0");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "8.1.0");
		head.put("mod", "(google)Nexus 5X");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id不存在" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("-3");
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID超长
	 */
	@Test
	public void postAuthenticationManagementListTestUserIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 1223232323323232125L);
		con.put("mobile", 13774323645L);
		con.put("checkMsg", 478193);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.0");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "8.1.0");
		head.put("mod", "(google)Nexus 5X");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id不存在" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("-1");
		assertThat(head1.get("msg")).isEqualTo("账户不存在");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postAuthenticationManagementListTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("mobile", 13774323645L);
		con.put("checkMsg", 478193);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.0");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "8.1.0");
		head.put("mod", "(google)Nexus 5X");
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
	@Test
	public void postAuthenticationManagementListTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("mobile", 13774323645L);
		con.put("checkMsg", 478193);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.0");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "8.1.0");
		head.put("mod", "(google)Nexus 5X");
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
	 * 用户ID未null
	 */
	@Test
	public void postAuthenticationManagementListTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		con.put("mobile", 13774323645L);
		con.put("checkMsg", 478193);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.0");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "8.1.0");
		head.put("mod", "(google)Nexus 5X");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID未null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID不提交
	 */
	@Test
	public void postAuthenticationManagementListTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("mobile", 13774323645L);
		con.put("checkMsg", 478193);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.0");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "8.1.0");
		head.put("mod", "(google)Nexus 5X");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不提交" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 新手机号码错误
	 */
	@Test
	public void postAuthenticationManagementListTestMobileIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("mobile", "137743236s5");
		con.put("checkMsg", 478193);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.0");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "8.1.0");
		head.put("mod", "(google)Nexus 5X");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("新手机号码错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("-3");
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 新手机号码超长
	 */
	@Test
	public void postAuthenticationManagementListTestMobileIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("mobile", 137743236111111141L);
		con.put("checkMsg", 478193);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.0");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "8.1.0");
		head.put("mod", "(google)Nexus 5X");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("新手机号码超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("-3");
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 新手机号码小于11位
	 */
	@Test
	public void postAuthenticationManagementListTestMobileLessThan11() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("mobile", 1377432345L);
		con.put("checkMsg", 478193);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.0");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "8.1.0");
		head.put("mod", "(google)Nexus 5X");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("新手机号码小于11位" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("-3");
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 手机号码前面加00
	 */
	@Test
	public void postAuthenticationManagementListTestMobilePrecede00() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("mobile", 0013774323645L);
		con.put("checkMsg", 478193);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.0");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "8.1.0");
		head.put("mod", "(google)Nexus 5X");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码前面加00" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 手机号码前面加+ 86
	 */
	@Test
	public void postAuthenticationManagementListTestMobilePrecede86() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("mobile", +8613774323645L);
		con.put("checkMsg", 478193);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.0");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "8.1.0");
		head.put("mod", "(google)Nexus 5X");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码前面加+ 86" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 输入11位的固话（固话+区号）
	 */
	@Test
	public void postAuthenticationManagementListTestMobileIsTelephone() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("mobile", 02154555455L);
		con.put("checkMsg", 478193);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.0");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "8.1.0");
		head.put("mod", "(google)Nexus 5X");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("输入11位的固话（固话+区号）" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("-3");
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 输入手机号码存在小数
	 */
	@Test
	public void postAuthenticationManagementListTestMobileIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("mobile", 1377432.1);
		con.put("checkMsg", 478193);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.0");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "8.1.0");
		head.put("mod", "(google)Nexus 5X");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("输入手机号码存在小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 手机号码存在负数
	 */
	@Test
	public void postAuthenticationManagementListTestMobileIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("mobile", -13774323);
		con.put("checkMsg", 478193);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.0");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "8.1.0");
		head.put("mod", "(google)Nexus 5X");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码存在负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 手机号码存在非法字符
	 */
	@Test
	public void postAuthenticationManagementListTestMobileIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("mobile", "<>^&*");
		con.put("checkMsg", 478193);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.0");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "8.1.0");
		head.put("mod", "(google)Nexus 5X");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码存在非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 手机号码为空
	 */
	@Test
	public void postAuthenticationManagementListTestMobileIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("mobile", "");
		con.put("checkMsg", 478193);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.0");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "8.1.0");
		head.put("mod", "(google)Nexus 5X");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 手机号码为null
	 */
	@Test
	public void postAuthenticationManagementListTestMobileIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("mobile", null);
		con.put("checkMsg", 478193);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
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
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 手机号码为空格
	 */
	@Test
	public void postAuthenticationManagementListTestMobileIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("mobile", " ");
		con.put("checkMsg", 478193);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 手机号码不传该参数
	 */
	@Test
	public void postAuthenticationManagementListTestMobileNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("checkMsg", 478193);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
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
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 查询的验证码错误
	 */
	@Test
	public void postAuthenticationManagementListTestcheckMsgIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("mobile", 13764590708L);
		con.put("checkMsg", 123123);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询的验证码错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-2);
		assertThat(head1.get("msg")).isEqualTo("验证码错误");
	}
	/**
	 * 查询的验证码为String
	 */
	@Test
	public void postAuthenticationManagementListTestCheckMsgIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("mobile", 13764590708L);
		con.put("checkMsg", "1sdas");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询的验证码为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-2);
		assertThat(head1.get("msg")).isEqualTo("验证码错误");
	}
	/**
	 * 查询的验证码超长
	 */
	@Test
	public void postAuthenticationManagementListTestcheckMsgIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("mobile", 13764590708L);
		con.put("checkMsg", 4781911113L);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询的验证码超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-2);
		assertThat(head1.get("msg")).isEqualTo("验证码错误");
	}
	/**
	 * 查询的验证码为空
	 */
	@Test
	public void postAuthenticationManagementListTestCheckMsgIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("mobile", 13764590708L);
		con.put("checkMsg", " ");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询的验证码为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-2);
		assertThat(head1.get("msg")).isEqualTo("验证码错误");
	}
	/**
	 * 查询的验证码为null
	 */
	@Test
	public void postAuthenticationManagementListTestCheckMsgIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("mobile", 13764590708L);
		con.put("checkMsg", null);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询的验证码为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-2);
		assertThat(head1.get("msg")).isEqualTo("验证码错误");
	}
	/**
	 * 查询的验证码为不存在
	 */
	@Test
	public void postAuthenticationManagementListTestCheckMsgNonExistent() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("mobile", 13764590708L);
		con.put("checkMsg", 111111);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询的验证码为不存在" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-2);
		assertThat(head1.get("msg")).isEqualTo("验证码错误");
	}
	/**
	 * 查询的验证码为小数
	 */
	@Test
	public void postAuthenticationManagementListTestCheckMsgIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("mobile", 13764590708L);
		con.put("checkMsg", 478.193);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询的验证码为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-2);
		assertThat(head1.get("msg")).isEqualTo("验证码错误");
	}
	/**
	 * 查询的验证码为负数
	 */
	@Test
	public void postAuthenticationManagementListTestCheckMsgIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("mobile", 13764590708L);
		con.put("checkMsg", -478193);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询的验证码为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-2);
		assertThat(head1.get("msg")).isEqualTo("验证码错误");
	}
	/**
	 * 查询的验证码诶空格
	 */
	@Test
	public void postAuthenticationManagementListTestCheckMsgIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("mobile", 13764590708L);
		con.put("checkMsg", " ");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("cmd", "218");
		head.put("de", "2017-08-17 16:58:08");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mos", "6.0");
		head.put("mod", "(LeEco)Le X620");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询的验证码诶空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-2);
		assertThat(head1.get("msg")).isEqualTo("验证码错误");
	}
	
	
	
}