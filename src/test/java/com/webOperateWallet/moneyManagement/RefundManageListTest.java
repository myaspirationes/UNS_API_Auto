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

public class RefundManageListTest extends HttpUtil {
// 退款管理列表接口
	String url = "/uu-admin/refund/getRefundList";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postRefundManageListTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * refundMinTime为空
	 */
	@Test
	public void postRefundManageListTestRefundMinTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("refundMinTime为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * refundMinTime为空格
	 */
	@Test
	public void postRefundManageListTestRefundMinTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", " ");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("refundMinTime为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * refundMinTime为null
	 */
	@Test
	public void postRefundManageListTestRefundMinTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", null);	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("refundMinTime为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * refundMinTime不传
	 */
	@Test
	public void postRefundManageListTestRefundMinTimeNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("refundMinTime不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * refundMinTime为最大值
	 */
	@Test
	public void postRefundManageListTestRefundMinTimeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "9999-12-31");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("refundMinTime为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * refundMinTime为超长
	 */
	@Test
	public void postRefundManageListTestRefundMinTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "123456798456134567897845635145464");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("refundMinTime为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * refundMaxTime为空
	 */
	@Test
	public void postRefundManageListTestRefundMaxTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("refundMaxTime为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * refundMaxTime为空格
	 */
	@Test
	public void postRefundManageListTestRefundMaxTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", " ");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("refundMaxTime为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * refundMaxTime为null
	 */
	@Test
	public void postRefundManageListTestRefundMaxTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", null);
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("refundMaxTime为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * refundMaxTime不传
	 */
	@Test
	public void postRefundManageListTestRefundMaxTimeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("refundMaxTime不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * refundMaxTime为超长
	 */
	@Test
	public void postRefundManageListTestRefundMaxTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "12345678945613123456487");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("refundMaxTime为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * refundMaxTime为最大值
	 */
	@Test
	public void postRefundManageListTestRefundMaxTimeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "9999-12-31");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("refundMaxTime为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * payType为最大值
	 */
	@Test
	public void postRefundManageListTestPayTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 999999999);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payType为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * payType为空
	 */
	@Test
	public void postRefundManageListTestPayTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", "");
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payType为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * payType为空格
	 */
	@Test
	public void postRefundManageListTestPayTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", " ");
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payType为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * payType为null
	 */
	@Test
	public void postRefundManageListTestPayTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", null);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payType为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * payType不传
	 */
	@Test
	public void postRefundManageListTestPayTypeIsNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payType不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * payType为1红包到期退款
	 */
	@Test
	public void postRefundManageListTestPayTypeIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payType为1红包到期退款" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * payType为2电商退款
	 */
	@Test
	public void postRefundManageListTestPayTypeIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 2);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payType为2电商退款" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * payType为3二手买卖退款
	 */
	@Test
	public void postRefundManageListTestPayTypeIs3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 3);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payType为3二手买卖退款" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * payType为4转账到期退款
	 */
	@Test
	public void postRefundManageListTestPayTypeIs4() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 4);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("payType为4转账到期退款" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * account为最大值
	 */
	@Test
	public void postRefundManageListTestAccountIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 999999999999999999L);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("account为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * account为空
	 */
	@Test
	public void postRefundManageListTestAccountIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", "");
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
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
	public void postRefundManageListTestAccountIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", " ");
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("account为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * account为null
	 */
	@Test
	public void postRefundManageListTestAccountIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", null);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("account为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * account不传
	 */
	@Test
	public void postRefundManageListTestAccountIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("account不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * orderNo为最大值
	 */
	@Test
	public void postRefundManageListTestOrderNoIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 999999999999999999L);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("orderNo为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * orderNo传空
	 */
	@Test
	public void postRefundManageListTestOrderNoIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", "");
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("orderNo传空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * orderNo传空格
	 */
	@Test
	public void postRefundManageListTestOrderNoIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", " ");
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("orderNo传空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * orderNo传null
	 */
	@Test
	public void postRefundManageListTestOrderNoIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", null);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("orderNo传null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * orderNo不传
	 */
	@Test
	public void postRefundManageListTestOrderNoIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("orderNo不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * backAccount传null
	 */
	@Test
	public void postRefundManageListTestBackAccountIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", null);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("backAccount传null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * backAccount传空
	 */
	@Test
	public void postRefundManageListTestBackAccountIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", "");
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("backAccount传null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * backAccount传空格
	 */
	@Test
	public void postRefundManageListTestBackAccountIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", " ");
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("backAccount传null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * backAccount不传
	 */
	@Test
	public void postRefundManageListTestBackAccountIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("backAccount不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * backAccount传最大值
	 */
	@Test
	public void postRefundManageListTestBackAccountIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 999999999999999999L);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("backAccount传最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * status传最大值
	 */
	@Test
	public void postRefundManageListTestStatusIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 999999999999999999L);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("status传最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * status传空
	 */
	@Test
	public void postRefundManageListTestStatusIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", "");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("status传空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * status传空格
	 */
	@Test
	public void postRefundManageListTestStatusIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", " ");
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("status传最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * status传null
	 */
	@Test
	public void postRefundManageListTestStatusIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", null);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("status传null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * status不传
	 */
	@Test
	public void postRefundManageListTestStatusIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("pageSize", 5);
		request.put("pageNow", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("status不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * pageSize为空
	 */
	@Test
	public void postRefundManageListTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
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
	public void postRefundManageListTestPageSizeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
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
	public void postRefundManageListTestPageSizeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
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
	public void postRefundManageListTestPageSizeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
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
	public void postRefundManageListTestPageSizeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
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
	public void postRefundManageListTestPageNowIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
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
	public void postRefundManageListTestPageNowIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
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
	public void postRefundManageListTestPageNowIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
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
	public void postRefundManageListTestPageNowIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
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
	public void postRefundManageListTestPageNowIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("refundMinTime", "2018-07-16");	
		request.put("refundMaxTime", "2018-07-17");
		request.put("payType", 1);
		request.put("account", 123456);
		request.put("orderNo", 123);
		request.put("backAccount", 456789);
		request.put("status", 0);
		request.put("pageSize", 5);
		request.put("pageNow", 999999999);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("pageNow为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
}
