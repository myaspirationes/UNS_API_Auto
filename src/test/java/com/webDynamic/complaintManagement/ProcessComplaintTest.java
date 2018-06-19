package com.webDynamic.complaintManagement;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;
//import com.example.LoginTest;

public class ProcessComplaintTest extends HttpUtil {
	//投诉信息处理接口
	String url = "/uu-admin/complaint/processComplaint";


	String userid;
	@BeforeClass
	public void  beforeClass(){
		userid = new BackUserLoginTest().userId;
		
	}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postProcessComplaintTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID为未登录
	 */
	@Test
	public void postProcessComplaintTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为未登录" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID为错误用户
	 */
	@Test
	public void postProcessComplaintTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为错误用户" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID为非法字符
	 */
	@Test
	public void postProcessComplaintTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", "<.$%^&>");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID为小数
	 */
	@Test
	public void postProcessComplaintTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", 1.1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID为负数
	 */
	@Test
	public void postProcessComplaintTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", -9);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID为空格
	 */
	@Test
	public void postProcessComplaintTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", " ");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID为null
	 */
	@Test
	public void postProcessComplaintTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", null);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID为超长
	 */
	@Test
	public void postProcessComplaintTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", "123123123123123123123");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID为String
	 */
	@Test
	public void postProcessComplaintTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", "userId");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID为0
	 */
	@Test
	public void postProcessComplaintTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID为空
	 */
	@Test
	public void postProcessComplaintTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", "");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID不传该参数
	 */
	@Test
	public void postProcessComplaintTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 投诉编号为超长
	 */
	@Test
	public void postProcessComplaintTestComplaintsNOIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", "123123123123123123123123123123123123123123123");
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉编号为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 投诉编号为小数
	 */
	@Test
	public void postProcessComplaintTestComplaintsNOIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 12.3);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉编号为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 投诉编号为负数
	 */
	@Test
	public void postProcessComplaintTestComplaintsNOIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", -123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉编号为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 投诉编号为0
	 */
	@Test
	public void postProcessComplaintTestComplaintsNOIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 0);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉编号为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 投诉编号为字符串
	 */
	@Test
	public void postProcessComplaintTestComplaintsNOIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", "complaintsNO");
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉编号为字符串" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 投诉编号为空格
	 */
	@Test
	public void postProcessComplaintTestComplaintsNOIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", " ");
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉编号为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 投诉编号为空
	 */
	@Test
	public void postProcessComplaintTestComplaintsNOIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", "");
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉编号为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 投诉编号为不存在
	 */
	@Test
	public void postProcessComplaintTestComplaintsNONonExistent() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 999999999);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉编号为不存在" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 投诉编号为null
	 */
	@Test
	public void postProcessComplaintTestComplaintsNOIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", null);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉编号为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 投诉编号不传该参数
	 */
	@Test
	public void postProcessComplaintTestComplaintsNONonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉编号不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理人为超长
	 */
	@Test
	public void postProcessComplaintTestProcessPeopleIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理人为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理人为非法字符
	 */
	@Test
	public void postProcessComplaintTestProcessPeopleIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "<.@#$%^&>");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理人为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理人为为空
	 */
	@Test
	public void postProcessComplaintTestProcessPeopleIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理人为为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理人为为空格
	 */
	@Test
	public void postProcessComplaintTestProcessPeopleIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", " ");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理人为为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理人为null
	 */
	@Test
	public void postProcessComplaintTestProcessPeopleIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", null);
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理人为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理人为不传该参数
	 */
	@Test
	public void postProcessComplaintTestProcessPeopleNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理人为不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理说明超长
	 */
	@Test
	public void postProcessComplaintTestProcessInstructionsIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理说明超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理说明为空
	 */
	@Test
	public void postProcessComplaintTestProcessInstructionsIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理说明为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理说明为空格
	 */
	@Test
	public void postProcessComplaintTestProcessInstructionsIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", " ");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理说明为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理说明为null
	 */
	@Test
	public void postProcessComplaintTestProcessInstructionsIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理说明为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理说明为非法字符
	 */
	@Test
	public void postProcessComplaintTestProcessInstructionsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "<.@#$%^&>");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理说明为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理说明不传该参数
	 */
	@Test
	public void postProcessComplaintTestProcessInstructionsNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理说明不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理意见为错误
	 */
	@Test
	public void postProcessComplaintTestProcessOpinionIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion",0001 );//UEDB中的T_AUDIT_MSG 查
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为错误" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理意见为负数
	 */
	@Test
	public void postProcessComplaintTestProcessOpinionIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", -1);
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理意见为小数
	 */
	@Test
	public void postProcessComplaintTestProcessOpinionIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", 1.1);
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理意见为0
	 */
	@Test
	public void postProcessComplaintTestProcessOpinionIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", 0);
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理意见为字符串
	 */
	@Test
	public void postProcessComplaintTestProcessOpinionIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "processOpinion");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为字符串" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理意见为空
	 */
	@Test
	public void postProcessComplaintTestProcessOpinionIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理意见为空格
	 */
	@Test
	public void postProcessComplaintTestProcessOpinionIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", " ");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理意见为null
	 */
	@Test
	public void postProcessComplaintTestProcessOpinionIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", null);
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理意见为最大值
	 */
	@Test
	public void postProcessComplaintTestProcessOpinionIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", 999999999999999999L);
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理意见为超长
	 */
	@Test
	public void postProcessComplaintTestProcessOpinionIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "99999999999999999999");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理意见不传该参数
	 */
	@Test
	public void postProcessComplaintTestProcessOpinionNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理意见为暂不处理
	 */
	@Test
	public void postProcessComplaintTestProcessOpinionNotYetProcessed() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "暂不处理ID");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为暂不处理" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理意见为建议禁止评论
	 */
	@Test
	public void postProcessComplaintTestProcessOpinionNoComment() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "禁止评论ID");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为建议禁止评论" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理意见为建议禁止交易
	 */
	@Test
	public void postProcessComplaintTestProcessOpinionNoTrading() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "禁止交易ID");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为建议禁止交易" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理意见为建议禁止发表动态
	 */
	@Test
	public void postProcessComplaintTestProcessOpinionProposeToProhibitPublicationOfNews() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "禁止发表动态ID");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为建议禁止发表动态" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理意见为建议封号
	 */
	@Test
	public void postProcessComplaintTestProcessOpinionSuggestedTitle() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "为建议封号ID");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为建议封号" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理意见为建议禁号
	 */
	@Test
	public void postProcessComplaintTestProcessOpinionRecommendedBan() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "建议禁号ID");
		request.put("processOperate", "处理操作");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理意见为建议禁号" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理操作为0正常
	 */
	@Test
	public void postProcessComplaintTestProcessOperateNormal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", 0);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作为0正常" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理操作为1隐藏
	 */
	@Test
	public void postProcessComplaintTestProcessOperateHide() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", 1);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作为1隐藏" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理操作为2暂不处理
	 */
	@Test
	public void postProcessComplaintTestProcessOperateNotYetProcessed() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", 2);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作为2暂不处理" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理操作为3建议商品下架
	 */
	@Test
	public void postProcessComplaintTestProcessOperateProductShelves() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", 3);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作为3建议商品下架" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理操作为4禁止评论
	 */
	@Test
	public void postProcessComplaintTestProcessOperateNoComment() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", 4);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作为4禁止评论" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理操作为5建议禁止交易
	 */
	@Test
	public void postProcessComplaintTestProcessOperateNoTrading() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作为5建议禁止交易" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理操作为6建议禁止发表动态
	 */
	@Test
	public void postProcessComplaintTestProcessOperateProposeToProhibitPublicationOfNews() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", 6);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作为6建议禁止发表动态" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理操作为7建议封号
	 */
	@Test
	public void postProcessComplaintTestProcessOperateProposedBan() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", 7);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作为7建议封号" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理操作为和处理意见不符
	 */
	@Test
	public void postProcessComplaintTestProcessOperateInconsistentThanProcessOpinion() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", 2);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作为和处理意见不符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理操作为小数
	 */
	@Test
	public void postProcessComplaintTestProcessOperateIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", 1.1);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理操作为负数
	 */
	@Test
	public void postProcessComplaintTestProcessOperateIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", -1);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理操作为空
	 */
	@Test
	public void postProcessComplaintTestProcessOperateIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", "");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理操作为空格
	 */
	@Test
	public void postProcessComplaintTestProcessOperateIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", " ");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理操作为最大值
	 */
	@Test
	public void postProcessComplaintTestProcessOperateIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", 999999999);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理操作为超长
	 */
	@Test
	public void postProcessComplaintTestProcessOperateIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", 9999999999L);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理操作为null
	 */
	@Test
	public void postProcessComplaintTestProcessOperateIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("processOperate", null);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 处理操作为不传该参数
	 */
	@Test
	public void postProcessComplaintTestProcessOperateNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintsNO", 123);
		request.put("processPeople", "处理人");
		request.put("processInstructions", "处理说明");
		request.put("processOpinion", "处理意见");
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("处理操作为不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

}