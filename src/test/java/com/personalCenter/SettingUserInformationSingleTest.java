package com.personalCenter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;

public class SettingUserInformationSingleTest extends HttpUtil {
//设置用户信息(单个)接口
	String url = "/UU/user";
	

	/**
	 * 提交正确参数
	 */
	@Test
	public void postSettingUserInformationSingleTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户为未登录
	 */
	@Test
	public void postSettingUserInformationSingleTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户为未登录" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户为错误
	 */
	@Test
	public void postSettingUserInformationSingleTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 1249521856);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID存在小数
	 */
	@Test
	public void postSettingUserInformationSingleTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12.495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID存在小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID存在非法字符
	 */
	@Test
	public void postSettingUserInformationSingleTestIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "<#$&*+>");
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID存在非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID存在负数
	 */
	@Test
	public void postSettingUserInformationSingleTestUserIdIsNegativeNumbe() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID存在负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postSettingUserInformationSingleTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postSettingUserInformationSingleTestUserIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "dfggghsds");
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postSettingUserInformationSingleTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postSettingUserInformationSingleTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postSettingUserInformationSingleTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID不传该 参数
	 */
	@Test
	public void postSettingUserInformationSingleTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该 参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 昵称超长
	 */
	@Test
	public void postSettingUserInformationSingleTestNickNameIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工分公司分管但是经过核查v虚构的身份梵蒂冈地方豆腐干的");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 昵称为非法字符
	 */
	@Test
	public void postSettingUserInformationSingleTestNickNameIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "<@%&*>");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 昵称为空
	 */
	@Test
	public void postSettingUserInformationSingleTestNickNameIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 昵称为空格
	 */
	@Test
	public void postSettingUserInformationSingleTestNickNameIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", " ");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 昵称为null
	 */
	@Test
	public void postSettingUserInformationSingleTestNickNameIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", null);
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 昵称为不传该参数
	 */
	@Test
	public void postSettingUserInformationSingleTestNickNameNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * u吧号超长
	 */
	@Test
	public void postSettingUserInformationSingleTestUBarIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500555555675674565");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("u吧号超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * u吧号为非法字符
	 */
	@Test
	public void postSettingUserInformationSingleTestUBarIdIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "<@#%&*>");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("u吧号为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * u吧号为空
	 */
	@Test
	public void postSettingUserInformationSingleTestUBarIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("u吧号为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * u吧号为空格
	 */
	@Test
	public void postSettingUserInformationSingleTestUBarIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", " ");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("u吧号为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	/**
	 * u吧号为null
	 */
	@Test
	public void postSettingUserInformationSingleTestUBarIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", null);
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("u吧号为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	/**
	 * u吧号为不传该参数
	 */
	@Test
	public void postSettingUserInformationSingleTestUBarIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("u吧号为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	/**
	 * 性别传0男
	 */
	@Test
	public void postSettingUserInformationSingleTestGenderIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 0);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别传0男" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	/**
	 * 性别传1女
	 */
	@Test
	public void postSettingUserInformationSingleTestGenderIsOne() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别传1女" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 性别传错误
	 */
	@Test
	public void postSettingUserInformationSingleTestGenderIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 5);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别传错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 性别传小数
	 */
	@Test
	public void postSettingUserInformationSingleTestGenderIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1.23);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别传小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 性别传负数
	 */
	@Test
	public void postSettingUserInformationSingleTestGenderIsNegativeNumbe() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 性别传String
	 */
	@Test
	public void postSettingUserInformationSingleTestGenderIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", "hjkhj");
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别传String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 性别传最大值
	 */
	@Test
	public void postSettingUserInformationSingleTestGenderIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 999999999);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别传最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 性别传空
	 */
	@Test
	public void postSettingUserInformationSingleTestGenderIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", "");
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 性别传空格
	 */
	@Test
	public void postSettingUserInformationSingleTestGenderIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", " ");
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 性别传null
	 */
	@Test
	public void postSettingUserInformationSingleTestGenderIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", null);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 性别不传该参数
	 */
	@Test
	public void postSettingUserInformationSingleTestGenderNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 地区超长
	 */
	@Test
	public void postSettingUserInformationSingleTestCityAddressIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "100005353353534324236564563453453");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地区超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 地区为非法字符
	 */
	@Test
	public void postSettingUserInformationSingleTestCityAddressIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "<#$%&*>");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地区为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 地区为空
	 */
	@Test
	public void postSettingUserInformationSingleTestCityAddressIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地区为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 地区为空格
	 */
	@Test
	public void postSettingUserInformationSingleTestCityAddressIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", " ");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地区为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	/**
	 * 地区为null
	 */
	@Test
	public void postSettingUserInformationSingleTestCityAddressIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", null);
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地区为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 地区为不传该参数
	 */
	@Test
	public void postSettingUserInformationSingleTestCityAddressNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地区为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 公司地址超长
	 */
	@Test
	public void postSettingUserInformationSingleTestCompanyAddressIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "2000014565623658866532312128652324478452213");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公司地址超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 公司地址为非法字符
	 */
	@Test
	public void postSettingUserInformationSingleTestCompanyAddressIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "<#$^%(>");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公司地址为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 公司地址为空
	 */
	@Test
	public void postSettingUserInformationSingleTestCompanyAddressIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公司地址为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 公司地址为空格
	 */
	@Test
	public void postSettingUserInformationSingleTestCompanyAddressIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", " ");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公司地址为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 公司地址为null
	 */
	@Test
	public void postSettingUserInformationSingleTestCompanyAddressIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", null);
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公司地址为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 公司地址为不传该参数
	 */
	@Test
	public void postSettingUserInformationSingleTestCompanyAddressNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公司地址为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 家庭住址为非法字符
	 */
	@Test
	public void postSettingUserInformationSingleTestFamilyAddressIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "<@$&*_>");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("家庭住址为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 家庭住址为空
	 */
	@Test
	public void postSettingUserInformationSingleTestFamilyAddressIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("家庭住址为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 家庭住址为空格
	 */
	@Test
	public void postSettingUserInformationSingleTestFamilyAddressIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", " ");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("家庭住址为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 家庭住址为null
	 */
	@Test
	public void postSettingUserInformationSingleTestFamilyAddressIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", null);
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("家庭住址为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 家庭住址为不传该参数
	 */
	@Test
	public void postSettingUserInformationSingleTestFamilyAddressNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
	
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("家庭住址为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 邮箱超长
	 */
	@Test
	public void postSettingUserInformationSingleTestEmailIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171154654312@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("邮箱超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 邮箱为非法字符
	 */
	@Test
	public void postSettingUserInformationSingleTestEmailIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "<@$%@^*+>");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("邮箱为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 邮箱为空
	 */
	@Test
	public void postSettingUserInformationSingleTestEmailIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("邮箱为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
		
	/**
	 * 邮箱为空格
	 */
	@Test
	public void postSettingUserInformationSingleTestEmailIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", " ");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("邮箱为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
		
	/**
	 * 邮箱为null
	 */
	@Test
	public void postSettingUserInformationSingleTestEmailIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", null);
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("邮箱为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
		
	/**
	 * 邮箱为不传该参数
	 */
	@Test
	public void postSettingUserInformationSingleTestEmailNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("邮箱为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
		
	/**
	 * 英文名超长
	 */
	@Test
	public void postSettingUserInformationSingleTestEnglishNameIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jackdfgsdfdfhghgjhjhkjgdfgyyttvcx");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("英文名超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
		
	/**
	 * 英文名为非法字符
	 */
	@Test
	public void postSettingUserInformationSingleTestEnglishNameIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
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
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("英文名为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 英文名为空
	 */
	@Test
	public void postSettingUserInformationSingleTestEnglishNameIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
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
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("英文名为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 英文名为空格
	 */
	@Test
	public void postSettingUserInformationSingleTestEnglishNameIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
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
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("英文名为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 英文名为null
	 */
	@Test
	public void postSettingUserInformationSingleTestEnglishNameIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
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
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("英文名为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 英文名为不传该参数
	 */
	@Test
	public void postSettingUserInformationSingleTestEnglishNameIsNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
	
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("英文名为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 个性签名超长
	 */
	@Test
	public void postSettingUserInformationSingleTestsiGnatureIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性风格的后果脚后跟艰苦艰苦联合国环境感豆腐干豆腐干豆腐干地方的风格的广告翻跟斗广泛大概对方身上仿佛");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("个性签名超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 个性签名为非法字符
	 */
	@Test
	public void postSettingUserInformationSingleTestsiGnatureIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "<@$^&*+>");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("个性签名为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 个性签名为空
	 */
	@Test
	public void postSettingUserInformationSingleTestsiGnatureIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("个性签名为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 个性签名为空格
	 */
	@Test
	public void postSettingUserInformationSingleTestsiGnatureIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", " ");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("个性签名为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 个性签名为null
	 */
	@Test
	public void postSettingUserInformationSingleTestsiGnatureIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", null);
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("个性签名为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 个性签名为不传该参数
	 */
	@Test
	public void postSettingUserInformationSingleTestNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("个性签名为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 我的社交超长
	 */
	@Test
	public void postSettingUserInformationSingleTestMySocialIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125的古代诗歌风格非官方的郭德纲郭德纲地方梵蒂冈法国地方官梵蒂冈");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("我的社交超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 我的社交为非法字符
	 */
	@Test
	public void postSettingUserInformationSingleTestMySocialIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "<@#&)+>");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("我的社交为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 我的社交为空
	 */
	@Test
	public void postSettingUserInformationSingleTestmySocialIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("我的社交为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 我的社交为空格
	 */
	@Test
	public void postSettingUserInformationSingleTestmySocialIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", " ");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("我的社交为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 我的社交为null
	 */
	@Test
	public void postSettingUserInformationSingleTestMySocialIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", null);
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("我的社交为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 我的社交为不传该参数
	 */
	@Test
	public void postSettingUserInformationSingleTestMySocialNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
	
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("我的社交为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 头像url超长
	 */
	@Test
	public void postSettingUserInformationSingleTestHeadUrlIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl", "http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E5%9B%BE%E7%89%87&hs=0&pn=0&spn=0&di=51259042670&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=768609259%2C3589793470&os=1132863611%2C2811260572&simid=0%2C0&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01080755c1edaf32f87528a18e9840.jpg%40900w_1l_2o_100sh.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bzv55s_z%26e3Bv54_z%26e3BvgAzdH3Fo56hAzdH3FZMTIcNzMnODQ%3D_z%26e3Bip4s&gsm=0&islist=&querylist=");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("头像url超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 头像url为非法字符
	 */
	@Test
	public void postSettingUserInformationSingleTestHeadUrlIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl", "<@$^*_>");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("头像url为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 头像url为空
	 */
	@Test
	public void postSettingUserInformationSingleTestHeadUrlIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("头像url为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 头像url为空格
	 */
	@Test
	public void postSettingUserInformationSingleTestHeadUrlIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl"," ");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("头像url为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	/**
	 * 头像url为不传该参数
	 */
	@Test
	public void postSettingUserInformationSingleTestHeadUrlNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("头像url为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 主机域名超长
	 */
	@Test
	public void postSettingUserInformationSingleTestHostUrlIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://www.baidu.com/s?word=%E5%9B%BE%E7%89%87&tn=site888_3_pg&lm=-1&ssl_s=2&ssl_c=ssl1_16349c76bb1&prec=0");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("主机域名超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 主机域名为非法字符
	 */
	@Test
	public void postSettingUserInformationSingleTestHostUrlIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "<%#@(+>");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("主机域名为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 主机域名为空
	 */
	@Test
	public void postSettingUserInformationSingleTestHostUrlIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("主机域名为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 主机域名为空格
	 */
	@Test
	public void postSettingUserInformationSingleTestHostUrlIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", " ");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("主机域名为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 主机域名为null
	 */
	@Test
	public void postSettingUserInformationSingleTestHostUrlIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", null);
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("主机域名为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 主机域名为不传该参数
	 */
	@Test
	public void postSettingUserInformationSingleTestHostUrlNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("主机域名为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户头像id超长
	 */
	@Test
	public void postSettingUserInformationSingleTestHeadFileIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 100011222254323L);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户头像id超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户头像id为非法字符
	 */
	@Test
	public void postSettingUserInformationSingleTestHeadFileIdIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", "<@#$)+>");
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户头像id为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户头像id为空
	 */
	@Test
	public void postSettingUserInformationSingleTestHeadFileIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", "");
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户头像id为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户头像ID为空格
	 */
	@Test
	public void postSettingUserInformationSingleTestHeadFileIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", " ");
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户头像ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户头像ID为null
	 */
	@Test
	public void postSettingUserInformationSingleTestHeadFileIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", null);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户头像ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户头像ID为小数
	 */
	@Test
	public void postSettingUserInformationSingleTestHeadFileIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10.001);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户头像ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户头像ID为0
	 */
	@Test
	public void postSettingUserInformationSingleTestHeadFileIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 0);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户头像ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户头像ID为负数
	 */
	@Test
	public void postSettingUserInformationSingleTestHeadFileIdIsNegativeNumbe() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", -1002);
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户头像ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户头像ID为不传该参数
	 */
	@Test
	public void postSettingUserInformationSingleTestHeadFileIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		
		con.put("dynamicFileId", 10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户头像ID为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 动态封面文件id超长
	 */
	@Test
	public void postSettingUserInformationSingleTestDynamicFileIdIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 100021454566L);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态封面文件id超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 动态封面文件id为非法字符
	 */
	@Test
	public void postSettingUserInformationSingleTestDynamicFileIdIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", "<#%&*)>");
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态封面文件id为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 动态封面文件id为空
	 */
	@Test
	public void postSettingUserInformationSingleTestDynamicFileIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", "");
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态封面文件id为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 动态封面文件ID为空格
	 */
	@Test
	public void postSettingUserInformationSingleTestDynamicFileIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", " ");
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态封面文件ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 动态封面文件ID为null
	 */
	@Test
	public void postSettingUserInformationSingleTestDynamicFileIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", null);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态封面文件ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 动态封面文件ID为小数
	 */
	@Test
	public void postSettingUserInformationSingleTestDynamicFileIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", "10.002");
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态封面文件ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 动态封面文件ID为0
	 */
	@Test
	public void postSettingUserInformationSingleTestDynamicFileIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 0);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态封面文件ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 动态封面文件ID为负数
	 */
	@Test
	public void postSettingUserInformationSingleTestDynamicFileIdIsNegativeNumbe() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", -10002);
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态封面文件ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 动态封面文件ID为不传该参数
	 */
	@Test
	public void postSettingUserInformationSingleTestDynamicFileIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495218);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", "125");
		con.put("headUrl","https://www.2345.com/?k872897314");
		con.put("hostUrl", "http://192.168.9.20:8088/index.php?s=/8&page_id=2325");
		con.put("headFileId", 10001);
	
		Map<String, Object> head = new HashMap<String, Object>();		
		head.put("ver", "1.2.1");
		head.put("cmd", "209");		
		head.put("uuid", "12491610");
		head.put("ln", "cn");
		head.put("chcode", "VfMNOgrCxVpKcwVoU4n2y4jbgjnYR6mb");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态封面文件ID为不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	
	
}