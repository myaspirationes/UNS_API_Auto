package com.personalCenter;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;

public class ObtainDetailsOfHolderPhotosTest extends HttpUtil {
//获取手持件照详情接口
	String url = "/UU/authenticate";
	
	

	/**
	 * 提交正确参数
	 */
	@Test
	public void postObtainDetailsOfHolderPhotosTestCorrectParameters() throws Exception {
		HolderPhotoAuthenticateTest hpa = new HolderPhotoAuthenticateTest();
		hpa.postHolderPhotoAuthenticateTestCorrectParameter();
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495417);

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", 3908);
		head.put("uuid", 12495417);
		head.put("ln", "cn");
		head.put("chcode", "ubd1yTW/Xcgx+ypradQi02IAGc5+AKvf");
		head.put("sync", 1);
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
	 * 用户ID为未登录用户
	 */
	//@Test
	public void postObtainDetailsOfHolderPhotosTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 1249541766);

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3908");
		head.put("uuid", "12495417");
		head.put("ln", "cn");
		head.put("chcode", "ubd1yTW/Xcgx+ypradQi02IAGc5+AKvf");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId数据格式不对");
	}
	/**
	 * 用户ID为错误用户
	 */
	//@Test
	public void postObtainDetailsOfHolderPhotosTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 1249541756);

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3908");
		head.put("uuid", "12495417");
		head.put("ln", "cn");
		head.put("chcode", "ubd1yTW/Xcgx+ypradQi02IAGc5+AKvf");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("userId数据格式不对");
	}
	/**
	 * 用户ID为非法字符
	 */
	//@Test
	public void postObtainDetailsOfHolderPhotosTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "<@$%^&*(_>");

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3908");
		head.put("uuid", "12495417");
		head.put("ln", "cn");
		head.put("chcode", "ubd1yTW/Xcgx+ypradQi02IAGc5+AKvf");
		head.put("sync", "1");
		head.put("mod", "ios");
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
	 * 用户ID为小数
	 */
	//@Test
	public void postObtainDetailsOfHolderPhotosTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12.499);

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3908");
		head.put("uuid", "12495417");
		head.put("ln", "cn");
		head.put("chcode", "ubd1yTW/Xcgx+ypradQi02IAGc5+AKvf");
		head.put("sync", "1");
		head.put("mod", "ios");
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
	//@Test
	public void postObtainDetailsOfHolderPhotosTestUserIdIsNegativeNumbe() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -1991L);

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3908");
		head.put("uuid", "12495417");
		head.put("ln", "cn");
		head.put("chcode", "ubd1yTW/Xcgx+ypradQi02IAGc5+AKvf");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("请输入有效的用户id");
	}
	/**
	 * 用户ID为空格
	 */
	//@Test
	public void postObtainDetailsOfHolderPhotosTestUserIdIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3908");
		head.put("uuid", "12495417");
		head.put("ln", "cn");
		head.put("chcode", "ubd1yTW/Xcgx+ypradQi02IAGc5+AKvf");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为空
	 */
	//@Test
	public void postObtainDetailsOfHolderPhotosTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3908");
		head.put("uuid", "12495417");
		head.put("ln", "cn");
		head.put("chcode", "ubd1yTW/Xcgx+ypradQi02IAGc5+AKvf");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("请输入有效的用户id");
	}
	/**
	 * 用户ID为null
	 */
	//@Test
	public void postObtainDetailsOfHolderPhotosTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3908");
		head.put("uuid", "12495417");
		head.put("ln", "cn");
		head.put("chcode", "ubd1yTW/Xcgx+ypradQi02IAGc5+AKvf");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("请输入有效的用户id");
	}
	/**
	 * 用户ID不传该参数
	 */
	//@Test
	public void postObtainDetailsOfHolderPhotosTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3908");
		head.put("uuid", "12495417");
		head.put("ln", "cn");
		head.put("chcode", "ubd1yTW/Xcgx+ypradQi02IAGc5+AKvf");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("请输入有效的用户id");
	}
	/**
	 * 用户ID为0
	 */
	//@Test
	public void postObtainDetailsOfHolderPhotosTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);

		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "1and6uu");
		head.put("de", "2011-07-13 00:00:00");
		head.put("ver", "1.0");
		head.put("cmd", "3908");
		head.put("uuid", "12495417");
		head.put("ln", "cn");
		head.put("chcode", "ubd1yTW/Xcgx+ypradQi02IAGc5+AKvf");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("请输入有效的用户id");
	}
	
	
	
		
	
}