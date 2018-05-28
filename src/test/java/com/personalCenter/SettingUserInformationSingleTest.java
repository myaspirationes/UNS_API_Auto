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
import com.example.RandomUtils;

public class SettingUserInformationSingleTest extends HttpUtil {
//设置用户信息(单个)接口
	String url = "/UU/user";
	RandomUtils ru = new RandomUtils();
	String updateSql = "UPDATE  T_USERINFO SET UBAR_IS_DEFAULT = '1' WHERE USER_ID = 12495396";
	String dataType = "perCenter81";
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
	public void postSettingUserInformationSingleTestCorrectParameter() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
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
	 * 用户为未登录
	 */
	//@Test
	public void postSettingUserInformationSingleTestUserIdNotLoggedIn() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12494324);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
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
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("微度号只可以修改一次");
	}
	/**
	 * 用户为错误
	 */
	//@Test
	public void postSettingUserInformationSingleTestUserIdIsError() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "124A456");
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
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
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 用户ID存在小数
	 */
	//@Test
	public void postSettingUserInformationSingleTestUserIdIsDecimal() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12.495218);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
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
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 用户ID存在非法字符
	 */
	//@Test
	public void postSettingUserInformationSingleTestIsIllegalCharacters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "<#$&*+>");
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
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
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 用户ID存在负数
	 */
	//@Test
	public void postSettingUserInformationSingleTestUserIdIsNegativeNumbe() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -12495324);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
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
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 用户ID为0
	 */
	//@Test
	public void postSettingUserInformationSingleTestUserIdIsZero() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
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
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 用户ID为String
	 */
	//@Test
	public void postSettingUserInformationSingleTestUserIdIsString() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "dfggghsds");
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
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
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 用户ID为空
	 */
	//@Test
	public void postSettingUserInformationSingleTestUserIdIsEmpty() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
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
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 用户ID为空格
	 */
	//@Test
	public void postSettingUserInformationSingleTestUserIdIsSpace() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
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
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 用户ID为null
	 */
	//@Test
	public void postSettingUserInformationSingleTestUserIdIsNull() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
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
	 * 用户ID不传该 参数
	 */
	//@Test
	public void postSettingUserInformationSingleTestUserIdNonSubmissionParameters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
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
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 昵称超长
	 */
	//@Test
	public void postSettingUserInformationSingleTestNickNameIsLong() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even分公司分管但是经过核查v虚构的2222222222222222222222222222222222222222222222222222222222222身份梵蒂冈地方豆腐干的");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("昵称的长度不能超过64位");
	}
	/**
	 * 昵称为非法字符
	 */
	//@Test
	public void postSettingUserInformationSingleTestNickNameIsIllegalCharacters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "<@%&*>");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 昵称为空
	 */
	//@Test
	public void postSettingUserInformationSingleTestNickNameIsEmpty() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 昵称为空格
	 */
	//@Test
	public void postSettingUserInformationSingleTestNickNameIsSpace() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", " ");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 昵称为null
	 */
	//@Test
	public void postSettingUserInformationSingleTestNickNameIsNull() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", null);
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 昵称为不传该参数
	 */
	//@Test
	public void postSettingUserInformationSingleTestNickNameNonSubmissionParameters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * u吧号超长
	 */
	//@Test
	public void postSettingUserInformationSingleTestUBarIdIsLong() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "DreamEven1555555675674565");
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("u吧号超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("微度号必须以字母开头，长度4到20之间");
	}
	/**
	 * u吧号为非法字符
	 */
	//@Test
	public void postSettingUserInformationSingleTestUBarIdIsIllegalCharacters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "<@#%&*>");
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("u吧号为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("微度号必须以字母开头，长度4到20之间");
	}
	/**
	 * u吧号为空
	 */
	//@Test
	public void postSettingUserInformationSingleTestUBarIdIsEmpty() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "");
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("u吧号为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("微度号必须以字母开头，长度4到20之间");
	}
	/**
	 * u吧号为空格
	 */
	//@Test
	public void postSettingUserInformationSingleTestUBarIdIsSpace() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", " ");
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("u吧号为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("微度号必须以字母开头，长度4到20之间");
	}
	
	/**
	 * u吧号为null
	 */
	//@Test
	public void postSettingUserInformationSingleTestUBarIdIsNull() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", null);
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("u吧号为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * u吧号为不传该参数
	 */
	//@Test
	public void postSettingUserInformationSingleTestUBarIdNonSubmissionParameters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("u吧号为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 性别传0男
	 */
	//@Test
	public void postSettingUserInformationSingleTestGenderIsZero() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 0);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别传0男" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		String sesql0 = "SELECT * FROM T_USERINFO WHERE USER_ID = 12495324";
		list = MetaOper.read(sesql0, dataType);
		String gender = list.get(0).get("GENDER").toString();
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(gender,equalTo("0"));
	}
	
	/**
	 * 性别传1女
	 */
	//@Test
	public void postSettingUserInformationSingleTestGenderIsOne() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别传1女" + post);
		JSONObject head1 = (JSONObject) post.get("head");
		String sesql0 = "SELECT * FROM T_USERINFO WHERE USER_ID = 12495324";
		list = MetaOper.read(sesql0, dataType);
		String gender = list.get(0).get("GENDER").toString();
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
		assertThat(gender,equalTo( "1" ));
	}
	/**
	 * 性别传错误
	 */
	//@Test
	public void postSettingUserInformationSingleTestGenderIsError() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 5);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别传错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("微度号只可以修改一次");
	}
	/**
	 * 性别传小数
	 */
	//@Test
	public void postSettingUserInformationSingleTestGenderIsDecimal() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1.23);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别传小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("微度号只可以修改一次");
	}
	/**
	 * 性别传负数
	 */
	//@Test
	public void postSettingUserInformationSingleTestGenderIsNegativeNumbe() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", -1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("微度号只可以修改一次");
	}
	/**
	 * 性别传String
	 */
	//@Test
	public void postSettingUserInformationSingleTestGenderIsString() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", "hjkhj");
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别传String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("微度号只可以修改一次");
	}
	/**
	 * 性别传最大值
	 */
	//@Test
	public void postSettingUserInformationSingleTestGenderIsMax() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 999999999);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别传最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("微度号只可以修改一次");
	}
	/**
	 * 性别传空
	 */
	//@Test
	public void postSettingUserInformationSingleTestGenderIsEmpty() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", "");
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("微度号只可以修改一次");
	}
	/**
	 * 性别传空格
	 */
	//@Test
	public void postSettingUserInformationSingleTestGenderIsSpace() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", " ");
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("微度号只可以修改一次");
	}
	/**
	 * 性别传null
	 */
	//@Test
	public void postSettingUserInformationSingleTestGenderIsNull() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", null);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 性别不传该参数
	 */
	//@Test
	public void postSettingUserInformationSingleTestGenderNonSubmissionParameters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
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
	 * 地区超长
	 */
	//@Test
	public void postSettingUserInformationSingleTestCityAddressIsLong() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "3100005353353534324236564563453453");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地区超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("微度号只可以修改一次");
	}
	/**
	 * 地区为非法字符
	 */
	//@Test
	public void postSettingUserInformationSingleTestCityAddressIsIllegalCharacters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "<#$%&*>");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地区为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("微度号只可以修改一次");
	}
	/**
	 * 地区为空
	 */
	//@Test
	public void postSettingUserInformationSingleTestCityAddressIsEmpty() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地区为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("微度号只可以修改一次");
	}
	/**
	 * 地区为空格
	 */
	//@Test
	public void postSettingUserInformationSingleTestCityAddressIsSpace() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", " ");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地区为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("微度号只可以修改一次");
	}
	
	/**
	 * 地区为null
	 */
	//@Test
	public void postSettingUserInformationSingleTestCityAddressIsNull() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", null);
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地区为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地区为不传该参数
	 */
	//@Test
	public void postSettingUserInformationSingleTestCityAddressNonSubmissionParameters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地区为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 公司地址超长
	 */
	//@Test
	public void postSettingUserInformationSingleTestCompanyAddressIsLong() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼14565623658866532312128652324478452213上南路3855号如日商务园区11号楼5楼14565623658866532312128652324478452213上南路3855号如日商务园区11号楼5楼14565623658866532312128652324478452213上南路3855号如日商务园区11号楼5楼14565623658866532312128652324478452213上南路3855号如日商务园区11号楼5楼14565623658866532312128652324478452213");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公司地址超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("微度号只可以修改一次");
	}
	/**
	 * 公司地址为非法字符
	 */
	//@Test
	public void postSettingUserInformationSingleTestCompanyAddressIsIllegalCharacters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "<#$^%(>");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公司地址为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 公司地址为空
	 */
	////@Test
	public void postSettingUserInformationSingleTestCompanyAddressIsEmpty() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公司地址为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 公司地址为空格
	 */
	////@Test
	public void postSettingUserInformationSingleTestCompanyAddressIsSpace() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", " ");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公司地址为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 公司地址为null
	 */
	////@Test
	public void postSettingUserInformationSingleTestCompanyAddressIsNull() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", null);
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公司地址为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 公司地址为不传该参数
	 */
	////@Test
	public void postSettingUserInformationSingleTestCompanyAddressNonSubmissionParameters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公司地址为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 家庭住址为非法字符
	 */
	////@Test
	public void postSettingUserInformationSingleTestFamilyAddressIsIllegalCharacters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "<@$&*_>");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("家庭住址为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 家庭住址为空
	 */
	////@Test
	public void postSettingUserInformationSingleTestFamilyAddressIsEmpty() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("家庭住址为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 家庭住址为空格
	 */
	////@Test
	public void postSettingUserInformationSingleTestFamilyAddressIsSpace() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", " ");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("家庭住址为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 家庭住址为null
	 */
	////@Test
	public void postSettingUserInformationSingleTestFamilyAddressIsNull() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", null);
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("家庭住址为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 家庭住址为不传该参数
	 */
	////@Test
	public void postSettingUserInformationSingleTestFamilyAddressNonSubmissionParameters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
	
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("家庭住址为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 邮箱超长
	 */
	////@Test
	public void postSettingUserInformationSingleTestEmailIsLong() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "15171154654312151711546543121517115465431215171154654312@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("邮箱超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 邮箱为非法字符
	 */
	////@Test
	public void postSettingUserInformationSingleTestEmailIsIllegalCharacters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "<@$%@^*+>");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("邮箱为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("邮箱格式不正确");
	}
	/**
	 * 邮箱为空
	 */
	////@Test
	public void postSettingUserInformationSingleTestEmailIsEmpty() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("邮箱为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
		
	/**
	 * 邮箱为空格
	 */
	////@Test
	public void postSettingUserInformationSingleTestEmailIsSpace() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", " ");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("邮箱为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("邮箱格式不正确");
	}
		
	/**
	 * 邮箱为null
	 */
	////@Test
	public void postSettingUserInformationSingleTestEmailIsNull() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", null);
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("邮箱为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
		
	/**
	 * 邮箱为不传该参数
	 */
	////@Test
	public void postSettingUserInformationSingleTestEmailNonSubmissionParameters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("邮箱为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
		
	/**
	 * 英文名超长
	 */
	////@Test
	public void postSettingUserInformationSingleTestEnglishNameIsLong() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Evendfgsdfdfhghgjhjhkjgdfgyyttvcx");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("英文名超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("英文名的长度不能超过32位");
	}
		
	/**
	 * 英文名为非法字符
	 */
	////@Test
	public void postSettingUserInformationSingleTestEnglishNameIsIllegalCharacters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "<@$^&_>");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("英文名为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 英文名为空
	 */
	////@Test
	public void postSettingUserInformationSingleTestEnglishNameIsEmpty() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("英文名为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 英文名为空格
	 */
	////@Test
	public void postSettingUserInformationSingleTestEnglishNameIsSpace() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", " ");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("英文名为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 英文名为null
	 */
	////@Test
	public void postSettingUserInformationSingleTestEnglishNameIsNull() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", null);
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("英文名为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 英文名为不传该参数
	 */
	////@Test
	public void postSettingUserInformationSingleTestEnglishNameIsNonSubmissionParameters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
	
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("英文名为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 个性签名超长
	 */
	////@Test
	public void postSettingUserInformationSingleTestsiGnatureIsLong() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性风格的后果脚后跟艰苦艰苦联合国环境感豆腐干豆腐干豆腐干地方的风格的广告翻跟斗广泛大概对方身上仿佛");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("个性签名超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("个性签名的长度不能超过30位");
	}
	/**
	 * 个性签名为非法字符
	 */
	////@Test
	public void postSettingUserInformationSingleTestsiGnatureIsIllegalCharacters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "<@$^&*+>");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("个性签名为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 个性签名为空
	 */
	////@Test
	public void postSettingUserInformationSingleTestsiGnatureIsEmpty() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("个性签名为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 个性签名为空格
	 */
	////@Test
	public void postSettingUserInformationSingleTestsiGnatureIsSpace() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", " ");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("个性签名为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 个性签名为null
	 */
	////@Test
	public void postSettingUserInformationSingleTestsiGnatureIsNull() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", null);
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("个性签名为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 个性签名为不传该参数
	 */
	////@Test
	public void postSettingUserInformationSingleTestNonSubmissionParameters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("个性签名为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 我的社交超长
	 */
	////@Test
	public void postSettingUserInformationSingleTestMySocialIsLong() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125的古代诗歌风格非官方的郭德纲郭德纲地方梵蒂冈法国地方官梵蒂冈");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("我的社交超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("我的社交长度超过16位");
	}
	/**
	 * 我的社交为非法字符
	 */
	////@Test
	public void postSettingUserInformationSingleTestMySocialIsIllegalCharacters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "<@#&)+>");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("我的社交为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("我的社交输入的不是数字");
	}
	/**
	 * 我的社交为空
	 */
	////@Test
	public void postSettingUserInformationSingleTestmySocialIsEmpty() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("我的社交为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 我的社交为空格
	 */
	////@Test
	public void postSettingUserInformationSingleTestmySocialIsSpace() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", " ");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("我的社交为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("我的社交输入的不是数字");
	}
	/**
	 * 我的社交为null
	 */
	////@Test
	public void postSettingUserInformationSingleTestMySocialIsNull() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", null);
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("我的社交为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 我的社交为不传该参数
	 */
	////@Test
	public void postSettingUserInformationSingleTestMySocialNonSubmissionParameters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
	
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("我的社交为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 头像url超长
	 */
	////@Test
	public void postSettingUserInformationSingleTestHeadUrlIsLong() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl", "http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E5%9B%BE%E7%89%87&hs=0&pn=0&spn=0&di=51259042670&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=768609259%2C3589793470&os=1132863611%2C2811260572&simid=0%2C0&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01080755c1edaf32f87528a18e9840.jpg%40900w_1l_2o_100sh.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bzv55s_z%26e3Bv54_z%26e3BvgAzdH3Fo56hAzdH3FZMTIcNzMnODQ%3D_z%26e3Bip4s&gsm=0&islist=&querylist=");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("头像url超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("头像地址不能超过230位");
	}
	/**
	 * 头像url为非法字符
	 */
	////@Test
	public void postSettingUserInformationSingleTestHeadUrlIsIllegalCharacters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl", "<@$^*_>");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("头像url为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 头像url为空
	 */
	////@Test
	public void postSettingUserInformationSingleTestHeadUrlIsNull() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("头像url为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 头像url为空格
	 */
	////@Test
	public void postSettingUserInformationSingleTestHeadUrlIsSpace() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl"," ");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("头像url为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 头像url为不传该参数
	 */
	////@Test
	public void postSettingUserInformationSingleTestHeadUrlNonSubmissionParameters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("头像url为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 主机域名超长
	 */
	////@Test
	public void postSettingUserInformationSingleTestHostUrlIsLong() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://www.baidu.com/s?word=%E5%9B%BE%E7%89%87&tn=site888_3_pg&lm=-1&ssl_s=2&ssl_c=ssl1_16349c76bb1&prec=0");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("主机域名超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("主机域名不能超过60位");
	}
	/**
	 * 主机域名为非法字符
	 */
	////@Test
	public void postSettingUserInformationSingleTestHostUrlIsIllegalCharacters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "<%#@(+>");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("主机域名为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 主机域名为空
	 */
	////@Test
	public void postSettingUserInformationSingleTestHostUrlIsEmpty() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("主机域名为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 主机域名为空格
	 */
	////@Test
	public void postSettingUserInformationSingleTestHostUrlIsSpace() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", " ");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("主机域名为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 主机域名为null
	 */
	////@Test
	public void postSettingUserInformationSingleTestHostUrlIsNull() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", null);
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("主机域名为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 主机域名为不传该参数
	 */
	////@Test
	public void postSettingUserInformationSingleTestHostUrlNonSubmissionParameters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("主机域名为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户头像id超长
	 */
	////@Test
	public void postSettingUserInformationSingleTestHeadFileIdIsLong() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", "1233241452547689765442352345245636776856890689067896734562");
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户头像id超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-2);
		assertThat(head1.get("msg")).isEqualTo("数据库执行异常！");
	}
	/**
	 * 用户头像id为非法字符
	 */
	////@Test
	public void postSettingUserInformationSingleTestHeadFileIdIsIllegalCharacters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", "<@#$)+>");
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户头像id为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("头像id不是数字");
	}
	/**
	 * 用户头像id为空
	 */
	////@Test
	public void postSettingUserInformationSingleTestHeadFileIdIsEmpty() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", "");
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户头像id为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("头像id不是数字");
	}
	/**
	 * 用户头像ID为空格
	 */
	////@Test
	public void postSettingUserInformationSingleTestHeadFileIdIsSpace() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", " ");
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户头像ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("头像id不是数字");
	}
	/**
	 * 用户头像ID为null
	 */
	////@Test
	public void postSettingUserInformationSingleTestHeadFileIdIsNull() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", null);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户头像ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户头像ID为小数
	 */
	////@Test
	public void postSettingUserInformationSingleTestHeadFileIdIsDecimal() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10.001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户头像ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("头像id不是数字");
	}
	/**
	 * 用户头像ID为0
	 */
	////@Test
	public void postSettingUserInformationSingleTestHeadFileIdIsZero() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 0);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户头像ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户头像ID为负数
	 */
	////@Test
	public void postSettingUserInformationSingleTestHeadFileIdIsNegativeNumbe() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", -1002);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户头像ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("头像id不是数字");
	}
	/**
	 * 用户头像ID为不传该参数
	 */
	////@Test
	public void postSettingUserInformationSingleTestHeadFileIdNonSubmissionParameters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户头像ID为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态封面文件id超长
	 */
	////@Test
	public void postSettingUserInformationSingleTestDynamicFileIdIsLong() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", "10001100011000110001");
		con.put("dynamicFileId", 100021454566L);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态封面文件id超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-2);
		assertThat(head1.get("msg")).isEqualTo("数据库执行异常！");
	}
	/**
	 * 动态封面文件id为非法字符
	 */
	////@Test
	public void postSettingUserInformationSingleTestDynamicFileIdIsIllegalCharacters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", "<#%&*)>");
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态封面文件id为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("动态封面id不是数字");
	}
	/**
	 * 动态封面文件id为空
	 */
	////@Test
	public void postSettingUserInformationSingleTestDynamicFileIdIsEmpty() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", "");
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态封面文件id为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("动态封面id不是数字");
	}
	/**
	 * 动态封面文件ID为空格
	 */
	////@Test
	public void postSettingUserInformationSingleTestDynamicFileIdIsSpace() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", " ");
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态封面文件ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("动态封面id不是数字");
	}
	/**
	 * 动态封面文件ID为null
	 */
	////@Test
	public void postSettingUserInformationSingleTestDynamicFileIdIsNull() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", null);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态封面文件ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态封面文件ID为小数
	 */
	////@Test
	public void postSettingUserInformationSingleTestDynamicFileIdIsDecimal() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", "10.002");
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态封面文件ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("动态封面id不是数字");
	}
	/**
	 * 动态封面文件ID为0
	 */
	////@Test
	public void postSettingUserInformationSingleTestDynamicFileIdIsZero() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 0);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态封面文件ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态封面文件ID为负数
	 */
	////@Test
	public void postSettingUserInformationSingleTestDynamicFileIdIsNegativeNumbe() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", -10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态封面文件ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("动态封面id不是数字");
	}
	/**
	 * 动态封面文件ID为不传该参数
	 */
	////@Test
	public void postSettingUserInformationSingleTestDynamicFileIdNonSubmissionParameters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("nickName", "梦想家Even");
		con.put("uBarId", "D"+ru.getRandomNum(8)+"E"+ru.getRandomNum(6));
		con.put("gender", 1);
		con.put("cityAddress", "310000");
		con.put("companyAddress", "上南路3855号如日商务园区11号楼5楼");
		con.put("familyAddress", "闵行区富砾路259弄38号");
		con.put("email", "13774323645@163.com");
		con.put("englishName", "Even");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
	
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", uuid);
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态封面文件ID为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	
	
	
}