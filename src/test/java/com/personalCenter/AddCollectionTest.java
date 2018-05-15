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
import com.example.LoginTest;

public class AddCollectionTest extends HttpUtil {
//添加收藏接口
	String url = "/UU/addcollection";
	String chcode;
	LoginTest login = new LoginTest();
	@BeforeClass
	public void  beforeClass(){
		
		try {
			chcode = login.getLoginTestChcodeBy177();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * 正确参数查询
	 */
	@Test
	public void postAddCollectionTestCorrectParameter() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg",msg );
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("正确参数查询" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postAddCollectionTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postAddCollectionTestUserIdIsError() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postAddCollectionTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "#$%+(");
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postAddCollectionTestUserIdIsDecimal() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12.4917);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("正确参数查询" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postAddCollectionTestUserIdIsNegativeNumbe() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -1249);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
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
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postAddCollectionTestUserIdIsSpace() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
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
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postAddCollectionTestUserIdIsEmpty() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
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
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postAddCollectionTestUserIdNull() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
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
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postAddCollectionTestUserIdIsZero() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
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
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postAddCollectionTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
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
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏类型错误
	 */
	@Test
	public void postAddCollectionTestFavoriteTypeIsError() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 30);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏类型错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏类型为String
	 */
	@Test
	public void postAddCollectionTestFavoriteTypeIsString() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", "dffgg");
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏类型为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏类型为最大值
	 */
	@Test
	public void postAddCollectionTestFavoriteTypeIsMax() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 999999999);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏类型为最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏类型为商品6
	 */
	@Test
	public void postAddCollectionTestFavoriteTypeIsSix() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏类型为商铺17
	 */
	@Test
	public void postAddCollectionTestFavoriteTypeIsSeventeen() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏类型为商铺17" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏类型为小数
	 */
	@Test
	public void postAddCollectionTestFavoriteTypeIsDecimal() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6.23);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏类型为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏类型为0
	 */
	@Test
	public void postAddCollectionTestFavoriteTypeIsZero() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 0);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏类型为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏类型为空
	 */
	@Test
	public void postAddCollectionTestFavoriteTypeIsEmpty() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", "");
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏类型为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏类型为空格
	 */
	@Test
	public void postAddCollectionTestFavoriteTypeIsSpace() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", " ");
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏类型为非法字符
	 */
	@Test
	public void postAddCollectionTestFavoriteTypeIsIllegalCharacters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", "<@^&)+>");
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏类型为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏类型不传该参数
	 */
	@Test
	public void postAddCollectionTestFavoriteTypeNonSubmissionParameters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏类型不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 聊天信息时间戳为00000000
	 */
	@Test
	public void postAddCollectionTestTimeStampIs00000000() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", " ");
		con.put("timeStamp", 00000000);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("聊天信息时间戳为00000000" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 聊天信息时间戳为最大值时间戳
	 */
	@Test
	public void postAddCollectionTestTimeStampIsMax() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 9999999999999L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("聊天信息时间戳为最大值时间戳" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 聊天信息时间戳为错误时间戳
	 */
	@Test
	public void postAddCollectionTestTimeStampIsError() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("聊天信息时间戳为错误时间戳" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 聊天信息时间戳为YYYY-MM-DD
	 */
	@Test
	public void postAddCollectionTestTimeStampIsYYYYMMDD() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", "2018-05-08");
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("聊天信息时间戳为YYYY-MM-DD" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 聊天信息时间戳为负数
	 */
	@Test
	public void postAddCollectionTestTimeStampIsNegativeNumbe() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", -1476096258);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("聊天信息时间戳为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 聊天信息时间戳为小数
	 */
	@Test
	public void postAddCollectionTestTimeStampIsDecimal() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 14.76096258);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("聊天信息时间戳为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 聊天信息时间戳为String
	 */
	@Test
	public void postAddCollectionTestTimeStampIsString() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", "bbghsdfdsf");
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("聊天信息时间戳为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 聊天信息时间戳为空
	 */
	@Test
	public void postAddCollectionTestTimeStampIsEmpty() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", "");
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("聊天信息时间戳为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 聊天信息时间戳为空格
	 */
	@Test
	public void postAddCollectionTestTimeStampIsSpace() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", " ");
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("聊天信息时间戳为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 聊天信息时间戳为null
	 */
	@Test
	public void postAddCollectionTestTimeStampIsNull() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", null);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("聊天信息时间戳为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 聊天信息时间戳为非法字符
	 */
	@Test
	public void postAddCollectionTestTimeStampIsIllegalCharacters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", "<#*+$>");
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("聊天信息时间戳为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 聊天信息时间戳不传该参数
	 */
	@Test
	public void postAddCollectionTestTimeStampNonSubmissionParameters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
	
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("聊天信息时间戳不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 信息发布人用户id错误
	 */
	@Test
	public void postAddCollectionTestObjectIdIsError() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("信息发布人用户id错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 信息发布人用户id为非法字符
	 */
	@Test
	public void postAddCollectionTestObjectIdIsIllegalCharacters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", "<@&+$>");
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("信息发布人用户id为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 信息发布人用户id为小数
	 */
	@Test
	public void postAddCollectionTestObjectIdIsDecimal() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12.3456);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("信息发布人用户id为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 信息发布人用户id负数
	 */
	@Test
	public void postAddCollectionTestObjectIdIsNegativeNumbe() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", -12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("信息发布人用户id负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 信息发布人用户id为0
	 */
	@Test
	public void postAddCollectionTestObjectIdIsZero() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 0);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("信息发布人用户id为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 信息发布人用户id为超长
	 */
	@Test
	public void postAddCollectionTestObjectIdIsLong() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 1234567846767676775L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("信息发布人用户id为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 信息发布人用户id为String
	 */
	@Test
	public void postAddCollectionTestObjectIdIsString() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", "dgfgdds");
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("信息发布人用户id为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 信息发布人用户id为空
	 */
	@Test
	public void postAddCollectionTestObjectIdIsEmpty() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", "");
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("信息发布人用户id为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 信息发布人用户id为空格
	 */
	@Test
	public void postAddCollectionTestObjectIdIsSpace() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", " ");
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("信息发布人用户id为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 信息发布人用户id为null
	 */
	@Test
	public void postAddCollectionTestObjectIdIsNull() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", null);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("信息发布人用户id为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 信息发布人用户id不传该参数
	 */
	@Test
	public void postAddCollectionTestObjectIdNonSubmissionParameters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("信息发布人用户id不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏内容与来源不符
	 */
	@Test
	public void postAddCollectionTestMsgAndFavoriteSourceNotMatch() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg",msg );
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏内容与来源不符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品ID为错误
	 */
	@Test
	public void postAddCollectionTestMsgGoodIdIsError() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品ID为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品ID为超长
	 */
	@Test
	public void postAddCollectionTestMsgGoodIdIsLong() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",1012910254L);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品ID为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品ID为空
	 */
	@Test
	public void postAddCollectionTestMsgGoodIdIsEmpty() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId","");//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品ID为空格
	 */
	@Test
	public void postAddCollectionTestMsgGoodIdIsSpace() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId"," ");//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg );
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品ID为Null
	 */
	@Test
	public void postAddCollectionTestMsgGoodIdIsNull() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",null);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品ID为Null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品ID为String
	 */
	@Test
	public void postAddCollectionTestMsgGoodIdIsString() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId","dfdgs");//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品ID为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品ID为小数
	 */
	@Test
	public void postAddCollectionTestMsgGoodIdIsDecimal() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10.129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品ID为负数
	 */
	@Test
	public void postAddCollectionTestMsgGoodIdIsNegativeNumbe() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",-10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品ID为0
	 */
	@Test
	public void postAddCollectionTestMsgGoodIdIsZero() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",0);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品ID不传该参数
	 */
	@Test
	public void postAddCollectionTestMsgGoodIdNonSubmissionParameters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品名字和商品ID不符
	 */
	@Test
	public void postAddCollectionTestMsgGoodNameAndGoodIdNotMatch() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品名字和商品ID不符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品名字为空
	 */
	@Test
	public void postAddCollectionTestMsgGoodNameIsEmpty() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品名字为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品名字为空格
	 */
	@Test
	public void postAddCollectionTestMsgGoodNameIsSpace() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName"," ");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品名字为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品名字为非法字符
	 */
	@Test
	public void postAddCollectionTestMsgGoodNameIsIllegalCharacters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","<@^*_>");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品名字为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	/**
	 * 收藏电商商品名字为null
	 */
	@Test
	public void postAddCollectionTestMsgGoodNameIsNull() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","null");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品名字为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品名字为超长
	 */
	@Test
	public void postAddCollectionTestMsgGoodNameIsLong() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特尽快解决来得及发了大量精力的可怜的的快捷键");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品名字为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品名字不传该参数
	 */
	@Test
	public void postAddCollectionTestMsgGoodNameNonSubmissionParameters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品名字不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品缩略图url错误地址
	 */
	@Test
	public void postAddCollectionTestMsgGoodUrlIsError() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品缩略图url错误地址" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品缩略图url超长
	 */
	@Test
	public void postAddCollectionTestMsgGoodUrlIsLong() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品缩略图url超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品缩略图url存在非法字符
	 */
	@Test
	public void postAddCollectionTestMsgGoodUrlIsIllegalCharacters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品缩略图url存在非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品缩略图url为空
	 */
	@Test
	public void postAddCollectionTestMsgGoodUrlIsEmpty() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品缩略图url为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品缩略图url为空格
	 */
	@Test
	public void postAddCollectionTestMsgGoodUrlIsSpace() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl"," ");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品缩略图url为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品缩略图url为null
	 */
	@Test
	public void postAddCollectionTestMsgGoodUrlIsNull() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl",null);
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品缩略图url为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品缩略图url不传该参数
	 */
	@Test
	public void postAddCollectionTestMsgGoodUrlNonSubmissionParameters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品缩略图url不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品状态0待上架
	 */
	@Test
	public void postAddCollectionTestMsgGoodSatusIsZero() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",0);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品状态0待上架" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品状态1上架中
	 */
	@Test
	public void postAddCollectionTestMsgGoodSatusIsOne() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品状态1上架中" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品状态2已下架
	 */
	@Test
	public void postAddCollectionTestMsgGoodSatusIsTwo() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",2);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品状态2已下架" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品状态3草稿箱
	 */
	@Test
	public void postAddCollectionTestMsgGoodSatusIsThree() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品状态3草稿箱" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品状态为错误
	 */
	@Test
	public void postAddCollectionTestMsgGoodSatusIsError() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",99);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品状态为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品状态为小数
	 */
	@Test
	public void postAddCollectionTestMsgGoodSatusIsDecimal() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1.23);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品状态为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品状态为负数
	 */
	@Test
	public void postAddCollectionTestMsgGoodSatusIsNegativeNumbe() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",-1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品状态为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品状态为String
	 */
	@Test
	public void postAddCollectionTestMsgGoodSatusIsString() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus","dfdfds");
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品状态为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品状态为空格
	 */
	@Test
	public void postAddCollectionTestMsgGoodSatusIsSpace() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus"," ");
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品状态为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品状态为空
	 */
	@Test
	public void postAddCollectionTestMsgGoodSatusIsEmpty() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus","");
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品状态为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品状态为null
	 */
	@Test
	public void postAddCollectionTestMsgGoodSatusIsNull() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",null);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品状态为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品状态为最大值
	 */
	@Test
	public void postAddCollectionTestMsgGoodSatusIsMax() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",999999999);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品状态为最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品状态不传该参数
	 */
	@Test
	public void postAddCollectionTestMsgGoodSatusNonSubmissionParameters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品状态不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品标签为超长
	 */
	@Test
	public void postAddCollectionTestMsgGoodTagsIsLong() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice,instestingnicefdsfsffggg");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品标签为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品标签为空格
	 */
	@Test
	public void postAddCollectionTestMsgGoodTagsIsSpace() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags"," ");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品标签为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品标签为空
	 */
	@Test
	public void postAddCollectionTestMsgGoodTagsIsEmpty() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus"," ");
		msg.put("goodTags","");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品标签为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品标签为null
	 */
	@Test
	public void postAddCollectionTestMsgGoodTagsIsNull() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags",null);
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品标签为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品标签不传该参数
	 */
	@Test
	public void postAddCollectionTestMsgGoodTagsNonSubmissionParameters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品标签不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品标签存在非法字符
	 */
	@Test
	public void postAddCollectionTestMsgGoodTagsIsIllegalCharacters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","<#$&(>,instesting,nice");
		msg.put("goodPrice",10.20);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品标签存在非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品价格为最大值
	 */
	@Test
	public void postAddCollectionTestMsgGoodPriceIsMax() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",999999999);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品价格为最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品价格为5位小数
	 */
	@Test
	public void postAddCollectionTestMsgGoodTagsIsFiveDecimal() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",10.20326);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品价格为5位小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品价格为0.0000
	 */
	@Test
	public void postAddCollectionTestMsgGoodPriceIs0Spot0000() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",0.0000);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品价格为0.0000" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品价格为String
	 */
	@Test
	public void postAddCollectionTestMsgGoodPriceIsString() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice","GGAFSB");
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品价格为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品价格为最小值
	 */
	@Test
	public void postAddCollectionTestMsgGoodPriceIsMinimum() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",0);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品价格为最小值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品价格为超范围
	 */
	@Test
	public void postAddCollectionTestMsgGoodPriceOverRange() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",9999999999L);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品价格为超范围" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品价格分数
	 */
	@Test
	public void postAddCollectionTestMsgGoodPriceIsFraction() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",60/13);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品价格分数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品价格为运算式1+1
	 */
	@Test
	public void postAddCollectionTestMsgGoodPriceIsOperationalFormula() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",1+1);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品价格为运算式1+1" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品价格为空
	 */
	@Test
	public void postAddCollectionTestMsgGoodPriceIsIsEmpty() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice","");
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品价格为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品价格为空格
	 */
	@Test
	public void postAddCollectionTestMsgGoodPriceIsSpace() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice"," ");
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品价格为最小值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品价格为null
	 */
	@Test
	public void postAddCollectionTestMsgGoodPriceIsNull() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		msg.put("goodPrice",null);
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品价格为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商商品价格不传该值
	 */
	@Test
	public void postAddCollectionTestMsgGoodPriceNonSubmissionParameters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("goodId",10129);//"goodId":"10129","goodName":"他是特","goodUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","goodSatus":"1","goodTags":"[fun,instesting,nice]","goodPrice":"10.20"
		msg.put("goodName","他是特");
		msg.put("goodUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("goodSatus",1);
		msg.put("goodTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商商品价格不传该值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺ID为错误
	 */
	@Test
	public void postAddCollectionTestMsgShopIdIsError() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId",1012);//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺ID为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺ID为超长
	 */
	@Test
	public void postAddCollectionTestMsgShopIdIsLong() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId",1012121231L);//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺ID为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺ID为空
	 */
	@Test
	public void postAddCollectionTestMsgShopIdIsEmpty() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺ID为空格
	 */
	@Test
	public void postAddCollectionTestMsgShopIdIsSpace() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId"," ");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺ID为Null
	 */
	@Test
	public void postAddCollectionTestMsgShopIdIsNull() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId",null);//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺ID为Null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺ID为String
	 */
	@Test
	public void postAddCollectionTestMsgShopIdIsString() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","cgfggdf");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺ID为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺ID为小数
	 */
	@Test
	public void postAddCollectionTestMsgShopIdIsDecimal() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","10.12");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺ID为负数
	 */
	@Test
	public void postAddCollectionTestMsgShopIdIsNegativeNumbe() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","-1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺ID为0
	 */
	@Test
	public void postAddCollectionTestMsgShopIdIsZero() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId",0);//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺ID不传该参数
	 */
	@Test
	public void postAddCollectionTestMsgShopIdNonSubmissionParameters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺名字和店铺ID不符
	 */
	@Test
	public void postAddCollectionTestMsgShopIdAndShopNameNotMatch() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺名字和店铺ID不符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺名字为空
	 */
	@Test
	public void postAddCollectionTestMsgShopNameIsEmpty() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺名字为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺名字为空格
	 */
	@Test
	public void postAddCollectionTestMsgShopNameIsSpace() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName"," ");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺名字为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺名字为非法字符
	 */
	@Test
	public void postAddCollectionTestMsgShopNameIsIllegalCharacters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","<@$%*)>");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺名字为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺名字为null
	 */
	@Test
	public void postAddCollectionTestMsgShopNameIsNull() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName",null);
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺名字为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺名字为超长
	 */
	@Test
	public void postAddCollectionTestMsgShopNameIsLong() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特仿盛大私服技术等级奖励是开放的死灵法师JFK就看见艰苦的发生的事");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺名字为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺名字不传该参数
	 */
	@Test
	public void postAddCollectionTestMsgShopNameNonSubmissionParameters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺名字不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺缩略图url错误地址
	 */
	@Test
	public void postAddCollectionTestMsgShopUrlIsError() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺缩略图url错误地址" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺缩略图url超长
	 */
	@Test
	public void postAddCollectionTestMsgShopUrlIsLong() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺缩略图url超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺缩略图url存在非法字符
	 */
	@Test
	public void postAddCollectionTestMsgShopUrlIsIllegalCharacters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺缩略图url存在非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺缩略图url为空
	 */
	@Test
	public void postAddCollectionTestMsgShopUrlIsEmpty() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺缩略图url为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺缩略图url为空格
	 */
	@Test
	public void postAddCollectionTestMsgShopUrlIsSpace() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl"," ");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺缩略图url为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺缩略图url为null
	 */
	@Test
	public void postAddCollectionTestMsgShopUrlIsNull() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl",null);
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺缩略图url为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺缩略图url不传该参数
	 */
	@Test
	public void postAddCollectionTestMsgShopUrlNonSubmissionParameters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺缩略图url不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺状态0待上架
	 */
	@Test
	public void postAddCollectionTestMsgShopSatusIsZero() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",0);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺状态0待上架" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺状态1上架中
	 */
	@Test
	public void postAddCollectionTestMsgShopSatusIsOne() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺状态1上架中" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺状态2已下架
	 */
	@Test
	public void postAddCollectionTestMsgShopSatusIsTwo() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",2);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺状态2已下架" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺状态3草稿箱
	 */
	@Test
	public void postAddCollectionTestMsgShopSatusIsThree() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",3);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺状态3草稿箱" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺状态为错误
	 */
	@Test
	public void postAddCollectionTestMsgShopSatusIsError() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",99);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺状态为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺状态为小数
	 */
	@Test
	public void postAddCollectionTestMsgShopSatusIsDecimal() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1.45);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺状态为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺状态为负数
	 */
	@Test
	public void postAddCollectionTestMsgShopSatusIsNegativeNumbe() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",-1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺状态为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺状态为String
	 */
	@Test
	public void postAddCollectionTestMsgShopSatusIsString() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus","dfdsf");
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺状态为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺状态为空格
	 */
	@Test
	public void postAddCollectionTestMsgShopSatusIsSpace() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus"," ");
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺状态为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺状态为空
	 */
	@Test
	public void postAddCollectionTestMsgShopSatusIsEmpty() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus","");
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺状态为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺状态为null
	 */
	@Test
	public void postAddCollectionTestMsgShopSatusIsNull() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",null);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺状态为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺状态为最大值
	 */
	@Test
	public void postAddCollectionTestMsgShopSatusIsMax() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",999999999);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺状态为最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺状态不传该参数
	 */
	@Test
	public void postAddCollectionTestMsgShopSatusNonSubmissionParameters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺状态不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺标签为超长
	 */
	@Test
	public void postAddCollectionTestMsgShopTagsIsLong() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nicedgsfgdsgdfghghgfhhrtrjhjggffgfd");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺标签为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺标签为空格
	 */
	@Test
	public void postAddCollectionTestMsgShopTagsIsSpace() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags"," ");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺标签为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺标签为空
	 */
	@Test
	public void postAddCollectionTestMsgShopTagsIsEmpty() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺标签为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺标签为null
	 */
	@Test
	public void postAddCollectionTestMsgShopTagsIsNull() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags",null);
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺标签为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺标签不传该参数
	 */
	@Test
	public void postAddCollectionTestMsgShopTagsNonSubmissionParameters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺标签不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏电商店铺标签存在非法字符
	 */
	@Test
	public void postAddCollectionTestMsgShopTagsIsIllegalCharacters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","<%&*+>");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 11L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏电商店铺标签存在非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 唯一标识id为超长
	 */
	@Test
	public void postAddCollectionTestUniqueIdIsLong() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 9999999999999L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("唯一标识id为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 唯一标识id为空格
	 */
	@Test
	public void postAddCollectionTestUniqueIdIsSpace() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", " ");
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("唯一标识id为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 唯一标识id为空
	 */
	@Test
	public void postAddCollectionTestUniqueIdIsEmpty() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", "");
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("唯一标识id为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 唯一标识id为非法字符
	 */
	@Test
	public void postAddCollectionTestUniqueIdIsIllegalCharacters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", "<@#%*&>");
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("唯一标识id为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 唯一标识id为null
	 */
	@Test
	public void postAddCollectionTestUniqueIdIsNull() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", null);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("唯一标识id为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 唯一标识id为小数
	 */
	@Test
	public void postAddCollectionTestUniqueIdIsDecimal() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10.3);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("唯一标识id为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 唯一标识id为0
	 */
	@Test
	public void postAddCollectionTestUniqueIdIsZero() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 0);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("唯一标识id为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 唯一标识id为负数
	 */
	@Test
	public void postAddCollectionTestUniqueIdIsNegativeNumbe() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", -11);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("唯一标识id为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 唯一标识id为String
	 */
	@Test
	public void postAddCollectionTestUniqueIdIsString() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", "dfsd");
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("唯一标识id为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 唯一标识id不传该参数
	 */
	@Test
	public void postAddCollectionTestUniqueIdNonSubmissionParameters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 17);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("唯一标识id不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏来源为错误
	 */
	@Test
	public void postAddCollectionTestFavoriteSourceIsError() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 99);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏来源为错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏来源为String
	 */
	@Test
	public void postAddCollectionTestFavoriteSourceIsString() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
	
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", "DFSDFS");
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏来源为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏来源为负数
	 */
	@Test
	public void postAddCollectionTestFavoriteSourceIsNegativeNumbe() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", -12);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏来源为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏来源为小数
	 */
	@Test
	public void postAddCollectionTestFavoriteSourceIsDecimal() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12.23);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏来源为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏来源为0
	 */
	@Test
	public void postAddCollectionTestFavoriteSourceIsZero() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 0);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏来源为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏来源为最大值
	 */
	@Test
	public void postAddCollectionTestFavoriteSourceIsMax() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 999999999);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏来源为最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏来源为长整型
	 */
	@Test
	public void postAddCollectionTestFavoriteSourceIsLongForm() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12L);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏来源为长整型" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏来源为空格
	 */
	@Test
	public void postAddCollectionTestFavoriteSourceIsSpace() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", " ");
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏来源为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏来源为空
	 */
	@Test
	public void postAddCollectionTestFavoriteSourceIsEmpty() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", "");
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏来源为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏来源为null
	 */
	@Test
	public void postAddCollectionTestFavoriteSourceIsNull() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", null);
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏来源为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏来源不传该参数
	 */
	@Test
	public void postAddCollectionTestFavoriteSourceNonSubmissionParameters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		
		con.put("objectName", "hello");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏来源不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 信息发布人昵称超长
	 */
	@Test
	public void postAddCollectionTestObjectNameIsLong() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "helloDGGddddddFGDfsfdsfdfdssfgfhgfhfgfhfgh");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("信息发布人昵称超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 信息发布人昵称为空
	 */
	@Test
	public void postAddCollectionTestObjectNameIsEmpty() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("信息发布人昵称为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 信息发布人昵称为空格
	 */
	@Test
	public void postAddCollectionTestObjectNameIsSpace() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", " ");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("信息发布人昵称为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 信息发布人昵称为null
	 */
	@Test
	public void postAddCollectionTestObjectNameIsNull() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", null);
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("信息发布人昵称为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 信息发布人昵称为非法字符
	 */
	@Test
	public void postAddCollectionTestObjectNameIsIllegalCharacters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "<@#*(>");
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("信息发布人昵称为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 信息发布人昵称不传该参数
	 */
	@Test
	public void postAddCollectionTestObjectNameNonSubmissionParameters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		
		con.put("describe", "word");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("信息发布人昵称不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 描述超长
	 */
	@Test
	public void postAddCollectionTestDescribeIsLong() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "wordFdsffgfhghhjkdjsklfjklsjfdsffffgh");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("描述超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 描述为空
	 */
	@Test
	public void postAddCollectionTestDescribeIsEmpty() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("描述超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 描述为空格
	 */
	@Test
	public void postAddCollectionTestDescribeIsSpace() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", " ");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("描述为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 描述为null
	 */
	@Test
	public void postAddCollectionTestDescribeIsNull() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", null);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("描述为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 描述为非法字符
	 */
	@Test
	public void postAddCollectionTestDescribeIsIllegalCharacters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		con.put("describe", "<#$&*>");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("描述为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 描述不传该参数
	 */
	@Test
	public void postAddCollectionTestDescribeNonSubmissionParameters() throws Exception {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("shopId","1012");//"shopId":"1012","shopName":"他是特","shopUrl":"http://192.168.9.20:8088/index.php?s=/kabao&page_id=792","shopSatus":"1","shopTags":"[fun,instesting,nice]"
		msg.put("shopName","他是特");
		msg.put("shopUrl","http://192.168.9.20:8088/index.php?s=/kabao&page_id=792");
		msg.put("shopSatus",1);
		msg.put("shopTags","fun,instesting,nice");
		
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491737L);
		con.put("favoriteType", 6);
		con.put("timeStamp", 1476096258L);
		con.put("objectId", 12345678L);
		con.put("msg", msg);
		con.put("uniqueId", 10L);
		con.put("favoriteSource", 12);
		con.put("objectName", "hello");
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2111");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", chcode);
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("描述不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo("0");
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
}