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

public class ExportFundsFlowIntoListTest extends HttpUtil {
// 导出资金流入列表接口
	String url = "/uu-admin/Fund/exportFundsFlowIntoList";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postExportFundsFlowIntoListTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "2018-10-10");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * minTime为空
	 */
	@Test
	public void postExportFundsFlowIntoListTestMinTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "");			
		request.put("maxTime", "2018-10-10");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("minTime为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * minTime为空格
	 */
	@Test
	public void postExportFundsFlowIntoListTestMinTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", " ");			
		request.put("maxTime", "2018-10-10");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("minTime为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * minTime为null
	 */
	@Test
	public void postExportFundsFlowIntoListTestMinTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", null);			
		request.put("maxTime", "2018-10-10");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minTime为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * minTime为不传
	 */
	@Test
	public void postExportFundsFlowIntoListTestMinTimeNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("maxTime", "2018-10-10");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minTime为不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * minTime为超长
	 */
	@Test
	public void postExportFundsFlowIntoListTestMinTimeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "1234567895465321312345687456");			
		request.put("maxTime", "2018-10-10");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minTime为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * minTime为最大值
	 */
	@Test
	public void postExportFundsFlowIntoListTestMinTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "9999-12-31");			
		request.put("maxTime", "2018-10-10");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("minTime为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * maxTime为空
	 */
	@Test
	public void postExportFundsFlowIntoListTestMaxTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxTime为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * maxTime为空格
	 */
	@Test
	public void postExportFundsFlowIntoListTestMaxTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", " ");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxTime为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * maxTime为null
	 */
	@Test
	public void postExportFundsFlowIntoListTestMaxTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", null);
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxTime为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * maxTime不传
	 */
	@Test
	public void postExportFundsFlowIntoListTestMaxTimeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxTime不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * maxTime为超长
	 */
	@Test
	public void postExportFundsFlowIntoListTestMaxTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "1235646548979566513213456589789565");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxTime为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * maxTime为最大值
	 */
	@Test
	public void postExportFundsFlowIntoListTestMaxTimeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "9999-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("maxTime为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * accountType为最大值
	 */
	@Test
	public void postExportFundsFlowIntoListTestAccountTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 999999999);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountType为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * accountType为空
	 */
	@Test
	public void postExportFundsFlowIntoListTestAccountTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "9999-12-31");
		request.put("accountType", "");
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountType为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * accountType为空格
	 */
	@Test
	public void postExportFundsFlowIntoListTestAccountTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "2018-12-31");
		request.put("accountType", " ");
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountType为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * accountType为null
	 */
	@Test
	public void postExportFundsFlowIntoListTestAccountTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "2018-12-31");
		request.put("accountType", null);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountType为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * accountType不传
	 */
	@Test
	public void postExportFundsFlowIntoListTestAccountTypeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "2018-12-31");
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("accountType不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * reasonType为空
	 */
	@Test
	public void postExportFundsFlowIntoListTestReasonTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");			
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", "");
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("reasonType为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * reasonType为空格
	 */
	@Test
	public void postExportFundsFlowIntoListTestReasonTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", " ");
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("reasonType为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * reasonType为null
	 */
	@Test
	public void postExportFundsFlowIntoListTestReasonTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", null);
		request.put("reasonType", 0);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("reasonType为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * reasonType不传
	 */
	@Test
	public void postExportFundsFlowIntoListTestReasonTypeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("reasonType不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * reasonType为最大值
	 */
	@Test
	public void postExportFundsFlowIntoListTestReasonTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 999999999);
		request.put("orderNo", "132456");
		request.put("billType", 0);
		request.put("account", "413");
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("reasonType为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * orderNo为超长
	 */
	@Test
	public void postExportFundsFlowIntoListTestOrderNoIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", "1324561234567896523135467895132121356");
		request.put("billType", 0);
		request.put("account", "413");
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("orderNo为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * orderNo为空
	 */
	@Test
	public void postExportFundsFlowIntoListTestOrderNoIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", "");
		request.put("billType", 0);
		request.put("account", "413");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("orderNo为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * orderNo为空格
	 */
	@Test
	public void postExportFundsFlowIntoListTestOrderNoIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", " ");
		request.put("billType", 0);
		request.put("account", "413");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("orderNo为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * orderNo为null
	 */
	@Test
	public void postExportFundsFlowIntoListTestOrderNoIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", null);
		request.put("billType", 0);
		request.put("account", "413");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("orderNo为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * orderNo为不传
	 */
	@Test
	public void postExportFundsFlowIntoListTestOrderNoIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("billType", 0);
		request.put("account", "413");
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("orderNo为不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * billType为null
	 */
	@Test
	public void postExportFundsFlowIntoListTestBillTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", "123456");
		request.put("billType", null);
		request.put("account", "413");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("billType为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * billType不传
	 */
	@Test
	public void postExportFundsFlowIntoListTestBillTypeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", "123456");
		request.put("account", "413");
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("billType不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * billType为空
	 */
	@Test
	public void postExportFundsFlowIntoListTestBillTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", "123456");
		request.put("billType", "");
		request.put("account", "413");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("billType为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * billType为空格
	 */
	@Test
	public void postExportFundsFlowIntoListTestBillTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", "123456");
		request.put("billType", " ");
		request.put("account", "413");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("billType为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * billType为最大值
	 */
	@Test
	public void postExportFundsFlowIntoListTestBillTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", "123456");
		request.put("billType", 999999999);
		request.put("account", "413");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("billType为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * account为null
	 */
	@Test
	public void postExportFundsFlowIntoListTestAccountIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", "123456");
		request.put("billType", 1);
		request.put("account", null);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("account为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * account为空
	 */
	@Test
	public void postExportFundsFlowIntoListTestAccountIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", "123456");
		request.put("billType", 1);
		request.put("account", "");
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("account为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * account为空格
	 */
	@Test
	public void postExportFundsFlowIntoListTestAccountIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", "123456");
		request.put("billType", 1);
		request.put("account", " ");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("account为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * account为不传
	 */
	@Test
	public void postExportFundsFlowIntoListTestAccountIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", "123456");
		request.put("billType", 1);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("account为不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * account为超长
	 */
	@Test
	public void postExportFundsFlowIntoListTestAccountIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("minTime", "2018-01-01");
		request.put("maxTime", "2018-12-31");
		request.put("accountType", 1);
		request.put("reasonType", 1);
		request.put("orderNo", "123456");
		request.put("billType", 1);
		request.put("account", "121346474897545645131454689796543121");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("account为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	
}
