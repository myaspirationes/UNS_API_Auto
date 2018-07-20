package com.webShopWallet.setting;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;
import com.webShopWallet.companyWalletEnter.SaveCompanyMessageTest;
import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class GetCompanyBasicInformationTest extends HttpUtil {
// 获取企业基本信息接口
	String url = "/wallet-admin/enterprise/getBasicEnterprise";
	String selEnterprise = "SELECT * FROM T_ENTERPRISE WHERE ENTERPRISE_NAME = '自动化测试企业' OR ENTERPRISE_NAME = '自动化测试企业1'";
	String selEnterpriseInfo = "SELECT * FROM T_ENTERPRISE_INFO WHERE LEGAL_PERSON = '测试' OR LEGAL_PERSON  = '测试1'";
	String selEnterpriseWalletInfo = "SELECT * FROM T_ENTERPRISE_WALLET_INFO WHERE WALLET_ALIAS = '自动化测试钱包别名' OR WALLET_ALIAS = '自动化测试钱包别名1' ";
	String delEnterprise = "DELETE FROM T_ENTERPRISE WHERE ENTERPRISE_NAME = '自动化测试企业' OR ENTERPRISE_NAME = '自动化测试企业1'";
	String delEnterpriseInfo = "DELETE FROM T_ENTERPRISE_INFO WHERE LEGAL_PERSON = '测试' OR LEGAL_PERSON = '测试1'";
	String delEnterpriseWalletInfo = "DELETE FROM T_ENTERPRISE_WALLET_INFO WHERE WALLET_ALIAS = '自动化测试钱包别名' OR WALLET_ALIAS = '自动化测试钱包别名1'";
	List<Map<String,Object>> list ;
	List<Map<String,Object>> list1 ;
	List<Map<String,Object>> list2 ;
	List<Map<String,Object>> list3 ;
	String dataType = "wallet81";
	String walletId;
	String enterpriseId;
	@BeforeClass
	public void beforeclass()throws Exception{
		new SaveCompanyMessageTest().postSaveCompanyMessageTestCorrectParameter();
		list = MetaOper.read(selEnterpriseWalletInfo, dataType);
	    walletId = list.get(0).get("WALLET_ID").toString();	
	    enterpriseId = list.get(0).get("ENTERPRISE_ID").toString();
	}
	@AfterClass
	public void aftermethod(){
		MetaOper.delete(delEnterprise,dataType);
		MetaOper.delete(delEnterpriseInfo,dataType);
		MetaOper.delete(delEnterpriseWalletInfo,dataType);
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveThePublicAccountMessageTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
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
		request.put("userId", 12495417);
		request.put("enterpriseId", enterpriseId);
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
		request.put("userId", 12495417);
		request.put("walletId", "");
		request.put("enterpriseId", enterpriseId);
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
		request.put("userId", 12495417);
		request.put("walletId", " ");
		request.put("enterpriseId", enterpriseId);
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
		request.put("userId", 12495417);
		request.put("walletId", null);
		request.put("enterpriseId", enterpriseId);
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
		request.put("userId", 12495417);
		request.put("walletId", 999999999999999999L);
		request.put("enterpriseId", enterpriseId);
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
		request.put("userId", 12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", 999999999999999999L);
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
		request.put("userId", 12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", "");
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
		request.put("userId", 12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", " ");
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
		request.put("userId", 12495417);
		request.put("walletId", walletId);
		request.put("enterpriseId", null);
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
		request.put("userId", 12495417);
		request.put("walletId", walletId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
}
