package com.webDynamic.complaintManagement;

import com.appDynamic.ReportDynamicsOrCommentsTest;
import com.example.HttpUtil;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;
//import com.example.LoginTest;

public class GetComplainDetailTest extends HttpUtil {
	//获取投诉信息详情接口
	String url = "/uu-admin/complaint/getComplaintDetail";
	String dataType = "perCenter81";
	String selectSql = "SELECT * FROM T_USER_COMPLAINT WHERE REASON = '自动化测试举报'";
	String delDynamic = "DELETE FROM T_DYNAMIC WHERE DESCRIPTION = '自动化测试'";
	String delComment = "DELETE FROM T_COMMENTBACK WHERE CONTENT in ('自动化评论','<#$%^&**^%$#>','自动化评论回复')";
	String delComplaint = "DELETE FROM T_USER_COMPLAINT WHERE REASON = '自动化测试举报'";
	List<Map<String,Object>> list ;
	String complaintsNO;

	String userid;
	@BeforeClass
	public void  beforeClass(){
		userid = new BackUserLoginTest().userId;
		
	}
	@BeforeMethod
	public void beforeMethod() throws Exception {
		new ReportDynamicsOrCommentsTest().postReportDynamicsOrCommentsTestCorrectParameterReportDynamic();
		list = MetaOper.read(selectSql,dataType);
		complaintsNO = list.get(0).get("COMPLAINT_ID").toString();

	}
	@AfterMethod
	public void afterMethod() {
		MetaOper.delete(delComment, dataType);
		MetaOper.delete(delDynamic, dataType);
		MetaOper.delete(delComplaint, dataType);
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetComplainDetailTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("complaintId", complaintsNO);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 操作用户ID为未登录
	 */
	@Test
	public void postGetComplainDetailTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 10000001);
		request.put("complaintId", complaintsNO);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为未登录" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("投诉编号格式错误！");
	}
	/**
	 * 操作用户ID错误用户
	 */
	@Test
	public void postGetComplainDetailTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 121);
		request.put("complaintId", complaintsNO);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID错误用户" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("投诉编号格式错误！");
	}
	/**
	 * 操作用户ID为非法字符
	 */
	@Test
	public void postGetComplainDetailTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "<.@#$%>");
		request.put("complaintId", complaintsNO);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户id格式错误！");
	}
	/**
	 * 操作用户ID为小数
	 */
	@Test
	public void postGetComplainDetailTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1.1);
		request.put("complaintId", complaintsNO);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户id格式错误！");
	}
	/**
	 * 操作用户ID为负数
	 */
	@Test
	public void postGetComplainDetailTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", -1);
		request.put("complaintId", complaintsNO);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户id格式错误！");
	}
	/**
	 * 操作用户ID为空格
	 */
	@Test
	public void postGetComplainDetailTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", " ");
		request.put("complaintId", complaintsNO);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户id格式错误！");
	}
	/**
	 * 操作用户ID为空
	 */
	@Test
	public void postGetComplainDetailTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "");
		request.put("complaintId", complaintsNO);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户id不能为空");
	}
	/**
	 * 操作用户ID为null
	 */
	@Test
	public void postGetComplainDetailTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", null);
		request.put("complaintId", complaintsNO);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户id不能为空");
	}
	/**
	 * 操作用户ID为超长
	 */
	@Test
	public void postGetComplainDetailTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "123123123112312312323123");
		request.put("complaintId", complaintsNO);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("投诉编号格式错误！");
	}
	/**
	 * 操作用户ID为String
	 */
	@Test
	public void postGetComplainDetailTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "userId");
		request.put("complaintId", complaintsNO);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户id格式错误！");
	}
	/**
	 * 操作用户ID为0
	 */
	@Test
	public void postGetComplainDetailTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 0);
		request.put("complaintId", complaintsNO);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户id格式错误！");
	}
	/**
	 * 操作用户ID不传该参数
	 */
	@Test
	public void postGetComplainDetailTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintId", complaintsNO);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("操作用户id不能为空");
	}
	/**
	 * 投诉编号超长
	 */
	@Test
	public void postGetComplainDetailTestComplaintIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("complaintId", "1111111111111111111111");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉编号超长" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 投诉编号为小数
	 */
	@Test
	public void postGetComplainDetailTestComplaintIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("complaintId", 1.1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉编号为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("投诉编号格式错误！");
	}
	/**
	 * 投诉编号为负数
	 */
	@Test
	public void postGetComplainDetailTestComplaintIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("complaintId", -1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉编号为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("投诉编号格式错误！");
	}
	/**
	 * 投诉编号为0
	 */
	@Test
	public void postGetComplainDetailTestComplaintIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("complaintId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉编号为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("投诉编号格式错误！");
	}
	/**
	 * 投诉编号为字符串
	 */
	@Test
	public void postGetComplainDetailTestComplaintIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("complaintId", "complaintId");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉编号为字符串" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("投诉编号格式错误！");
	}
	/**
	 * 投诉编号为空
	 */
	@Test
	public void postGetComplainDetailTestComplaintIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("complaintId", "");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉编号为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("投诉编号不能为空");
	}
	/**
	 * 投诉编号为空格
	 */
	@Test
	public void postGetComplainDetailTestComplaintIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("complaintId", " ");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉编号为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("投诉编号格式错误！");
	}
	/**
	 * 投诉编号为不存在
	 */
	@Test
	public void postGetComplainDetailTestComplaintIdNonExistent() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("complaintId", 1212212121);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉编号为不存在" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("当前投诉详情不存在");
	}
	/**
	 * 投诉编号为null
	 */
	@Test
	public void postGetComplainDetailTestComplaintIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("complaintId", null);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉编号为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("投诉编号不能为空");
	}
	/**
	 * 投诉编号不传该参数
	 */
	@Test
	public void postGetComplainDetailTestComplaintIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉编号不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("投诉编号不能为空");
	}
	/**
	 * 投诉编号为最大值
	 */
	@Test
	public void postGetComplainDetailTestComplaintIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("complaintId", 999999999999999999L);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉编号为最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("当前投诉详情不存在");
	}

}