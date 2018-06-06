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
import com.login.BackUserLoginTest;

public class GetSensitiveWordListTest extends HttpUtil {
//敏感词库列表接口
	String url = "/uu-admin/sensitiveWord/getSensitiveWordList";

	String userid;
	@BeforeClass
	public void  beforeClass(){
		userid = new BackUserLoginTest().userId;
	}
	/**
	 * 提交正确参数
	 */
	@Test
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
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
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
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
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
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 关键词为空格
	 */
	@Test
	public void postGetSensitiveWordListTestKeyWordIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", " ");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 关键词为空
	 */
	@Test
	public void postGetSensitiveWordListTestKeyWordIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
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
		assertThat(post.get("msg")).isEqualTo("没有查询到含有该关键字的敏感词");
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
		assertThat(post.get("msg")).isEqualTo("没有查询到含有该关键字的敏感词");
	}
	
	/**
	 * 每页显示记录集为非法字符
	 */
	@Test
	public void postTheUserAddressTestPageSizeIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "中国");
		request.put("pageSize", "<.@#$%>");
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 每页显示记录集为错误
	 */
	@Test
	public void postTheUserAddressTestPageSizeIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "中国");
		request.put("pageSize", 645321);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录集为小数
	 */
	@Test
	public void postGetSensitiveWordListTestPageSizeIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "中国");
		request.put("pageSize", 1.23);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录集为负数
	 */
	@Test
	public void postGetSensitiveWordListTestPageSizeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "中国");
		request.put("pageSize", -2);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录集为0
	 */
	@Test
	public void postGetSensitiveWordListTestPageSizeIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "中国");
		request.put("pageSize", 0);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录集为空格
	 */
	@Test
	public void postGetSensitiveWordListTestPageSizeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "中国");
		request.put("pageSize", " ");
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录集为空
	 */
	@Test
	public void postGetSensitiveWordListTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "中国");
		request.put("pageSize", "");
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
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
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录集为String
	 */
	@Test
	public void postGetSensitiveWordListTestPageSizeIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "中国");
		request.put("pageSize", "abc123def");
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录集不传该参数
	 */
	@Test
	public void postGetSensitiveWordListTestPageSizeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "中国");
//		request.put("pageSize", 10);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录集为超长
	 */
	@Test
	public void postGetSensitiveWordListTestPageSizeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "中国");
		request.put("pageSize", 1234567890);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 当前页数为非法字符
	 */
	@Test
	public void postTheUserAddressTestPageNowIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "中国");
		request.put("pageSize", 10);
		request.put("pageNow", "<.@#$%>");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 当前页数为错误
	 */
	@Test
	public void postTheUserAddressTestPageNowIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "中国");
		request.put("pageSize", 10);
		request.put("pageNow", 9999);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 当前页数为小数
	 */
	@Test
	public void postGetSensitiveWordListTestPageNowIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "中国");
		request.put("pageSize", 10);
		request.put("pageNow", 1.23);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页数为负数
	 */
	@Test
	public void postGetSensitiveWordListTestPageNowIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "中国");
		request.put("pageSize", 10);
		request.put("pageNow", -1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页数为0
	 */
	@Test
	public void postGetSensitiveWordListTestPageNowIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "中国");
		request.put("pageSize", 10);
		request.put("pageNow", 0);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页数为空格
	 */
	@Test
	public void postGetSensitiveWordListTestPageNowIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "中国");
		request.put("pageSize", 10);
		request.put("pageNow", " ");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页数为空
	 */
	@Test
	public void postGetSensitiveWordListTestPageNowIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "中国");
		request.put("pageSize", 10);
		request.put("pageNow", "");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页数为null
	 */
	@Test
	public void postGetSensitiveWordListTestPageNowIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "中国");
		request.put("pageSize", 10);
		request.put("pageNow", null);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页数为String
	 */
	@Test
	public void postGetSensitiveWordListTestPageNowIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "中国");
		request.put("pageSize", 10);
		request.put("pageNow", "abc123def");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页数不传该参数
	 */
	@Test
	public void postGetSensitiveWordListTestPageNowNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "中国");
		request.put("pageSize", 10);
//		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页数为超长
	 */
	@Test
	public void postGetSensitiveWordListTestPageNowIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("keyWord", "中国");
		request.put("pageSize", 10);
		request.put("pageNow", 1234567890);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	
	
}