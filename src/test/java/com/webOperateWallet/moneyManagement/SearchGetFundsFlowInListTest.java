package com.webOperateWallet.moneyManagement;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class SearchGetFundsFlowInListTest extends HttpUtil {
// 搜索获取资金流入列表接口
	String url = "/uu-admin/Fund/getFundsFlowInto";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postSearchGetFundsFlowInListTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "2018-10-10");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * minTime为空
	 */
	@Test
	public void postSearchGetFundsFlowInListTestMinTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "");			
		request.put("maxTime", "2018-10-10");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minTime为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * minTime为空格
	 */
	@Test
	public void postSearchGetFundsFlowInListTestMinTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", " ");			
		request.put("maxTime", "2018-10-10");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minTime为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * minTime为null
	 */
	@Test
	public void postSearchGetFundsFlowInListTestMinTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", null);			
		request.put("maxTime", "2018-10-10");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minTime为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * minTime为不传
	 */
	@Test
	public void postSearchGetFundsFlowInListTestMinTimeNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("maxTime", "2018-10-10");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minTime为不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * minTime为超长
	 */
	@Test
	public void postSearchGetFundsFlowInListTestMinTimeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "1234567895465321312345687456");			
		request.put("maxTime", "2018-10-10");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minTime为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * minTime为最大值
	 */
	@Test
	public void postSearchGetFundsFlowInListTestMinTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "9999-12-31");			
		request.put("maxTime", "2018-10-10");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minTime为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * maxTime为空
	 */
	@Test
	public void postSearchGetFundsFlowInListTestMaxTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxTime为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * maxTime为空格
	 */
	@Test
	public void postSearchGetFundsFlowInListTestMaxTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", " ");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxTime为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * maxTime为null
	 */
	@Test
	public void postSearchGetFundsFlowInListTestMaxTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", null);
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxTime为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * maxTime不传
	 */
	@Test
	public void postSearchGetFundsFlowInListTestMaxTimeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxTime不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * maxTime为超长
	 */
	@Test
	public void postSearchGetFundsFlowInListTestMaxTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "1235646548979566513213456589789565");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxTime为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * maxTime为最大值
	 */
	@Test
	public void postSearchGetFundsFlowInListTestMaxTimeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "9999-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxTime为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * accountType为最大值
	 */
	@Test
	public void postSearchGetFundsFlowInListTestAccountTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 999999999);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountType为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * accountType为空
	 */
	@Test
	public void postSearchGetFundsFlowInListTestAccountTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "9999-12-31");
		request.put("accountType", "");
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountType为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * accountType为空格
	 */
	@Test
	public void postSearchGetFundsFlowInListTestAccountTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "2018-12-31");
		request.put("accountType", " ");
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountType为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * accountType为null
	 */
	@Test
	public void postSearchGetFundsFlowInListTestAccountTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "2018-12-31");
		request.put("accountType", null);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountType为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * accountType不传
	 */
	@Test
	public void postSearchGetFundsFlowInListTestAccountTypeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "2018-12-31");
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountType不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * reasonType为空
	 */
	@Test
	public void postSearchGetFundsFlowInListTestReasonTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", "");
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("reasonType为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * reasonType为空格
	 */
	@Test
	public void postSearchGetFundsFlowInListTestReasonTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", " ");
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("reasonType为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * reasonType为null
	 */
	@Test
	public void postSearchGetFundsFlowInListTestReasonTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", null);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("reasonType为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * reasonType不传
	 */
	@Test
	public void postSearchGetFundsFlowInListTestReasonTypeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("reasonType不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * reasonType为最大值
	 */
	@Test
	public void postSearchGetFundsFlowInListTestReasonTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 999999999);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("reasonType为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * orderNo为超长
	 */
	@Test
	public void postSearchGetFundsFlowInListTestOrderNoIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", "1324561234567896523135467895132121356");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("orderNo为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * orderNo为空
	 */
	@Test
	public void postSearchGetFundsFlowInListTestOrderNoIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", "");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("orderNo为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * orderNo为空格
	 */
	@Test
	public void postSearchGetFundsFlowInListTestOrderNoIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", " ");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("orderNo为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * orderNo为null
	 */
	@Test
	public void postSearchGetFundsFlowInListTestOrderNoIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", null);
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("orderNo为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * orderNo为不传
	 */
	@Test
	public void postSearchGetFundsFlowInListTestOrderNoIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("orderNo为不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * billType为null
	 */
	@Test
	public void postSearchGetFundsFlowInListTestBillTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", "123456");
		request.put("billType", null);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("billType为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * billType不传
	 */
	@Test
	public void postSearchGetFundsFlowInListTestBillTypeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", "123456");
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("billType不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * billType为空
	 */
	@Test
	public void postSearchGetFundsFlowInListTestBillTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", "123456");
		request.put("billType", "");
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("billType为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * billType为空格
	 */
	@Test
	public void postSearchGetFundsFlowInListTestBillTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", "123456");
		request.put("billType", " ");
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("billType为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * billType为最大值
	 */
	@Test
	public void postSearchGetFundsFlowInListTestBillTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", "123456");
		request.put("billType", 999999999);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("billType为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * account为null
	 */
	@Test
	public void postSearchGetFundsFlowInListTestAccountIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", "123456");
		request.put("billType", 1);
		request.put("account", null);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("account为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * account为空
	 */
	@Test
	public void postSearchGetFundsFlowInListTestAccountIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", "123456");
		request.put("billType", 1);
		request.put("account", "");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("account为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * account为空格
	 */
	@Test
	public void postSearchGetFundsFlowInListTestAccountIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", "123456");
		request.put("billType", 1);
		request.put("account", " ");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("account为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * account为不传
	 */
	@Test
	public void postSearchGetFundsFlowInListTestAccountIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", "123456");
		request.put("billType", 1);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("account为不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * account为超长
	 */
	@Test
	public void postSearchGetFundsFlowInListTestAccountIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", "123456");
		request.put("billType", 1);
		request.put("account", "121346474897545645131454689796543121");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("account为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * pageSize为空
	 */
	@Test
	public void postSearchGetFundsFlowInListTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "2018-10-10");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
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
	public void postSearchGetFundsFlowInListTestPageSizeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "2018-10-10");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
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
	public void postSearchGetFundsFlowInListTestPageSizeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "2018-10-10");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
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
	public void postSearchGetFundsFlowInListTestPageSizeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "2018-10-10");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
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
	public void postSearchGetFundsFlowInListTestPageSizeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "2018-10-10");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
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
	public void postSearchGetFundsFlowInListTestPageNowIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "2018-10-10");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
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
	public void postSearchGetFundsFlowInListTestPageNowIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "2018-10-10");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
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
	public void postSearchGetFundsFlowInListTestPageNowIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "2018-10-10");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
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
	public void postSearchGetFundsFlowInListTestPageNowIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "2018-10-10");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
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
	public void postSearchGetFundsFlowInListTestPageNowIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "2018-10-10");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
		request.put("pageSize", 5);
		request.put("pageNow", 999999999);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageNow为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
}
