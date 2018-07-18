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

public class GetBankCardInformationOfBusinessAccountTest extends HttpUtil {
// 获取企业账户银行卡信息接口
	String url = "/BackUser/getUserOperateLogByWalletId";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetBankCardInformationOfBusinessAccountTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);		
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 用户id为空
	 */
	@Test
	public void postGetBankCardInformationOfBusinessAccountTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", "");		
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 用户id为空格
	 */
	@Test
	public void postGetBankCardInformationOfBusinessAccountTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", " ");		
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 用户id为null
	 */
	@Test
	public void postGetBankCardInformationOfBusinessAccountTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", null);		
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 用户id为不传
	 */
	@Test
	public void postGetBankCardInformationOfBusinessAccountTestUserIdNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);	
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 用户id为最大值
	 */
	@Test
	public void postGetBankCardInformationOfBusinessAccountTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", "3164646887845415645645");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 钱包id为空
	 */
	@Test
	public void postGetBankCardInformationOfBusinessAccountTestWalletIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", "");
		request.put("userId", "3164646887845415645645");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("钱包id为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 钱包id为空格
	 */
	@Test
	public void postGetBankCardInformationOfBusinessAccountTestWalletIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", " ");
		request.put("userId", userId);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("钱包id为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 钱包id为null
	 */
	@Test
	public void postGetBankCardInformationOfBusinessAccountTestWalletIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", null);
		request.put("userId", userId);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("钱包id为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 钱包id不传
	 */
	@Test
	public void postGetBankCardInformationOfBusinessAccountTestWalletIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
	
		request.put("userId", userId);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("钱包id不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 钱包id为最大值
	 */
	@Test
	public void postGetBankCardInformationOfBusinessAccountTestWalletIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 999999999999999999L);
		request.put("userId", userId);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("钱包id为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * pageSize为空
	 */
	@Test
	public void postGetBankCardInformationOfBusinessAccountTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("pageSize", "");
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageSize为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * pageSize为空格
	 */
	@Test
	public void postGetBankCardInformationOfBusinessAccountTestPageSizeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("pageSize", " ");
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageSize为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * pageSize为null
	 */
	@Test
	public void postGetBankCardInformationOfBusinessAccountTestPageSizeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("pageSize", null);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageSize为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * pageSize不传
	 */
	@Test
	public void postGetBankCardInformationOfBusinessAccountTestPageSizeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageSize不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * pageSize为最大值
	 */
	@Test
	public void postGetBankCardInformationOfBusinessAccountTestPageSizeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("pageSize", 999999999);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageSize为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * pageNow为空
	 */
	@Test
	public void postGetBankCardInformationOfBusinessAccountTestPageNowIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("pageSize", 5);
		request.put("pageNow", "");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageNow为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * pageNow为空格
	 */
	@Test
	public void postGetBankCardInformationOfBusinessAccountTestPageNowIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("pageSize", 5);
		request.put("pageNow", " ");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageNow为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * pageNow为null
	 */
	@Test
	public void postGetBankCardInformationOfBusinessAccountTestPageNowIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("pageSize", 5);
		request.put("pageNow", null);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageNow为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * pageNow不传
	 */
	@Test
	public void postGetBankCardInformationOfBusinessAccountTestPageNowIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("pageSize", 5);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageNow不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * pageNow为最大值
	 */
	@Test
	public void postGetBankCardInformationOfBusinessAccountTestPageNowIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("pageSize", 5);
		request.put("pageNow", 999999999);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageNow为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
}
