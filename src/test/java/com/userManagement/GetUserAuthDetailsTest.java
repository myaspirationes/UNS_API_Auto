package com.userManagement;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.login.BackUserLoginTest;

public class GetUserAuthDetailsTest extends HttpUtil {
// 获取用户认证详情接口
	String url = "/uu-admin/UUuserManage/getUserAuthDetails";
	String userId;
	String selectSql = "SELECT * FROM T_AUTH_JUNIOR_REAL_NAME where USER_ID = 12495005";
	List<Map<String,Object>> list ;
	String dataType = "perCenter81";
@BeforeClass
public void beforeClass(){
	 userId = new BackUserLoginTest().userId;
	 list = MetaOper.read(selectSql, dataType);
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetUserAuthDetailsTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("uid", 12495005);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("REAL_NAME").toString()).isEqualTo("张慧彪");
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postGetUserAuthDetailsTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12345678);	
		request.put("uid", 12495005);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postGetUserAuthDetailsTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12312313);	
		request.put("uid", 12495005);
		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postGetUserAuthDetailsTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<$%^>");	
		request.put("uid", 12495005);
		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postGetUserAuthDetailsTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 121123.33);
		request.put("uid", 12495005);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postGetUserAuthDetailsTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -121312);	
		request.put("uid", 12495005);
				
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postGetUserAuthDetailsTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");		
		request.put("uid", 12495005);
			
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postGetUserAuthDetailsTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");	
		request.put("uid", 12495005);
		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postGetUserAuthDetailsTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);	
		request.put("uid", 12495005);
					
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不能为空");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postGetUserAuthDetailsTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);	
		request.put("uid", 12495005);
		

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postGetUserAuthDetailsTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "fsddf");	
		request.put("uid", 12495005);
		

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postGetUserAuthDetailsTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("uid", 12495005);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不能为空");
	}
	
	/**
	 * 被查看用户ID为错误
	 */
	@Test
	public void postGetUserAuthDetailsTestUidIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);	
		request.put("uid", 12345678);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查看用户ID为错误" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 被查看用户ID超长
	 */
	@Test
	public void postGetUserAuthDetailsTestUidIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);	
		request.put("uid", 999999999999999999L);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查看用户ID超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 被查看用户ID为空
	 */
	@Test
	public void postGetUserAuthDetailsTestUidIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId",userId);	
		request.put("uid", "");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查看用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 被查看用户ID存在非法字符
	 */
	@Test
	public void postGetUserAuthDetailsTestUidIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);	
		request.put("uid", "<@$^*_>");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查看用户ID存在非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 被查看用户ID为小数
	 */
	@Test
	public void postGetUserAuthDetailsTestUidIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);	
		request.put("uid", 2.36);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查看用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 被查看用户ID为负数
	 */
	@Test
	public void postGetUserAuthDetailsTestUidIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);	
		request.put("uid", -23);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查看用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 被查看用户ID为空格
	 */
	@Test
	public void postGetUserAuthDetailsTestUidIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);	
		request.put("uid", " ");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查看用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 被查看用户ID为null
	 */
	@Test
	public void postGetUserAuthDetailsTestUidIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);	
		request.put("uid", null);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查看用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("uid不能为空");
	}
	/**
	 * 被查看用户ID为String
	 */
	@Test
	public void postGetUserAuthDetailsTestUidIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);	
		request.put("uid", "gsd");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查看用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数非法");
	}
	/**
	 * 被查看用户不传该参数
	 */
	@Test
	public void postGetUserAuthDetailsTestUidNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);	
		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("被查看用户不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("uid不能为空");
	}
	
	
}