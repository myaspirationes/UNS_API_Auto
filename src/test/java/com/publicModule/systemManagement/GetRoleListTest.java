package com.publicModule.systemManagement;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class GetRoleListTest extends HttpUtil {
// 搜索获取角色列表接口
	String url = "/uu-admin/SystemManager/getRoleList";
	String userId;
	@BeforeClass
	public void beforeClass(){

		userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetRoleListTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postGetRoleListTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postGetRoleListTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "123");
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postGetRoleListTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<.#$%^>");
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postGetRoleListTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1.8);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postGetRoleListTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -1);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id格式错误！");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postGetRoleListTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id格式错误！");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postGetRoleListTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "userId");
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postGetRoleListTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postGetRoleListTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postGetRoleListTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为不传该参数
	 */
	@Test
	public void postGetRoleListTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不能为空！");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postGetRoleListTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "123123123123123123123123123123123");
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 地对地导弹为超长
	 */
	@Test
	public void postGetRoleListTestRoleNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地对地导弹为超长" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 地对地导弹为为非法字符
	 */
	@Test
	public void postGetRoleListTestRoleNameIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "<.$%^>");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地对地导弹为为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地对地导弹为空
	 */
	@Test
	public void postGetRoleListTestRoleNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地对地导弹为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地对地导弹为空格
	 */
	@Test
	public void postGetRoleListTestRoleNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", " ");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地对地导弹为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地对地导弹为null
	 */
	@Test
	public void postGetRoleListTestRoleNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", null);
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地对地导弹为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地对地导弹传该参数
	 */
	@Test
	public void postGetRoleListTestRoleNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地对地导弹传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * 创建开始时间超长
	 */
	@Test
	public void postGetRoleListTestCreatTimeStartIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "20112345675675675675675675675678-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("时间格式校验失败");
	}
	/**
	 * 创建开始时间大于结束时间
	 */
	@Test
	public void postGetRoleListTestCreatTimeStartGreaterThanCreatTimeEnd() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-06-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建开始时间为时间戳
	 */
	@Test
	public void postGetRoleListTestCreatTimeStartIsTimeStamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "1528248480000");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为时间戳" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("时间格式校验失败");
	}
	/**
	 * 创建开始时间为空
	 */
	@Test
	public void postGetRoleListTestCreatTimeStartIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("时间格式校验失败");
	}
	/**
	 * 创建开始时间为空格
	 */
	@Test
	public void postGetRoleListTestCreatTimeStartIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", " ");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("时间格式校验失败");
	}
	/**
	 * 创建开始时间为null
	 */
	@Test
	public void postGetRoleListTestCreatTimeStartIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", null);
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建开始时间不传该参数
	 */
	@Test
	public void postGetRoleListTestCreatTimeStartNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建开始时间为年月日
	 */
	@Test
	public void postGetRoleListTestCreatTimeStartIsYMD() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为年月日" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建开始时间为时分秒
	 */
	@Test
	public void postGetRoleListTestCreatTimeStartIsHMS() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "13:13:13");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为时分秒" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("时间格式校验失败");
	}
	/**
	 * 创建开始时间为0
	 */
	@Test
	public void postGetRoleListTestCreatTimeStartIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", 0);
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("时间格式校验失败");
	}
	/**
	 * 创建开始时间为闰年2月
	 */
	@Test
	public void postGetRoleListTestCreatTimeStartIsLeapYear() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2016-02-29");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为闰年2月" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建开始时间为非闰年2月
	 */
	@Test
	public void postGetRoleListTestCreatTimeStartIsNonLeapYear() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-02-29");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为非闰年2月" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("时间格式校验失败");
	}
	/**
	 * 创建结束时间超长
	 */
	@Test
	public void postGetRoleListTestCreatTimeEndIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeEnd", "20112345675675675675675675675678-05-03");
		request.put("creatTimeStart","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("时间格式校验失败");
	}

	/**
	 * 创建结束时间为时间戳
	 */
	@Test
	public void postGetRoleListTestCreatTimeEndIsTimeStamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeEnd", "1528248480000");
		request.put("creatTimeStart","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("时间格式校验失败");
	}
	/**
	 * 创建结束时间为空
	 */
	@Test
	public void postGetRoleListTestCreatTimeEndIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeEnd", "");
		request.put("creatTimeStart","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("时间格式校验失败");
	}
	/**
	 * 创建结束时间为空格
	 */
	@Test
	public void postGetRoleListTestCreatTimeEndIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeEnd", " ");
		request.put("creatTimeStart","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("时间格式校验失败");
	}
	/**
	 * 创建结束时间为null
	 */
	@Test
	public void postGetRoleListTestCreatTimeEndIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeEnd", null);
		request.put("creatTimeStart","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建结束时间不传该参数
	 */
	@Test
	public void postGetRoleListTestCreatTimeEndNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建结束时间为年月日
	 */
	@Test
	public void postGetRoleListTestCreatTimeEndIsYMD() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeEnd", "2018-05-03");
		request.put("creatTimeStart","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为年月日" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建结束时间为时分秒
	 */
	@Test
	public void postGetRoleListTestCreatTimeEndIsHMS() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeEnd", "13:13:13");
		request.put("creatTimeStart","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为时分秒" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("时间格式校验失败");
	}
	/**
	 * 创建结束时间为0
	 */
	@Test
	public void postGetRoleListTestCreatTimeEndIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeEnd", 0);
		request.put("creatTimeStart","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("时间格式校验失败");
	}
	/**
	 * 创建结束时间为闰年2月
	 */
	@Test
	public void postGetRoleListTestCreatTimeEndIsLeapYear() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeEnd", "2016-02-29");
		request.put("creatTimeStart","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为闰年2月" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建结束时间为非闰年2月
	 */
	@Test
	public void postGetRoleListTestCreatTimeEndIsNonLeapYear() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeEnd", "2018-02-29");
		request.put("creatTimeStart","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为非闰年2月" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("时间格式校验失败");
	}
	/**
	 * 角色状态为超长
	 */
	@Test
	public void postGetRoleListTesttatusIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 111111111111111L);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为超长" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 角色状态为非法字符
	 */
	@Test
	public void postGetRoleListTesttatusIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", "<.@$$>");
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 角色状态为错误状态
	 */
	@Test
	public void postGetRoleListTesttatusIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 98787878);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为错误状态" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色状态为空
	 */
	@Test
	public void postGetRoleListTesttatusIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", "");
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("状态不能为空！");
	}
	/**
	 * 角色状态为空格
	 */
	@Test
	public void postGetRoleListTesttatusIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", " ");
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("状态不能为空！");
	}
	/**
	 * 角色状态为String
	 */
	@Test
	public void postGetRoleListTesttatusIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", "status");
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 角色状态为null
	 */
	@Test
	public void postGetRoleListTesttatusIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", null);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("状态不能为空！");
	}
	/**
	 * 角色状态不传该参数
	 */
	@Test
	public void postGetRoleListTesttatusNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("状态不能为空！");
	}
	/**
	 * 角色状态为小数
	 */
	@Test
	public void postGetRoleListTesttatusIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1.5);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色状态为负数
	 */
	@Test
	public void postGetRoleListTesttatusIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色状态为0
	 */
	@Test
	public void postGetRoleListTesttatusIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 0);
		request.put("pageSize", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色状态为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录集为负数
	 */
	@Test
	public void postGetRoleListTestPageSizeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", -1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("每页大小格式错误！");
	}
	/**
	 * 每页显示记录集为小数
	 */
	@Test
	public void postGetRoleListTestPageSizeIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1.7);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录集为String
	 */
	@Test
	public void postGetRoleListTestPageSizeIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", "pageSize");
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 每页显示记录集为空格
	 */
	@Test
	public void postGetRoleListTestPageSizeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", " ");
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("每页获取的条数不能为空！");
	}
	/**
	 * 每页显示记录集为空
	 */
	@Test
	public void postGetRoleListTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", "");
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集为" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("每页获取的条数不能为空！");
	}
	/**
	 * 每页显示记录集为null
	 */
	@Test
	public void postGetRoleListTestPageSizeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", null);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集为" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("每页获取的条数不能为空！");
	}
	/**
	 * 每页显示记录集为超长
	 */
	@Test
	public void postGetRoleListTestPageSizeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 1111111111111L);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集为" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 每页显示记录集不传该参数
	 */
	@Test
	public void postGetRoleListTestPageSizeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("每页获取的条数不能为空！");
	}
	/**
	 * 每页显示记录集为0
	 */
	@Test
	public void postGetRoleListTestPageSizeIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageSize", 0);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("每页大小格式错误！");
	}
	/**
	 * 当前页数为负数
	 */
	@Test
	public void postGetRoleListTestPageNowIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageNow", -1);
		request.put("pageSize", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("当前页格式错误！");
	}
	/**
	 * 当前页数为小数
	 */
	@Test
	public void postGetRoleListTestPageNowIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageNow", 1.7);
		request.put("pageSize", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页数为String
	 */
	@Test
	public void postGetRoleListTestPageNowIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageNow", "pageSize");
		request.put("pageSize", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 当前页数为空格
	 */
	@Test
	public void postGetRoleListTestPageNowIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageNow", " ");
		request.put("pageSize", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("当前请求第几页不能为空！");
	}
	/**
	 * 当前页数为空
	 */
	@Test
	public void postGetRoleListTestPageNowIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageNow", "");
		request.put("pageSize", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("当前请求第几页不能为空！");
	}
	/**
	 * 当前页数为null
	 */
	@Test
	public void postGetRoleListTestPageNowIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageNow", null);
		request.put("pageSize", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("当前请求第几页不能为空！");
	}
	/**
	 * 当前页数为超长
	 */
	@Test
	public void postGetRoleListTestPageNowIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageNow", 1111111111111L);
		request.put("pageSize", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 当前页数不传该参数
	 */
	@Test
	public void postGetRoleListTestPageNowNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("每页获取的条数不能为空！");
	}
	/**
	 * 当前页数为0
	 */
	@Test
	public void postGetRoleListTestPageNowIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("roleName", "地对地导弹");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd","2018-07-29");
		request.put("status", 1);
		request.put("pageNow", 0);
		request.put("pageSize", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为0" + post);

		assertThat(post.get("status")).isEqualTo(0-1);
		assertThat(post.get("msg")).isEqualTo("当前页格式错误！");
	}

}