package com.webShopWallet.accountManagement;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class SendCodeTest extends HttpUtil {
// 获取转账短信验证码接口
	String url = "/asset/SendCode";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postSendCodeTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 123);
		request.put("mobile", "12345678910");
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID最大值
	 */
	@Test
	public void postSendCodeTestUserIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1231231231231231231L);
		request.put("enterpriseId", 123);
		request.put("mobile", "12345678910");
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postSendCodeTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("enterpriseId", 123);
		request.put("mobile", "12345678910");
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postSendCodeTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("enterpriseId", 123);
		request.put("mobile", "12345678910");
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postSendCodeTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("enterpriseId", 123);
		request.put("mobile", "12345678910");
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为不传
	 */
	@Test
	public void postSendCodeTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("enterpriseId", 123);
		request.put("mobile", "12345678910");
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * enterpriseId为最大值
	 */
	@Test
	public void postSendCodeTestEnterpriseIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 999999999999999999L);
		request.put("mobile", "12345678910");
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * enterpriseId为空
	 */
	@Test
	public void postSendCodeTestEnterpriseIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", "");
		request.put("mobile", "12345678910");
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * enterpriseId为空格
	 */
	@Test
	public void postSendCodeTestEnterpriseIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", " ");
		request.put("mobile", "12345678910");
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * enterpriseId为null
	 */
	@Test
	public void postSendCodeTestEnterpriseIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", null);
		request.put("mobile", "12345678910");
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * enterpriseId为不传
	 */
	@Test
	public void postSendCodeTestEnterpriseIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("mobile", "12345678910");
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * mobile为空
	 */
	@Test
	public void postSendCodeTestMobileIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 123);
		request.put("mobile", "");
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * mobile为空格
	 */
	@Test
	public void postSendCodeTestMobileIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 123);
		request.put("mobile", " ");
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * mobile为null
	 */
	@Test
	public void postSendCodeTestMobileIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 123);
		request.put("mobile", null);
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * mobile为不传
	 */
	@Test
	public void postSendCodeTestMobileIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 123);
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * mobile为超长
	 */
	@Test
	public void postSendCodeTestWalletIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 123);
		request.put("mobile", "12345678910123456");
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为空
	 */
	@Test
	public void postSendCodeTestTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 123);
		request.put("mobile", "12345678910123456");
		request.put("type", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为空格
	 */
	@Test
	public void postSendCodeTestTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 123);
		request.put("mobile", "12345678910123456");
		request.put("type", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为null
	 */
	@Test
	public void postSendCodeTestTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 123);
		request.put("mobile", "12345678910123456");
		request.put("type", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为最大值
	 */
	@Test
	public void postSendCodeTestTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 123);
		request.put("mobile", "12345678910123456");
		request.put("type", 999999999);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为1提现
	 */
	@Test
	public void postSendCodeTestTypeIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 123);
		request.put("mobile", "12345678910123456");
		request.put("type", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为1提现" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为2转账
	 */
	@Test
	public void postSendCodeTestTypeIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 123);
		request.put("mobile", "12345678910123456");
		request.put("type", 2);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为2转账" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为3忘记密码
	 */
	@Test
	public void postSendCodeTestTypeIs3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 123);
		request.put("mobile", "12345678910123456");
		request.put("type", 3);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为3忘记密码" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为4绑卡
	 */
	@Test
	public void postSendCodeTestTypeIs4() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 123);
		request.put("mobile", "12345678910123456");
		request.put("type", 4);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为4绑卡" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * type为不传
	 */
	@Test
	public void postSendCodeTestTypeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 123);
		request.put("mobile", "12345678910123456");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
}
