package com.systemManagement;

import com.example.HttpUtil;
import com.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class ModifyParameterConfigurationTest extends HttpUtil {
// 修改参数配置接口
	String url = "/uu-admin/SystemManager/setParaManager";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postModifyParameterConfigurationTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postModifyParameterConfigurationTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为错误
	 */
	@Test
	public void postModifyParameterConfigurationTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postModifyParameterConfigurationTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<.@#$%>");
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postModifyParameterConfigurationTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 123.123);
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postModifyParameterConfigurationTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -345);
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postModifyParameterConfigurationTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postModifyParameterConfigurationTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "userId");
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postModifyParameterConfigurationTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postModifyParameterConfigurationTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postModifyParameterConfigurationTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postModifyParameterConfigurationTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 参数ID传错误
	 */
	@Test
	public void postModifyParameterConfigurationTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 999);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数ID传错误" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 参数id传负数
	 */
	@Test
	public void postModifyParameterConfigurationTestParaIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", -2);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id传负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 参数id传小数
	 */
	@Test
	public void postModifyParameterConfigurationTestParaIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1.23);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id传小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 参数id传非法字符
	 */
	@Test
	public void postModifyParameterConfigurationTestParaIdIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", "<@$%^>");
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id传非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 参数id传String
	 */
	@Test
	public void postModifyParameterConfigurationTestParaIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", "GDFD");
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id传String" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 参数id传空
	 */
	@Test
	public void postModifyParameterConfigurationTestParaIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", "");
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 参数id传空格
	 */
	@Test
	public void postModifyParameterConfigurationTestParaIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", " ");
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 参数id传null
	 */
	@Test
	public void postModifyParameterConfigurationTestParaIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", null);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 参数id不传参数
	 */
	@Test
	public void postModifyParameterConfigurationTestParaIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 参数id传超长
	 */
	@Test
	public void postModifyParameterConfigurationTestParaIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 999999999999999999L);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 名称name传超长
	 */
	@Test
	public void postModifyParameterConfigurationTestNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", "自动化测试dgdgfdsf法大师傅大师傅士大夫发生的事故和福建话剧他还发不发的速度");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("名称name传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 名称name含有非法字符
	 */
	@Test
	public void postModifyParameterConfigurationTestNameIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", "<$^@#￥￥#>");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("名称name含有非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 名称name传空格
	 */
	@Test
	public void postModifyParameterConfigurationTestNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", " ");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("名称name传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 名称name传空
	 */
	@Test
	public void postModifyParameterConfigurationTestNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", "");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("名称name传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 名称name传null
	 */
	@Test
	public void postModifyParameterConfigurationTestNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", null);
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("名称name传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 名称name不传参数
	 */
	@Test
	public void postModifyParameterConfigurationTestNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", "");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("名称name不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 规则列表rules超长
	 */
	@Test
	public void postModifyParameterConfigurationTestRulesIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除地方大师傅十分十分广泛大锅饭好好干黄瓜富含丰富的规范规定");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("规则列表rules超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 规则列表rules含有非法字符
	 */
	@Test
	public void postModifyParameterConfigurationTestRulesIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "<@$%$#^>");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("规则列表rules含有非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 规则列表rules为空
	 */
	@Test
	public void postModifyParameterConfigurationTestRulesIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("规则列表rules为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 规则列表rule传空格
	 */
	@Test
	public void postModifyParameterConfigurationTestRulesIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", " ");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("规则列表rule传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 规则列表rules传null
	 */
	@Test
	public void postModifyParameterConfigurationTestRulesIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", null);
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("规则列表rules传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 规则列表rules不传参数
	 */
	@Test
	public void postModifyParameterConfigurationTestRulesNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("规则列表rules不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态status传错误
	 */
	@Test
	public void postModifyParameterConfigurationTestStatusIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 99);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传错误" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态status传小数
	 */
	@Test
	public void postModifyParameterConfigurationTestStatusIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1.22);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态status传负数
	 */
	@Test
	public void postModifyParameterConfigurationTestStatusIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", -1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态status传空
	 */
	@Test
	public void postModifyParameterConfigurationTestStatusIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态status传空格
	 */
	@Test
	public void postModifyParameterConfigurationTestStatusIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态status传null
	 */
	@Test
	public void postModifyParameterConfigurationTestStatusIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态status传String
	 */
	@Test
	public void postModifyParameterConfigurationTestStatusIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", "但是犯得上发生");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传String" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态status不传参
	 */
	@Test
	public void postModifyParameterConfigurationTestStatusNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status不传参" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态status传1启用
	 */
	@Test
	public void postModifyParameterConfigurationTestStatusIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传1启用" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态status传0禁止
	 */
	@Test
	public void postModifyParameterConfigurationTestStatusIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传0禁止" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态status先传1启用再传0禁止
	 */
	@Test
	public void postModifyParameterConfigurationTestStatusIs1Again0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status先传1启用再传0禁止" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态status先传0禁止再传1启用
	 */
	@Test
	public void postModifyParameterConfigurationTestStatusIs0Again1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 0);
		request.put("name", "自动化测试");
		request.put("rules", "自动化测试用请勿删除");
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status先传0禁止再传1启用" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
}