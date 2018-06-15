package com.webDynamic.complaintReasonManagement;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.login.BackUserLoginTest;
import com.example.CryptographyUtil;
import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AddAndEditComplainList extends HttpUtil {
	// 添加/编辑投诉原因接口
	String url = "/uu-admin/SystemManager/getComplaintsList";
	
	String dataType = "perCenter81";
	
	BackUserLoginTest login = new BackUserLoginTest();
	String userId=login.userId;
	
	
			
	
	/**
	 * 提交正确参数：type为0
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 0);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交正确参数：type为1
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 1);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为1" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交正确参数：type为2
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 2);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为2" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交正确参数：type为3
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIs3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 3);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为3" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交正确参数：type为4
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIs4() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为4" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交正确参数：type为5
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIs5() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 5);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为5" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交正确参数：type为6
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIs6() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 6);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为6" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交错误的type值
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 7);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交错误的type值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交type为负数
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIsNegative() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", -1);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交type为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
		
		
		
}