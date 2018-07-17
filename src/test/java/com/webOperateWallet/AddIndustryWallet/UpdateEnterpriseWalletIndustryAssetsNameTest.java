package com.webOperateWallet.AddIndustryWallet;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class UpdateEnterpriseWalletIndustryAssetsNameTest extends HttpUtil {
// 修改钱包名称接口
	String url = "/walletEnterprise/UpdateEnterpriseWalletIndustryAssetsName";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postUpdateEnterpriseWalletIndustryAssetsNameTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		
		request.put("userId", userId);
		request.put("assetsDataList", 2);
		request.put("assetsName", 1);
		request.put("assetsKey", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postUpdateEnterpriseWalletIndustryAssetsNameTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("assetsDataList", 2);
		request.put("assetsName", 1);
		request.put("assetsKey", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postUpdateEnterpriseWalletIndustryAssetsNameTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("assetsDataList", 2);
		request.put("assetsName", 1);
		request.put("assetsKey", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postUpdateEnterpriseWalletIndustryAssetsNameTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("assetsDataList", 2);
		request.put("assetsName", 1);
		request.put("assetsKey", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postUpdateEnterpriseWalletIndustryAssetsNameTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("assetsDataList", 2);
		request.put("assetsName", 1);
		request.put("assetsKey", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postUpdateEnterpriseWalletIndustryAssetsNameTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 999999999999999999L);
		request.put("assetsDataList", 2);
		request.put("assetsName", 1);
		request.put("assetsKey", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * assetsDataList为空
	 */
	@Test
	public void postUpdateEnterpriseWalletIndustryAssetsNameTestAssetsDataListIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("assetsDataList", "");
		request.put("assetsName", 1);
		request.put("assetsKey", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("assetsDataList为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * assetsDataList为空格
	 */
	@Test
	public void postUpdateEnterpriseWalletIndustryAssetsNameTestAssetsDataListIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("assetsDataList", " ");
		request.put("assetsName", 1);
		request.put("assetsKey", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("assetsDataList为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * assetsDataList为null
	 */
	@Test
	public void postUpdateEnterpriseWalletIndustryAssetsNameTestAssetsDataListIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("assetsDataList", null);
		request.put("assetsName", 1);
		request.put("assetsKey", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("assetsDataList为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * assetsDataList不传
	 */
	@Test
	public void postUpdateEnterpriseWalletIndustryAssetsNameTestAssetsDataListIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("assetsName", 1);
		request.put("assetsKey", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("assetsDataList不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * assetsName为空
	 */
	@Test
	public void postUpdateEnterpriseWalletIndustryAssetsNameTestAssetsNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("assetsDataList", 2);
		request.put("assetsName", "");
		request.put("assetsKey", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("assetsName为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * assetsDataList为空格
	 */
	@Test
	public void postUpdateEnterpriseWalletIndustryAssetsNameTestAssetsNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("assetsDataList", 2);
		request.put("assetsName", " ");
		request.put("assetsKey", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("assetsDataList为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * assetsName为null
	 */
	@Test
	public void postUpdateEnterpriseWalletIndustryAssetsNameTestAssetsNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("assetsDataList", 2);
		request.put("assetsName", null);
		request.put("assetsKey", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("assetsName为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * assetsName为不传
	 */
	@Test
	public void postUpdateEnterpriseWalletIndustryAssetsNameTestAssetsNameIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("assetsDataList", 2);
		request.put("assetsKey", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("assetsName为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * assetsName为超长
	 */
	@Test
	public void postUpdateEnterpriseWalletIndustryAssetsNameTestAssetsNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("assetsDataList", 2);
		request.put("assetsName", "的方式反对犯得上梵蒂冈地方官大哥非规定");
		request.put("assetsKey", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("assetsName为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * assetsKey为最大值
	 */
	@Test
	public void postUpdateEnterpriseWalletIndustryAssetsNameTestAssetsKeyIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("assetsDataList", 2);
		request.put("assetsName", 1);
		request.put("assetsKey", 999999999);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("assetsKey为最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * assetsKey为null
	 */
	@Test
	public void postUpdateEnterpriseWalletIndustryAssetsNameTestAssetsKeyIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("assetsDataList", 2);
		request.put("assetsName", 1);
		request.put("assetsKey", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("assetsKey为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * assetsKey为空
	 */
	@Test
	public void postUpdateEnterpriseWalletIndustryAssetsNameTestAssetsKeyIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("assetsDataList", 2);
		request.put("assetsName", 1);
		request.put("assetsKey", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("assetsKey为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * assetsKey为空格
	 */
	@Test
	public void postUpdateEnterpriseWalletIndustryAssetsNameTestAssetsKeyIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("assetsDataList", 2);
		request.put("assetsName", 1);
		request.put("assetsKey", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("assetsKey为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * assetsKey为不传
	 */
	@Test
	public void postUpdateEnterpriseWalletIndustryAssetsNameTestAssetsKeyIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("assetsDataList", 2);
		request.put("assetsName", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("assetsKey为不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	
	
	
}
