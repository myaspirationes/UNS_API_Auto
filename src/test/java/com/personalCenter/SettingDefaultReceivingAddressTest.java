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

public class SettingDefaultReceivingAddressTest extends HttpUtil {
//设置默认收货地址接口
	String url = "/UU/addressinfo";
	String dataType = "perCenter81";
	String insertIntoSql ="INSERT INTO T_ADDRESS_INFO (\"ADDRESS_ID\",\"USER_ID\",\"CONTACT_NAME\", \"CONTACT_INFO\", \"PROVINCE_CODE\", \"CITY_CODE\", \"COUNTY_CODE\", \"DETAILED_ADDRESS\", \"IS_DEFAULT\", \"IS_DELETE\", \"MODIFY_TIME\", \"CREATE_TIME\", \"LABEL\", \"BRIEF_ADDRESS\") VALUES (T_ADDRESS_INFO_SEQ.nextval,'12495324', '测试君', '13524001140', '上海市', '上海市', '浦东新区', '会一直了', '0', '1', TO_DATE('2016-12-02 13:19:54', 'SYYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-02 10:59:05', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL)";
	String insertIntoSql1 ="INSERT INTO T_ADDRESS_INFO (\"ADDRESS_ID\",\"USER_ID\",\"CONTACT_NAME\", \"CONTACT_INFO\", \"PROVINCE_CODE\", \"CITY_CODE\", \"COUNTY_CODE\", \"DETAILED_ADDRESS\", \"IS_DEFAULT\", \"IS_DELETE\", \"MODIFY_TIME\", \"CREATE_TIME\", \"LABEL\", \"BRIEF_ADDRESS\") VALUES (T_ADDRESS_INFO_SEQ.nextval,'12495324', '测试君', '13524001140', '上海市', '上海市', '浦东新区', '会一直了', '1', '1', TO_DATE('2016-12-02 13:19:54', 'SYYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-02 10:59:05', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL)";
	String updateSql = "UPDATE T_ADDRESS_INFO SET ADDRESS_ID=10709 where USER_ID = '12495324'";
	String selectSql = "SELECT * FROM T_ADDRESS_INFO WHERE USER_ID = 12495324";
	String deleteSql = "DELETE  T_ADDRESS_INFO WHERE USER_ID = '12495324'";
	List<Map<String,Object>> list ;
	JSONObject body;
	String uuid;
	String chcode;
	@BeforeClass
	public void  beforeClass(){
		LoginTest login = new LoginTest();
		try {
			body = login.getLoginTestChcodeBy177();
			uuid = (body.get("userId")).toString();
			chcode = (body.get("checkCode")).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSettingDefaultReceivingAddressTestCorrectParameter() throws Exception {
		
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertIntoSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String addressId = list.get(0).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", addressId);
		con.put("userId", uuid);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
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
	 * 地址ID非此用户
	 */
	@Test
	public void postSettingDefaultReceivingAddressTestAddressIdNotTheUser() throws Exception {
		String selectSql = "SELECT * FROM T_ADDRESS_INFO WHERE USER_ID <> 12495324";
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertIntoSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String addressId = list.get(0).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", addressId);
		con.put("userId", uuid);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
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
		System.out.println("地址ID非此用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
			
	}
	/**
	 * 地址id错误信息
	 */
	@Test
	public void postSettingDefaultReceivingAddressTestAddressIdError() throws Exception {
		String selectSql = "SELECT * FROM T_ADDRESS_INFO WHERE USER_ID <> 12495324";
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertIntoSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 5694521);
		con.put("userId", uuid);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
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
		assertThat(head1.get("msg")).isEqualTo("失败");
			
	}
	/**
	 * 地址id为String类型
	 */
	@Test
	public void postSettingDefaultReceivingAddressTestAddressIdIsString() throws Exception {
		
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertIntoSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", "ghdgdfgdg");
		con.put("userId", uuid);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
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
	public void postSettingDefaultReceivingAddressTestAddressIdIsDecimal() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertIntoSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 12.36);
		con.put("userId", uuid);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
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
	public void postSettingDefaultReceivingAddressTestAddressIdIsNegativeNumber() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertIntoSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", -12465);
		con.put("userId", uuid);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
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
	public void postSettingDefaultReceivingAddressTestAddressIdIsZero() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertIntoSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 0);
		con.put("userId", uuid);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
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
	public void postSettingDefaultReceivingAddressTestAddressIdIsSpace() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertIntoSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", " ");
		con.put("userId", uuid);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
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
	public void postSettingDefaultReceivingAddressTestAddressIdIsEmpty() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertIntoSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", "");
		con.put("userId", uuid);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
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
		System.out.println("地址id为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("addressId 校验失败,非法输入");
			
	}
	/**
	 * 地址id不传该参数
	 */
	@Test
	public void postSettingDefaultReceivingAddressTestAddressIdNonSubmissionParameters() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertIntoSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
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
	@Test
	public void postSettingDefaultReceivingAddressTestAddressIdIsLong() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertIntoSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", 5645542132545565655L);
		con.put("userId", uuid);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
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
		assertThat(head1.get("msg")).isEqualTo("失败");
			
	}
	/**
	 * 用户ID错误
	 */
	@Test
	public void postSettingDefaultReceivingAddressTestUserIdIsError() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertIntoSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String addressId = list.get(0).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", addressId);
		con.put("userId", 1324566);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
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
		assertThat(head1.get("msg")).isEqualTo("失败");
			
	}
	/**
	 * 用户ID用户未登录
	 */
	@Test
	public void postSettingDefaultReceivingAddressTestUserIdNotLoggedIn() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertIntoSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String addressId = list.get(0).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", addressId);
		con.put("userId", 13245633);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
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
		System.out.println("用户ID用户未登录" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
			
	}
	/**
	 * 用户ID超长
	 */
	@Test
	public void postSettingDefaultReceivingAddressTestUserIdIsLong() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertIntoSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String addressId = list.get(0).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", addressId);
		con.put("userId", "5645542132123456489555555555555555555555555555555");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
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
	 * 用户ID为0
	 */
	@Test
	public void postSettingDefaultReceivingAddressTestUserIdIsZero() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertIntoSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String addressId = list.get(0).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", addressId);
		con.put("userId", 0);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
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
	 * 用户ID为负数
	 */
	@Test
	public void postSettingDefaultReceivingAddressTestUserIdIsNegativeNumber() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertIntoSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String addressId = list.get(0).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", addressId);
		con.put("userId", -12495324);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
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
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postSettingDefaultReceivingAddressTestUserIdIsDecimal() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertIntoSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String addressId = list.get(0).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", addressId);
		con.put("userId", 12.45);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
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
	 * 用户ID为空
	 */
	@Test
	public void postSettingDefaultReceivingAddressTestUserIdIsEmpty() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertIntoSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String addressId = list.get(0).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", addressId);
		con.put("userId", "");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
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
	public void postSettingDefaultReceivingAddressTestUserIdIsSpace() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertIntoSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String addressId = list.get(0).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", addressId);
		con.put("userId", " ");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
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
	 * 用户ID存在非法字符
	 */
	@Test
	public void postSettingDefaultReceivingAddressTestUserIdIllegalCharacters() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertIntoSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String addressId = list.get(0).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", addressId);
		con.put("userId", "<@#^*)_+>");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
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
		System.out.println("用户ID存在非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId 校验失败,非法输入");
			
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postSettingDefaultReceivingAddressTestUserIdIsNull() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertIntoSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String addressId = list.get(0).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", addressId);
		con.put("userId", null);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
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
	 * 用户ID不传该参数
	 */
	@Test
	public void postSettingDefaultReceivingAddressTestUserIdNonSubmissionParameters() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertIntoSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String addressId = list.get(0).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", addressId);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
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
		System.out.println("用户ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
			
	}
	/**
	 * 设置多个默认地址
	 */
	@Test
	public void postSettingDefaultReceivingAddressTestSetManyDefaultAddress() throws Exception {				
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertIntoSql, dataType);
		MetaOper.insert(insertIntoSql1, dataType);
		list=MetaOper.read(selectSql, dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", addressId);
		con.put("userId", uuid);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
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
		System.out.println("设置多个默认地址" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
			
	}
	/**
	 * 设置地址已是默认地址
	 */
	@Test
	public void postSettingDefaultReceivingAddressTestSetAddressExisted() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertIntoSql, dataType);
		MetaOper.insert(insertIntoSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String addressId = list.get(0).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", addressId);
		con.put("userId", uuid);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("ver", "1.2.0");
		head.put("cmd", "4501");
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
		System.out.println("设置地址已是默认地址" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
			
	}
	
	
	
	
}