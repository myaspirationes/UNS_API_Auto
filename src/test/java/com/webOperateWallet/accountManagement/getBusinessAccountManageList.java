package com.webOperateWallet.accountManagement;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class getBusinessAccountManageList extends HttpUtil {
// 获取企业账户管理列表接口
	String url = "/walletEnterprise/getWalletEnterpriseAccountList";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetBusinessAccountManageTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", userId);	
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 用户id为空
	 */
	@Test
	public void postGetBusinessAccountManageTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");	
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 用户id为空格
	 */
	@Test
	public void postGetBusinessAccountManageTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");	
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 用户id为null
	 */
	@Test
	public void postGetBusinessAccountManageTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 用户id为不传
	 */
	@Test
	public void postGetBusinessAccountManageTestUserIdNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");	
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 用户id为最大值
	 */
	@Test
	public void postGetBusinessAccountManageTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "3164646887845415645645");
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * walletIdOrMobile为空
	 */
	@Test
	public void postGetBusinessAccountManageTestWalletIdOrMobileIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", "");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletIdOrMobile为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * walletIdOrMobile为空格
	 */
	@Test
	public void postGetBusinessAccountManageTestWalletIdOrMobileIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", " ");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletIdOrMobile为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * walletIdOrMobile为null
	 */
	@Test
	public void postGetBusinessAccountManageTestWalletIdOrMobileIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", null);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletIdOrMobile为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * walletIdOrMobile不传
	 */
	@Test
	public void postGetBusinessAccountManageTestWalletIdOrMobileIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletIdOrMobile不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * walletIdOrMobile为超长
	 */
	@Test
	public void postGetBusinessAccountManageTestWalletIdOrMobileIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", "13245678945612345678797545313212346");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("walletIdOrMobile为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * startTime为超长
	 */
	@Test
	public void postGetBusinessAccountManageTestStartTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "13456789562312156466897945113225669895");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("startTime为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * startTime为最大值
	 */
	@Test
	public void postGetBusinessAccountManageTestStartTimeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "9999-12-31");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("startTime为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * startTime为空
	 */
	@Test
	public void postGetBusinessAccountManageTestStartTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("startTime为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * startTime为空格
	 */
	@Test
	public void postGetBusinessAccountManageTestStartTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", " ");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("startTime为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * startTime为null
	 */
	@Test
	public void postGetBusinessAccountManageTestStartTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", null);
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("startTime为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * startTime不传
	 */
	@Test
	public void postGetBusinessAccountManageTestStartTimeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("startTime不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * endTime为空
	 */
	@Test
	public void postGetBusinessAccountManageTestEndTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * endTime为空格
	 */
	@Test
	public void postGetBusinessAccountManageTestEndTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", " ");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * endTime为null
	 */
	@Test
	public void postGetBusinessAccountManageTestEndTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", null);
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * endTime不传
	 */
	@Test
	public void postGetBusinessAccountManageTestEndTimeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * endTime为最大值
	 */
	@Test
	public void postGetBusinessAccountManageTestEndTimeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "9999-12-31");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * endTime为超长
	 */
	@Test
	public void postGetBusinessAccountManageTestEndTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "1345678945613123456789456123132456789");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("endTime为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * status为空
	 */
	@Test
	public void postGetBusinessAccountManageTestStatusIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", "");
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("status为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * status为空格
	 */
	@Test
	public void postGetBusinessAccountManageTestStatusIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", " ");
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("status为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * status为null
	 */
	@Test
	public void postGetBusinessAccountManageTestStatusIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", null);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("status为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * status不传
	 */
	@Test
	public void postGetBusinessAccountManageTestStatusIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("status不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * status为最大值
	 */
	@Test
	public void postGetBusinessAccountManageTestStatusIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 999999999);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("status为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * status为0全部
	 */
	@Test
	public void postGetBusinessAccountManageTestStatusIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("status为0全部" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * status为1正常账户
	 */
	@Test
	public void postGetBusinessAccountManageTestStatusIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 1);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("status为1正常账户" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * status为2已冻结
	 */
	@Test
	public void postGetBusinessAccountManageTestStatusIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 2);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("status为2已冻结" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * status为3待审核
	 */
	@Test
	public void postGetBusinessAccountManageTestStatusIs3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 3);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("status为3待审核" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * status为4审核驳回
	 */
	@Test
	public void postGetBusinessAccountManageTestStatusIs4() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 4);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("status为4审核驳回" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * pageSize为空
	 */
	@Test
	public void postGetBusinessAccountManageTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", "");
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageSize为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * pageSize为空格
	 */
	@Test
	public void postGetBusinessAccountManageTestPageSizeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", " ");
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageSize为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * pageSize为null
	 */
	@Test
	public void postGetBusinessAccountManageTestPageSizeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", null);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageSize为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * pageSize不传
	 */
	@Test
	public void postGetBusinessAccountManageTestPageSizeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageSize不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * pageSize为最大值
	 */
	@Test
	public void postGetBusinessAccountManageTestPageSizeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 999999999);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageSize为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * pageNow为空
	 */
	@Test
	public void postGetBusinessAccountManageTestPageNowIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", "");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageNow为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * pageNow为空格
	 */
	@Test
	public void postGetBusinessAccountManageTestPageNowIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", " ");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageNow为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * pageNow为null
	 */
	@Test
	public void postGetBusinessAccountManageTestPageNowIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", null);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageNow为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * pageNow不传
	 */
	@Test
	public void postGetBusinessAccountManageTestPageNowIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageNow不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * pageNow为最大值
	 */
	@Test
	public void postGetBusinessAccountManageTestPageNowIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("startTime", "2018-01-01");
		request.put("endTime", "2018-10-10");
		request.put("status", 0);
		request.put("walletIdOrMobile", "123");
		request.put("pageSize", 5);
		request.put("pageNow", 999999999);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageNow为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
}
