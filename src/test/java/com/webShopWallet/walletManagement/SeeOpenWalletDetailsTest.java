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

public class SeeOpenWalletDetailsTest extends HttpUtil {
// 查看开通钱包详情接口
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
	public void postSeeOpenWalletDetailsTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("recordId", "132456");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	

	/**
	 * recordId为超长
	 */
	@Test
	public void postSeeOpenWalletDetailsTestrecordIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();

		request.put("recordId", "1324561234567896523135467895132121356");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("recordId为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * recordId为空
	 */
	@Test
	public void postSeeOpenWalletDetailsTestrecordIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("recordId", "");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("recordId为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * recordId为空格
	 */
	@Test
	public void postSeeOpenWalletDetailsTestrecordIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("recordId", " ");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("recordId为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * recordId为null
	 */
	@Test
	public void postSeeOpenWalletDetailsTestrecordIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();

		request.put("recordId", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("recordId为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * recordId为不传
	 */
	@Test
	public void postSeeOpenWalletDetailsTestrecordIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();

		JSONObject post = super.UNSPost(url, request);
		System.out.println("recordId为不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}

	
}
