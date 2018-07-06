package com.webDynamic.labelManagement;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;
//import com.example.LoginTest;

public class SetLabelSettingLableTest extends HttpUtil {
	//设置标签设置接口
	String url = "/uu-admin/labelManage/setLabelSetting";
	String selType1 = "SELECT * FROM T_LABEL_SET WHERE TYPE = '1'";
	String selType2 = "SELECT * FROM T_LABEL_SET WHERE TYPE = '2'";
	String selType3 = "SELECT * FROM T_LABEL_SET WHERE TYPE = '3'";
	String selType4 = "SELECT * FROM T_LABEL_SET WHERE TYPE = '4'";
	List<Map<String,Object>> list ;
	String dataType = "perCenter81";

	String userid;
	@BeforeClass
	public void  beforeClass(){
		userid = new BackUserLoginTest().userId;
		
	}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postSetAndModifyTalantLableTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为错误
	 */
	@Test
	public void postSetAndModifyTalantLableTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 112233);
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为未登录
	 */
	@Test
	public void postSetAndModifyTalantLableTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 10000004);
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postSetAndModifyTalantLableTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "<.@#$%^&>");
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postSetAndModifyTalantLableTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "");
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postSetAndModifyTalantLableTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", " ");
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postSetAndModifyTalantLableTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", null);
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postSetAndModifyTalantLableTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1231231231231231231L);
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数异常");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postSetAndModifyTalantLableTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1.1);
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postSetAndModifyTalantLableTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", -1);
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数异常");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postSetAndModifyTalantLableTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 0);
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为不传该参数
	 */
	@Test
	public void postSetAndModifyTalantLableTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}

	/**
	 * 星座属相标签数量为小数
	 */
	@Test
	public void postSetAndModifyTalantLableTestConstellationNumIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("constellationNum", 3.1);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("星座属相标签数量为小数" + post);
		list = MetaOper.read(selType1,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("NUM").toString()).isEqualTo("3");
	}
	/**
	 * 星座属相标签数量为负数
	 */
	@Test
	public void postSetAndModifyTalantLableTestConstellationNumIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("constellationNum", -2);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("星座属相标签数量为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数异常");
	}
	/**
	 * 星座属相标签数量为0
	 */
	@Test
	public void postSetAndModifyTalantLableTestConstellationNumIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("constellationNum", 0);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("星座属相标签数量为0" + post);
		list = MetaOper.read(selType1,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("NUM").toString()).isEqualTo("0");
	}
	/**
	 * 星座属相标签数量为最大值
	 */
	@Test
	public void postSetAndModifyTalantLableTestConstellationNumIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("constellationNum", 999999999);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("星座属相标签数量为最大值" + post);
		list = MetaOper.read(selType1,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("NUM").toString()).isEqualTo("999999999");
	}
	/**
	 * 星座属相标签数量为超长
	 */
	@Test
	public void postSetAndModifyTalantLableTestConstellationNumIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("constellationNum", 99999999999L);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("星座属相标签数量为超长" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 星座属相标签数量为字符串
	 */
	@Test
	public void postSetAndModifyTalantLableTestConstellationNumIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("constellationNum", "constellationNum");
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("星座属相标签数量为字符串" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 星座属相标签数量为空
	 */
	@Test
	public void postSetAndModifyTalantLableTestConstellationNumIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("constellationNum", "");
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("星座属相标签数量为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 星座属相标签数量为空格
	 */
	@Test
	public void postSetAndModifyTalantLableTestConstellationNumIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("constellationNum", " ");
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("星座属相标签数量为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 星座属相标签数量为null
	 */
	@Test
	public void postSetAndModifyTalantLableTestConstellationNumIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("constellationNum", null);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("星座属相标签数量为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 星座属相标签数量不传该参数
	 */
	@Test
	public void postSetAndModifyTalantLableTestConstellationNumNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("星座属相标签数量不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 属相专属标签数量为小数
	 */
	@Test
	public void postSetAndModifyTalantLableTestChineseZodiacSignNumIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("chineseZodiacSignNum", 3.1);
		request.put("constellationNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("属相专属标签数量为小数" + post);
		list = MetaOper.read(selType2,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("NUM").toString()).isEqualTo("3");
	}
	/**
	 * 属相专属标签数量为负数
	 */
	@Test
	public void postSetAndModifyTalantLableTestChineseZodiacSignNumIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("chineseZodiacSignNum", -2);
		request.put("constellationNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("属相专属标签数量为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数异常");
	}
	/**
	 * 属相专属标签数量为0
	 */
	@Test
	public void postSetAndModifyTalantLableTestChineseZodiacSignNumIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("chineseZodiacSignNum", 0);
		request.put("constellationNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("属相专属标签数量为0" + post);
		list = MetaOper.read(selType2,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("NUM").toString()).isEqualTo("0");
	}
	/**
	 * 属相专属标签数量为最大值
	 */
	@Test
	public void postSetAndModifyTalantLableTestChineseZodiacSignNumIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("chineseZodiacSignNum", 999999999);
		request.put("constellationNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("属相专属标签数量为最大值" + post);
		list = MetaOper.read(selType2,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("NUM").toString()).isEqualTo("999999999");
	}
	/**
	 * 属相专属标签数量为超长
	 */
	@Test
	public void postSetAndModifyTalantLableTestChineseZodiacSignNumIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("chineseZodiacSignNum", 99999999999L);
		request.put("constellationNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("属相专属标签数量为超长" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 属相专属标签数量为字符串
	 */
	@Test
	public void postSetAndModifyTalantLableTestChineseZodiacSignNumIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("chineseZodiacSignNum", "chineseZodiacSignNum");
		request.put("constellationNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("属相专属标签数量为字符串" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 属相专属标签数量为空
	 */
	@Test
	public void postSetAndModifyTalantLableTestChineseZodiacSignNumIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("chineseZodiacSignNum", "");
		request.put("constellationNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("属相专属标签数量为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 属相专属标签数量为空格
	 */
	@Test
	public void postSetAndModifyTalantLableTestChineseZodiacSignNumIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("chineseZodiacSignNum", " ");
		request.put("constellationNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("属相专属标签数量为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 属相专属标签数量为null
	 */
	@Test
	public void postSetAndModifyTalantLableTestChineseZodiacSignNumIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("chineseZodiacSignNum", null);
		request.put("constellationNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("属相专属标签数量为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 属相专属标签数量不传该参数
	 */
	@Test
	public void postSetAndModifyTalantLableTestChineseZodiacSignNumNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("constellationNum", 2);
		request.put("timeNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("属相专属标签数量不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 年代标签数量为小数
	 */
	@Test
	public void postSetAndModifyTalantLableTestTimeNumIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("timeNum", 3.1);
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("年代标签数量为小数" + post);
		list = MetaOper.read(selType3,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("NUM").toString()).isEqualTo("3");

	}
	/**
	 * 年代标签数量为负数
	 */
	@Test
	public void postSetAndModifyTalantLableTestTimeNumIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("timeNum", -2);
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("年代标签数量为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数异常");
	}
	/**
	 * 年代标签数量为0
	 */
	@Test
	public void postSetAndModifyTalantLableTestTimeNumIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("timeNum", 0);
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("年代标签数量为0" + post);
		list = MetaOper.read(selType3,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("NUM").toString()).isEqualTo("0");
	}
	/**
	 * 年代标签数量为最大值
	 */
	@Test
	public void postSetAndModifyTalantLableTestTimeNumIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("timeNum", 999999999);
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("年代标签数量为最大值" + post);
		list = MetaOper.read(selType3,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("NUM").toString()).isEqualTo("999999999");
	}
	/**
	 * 年代标签数量为超长
	 */
	@Test
	public void postSetAndModifyTalantLableTestTimeNumIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("timeNum", 99999999999L);
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("年代标签数量为超长" + post);

		assertThat(post.get("status")).isEqualTo(400);

	}
	/**
	 * 年代标签数量为字符串
	 */
	@Test
	public void postSetAndModifyTalantLableTestTimeNumIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("timeNum", "timeNum");
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("年代标签数量为字符串" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 年代标签数量为空
	 */
	@Test
	public void postSetAndModifyTalantLableTestTimeNumIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("timeNum", "");
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("年代标签数量为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 年代标签数量为空格
	 */
	@Test
	public void postSetAndModifyTalantLableTestTimeNumIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("timeNum", " ");
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("年代标签数量为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 年代标签数量为null
	 */
	@Test
	public void postSetAndModifyTalantLableTestTimeNumIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("timeNum", null);
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("年代标签数量为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 年代标签数量不传该参数
	 */
	@Test
	public void postSetAndModifyTalantLableTestTimeNumNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("commonNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("年代标签数量不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * 普通标签数量为小数
	 */
	@Test
	public void postSetAndModifyTalantLableTestCommonNumIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("commonNum", 3.1);
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("普通标签数量为小数" + post);
		list = MetaOper.read(selType4,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("NUM").toString()).isEqualTo("3");
	}
	/**
	 * 普通标签数量为负数
	 */
	@Test
	public void postSetAndModifyTalantLableTestCommonNumIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("commonNum", -2);
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("普通标签数量为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数异常");
	}
	/**
	 * 普通标签数量为0
	 */
	@Test
	public void postSetAndModifyTalantLableTestCommonNumIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("commonNum", 0);
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("普通标签数量为0" + post);
		list = MetaOper.read(selType3,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("NUM").toString()).isEqualTo("0");
	}
	/**
	 * 普通标签数量为最大值
	 */
	@Test
	public void postSetAndModifyTalantLableTestCommonNumIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("commonNum", 999999999);
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("普通标签数量为最大值" + post);
		list = MetaOper.read(selType3,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("NUM").toString()).isEqualTo("999999999");
	}
	/**
	 * 普通标签数量为超长
	 */
	@Test
	public void postSetAndModifyTalantLableTestCommonNumIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("commonNum", 99999999999L);
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("普通标签数量为超长" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 普通标签数量为字符串
	 */
	@Test
	public void postSetAndModifyTalantLableTestCommonNumIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("commonNum", "commonNum");
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("普通标签数量为字符串" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 普通标签数量为空
	 */
	@Test
	public void postSetAndModifyTalantLableTestCommonNumIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("commonNum", "");
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("普通标签数量为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 普通标签数量为空格
	 */
	@Test
	public void postSetAndModifyTalantLableTestCommonNumIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("commonNum", " ");
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("普通标签数量为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 普通标签数量为null
	 */
	@Test
	public void postSetAndModifyTalantLableTestCommonNumIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("commonNum", null);
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("普通标签数量为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 普通标签数量不传该参数
	 */
	@Test
	public void postSetAndModifyTalantLableTestCommonNumNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("constellationNum", 2);
		request.put("chineseZodiacSignNum", 2);
		request.put("timeNum", 2);
//		request.put("constellationIsAll", 1);
//		request.put("chineseZodiacSignIsALL", 1);
//		request.put("timeIsALL", 1);
//		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("普通标签数量不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * 星座专属标签数量是否显示全部为1选择
	 */
	@Test
	public void postSetAndModifyTalantLableTestConstellationIsAllIsOne() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("constellationIsAll", 1);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("timeIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("星座专属标签数量是否显示全部为1选择" + post);
		list = MetaOper.read(selType1,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("IS_ALL").toString()).isEqualTo("1");
	}
	/**
	 * 星座专属标签数量是否显示全部为0为选择
	 */
	@Test
	public void postSetAndModifyTalantLableTestConstellationIsAllIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("constellationIsAll", 0);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("timeIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("星座专属标签数量是否显示全部为0为选择" + post);
		list = MetaOper.read(selType1,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("IS_ALL").toString()).isEqualTo("0");
	}
	/**
	 * 星座专属标签数量是否显示全部为小数
	 */
	@Test
	public void postSetAndModifyTalantLableTestConstellationIsAllIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("constellationIsAll", 1.1);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("timeIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("星座专属标签数量是否显示全部为小数" + post);
		list = MetaOper.read(selType1,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("IS_ALL").toString()).isEqualTo("1");
	}
	/**
	 * 星座专属标签数量是否显示全部为负数
	 */
	@Test
	public void postSetAndModifyTalantLableTestConstellationIsAllIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("constellationIsAll", -1);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("timeIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数异常");
	}
	/**
	 * 星座专属标签数量是否显示全部为最大值
	 */
	@Test
	public void postSetAndModifyTalantLableTestConstellationIsAllIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("constellationIsAll", 999999999);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("timeIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("星座专属标签数量是否显示全部为最大值" + post);
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数异常");
	}
	/**
	 * 星座专属标签数量是否显示全部为超长
	 */
	@Test
	public void postSetAndModifyTalantLableTestConstellationIsAllIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("constellationIsAll", 1111111111111111L);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("timeIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("星座专属标签数量是否显示全部为超长" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 星座专属标签数量是否显示全部为字符串
	 */
	@Test
	public void postSetAndModifyTalantLableTestConstellationIsAllIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("constellationIsAll", "constellationIsAll");
		request.put("chineseZodiacSignIsALL", 1);
		request.put("timeIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("星座专属标签数量是否显示全部为字符串" + post);

		assertThat(post.get("status")).isEqualTo(400);

	}
	/**
	 * 星座专属标签数量是否显示全部为空格
	 */
	@Test
	public void postSetAndModifyTalantLableTestConstellationIsAllIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("constellationIsAll", " ");
		request.put("chineseZodiacSignIsALL", 1);
		request.put("timeIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("星座专属标签数量是否显示全部为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 星座专属标签数量是否显示全部为空
	 */
	@Test
	public void postSetAndModifyTalantLableTestConstellationIsAllIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("constellationIsAll", "");
		request.put("chineseZodiacSignIsALL", 1);
		request.put("timeIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("星座专属标签数量是否显示全部为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 星座专属标签数量是否显示全部为null
	 */
	@Test
	public void postSetAndModifyTalantLableTestConstellationIsAllIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("constellationIsAll", null);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("timeIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("星座专属标签数量是否显示全部为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 星座专属标签数量是否显示全部不传该参数
	 */
	@Test
	public void postSetAndModifyTalantLableTestConstellationIsAllNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("timeIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("星座专属标签数量是否显示全部不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * 属相专属标签数量是否显示全部为1选择
	 */
	@Test
	public void postSetAndModifyTalantLableTestChineseZodiacSignIsALLIsOne() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("constellationIsAll", 1);
		request.put("timeIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("属相专属标签数量是否显示全部为1选择" + post);
		list = MetaOper.read(selType2,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("IS_ALL").toString()).isEqualTo("1");
	}
	/**
	 * 属相专属标签数量是否显示全部为0为选择
	 */
	@Test
	public void postSetAndModifyTalantLableTestChineseZodiacSignIsALLIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("chineseZodiacSignIsALL", 0);
		request.put("constellationIsAll", 1);
		request.put("timeIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("属相专属标签数量是否显示全部为0为选择" + post);
		list = MetaOper.read(selType2,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("IS_ALL").toString()).isEqualTo("0");
	}
	/**
	 * 属相专属标签数量是否显示全部为小数
	 */
	@Test
	public void postSetAndModifyTalantLableTestChineseZodiacSignIsALLIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("chineseZodiacSignIsALL", 1.1);
		request.put("constellationIsAll", 1);
		request.put("timeIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("属相专属标签数量是否显示全部为小数" + post);
		list = MetaOper.read(selType2,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("IS_ALL").toString()).isEqualTo("1");
	}
	/**
	 * 属相专属标签数量是否显示全部为负数
	 */
	@Test
	public void postSetAndModifyTalantLableTestChineseZodiacSignIsALLIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("chineseZodiacSignIsALL", -1);
		request.put("constellationIsAll", 1);
		request.put("timeIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("属相专属标签数量是否显示全部为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数异常");
	}
	/**
	 * 属相专属标签数量是否显示全部为最大值
	 */
	@Test
	public void postSetAndModifyTalantLableTestChineseZodiacSignIsALLIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("chineseZodiacSignIsALL", 999999999);
		request.put("constellationIsAll", 1);
		request.put("timeIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("属相专属标签数量是否显示全部为最大值" + post);
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 属相专属标签数量是否显示全部为超长
	 */
	@Test
	public void postSetAndModifyTalantLableTestChineseZodiacSignIsALLIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("chineseZodiacSignIsALL", 111111111111111111L);
		request.put("constellationIsAll", 1);
		request.put("timeIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("属相专属标签数量是否显示全部为超长" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 属相专属标签数量是否显示全部为字符串
	 */
	@Test
	public void postSetAndModifyTalantLableTestChineseZodiacSignIsALLIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("chineseZodiacSignIsALL", "chineseZodiacSignIsALL");
		request.put("constellationIsAll", 1);
		request.put("timeIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("属相专属标签数量是否显示全部为字符串" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 属相专属标签数量是否显示全部为空格
	 */
	@Test
	public void postSetAndModifyTalantLableTestChineseZodiacSignIsALLIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("chineseZodiacSignIsALL", " ");
		request.put("constellationIsAll", 1);
		request.put("timeIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("属相专属标签数量是否显示全部为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 属相专属标签数量是否显示全部为空
	 */
	@Test
	public void postSetAndModifyTalantLableTestChineseZodiacSignIsALLIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("chineseZodiacSignIsALL", "");
		request.put("constellationIsAll", 1);
		request.put("timeIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("属相专属标签数量是否显示全部为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 属相专属标签数量是否显示全部为null
	 */
	@Test
	public void postSetAndModifyTalantLableTestChineseZodiacSignIsALLIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("chineseZodiacSignIsALL", null);
		request.put("constellationIsAll", 1);
		request.put("timeIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("属相专属标签数量是否显示全部为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 属相专属标签数量是否显示全部不传该参数
	 */
	@Test
	public void postSetAndModifyTalantLableTestChineseZodiacSignIsALLNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("constellationIsAll", 1);
		request.put("timeIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("属相专属标签数量是否显示全部不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 年代专属标签数量是否显示全部为1选择
	 */
	@Test
	public void postSetAndModifyTalantLableTestTimeIsALLIsOne() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("timeIsALL", 1);
		request.put("constellationIsAll", 1);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("年代专属标签数量是否显示全部为1选择" + post);
		list = MetaOper.read(selType3,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("IS_ALL").toString()).isEqualTo("1");
	}
	/**
	 * 年代专属标签数量是否显示全部为0为选择
	 */
	@Test
	public void postSetAndModifyTalantLableTestTimeIsALLIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("timeIsALL", 0);
		request.put("constellationIsAll", 1);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("年代专属标签数量是否显示全部为0为选择" + post);
		list = MetaOper.read(selType3,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("IS_ALL").toString()).isEqualTo("0");
	}
	/**
	 * 年代专属标签数量是否显示全部为小数
	 */
	@Test
	public void postSetAndModifyTalantLableTestTimeIsALLIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("timeIsALL", 1.1);
		request.put("constellationIsAll", 1);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("年代专属标签数量是否显示全部为小数" + post);
		list = MetaOper.read(selType3,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("IS_ALL").toString()).isEqualTo("1");
	}
	/**
	 * 年代专属标签数量是否显示全部为负数
	 */
	@Test
	public void postSetAndModifyTalantLableTestTimeIsALLIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("timeIsALL", -1);
		request.put("constellationIsAll", 1);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数异常");
	}
	/**
	 * 年代专属标签数量是否显示全部为最大值
	 */
	@Test
	public void postSetAndModifyTalantLableTestTimeIsALLIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("timeIsALL", 999999999);
		request.put("constellationIsAll", 1);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("年代专属标签数量是否显示全部为最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 年代专属标签数量是否显示全部为超长
	 */
	@Test
	public void postSetAndModifyTalantLableTestTimeIsALLIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("timeIsALL", 1111111111111111L);
		request.put("constellationIsAll", 1);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("年代专属标签数量是否显示全部为超长" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 年代专属标签数量是否显示全部为字符串
	 */
	@Test
	public void postSetAndModifyTalantLableTestTimeIsALLIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("timeIsALL", "timeIsALL");
		request.put("constellationIsAll", 1);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("年代专属标签数量是否显示全部为字符串" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 年代专属标签数量是否显示全部为空格
	 */
	@Test
	public void postSetAndModifyTalantLableTestTimeIsALLIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("timeIsALL", " ");
		request.put("constellationIsAll", 1);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("年代专属标签数量是否显示全部为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 年代专属标签数量是否显示全部为空
	 */
	@Test
	public void postSetAndModifyTalantLableTestTimeIsALLIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("timeIsALL", "");
		request.put("constellationIsAll", 1);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("年代专属标签数量是否显示全部为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 年代专属标签数量是否显示全部为null
	 */
	@Test
	public void postSetAndModifyTalantLableTestTimeIsALLIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("timeIsALL", null);
		request.put("constellationIsAll", 1);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("年代专属标签数量是否显示全部为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 年代专属标签数量是否显示全部不传该参数
	 */
	@Test
	public void postSetAndModifyTalantLableTestTimeIsALLNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("constellationIsAll", 1);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("commonIsAll", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("年代专属标签数量是否显示全部不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 普通专属标签数量是否显示全部为1选择
	 */
	@Test
	public void postSetAndModifyTalantLableTestCommonIsAllIsOne() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("commonIsAll", 1);
		request.put("constellationIsAll", 1);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("timeIsALL", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("普通专属标签数量是否显示全部为1选择" + post);
		list = MetaOper.read(selType4,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("IS_ALL").toString()).isEqualTo("1");
	}
	/**
	 * 普通专属标签数量是否显示全部为0为选择
	 */
	@Test
	public void postSetAndModifyTalantLableTestCommonIsAllIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("commonIsAll", 0);
		request.put("constellationIsAll", 1);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("timeIsALL", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("普通专属标签数量是否显示全部为0为选择" + post);
		list = MetaOper.read(selType4,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("IS_ALL").toString()).isEqualTo("0");
	}
	/**
	 * 普通专属标签数量是否显示全部为小数
	 */
	@Test
	public void postSetAndModifyTalantLableTestCommonIsAllIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("commonIsAll", 1.1);
		request.put("constellationIsAll", 1);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("timeIsALL", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("普通专属标签数量是否显示全部为小数" + post);
		list = MetaOper.read(selType4,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("IS_ALL").toString()).isEqualTo("1");

	}
	/**
	 * 普通专属标签数量是否显示全部为负数
	 */
	@Test
	public void postSetAndModifyTalantLableTestCommonIsAllIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("commonIsAll", -1);
		request.put("constellationIsAll", 1);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("timeIsALL", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数异常");
	}
	/**
	 * 普通专属标签数量是否显示全部为最大值
	 */
	@Test
	public void postSetAndModifyTalantLableTestCommonIsAllIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("commonIsAll", 999999999);
		request.put("constellationIsAll", 1);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("timeIsALL", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("普通专属标签数量是否显示全部为最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数异常");
	}
	/**
	 * 普通专属标签数量是否显示全部为超长
	 */
	@Test
	public void postSetAndModifyTalantLableTestCommonIsAllIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("commonIsAll", 1111111111111111L);
		request.put("constellationIsAll", 1);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("timeIsALL", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("普通专属标签数量是否显示全部为超长" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 普通专属标签数量是否显示全部为字符串
	 */
	@Test
	public void postSetAndModifyTalantLableTestCommonIsAllIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("commonIsAll", "commonIsAll");
		request.put("constellationIsAll", 1);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("timeIsALL", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("普通专属标签数量是否显示全部为字符串" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 普通专属标签数量是否显示全部为空格
	 */
	@Test
	public void postSetAndModifyTalantLableTestCommonIsAllIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("commonIsAll", " ");
		request.put("constellationIsAll", 1);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("timeIsALL", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("普通专属标签数量是否显示全部为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 普通专属标签数量是否显示全部为空
	 */
	@Test
	public void postSetAndModifyTalantLableTestCommonIsAllIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("commonIsAll", "");
		request.put("constellationIsAll", 1);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("timeIsALL", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("普通专属标签数量是否显示全部为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 普通专属标签数量是否显示全部为null
	 */
	@Test
	public void postSetAndModifyTalantLableTestCommonIsAllIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("commonIsAll", null);
		request.put("constellationIsAll", 1);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("timeIsALL", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("普通专属标签数量是否显示全部为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 普通专属标签数量是否显示全部不传该参数
	 */
	@Test
	public void postSetAndModifyTalantLableTestCommonIsAllNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
//		request.put("constellationNum", 2);
//		request.put("chineseZodiacSignNum", 2);
//		request.put("timeNum", 2);
//		request.put("commonNum", 2);
		request.put("constellationIsAll", 1);
		request.put("chineseZodiacSignIsALL", 1);
		request.put("timeIsALL", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("普通专属标签数量是否显示全部不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}


}
