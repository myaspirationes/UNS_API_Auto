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

public class DeleteLabelTest extends HttpUtil {
	//删除标签
	String url = "/uu-admin/labelManage/deleteLabel";
	String	selectSql = "SELECT * FROM T_TALENT_LABEL WHERE LABEL_NAME = '自动化标签'";
	String delLabel = "DELETE FROM T_LABEL WHERE LABEL_MSG IN ('自动化标签','<.!@#$%^>','',' ')";
	String delTalentLabel = "DELETE FROM T_TALENT_LABEL WHERE LABEL_NAME IN ('自动化标签','<.!@#$%^>','',' ')";
	List<Map<String,Object>> list ;
	Long labelId;
	int type;
	String dataType = "perCenter81";

	String userid;
	@BeforeClass
	public void  beforeClass(){
		userid = new BackUserLoginTest().userId;


		
	}
	@BeforeMethod
	public void beforeMethod() throws Exception {
		new SetAndModifyTalantLableTest().postSetAndModifyTalantLableTestCorrectParameter();
		list = MetaOper.read(selectSql,dataType);
		labelId = Long.parseLong(list.get(0).get("LABEL_ID").toString());
		type = Integer.parseInt(list.get(0).get("LABEL_TYPE").toString());
	}
	@AfterMethod
	public void afterMethod(){
		MetaOper.delete(delLabel,dataType);
		MetaOper.delete(delTalentLabel,dataType);
	}

	/**
	 * 删除普通表标签
	 */
	@Test
	public void postDeleteLabelTestDeleteTLabel() throws Exception {
		new AddCommonLabelTest().postSetAndModifyTalantLableTestCorrectParameter();
		String selTlabel = "SELECT * FROM T_LABEL WHERE LABEL_MSG = '自动化标签'";
		list = MetaOper.read(selTlabel,dataType);
		labelId = Long.parseLong(list.get(0).get("LABEL_ID").toString());
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("labelId", labelId);
		request.put("type", 4);

		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("删除普通表标签" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功！");
		list = MetaOper.read(selTlabel,dataType);
		assertThat(list.get(0).get("DELETED").toString()).isEqualTo("1");
	}
	/**
	 * 删除达人表标签
	 */
	@Test
	public void postDeleteLabelTestDeleteTalentLabel() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("labelId", labelId);
		request.put("type", type);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("删除达人表标签" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功！");
		list = MetaOper.read(selectSql,dataType);
		assertThat(list.get(0).get("DELETED").toString()).isEqualTo("1");
	}
	/**
	 * 操作用户ID为未登录
	 */
	@Test
	public void postDeleteLabelTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 12495079);
		request.put("labelId", labelId);
		request.put("type", type);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为未登录" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不存在！");
	}
	/**
	 * 操作用户ID为错误用户
	 */
	@Test
	public void postDeleteLabelTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1111111111);
		request.put("labelId", labelId);
		request.put("type", type);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为错误用户" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不存在！");
	}
	/**
	 * 操作用户ID为非法字符
	 */
	@Test
	public void postDeleteLabelTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "<.!@#!@#>");
		request.put("labelId", labelId);
		request.put("type", type);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 操作用户ID为小数
	 */
	@Test
	public void postDeleteLabelTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 1.5);
		request.put("labelId", labelId);
		request.put("type", type);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不存在！");
	}
	/**
	 * 操作用户ID为负数
	 */
	@Test
	public void postDeleteLabelTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", -9);
		request.put("labelId", labelId);
		request.put("type", type);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不存在！");
	}
	/**
	 * 操作用户ID为空格
	 */
	@Test
	public void postDeleteLabelTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "");
		request.put("labelId", labelId);
		request.put("type", type);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 操作用户ID为null
	 */
	@Test
	public void postDeleteLabelTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", null);
		request.put("labelId", labelId);
		request.put("type", type);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 操作用户ID为超长
	 */
	@Test
	public void postDeleteLabelTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "112121212121212121212");
		request.put("labelId", labelId);
		request.put("type", type);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 操作用户ID为String
	 */
	@Test
	public void postDeleteLabelTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "userId");
		request.put("labelId", labelId);
		request.put("type", type);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 操作用户ID为0
	 */
	@Test
	public void postDeleteLabelTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", 0);
		request.put("labelId", labelId);
		request.put("type", type);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("用户id不存在！");
	}
	/**
	 * 操作用户ID为空
	 */
	@Test
	public void postDeleteLabelTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", "");
		request.put("labelId", labelId);
		request.put("type", type);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 操作用户ID不传该参数
	 */
	@Test
	public void postDeleteLabelTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("labelId", labelId);
		request.put("type", type);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("操作用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 标签ID为超长
	 */
	@Test
	public void postDeleteLabelTestLabelIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("labelId", 1231231123123123123L);
		request.put("type", type);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功！");
	}
	/**
	 * 标签ID为空格
	 */
	@Test
	public void postDeleteLabelTestLabelIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("labelId", " ");
		request.put("type", type);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 标签ID为空
	 */
	@Test
	public void postDeleteLabelTestLabelIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("labelId", "");
		request.put("type", type);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 标签ID为为非法字符
	 */
	@Test
	public void postDeleteLabelTestLabelIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("labelId", "<.@#$%^&>");
		request.put("type", type);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}
	/**
	 * 标签ID为为null
	 */
	@Test
	public void postDeleteLabelTestLabelIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("labelId", null);
		request.put("type", type);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 标签ID为不传该参数
	 */
	@Test
	public void postDeleteLabelTestLabelIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("type", type);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}
	/**
	 * 标签ID为0
	 */
	@Test
	public void postDeleteLabelTestLabelIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("labelId", 0);
		request.put("type", type);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功！");
	}

	/**
	 * 标签ID为错误
	 */
	@Test
	public void postDeleteLabelTestLabelIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("labelId", 121);
		request.put("type", type);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为错误" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功！");
	}
	/**
	 * 标签ID为字符串
	 */
	@Test
	public void postDeleteLabelTestLabelIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("labelId", "labelId");
		request.put("type", type);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为字符串" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}

	/**
	 * 标签ID为负数
	 */
	@Test
	public void postDeleteLabelTestLabelIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("labelId", -1);
		request.put("type", type);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功！");
	}
	/**
	 * 标签ID为小数
	 */
	@Test
	public void postDeleteLabelTestLabelIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("labelId", 1.1);
		request.put("type", type);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功！");
	}

	/**
	 * 标签ID为最大值
	 */
	@Test
	public void postDeleteLabelTestLabelIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("labelId", 1231231231231211111L);
		request.put("type", type);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签ID为最大值" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功！");
	}
	/**
	 * 标签类型为1星座
	 */
	@Test
	public void postDeleteLabelTestTypeIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("labelId", labelId);
		request.put("type", 1);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签类型为1星座" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功！");
	}
	/**
	 * 标签类型为错误
	 */
	@Test
	public void postDeleteLabelTestTypeIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("labelId", labelId);
		request.put("type", 9);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签类型为错误" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数异常！");
	}/**
	 * 标签类型为0
	 */
	@Test
	public void postDeleteLabelTestTypeIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("labelId", labelId);
		request.put("type", 0);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签类型为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数异常！");
	}/**
	 * 标签类型为空
	 */
	@Test
	public void postDeleteLabelTestTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("labelId", labelId);
		request.put("type", "");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签类型为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}/**
	 * 标签类型为空格
	 */
	@Test
	public void postDeleteLabelTestTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("labelId", labelId);
		request.put("type", " ");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签类型为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}/**
	 * 标签类型为null
	 */
	@Test
	public void postDeleteLabelTestTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("labelId", labelId);
		request.put("type", null);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签类型为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}/**
	 * 标签类型为小数
	 */
	@Test
	public void postDeleteLabelTestTypeIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("labelId", labelId);
		request.put("type", 1.1);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签类型为小数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功！");
	}/**
	 * 标签类型为负数
	 */
	@Test
	public void postDeleteLabelTestTypeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("labelId", labelId);
		request.put("type", -1);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签类型为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数异常！");
	}/**
	 * 标签类型不传该参数
	 */
	@Test
	public void postDeleteLabelTestTypeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("labelId", labelId);


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签类型不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数不能为空！");
	}/**
	 * 标签类型为字符串
	 */
	@Test
	public void postDeleteLabelTestTypeIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("userId", userid);
		request.put("labelId", labelId);
		request.put("type", "type");


		JSONObject post = super.UNSPost(url, request);
		System.out.println("标签类型为字符串" + post);

		assertThat(post.get("status")).isEqualTo(400);
	}

}
