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

public class CollectionListTest extends HttpUtil {
//获取收藏列表接口
	String url = "/UU/favorite";
	

	/**
	 * 正确参数查询
	 */
	@Test
	public void postCollectionListTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12495324);
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("正确参数查询" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postCollectionListTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postCollectionListTestUserIdIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postCollectionListTestUserIdIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "<@$%&*)_>");
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postCollectionListTestUserIdIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12.49);
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postCollectionListTestUserIdIsNegativeNumbe() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", -124);
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postCollectionListTestUserIdIsIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", " ");
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postCollectionListTestUserIdIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "");
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postCollectionListTestUserIdIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", null);
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("用户id不能为空");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postCollectionListTestUserIdIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 0);
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postCollectionListTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("用户id不能为空");
	}
	/**
	 * 收藏类型错误
	 */
	@Test
	public void postCollectionListTestFavoriteTypeIsError() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 20);
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏类型错误" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏类型为String
	 */
	@Test
	public void postCollectionListTestFavoriteTypeIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", "bghggs");
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏类型为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏类型为最大值
	 */
	@Test
	public void postCollectionListTestFavoriteTypeIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 999999999);
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏类型为最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏类型为商品6
	 */
	@Test
	public void postCollectionListTestFavoriteTypeIsGoodsSix() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 6);
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏类型为商品6" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 收藏类型为商铺17
	 */
	@Test
	public void postCollectionListTestFavoriteTypeIsShopsSeventeen() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 17);
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏类型为商铺17" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 收藏类型为负数
	 */
	@Test
	public void postCollectionListTestFavoriteTypeIsNegativeNumbe() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", -17);
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏类型为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏类型为小数
	 */
	@Test
	public void postCollectionListTestFavoriteTypeIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 1.7);
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏类型为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏类型为0
	 */
	@Test
	public void postCollectionListTestFavoriteTypeIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏类型为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 收藏类型为空
	 */
	@Test
	public void postCollectionListTestFavoriteTypeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", "");
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏类型为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏类型为空格
	 */
	@Test
	public void postCollectionListTestFavoriteTypeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", " ");
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏类型为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏类型为非法字符
	 */
	@Test
	public void postCollectionListTestFavoriteTypeIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", "<#%*_+>");
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏类型为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 收藏类型不传该参数
	 */
	@Test
	public void postCollectionListTestFavoriteTypeNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("收藏类型不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("收藏类型不能为空");
	}
	/**
	 * 当前页码为String
	 */
	@Test
	public void postCollectionListTestPageNowIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 1);
		con.put("pageNow", "vfhfg");
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 当前页码为小数
	 */
	@Test
	public void postCollectionListTestPageNowIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 1);
		con.put("pageNow", 12.3);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 当前页码为负数
	 */
	@Test
	public void postCollectionListTestPageNowIsNegativeNumbe() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 1);
		con.put("pageNow", -12);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 当前页码为0
	 */
	@Test
	public void postCollectionListTestPageNowIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 1);
		con.put("pageNow", 0);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 当前页码为最大值
	 */
	@Test
	public void postCollectionListTestPageNowIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 1);
		con.put("pageNow", 999999999);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页码为超长
	 */
	@Test
	public void postCollectionListTestPageNowIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 1);
		con.put("pageNow", 12491740L);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 当前页码为空
	 */
	@Test
	public void postCollectionListTestPageNowIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 1);
		con.put("pageNow", "");
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 当前页码为空格
	 */
	@Test
	public void postCollectionListTestPageNowIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 1);
		con.put("pageNow", " ");
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 当前页码为null
	 */
	@Test
	public void postCollectionListTestPageNowIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 1);
		con.put("pageNow", null);
		con.put("pageSize", 5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("当前页码不能为空");
	}
	/**
	 * 每页显示数量为String
	 */
	@Test
	public void postCollectionListTestPageSizeIsString() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", "FHHGDF");
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示数量为String" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 每页显示数量为小数
	 */
	@Test
	public void postCollectionListTestPageSizeIsDecimal() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", 5.36);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示数量为小数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 每页显示数量为负数
	 */
	@Test
	public void postCollectionListTestPageSizeIsNegativeNumbe() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", -5);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示数量为负数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 每页显示数量为0
	 */
	@Test
	public void postCollectionListTestPageSizeIsZero() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", 0);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示数量为0" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 每页显示数量为最大值
	 */
	@Test
	public void postCollectionListTestPageSizeIsMax() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", 999999999);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示数量为最大值" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	
	/**
	 * 每页显示数量为超长
	 */
	@Test
	public void postCollectionListTestPageSizeIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", 12491740L);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示数量为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 每页显示数量为空
	 */
	@Test
	public void postCollectionListTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", "");
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示数量为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 每页显示数量为空格
	 */
	@Test
	public void postCollectionListTestPageSizeIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", " ");
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示数量为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("上传成功");
	}
	/**
	 * 每页显示数量为null
	 */
	@Test
	public void postCollectionListTestpageSizeIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", null);
		con.put("keyWord", "fun");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页显示数量为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(-3);
		assertThat(head1.get("msg")).isEqualTo("每页显示数量不能为空");
	}
	/**
	 * 搜索关键字为超长
	 */
	@Test
	public void postCollectionListTestKeyWordIsLong() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "fungssssdggfffgfgddwgfggfghhgfhhgf");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("搜索关键字为超长" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 搜索关键字为非法字符
	 */
	@Test
	public void postCollectionListTestKeyWordIsIllegalCharacters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "<#&*_+>");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("搜索关键字为非法字符" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 搜索关键字为空
	 */
	@Test
	public void postCollectionListTestKeyWordIsEmpty() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", "");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("搜索关键字为空" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 搜索关键字为空格
	 */
	@Test
	public void postCollectionListTestKeyWordIsSpace() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", " ");
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("搜索关键字为空格" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 搜索关键字为null
	 */
	@Test
	public void postCollectionListTestKeyWordIsNull() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		con.put("keyWord", null);
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("搜索关键字为null" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	/**
	 * 搜索关键字不传该参数
	 */
	@Test
	public void postCollectionListTestKeyWordIsNonSubmissionParameters() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", 12491740L);
		con.put("favoriteType", 0);
		con.put("pageNow", 1);
		con.put("pageSize", 5);
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("ver", "1.2.1");
		head.put("cmd", "2112");
		head.put("uuid", "12495324");
		head.put("ln", "cn");
		head.put("chcode", "rd3p7fUEwnCNKyqMdND0NdKbX2bIK/6E");
		head.put("sync", "1");
		head.put("mod", "ios");
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		request.put("head", head);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("搜索关键字不传该参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	
	
	
	
	
	
	
}