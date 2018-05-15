package com.homePage;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;

public class SaveParametersTest extends HttpUtil {
// 保存板块参数接口
	String url = "/uu-admin/container/saveParameters";


	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postSaveParametersTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postSaveParametersTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "1aaa4");
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postSaveParametersTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "<$%^&*>");
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postSaveParametersTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1249.5324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postSaveParametersTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", -12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postSaveParametersTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", " ");
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postSaveParametersTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "");
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postSaveParametersTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", null);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postSaveParametersTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 轮播图播放时间为小数
	 */
	@Test
	public void postSaveParametersTestCarouselIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1.5);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("轮播图播放时间为小数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 轮播图播放时间为负数
	 */
	@Test
	public void postSaveParametersTestCarouselIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", -1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("轮播图播放时间为负数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 轮播图播放时间为字符
	 */
	@Test
	public void postSaveParametersTestCarouselIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", "carousel");
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("轮播图播放时间为字符" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 轮播图播放时间为0
	 */
	@Test
	public void postSaveParametersTestCarouselIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 0);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("轮播图播放时间为0" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 轮播图播放时间为最大值
	 */
	@Test
	public void postSaveParametersTestCarouselIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 999999999);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("轮播图播放时间为最大值" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 轮播图播放时间为长整型
	 */
	@Test
	public void postSaveParametersTestCarouselIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 9999999999999999L);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("轮播图播放时间为长整型" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 轮播图播放时间为空
	 */
	@Test
	public void postSaveParametersTestCarouselIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", "");
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("轮播图播放时间为空" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 轮播图播放时间为空格
	 */
	@Test
	public void postSaveParametersTestCarouselIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", " ");
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("轮播图播放时间为空格" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 轮播图播放时间为null
	 */
	@Test
	public void postSaveParametersTestCarouselIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", null);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("轮播图播放时间为null" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 轮播图播放时间不传该参数
	 */
	@Test
	public void postSaveParametersTestCarouselNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("轮播图播放时间不传该参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 *达人搜索结果罗列条数为小数
	 */
	@Test
	public void postSaveParametersTestBigGunCountIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1.5);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("达人搜索结果罗列条数为小数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 达人搜索结果罗列条数为负数
	 */
	@Test
	public void postSaveParametersTestBigGunCountIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", -1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("达人搜索结果罗列条数为负数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 达人搜索结果罗列条数为字符
	 */
	@Test
	public void postSaveParametersTestBigGunCountIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", "aaa");
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("达人搜索结果罗列条数为字符" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 达人搜索结果罗列条数为0
	 */
	@Test
	public void postSaveParametersTestBigGunCountIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 0);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("达人搜索结果罗列条数为0" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 达人搜索结果罗列条数为最大值
	 */
	@Test
	public void postSaveParametersTestBigGunCountIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 999999999);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("达人搜索结果罗列条数为最大值" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 达人搜索结果罗列条数为长整型
	 */
	@Test
	public void postSaveParametersTestBigGunCountIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 999999999999999L);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("达人搜索结果罗列条数为长整型" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 达人搜索结果罗列条数为空
	 */
	@Test
	public void postSaveParametersTestBigGunCountIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", "");
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("达人搜索结果罗列条数为空" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 达人搜索结果罗列条数为空格
	 */
	@Test
	public void postSaveParametersTestBigGunCountIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", " ");
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("达人搜索结果罗列条数为空格" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 达人搜索结果罗列条数为null
	 */
	@Test
	public void postSaveParametersTestBigGunCountIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", null);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("达人搜索结果罗列条数为null" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 达人搜索结果罗列条数不传该参数
	 */
	@Test
	public void postSaveParametersTestBigGunCountNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("达人搜索结果罗列条数不传该参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 电商搜索结果罗列条数为小数
	 */
	@Test
	public void postSaveParametersTestGoodsCountIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1.5);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("电商搜索结果罗列条数为小数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 电商搜索结果罗列条数为负数
	 */
	@Test
	public void postSaveParametersTestGoodsCountIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", -1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("电商搜索结果罗列条数为负数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 电商搜索结果罗列条数为字符
	 */
	@Test
	public void postSaveParametersTestGoodsCountIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", "aaaa");
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("电商搜索结果罗列条数为字符" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 电商搜索结果罗列条数为0
	 */
	@Test
	public void postSaveParametersTestGoodsCountZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 0);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("电商搜索结果罗列条数为0" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 电商搜索结果罗列条数为最大值
	 */
	@Test
	public void postSaveParametersTestGoodsCountIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 999999999);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("电商搜索结果罗列条数为最大值" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 电商搜索结果罗列条数为长整型
	 */
	@Test
	public void postSaveParametersTestGoodsCountIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 999999999999L);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("电商搜索结果罗列条数为长整型" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 电商搜索结果罗列条数为空
	 */
	@Test
	public void postSaveParametersTestGoodsCountIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", "");
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("电商搜索结果罗列条数为空" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 电商搜索结果罗列条数为空格
	 */
	@Test
	public void postSaveParametersTestGoodsCountIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", " ");
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("电商搜索结果罗列条数为空格" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 电商搜索结果罗列条数为null
	 */
	@Test
	public void postSaveParametersTestGoodsCountIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", null);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("电商搜索结果罗列条数为null" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 电商搜索结果罗列条数不传该参数
	 */
	@Test
	public void postSaveParametersTestGoodsCountNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("电商搜索结果罗列条数不传该参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 二手搜索结果罗列条数为小数
	 */
	@Test
	public void postSaveParametersTestUsedCountIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1.5);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("二手搜索结果罗列条数为小数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 二手搜索结果罗列条数为负数
	 */
	@Test
	public void postSaveParametersTestUsedCountIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", -1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("二手搜索结果罗列条数为负数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 二手搜索结果罗列条数为字符
	 */
	@Test
	public void postSaveParametersTestUsedCountIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", "aaaa");
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("二手搜索结果罗列条数为字符" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 二手搜索结果罗列条数为0
	 */
	@Test
	public void postSaveParametersTestUsedCountIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 0);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("二手搜索结果罗列条数为0" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 二手搜索结果罗列条数为最大值
	 */
	@Test
	public void postSaveParametersTestUsedCountIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 999999999);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("二手搜索结果罗列条数为最大值" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 二手搜索结果罗列条数为长整型
	 */
	@Test
	public void postSaveParametersTestUsedCountIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 999999999999L);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("二手搜索结果罗列条数为长整型" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 二手搜索结果罗列条数为空
	 */
	@Test
	public void postSaveParametersTestUsedCountIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", "");
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("二手搜索结果罗列条数为空" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 二手搜索结果罗列条数为空格
	 */
	@Test
	public void postSaveParametersTestUsedCountIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", " ");
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("二手搜索结果罗列条数为空格" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 二手搜索结果罗列条数不传该参数
	 */
	@Test
	public void postSaveParametersTestUsedCountNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("二手搜索结果罗列条数不传该参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 混合橱窗容器高度为小数
	 */
	@Test
	public void postSaveParametersTestMixtureHighIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1.5);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("混合橱窗容器高度为小数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 混合橱窗容器高度为负数
	 */
	@Test
	public void postSaveParametersTestMixtureHighIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", -1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("混合橱窗容器高度为负数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 混合橱窗容器高度为字符
	 */
	@Test
	public void postSaveParametersTestMixtureHighIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", "aaa");
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("混合橱窗容器高度为字符" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 混合橱窗容器高度为0
	 */
	@Test
	public void postSaveParametersTestMixtureHighIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 0);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("混合橱窗容器高度为0" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 混合橱窗容器高度为最大值
	 */
	@Test
	public void postSaveParametersTestMixtureHighIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 999999999);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("混合橱窗容器高度为最大值" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 混合橱窗容器高度为长整型
	 */
	@Test
	public void postSaveParametersTestMixtureHigh() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 999999999999L);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("混合橱窗容器高度为长整型" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 混合橱窗容器高度为空
	 */
	@Test
	public void postSaveParametersTestMixtureHighIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", "");
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("混合橱窗容器高度为空" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 混合橱窗容器高度为空格
	 */
	@Test
	public void postSaveParametersTestMixtureHighIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", " ");
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("混合橱窗容器高度为空格" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 混合橱窗容器高度为null
	 */
	@Test
	public void postSaveParametersTestMixtureHighIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", null);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("混合橱窗容器高度为null" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 混合橱窗容器高度不传该参数
	 */
	@Test
	public void postSaveParametersTestMixtureHighNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("混合橱窗容器高度不传该参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 达人橱窗高度为小数
	 */
	@Test
	public void postSaveParametersTestBigGunHighNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1.5);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("达人橱窗高度为小数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 达人橱窗高度为负数
	 */
	@Test
	public void postSaveParametersTestBigGunHighIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", -1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("达人橱窗高度为负数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 达人橱窗高度为字符
	 */
	@Test
	public void postSaveParametersTestBigGunHighIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", "aaaaaa");
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("达人橱窗高度为字符" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	
	
}