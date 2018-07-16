package com.webShopWallet.walletManagement;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class AgainOpenWalletCheckListTest extends HttpUtil {
// 再次开通钱包审核列表接口
	String url = "/uu-admin/walletAuditEnterprise/getWalletAuditEnterprise";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postAgainOpenWalletCheckListTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postAgainOpenWalletCheckListTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postAgainOpenWalletCheckListTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postAgainOpenWalletCheckListTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postAgainOpenWalletCheckListTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postAgainOpenWalletCheckListTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 999999999999999999L);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	
	/**
	 * pageSize传空
	 */
	@Test
	public void postAgainOpenWalletCheckListTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", "");
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageSize传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * pageSize传空格
	 */
	@Test
	public void postAgainOpenWalletCheckListTestPageSizeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", " ");
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageSize传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * pageSize传null
	 */
	@Test
	public void postAgainOpenWalletCheckListTestPageSizeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", null);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageSize传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * pageSize不传参数
	 */
	@Test
	public void postAgainOpenWalletCheckListTestPageSizeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageSize不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * pageSize传最大值
	 */
	@Test
	public void postAgainOpenWalletCheckListTestPageSizeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("pageSize", 999999999);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageSize传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * pageNow传最大值
	 */
	@Test
	public void postAgainOpenWalletCheckListTestPageNowIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("pageSize", 5);
		request.put("pageNow", 999999999);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageNow传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * pageNow传空
	 */
	@Test
	public void postAgainOpenWalletCheckListTestPageNowIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageNow传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * pageNow传空格
	 */
	@Test
	public void postAgainOpenWalletCheckListTestPageNowIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageNow传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * pageNow传null
	 */
	@Test
	public void postAgainOpenWalletCheckListTestPageNowIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageNow传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * pageNow不传参数
	 */
	@Test
	public void postAgainOpenWalletCheckListTestPageNowIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageNow不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * startTime不传参数
	 */
	@Test
	public void postAgainOpenWalletCheckListTestStartTimeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("startTime不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * startTime传空
	 */
	@Test
	public void postAgainOpenWalletCheckListTestStartTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("startTime传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * startTime传空格
	 */
	@Test
	public void postAgainOpenWalletCheckListTestStartTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", " ");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("startTime传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * startTime传null
	 */
	@Test
	public void postAgainOpenWalletCheckListTestStartTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", null);
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("startTime传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * startTime传超长
	 */
	@Test
	public void postAgainOpenWalletCheckListTestStartTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "123456789456132013446554");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("startTime传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * startTime传最大值
	 */
	@Test
	public void postAgainOpenWalletCheckListTestStartTimeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "9999-12-31");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("startTime传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * endTime传最大值
	 */
	@Test
	public void postAgainOpenWalletCheckListTestEndTimeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * endTime传空
	 */
	@Test
	public void postAgainOpenWalletCheckListTestEndTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * endTime传空格
	 */
	@Test
	public void postAgainOpenWalletCheckListTestEndTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", " ");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * endTime传null
	 */
	@Test
	public void postAgainOpenWalletCheckListTestentEndTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", null);
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * endTime不传参数
	 */
	@Test
	public void postAgainOpenWalletCheckListTestEndTimeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * endTime传超长
	 */
	@Test
	public void postAgainOpenWalletCheckListTestEndTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "12345678945645123456878956412314565");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	
	/**
	 * enterpriseName传null
	 */
	@Test
	public void postAgainOpenWalletCheckListTestEnterpriseNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", null);
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseName传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseName传空
	 */
	@Test
	public void postAgainOpenWalletCheckListTestEnterpriseNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseName传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseName传空格
	 */
	@Test
	public void postAgainOpenWalletCheckListTestEnterpriseNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", " ");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseName传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseName不传参数
	 */
	@Test
	public void postAgainOpenWalletCheckListTestEnterpriseNameIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseName不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * enterpriseName传超长
	 */
	@Test
	public void postAgainOpenWalletCheckListTestEnterpriseNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝大幅度随风倒十分翻跟斗翻跟斗广泛大概豆腐干地方事故发生发售股份");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("enterpriseName传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	
	/**
	 * walletAlias传空
	 */
	@Test
	public void postAgainOpenWalletCheckListTestWalletAliasIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletAlias传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * walletAlias传空格
	 */
	@Test
	public void postAgainOpenWalletCheckListTestWalletAliasIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", " ");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletAlias传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * walletAlias传null
	 */
	@Test
	public void postAgainOpenWalletCheckListTestWalletAliasIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", null);
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletAlias传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * walletAlias不传参数
	 */
	@Test
	public void postAgainOpenWalletCheckListTestWalletAliasIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletAlias不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * walletAlias传超长
	 */
	@Test
	public void postAgainOpenWalletCheckListTestWalletAliasIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "卡夫卡就是当你烦恼方面，十多年发快递顺丰快递就是看附件附近的开始就反抗类毒素解放了");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletAlias传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * operatorName传超长
	 */
	@Test
	public void postAgainOpenWalletCheckListTestOperatorNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试大幅度随风倒十分的广告和规范规范化规范化广东鬼地方鬼地方");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operatorName传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * operatorName传空
	 */
	@Test
	public void postAgainOpenWalletCheckListTestOperatorNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operatorName传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * operatorName传空格
	 */
	@Test
	public void postAgainOpenWalletCheckListTestOperatorNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", " ");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operatorName传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * operatorName传null
	 */
	@Test
	public void postAgainOpenWalletCheckListTestOperatorNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", null);
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operatorName传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * operatorName不传
	 */
	@Test
	public void postAgainOpenWalletCheckListTestOperatorNameIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operatorName不传" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * auditStatus传空
	 */
	@Test
	public void postAgainOpenWalletCheckListTestAuditStatusIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", "");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditStatus传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * auditStatus传空格
	 */
	@Test
	public void postAgainOpenWalletCheckListTestAuditStatusIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", " ");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditStatus传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * auditStatus传null
	 */
	@Test
	public void postAgainOpenWalletCheckListTestAuditStatusIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", null);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditStatus传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * auditStatus不传参数
	 */
	@Test
	public void postAgainOpenWalletCheckListTestAuditStatusIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("transactionType", 3);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditStatus不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * auditStatus传最大值
	 */
	@Test
	public void postAgainOpenWalletCheckListTestAuditStatusIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 999999999);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditStatus传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * auditStatus传0全部
	 */
	@Test
	public void postAgainOpenWalletCheckListTestAuditStatusIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditStatus传0全部" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * auditStatus传1待审核
	 */
	@Test
	public void postAgainOpenWalletCheckListTestAuditStatusIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 1);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditStatus传1待审核" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * auditStatus传2审核通过
	 */
	@Test
	public void postAgainOpenWalletCheckListTestAuditStatusIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 2);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditStatus传2审核通过" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	/**
	 * auditStatus传3审核未通过
	 */
	@Test
	public void postAgainOpenWalletCheckListTestAuditStatusIs3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("enterpriseName", "银生宝");
		request.put("walletAlias", "自动化测试钱包");
		request.put("operatorName", "自动化测试");
		request.put("auditStatus", 3);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditStatus传3审核未通过" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败！");
	}
	
	
}
