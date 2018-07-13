package com.webShopWallet.messageCenter;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class GetMessageDetailsTest extends HttpUtil {
// 搜索获取消息中心列表接口
	String url = "/";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetMessageDetailsTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("recordId", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postGetMessageDetailsTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("recordId", 0);	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postGetMessageDetailsTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("recordId", 0);	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postGetMessageDetailsTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("recordId", 0);	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postGetMessageDetailsTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("recordId", 0);	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postGetMessageDetailsTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 999999999999999999L);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("recordId", 0);	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	
	/**
	 * walletId不传参数
	 */
	@Test
	public void postGetMessageDetailsTestWalletIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("enterpriseId", 0);
		request.put("recordId", 0);	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空
	 */
	@Test
	public void postGetMessageDetailsTestWalletIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", "");
		request.put("enterpriseId", 0);
		request.put("recordId", 0);	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空格
	 */
	@Test
	public void postGetMessageDetailsTestWalletIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", " ");
		request.put("enterpriseId", 0);
		request.put("recordId", 0);	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传null
	 */
	@Test
	public void postGetMessageDetailsTestWalletIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", null);
		request.put("enterpriseId", 0);
		request.put("recordId", 0);	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传最大值
	 */
	@Test
	public void postGetMessageDetailsTestWalletIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 999999999999999999L);
		request.put("enterpriseId", 0);
		request.put("recordId", 0);	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传最大值
	 */
	@Test
	public void postGetMessageDetailsTestEnterpriseIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 999999999999999999L);
		request.put("recordId", 0);	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传空
	 */
	@Test
	public void postGetMessageDetailsTestEnterpriseIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", "");
		request.put("recordId", 0);	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传空格
	 */
	@Test
	public void postGetMessageDetailsTestEnterpriseIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", " ");
		request.put("recordId", 0);	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId传null
	 */
	@Test
	public void postGetMessageDetailsTestEnterpriseIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", null);
		request.put("recordId", 0);	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseId不传参数
	 */
	@Test
	public void postGetMessageDetailsTestEnterpriseIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("recordId", 0);	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * recordId传null
	 */
	@Test
	public void postGetMessageDetailsTestRecordIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("recordId", null);	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("recordId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * recordId传空
	 */
	@Test
	public void postGetMessageDetailsTestRecordIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("recordId", "");	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("recordId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * recordId传空格
	 */
	@Test
	public void postGetMessageDetailsTestRecordIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("recordId", " ");	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("recordId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * recordId不传
	 */
	@Test
	public void postGetMessageDetailsTestRecordIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("recordId不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * recordId传最大值
	 */
	@Test
	public void postGetMessageDetailsTestRecordIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("enterpriseId", 0);
		request.put("recordId", 999999999999999999L);	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("recordId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
}
