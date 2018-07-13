package com.webShopWallet.companyWalletEnter;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class CheckUnifiedSocialCreditCodeTest extends HttpUtil {
// 验证社会统一信用代码接口
	String url = "/wallet-admin/enterprise/checkUnifiedSocialCreditCode";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postCheckUnifiedSocialCreditCodeTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	

	
	/**
	 * unifiedSocialCreditCode不传参数
	 */
	@Test
	public void postCheckUnifiedSocialCreditCodeTestUnifiedSocialCreditCodeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		JSONObject post = super.UNSPost(url, request);
		System.out.println("unifiedSocialCreditCode不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * unifiedSocialCreditCode传空
	 */
	@Test
	public void postCheckUnifiedSocialCreditCodeTestUnifiedSocialCreditCodeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("unifiedSocialCreditCode", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("unifiedSocialCreditCode传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * unifiedSocialCreditCode传空格
	 */
	@Test
	public void postCheckUnifiedSocialCreditCodeTestUnifiedSocialCreditCodeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("unifiedSocialCreditCode", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("unifiedSocialCreditCode传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * unifiedSocialCreditCode传null
	 */
	@Test
	public void postCheckUnifiedSocialCreditCodeTestUnifiedSocialCreditCodeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("unifiedSocialCreditCode", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("unifiedSocialCreditCode传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * unifiedSocialCreditCode传超长
	 */
	@Test
	public void postCheckUnifiedSocialCreditCodeTestUnifiedSocialCreditCodeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("unifiedSocialCreditCode", "91350100M000100Y431234542212131fdssf5444444212");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	
}
