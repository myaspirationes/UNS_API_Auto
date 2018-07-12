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

public class SetTransactionPasswordTest extends HttpUtil {
// 设置交易密码接口
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
	public void postSetTransactionPasswordTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postSetTransactionPasswordTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postSetTransactionPasswordTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postSetTransactionPasswordTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postSetTransactionPasswordTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postSetTransactionPasswordTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 999999999999999999L);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	
	
	/**
	 * walletId不传参数
	 */
	@Test
	public void postSetTransactionPasswordTestWalletIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空
	 */
	@Test
	public void postSetTransactionPasswordTestWalletIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", "");
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空格
	 */
	@Test
	public void postSetTransactionPasswordTestWalletIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", " ");
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传null
	 */
	@Test
	public void postSetTransactionPasswordTestWalletIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", null);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传超长
	 */
	@Test
	public void postSetTransactionPasswordTestWalletIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 999999999999999999L);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * newPwd传超长
	 */
	@Test
	public void postSetTransactionPasswordTestNewPwdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", "1254dnjjkdjjljdkj45443434343d43f4d3fdfdfdfd32f4fdfdfdfdfdf");
		request.put("newPwdCr", 1);
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("newPwd传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * newPwd传空
	 */
	@Test
	public void postSetTransactionPasswordTestNewPwdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", "");
		request.put("newPwdCr", 1);
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("newPwd传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * newPwd传空格
	 */
	@Test
	public void postSetTransactionPasswordTestNewPwdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", " ");
		request.put("newPwdCr", 1);
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("newPwd传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * newPwd传null
	 */
	@Test
	public void postSetTransactionPasswordTestNewPwdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", null);
		request.put("newPwdCr", 1);
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("newPwd传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * newPwd不传参数
	 */
	@Test
	public void postSetTransactionPasswordTestNewPwdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwdCr", 1);
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("newPwd不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	
	/**
	 * newPwdCr传null
	 */
	@Test
	public void postSetTransactionPasswordTestNewPwdCrIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", null);
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("newPwdCr传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * newPwdCr传空
	 */
	@Test
	public void postSetTransactionPasswordTestNewPwdCrIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", "");
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("newPwdCr传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * newPwdCr传空格
	 */
	@Test
	public void postSetTransactionPasswordTestNewPwdCrIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", " ");
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("newPwdCr传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * newPwdCr不传参数
	 */
	@Test
	public void postSetTransactionPasswordTestNewPwdCrIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("newPwdCr不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * newPwdCr传超长
	 */
	@Test
	public void postSetTransactionPasswordTestNewPwdCrIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", "31322gfgfdgfgfdg12124544hghfgggggfhghgh");
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("newPwdCr传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * type传空
	 */
	@Test
	public void postSetTransactionPasswordTestTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("type", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * type传空格
	 */
	@Test
	public void postSetTransactionPasswordTestTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("type", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * type传null
	 */
	@Test
	public void postSetTransactionPasswordTestTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("type", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * type不传参数
	 */
	@Test
	public void postSetTransactionPasswordTestTypeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * type传最大值
	 */
	@Test
	public void postSetTransactionPasswordTestTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("type", 999999999);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * type传1设置密码
	 */
	@Test
	public void postSetTransactionPasswordTestTypeIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传1设置密码" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * type传2重置密码
	 */
	@Test
	public void postSetTransactionPasswordTestTypeIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("newPwd", 1);
		request.put("newPwdCr", 1);
		request.put("type", 2);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传2重置密码" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	
	
	
}
