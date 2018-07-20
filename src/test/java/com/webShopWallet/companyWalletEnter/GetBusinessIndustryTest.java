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

public class GetBusinessIndustryTest extends HttpUtil {
// 获取企业所属行业列表接口
	String url = "/wallet-admin/enterprise/getEnterpriseIndustry";

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetBusinessIndustryTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	
}
