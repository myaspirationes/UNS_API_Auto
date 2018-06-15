package com.homePage;

import static org.assertj.core.api.Assertions.assertThat;

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
import com.personalCenter.WalletTest;

public class DeleteContainerModuleTest extends HttpUtil {
// 删除容器模块接口
	String url = "/uu-admin/container/deleteHomePageContainer";
	AddOrEditContainerTest AddOrEditContainerTest = new AddOrEditContainerTest();
	String selectSql1 = "SELECT * from T_HOME_PAGE_CONTAINER WHERE TITLE = '接口测试'";
	String updateSql = " UPDATE T_HOME_PAGE_CONTAINER SET IS_DELETE=0 where CONTAINER_ID = '1'";
	
	String dataType = "perCenter81";
	List<Map<String,Object>> list ;
	/**
	 * 提交正确参数
	 */
	@Test
	public void postDeleteContainerModuleTestCorrectParameter() throws Exception {
		MetaOper.update(updateSql, dataType);
		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495324);				
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		list=MetaOper.read(selectSql1, dataType);
		assertThat(list.get(0).get("IS_DELETE").toString()).isEqualTo("1");
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postDeleteContainerModuleTestUserIdNotLoggedIn() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495328);		
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postDeleteContainerModuleTestUserIdIsError() throws Exception {
		MetaOper.update(updateSql, dataType);		
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12312313);		
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postDeleteContainerModuleTestUserIdIllegalCharacters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<$%^>");				
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);
	
		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postDeleteContainerModuleTestUserIdIsDecimal() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 121123.33);			
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postDeleteContainerModuleTestUserIdIsNegativeNumber() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -121312);				
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postDeleteContainerModuleTestUserIdIsSpace() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");					
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);
	
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("缺少参数");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postDeleteContainerModuleTestUserIdIsEmpty() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");				
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("缺少参数");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postDeleteContainerModuleTestUserIdIsNull() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);		
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("缺少参数");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postDeleteContainerModuleTestUserIdIsZero() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);			
		request.put("containerId", 0);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("参数有误");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postDeleteContainerModuleTestUserIdNonSubmissionParameters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("缺少参数");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postDeleteContainerModuleTestUserIdIsLong() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 999999999999999999L);	
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postDeleteContainerModuleTestUserIdIsString() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", "gfgdf");	
		request.put("containerId", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 容器ID为错误
	 */
	@Test
	public void postDeleteContainerModuleTestContainerIdIsError() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		request.put("containerId", 999999);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID为错误" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("该容器不存在");
	}
	/**
	 * 容器ID超长
	 */
	@Test
	public void postDeleteContainerModuleTestContainerIdIsLong() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		request.put("containerId", 999999999999999999L);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("该容器不存在");
	}
	/**
	 * 容器ID为空
	 */
	@Test
	public void postDeleteContainerModuleTestContainerIdIsEmpty() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		request.put("containerId", "");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("缺少参数");
	}
	/**
	 * 容器ID存在非法字符
	 */
	@Test
	public void postDeleteContainerModuleTestContainerIdIsIllegalCharacters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		request.put("containerId", "<@%&(>");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID存在非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 容器ID为小数
	 */
	@Test
	public void postDeleteContainerModuleTestContainerIdIsDecimal() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		request.put("containerId", 8.22);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("该容器不存在");
	}
	/**
	 * 容器ID为负数
	 */
	@Test
	public void postDeleteContainerModuleTestContainerIdIsNegativeNumber() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		request.put("containerId", -1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("该容器不存在");
	}
	/**
	 * 容器ID为空格
	 */
	@Test
	public void postDeleteContainerModuleTestContainerIdIsSpace() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		request.put("containerId", " ");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("缺少参数");
	}
	/**
	 * 容器ID为null
	 */
	@Test
	public void postDeleteContainerModuleTestContainerIdIsNull() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		request.put("containerId", null);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("缺少参数");
	}
	/**
	 * 容器ID为String
	 */
	@Test
	public void postDeleteContainerModuleTestContainerIdIsString() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		request.put("containerId", "dddddddddddd");
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID为String" + post);

		assertThat(post.get("status")).isEqualTo(400);
		
	}
	/**
	 * 容器ID不传该参数
	 */
	@Test
	public void postDeleteContainerModuleTestContainerIdNonSubmissionParameters() throws Exception {
		MetaOper.update(updateSql, dataType);
		Map<String, Object> request = new HashMap<String, Object>();		
		request.put("userId", 12495324);	
		
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("容器ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("缺少参数");
	}
	
	
}