package com.appDynamic;

import com.example.HttpUtil;
import com.example.LoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.collections.CollectionUtils;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class HomeDynamicListsTest extends HttpUtil {
//首页动态列表接口（支持筛选、搜索、插入陌生人动态）
	String url = "/UU/dynamic";

	JSONObject body;
	String uuid;
	String chcode;
	Map<String, Object> head = new HashMap<String, Object>();
	@BeforeClass
	public void  beforeClass() throws Exception {
		LoginTest login = new LoginTest();
		try {
			body = login.getLoginTestChcodeBy177();
			uuid= (body.get("userId")).toString();
			chcode= (body.get("checkCode")).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new PublishDynamicsTest().postPublishDynamicsTestCorrectParameter();
		head.put("aid", "lan6uu");
		head.put("ver", "1.2.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", chcode);
		head.put("cmd", 520);//514  520
	}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postHomeDynamicListsTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 0);
		con.put("keyContent", "");

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
	 * 开启附近陌生人
	 */
	@Test
	public void postHomeDynamicListsTestOpenNearbyStrangers() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 1);
		con.put("indirectFriend", 0);
		con.put("stranger", 0);
		con.put("keyContent", "");
		con.put("longitude", "121.51419305272026");
		con.put("latitude", "31.15694861603254");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("开启附近陌生人" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postHomeDynamicListsTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 1.1);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("For input string: \"1.1\"");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postHomeDynamicListsTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -1);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body = (JSONObject) post.get("body");
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(body.get("dynamicList").toString()).isEqualTo("[]");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postHomeDynamicListsTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为错误
	 */
	@Test
	public void postHomeDynamicListsTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 123);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body = (JSONObject) post.get("body");
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(body.get("dynamicList").toString()).isEqualTo("[]");
	}
	/**
	 * 用户ID未登录
	 */
	@Test
	public void postHomeDynamicListsTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

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
	public void postHomeDynamicListsTestUserIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "uuid");
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为字符串" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("For input string: \"uuid\"");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postHomeDynamicListsTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

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
	public void postHomeDynamicListsTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("For input string: \"\"");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postHomeDynamicListsTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("For input string: \" \"");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postHomeDynamicListsTestUserIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 123123123123123L);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body = (JSONObject) post.get("body");
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(body.get("dynamicList").toString()).isEqualTo("[]");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postHomeDynamicListsTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

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
	 * 动态类型为字符串//接口不做校验这参数默认-1
	 */
	@Test
	public void postHomeDynamicListsTestDynamicTypeIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", "dynamicType");
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型为字符串" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型为小数
	 */
	@Test
	public void postHomeDynamicListsTestDynamicTypeIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", 1.1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}

	/**
	 * 动态类型为负数
	 */
	@Test
	public void postHomeDynamicListsTestDynamicTypeIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -2);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型为最大值
	 */
	@Test
	public void postHomeDynamicListsTestDynamicTypeIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", 999999999);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型为最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型为0文字
	 */
	@Test
	public void postHomeDynamicListsTestDynamicTypeIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", 0);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型为0文字" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型为1图文
	 */
	@Test
	public void postHomeDynamicListsTestDynamicTypeIsOne() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", 1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型为1图文" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型为2图片
	 */
	@Test
	public void postHomeDynamicListsTestDynamicTypeIsTwo() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", 2);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型为2图片" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型为3视频
	 */
	@Test
	public void postHomeDynamicListsTestDynamicTypeIsThree() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", 3);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型为3视频" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型为4音频
	 */
	@Test
	public void postHomeDynamicListsTestDynamicTypeIsFour() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", 4);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型为4音频" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型为5位置
	 */
	@Test
	public void postHomeDynamicListsTestDynamicTypeIsFives() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", 5);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型为5位置" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型为6直销动态
	 */
	@Test
	public void postHomeDynamicListsTestDynamicTypeIsSix() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", 6);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型为6直销动态" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型为7明星片分析
	 */
	@Test
	public void postHomeDynamicListsTestDynamicTypeIsSeven() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", 7);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型为7明星片分析" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型为8社群分享
	 */
	@Test
	public void postHomeDynamicListsTestDynamicTypeIsEight() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", 8);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型为8社群分享" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型为9活动
	 */
	@Test
	public void postHomeDynamicListsTestDynamicTypeIsNine() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", 9);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型为9活动" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型为10需求
	 */
	@Test
	public void postHomeDynamicListsTestDynamicTypeIsTen() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", 10);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型为10需求" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型为11服务
	 */
	@Test
	public void postHomeDynamicListsTestDynamicTypeIsEleven() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", 11);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型为11服务" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型为-1全部
	 */
	@Test
	public void postHomeDynamicListsTestDynamicTypeNegativeOne() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型为-1全部" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型为空
	 */
	@Test
	public void postHomeDynamicListsTestDynamicTypeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", "");
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型为空格
	 */
	@Test
	public void postHomeDynamicListsTestDynamicTypeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", " ");
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型为null
	 */
	@Test
	public void postHomeDynamicListsTestDynamicTypeIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", null);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型不传该参数
	 */
	@Test
	public void postHomeDynamicListsTestDynamicTypeNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 基本类型为小数//参数不做校验直接都以-1处理
	 */
	@Test
	public void postHomeDynamicListsTestBasicTypeIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", 1.2);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("基本类型为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 基本类型为负数
	 */
	@Test
	public void postHomeDynamicListsTestBasicTypeIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -9);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("基本类型为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 基本类型为-1
	 */
	@Test
	public void postHomeDynamicListsTestBasicTypeIsNegativeNumberOne() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("基本类型为-1" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 基本类型为0
	 */
	@Test
	public void postHomeDynamicListsTestBasicTypeIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", 0);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("基本类型为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 基本类型为字符串
	 */
	@Test
	public void postHomeDynamicListsTestBasicTypeIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", "basicType");
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("基本类型为字符串" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 基本类型为空
	 */
	@Test
	public void postHomeDynamicListsTestBasicTypeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", "");
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("基本类型为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 基本类型为空格
	 */
	@Test
	public void postHomeDynamicListsTestBasicTypeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", " ");
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("基本类型为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 基本类型为null
	 */
	@Test
	public void postHomeDynamicListsTestBasicTypeIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", null);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("基本类型为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 基本类型为最大值
	 */
	@Test
	public void postHomeDynamicListsTestBasicTypeIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", 999999999);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("基本类型为最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 基本类型不传该参数
	 */
	@Test
	public void postHomeDynamicListsTestBasicTypeNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("基本类型不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 基本类型为超长
	 */
	@Test
	public void postHomeDynamicListsTestBasicTypeIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", 11111111111111111L);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("基本类型为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 性别为0男
	 */
	@Test
	public void postHomeDynamicListsTestGenderTypeIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为0男" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 性别为1女
	 */
	@Test
	public void postHomeDynamicListsTestGenderTypeIsOne() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", 1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为1女" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 性别为-1不选
	 */
	@Test
	public void postHomeDynamicListsTestGenderTypeIsNegativeOne() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为-1不选" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 性别为-2错误
	 */
	@Test
	public void postHomeDynamicListsTestGenderTypeIsNegativeTwo() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -2);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为-2错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 性别为2错误
	 */
	@Test
	public void postHomeDynamicListsTestGenderTypeIsTwo() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", 2);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为2错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 性别为小数
	 */
	@Test
	public void postHomeDynamicListsTestGenderTypeIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", 1.1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 性别为字符串
	 */
	@Test
	public void postHomeDynamicListsTestGenderTypeIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", "ssss");
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为字符串" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 性别为最大值
	 */
	@Test
	public void postHomeDynamicListsTestGenderTypeIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", 999999999);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 性别为超长
	 */
	@Test
	public void postHomeDynamicListsTestGenderTypeIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", 999999999999L);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 性别为空//性别不做校验
	 */
	@Test
	public void postHomeDynamicListsTestGenderTypeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", "");
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 性别为空格
	 */
	@Test
	public void postHomeDynamicListsTestGenderTypeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", " ");
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 性别为null
	 */
	@Test
	public void postHomeDynamicListsTestGenderTypeIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", null);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 性别不传该参数
	 */
	@Test
	public void postHomeDynamicListsTestGenderTypeNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页码为小数
	 */
	@Test
	public void postHomeDynamicListsTestPageNowIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1.4);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("For input string: \"1.4\"");
	}
	/**
	 * 当前页码为负数
	 */
	@Test
	public void postHomeDynamicListsTestPageNowIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", -1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body = (JSONObject) post.get("body");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(body.get("dynamicList").toString()).isEqualTo("[]");
		//CollectionUtils.isEmpty
	}
	/**
	 * 当前页码为0
	 */
	@Test
	public void postHomeDynamicListsTestPageNowIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 0);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body = (JSONObject) post.get("body");
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(body.get("dynamicList").toString()).isEqualTo("[]");
	}
	/**
	 * 当前页码最大值
	 */
	@Test
	public void postHomeDynamicListsTestPageNowIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 999999999);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页码超长
	 */
	@Test
	public void postHomeDynamicListsTestPageNowIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 99999999999999L);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("For input string: \"99999999999999\"");
	}
	/**
	 * 当前页码为空
	 */
	@Test
	public void postHomeDynamicListsTestPageNowIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", "");
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("For input string: \"\"");
	}
	/**
	 * 当前页码为空格
	 */
	@Test
	public void postHomeDynamicListsTestPageNowIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", " ");
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("For input string: \" \"");
	}
	/**
	 * 当前页码为null
	 */
	@Test
	public void postHomeDynamicListsTestPageNowIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", null);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 当前页码不传该参数
	 */
	@Test
	public void postHomeDynamicListsTestPageNowNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 每页的个数为小数
	 */
	@Test
	public void postHomeDynamicListsTestPageSizeIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageSize", 1.4);
		con.put("pageNow", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页的个数为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("For input string: \"1.4\"");
	}
	/**
	 * 每页的个数为负数
	 */
	@Test
	public void postHomeDynamicListsTestPageSizeIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageSize", -1);
		con.put("pageNow", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页的个数为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body = (JSONObject) post.get("body");
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(body.get("dynamicList").toString()).isEqualTo("[]");
	}
	/**
	 * 每页的个数为0
	 */
	@Test
	public void postHomeDynamicListsTestPageSizeIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageSize", 0);
		con.put("pageNow", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页的个数为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body = (JSONObject) post.get("body");
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(body.get("dynamicList").toString()).isEqualTo("[]");
	}
	/**
	 * 每页的个数最大值
	 */
	@Test
	public void postHomeDynamicListsTestPageSizeIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageSize", 999999999);
		con.put("pageNow", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页的个数最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 每页的个数超长
	 */
	@Test
	public void postHomeDynamicListsTestPageSizeIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageSize", 99999999999999L);
		con.put("pageNow", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页的个数超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("For input string: \"99999999999999\"");
	}
	/**
	 * 每页的个数为空
	 */
	@Test
	public void postHomeDynamicListsTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageSize", "");
		con.put("pageNow", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页的个数为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("For input string: \"\"");
	}
	/**
	 * 每页的个数为空格
	 */
	@Test
	public void postHomeDynamicListsTestPageSizeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageSize", " ");
		con.put("pageNow", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页的个数为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("For input string: \" \"");
	}
	/**
	 * 每页的个数为null
	 */
	@Test
	public void postHomeDynamicListsTestPageSizeIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageSize", null);
		con.put("pageNow", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页的个数为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 每页的个数不传该参数
	 */
	@Test
	public void postHomeDynamicListsTestPageSizeNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页的个数不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 排序为0时间排序
	 */
	@Test
	public void postHomeDynamicListsTestSelectTypeIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("排序为0时间排序" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 排序为1距离排序
	 */
	@Test
	public void postHomeDynamicListsTestSelectTypeIsOne() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("排序为1距离排序" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 排序为小数
	 */
	@Test
	public void postHomeDynamicListsTestSelectTypeIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0.1);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("排序为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body = (JSONObject) post.get("body");
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(body.get("dynamicList").toString()).isEqualTo("[]");
	}
	/**
	 * 排序为负数
	 */
	@Test
	public void postHomeDynamicListsTestSelectTypeIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", -1);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("排序为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body = (JSONObject) post.get("body");
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(body.get("dynamicList").toString()).isEqualTo("[]");
	}
	/**
	 * 排序为字符串
	 */
	@Test
	public void postHomeDynamicListsTestSelectTypeIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", "selectType");
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("排序为字符串" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body = (JSONObject) post.get("body");
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(body.get("dynamicList").toString()).isEqualTo("[]");
	}
	/**
	 * 排序为最大值
	 */
	@Test
	public void postHomeDynamicListsTestSelectTypeIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 999999999);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("排序为最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body = (JSONObject) post.get("body");
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(body.get("dynamicList").toString()).isEqualTo("[]");
	}
	/**
	 * 排序为超长
	 */
	@Test
	public void postHomeDynamicListsTestSelectTypeIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 999999999999L);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("排序为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body = (JSONObject) post.get("body");
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(body.get("dynamicList").toString()).isEqualTo("[]");
	}
	/**
	 * 排序为空
	 */
	@Test
	public void postHomeDynamicListsTestSelectTypeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", "");
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("排序为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 排序为空格
	 */
	@Test
	public void postHomeDynamicListsTestSelectTypeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", " ");
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("排序为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body = (JSONObject) post.get("body");
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(body.get("dynamicList").toString()).isEqualTo("[]");
	}
	/**
	 * 排序为null
	 */
	@Test
	public void postHomeDynamicListsTestSelectTypeIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", null);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("排序为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 排序不传该参数
	 */
	@Test
	public void postHomeDynamicListsTestSelectTypeNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("排序不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不能为空！");
	}

	/**
	 * 间接朋友和陌生人一起勾选
	 */
	@Test
	public void postHomeDynamicListsTestIndirectFriendAndStrangerCheckTogether() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 1);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("间接朋友和陌生人一起勾选" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 只勾选间接朋友
	 */
	@Test
	public void postHomeDynamicListsTestIndirectFriendIsCheck() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 1);
		con.put("stranger", 0);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("只勾选间接朋友" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 只勾选陌生人
	 */
	@Test
	public void postHomeDynamicListsTestIndirectStrangerIsCheck() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("只勾选陌生人" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 间接朋友和陌生人都不勾选
	 */
	@Test
	public void postHomeDynamicListsTestIndirectFriendAndStrangerDoNotCheck() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 0);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("间接朋友和陌生人都不勾选" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 间接朋友为小数
	 */
	@Test
	public void postHomeDynamicListsTestIndirectFriendIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("间接朋友为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 间接朋友为负数
	 */
	@Test
	public void postHomeDynamicListsTestIndirectFriendIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", -9);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("间接朋友为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 间接朋友为null
	 */
	@Test
	public void postHomeDynamicListsTestIndirectFriendIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", null);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("间接朋友为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 间接朋友为最大值
	 */
	@Test
	public void postHomeDynamicListsTestIndirectFriendIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 999999999);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("间接朋友为最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 间接朋友为超长
	 */
	@Test
	public void postHomeDynamicListsTestIndirectFriendIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 999999999999L);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("间接朋友为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("For input string: \"999999999999\"");
	}
	/**
	 * 间接朋友为字符串
	 */
	@Test
	public void postHomeDynamicListsTestIndirectFriendIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", "indirectFriend");
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("间接朋友为字符串" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 间接朋友为空格
	 */
	@Test
	public void postHomeDynamicListsTestIndirectFriendIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", " ");
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("间接朋友为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("For input string: \" \"");
	}
	/**
	 * 间接朋友为空
	 */
	@Test
	public void postHomeDynamicListsTestIndirectFriendIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", "");
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("间接朋友为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("For input string: \"\"");
	}
	/**
	 * 间接朋友不传该参数
	 */
	@Test
	public void postHomeDynamicListsTestIndirectFriendNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("间接朋友不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 陌生人不传该参数
	 */
	@Test
	public void postHomeDynamicListsTestStrangerNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("陌生人不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 陌生人为空
	 */
	@Test
	public void postHomeDynamicListsTestStrangerIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", "");
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("陌生人为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body = (JSONObject) post.get("body");
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(body.get("dynamicList").toString()).isEqualTo("[]");
	}
	/**
	 * 陌生人为空格
	 */
	@Test
	public void postHomeDynamicListsTestStrangerIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", " ");
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("陌生人为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body = (JSONObject) post.get("body");
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(body.get("dynamicList").toString()).isEqualTo("[]");
	}
	/**
	 * 陌生人为字符串
	 */
	@Test
	public void postHomeDynamicListsTestStrangerIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", "aaaaaa");
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("陌生人为字符串" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body = (JSONObject) post.get("body");
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(body.get("dynamicList").toString()).isEqualTo("[]");
	}
	/**
	 * 陌生人为超长
	 */
	@Test
	public void postHomeDynamicListsTestStrangerIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 111111111111L);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("陌生人为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body = (JSONObject) post.get("body");
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(body.get("dynamicList").toString()).isEqualTo("[]");
	}
	/**
	 * 陌生人为最大值
	 */
	@Test
	public void postHomeDynamicListsTestStrangerIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 999999999);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("陌生人为最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 陌生人为null
	 */
	@Test
	public void postHomeDynamicListsTestStrangerIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", null);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("陌生人为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 陌生人为负数
	 */
	@Test
	public void postHomeDynamicListsTestStrangerIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", -1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("陌生人为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body = (JSONObject) post.get("body");
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(body.get("dynamicList").toString()).isEqualTo("[]");
	}
	/**
	 * 陌生人为小数
	 */
	@Test
	public void postHomeDynamicListsTestStrangerIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1.8);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("陌生人为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		JSONObject body = (JSONObject) post.get("body");
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(body.get("dynamicList").toString()).isEqualTo("[]");
	}
	/**
	 * 关键字查询不传该参数
	 */
	@Test
	public void postHomeDynamicListsTestKeyContentNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键字查询" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 关键字查询为null
	 */
	@Test
	public void postHomeDynamicListsTestKeyContentIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", null);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键字查询为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 关键字查询为空格
	 */
	@Test
	public void postHomeDynamicListsTestKeyContentIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", " ");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键字查询为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 关键字查询为空
	 */
	@Test
	public void postHomeDynamicListsTestKeyContentIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键字查询为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 关键字查询为超长
	 */
	@Test
	public void postHomeDynamicListsTestKeyContentIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "FGHJKLKJHGFGHJKJHGFDDFGHJKLKJHGDCFVKJHGFDFGHJKJHGFDFGHJYTRTYUIIUYFGHJghjkjhhfkfasdfasdfaskjdfhasdfFGHJKLKJHGFGHJKJHGFDDFGHJKLKJHGDCFVKJHGFDFGHJKJHGFDFGHJYTRTYUIIUYFGHJghjkjhhfkfasdfasdfaskjdfhasdfFGHJKLKJHGFGHJKJHGFDDFGHJKLKJHGDCFVKJHGFDFGHJKJHGFDFGHJYTRTYUIIUYFGHJghjkjhhfkfasdfasdfaskjdfhasdfFGHJKLKJHGFGHJKJHGFDDFGHJKLKJHGDCFVKJHGFDFGHJKJHGFDFGHJYTRTYUIIUYFGHJghjkjhhfkfasdfasdfaskjdfhasdfFGHJKLKJHGFGHJKJHGFDDFGHJKLKJHGDCFVKJHGFDFGHJKJHGFDFGHJYTRTYUIIUYFGHJghjkjhhfkfasdfasdfaskjdfhasdfFGHJKLKJHGFGHJKJHGFDDFGHJKLKJHGDCFVKJHGFDFGHJKJHGFDFGHJYTRTYUIIUYFGHJghjkjhhfkfasdfasdfaskjdfhasdfFGHJKLKJHGFGHJKJHGFDDFGHJKLKJHGDCFVKJHGFDFGHJKJHGFDFGHJYTRTYUIIUYFGHJghjkjhhfkfasdfasdfaskjdfhasdf");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键字查询为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 关键字查询为非法字符
	 */
	@Test
	public void postHomeDynamicListsTestKeyContentIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicType", -1);
		con.put("basicType", -1);
		con.put("genderType", -1);
		con.put("pageNow", 1);
		con.put("pageSize", 10);
		con.put("selectType", 0);
		con.put("indirectFriend", 0);
		con.put("stranger", 1);
		con.put("keyContent", "<.@#$%^>");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("关键字查询为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}


}