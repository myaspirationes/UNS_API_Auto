package com.webDynamic.dynamicManagement;

import com.appDynamic.PublishDynamicsTest;
import com.example.HttpUtil;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
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
	String selDynamic = "SELECT * FROM T_DYNAMIC WHERE DESCRIPTION = '自动化测试' AND USER_ID = 12495396";
	String delDynamic = "DELETE FROM T_DYNAMIC WHERE DESCRIPTION = '自动化测试'";
	String userId=login.userId;
	@BeforeMethod
	public void  beforeMethod() throws Exception {
		new PublishDynamicsTest().postPublishDynamicsTestCorrectParameter();
	}
	@AfterMethod
	public void afterMethod()
	{
		MetaOper.delete(delDynamic, dataType);
	}
	@AfterClass
	public void afterClass(){
		MetaOper.delete(delDynamic, dataType);
	}
			
	
	/**
	 * 提交正确参数
	 */
 	@Test
	public void postSearchGetDynamicListTestTypeCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
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
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postSearchGetDynamicListTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1111);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postSearchGetDynamicListTestUserIdIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<@$%#$%$&^>");
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postSearchGetDynamicListTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 11.11);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postSearchGetDynamicListTestUserIdIsNegativeNumberr() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -110);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("用户id值不正确!");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postSearchGetDynamicListTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("用户id值不正确!");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postSearchGetDynamicListTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("用户id值不正确!");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postSearchGetDynamicListTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("用户id值不正确!");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postSearchGetDynamicListTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 999999999999999999L);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("用户id值不正确!");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postSearchGetDynamicListTestUserIdIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("用户id值不正确!");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postSearchGetDynamicListTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("用户id值不正确!");
	}
	/**
	 * 昵称为超长
	 */
	@Test
	public void postSearchGetDynamicListTestNickNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "自动化测试的感觉看见了实力肯定就过了多久能否八年年初没那么JFK九零");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 昵称含有非法字符
	 */
	@Test
	public void postSearchGetDynamicListTestNickNameIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "<@$%^^%&>");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称含有非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 昵称为空
	 */
	@Test
	public void postSearchGetDynamicListTestNickNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
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
	@Test
	public void postSearchGetDynamicListTestNickNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", " ");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
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
	@Test
	public void postSearchGetDynamicListTestNickNameIsnull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", null);
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
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
	@Test
	public void postSearchGetDynamicListTestNickNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
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
	@Test
	public void postSearchGetDynamicListTestKeyWordIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试犯得上发射点发生发货的事件发生纠纷首付款飞机螺丝钉解放攻击速度快来解放拉萨解放了控江路事件附近的老师JFK历史交锋两款手机及辅导老师JFK历史交锋广泛大锅饭光伏发电计划辐射防护发货的接口返回的机会是靠回复恢复的空间和发挥监督和考试辅导空间大锅饭梵蒂冈地方官广东dgfg从对方是谁发的烦烦烦烦烦烦股份股份烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦股份大股东各个地方广泛大锅饭发广告广告顶顶顶顶顶顶顶顶顶顶顶顶顶顶幅度高达顶顶顶顶顶的发士大夫发射点的地方是否大锅饭大概.测试犯得上发射点发生发货的事件发生纠纷首付款飞机螺丝钉解放攻击速度快来解放拉萨解放了控江路事件附近的老师JFK历史交锋两款手机及辅导老师JFK历史交锋广泛大锅饭光伏发电计划辐射防护发货的接口返回的机会是靠回复恢复的空间和发挥监督和考试辅导空间大锅饭梵蒂冈地方官广东dgfg从对方是谁发的烦烦烦烦烦烦股份股份烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦股份大股东各个地方广泛大锅饭发广告广告顶顶顶顶顶顶顶顶顶顶顶顶顶顶幅度高达顶顶顶顶顶的发士大夫发射点的地方是否大锅饭大概。测试犯得上发射点发生发货的事件发生纠纷首付款飞机螺丝钉解放攻击速度快来解放拉萨解放了控江路事件附近的老师JFK历史交锋两款手机及辅导老师JFK历史交锋广泛大锅饭光伏发电计划辐射防护发货的接口返回的机会是靠回复恢复的空间和发挥监督和考试辅导空间大锅饭梵蒂冈地方官广东dgfg从对方是谁发的烦烦烦烦烦烦股份股份烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦股份大股东各个地方广泛大锅饭发广告广告顶顶顶顶顶顶顶顶顶顶顶顶顶顶幅度高达顶顶顶顶顶的发士大夫发射点的地方是否大锅饭大概。测试犯得上发射点发生发货的事件发生纠纷首付款飞机螺丝钉解放攻击速度快来解放拉萨解放了控江路事件附近的老师JFK历史交锋两款手机及辅导老师JFK历史交锋广泛大锅饭光伏发电计划辐射防护发货的接口返回的机会是靠回复恢复的空间和发挥监督和考试辅导空间大锅饭梵蒂冈地方官广东dgfg从对方是谁发的烦烦烦烦烦烦股份股份烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦股份大股东各个地方广泛大锅饭发广告广告顶顶顶顶顶顶顶顶顶顶顶顶顶顶幅度高达顶顶顶顶顶的发士大夫发射点的地方是否大锅饭大概。测试犯得上发射点发生发货的事件发生纠纷首付款飞机螺丝钉解放攻击速度快来解放拉萨解放了控江路事件附近的老师JFK历史交锋两款手机及辅导老师JFK历史交锋广泛大锅饭光伏发电计划辐射防护发货的接口返回的机会是靠回复恢复的空间和发挥监督和考试辅导空间大锅饭梵蒂冈地方官广东dgfg从对方是谁发的烦烦烦烦烦烦股份股份烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦股份大股东各个地方广泛大锅饭发广告广告顶顶顶顶顶顶顶顶顶顶顶顶顶顶幅度高达顶顶顶顶顶的发士大夫发射点的地方是否大锅饭大概。测试犯得上发射点发生发货的事件发生纠纷首付款飞机螺丝钉解放攻击速度快来解放拉萨解放了控江路事件附近的老师JFK历史交锋两款手机及辅导老师JFK历史交锋广泛大锅饭光伏发电计划辐射防护发货的接口返回的机会是靠回复恢复的空间和发挥监督和考试辅导空间大锅饭梵蒂冈地方官广东dgfg从对方是谁发的烦烦烦烦烦烦股份股份烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦股份大股东各个地方广泛大锅饭发广告广告顶顶顶顶顶顶顶顶顶顶顶顶顶顶幅度高达顶顶顶顶顶的发士大夫发射点的地方是否大锅饭大概。测试犯得上发射点发生发货的事件发生纠纷首付款飞机螺丝钉解放攻击速度快来解放拉萨解放了控江路事件附近的老师JFK历史交锋两款手机及辅导老师JFK历史交锋广泛大锅饭光伏发电计划辐射防护发货的接口返回的机会是靠回复恢复的空间和发挥监督和考试辅导空间大锅饭梵蒂冈地方官广东dgfg从对方是谁发的烦烦烦烦烦烦股份股份烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦股份大股东各个地方广泛大锅饭发广告广告顶顶顶顶顶顶顶顶顶顶顶顶顶顶幅度高达顶顶顶顶顶的发士大夫发射点的地方是否大锅饭大概。测试犯得上发射点发生发货的事件发生纠纷首付款飞机螺丝钉解放攻击速度快来解放拉萨解放了控江路事件附近的老师JFK历史交锋两款手机及辅导老师JFK历史交锋广泛大锅饭光伏发电计划辐射防护发货的接口返回的机会是靠回复恢复的空间和发挥监督和考试辅导空间大锅饭梵蒂冈地方官广东dgfg从对方是谁发的烦烦烦烦烦烦股份股份烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦股份大股东各个地方广泛大锅饭发广告广告顶顶顶顶顶顶顶顶顶顶顶顶顶顶幅度高达顶顶顶顶顶的发士大夫发射点的地方是否大锅饭大概");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键词keyWord为超长" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 关键词keyWord为非法字符
	 */
	@Test
	public void postSearchGetDynamicListTestKeyWordIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "<#$%&*&*(>");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键词keyWord为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 关键词keyWord为空
	 */
	@Test
	public void postSearchGetDynamicListTestKeyWordIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
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
	@Test
	public void postSearchGetDynamicListTestKeyWordIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", " ");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
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
	@Test
	public void postSearchGetDynamicListTestKeyWordNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
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
	@Test
	public void postSearchGetDynamicListTestOperateStartTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", 666666666666666666L);
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为超长" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
	}
	/**
	 * 创建开始时间大于结束时间
	 */
	@Test
	public void postSearchGetDynamicListTestOperateStartTimeIsMoreoperateEndTime() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-08-03");
		request.put("operateEndTime", "2018-07-29");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间大于结束时间" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 创建开始时间为时间戳
	 */
	@Test
	public void postSearchGetDynamicListTestOperateStartTimeIsTimeStamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "1525305600000");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为时间戳" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
	}
	/**
	 * 创建开始时间为空
	 */
	@Test
	public void postSearchGetDynamicListTestOperateStartTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
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
	@Test
	public void postSearchGetDynamicListTestOperateStartTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", " ");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为空格" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
	}
	/**
	 * 创建开始时间为null
	 */
	@Test
	public void postSearchGetDynamicListTestOperateStartTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", null);
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
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
	@Test
	public void postSearchGetDynamicListTestOperateStartTimeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", -230);
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
	}
	/**
	 * 创建开始时间为小数
	 */
	@Test
	public void postSearchGetDynamicListTestOperateStartTimeIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", 1.2);
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为小数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
	}
	/**
	 * 创建开始时间为年月日
	 */
	@Test
	public void postSearchGetDynamicListTestOperateStartTimeIsYMD() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
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
	@Test
	public void postSearchGetDynamicListTestOperateStartTimeIsHMS() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "12:11:14");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为时分秒" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
	}
	/**
	 * 创建开始时间为闰年2月29日
	 */
	@Test
	public void postSearchGetDynamicListTestOperateStartTimeIsLeapYear2Mon29() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2016-02-29");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
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
	@Test
	public void postSearchGetDynamicListTestOperateStartTimeIsNotLeapYear2Mon29() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2017-02-29");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为非闰年2月29日" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
	}
	/**
	 * 创建开始时间为数字去掉中间格式
	 */
	@Test
	public void postSearchGetDynamicListTestOperateStartTimeIsNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "20180503");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为数字去掉中间格式" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
	}
	/**
	 * 创建开始时间为错误格式
	 */
	@Test
	public void postSearchGetDynamicListTestOperateStartTimeIsErrorFormat() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018/05/03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间为错误格式" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
	}
	/**
	 * 创建开始时间不传该参数
	 */
	@Test
	public void postSearchGetDynamicListTestOperateStartTimeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
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
	@Test
	public void postSearchGetDynamicListTestOperateStartTimeIsYMDMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "9999-12-31");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间传年月日最大时间" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 创建开始时间传年月日最小时间
	 */
	@Test
	public void postSearchGetDynamicListTestOperateStartTimeIsYMDMin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "00001-01-01");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
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
	@Test
	public void postSearchGetDynamicListTestOperateStartTimeIsHMSMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "23:59:59");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间传时分秒最大时间" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
	}
	/**
	 * 创建开始时间传时分秒最小时间
	 */
	@Test
	public void postSearchGetDynamicListTestOperateStartTimeIsHMSMin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "00:00:00");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建开始时间传时分秒最小时间" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
	}
	/**
	 * 创建开始时间传年月日时分秒
	 */
	@Test
	public void postSearchGetDynamicListTestOperateStartTimeIsYMDHMS() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03 15:26:14");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
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
	@Test
	public void postSearchGetDynamicListTestOperateEndTimeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", 999999999999999999L);
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为超长" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
	}
	/**
	 * 创建结束时间为时间戳
	 */
	@Test
	public void postSearchGetDynamicListTestOperateEndTimeIsTimeStamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "1529452800000");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为时间戳" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
	}
	/**
	 * 创建结束时间为空
	 */
	@Test
	public void postSearchGetDynamicListTestOperateEndTimeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "");
		request.put("status", -1);
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
	@Test
	public void postSearchGetDynamicListTestOperateEndTimeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", " ");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为空格" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
	}
	/**
	 * 创建结束时间为null
	 */
	@Test
	public void postSearchGetDynamicListTestOperateEndTimeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", null);
		request.put("status", -1);
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
	@Test
	public void postSearchGetDynamicListTestOperateEndTimeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", -1234);
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
	}
	/**
	 * 创建结束时间为小数
	 */
	@Test
	public void postSearchGetDynamicListTestOperateEndTimeIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", 12.34);
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为小数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
	}
	/**
	 * 创建结束时间为年月日
	 */
	@Test
	public void postSearchGetDynamicListTestOperateEndTimeIsYMD() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
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
	@Test
	public void postSearchGetDynamicListTestOperateEndTimeIsHMS() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "15:12:56");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为时分秒" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
	}
	/**
	 * 创建结束时间为闰年2月29日
	 */
	@Test
	public void postSearchGetDynamicListTestOperateEndTimeIsLeapYear2Mon29() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2016-05-03");
		request.put("operateEndTime", "2020-02-29");
		request.put("status", -1);
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
	@Test
	public void postSearchGetDynamicListTestOperateEndTimeIsNotLeapYear2Mon29() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2019-02-29");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为非闰年2月29日" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
	}
	/**
	 * 创建结束时间为中间格式错误
	 */
	@Test
	public void postSearchGetDynamicListTestOperateEndTimeIsErrorFormat() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018/10/20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为错误格式" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
	}
	/**
	 * 创建结束时间为去掉中间格式
	 */
	@Test
	public void postSearchGetDynamicListTestOperateEndTimeIsNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "20180220");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为去掉中间格式" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
	}
	/**
	 * 创建结束时间不传该参数
	 */
	@Test
	public void postSearchGetDynamicListTestOperateEndTimeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("status", -1);
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
	@Test
	public void postSearchGetDynamicListTestOperateEndTimeIsYMDMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "9999-12-31");
		request.put("status", -1);
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
	@Test
	public void postSearchGetDynamicListTestOperateEndTimeIsYMDMin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "0001-01-01");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为年月日最小时间" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 创建结束时间为时分秒最大时间
	 */
	@Test
	public void postSearchGetDynamicListTestOperateEndTimeIsHMSMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "23:59:59");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为时分秒最大时间" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
	}
	/**
	 * 创建结束时间为时分秒最小时间
	 */
	@Test
	public void postSearchGetDynamicListTestOperateEndTimeIsHMSMin() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "00:00:00");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("创建结束时间为时分秒最小时间" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
	}
	/**
	 * 创建结束时间为年月日时分秒
	 */
	@Test
	public void postSearchGetDynamicListTestOperateEndTimeIsYMDHMS() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-06-20 12:22:51");
		request.put("status", -1);
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
	@Test
	public void postSearchGetDynamicListTestStatusIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", 0);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为0未处理" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		//JSONObject body = (JSONObject)post.get("body");
		//assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 状态为1正常
	 */
	@Test
	public void postSearchGetDynamicListTestStatusIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", 1);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为1正常" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("total")).isEqualTo(0);
	}
	/**
	 * 状态为2隐藏
	 */
	@Test
	public void postSearchGetDynamicListTestStatusIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
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
	@Test
	public void postSearchGetDynamicListTestStatusIsAll() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
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
	@Test
	public void postSearchGetDynamicListTestStatusIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", 10);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为错误" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("状态值有误");
	}
	/**
	 * 状态为负数
	 */
	@Test
	public void postSearchGetDynamicListTestStatusIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -6);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("状态值有误");
	}
	/**
	 * 状态为小数
	 */
	@Test
	public void postSearchGetDynamicListTestStatusIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", 3.3);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为小数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("状态值有误");
	}
	/**
	 * 状态为空
	 */
	@Test
	public void postSearchGetDynamicListTestStatusIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
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
	@Test
	public void postSearchGetDynamicListTestStatusIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
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
	@Test
	public void postSearchGetDynamicListTestStatusIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
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
	@Test
	public void postSearchGetDynamicListTestStatusIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", "dfggf");
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态为最大值
	 */
	@Test
	public void postSearchGetDynamicListTestStatusIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", 99999999);
		request.put("pageSize", 10);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态为最大值" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("状态值有误");
	}
	/**
	 * 状态为不传该参数
	 */
	@Test
	public void postSearchGetDynamicListTestStatusNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
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
	@Test
	public void postSearchGetDynamicListTestPageSizeIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 0);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集pageSize为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		JSONObject body = (JSONObject)post.get("body");
		assertThat(body.get("dynamicList").toString()).isEqualTo("[]");
	}
	/**
	 * 每页显示记录集pageSize为超长
	 */
	@Test
	public void postSearchGetDynamicListTestPageSizeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 999999999999999999L);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集pageSize为超长" + post);

		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录集pageSize为负数
	 */
	@Test
	public void postSearchGetDynamicListTestPageSizeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", -2);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集pageSize为负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("pageSize及pageNow 输入值不正确!");
	}
	/**
	 * 每页显示记录集pageSize为小数
	 */
	@Test
	public void postSearchGetDynamicListTestPageSizeIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
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
	@Test
	public void postSearchGetDynamicListTestPageSizeIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", "ddd");
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集pageSize为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页显示记录集pageSize为空格
	 */
	@Test
	public void postSearchGetDynamicListTestPageSizeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", " ");
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集pageSize为空格" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("pageSize及pageNow 输入值不正确!");
	}
	/**
	 * 每页显示记录集pageSize为空
	 */
	@Test
	public void postSearchGetDynamicListTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", "");
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集pageSize为空" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("pageSize及pageNow 输入值不正确!");
	}
	/**
	 * 每页显示记录集pageSize为null
	 */
	@Test
	public void postSearchGetDynamicListTestPageSizeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", null);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集pageSize为null" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("pageSize及pageNow 输入值不正确!");
	}
	/**
	 * 每页显示记录集pageSize不传该参数
	 */
	@Test
	public void postSearchGetDynamicListTestPageSizeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageNow", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示记录集pageSize不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页数pageNow为负数
	 */
	@Test
	public void postSearchGetDynamicListTestPageNowIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", -1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数pageNow为负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("pageSize及pageNow 输入值不正确!");
	}
	/**
	 * 当前页数pageNow为小数
	 */
	@Test
	public void postSearchGetDynamicListTestPageNowIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
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
	@Test
	public void postSearchGetDynamicListTestPageNowIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", "dffds");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数pageNow为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页数pageNow为空格
	 */
	@Test
	public void postSearchGetDynamicListTestPageNowIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数pageNow为空格" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("pageSize及pageNow 输入值不正确!");
	}
	/**
	 * 当前页数pageNow为空
	 */
	@Test
	public void postSearchGetDynamicListTestPageNowIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数pageNow为空" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("pageSize及pageNow 输入值不正确!");
	}
	/**
	 * 当前页数pageNow为null
	 */
	@Test
	public void postSearchGetDynamicListTestPageNowIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数pageNow为null" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("pageSize及pageNow 输入值不正确!");
	}
	/**
	 * 当前页数pageNow为超长
	 */
	@Test
	public void postSearchGetDynamicListTestPageNowIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		request.put("pageNow", 999999999999999999L);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数pageNow为超长" + post);

		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页数pageNow不传该参数
	 */
	@Test
	public void postSearchGetDynamicListTestPageNowNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("nickName", "梦想家Even");
		request.put("keyContentWord", "测试");
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", -1);
		request.put("pageSize", 10);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数pageNow不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
}