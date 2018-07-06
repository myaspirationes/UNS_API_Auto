package com.postcard;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;
import com.example.LoginTest;
//import com.example.LoginTest;

public class NewAgeForPersonalBasicInformationTest extends HttpUtil {
	//个人基本信息设置新增年龄
	String url = "/uu-admin/sensitiveWord/addOrEditSensitiveWord";
	Map<String, Object> head = new HashMap<String, Object>();
	JSONObject body177;
	String uuid;
	String chcode;
	@BeforeClass
	public void  beforeClass() throws Exception {
		LoginTest login = new LoginTest();
		try {
			body177 = login.getLoginTestChcodeBy177();
			uuid= (body177.get("uuid")).toString();
			chcode= (body177.get("checkCode")).toString();
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
		head.put("cmd", 209);
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestAllCorrectParameter() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("nickName", "武城东员工");
		con.put("uBarId", "5500");
		con.put("gender", 1);
		con.put("cityAddress", "10000");
		con.put("companyAddress", "20000");
		con.put("familyAddress", "25000");
		con.put("email", "15171@163.com");
		con.put("englishName", "Jack");
		con.put("signature", "任性");
		con.put("mySocial", 125);
		con.put("headUrl", "");
		con.put("hostUrl", "");
		con.put("headFileId", 10001);
		con.put("dynamicFileId", 10002);
		con.put("birthday", "1990-06-08");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 只提交用户ID
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestOnleUuid() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("只提交用户ID" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 用户id为为最大值
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestuuidIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", 999999999999999999L);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 用户id为为空
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestuuidIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", "");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 用户id为为空格
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestuuidIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", " ");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 用户id为null
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestuuidIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", null);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 用户id为不传该参数
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestuuidNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 昵称为最大值
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestNickNameIsMax() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("nickName", "武城东员工武城东员工武城东员工武城东员工武城东员工武城东员工武城东员工武城东员工武城东员工武城东员工武城东员工武城东员工武城东员工武城东员工武城东员工武城东员工武城东员工武城东员工武城东员工武城东员工武城东员工武城东员工武城东员工武城东员工武城东员工武城东员工武城东员工武城东员工武城东员工武城东员工");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 昵称为null
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestNickNameIsNull() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("nickName", null);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 昵称为空
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestNickNameIsEmpty() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("nickName", "");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 昵称为空格
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestNickNameIsSpace() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("nickName", " ");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 昵称不传该参数
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestNickNameNonSubmissionParameters() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("昵称不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * u吧号最大值
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestUBarIdIsMax() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("uBarId", "111111111111111111111111111111111111");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("u吧号为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * u吧号为null
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestUBarIdIsNull() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("nickName", null);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("u吧号为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * u吧号为空
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestUBarIdIsEmpty() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("nickName", "");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("u吧号为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * u吧号为空格
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestUBarIdIsSpace() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("nickName", " ");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("u吧号为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * u吧号不传该参数
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestUBarIdNonSubmissionParameters() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("u吧号不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 性别最大值
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestGenderIsMax() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("gender", 999999999);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 性别为null
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestGenderIsNull() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("gender", null);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 性别为空
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestGenderIsEmpty() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("gender", "");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 性别为空格
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestGenderIsSpace() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("gender", " ");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 性别不传该参数
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestGenderNonSubmissionParameters() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	
	/**
	 * 地区最大值
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestCityAddressIsMax() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cityAddress", "cityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddresscityAddress");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地区为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 地区为null
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestCityAddressIsNull() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cityAddress", null);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地区为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 地区为空
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestCityAddressIsEmpty() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cityAddress", "");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地区为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 地区为空格
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestCityAddressIsSpace() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("cityAddress", " ");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地区为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 地区不传该参数
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestCityAddressNonSubmissionParameters() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地区不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	
	/**
	 * 公司地址为最大值
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestCompanyAddressIsMax() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("companyAddress", "companyAddresscompanyAddresscompanyAddresscompanyAddresscompanyAddresscompanyAddresscompanyAddresscompanyAddresscompanyAddresscompanyAddresscompanyAddresscompanyAddresscompanyAddresscompanyAddresscompanyAddresscompanyAddresscompanyAddresscompanyAddresscompanyAddresscompanyAddresscompanyAddresscompanyAddresscompanyAddresscompanyAddresscompanyAddresscompanyAddresscompanyAddresscompanyAddresscompanyAddress");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公司地址为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 公司地址为null
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestCompanyAddressIsNull() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("companyAddress", null);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公司地址为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 公司地址为空
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestCompanyAddressIsEmpty() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("companyAddress", "");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公司地址为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 公司地址为空格
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestCompanyAddressIsSpace() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("companyAddress", " ");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公司地址为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 公司地址不传该参数
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestTestCompanyAddressNonSubmissionParameters() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公司地址不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	
	/**
	 * 家庭住址为最大值
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestFamilyAddressIsMax() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("familyAddress", "familyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddressfamilyAddress");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("家庭住址为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 家庭住址为null
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestFamilyAddressIsNull() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("familyAddress", null);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("家庭住址为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 家庭住址为空
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestFamilyAddressIsEmpty() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("familyAddress", "");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("家庭住址为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 家庭住址为空格
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestFamilyAddressIsSpace() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("familyAddress", " ");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("家庭住址为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 家庭住址不传该参数
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestTestFamilyAddressNonSubmissionParameters() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("家庭住址不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	
	/**
	 * 邮箱为最大值
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestEmailIsMax() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("email", "emailemailemailemailemailemailemailemailemailemailemailemailemailemailemailemailemailemailemailemailemailemailemailemailemailemailemailemailemailemailemail");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("邮箱为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 邮箱为null
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestEmailIsNull() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("email", null);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("邮箱为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 邮箱为空
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestEmailIsEmpty() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("email", "");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("邮箱为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 邮箱为空格
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestEmailIsSpace() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("email", " ");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("邮箱为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 邮箱不传该参数
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestTestEmailNonSubmissionParameters() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("邮箱不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	
	/**
	 * 英文名为最大值
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestEnglishNameIsMax() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("englishName", "englishNameenglishNameenglishNameenglishNameenglishNameenglishNameenglishNameenglishNameenglishNameenglishNameenglishNameenglishNameenglishNameenglishNameenglishNameenglishNameenglishName");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("英文名为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 英文名为null
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestEnglishNameIsNull() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("englishName", null);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("英文名为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 英文名为空
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestEnglishNameIsEmpty() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("englishName", "");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("英文名为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 英文名为空格
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestEnglishNameIsSpace() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("englishName", " ");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("英文名为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 英文名不传该参数
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestTestEnglishNameNonSubmissionParameters() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("英文名不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	
	/**
	 * 个性签名为最大值
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestSignatureIsMax() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("signature", "signaturesignaturesignaturesignaturesignaturesignaturesignaturesignaturesignaturesignaturesignaturesignaturesignaturesignaturesignaturesignaturesignaturesignaturesignaturesignaturesignaturesignaturesignaturesignaturesignaturesignaturesignaturesignaturesignaturesignaturesignature");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("个性签名为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 个性签名为null
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestSignatureIsNull() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("signature", null);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("个性签名为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 个性签名为空
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestSignatureIsEmpty() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("signature", "");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("个性签名为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 个性签名为空格
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestSignatureIsSpace() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("signature", " ");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("个性签名为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 个性签名不传该参数
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestTestSignatureNonSubmissionParameters() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("个性签名不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	
	/**
	 * 我的社交为最大值
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestMySocialIsMax() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("mySocial", "mySocialmySocialmySocialmySocialmySocialmySocialmySocialmySocialmySocialmySocialmySocialmySocialmySocialmySocialmySocialmySocialmySocialmySocialmySocialmySocialmySocialmySocialmySocialmySocialmySocialmySocialmySocialmySocialmySocialmySocial");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("我的社交为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 我的社交为null
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestMySocialIsNull() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("mySocial", null);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("我的社交为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 我的社交为空
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestMySocialIsEmpty() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("mySocial", "");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("我的社交为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 我的社交为空格
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestMySocialIsSpace() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("mySocial", " ");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("我的社交为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 我的社交不传该参数
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestTestMySocialNonSubmissionParameters() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("我的社交不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	
	/**
	 * 头像url为最大值
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestHeadUrlIsMax() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("headUrl", "headUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrlheadUrl");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("头像url为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 头像url为null
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestHeadUrlIsNull() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("headUrl", null);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("头像url为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 头像url为空
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestHeadUrlIsEmpty() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("headUrl", "");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("头像url为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 头像url为空格
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestHeadUrlIsSpace() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("headUrl", " ");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("头像url为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 头像url不传该参数
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestTestHeadUrlNonSubmissionParameters() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("头像url不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	
	/**
	 * 主机域名为最大值
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestHostUrlIsMax() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("hostUrl", "hostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrlhostUrl");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("主机域名为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 主机域名为null
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestHostUrlIsNull() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("hostUrl", null);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("主机域名为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 主机域名为空
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestHostUrlIsEmpty() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("hostUrl", "");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("主机域名为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 主机域名为空格
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestHostUrlIsSpace() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("hostUrl", " ");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("主机域名为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 主机域名不传该参数
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestTestHostUrlNonSubmissionParameters() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("主机域名不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	
	/**
	 * 用户头像id为最大值
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestHeadFileIdIsMax() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("headFileId", 999999999999999999L);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户头像id为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 用户头像id为null
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestHeadFileIdIsNull() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("headFileId", null);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户头像id为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 用户头像id为空
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestHeadFileIdIsEmpty() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("headFileId", "");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户头像id为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 用户头像id为空格
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestHeadFileIdIsSpace() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("headFileId", " ");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户头像id为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 用户头像id不传该参数
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestTestHeadFileIdNonSubmissionParameters() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户头像id不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	
	/**
	 * 动态封面文件id为最大值
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestDynamicFileIdIsMax() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("dynamicFileId", 999999999999999999L);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态封面文件id为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 动态封面文件id为null
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestDynamicFileIdIsNull() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("dynamicFileId", null);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态封面文件id为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 动态封面文件id为空
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestDynamicFileIdIsEmpty() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("dynamicFileId", "");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态封面文件id为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 动态封面文件id为空格
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestDynamicFileIdIsSpace() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("dynamicFileId", " ");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态封面文件id为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 动态封面文件id不传该参数
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestTestDynamicFileIdNonSubmissionParameters() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态封面文件id不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	
	/**
	 * 用户手动配置生日为最大值
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestBirthdayIsMax() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("birthday", "9999-12-31");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户手动配置生日为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 用户手动配置生日为null
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestBirthdayIsNull() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("birthday", null);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户手动配置生日为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 用户手动配置生日为空
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestBirthdayIsEmpty() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("birthday", "");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户手动配置生日为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 用户手动配置生日为空格
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestBirthdayIsSpace() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		con.put("birthday", " ");
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户手动配置生日为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 用户手动配置生日不传该参数
	 */
	@Test
	public void postNewAgeForPersonalBasicInformationTestTestBirthdayNonSubmissionParameters() throws Exception {
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("uuid", uuid);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户手动配置生日不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
}