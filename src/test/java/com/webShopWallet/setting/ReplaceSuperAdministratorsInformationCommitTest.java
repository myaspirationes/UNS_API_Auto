package com.webShopWallet.setting;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class ReplaceSuperAdministratorsInformationCommitTest extends HttpUtil {
// 更换超级管理员信息提交接口
	String url = "/";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postReplaceSuperAdministratorsInformationCommitTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("bookUrl", "1123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postReplaceSuperAdministratorsInformationCommitTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("bookUrl", "1123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postReplaceSuperAdministratorsInformationCommitTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("bookUrl", "1123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postReplaceSuperAdministratorsInformationCommitTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("bookUrl", "1123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postReplaceSuperAdministratorsInformationCommitTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("bookUrl", "1123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postReplaceSuperAdministratorsInformationCommitTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 999999999999999999L);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("bookUrl", "1123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	
	
	/**
	 * walletId不传参数
	 */
	@Test
	public void postReplaceSuperAdministratorsInformationCommitTestWalletIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 1);
		request.put("bookUrl", "1123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空
	 */
	@Test
	public void postReplaceSuperAdministratorsInformationCommitTestWalletIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", "");
		request.put("enterpriseId", 1);
		request.put("bookUrl", "1123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空格
	 */
	@Test
	public void postReplaceSuperAdministratorsInformationCommitTestWalletIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", " ");
		request.put("enterpriseId", 1);
		request.put("bookUrl", "1123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传null
	 */
	@Test
	public void postReplaceSuperAdministratorsInformationCommitTestWalletIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", null);
		request.put("enterpriseId", 1);
		request.put("bookUrl", "1123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传最大值
	 */
	@Test
	public void postReplaceSuperAdministratorsInformationCommitTestWalletIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 999999999999999999L);
		request.put("enterpriseId", 1);
		request.put("bookUrl", "1123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传最大值
	 */
	@Test
	public void postReplaceSuperAdministratorsInformationCommitTestEnterpriseIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 999999999999999999L);
		request.put("bookUrl", "1123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * enterpriseId传空
	 */
	@Test
	public void postReplaceSuperAdministratorsInformationCommitTestEnterpriseIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", "");
		request.put("bookUrl", "1123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传空格
	 */
	@Test
	public void postReplaceSuperAdministratorsInformationCommitTestentErpriseIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", " ");
		request.put("bookUrl", "1123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传null
	 */
	@Test
	public void postReplaceSuperAdministratorsInformationCommitTestEnterpriseIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", null);
		request.put("bookUrl", "1123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId不传参数
	 */
	@Test
	public void postReplaceSuperAdministratorsInformationCommitTestEnterpriseIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("bookUrl", "1123");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * bookUrl传null
	 */
	@Test
	public void postReplaceSuperAdministratorsInformationCommitTestBookUrlIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("bookUrl", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("bookUrl传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * bookUrl传空
	 */
	@Test
	public void postReplaceSuperAdministratorsInformationCommitTestBookUrlIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("bookUrl", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("bookUrl传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * bookUrl传空格
	 */
	@Test
	public void postReplaceSuperAdministratorsInformationCommitTestBookUrlIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("bookUrl", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("bookUrl传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * bookUrl不传
	 */
	@Test
	public void postReplaceSuperAdministratorsInformationCommitTestBookUrlIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("bookUrl不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * bookUrl传超长
	 */
	@Test
	public void postReplaceSuperAdministratorsInformationCommitTestBookUrlIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("bookUrl", "144544443223357887765634332132225487612");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("bookUrl传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
}
