package com.appDynamic;

import com.example.HttpUtil;
import com.example.LoginTest;
import com.example.MetaOper;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class GetLaudListTest extends HttpUtil {
//获取点赞列表接口
	String url = "/UU/dynamic";

	JSONObject body;
	Long uuid;
	String chcode;
	String dataType = "perCenter81";
	Long dynamicId;
	String selectSql = "SELECT * FROM T_DYNAMIC ORDER BY CREATE_TIME DESC";
	List<Map<String,Object>> list ;
	Map<String, Object> head = new HashMap<String, Object>();
	@BeforeClass
	public void  beforeClass(){
		list = MetaOper.read(selectSql,dataType);
		dynamicId = Long.parseLong(list.get(0).get("DYNAMIC_ID").toString());
		LoginTest login = new LoginTest();
		try {
			body = login.getLoginTestChcodeBy177();
			uuid= Long.parseLong((body.get("userId")).toString());
			chcode= (body.get("checkCode")).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-06-20 14:22:01");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", chcode);
		head.put("cmd", 519);
	}
	
//	@BeforeMethod
//	public void beforeMethod(){
//		
//	}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetLaudListTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", 20);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isIn("成功","扎心了,该动态没人点赞");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postGetLaudListTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 1.1);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", 20);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postGetLaudListTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -1);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", 20);
		con.put("pageNow", 1);

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
	public void postGetLaudListTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", 20);
		con.put("pageNow", 1);

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
	public void postGetLaudListTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 123);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", 20);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isIn("成功", "扎心了,该动态没人点赞");
	}
	/**
	 * 用户ID未登录
	 */
	@Test
	public void postGetLaudListTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12492161);
		con.put("dynamicId", 8264);
		con.put("pageSize", 20);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID未登录" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isIn("成功", "扎心了,该动态没人点赞");
	}
	/**
	 * 用户ID为字符串
	 */
	@Test
	public void postGetLaudListTestUserIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "uuid");
		con.put("dynamicId", dynamicId);
		con.put("pageSize", 20);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为字符串" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postGetLaudListTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "<.@#$%>");
		con.put("dynamicId", dynamicId);
		con.put("pageSize", 20);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postGetLaudListTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", 20);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postGetLaudListTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("dynamicId", dynamicId);
		con.put("pageSize", 20);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(1);
		assertThat(head1.get("msg")).isEqualTo("错误,用户id格式违法");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postGetLaudListTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("dynamicId", dynamicId);
		con.put("pageSize", 20);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(1);
		assertThat(head1.get("msg")).isEqualTo("错误,用户id格式违法");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postGetLaudListTestUserIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 123123123123123L);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", 20);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postGetLaudListTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("dynamicId", dynamicId);
		con.put("pageSize", 20);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	
	/**
	 * 动态ID为小数
	 */
	@Test
	public void postGetLaudListTestDynamicIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", 1.1);
		con.put("pageSize", 20);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 动态ID为负数
	 */
	@Test
	public void postGetLaudListTestDynamicIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", -1);
		con.put("pageSize", 20);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(1);
		assertThat(head1.get("msg")).isEqualTo("没有这条动态");
	}
	/**
	 * 动态ID为0
	 */
	@Test
	public void postGetLaudListTestDynamicIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", 0);
		con.put("pageSize", 20);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(1);
		assertThat(head1.get("msg")).isEqualTo("没有这条动态");
	}
	/**
	 * 动态ID为错误
	 */
	@Test
	public void postGetLaudListTestDynamicIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", 123);
		con.put("pageSize", 20);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(1);
		assertThat(head1.get("msg")).isEqualTo("没有这条动态");
	}
	/**
	 * 动态ID为字符串
	 */
	@Test
	public void postGetLaudListTestDynamicIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", "a6b4c6d8");
		con.put("pageSize", 20);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为字符串" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 动态ID为非法字符
	 */
	@Test
	public void postGetLaudListTestDynamicIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", "<.@#$%>");
		con.put("pageSize", 20);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 动态ID为null
	 */
	@Test
	public void postGetLaudListTestDynamicIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", null);
		con.put("pageSize", 20);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(1);
		assertThat(head1.get("msg")).isEqualTo("错误,请输入动态id");
	}
	/**
	 * 动态ID为空
	 */
	@Test
	public void postGetLaudListTestDynamicIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", "");
		con.put("pageSize", 20);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(1);
		assertThat(head1.get("msg")).isEqualTo("错误,动态id格式违法");
	}
	/**
	 * 动态ID为空格
	 */
	@Test
	public void postGetLaudListTestDynamicIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", " ");
		con.put("pageSize", 20);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(1);
		assertThat(head1.get("msg")).isEqualTo("错误,动态id格式违法");
	}
	/**
	 * 动态ID为超长
	 */
	@Test
	public void postGetLaudListTestDynamicIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", 123123123123123L);
		con.put("pageSize", 20);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 动态ID不传该参数
	 */
	@Test
	public void postGetLaudListTestDynamicIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("pageSize", 20);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(1);
		assertThat(head1.get("msg")).isEqualTo("错误,请输入动态id");
	}
	
	/**
	 * 每页显示数量为小数
	 */
	@Test
	public void postGetLaudListTestPageSizeIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", 1.23);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示数量为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 每页显示数量为负数
	 */
	@Test
	public void postGetLaudListTestPageSizeIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", -2);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示数量为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(1);
		assertThat(head1.get("msg")).isEqualTo("错误,当前页或每页显示必须大于等于1");
	}
	/**
	 * 每页显示数量为0
	 */
	@Test
	public void postGetLaudListTestPageSizeIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", 0);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示数量为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(1);
		assertThat(head1.get("msg")).isEqualTo("错误,当前页或每页显示必须大于等于1");
	}
	/**
	 * 每页显示数量为非法字符
	 */
	@Test
	public void postGetLaudListTestPageSizeIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", "<.@#$%>");
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示数量为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 每页显示数量为字符串
	 */
	@Test
	public void postGetLaudListTestPageSizeIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", "a6b4c6d8");
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示数量为字符串" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 每页显示数量为null
	 */
	@Test
	public void postGetLaudListTestPageSizeIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", null);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示数量为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 每页显示数量为空
	 */
	@Test
	public void postGetLaudListTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", "");
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示数量为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 每页显示数量为空格
	 */
	@Test
	public void postGetLaudListTestPageSizeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", " ");
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示数量为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 每页显示数量为超长
	 */
	@Test
	public void postGetLaudListTestPageSizeIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", 123123123123123L);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示数量为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 每页显示数量不传该参数
	 */
	@Test
	public void postGetLaudListTestPageSizeNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", dynamicId);
		con.put("pageNow", 1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示数量不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	
	/**
	 * 当前页数为小数
	 */
	@Test
	public void postGetLaudListTestPageNowIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", 20);
		con.put("pageNow", 1.23);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 当前页数为负数
	 */
	@Test
	public void postGetLaudListTestPageNowIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", 20);
		con.put("pageNow", -1);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(1);
		assertThat(head1.get("msg")).isEqualTo("错误,当前页或每页显示必须大于等于1");
	}
	/**
	 * 当前页数为0
	 */
	@Test
	public void postGetLaudListTestPageNowIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", 20);
		con.put("pageNow", 0);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(1);
		assertThat(head1.get("msg")).isEqualTo("错误,当前页或每页显示必须大于等于1");
	}
	/**
	 * 当前页数为非法字符
	 */
	@Test
	public void postGetLaudListTestPageNowIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", 20);
		con.put("pageNow", "<.@#$%>");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 当前页数为字符串
	 */
	@Test
	public void postGetLaudListTestPageNowIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", 20);
		con.put("pageNow", "a6b4c6d8");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为字符串" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 当前页数为null
	 */
	@Test
	public void postGetLaudListTestPageNowIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", 20);
		con.put("pageNow", null);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 当前页数为空
	 */
	@Test
	public void postGetLaudListTestPageNowIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", 20);
		con.put("pageNow", "");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 当前页数为空格
	 */
	@Test
	public void postGetLaudListTestPageNowIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", 20);
		con.put("pageNow", " ");

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 当前页数为超长
	 */
	@Test
	public void postGetLaudListTestPageNowIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", 20);
		con.put("pageNow", 123123123123123L);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 当前页数不传该参数
	 */
	@Test
	public void postGetLaudListTestPageNowNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("dynamicId", dynamicId);
		con.put("pageSize", 20);

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页数不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");

		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}

}