package com.publicModule.contentManagement;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;
//import com.example.LoginTest;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;

public class AddOrEditSensitiveWordTest extends HttpUtil {
	//添加/编辑敏感词接口
	String url = "/uu-admin/sensitiveWord/addOrEditSensitiveWord";
	String datatype = "perCenter81";
	String insertSql = "INSERT INTO T_SENSITIVE_WORD (\"SENSITIVE_ID\", \"SENSITIVE_NAME\", \"TYPE\") VALUES ('18801', '政治局', '1')";
	String deleteSql = "DELETE T_SENSITIVE_WORD WHERE SENSITIVE_NAME LIKE '%政治局%'";
	String deleteSql2 = "DELETE FROM T_SENSITIVE_WORD WHERE SENSITIVE_NAME = ' '";
	String deleteSql3 = "DELETE FROM T_SENSITIVE_WORD WHERE SENSITIVE_NAME = '<.@#$%>'";
	String selectSql = "SELECT * FROM T_SENSITIVE_WORD WHERE SENSITIVE_NAME = '政治局'";

	String userid;
	String sensitiveWordId;
	@BeforeClass
	public void  beforeClass(){
		userid = new BackUserLoginTest().userId;
		
	}
	@BeforeMethod
	public void BeforeMethod(){
		MetaOper.delete(deleteSql, datatype);
	}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postAddOrEditSensitiveWordTestCorrectParameter() throws Exception {
		userid = new BackUserLoginTest().userId;
		MetaOper.delete(deleteSql, datatype);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", 0);
		request.put("sensitiveWord", "政治局");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postAddOrEditSensitiveWordTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("sensitiveWordId", 0);
		request.put("sensitiveWord", "政治局");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id数值不符合要求");
	}
	
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postAddOrEditSensitiveWordTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 123456);
		request.put("sensitiveWordId", 0);
		request.put("sensitiveWord", "政治局");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id数值不符合要求");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postTheUserAddressTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "<.@#$%>");
		request.put("sensitiveWordId", 0);
		request.put("sensitiveWord", "政治局");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postAddOrEditSensitiveWordTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1.23);
		request.put("sensitiveWordId", 0);
		request.put("sensitiveWord", "政治局");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id数值不符合要求");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postAddOrEditSensitiveWordTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", -1);
		request.put("sensitiveWordId", 0);
		request.put("sensitiveWord", "政治局");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id数值不符合要求");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postAddOrEditSensitiveWordTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 0);
		request.put("sensitiveWordId", 0);
		request.put("sensitiveWord", "政治局");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postAddOrEditSensitiveWordTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", " ");
		request.put("sensitiveWordId", 0);
		request.put("sensitiveWord", "政治局");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postAddOrEditSensitiveWordTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "");
		request.put("sensitiveWordId", 0);
		request.put("sensitiveWord", "政治局");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id数值不符合要求");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postAddOrEditSensitiveWordTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", null);
		request.put("sensitiveWordId", 0);
		request.put("sensitiveWord", "政治局");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postAddOrEditSensitiveWordTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "abc123");
		request.put("sensitiveWordId", 0);
		request.put("sensitiveWord", "政治局");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postAddOrEditSensitiveWordTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("sensitiveWordId", 0);
		request.put("sensitiveWord", "政治局");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 用户ID超长
	 */
	@Test
	public void postAddOrEditSensitiveWordTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1234567890);
		request.put("sensitiveWordId", 0);
		request.put("sensitiveWord", "政治局");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID超长" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id数值不符合要求");
	}
	
	/**
	 * 敏感词ID为0
	 */
	@Test
	public void postAddOrEditSensitiveWordTestSensitiveWordIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", 0);
		request.put("sensitiveWord", "政治局");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词ID为0" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 敏感词ID为存在的
	 */
	@Test
	public void postAddOrEditSensitiveWordTestSensitiveWordIdIsExistent() throws Exception {
		MetaOper.insert(insertSql, datatype);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql, datatype);
		sensitiveWordId = list.get(0).get("SENSITIVE_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", sensitiveWordId);
		request.put("sensitiveWord", "政治局哈哈哈789");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词ID为存在的" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("编辑成功");
	}
	/**
	 * 敏感词ID为负数
	 */
	@Test
	public void postAddOrEditSensitiveWordTestSensitiveWordIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", -1);
		request.put("sensitiveWord", "政治局");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词ID为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("敏感词id数值不符合要求");
	}
	/**
	 * 敏感词ID为小数
	 */
	@Test
	public void postAddOrEditSensitiveWordTestSensitiveWordIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", 1.23);
		request.put("sensitiveWord", "政治局");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词ID为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("编辑失败,没有找到这个敏感词");
	}
	/**
	 * 敏感词ID为String
	 */
	@Test
	public void postAddOrEditSensitiveWordTestSensitiveWordIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", "abc123qwe");
		request.put("sensitiveWord", "政治局");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词ID为String" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 敏感词ID为空格
	 */
	@Test
	public void postAddOrEditSensitiveWordTestSensitiveWordIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		MetaOper.delete(deleteSql2, datatype);
		request.put("userId", userid);
		request.put("sensitiveWordId", " ");
		request.put("sensitiveWord", "政治局");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词ID为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 敏感词ID为空
	 */
	@Test
	public void postAddOrEditSensitiveWordTestSensitiveWordIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", "");
		request.put("sensitiveWord", "政治局");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词ID为空" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 敏感词ID为null
	 */
	@Test
	public void postAddOrEditSensitiveWordTestSensitiveWordIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", null);
		request.put("sensitiveWord", "政治局");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词ID为null" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 敏感词ID为错误
	 */
	@Test
	public void postAddOrEditSensitiveWordTestSensitiveWordIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", 123);
		request.put("sensitiveWord", "政治局");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词ID为错误" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("编辑失败,没有找到这个敏感词");
	}
	/**
	 * 敏感词ID为非法字符
	 */
	@Test
	public void postAddOrEditSensitiveWordTestSensitiveWordIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", "<.@#$%>");
		request.put("sensitiveWord", "政治局");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词ID为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 敏感词ID不传该参数
	 */
	@Test
	public void postAddOrEditSensitiveWordTestSensitiveWordIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWord", "政治局");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词ID不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 敏感词ID超长
	 */
	@Test
	public void postAddOrEditSensitiveWordTestSensitiveWordIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", 1234567890);
		request.put("sensitiveWord", "政治局");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词ID超长" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("编辑失败,没有找到这个敏感词");
	}
	
	/**
	 * 敏感词为空格
	 */
	@Test
	public void postAddOrEditSensitiveWordTestSensitiveWordIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", 0);
		request.put("sensitiveWord", " ");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id数值不符合要求");
	}
	/**
	 * 敏感词为空
	 */
	@Test
	public void postAddOrEditSensitiveWordTestSensitiveWordIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", 0);
		request.put("sensitiveWord", "");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词为空" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("敏感词为空");
	}
	/**
	 * 敏感词为null
	 */
	@Test
	public void postAddOrEditSensitiveWordTestSensitiveWordIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", 0);
		request.put("sensitiveWord", null);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词为null" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("敏感词为空");
	}
	/**
	 * 敏感词为非法字符
	 */
	@Test
	public void postAddOrEditSensitiveWordTestSensitiveWordIllegalCharacters() throws Exception {
		MetaOper.delete(deleteSql3, datatype);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", 0);
		request.put("sensitiveWord", "<.@#$%>");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id数值不符合要求");
	}
	/**
	 * 敏感词不传该参数
	 */
	@Test
	public void postAddOrEditSensitiveWordTestSensitiveWordNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", 0);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("敏感词为空");
	}
	/**
	 * 敏感词超长
	 */
	@Test
	public void postAddOrEditSensitiveWordTestSensitiveWordIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", 0);
		request.put("sensitiveWord", "1234567890912903131451234567890912903131L1234567890912903131L1234567890912903131451234567890912903131L1234567890912903131L1234567890912903131451234567890912903131L1234567890912903131L1234567890912903131451234567890912903131L1234567890912903131L1234567890912903131451234567890912903131L1234567890912903131L");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词超长" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("添加失败");
	}
	/**
	 * 敏感词为存在的
	 */
	@Test
	public void postAddOrEditSensitiveWordTestSensitiveWordIsExistent() throws Exception {
		MetaOper.insert(insertSql, datatype);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", 0);
		request.put("sensitiveWord", "政治局");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词为存在的" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("不可以添加重复敏感词");
	}
	@AfterClass
	public void afterClass(){


		MetaOper.delete(deleteSql, datatype);
		MetaOper.delete(deleteSql3, datatype);
		MetaOper.delete(deleteSql2, datatype);

	}
}