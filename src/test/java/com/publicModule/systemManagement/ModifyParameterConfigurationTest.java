package com.publicModule.systemManagement;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class ModifyParameterConfigurationTest extends HttpUtil {
// 修改参数配置接口
	String url = "/uu-admin/SystemManager/setParaManager";
	List<Map<String,Object>> list ;
	List<Map<String,Object>> list1 ;
	List<Map<String,Object>> list2 ;
	String selectSql = "SELECT * FROM T_AUDIT_MSG WHERE MSG_ID = 6";
	String selectSql1 = "SELECT * FROM T_AUDIT_MSG_CATEGORY WHERE CATEGORY_ID = 1";
	String selectSql2 = "SELECT * FROM T_AUDIT_MSG WHERE MSG_CONTENT = '自动化测试1' ";
	String updateSql = "UPDATE T_AUDIT_MSG_CATEGORY SET STATUS = 1 WHERE CATEGORY_ID = 1 ";
	String dataType = "uedb";
	List<Map> lis = new ArrayList<Map>();
	Map<Object, Object> map1 = new HashMap<Object, Object>();
	BackUserLoginTest login = new BackUserLoginTest();
	String userId=login.userId;	
	
	/**
	 * 提交正确参数
	 */
	@Test
	public void postModifyParameterConfigurationTestCorrectParameter() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试1");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("name", "商户审核原因");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		list1 = MetaOper.read(selectSql1,dataType);
		assertThat(list1.get(0).get("STATUS").toString()).isEqualTo("0");
		assertThat(list.get(0).get("CATEGORY_ID").toString()).isEqualTo("1");
		assertThat(list.get(0).get("MSG_CONTENT").toString()).isEqualTo("自动化测试1");
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postModifyParameterConfigurationTestUserIdNotLoggedIn() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 10000006);
		request.put("paraId", 1);
		request.put("name", "商户审核原因");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为错误
	 */
	@Test
	public void postModifyParameterConfigurationTestUserIdIsError() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 111);
		request.put("paraId", 1);
		request.put("name", "商户审核原因");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postModifyParameterConfigurationTestUserIdIllegalCharacters() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "#@$$");
		request.put("paraId", 1);
		request.put("name", "商户审核原因");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postModifyParameterConfigurationTestUserIdIsDecimal() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 124.95366);
		request.put("paraId", 1);
		request.put("name", "商户审核原因");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postModifyParameterConfigurationTestUserIdIsNegativeNumber() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -12495366);
		request.put("paraId", 1);
		request.put("name", "商户审核原因");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postModifyParameterConfigurationTestUserIdIsZero() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);
		request.put("paraId", 1);
		request.put("name", "商户审核原因");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postModifyParameterConfigurationTestUserIdIsString() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "dfgdfs");
		request.put("paraId", 1);
		request.put("name", "商户审核原因");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postModifyParameterConfigurationTestUserIdIsSpace() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("paraId", 1);
		request.put("name", "商户审核原因");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postModifyParameterConfigurationTestUserIdIsEmpty() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("paraId", 1);
		request.put("name", "商户审核原因");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId或者roleId为空");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postModifyParameterConfigurationTestUserIdIsNull() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("paraId", 1);
		request.put("name", "商户审核原因");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId或者roleId为空");
	}
	/**
	 * 参数ID传错误
	 */
	@Test
	public void postModifyParameterConfigurationTestParaIdIsError() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("paraId", 66);
		request.put("name", "商户审核原因");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数ID传错误" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId或者roleId为空");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postModifyParameterConfigurationTestUserIdNonSubmissionParameters() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("paraId", 1);
		request.put("name", "商户审核原因");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId或者roleId为空");
	}
	/**
	 * userId传超长
	 */
	@Test
	public void postModifyParameterConfigurationTestUserIdIsLong() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 999999999999999999L);
		request.put("paraId", 66);
		request.put("name", "商户审核原因");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("userId传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不是admin用户");
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
		assertThat(post.get("msg")).isEqualTo("userId或者roleId格式不正确");
	}
	/**
	 * 参数id传小数
	 */
	@Test
	public void postModifyParameterConfigurationTestParaIdIsDecimal() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 6.6);
		request.put("name", "商户审核原因");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id传小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId或者roleId格式不正确");
	}
	/**
	 * 参数id传非法字符
	 */
	@Test
	public void postModifyParameterConfigurationTestParaIdIsIllegalCharacters() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", "<$%$%>");
		request.put("name", "商户审核原因");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id传非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId或者roleId格式不正确");
	}
	/**
	 * 参数id传String
	 */
	@Test
	public void postModifyParameterConfigurationTestParaIdIsString() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", "dgsgssd");
		request.put("name", "商户审核原因");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id传String" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId或者roleId格式不正确");
	}
	/**
	 * 参数id传空
	 */
	@Test
	public void postModifyParameterConfigurationTestParaIdIsEmpty() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", "");
		request.put("name", "商户审核原因");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId或者roleId为空");
	}
	/**
	 * 参数id传空格
	 */
	@Test
	public void postModifyParameterConfigurationTestParaIdIsSpace() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", " ");
		request.put("name", "商户审核原因");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId或者roleId格式不正确");
	}
	/**
	 * 参数id传null
	 */
	@Test
	public void postModifyParameterConfigurationTestParaIdIsNull() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", null);
		request.put("name", "商户审核原因");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId或者roleId为空");
	}
	/**
	 * 参数id不传参数
	 */
	@Test
	public void postModifyParameterConfigurationTestParaIdNonSubmissionParameters() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("name", "商户审核原因");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId或者roleId为空");
	}
	/**
	 * 参数id传超长
	 */
	@Test
	public void postModifyParameterConfigurationTestParaIdIsLong() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 999999999999999999L);
		request.put("name", "商户审核原因");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("参数id传超长" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 名称name传超长
	 */
	@Test
	public void postModifyParameterConfigurationTestNameIsLong() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("name", "商户审核原因DF的手法首发申购的是规划规范化广泛会议和犹太人发合格符合符合规范化的法国队更多的 ");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("名称name传超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 名称name含有非法字符
	 */
	@Test
	public void postModifyParameterConfigurationTestNameIsIllegalCharacters() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("name", "<#$@#$> ");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("名称name含有非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 名称name传空格
	 */
	@Test
	public void postModifyParameterConfigurationTestNameIsSpace() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("name", " ");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("名称name传空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 名称name传空
	 */
	@Test
	public void postModifyParameterConfigurationTestNameIsEmpty() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("name", "");
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("名称name传空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 名称name传null
	 */
	@Test
	public void postModifyParameterConfigurationTestNameIsNull() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("name", null);
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("名称name传null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 名称name不传参数
	 */
	@Test
	public void postModifyParameterConfigurationTestNameNonSubmissionParameters() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("名称name不传参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 规则列表rules超长
	 */
	@Test
	public void postModifyParameterConfigurationTestRulesIsLong() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", 999999999999999999L);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("规则列表rules超长" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 规则列表rules含有非法字符
	 */
	@Test
	public void postModifyParameterConfigurationTestRulesIsIllegalCharacters() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", "<#$@#$>");
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("规则列表rules含有非法字符" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 规则列表rules为空
	 */
	@Test
	public void postModifyParameterConfigurationTestRulesIsEmpty() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", "");
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("规则列表rules为空" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 规则列表rule传空格
	 */
	@Test
	public void postModifyParameterConfigurationTestRulesIsSpace() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", " ");
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("规则列表rule传空格" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 规则列表rules传null
	 */
	@Test
	public void postModifyParameterConfigurationTestRulesIsNull() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", null);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("规则列表rules传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 规则列表rules不传参数
	 */
	@Test
	public void postModifyParameterConfigurationTestRulesNonSubmissionParameters() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("规则列表rules不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 状态status传错误
	 */
	@Test
	public void postModifyParameterConfigurationTestStatusIsError() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", 99);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传错误" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("status不正确");
	}
	/**
	 * 状态status传小数
	 */
	@Test
	public void postModifyParameterConfigurationTestStatusIsDecimal() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", 1.2);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("status不正确");
	}
	/**
	 * 状态status传负数
	 */
	@Test
	public void postModifyParameterConfigurationTestStatusIsNegativeNumber() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", -1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("status不正确");
	}
	/**
	 * 状态status传空
	 */
	@Test
	public void postModifyParameterConfigurationTestStatusIsEmpty() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("status不正确");
	}
	/**
	 * 状态status传空格
	 */
	@Test
	public void postModifyParameterConfigurationTestStatusIsSpace() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("status不正确");
	}
	/**
	 * 状态status传null
	 */
	@Test
	public void postModifyParameterConfigurationTestStatusIsNull() throws Exception {
		MetaOper.update(updateSql, dataType);
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list1 = MetaOper.read(selectSql1,dataType);
		assertThat(list1.get(0).get("STATUS").toString()).isEqualTo("1");
	}
	/**
	 * 状态status传String
	 */
	@Test
	public void postModifyParameterConfigurationTestStatusIsString() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", "dfsf");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传String" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("status不正确");
	}
	/**
	 * 状态status不传参
	 */
	@Test
	public void postModifyParameterConfigurationTestStatusNonSubmissionParameters() throws Exception {
		MetaOper.update(updateSql, dataType);
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status不传参" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list1 = MetaOper.read(selectSql1,dataType);
		assertThat(list1.get(0).get("STATUS").toString()).isEqualTo("1");
	}
	/**
	 * 状态status传1启用
	 */
	@Test
	public void postModifyParameterConfigurationTestStatusIs1() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传1启用" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list1 = MetaOper.read(selectSql1,dataType);
		assertThat(list1.get(0).get("STATUS").toString()).isEqualTo("1");

	}
	/**
	 * 状态status传0禁止
	 */
	@Test
	public void postModifyParameterConfigurationTestStatusIs0() throws Exception {
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传0禁止" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list1 = MetaOper.read(selectSql1,dataType);
		assertThat(list1.get(0).get("STATUS").toString()).isEqualTo("0");

	}
	/**
	 * 状态status先传1启用再传0禁止
	 */
	@Test
	public void postModifyParameterConfigurationTestStatusIs1Again0() throws Exception {
		MetaOper.update(updateSql, dataType);
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status先传1启用再传0禁止" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list1 = MetaOper.read(selectSql1,dataType);
		assertThat(list1.get(0).get("STATUS").toString()).isEqualTo("0");

	}
	/**
	 * 状态status先传1启用再传1启用
	 */
	@Test
	public void postModifyParameterConfigurationTestStatusIs0Again1() throws Exception {
		MetaOper.update(updateSql, dataType);
		map1.put("key", "6");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status先传0禁止再传1启用" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list1 = MetaOper.read(selectSql1,dataType);
		assertThat(list1.get(0).get("STATUS").toString()).isEqualTo("1");
	}
	/**
	 * key值传错误
	 */
	@Test
	public void postModifyParameterConfigurationTestKeyIsError() throws Exception {
		map1.put("key", "100");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("key值传错误" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("编辑的id不正确");
	}
	/**
	 * key值传String
	 */
	@Test
	public void postModifyParameterConfigurationTestKeyIsString() throws Exception {
		map1.put("key", "fgdfg");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("key值传String" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * key值传超长
	 */
	@Test
	public void postModifyParameterConfigurationTestKeyIsLong() throws Exception {
		map1.put("key", 999999999999999999L);
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("key值传超长" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * key值传负数
	 */
	@Test
	public void postModifyParameterConfigurationTestKeyIsNegativeNumber() throws Exception {
		map1.put("key", -1);
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("key值传负数" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * key值传小数
	 */
	@Test
	public void postModifyParameterConfigurationTestKeyIsDecimal() throws Exception {
		map1.put("key", "1.23");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("key值传小数" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * key值传空
	 */
	@Test
	public void postModifyParameterConfigurationTestKeyIsEmpty() throws Exception {
		map1.put("key", "");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("key值传空" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * key值传空格
	 */
	@Test
	public void postModifyParameterConfigurationTestKeyIsSpace() throws Exception {
		map1.put("key", " ");
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("key值传空格" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * key值传null
	 */
	@Test
	public void postModifyParameterConfigurationTestKeyIsNull() throws Exception {
		map1.put("key", null);
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("key值传null" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * key值不传
	 */
	@Test
	public void postModifyParameterConfigurationTestKeyNonSubmissionParameters() throws Exception {
		map1.put("value", "自动化测试勿删除");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("key值不传" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * value值传超长
	 */
	@Test
	public void postModifyParameterConfigurationTestValueIsLong() throws Exception {
		map1.put("key", "1.23");
		map1.put("value", "自动化测试勿删除f风帆股份烦烦烦烦烦烦广泛广泛广泛广泛广泛广泛广泛广泛广泛广泛分店");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("value值传超长" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * value值传非法字符
	 */
	@Test
	public void postModifyParameterConfigurationTestValueIsIllegalCharacters() throws Exception {
		map1.put("key", "1.23");
		map1.put("value", "<$@#$@#$>");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("value值传非法字符" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * value值传空
	 */
	@Test
	public void postModifyParameterConfigurationTestValueIsEmpty() throws Exception {
		map1.put("key", "6");
		map1.put("value", "");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("value值传空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("MSG_CONTENT")).isEqualTo(null);
	}
	/**
	 * value值传空格
	 */
	@Test
	public void postModifyParameterConfigurationTestValueIsSpace() throws Exception {
		map1.put("key", "6");
		map1.put("value", " ");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("value值传空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("MSG_CONTENT")).isEqualTo(" ");
	}
	/**
	 * value值传null
	 */
	@Test
	public void postModifyParameterConfigurationTestValueIsNull() throws Exception {
		map1.put("key", "6");
		map1.put("value", null);
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("value值传null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("MSG_CONTENT")).isEqualTo(null);
	}
	/**
	 * value值不传
	 */
	@Test
	public void postModifyParameterConfigurationTestValueNonSubmissionParameters() throws Exception {
		List<Map> lis = new ArrayList<Map>();
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("key", "6");
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("paraId", 1);
		request.put("rules", lis);
		request.put("status", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("value值不传" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("MSG_CONTENT")).isEqualTo(null);
	}
}