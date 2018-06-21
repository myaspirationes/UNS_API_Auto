package com.webDynamic.labelManagement;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;
//import com.example.LoginTest;

public class SetAndModifyTalantLableTest extends HttpUtil {
	//添加/编辑达人标签接口
	String url = "/uu-admin/labelManage/setAndModifyTalantLable`";


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
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);

		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签名为超长
	 */
	@Test
	public void postSetAndModifyTalantLableTestLabelNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签名为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签名为空格
	 */
	@Test
	public void postSetAndModifyTalantLableTestLabelNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", " ");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签名为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签名为空
	 */
	@Test
	public void postSetAndModifyTalantLableTestLabelNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签名为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签名为null
	 */
	@Test
	public void postSetAndModifyTalantLableTestLabelNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", null);
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签名为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签名为非法字符
	 */
	@Test
	public void postSetAndModifyTalantLableTestLabelNameIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "<.!@#$%^>");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签名为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签名不传该参数
	 */
	@Test
	public void postSetAndModifyTalantLableTestLabelNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签名不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

	/**
	 * 性别为null
	 */
	@Test
	public void postSetAndModifyTalantLableTestSexIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", null);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 性别为0女
	 */
	@Test
	public void postSetAndModifyTalantLableTestSexIsFemale() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为0女" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 性别为1男
	 */
	@Test
	public void postSetAndModifyTalantLableTestSexIsMen() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 1);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为1男" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 性别为错误值
	 */
	@Test
	public void postSetAndModifyTalantLableTestSexIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 3);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为错误值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 性别为小数
	 */
	@Test
	public void postSetAndModifyTalantLableTestSexIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 1.2);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 性别为最大值
	 */
	@Test
	public void postSetAndModifyTalantLableTestSexIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 999999999);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 性别为超长
	 */
	@Test
	public void postSetAndModifyTalantLableTestSexIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 99999999999L);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 性别为字符串
	 */
	@Test
	public void postSetAndModifyTalantLableTestSexIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", "sex");
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为字符串" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 性别为空
	 */
	@Test
	public void postSetAndModifyTalantLableTestSexIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", "");
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 性别为空格
	 */
	@Test
	public void postSetAndModifyTalantLableTestSexIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", " ");
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 性别不传该参数
	 */
	@Test
	public void postSetAndModifyTalantLableTestSexNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("性别不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签类型为1星座
	 */
	@Test
	public void postSetAndModifyTalantLableTestLabelTypeIsConstellation() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 1);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签类型为1星座" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签类型为2属相
	 */
	@Test
	public void postSetAndModifyTalantLableTestLabelTypeSignOfTheZodiac() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 2);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签类型为2属相" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签类型为3年代
	 */
	@Test
	public void postSetAndModifyTalantLableTestLabelTypeIsTime() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签类型为3年代" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签类型为错误
	 */
	@Test
	public void postSetAndModifyTalantLableTestLabelTypeIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 4);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签类型为错误" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签类型为小数
	 */
	@Test
	public void postSetAndModifyTalantLableTestLabelTypeIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 2.2);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签类型为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签类型为负数
	 */
	@Test
	public void postSetAndModifyTalantLableTestLabelTypeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", -3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签类型为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签类型为0
	 */
	@Test
	public void postSetAndModifyTalantLableTestLabelTypeIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 0);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签类型为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签类型为最大值
	 */
	@Test
	public void postSetAndModifyTalantLableTestLabelTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 999999999);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签类型为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签类型为超长
	 */
	@Test
	public void postSetAndModifyTalantLableTestLabelTypeIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 99999999999L);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签类型为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签类型为空
	 */
	@Test
	public void postSetAndModifyTalantLableTestLabelTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", "");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签类型为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签类型为空格
	 */
	@Test
	public void postSetAndModifyTalantLableTestLabelTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", " ");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签类型为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签类型为null
	 */
	@Test
	public void postSetAndModifyTalantLableTestLabelTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", null);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签类型为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签类型不传该参数
	 */
	@Test
	public void postSetAndModifyTalantLableTestLabelTypeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签类型不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 具体说明为超长
	 */
	@Test
	public void postSetAndModifyTalantLableTestConcreteDescIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长具体说明为超长");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("具体说明为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 具体说明为非法字符
	 */
	@Test
	public void postSetAndModifyTalantLableTestConcreteDescIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "<.@#$%^&>");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("具体说明为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 具体说明为空格
	 */
	@Test
	public void postSetAndModifyTalantLableTestConcreteDescIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", " ");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("具体说明为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 具体说明为空
	 */
	@Test
	public void postSetAndModifyTalantLableTestConcreteDescIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("具体说明为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 具体说明为null
	 */
	@Test
	public void postSetAndModifyTalantLableTestConcreteDescIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", null);
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("具体说明为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 具体说明不传该参数
	 */
	@Test
	public void postSetAndModifyTalantLableTestConcreteDescNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("具体说明不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签ID为0增加
	 */
	@Test
	public void postSetAndModifyTalantLableTestLableIdIsAdd() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 0);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为0增加" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签ID为已存在的编辑
	 */
	@Test
	public void postSetAndModifyTalantLableTestLableIdIsEdit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 1313);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为已存在的编辑" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签ID为不存在的错误ID
	 */
	@Test
	public void postSetAndModifyTalantLableTestLableIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 98789998);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为不存在的错误ID" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签ID为字符串
	 */
	@Test
	public void postSetAndModifyTalantLableTestLableIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", "asd");
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为字符串" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签ID为空格
	 */
	@Test
	public void postSetAndModifyTalantLableTestLableIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", " ");
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签ID为空
	 */
	@Test
	public void postSetAndModifyTalantLableTestLableIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", "");
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签ID为负数
	 */
	@Test
	public void postSetAndModifyTalantLableTestLableIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", -1);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签ID为null
	 */
	@Test
	public void postSetAndModifyTalantLableTestLableIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", null);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签ID为最大值
	 */
	@Test
	public void postSetAndModifyTalantLableTestLableIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 999999999);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签ID为超长
	 */
	@Test
	public void postSetAndModifyTalantLableTestLableIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 1111111111111111111L);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签ID为小数
	 */
	@Test
	public void postSetAndModifyTalantLableTestLableIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("lableId", 1.1);
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 标签ID为不传该参数
	 */
	@Test
	public void postSetAndModifyTalantLableTestLableIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelName", "自动化标签");
		request.put("sex", 0);
		request.put("concreteDesc", "自动化类型");
		request.put("labelType", 3);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}

}
