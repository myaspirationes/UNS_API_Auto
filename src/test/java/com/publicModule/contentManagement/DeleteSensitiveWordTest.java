package com.publicModule.contentManagement;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;
import com.example.MetaOper;
//import com.example.LoginTest;
import com.publicModule.login.BackUserLoginTest;
import com.publicModule.contentManagement.AddOrEditSensitiveWordTest;
public class DeleteSensitiveWordTest extends HttpUtil {
//删除敏感词ID库接口
	String url = "/uu-admin/sensitiveWord/deleteSensitiveWord";
	String selectSql = "SELECT * FROM T_SENSITIVE_WORD WHERE SENSITIVE_NAME = '政治局'";
	List<Map<String,Object>> list ;

	String userid;	
	String sensitiveWordId;
	String dataType = "perCenter81";
	@BeforeMethod
	public void  beforeMethod() throws Exception{
		userid = new BackUserLoginTest().userId;	
		new AddOrEditSensitiveWordTest().postAddOrEditSensitiveWordTestCorrectParameter();
		list = MetaOper.read(selectSql,dataType);
		sensitiveWordId = list.get(0).get("SENSITIVE_ID").toString();
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postDeleteSensitiveWordTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", sensitiveWordId);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("删除成功");
	}
	
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postDeleteSensitiveWordTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("sensitiveWordId", sensitiveWordId);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("删除成功");
	}
	
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postDeleteSensitiveWordTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 123456);
		request.put("sensitiveWordId", sensitiveWordId);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("敏感词id错误");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postTheUserAddressTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "<.@#$%>");
		request.put("sensitiveWordId", sensitiveWordId);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postDeleteSensitiveWordTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1.23);
		request.put("sensitiveWordId", sensitiveWordId);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postDeleteSensitiveWordTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", -1);
		request.put("sensitiveWordId", sensitiveWordId);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("数据错误");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postDeleteSensitiveWordTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 0);
		request.put("sensitiveWordId", sensitiveWordId);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("删除失败,数据不正常");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postDeleteSensitiveWordTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", " ");
		request.put("sensitiveWordId", sensitiveWordId);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("删除失败,数据不正常");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postDeleteSensitiveWordTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "");
		request.put("sensitiveWordId", sensitiveWordId);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("删除失败,数据不正常");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postDeleteSensitiveWordTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", null);
		request.put("sensitiveWordId", sensitiveWordId);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("删除失败,数据不正常");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postDeleteSensitiveWordTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "abc123");
		request.put("sensitiveWordId", sensitiveWordId);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postDeleteSensitiveWordTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("sensitiveWordId", sensitiveWordId);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("删除失败,数据不正常");
	}
	/**
	 * 用户ID超长
	 */
	@Test
	public void postDeleteSensitiveWordTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1234567890);
		request.put("sensitiveWordId", sensitiveWordId);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID超长" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("数据错误");
	}
	
	/**
	 * 敏感词ID为0
	 */
	@Test
	public void postDeleteSensitiveWordTestSensitiveWordIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", 0);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词ID为0" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("删除失败,数据不正常");
	}
	/**
	 * 敏感词ID为负数
	 */
	@Test
	public void postDeleteSensitiveWordTestSensitiveWordIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", -1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词ID为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("数据错误");
	}
	/**
	 * 敏感词ID为小数
	 */
	@Test
	public void postDeleteSensitiveWordTestSensitiveWordIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", 1.23);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词ID为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("敏感词id错误");
	}
	/**
	 * 敏感词ID为String
	 */
	@Test
	public void postDeleteSensitiveWordTestSensitiveWordIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", "abc123qwe");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词ID为String" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 敏感词ID为空格
	 */
	@Test
	public void postDeleteSensitiveWordTestSensitiveWordIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", " ");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词ID为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("删除失败,数据不正常");
	}
	/**
	 * 敏感词ID为空
	 */
	@Test
	public void postDeleteSensitiveWordTestSensitiveWordIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", "");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词ID为空" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("删除失败,数据不正常");
	}
	/**
	 * 敏感词ID为null
	 */
	@Test
	public void postDeleteSensitiveWordTestSensitiveWordIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", null);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词ID为null" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("删除失败,数据不正常");
	}
	/**
	 * 敏感词ID为错误
	 */
	@Test
	public void postDeleteSensitiveWordTestSensitiveWordIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", 123);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词ID为错误" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("敏感词id错误");
	}
	/**
	 * 敏感词ID为非法字符
	 */
	@Test
	public void postDeleteSensitiveWordTestSensitiveWordIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", "<.@#$%>");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词ID为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 敏感词ID不传该参数
	 */
	@Test
	public void postDeleteSensitiveWordTestSensitiveWordIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词ID不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(1);
		assertThat(post.get("msg")).isEqualTo("删除失败,数据不正常");
	}
	/**
	 * 敏感词ID超长
	 */
	@Test
	public void postDeleteSensitiveWordTestSensitiveWordIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("sensitiveWordId", "123456789012398754656468798656165112635116254438498579866541641536");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("敏感词ID超长" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
	}
	
}