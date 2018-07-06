package com.postcard;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;
import com.example.LoginTest;
//import com.example.LoginTest;

public class GetAListOfNameCardCommunitiesTest extends HttpUtil {
	//获取名信片社群列表
	String url = "/uu-admin/sensitiveWord/addOrEditSensitiveWord";
	Map<String, Object> head = new HashMap<String, Object>();
	JSONObject body177;
	String uuid;
	String chcode;
	@BeforeClass
	public void  beforeClass() throws Exception {
		LoginTest login = new LoginTest();
		try {
			body177 = login.getLoginTestChcodeBy177();
			uuid= (body177.get("uuid")).toString();
			chcode= (body177.get("checkCode")).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		head.put("aid", "lan6uu");
		head.put("ver", "1.2.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", chcode);
		head.put("cmd", 3415);
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestCorrectParameter() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cardId", 10000263);
		con.put("pageSize", 1);
		con.put("pageNow", 1);
		con.put("showType", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 用户id为为最大值
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestuuidIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", 999999999999999999L);
		con.put("cardId", 10000263);
		con.put("pageSize", 1);
		con.put("pageNow", 1);
		con.put("showType", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 用户id为为空
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestuuidIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", "");
		con.put("cardId", 10000263);
		con.put("pageSize", 1);
		con.put("pageNow", 1);
		con.put("showType", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 用户id为为空格
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestuuidIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", " ");
		con.put("cardId", 10000263);
		con.put("pageSize", 1);
		con.put("pageNow", 1);
		con.put("showType", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 用户id为null
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestuuidIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", null);
		con.put("cardId", 10000263);
		con.put("pageSize", 1);
		con.put("pageNow", 1);
		con.put("showType", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 用户id为不传该参数
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestuuidNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("cardId", 10000263);
		con.put("pageSize", 1);
		con.put("pageNow", 1);
		con.put("showType", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 	名信片id最大值
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestCardIdIsMax() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cardId", 999999999999999999L);
		con.put("pageSize", 1);
		con.put("pageNow", 1);
		con.put("showType", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("名信片id最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 	名信片id为空
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestCardIdIsEmpty() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cardId", "");
		con.put("pageSize", 1);
		con.put("pageNow", 1);
		con.put("showType", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("名信片id为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 	名信片id为空格
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestCardIdIsSpace() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cardId", " ");
		con.put("pageSize", 1);
		con.put("pageNow", 1);
		con.put("showType", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("名信片id为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 	名信片id为null
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestCardIdIsNull() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cardId", null);
		con.put("pageSize", 1);
		con.put("pageNow", 1);
		con.put("showType", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("名信片id为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 	名信片id不传该参数
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestCardIdNonSubmissionParameters() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("pageSize", 1);
		con.put("pageNow", 1);
		con.put("showType", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("名信片id不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 	页面数量为最大值
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestPageSizeIsMax() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cardId", 10000263);
		con.put("pageSize", 999999999);
		con.put("pageNow", 1);
		con.put("showType", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("页面数量为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 	页面数量为空
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestPageSizeIsEmpty() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cardId", 10000263);
		con.put("pageSize", "");
		con.put("pageNow", 1);
		con.put("showType", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("页面数量为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 	页面数量为空格
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestPageSizeIsSpace() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cardId", 10000263);
		con.put("pageSize", " ");
		con.put("pageNow", 1);
		con.put("showType", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("页面数量为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 	页面数量为null
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestPageSizeIsNull() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cardId", 10000263);
		con.put("pageSize", null);
		con.put("pageNow", 1);
		con.put("showType", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("页面数量为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 	页面数量不传改值
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestPageSizeNonSubmissionParameters() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cardId", 10000263);
		con.put("pageNow", 1);
		con.put("showType", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("页面数量不传改值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	
	
	/**
	 * 	当前页为最大值
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestPageNowIsMax() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cardId", 10000263);
		con.put("pageSize", 1);
		con.put("pageNow", 999999999);
		con.put("showType", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 	当前页为空
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestPageNowIsEmpty() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cardId", 10000263);
		con.put("pageSize", 1);
		con.put("pageNow", "");
		con.put("showType", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 	当前页为空格
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestPageNowIsSpace() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cardId", 10000263);
		con.put("pageSize", 1);
		con.put("pageNow", " ");
		con.put("showType", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 	当前页为null
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestPageNowIsNull() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cardId", 10000263);
		con.put("pageSize", 1);
		con.put("pageNow", null);
		con.put("showType", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 	当前页不传该参数
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestPageNowNonSubmissionParameters() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cardId", 10000263);
		con.put("pageSize", 1);
		con.put("showType", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	
	
	
	/**
	 * 	显示类型为0
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestShowTypeIsZero() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cardId", 10000263);
		con.put("pageSize", 1);
		con.put("pageNow", 1);
		con.put("showType", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("显示类型为0" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 	显示类型为1
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestShowTypeIsOne() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cardId", 10000263);
		con.put("pageSize", 1);
		con.put("pageNow", 1);
		con.put("showType", 1);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("显示类型为1" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 	显示类型为空
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestShowTypeIsEmpty() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cardId", 10000263);
		con.put("pageSize", 1);
		con.put("pageNow", 1);
		con.put("showType", "");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("显示类型为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 	显示类型为空格
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestShowTypeIsSpace() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cardId", 10000263);
		con.put("pageSize", 1);
		con.put("pageNow", 1);
		con.put("showType", " ");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("显示类型为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 	显示类型为 null
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestShowTypeIsNull() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cardId", 10000263);
		con.put("pageSize", 1);
		con.put("pageNow", 1);
		con.put("showType", null);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("显示类型为 null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("显示类型为 null");
	}
	/**
	 * 	显示类型为最大值
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestShowTypeIsMax() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cardId", 10000263);
		con.put("pageSize", 1);
		con.put("pageNow", 1);
		con.put("showType", 999999999);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("显示类型为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 	显示类型为不传该参数
	 */
	@Test
	public void postGetAListOfNameCardCommunitiesTestShowTypeNonSubmissionParameters() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cardId", 10000263);
		con.put("pageSize", 1);
		con.put("pageNow", 1);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("显示类型为不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	
	
	
	
}