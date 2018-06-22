package com.appDynamic;

import com.example.HttpUtil;
import com.example.LoginTest;
import com.example.MetaOper;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class GetDynamicDetailsTest extends HttpUtil {
//获取动态详情接口
	String url = "/UU/dynamic";

	JSONObject body;
	String uuid;
	String chcode;
	String dataType = "perCenter81";
	String dynamicId;
	String selectSql = "SELECT * FROM T_DYNAMIC ORDER BY CREATE_TIME DESC";
	List<Map<String,Object>> list ;
	Map<String, Object> head = new HashMap<String, Object>();
	@BeforeClass
	public void  beforeClass(){
		list = MetaOper.read(selectSql,dataType);
		dynamicId = list.get(0).get("DYNAMIC_ID").toString();
		LoginTest login = new LoginTest();
		try {
			body = login.getLoginTestChcodeBy177();
			uuid= (body.get("userId")).toString();
			chcode= (body.get("checkCode")).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		head.put("aid", "lan6uu");
		head.put("ver", "1.2.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", chcode);
		head.put("cmd", 515);
	}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetDynamicDetailsTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", dynamicId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postGetDynamicDetailsTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 1.1);
		con.put("dynamicId", dynamicId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不合法！");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postGetDynamicDetailsTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -1);
		con.put("dynamicId", dynamicId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不合法！");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postGetDynamicDetailsTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
		con.put("dynamicId", dynamicId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不合法！");
	}
	/**
	 * 用户ID为错误
	 */
	@Test
	public void postGetDynamicDetailsTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 123);
		con.put("dynamicId", dynamicId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID未登录
	 */
	@Test
	public void postGetDynamicDetailsTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492161);
		con.put("dynamicId", dynamicId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID未登录" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为字符串
	 */
	@Test
	public void postGetDynamicDetailsTestUserIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "uuid");
		con.put("dynamicId", dynamicId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不合法！");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postGetDynamicDetailsTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "<.@#$%>");
		con.put("dynamicId", dynamicId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不合法！");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postGetDynamicDetailsTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		con.put("dynamicId", dynamicId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postGetDynamicDetailsTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("dynamicId", dynamicId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不合法！");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postGetDynamicDetailsTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("dynamicId", dynamicId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不合法！");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postGetDynamicDetailsTestUserIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 123123123123123L);
		con.put("dynamicId", dynamicId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不合法！");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postGetDynamicDetailsTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", dynamicId);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不能为空！");
	}
	
	/**
	 * 动态ID为小数
	 */
	@Test
	public void postGetDynamicDetailsTestDynamicIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", 1.1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不合法！");
	}
	/**
	 * 动态ID为负数
	 */
	@Test
	public void postGetDynamicDetailsTestDynamicIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", -1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不合法！");
	}
	/**
	 * 动态ID为0
	 */
	@Test
	public void postGetDynamicDetailsTestDynamicIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("该动态已被删除,无法查看！");
	}
	/**
	 * 动态ID为错误
	 */
	@Test
	public void postGetDynamicDetailsTestDynamicIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", 123);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("该动态已被删除,无法查看！");
	}
	/**
	 * 动态ID为字符串
	 */
	@Test
	public void postGetDynamicDetailsTestDynamicIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", "a6b4c6d8");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为字符串" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不合法！");
	}
	/**
	 * 动态ID为非法字符
	 */
	@Test
	public void postGetDynamicDetailsTestDynamicIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", "<.@#$%>");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不合法！");
	}
	/**
	 * 动态ID为null
	 */
	@Test
	public void postGetDynamicDetailsTestDynamicIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", null);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 动态ID为空
	 */
	@Test
	public void postGetDynamicDetailsTestDynamicIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不合法！");
	}
	/**
	 * 动态ID为空格
	 */
	@Test
	public void postGetDynamicDetailsTestDynamicIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", " ");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不合法！");
	}
	/**
	 * 动态ID为超长
	 */
	@Test
	public void postGetDynamicDetailsTestDynamicIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", 123123123123123L);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("该动态已被删除,无法查看！");
	}
	/**
	 * 动态ID不传该参数
	 */
	@Test
	public void postGetDynamicDetailsTestDynamicIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不能为空！");
	}

}