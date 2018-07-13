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

public class SaveCompanyMessageTest extends HttpUtil {
// 保存企业信息接口
	String url = "/wallet-admin/enterprise/setEnterpriseInfo";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveCompanyMessageTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postSaveCompanyMessageTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postSaveCompanyMessageTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postSaveCompanyMessageTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postSaveCompanyMessageTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postSaveCompanyMessageTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 999999999999999999L);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	
	
	/**
	 * walletId不传参数
	 */
	@Test
	public void postSaveCompanyMessageTestWalletIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空
	 */
	@Test
	public void postSaveCompanyMessageTestWalletIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", "");
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空格
	 */
	@Test
	public void postSaveCompanyMessageTestWalletIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", " ");
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传null
	 */
	@Test
	public void postSaveCompanyMessageTestWalletIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", null);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传超长
	 */
	@Test
	public void postSaveCompanyMessageTestWalletIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 999999999999999999L);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传最大值
	 */
	@Test
	public void postSaveCompanyMessageTestEnterpriseIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 999999999999999999L);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * enterpriseId传空
	 */
	@Test
	public void postSaveCompanyMessageTestEnterpriseIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", "");
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传空格
	 */
	@Test
	public void postSaveCompanyMessageTestentErpriseIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", " ");
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传null
	 */
	@Test
	public void postSaveCompanyMessageTestEnterpriseIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", null);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId不传参数
	 */
	@Test
	public void postSaveCompanyMessageTestEnterpriseIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传0新企业入驻
	 */
	@Test
	public void postSaveCompanyMessageTestEnterpriseIdIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传0新企业入驻" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传enterpriseId修改入驻信息
	 */
	@Test
	public void postSaveCompanyMessageTestEnterpriseIdIsMofidy() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传enterpriseId修改入驻信息" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	
	/**
	 * walletAlias传null
	 */
	@Test
	public void postSaveCompanyMessageTestWalletAliasIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", null);
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletAlias传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletAlias传空
	 */
	@Test
	public void postSaveCompanyMessageTestWalletAliasIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletAlias传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletAlias传空格
	 */
	@Test
	public void postSaveCompanyMessageTestWalletAliasIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", " ");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletAlias传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletAlias不传参数
	 */
	@Test
	public void postSaveCompanyMessageTestWalletAliasIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletAlias不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletAlias传超长
	 */
	@Test
	public void postSaveCompanyMessageTestWalletAliasIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多df大幅度反对反对是否法大师傅大师傅反对犯得上犯得上发复古复古风格发热热");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletAlias传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * email传超长
	 */
	@Test
	public void postSaveCompanyMessageTestEmailIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "3090110512145131323456@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("email传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * email传空
	 */
	@Test
	public void postSaveCompanyMessageTestEmailIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("email传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * email传空格
	 */
	@Test
	public void postSaveCompanyMessageTestEmailIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", " ");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("email传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * email传null
	 */
	@Test
	public void postSaveCompanyMessageTestEmailIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", null);
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("email传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * email不传参数
	 */
	@Test
	public void postSaveCompanyMessageTestEmailIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("email不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * enterpriseName不传参数
	 */
	@Test
	public void postSaveCompanyMessageTestEnterpriseNameIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseName不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * enterpriseName传空
	 */
	@Test
	public void postSaveCompanyMessageTestEnterpriseNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseName传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * enterpriseName传空格
	 */
	@Test
	public void postSaveCompanyMessageTestEnterpriseNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", " ");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseName传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * enterpriseName传null
	 */
	@Test
	public void postSaveCompanyMessageTestEnterpriseNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", null);
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseName传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * enterpriseName传超长
	 */
	@Test
	public void postSaveCompanyMessageTestEnterpriseNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试等多个以哦儿童如果对方的广告费的统一体刚刚的功夫刚刚发生过");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseName传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * enterpriseAbbreviation传空
	 */
	@Test
	public void postSaveCompanyMessageTestEnterpriseAbbreviationIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseAbbreviation传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * enterpriseAbbreviation传空格
	 */
	@Test
	public void postSaveCompanyMessageTestEnterpriseAbbreviationIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", " ");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseAbbreviation传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * enterpriseAbbreviation传null
	 */
	@Test
	public void postSaveCompanyMessageTestEnterpriseAbbreviationIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", null);
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseAbbreviation传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * enterpriseAbbreviation不传参数
	 */
	@Test
	public void postSaveCompanyMessageTestEnterpriseAbbreviationIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseAbbreviation不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * enterpriseAbbreviation传超长
	 */
	@Test
	public void postSaveCompanyMessageTestEnterpriseAbbreviationIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "道德规范火箭加油i看过翻跟斗翻跟斗广泛大概的广告的风格复古风格感到反感");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseAbbreviation传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传空
	 */
	@Test
	public void postSaveCompanyMessageTestTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", "");
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传空格
	 */
	@Test
	public void postSaveCompanyMessageTestTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", " ");
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传null
	 */
	@Test
	public void postSaveCompanyMessageTestTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", null);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type不传参数
	 */
	@Test
	public void postSaveCompanyMessageTestTypeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传最大值
	 */
	@Test
	public void postSaveCompanyMessageTestTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 999999999);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传1有限责任公司
	 */
	@Test
	public void postSaveCompanyMessageTestTypeIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 1);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传1有限责任公司" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传2股份责任公司
	 */
	@Test
	public void postSaveCompanyMessageTestTypeIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 2);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传2股份责任公司" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传3个体工商户
	 */
	@Test
	public void postSaveCompanyMessageTestTypeIs3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 3);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传3个体工商户" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传4合资
	 */
	@Test
	public void postSaveCompanyMessageTestTypeIs4() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 4);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传4合资" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传5独资
	 */
	@Test
	public void postSaveCompanyMessageTestTypeIs5() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 5);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传5独资" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传6国有
	 */
	@Test
	public void postSaveCompanyMessageTestTypeIs6() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传6国有" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传7私营
	 */
	@Test
	public void postSaveCompanyMessageTestTypeIs7() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 7);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传7私营" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传8全名所有制
	 */
	@Test
	public void postSaveCompanyMessageTestTypeIs8() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 8);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传8全名所有制" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type传9集体所有制
	 */
	@Test
	public void postSaveCompanyMessageTestTypeIs9() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 9);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type传9集体所有制" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * industryId传空
	 */
	@Test
	public void postSaveCompanyMessageTestIndustryIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", "");
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("industryId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * industryId传空格
	 */
	@Test
	public void postSaveCompanyMessageTestIndustryIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", " ");
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("industryId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * industryId传null
	 */
	@Test
	public void postSaveCompanyMessageTestIndustryIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", null);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("industryId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * industryId不传
	 */
	@Test
	public void postSaveCompanyMessageTestIndustryIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("industryId不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * industryId传最大值
	 */
	@Test
	public void postSaveCompanyMessageTestIndustryIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 999999999999999999L);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("industryId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * unifiedSocialCreditCode传空
	 */
	@Test
	public void postSaveCompanyMessageTestUnifiedSocialCreditCodeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("unifiedSocialCreditCode传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * unifiedSocialCreditCode传空格
	 */
	@Test
	public void postSaveCompanyMessageTestUnifiedSocialCreditCodeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", " ");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("unifiedSocialCreditCode传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * unifiedSocialCreditCode传null
	 */
	@Test
	public void postSaveCompanyMessageTestUnifiedSocialCreditCodeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", null);
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("unifiedSocialCreditCode传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * unifiedSocialCreditCode不传
	 */
	@Test
	public void postSaveCompanyMessageTestUnifiedSocialCreditCodeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("unifiedSocialCreditCode不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * unifiedSocialCreditCode传超长
	 */
	@Test
	public void postSaveCompanyMessageTestUnifiedSocialCreditCodeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "132454787645313212121545454545545121212");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("unifiedSocialCreditCode传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * operatingPeriod传空
	 */
	@Test
	public void postSaveCompanyMessageTestOperatingPeriodIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operatingPeriod传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * operatingPeriod传空格
	 */
	@Test
	public void postSaveCompanyMessageTestOperatingPeriodIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", " ");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operatingPeriod传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * operatingPeriod传null
	 */
	@Test
	public void postSaveCompanyMessageTestOperatingPeriodIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", null);
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operatingPeriod传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * operatingPeriod不传
	 */
	@Test
	public void postSaveCompanyMessageTestOperatingPeriodIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operatingPeriod不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * operatingPeriod传最大值
	 */
	@Test
	public void postSaveCompanyMessageTestOperatingPeriodIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "9999-12-31");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operatingPeriod传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * operatingPeriod传超长
	 */
	@Test
	public void postSaveCompanyMessageTestOperatingPeriodIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "13321234564644444444444444444255562");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operatingPeriod传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * licenceNo传超长
	 */
	@Test
	public void postSaveCompanyMessageTestLicenceNoIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J469300041D3701123145D1212G1HG212Y1U21J21GF21");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("licenceNo传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * licenceNo传空
	 */
	@Test
	public void postSaveCompanyMessageTestLicenceNoIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("licenceNo传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * licenceNo传空格
	 */
	@Test
	public void postSaveCompanyMessageTestLicenceNoIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", " ");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("licenceNo传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * licenceNo传null
	 */
	@Test
	public void postSaveCompanyMessageTestLicenceNoIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", null);
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("licenceNo传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * licenceNo不传
	 */
	@Test
	public void postSaveCompanyMessageTestLicenceNoIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("licenceNo不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * legalPerson传超长
	 */
	@Test
	public void postSaveCompanyMessageTestLegalPersonIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试dg梵蒂冈的姑姑姑父国语研究会工作v成本v符合太化股份");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("legalPerson传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * legalPerson传空
	 */
	@Test
	public void postSaveCompanyMessageTestLegalPersonIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("legalPerson传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * legalPerson传空格
	 */
	@Test
	public void postSaveCompanyMessageTestLegalPersonIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", " ");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("legalPerson传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * legalPerson传null
	 */
	@Test
	public void postSaveCompanyMessageTestLegalPersonIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", null);
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("legalPerson传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * legalPerson不传
	 */
	@Test
	public void postSaveCompanyMessageTestLegalPersonIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("legalPerson不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * legalPersonMobile传超长
	 */
	@Test
	public void postSaveCompanyMessageTestLegalPersonMobileIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "1366186464113544456464654646566566655");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("legalPersonMobile传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * legalPersonMobile传空
	 */
	@Test
	public void postSaveCompanyMessageTestLegalPersonMobileIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("legalPersonMobile传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * legalPersonMobile传空格
	 */
	@Test
	public void postSaveCompanyMessageTestLegalPersonMobileIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", " ");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("legalPersonMobile传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * legalPersonMobile传null
	 */
	@Test
	public void postSaveCompanyMessageTestLegalPersonMobileIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", null);
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("legalPersonMobile传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * legalPersonMobile不传
	 */
	@Test
	public void postSaveCompanyMessageTestLegalPersonMobileIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("legalPersonMobile不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * legalPersonIdCardNo传超长
	 */
	@Test
	public void postSaveCompanyMessageTestLegalPersonIdCardNoIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519123164544645644579965223");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("legalPersonIdCardNo传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * legalPersonIdCardNo传空
	 */
	@Test
	public void postSaveCompanyMessageTestLegalPersonIdCardNoIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("legalPersonIdCardNo传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * legalPersonIdCardNo传空格
	 */
	@Test
	public void postSaveCompanyMessageTestLegalPersonIdCardNoIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", " ");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("legalPersonIdCardNo传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * legalPersonIdCardNo传null
	 */
	@Test
	public void postSaveCompanyMessageTestLegalPersonIdCardNoIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", null);
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("legalPersonIdCardNo传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * legalPersonIdCardNo不传
	 */
	@Test
	public void postSaveCompanyMessageTestLegalPersonIdCardNoIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("legalPersonIdCardNo不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * minIdCardValidityDate传超长
	 */
	@Test
	public void postSaveCompanyMessageTestMinIdCardValidityDateIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578123454644852121224546");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minIdCardValidityDate传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * minIdCardValidityDate不传
	 */
	@Test
	public void postSaveCompanyMessageTestMinIdCardValidityDateIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minIdCardValidityDate不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * minIdCardValidityDate传空
	 */
	@Test
	public void postSaveCompanyMessageTestMinIdCardValidityDateIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minIdCardValidityDate传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * minIdCardValidityDate传空格
	 */
	@Test
	public void postSaveCompanyMessageTestMinIdCardValidityDateIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", " ");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minIdCardValidityDate传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * minIdCardValidityDate传null
	 */
	@Test
	public void postSaveCompanyMessageTestMinIdCardValidityDateIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", null);
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minIdCardValidityDate传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * minIdCardValidityDate传最大值
	 */
	@Test
	public void postSaveCompanyMessageTestMinIdCardValidityDateIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "9999-12-31");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minIdCardValidityDate传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * maxIdCardValidityDate传最大值
	 */
	@Test
	public void postSaveCompanyMessageTestMaxIdCardValidityDateIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "9999-12-31");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxIdCardValidityDate传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * maxIdCardValidityDate不传
	 */
	@Test
	public void postSaveCompanyMessageTestMaxIdCardValidityDateIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxIdCardValidityDate不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * maxIdCardValidityDate传空
	 */
	@Test
	public void postSaveCompanyMessageTestMaxIdCardValidityDateIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxIdCardValidityDate传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * maxIdCardValidityDate传空格
	 */
	@Test
	public void postSaveCompanyMessageTestMaxIdCardValidityDateIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", " ");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxIdCardValidityDate传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * maxIdCardValidityDate传null
	 */
	@Test
	public void postSaveCompanyMessageTestMaxIdCardValidityDateIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", null);
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxIdCardValidityDate传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * maxIdCardValidityDate传超长
	 */
	@Test
	public void postSaveCompanyMessageTestMaxIdCardValidityDateIsLLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1234564465321231233565464564646");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxIdCardValidityDate传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * address传超长
	 */
	@Test
	public void postSaveCompanyMessageTestAddressIsLLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球Djdkfjj健康健康快乐建立覆盖就感觉偶然已退役士大夫看见路上洛杉矶发多少积分回复客户购房");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("address传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * address不传
	 */
	@Test
	public void postSaveCompanyMessageTestAddressIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("address不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * address传空
	 */
	@Test
	public void postSaveCompanyMessageTestAddressIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("address传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * address传空格
	 */
	@Test
	public void postSaveCompanyMessageTestAddressIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", " ");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("address传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * address传null
	 */
	@Test
	public void postSaveCompanyMessageTestAddressIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", null);
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("address传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * mccId传空
	 */
	@Test
	public void postSaveCompanyMessageTestMccIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", "");
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mccId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * mccId传空格
	 */
	@Test
	public void postSaveCompanyMessageTestMccIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", " ");
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mccId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * mccId传null
	 */
	@Test
	public void postSaveCompanyMessageTestMccIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", null);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mccId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * mccId不传
	 */
	@Test
	public void postSaveCompanyMessageTestMccIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mccId不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * mccId传最大值
	 */
	@Test
	public void postSaveCompanyMessageTestMccIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 999999999999999999L);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("mccId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * businessScope传空格
	 */
	@Test
	public void postSaveCompanyMessageTestBusinessScopeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", " ");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("businessScope传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * businessScope传空
	 */
	@Test
	public void postSaveCompanyMessageTestBusinessScopeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("businessScope传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * businessScope传null
	 */
	@Test
	public void postSaveCompanyMessageTestBusinessScopeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", null);
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("businessScope传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * businessScope不传
	 */
	@Test
	public void postSaveCompanyMessageTestBusinessScopeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("businessScope不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * businessScope传超长
	 */
	@Test
	public void postSaveCompanyMessageTestBusinessScopeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "大刀阔斧和谁i为瑞芳军事对抗JFK时代就开始罚款乱收费大师傅艰苦拉萨JFK的加分的考生加分");
		request.put("websiteAddress", "www.998.com");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("businessScope传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * websiteAddress传超长
	 */
	@Test
	public void postSaveCompanyMessageTestWebsiteAddressIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "www.998.comhjkjkjkjkojkkjknknnhjljkl");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("websiteAddress传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * websiteAddress传空
	 */
	@Test
	public void postSaveCompanyMessageTestWebsiteAddressIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("websiteAddress传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * websiteAddress传空格
	 */
	@Test
	public void postSaveCompanyMessageTestWebsiteAddressIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("websiteAddress传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * websiteAddress传null
	 */
	@Test
	public void postSaveCompanyMessageTestWebsiteAddressIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		request.put("websiteAddress", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("websiteAddress传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * websiteAddress不传
	 */
	@Test
	public void postSaveCompanyMessageTestWebsiteAddressIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("walletAlias", "钱多多");
		request.put("email", "30901105@qq.com");
		request.put("enterpriseName", "自动化测试");
		request.put("enterpriseAbbreviation", "自动化");
		request.put("type", 6);
		request.put("industryId", 1);
		request.put("unifiedSocialCreditCode", "91350100M000100Y43");
		request.put("operatingPeriod", "1529784045140");
		request.put("licenceNo", "J4693000413701");
		request.put("legalPerson", "测试");
		request.put("legalPersonMobile", "13661864641");
		request.put("legalPersonIdCardNo", "130321860311519");
		request.put("minIdCardValidityDate", "1528705838578");
		request.put("maxIdCardValidityDate", "1529784045140");
		request.put("address", "地球");
		request.put("mccId", 1);
		request.put("businessScope", "中国");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("websiteAddress不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
}
