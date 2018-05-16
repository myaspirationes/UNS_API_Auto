package com.personalCenter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;
import com.example.LoginTest;
import com.example.MetaOper;

public class NoDisturbModeSettingTest extends HttpUtil {
//勿扰模式设置接口
	String url = "/UU/user";
	String selectSql = "SELECT * FROM T_MOBILE_SET WHERE USER_ID = 12495324";
	List<Map<String,Object>> list ;
	String dataType = "perCenter81";
	String chcode;
	@BeforeClass
	public void  beforeClass(){
		LoginTest login = new LoginTest();
		try {
			chcode = login.getLoginTestChcodeBy177();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 提交正确参数为未开启
	 */
	////@Test
	public void postNoDisturbModeSettingTestCorrectParameterNoOpen() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 0);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数为未开启" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		list =MetaOper.read(selectSql,dataType);
		String isNotDisturb = list.get(0).get("IS_NOT_DISTURB").toString();
		
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(isNotDisturb,equalTo( "0" ));
		
		
	}
	/**
	 * 提交正确参数为开启
	 */
	@Test
	public void postNoDisturbModeSettingTestCorrectParameterIsOpen() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", "23:00:00");
		con.put("noDisturbEndTime", "06:00:00");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数为开启" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		list =MetaOper.read(selectSql,dataType);
		String isNotDisturb = list.get(0).get("IS_NOT_DISTURB").toString();
		String nct = list.get(0).get("NODISTURBER_CREATE_TIME") .toString();
		String net = list.get(0).get("NODISTURBER_END_TIME").toString();
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(isNotDisturb,equalTo( "1" ));
		assertThat(nct,equalTo( "23:00:00" ));
		assertThat(net,equalTo( "06:00:00" ));
	}
	/**
	 * 用户为未登录
	 */
	@Test
	public void postNoDisturbModeSettingTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495325");
		con.put("isNotDisturb", 0);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户为未登录" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户为错误
	 */
	////@Test
	public void postNoDisturbModeSettingTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "124a95324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId格式不对");
	}
	/**
	 * 用户ID存在小数
	 */
	////@Test
	public void postNoDisturbModeSettingTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "23.4");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID存在小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId格式不对");
	}
	/**
	 * 用户ID存在非法字符
	 */
	////@Test
	public void postNoDisturbModeSettingTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "<@$*(_+.>");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID存在非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId格式不对");
	}
	/**
	 * 用户ID存在负数
	 */
	//@Test
	public void postNoDisturbModeSettingTestUserIdIsNegativeNumbe() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "-12");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID存在负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId格式不对");
	}
	/**
	 * 用户ID为0
	 */
	//@Test
	public void postNoDisturbModeSettingTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId格式不对");
	}
	/**
	 * 用户ID为String
	 */
	//@Test
	public void postNoDisturbModeSettingTestUserIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "sfhjkkm");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId格式不对");
	}
	/**
	 * 用户ID为空
	 */
	////@Test
	public void postNoDisturbModeSettingTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId格式不对");
	}
	/**
	 * 用户ID为空格
	 */
	//@Test
	public void postNoDisturbModeSettingTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId格式不对");
	}
	/**
	 * 用户ID为null
	 */
	//@Test
	public void postNoDisturbModeSettingTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId为空");
	}
	/**
	 * 用户ID不传该 参数
	 */
	//@Test
	public void postNoDisturbModeSettingTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该 参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId为空");
	}
	/**
	 * 未开启勿扰模式传正确时间
	 */
	//@Test
	public void postNoDisturbModeSettingTestIsNotDisturbNoOpenTimeIsCorrect() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", "00:00:00");
		con.put("noDisturbEndTime", "01:00:00");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("未开启勿扰模式传正确时间" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 开启勿扰模式不传时间
	 */
	//@Test
	public void postNoDisturbModeSettingTestIsNotDisturbNoOpenTimeNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开启勿扰模式不传时间" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 未开启勿扰模式时间传错误格式
	 */
	//@Test
	public void postNoDisturbModeSettingTestIsNotDisturbNoOpenTimeIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", "120");
		con.put("noDisturbEndTime", "223");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("未开启勿扰模式时间传错误格式" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 设置勿扰模式参数传错误
	 */
	//@Test
	public void postNoDisturbModeSettingTestIsNotDisturbIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 3);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("设置勿扰模式参数传错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 设置勿扰模式参数传负数
	 */
	//@Test
	public void postNoDisturbModeSettingTestIsNotDisturbIsNegativeNumbe() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", -1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("设置勿扰模式参数传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 设置勿扰模式参数传小数
	 */
	////@Test
	public void postNoDisturbModeSettingTestIsNotDisturbIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1.23);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("设置勿扰模式参数传小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 设置勿扰模式参数传非法字符
	 */
	////@Test
	public void postNoDisturbModeSettingTestIsNotDisturbIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", "<@#^&*(_+>");
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("设置勿扰模式参数传非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 设置勿扰模式参数传空
	 */
	////@Test
	public void postNoDisturbModeSettingTestIsNotDisturbIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", "");
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("设置勿扰模式参数传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 设置勿扰模式参数传null
	 */
	////@Test
	public void postNoDisturbModeSettingTestIsNotDisturbIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", null);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("设置勿扰模式参数传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 设置勿扰模式不传该参数
	 */
	////@Test
	public void postNoDisturbModeSettingTestIsNotDisturbNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("设置勿扰模式不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 开启勿扰模式再次传开启值
	 */
	//@Test
	public void postNoDisturbModeSettingTestIsNotDisturbOpenedAgainOpen() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 0);
		con.put("noDisturbCreateTime", "00:00:00");
		con.put("noDisturbEndTime", "00:00:00");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开启勿扰模式再次传开启值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 开启勿扰模式再次传未开启值
	 */
	//@Test
	public void postNoDisturbModeSettingTestIsNotDisturbOpenedAgainNoOpen() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开启勿扰模式再次传未开启值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传");
	}
	/**
	 * 关闭勿扰模式再次传开启勿扰模式
	 */
	//@Test
	public void postNoDisturbModeSettingTestIsNotDisturbClosedAgainOpen() throws Exception {
		String updateSql = "UPDATE \"T_MOBILE_SET\" SET \"IS_NOT_DISTURB\"='0' WHERE USER_ID = '12495417'";
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", "23:00:00");
		con.put("noDisturbEndTime", "06:00:00");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("关闭勿扰模式再次传开启勿扰模式" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		list =MetaOper.read(selectSql,dataType);
		String isNotDisturb = list.get(0).get("IS_NOT_DISTURB").toString();
		String nct = list.get(0).get("NODISTURBER_CREATE_TIME") .toString();
		String net = list.get(0).get("NODISTURBER_END_TIME").toString();
		
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(isNotDisturb,equalTo( "1" ));
		assertThat(nct,equalTo( "23:00:00" ));
		assertThat(net,equalTo( "06:00:00" ));
	}
	/**
	 * 关闭勿扰模式再次传关闭勿扰模式
	 */
	////@Test
	public void postNoDisturbModeSettingTestIsNotDisturbClosedAgainClose() throws Exception {
		String updateSql = "UPDATE \"T_MOBILE_SET\" SET \"IS_NOT_DISTURB\"='0' WHERE USER_ID = '12495417'";
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 0);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("关闭勿扰模式再次传关闭勿扰模式" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 开始时间传错误格式
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbCreateTimeIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 0);
		con.put("noDisturbCreateTime", 156452);
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传错误格式" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 开始时间小于结束时间
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbCreateTimeLessNoDisturbEndTime() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", "00:00:00");
		con.put("noDisturbEndTime", "01:00:00");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间小于结束时间" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 开始时间大于结束时间
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbCreateTimeMoreNoDisturbEndTime() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime","01:00:00");
		con.put("noDisturbEndTime","00:00:00");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间大于结束时间" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 开始时间传时间戳
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbCreateTimeIsTimeStamp() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", "1377216000000");
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传时间戳" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 开始时间传年月日
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbCreateTimeIsYearMonthDay() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", "2018/5/4");
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传年月日" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 开始时间传时分秒
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbCreateTimeIsHourMinuteSec() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", "13:34:45");
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传时分秒" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		list =MetaOper.read(selectSql,dataType);
		String noDisturbCreateTime = list.get(0).get("NODISTURBER_CREATE_TIME").toString();
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(noDisturbCreateTime,equalTo( "13:34:45" ));
	}
	/**
	 * 开始时间传空格
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbCreateTimeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", " ");
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 开始时间传数字去掉中间格式
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbCreateTimeIsNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", "140912");
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传数字去掉中间格式" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 开始时间传空
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbCreateTimeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", "");
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 开始时间传null
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbCreateTimeIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", null);
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	/**
	 * 开始时间不传该参数
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbCreateTimeNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	/**
	 * 开始时间传负数
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbCreateTimeIsNegativeNumbe() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", "-23");
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	/**
	 * 开始时间传年月日最大值
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbCreateTimeIsYearMonthDayMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", "9999/12/31");
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传年月日最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	/**
	 * 开始时间传年月日最小时间
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbCreateTimeIsYearMonthDayLeast() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", "1/1/1");
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传年月日最小时间" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 开始时间传时分秒最大时间
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbCreateTimeIsHourMinSecMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", "23:59:59");
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传时分秒最大时间" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		list =MetaOper.read(selectSql,dataType);
		String noDisturbCreateTime = list.get(0).get("NODISTURBER_CREATE_TIME").toString();
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(noDisturbCreateTime,equalTo( "23:59:59" ));
	}
	/**
	 * 开始时间传时分秒最小时间
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbCreateTimeIsHourMinSecLeast() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", "00:00:00");
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传时分秒最小时间" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		list =MetaOper.read(selectSql,dataType);
		String noDisturbCreateTime = list.get(0).get("NODISTURBER_CREATE_TIME").toString();
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(noDisturbCreateTime,equalTo( "00:00:00" ));
	}
	/**
	 * 开始时间传年月日时分秒
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbCreateTimeIsYearMonDayHourMinSec() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", "2018/1/1 00:00:00");
		con.put("noDisturbEndTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("开始时间传年月日时分秒" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 结束时间传错误格式
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbEndTimeIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", 123456);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传错误格式" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 结束时间传时间戳
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbEndTimeIsTimeStamp() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", "1377216000000");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传时间戳" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 结束时间传年月日
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbEndTimeIsTimeYearMonthDay() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", "2018/12/12");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传年月日" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 结束时间传时分秒
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbEndTimeIsHourMinuteSec() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", "13:12:12");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传时分秒" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		list =MetaOper.read(selectSql,dataType);
		String noDisturbEndTime = list.get(0).get("NODISTURBER_END_TIME").toString();
		
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(noDisturbEndTime,equalTo( "13:12:12" ));
	}
	/**
	 * 结束时间传空格
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbEndTimeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", " ");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 结束时间传数字去掉中间格式
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbEndTimeIsNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", "152324");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传数字去掉中间格式" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 结束时间传空
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbEndTimeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", "");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 结束时间传null
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbEndTimeIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", null);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 结束时间不传该参数
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbEndTimeNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 结束时间传负数
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbEndTimeIsNegativeNumbe() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", "-562");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 结束时间传年月日最大值
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbEndTimeIsYearMonthDayMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", "9999/12/31");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传年月日最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 结束时间传年月日最小时间
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbEndTimeIsYearMonthDayLeast() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", "1/1/1");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传年月日最小时间" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 结束时间传时分秒最大时间
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbEndTimeIsHourMinSecMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", "23:59:59");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传时分秒最大时间" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		list =MetaOper.read(selectSql,dataType);
		String noDisturbEndTime = list.get(0).get("NODISTURBER_END_TIME").toString();
		
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(noDisturbEndTime,equalTo( "23:59:59" ));
	}
	/**
	 * 结束时间传时分秒最小时间
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbEndTimeIsHourMinSecLeast() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", "00:00:00");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传时分秒最小时间" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		list =MetaOper.read(selectSql,dataType);
		String noDisturbEndTime = list.get(0).get("NODISTURBER_END_TIME").toString();
		
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(noDisturbEndTime,equalTo( "00:00:00" ));
	}
	/**
	 * 结束时间传年月日时分秒
	 */
	//@Test
	public void postNoDisturbModeSettingTestNoDisturbEndTimeIsYearMonthDayHourMinSec() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("isNotDisturb", 1);
		con.put("noDisturbCreateTime", 0);
		con.put("noDisturbEndTime", "2018/12/12 01:00:00");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.0");
		head.put("cmd", "3712");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("结束时间传年月日时分秒" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	
		
	
}