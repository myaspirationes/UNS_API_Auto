package com.webShopWallet.setting;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class RelationWalletListTest extends HttpUtil {
// 关联钱包列表接口
	String url = "/wallet-admin/enterpriseWalletApply/getEnterpriseWalletApplyList";
	String updateSql = "UPDATE T_ENTERPRISE_WALLET_APPLY_RECORD SET AUDIT_STATUS = 4 WHERE RECORD_ID = 88";
	String dataType = "wallet81";
	/**
	 * 提交正确参数
	 */
	@Test
	public void postRelationWalletListTestCorrectParameter() throws Exception {
		new WalletRelationCheckingTest().postWalletRelationCheckingTestCorrectParameter(); 
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
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
	public void postRelationWalletListTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
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
	public void postRelationWalletListTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
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
	public void postRelationWalletListTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
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
	public void postRelationWalletListTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
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
	public void postRelationWalletListTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 999999999999999999L);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isIn("参数错误","用户id格式错误！");
	}
	/**
	 * beginTime传空
	 */
	@Test
	public void postRelationWalletListTestBeginTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("beginTime传空" + post);

		assertThat(post.get("status")).isIn(1,-1);
		assertThat(post.get("msg")).isEqualTo("id为：999的角色不存在");
	}
	/**
	 * beginTime传空格
	 */
	@Test
	public void postRelationWalletListTestBeginTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", " ");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("beginTime传空格" + post);

		assertThat(post.get("status")).isIn(1,-1);
		assertThat(post.get("msg")).isEqualTo("id为：1的角色不存在");
	}
	/**
	 * beginTime传null
	 */
	@Test
	public void postRelationWalletListTestBeginTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", null);
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("beginTime传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * beginTime不传参数
	 */
	@Test
	public void postRelationWalletListTestBeginTimeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("beginTime不传参数" + post);

		assertThat(post.get("status")).isEqualTo(400);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * beginTime传超长
	 */
	@Test
	public void postRelationWalletListTestBeginTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "1245454454542125656898978654343321334545");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("beginTime不传参数" + post);

		assertThat(post.get("status")).isEqualTo(400);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * beginTime传最大值
	 */
	@Test
	public void postRelationWalletListTestBeginTimeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "9999-12-31");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("beginTime传最大值" + post);

		assertThat(post.get("status")).isEqualTo(400);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * endTime传空
	 */
	@Test
	public void postRelationWalletListTestEndTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "");
		request.put("auditStatus", 1);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id不能为空！");
	}
	/**
	 * endTime传空格
	 */
	@Test
	public void postRelationWalletListTestEndTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", " ");
		request.put("auditStatus", 1);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id不能为空！");
	}
	/**
	 * endTime传null
	 */
	@Test
	public void postRelationWalletListTestEndTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", null);
		request.put("auditStatus", 1);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime传null" + post);

		assertThat(post.get("status")).isEqualTo(400);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * endTime不传参数
	 */
	@Test
	public void postRelationWalletListTestEndTimeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("auditStatus", 1);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id不能为空！");
	}
	/**
	 * endTime传超长
	 */
	@Test
	public void postRelationWalletListTestEndTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "1234564657845643212313454643213454687754541");
		request.put("auditStatus", 1);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * endTime传最大值
	 */
	@Test
	public void postRelationWalletListTestroleIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "9999-12-31");
		request.put("auditStatus", 1);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * pageSize传空
	 */
	@Test
	public void postRelationWalletListTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
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
	public void postRelationWalletListTestPageSizeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
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
	public void postRelationWalletListTestPageSizeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
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
	public void postRelationWalletListTestPageSizeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
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
	public void postRelationWalletListTestPageSizeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
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
	public void postRelationWalletListTestPageNowIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
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
	public void postRelationWalletListTestPageNowIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
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
	public void postRelationWalletListTestPageNowIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
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
	public void postRelationWalletListTestPageNowIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
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
	public void postRelationWalletListTestPageNowIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageNow不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId不传参数
	 */
	@Test
	public void postRelationWalletListTestWalletIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空
	 */
	@Test
	public void postRelationWalletListTestWalletIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", "");
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传空格
	 */
	@Test
	public void postRelationWalletListTestWalletIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", " ");
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传null
	 */
	@Test
	public void postRelationWalletListTestWalletIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", null);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * walletId传最大值
	 */
	@Test
	public void postRelationWalletListTestWalletIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 999999999999999999L);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletId传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * auditStatus传最大值
	 */
	@Test
	public void postRelationWalletListTestAuditStatusIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 999999999);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditStatus传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * auditStatus传空
	 */
	@Test
	public void postRelationWalletListTestAuditStatusIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", "");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditStatus传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * auditStatus传空格
	 */
	@Test
	public void postRelationWalletListTestAuditStatusIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", " ");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditStatus传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * auditStatus传null
	 */
	@Test
	public void postRelationWalletListTestAuditStatusIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", null);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditStatus传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * auditStatus不传参数
	 */
	@Test
	public void postRelationWalletListTestAuditStatusIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditStatus不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("角色id格式错误！");
	}
	/**
	 * auditStatus传1待审核
	 */
	@Test
	public void postRelationWalletListTestAuditStatusIs1() throws Exception {
		new WalletRelationCheckingTest().postWalletRelationCheckingTestAuditStatusIs1();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 1);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditStatus传1待审核" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * auditStatus传2通过
	 */
	@Test
	public void postRelationWalletListTestAuditStatusIs2() throws Exception {
		new WalletRelationCheckingTest().postWalletRelationCheckingTestAuditStatusIs2();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 2);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditStatus传2通过" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * auditStatus传3不通过
	 */
	@Test
	public void postRelationWalletListTestAuditStatusIs3() throws Exception {
		new WalletRelationCheckingTest().postWalletRelationCheckingTestAuditStatusIs3();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 3);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditStatus传3不通过" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * auditStatus传4已撤销
	 */
	@Test
	public void postRelationWalletListTestAuditStatusIs4() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495417);
		request.put("walletId", 66);
		request.put("beginTime", "20180101");
		request.put("endTime", "20181010");
		request.put("auditStatus", 4);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("auditStatus传4已撤销" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
}
