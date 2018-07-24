package com.webDynamic.labelManagement;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.junit.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;
//import com.example.LoginTest;

public class QueryLabelListTest extends HttpUtil {
	//获取标签管理列表接口
	String url = "/uu-admin/labelManage/queryLabelList";
	String delLabel = "DELETE FROM T_LABEL WHERE LABEL_MSG IN ('自动化标签','<.!@#$%^>','',' ')";
	String dataType = "perCenter81";

	String userid;
	@BeforeClass
	public void  beforeClass(){
		userid = new BackUserLoginTest().userId;
		
	}
	@BeforeMethod
	public void beforeMethod() throws Exception {
		new AddCommonLabelTest().postSetAndModifyTalantLableTestCorrectParameter();
	}
	@AfterClass
	public void afterClass(){
		MetaOper.delete(delLabel,dataType);
	}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postQueryLabelListTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("type", 4);
		request.put("labelName", "自动化标签");

		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作用户ID为未登录
	 */
	@Test
	public void postQueryLabelListTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495079);
		request.put("type", 4);
		request.put("labelName", "自动化标签");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为未登录" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不存在！");
	}
	/**
	 * 操作用户ID为错误用户
	 */
	@Test
	public void postQueryLabelListTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1111111111);
		request.put("type", 4);
		request.put("labelName", "自动化标签");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为错误用户" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不存在！");
	}
	/**
	 * 操作用户ID为非法字符
	 */
	@Test
	public void postQueryLabelListTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "<.!@#!@#>");
		request.put("type", 4);
		request.put("labelName", "自动化标签");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 操作用户ID为小数
	 */
	@Test
	public void postQueryLabelListTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1.5);
		request.put("type", 4);
		request.put("labelName", "自动化标签");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不存在！");
	}
	/**
	 * 操作用户ID为负数
	 */
	@Test
	public void postQueryLabelListTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", -9);
		request.put("type", 4);
		request.put("labelName", "自动化标签");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不存在！");
	}
	/**
	 * 操作用户ID为空格
	 */
	@Test
	public void postQueryLabelListTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "");
		request.put("type", 4);
		request.put("labelName", "自动化标签");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("请求参数不能为空！");
	}
	/**
	 * 操作用户ID为null
	 */
	@Test
	public void postQueryLabelListTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", null);
		request.put("type", 4);
		request.put("labelName", "自动化标签");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("请求参数不能为空！");
	}
	/**
	 * 操作用户ID为超长
	 */
	@Test
	public void postQueryLabelListTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "112121212121212121212");
		request.put("type", 4);
		request.put("labelName", "自动化标签");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 操作用户ID为String
	 */
	@Test
	public void postQueryLabelListTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "userId");
		request.put("type", 4);
		request.put("labelName", "自动化标签");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 操作用户ID为0
	 */
	@Test
	public void postQueryLabelListTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 0);
		request.put("type", 4);
		request.put("labelName", "自动化标签");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不存在！");
	}
	/**
	 * 操作用户ID为空
	 */
	@Test
	public void postQueryLabelListTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "");
		request.put("type", 4);
		request.put("labelName", "自动化标签");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("请求参数不能为空！");
	}
	/**
	 * 操作用户ID不传该参数
	 */
	@Test
	public void postQueryLabelListTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("type", 4);
		request.put("labelName", "自动化标签");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("请求参数不能为空！");
	}
	/**
	 * 类型ID为1星座
	 */
	@Test
	public void postQueryLabelListTestTypeIsConstellation() throws Exception {
		new SetAndModifyTalantLableTest().postSetAndModifyTalantLableTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("type", 1);
		request.put("labelName", "自动化标签");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型ID为1星座" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型ID为2属相
	 */
	@Test
	public void postQueryLabelListTestTypeIsSignOfTheZodiac() throws Exception {
		new SetAndModifyTalantLableTest().postSetAndModifyTalantLableTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("type", 2);
		request.put("labelName", "自动化标签");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型ID为2属相" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型ID为3年代
	 */
	@Test
	public void postQueryLabelListTestTypeIsTime() throws Exception {
		new SetAndModifyTalantLableTest().postSetAndModifyTalantLableTestCorrectParameter();
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("type", 3);
		request.put("labelName", "自动化标签");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型ID为3年代" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型ID为4普通
	 */
	@Test
	public void postQueryLabelListTestTypeIsOrdinary() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("type", 4);
		request.put("labelName", "自动化标签");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型ID为4普通" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型ID为错误值
	 */
	@Test
	public void postQueryLabelListTestTypeIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("type", 999);
		request.put("labelName", "自动化标签");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型ID为错误值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 类型ID为小数
	 */
	@Test
	public void postQueryLabelListTestTypeIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("type", 4.9);
		request.put("labelName", "自动化标签");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}/**
	 * 类型ID为负数
	 */
	@Test
	public void postQueryLabelListTestTypeIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("type", -1);
		request.put("labelName", "自动化标签");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 类型ID为0
	 */
	@Test
	public void postQueryLabelListTestTypeIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("type", 0);
		request.put("labelName", "自动化标签");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 类型ID为字符串
	 */
	@Test
	public void postQueryLabelListTestTypeIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("type", "type");
		request.put("labelName", "自动化标签");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型ID" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 类型ID为空格
	 */
	@Test
	public void postQueryLabelListTestTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("type", " ");
		request.put("labelName", "自动化标签");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("请求参数不能为空！");
	}
	/**
	 * 类型ID为空
	 */
	@Test
	public void postQueryLabelListTestTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("type", "");
		request.put("labelName", "自动化标签");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型类型ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("请求参数不能为空！");
	}
	/**
	 * 类型ID为null
	 */
	@Test
	public void postQueryLabelListTestTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("type", null);
		request.put("labelName", "自动化标签");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("请求参数不能为空！");
	}
	/**
	 * 类型ID为最大值
	 */
	@Test
	public void postQueryLabelListTestTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("type", 999999999);
		request.put("labelName", "自动化标签");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型ID为最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 类型ID为超长
	 */
	@Test
	public void postQueryLabelListTestTypeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("type", 411111111111111L);
		request.put("labelName", "自动化标签");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 类型ID不传该参数
	 */
	@Test
	public void postQueryLabelListTestTypeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("labelName", "自动化标签");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("请求参数不能为空！");
	}

	/**
	 * 类型名与类型ID不符
	 */
	@Test
	public void postQueryLabelListTestLabelNameNotTheSameAsType() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("type", 4);
		request.put("labelName", "自动化标签");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型名与类型ID不符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型名为超长
	 */
	@Test
	public void postQueryLabelListTestLabelNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("type", 4);
		request.put("labelName", "自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型名为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("org.hibernate.exception.SQLGrammarException: could not extract ResultSet");
	}
	/**
	 * 类型名为非法字符
	 */
	@Test
	public void postQueryLabelListTestLabelNameIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("type", 4);
		request.put("labelName", "<.@#$%^&>");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型名为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型名为空
	 */
	@Test
	public void postQueryLabelListTestLabelNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("type", 4);
		request.put("labelName", "");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型名为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型名为空格
	 */
	@Test
	public void postQueryLabelListTestLabelNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("type", 4);
		request.put("labelName", " ");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型名为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型名为null
	 */
	@Test
	public void postQueryLabelListTestLabelNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("type", 4);
		request.put("labelName", null);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型名为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型名不传该参数
	 */
	@Test
	public void postQueryLabelListTestLabelNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("type", 4);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型名不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
}
