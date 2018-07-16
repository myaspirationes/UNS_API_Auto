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

public class ExportRefundManageListTest extends HttpUtil {
// 导出退款管理列表接口
	String url = "/uu-admin/refund/exportRefundList";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postExportRefundManageListTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * refundMinTime为空
	 */
	@Test
	public void postExportRefundManageListTestRefundMinTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("refundMinTime为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * refundMinTime为空格
	 */
	@Test
	public void postExportRefundManageListTestRefundMinTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", " ");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("refundMinTime为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * refundMinTime为null
	 */
	@Test
	public void postExportRefundManageListTestRefundMinTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", null);	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("refundMinTime为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * refundMinTime不传
	 */
	@Test
	public void postExportRefundManageListTestRefundMinTimeNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("refundMinTime不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * refundMinTime为最大值
	 */
	@Test
	public void postExportRefundManageListTestRefundMinTimeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "9999-12-31");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("refundMinTime为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * refundMinTime为超长
	 */
	@Test
	public void postExportRefundManageListTestRefundMinTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "123456798456134567897845635145464");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("refundMinTime为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * refundMaxTime为空
	 */
	@Test
	public void postExportRefundManageListTestRefundMaxTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("refundMaxTime为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * refundMaxTime为空格
	 */
	@Test
	public void postExportRefundManageListTestRefundMaxTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", " ");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("refundMaxTime为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * refundMaxTime为null
	 */
	@Test
	public void postExportRefundManageListTestRefundMaxTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", null);
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("refundMaxTime为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * refundMaxTime不传
	 */
	@Test
	public void postExportRefundManageListTestRefundMaxTimeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("refundMaxTime不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * refundMaxTime为超长
	 */
	@Test
	public void postExportRefundManageListTestRefundMaxTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "12345678945613123456487");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("refundMaxTime为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * refundMaxTime为最大值
	 */
	@Test
	public void postExportRefundManageListTestRefundMaxTimeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "9999-12-31");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("refundMaxTime为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * payType为最大值
	 */
	@Test
	public void postExportRefundManageListTestPayTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 999999999);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payType为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * payType为空
	 */
	@Test
	public void postExportRefundManageListTestPayTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", "");
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payType为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * payType为空格
	 */
	@Test
	public void postExportRefundManageListTestPayTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", " ");
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payType为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * payType为null
	 */
	@Test
	public void postExportRefundManageListTestPayTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", null);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payType为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * payType不传
	 */
	@Test
	public void postExportRefundManageListTestPayTypeIsNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payType不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * payType为1红包到期退款
	 */
	@Test
	public void postExportRefundManageListTestPayTypeIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payType为1红包到期退款" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * payType为2电商退款
	 */
	@Test
	public void postExportRefundManageListTestPayTypeIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 2);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payType为2电商退款" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * payType为3二手买卖退款
	 */
	@Test
	public void postExportRefundManageListTestPayTypeIs3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 3);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payType为3二手买卖退款" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * payType为4转账到期退款
	 */
	@Test
	public void postExportRefundManageListTestPayTypeIs4() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 4);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payType为4转账到期退款" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * account为最大值
	 */
	@Test
	public void postExportRefundManageListTestAccountIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 999999999999999999L);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("account为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * account为空
	 */
	@Test
	public void postExportRefundManageListTestAccountIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", "");
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("account为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * account为空格
	 */
	@Test
	public void postExportRefundManageListTestAccountIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", " ");
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("account为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * account为null
	 */
	@Test
	public void postExportRefundManageListTestAccountIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", null);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("account为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * account不传
	 */
	@Test
	public void postExportRefundManageListTestAccountIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("account不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * orderNo为最大值
	 */
	@Test
	public void postExportRefundManageListTestOrderNoIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 999999999999999999L);
		request.put("backAccount", 456789);
		request.put("status", 0);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("orderNo为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * orderNo传空
	 */
	@Test
	public void postExportRefundManageListTestOrderNoIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", "");
		request.put("backAccount", 456789);
		request.put("status", 0);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("orderNo传空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * orderNo传空格
	 */
	@Test
	public void postExportRefundManageListTestOrderNoIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", " ");
		request.put("backAccount", 456789);
		request.put("status", 0);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("orderNo传空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * orderNo传null
	 */
	@Test
	public void postExportRefundManageListTestOrderNoIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", null);
		request.put("backAccount", 456789);
		request.put("status", 0);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("orderNo传null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * orderNo不传
	 */
	@Test
	public void postExportRefundManageListTestOrderNoIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("backAccount", 456789);
		request.put("status", 0);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("orderNo不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * backAccount传null
	 */
	@Test
	public void postExportRefundManageListTestBackAccountIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", null);
		request.put("status", 0);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("backAccount传null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * backAccount传空
	 */
	@Test
	public void postExportRefundManageListTestBackAccountIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", "");
		request.put("status", 0);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("backAccount传null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * backAccount传空格
	 */
	@Test
	public void postExportRefundManageListTestBackAccountIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", " ");
		request.put("status", 0);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("backAccount传null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * backAccount不传
	 */
	@Test
	public void postExportRefundManageListTestBackAccountIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("status", 0);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("backAccount不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * backAccount传最大值
	 */
	@Test
	public void postExportRefundManageListTestBackAccountIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 999999999999999999L);
		request.put("status", 0);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("backAccount传最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * status传最大值
	 */
	@Test
	public void postExportRefundManageListTestStatusIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 999999999999999999L);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("status传最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * status传空
	 */
	@Test
	public void postExportRefundManageListTestStatusIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", "");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("status传空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * status传空格
	 */
	@Test
	public void postExportRefundManageListTestStatusIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", " ");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("status传最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * status传null
	 */
	@Test
	public void postExportRefundManageListTestStatusIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", null);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("status传null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * status不传
	 */
	@Test
	public void postExportRefundManageListTestStatusIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("status不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
}
