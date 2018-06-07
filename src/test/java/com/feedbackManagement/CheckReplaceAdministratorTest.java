package com.feedbackManagement;

import com.example.HttpUtil;
import com.example.MetaOper;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckReplaceAdministratorTest extends HttpUtil {
	// 审核更换管理员接口
	String url = "/modifyManager/auditModifyManager";

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 4);
		request.put("status", 1);
		request.put("userId", 12491748);
		request.put("userName", "梁保坤");
		request.put("errorMsg", "测试");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 申请Id为错误
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestApplyIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 111);
		request.put("status", 1);
		request.put("userId", 12491748);
		request.put("userName", "梁保坤");
		request.put("errorMsg", "测试");		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请Id为错误" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 申请Id传非法字符
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestApplyIdIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", "vfgszd");
		request.put("status", 1);
		request.put("userId", 12491748);
		request.put("userName", "梁保坤");
		request.put("errorMsg", "测试");		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请Id传非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 申请Id传0
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestApplyIdIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 0);
		request.put("status", 1);
		request.put("userId", 12491748);
		request.put("userName", "梁保坤");
		request.put("errorMsg", "测试");		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请Id传0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 申请Id传空格
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestApplyIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", " ");
		request.put("status", 1);
		request.put("userId", 12491748);
		request.put("userName", "梁保坤");
		request.put("errorMsg", "测试");		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请Id传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 申请Id传空
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestApplyIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", "");
		request.put("status", 1);
		request.put("userId", 12491748);
		request.put("userName", "梁保坤");
		request.put("errorMsg", "测试");		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请Id传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 申请Id传null
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestApplyIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", null);
		request.put("status", 1);
		request.put("userId", 12491748);
		request.put("userName", "梁保坤");
		request.put("errorMsg", "测试");		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请Id传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	

}
