package com.webDynamic.labelManagement;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;
//import com.example.LoginTest;

public class AddCommonLabelTest extends HttpUtil {
	//添加/编辑普通标签接口
	String url = "/uu-admin/labelManage/addCommonLabel";
	String delLabel = "DELETE FROM T_LABEL WHERE LABEL_MSG IN ('自动化标签','<.!@#$%^>','',' ')";
	String selLabel = "SELECT * FROM T_LABEL WHERE LABEL_MSG IN ('自动化标签','<.!@#$%^>','',' ','自动化标签编辑测试后')";
	String dataType = "perCenter81";
	String userid;
	List<Map<String,Object>> list ;
	@AfterMethod
	public void afterMethod(){
		MetaOper.delete(delLabel,dataType);
	}
	@BeforeClass
	public void  beforeClass(){
		userid = new BackUserLoginTest().userId;

	}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postSetAndModifyTalantLableTestCorrectParameter() throws Exception {
		userid = new BackUserLoginTest().userId;
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelName", "自动化标签");
		request.put("userId", userid);
		request.put("labelId", 0);


		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		list = MetaOper.read(selLabel,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("LABEL_MSG").toString()).isEqualTo("自动化标签");
	}
	/**
	 * 标签名为超长
	 */
	@Test
	public void postSetAndModifyTalantLableTestLabelNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelId", 0);
		request.put("labelName", "自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签自动化标签");
		request.put("userId", userid);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签名为超长" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 标签名为空格
	 */
	@Test
	public void postSetAndModifyTalantLableTestLabelNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelId", 0);
		request.put("labelName", " ");
		request.put("userId", userid);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签名为空格" + post);
		list = MetaOper.read(selLabel,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("LABEL_MSG").toString()).isEqualTo(" ");
	}
	/**
	 * 标签名为空
	 */
	@Test
	public void postSetAndModifyTalantLableTestLabelNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelId", 0);
		request.put("labelName", "");
		request.put("userId", userid);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签名为空" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 标签名为null
	 */
	@Test
	public void postSetAndModifyTalantLableTestLabelNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelId", 0);
		request.put("labelName", null);
		request.put("userId", userid);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签名为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 标签名为非法字符
	 */
	@Test
	public void postSetAndModifyTalantLableTestLabelNameIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelId", 0);
		request.put("labelName", "<.!@#$%^>");
		request.put("userId", userid);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签名为非法字符" + post);
		list = MetaOper.read(selLabel,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("LABEL_MSG").toString()).isEqualTo("<.!@#$%^>");
	}
	/**
	 * 标签名不传该参数
	 */
	@Test
	public void postSetAndModifyTalantLableTestLabelNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelId", 0);
		request.put("userId", userid);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签名不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}


	/**
	 * 标签ID为0增加
	 */
	@Test
	public void postSetAndModifyTalantLableTestLableIdIsAdd() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelId", 0);
		request.put("labelName", "自动化标签");
		request.put("userId", userid);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为0增加" + post);
		list = MetaOper.read(selLabel,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("LABEL_MSG").toString()).isEqualTo("自动化标签");
	}
	/**
	 * 标签ID为已存在的编辑
	 */
	@Test
	public void postSetAndModifyTalantLableTestLableIdIsEdit() throws Exception {
		String selLabelID = "SELECT * FROM T_LABEL WHERE LABEL_MSG = '自动化标签编辑测试前'";

		list = MetaOper.read(selLabelID,dataType);
		String labelId = list.get(0).get("LABEL_ID").toString();
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelId", labelId);
		request.put("labelName", "自动化标签编辑测试后");
		request.put("userId", userid);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为已存在的编辑" + post);
		list = MetaOper.read(selLabel,dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("LABEL_MSG").toString()).isEqualTo("自动化标签编辑测试后");
		String updateLabelName = "UPDATE T_LABEL SET LABEL_MSG = '自动化标签编辑测试前' WHERE LABEL_ID = "+labelId;
		MetaOper.update(updateLabelName,dataType);
	}
	/**
	 * 标签ID为不存在的错误ID
	 */
	@Test
	public void postSetAndModifyTalantLableTestLableIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelId", 98789998);
		request.put("labelName", "自动化标签");
		request.put("userId", userid);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为不存在的错误ID" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 标签ID为字符串
	 */
	@Test
	public void postSetAndModifyTalantLableTestLableIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelId", "asd");
		request.put("labelName", "自动化标签");
		request.put("userId", userid);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为字符串" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 标签ID为空格
	 */
	@Test
	public void postSetAndModifyTalantLableTestLableIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelId", " ");
		request.put("labelName", "自动化标签");
		request.put("userId", userid);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 标签ID为空
	 */
	@Test
	public void postSetAndModifyTalantLableTestLableIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelId", "");
		request.put("labelName", "自动化标签");
		request.put("userId", userid);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 标签ID为负数
	 */
	@Test
	public void postSetAndModifyTalantLableTestLableIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelId", -1);
		request.put("labelName", "自动化标签");
		request.put("userId", userid);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为负数" + post);
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("标签id格式错误！");
	}
	/**
	 * 标签ID为null
	 */
	@Test
	public void postSetAndModifyTalantLableTestLableIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelId", null);
		request.put("labelName", "自动化标签");
		request.put("userId", userid);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 标签ID为最大值
	 */
	@Test
	public void postSetAndModifyTalantLableTestLableIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelId", 999999999);
		request.put("labelName", "自动化标签");
		request.put("userId", userid);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为最大值" + post);
		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 标签ID为超长
	 */
	@Test
	public void postSetAndModifyTalantLableTestLableIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelId", 1111111111111111111L);
		request.put("labelName", "自动化标签");
		request.put("userId", userid);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("标签id格式错误！");
	}
	/**
	 * 标签ID为小数
	 */
	@Test
	public void postSetAndModifyTalantLableTestLableIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelId", 1.1);
		request.put("labelName", "自动化标签");
		request.put("userId", userid);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(500);
	}
	/**
	 * 标签ID为不传该参数
	 */
	@Test
	public void postSetAndModifyTalantLableTestLableIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelName", "自动化标签");
		request.put("userId", userid);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 用户ID为错误
	 */
	@Test
	public void postSetAndModifyTalantLableTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelName", "自动化标签");
		request.put("userId", 1231);
		request.put("labelId", 0);



		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 用户ID为未登录
	 */
	@Test
	public void postSetAndModifyTalantLableTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelName", "自动化标签");
		request.put("userId", 12495079);
		request.put("labelId", 0);



		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("添加成功");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postSetAndModifyTalantLableTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelName", "自动化标签");
		request.put("userId", "<.#$%^&*>");
		request.put("labelId", 0);



		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postSetAndModifyTalantLableTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelName", "自动化标签");
		request.put("userId", " ");
		request.put("labelId", 0);



		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postSetAndModifyTalantLableTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelName", "自动化标签");
		request.put("userId", "");
		request.put("labelId", 0);



		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postSetAndModifyTalantLableTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelName", "自动化标签");
		request.put("userId", null);
		request.put("labelId", 0);



		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postSetAndModifyTalantLableTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelName", "自动化标签");
		request.put("userId", "123123123123123123123123");
		request.put("labelId", 0);



		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postSetAndModifyTalantLableTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelName", "自动化标签");
		request.put("userId", 1.1);
		request.put("labelId", 0);



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
		request.put("labelName", "自动化标签");
		request.put("userId", -1);
		request.put("labelId", 0);



		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id格式错误！");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postSetAndModifyTalantLableTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelName", "自动化标签");
		request.put("userId", 0);
		request.put("labelId", 0);



		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id格式错误！");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postSetAndModifyTalantLableTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelName", "自动化标签");
		request.put("labelId", 0);



		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}

}
