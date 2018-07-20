package com.webShopWallet.companyWalletEnter;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class SaveEnclosureMessageTest extends HttpUtil {
// 保存附件信息接口
	String url = "/wallet-admin/enterprise/setEnterpriseAttachment";
	String selEnterpriseInfo = "SELECT * FROM T_ENTERPRISE_INFO WHERE LEGAL_PERSON = '测试' OR LEGAL_PERSON  = '测试1'";
	String selEnterpriseWalletInfo = "SELECT * FROM T_ENTERPRISE_WALLET_INFO WHERE WALLET_ALIAS = '自动化测试钱包别名' OR WALLET_ALIAS = '自动化测试钱包别名1' ";
	String delEnterprise = "DELETE FROM T_ENTERPRISE WHERE ENTERPRISE_NAME = '自动化测试企业' OR ENTERPRISE_NAME = '自动化测试企业1'";
	String delEnterpriseInfo = "DELETE FROM T_ENTERPRISE_INFO WHERE LEGAL_PERSON = '测试' OR LEGAL_PERSON = '测试1'";
	String delEnterpriseWalletInfo = "DELETE FROM T_ENTERPRISE_WALLET_INFO WHERE WALLET_ALIAS = '自动化测试钱包别名' OR WALLET_ALIAS = '自动化测试钱包别名1'";
	List<Map<String,Object>> list ;
	String dataType = "wallet81";
	String userId;
	@AfterMethod
	public void aftermethod(){
		MetaOper.delete(delEnterprise,dataType);
		MetaOper.delete(delEnterpriseInfo,dataType);
		MetaOper.delete(delEnterpriseWalletInfo,dataType);
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveEnclosureMessageTestCorrectParameter() throws Exception {
		new SaveCompanyMessageTest().postSaveCompanyMessageTestCorrectParameter();
		list = MetaOper.read(selEnterpriseWalletInfo, dataType);
		String walletId = list.get(0).get("WALLET_ID").toString();
		String enterpriseId = list.get(0).get("ENTERPRISE_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		request.put("isSave", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selEnterpriseInfo, dataType);
		assertThat(list.get(0).get("BUSINESS_LICENSE_FILE_ID").toString()).isEqualTo("1");
		assertThat(list.get(0).get("LICENCE_NO_FILE_ID").toString()).isEqualTo("1");
		assertThat(list.get(0).get("HOLD_BUSINESS_LICENSE_FILE_ID").toString()).isEqualTo("1");
		assertThat(list.get(0).get("IDCARD_POSITIVE_FILE_ID").toString()).isEqualTo("1");
		assertThat(list.get(0).get("IDCARD_SIDE_FILE_ID").toString()).isEqualTo("1");
		assertThat(list.get(0).get("OFFICE_SCENE_FILE_ID").toString()).isEqualTo("1");
	}
	
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postSaveEnclosureMessageTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postSaveEnclosureMessageTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postSaveEnclosureMessageTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postSaveEnclosureMessageTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postSaveEnclosureMessageTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 999999999999999999L);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	
	
	/**
	 * walletId不传参数
	 */
	@Test
	public void postSaveEnclosureMessageTestWalletIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空
	 */
	@Test
	public void postSaveEnclosureMessageTestWalletIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", "");
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空格
	 */
	@Test
	public void postSaveEnclosureMessageTestWalletIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", " ");
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传null
	 */
	@Test
	public void postSaveEnclosureMessageTestWalletIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", null);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传超长
	 */
	@Test
	public void postSaveEnclosureMessageTestWalletIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 999999999999999999L);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传最大值
	 */
	@Test
	public void postSaveEnclosureMessageTestEnterpriseIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 999999999999999999L);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * enterpriseId传空
	 */
	@Test
	public void postSaveEnclosureMessageTestEnterpriseIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", "");
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传空格
	 */
	@Test
	public void postSaveEnclosureMessageTestentErpriseIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", " ");
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传null
	 */
	@Test
	public void postSaveEnclosureMessageTestEnterpriseIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", null);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId不传参数
	 */
	@Test
	public void postSaveEnclosureMessageTestEnterpriseIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传0新企业入驻
	 */
	@Test
	public void postSaveEnclosureMessageTestEnterpriseIdIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传0新企业入驻" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传enterpriseId修改入驻信息
	 */
	@Test
	public void postSaveEnclosureMessageTestEnterpriseIdIsMofidy() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传enterpriseId修改入驻信息" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	
	/**
	 * certificateFileId传null
	 */
	@Test
	public void postSaveEnclosureMessageTestCertificateFileIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", null);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("certificateFileId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * certificateFileId传空
	 */
	@Test
	public void postSaveEnclosureMessageTestCertificateFileIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", "");
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("certificateFileId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * certificateFileId传空格
	 */
	@Test
	public void postSaveEnclosureMessageTestCertificateFileIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", " ");
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("certificateFileId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * certificateFileId不传参数
	 */
	@Test
	public void postSaveEnclosureMessageTestCertificateFileIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("certificateFileId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * certificateFileId传最大值
	 */
	@Test
	public void postSaveEnclosureMessageTestCertificateFileIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 999999999999999999L);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("certificateFileId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * businessLicensefileId传最大值
	 */
	@Test
	public void postSaveEnclosureMessageTestBusinessLicensefileIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 999999999999999999L);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("businessLicensefileId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * businessLicensefileId传空
	 */
	@Test
	public void postSaveEnclosureMessageTestBusinessLicensefileIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", "");
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("businessLicensefileId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * businessLicensefileId传空格
	 */
	@Test
	public void postSaveEnclosureMessageTestBusinessLicensefileIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", " ");
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("businessLicensefileId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * businessLicensefileId传null
	 */
	@Test
	public void postSaveEnclosureMessageTestBusinessLicensefileIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", null);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("businessLicensefileId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * businessLicensefileId不传参数
	 */
	@Test
	public void postSaveEnclosureMessageTestBusinessLicensefileIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("businessLicensefileId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * licenceNoFileId不传参数
	 */
	@Test
	public void postSaveEnclosureMessageTestLicenceNoFileIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("licenceNoFileId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * licenceNoFileId传空
	 */
	@Test
	public void postSaveEnclosureMessageTestLicenceNoFileIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", "");
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("licenceNoFileId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * licenceNoFileId传空格
	 */
	@Test
	public void postSaveEnclosureMessageTestLicenceNoFileIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", " ");
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("licenceNoFileId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * licenceNoFileId传null
	 */
	@Test
	public void postSaveEnclosureMessageTestLicenceNoFileIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", null);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("licenceNoFileId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * licenceNoFileId传最大值
	 */
	@Test
	public void postSaveEnclosureMessageTestLicenceNoFileIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 999999999999999999L);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("licenceNoFileId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * holdBusinessLicenseFileId传空
	 */
	@Test
	public void postSaveEnclosureMessageTestHoldBusinessLicenseFileIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", "");
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("holdBusinessLicenseFileId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * holdBusinessLicenseFileId传空格
	 */
	@Test
	public void postSaveEnclosureMessageTestHoldBusinessLicenseFileIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", " ");
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("holdBusinessLicenseFileId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * holdBusinessLicenseFileId传null
	 */
	@Test
	public void postSaveEnclosureMessageTestHoldBusinessLicenseFileIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", null);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("holdBusinessLicenseFileId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * holdBusinessLicenseFileId不传参数
	 */
	@Test
	public void postSaveEnclosureMessageTestHoldBusinessLicenseFileIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("holdBusinessLicenseFileId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * holdBusinessLicenseFileId传最大值
	 */
	@Test
	public void postSaveEnclosureMessageTestHoldBusinessLicenseFileIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 999999999999999999L);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("holdBusinessLicenseFileId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * idcardPositiveFileId传空
	 */
	@Test
	public void postSaveEnclosureMessageTestIdcardPositiveFileIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", "");
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("idcardPositiveFileId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * idcardPositiveFileId传空格
	 */
	@Test
	public void postSaveEnclosureMessageTestIdcardPositiveFileIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", " ");
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("idcardPositiveFileId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * idcardPositiveFileId传null
	 */
	@Test
	public void postSaveEnclosureMessageTestIdcardPositiveFileIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", null);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("idcardPositiveFileId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * idcardPositiveFileId不传参数
	 */
	@Test
	public void postSaveEnclosureMessageTestIdcardPositiveFileIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("idcardPositiveFileId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * idcardPositiveFileId传最大值
	 */
	@Test
	public void postSaveEnclosureMessageTestIdcardPositiveFileIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 999999999999999999L);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("idcardPositiveFileId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * idcardSideFileId传空
	 */
	@Test
	public void postSaveEnclosureMessageTestIdcardSideFileIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", "");
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("idcardSideFileId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * idcardSideFileId传空格
	 */
	@Test
	public void postSaveEnclosureMessageTestIdcardSideFileIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", " ");
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("idcardSideFileId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * idcardSideFileId传null
	 */
	@Test
	public void postSaveEnclosureMessageTestIdcardSideFileIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", null);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("idcardSideFileId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * idcardSideFileId不传
	 */
	@Test
	public void postSaveEnclosureMessageTestIdcardSideFileIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("idcardSideFileId不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * idcardSideFileId传最大值
	 */
	@Test
	public void postSaveEnclosureMessageTestIdcardSideFileIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 999999999999999999L);
		request.put("officeScenefileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("idcardSideFileId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * officeScenefileId传空
	 */
	@Test
	public void postSaveEnclosureMessageTestOfficeScenefileIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", "");
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("officeScenefileId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * officeScenefileId传空格
	 */
	@Test
	public void postSaveEnclosureMessageTestOfficeScenefileIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", " ");
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("officeScenefileId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * officeScenefileId传null
	 */
	@Test
	public void postSaveEnclosureMessageTestOfficeScenefileIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 999999999999999999L);
		request.put("officeScenefileId", null);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("officeScenefileId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * officeScenefileId不传
	 */
	@Test
	public void postSaveEnclosureMessageTestOfficeScenefileIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("officeScenefileId不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * officeScenefileId传最大值
	 */
	@Test
	public void postSaveEnclosureMessageTestOfficeScenefileIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 999999999999999999L);
		request.put("logoId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("officeScenefileId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * logoId传空
	 */
	@Test
	public void postSaveEnclosureMessageTestLogoIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("logoId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * logoId传空格
	 */
	@Test
	public void postSaveEnclosureMessageTestLogoIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("logoId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * logoId传null
	 */
	@Test
	public void postSaveEnclosureMessageTestLogoIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("logoId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * logoId不传
	 */
	@Test
	public void postSaveEnclosureMessageTestLogoIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("logoId不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * logoId传最大值
	 */
	@Test
	public void postSaveEnclosureMessageTestLogoIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 1);
		request.put("certificateFileId", 1);
		request.put("businessLicensefileId", 1);
		request.put("licenceNoFileId", 1);
		request.put("holdBusinessLicenseFileId", 1);
		request.put("idcardPositiveFileId", 1);
		request.put("idcardSideFileId", 1);
		request.put("officeScenefileId", 1);
		request.put("logoId", 999999999999999999L);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("logoId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
}
