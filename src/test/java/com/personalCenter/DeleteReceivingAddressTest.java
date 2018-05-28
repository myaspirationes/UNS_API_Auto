package com.personalCenter;

import static org.assertj.core.api.Assertions.assertThat;

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

public class DeleteReceivingAddressTest extends HttpUtil {
//删除收货地址
	String url = "/UU/addressinfo";
	String insertIntoSql = "INSERT INTO T_ADDRESS_INFO (\"ADDRESS_ID\",\"USER_ID\",\"CONTACT_NAME\", \"CONTACT_INFO\", \"PROVINCE_CODE\", \"CITY_CODE\", \"COUNTY_CODE\", \"DETAILED_ADDRESS\", \"IS_DEFAULT\", \"IS_DELETE\", \"MODIFY_TIME\", \"CREATE_TIME\", \"LABEL\", \"BRIEF_ADDRESS\") VALUES (T_ADDRESS_INFO_SEQ.nextval,'12495324', '测试君', '13524001140', '上海市', '上海市', '浦东新区', '会一直了', '0', '1', TO_DATE('2016-12-02 13:19:54', 'SYYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-02 10:59:05', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL)";
	String selectSql = "SELECT * FROM T_ADDRESS_INFO WHERE USER_ID = '12495324'";
	String deleteSql = "DELETE T_ADDRESS_INFO where USER_ID = '12495324'";
	String dataType = "perCenter81";
	JSONObject body;
	String uuid;
	String chcode;
	@BeforeClass
	public void beforeClass(){
		MetaOper.insert(insertIntoSql, dataType);
		LoginTest login = new LoginTest();
		try {
			body = login.getLoginTestChcodeBy177();
			uuid= (body.get("userId")).toString();
			chcode= (body.get("checkCode")).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postDeleteReceivingAddressTestCorrectParameter() throws Exception {
		List<Map<String,Object>> list ;
		list =MetaOper.read(selectSql,dataType);
		System.out.println("list======="+list);
		String addressId = list.get(0).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", addressId);
		con.put("userId", 12495324);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
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
	 * 地址ID 非此用户
	 */
	@Test
	public void postDeleteReceivingAddressTestAddressIdNotTheUser() throws Exception {
		String selectSql1 ="SELECT * FROM T_ADDRESS_INFO WHERE USER_ID <> '12495324'";
		List<Map<String,Object>> list ;
		list =MetaOper.read(selectSql1,dataType);
		System.out.println("list======="+list);
		String addressId = list.get(0).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", addressId);
		con.put("userId", 12495324);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址ID 非此用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("没有此地址");
			
	}
	/**
	 * 地址id错误信息
	 */
	//@Test
	public void postDeleteReceivingAddressTestAddressIdError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 1249545);
		con.put("userId", 12495324);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址id错误信息" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("没有此地址");
	}
	/**
	 * 地址id为String类型
	 */
	@Test
	public void postDeleteReceivingAddressTestAddressIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", "vfgdfg");
		con.put("userId", 12495324);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址id为String类型" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("addressId 校验失败,非法输入");
	}
	/**
	 * 地址id为小数
	 */
	@Test
	public void postDeleteReceivingAddressTestAddressIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12.4);
		con.put("userId", 12495324);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址id为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("addressId 校验失败,非法输入");
	}
	/**
	 * 地址id为负数
	 */
	@Test
	public void postDeleteReceivingAddressTestAddressIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", -124);
		con.put("userId", 12495324);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址id为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("addressId 校验失败,非法输入");
	}
	/**
	 * 地址id为0
	 */
	@Test
	public void postDeleteReceivingAddressTestAddressIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 0);
		con.put("userId", 12495324);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址id为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("addressId 校验失败,非法输入");
	}
	/**
	 * 地址id为空格
	 */
	@Test
	public void postDeleteReceivingAddressTestAddressIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", " ");
		con.put("userId", 12495324);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址id为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("addressId 校验失败,非法输入");
	}
	/**
	 * 地址id 为空
	 */
	@Test
	public void postDeleteReceivingAddressTestAddressIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", "");
		con.put("userId", 12495324);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址id 为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("addressId 校验失败,非法输入");
	}
	/**
	 * 地址id不传该参数
	 */
	//@Test
	public void postDeleteReceivingAddressTestAddressIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址id不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 地址id为超长
	 */
	//@Test
	public void postDeleteReceivingAddressTestAddressIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 45232555558L);
		con.put("userId", 12495324);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址id为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("没有此地址");
	}
	
	/**
	 * 用户ID错误
	 */
	@Test
	public void postDeleteReceivingAddressTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12495325);
		con.put("userId", 125321114);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId 校验失败,非法输入");
	}
	/**
	 * 用户id不存在
	 */
	@Test
	public void postDeleteReceivingAddressTestUserIdIsNotExist() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 124953245);
		con.put("userId", 1212495324);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id不存在" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId 校验失败,非法输入");
	}
	/**
	 * 用户ID超长
	 */
	@Test
	public void postDeleteReceivingAddressTestUserIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 124953245);
		con.put("userId", 124953242235L);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId 校验失败,非法输入");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postDeleteReceivingAddressTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 124953245);
		con.put("userId", "");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
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
		assertThat(head1.get("msg")).isEqualTo("userId 校验失败,非法输入");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postDeleteReceivingAddressTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 124953245);
		con.put("userId", " ");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
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
		assertThat(head1.get("msg")).isEqualTo("userId 校验失败,非法输入");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postDeleteReceivingAddressTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 124953245);
		con.put("userId", null);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
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
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 用户ID不提交
	 */
	//@Test
	public void postDeleteReceivingAddressTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 124953245);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不提交" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postDeleteReceivingAddressTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 124953245);
		con.put("userId", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
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
		assertThat(head1.get("msg")).isEqualTo("userId 校验失败,非法输入");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postDeleteReceivingAddressTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 124953245);
		con.put("userId", 12.69);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId 校验失败,非法输入");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postDeleteReceivingAddressTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 124953245);
		con.put("userId", -56);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4502");
		head.put("de", "2011-07-13 00:00:00");
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId 校验失败,非法输入");
	}
	@AfterClass
	public void afterClass(){
		/*List<Map<String,Object>> list ;
		list =MetaOper.read(selectSql,dataType);
		System.out.println("list======="+list);
		String userId = list.get(0).get("USER_ID").toString();*/
		
		MetaOper.delete(deleteSql, dataType);
		
	}
	
	
}