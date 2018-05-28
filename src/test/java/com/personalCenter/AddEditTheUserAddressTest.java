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

public class AddEditTheUserAddressTest extends HttpUtil {
//用户地址编辑/添加接口
	String url = "/UU/addressinfo";
	String dataType = "perCenter81";
	String deleteSql = "DELETE  T_ADDRESS_INFO WHERE USER_ID = '12495396'";
	String insertSql = "INSERT INTO T_ADDRESS_INFO (\"ADDRESS_ID\",\"USER_ID\",\"CONTACT_NAME\", \"CONTACT_INFO\", \"PROVINCE_CODE\", \"CITY_CODE\", \"COUNTY_CODE\", \"DETAILED_ADDRESS\", \"IS_DEFAULT\", \"IS_DELETE\", \"MODIFY_TIME\", \"CREATE_TIME\", \"LABEL\", \"BRIEF_ADDRESS\") VALUES (T_ADDRESS_INFO_SEQ.nextval,'12495396', '测试君', '13524001140', '上海市', '上海市', '浦东新区', '会一直了', '0', '1', TO_DATE('2016-12-02 13:19:54', 'SYYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-02 10:59:05', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL)";
	String insertSql1 = "INSERT INTO T_ADDRESS_INFO (\"ADDRESS_ID\",\"USER_ID\",\"CONTACT_NAME\", \"CONTACT_INFO\", \"PROVINCE_CODE\", \"CITY_CODE\", \"COUNTY_CODE\", \"DETAILED_ADDRESS\", \"IS_DEFAULT\", \"IS_DELETE\", \"MODIFY_TIME\", \"CREATE_TIME\", \"LABEL\", \"BRIEF_ADDRESS\") VALUES (T_ADDRESS_INFO_SEQ.nextval,'12495396', '测试君', '13524001140', '上海市', '上海市', '浦东新区', '会一直了', '1', '1', TO_DATE('2016-12-02 13:19:54', 'SYYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-02 10:59:05', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL)";
	String selectSql = "SELECT * FROM T_ADDRESS_INFO WHERE USER_ID = '12495396'";
	String deleteSql1 = "DELETE  T_ADDRESS_INFO WHERE USER_ID = '12495396'";
	List<Map<String,Object>> list ;
	JSONObject body;
	String uuid;
	String chcode;
	@BeforeClass
	public void  beforeClass(){
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
	 * 1、提交正确参数为默认地址
	 */
	@Test
	public void postAddEditTheUserAddressTestCorrectParameter() throws Exception {
		
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);		
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(0).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 1);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", chcode);
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数为默认地址" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	
	/**
	 *2、提交正确参数为非默认地址
	 */
	@Test
	public void postAddEditTheUserAddressTestCorrectParameter0() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("addressId", addressId);
		con.put("contactName", "测试小哥");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
		
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数为非默认地址" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	
	/**
	 *3、用户ID未登录
	 */
	@Test
	public void postAddEditTheUserAddressTestUserIdNotLoggedIn() throws Exception {		
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 124953242);
		con.put("addressId", addressId);
		con.put("contactName", "测试小哥");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
		
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID未登录" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId 校验失败,非法输入");
	}
	/**
	 *4、用户ID为错误信息
	 */
	@Test
	public void postAddEditTheUserAddressTestUserIdIllegalCharacters() throws Exception {	
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "888888");
		con.put("addressId", addressId);
		con.put("contactName", "测试小哥");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
		
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误信息" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 5、用户ID为String类型
	 */
	@Test
	public void postAddEditTheUserAddressTestUserIdIsError() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12312sd313");
		con.put("addressId", addressId);
		con.put("contactName", "测试小哥");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String类型" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId 校验失败,非法输入");
	}
	/**
	 * 6、用户ID为小数
	 */
	@Test
	public void postAddEditTheUserAddressTestUserIdIsDecimal() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();

		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 1.23);
		con.put("addressId", addressId);
		con.put("contactName", "测试小哥");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
		
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
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
	 * 7、用户ID为负数
	 */
	@Test
	public void postAddEditTheUserAddressTestUserIdIsNegativeNumber() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();

		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -12312313);
		con.put("addressId", addressId);
		con.put("contactName", "测试小哥");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
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
	 * 8、用户ID为0
	 */
	@Test
	public void postAddEditTheUserAddressTestUserIdIsZero() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
		con.put("addressId", addressId);
		con.put("contactName", "测试小哥");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
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
	 * 9、用户ID为空格
	 */
	@Test
	public void postAddEditTheUserAddressTestUserIdIsSpace() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("addressId", addressId);
		con.put("contactName", "测试小哥");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
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
	 * 10、用户ID为空
	 */
	@Test
	public void postAddEditTheUserAddressTestUserIdIsEmpty() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("addressId", addressId);
		con.put("contactName", "测试小哥");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
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
	 * 11、用户ID不传该参数
	 */
	@Test
	public void postAddEditTheUserAddressTestUserIdNonSubmissionParameters() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("addressId", addressId);
		con.put("contactName", "测试小哥");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
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
	 * 12、用户ID超长
	 */
	@Test
	public void postAddEditTheUserAddressTestUserIdIsLong() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "123313546846846165687987984651513213135687987451513213565687879845115354548787413546222");
		con.put("addressId", addressId);
		con.put("contactName", "测试小哥");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 13、添加非自己用户ID的地址
	 */
	@Test
	public void postAddEditTheUserAddressTestUserIdNonSelf() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495417");
		con.put("addressId", addressId);
		con.put("contactName", "测试小哥");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("添加非自己用户ID的地址" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("失败");
	}
	/**
	 * 14、地址标签超长
	 */
	@Test
	public void postAddEditTheUserAddressTestAddressLabelIsLong() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试小哥");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "123313546846846165687987984651513213135687987451513213565687879845115354548787413546222");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址标签超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据库执行异常");
	}
	/**
	 * 14、地址标签为小数
	 */
	@Test
	public void postAddEditTheUserAddressTestAddressLabelIsDecimal() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试小哥");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", 1.5);
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址标签为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 16、地址标签为负数
	 */
	@Test
	public void postAddEditTheUserAddressTestAddressLabelIsNegativeNumber() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试小哥");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", -1235);
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址标签为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 17、地址标签为0
	 */
	@Test
	public void postAddEditTheUserAddressTestAddressLabelIsZero() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();

		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试小哥");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址标签为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 18、地址标签为已有
	 */
	@Test
	public void postAddEditTheUserAddressTestAddressLabelIsExistent() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addId = list.get(0).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addId);
		con.put("contactName", "测试小哥");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址标签为已有" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 19、地址标签为空
	 */
	@Test
	public void postAddEditTheUserAddressTestAddressLabelIsEmpty() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		//MetaOper.insert(insertSql, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		//String addId = list.get(0).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", "");
		con.put("contactName", "测试小哥");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址标签为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 20、地址标签为null
	 */
	@Test
	public void postAddEditTheUserAddressTestAddressLabelIsNull() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		//MetaOper.insert(insertSql, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		//String addId = list.get(0).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", null);
		con.put("contactName", "测试小哥");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址标签为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 21、地址标签为空格
	 */
	@Test
	public void postAddEditTheUserAddressTestAddressLabelIsSpace() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		//MetaOper.insert(insertSql, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		//String addId = list.get(0).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", " ");
		con.put("contactName", "测试小哥");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址标签为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 22、地址标签不传该参数
	 */
	@Test
	public void postAddEditTheUserAddressTestAddressLabelNonSubmissionParameters() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		//MetaOper.insert(insertSql, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		//String addId = list.get(0).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		//con.put("addressId", addressId);
		con.put("contactName", "测试小哥");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址标签不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 23、地址标签存在非法字符
	 */
	@Test
	public void postAddEditTheUserAddressTestAddressLabelIllegalCharacters() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		//MetaOper.insert(insertSql, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		//String addId = list.get(0).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", "<$%^>");
		con.put("contactName", "测试小哥");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地址标签存在非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 24、收货人超长
	 */
	@Test
	public void postAddEditTheUserAddressTestConsigneeIsLong() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试小哥奥斯卡大快圣诞节我我及饿哦来卡仕达路上看到 卡懒得去我饿迫切我开始懂了马充满了姓名存在");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收货人超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据库执行异常");
	}
	/**
	 * 25、收货人存在非法字符
	 */
	@Test
	public void postAddEditTheUserAddressTestConsigneeIllegalCharacters() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "<$%^>");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收货人存在非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 26、收货人为空
	 */
	@Test
	public void postAddEditTheUserAddressTestConsigneeIsEmpty() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收货人为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 27、收货人为空格
	 */
	@Test
	public void postAddEditTheUserAddressTestConsigneeIsSpace() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "  ");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收货人为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 28、收货人为null
	 */
	@Test
	public void postAddEditTheUserAddressTestConsigneeIsNull() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", null);
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收货人为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 29、收货人不传该参数
	 */
	@Test
	public void postAddEditTheUserAddressTestConsigneeNonSubmissionParameters() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		//con.put("contactName", "测试");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收货人不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 30、手机号码超11位
	 */
	@Test
	public void postAddEditTheUserAddressTestMobileIsLong() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996123");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码超11位" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 31、手机号码前缀+86
	 */
	@Test
	public void postAddEditTheUserAddressTestMobilePrecede86() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "+8613764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码前缀+86" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 32、手机号码前缀+00
	 */
	@Test
	public void postAddEditTheUserAddressTestMobilePrecede00() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "+0013764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码前缀+00" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 33、手机号码前缀加长途17951
	 */
	@Test
	public void postAddEditTheUserAddressTestMobilePrecede17951() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "1795113764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码前缀加长途17951" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 34、手机号码小于11位
	 */
	@Test
	public void postAddEditTheUserAddressTestMobileLessThan11() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "1376477");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码小于11位" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 35、手机号码为区号加固话（02160790211）
	 */
	@Test
	public void postAddEditTheUserAddressTestMobileIsTelephone() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "02160790211");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为区号加固话" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 36、手机号码为空
	 */
	@Test
	public void postAddEditTheUserAddressTestMobileIsEmpty() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 37、手机号码为空格
	 */
	@Test
	public void postAddEditTheUserAddressTestMobileIsSpace() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", " ");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 38、手机号码存在非法字符
	 */
	@Test
	public void postAddEditTheUserAddressTestMobileIllegalCharacters() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "<$%^>");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码存在非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 39、手机号码为null
	 */
	@Test
	public void postAddEditTheUserAddressTestMobileIsNull() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "null");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 40、手机号码非1开头
	 */
	@Test
	public void postAddEditTheUserAddressTestMobileNotBegin1() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "23764447159");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码非1开头" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 41、手机号码不传该参数
	 */
	@Test
	public void postAddEditTheUserAddressTestMobileNonSubmissionParameters() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		//con.put("contactInfo", "");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 42、手机号码存负数
	 */
	@Test
	public void postAddEditTheUserAddressTestMobileIsNegativeNumber() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "-13764771995");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码存负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 43、手机号码为0
	 */
	@Test
	public void postAddEditTheUserAddressTestMobileIsZero() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", 0);
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号码为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 44、省编码和市编码不一致
	 */
	@Test
	public void postAddEditTheUserAddressTestProvinceCodeNotTheSameAsCityCode() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 340000);
		con.put("cityCode", 310102);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("省编码和市编码不一致" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 45、市编码和区编码不一致
	 */
	@Test
	public void postAddEditTheUserAddressTestCityCodeNotTheSameAsCountyCode() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 410100);
		con.put("countyCode", 110115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("市编码和区编码不一致" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 46、省编码和区编码不一致
	 */
	@Test
	public void postAddEditTheUserAddressTestProvinceCodeNotTheSameAsCountyCode() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 610000);
		con.put("cityCode", 310100);
		con.put("countyCode", 110115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("省编码和区编码不一致" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 47、省编码错误
	 */
	@Test
	public void postAddEditTheUserAddressTestProvinceCodeIsError() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 918796);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("省编码错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 48、省编码输入负数
	 */
	@Test
	public void postAddEditTheUserAddressTestProvinceCodeIsNegativeNumber() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", -310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("省编码输入负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 49、省编码输入小数
	 */
	@Test
	public void postAddEditTheUserAddressTestProvinceCodeIsDecimal() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 3.10000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("省编码输入小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 50、省编码为0
	 */
	@Test
	public void postAddEditTheUserAddressTestProvinceCodeIsZero() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 0);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("省编码为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 51、省编码为空格
	 */
	@Test
	public void postAddEditTheUserAddressTestProvinceCodeIsSpace() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", " ");
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("省编码为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 52、省编码为空
	 */
	@Test
	public void postAddEditTheUserAddressTestProvinceCodeIsEmpty() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", "");
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("省编码为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 53、省编码为null
	 */
	@Test
	public void postAddEditTheUserAddressTestProvinceCodeIsNull() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", null);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("省编码为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 54、省编码为非法字符
	 */
	@Test
	public void postAddEditTheUserAddressTestProvinceCodeIllegalCharacters() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", "<$%^>");
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("省编码为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 55、省编码超长
	 */
	@Test
	public void postAddEditTheUserAddressTestProvinceCodeIsLong() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", "516546847987984651361322035130201350203156");
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("省编码超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 56、省编码不传该参数
	 */
	@Test
	public void postAddEditTheUserAddressTestProvinceCodeNonSubmissionParameters() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		//con.put("provinceCode", "<$%^>");
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("省编码不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 57、省编码为String
	 */
	@Test
	public void postAddEditTheUserAddressTestProvinceCodeIsString() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", "123qqw6987");
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("省编码为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 58、市编码错误
	 */
	@Test
	public void postAddEditTheUserAddressTestCityCodeIsError() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 987654);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("市编码错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 59、市编码输入负数
	 */
	@Test
	public void postAddEditTheUserAddressTestCityCodeIsNegativeNumber() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", -310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("市编码输入负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 60、市编码输入小数
	 */
	@Test
	public void postAddEditTheUserAddressTestCityCodeIsDecimal() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 987.654);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("市编码输入小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 61、市编码为0
	 */
	@Test
	public void postAddEditTheUserAddressTestCityCodeIsZero() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 0);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("市编码为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 62、市编码为空格
	 */
	@Test
	public void postAddEditTheUserAddressTestCityCodeIsSpace() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", " ");
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("市编码为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 63、市编码为空
	 */
	@Test
	public void postAddEditTheUserAddressTestCityCodeIsEmpty() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", "");
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("市编码为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 65、市编码为非法字符
	 */
	@Test
	public void postAddEditTheUserAddressTestCityCodeIllegalCharacters() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", "<$%^>");
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("市编码为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 66、市编码超长
	 */
	@Test
	public void postAddEditTheUserAddressTestCityCodeIsLong() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", "123313546846846165687987984651513213135687987451513213565687879845115354548787413546222");
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("市编码超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 67、市编码不传该参数
	 */
	@Test
	public void postAddEditTheUserAddressTestCityCodeNonSubmissionParameters() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		//con.put("cityCode", "1233135468");
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("市编码不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 68、市编码为String
	 */
	@Test
	public void postAddEditTheUserAddressTestCityCodeIsString() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", "123ss69");
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("市编码为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 69、区编码错误
	 */
	@Test
	public void postAddEditTheUserAddressTestCountyCodeIsError() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 999999);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("区编码错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 70、区编码输入负数
	 */
	@Test
	public void postAddEditTheUserAddressTestCountyCodeIsNegativeNumber() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", -310115);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("区编码输入负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 71、区编码输入小数
	 */
	@Test
	public void postAddEditTheUserAddressTestCountyCodeIsDecimal() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 3.1231);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("区编码输入小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 72、区编码为0
	 */
	@Test
	public void postAddEditTheUserAddressTestCountyCodeIsZero() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 0);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("区编码为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 73、区编码为空格
	 */
	@Test
	public void postAddEditTheUserAddressTestCountyCodeIsSpace() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", " ");
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("区编码为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 74、区编码为空
	 */
	@Test
	public void postAddEditTheUserAddressTestCountyCodeIsEmpty() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", "");
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("区编码为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 75、区编码为null
	 */
	@Test
	public void postAddEditTheUserAddressTestCountyCodeIsNull() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", null);
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("区编码为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 76、区编码为非法字符
	 */
	@Test
	public void postAddEditTheUserAddressTestCountyCodeIllegalCharacters() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", "<$%^>");
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("区编码为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 77、区编码超长
	 */
	@Test
	public void postAddEditTheUserAddressTestCountyCodeIsLong() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", "123313546846846165687987984651513213135687987451513213565687879845115354548787413546222");
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("区编码超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据库执行异常");
	}
	/**
	 * 78、区编码不传该参数
	 */
	@Test
	public void postAddEditTheUserAddressTestCountyCodeNonSubmissionParameters() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		//con.put("countyCode", "1233135468");
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("区编码不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 79、区编码为String
	 */
	@Test
	public void postAddEditTheUserAddressTestCountyCodeIsString() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", "1233de25");
		con.put("label", "公司");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("区编码为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 80、详细地址为空
	 */
	@Test
	public void postAddEditTheUserAddressTestDetailedAddressIsEmpty() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("详细地址为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 81、详细地址为空格
	 */
	@Test
	public void postAddEditTheUserAddressTestDetailedAddressIsSpace() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", " ");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("详细地址为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 82、详细地址为null
	 */
	@Test
	public void postAddEditTheUserAddressTestDetailedAddressIsNull() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", null);
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("详细地址为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	
	/**
	 * 84、详细地址非法字符
	 */
	@Test
	public void postAddEditTheUserAddressTestDetailedAddressIllegalCharacters() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "<$%^>");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("详细地址为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 85、详细地址超长
	 */
	@Test
	public void postAddEditTheUserAddressTestDetailedAddressIsLong() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222123313546846846165687987984651513213135687987451513213565687879845115354548787413546222");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("详细地址超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据库执行异常");
	}
	/**
	 * 86、详细地址为String
	 */
	@Test
	public void postAddEditTheUserAddressTestDetailedAddressIsString() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", "123as244");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("详细地址为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 87、详细地址为0
	 */
	@Test
	public void postAddEditTheUserAddressTestDetailedAddressIsZero() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", 0);
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("详细地址为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 88、详细地址为负数
	 */
	@Test
	public void postAddEditTheUserAddressTestDetailedAddressIsNegativeNumber() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", -89765);
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("详细地址为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 89、详细地址为小数
	 */
	@Test
	public void postAddEditTheUserAddressTestDetailedAddressIsDecimal() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		con.put("detailedAd", 1.25);
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("详细地址为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 90、详细地址不传该值
	 */
	@Test
	public void postAddEditTheUserAddressTestDetailedAddressNonSubmissionParameters() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "公司");
		//con.put("detailedAd", 0);
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("详细地址不传该值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 91、标签名称为空
	 */
	@Test
	public void postAddEditTheUserAddressTestLabelNameIsEmpty() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签名称为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 92、标签名称为空格
	 */
	@Test
	public void postAddEditTheUserAddressTestLabelNameIsSpace() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", " ");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签名称为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 93、标签名称为null
	 */
	@Test
	public void postAddEditTheUserAddressTestLabelNameIsNull() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", null);
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签名称为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 95、标签名称为非法字符
	 */
	@Test
	public void postAddEditTheUserAddressTestLabelNameIllegalCharacters() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "<$%^>");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签名称为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 96、标签名称超长
	 */
	@Test
	public void postAddEditTheUserAddressTestLabelNameIsLong() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "123313546846846165687987984651513213135687987451513213565687879845115354548787413546222");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签名称超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据库执行异常");
	}
	/**
	 * 97、标签名称为String
	 */
	@Test
	public void postAddEditTheUserAddressTestLabelNameIsString() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "12563sw415");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签名称为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 98、标签名称为0
	 */
	@Test
	public void postAddEditTheUserAddressTestLabelNameIsZero() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", 0);
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签名称为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 99、标签名称为负数
	 */
	@Test
	public void postAddEditTheUserAddressTestLabelNameIsNegativeNumber() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", -728);
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签名称为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 100、标签名称为小数
	 */
	@Test
	public void postAddEditTheUserAddressTestLabelNameIsDecimal() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", 7.28);
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签名称为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 101、标签名称不传该值
	 */
	@Test
	public void postAddEditTheUserAddressTestLabelNameNonSubmissionParameters() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		//con.put("label", -728);
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签名称不传该值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 102、默认标记为默认
	 */
	@Test
	public void postAddEditTheUserAddressTestIsDefault() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "家");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 1);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("默认标记为默认" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 103、默认标记为非默认
	 */
	@Test
	public void postAddEditTheUserAddressTestNonDefault() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "家");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("默认标记为非默认" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 104、多个非默认地址
	 */
	@Test
	public void postAddEditTheUserAddressTestNonDefaults() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "家");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 0);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("多个非默认地址" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 105、多个默认地址
	 */
	@Test
	public void postAddEditTheUserAddressTestDefaults() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "家");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 1);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("多个默认地址" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 106、默认值错误
	 */
	@Test
	public void postAddEditTheUserAddressTestDefaultIsError() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "家");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 5);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("默认值错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 107、默认值为负数
	 */
	@Test
	public void postAddEditTheUserAddressTestDefaultIsNegativeNumber() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "家");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", -6);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("默认值为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 108、默认值为小数
	 */
	@Test
	public void postAddEditTheUserAddressTestDefaultIsDecimal() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "家");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", 1.23);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("默认值为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 109、默认值为String
	 */
	@Test
	public void postAddEditTheUserAddressTestDefaultIsString() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "家");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", "12wd6");
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("默认值为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 110、默认值为空格
	 */
	@Test
	public void postAddEditTheUserAddressTestDefaultIsSpace() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "家");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", " ");
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("默认值为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 111、默认值为空
	 */
	@Test
	public void postAddEditTheUserAddressTestDefaultIsEmpty() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "家");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", "");
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("默认值为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 112、默认值为null
	 */
	@Test
	public void postAddEditTheUserAddressTestDefaultIsNull() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "家");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", null);
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("默认值为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 113、默认值为非法字符
	 */
	@Test
	public void postAddEditTheUserAddressTestDefaultIllegalCharacters() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "家");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", "<$%^>");
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("默认值为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 114、默认值为超长
	 */
	@Test
	public void postAddEditTheUserAddressTestDefaultIsLong() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "家");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		con.put("isDefault", "123313546846846165687987984651513213135687987451513213565687879845115354548787413546222");
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("默认值为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	/**
	 * 115、默认值不传该参数
	 */
	@Test
	public void postAddEditTheUserAddressTestDefaultNonSubmissionParameters() throws Exception {
		MetaOper.delete(deleteSql, dataType);
		MetaOper.insert(insertSql, dataType);
		MetaOper.insert(insertSql1, dataType);
		List<Map<String,Object>> list ;
		list = MetaOper.read(selectSql,dataType);
		String addressId = list.get(1).get("ADDRESS_ID").toString();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("addressId", addressId);
		con.put("contactName", "测试君");
		con.put("contactInfo", "13764771996");
		con.put("provinceCode", 310000);
		con.put("cityCode", 310100);
		con.put("countyCode", 310115);
		con.put("label", "家");
		con.put("detailedAd", "上南路3855号如日商务园");
		con.put("briefAddress", "上海市，上海市，浦东新区");
		//con.put("isDefault", "");
	
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.2.2");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2018-05-10 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", "chcode");
		head.put("cmd", 4503);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("默认值不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("参数异常！");
	}
	
	
}