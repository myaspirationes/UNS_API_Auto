package com.webShopWallet.companyWalletEnter;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.webShopWallet.companyWalletEnter.SaveCompanyMessageTest;
import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class SaveThePublicAccountMessageTest extends HttpUtil {
// 保存对公账户信息接口
	String url = "/wallet-admin/enterprise/savePublicAccount";
	String selEnBankCard = "SELECT * FROM T_ENTERPRISE_BANK_CARD WHERE ACCOUNT_NO = '自动化测试'";
	String selEnterprise = "SELECT * FROM T_ENTERPRISE WHERE ENTERPRISE_NAME = '自动化测试企业' OR ENTERPRISE_NAME = '自动化测试企业1'";
	String selEnterpriseInfo = "SELECT * FROM T_ENTERPRISE_INFO WHERE LEGAL_PERSON = '测试' OR LEGAL_PERSON  = '测试1'";
	String selEnterpriseWalletInfo = "SELECT * FROM T_ENTERPRISE_WALLET_INFO WHERE WALLET_ALIAS = '自动化测试钱包别名' OR WALLET_ALIAS = '自动化测试钱包别名1' ";
	String delEnterprise = "DELETE FROM T_ENTERPRISE WHERE ENTERPRISE_NAME = '自动化测试企业' OR ENTERPRISE_NAME = '自动化测试企业1'";
	String delEnterpriseInfo = "DELETE FROM T_ENTERPRISE_INFO WHERE LEGAL_PERSON = '测试' OR LEGAL_PERSON = '测试1'";
	String delEnterpriseWalletInfo = "DELETE FROM T_ENTERPRISE_WALLET_INFO WHERE WALLET_ALIAS = '自动化测试钱包别名' OR WALLET_ALIAS = '自动化测试钱包别名1'";
	String delEnBankCard = "DELETE FROM T_ENTERPRISE_BANK_CARD WHERE ACCOUNT_NO = '自动化测试'";
	List<Map<String,Object>> list ;
	String dataType = "wallet81";
	String walletId;
	String enterpriseId;
	//@BeforeClass
	//public void beforeclass() throws Exception{
		//new SaveCompanyMessageTest().postSaveCompanyMessageTestCorrectParameter();
		//list = MetaOper.read(selEnterpriseWalletInfo, dataType);
	    //walletId = list.get(0).get("WALLET_ID").toString();
		//enterpriseId = list.get(0).get("ENTERPRISE_ID").toString();
//}
	@AfterMethod
	public void aftermethod(){
		MetaOper.delete(delEnterprise,dataType);
		MetaOper.delete(delEnterpriseInfo,dataType);
		MetaOper.delete(delEnterpriseWalletInfo,dataType);
		MetaOper.delete(delEnBankCard,dataType);
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveThePublicAccountMessageTestCorrectParameter() throws Exception {
		new SaveCompanyMessageTest().postSaveCompanyMessageTestCorrectParameter();
		list = MetaOper.read(selEnterpriseWalletInfo, dataType);
	    walletId = list.get(0).get("WALLET_ID").toString();
		enterpriseId = list.get(0).get("ENTERPRISE_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", walletId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		request.put("enterpriseId", enterpriseId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selEnBankCard, dataType);
		assertThat(list.get(0).get("PROVINCE_ID").toString()).isEqualTo("3928");
		assertThat(list.get(0).get("CITY_ID").toString()).isEqualTo("1");
		assertThat(list.get(0).get("OPENING_BANK_NAME").toString()).isEqualTo("光大银行");
		assertThat(list.get(0).get("IS_DEFAULT").toString()).isEqualTo("0");
		assertThat(list.get(0).get("ACCOUNT_TYPE").toString()).isEqualTo("1");
	}
	
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postSaveThePublicAccountMessageTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postSaveThePublicAccountMessageTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postSaveThePublicAccountMessageTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postSaveThePublicAccountMessageTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postSaveThePublicAccountMessageTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 999999999999999999L);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	
	
	/**
	 * walletId不传参数
	 */
	@Test
	public void postSaveThePublicAccountMessageTestWalletIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空
	 */
	@Test
	public void postSaveThePublicAccountMessageTestWalletIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", "");
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空格
	 */
	@Test
	public void postSaveThePublicAccountMessageTestWalletIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", " ");
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传null
	 */
	@Test
	public void postSaveThePublicAccountMessageTestWalletIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", null);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传最大值
	 */
	@Test
	public void postSaveThePublicAccountMessageTestWalletIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", 999999999999999999L);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传最大值
	 */
	@Test
	public void postSaveThePublicAccountMessageTestEnterpriseIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", 999999999999999999L);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * enterpriseId传空
	 */
	@Test
	public void postSaveThePublicAccountMessageTestEnterpriseIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", "");
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传空格
	 */
	@Test
	public void postSaveThePublicAccountMessageTestentErpriseIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", " ");
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传null
	 */
	@Test
	public void postSaveThePublicAccountMessageTestEnterpriseIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", null);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId不传参数
	 */
	@Test
	public void postSaveThePublicAccountMessageTestEnterpriseIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传0新企业入驻
	 */
	@Test
	public void postSaveThePublicAccountMessageTestEnterpriseIdIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", 0);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传0新企业入驻" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传enterpriseId修改入驻信息
	 */
	@Test
	public void postSaveThePublicAccountMessageTestEnterpriseIdIsMofidy() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传enterpriseId修改入驻信息" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	
	/**
	 * accountNo传null
	 */
	@Test
	public void postSaveThePublicAccountMessageTestAccountNoIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", null);
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountNo传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * accountNo传空
	 */
	@Test
	public void postSaveThePublicAccountMessageTestAccountNoIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountNo传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * accountNo传空格
	 */
	@Test
	public void postSaveThePublicAccountMessageTestAccountNoIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", " ");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountNo传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * accountNo不传参数
	 */
	@Test
	public void postSaveThePublicAccountMessageTestAccountNoIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountNo不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * accountNo传最大值
	 */
	@Test
	public void postSaveThePublicAccountMessageTestAccountNoIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", 999999999999999999L);
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountNo传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * cardNo传最大值
	 */
	@Test
	public void postSaveThePublicAccountMessageTestCardNoIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", 999999999999999999L);
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("cardNo传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * cardNo传空
	 */
	@Test
	public void postSaveThePublicAccountMessageTestCardNoIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("cardNo传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * cardNo传空格
	 */
	@Test
	public void postSaveThePublicAccountMessageTestCardNoIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", " ");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("cardNo传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * cardNo传null
	 */
	@Test
	public void postSaveThePublicAccountMessageTestCardNoIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", null);
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("cardNo传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * cardNo不传参数
	 */
	@Test
	public void postSaveThePublicAccountMessageTestCardNoIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("cardNo不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * provinceId不传参数
	 */
	@Test
	public void postSaveThePublicAccountMessageTestProvinceIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("provinceId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * provinceId传空
	 */
	@Test
	public void postSaveThePublicAccountMessageTestProvinceIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", "");
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("provinceId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * provinceId传空格
	 */
	@Test
	public void postSaveThePublicAccountMessageTestProvinceIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", " ");
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("provinceId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * provinceId传null
	 */
	@Test
	public void postSaveThePublicAccountMessageTestProvinceIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", null);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("provinceId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * provinceId传最大值
	 */
	@Test
	public void postSaveThePublicAccountMessageTestProvinceIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 999999999999999999L);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("provinceId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * cityId传空
	 */
	@Test
	public void postSaveThePublicAccountMessageTestCityIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", "");
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("cityId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * cityId传空格
	 */
	@Test
	public void postSaveThePublicAccountMessageTestCityIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", " ");
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("cityId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * cityId传null
	 */
	@Test
	public void postSaveThePublicAccountMessageTestCityIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", null);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("cityId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * cityId不传参数
	 */
	@Test
	public void postSaveThePublicAccountMessageTestCityIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("cityId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * cityId传最大值
	 */
	@Test
	public void postSaveThePublicAccountMessageTestCityIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 999999999999999999L);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("cityId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * openingBankName传空
	 */
	@Test
	public void postSaveThePublicAccountMessageTestOpeningBankNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("openingBankName传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * openingBankName传空格
	 */
	@Test
	public void postSaveThePublicAccountMessageTestOpeningBankNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", " ");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("openingBankName传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * openingBankName传null
	 */
	@Test
	public void postSaveThePublicAccountMessageTestOpeningBankNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", null);
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("openingBankName传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * openingBankName不传参数
	 */
	@Test
	public void postSaveThePublicAccountMessageTestOpeningBankNameIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("openingBankName不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * openingBankName传最大值
	 */
	@Test
	public void postSaveThePublicAccountMessageTestOpeningBankNameIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", 999999999999999999L);
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("openingBankName传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * cardtype传空
	 */
	@Test
	public void postSaveThePublicAccountMessageTestCardtypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", "");
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("cardtype传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * cardtype传空格
	 */
	@Test
	public void postSaveThePublicAccountMessageTestCardtypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", " ");
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("cardtype传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * cardtype传null
	 */
	@Test
	public void postSaveThePublicAccountMessageTestCardtypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", null);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("cardtype传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * cardtype不传
	 */
	@Test
	public void postSaveThePublicAccountMessageTestCardtypeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("cardtype不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * cardtype传最大值
	 */
	@Test
	public void postSaveThePublicAccountMessageTestCardtypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 999999999999999999L);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("cardtype传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	* cardtype传0借记卡
    */
	@Test
	public void postSaveThePublicAccountMessageTestCardtypeIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 0);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("cardtype传0借记卡" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selEnBankCard, dataType);	
		assertThat(list.get(0).get("ACCOUNT_TYPE").toString()).isEqualTo("0");
	}
	/**
	 * cardtype传1结算账户
	 */
	@Test
	public void postSaveThePublicAccountMessageTestCardtypeIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("cardtype传1结算账户" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selEnBankCard, dataType);	
		assertThat(list.get(0).get("ACCOUNT_TYPE").toString()).isEqualTo("1");
	}
	/**
	 * isDefault传空
	 */
	@Test
	public void postSaveThePublicAccountMessageTestIsDefaultIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("isDefault传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * isDefault传空格
	 */
	@Test
	public void postSaveThePublicAccountMessageTestIsDefaultIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("isDefault传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * isDefault传null
	 */
	@Test
	public void postSaveThePublicAccountMessageTestIsDefaultIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("isDefault传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * isDefault不传
	 */
	@Test
	public void postSaveThePublicAccountMessageTestIsDefaultIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("isDefault不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * isDefault传最大值
	 */
	@Test
	public void postSaveThePublicAccountMessageTestIsDefaultIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 999999999999999999L);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("isDefault传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * isDefault传0不是默认账户
	 */
	@Test
	public void postSaveThePublicAccountMessageTestIsDefaultIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("isDefault传0不是默认账户" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selEnBankCard, dataType);		
		assertThat(list.get(0).get("IS_DEFAULT").toString()).isEqualTo("0");
	}
	/**
	 * isDefault传1是默认账户
	 */
	@Test
	public void postSaveThePublicAccountMessageTestIsDefaultIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId",12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		request.put("accountNo", "自动化测试");
		request.put("cardNo", "6226630602386574");
		request.put("provinceId", 3928);
		request.put("cityId", 1);
		request.put("openingBankName", "光大银行");
		request.put("cardtype", 1);
		request.put("isDefault", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("isDefault传1是默认账户" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selEnBankCard, dataType);	
		assertThat(list.get(0).get("IS_DEFAULT").toString()).isEqualTo("1");
	}
	
}
