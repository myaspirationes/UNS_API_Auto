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

public class TransferForBankCardTest extends HttpUtil {
// 转账到银行卡接口
	String url = "/wallet-admin/enterpriseWalletPay/transferForBankCard";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postTransferForBankCardTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "120");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
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
	public void postTransferForBankCardTestUserIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1231231231231231231L);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "120");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postTransferForBankCardTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "120");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postTransferForBankCardTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "120");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postTransferForBankCardTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "120");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为不传
	 */
	@Test
	public void postTransferForBankCardTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "120");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * targetName为超长
	 */
	@Test
	public void postTransferForBankCardTestTargetNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试fgdgdgdg地方官梵蒂冈是法国风格豆腐干大概手动阀手动阀");
		request.put("walletId", 100);
		request.put("cardNo", "120");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("targetName为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * targetName为空
	 */
	@Test
	public void postTransferForBankCardTestTargetNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "");
		request.put("walletId", 100);
		request.put("cardNo", "120");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("targetName为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * targetName为空格
	 */
	@Test
	public void postTransferForBankCardTestTargetNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", " ");
		request.put("walletId", 100);
		request.put("cardNo", "120");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("targetName为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * targetName为null
	 */
	@Test
	public void postTransferForBankCardTestTargetNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", null);
		request.put("walletId", 100);
		request.put("cardNo", "120");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("targetName为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * targetName为不传
	 */
	@Test
	public void postTransferForBankCardTestTargetNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 100);
		request.put("cardNo", "120");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("targetName为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletId为空
	 */
	@Test
	public void postTransferForBankCardTestWalletIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", "");
		request.put("cardNo", "120");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletId为空格
	 */
	@Test
	public void postTransferForBankCardTestWalletIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", " ");
		request.put("cardNo", "120");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletId为null
	 */
	@Test
	public void postTransferForBankCardTestWalletIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", null);
		request.put("cardNo", "120");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletId为最大值
	 */
	@Test
	public void postTransferForBankCardTestWalletIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 999999999999999999L);
		request.put("cardNo", "120");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * walletId为不传
	 */
	@Test
	public void postTransferForBankCardTestWalletIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("cardNo", "120");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * cardNo为空
	 */
	@Test
	public void postTransferForBankCardTestCardNoIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("cardNo为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * cardNo为空格
	 */
	@Test
	public void postTransferForBankCardTestCardNoIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", " ");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("cardNo为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * cardNo为null
	 */
	@Test
	public void postTransferForBankCardTestCardNoIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", null);
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("cardNo为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * cardNo为超长
	 */
	@Test
	public void postTransferForBankCardTestCardNotIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456789456123012312545646");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("cardNo为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * cardNo为不传
	 */
	@Test
	public void postTransferForBankCardTestCardNoNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("cardNo为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * bankName为超长
	 */
	@Test
	public void postTransferForBankCardTestBankNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行的方法发给太化股份黑化肥挥发的豆腐干豆腐干地方非规定");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("bankName为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * bankName为空
	 */
	@Test
	public void postTransferForBankCardTestBankNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("bankName为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * bankName为空格
	 */
	@Test
	public void postTransferForBankCardTestBankNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", " ");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("bankName为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * bankName为null
	 */
	@Test
	public void postTransferForBankCardTestBankNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", null);
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("bankName为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * bankName为不传
	 */
	@Test
	public void postTransferForBankCardTestBankNameIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("bankName为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * transferRemark为超长
	 */
	@Test
	public void postTransferForBankCardTestTransferRemarkIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", null);
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("transferRemark为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * amount为空
	 */
	@Test
	public void postTransferForBankCardTestAmountIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", "");
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("amount为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * amount为空格
	 */
	@Test
	public void postTransferForBankCardTestAmountIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", " ");
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("amount为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * amount为null
	 */
	@Test
	public void postTransferForBankCardTestAmountIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", null);
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("amount为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * amount不传
	 */
	@Test
	public void postTransferForBankCardTestAmountIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("remark", "自动化测试转账");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("amount不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * remark为null
	 */
	@Test
	public void postTransferForBankCardTestRemarkIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", null);
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("remark为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * remark为空
	 */
	@Test
	public void postTransferForBankCardTestRemarkIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("remark为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * remark为空格
	 */
	@Test
	public void postTransferForBankCardTestRemarkIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", " ");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("remark为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * remark为不传
	 */
	@Test
	public void postTransferForBankCardTestRemarkIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("remark为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * charges为null
	 */
	@Test
	public void postTransferForBankCardTestChargesIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", null);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("charges为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * remark为超长
	 */
	@Test
	public void postTransferForBankCardTestRemarkIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "豆腐干风格和已经发大师傅地方风俗v负电荷高房价和显得十分受到广泛");
		request.put("charges", 100);
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("remark为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * charges为空
	 */
	@Test
	public void postTransferForBankCardTestChargesIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", "");
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("charges为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * charges为空格
	 */
	@Test
	public void postTransferForBankCardTestChargesIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", " ");
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("charges为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * charges为不传
	 */
	@Test
	public void postTransferForBankCardTestChargesIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("charges为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * charges为最大值
	 */
	@Test
	public void postTransferForBankCardTestChargesIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", "999999999999999999");
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("charges为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * pwdCr为null
	 */
	@Test
	public void postTransferForBankCardTestPwdCrIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", "100");
		request.put("passWord", "123456");
		request.put("pwdCr", null);
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pwdCr为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * pwdCr为空
	 */
	@Test
	public void postTransferForBankCardTestPwdCrIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", "100");
		request.put("passWord", "123456");
		request.put("pwdCr", "");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pwdCr为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * pwdCr为空格
	 */
	@Test
	public void postTransferForBankCardTestPwdCrIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", "100");
		request.put("passWord", "123456");
		request.put("pwdCr", " ");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pwdCr为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * pwdCr为不传
	 */
	@Test
	public void postTransferForBankCardTestPwdCrIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", "100");
		request.put("passWord", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pwdCr为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * pwdCr为超长
	 */
	@Test
	public void postTransferForBankCardTestPwdCrIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", "100");
		request.put("passWord", "123456");
		request.put("pwdCr", "dgdgsgfdgdfhryuytityzasfdsfsf");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pwdCr为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * passWord为超长
	 */
	@Test
	public void postTransferForBankCardTestPassWordIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", "100");
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("passWord为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * passWord为空
	 */
	@Test
	public void postTransferForBankCardTestPassWordIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", "100");
		request.put("passWord", "");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("passWord为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * passWord为空格
	 */
	@Test
	public void postTransferForBankCardTestPassWordIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", "100");
		request.put("passWord", " ");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("passWord为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * passWord为null
	 */
	@Test
	public void postTransferForBankCardTestPassWordIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", "100");
		request.put("passWord", null);
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("passWord为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * passWord为不传
	 */
	@Test
	public void postTransferForBankCardTestPassWordIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", "100");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("passWord为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * mobile为超长
	 */
	@Test
	public void postTransferForBankCardTestMobileIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", "100");
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "123456789101112");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * mobile为空
	 */
	@Test
	public void postTransferForBankCardTestMobileIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", "100");
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * mobile为空格
	 */
	@Test
	public void postTransferForBankCardTestMobileIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", "100");
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", " ");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * mobile为null
	 */
	@Test
	public void postTransferForBankCardTestMobileIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", "100");
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", null);
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * mobile为不传
	 */
	@Test
	public void postTransferForBankCardTestMobileIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", "100");
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("code", "2222");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mobile为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * code为超长
	 */
	@Test
	public void postTransferForBankCardTestCodeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", "100");
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "2222456765645453132132145");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("code为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * code为空
	 */
	@Test
	public void postTransferForBankCardTestCodeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", "100");
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("code为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * code为空格
	 */
	@Test
	public void postTransferForBankCardTestCodeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", "100");
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("code为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * code为null
	 */
	@Test
	public void postTransferForBankCardTestCodeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", "100");
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		request.put("code", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("code为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * code为不传
	 */
	@Test
	public void postTransferForBankCardTestCodeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("targetName", "自动化测试");
		request.put("walletId", 100);
		request.put("cardNo", "123456");
		request.put("bankName", "自动化测试银行");
		request.put("amount", 100);
		request.put("remark", "自动化测试转账");
		request.put("charges", "100");
		request.put("passWord", "123456");
		request.put("pwdCr", "123456");
		request.put("mobile", "12345678910");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("code为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
}
