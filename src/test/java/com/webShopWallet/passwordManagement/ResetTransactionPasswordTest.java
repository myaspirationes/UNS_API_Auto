package com.webShopWallet.passwordManagement;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class ResetTransactionPasswordTest extends HttpUtil {
// 重置交易密码接口
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
	public void postResetTransactionPasswordTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("mobile", 1);
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postResetTransactionPasswordTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("mobile", 1);
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postResetTransactionPasswordTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("mobile", 1);
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postResetTransactionPasswordTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("mobile", 1);
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postResetTransactionPasswordTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("mobile", 1);
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postResetTransactionPasswordTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 999999999999999999L);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("mobile", 1);
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	
	
	/**
	 * walletId不传参数
	 */
	@Test
	public void postResetTransactionPasswordTestWalletIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("mobile", 1);
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空
	 */
	@Test
	public void postResetTransactionPasswordTestWalletIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", "");
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("mobile", 1);
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空格
	 */
	@Test
	public void postResetTransactionPasswordTestWalletIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", " ");
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("mobile", 1);
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传null
	 */
	@Test
	public void postResetTransactionPasswordTestWalletIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", null);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("mobile", 1);
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传超长
	 */
	@Test
	public void postResetTransactionPasswordTestWalletIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 999999999999999999L);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("mobile", 1);
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * newPwd传超长
	 */
	@Test
	public void postResetTransactionPasswordTestNewPwdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", "1254dnjjkdjjljdkj45443434343d43f4d3fdfdfdfd32f4fdfdfdfdfdf");
		request.put("newPwdCr", 1);
		request.put("mobile", 1);
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("newPwd传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * newPwd传空
	 */
	@Test
	public void postResetTransactionPasswordTestNewPwdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", "");
		request.put("newPwdCr", 1);
		request.put("mobile", 1);
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("newPwd传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * newPwd传空格
	 */
	@Test
	public void postResetTransactionPasswordTestNewPwdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", " ");
		request.put("newPwdCr", 1);
		request.put("mobile", 1);
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("newPwd传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * newPwd传null
	 */
	@Test
	public void postResetTransactionPasswordTestNewPwdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", null);
		request.put("newPwdCr", 1);
		request.put("mobile", 1);
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("newPwd传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * newPwd不传参数
	 */
	@Test
	public void postResetTransactionPasswordTestNewPwdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwdCr", 1);
		request.put("mobile", 1);
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("newPwd不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	
	/**
	 * newPwdCr传null
	 */
	@Test
	public void postResetTransactionPasswordTestNewPwdCrIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", null);
		request.put("mobile", 1);
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("newPwdCr传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * newPwdCr传空
	 */
	@Test
	public void postResetTransactionPasswordTestNewPwdCrIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", "");
		request.put("mobile", 1);
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("newPwdCr传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * newPwdCr传空格
	 */
	@Test
	public void postResetTransactionPasswordTestNewPwdCrIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", " ");
		request.put("mobile", 1);
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("newPwdCr传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * newPwdCr不传参数
	 */
	@Test
	public void postResetTransactionPasswordTestNewPwdCrIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("mobile", 1);
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("newPwdCr不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * newPwdCr传超长
	 */
	@Test
	public void postResetTransactionPasswordTestNewPwdCrIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", "31322gfgfdgfgfdg12124544hghfgggggfhghgh");
		request.put("mobile", 1);
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("newPwdCr传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * mobile传空
	 */
	@Test
	public void postResetTransactionPasswordTestMobileIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("mobile", "");
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * mobile传空格
	 */
	@Test
	public void postResetTransactionPasswordTestMobileIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("mobile", " ");
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * mobile传null
	 */
	@Test
	public void postResetTransactionPasswordTestMobileIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("mobile", null);
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * mobile不传参数
	 */
	@Test
	public void postResetTransactionPasswordTestmobileIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * mobile传超长
	 */
	@Test
	public void postResetTransactionPasswordTestMobileIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("mobile", "1232454544564545454548784121212123132312132132");
		request.put("code", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * code传超长
	 */
	@Test
	public void postResetTransactionPasswordTestCodeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("mobile", 1);
		request.put("code", "1232454544564545454548784121212123132312132132");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("code传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * code传空
	 */
	@Test
	public void postResetTransactionPasswordTestCodeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("mobile", 1);
		request.put("code", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("code传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * code传空格
	 */
	@Test
	public void postResetTransactionPasswordTestCodeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("mobile", 1);
		request.put("code", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("code传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * code传null
	 */
	@Test
	public void postResetTransactionPasswordTestCodeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("mobile", 1);
		request.put("code", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("code传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * code不传参数
	 */
	@Test
	public void postResetTransactionPasswordTestCodeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("mobile", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("code不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	
	
	
}
