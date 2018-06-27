package com.webDynamic.complaintManagement;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;
//import com.example.LoginTest;

public class GetComplaintListTest extends HttpUtil {
	//获取投诉列表接口
	String url = "/uu-admin/complaint/getComplaintList";


	String userid;
	@BeforeClass
	public void  beforeClass(){
		userid = new BackUserLoginTest().userId;
		
	}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetComplaintListTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
//		request.put("functionCategory", "");
//		request.put("complaintStartTime", "2018-04-29 13:13:13");
//		request.put("complaintEndTime", "2018-06-29 13:13:13");
//		request.put("businessCategories", 1);
//		request.put("status", 1);
//		request.put("complaintObject", "x");
// 		request.put("keyWord", "");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能分类为0评论
	 */
	@Test
	public void postGetComplaintListTestFunctionCategoryIsComment() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能分类为0评论" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 功能分类为1动态
	 */
	@Test
	public void postGetComplaintListTestFunctionCategoryIsDynamic() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 1);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能分类为1动态" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 功能分类为2商品
	 */
	@Test
	public void postGetComplaintListTestFunctionCategoryIsCommodity() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 2);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能分类为2商品" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 功能分类为3订单
	 */
	@Test
	public void postGetComplaintListTestFunctionCategoryIsOrders() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 3);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能分类为3订单" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 功能分类为4社群
	 */
	@Test
	public void postGetComplaintListTestFunctionCategoryIsCommunities() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 4);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能分类为4社群" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 功能分类为5用户
	 */
	@Test
	public void postGetComplaintListTestFunctionCategoryIsUser() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 5);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能分类为5用户" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 功能分类为错误
	 */
	@Test
	public void postGetComplaintListTestFunctionCategoryIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 124921745);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能分类为错误" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 功能分类为小数
	 */
	@Test
	public void postGetComplaintListTestFunctionCategoryIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 1.1);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能分类为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 功能分类为负数
	 */
	@Test
	public void postGetComplaintListTestFunctionCategoryIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", -1);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能分类为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 功能分类为字符串
	 */
	@Test
	public void postGetComplaintListTestFunctionCategoryIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", "functionCategory");
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能分类为字符串" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 功能分类为空
	 */
	@Test
	public void postGetComplaintListTestFunctionCategoryIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", " ");
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能分类为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 功能分类为空格
	 */
	@Test
	public void postGetComplaintListTestFunctionCategoryIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", " ");
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能分类为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 功能分类为null
	 */
	@Test
	public void postGetComplaintListTestFunctionCategoryIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", null);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能分类为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 功能分类不传该参数
	 */
	@Test
	public void postGetComplaintListTestFunctionCategoryNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能分类不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 投诉开始时间大于投诉结束时间
	 */
	@Test
	public void postGetComplaintListTestComplaintStartTimeGreaterThanComplaintEndTime() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-06-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉开始时间大于投诉结束时间" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 投诉开始时间为时间戳
	 */
	@Test
	public void postGetComplaintListTestComplaintStartTimeIsTimeStamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "1529391256000");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉开始时间为时间戳" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉开始时间传年月日
	 */
	@Test
	public void postGetComplaintListTestComplaintStartTimeIsYMD() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-03-28");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉开始时间传年月日" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉开始时间传年月日最大值
	 */
	@Test
	public void postGetComplaintListTestComplaintStartTimeIsYMDMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "9999-12-31");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉开始时间传年月日最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉开始时间传年月日最小值
	 */
	@Test
	public void postGetComplaintListTestComplaintStartTimeIsYMDMin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "0000-01-01");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉开始时间传年月日最小值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉开始时间传时分秒
	 */
	@Test
	public void postGetComplaintListTestComplaintStartTimeIsHMS() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "17:12:30");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉开始时间传时分秒最大值
	 */
	@Test
	public void postGetComplaintListTestComplaintStartTimeIsHMSMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "23:59:59");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉开始时间传时分秒最小值
	 */
	@Test
	public void postGetComplaintListTestComplaintStartTimeIsHMSMin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "00:00:00");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉开始时间传时分秒最小值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉开始时间传年月日时分秒
	 */
	@Test
	public void postGetComplaintListTestComplaintStartTimeIsYMDHMS() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-03-29 17:12:30");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉开始时间传年月日时分秒" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉开始时间传年月日时分秒最大值
	 */
	@Test
	public void postGetComplaintListTestComplaintStartTimeIsYMDHMSMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "9999-12-31 23:59:59");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉开始时间传年月日时分秒最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉开始时间传年月日时分秒最小值
	 */
	@Test
	public void postGetComplaintListTestComplaintStartTimeIsYMDHMSMin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "0000-01-01 00:00:00");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉开始时间传年月日时分秒最小值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉开始时间传年月日时分秒去掉中间值
	 */
	@Test
	public void postGetComplaintListTestComplaintStartTimeRemoveTheFormat() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "20180529171230");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉开始时间传年月日时分秒去掉中间值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉开始时间传字符串
	 */
	@Test
	public void postGetComplaintListTestComplaintStartTimeIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "SSSS");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉开始时间传字符串" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉开始时间传空
	 */
	@Test
	public void postGetComplaintListTestComplaintStartTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉开始时间传空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉开始时间传空格
	 */
	@Test
	public void postGetComplaintListTestComplaintStartTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", " ");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉开始时间传空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉开始时间传null
	 */
	@Test
	public void postGetComplaintListTestComplaintStartTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", null);
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉开始时间传null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉开始时间传小数
	 */
	@Test
	public void postGetComplaintListTestComplaintStartTimeIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", 1.1);
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉开始时间传小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉开始时间传负数
	 */
	@Test
	public void postGetComplaintListTestComplaintStartTimeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", -1);
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉开始时间传负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉开始时间传0
	 */
	@Test
	public void postGetComplaintListTestComplaintStartTimeIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", 0);
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉开始时间传0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉开始时间不传该参数
	 */
	@Test
	public void postGetComplaintListTestComplaintStartTimeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉开始时间不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 投诉结束时间为时间戳
	 */
	@Test
	public void postGetComplaintListTestComplaintEndTimeIsTimeStamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintEndTime", "1529391256000");
		request.put("complaintStartTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉结束时间为时间戳" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉结束时间传年月日
	 */
	@Test
	public void postGetComplaintListTestComplaintEndTimeIsYMD() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintEndTime", "2018-03-28");
		request.put("complaintStartTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉结束时间传年月日" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉结束时间传年月日最大值
	 */
	@Test
	public void postGetComplaintListTestComplaintEndTimeIsYMDMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintEndTime", "9999-12-31");
		request.put("complaintStartTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉结束时间传年月日最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉结束时间传年月日最小值
	 */
	@Test
	public void postGetComplaintListTestComplaintEndTimeIsYMDMin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintEndTime", "0000-01-01");
		request.put("complaintStartTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉结束时间传年月日最小值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉结束时间传时分秒
	 */
	@Test
	public void postGetComplaintListTestComplaintEndTimeIsHMS() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintEndTime", "17:12:30");
		request.put("complaintStartTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉结束时间传时分秒最大值
	 */
	@Test
	public void postGetComplaintListTestComplaintEndTimeIsHMSMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintEndTime", "23:59:59");
		request.put("complaintStartTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉结束时间传时分秒最小值
	 */
	@Test
	public void postGetComplaintListTestComplaintEndTimeIsHMSMin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintEndTime", "00:00:00");
		request.put("complaintStartTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉结束时间传时分秒最小值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉结束时间传年月日时分秒
	 */
	@Test
	public void postGetComplaintListTestComplaintEndTimeIsYMDHMS() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintEndTime", "2018-03-29 17:12:30");
		request.put("complaintStartTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉结束时间传年月日时分秒" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉结束时间传年月日时分秒最大值
	 */
	@Test
	public void postGetComplaintListTestComplaintEndTimeIsYMDHMSMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintEndTime", "9999-12-31 23:59:59");
		request.put("complaintStartTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉结束时间传年月日时分秒最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉结束时间传年月日时分秒最小值
	 */
	@Test
	public void postGetComplaintListTestComplaintEndTimeIsYMDHMSMin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintEndTime", "0000-01-01 00:00:00");
		request.put("complaintStartTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉结束时间传年月日时分秒最小值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉结束时间传年月日时分秒去掉中间值
	 */
	@Test
	public void postGetComplaintListTestComplaintEndTimeRemoveTheFormat() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintEndTime", "20180529171230");
		request.put("complaintStartTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉结束时间传年月日时分秒去掉中间值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉结束时间传字符串
	 */
	@Test
	public void postGetComplaintListTestComplaintEndTimeIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintEndTime", "SSSS");
		request.put("complaintStartTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉结束时间传字符串" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉结束时间传空
	 */
	@Test
	public void postGetComplaintListTestComplaintEndTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintEndTime", "");
		request.put("complaintStartTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉结束时间传空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉结束时间传空格
	 */
	@Test
	public void postGetComplaintListTestComplaintEndTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintEndTime", " ");
		request.put("complaintStartTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉结束时间传空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉结束时间传null
	 */
	@Test
	public void postGetComplaintListTestComplaintEndTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintEndTime", null);
		request.put("complaintStartTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉结束时间传null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉结束时间传小数
	 */
	@Test
	public void postGetComplaintListTestComplaintEndTimeIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintEndTime", 1.1);
		request.put("complaintStartTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉结束时间传小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉结束时间传负数
	 */
	@Test
	public void postGetComplaintListTestComplaintEndTimeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintEndTime", -1);
		request.put("complaintStartTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉结束时间传负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉结束时间传0
	 */
	@Test
	public void postGetComplaintListTestComplaintEndTimeIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintEndTime", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉结束时间传0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 投诉结束时间不传该参数
	 */
	@Test
	public void postGetComplaintListTestComplaintEndTimeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉结束时间不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 业务类型为0电商
	 */
	@Test
	public void postGetComplaintListTestBusinessCategoriesIsElectricitySupplier() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 0);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("业务类型为0电商" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 业务类型为1二手商品
	 */
	@Test
	public void postGetComplaintListTestBusinessCategoriesIsCommodity() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("业务类型为1二手商品" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 业务类型为2社交
	 */
	@Test
	public void postGetComplaintListTestBusinessCategoriesIsSocial() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 2);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("业务类型为2社交" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 业务类型为负数
	 */
	@Test
	public void postGetComplaintListTestBusinessCategoriesIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", -1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("业务类型为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 业务类型为小数
	 */
	@Test
	public void postGetComplaintListTestBusinessCategoriesIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1.1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("业务类型为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 业务类型为字符串
	 */
	@Test
	public void postGetComplaintListTestBusinessCategoriesIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", "businessCategories");
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("业务类型为字符串" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 业务类型为空
	 */
	@Test
	public void postGetComplaintListTestBusinessCategoriesIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", "");
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("业务类型为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 业务类型为空格
	 */
	@Test
	public void postGetComplaintListTestBusinessCategoriesIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", " ");
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("业务类型为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 业务类型为null
	 */
	@Test
	public void postGetComplaintListTestBusinessCategoriesIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", null);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("业务类型为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 业务类型为最大值
	 */
	@Test
	public void postGetComplaintListTestBusinessCategoriesIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 999999999);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("业务类型为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 业务类型为超长
	 */
	@Test
	public void postGetComplaintListTestBusinessCategoriesIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1111111111111L);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("业务类型为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 业务类型不传该参数
	 */
	@Test
	public void postGetComplaintListTestBusinessCategoriesNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("业务类型不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 状态为0已处理
	 */
	@Test
	public void postGetComplaintListTestStatusIsProcessed() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 0);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为0已处理" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 状态为1未处理
	 */
	@Test
	public void postGetComplaintListTestStatusIsUnprocessed() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为1未处理" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 状态为错误
	 */
	@Test
	public void postGetComplaintListTestStatusIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 9);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为错误" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 状态为小数
	 */
	@Test
	public void postGetComplaintListTestStatusIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1.9);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 状态为负数
	 */
	@Test
	public void postGetComplaintListTestStatusIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", -1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 状态为字符串
	 */
	@Test
	public void postGetComplaintListTestStatusIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", "status");
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为字符串" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 状态为最大值
	 */
	@Test
	public void postGetComplaintListTestStatusIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 999999999);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 状态为超长
	 */
	@Test
	public void postGetComplaintListTestStatusIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 999999999999L);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 状态为空格
	 */
	@Test
	public void postGetComplaintListTestStatusIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", " ");
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 状态为空
	 */
	@Test
	public void postGetComplaintListTestStatusIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", "");
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 状态为null
	 */
	@Test
	public void postGetComplaintListTestStatusIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", null);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 状态为不传该参数
	 */
	@Test
	public void postGetComplaintListTestStatusNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 投诉对象名称为超长
	 */
	@Test
	public void postGetComplaintListTestComplaintObjectIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "complaintObjectcomplaintObjectcomplaintObjectcomplaintObjectcomplaintObjectcomplaintObjectcomplaintObjectcomplaintObjectcomplaintObjectcomplaintObjectcomplaintObjectcomplaintObjectcomplaintObjectcomplaintObjectcomplaintObjectcomplaintObjectcomplaintObjectcomplaintObjectcomplaintObjectcomplaintObjectcomplaintObjectcomplaintObjectcomplaintObject");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉对象名称为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 投诉对象名称为非法字符
	 */
	@Test
	public void postGetComplaintListTestComplaintObject() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "<.@#$%>");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉对象名称为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 投诉对象为名称为空
	 */
	@Test
	public void postGetComplaintListTestComplaintObjectIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉对象为名称为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 投诉对象名称为空格
	 */
	@Test
	public void postGetComplaintListTestComplaintObjectIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", " ");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉对象名称为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 投诉对象名称为null
	 */
	@Test
	public void postGetComplaintListTestComplaintObjectIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", null);
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉对象名称为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 投诉对象名称不传该参数
	 */
	@Test
	public void postGetComplaintListTestComplaintObjectNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("投诉对象名称不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 关键字为超长
	 */
	@Test
	public void postGetComplaintListTestKeyWordIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "keyWordkeyWordkeyWordkeyWordkeyWordkeyWordkeyWordkeyWordkeyWordkeyWordkeyWordkeyWordkeyWordkeyWordkeyWordkeyWordkeyWordkeyWordkeyWordkeyWordkeyWordkeyWordkeyWordkeyWordkeyWordkeyWordkeyWordkeyWordkeyWordkeyWordkeyWord");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键字为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 关键字为非法字符
	 */
	@Test
	public void postGetComplaintListTestKeyWordIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "<.#$%^>");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键字为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 关键字为空
	 */
	@Test
	public void postGetComplaintListTestKeyWordIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键字为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 关键字为空格
	 */
	@Test
	public void postGetComplaintListTestKeyWordIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", " ");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键字为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 关键字为null
	 */
	@Test
	public void postGetComplaintListTestKeyWordIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", null);
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键字为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 关键字不传该参数
	 */
	@Test
	public void postGetComplaintListTestKeyWordNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键字不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 当前页数为小数
	 */
	@Test
	public void postGetComplaintListTestPageNowIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1.2);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 当前页数为负数
	 */
	@Test
	public void postGetComplaintListTestPageNowIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", -1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 当前页数为字符串
	 */
	@Test
	public void postGetComplaintListTestPageNowIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", "pageNow");
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为字符串" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 当前页数为0
	 */
	@Test
	public void postGetComplaintListTestPageNowIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 0);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 当前页数为最大值
	 */
	@Test
	public void postGetComplaintListTestPageNowIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 999999999);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 当前页数为超长
	 */
	@Test
	public void postGetComplaintListTestPageNowIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 111111111111L);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 当前页数为空
	 */
	@Test
	public void postGetComplaintListTestPageNowIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", "");
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 当前页数为空格
	 */
	@Test
	public void postGetComplaintListTestPageNowIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", " ");
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 当前页数为null
	 */
	@Test
	public void postGetComplaintListTestPageNowIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", null);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 当前页数为不传该参数
	 */
	@Test
	public void postGetComplaintListTestPageNowNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 每页条数为小数
	 */
	@Test
	public void postGetComplaintListTestPageSizeIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageSize", 1.2);
		request.put("pageNow", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页条数为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 每页条数为负数
	 */
	@Test
	public void postGetComplaintListTestPageSizeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageSize", -1);
		request.put("pageNow", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 每页条数为字符串
	 */
	@Test
	public void postGetComplaintListTestPageSizeIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageSize", "pageSize");
		request.put("pageNow", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页条数为字符串" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 每页条数为0
	 */
	@Test
	public void postGetComplaintListTestPageSizeIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageSize", 0);
		request.put("pageNow", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页条数为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 每页条数为最大值
	 */
	@Test
	public void postGetComplaintListTestPageSizeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageSize", 999999999);
		request.put("pageNow", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页条数为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 每页条数为超长
	 */
	@Test
	public void postGetComplaintListTestPageSizeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageSize", 111111111111L);
		request.put("pageNow", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页条数为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 每页条数为空
	 */
	@Test
	public void postGetComplaintListTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageSize", "");
		request.put("pageNow", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页条数为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 每页条数为空格
	 */
	@Test
	public void postGetComplaintListTestPageSizeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageSize", " ");
		request.put("pageNow", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页条数为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 每页条数为null
	 */
	@Test
	public void postGetComplaintListTestPageSizeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageSize", null);
		request.put("pageNow", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页条数为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 每页条数为不传该参数
	 */
	@Test
	public void postGetComplaintListTestPageSizeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页条数为不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID未登录
	 */
	@Test
	public void postGetComplaintListTestOperateUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", userid);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID未登录" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID为错误
	 */
	@Test
	public void postGetComplaintListTestOperateUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", 123);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为错误" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID为超长
	 */
	@Test
	public void postGetComplaintListTestOperateUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", 123123123123123L);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID为字符串
	 */
	@Test
	public void postGetComplaintListTestOperateUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", "userId");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为字符串" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID为小数
	 */
	@Test
	public void postGetComplaintListTestOperateUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", 1.1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID为负数
	 */
	@Test
	public void postGetComplaintListTestOperateUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", -1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID为0
	 */
	@Test
	public void postGetComplaintListTestOperateUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID为空格
	 */
	@Test
	public void postGetComplaintListTestOperateUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", " ");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID为空
	 */
	@Test
	public void postGetComplaintListTestOperateUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", "");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID为null
	 */
	@Test
	public void postGetComplaintListTestOperateUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);
		request.put("userId", null);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 操作用户ID不传该参数
	 */
	@Test
	public void postGetComplaintListTestOperateUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("functionCategory", 0);
		request.put("complaintStartTime", "2018-05-29");
		request.put("complaintEndTime", "2018-05-29");
		request.put("businessCategories", 1);
		request.put("status", 1);
		request.put("complaintObject", "x");
		request.put("keyWord", "xx");
		request.put("pageNow", 1);
		request.put("pageSize", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

}