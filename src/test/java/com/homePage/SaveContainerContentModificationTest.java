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
	//String insertIntoSql = "INSERT INTO T_CONTAINER_CONTENT (\"ADDRESS_ID\",\"USER_ID\",\"CONTACT_NAME\", \"CONTACT_INFO\", \"PROVINCE_CODE\", \"CITY_CODE\", \"COUNTY_CODE\", \"DETAILED_ADDRESS\", \"IS_DEFAULT\", \"IS_DELETE\", \"MODIFY_TIME\", \"CREATE_TIME\", \"LABEL\", \"BRIEF_ADDRESS\") VALUES (T_ADDRESS_INFO_SEQ.nextval,'12495324', '测试君', '13524001140', '上海市', '上海市', '浦东新区', '会一直了', '0', '1', TO_DATE('2016-12-02 13:19:54', 'SYYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-02 10:59:05', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL)";
	String updateSql = "update T_CONTAINER_CONTENT set TITLE = '大地' , FILE_ID='101' WHERE CONTAINER_CON_ID='1'";
	String selectSql = "SELECT * from T_CONTAINER_CONTENT WHERE CONTAINER_CON_ID = '1'";
	String dataType = "perCenter81";
	
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveContainerContentModificationTesttCorrectParameter() throws Exception {
		MetaOper.update(updateSql, dataType);
		MetaOper.read(selectSql, dataType);
		Map<String, Object> contentList = new HashMap<String, Object>();
	

		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", contentList);
		
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
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("contentList", 10289);
		request.put("titleText", "大地");
		request.put("fileId", 101);
		request.put("contentId", 10289);
		request.put("containerId", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为错误" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 内容id 集合为非法字符
	 */
	////@Test
	public void postSaveContainerContentModificationTestContentListIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("contentList", "<@$^&*>");
		request.put("titleText", "大地");
		request.put("fileId", 101);
		request.put("contentId", 10289);
		request.put("containerId", 2);		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 内容id 集合为小数
	 */
	////@Test
	public void postSaveContainerContentModificationTestContentListIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("contentList", 10.289);
		request.put("titleText", "大地");
		request.put("fileId", 101);
		request.put("contentId", 10289);
		request.put("containerId", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 内容id 集合为负数
	 */
	////@Test
	public void postSaveContainerContentModificationTestContentListIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("contentList", -10289);
		request.put("titleText", "大地");
		request.put("fileId", 101);
		request.put("contentId", 10289);
		request.put("containerId", 2);	
				
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 内容id 集合为空格
	 */
	////@Test
	public void postSaveContainerContentModificationTestContentListIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("contentList", " ");
		request.put("titleText", "大地");
		request.put("fileId", 101);
		request.put("contentId", 10289);
		request.put("containerId", 2);		
			
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为空格" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 内容id 集合为空
	 */
	////@Test
	public void postSaveContainerContentModificationTestContentListIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("contentList", "");
		request.put("titleText", "大地");
		request.put("fileId", 101);
		request.put("contentId", 10289);
		request.put("containerId", 2);	
	
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 内容id 集合null
	 */
	////@Test
	public void postSaveContainerContentModificationTestContentListIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("contentList", null);
		request.put("titleText", "大地");
		request.put("fileId", 101);
		request.put("contentId", 10289);
		request.put("containerId", 2);	
					
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合null" + post);
	
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 内容id 集合为超长
	 */
	////@Test
	public void postSaveContainerContentModificationTestContentListIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("contentList", "102891221111111111111111111");
		request.put("titleText", "大地");
		request.put("fileId", 101);
		request.put("contentId", 10289);
		request.put("containerId", 2);	

		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为超长" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 内容id 集合为String
	 */
	////@Test
	public void postSaveContainerContentModificationTestContentListIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("contentList", "dfdsfsd");
		request.put("titleText", "大地");
		request.put("fileId", 101);
		request.put("contentId", 10289);
		request.put("containerId", 2);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为String" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 内容id 集合为0
	 */
	////@Test
	public void postSaveContainerContentModificationTestContentListIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();				
		request.put("contentList", 0);
		request.put("titleText", "大地");
		request.put("fileId", 101);
		request.put("contentId", 10289);
		request.put("containerId", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合为0" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 内容id 集合不传该参数
	 */
	////@Test
	public void postSaveContainerContentModificationTestContentListNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		
		request.put("titleText", "大地");
		request.put("fileId", 101);
		request.put("contentId", 10289);
		request.put("containerId", 2);	
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("内容id 集合不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 文字标题 titleText为超长
	 */
	//@Test
	public void postSaveContainerContentModificationTestTitleTextIsLong() throws Exception {
		MetaOper.update(updateSql, dataType);
		MetaOper.read(selectSql, dataType);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", 10289);
		request.put("titleText", "大地f分隔符分割发嘀咕嘀咕嘀咕的风格的大多数规范规范规定的广泛的幅度高达顶顶顶顶顶分公司的风格的是");
		request.put("fileId", 101);
		request.put("contentId", 10289);
		request.put("containerId", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文字标题 titleText为空
	 */
	//@Test
	public void postSaveContainerContentModificationTestTitleTextIsEmpty() throws Exception {
		MetaOper.update(updateSql, dataType);
		MetaOper.read(selectSql, dataType);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", 10289);
		request.put("titleText", "");
		request.put("fileId", 101);
		request.put("contentId", 10289);
		request.put("containerId", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文字标题 titleText为空格
	 */
	//@Test
	public void postSaveContainerContentModificationTestTitleTextIsSpace() throws Exception {
		MetaOper.update(updateSql, dataType);
		MetaOper.read(selectSql, dataType);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", 10289);
		request.put("titleText", " ");
		request.put("fileId", 101);
		request.put("contentId", 10289);
		request.put("containerId", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文字标题 titleText为null
	 */
	//@Test
	public void postSaveContainerContentModificationTestTitleTextIsNull() throws Exception {
		MetaOper.update(updateSql, dataType);
		MetaOper.read(selectSql, dataType);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", 10289);
		request.put("titleText", null);
		request.put("fileId", 101);
		request.put("contentId", 10289);
		request.put("containerId", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText为null" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文字标题 titleText为非法字符
	 */
	//@Test
	public void postSaveContainerContentModificationTestTitleTextIsIllegalCharacters() throws Exception {
		MetaOper.update(updateSql, dataType);
		MetaOper.read(selectSql, dataType);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", 10289);
		request.put("titleText", "<@$%&*_>");
		request.put("fileId", 101);
		request.put("contentId", 10289);
		request.put("containerId", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文字标题 titleText为0
	 */
	//@Test
	public void postSaveContainerContentModificationTestTitleTextIsZero() throws Exception {
		MetaOper.update(updateSql, dataType);
		MetaOper.read(selectSql, dataType);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", 10289);
		request.put("titleText", 0);
		request.put("fileId", 101);
		request.put("contentId", 10289);
		request.put("containerId", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText为0" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文字标题 titleText错误
	 */
	//@Test
	public void postSaveContainerContentModificationTestTitleTextIsError() throws Exception {
		MetaOper.update(updateSql, dataType);
		MetaOper.read(selectSql, dataType);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", 10289);
		request.put("titleText", "fdf");
		request.put("fileId", 101);
		request.put("contentId", 10289);
		request.put("containerId", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText错误" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文字标题 titleText不传该参数
	 */
	//@Test
	public void postSaveContainerContentModificationTestTitleTextNonSubmissionParameters() throws Exception {
		MetaOper.update(updateSql, dataType);
		MetaOper.read(selectSql, dataType);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", 10289);
	
		request.put("fileId", 101);
		request.put("contentId", 10289);
		request.put("containerId", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文字标题 titleText不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文本id错误
	 */
	//@Test
	public void postSaveContainerContentModificationTestFileIdIsError() throws Exception {
		MetaOper.update(updateSql, dataType);
		MetaOper.read(selectSql, dataType);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", 10289);
		request.put("titleText", "大地");
		request.put("fileId", 1011);
		request.put("contentId", 10289);
		request.put("containerId", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id错误" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文本id为String
	 */
	//@Test
	public void postSaveContainerContentModificationTestFileIdIsString() throws Exception {
		MetaOper.update(updateSql, dataType);
		MetaOper.read(selectSql, dataType);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", 10289);
		request.put("titleText", "大地");
		request.put("fileId", "fgsdgs");
		request.put("contentId", 10289);
		request.put("containerId", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为String" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文本id为小数
	 */
	//@Test
	public void postSaveContainerContentModificationTestFileIdIsDecimal() throws Exception {
		MetaOper.update(updateSql, dataType);
		MetaOper.read(selectSql, dataType);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", 10289);
		request.put("titleText", "大地");
		request.put("fileId", 10.1);
		request.put("contentId", 10289);
		request.put("containerId", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文本id为负数
	 */
	//@Test
	public void postSaveContainerContentModificationTestFileIdIsNegativeNumber() throws Exception {
		MetaOper.update(updateSql, dataType);
		MetaOper.read(selectSql, dataType);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", 10289);
		request.put("titleText", "大地");
		request.put("fileId", -101);
		request.put("contentId", 10289);
		request.put("containerId", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为负数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文本id为超长
	 */
	//@Test
	public void postSaveContainerContentModificationTestTFileIdIsLong() throws Exception {
		MetaOper.update(updateSql, dataType);
		MetaOper.read(selectSql, dataType);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", 10289);
		request.put("titleText", "大地");
		request.put("fileId", "10111111111111111111111111111111111");
		request.put("contentId", 10289);
		request.put("containerId", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文本id为0
	 */
	//@Test
	public void postSaveContainerContentModificationTestFileIdIsZero() throws Exception {
		MetaOper.update(updateSql, dataType);
		MetaOper.read(selectSql, dataType);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", 10289);
		request.put("titleText", "大地");
		request.put("fileId", 101);
		request.put("contentId", 10289);
		request.put("containerId", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为0" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文本id为空
	 */
	//@Test
	public void postSaveContainerContentModificationTestFileIdIsEmpty() throws Exception {
		MetaOper.update(updateSql, dataType);
		MetaOper.read(selectSql, dataType);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", 10289);
		request.put("titleText", "大地");
		request.put("fileId", "");
		request.put("contentId", 10289);
		request.put("containerId", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为空" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文本id为非法字符
	 */
	//@Test
	public void postSaveContainerContentModificationTestFileIdIsIllegalCharacters() throws Exception {
		MetaOper.update(updateSql, dataType);
		MetaOper.read(selectSql, dataType);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", 10289);
		request.put("titleText", "大地");
		request.put("fileId", "<@$%&)>");
		request.put("contentId", 10289);
		request.put("containerId", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 文本id不传该参数
	 */
	//@Test
	public void postSaveContainerContentModificationTestTitleText() throws Exception {
		MetaOper.update(updateSql, dataType);
		MetaOper.read(selectSql, dataType);
		
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("contentList", 10289);
		request.put("titleText", "大地");
		
		request.put("contentId", 10289);
		request.put("containerId", 2);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("文本id不传该参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
}