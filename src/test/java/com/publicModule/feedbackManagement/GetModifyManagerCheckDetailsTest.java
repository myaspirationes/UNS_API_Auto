package com.publicModule.feedbackManagement;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;

public class GetModifyManagerCheckDetailsTest extends HttpUtil {
// 获取更换管理员审核详情接口
	String url = "/uu-admin/modifyManager/getModifyManagerDetail";
	String userId;
	String updateSql = "UPDATE T_MODIFY_MANAGER_APPLY SET STATUS = 2 WHERE MANAGER_ID = 12495396";
	String datatype = "uedb" ;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
	MetaOper.update(updateSql, datatype);
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestCorrectParameter() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("applyId", 6);
		request.put("status", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestUserIdNotLoggedIn() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12491748);				
		request.put("applyId", 6);
		request.put("status", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户不存在");
		}
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestUserIdIsError() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495);				
		request.put("applyId", 6);
		request.put("status", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户不存在");
		}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestUserIdIsString() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "dfdsfds");				
		request.put("applyId", 6);
		request.put("status", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("成功1");
		}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestUserIdIsDecimal() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 124.95396);				
		request.put("applyId", 6);
		request.put("status", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户不存在");
		}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestUserIdIsNegativeNumber() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -12495396);				
		request.put("applyId", 6);
		request.put("status", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户Id不合法");
		}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestUserIdIsSpace() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");				
		request.put("applyId", 6);
		request.put("status", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户Id不合法");
		}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestUserIdIsEmpty() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");				
		request.put("applyId", 6);
		request.put("status", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户Id不合法");
		}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestUserIdIsNull() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);				
		request.put("applyId", 6);
		request.put("status", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户Id不合法");
		}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestUserIdNonSubmissionParameters() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 6);
		request.put("status", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户Id不合法");
		}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestUserIdIs0() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);				
		request.put("applyId", 6);
		request.put("status", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户不存在");
		}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestUserIdIsLong() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 999999999999999999L);				
		request.put("applyId", 6);
		request.put("status", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户Id不合法");
		}
	/**
	 * 申请id为错误
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestApplyIdIsError() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("applyId", 99);
		request.put("status", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请id为错误" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("申请数据不存在");
		}
	/**
	 * 申请id传小数
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestApplyIdIsDecimal() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("applyId", 7.3);
		request.put("status", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请id传小数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("申请数据不存在");
		}
	/**
	 * 申请id传负数
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestApplyIdIsNegativeNumber() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("applyId", -6);
		request.put("status", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请id传负数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("申请Id参数不合法");
		}
	/**
	 * 申请id传String
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestApplyIdIsString() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("applyId", "fdgdsgs");
		request.put("status", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请id传String" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("成功");
		}
	/**
	 * 申请id传0
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestApplyIdIs0() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("applyId", 0);
		request.put("status", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请id传0" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("申请数据不存在");
		}
	/**
	 * 申请id传最大值
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestApplyIdIsMax() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("applyId", 999999999);
		request.put("status", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请id传最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("申请数据不存在");
		}
	/**
	 * 申请id不传参数
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestApplyIdNonSubmissionParameters() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("status", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请id不传参数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("申请Id参数不合法");
		}
	/**
	 * 申请id传空
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestApplyIdIsEmpty() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("applyId", "");
		request.put("status", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请id传空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("申请Id参数不合法");
		}
	/**
	 * 申请id传空格
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestApplyIdIsSpace() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("applyId", " ");
		request.put("status", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请id传空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("申请Id参数不合法");
		}
	/**
	 * 状态status传错误值
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestStatusIsError() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("applyId", 6);
		request.put("status", 6);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传错误值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("申请数据不存在");
		}
	/**
	 * 状态status传小数
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestStatusIsDecimal() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("applyId", 6);
		request.put("status", 6.23);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传小数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("申请数据不存在");
		}
	/**
	 * 状态status传负数
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestStatusIsNegativeNumber() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("applyId", 6);
		request.put("status", -1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传负数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("申请数据不存在");
		}
	/**
	 * 状态status传空
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestStatusIsEmpty() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("applyId", 6);
		request.put("status", "");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("申请数据不存在");
		}
	/**
	 * 状态status传空格
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestStatusIsSpace() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("applyId", 6);
		request.put("status", " ");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("申请数据不存在");
		}
	/**
	 * 状态status传null
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestStatusIsNull() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("applyId", 6);
		request.put("status", null);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("申请数据不存在");
		}
	/**
	 * 状态status传String
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestStatusIsString() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("applyId", 6);
		request.put("status", "gfgdds");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传String" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		}
	/**
	 * 状态status不传参数
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestStatusNonSubmissionParameters() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("applyId", 6);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status不传参数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("申请数据不存在");
		}
	/**
	 * 状态status传0待审核
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestStatusIs0() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("applyId", 6);
		request.put("status", 0);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传0待审核" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("申请数据不存在");
		}
	/**
	 * 状态status传1审核通过
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestStatusIs1() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("applyId", 6);
		request.put("status", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传1审核通过" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("申请数据不存在");
		}
	/**
	 * 状态status传2审核失败
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestStatusIs2() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("applyId", 6);
		request.put("status", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传2审核失败" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		}
	/**
	 * 状态status传最大值
	 */
	@Test
	public void postGetModifyManagerCheckDetailsTestStatusIsMax() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);				
		request.put("applyId", 6);
		request.put("status", 999999999);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("申请数据不存在");
		}
	
}