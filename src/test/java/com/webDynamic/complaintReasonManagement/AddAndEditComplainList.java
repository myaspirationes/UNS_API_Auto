package com.webDynamic.complaintReasonManagement;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AddAndEditComplainList extends HttpUtil {
	// 添加/编辑投诉原因接口
	String url = "/uu-admin/SystemManager/getComplaintsList";
	
	String dataType = "perCenter81";
	
	BackUserLoginTest login = new BackUserLoginTest();
	String userId=login.userId;
	
	
			
	
	/**
	 * 提交正确参数：type为0
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 0);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交正确参数：type为1
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 1);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为1" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交正确参数：type为2
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 2);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为2" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交正确参数：type为3
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIs3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 3);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为3" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交正确参数：type为4
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIs4() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为4" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交正确参数：type为5
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIs5() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 5);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为5" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交正确参数：type为6
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIs6() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 6);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数：type为6" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交错误的type值
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 7);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交错误的type值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交type为负数
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIsNegative() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", -1);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交type为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交type为String类型
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", "4");
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交type为String类型" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交type为特殊字符
	 */
//	@Test
	public void postDeleteComplainReasonTestTypeIsIllegalCharacter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", "@#$%^");
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", 0);

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
		request.put("type", "55555555555555555555555555555555555");
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", 0);

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
		request.put("type", "1.2");
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", 0);

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
		request.put("UserId", userId);
		request.put("reasionId", 0);

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
		request.put("UserId", userId);
		request.put("reasionId", 0);

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
		request.put("UserId", userId);
		request.put("reasionId", 0);

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
		request.put("UserId", userId);
		request.put("reasionId", 0);

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
		request.put("reason", "@#$%^!#");
		request.put("UserId", userId);
		request.put("reasionId", 0);

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
		request.put("reason", 123456);
		request.put("UserId", userId);
		request.put("reasionId", 0);

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
		request.put("reason", "i阿斯顿包括东非如额啊u是否啥u安徽的吉萨高地就开始啊开始重新准备出门小女子舒肤佳舒肤佳快递发货按时发送接口返回就快点发货尽快电放还是开车门现在变成你们必须尽快的示范基地空间十分好吃就行");
		request.put("UserId", userId);
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reason为超长字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
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
		request.put("UserId", userId);
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reason为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交reason为空
	 */
//	@Test
	public void postDeleteComplainReasonTestReasonIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "");
		request.put("UserId", userId);
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reason为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交reason为null
	 */
//	@Test
	public void postDeleteComplainReasonTestReasonIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", null);
		request.put("UserId", userId);
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reason为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 不提交reason参数
	 */
//	@Test
	public void postDeleteComplainReasonTestReasonNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("UserId", userId);
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("不提交reason参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交userId为错误的
	 */
//	@Test
	public void postDeleteComplainReasonTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("UserId", 001);
		request.put("reasionId", 0);

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
		request.put("UserId", 10000003);
		request.put("reasionId", 0);

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
		request.put("UserId", 0);
		request.put("reasionId", 0);

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
		request.put("UserId", -1);
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交userId为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交userId为小数
	 */
//	@Test
	public void postDeleteComplainReasonTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("UserId", 11.2);
		request.put("reasionId", 0);

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
		request.put("UserId", "1000000");
		request.put("reasionId", 0);

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
		request.put("UserId", "@#$%^");
		request.put("reasionId", 0);

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
		request.put("UserId", "1000000111111111111111100000000000003333333333");
		request.put("reasionId", 0);

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
		request.put("UserId", " ");
		request.put("reasionId", 0);

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
		request.put("UserId", "");
		request.put("reasionId", 0);

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
		request.put("UserId", null);
		request.put("reasionId", 0);

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
		request.put("reasionId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("不提交userId参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交reasonId为1
	 */
//	@Test
	public void postDeleteComplainReasonTestReasonIdIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reasonId为1" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交reasonId为错误的
	 */
//	@Test
	public void postDeleteComplainReasonTestReasonIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", 3);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reasonId为错误的" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交reasonId为正确的String型
	 */
//	@Test
	public void postDeleteComplainReasonTestReasonIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", "1");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reasonId为正确的String型" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 提交reasonId为负数
	 */
//	@Test
	public void postDeleteComplainReasonTestReasonIdIsNegative() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", -1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reasonId为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交reasonId为小数
	 */
//	@Test
	public void postDeleteComplainReasonTestReasonIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", 1.5);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reasonId为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交reasonId为特殊字符
	 */
//	@Test
	public void postDeleteComplainReasonTestReasonIdIsIllegalCharacter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", "!@#$%^");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reasonId为特殊字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交reasonId为空格
	 */
//	@Test
	public void postDeleteComplainReasonTestReasonIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", " ");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reasonId为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交reasonId为空
	 */
//	@Test
	public void postDeleteComplainReasonTestReasonIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", "");

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reasonId为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 提交reasonId为null
	 */
//	@Test
	public void postDeleteComplainReasonTestReasonIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);
		request.put("reasionId", null);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交reasonId为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 不提交reasonId
	 */
//	@Test
	public void postDeleteComplainReasonTestReasonIdNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("type", 4);
		request.put("reason", "投诉原因test");
		request.put("UserId", userId);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("不提交reasonId" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
		
		
}