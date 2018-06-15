package com.systemManagement;

import com.example.HttpUtil;
import com.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class GetManagerParaListTest extends HttpUtil {
// 获取参数管理列表接口
	String url = "/uu-admin/SystemManager/getManagerParaList";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetManagerParaListTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");
		request.put("status", 1);
		request.put("pageSize",1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID未登录
	 */
	@Test
	public void postGetManagerParaListTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");
		request.put("status", 1);
		request.put("pageSize",1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID未登录" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为错误ID
	 */
	@Test
	public void postGetManagerParaListTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",54145450);
		request.put("keyWords", "超级管理员");
		request.put("status", 1);
		request.put("pageSize",1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误ID" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不存在数据库中");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postGetManagerParaListTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "!@@#@##$@");
		request.put("keyWords", "超级管理员");
		request.put("status", 1);
		request.put("pageSize",1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postGetManagerParaListTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 5263.155);
		request.put("keyWords", "超级管理员");
		request.put("status", 1);
		request.put("pageSize",1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postGetManagerParaListTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -5515225);
		request.put("keyWords", "超级管理员");
		request.put("status", 1);
		request.put("pageSize",1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不存在数据库中");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postGetManagerParaListTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);
		request.put("keyWords", "超级管理员");
		request.put("status", 1);
		request.put("pageSize",1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不存在数据库中");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postGetManagerParaListTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "sdfsdfdsf");
		request.put("keyWords", "超级管理员");
		request.put("status", 1);
		request.put("pageSize",1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postGetManagerParaListTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "   ");
		request.put("keyWords", "超级管理员");
		request.put("status", 1);
		request.put("pageSize",1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postGetManagerParaListTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId","");
		request.put("keyWords", "超级管理员");
		request.put("status", 1);
		request.put("pageSize",1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId为空");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postGetManagerParaListTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("keyWords", "超级管理员");
		request.put("status", 1);
		request.put("pageSize",1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId为空");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postGetManagerParaListTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		
		request.put("keyWords", "超级管理员");
		request.put("status", 1);
		request.put("pageSize",1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId为空");
	}
	/**
	 * 关键字为错误
	 */
	@Test
	public void postGetManagerParaListTestKeyWordsIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "gdfddfgdf");
		request.put("status", 1);
		request.put("pageSize",1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键字为错误" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 关键字为非法字符
	 */
	@Test
	public void postGetManagerParaListTestKeyWordsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "!@#$#@$@");
		request.put("status", 1);
		request.put("pageSize",1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键字为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 关键字为空格
	 */
	@Test
	public void postGetManagerParaListTestKeyWordsIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "  ");
		request.put("status", 1);
		request.put("pageSize",1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键字为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 关键字为空
	 * 
	 */
	@Test
	public void postGetManagerParaListTestKeyWordsIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "");
		request.put("status", 1);
		request.put("pageSize",1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键字为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 关键字为null
	 */
	@Test
	public void postGetManagerParaListTestKeyWordsIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", null);
		request.put("status", 1);
		request.put("pageSize",1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键字为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 关键字不传该参数
	 */
	@Test
	public void postGetManagerParaListTestKeyWordsNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		
		request.put("status", 1);
		request.put("pageSize",1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键字不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 关键字为超长
	 */
	@Test
	public void postGetManagerParaListTestKeyWordsIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "135564548431464464564485146L");
		request.put("status", 1);
		request.put("pageSize",1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键字为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 查询状态为错误
	 */
	@Test
	public void postGetManagerParaListTestStatusIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");		
		request.put("status", 9999);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询状态为错误" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 查询状态为非法字符
	 */
	@Test
	public void postGetManagerParaListTestStatusIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");
		request.put("status", "<.@%$^>");
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询状态为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 查询状态为空
	 */
	@Test
	public void postGetManagerParaListTestStatusIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");
		request.put("status", "");
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询状态为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 查询状态为空格
	 */
	@Test
	public void postGetManagerParaListTestStatusIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");
		request.put("status", " ");
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询状态为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 查询状态为String
	 */
	@Test
	public void postGetManagerParaListTestStatusIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");		
		request.put("status", "aa");
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询状态为String" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 查询状态为null
	 */
	@Test
	public void postGetManagerParaListTestStatusIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");
		request.put("status", null);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询状态为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 查询状态不传该参数
	 */
	@Test
	public void postGetManagerParaListTestStatusNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");	
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询状态不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 查询状态为小数
	 */
	@Test
	public void postGetManagerParaListTestStatusIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");	
		request.put("status", 2.9);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询状态为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 查询状态为负数
	 */
	@Test
	public void postGetManagerParaListTestStatusIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");		
		request.put("status", -2);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询状态为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 查询状态为0
	 */
	@Test
	public void postGetManagerParaListTestStatusIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");	
		request.put("status", 0);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询状态为0" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 查询状态为1
	 */
	@Test
	public void postGetManagerParaListTestStatusIsOne() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");	
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询状态名称为1" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页获取条数为0
	 */
	@Test
	public void postGetManagerParaListTestPageSizeIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");		
		request.put("status", 2);
		request.put("pageSize", 0);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页获取条数为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("user名或者pagesize或pagenow格式不正确");
	}
	/**
	 * 每页获取条数为负数
	 */
	@Test
	public void postGetManagerParaListTestPageSizeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");
		request.put("status", 2);
		request.put("pageSize", -1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页获取条数为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("user名或者pagesize或pagenow格式不正确");
	}
	/**
	 * 每页获取条数为小数
	 */
	@Test
	public void postGetManagerParaListTestPageSizeIsIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");	
		request.put("status", 2);
		request.put("pageSize", 1.1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页获取条数为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("user名或者pagesize或pagenow格式不正确");
	}
	/**
	 * 每页获取条数为String
	 */
	@Test
	public void postGetManagerParaListTestPageSizeIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");	
		request.put("status", 2);
		request.put("pageSize", "aaa");
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页获取条数为String" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("user名或者pagesize或pagenow格式不正确");
	}
	/**
	 * 每页获取条数为空格
	 */
	@Test
	public void postGetManagerParaListTestPageSizeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");	
		request.put("status", 2);
		request.put("pageSize", " ");
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页获取条数为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("user名或者pagesize或pagenow格式不正确");
	}
	/**
	 * 每页获取条数为空
	 */
	@Test
	public void postGetManagerParaListTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");	
		request.put("status", 2);
		request.put("pageSize", "");
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页获取条数为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("pageSize为空");
	}
	/**
	 * 每页获取条数为null
	 */
	@Test
	public void postGetManagerParaListTestPageSizeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");	
		request.put("status", 2);
		request.put("pageSize", null);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页获取条数为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("pageSize为空");
	}
	/**
	 * 每页获取条数为超长
	 */
	@Test
	public void postGetManagerParaListTestPageSizeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");	
		request.put("status", 2);
		request.put("pageSize", -1);
		request.put("pageNow", 1111111111111111111L);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页获取条数为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("user名或者pagesize或pagenow格式不正确");
	}
	/**
	 * 每页获取条数为非法字符
	 */
	@Test
	public void postGetManagerParaListTestPageSizeIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");		
		request.put("status", 2);
		request.put("pageSize","dsffsfdsfs");
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页获取条数为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("user名或者pagesize或pagenow格式不正确");
	}
	/**
	 * 每页获取条数不传该参数
	 */
	@Test
	public void postGetManagerParaListTestPageSizeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");	
		request.put("status", 2);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页获取条数不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("pageSize为空");
	}
	/**
	 * 当前页数为0
	 */
	@Test
	public void postGetManagerParaListTestPageNowIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("user名或者pagesize或pagenow格式不正确");
	}
	/**
	 * 当前页数为负数
	 */
	@Test
	public void postGetManagerParaListTestPageNowIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");	
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", -1);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("user名或者pagesize或pagenow格式不正确");
	}
	/**
	 * 当前页数为小数
	 */
	@Test
	public void postGetManagerParaListTestPageNowIsIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 23.01);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("user名或者pagesize或pagenow格式不正确");
	}
	/**
	 * 当前页数为String
	 */
	@Test
	public void postGetManagerParaListTestPageNowIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");	
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", "sfsdfsdfs");		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为String" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("user名或者pagesize或pagenow格式不正确");
	}
	/**
	 * 当前页数为空格
	 */
	@Test
	public void postGetManagerParaListTestPageNowIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");	
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow","  ");		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("user名或者pagesize或pagenow格式不正确");
	}
	/**
	 * 当前页数为空
	 */
	@Test
	public void postGetManagerParaListTestPageNowIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", "");		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("pageNow为空");
	}
	/**
	 * 当前页数为null
	 */
	@Test
	public void postGetManagerParaListTestPageNowIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");	
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", null);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("pageNow为空");
	}
	/**
	 * 当前页数为超长
	 */
	@Test
	public void postGetManagerParaListTestPageNowIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");	
		request.put("status", 2);
		request.put("pageSize", 1);
		request.put("pageNow", 999999999999999999L);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 当前页数为非法字符
	 */
	@Test
	public void postGetManagerParaListTestpageNowIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");		
		request.put("status", 2);
		request.put("pageSize",1);
		request.put("pageNow", "dsfdfsdf");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("user名或者pagesize或pagenow格式不正确");
	}
	/**
	 * 当前页数不传该参数
	 */
	@Test
	public void postGetManagerParaListTestPageNowNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWords", "超级管理员");	
		request.put("status", 2);
		request.put("pageSize", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("pageNow为空");
	}
	
}
