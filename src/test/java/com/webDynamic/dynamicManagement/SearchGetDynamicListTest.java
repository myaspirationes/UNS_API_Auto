package com.webDynamic.dynamicManagement;

import com.appDynamic.PublishDynamicsTest;
import com.example.HttpUtil;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchGetDynamicListTest extends HttpUtil {
	// 搜索获取动态列表接口
	String url = "/uu-admin/dynamicManage/dynamicList";
	
	String dataType = "perCenter81";
	
	BackUserLoginTest login = new BackUserLoginTest();
	String userId=login.userId;
	@BeforeMethod
	public void  beforeMethod() throws Exception {
		new PublishDynamicsTest().postPublishDynamicsTestCorrectParameter();
	}
	
			
	
	/**
	 * 提交正确参数
	 */
 	@Test
	public void postSearchGetDynamicListTestTypeCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("UserId", 12495396);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-07-20");
		request.put("status", -1);
		request.put("pageSize", 10);
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
	public void postSearchGetDynamicListTestUserIdIsNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 10000001);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 用户ID为错误用户
	 */
//	@Test
	public void postSearchGetDynamicListTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1111);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为非法字符
	 */
//	@Test
	public void postSearchGetDynamicListTestUserIdIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1111);
		request.put("nickName", "<@$%#$%$&^>");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为小数
	 */
//	@Test
	public void postSearchGetDynamicListTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 11.11);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为负数
	 */
//	@Test
	public void postSearchGetDynamicListTestUserIdIsNegativeNumberr() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -110);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空格
	 */
//	@Test
	public void postSearchGetDynamicListTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空
	 */
//	@Test
	public void postSearchGetDynamicListTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为null
	 */
//	@Test
	public void postSearchGetDynamicListTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为超长
	 */
//	@Test
	public void postSearchGetDynamicListTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 999999999999999999L);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为0
	 */
//	@Test
	public void postSearchGetDynamicListTestUserIdIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID不传该参数
	 */
//	@Test
	public void postSearchGetDynamicListTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 昵称为超长
	 */
//	@Test
	public void postSearchGetDynamicListTestNickNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试的感觉看见了实力肯定就过了多久能否八年年初没那么JFK九零");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 昵称含有非法字符
	 */
//	@Test
	public void postSearchGetDynamicListTestNickNameIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "<@$%^^%&>");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称含有非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 昵称为空
	 */
//	@Test
	public void postSearchGetDynamicListTestNickNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 昵称为空格
	 */
//	@Test
	public void postSearchGetDynamicListTestNickNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", " ");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 昵称为null
	 */
//	@Test
	public void postSearchGetDynamicListTestNickNameIsnull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", null);
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 昵称不传该参数
	 */
//	@Test
	public void postSearchGetDynamicListTestNickNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 关键词keyWord为超长
	 */
//	@Test
	public void postSearchGetDynamicListTestKeyWordIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试犯得上发射点发生广泛大锅饭大锅饭梵蒂冈地方官广东各个地方广泛大锅饭大锅饭大概");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键词keyWord为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 关键词keyWord为非法字符
	 */
//	@Test
	public void postSearchGetDynamicListTestKeyWordIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "<#$%&*&*(>");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键词keyWord为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 关键词keyWord为空
	 */
//	@Test
	public void postSearchGetDynamicListTestKeyWordIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键词keyWord为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 关键词keyWord为空格
	 */
//	@Test
	public void postSearchGetDynamicListTestKeyWordIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", " ");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键词keyWord为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 关键词keyWord不传该参数
	 */
//	@Test
	public void postSearchGetDynamicListTestKeyWordNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键词keyWord不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建开始时间为超长
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeStartIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", 666666666666666666L);
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建开始时间大于结束时间
	 */
//	@Test
	public void postSearchGetDynamicListTestKeyWordIsMoreCreatTimeEnd() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-07-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间大于结束时间" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建开始时间为时间戳
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeStartIsTimeStamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "1525305600000");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为时间戳" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建开始时间为空
	 */
//	@Test
	public void postSearchGetDynamicListTestcreatTimeStartIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建开始时间为空格
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeStartIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", " ");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建开始时间为null
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeStartIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", null);
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建开始时间为负数
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeStartIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "-230");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建开始时间为小数
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeStartIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", 1.2);
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建开始时间为年月日
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeStartIsYMD() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建开始时间为时分秒
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeStartIsHMS() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "12:11:14");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为时分秒" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建开始时间为闰年2月29日
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeStartIsLeapYear2Mon29() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-02-29");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为闰年2月29日" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建开始时间为非闰年2月29日
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeStartIsNotLeapYear2Mon29() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2017-02-29");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为非闰年2月29日" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建开始时间为数字去掉中间格式
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeStartIsNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "20180503");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为数字去掉中间格式" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建开始时间为错误格式
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeStartIsErrorFormat() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018/05/03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为错误格式" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建开始时间不传该参数
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeStartNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建开始时间传年月日最大时间
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeStartIsYMDMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "9999-12-31");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间传年月日最大时间" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建开始时间传年月日最小时间
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeStartIsYMDMin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "00001-01-01");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间传年月日最小时间" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建开始时间传时分秒最大时间
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeStartIsHMSMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "23:59:59");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间传时分秒最大时间" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建开始时间传时分秒最小时间
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeStartIsHMSMin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "00:00:00");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间传时分秒最小时间" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建开始时间传年月日时分秒
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeStartIsYMDHMS() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03 15:26:14");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间传年月日时分秒" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建结束时间为超长
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeEndIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", 999999999999999999L);
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建结束时间为时间戳
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeEndIsTimeStamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "1529452800000");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为时间戳" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建结束时间为空
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeEndIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建结束时间为空格
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeEndIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", " ");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建结束时间为null
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeEndIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", null);
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建结束时间为负数
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeEndIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", -1234);
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建结束时间为小数
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeEndIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", 12.34);
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建结束时间为年月日
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeEndIsYMD() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为年月日" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建结束时间为时分秒
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeEndIsHMS() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "15:12:56");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为时分秒" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建结束时间为闰年2月29日
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeEndIsLeapYear2Mon29() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-02-29");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为闰年2月29日" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建结束时间为非闰年2月29日
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeEndIsNotLeapYear2Mon29() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-02-29");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为非闰年2月29日" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建结束时间为中间格式错误
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeEndIsErrorFormat() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018/06/20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为中间格式错误" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建结束时间为去掉中间格式
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeEndIsNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "20180220");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为去掉中间格式" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建结束时间不传该参数
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeEndNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建结束时间为年月日最大时间
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeEndIsYMDMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "9999-12-31");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为年月日最大时间" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建结束时间为年月日最小时间
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeEndIsYMDMin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "0001-01-01");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为年月日最小时间" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建结束时间为时分秒最大时间
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeEndIsHMSMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "23:59:59");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为时分秒最大时间" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建结束时间为时分秒最小时间
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeEndIsHMSMin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "00:00:00");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为时分秒最小时间" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 创建结束时间为年月日时分秒
	 */
//	@Test
	public void postSearchGetDynamicListTestCreatTimeEndIsYMDHMS() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20 12:22:51");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为年月日时分秒" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为0未处理
	 */
//	@Test
	public void postSearchGetDynamicListTestStatusIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为0未处理" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为1正常
	 */
//	@Test
	public void postSearchGetDynamicListTestStatusIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为1正常" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为2隐藏
	 */
//	@Test
	public void postSearchGetDynamicListTestStatusIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 2);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为2隐藏" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为-1全部
	 */
//	@Test
	public void postSearchGetDynamicListTestStatusIsall() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为-1全部" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为错误
	 */
//	@Test
	public void postSearchGetDynamicListTestStatusIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 10);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为错误" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为负数
	 */
//	@Test
	public void postSearchGetDynamicListTestStatusIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为小数
	 */
//	@Test
	public void postSearchGetDynamicListTestStatusIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 1.3);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为空
	 */
//	@Test
	public void postSearchGetDynamicListTestStatusIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", "");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为空格
	 */
//	@Test
	public void postSearchGetDynamicListTestStatusIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", " ");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为null
	 */
//	@Test
	public void postSearchGetDynamicListTestStatusIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", null);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为String
	 */
//	@Test
	public void postSearchGetDynamicListTestStatusIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", "dfggf");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为String" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为最大值
	 */
//	@Test
	public void postSearchGetDynamicListTestStatusIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 99999999);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为不传该参数
	 */
//	@Test
	public void postSearchGetDynamicListTestStatusNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录集pageSize为0
	 */
//	@Test
	public void postSearchGetDynamicListTestPageSizeIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 0);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集pageSize为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录集pageSize为超长
	 */
//	@Test
	public void postSearchGetDynamicListTestPageSizeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 999999999999999999L);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集pageSize为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录集pageSize为负数
	 */
//	@Test
	public void postSearchGetDynamicListTestPageSizeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", -2);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集pageSize为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录集pageSize为小数
	 */
//	@Test
	public void postSearchGetDynamicListTestPageSizeIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 2.3);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集pageSize为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录集pageSize为String
	 */
//	@Test
	public void postSearchGetDynamicListTestPageSizeIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", "ddd");
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集pageSize为String" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录集pageSize为空格
	 */
//	@Test
	public void postSearchGetDynamicListTestPageSizeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", " ");
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集pageSize为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录集pageSize为空
	 */
//	@Test
	public void postSearchGetDynamicListTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", "");
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集pageSize为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录集pageSize为null
	 */
//	@Test
	public void postSearchGetDynamicListTestPageSizeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", null);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集pageSize为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录集pageSize不传该参数
	 */
//	@Test
	public void postSearchGetDynamicListTestPageSizeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集pageSize不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页数pageNow为负数
	 */
//	@Test
	public void postSearchGetDynamicListTestPageNowIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", -1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数pageNow为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页数pageNow为小数
	 */
//	@Test
	public void postSearchGetDynamicListTestPageNowIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1.3);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数pageNow为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页数pageNow为String
	 */
//	@Test
	public void postSearchGetDynamicListTestPageNowIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", "dffds");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数pageNow为String" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页数pageNow为空格
	 */
//	@Test
	public void postSearchGetDynamicListTestPageNowIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数pageNow为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页数pageNow为空
	 */
//	@Test
	public void postSearchGetDynamicListTestPageNowIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数pageNow为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页数pageNow为null
	 */
//	@Test
	public void postSearchGetDynamicListTestPageNowIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数pageNow为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页数pageNow为超长
	 */
//	@Test
	public void postSearchGetDynamicListTestPageNowIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 999999999999999999L);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数pageNow为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页数pageNow不传该参数
	 */
//	@Test
	public void postSearchGetDynamicListTestPageNowNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试");
		request.put("keyWord", "测试");
		request.put("creatTimeStart", "2018-05-03");
		request.put("creatTimeEnd", "2018-06-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数pageNow不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
}