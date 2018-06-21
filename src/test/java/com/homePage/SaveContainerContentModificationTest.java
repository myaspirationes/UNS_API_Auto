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

public class SaveContainerContentModificationTest extends HttpUtil {
// 保存容器内容修改
	String url = "/uu-admin/container/saveOrEditContent";
	String selectSql = "SELECT * from T_CONTAINER_CONTENT where CONTAINER_CON_ID = '1'";
	String updateSql = "update T_CONTAINER_CONTENT set IS_DELETE = '0' where CONTAINER_CON_ID = '1'";
	String containerId;
	List<Map<String,Object>> list ;
	List<Map<String,Object>> list1 ;
	String dataType = "perCenter81";
	List<Map> lis = new ArrayList<Map>();
	Map<Object, Object> map1 = new HashMap<Object, Object>();
	Map<Object, Object> ClobToString = new HashMap<Object, Object>();	
	@BeforeMethod
	public void  beforeMethod() throws Exception {
		list1 = MetaOper.read(selectSql, dataType);
		containerId = list1.get(0).get("CONTAINER_ID").toString();
	}
	
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveContainerContentModificationTestCorrectParameter() throws Exception {
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("containerId", containerId);
		request.put("userId", 10000000);
				
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		MetaOper.read(selectSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		assertThat(list.get(0).get("FILE_ID").toString()).isEqualTo("2");
		System.out.println(list.get(0).get("TITLE"));	
		//assertThat(list.get(0).get("TITLE").ClobToString("TITLE")).isEqualTo("天空lala");
	}
	
	
	/**
	 * 内容id 集合为错误
	 */
	@Test
	public void postSaveContainerContentModificationTestContentListIsError() throws Exception {
		  		
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "天空0");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);
					
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", "list");
		request.put("containerId", containerId);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为错误" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合为非法字符
	 */
	@Test
	public void postSaveContainerContentModificationTestContentListIsIllegalCharacters() throws Exception {
		  
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "天空0");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", "<!%^&>");
		request.put("containerId", containerId);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合为小数
	 */
	@Test
	public void postSaveContainerContentModificationTestContentListIsDecimal() throws Exception {
		  
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "天空0");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", 12.66);
		request.put("containerId", containerId);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合为负数
	 */
	@Test
	public void postSaveContainerContentModificationTestContentListIsNegativeNumber() throws Exception {
		  
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "天空0");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", -22);
		request.put("containerId", containerId);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为负数" + post);

		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合为空格
	 */
	@Test
	public void postSaveContainerContentModificationTestContentListIsSpace() throws Exception {
		  
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "天空0");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", " ");
		request.put("containerId", containerId);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为空格" + post);
	
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合为空
	 */
	@Test
	public void postSaveContainerContentModificationTestContentListIsEmpty() throws Exception {
		  
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "天空0");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", "");
		request.put("containerId", containerId);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为空" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合null
	 */
	@Test
	public void postSaveContainerContentModificationTestContentListIsNull() throws Exception {
		  
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "天空0");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", null);
		request.put("containerId", containerId);			
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合null" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 内容id 集合为超长
	 */
	@Test
	public void postSaveContainerContentModificationTestContentListIsLong() throws Exception {
		  
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "天空0");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", "lisffffffffffffffffdfdsdsdffdsff");
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为超长" + post);

		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合为String
	 */
	@Test
	public void postSaveContainerContentModificationTestContentListIsString() throws Exception {
		  
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "天空0");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", "dfffd");
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合为0
	 */
	@Test
	public void postSaveContainerContentModificationTestContentListIsZero() throws Exception {
		  
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "天空0");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList",  0);
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为0" + post);

		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合不传该参数
	 */
	@Test
	public void postSaveContainerContentModificationTestContentListNonSubmissionParameters() throws Exception {
		  
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "天空0");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("containerId", containerId);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 文字标题 titleText为超长
	 */
	@Test
	public void postSaveContainerContentModificationTestTitleTextIsLong() throws Exception {
		  
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "天空地方大师傅大师发动反攻各个地和梵蒂冈梵蒂冈的固体液体已经结婚大话黄飞鸿官方的方式发送");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);	
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 文字标题 titleText为空
	 */
	@Test
	public void postSaveContainerContentModificationTestTitleTextIsEmpty() throws Exception {
		  
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);	

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		MetaOper.read(selectSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		assertThat(list.get(0).get("TITLE")).isEqualTo(null);
	}
	/**
	 * 文字标题 titleText为空格
	 */
	@Test
	public void postSaveContainerContentModificationTestTitleTextIsSpace() throws Exception {
		  
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", " ");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		MetaOper.read(selectSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		assertThat(list.get(0).get("TITLE").toString()).isEqualTo(" ");
	}
	/**
	 * 文字标题 titleText为null
	 */
	@Test
	public void postSaveContainerContentModificationTestTitleTextIsNull() throws Exception {
		  
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", null);
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		MetaOper.read(selectSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		assertThat(list.get(0).get("TITLE").toString()).isEqualTo(" ");
	}
	/**
	 * 文字标题 titleText为非法字符
	 */
	@Test
	public void postSaveContainerContentModificationTestTitleTextIsIllegalCharacters() throws Exception {
		  
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "<@#%&*>");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		MetaOper.read(selectSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		assertThat(list.get(0).get("TITLE").toString()).isEqualTo("<@#%&*>");
	}
	/**
	 * 文字标题 titleText为0
	 */
	@Test
	public void postSaveContainerContentModificationTestTitleTextIsZero() throws Exception {
		  
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", 0);
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText为0" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		MetaOper.read(selectSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		assertThat(list.get(0).get("TITLE").toString()).isEqualTo("0");
	}
	
	/**
	 * 文字标题 titleText不传该参数
	 */
	@Test
	public void postSaveContainerContentModificationTestTitleTextNonSubmissionParameters() throws Exception {
		  
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
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
		  
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", "gssdgs");
		map1.put("contentId", contentId);	
		lis.add(map1);
				
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为String" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 文本id超长
	 */
	@Test
	public void postSaveContainerContentModificationTestFileIdIsLong() throws Exception {
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", "999999999999999999L");
		map1.put("contentId", contentId);	
		lis.add(map1);
		

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id超长" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	
	/**
	 * 文本id为小数
	 */
	@Test
	public void postSaveContainerContentModificationTestFileIdIsDecimal() throws Exception {
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", "1.23");
		map1.put("contentId", contentId);	
		lis.add(map1);
		

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 文本id为负数
	 */
	@Test
	public void postSaveContainerContentModificationTestFileIdIsNegativeNumber() throws Exception {
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", -2);
		map1.put("contentId", contentId);	
		lis.add(map1);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	
	/**
	 * 文本id为0
	 */
	@Test
	public void postSaveContainerContentModificationTestFileIdIsZero() throws Exception {
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", 0);
		map1.put("contentId", contentId);	
		lis.add(map1);
		

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
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
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", "");
		map1.put("contentId", contentId);	
		lis.add(map1);
		

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为空" + post);
		MetaOper.read(selectSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("FILE_ID")).isEqualTo(null);
		
	}
	/**
	 * 文本id为非法字符
	 */
	@Test
	public void postSaveContainerContentModificationTestFileIdIsIllegalCharacters() throws Exception {
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", "<@$^&>");
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 文本id不传该参数
	 */
	@Test
	public void postSaveContainerContentModificationTestfileIdNonSubmissionParameters() throws Exception {
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		
	}
	/**
	 * 内容id为错误
	 */
	@Test
	public void postSaveContainerContentModificationTestContentIdIsError() throws Exception {
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", 8888888);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为错误" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id为String
	 */
	@Test
	public void postSaveContainerContentModificationTestcontentIdIsString() throws Exception {
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", "fggdd");	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为String" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id为非法字符
	 */
	@Test
	public void postSaveContainerContentModificationTestContentIdIsIllegalCharacters() throws Exception {
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", "<#$%>");	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id为空
	 */
	@Test
	public void postSaveContainerContentModificationTestContentIdIsEmpty() throws Exception {
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", "");	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为空" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 内容id为空格
	 */
	@Test
	public void postSaveContainerContentModificationTestContentIdIsSpace() throws Exception {
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", " ");	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 内容id为null
	 */
	@Test
	public void postSaveContainerContentModificationTestContentIdIsNull() throws Exception {
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", null);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为null" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 内容id为负数
	 */
	@Test
	public void postSaveContainerContentModificationTestContentIdIsNegativeNumber() throws Exception {
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", -2);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id为小数
	 */
	@Test
	public void postSaveContainerContentModificationTestContentIdIsDecimal() throws Exception {
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", 1.6);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id为0
	 */
	@Test
	public void postSaveContainerContentModificationTestContentIdIsZero() throws Exception {
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", 0);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为0" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id超长
	 */
	@Test
	public void postSaveContainerContentModificationTestContentIdIsLong() throws Exception {
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", 999999999999999999L);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id超长" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id不传该参数
	 */
	@Test
	public void postSaveContainerContentModificationTestContentIdNonSubmissionParameters() throws Exception {
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();		
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 容器id为错误
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsError() throws Exception {
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", 99999);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为错误" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 容器id为非法字符
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsIllegalCharacters() throws Exception {
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
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
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);


		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", 9999999999999999L);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 容器id为String
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsString() throws Exception {
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", "DFGD");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为String" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 容器id为负数
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsNegativeNumber() throws Exception {
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", -5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 容器id为小数
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsDecimal() throws Exception {
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", 8.5);
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
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为0" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 容器id为空
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsEmpty() throws Exception {
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", "");
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
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", " ");
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
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(0).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", null);
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
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("容器id不能为空");
	}
	/**
	 * 容器id和内容id不匹配
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdNotMatchContentId() throws Exception {
		MetaOper.read(selectSql, dataType);
		MetaOper.update(updateSql, dataType);
		list=MetaOper.read(selectSql, dataType);
		String containerId = list.get(1).get("CONTAINER_ID").toString();
		String contentId = list.get(0).get("CONTAINER_CON_ID").toString();
		map1.put("titleText", "测试");
		map1.put("fileId", 1);
		map1.put("contentId", contentId);	
		lis.add(map1);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		request.put("containerId", containerId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id和内容id不匹配" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("容器id和内容id不匹配");
	}
	

}