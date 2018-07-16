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

public class BindBankCardTest extends HttpUtil {
// 获取企业钱包详情接口
	String url = "/enterpriseWalletAssets/bindBankCard";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");//预计无法测试需要开发给出万能验证码
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID最大值
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestUserIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1231231231231231231L);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为不传
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * 钱包ID为最大值
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestWallrtIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 1717171717117171717L);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 钱包ID为空
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestWallrtIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", "");
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("钱包ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 钱包ID为空格
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestWallrtIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", " ");
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("钱包ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 钱包ID为null
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestWallrtIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", null);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("钱包ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 钱包ID为不传
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestWallrtIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("钱包ID为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 银行卡ID为空
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestCardNoIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("银行卡ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 银行卡ID为空格
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestCardNoIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", " ");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("银行卡ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 银行卡ID为null
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestCardNoIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", null);
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("银行卡ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 银行卡ID为最大值
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestCardNoIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", 1231231231231231231L);
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("银行卡ID为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 银行卡ID为不传
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestCardNoNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("银行卡ID为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * 银生宝银行卡ID为最大值
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestOpeningBankNameIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", 1231231211113123123L);
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("银生宝银行卡ID为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 银生宝银行卡ID为空
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestOpeningBankNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("银生宝银行卡ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 银生宝银行卡ID为空格
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestOpeningBankNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", " ");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("银生宝银行卡ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}/**
	 * 银生宝银行卡ID为null
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestOpeningBankNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", null);
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("银生宝银行卡ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 银生宝银行卡ID为不传
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestOpeningBankNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("银生宝银行卡ID为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * 类型为0对公账户
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestAccountTypeIsPublic() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 0);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型为0对公账户" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型为1个人
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestAccountTypeIsPersonal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型为1个人" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型为最大值
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestAccountTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1111111111111111111L);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型为空
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestAccountTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", "");
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型为空格
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestAccountTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", " ");
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型为null
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestAccountTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", null);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 类型为不传
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestAccountTypeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("类型为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 姓名为空
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestPersonNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("姓名为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 姓名为空格
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestPersonNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", " ");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("姓名为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 姓名为null
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestPersonNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", null);
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("姓名为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 姓名为最大值
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestPersonNameIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personNamepersonNamepersonNamepersonNamepersonNamepersonName");//根据数据库字段最大值来传入参数
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("姓名为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 姓名为不传
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestPersonNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 身份证为最大值
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestPapersNoIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");//根据数据字段设置为传入最大值参数
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("身份证为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 身份证为空格
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestPapersNoIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", " ");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("身份证为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 身份证为空
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestPapersNoIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("身份证为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 身份证为null
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestPapersNoIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", null);
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("身份证为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 身份证为不传
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestPapersNoNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("validCode", "validCode");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 验证码为空
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestValidCodeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("验证码为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 验证码为空格
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestValidCodeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("验证码为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 验证码为null
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestValidCodeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("验证码为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 验证码为最大值
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestValidCodeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		request.put("validCode", "validCodevalidCodevalidCode");//根据数据字段设置最大值来传入
		JSONObject post = super.UNSPost(url, request);
		System.out.println("验证码为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 验证码为不传
	 */
	@Test
	public void postDeleteEnterpriseBankCardTestValidCodeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("wallrtId", 17);
		request.put("cardNo", "cardNo");
		request.put("openingBankName", "openingBankName");
		request.put("accountType", 1);
		request.put("personName", "personName");
		request.put("papersNo", "310112198708273611");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("验证码为不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}


	
}
