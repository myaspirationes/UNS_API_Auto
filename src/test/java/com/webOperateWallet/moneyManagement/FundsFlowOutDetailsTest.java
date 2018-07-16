package com.webOperateWallet.moneyManagement;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class FundsFlowOutDetailsTest extends HttpUtil {
// 资金流出详情接口
	String url = "/uu-admin/Fund/getFundsFlowDetails";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postFundsFlowOutDetailsTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("orderNo", "132456");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	

	/**
	 * orderNo为超长
	 */
	@Test
	public void postFundsFlowOutDetailsTestOrderNoIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();

		request.put("orderNo", "1324561234567896523135467895132121356");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("orderNo为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * orderNo为空
	 */
	@Test
	public void postFundsFlowOutDetailsTestOrderNoIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("orderNo", "");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("orderNo为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * orderNo为空格
	 */
	@Test
	public void postFundsFlowOutDetailsTestOrderNoIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("orderNo", " ");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("orderNo为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * orderNo为null
	 */
	@Test
	public void postFundsFlowOutDetailsTestOrderNoIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();

		request.put("orderNo", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("orderNo为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * orderNo为不传
	 */
	@Test
	public void postFundsFlowOutDetailsTestOrderNoIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();

		JSONObject post = super.UNSPost(url, request);
		System.out.println("orderNo为不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}

	
}
