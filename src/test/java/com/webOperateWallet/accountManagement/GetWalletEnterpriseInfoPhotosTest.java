package com.webOperateWallet.accountManagement;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class GetWalletEnterpriseInfoPhotosTest extends HttpUtil {
// 获取企业账户附件图片信息接口
	String url = "/walletEnterprise/getWalletEnterpriseInfoPhotos";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetWalletEnterpriseInfoPhotosTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("enterpriseId", 2);
		request.put("userId", userId);		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 用户id为空
	 */
	@Test
	public void postGetWalletEnterpriseInfoPhotosTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("enterpriseId", 123);
		request.put("userId", "");		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 用户id为空格
	 */
	@Test
	public void postGetWalletEnterpriseInfoPhotosTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("enterpriseId", 123);
		request.put("userId", " ");		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 用户id为null
	 */
	@Test
	public void postGetWalletEnterpriseInfoPhotosTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("enterpriseId", 123);
		request.put("userId", null);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 用户id为不传
	 */
	@Test
	public void postGetWalletEnterpriseInfoPhotosTestUserIdNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("enterpriseId", 123);	

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 用户id为最大值
	 */
	@Test
	public void postGetWalletEnterpriseInfoPhotosTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("enterpriseId", 123);
		request.put("userId", "3164646887845415645645");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 钱包id为空
	 */
	@Test
	public void postGetWalletEnterpriseInfoPhotosTestEnterpriseIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("enterpriseId", "");
		request.put("userId", "3164646887845415645645");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("钱包id为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 钱包id为空格
	 */
	@Test
	public void postGetWalletEnterpriseInfoPhotosTestEnterpriseIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("enterpriseId", " ");
		request.put("userId", userId);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("钱包id为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 钱包id为null
	 */
	@Test
	public void postGetWalletEnterpriseInfoPhotosTestEnterpriseIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("enterpriseId", null);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("钱包id为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 钱包id不传
	 */
	@Test
	public void postGetWalletEnterpriseInfoPhotosTestEnterpriseIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();	
		request.put("userId", userId);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("钱包id不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 钱包id为最大值
	 */
	@Test
	public void postGetWalletEnterpriseInfoPhotosTestEnterpriseIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("enterpriseId", 999999999999999999L);
		request.put("userId", userId);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("钱包id为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
}
