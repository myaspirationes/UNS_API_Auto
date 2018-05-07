package com.personalCenter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;

public class OrderSeachTest extends HttpUtil {
// 用户创建订单接口
	String url = "/api/oderSeach";
	
	/**
	 * 正确搜索待付款订单
	 */
	@Test
	public void postAuthenticateTestClidPendingPayment() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("clid", 0);
		con.put("searchWord", "searchWord");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12492126);
		head.put("chcode", "viTIKkLDeKMU85CexwSsWgSCZBAAiPhQ");
		head.put("cmd", 3902);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("正确搜索待付款订单" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 正确搜索待收货订单
	 */
	@Test
	public void postAuthenticateTestClidWaitingForTheReceipt() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("clid", 1);
		con.put("searchWord", "searchWord");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12492126);
		head.put("chcode", "viTIKkLDeKMU85CexwSsWgSCZBAAiPhQ");
		head.put("cmd", 3902);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("正确搜索待收货订单" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 正确搜索已完成订单
	 */
	@Test
	public void postAuthenticateTestClidCompleted() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("clid", 0);
		con.put("searchWord", "searchWord");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12492126);
		head.put("chcode", "viTIKkLDeKMU85CexwSsWgSCZBAAiPhQ");
		head.put("cmd", 3902);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("正确搜索已完成订单" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 正确搜索全部订单
	 */
	@Test
	public void postAuthenticateTestClidIsAll() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("clid", 3);
		con.put("searchWord", "searchWord");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12492126);
		head.put("chcode", "viTIKkLDeKMU85CexwSsWgSCZBAAiPhQ");
		head.put("cmd", 3902);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("正确搜索全部订单" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 查询订单搜索词错误
	 */
	@Test
	public void postAuthenticateTestSearchWordIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("clid", 0);
		con.put("searchWord", "searchWord");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12492126);
		head.put("chcode", "viTIKkLDeKMU85CexwSsWgSCZBAAiPhQ");
		head.put("cmd", 3902);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询订单搜索词错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 查询订单搜索词为非法字符
	 */
	@Test
	public void postAuthenticateTestSearchWordIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("clid", 0);
		con.put("searchWord", "<#%^.>");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12492126);
		head.put("chcode", "viTIKkLDeKMU85CexwSsWgSCZBAAiPhQ");
		head.put("cmd", 3902);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询订单搜索词为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 查询订单搜索词为空
	 */
	@Test
	public void postAuthenticateTestSearchWordIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("clid", 0);
		con.put("searchWord", "");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12492126);
		head.put("chcode", "viTIKkLDeKMU85CexwSsWgSCZBAAiPhQ");
		head.put("cmd", 3902);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询订单搜索词为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 查询订单搜索词为null
	 */
	@Test
	public void postAuthenticateTestSearchWordIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("clid", 0);
		con.put("searchWord", null);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12492126);
		head.put("chcode", "viTIKkLDeKMU85CexwSsWgSCZBAAiPhQ");
		head.put("cmd", 3902);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询订单搜索词为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 查询订单搜索词不传该参数
	 */
	@Test
	public void postAuthenticateTestSearchWordNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("clid", 0);
		con.put("searchWord", "searchWord");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12492126);
		head.put("chcode", "viTIKkLDeKMU85CexwSsWgSCZBAAiPhQ");
		head.put("cmd", 3902);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询订单搜索词不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 查询错误的订单分类编码
	 */
	@Test
	public void postAuthenticateTestClidIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("clid", 4636);
		con.put("searchWord", "searchWord");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12492126);
		head.put("chcode", "viTIKkLDeKMU85CexwSsWgSCZBAAiPhQ");
		head.put("cmd", 3902);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询错误的订单分类编码" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 *查询的订单分类编码为负数
	 */
	@Test
	public void postAuthenticateTestClidIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("clid", -1);
		con.put("searchWord", "searchWord");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12492126);
		head.put("chcode", "viTIKkLDeKMU85CexwSsWgSCZBAAiPhQ");
		head.put("cmd", 3902);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询的订单分类编码为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 查询的订单分类编码为小数
	 */
	@Test
	public void postAuthenticateTestClidIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("clid", 1.5);
		con.put("searchWord", "searchWord");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12492126);
		head.put("chcode", "viTIKkLDeKMU85CexwSsWgSCZBAAiPhQ");
		head.put("cmd", 3902);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询的订单分类编码为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 查询的订单分类编码超最大值
	 */
	@Test
	public void postAuthenticateTestClidIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("clid", 999999999);
		con.put("searchWord", "searchWord");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12492126);
		head.put("chcode", "viTIKkLDeKMU85CexwSsWgSCZBAAiPhQ");
		head.put("cmd", 3902);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询的订单分类编码超最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 查询的订单分类编码为String
	 */
	@Test
	public void postAuthenticateTestClidIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("clid", "a");
		con.put("searchWord", "searchWord");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12492126);
		head.put("chcode", "viTIKkLDeKMU85CexwSsWgSCZBAAiPhQ");
		head.put("cmd", 3902);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询的订单分类编码为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 查询的订单分类编码为空
	 */
	@Test
	public void postAuthenticateTestClidIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("clid", " ");
		con.put("searchWord", "searchWord");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12492126);
		head.put("chcode", "viTIKkLDeKMU85CexwSsWgSCZBAAiPhQ");
		head.put("cmd", 3902);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询的订单分类编码为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 查询的订单分类编码不存在
	 */
	@Test
	public void postAuthenticateTestClidNonExistent() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("clid", 2455);
		con.put("searchWord", "searchWord");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12492126);
		head.put("chcode", "viTIKkLDeKMU85CexwSsWgSCZBAAiPhQ");
		head.put("cmd", 3902);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询的订单分类编码不存在" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 查询的订单分类编码为null
	 */
	@Test
	public void postAuthenticateTestClidIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("clid", 0);
		con.put("searchWord", "searchWord");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12492126);
		head.put("chcode", "viTIKkLDeKMU85CexwSsWgSCZBAAiPhQ");
		head.put("cmd", 3902);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询的订单分类编码为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 查询错误用户id的订单
	 */
	@Test
	public void postAuthenticateTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("clid", 0);
		con.put("searchWord", "searchWord");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12492126);
		head.put("chcode", "viTIKkLDeKMU85CexwSsWgSCZBAAiPhQ");
		head.put("cmd", 3902);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询错误用户id的订单" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 查询用户id未登录的订单
	 */
	@Test
	public void postAuthenticateTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("clid", 0);
		con.put("searchWord", "searchWord");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12492126);
		head.put("chcode", "viTIKkLDeKMU85CexwSsWgSCZBAAiPhQ");
		head.put("cmd", 3902);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询用户id未登录的订单" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户id的非法字符
	 */
	@Test
	public void postAuthenticateTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "<.$%^>");
		con.put("clid", 0);
		con.put("searchWord", "searchWord");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12492126);
		head.put("chcode", "viTIKkLDeKMU85CexwSsWgSCZBAAiPhQ");
		head.put("cmd", 3902);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id的非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户id的为空
	 */
	@Test
	public void postAuthenticateTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("clid", 0);
		con.put("searchWord", "searchWord");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12492126);
		head.put("chcode", "viTIKkLDeKMU85CexwSsWgSCZBAAiPhQ");
		head.put("cmd", 3902);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id的为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户id的为null
	 */
	@Test
	public void postAuthenticateTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		con.put("clid", 0);
		con.put("searchWord", "searchWord");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12492126);
		head.put("chcode", "viTIKkLDeKMU85CexwSsWgSCZBAAiPhQ");
		head.put("cmd", 3902);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id的为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户id的为空格
	 */
	@Test
	public void postAuthenticateTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("clid", 0);
		con.put("searchWord", "searchWord");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12492126);
		head.put("chcode", "viTIKkLDeKMU85CexwSsWgSCZBAAiPhQ");
		head.put("cmd", 3902);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id的为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户id的不传该参数
	 */
	@Test
	public void postAuthenticateTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("clid", 0);
		con.put("searchWord", "searchWord");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12492126);
		head.put("chcode", "viTIKkLDeKMU85CexwSsWgSCZBAAiPhQ");
		head.put("cmd", 3902);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id的不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 查询订单订单分类为空格
	 */
	@Test
	public void postAuthenticateTestSearchWordIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492125);
		con.put("clid", 0);
		con.put("searchWord", " ");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", 12492126);
		head.put("chcode", "viTIKkLDeKMU85CexwSsWgSCZBAAiPhQ");
		head.put("cmd", 3902);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("查询订单订单分类为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}

	
	
}