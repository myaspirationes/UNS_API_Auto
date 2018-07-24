package com.homePage;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.MetaOper;
import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;

public class SaveParametersTest extends HttpUtil {
// 保存板块参数接口
	String url = "/uu-admin/container/saveParameters";
	//81环境
//	String selectCarousel = "SELECT * FROM T_DICT WHERE \"PARENT\" = 1100 AND \"DICT_ID\" = 10100";
//    String selectBigGunCount = "SELECT * FROM T_DICT WHERE \"PARENT\" = 1100 AND \"DICT_ID\" = 10101";
//    String selectGoodsCount = "SELECT * FROM T_DICT WHERE \"PARENT\" = 1100 AND \"DICT_ID\" = 10102";
//    String selectUsedCount = "SELECT * FROM T_DICT WHERE \"PARENT\" = 1100 AND \"DICT_ID\" = 10103";
//    String selectMixtureHigh = "SELECT * FROM T_DICT WHERE \"PARENT\" = 1100 AND \"DICT_ID\" = 10104";
//    String selectBigGunHigh = "SELECT * FROM T_DICT WHERE \"PARENT\" = 1100 AND \"DICT_ID\" = 10105";
//    String selectShopHigh = "SELECT * FROM T_DICT WHERE \"PARENT\" = 1100 AND \"DICT_ID\" = 10116";
//    String selectGoodsHigh = "SELECT * FROM T_DICT WHERE \"PARENT\" = 1100 AND \"DICT_ID\" = 10117";
//    String selectUsedHigh = "SELECT * FROM T_DICT WHERE \"PARENT\" = 1100 AND \"DICT_ID\" = 10107";

	//41环境
	String selectCarousel = "SELECT * FROM T_DICT WHERE PARENT = 1100 AND DICT_ID = 10099";
	String selectBigGunCount = "SELECT * FROM T_DICT WHERE PARENT = 1100 AND DICT_ID = 10100";
	String selectGoodsCount = "SELECT * FROM T_DICT WHERE PARENT = 1100 AND DICT_ID = 10101";
	String selectUsedCount = "SELECT * FROM T_DICT WHERE PARENT = 1100 AND DICT_ID = 10102";
	String selectMixtureHigh = "SELECT * FROM T_DICT WHERE PARENT = 1100 AND DICT_ID = 10103";
	String selectBigGunHigh = "SELECT * FROM T_DICT WHERE PARENT = 1100 AND DICT_ID = 10104";
	String selectShopHigh = "SELECT * FROM T_DICT WHERE PARENT = 1100 AND DICT_ID = 10105";
	String selectGoodsHigh = "SELECT * FROM T_DICT WHERE PARENT = 1100 AND DICT_ID = 10119";
	String selectUsedHigh = "SELECT * FROM T_DICT WHERE PARENT = 1100 AND DICT_ID = 10106";

	String dataType = "perCenter81";
	List<Map<String,Object>> list ;
	/**
	 * 恢复默认值
	 */
	@AfterClass
	public void postSaveParametersTestRestoreTheDefaultValue() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("恢复默认值" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectCarousel,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("5");
        list =MetaOper.read(selectBigGunCount,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("3");
        list =MetaOper.read(selectGoodsCount,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("3");
        list =MetaOper.read(selectUsedCount,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("3");
        list =MetaOper.read(selectMixtureHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("128");
        list =MetaOper.read(selectBigGunHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("128");
        list =MetaOper.read(selectShopHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("192");
        list =MetaOper.read(selectGoodsHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("192");
        list =MetaOper.read(selectUsedHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("192");
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
	 * 用户ID为未登录用户
	 */
	@Test
	public void postSaveParametersTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495325);
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
		assertThat(post.get("msg")).isEqualTo("用户未做校验");
	}
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postSaveParametersTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1111);
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
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
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
		assertThat(post.get("status")).isEqualTo(400);
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
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
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
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
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
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("缺少参数:userId");
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
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("缺少参数:userId");
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
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("缺少参数:userId");
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
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("缺少参数:userId");
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

		list =MetaOper.read(selectCarousel,dataType);
		assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("1");
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
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("轮播图播放间隔时间不能为小于0");
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
		assertThat(post.get("status")).isEqualTo(400);
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
        list =MetaOper.read(selectCarousel,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("5");
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
        list =MetaOper.read(selectCarousel,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("999999999");
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
		assertThat(post.get("status")).isEqualTo(400);
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
        list =MetaOper.read(selectCarousel,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("5");
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
        list =MetaOper.read(selectCarousel,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("5");
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
        list =MetaOper.read(selectCarousel,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("5");
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
        list =MetaOper.read(selectCarousel,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("5");
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
        list =MetaOper.read(selectBigGunCount,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("1");

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
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("达人搜索结果罗列条数不能小于0");
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
		assertThat(post.get("status")).isEqualTo(400);
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
        list =MetaOper.read(selectBigGunCount,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("0");
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
        list =MetaOper.read(selectBigGunCount,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("999999999");
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
		assertThat(post.get("status")).isEqualTo(400);
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
        list =MetaOper.read(selectBigGunCount,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("3");
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
        list =MetaOper.read(selectBigGunCount,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("3");
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
        list =MetaOper.read(selectBigGunCount,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("3");
	}
	/**
	 * 达人搜索结果罗列条数不传该参数
	 */
	@Test
	public void postSaveParametersTestBigGunCountNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		//request.put("bigGunCount", 1);
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
        list =MetaOper.read(selectBigGunCount,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("3");
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
        list =MetaOper.read(selectGoodsCount,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("1");
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
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("商品搜索结果罗列条数不能小于0");
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
		assertThat(post.get("status")).isEqualTo(400);
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
        list =MetaOper.read(selectGoodsCount,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("0");
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
        list =MetaOper.read(selectGoodsCount,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("999999999");
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
		assertThat(post.get("status")).isEqualTo(400);
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
        list =MetaOper.read(selectGoodsCount,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("3");
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
        list =MetaOper.read(selectGoodsCount,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("3");
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
        list =MetaOper.read(selectGoodsCount,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("3");
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
        list =MetaOper.read(selectGoodsCount,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("3");
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
        list =MetaOper.read(selectUsedCount,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("1");
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
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("二手搜索结果罗列条数不能小于0");
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
		assertThat(post.get("status")).isEqualTo(400);
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
        list =MetaOper.read(selectUsedCount,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("0");
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
        list =MetaOper.read(selectUsedCount,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("999999999");
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
		assertThat(post.get("status")).isEqualTo(400);
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
        list =MetaOper.read(selectUsedCount,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("3");
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
        list =MetaOper.read(selectUsedCount,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("3");
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
        list =MetaOper.read(selectUsedCount,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("3");
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
        list =MetaOper.read(selectMixtureHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("1");
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
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("混合橱窗容器高度不能小于0");
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
		assertThat(post.get("status")).isEqualTo(400);

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
        list =MetaOper.read(selectMixtureHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("216");
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
        list =MetaOper.read(selectMixtureHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("999999999");
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
		assertThat(post.get("status")).isEqualTo(400);

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
        list =MetaOper.read(selectMixtureHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("216");
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
        list =MetaOper.read(selectMixtureHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("216");
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
        list =MetaOper.read(selectMixtureHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("216");
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
        list =MetaOper.read(selectMixtureHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("216");
	}
	/**
	 * 达人橱窗高度为小数
	 */
	@Test
	public void postSaveParametersTestBigGunHighIsDecimal() throws Exception {
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
        list =MetaOper.read(selectBigGunHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("1");
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
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("达人橱窗高度不能小于0");
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
		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 达人橱窗高度为0
	 */
	@Test
	public void postSaveParametersTestBigGunHighIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 0);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("达人橱窗高度为0" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectBigGunHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("216");
	}
	/**
	 * 达人橱窗高度为最大值
	 */
	@Test
	public void postSaveParametersTestBigGunHighIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 999999999);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("达人橱窗高度为最大值" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectBigGunHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("999999999");
	}
	/**
	 * 达人橱窗高度为长整型
	 */
	@Test
	public void postSaveParametersTestBigGunHigh() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 999999999999L);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(400);

	}
	/**
	 * 达人橱窗高度为空
	 */
	@Test
	public void postSaveParametersTestBigGunHighIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", "");
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("达人橱窗高度为空" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectBigGunHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("216");
	}
	/**
	 * 达人橱窗高度为空格
	 */
	@Test
	public void postSaveParametersTestBigGunHighIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", " ");
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("达人橱窗高度为空格" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectBigGunHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("216");
	}
	/**
	 * 达人橱窗高度为null
	 */
	@Test
	public void postSaveParametersTestBigGunHighIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", null);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("达人橱窗高度为null" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectBigGunHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("216");
	}
	/**
	 * 达人橱窗高度不传该参数
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
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("达人橱窗高度不传该参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectBigGunHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("216");
	}
	/**
	 * 店铺板块高度为小数
	 */
	@Test
	public void postSaveParametersTestShopHighIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1.5);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("店铺板块高度为小数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectShopHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("1");
	}
	/**
	 * 店铺板块高度为负数
	 */
	@Test
	public void postSaveParametersTestShopHighIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", -1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("店铺板块高度为负数" + post);
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("店铺板块高度不能小于0");
	}
	/**
	 * 店铺板块高度为字符
	 */
	@Test
	public void postSaveParametersTestShopHighIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", "aaaa");
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("店铺板块高度为字符" + post);
		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 店铺板块高度为0
	 */
	@Test
	public void postSaveParametersTestShopHighIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 0);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("店铺板块高度为0" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectShopHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("216");
	}
	/**
	 * 店铺板块高度为最大值
	 */
	@Test
	public void postSaveParametersTestShopHighIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 999999999);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("店铺板块高度为最大值" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectShopHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("999999999");
	}
	/**
	 * 店铺板块高度为长整型
	 */
	@Test
	public void postSaveParametersTestShopHighIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 999999999999L);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("店铺板块高度为长整型" + post);
		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 店铺板块高度为空
	 */
	@Test
	public void postSaveParametersTestShopHighIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", "");
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("店铺板块高度为空" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectShopHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("216");
	}
	/**
	 * 店铺板块高度为空格
	 */
	@Test
	public void postSaveParametersTestShopHighIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", " ");
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("店铺板块高度为空格" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectShopHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("216");
	}
	/**
	 * 店铺板块高度为null
	 */
	@Test
	public void postSaveParametersTestShopHighIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", null);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("店铺板块高度为null" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectShopHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("216");
	}
	/**
	 * 店铺板块高度不传该参数
	 */
	@Test
	public void postSaveParametersTestShopHighNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("goodsHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("店铺板块高度不传该参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectShopHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("216");
	}
	/**
	 * 商品板块高度为小数
	 */
	@Test
	public void postSaveParametersTestGoodsHighIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 1.5);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("商品板块高度为小数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectGoodsHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("1");
	}
	/**
	 * 商品板块高度为负数
	 */
	@Test
	public void postSaveParametersTestGoodsHighIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", -1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("商品板块高度为负数" + post);
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("商品板块高度不能小于0");
	}
	/**
	 * 商品板块高度为字符
	 */
	@Test
	public void postSaveParametersTestGoodsHighIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", "aaa");
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("商品板块高度为字符" + post);
		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 商品板块高度为0
	 */
	@Test
	public void postSaveParametersTestGoodsHighIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 0);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("商品板块高度为0" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectGoodsHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("216");
	}
	/**
	 * 商品板块高度为最大值
	 */
	@Test
	public void postSaveParametersTestGoodsHighIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 999999999);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("商品板块高度为最大值" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectGoodsHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("999999999");
	}
	/**
	 * 商品板块高度为长整型
	 */
	@Test
	public void postSaveParametersTestGoodsHighIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", 989999999999L);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("商品板块高度为长整型" + post);
		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 商品板块高度为空
	 */
	@Test
	public void postSaveParametersTestGoodsHighIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", "");
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("商品板块高度为空" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectGoodsHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("216");
	}
	/**
	 * 商品板块高度为空格
	 */
	@Test
	public void postSaveParametersTestGoodsHighIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("goodsHigh", " ");
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("商品板块高度为空格" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectGoodsHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("216");
	}
	/**
	 * 商品板块高度不传该参数
	 */
	@Test
	public void postSaveParametersTestGoodsHighNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495324);
		request.put("carousel", 1);
		request.put("bigGunCount", 1);
		request.put("goodsCount", 1);
		request.put("usedCount", 1);
		request.put("mixtureHigh", 1);
		request.put("bigGunHigh", 1);
		request.put("shopHigh", 1);
		request.put("usedHigh", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("商品板块高度不传该参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectGoodsHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("216");
	}
	/**
	 * 二手橱窗高度为小数
	 */
	@Test
	public void postSaveParametersTestUsedHighIsDecimal() throws Exception {
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
		request.put("usedHigh", 1.5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("二手橱窗高度为小数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectUsedHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("1");
	}
	/**
	 * 二手橱窗高度为负数
	 */
	@Test
	public void postSaveParametersTestUsedHighIsNegativeNumber() throws Exception {
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
		request.put("usedHigh", -1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("二手橱窗高度为负数" + post);
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("二手橱窗高度不能小于0");
	}
	/**
	 * 二手橱窗高度为字符
	 */
	@Test
	public void postSaveParametersTestUsedHighIsString() throws Exception {
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
		request.put("usedHigh", "aa");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("二手橱窗高度为字符" + post);
		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 二手橱窗高度为0
	 */
	@Test
	public void postSaveParametersTestUsedHighIsZero() throws Exception {
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
		request.put("usedHigh", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("二手橱窗高度为0" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectUsedHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("216");
	}
	/**
	 * 二手橱窗高度为最大值
	 */
	@Test
	public void postSaveParametersTestUsedHighIsMax() throws Exception {
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
		request.put("usedHigh", 999999999);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("二手橱窗高度为最大值" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectUsedHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("999999999");
	}
	/**
	 * 二手橱窗高度为长整型
	 */
	@Test
	public void postSaveParametersTestUsedHighIsLong() throws Exception {
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
		request.put("usedHigh", 999999999999L);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("二手橱窗高度为长整型" + post);
		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 二手橱窗高度为空
	 */
	@Test
	public void postSaveParametersTestUsedHighIsEmpty() throws Exception {
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
		request.put("usedHigh", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("二手橱窗高度为空" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectUsedHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("216");
	}
	/**
	 * 二手橱窗高度为空格
	 */
	@Test
	public void postSaveParametersTestUsedHighIsSpace() throws Exception {
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
		request.put("usedHigh", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("二手橱窗高度为空格" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectUsedHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("216");
	}
	/**
	 * 二手橱窗高度为null
	 */
	@Test
	public void postSaveParametersTestUsedHighIsNull() throws Exception {
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
		request.put("usedHigh", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("二手橱窗高度为null" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectUsedHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("216");
	}
	/**
	 * 二手橱窗高度不传该参数
	 */
	@Test
	public void postSaveParametersTestUsedHighNonSubmissionParameters() throws Exception {
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
		JSONObject post = super.UNSPost(url, request);
		System.out.println("二手橱窗高度不传该参数" + post);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
        list =MetaOper.read(selectUsedHigh,dataType);
        assertThat((list.get(0).get("CONTENT").toString())).isEqualTo("216");
	}

	
	
}