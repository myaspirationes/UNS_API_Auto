package com.webShopWallet.staffAndAuthorityManagement;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class CheckMobileTest extends HttpUtil {
// 检验手机号接口
	String url = "/wallet-admin/enterprise/checkMobile";

	/**
	 * 提交正确参数
	 */
	@Test
	public void postCheckMobileTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("mobile", "13774323645");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * mobile为空格
	 */
	@Test
	public void postCheckMobileTestMobileIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("mobile", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * mobile为空
	 */
	@Test
	public void postCheckMobileTestMobileIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("mobile", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * mobile为null
	 */
	@Test
	public void postCheckMobileTestMobileIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("mobile", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * mobile不传该参数
	 */
	@Test
	public void postCheckMobileTestMobileNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * mobile为超长
	 */
	@Test
	public void postCheckMobileTestMobileIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("mobile", "1234567891321454454465645");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	
}
