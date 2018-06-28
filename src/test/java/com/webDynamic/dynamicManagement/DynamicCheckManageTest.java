package com.webDynamic.dynamicManagement;

import com.appDynamic.DynamicCommentTest;
import com.appDynamic.PublishDynamicsTest;
import com.example.HttpUtil;
import com.example.LoginTest;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;



public class DynamicCheckManageTest extends HttpUtil {
//动态审核处理接口
	String url = "/uu-admin/dynamicManage/dynamicAudit";
	String selectSql = "SELECT * FROM T_DYNAMIC WHERE DESCRIPTION = '自动化测试' ";
	String deleteSql = "DELETE FROM T_DYNAMIC WHERE DESCRIPTION = '自动化测试' or USER_ID = 12495396";
	String selDispose = "SELECT * FROM T_USER_DISPOSE WHERE DISPOSE_EXPLAIN = '自动化测试' OR DISPOSE_EXPLAIN = '<@#@$@#%%>' OR DISPOSEED_USER_ID = '12495396'";
	String delDispose = "DELETE FROM T_USER_DISPOSE WHERE DISPOSE_EXPLAIN = '自动化测试' OR DISPOSE_EXPLAIN = '<@#@$@#%%>' OR DISPOSEED_USER_ID = '12495396'";
	String dataType = "perCenter81";
	String dynamicId ;
	List<Map<String,Object>> list ;
	BackUserLoginTest login = new BackUserLoginTest();
	String userId=login.userId;
	@BeforeMethod
	public void  beforeMethod() throws Exception {
		new PublishDynamicsTest().postPublishDynamicsTestCorrectParameter();
		list = MetaOper.read(selectSql, dataType);
		dynamicId = list.get(0).get("DYNAMIC_ID").toString();
	}
	@AfterMethod
	public void afterMethod()
	{
		MetaOper.delete(deleteSql, dataType);
		MetaOper.delete(delDispose, dataType);
	}
	@AfterClass
	public void afterClass(){
		MetaOper.delete(deleteSql, dataType);
		MetaOper.delete(delDispose, dataType);
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postDynamicCheckManageTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 10000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list =MetaOper.read(selDispose,dataType);
		assertThat(list.get(0).get("DISPOSE_SOURCE").toString()).isEqualTo("1");
		assertThat(list.get(0).get("DISPOSE_OPERATION").toString()).isEqualTo("0");
		assertThat(list.get(0).get("DISPOSE_OPINION").toString()).isEqualTo("0");
		assertThat(list.get(0).get("DISPOSE_EXPLAIN").toString()).isEqualTo("自动化测试");
		assertThat(list.get(0).get("DISPOSE_USER").toString()).isEqualTo("admin");
	}
	/**
	 * 操作用户ID为小数
	 */
	@Test
	public void postDynamicCheckManageTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1.1);
		request.put("dynamicId", dynamicId);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为小数" + post);
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postDynamicCheckManageTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", -1);
		request.put("dynamicId", dynamicId);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为负数" + post);		
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id或动态id错误");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postDynamicCheckManageTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 0);
		request.put("dynamicId", dynamicId);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为0" + post);
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id或动态id错误");
	}
	/**
	 * 用户ID为错误
	 */
	@Test
	public void postDynamicCheckManageTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 123);
		request.put("dynamicId", dynamicId);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为错误" + post);
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 用户ID未登录
	 */
	@Test
	public void postDynamicCheckManageTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 10000016);
		request.put("dynamicId", dynamicId);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID未登录" + post);		 
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 用户ID为字符串
	 */
	@Test
	public void postDynamicCheckManageTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "1dfsd000");
		request.put("dynamicId", dynamicId);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID" + post);
		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postDynamicCheckManageTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", null);
		request.put("dynamicId", dynamicId);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为null" + post);
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("数据为空");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postDynamicCheckManageTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "");
		request.put("dynamicId", dynamicId);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为空" + post);
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("数据为空");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postDynamicCheckManageTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", " ");
		request.put("dynamicId", dynamicId);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为空格" + post);
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("数据为空");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postDynamicCheckManageTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 123123123123123L);
		request.put("dynamicId", dynamicId);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为超长" + post);
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id或动态id错误");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postDynamicCheckManageTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID不传该参数" + post);
    	assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("数据为空");
	}
	/**
	 * 动态id为错误
	 */
	@Test
	public void postDynamicCheckManageTestDynamicIdIsError() throws Exception {
		new DynamicCommentTest().postDynamicCommentTestCorrectParameter();
		list = MetaOper.read("SELECT * FROM T_COMMENTBACK WHERE CONTENT = '自动化评论'", dataType);
		dynamicId = list.get(0).get("COMMENT_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id为错误" + post);
    	assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
		//list =MetaOper.read(selDispose,dataType);
		//assertThat(list.get(0).get("DISPOSE_SOURCE").toString()).isEqualTo("2");
		
	}
	/**
	 * 动态id为负数
	 */
	@Test
	public void postDynamicCheckManageTestDynamicIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", -1234);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id为负数" + post);
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id或动态id错误");
	}
	/**
	 * 动态id为小数
	 */
	@Test
	public void postDynamicCheckManageTestDynamicIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", 11.41);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id为小数" + post);
		 

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 动态id为String
	 */
	@Test
	public void postDynamicCheckManageTestDynamicIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", "hgfhgf");
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id为String" + post);
		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态id为0
	 */
	@Test
	public void postDynamicCheckManageTestDynamicIdIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", 0);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id为0" + post);
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id或动态id错误");
	}
	/**
	 * 动态id为空
	 */
	@Test
	public void postDynamicCheckManageTestDynamicIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", "");
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id为空" + post);
		assertThat(post.get("status")).isEqualTo(500);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态id为空格
	 */
	@Test
	public void postDynamicCheckManageTestDynamicIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", " ");
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id为空格" + post);
		 

		assertThat(post.get("status")).isEqualTo(500);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态id为null
	 */
	@Test
	public void postDynamicCheckManageTestDynamicIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", null);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id为null" + post);
		 

		assertThat(post.get("status")).isEqualTo(500);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态id不传参数
	 */
	@Test
	public void postDynamicCheckManageTestDynamicIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id不传参数" + post);
		 

		assertThat(post.get("status")).isEqualTo(500);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态id为超长
	 */
	@Test
	public void postDynamicCheckManageTestDynamicIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", 999999999999999999L);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态id为超长" + post);
		 

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id或动态id错误");
	}
	/**
	 * 处理人传错误
	 */
	@Test
	public void postDynamicCheckManageTestUserNameIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "测试");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理人传错误" + post);
		 

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 处理人传超长
	 */
	@Test
	public void postDynamicCheckManageTestUserNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin代表进空间看看进步空间看尽可能你考虑进来快捷键零零进来看看吗， 接口脚。");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理人传超长" + post);
		 

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 处理人传空
	 */
	@Test
	public void postDynamicCheckManageTestUserNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理人传空" + post);
		 

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 处理人传空格
	 */
	@Test
	public void postDynamicCheckManageTestUserNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", " ");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理人传空格" + post);
		 

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("数据为空");
	}
	/**
	 * 处理人传null
	 */
	@Test
	public void postDynamicCheckManageTestUserNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", null);
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理人传null" + post);
		 

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("数据为空");
	}
	/**
	 * 处理人不传参数
	 */
	@Test
	public void postDynamicCheckManageTestUserNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理人不传参数" + post);
		 

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("数据为空");
	}
	/**
	 * 处理说明传超长
	 */
	@Test
	public void postDynamicCheckManageTestDioposeExpiainIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试df发射点犯得上看见了将来可能你的机会迪斯科解放单反决定开发贷款累计");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理说明传超长" + post);
		 

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 处理说明传非法字符
	 */
	@Test
	public void postDynamicCheckManageTestDioposeExpiainIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "<@#@$@#%%>");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理说明传非法字符" + post);		 
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list =MetaOper.read(selDispose,dataType);
		assertThat(list.get(0).get("DISPOSE_EXPLAIN").toString()).isEqualTo("<@#@$@#%%>");
	}
	/**
	 * 处理说明传空
	 */
	@Test
	public void postDynamicCheckManageTestDioposeExpiainIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理说明传空" + post);
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
		list =MetaOper.read(selDispose,dataType);
		assertThat(list.get(0).get("DISPOSE_EXPLAIN")).isEqualTo(null);
	}
	/**
	 * 处理说明传空格
	 */
	@Test
	public void postDynamicCheckManageTestDioposeExpiainIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", " ");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理说明传空格" + post);
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
		list =MetaOper.read(selDispose,dataType);
		assertThat(list.get(0).get("DISPOSE_EXPLAIN").toString()).isEqualTo(" ");
	}
	/**
	 * 处理说明传null
	 */
	@Test
	public void postDynamicCheckManageTestDioposeExpiainIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", null);
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理说明传null" + post);
		 

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
		list =MetaOper.read(selDispose,dataType);
		assertThat(list.get(0).get("DISPOSE_EXPLAIN")).isEqualTo(null);
	}
	/**
	 * 处理说明不传
	 */
	@Test
	public void postDynamicCheckManageTestDioposeExpiainNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 10000000);
		request.put("userName", "admin");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理说明不传" + post);
		 

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
		list =MetaOper.read(selDispose,dataType);
		assertThat(list.get(0).get("DISPOSE_EXPLAIN")).isEqualTo(null);
	}
	/**
	 * 处理意见为错误
	 */
	@Test
	public void postDynamicCheckManageTestDioposeOpinionIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 5);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为错误" + post);
		 

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	/**
	 * 处理意见传空
	 */
	@Test
	public void postDynamicCheckManageTestDioposeOpinionIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", "");
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见传空" + post);
		 

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 处理意见传空格
	 */
	@Test
	public void postDynamicCheckManageTestDioposeOpinionIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", " ");
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见传空格" + post);
		 

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 处理意见传null
	 */
	@Test
	public void postDynamicCheckManageTestDioposeOpinionIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", null);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见传null" + post);
		 

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 处理意见传String
	 */
	@Test
	public void postDynamicCheckManageTestDioposeOpinionIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", "DFDSFDD");
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见传String" + post);
		 

		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 处理意见传超长
	 */
	@Test
	public void postDynamicCheckManageTestDioposeOpinionIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 999999999999999999L);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见传超长" + post);
		 

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	/**
	 * 处理意见传0
	 */
	@Test
	public void postDynamicCheckManageTestDioposeOpinionIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见传0" + post);
		 

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list =MetaOper.read(selDispose,dataType);
		assertThat(list.get(0).get("DISPOSE_OPINION").toString()).isEqualTo("0");
	}
	/**
	 * 处理意见传1
	 */
	@Test
	public void postDynamicCheckManageTestDioposeOpinionIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 1);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见传1" + post);
		 

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list =MetaOper.read(selDispose,dataType);
		assertThat(list.get(0).get("DISPOSE_OPINION").toString()).isEqualTo("1");
	}
	/**
	 * 处理意见传2
	 */
	@Test
	public void postDynamicCheckManageTestDioposeOpinionIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 2);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见传2" + post);
		 

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list =MetaOper.read(selDispose,dataType);
		assertThat(list.get(0).get("DISPOSE_OPINION").toString()).isEqualTo("2");
	}
	/**
	 * 处理意见传3
	 */
	@Test
	public void postDynamicCheckManageTestDioposeOpinionIs3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 3);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见传3" + post);
		 

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list =MetaOper.read(selDispose,dataType);
		assertThat(list.get(0).get("DISPOSE_OPINION").toString()).isEqualTo("3");
	}
	/**
	 * 处理意见不传
	 */
	@Test
	public void postDynamicCheckManageTestDioposeOpinionNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见不传" + post);
		 

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 处理意见传负数
	 */
	@Test
	public void postDynamicCheckManageTestDioposeOpinionIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", -1);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见传负数" + post);
		 

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	/**
	 * 处理意见传小数
	 */
	@Test
	public void postDynamicCheckManageTestDioposeOpinionIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 8.23);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见传小数" + post);
		 

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	/**
	 * 处理操作传负数
	 */
	@Test
	public void postDynamicCheckManageTestDioposeOperationIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", -10);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作传负数" + post);
		 

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	/**
	 * 处理操作传小数
	 */
	@Test
	public void postDynamicCheckManageTestDioposeOperationIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 2.3);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作传小数" + post);
		 

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 处理操作传空
	 */
	@Test
	public void postDynamicCheckManageTestDioposeOperationIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", "");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作传空" + post);
		 

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 处理操作传空格
	 */
	@Test
	public void postDynamicCheckManageTestDioposeOperationIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", " ");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作传空格" + post);
		 

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 处理操作传null
	 */
	@Test
	public void postDynamicCheckManageTestDioposeOperationIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", null);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作传null" + post);
		 

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 处理操作传String
	 */
	@Test
	public void postDynamicCheckManageTestDioposeOperationIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", "SDFSFS");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作传String" + post);
		 

		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 处理操作传超长
	 */
	@Test
	public void postDynamicCheckManageTestDioposeOperationIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 999999999999999999L);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作传超长" + post);
		 

		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 处理操作传 0
	 */
	@Test
	public void postDynamicCheckManageTestDioposeOperationIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作传 0" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list =MetaOper.read(selDispose,dataType);
		assertThat(list.get(0).get("DISPOSE_OPERATION").toString()).isEqualTo("0");
	}
	/**
	 * 处理操作传1
	 */
	@Test
	public void postDynamicCheckManageTestDioposeOperationIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		request.put("disposeOperation", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作传1" + post);
		 

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list =MetaOper.read(selDispose,dataType);
		assertThat(list.get(0).get("DISPOSE_OPERATION").toString()).isEqualTo("1");
	}
	/**
	 * 处理操作不传
	 */
	@Test
	public void postDynamicCheckManageTestDioposeOperationNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("dynamicId", dynamicId);
		request.put("userId", 1000000);
		request.put("userName", "admin");
		request.put("dioposeExpiain", "自动化测试");
		request.put("disposeOpinion", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作不传" + post);
		 

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}


}