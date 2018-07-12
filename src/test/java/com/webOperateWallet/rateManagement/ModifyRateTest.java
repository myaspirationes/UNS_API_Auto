package com.webOperateWallet.rateManagement;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class ModifyRateTest extends HttpUtil {
// 修改费率接口
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
	public void postModifyRateTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 1);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postModifyRateTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 1);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postModifyRateTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 1);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postModifyRateTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 1);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postModifyRateTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 1);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postModifyRateTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 999999999999999999L);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 1);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	
	
	/**
	 * walletId不传参数
	 */
	@Test
	public void postModifyRateTestWalletIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 1);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空
	 */
	@Test
	public void postModifyRateTestWalletIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", "");
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 1);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空格
	 */
	@Test
	public void postModifyRateTestWalletIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", " ");
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 1);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传null
	 */
	@Test
	public void postModifyRateTestWalletIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", null);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 1);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传超长
	 */
	@Test
	public void postModifyRateTestWalletIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 999999999999999999L);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 1);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * changeId传最大值
	 */
	@Test
	public void postModifyRateTestChangeIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 999999999999999999L);
		request.put("style", 1);
		request.put("transactionType", 1);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("changeId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * changeId传空
	 */
	@Test
	public void postModifyRateTestChangeIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", "");
		request.put("style", 1);
		request.put("transactionType", 1);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("changeId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * changeId传空格
	 */
	@Test
	public void postModifyRateTestChangeIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", " ");
		request.put("style", 1);
		request.put("transactionType", 1);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("changeId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * changeId传null
	 */
	@Test
	public void postModifyRateTestChangeIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", null);
		request.put("style", 1);
		request.put("transactionType", 1);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("changeId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * changeId不传参数
	 */
	@Test
	public void postModifyRateTestChangeIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("style", 1);
		request.put("transactionType", 1);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("changeId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	
	/**
	 * style传null
	 */
	@Test
	public void postModifyRateTestStyleIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", null);
		request.put("transactionType", 1);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("style传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * style传空
	 */
	@Test
	public void postModifyRateTestStyleIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", "");
		request.put("transactionType", 1);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("style传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * style传空格
	 */
	@Test
	public void postModifyRateTestStyleIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", " ");
		request.put("transactionType", 1);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("style传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * style不传参数
	 */
	@Test
	public void postModifyRateTestStyleIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("transactionType", 1);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("style不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * style传最大值
	 */
	@Test
	public void postModifyRateTestStyleIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 999999999);
		request.put("transactionType", 1);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("style传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * style传1固定
	 */
	@Test
	public void postModifyRateTestStyleIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 1);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("style传1固定" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * style传2比例
	 */
	@Test
	public void postModifyRateTestStyleIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 2);
		request.put("transactionType", 1);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("style传2比例" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * transactionType传空
	 */
	@Test
	public void postModifyRateTestTransactionTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", "");
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("transactionType传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * transactionType传空格
	 */
	@Test
	public void postModifyRateTestTransactionTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", " ");
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("transactionType传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * transactionType传null
	 */
	@Test
	public void postModifyRateTestTransactionTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", null);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("transactionType传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * transactionType不传参数
	 */
	@Test
	public void postModifyRateTestTransactionTypeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("transactionType不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * transactionType传最大值
	 */
	@Test
	public void postModifyRateTestTransactionTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 999999999);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("transactionType传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * transactionType传1入金
	 */
	@Test
	public void postModifyRateTestTransactionTypeIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 1);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("transactionType传1入金" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * transactionType传2出金
	 */
	@Test
	public void postModifyRateTestTransactionTypeIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 2);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("transactionType传2出金" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * transactionType传3账户间流转
	 */
	@Test
	public void postModifyRateTestTransactionTypeIs3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("transactionType传3账户间流转" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * amount传空
	 */
	@Test
	public void postModifyRateTestAmountIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", "");
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("amount传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * amount传空格
	 */
	@Test
	public void postModifyRateTestAmountIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", " ");
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("amount传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * amount传null
	 */
	@Test
	public void postModifyRateTestAmountIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", null);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("amount传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * amount不传参数
	 */
	@Test
	public void postModifyRateTestAmountIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("amount不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * amount传最大值
	 */
	@Test
	public void postModifyRateTestAmountIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 999999999);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("amount传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * proportion传空
	 */
	@Test
	public void postModifyRateTestProportionIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", "");
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("proportion传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * proportion传空格
	 */
	@Test
	public void postModifyRateTestProportionIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", " ");
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("proportion传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * proportion传null
	 */
	@Test
	public void postModifyRateTestProportionIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", null);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("proportion传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * proportion不传参数
	 */
	@Test
	public void postModifyRateTestProportionIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("proportion不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * proportion传最大值
	 */
	@Test
	public void postModifyRateTestProportionIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", 999999999);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("proportion传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * lowerLimit传空
	 */
	@Test
	public void postModifyRateTestLowerLimitIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", "");
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("lowerLimit传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * lowerLimit传空格
	 */
	@Test
	public void postModifyRateTestLowerLimitIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", " ");
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("lowerLimit传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * lowerLimit传null
	 */
	@Test
	public void postModifyRateTestLowerLimitIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", null);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("lowerLimit传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * lowerLimit不传参数
	 */
	@Test
	public void postModifyRateTestLowerLimitIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("lowerLimit不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * lowerLimit传最大值
	 */
	@Test
	public void postModifyRateTestLowerLimitIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 999999999);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("lowerLimit传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * upperLimit传空
	 */
	@Test
	public void postModifyRateTestUpperLimitIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", "");
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("upperLimit传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * upperLimit传空格
	 */
	@Test
	public void postModifyRateTestUpperLimitIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", " ");
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("upperLimit传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * upperLimit传null
	 */
	@Test
	public void postModifyRateTestUpperLimitIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", null);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("upperLimit传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * upperLimit不传参数
	 */
	@Test
	public void postModifyRateTestUpperLimitIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("upperLimit不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * upperLimit传最大值
	 */
	@Test
	public void postModifyRateTestUpperLimitIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 999999999);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("upperLimit传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * beginTime传空
	 */
	@Test
	public void postModifyRateTestBeginTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("beginTime传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * beginTime传空格
	 */
	@Test
	public void postModifyRateTestBeginTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", " ");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("beginTime传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * beginTime传null
	 */
	@Test
	public void postModifyRateTestBeginTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", null);
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("beginTime传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * beginTime不传参数
	 */
	@Test
	public void postModifyRateTestBeginTimeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("beginTime不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * beginTime传最大值
	 */
	@Test
	public void postModifyRateTestBeginTimeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "9999-12-31");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("beginTime传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * beginTime传超长
	 */
	@Test
	public void postModifyRateTestBeginTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "1223435214545645798332121245643513213454321254121");
		request.put("endTime", "2018-11-11");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("beginTime超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * endTime传超长
	 */
	@Test
	public void postModifyRateTestEndTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "1223435214545645798332121245643513213454321254121");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * endTime传空
	 */
	@Test
	public void postModifyRateTestEndTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * endTime传空格
	 */
	@Test
	public void postModifyRateTestEndTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * endTime传null
	 */
	@Test
	public void postModifyRateTestEndTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * endTime传最大值
	 */
	@Test
	public void postModifyRateTestEndTimeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("walletId", 123);
		request.put("changeId", 1);
		request.put("style", 1);
		request.put("transactionType", 3);
		request.put("amount", 30);
		request.put("proportion", 30);
		request.put("lowerLimit", 20);
		request.put("upperLimit", 40);
		request.put("beginTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	
}
