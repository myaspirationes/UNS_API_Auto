package com.webDynamic.complaintReasonManagement;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.login.BackUserLoginTest;
import com.example.CryptographyUtil;
import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchGetComplaintsList extends HttpUtil {
	// 搜索获取投诉原因列表接口
	String url = "/uu-admin/SystemManager/getComplaintsList";
	
	String dataType = "perCenter81";
	
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}
	
	
			
	
	/**
	 * 提交正确参数：type为0
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 0);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交正确参数：type=1
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 1);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为1" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交正确参数：type=2
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 2);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为2" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交正确参数：type=3
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIs3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 3);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为3" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交正确参数：type=4
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIs4() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为4" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交正确参数：type=5
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIs5() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 5);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为5" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交正确参数：type=6
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIs6() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 6);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为6" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交错误的type值
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIs7() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 7);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交错误的type值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交type为负数
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIsNegtive() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", -1);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交type为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交type为正确的String类型
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", "4");
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交type为正确的String类型" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交type为特殊字符
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIsIllegalCharacter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", "#$%%^&");
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交type为特殊字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交type为超长字符
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", "1234678745451122121554544646444444444444454444444");
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交type为超长字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交type为小数
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", "12.3");
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交type为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交type为空格
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", " ");
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交type为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交type为空
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", "");
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交type为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交type为null
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", null);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交type为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 不提交type参数
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("不提交type参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交reason为特殊字符
	 */
//	@Test
	public void postDeleteComplainReasonTestReasonIsIllegalCharacter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "!@#$%^&*");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reason为特殊字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交reason为int型
	 */
//	@Test
	public void postDeleteComplainReasonTestReasonIsInt() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", 123);
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reason为int型" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交reason为超长字符
	 */
//	@Test
	public void postDeleteComplainReasonTestReasonIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "是绝对不被封为瑞文月份护额发货的精神病jbzxnbclhrfsafl啊手机卡可是当时觉得还是觉得sjdhasjhsjdhajcbxznmcbu事件发生的数据库的数据库都很费劲大家的看法和");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reason为int型" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交reason为空格
	 */
//	@Test
	public void postDeleteComplainReasonTestReasonIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", " ");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reason为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交reason为空
	 */
//	@Test
	public void postDeleteComplainReasonTestReasonIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reason为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交reason为null
	 */
//	@Test
	public void postDeleteComplainReasonTestReasonIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", null);
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reason为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 不提交reason参数
	 */
//	@Test
	public void postDeleteComplainReasonTestReasonNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("不提交reason参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交userId为错误的
	 */
//	@Test
	public void postDeleteComplainReasonTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", 11);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为错误的" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交userId为未登录的
	 */
//	@Test
	public void postDeleteComplainReasonTestUserIdIsNotLogin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", 11);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为未登录的" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交userId为0
	 */
//	@Test
	public void postDeleteComplainReasonTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交userId为负数
	 */
//	@Test
	public void postDeleteComplainReasonTestUserIdIsNegative() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交userId为小数
	 */
//	@Test
	public void postDeleteComplainReasonTestUserIdIsDynamic() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", 1.2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交userId为正确的string型
	 */
//	@Test
	public void postDeleteComplainReasonTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", "10000000");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为正确的string型" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交userId为非法字符
	 */
//	@Test
	public void postDeleteComplainReasonTestUserIdIsIllegalCharacter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", "!@#$%^&*");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交userId为超长字符
	 */
//	@Test
	public void postDeleteComplainReasonTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", "313212333333333333333345454545454545454545454545879999999");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为超长字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交userId为空格
	 */
//	@Test
	public void postDeleteComplainReasonTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", " ");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交userId为空
	 */
//	@Test
	public void postDeleteComplainReasonTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", "");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交userId为null
	 */
//	@Test
	public void postDeleteComplainReasonTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", null);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 不提交userId参数
	 */
//	@Test
	public void postDeleteComplainReasonTestUserIdNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("UserId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("不提交userId参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交startTime为错误的时间格式
	 */
//	@Test
	public void postDeleteComplainReasonTestStartTimeIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017/06/12");
		request.put("endTime", "2017-06-12");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交startTime为错误的时间格式" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交startTime为时间戳
	 */
//	@Test
	public void postDeleteComplainReasonTestStartTimeIsTimestamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "1529049251");
		request.put("endTime", "2017-06-12");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交startTime为时间戳" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交startTime为非法字符
	 */
//	@Test
	public void postDeleteComplainReasonTestStartTimeIsIllegalCharacter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "!@#%$%^&");
		request.put("endTime", "2017-06-12");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交startTime为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交startTime为超长字符
	 */
//	@Test
	public void postDeleteComplainReasonTestStartTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "654513216574685354563455315142541532415454568768");
		request.put("endTime", "2017-06-12");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交startTime为超长字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交startTime为int型
	 */
//	@Test
	public void postDeleteComplainReasonTestStartTimeIsInt() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", 1529049251);
		request.put("endTime", "2017-06-12");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交startTime为int型" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交startTime为空格
	 */
//	@Test
	public void postDeleteComplainReasonTestStartTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", " ");
		request.put("endTime", "2017-06-12");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交startTime为int型" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交startTime为空
	 */
//	@Test
	public void postDeleteComplainReasonTestStartTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "");
		request.put("endTime", "2017-06-12");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交startTime为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交startTime为null
	 */
//	@Test
	public void postDeleteComplainReasonTestStartTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", null);
		request.put("endTime", "2017-06-12");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交startTime为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 不提交startTime
	 */
//	@Test
	public void postDeleteComplainReasonTestStartTimeNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("endTime", "2017-06-12");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交startTime为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交endTime为错误的时间格式
	 */
//	@Test
	public void postDeleteComplainReasonTestEndTimeIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017/06/12");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交endTime为错误的时间格式" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交endTime为时间戳
	 */
//	@Test
	public void postDeleteComplainReasonTestEndTimeIsTimestamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "1529049251");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交endTime为时间戳" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交endTime为非法字符
	 */
//	@Test
	public void postDeleteComplainReasonTestEndTimeIsIllegalCharacter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "!@#$%^&*");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交endTime为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交endTime为超长字符
	 */
//	@Test
	public void postDeleteComplainReasonTestEndTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2132132465787777777777746546546546546546546546521221111165644666666666666");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交endTime为超长字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交endTime为空格
	 */
//	@Test
	public void postDeleteComplainReasonTestEndTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", " ");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交endTime为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交endTime为空
	 */
//	@Test
	public void postDeleteComplainReasonTestEndTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交endTime为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交endTime为null
	 */
//	@Test
	public void postDeleteComplainReasonTestEndTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", null);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交endTime为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 不提交endTime
	 */
//	@Test
	public void postDeleteComplainReasonTestEndTimeNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("不提交endTime" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交pageSize为10000
	 */
//	@Test
	public void postDeleteComplainReasonTestPageSizeIs10000() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("pageSize", 10000);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageSize为10000" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交pageSize为string型
	 */
//	@Test
	public void postDeleteComplainReasonTestPageSizeIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("pageSize", "10");
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageSize为string型" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交pageSize为负数
	 */
//	@Test
	public void postDeleteComplainReasonTestPageSizeIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("pageSize", -1);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageSize为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
		
	/**
	 * 提交pageSize为小数
	 */
//	@Test
	public void postDeleteComplainReasonTestPageSizeIsNegative() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("pageSize", "1.3");
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageSize为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交pageSize为0
	 */
//	@Test
	public void postDeleteComplainReasonTestPageSizeIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("pageSize", 0);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageSize为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交pageSize为非法字符串
	 */
//	@Test
	public void postDeleteComplainReasonTestPageSizeIsIllegalCharacter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("pageSize", "!@#$%^&*");
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageSize为非法字符串" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交pageSize为超长字符
	 */
//	@Test
	public void postDeleteComplainReasonTestPageSizeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("pageSize", "10000000000000000000000000000000000000000000");
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageSize为超长字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交pageSize为空
	 */
//	@Test
	public void postDeleteComplainReasonTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("pageSize", "");
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageSize为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交pageSize为空格
	 */
//	@Test
	public void postDeleteComplainReasonTestPageSizeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("pageSize", " ");
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageSize为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交pageSize为null
	 */
//	@Test
	public void postDeleteComplainReasonTestPageSizeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("pageSize", null);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageSize为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 不提交pageSize
	 */
//	@Test
	public void postDeleteComplainReasonTestPageSizeNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("不提交pageSize" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交pageNow为10000
	 */
//	@Test
	public void postDeleteComplainReasonTestPageNowIs10000() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("pageNow", 10000);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageNow为10000" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交pageNow为string型
	 */
//	@Test
	public void postDeleteComplainReasonTestPageNowIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("pageNow", "1");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageNow为string型" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交pageNow为小数
	 */
//	@Test
	public void postDeleteComplainReasonTestPageNowIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("pageNow", 1.2);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageNow为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交pageNow为负数
	 */
//	@Test
	public void postDeleteComplainReasonTestPageNowIsNegative() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("pageNow", -1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageNow为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交pageNow为0
	 */
//	@Test
	public void postDeleteComplainReasonTestPageNowIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("pageNow", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageNow为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交pageNow为特殊字符
	 */
//	@Test
	public void postDeleteComplainReasonTestPageNowIsIllegalCharacter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("pageNow", "!@#$%^&*");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageNow为特殊字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交pageNow为超长字符
	 */
//	@Test
	public void postDeleteComplainReasonTestPageNowIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("pageNow", "1000000000000000000000000000000000000");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageNow为特殊字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交pageNow为空格
	 */
//	@Test
	public void postDeleteComplainReasonTestPageNowIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("pageNow", " ");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageNow为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	


	/**
	 * 提交pageNow为null
	 */
//	@Test
	public void postDeleteComplainReasonTestPageNowIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");
		request.put("pageNow", null);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageNow为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 不提交pageNow
	 */
//	@Test
	public void postDeleteComplainReasonTestPageNowNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("startTime", "2017-06-12");
		request.put("endTime", "2017-06-12");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("不提交pageNow" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
}