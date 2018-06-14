package com.contentManagement;

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

public class GetSensitiveWordListTest extends HttpUtil {
//敏感词库列表接口
	String url = "/uu-admin/sensitiveWord/getSensitiveWordList";

	String chcode;
	@BeforeClass
	public void  beforeClass(){
	}
	/**
	 * 提交正确参数
	 */
	@Test
<<<<<<< HEAD
	public void postGetSensitiveWordListTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "中国");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postGetSensitiveWordListTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("keyWord", "中国");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postGetSensitiveWordListTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 9876);
		request.put("keyWord", "中国");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postTheUserAddressTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "<.@#$%>");
		request.put("keyWord", "中国");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postGetSensitiveWordListTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1.23);
		request.put("keyWord", "中国");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postGetSensitiveWordListTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", -1);
		request.put("keyWord", "中国");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postGetSensitiveWordListTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 0);
		request.put("keyWord", "中国");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postGetSensitiveWordListTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", " ");
		request.put("keyWord", "中国");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postGetSensitiveWordListTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "");
		request.put("keyWord", "中国");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postGetSensitiveWordListTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", null);
		request.put("keyWord", "中国");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postGetSensitiveWordListTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "abc123def");
		request.put("keyWord", "中国");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postGetSensitiveWordListTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
//		request.put("userId", userid);
		request.put("keyWord", "中国");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID超长
	 */
	@Test
	public void postGetSensitiveWordListTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1234567890);
		request.put("keyWord", "中国");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
=======
	public void postTheUserAddressTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
>>>>>>> 3799bad522fa1157f03cc0d0797caf06bd4d9db3
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan6uu");
		head.put("ver", "1.2.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("cmd", 4504);
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
<<<<<<< HEAD
	 * 关键词为null
	 */
	@Test
	public void postGetSensitiveWordListTestKeyWordIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", null);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 关键词为非法字符
	 */
	@Test
	public void postGetSensitiveWordListTestKeyWordIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "<.@#$%>");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 关键词不传该参数
	 */
	@Test
	public void postGetSensitiveWordListTestKeyWordNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("keyWord", "中国");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 关键词超长
	 */
	@Test
	public void postGetSensitiveWordListTestKeyWordIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", 1234567890);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 每页显示记录集为非法字符
=======
	 * 用户ID为未登录用户
>>>>>>> 3799bad522fa1157f03cc0d0797caf06bd4d9db3
	 */
	@Test
	public void postTheUserAddressTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12312313);
		
	
<<<<<<< HEAD
		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 每页显示记录集为错误
	 */
	@Test
	public void postTheUserAddressTestPageSizeIsError() throws Exception {
=======
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan6uu");
		head.put("ver", "1.2.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", chcode);
		head.put("cmd", 4504);
>>>>>>> 3799bad522fa1157f03cc0d0797caf06bd4d9db3
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postTheUserAddressTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12312sd313");
		
	
<<<<<<< HEAD
		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 每页显示记录集为0
	 */
	@Test
	public void postGetSensitiveWordListTestPageSizeIsZero() throws Exception {
=======
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan6uu");
		head.put("ver", "1.2.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", chcode);
		head.put("cmd", 4504);
>>>>>>> 3799bad522fa1157f03cc0d0797caf06bd4d9db3
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
<<<<<<< HEAD
		assertThat(post.get("status")).isEqualTo(500);
=======
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
>>>>>>> 3799bad522fa1157f03cc0d0797caf06bd4d9db3
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postTheUserAddressTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "<$%^>");
		
	
<<<<<<< HEAD
		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 每页显示记录集为空
	 */
	@Test
	public void postGetSensitiveWordListTestPageSizeIsEmpty() throws Exception {
=======
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan6uu");
		head.put("ver", "1.2.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", chcode);
		head.put("cmd", 4504);
>>>>>>> 3799bad522fa1157f03cc0d0797caf06bd4d9db3
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
<<<<<<< HEAD
		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 每页显示记录集为null
	 */
	@Test
	public void postGetSensitiveWordListTestPageSizeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "中国");
		request.put("pageSize", null);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 每页显示记录集为String
=======
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 用户ID为小数
>>>>>>> 3799bad522fa1157f03cc0d0797caf06bd4d9db3
	 */
	@Test
	public void postTheUserAddressTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12123123.33);
		
	
<<<<<<< HEAD
		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 每页显示记录集不传该参数
	 */
	@Test
	public void postGetSensitiveWordListTestPageSizeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "中国");
		request.put("pageNow", 1);
=======
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan6uu");
		head.put("ver", "1.2.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", chcode);
		head.put("cmd", 4504);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
>>>>>>> 3799bad522fa1157f03cc0d0797caf06bd4d9db3
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 用户ID为负数
	 */
	//@Test
	public void postTheUserAddressTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -121312);
		
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan6uu");
		head.put("ver", "1.2.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", chcode);
		head.put("cmd", 4504);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
<<<<<<< HEAD
		assertThat(post.get("status")).isEqualTo(400);
=======
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
>>>>>>> 3799bad522fa1157f03cc0d0797caf06bd4d9db3
	}
	/**
	 * 用户ID为0
	 */
<<<<<<< HEAD
	@Test
	public void postTheUserAddressTestPageNowIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "中国");
		request.put("pageSize", 10);
		request.put("pageNow", 987654321L);
=======
	//@Test
	public void postTheUserAddressTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
>>>>>>> 3799bad522fa1157f03cc0d0797caf06bd4d9db3
		
	
<<<<<<< HEAD
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("没有查询到含有该关键字的敏感词");
	}
	/**
	 * 当前页数为小数
	 */
	@Test
	public void postGetSensitiveWordListTestPageNowIsDecimal() throws Exception {
=======
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan6uu");
		head.put("ver", "1.2.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", chcode);
		head.put("cmd", 4504);
>>>>>>> 3799bad522fa1157f03cc0d0797caf06bd4d9db3
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postTheUserAddressTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		
	
<<<<<<< HEAD
		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 当前页数为0
	 */
	@Test
	public void postGetSensitiveWordListTestPageNowIsZero() throws Exception {
=======
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan6uu");
		head.put("ver", "1.2.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", chcode);
		head.put("cmd", 4504);
>>>>>>> 3799bad522fa1157f03cc0d0797caf06bd4d9db3
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
<<<<<<< HEAD
		assertThat(post.get("status")).isEqualTo(500);
=======
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
>>>>>>> 3799bad522fa1157f03cc0d0797caf06bd4d9db3
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postTheUserAddressTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		
	
<<<<<<< HEAD
		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 当前页数为空
	 */
	@Test
	public void postGetSensitiveWordListTestPageNowIsEmpty() throws Exception {
=======
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan6uu");
		head.put("ver", "1.2.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", chcode);
		head.put("cmd", 4504);
>>>>>>> 3799bad522fa1157f03cc0d0797caf06bd4d9db3
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
<<<<<<< HEAD
		assertThat(post.get("status")).isEqualTo(500);
=======
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
>>>>>>> 3799bad522fa1157f03cc0d0797caf06bd4d9db3
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postTheUserAddressTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
	
<<<<<<< HEAD
		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 当前页数为String
	 */
	@Test
	public void postGetSensitiveWordListTestPageNowIsString() throws Exception {
=======
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan6uu");
		head.put("ver", "1.2.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", chcode);
		head.put("cmd", 4504);
>>>>>>> 3799bad522fa1157f03cc0d0797caf06bd4d9db3
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
<<<<<<< HEAD
		assertThat(post.get("status")).isEqualTo(400);
=======
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
>>>>>>> 3799bad522fa1157f03cc0d0797caf06bd4d9db3
	}
	/**
	 * 用户ID超长
	 */
	@Test
	public void postTheUserAddressTestUserIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "123313546846846165687987984651513213135687987451513213565687879845115354548787413546222");
		
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan6uu");
		head.put("ver", "1.2.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", 12495324);
		head.put("chcode", chcode);
		head.put("cmd", 4504);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
<<<<<<< HEAD
		assertThat(post.get("status")).isEqualTo(500);
=======
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
>>>>>>> 3799bad522fa1157f03cc0d0797caf06bd4d9db3
	}
	
	
	
}