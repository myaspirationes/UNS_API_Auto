package com.homePage;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;
import com.example.MetaOper;

public class SaveContainerContentModificationTest extends HttpUtil {
// 保存容器内容修改
	String url = "/uu-admin/container/saveOrEditContent";
	//String updateSql = "update T_CONTAINER_CONTENT set TITLE = '大地' , FILE_ID='101' WHERE CONTAINER_CON_ID='1'";
	//String selectSql = "SELECT * from T_CONTAINER_CONTENT WHERE CONTAINER_CON_ID = '1'";
	//String dataType = "perCenter81";
	List<Map> lis = new ArrayList<Map>();
	Map<Object, Object> map1 = new HashMap<Object, Object>();
	Map<Object, Object> map2 = new HashMap<Object, Object>();
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveContainerContentModificationTesttCorrectParameter() throws Exception {
		////MetaOper.update(updateSql, dataType);
		////MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 内容id 集合为错误
	 */
	////@Test
	public void postSaveContainerContentModificationTestContentListIsError() throws Exception {
		////MetaOper.update(updateSql, dataType);
		////MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", "list");
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为错误" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合为非法字符
	 */
	////@Test
	public void postSaveContainerContentModificationTestContentListIsIllegalCharacters() throws Exception {
		////MetaOper.update(updateSql, dataType);
		////MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", "<!%^&>");
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合为小数
	 */
	////@Test
	public void postSaveContainerContentModificationTestContentListIsDecimal() throws Exception {
		////MetaOper.update(updateSql, dataType);
		////MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", 12.3);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合为负数
	 */
	////@Test
	public void postSaveContainerContentModificationTestContentListIsNegativeNumber() throws Exception {
		////MetaOper.update(updateSql, dataType);
		////MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", -22);
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为负数" + post);

		assertThat(post.get("status")).isEqualTo(400);
		//assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 内容id 集合为空格
	 */
	////@Test
	public void postSaveContainerContentModificationTestContentListIsSpace() throws Exception {
		////MetaOper.update(updateSql, dataType);
		////MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", " ");
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为空格" + post);
	
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合为空
	 */
	////@Test
	public void postSaveContainerContentModificationTestContentListIsEmpty() throws Exception {
		////MetaOper.update(updateSql, dataType);
		////MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", "");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为空" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合null
	 */
	////@Test
	public void postSaveContainerContentModificationTestContentListIsNull() throws Exception {
		////MetaOper.update(updateSql, dataType);
		////MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", null);
					
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合null" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 内容id 集合为超长
	 */
	////@Test
	public void postSaveContainerContentModificationTestContentListIsLong() throws Exception {
		////MetaOper.update(updateSql, dataType);
		////MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", "lisffffffffffffffffdfdsdsdffdsff");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为超长" + post);

		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合为String
	 */
	////@Test
	public void postSaveContainerContentModificationTestContentListIsString() throws Exception {
		////MetaOper.update(updateSql, dataType);
		////MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", "dfffd");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合为0
	 */
	////@Test
	public void postSaveContainerContentModificationTestContentListIsZero() throws Exception {
		////MetaOper.update(updateSql, dataType);
		////MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList",  0);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为0" + post);

		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id 集合不传该参数
	 */
	////@Test
	public void postSaveContainerContentModificationTestContentListNonSubmissionParameters() throws Exception {
		////MetaOper.update(updateSql, dataType);
		////MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 文字标题 titleText为超长
	 */
	////@Test
	public void postSaveContainerContentModificationTestTitleTextIsLong() throws Exception {
		////MetaOper.update(updateSql, dataType);
		////MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空fff地方大师傅大师傅大师傅和华国锋哈哈哈哈哈哈哈哈对方的刚刚发给");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶帆帆帆帆帆帆帆帆帆帆 ");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 文字标题 titleText为空
	 */
	////@Test
	public void postSaveContainerContentModificationTestTitleTextIsEmpty() throws Exception {
		////MetaOper.update(updateSql, dataType);
		////MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", "");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文字标题 titleText为空格
	 */
	////@Test
	public void postSaveContainerContentModificationTestTitleTextIsSpace() throws Exception {
		////MetaOper.update(updateSql, dataType);
		////MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", " ");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", " ");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文字标题 titleText为null
	 */
	////@Test
	public void postSaveContainerContentModificationTestTitleTextIsNull() throws Exception {
		////MetaOper.update(updateSql, dataType);
		////MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", null);
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", null);
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文字标题 titleText为非法字符
	 */
	////@Test
	public void postSaveContainerContentModificationTestTitleTextIsIllegalCharacters() throws Exception {
		////MetaOper.update(updateSql, dataType);
		////MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "<@%&*>");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", "<@%%^>");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文字标题 titleText为0
	 */
	////@Test
	public void postSaveContainerContentModificationTestTitleTextIsZero() throws Exception {
		////MetaOper.update(updateSql, dataType);
		////MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", 0);
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", 0);
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText为0" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文字标题 titleText错误
	 */
	////@Test
	public void postSaveContainerContentModificationTestTitleTextIsError() throws Exception {
		////MetaOper.update(updateSql, dataType);
		////MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", 123);
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", 456);
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText错误" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文字标题 titleText不传该参数
	 */
	////@Test
	public void postSaveContainerContentModificationTestTitleTextNonSubmissionParameters() throws Exception {
		////MetaOper.update(updateSql, dataType);
		////MetaOper.read(selectSql, dataType);
		
		
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文本id错误
	 */
	////@Test
	public void postSaveContainerContentModificationTestFileIdIsError() throws Exception {
		////MetaOper.update(updateSql, dataType);
		////MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", "88sd88");
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", "99h99");
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id错误" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 文本id为String
	 */
	////@Test
	public void postSaveContainerContentModificationTestFileIdIsString() throws Exception {
		////MetaOper.update(updateSql, dataType);
		////MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", "fdgdgdfg");
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", "dgfsdgfg");
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为String" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 文本id超长
	 */
	////@Test
	public void postSaveContainerContentModificationTestFileIdIsLong() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 999999999999999999L);
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 1111111111111111111L);
		map2.put("contentId", "");
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id超长" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	
	/**
	 * 文本id为小数
	 */
	////@Test
	public void postSaveContainerContentModificationTestFileIdIsDecimal() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11.2);
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 2.2);
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 文本id为负数
	 */
	////@Test
	public void postSaveContainerContentModificationTestFileIdIsNegativeNumber() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", -11);
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", -22);
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	
	/**
	 * 文本id为0
	 */
	////@Test
	public void postSaveContainerContentModificationTestFileIdIsZero() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 0);
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 0);
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为0" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 文本id为空
	 */
	////@Test
	public void postSaveContainerContentModificationTestFileIdIsEmpty() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", "");
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", "");
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为空" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 文本id为非法字符
	 */
	////@Test
	public void postSaveContainerContentModificationTestFileIdIsIllegalCharacters() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", "<@$&_>");
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", "<@#^*+>");
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 文本id不传该参数
	 */
	////@Test
	public void postSaveContainerContentModificationTestTitleText() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		
		map1.put("contentId", 1);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		
		map2.put("contentId", 2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id为错误
	 */
	//@Test
	public void postSaveContainerContentModificationTestContentIdIsError() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", "99n9");
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", "2h2");
		map2.put("contentId", 888);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为错误" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id为String
	 */
	//@Test
	public void postSaveContainerContentModificationTestcontentIdIsString() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", "ssda");
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", "dddddd");
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为String" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id为非法字符
	 */
	//@Test
	public void postSaveContainerContentModificationTestContentIdIsIllegalCharacters() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", "<@%&(>");
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", "<@%&*>");

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id为空
	 */
	//@Test
	public void postSaveContainerContentModificationTestContentIdIsEmpty() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", "");
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", "");
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为空" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 内容id为空格
	 */
	//@Test
	public void postSaveContainerContentModificationTestContentIdIsSpace() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", " ");
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", " ");
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 内容id为null
	 */
	//@Test
	public void postSaveContainerContentModificationTestContentIdIsNull() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", null);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", null);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为null" + post);
	
		assertThat(post.get("status")).isEqualTo(500);
		
	}
	/**
	 * 内容id为负数
	 */
	//@Test
	public void postSaveContainerContentModificationTestContentIdIsNegativeNumber() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", -2);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", -2);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id为小数
	 */
	//@Test
	public void postSaveContainerContentModificationTestContentIdIsDecimal() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 2.33);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 16.9);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id为0
	 */
	//@Test
	public void postSaveContainerContentModificationTestContentIdIsZero() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 0);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 0);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id为0" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id超长
	 */
	//@Test
	public void postSaveContainerContentModificationTestContentIdIsLong() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 999999999999999999L);
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 999999999999999999L);
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id超长" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 内容id不传该参数
	 */
	//@Test
	public void postSaveContainerContentModificationTestContentIdNonSubmissionParameters() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		
		map1.put("containerId", 1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		
		map2.put("containerId", 2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 容器id为错误
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsError() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", "88D8");
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", "999H");

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为错误" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 容器id为非法字符
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsIllegalCharacters() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", "<#$%&*>");
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", "<@$^&&>");

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 容器id为超长
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsLong() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", 888888888888888888L);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", 888888888888888888L);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 容器id为String
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsString() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", "fgdgdf");
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", "sdsds");

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为String" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 容器id为负数
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsNegativeNumber() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", -1);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", -2);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 容器id为小数
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsDecimal() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", 1.2);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", 22.3);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 容器id为0
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsZero() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", 0);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", 0);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为0" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 容器id为空
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsEmpty() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", "");
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", "");

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为空" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 容器id为空格
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsSpace() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", " ");
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", " ");

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 容器id为null
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdIsNull() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		map1.put("containerId", null);
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
		map2.put("containerId", null);

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id为null" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 容器id不传该参数
	 */
	@Test
	public void postSaveContainerContentModificationTestContainerIdNonSubmissionParameters() throws Exception {
		//MetaOper.update(updateSql, dataType);
		//MetaOper.read(selectSql, dataType);
		
		map1.put("titleText", "天空");
		map1.put("fileId", 11);
		map1.put("contentId", 1);
		
		map2.put("titleText", "天空2");
		map2.put("fileId", 22);
		map2.put("contentId", 2);
	

		lis.add(map1);
		lis.add(map2);

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", lis);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器id不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}

}