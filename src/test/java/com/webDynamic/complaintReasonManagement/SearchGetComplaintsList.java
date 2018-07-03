package com.webDynamic.complaintReasonManagement;
import com.webDynamic.complaintReasonManagement.AddAndEditComplainList;
import com.example.HttpUtil;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;
import com.example.CryptographyUtil;
import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchGetComplaintsList extends HttpUtil {
	// 搜索获取投诉原因列表接口
	String url = "/uu-admin/complainManage/queryComplainReasonList";
	
	String dataType = "uedb";
	String deleteSql = "DELETE FROM T_AUDIT_MSG WHERE MSG_CONTENT = '自动化测试投诉原因'";
	List<Map<String,Object>> list ;
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}
	@BeforeMethod
	public void  beforeMethod() throws Exception {
		new AddAndEditComplainList().postAddAndEditComplainListTestTypeIs0();
	}
	@AfterMethod
		public void afterMethod()
		{
			MetaOper.delete(deleteSql, dataType);
		}
	@AfterClass
		public void afterClass(){
			MetaOper.delete(deleteSql, dataType);
		}
			
	
	/**
	 * 提交正确参数：category为0
	 */
	@Test
	public void postSearchGetComplaintsListTestCategoryIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("keyComplain", "自动化测试");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：category为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交正确参数：category=1
	 */
	@Test
	public void postSearchGetComplaintsListTestCategoryIs1() throws Exception {
		new AddAndEditComplainList().postAddAndEditComplainListTestTypeIs1();
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 1);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：category为1" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交正确参数：category=2
	 */
	@Test
	public void postSearchGetComplaintsListTestCategoryIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 2);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：category为2" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交正确参数：category=3
	 */
	@Test
	public void postSearchGetComplaintsListTestCategoryIs3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 3);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：category为3" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交正确参数：category=4
	 */
	@Test
	public void postSearchGetComplaintsListTestCategoryIs4() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：category为4" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交正确参数：category=5
	 */
	@Test
	public void postSearchGetComplaintsListTestCategoryIs5() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 5);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：category为5" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交正确参数：category=6
	 */
	@Test
	public void postSearchGetComplaintsListTestCategoryIs6() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 6);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：category为6" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交错误的category值
	 */
	@Test
	public void postSearchGetComplaintsListTestCategoryIs7() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 7);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交错误的category值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("totalcount")).isEqualTo(0);
	}
	
	/**
	 * 提交category为负数
	 */
	@Test
	public void postSearchGetComplaintsListTestCategoryIsNegtive() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", -9);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交category为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("totalcount")).isEqualTo(0);
	}
	
	/**
	 * 提交category为正确的String类型
	 */
	@Test
	public void postSearchGetComplaintsListTestCategoryIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", "ddd");
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交category为正确的String类型" + post);

		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交category为特殊字符
	 */
	@Test
	public void postSearchGetComplaintsListTestCategoryIsIllegalCharacter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", "#$%%^&");
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交category为特殊字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交category为超长字符
	 */
	@Test
	public void postSearchGetComplaintsListTestCategoryIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", "1234678745451122121554544646444444444444454444444");
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交category为超长字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交category为小数
	 */
	@Test
	public void postSearchGetComplaintsListTestCategoryIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 12.3);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交category为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("totalcount")).isEqualTo(0);
	}
	
	/**
	 * 提交category为空格
	 */
	@Test
	public void postSearchGetComplaintsListTestCategoryIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", " ");
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交category为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交category为空
	 */
	@Test
	public void postSearchGetComplaintsListTestCategoryIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", "");
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交category为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交category为null
	 */
	@Test
	public void postSearchGetComplaintsListTestCategoryIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", null);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交category为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 不提交category参数
	 */
	@Test
	public void postSearchGetComplaintsListTestCategoryNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("不提交category参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交reason为特殊字符
	 */
	@Test
	public void postSearchGetComplaintsListTestReasonIsIllegalCharacter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "!@#$%^&*");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reason为特殊字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交reason为int型
	 */
	@Test
	public void postSearchGetComplaintsListTestReasonIsInt() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", 123);
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reason为int型" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交reason为超长字符
	 */
	@Test
	public void postSearchGetComplaintsListTestReasonIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "是绝对不被封为瑞文月份护额发货的精神病jbzxnbclhrfsafl啊手机卡可是当时觉得还是觉得sjdhasjhsjdhajcbxznmcbu事件发生的数据库的数据库都很费劲大家的看法和");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", userId);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reason为int型" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交reason为空格
	 */
	@Test
	public void postSearchGetComplaintsListTestReasonIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", " ");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", userId);
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
	@Test
	public void postSearchGetComplaintsListTestReasonIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", userId);
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
	@Test
	public void postSearchGetComplaintsListTestReasonIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", null);
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", userId);
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
	@Test
	public void postSearchGetComplaintsListTestReasonNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", userId);
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
	@Test
	public void postSearchGetComplaintsListTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", 11);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为错误的" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("totalcount")).isEqualTo(0);
	}
	
	/**
	 * 提交userId为未登录的
	 */
	@Test
	public void postSearchGetComplaintsListTestUserIdIsNotLogin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", 10000006);
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
	@Test
	public void postSearchGetComplaintsListTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("totalcount")).isEqualTo(0);
	}
	
	/**
	 * 提交userId为负数
	 */
	@Test
	public void postSearchGetComplaintsListTestUserIdIsNegative() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数异常！");
	}
	
	/**
	 * 提交userId为小数
	 */
	@Test
	public void postSearchGetComplaintsListTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", 1.2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("totalcount")).isEqualTo(0);
	}
	
	/**
	 * 提交userId为正确的string型
	 */
	@Test
	public void postSearchGetComplaintsListTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", "ddd");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为正确的string型" + post);

		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交userId为非法字符
	 */
	@Test
	public void postSearchGetComplaintsListTestUserIdIsIllegalCharacter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", "!@#$%^&*");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交userId为超长字符
	 */
	@Test
	public void postSearchGetComplaintsListTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", "313212333333333333333345454545454545454545454545879999999");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为超长字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交userId为空格
	 */
	@Test
	public void postSearchGetComplaintsListTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", " ");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("请求参数不能为空！");
	}
	
	/**
	 * 提交userId为空
	 */
	@Test
	public void postSearchGetComplaintsListTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", "");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("请求参数不能为空！");
	}
	
	/**
	 * 提交userId为null
	 */
	@Test
	public void postSearchGetComplaintsListTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", null);
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("请求参数不能为空！");
	}
	
	/**
	 * 不提交userId参数
	 */
	@Test
	public void postSearchGetComplaintsListTestUserIdNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
	
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("不提交userId参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("请求参数不能为空！");
	}
	
	/**
	 * 提交beginCreateDate为错误的时间格式
	 */
	@Test
	public void postSearchGetComplaintsListTestbeginCreateDateIsErrorFormat() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017/06/12");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交beginCreateDate为错误的时间格式" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("totalcount")).isEqualTo(0);
	}
	
	/**
	 * 提交beginCreateDate为时间戳
	 */
	@Test
	public void postSearchGetComplaintsListTestbeginCreateDateIsTimestamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "1529049251");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交beginCreateDate为时间戳" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("totalcount")).isEqualTo(0);
	}
	
	/**
	 * 提交beginCreateDate为非法字符
	 */
	@Test
	public void postSearchGetComplaintsListTestbeginCreateDateIsIllegalCharacter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "!@#%$%^&");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交beginCreateDate为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("totalcount")).isEqualTo(0);
	}
	
	/**
	 * 提交beginCreateDate为超长字符
	 */
	@Test
	public void postSearchGetComplaintsListTestbeginCreateDateIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "654513216574685354563455315142541532415454568768");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交beginCreateDate为超长字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("totalcount")).isEqualTo(0);
	}
	
	/**
	 * 提交beginCreateDate为int型
	 */
	@Test
	public void postSearchGetComplaintsListTestbeginCreateDateIsInt() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", 1529049251);
		request.put("endCreateDate", "2019-06-12");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交beginCreateDate为int型" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("totalcount")).isEqualTo(0);
	}
	
	/**
	 * 提交beginCreateDate为空格
	 */
	@Test
	public void postSearchGetComplaintsListTestbeginCreateDateIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", " ");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交beginCreateDate为int型" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交beginCreateDate为空
	 */
	@Test
	public void postSearchGetComplaintsListTestbeginCreateDateIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("userId",userId );
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交beginCreateDate为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交beginCreateDate为null
	 */
	@Test
	public void postSearchGetComplaintsListTestbeginCreateDateIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", null);
		request.put("endCreateDate", "2019-06-12");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交beginCreateDate为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 不提交beginCreateDate
	 */
	@Test
	public void postSearchGetComplaintsListTestbeginCreateDateNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("userId", userId);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交beginCreateDate为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交endCreateDate为错误的时间格式
	 */
	@Test
	public void postSearchGetComplaintsListTestendCreateDateIsErrorFormat() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2017/06/12");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交endCreateDate为错误的时间格式" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("totalcount")).isEqualTo(0);
	}
	
	/**
	 * 提交endCreateDate为时间戳
	 */
	@Test
	public void postSearchGetComplaintsListTestendCreateDateIsTimestamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "1529049251");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交endCreateDate为时间戳" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("totalcount")).isEqualTo(0);
	}
	
	/**
	 * 提交endCreateDate为非法字符
	 */
	@Test
	public void postSearchGetComplaintsListTestendCreateDateIsIllegalCharacter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "!@#$%^&*");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交endCreateDate为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("totalcount")).isEqualTo(0);
	}
	
	/**
	 * 提交endCreateDate为超长字符
	 */
	@Test
	public void postSearchGetComplaintsListTestendCreateDateIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2132132465787777777777746546546546546546546546521221111165644666666666666");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交endCreateDate为超长字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("totalcount")).isEqualTo(0);
	}
	
	/**
	 * 提交endCreateDate为空格
	 */
	@Test
	public void postSearchGetComplaintsListTestendCreateDateIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", " ");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交endCreateDate为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交endCreateDate为空
	 */
	@Test
	public void postSearchGetComplaintsListTestendCreateDateIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交endCreateDate为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交endCreateDate为null
	 */
	@Test
	public void postSearchGetComplaintsListTestendCreateDateIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", null);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交endCreateDate为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 不提交endCreateDate
	 */
	@Test
	public void postSearchGetComplaintsListTestendCreateDateNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("不提交endCreateDate" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交pageSize为10000
	 */
	@Test
	public void postSearchGetComplaintsListTestPageSizeIs10000() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageSize", 10000);
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageSize为10000" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交pageSize为string型
	 */
	@Test
	public void postSearchGetComplaintsListTestPageSizeIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageSize", "gg");
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageSize为string型" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	
	/**
	 * 提交pageSize为负数
	 */
	@Test
	public void postSearchGetComplaintsListTestPageSizeIsNegative() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageSize", -1);
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageSize为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("complainList").toString()).isEqualTo("[]");
	}
		
	/**
	 * 提交pageSize为小数
	 */
	@Test
	public void postSearchGetComplaintsListTestPageSizeIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageSize", 1.3);
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageSize为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交pageSize为0
	 */
	@Test
	public void postSearchGetComplaintsListTestPageSizeIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageSize", 0);
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageSize为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("totalcount")).isEqualTo(0);
	}
	
	/**
	 * 提交pageSize为非法字符串
	 */
	@Test
	public void postSearchGetComplaintsListTestPageSizeIsIllegalCharacter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageSize", "!@#$%^&*");
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageSize为非法字符串" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	
	/**
	 * 提交pageSize为超长
	 */
	@Test
	public void postSearchGetComplaintsListTestPageSizeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageSize", "346437648374879387489738974837483784837483646383473879473");
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageSize为超长" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	
	/**
	 * 提交pageSize为空
	 */
	@Test
	public void postSearchGetComplaintsListTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageSize", "");
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageSize为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("totalcount")).isEqualTo(0);
	}
	
	/**
	 * 提交pageSize为空格
	 */
	@Test
	public void postSearchGetComplaintsListTestPageSizeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageSize", " ");
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageSize为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("totalcount")).isEqualTo(0);
	}
	
	/**
	 * 提交pageSize为null
	 */
	@Test
	public void postSearchGetComplaintsListTestPageSizeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageSize", null);
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageSize为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("totalcount")).isEqualTo(0);
	}
	
	/**
	 * 不提交pageSize
	 */
	@Test
	public void postSearchGetComplaintsListTestPageSizeNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageNow", 1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("不提交pageSize" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("totalcount")).isEqualTo(0);
	}
	
	/**
	 * 提交pageNow为10000
	 */
	@Test
	public void postSearchGetComplaintsListTestPageNowIs10000() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageNow", 10000);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageNow为10000" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("complainList").toString()).isEqualTo("[]");
	}
	
	/**
	 * 提交pageNow为string型
	 */
	@Test
	public void postSearchGetComplaintsListTestPageNowIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageNow", "dd");
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageNow为string型" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	
	/**
	 * 提交pageNow为小数
	 */
	@Test
	public void postSearchGetComplaintsListTestPageNowIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageNow", 9.2);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageNow为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("complainList").toString()).isEqualTo("[]");
	}
	
	/**
	 * 提交pageNow为负数
	 */
	@Test
	public void postSearchGetComplaintsListTestPageNowIsNegative() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageNow", -1);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageNow为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("complainList").toString()).isEqualTo("[]");
	}
	
	/**
	 * 提交pageNow为0
	 */
	@Test
	public void postSearchGetComplaintsListTestPageNowIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageNow", 0);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageNow为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("totalcount")).isEqualTo(0);
	}
	
	/**
	 * 提交pageNow为特殊字符
	 */
	@Test
	public void postSearchGetComplaintsListTestPageNowIsIllegalCharacter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageNow", "!@#$%^&*");
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageNow为特殊字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	
	/**
	 * 提交pageNow为超长字符
	 */
	@Test
	public void postSearchGetComplaintsListTestPageNowIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageNow", 999999999999999999L);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageNow为特殊字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	
	/**
	 * 提交pageNow为空格
	 */
	@Test
	public void postSearchGetComplaintsListTestPageNowIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageNow", " ");
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageNow为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("totalcount")).isEqualTo(0);
	}
	


	/**
	 * 提交pageNow为null
	 */
	@Test
	public void postSearchGetComplaintsListTestPageNowIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("pageNow", null);
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交pageNow为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("totalcount")).isEqualTo(0);
	}
	
	/**
	 * 不提交pageNow
	 */
	@Test
	public void postSearchGetComplaintsListTestPageNowNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("category", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("beginCreateDate", "2017-06-12");
		request.put("endCreateDate", "2019-06-12");
		request.put("userId", userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("不提交pageNow" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("totalcount")).isEqualTo(0);
	}
}