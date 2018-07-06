package com.publicModule.feedbackManagement;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckReplaceAdministratorTest extends HttpUtil {
	// 审核更换管理员接口
	String url = "/uu-admin/modifyManager/auditModifyManager";
	String updateSql = "UPDATE T_MODIFY_MANAGER_APPLY SET STATUS = 0 WHERE MANAGER_ID = 12495396";
	String updateSql1 = "UPDATE T_MODIFY_MANAGER_RECORD SET STATUS = 0 WHERE MANAGER_ID = 12495396";
	String selectSql = "SELECT * FROM T_MODIFY_MANAGER_RECORD WHERE MANAGER_ID = 12495396 ";
	String deleteSql = "DELETE T_MODIFY_MANAGER_RECORD WHERE MANAGER_ID = 12495396";
	List<Map<String,Object>> list ;
	String dataType = "uedb";
	String userId; 
	String userName;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	@AfterMethod
	public void afterMethod()
	{
		MetaOper.delete(deleteSql, dataType);
	}
	
	/**
	 * 提交正确参数
	 */
	@Test
	public void postCheckReplaceAdministratorTestCorrectParameter() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功！");
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("STATUS").toString()).isEqualTo("2");
		assertThat(list.get(0).get("AUDIT_CONTENT").toString()).isEqualTo("13723");	
	}
	/**
	 * 申请Id为错误
	 */
	@Test
	public void postCheckReplaceAdministratorTestApplyIdIsError() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 111);
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请Id为错误" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("申请id不存在！");
	}
	/**
	 * 申请Id传非法字符
	 */
	@Test
	public void postCheckReplaceAdministratorTestApplyIdIsIllegalCharacters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", "vfgszd");
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请Id传非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 申请Id传0
	 */
	@Test
	public void postCheckReplaceAdministratorTestApplyIdIs0() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 0);
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请Id传0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("申请id不存在！");
	}
	/**
	 * 申请Id传空格
	 */
	@Test
	public void postCheckReplaceAdministratorTestApplyIdIsSpace() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", " ");
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请Id传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 申请Id传空
	 */
	@Test
	public void postCheckReplaceAdministratorTestApplyIdIsEmpty() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", "");
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请Id传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 申请Id传null
	 */
	@Test
	public void postCheckReplaceAdministratorTestApplyIdIsNull() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", null);
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请Id传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 申请Id传小数
	 */
	@Test
	public void postCheckReplaceAdministratorTestApplyIdIsDecimal() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 1.234);
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请Id传小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("已审核的申请不能再次审核！");
	}
	/**
	 * 申请Id传负数
	 */
	@Test
	public void postCheckReplaceAdministratorTestApplyIdIsNegativeNumber() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", -1);
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请Id传负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("申请id不存在！");
	}
	/**
	 * 申请Id不传参数
	 */
	@Test
	public void postCheckReplaceAdministratorTestApplyIdNonSubmissionParameters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请Id不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 审核人id为未登录用户
	 */
	@Test
	public void postCheckReplaceAdministratorTestApplyIdIsNotLoggedIn() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", 12491749);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核人id为未登录用户" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("审核人信息不匹配！");
	}
	/**
	 * 审核人id为错误用户
	 */
	@Test
	public void postCheckReplaceAdministratorTestUserIdIsError() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", 124916);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核人id为错误用户" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("审核人信息不匹配！");
	}
	/**
	 * 审核人id为非法字符
	 */
	@Test
	public void postCheckReplaceAdministratorTestUserIdIsIllegalCharacters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", "<@#$@#%>");
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核人id为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("申请id非法！");
	}
	/**
	 * 审核人id为小数
	 */
	@Test
	public void postCheckReplaceAdministratorTestUserIdIsDecimal() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", 1249.1748);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核人id为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("审核人信息不匹配！");
	}
	/**
	 * 审核人id为负数
	 */
	@Test
	public void postCheckReplaceAdministratorTestUserIdIsNegativeNumber() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", -12491748);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核人id为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("审核人信息不匹配！");
	}
	/**
	 * 审核人id为空格
	 */
	@Test
	public void postCheckReplaceAdministratorTestUserIdIsSpace() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", " ");
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核人id为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 审核人id为空
	 */
	@Test
	public void postCheckReplaceAdministratorTestUserIdIsEmpty() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", "");
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核人id为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 审核人id为null
	 */
	@Test
	public void postCheckReplaceAdministratorTestUserIdIsNull() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", null);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核人id为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 审核人id不传该参数
	 */
	@Test
	public void postCheckReplaceAdministratorTestUserIdNonSubmissionParameters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核人id不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 审核人id为0
	 */
	@Test
	public void postCheckReplaceAdministratorTestUserIdIs0() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", 0);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核人id为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("审核人信息不匹配！");
	}
	/**
	 * 审核人id为超长
	 */
	@Test
	public void postCheckReplaceAdministratorTestUserIdIsLong() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", 999999999999999999L);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核人id为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("审核人信息不匹配！");
	}
	/**
	 * 状态传0审核中
	 */
	@Test
	public void postCheckReplaceAdministratorTestStatusIs0() throws Exception {
		//MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 0);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态传0审核中" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("审核参数异常！");
	}
	/**
	 * 状态传1通过
	 */
	@Test
	public void postCheckReplaceAdministratorTestStatusIs1() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 1);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态传1通过" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("通过时，不用填写驳回原因！");
	}
	
	/**
	 * 状态传2驳回
	 */
	@Test
	public void postCheckReplaceAdministratorTestStatusIs2() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态传2驳回" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功！");
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("STATUS").toString()).isEqualTo("2");
		assertThat(list.get(0).get("AUDIT_CONTENT").toString()).isEqualTo("13723");	
		}
	/**
	 * 状态传错误值
	 */
	@Test
	public void postCheckReplaceAdministratorTestStatusIsError() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 6);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态传错误值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("审核参数异常！");
	}
	/**
	 * 状态传小数
	 */
	@Test
	public void postCheckReplaceAdministratorTestStatusIsDecimal() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 6.3);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态传小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("审核参数异常！");
	}
	/**
	 * 状态传负数
	 */
	@Test
	public void postCheckReplaceAdministratorTestStatusIsNegativeNumber() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", -2);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态传负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("审核参数异常！");
	}
	/**
	 * 状态传空格
	 */
	@Test
	public void postCheckReplaceAdministratorTestStatusIsSpace() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", " ");
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 状态传空
	 */
	@Test
	public void postCheckReplaceAdministratorTestStatusIsEmpty() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", "");
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 状态传null
	 */
	@Test
	public void postCheckReplaceAdministratorTestStatusIsNull() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", null);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 状态传非法字符
	 */
	@Test
	public void postCheckReplaceAdministratorTestStatusIsIllegalCharacters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", "<$%@>");
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态传非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("申请id非法！");
	}
	/**
	 * 状态不传参数
	 */
	@Test
	public void postCheckReplaceAdministratorTestStatusNonSubmissionParameters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 状态传最大值
	 */
	@Test
	public void postCheckReplaceAdministratorTestStatusIsMax() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 999999999);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("审核参数异常！");
	}
	/**
	 * 审核人姓名传超长
	 */
	@Test
	public void postCheckReplaceAdministratorTestUserNameIsLong() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", "梁保坤df的是法国的风格和健康急急急急急急就刚好经过很符合华国锋广泛大概");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核人姓名传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("审核人信息不匹配！");
	}
	/**
	 * 审核人姓名含有非法字符
	 */
	@Test
	public void postCheckReplaceAdministratorTestUserNameIsIllegalCharacters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", "<#$@#$>");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核人姓名含有非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("审核人信息不匹配！");
	}
	/**
	 * 审核人姓名传空
	 */
	@Test
	public void postCheckReplaceAdministratorTestUserNameIsEmpty() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", "");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核人姓名传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("审核人信息不匹配！");
	}
	/**
	 * 审核人姓名传空格
	 */
	@Test
	public void postCheckReplaceAdministratorTestUserNameIsSpace() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", " ");
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核人姓名传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("审核人信息不匹配！");
	}
	/**
	 * 审核人姓名传0
	 */
	@Test
	public void postCheckReplaceAdministratorTestUserNameIs0() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", 0);
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核人姓名传0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("审核人信息不匹配！");
	}
	/**
	 * 审核人姓名传null
	 */
	@Test
	public void postCheckReplaceAdministratorTestUserNameIsNull() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", null);
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核人姓名传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 审核人姓名不传参数
	 */
	@Test
	public void postCheckReplaceAdministratorTestUserNameNonSubmissionParameters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", userId);
		request.put("errorMsg", 13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核人姓名不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 驳回原因id传错误值
	 */
	@Test
	public void postCheckReplaceAdministratorTestErrorMsgIsError() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 888888);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("驳回原因id传错误值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("审核原因不存在！");
	}
	/**
	 * 驳回原因id传负数
	 */
	@Test
	public void postCheckReplaceAdministratorTestErrorMsgIsNegativeNumber() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", -13723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("驳回原因id传负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("驳回时，审核原因不能为空！");
	}
	/**
	 * 驳回原因id传小数
	 */
	@Test
	public void postCheckReplaceAdministratorTestErrorMsgIsDecimal() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 134.723);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("驳回原因id传小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("审核原因不存在！");
	}
	/**
	 * 状态为2驳回原因id传0
	 */
	@Test
	public void postCheckReplaceAdministratorTestErrorMsgIs0StatusIs2() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为2驳回原因id传0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("审核原因不存在！");
	}
	/**
	 * 状态为2驳回原因id传空格
	 */
	@Test
	public void postCheckReplaceAdministratorTestErrorMsgIsSpaceStatusIs2() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", " ");		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为2驳回原因id传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("驳回时，审核原因不能为空！");
	}
	/**
	 * 状态为2驳回原因id传空
	 */
	@Test
	public void postCheckReplaceAdministratorTestErrorMsgIsEmptyStatusIs2() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", "");		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为2驳回原因id传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("驳回时，审核原因不能为空！");
	}
	/**
	 * 状态为2驳回原因id传null
	 */
	@Test
	public void postCheckReplaceAdministratorTestErrorMsgIsNullStatusIs2() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", null);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为2驳回原因id传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("驳回时，审核原因不能为空！");
	}
	/**
	 * 驳回原因id传最大值
	 */
	@Test
	public void postCheckReplaceAdministratorTestErrorMsgIsMax() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", 999999999);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("驳回原因id传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("审核原因不存在！");
	}
	/**
	 * 驳回原因id不传参数
	 */
	@Test
	public void postCheckReplaceAdministratorTestErrorMsgNonSubmissionParameters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		request.put("userId", userId);
		request.put("userName", "admin");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("驳回原因id不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("驳回时，审核原因不能为空！");
	}
	/**
	 * 状态为0驳回原因id传空格
	 */
	@Test
	public void postCheckReplaceAdministratorTestErrorMsgIsSpaceStatusIs0() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 0);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", " ");		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为0驳回原因id传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("审核参数异常！");
	}
	/**
	 * 状态为0驳回原因id传空
	 */
	@Test
	public void postCheckReplaceAdministratorTestErrorMsgIsEmptyStatusIs0() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 0);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", "");		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为0驳回原因id传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("审核参数异常！");
	}
	/**
	 * 状态为0驳回原因id传null
	 */
	@Test
	public void postCheckReplaceAdministratorTestErrorMsgIsNullEmptyStatusIs0() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 0);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", "");		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为0驳回原因id传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("审核参数异常！");
	}
	/**
	 * 状态为0驳回原因id不传
	 */
	@Test
	public void postCheckReplaceAdministratorTestErrorMsgNonSubmissionParametersStatusIs0() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 0);
		request.put("userId", userId);
		request.put("userName", "admin");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为0驳回原因id不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("审核参数异常！");
	}
	/**
	 * 状态为1驳回原因id传空格
	 */
	@Test
	public void postCheckReplaceAdministratorTestErrorMsgIsSpaceStatusIs1() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 1);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", " ");		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为1驳回原因id传空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功！");
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("STATUS").toString()).isEqualTo("1");
	}
	/**
	 * 状态为1驳回原因id传空
	 */
	@Test
	public void postCheckReplaceAdministratorTestErrorMsgIsEmptyStatusIs1() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 1);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", "");		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为1驳回原因id传空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功！");
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("STATUS").toString()).isEqualTo("1");
		assertThat(list.get(0).get("AUDIT_CONTENT")).isEqualTo(null);
	}
	/**
	 * 状态为1驳回原因id传null
	 */
	@Test
	public void postCheckReplaceAdministratorTestErrorMsgIsNullStatusIs1() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 1);
		request.put("userId", userId);
		request.put("userName", "admin");
		request.put("errorMsg", null);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为1驳回原因id传空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功！");
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("STATUS").toString()).isEqualTo("1");
		assertThat(list.get(0).get("AUDIT_CONTENT")).isEqualTo(null);
	}
	/**
	 * 状态为1驳回原因id不传
	 */
	@Test
	public void postCheckReplaceAdministratorTestErrorMsgNonSubmissionParametersStatusIs1() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 1);
		request.put("userId", userId);
		request.put("userName", "admin");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为1驳回原因id不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功！");
		list =MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("STATUS").toString()).isEqualTo("1");
		//assertThat(list.get(0).get("AUDIT_CONTENT")).isEqualTo(null);
	}
	
	

}
