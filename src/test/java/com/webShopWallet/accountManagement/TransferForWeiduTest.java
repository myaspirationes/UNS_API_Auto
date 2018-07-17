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

public class TransferForWeiduTest extends HttpUtil {
// 转账到微度用户接口
	String url = "/wallet-admin/enterpriseWalletPay/transferForWeidu";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postTransferForWeiduTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID最大值
	 */
	@Test
	public void postTransferForWeiduTestUserIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1231231231231231231L);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postTransferForWeiduTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postTransferForWeiduTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postTransferForWeiduTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为不传
	 */
	@Test
	public void postTransferForWeiduTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("bankCardId", "bankCardId");
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * payeeAccount为超长
	 */
	@Test
	public void postTransferForWeiduTestPayeeAccountIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "123456789745631213103131");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payeeAccount为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * payeeAccount为空
	 */
	@Test
	public void postTransferForWeiduTestPayeeAccountIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payeeAccount为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * payeeAccount为空格
	 */
	@Test
	public void postTransferForWeiduTestPayeeAccountIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", " ");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payeeAccount为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * payeeAccount为null
	 */
	@Test
	public void postTransferForWeiduTestPayeeAccountIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", null);
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payeeAccount为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * payeeAccount为企业钱包
	 */
	@Test
	public void postTransferForWeiduTestPayeeAccountIsBusinessWallet() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "com");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payeeAccount为企业钱包" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * payeeAccount为个人用户
	 */
	@Test
	public void postTransferForWeiduTestPayeeAccountIsPersionalUser() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "12345678910");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payeeAccount为个人用户" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * payeeAccount为不传
	 */
	@Test
	public void postTransferForWeiduTestPayeeAccountNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payeeAccount为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletId为空
	 */
	@Test
	public void postTransferForWeiduTestWalletIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "12345678910");
		request.put("walletId", "");
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletId为空格
	 */
	@Test
	public void postTransferForWeiduTestWalletIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "12345678910");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", " ");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletId为null
	 */
	@Test
	public void postTransferForWeiduTestWalletIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "12345678910");
		request.put("walletId", null);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletId为最大值
	 */
	@Test
	public void postTransferForWeiduTestWalletIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "12345678910");
		request.put("walletId", 999999999999999999L);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletId为不传
	 */
	@Test
	public void postTransferForWeiduTestWalletIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "12345678910");
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * payeeName为空
	 */
	@Test
	public void postTransferForWeiduTestPayeeNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payeeName为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * payeeName为空格
	 */
	@Test
	public void postTransferForWeiduTestPayeeNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", " ");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payeeName为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * payeeName为null
	 */
	@Test
	public void postTransferForWeiduTestPayeeNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", null);
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payeeName为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * payeeName为超长
	 */
	@Test
	public void postTransferForWeiduTestPayeeNametIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试淡淡的灯光和黄金分割放松放松夫人太热不能涵盖空间空间和");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payeeName为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * payeeName为不传
	 */
	@Test
	public void postTransferForWeiduTestPayeeNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payeeName为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * money为最大值
	 */
	@Test
	public void postTransferForWeiduTestMoneyIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", 999999999999999999L);
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("money为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * money为空
	 */
	@Test
	public void postTransferForWeiduTestMoneyIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("money为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * money为空格
	 */
	@Test
	public void postTransferForWeiduTestMoneyIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", " ");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("money为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * money为null
	 */
	@Test
	public void postTransferForWeiduTestMoneyIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", null);
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("money为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * money为不传
	 */
	@Test
	public void postTransferForWeiduTestMoneyIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("money为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * transferRemark为超长
	 */
	@Test
	public void postTransferForWeiduTestTransferRemarkIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账的共和国很快就收到了看复活过来给甲方领导看见分级管理分局");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("transferRemark为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * transferRemark为空
	 */
	@Test
	public void postTransferForWeiduTestTransferRemarkIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("transferRemark为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * transferRemark为空格
	 */
	@Test
	public void postTransferForWeiduTestTransferRemarkIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", " ");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("transferRemark为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * transferRemark为null
	 */
	@Test
	public void postTransferForWeiduTestTransferRemarkIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", null);
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("transferRemark为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * transferRemark不传
	 */
	@Test
	public void postTransferForWeiduTestTransferRemarkIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("transferRemark不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * pwdCr为null
	 */
	@Test
	public void postTransferForWeiduTestPwdCrIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", null);
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pwdCr为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * pwdCr为空
	 */
	@Test
	public void postTransferForWeiduTestPwdCrIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pwdCr为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * pwdCr为空格
	 */
	@Test
	public void postTransferForWeiduTestPwdCrIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", " ");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pwdCr为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * pwdCr为不传
	 */
	@Test
	public void postTransferForWeiduTestPwdCrIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pwdCr为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * pwdCr为超长
	 */
	@Test
	public void postTransferForWeiduTestPwdCrIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "dfhdjfldjfdkjdlfjiueiuoiyoihdjnskdn");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pwdCr为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * passWord为超长
	 */
	@Test
	public void postTransferForWeiduTestPassWordIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "12345678945613213213dfddadsd");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("passWord为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * passWord为空
	 */
	@Test
	public void postTransferForWeiduTestPassWordIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("passWord为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * passWord为空格
	 */
	@Test
	public void postTransferForWeiduTestPassWordIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", " ");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("passWord为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * passWord为null
	 */
	@Test
	public void postTransferForWeiduTestPassWordIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", null);
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("passWord为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * passWord为不传
	 */
	@Test
	public void postTransferForWeiduTestPassWordIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("passWord为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * mobile为超长
	 */
	@Test
	public void postTransferForWeiduTestMobileIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910123456789");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * mobile为空
	 */
	@Test
	public void postTransferForWeiduTestMobileIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * mobile为空格
	 */
	@Test
	public void postTransferForWeiduTestMobileIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", " ");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * mobile为null
	 */
	@Test
	public void postTransferForWeiduTestMobileIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", null);
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * mobile为不传
	 */
	@Test
	public void postTransferForWeiduTestMobileIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("code", "2222");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * code为超长
	 */
	@Test
	public void postTransferForWeiduTestCodeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "222212345464546456456466");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("code为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * code为空
	 */
	@Test
	public void postTransferForWeiduTestCodeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("code为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * code为空格
	 */
	@Test
	public void postTransferForWeiduTestCodeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", " ");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("code为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * code为null
	 */
	@Test
	public void postTransferForWeiduTestCodeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", null);
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("code为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * code为不传
	 */
	@Test
	public void postTransferForWeiduTestCodeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("fee", "100");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("code为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手续费为空
	 */
	@Test
	public void postTransferForWeiduTestFeeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手续费为空格
	 */
	@Test
	public void postTransferForWeiduTestFeeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手续费为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手续费为null
	 */
	@Test
	public void postTransferForWeiduTestFeeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手续费为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手续费为最大值
	 */
	@Test
	public void postTransferForWeiduTestFeeisMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		request.put("fee", "99999999999999");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手续费为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 手续费为不传
	 */
	@Test
	public void postTransferForWeiduTestFeeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("payeeAccount", "bankCardId");
		request.put("walletId", 100);
		request.put("payeeName", "自动化测试");
		request.put("money", "自动化测试提现");
		request.put("transferRemark", "自动化测试转账");
		request.put("pwdCr", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手续费为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	
}
