package com.appDynamic;

import com.example.HttpUtil;
import com.example.LoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class PublishDynamicsTest extends HttpUtil {
//发布动态接口
	String url = "/UU/dynamic";

	JSONObject body;
	String uuid;
	String chcode;
	Map<String, Object> head = new HashMap<String, Object>();
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
		head.put("aid", "lan6uu");
		head.put("ver", "1.0");
		head.put("ln", "cn");
		head.put("mod", "ios");
		head.put("de", "2011-07-13 00:00:00");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", chcode);
		head.put("cmd", 510);
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postPublishDynamicsTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

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
	 * 用户id为最大值
	 */
	@Test
	public void postPublishDynamicsTestuserIdIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 999999999999999999L);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 用户id为空格
	 */
	@Test
	public void postPublishDynamicsTestuserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为空
	 */
	@Test
	public void postPublishDynamicsTestuserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为null
	 */
	@Test
	public void postPublishDynamicsTestuserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为0
	 */
	@Test
	public void postPublishDynamicsTestuserIdIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为String
	 */
	@Test
	public void postPublishDynamicsTestuserIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "FGSFDGDSD");
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为小数
	 */
	@Test
	public void postPublishDynamicsTestuserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 1249.2396);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为负数
	 */
	@Test
	public void postPublishDynamicsTestuserIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -12495396);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为不传参数
	 */
	@Test
	public void postPublishDynamicsTestuserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为不传参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户id为未登录用户
	 */
	@Test
	public void postPublishDynamicsTestuserIdIsNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495325);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为未登录用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文件id传超长
	 */
	@Test
	public void postPublishDynamicsTestFileIdsIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 999999999999999999L);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文件id传超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文件id含非法字符
	 */
	@Test
	public void postPublishDynamicsTestFileIdsIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", "<@$@#$>");
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文件id含非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文件id传空
	 */
	@Test
	public void postPublishDynamicsTestFileIdsIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", "");
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文件id传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文件id传空格
	 */
	@Test
	public void postPublishDynamicsTestFileIdsIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", " ");
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文件id传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文件id传null
	 */
	@Test
	public void postPublishDynamicsTestFileIdsIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", null);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文件id传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文件id传0
	 */
	@Test
	public void postPublishDynamicsTestFileIdsIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 0);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文件id传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文件id不传参数
	 */
	@Test
	public void postPublishDynamicsTestFileIdsNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文件id不传参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文件id传多个
	 */
	@Test
	public void postPublishDynamicsTestFileIdsIsMany() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", "aaa,bbb,ccc");
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文件id传多个" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文件id为空动态类型为5
	 */
	@Test
	public void postPublishDynamicsTestFileIdsIsEmptyDynamicTypeIs5() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", "");
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文件id为空动态类型为5" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文件id为空格动态为5
	 */
	@Test
	public void postPublishDynamicsTestFileIdsIsSpaceDynamicTypeIs5() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", " ");
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文件id为空格动态为5" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文件id为null动态为5
	 */
	@Test
	public void postPublishDynamicsTestFileIdsIsNullNynamicTypeIs5() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", null);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文件id为null动态为5" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文件id不传参数动态为5
	 */
	@Test
	public void postPublishDynamicsTestFileIdsNonSubmissionParametersNynamicTypeIs5() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文件id不传参数动态为5" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态文字内容传超长
	 */
	@Test
	public void postPublishDynamicsTestFileIdsContentIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666#$%dsf法国是否发生过广东分公，大概是个。发士大夫是非得失！感到十分十分士大夫十分顺丰顺丰。");
		con.put("dynamicType", 5);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态文字内容传超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态文字内容含有非法字符
	 */
	@Test
	public void postPublishDynamicsTestFileIdsContentIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "<#$#$$#%$^%&^%>");
		con.put("dynamicType", 5);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态文字内容含有非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态文字内容传空
	 */
	@Test
	public void postPublishDynamicsTestFileIdsContentIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "");
		con.put("dynamicType", 5);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态文字内容传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态文字内容传空格
	 */
	@Test
	public void postPublishDynamicsTestFileIdsContentIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", " ");
		con.put("dynamicType", 5);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态文字内容传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态文字内容传null
	 */
	@Test
	public void postPublishDynamicsTestFileIdsContentIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", null);
		con.put("dynamicType", 5);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态文字内容传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态文字内容传0
	 */
	@Test
	public void postPublishDynamicsTestFileIdsContentIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", 0);
		con.put("dynamicType", 5);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态文字内容传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态文字内容不传参数
	 */
	@Test
	public void postPublishDynamicsTestFileIdsContentNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("dynamicType", 5);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态文字内容不传参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型传错误
	 */
	@Test
	public void postPublishDynamicsTestFileIdsdynamicTypeIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 888);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型传错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型chuan 负数
	 */
	@Test
	public void postPublishDynamicsTestFileIdsContentIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", -1);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型传0
	 */
	@Test
	public void postPublishDynamicsTestFileIdsDynamicTypeIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型传空
	 */
	@Test
	public void postPublishDynamicsTestFileIdsDynamicTypeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", "");
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型传空格
	 */
	@Test
	public void postPublishDynamicsTestFileIdsDynamicTypeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", " ");
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型传null
	 */
	@Test
	public void postPublishDynamicsTestFileIdsDynamicTypeIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", null);
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型传String
	 */
	@Test
	public void postPublishDynamicsTestFileIdsDynamicTypeIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", "ddjhj");
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型传String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态类型不传
	 */
	@Test
	public void postPublishDynamicsTestFileIdsDynamicTypeNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("longitude", 13.26);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态类型不传" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态经度传String
	 */
	@Test
	public void postPublishDynamicsTestFileIdsLongitudeIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", "bbjkjk");
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态经度传String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态经度传负数
	 */
	@Test
	public void postPublishDynamicsTestFileIdsLongitudeIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", -13.66);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态经度传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态经度传整数
	 */
	@Test
	public void postPublishDynamicsTestFileIdsLongitudeIsInteger() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 62);
		con.put("latitude", 13.33);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态经度传整数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态经度传0
	 */
	@Test
	public void postPublishDynamicsTestFileIdsLongitudeIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 0);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态经度传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态经度传空
	 */
	@Test
	public void postPublishDynamicsTestFileIdsLongitudeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", "");
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态经度传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态经度传空格
	 */
	@Test
	public void postPublishDynamicsTestFileIdsLongitudeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", " ");
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态经度传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态经度传null
	 */
	@Test
	public void postPublishDynamicsTestFileIdsLongitudeIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", null);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态经度传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 发布动态时的地址传超长
	 */
	@Test
	public void postPublishDynamicsTestDynamicAddressIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园dgdgfs大师傅犯得上发顺丰发生过的是广东省，灌水灌水灌水的是。");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("发布动态时的地址传超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 发布动态时的地址传空
	 */
	@Test
	public void postPublishDynamicsTestDynamicAddressIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.23);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("发布动态时的地址传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 发布动态时的地址传空格
	 */
	@Test
	public void postPublishDynamicsTestDynamicAddressIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", " ");
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("发布动态时的地址传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 发布动态时的地址null
	 */
	@Test
	public void postPublishDynamicsTestDynamicAddressIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", null);
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("发布动态时的地址null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 发布动态时的地址传0
	 */
	@Test
	public void postPublishDynamicsTestDynamicAddressIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", 0);
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("发布动态时的地址传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 发布动态时的地址含有非法字符
	 */
	@Test
	public void postPublishDynamicsTestDynamicAddressIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 13.19);
		con.put("dynamicAddress", "<#$@#$>");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("发布动态时的地址含有非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 发布动态时的地址不传参
	 */
	@Test
	public void postPublishDynamicsTestDynamicAddressNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 13.19);
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("发布动态时的地址不传参" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态纬度传String
	 */
	@Test
	public void postPublishDynamicsTestLatitudeIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", "dfsfsd");
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态纬度传String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态纬度传空
	 */
	@Test
	public void postPublishDynamicsTestLatitudeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", "");
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态纬度传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态纬度传空格
	 */
	@Test
	public void postPublishDynamicsTestLatitudeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", " ");
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态纬度传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态纬度传0
	 */
	@Test
	public void postPublishDynamicsTestLatitudeIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 0);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态纬度传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态纬度传负数
	 */
	@Test
	public void postPublishDynamicsTestLatitudeIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", -22.32);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态纬度传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态纬度传整数
	 */
	@Test
	public void postPublishDynamicsTestLatitudeIsInteger() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态纬度传整数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态纬度传null
	 */
	@Test
	public void postPublishDynamicsTestLatitudeIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", null);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态纬度传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 动态纬度不传参数
	 */
	@Test
	public void postPublishDynamicsTestLatitudeNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("动态纬度不传参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图动态经度传空
	 */
	@Test
	public void postPublishDynamicsTestMapLongitudeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.22);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", "");
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图动态经度传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图动态经度传空格
	 */
	@Test
	public void postPublishDynamicsTestlatitudeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", " ");
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 22.36);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图动态经度传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图动态经度传null
	 */
	@Test
	public void postPublishDynamicsTestMapLongitudeIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", null);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图动态经度传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图动态经度传空格
	 */
	@Test
	public void postPublishDynamicsTestMapLongitudeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", "");
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图动态经度传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图动态经度传空动态类型是地图动态
	 */
	@Test
	public void postPublishDynamicsTestMapLongitudeIsEmptyDynamicTypeIs5() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", "");
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图动态经度传空动态类型是地图动态" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图动态经度传空格动态类型是地图动态
	 */
	@Test
	public void postPublishDynamicsTestMapLongitudeIsSpaceDynamicTypeIs5() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", " ");
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图动态经度传空格动态类型是地图动态" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图动态经度传 null动态类型是地图动态
	 */
	@Test
	public void postPublishDynamicsTestMapLongitudeIsNullDynamicTypeIs5() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", null);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图动态经度传 null动态类型是地图动态" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图动态经度不传动态类型是地图动态
	 */
	@Test
	public void postPublishDynamicsTestMapLongitudeNonSubmissionParametersDynamicTypeIs5() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图动态经度不传动态类型是地图动态" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图动态经度不传
	 */
	@Test
	public void postPublishDynamicsTestMapLongitudeNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图动态经度不传" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图动态经度传0
	 */
	@Test
	public void postPublishDynamicsTestMapLongitudeIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 0);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图动态经度传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图动态经度传String
	 */
	@Test
	public void postPublishDynamicsTestMapLongitudeIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", "dferfewe");
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图动态经度传String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图动态经度传负数
	 */
	@Test
	public void postPublishDynamicsTestMapLongitudeIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", -55.32);
		con.put("mapLatitude", 38.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图动态经度传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图动态纬度传空
	 */
	@Test
	public void postPublishDynamicsTestMapLatitudeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 26.35);
		con.put("mapLatitude", "");
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图动态纬度传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图动态纬度传空格
	 */
	@Test
	public void postPublishDynamicsTestMapLatitudeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", " ");
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图动态纬度传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图动态纬度传null
	 */
	@Test
	public void postPublishDynamicsTestMapLatitudeIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", null);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图动态纬度传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图动态纬度传负数
	 */
	@Test
	public void postPublishDynamicsTestMapLatitudeIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", -56.23);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图动态纬度传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图动态纬度传0
	 */
	@Test
	public void postPublishDynamicsTestMapLatitudeIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 0);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图动态纬度传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图动态纬度传 String
	 */
	@Test
	public void postPublishDynamicsTestMapLatitudeIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", "DFSDSF");
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图动态纬度传 String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图动态纬度不传
	 */
	@Test
	public void postPublishDynamicsTestMapLatitudeNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图动态纬度不传" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图动态纬度传空动态类型是地图动态
	 */
	@Test
	public void postPublishDynamicsTestMapLatitudeIsEmptyDynamicTypeIs5() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", "");
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图动态纬度传空动态类型是地图动态" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图动态纬度传空格动态类型是地图动态
	 */
	@Test
	public void postPublishDynamicsTestMapLatitudeIsSpaceDynamicTypeIs5() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", "DFSDSF");
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图动态纬度传空动态类型是地图动态" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图动态纬度传null动态类型是地图动态
	 */
	@Test
	public void postPublishDynamicsTestMapLatitudeIsnullDynamicTypeIs5() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", null);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图动态纬度传null动态类型是地图动态" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图动态纬度不传动态类型是地图动态
	 */
	@Test
	public void postPublishDynamicsTestMapLatitudeNonSubmissionParametersDynamicTypeIs5() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图动态纬度不传动态类型是地图动态" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 区域region传超长
	 */
	@Test
	public void postPublishDynamicsTestRegionIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区df的风格和经济多福多寿犯得上发生，法大师傅十分，是否电风扇犯得上。");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("区域region传超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 区域region传非法字符
	 */
	@Test
	public void postPublishDynamicsTestRegionIsIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "<@$%&^%*>");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("区域region传非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 区域region传空
	 */
	@Test
	public void postPublishDynamicsTestRegionIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("区域region传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 区域region传空格
	 */
	@Test
	public void postPublishDynamicsTestRegionIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", " ");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("区域region传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 区域region传null
	 */
	@Test
	public void postPublishDynamicsTestRegionIsnull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", null);
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("区域region传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 区域region传0
	 */
	@Test
	public void postPublishDynamicsTestRegionIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", 0);
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("区域region传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 区域region不传
	 */
	@Test
	public void postPublishDynamicsTestRegionNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("区域region不传" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图文件id传负数
	 */
	@Test
	public void postPublishDynamicsTestFileIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", -1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图文件id传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图文件id传小数
	 */
	@Test
	public void postPublishDynamicsTestFileIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 13.19);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图文件id传小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图文件id传空
	 */
	@Test
	public void postPublishDynamicsTestFileIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", "");
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图文件id传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图文件id传空格
	 */
	@Test
	public void postPublishDynamicsTestFileIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", " ");
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图文件id传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图文件id传null
	 */
	@Test
	public void postPublishDynamicsTestFileIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", null);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图文件id传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图文件id传0
	 */
	@Test
	public void postPublishDynamicsTestFileIdIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 0);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图文件id传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图文件id不传
	 */
	@Test
	public void postPublishDynamicsTestFileIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图文件id不传" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 地图文件id传String
	 */
	@Test
	public void postPublishDynamicsTestFileIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", "dfdsfs");
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("地图文件id传String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 详细地址传超长
	 */
	@Test
	public void postPublishDynamicsTestAddressIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号dfsd电风扇犯得上发法国梵蒂冈梵蒂冈鬼地方鬼地方梵蒂冈的规范环境");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("详细地址传超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 详细地址传空
	 */
	@Test
	public void postPublishDynamicsTestAddressIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("详细地址传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 详细地址传空格
	 */
	@Test
	public void postPublishDynamicsTestAddressIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", " ");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("详细地址传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 详细地址传0
	 */
	@Test
	public void postPublishDynamicsTestAddressIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", 0);
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("详细地址传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 详细地址传null
	 */
	@Test
	public void postPublishDynamicsTestAddressIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", null);
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("详细地址传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 详细地址传非法字符
	 */
	@Test
	public void postPublishDynamicsTestAddressIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "<#$#@%#%$>");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("详细地址传非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 详细地址不传
	 */
	@Test
	public void postPublishDynamicsTestAddressNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("fileId", 1319);
		con.put("zoomLevel", 2.22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("详细地址不传" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 缩放比例传空
	 */
	@Test
	public void postPublishDynamicsTestZoomLevelIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", "");
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("缩放比例传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 缩放比例传空格
	 */
	@Test
	public void postPublishDynamicsTestZoomLevelIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", " ");
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("缩放比例传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 缩放比例传null
	 */
	@Test
	public void postPublishDynamicsTestZoomLevelIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", null);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("缩放比例传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 缩放比例传0
	 */
	@Test
	public void postPublishDynamicsTestZoomLevelIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 0);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("缩放比例传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 缩放比例传String
	 */
	@Test
	public void postPublishDynamicsTestZoomLevelIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", "DFDSFS");
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("缩放比例传String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 缩放比例传负数
	 */
	@Test
	public void postPublishDynamicsTestZoomLevelIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", -22.3);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("缩放比例传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 缩放比例传整数
	 */
	@Test
	public void postPublishDynamicsTestZoomLevelIsInteger() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("缩放比例传整数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 缩放比例不传
	 */
	@Test
	public void postPublishDynamicsTestZoomLevelNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("缩放比例不传" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 公开程度传负数
	 */
	@Test
	public void postPublishDynamicsTestPowerTypeIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", -5);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公开程度传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 公开程度传小数
	 */
	@Test
	public void postPublishDynamicsTestPowerTypeIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 2.3);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公开程度传小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 公开程度传0
	 */
	@Test
	public void postPublishDynamicsTestPowerTypeIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公开程度传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 公开程度传String
	 */
	@Test
	public void postPublishDynamicsTestPowerTypeIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", "fsgsdad");
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公开程度传String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 公开程度传空
	 */
	@Test
	public void postPublishDynamicsTestPowerTypeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", "");
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公开程度传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 公开程度传空格
	 */
	@Test
	public void postPublishDynamicsTestPowerTypeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", " ");
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公开程度传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 公开程度传null
	 */
	@Test
	public void postPublishDynamicsTestPowerTypeIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", null);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公开程度传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 公开程度不传
	 */
	@Test
	public void postPublishDynamicsTestPowerTypeNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公开程度不传" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 公开程度传8
	 */
	@Test
	public void postPublishDynamicsTestPowerTypeIs8() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 8);
		con.put("atUserIds", 1319);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("公开程度传8" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提醒用户id数组传超长
	 */
	@Test
	public void postPublishDynamicsTestAtUserIdsIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "34424455436576765775675777665654");
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提醒用户id数组传超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提醒用户id数组传空格
	 */
	@Test
	public void postPublishDynamicsTestAtUserIdsIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", " ");
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提醒用户id数组传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提醒用户id数组传空
	 */
	@Test
	public void postPublishDynamicsTestAtUserIdsIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "");
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提醒用户id数组传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提醒用户id数组传 null
	 */
	@Test
	public void postPublishDynamicsTestAtUserIdsIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", null);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提醒用户id数组传 null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提醒用户id数组传0
	 */
	@Test
	public void postPublishDynamicsTestAtUserIdsIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", 0);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提醒用户id数组传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提醒用户id数组传多个
	 */
	@Test
	public void postPublishDynamicsTestAtUserIdsIsMany() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "3442,4455,4365767,6577567577,7665654");
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提醒用户id数组传多个" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提醒用户id数组不传
	 */
	@Test
	public void postPublishDynamicsTestAtUserIdsNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("audioTime", 1319);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提醒用户id数组不传" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 音频时间传0
	 */
	@Test
	public void postPublishDynamicsTestAudioTimeIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 0);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("音频时间传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 音频时间传空
	 */
	@Test
	public void postPublishDynamicsTestAudioTimeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", "");
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("音频时间传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 音频时间传空格
	 */
	@Test
	public void postPublishDynamicsTestAudioTimeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", " ");
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("音频时间传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 音频时间传null
	 */
	@Test
	public void postPublishDynamicsTestAudioTimeIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", null);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("音频时间传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 音频时间传最大值
	 */
	@Test
	public void postPublishDynamicsTestAudioTimeIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 999999999);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("音频时间传最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 音频时间传负数
	 */
	@Test
	public void postPublishDynamicsTestAudioTimeIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", -23);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("音频时间传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 音频时间传小数
	 */
	@Test
	public void postPublishDynamicsTestAudioTimeIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("音频时间传小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 音频时间传String
	 */
	@Test
	public void postPublishDynamicsTestAudioTimeIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", "fdgerew");
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("音频时间传String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 音频时间不传
	 */
	@Test
	public void postPublishDynamicsTestAudioTimeNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("音频时间不传" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 音频时间传空非音频动态
	 */
	@Test
	public void postPublishDynamicsTestAudioTimeIsEmptyDynamicTypeNot4() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", "");
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("音频时间传空非音频动态" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 音频时间传空格非音频动态
	 */
	@Test
	public void postPublishDynamicsTestAudioTimeIsSpaceDynamicTypeNot4() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", " ");
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("音频时间传空格非音频动态" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 音频时间传null非音频动态
	 */
	@Test
	public void postPublishDynamicsTestAudioTimeIsNullDynamicTypeNot4() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", null);
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("音频时间传null非音频动态" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 音频时间不传非音频动态
	 */
	@Test
	public void postPublishDynamicsTestAudioTimeNonSubmissionParametersDynamicTypeNot4() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 5);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", "fdgerew");
		con.put("selectIds", 1319);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("音频时间不传非音频动态" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 不可见看动态的人Id传空
	 */
	@Test
	public void postPublishDynamicsTestSelectIdsIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 8);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", "");
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("不可见看动态的人Id传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 不可见看动态的人Id传空格
	 */
	@Test
	public void postPublishDynamicsTestSelectIdsIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 8);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", " ");
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("不可见看动态的人Id传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 不可见看动态的人Id传null
	 */
	@Test
	public void postPublishDynamicsTestSelectIdsIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 8);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", null);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("不可见看动态的人Id传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 不可见看动态的人Id传0
	 */
	@Test
	public void postPublishDynamicsTestSelectIdsIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 8);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", 0);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("不可见看动态的人Id传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 不可见看动态的人Id传负数
	 */
	@Test
	public void postPublishDynamicsTestSelectIdsIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 8);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", "-12495396");
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("不可见看动态的人Id传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 不可见看动态的人Id传小数
	 */
	@Test
	public void postPublishDynamicsTestSelectIdsIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 8);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", "1249.2396");
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("不可见看动态的人Id传小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 不可见看动态的人Id不传
	 */
	@Test
	public void postPublishDynamicsTestSelectIdsNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 8);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("不可见看动态的人Id不传" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 不可见看动态的人Id传多个
	 */
	@Test
	public void postPublishDynamicsTestSelectIdsIsMany() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 8);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", "12495396,12495263,12495666,12495555,12495326");
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("不可见看动态的人Id传多个" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 不可见看动态的人Id传空动态类型非7或8
	 */
	@Test
	public void postPublishDynamicsTestSelectIdsIsEmptyDynamicTypeNot7Or8() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", "");
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("不可见看动态的人Id传空动态类型非7或8" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 不可见看动态的人Id传空格动态类型非7或8
	 */
	@Test
	public void postPublishDynamicsTestSelectIdsIsSpaceDynamicTypeNot7Or8() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", " ");
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("不可见看动态的人Id传空格动态类型非7或8" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 不可见看动态的人Id不传动态类型非7或8
	 */
	@Test
	public void postPublishDynamicsTestSelectIdsNonSubmissionParametersDynamicTypeNot7Or8() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("不可见看动态的人Id不传动态类型非7或8" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 不可见看动态的人Id传null动态类型非7或8
	 */
	@Test
	public void postPublishDynamicsTestSelectIdsIsNullDynamicTypeNot7Or8() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", null);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("不可见看动态的人Id传null动态类型非7或8" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 可见看动态的人Id传多个
	 */
	@Test
	public void postPublishDynamicsTestSelectIdsIsManyDynamicTypeIs7() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", "12495666,12495639,12495236,12495689,12495266");
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("不可见看动态的人Id传null动态类型非7或8" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 可见看动态的人Id传用户本人id
	 */
	@Test
	public void postPublishDynamicsTestSelectIdsIsUserIdDynamicTypeIs7() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", uuid);
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("不可见看动态的人Id传用户本人id" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 是否显示位置信息传负数
	 */
	@Test
	public void postPublishDynamicsTestIsShowAreaIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", "12495366");
		con.put("isShowArea", -1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("是否显示位置信息传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 是否显示位置信息传小数
	 */
	@Test
	public void postPublishDynamicsTestIsShowAreaIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", "12495366");
		con.put("isShowArea", 1.23);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("是否显示位置信息传小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 是否显示位置信息传0
	 */
	@Test
	public void postPublishDynamicsTestIsShowAreaIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", "12495366");
		con.put("isShowArea", 0);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("是否显示位置信息传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 是否显示位置信息传空
	 */
	@Test
	public void postPublishDynamicsTestIsShowAreaIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", "12495366");
		con.put("isShowArea", "");
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("是否显示位置信息传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 是否显示位置信息传空格
	 */
	@Test
	public void postPublishDynamicsTestIsShowAreaIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", "12495366");
		con.put("isShowArea", " ");
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("是否显示位置信息传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 是否显示位置信息传null
	 */
	@Test
	public void postPublishDynamicsTestIsShowAreaIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", "12495366");
		con.put("isShowArea", null);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("是否显示位置信息传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 是否显示位置信息传1
	 */
	@Test
	public void postPublishDynamicsTestIsShowAreaIs1() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", "12495366");
		con.put("isShowArea", 1);
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("是否显示位置信息传1" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 是否显示位置信息不传
	 */
	@Test
	public void postPublishDynamicsTestIsShowAreaNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", "12495366");
		con.put("relayId", 1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("是否显示位置信息不传" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 转发动态id传负数
	 */
	@Test
	public void postPublishDynamicsTestRelayIdIsNegativeNumber() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", "12495366");
		con.put("isShowArea", 0);
		con.put("relayId", -1319);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("转发动态id传负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 转发动态id传小数
	 */
	@Test
	public void postPublishDynamicsTestRelayIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", "12495366");
		con.put("isShowArea", 0);
		con.put("relayId", 13.19);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("转发动态id传小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 转发动态id传0
	 */
	@Test
	public void postPublishDynamicsTestRelayIdIs0() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", "12495366");
		con.put("isShowArea", 0);
		con.put("relayId", 0);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("转发动态id传0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 转发动态id传空
	 */
	@Test
	public void postPublishDynamicsTestRelayIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", "12495366");
		con.put("isShowArea", 0);
		con.put("relayId", "");	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("转发动态id传空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 转发动态id传空格
	 */
	@Test
	public void postPublishDynamicsTestRelayIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", "12495366");
		con.put("isShowArea", 0);
		con.put("relayId", " ");	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("转发动态id传空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 转发动态id传null
	 */
	@Test
	public void postPublishDynamicsTestRelayIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", "12495366");
		con.put("isShowArea", 0);
		con.put("relayId", null);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("转发动态id传null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 转发动态id传String
	 */
	@Test
	public void postPublishDynamicsTestRelayIdIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", "12495366");
		con.put("isShowArea", 0);
		con.put("relayId", "SDFDSFSD");	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("转发动态id传String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 转发动态id不传
	 */
	@Test
	public void postPublishDynamicsTestRelayIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", "12495366");
		con.put("isShowArea", 0);
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("转发动态id不传" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 转发动态id为未登陆用户
	 */
	@Test
	public void postPublishDynamicsTestRelayIdIsNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", "12495366");
		con.put("isShowArea", 0);
		con.put("relayId", 12495326);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("转发动态id为未登陆用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 转发动态id为错误
	 */
	@Test
	public void postPublishDynamicsTestRelayIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", uuid);
		con.put("fileIds", 1);
		con.put("content", "老铁6666");
		con.put("dynamicType", 0);
		con.put("longitude", 55.63);
		con.put("latitude", 23.66);
		con.put("dynamicAddress", "如日商务园");
		con.put("mapLongitude", 25.36);
		con.put("mapLatitude", 88.26);
		con.put("region", "浦东新区");
		con.put("address", "上南路3855号");
		con.put("fileId", 1319);
		con.put("zoomLevel", 22.3);
		con.put("powerType", 0);
		con.put("atUserIds", "1319");
		con.put("audioTime", 12.3);
		con.put("selectIds", "12495366");
		con.put("isShowArea", 0);
		con.put("relayId", 1245);	

		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("转发动态id为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	
}