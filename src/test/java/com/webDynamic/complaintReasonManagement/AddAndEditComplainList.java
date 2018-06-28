package com.webDynamic.complaintReasonManagement;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class AddAndEditComplainList extends HttpUtil {
	// 添加/编辑投诉原因接口
	String url = "/uu-admin/complainManage/addUpdateComplainReason";
	
	String dataType = "uedb";
	String selectSql = "SELECT * FROM T_AUDIT_MSG WHERE MSG_CONTENT = '自动化测试投诉原因'";
	String deleteSql = "DELETE FROM T_AUDIT_MSG WHERE MSG_CONTENT = '自动化测试投诉原因'";
	List<Map<String,Object>> list ;
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
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
	 * 提交正确参数：type为0
	 */
	@Test
	public void postAddAndEditComplainListTestTypeIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 0);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", userId);
		request.put("reasionId", 0);
		request.put("category", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql, dataType);
		assertThat(list.get(0).get("MSG_CONTENT").toString()).isEqualTo("自动化测试投诉原因");
		assertThat(list.get(0).get("CATEGORY_ID").toString()).isEqualTo("5");
	}
	
	/**
	 * 提交正确参数：type为1
	 */
	////@Test
	public void postAddAndEditComplainListTestTypeIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 1);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", userId);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为1" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql, dataType);
		assertThat(list.get(0).get("MSG_CONTENT").toString()).isEqualTo("自动化测试投诉原因");
		assertThat(list.get(0).get("CATEGORY_ID").toString()).isEqualTo("5");
	}
	
	/**
	 * 提交正确参数：type为2
	 */
	////@Test
	public void postAddAndEditComplainListTestTypeIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 2);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", userId);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为2" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql, dataType);
		assertThat(list.get(0).get("MSG_CONTENT").toString()).isEqualTo("自动化测试投诉原因");
		assertThat(list.get(0).get("CATEGORY_ID").toString()).isEqualTo("5");
	}
	
	/**
	 * 提交正确参数：type为3
	 */
	////@Test
	public void postAddAndEditComplainListTestTypeIs3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 3);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", userId);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为3" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql, dataType);
		assertThat(list.get(0).get("MSG_CONTENT").toString()).isEqualTo("自动化测试投诉原因");
		assertThat(list.get(0).get("CATEGORY_ID").toString()).isEqualTo("5");
	}
	
	/**
	 * 提交正确参数：type为4
	 */
	////@Test
	public void postAddAndEditComplainListTestTypeIs4() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", userId);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为4" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql, dataType);
		assertThat(list.get(0).get("MSG_CONTENT").toString()).isEqualTo("自动化测试投诉原因");
		assertThat(list.get(0).get("CATEGORY_ID").toString()).isEqualTo("5");
	}
	
	/**
	 * 提交正确参数：type为5
	 */
	////@Test
	public void postAddAndEditComplainListTestTypeIs5() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 5);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", userId);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为5" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql, dataType);
		assertThat(list.get(0).get("MSG_CONTENT").toString()).isEqualTo("自动化测试投诉原因");
		assertThat(list.get(0).get("CATEGORY_ID").toString()).isEqualTo("5");
	}
	/**
	 * 提交错误的type值
	 */
	@Test
	public void postAddAndEditComplainListTestTypeIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 7);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", userId);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交错误的type值" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交type为负数
	 */
	////@Test
	public void postAddAndEditComplainListTestTypeIsNegative() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", -1);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", userId);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交type为负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("类型输入有误");
	}
	
	/**
	 * 提交type为String类型
	 */
	////@Test
	public void postAddAndEditComplainListTestTypeIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", "4");
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", userId);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交type为String类型" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交type为特殊字符
	 */
	////@Test
	public void postAddAndEditComplainListTestTypeIsIllegalCharacter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", "@#$%^");
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", userId);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交type为特殊字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交type为超长
	 */
	@Test
	public void postAddAndEditComplainListTestTypeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 555555555555555555L);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", userId);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交type为超长字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交type为小数
	 */
	////@Test
	public void postAddAndEditComplainListTestTypeIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 9.2);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", userId);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交type为小数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交type为空格
	 */
	////@Test
	public void postAddAndEditComplainListTestTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", " ");
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", userId);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交type为空格" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("类型输入有误");
	}
	
	/**
	 * 提交type为空
	 */
	////@Test
	public void postAddAndEditComplainListTestTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", "");
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", userId);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交type为空" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("类型输入有误");
	}
	
	/**
	 * 提交type为null
	 */
	////@Test
	public void postAddAndEditComplainListTestTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", null);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", userId);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交type为null" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("类型输入有误");
	}
	
	/**
	 * 不提交type参数
	 */
	////@Test
	public void postAddAndEditComplainListTestTypeNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", userId);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("不提交type参数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("类型输入有误");
	}
	
	/**
	 * 提交reason为特殊字符
	 */
	////@Test
	public void postAddAndEditComplainListTestReasonIsIllegalCharacter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "@#$%^!#");
		request.put("userId", userId);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reason为特殊字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交reason为int型
	 */
	@Test
	public void postAddAndEditComplainListTestReasonIsInt() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", 123456);
		request.put("userId", userId);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reason为int型" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql, dataType);
		assertThat(list.get(0).get("MSG_CONTENT").toString()).isEqualTo("123456");
		assertThat(list.get(0).get("CATEGORY_ID").toString()).isEqualTo("5");
	}
	
	/**
	 * 提交reason为超长字符
	 */
	@Test
	public void postAddAndEditComplainListTestReasonIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "i阿斯顿包括东非如额啊u是否啥u安徽的吉萨高地就开始啊开始重新准备出门小女子舒肤佳舒肤佳快递发货按时发送接口返回就快点发货尽快电放还是开车门现在变成你们必须尽快的示范基地空间十分好吃就行");
		request.put("userId", userId);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reason为超长字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交reason为空格
	 */
	////@Test
	public void postAddAndEditComplainListTestReasonIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", " ");
		request.put("userId", userId);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reason为空格" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("原因内容有错！");
	}
	
	/**
	 * 提交reason为空
	 */
	////@Test
	public void postAddAndEditComplainListTestReasonIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "");
		request.put("userId", userId);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reason为空" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("原因内容有错！");
	}
	
	/**
	 * 提交reason为null
	 */
	////@Test
	public void postAddAndEditComplainListTestReasonIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", null);
		request.put("userId", userId);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reason为null" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("原因内容有错！");
	}
	
	/**
	 * 不提交reason参数
	 */
	////@Test
	public void postAddAndEditComplainListTestReasonNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("userId", userId);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("不提交reason参数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("原因内容有错！");
	}
	
	/**
	 * 提交userId为错误的
	 */
	//@Test
	public void postAddAndEditComplainListTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", 001);
		request.put("reasionId", 0);request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为错误的" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交userId为未登录的
	 */
	//@Test
	public void postAddAndEditComplainListTestUserIdIsNotLogin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", 10000003);
		request.put("reasionId", 0);request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为未登录的" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交userId为0
	 */
	//@Test
	public void postAddAndEditComplainListTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", 0);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为0" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交userId为负数
	 */
	//@Test
	public void postAddAndEditComplainListTestUserIdIsNegative() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", -1);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("请求参数userId为非法数据！");
	}
	
	/**
	 * 提交userId为小数
	 */
	//@Test
	public void postAddAndEditComplainListTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", 11.2);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为小数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交userId为正确的string型
	 */
	//@Test
	public void postAddAndEditComplainListTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", "1000000");
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为正确的string型" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交userId为非法字符
	 */
	//@Test
	public void postAddAndEditComplainListTestUserIdIsIllegalCharacter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", "@#$%^");
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交userId为超长字符
	 */
	//@Test
	public void postAddAndEditComplainListTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", "1000000111111111111111100000000000003333333333");
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为超长字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交userId为空格
	 */
	//@Test
	public void postAddAndEditComplainListTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", " ");
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为空格" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("请求参数userId为非法数据！");
	}
	
	/**
	 * 提交userId为空
	 */
	//@Test
	public void postAddAndEditComplainListTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", "");
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为空" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("请求参数userId为非法数据！");
	}
	
	/**
	 * 提交userId为null
	 */
	//@Test
	public void postAddAndEditComplainListTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", null);
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为null" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("请求参数userId为非法数据！");
	}
	
	/**
	 * 不提交userId参数
	 */
	//@Test
	public void postAddAndEditComplainListTestUserIdNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("reasionId", 0);
		request.put("category", 5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("不提交userId参数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("请求参数userId为非法数据！");
	}
	
	/**
	 * 提交reasonId为1
	 */
	@Test
	public void postAddAndEditComplainListTestReasonIdIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "自动化测试");
		request.put("userId", userId);
		request.put("reasionId", 1);
		request.put("category", 3);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reasonId为1" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql, dataType);
		assertThat(list.get(0).get("MSG_CONTENT").toString()).isEqualTo("自动化测试投诉原因");
		assertThat(list.get(0).get("CATEGORY_ID").toString()).isEqualTo("1");
	}
	
	/**
	 * 提交reasonId为错误的
	 */
	//@Test
	public void postAddAndEditComplainListTestReasonIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", userId);
		request.put("reasionId", 3);
		request.put("category", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reasonId为错误的" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");//数据库未保存
	}
	
	/**
	 * 提交reasonId为正确的String型
	 */
	//@Test
	public void postAddAndEditComplainListTestReasonIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", userId);
		request.put("reasionId", "1");
		request.put("category", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reasonId为正确的String型" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交reasonId为负数
	 */
	//@Test
	public void postAddAndEditComplainListTestReasonIdIsNegative() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", userId);
		request.put("reasionId", -3);
		request.put("category", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reasonId为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("原因Id输入有误");
	}
	
	/**
	 * 提交reasonId为小数
	 */
	//@Test
	public void postAddAndEditComplainListTestReasonIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", userId);
		request.put("reasionId", 3.5);
		request.put("category", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reasonId为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");//数据库未保存
	}
	
	/**
	 * 提交reasonId为特殊字符
	 */
	//@Test
	public void postAddAndEditComplainListTestReasonIdIsIllegalCharacter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", userId);
		request.put("reasionId", "!@#$%^");
		request.put("category", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reasonId为特殊字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交reasonId为空格
	 */
	//@Test
	public void postAddAndEditComplainListTestReasonIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", userId);
		request.put("reasionId", " ");
		request.put("category", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reasonId为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("原因Id输入有误");
	}
	
	/**
	 * 提交reasonId为空
	 */
	//@Test
	public void postAddAndEditComplainListTestReasonIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", userId);
		request.put("reasionId", "");
		request.put("category", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reasonId为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("原因Id输入有误");
	}
	
	/**
	 * 提交reasonId为null
	 */
	//@Test
	public void postAddAndEditComplainListTestReasonIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", userId);
		request.put("reasionId", null);
		request.put("category", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reasonId为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("原因Id输入有误");
	}
	
	/**
	 * 不提交reasonId
	 */
	//@Test
	public void postAddAndEditComplainListTestReasonIdNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "自动化测试投诉原因");
		request.put("userId", userId);
		request.put("category", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("不提交reasonId" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("原因Id输入有误");
	}
	/**
	 * 提交category为1
	 */
	//@Test
		public void postAddAndEditComplainListTestCategoryIs1() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("type", 0);
			request.put("reason", "自动化测试投诉原因");
			request.put("userId", userId);
			request.put("reasionId", 0);
			request.put("category", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交category为1" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
			list = MetaOper.read(selectSql, dataType);
			assertThat(list.get(0).get("MSG_CONTENT").toString()).isEqualTo("自动化测试投诉原因");
			assertThat(list.get(0).get("CATEGORY_ID").toString()).isEqualTo("1");
		}
		/**
		 * 提交category为2
		 */
		//@Test
		public void postAddAndEditComplainListTestCategoryIs2() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("type", 0);
			request.put("reason", "自动化测试投诉原因");
			request.put("userId", userId);
			request.put("reasionId", 0);
			request.put("category", 2);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交category为2" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
			list = MetaOper.read(selectSql, dataType);
			assertThat(list.get(0).get("MSG_CONTENT").toString()).isEqualTo("自动化测试投诉原因");
			assertThat(list.get(0).get("CATEGORY_ID").toString()).isEqualTo("2");
		}
		/**
		 * 提交category为3
		 */
		//@Test
		public void postAddAndEditComplainListTestCategoryIs3() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("type", 0);
			request.put("reason", "自动化测试投诉原因");
			request.put("userId", userId);
			request.put("reasionId", 0);
			request.put("category", 3);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交category为3" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
			list = MetaOper.read(selectSql, dataType);
			assertThat(list.get(0).get("MSG_CONTENT").toString()).isEqualTo("自动化测试投诉原因");
			assertThat(list.get(0).get("CATEGORY_ID").toString()).isEqualTo("3");
		}
		/**
		 * 提交category为4
		 */
		//@Test
		public void postAddAndEditComplainListTestCategoryIs4() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("type", 0);
			request.put("reason", "自动化测试投诉原因");
			request.put("userId", userId);
			request.put("reasionId", 0);
			request.put("category", 4);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交category为4" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
			list = MetaOper.read(selectSql, dataType);
			assertThat(list.get(0).get("MSG_CONTENT").toString()).isEqualTo("自动化测试投诉原因");
			assertThat(list.get(0).get("CATEGORY_ID").toString()).isEqualTo("4");
		}
		/**
		 * 提交category为5
		 */
		//@Test
		public void postAddAndEditComplainListTestCategoryIs5() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("type", 0);
			request.put("reason", "自动化测试投诉原因");
			request.put("userId", userId);
			request.put("reasionId", 0);
			request.put("category", 5);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交category为5" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
			list = MetaOper.read(selectSql, dataType);
			assertThat(list.get(0).get("MSG_CONTENT").toString()).isEqualTo("自动化测试投诉原因");
			assertThat(list.get(0).get("CATEGORY_ID").toString()).isEqualTo("5");
		}
		/**
		 * 提交category为错误
		 */
		@Test
		public void postAddAndEditComplainListTestCategoryIsError() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("type", 0);
			request.put("reason", "自动化测试投诉原因");
			request.put("userId", userId);
			request.put("reasionId", 0);
			request.put("category", 10);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交category为错误" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("成功");
	}
		/**
		 * 提交category为小数
		 */
		@Test
		public void postAddAndEditComplainListTestCategoryIsDecimal() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("type", 0);
			request.put("reason", "自动化测试投诉原因");
			request.put("userId", userId);
			request.put("reasionId", 0);
			request.put("category", 6.6);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交category为小数" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("成功");
			
		}
		/**
		 * 提交category为负数
		 */
		@Test
		public void postAddAndEditComplainListTestCategoryIsNegativeNumber() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("type", 0);
			request.put("reason", "自动化测试投诉原因");
			request.put("userId", userId);
			request.put("reasionId", 0);
			request.put("category", -7);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交category为负数" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("成功");
			
		}
		/**
		 * 提交category为0
		 */
		@Test
		public void postAddAndEditComplainListTestCategoryIs0() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("type", 0);
			request.put("reason", "自动化测试投诉原因");
			request.put("userId", userId);
			request.put("reasionId", 0);
			request.put("category", 0);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交category为0" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("成功");
			
		}
		/**
		 * 提交category为String
		 */
		@Test
		public void postAddAndEditComplainListTestCategoryIsString() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("type", 0);
			request.put("reason", "自动化测试投诉原因");
			request.put("userId", userId);
			request.put("reasionId", 0);
			request.put("category", "fgfdf");
			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交category为String" + post);

			assertThat(post.get("status")).isEqualTo(400);
			//assertThat(post.get("msg")).isEqualTo("成功");
			
		}
		/**
		 * 提交category为空
		 */
		@Test
		public void postAddAndEditComplainListTestCategoryIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("type", 0);
			request.put("reason", "自动化测试投诉原因");
			request.put("userId", userId);
			request.put("reasionId", 0);
			request.put("category", "");
			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交category为空" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("成功");
			
		}
		/**
		 * 提交category为空格
		 */
		@Test
		public void postAddAndEditComplainListTestCategoryIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("type", 0);
			request.put("reason", "自动化测试投诉原因");
			request.put("userId", userId);
			request.put("reasionId", 0);
			request.put("category", " ");
			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交category为空格" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("成功");
			
		}
		/**
		 * 提交category为null
		 */
		@Test
		public void postAddAndEditComplainListTestCategoryIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("type", 0);
			request.put("reason", "自动化测试投诉原因");
			request.put("userId", userId);
			request.put("reasionId", 0);
			request.put("category", null);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交category为null" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("成功");
			
		}
		/**
		 * 提交category不提交
		 */
		@Test
		public void postAddAndEditComplainListTestCategoryIsNotCommit() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("type", 0);
			request.put("reason", "自动化测试投诉原因");
			request.put("userId", userId);
			request.put("reasionId", 0);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交category不提交" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("成功");
			
		}

}