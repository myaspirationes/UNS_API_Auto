package com.webShopWallet.walletManagement;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class AgainOpenWalletCheckTest extends HttpUtil {
// 再次开通钱包深审核接口
	String url = "/uu-admin/walletAuditEnterprise/getAuditWalletDetail";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postAgainOpenWalletCheckTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);
		request.put("recordId", 123);
		request.put("auditResult", 2);
		request.put("auditReason", "自动化测试审核");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * userId传空
	 */
	@Test
	public void postAgainOpenWalletCheckTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", "");
		request.put("recordId", 123);
		request.put("auditResult", 2);
		request.put("auditReason", "自动化测试审核");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("userId传空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * userId传空格
	 */
	@Test
	public void postAgainOpenWalletCheckTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", " ");
		request.put("recordId", 123);
		request.put("auditResult", 2);
		request.put("auditReason", "自动化测试审核");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("userId传空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * userId传null
	 */
	@Test
	public void postAgainOpenWalletCheckTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", null);
		request.put("recordId", 123);
		request.put("auditResult", 2);
		request.put("auditReason", "自动化测试审核");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("userId传null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * userId不传
	 */
	@Test
	public void postAgainOpenWalletCheckTestUserIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("recordId", 123);
		request.put("auditResult", 2);
		request.put("auditReason", "自动化测试审核");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("userId不传" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * userId传最大值
	 */
	@Test
	public void postAgainOpenWalletCheckTestUserIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 999999999999999999L);
		request.put("recordId", 123);
		request.put("auditResult", 2);
		request.put("auditReason", "自动化测试审核");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("userId传最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * recordId传空
	 */
	@Test
	public void postAgainOpenWalletCheckTestRecordIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);
		request.put("recordId", "");
		request.put("auditResult", 2);
		request.put("auditReason", "自动化测试审核");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("recordId传空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * recordId传空格
	 */
	@Test
	public void postAgainOpenWalletCheckTestRecordIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);
		request.put("recordId", " ");
		request.put("auditResult", 2);
		request.put("auditReason", "自动化测试审核");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("recordId传空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * recordId传null
	 */
	@Test
	public void postAgainOpenWalletCheckTestRecordIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);
		request.put("recordId", null);
		request.put("auditResult", 2);
		request.put("auditReason", "自动化测试审核");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("recordId传null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * recordId不传
	 */
	@Test
	public void postAgainOpenWalletCheckTestRecordIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);
		request.put("auditResult", 2);
		request.put("auditReason", "自动化测试审核");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("recordId不传" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * recordId传超长
	 */
	@Test
	public void postAgainOpenWalletCheckTestRecordIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);
		request.put("recordId", 999999999999999999L);
		request.put("auditResult", 2);
		request.put("auditReason", "自动化测试审核");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("recordId传空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * auditResult传空
	 */
	@Test
	public void postAgainOpenWalletCheckTestAuditResultIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);
		request.put("recordId", 123);
		request.put("auditResult", "");
		request.put("auditReason", "自动化测试审核");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditResult传空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * auditResult传空格
	 */
	@Test
	public void postAgainOpenWalletCheckTestAuditResultIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);
		request.put("recordId", 123);
		request.put("auditResult", " ");
		request.put("auditReason", "自动化测试审核");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditResult传空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * auditResult传null
	 */
	@Test
	public void postAgainOpenWalletCheckTestAuditResultIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);
		request.put("recordId", 123);
		request.put("auditResult", "");
		request.put("auditReason", "自动化测试审核");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditResult传null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * auditResult不传
	 */
	@Test
	public void postAgainOpenWalletCheckTestAuditResultIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);
		request.put("recordId", 123);
		request.put("auditReason", "自动化测试审核");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditResult不传" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * auditResult传最大值
	 */
	@Test
	public void postAgainOpenWalletCheckTestAuditResultIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);
		request.put("recordId", 123);
		request.put("auditResult", 999999999);
		request.put("auditReason", "自动化测试审核");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditResult传最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * auditResult传2通过
	 */
	@Test
	public void postAgainOpenWalletCheckTestAuditResultIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);
		request.put("recordId", 123);
		request.put("auditResult", 2);
		request.put("auditReason", "自动化测试审核");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditResult传2通过" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * auditResult传3不通过
	 */
	@Test
	public void postAgainOpenWalletCheckTestAuditResultIs3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);
		request.put("recordId", 123);
		request.put("auditResult", 3);
		request.put("auditReason", "自动化测试审核");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditResult传3不通过" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * auditReason传空
	 */
	@Test
	public void postAgainOpenWalletCheckTestAuditReasonIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);
		request.put("recordId", 123);
		request.put("auditResult", 2);
		request.put("auditReason", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditReason传空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * auditReason传空格
	 */
	@Test
	public void postAgainOpenWalletCheckTestAuditReasonIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);
		request.put("recordId", 123);
		request.put("auditResult", 2);
		request.put("auditReason", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditReason传空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * auditReason传超长
	 */
	@Test
	public void postAgainOpenWalletCheckTestAuditReasonIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);
		request.put("recordId", 123);
		request.put("auditResult", 2);
		request.put("auditReason", "地方大师傅但是给感到翻跟斗翻跟斗推广和一家韩国海军飞机的法国队高浮雕鬼地方");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditReason传超长" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * auditReason不传
	 */
	@Test
	public void postAgainOpenWalletCheckTestAuditReasonIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);
		request.put("recordId", 123);
		request.put("auditResult", 2);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditReason不传" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * auditReason传null
	 */
	@Test
	public void postAgainOpenWalletCheckTestAuditReasonIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);
		request.put("recordId", 123);
		request.put("auditResult", 2);
		request.put("auditReason", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditReason传null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	

	
	
}
