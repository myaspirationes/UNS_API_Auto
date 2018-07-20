package com.webShopWallet.companyWalletEnter;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class GetEnterMessageDetailsTest extends HttpUtil {
// 获取入驻信息详情接口
	String url = "/wallet-admin/enterprise/getBasicEnterprise";
	String selEnterprise = "SELECT * FROM T_ENTERPRISE WHERE ENTERPRISE_NAME = '自动化测试企业' OR ENTERPRISE_NAME = '自动化测试企业1'";
	String selEnterpriseInfo = "SELECT * FROM T_ENTERPRISE_INFO WHERE LEGAL_PERSON = '测试' OR LEGAL_PERSON  = '测试1'";
	String selEnterpriseWalletInfo = "SELECT * FROM T_ENTERPRISE_WALLET_INFO WHERE WALLET_ALIAS = '自动化测试钱包别名' OR WALLET_ALIAS = '自动化测试钱包别名1' ";
	String delEnterprise = "DELETE FROM T_ENTERPRISE WHERE ENTERPRISE_NAME = '自动化测试企业' OR ENTERPRISE_NAME = '自动化测试企业1'";
	String delEnterpriseInfo = "DELETE FROM T_ENTERPRISE_INFO WHERE LEGAL_PERSON = '测试' OR LEGAL_PERSON = '测试1'";
	String delEnterpriseWalletInfo = "DELETE FROM T_ENTERPRISE_WALLET_INFO WHERE WALLET_ALIAS = '自动化测试钱包别名' OR WALLET_ALIAS = '自动化测试钱包别名1'";
	List<Map<String,Object>> list ;
	String dataType = "wallet81";
	String walletId;
	String enterpriseId;
	@BeforeClass
	public void beforeclass() throws Exception{
		new SaveCompanyMessageTest().postSaveCompanyMessageTestCorrectParameter();
		list = MetaOper.read(selEnterpriseWalletInfo, dataType);
	    walletId = list.get(0).get("WALLET_ID").toString();	
	    enterpriseId = list.get(0).get("ENTERPRISE_ID").toString();	
}
	@AfterClass 
	public void afterclass(){
		MetaOper.delete(delEnterprise,dataType);
		MetaOper.delete(delEnterpriseInfo,dataType);
		MetaOper.delete(delEnterpriseWalletInfo,dataType);
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetEnterMessageDetailsTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", walletId);
		request.put("enterpriseId", enterpriseId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	

	
	/**
	 * walletId不传参数
	 */
	@Test
	public void postGetEnterMessageDetailsTestWalletIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
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
	public void postGetEnterMessageDetailsTestWalletIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
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
	public void postGetEnterMessageDetailsTestWalletIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
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
	public void postGetEnterMessageDetailsTestWalletIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
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
	public void postGetEnterMessageDetailsTestWalletIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
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
	public void postGetEnterMessageDetailsTestEnterpriseIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
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
	public void postGetEnterMessageDetailsTestEnterpriseIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
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
	public void postGetEnterMessageDetailsTestentErpriseIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
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
	public void postGetEnterMessageDetailsTestEnterpriseIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
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
	public void postGetEnterMessageDetailsTestEnterpriseIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", walletId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}

	
}
