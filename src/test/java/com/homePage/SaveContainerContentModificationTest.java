package com.homePage;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.appDynamic.DynamicCommentTest;
import com.appDynamic.PublishDynamicsTest;
import com.example.HttpUtil;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;

public class SaveContainerContentModificationTest extends HttpUtil {
// 保存容器内容修改
	String url = "/uu-admin/container/saveOrEditContent";
	String selectSql = "SELECT * from T_CONTAINER_CONTENT where CONTAINER_CON_ID = '1'";
	String selectSql1 = "SELECT to_char(TITLE) from T_CONTAINER_CONTENT where CONTAINER_CON_ID = '1'";
	String updateSql = "update T_CONTAINER_CONTENT set IS_DELETE = '0' where CONTAINER_CON_ID = '1'";
	String containerId;
	String contentId;
	
	List<Map<String,Object>> list ;
	List<Map<String,Object>> list1 ;
	String dataType = "perCenter81";

	BackUserLoginTest login = new BackUserLoginTest();
	String userId=login.userId;
	@BeforeMethod
	public void  beforeMethod() throws Exception {
		MetaOper.update(updateSql, dataType);
		list1 = MetaOper.read(selectSql, dataType);
		containerId = list1.get(0).get("CONTAINER_ID").toString();
		contentId = list1.get(0).get("CONTAINER_CON_ID").toString();
	}
	

	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveContainerContentModificationTestCorrectParameter() throws Exception {
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		List<Map> lis = new ArrayList<Map>();map1.put("titleText", "自动化测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		request.put("contentList", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		MetaOper.read(selectSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		list1=MetaOper.read(selectSql1, dataType);
		assertThat(list.get(0).get("FILE_ID").toString()).isEqualTo("1");
		assertThat(list1.toString().substring(17,22)).isEqualTo("自动化测试");
	}
	
	
	/**
	 * 内容id 集合为错误
	 */
	@Test
	public void postSaveContainerContentModificationTestContentListIsError() throws Exception {
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		List<Map> lis = new ArrayList<Map>();map1.put("titleText", "自动化测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);
					
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", "list");
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为错误" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合为非法字符
	 */
	@Test
	public void postSaveContainerContentModificationTestContentListIsIllegalCharacters() throws Exception {
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		List<Map> lis = new ArrayList<Map>();map1.put("titleText", "自动化测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", "<!%^&>");
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合为小数
	 */
	@Test
	public void postSaveContainerContentModificationTestContentListIsDecimal() throws Exception {
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		List<Map> lis = new ArrayList<Map>();map1.put("titleText", "自动化测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", 12.66);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合为负数
	 */
	@Test
	public void postSaveContainerContentModificationTestContentListIsNegativeNumber() throws Exception {
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		List<Map> lis = new ArrayList<Map>();map1.put("titleText", "自动化测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", -22);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为负数" + post);

		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合为空格
	 */
	@Test
	public void postSaveContainerContentModificationTestContentListIsSpace() throws Exception {
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		List<Map> lis = new ArrayList<Map>();map1.put("titleText", "自动化测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", " ");
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为空格" + post);
	
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合为空
	 */
	@Test
	public void postSaveContainerContentModificationTestContentListIsEmpty() throws Exception {
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		List<Map> lis = new ArrayList<Map>();map1.put("titleText", "自动化测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", "");
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为空" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合null
	 */
	@Test
	public void postSaveContainerContentModificationTestContentListIsNull() throws Exception {
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		List<Map> lis = new ArrayList<Map>();map1.put("titleText", "自动化测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", null);
		request.put("containerId", containerId);			
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合null" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 内容id 集合为超长
	 */
	@Test
	public void postSaveContainerContentModificationTestContentListIsLong() throws Exception {
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		List<Map> lis = new ArrayList<Map>();map1.put("titleText", "自动化测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", "lisffffffffffffffffdfdsdsdffdsff");
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为超长" + post);

		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合为String
	 */
	@Test
	public void postSaveContainerContentModificationTestContentListIsString() throws Exception {
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		List<Map> lis = new ArrayList<Map>();map1.put("titleText", "自动化测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", "dfffd");
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合为0
	 */
	@Test
	public void postSaveContainerContentModificationTestContentListIsZero() throws Exception {
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		List<Map> lis = new ArrayList<Map>();map1.put("titleText", "自动化测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList",  0);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为0" + post);

		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合不传该参数
	 */
	@Test
	public void postSaveContainerContentModificationTestContentListNonSubmissionParameters() throws Exception {
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		List<Map> lis = new ArrayList<Map>();map1.put("titleText", "自动化测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 文字标题 titleText为超长
	 */
	@Test
	public void postSaveContainerContentModificationTestTitleTextIsLong() throws Exception {
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		List<Map> lis = new ArrayList<Map>();
		map1.put("titleText", "天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfds天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送天空地方大师傅fdsfdsfdsf地方大师傅似的非官方的是发风格的服饰的双方发生反对士大夫十分大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);	
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文字标题 titleText为空
	 */
	@Test
	public void postSaveContainerContentModificationTestTitleTextIsEmpty() throws Exception {
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		List<Map> lis = new ArrayList<Map>();
		map1.put("titleText", "");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);	

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		MetaOper.read(selectSql1, dataType);
		list1=MetaOper.read(selectSql1, dataType);
		assertThat(list1.toString().substring(17,21)).isEqualTo("null");
	}
	/**
	 * 文字标题 titleText为空格
	 */
	@Test
	public void postSaveContainerContentModificationTestTitleTextIsSpace() throws Exception {
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		List<Map> lis = new ArrayList<Map>();
		map1.put("titleText", " ");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		MetaOper.read(selectSql1, dataType);
		list1=MetaOper.read(selectSql1, dataType);
		assertThat(list1.toString().substring(17,18)).isEqualTo(" ");
	}
	/**
	 * 文字标题 titleText为null
	 */
	@Test
	public void postSaveContainerContentModificationTestTitleTextIsNull() throws Exception {
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		List<Map> lis = new ArrayList<Map>();
		map1.put("titleText", null);
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		}
	/**
	 * 文字标题 titleText为非法字符
	 */
	@Test
	public void postSaveContainerContentModificationTestTitleTextIsIllegalCharacters() throws Exception {
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		List<Map> lis = new ArrayList<Map>();
		map1.put("titleText", "<@#%&*>");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		MetaOper.read(selectSql, dataType);
		MetaOper.read(selectSql1, dataType);
		list1=MetaOper.read(selectSql1, dataType);
		assertThat(list1.toString().substring(17,24)).isEqualTo("<@#%&*>");
	}
	/**
	 * 文字标题 titleText为0
	 */
	@Test
	public void postSaveContainerContentModificationTestTitleTextIsZero() throws Exception {
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		List<Map> lis = new ArrayList<Map>();
		map1.put("titleText", 0);
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText为0" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		MetaOper.read(selectSql, dataType);
		MetaOper.read(selectSql1, dataType);
		list1=MetaOper.read(selectSql1, dataType);
		assertThat(list1.toString().substring(17,18)).isEqualTo("0");
	}
	
	/**
	 * 文字标题 titleText不传该参数
	 */
	@Test
	public void postSaveContainerContentModificationTestTitleTextNonSubmissionParameters() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 文本id为String
	 */
	@Test
	public void postSaveContainerContentModificationTestFileIdIsString() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", "gssdgs");
		map1.put("contentId", contentId);	
		lis.add(map1);
				
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为String" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 文本id超长
	 */
	@Test
	public void postSaveContainerContentModificationTestFileIdIsLong() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", "999999999999999999L");
		map1.put("contentId", contentId);	
		lis.add(map1);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id超长" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	
	/**
	 * 文本id为小数
	 */
	@Test
	public void postSaveContainerContentModificationTestFileIdIsDecimal() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", "1.23");
		map1.put("contentId", contentId);	
		lis.add(map1);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 文本id为负数
	 */
	@Test
	public void postSaveContainerContentModificationTestFileIdIsNegativeNumber() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", -3);
		map1.put("contentId", contentId);	
		lis.add(map1);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("文本id不能为负数");
	}
	
	/**
	 * 文本id为0
	 */
	@Test
	public void postSaveContainerContentModificationTestFileIdIsZero() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 0);
		map1.put("contentId", contentId);	
		lis.add(map1);
		

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为0" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		MetaOper.read(selectSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		assertThat(list.get(0).get("FILE_ID").toString()).isEqualTo("0");
		
	}
	/**
	 * 文本id为空
	 */
	@Test
	public void postSaveContainerContentModificationTestFileIdIsEmpty() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", "");
		map1.put("contentId", contentId);	
		lis.add(map1);
		

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为空" + post);
		MetaOper.read(selectSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		//assertThat(list.get(0).get("FILE_ID")).isEqualTo(null);
		
	}
	/**
	 * 文本id为空格
	 */
	@Test
	public void postSaveContainerContentModificationTestFileIdIsSpace() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", " ");
		map1.put("contentId", contentId);	
		lis.add(map1);
		

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为空格" + post);
		MetaOper.read(selectSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		//assertThat(list.get(0).get("FILE_ID").toString()).isEqualTo(" ");
		
	}
	/**
	 * 文本id为null
	 */
	@Test
	public void postSaveContainerContentModificationTestFileIdIsNull() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", null);
		map1.put("contentId", contentId);	
		lis.add(map1);
		

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为null" + post);
		MetaOper.read(selectSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		//assertThat(list.get(0).get("FILE_ID")).isEqualTo(null);
		
	}
	/**
	 * 文本id为非法字符
	 */
	@Test
	public void postSaveContainerContentModificationTestFileIdIsIllegalCharacters() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", "<@$^&>");
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 文本id不传该参数
	 */
	@Test
	public void postSaveContainerContentModificationTestFileIdNonSubmissionParameters() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");//不传就不修改数据了
		
	}
	/**
	 * 内容id为错误
	 */
	@Test
	public void postSaveContainerContentModificationTestContentIdIsError() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", 8888888);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为错误" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");//没有进行保存操作
	}
	/**
	 * 内容id为String
	 */
	@Test
	public void postSaveContainerContentModificationTestContentIdIsString() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", "fggdd");	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为String" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id为非法字符
	 */
	@Test
	public void postSaveContainerContentModificationTestContentIdIsIllegalCharacters() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", "<#$%>");	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id为空
	 */
	@Test
	public void postSaveContainerContentModificationTestContentIdIsEmpty() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", "");	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为空" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 内容id为空格
	 */
	@Test
	public void postSaveContainerContentModificationTestContentIdIsSpace() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", " ");	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 内容id为null
	 */
	@Test
	public void postSaveContainerContentModificationTestContentIdIsNull() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", null);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为null" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 内容id为负数
	 */
	@Test
	public void postSaveContainerContentModificationTestContentIdIsNegativeNumber() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试1");
		map1.put("fileId", 1);
		map1.put("contentId", -2);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");//数据库未保存修改
	}
	/**
	 * 内容id为小数
	 */
	@Test
	public void postSaveContainerContentModificationTestContentIdIsDecimal() throws Exception {
		List<Map> lis = new ArrayList<Map>();
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 2);
		map1.put("contentId", 7.6);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list=MetaOper.read("SELECT * FROM T_CONTAINER_CONTENT WHERE CONTAINER_CON_ID = 7", dataType);
		assertThat(list.get(0).get("FILE_ID").toString()).isEqualTo("2");
	}
	/**
	 * 内容id为0
	 */
	@Test
	public void postSaveContainerContentModificationTestContentIdIsZero() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", 0);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为0" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");//数据库未保存
		
	}
	/**
	 * 内容id超长
	 */
	@Test
	public void postSaveContainerContentModificationTestContentIdIsLong() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试1");
		map1.put("fileId", 1);
		map1.put("contentId", 999999999999999999L);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id超长" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");//数据库未保存
	}
	/**
	 * 内容id不传该参数
	 */
	@Test
	public void postSaveContainerContentModificationTestContentIdNonSubmissionParameters() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		//assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器id为错误
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsError() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", 99999);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为错误" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 容器id为非法字符
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsIllegalCharacters() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", " ");	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", "<#%^>");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 容器id为超长
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsLong() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", 9999999999999999L);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 容器id为String
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsString() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", "DFGD");
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为String" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 容器id为负数
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsNegativeNumber() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", -5);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("容器id不能为负数");
	}
	/**
	 * 容器id为小数
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsDecimal() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", 8.5);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 容器id为0
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsZero() throws Exception {
		List<Map> lis = new ArrayList<Map>();Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", 0);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为0" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("容器id不能为0");
	}
	/**
	 * 容器id为空
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsEmpty() throws Exception {
		List<Map> lis = new ArrayList<Map>();
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", "");
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("容器id不能为空");
		
	}
	/**
	 * 容器id为空格
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsSpace() throws Exception {
		List<Map> lis = new ArrayList<Map>();
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", " ");
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("容器id不能为空");
		
	}
	/**
	 * 容器id为null
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsNull() throws Exception {
		List<Map> lis = new ArrayList<Map>();
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", null);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("容器id不能为空");
		
	}
	/**
	 * 容器id不传该参数
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdNonSubmissionParameters() throws Exception {
		List<Map> lis = new ArrayList<Map>();
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("userId", 12495396);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("容器id不能为空");
	}
	/**
	 * userId传空
	 */
	@Test
	public void postSaveContainerContentModificationTestUserIdIsEmpty() throws Exception {
		List<Map> lis = new ArrayList<Map>();
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("userId传空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不能为空");
		
	}
	/**
	 * userId传null
	 */
	@Test
	public void postSaveContainerContentModificationTestUserIdIsNull() throws Exception {
		List<Map> lis = new ArrayList<Map>();
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("userId传null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不能为空");
		
	}
	/**
	 * userId传空格
	 */
	@Test
	public void postSaveContainerContentModificationTestUserIdIsSpace() throws Exception {
		List<Map> lis = new ArrayList<Map>();
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("userId传空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不能为空");
		
	}
	/**
	 * userId为错误
	 */
	@Test
	public void postSaveContainerContentModificationTestUserIdIsError() throws Exception {
		List<Map> lis = new ArrayList<Map>();
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 1249);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("userId为错误" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不存在");
		
	}
	/**
	 * userId为未登录
	 */
	@Test
	public void postSaveContainerContentModificationTestUserIdNotLoggedIn() throws Exception {
		List<Map> lis = new ArrayList<Map>();
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 12495079);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("userId为未登录" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * userId为超长
	 */
	@Test
	public void postSaveContainerContentModificationTestUserIdIsLong() throws Exception {
		List<Map> lis = new ArrayList<Map>();
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		request.put("userId", 999999999999999999L);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("userId为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不存在");
		
	}
	/**
	 * userId为String
	 */
	@Test
	public void postSaveContainerContentModificationTestUserIdIsString() throws Exception {
		List<Map> lis = new ArrayList<Map>();
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", null);
		request.put("userId", "fdsfdsf");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("userId为String" + post);
	
		assertThat(post.get("status")).isEqualTo(400);		
	}
	/**
	 * userId不传
	 */
	@Test
	public void postSaveContainerContentModificationTestUserIdNonSubmissionParameters() throws Exception {
		List<Map> lis = new ArrayList<Map>();
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("userId不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("userId不能为空");
		
	}
}