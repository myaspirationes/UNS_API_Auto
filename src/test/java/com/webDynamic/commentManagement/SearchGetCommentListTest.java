package com.webDynamic.commentManagement;

import com.appDynamic.DynamicCommentTest;
import com.appDynamic.PublishDynamicsTest;
import com.example.HttpUtil;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchGetCommentListTest extends HttpUtil {
	// 搜索获取评论列表接口
	String url = "/uu-admin/commentManage/queryCommentList";
	
	String dataType = "perCenter81";
	String selectSql = "SELECT * FROM T_COMMENTBACK WHERE CONTENT = '自动化评论'";
	String delDynamic = "DELETE FROM T_DYNAMIC WHERE DESCRIPTION = '自动化测试'";
	String delComment = "DELETE FROM T_COMMENTBACK WHERE CONTENT in ('自动化评论','<#$%^&**^%$#>','自动化评论回复')";
	List<Map<String,Object>> list ;
	BackUserLoginTest login = new BackUserLoginTest();
	String userId=login.userId;
	@BeforeMethod
	public void  beforeMethod() throws Exception {
		new PublishDynamicsTest().postPublishDynamicsTestCorrectParameter();
		new DynamicCommentTest().postDynamicCommentTestCorrectParameter();
	}
	@AfterMethod
	public void afterMethod(){
		MetaOper.delete(delComment,dataType);
		MetaOper.delete(delDynamic,dataType);

	}
	@AfterClass
	public void afterClass(){
		MetaOper.delete(delComment,dataType);
		MetaOper.delete(delDynamic,dataType);

	}
	
			
	
	/**
	 * 提交正确参数
	 */
	@Test
	public void postSearchGetCommentListTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("category", 2);
		request.put("operateStartTime", "2018-05-03");
		request.put("operateEndTime", "2018-10-20");
		request.put("status", 0);
		request.put("kewWord", "评论");
		request.put("nickName", "梦想家Even");
		request.put("commentUser", "梦想家Even");
		request.put("pageSize", 10);
		request.put("pageNow", 1);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}	
		/**
		 * 分类为错误
		 */
		@Test
		public void postSearchGetCommentListCategoryIsError() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 9);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类为错误" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("分类值错误");
	}
		/**
		 * 分类为负数
		 */
		@Test
		public void postSearchGetCommentListCategoryIsNegativeNumber() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", -9);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类为负数" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("分类值错误");
	}
		/**
		 * 分类为小数
		 */
		@Test
		public void postSearchGetCommentListCategoryIsDecimal() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 9.3);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类为小数" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("分类值错误");		
	}
		/**
		 * 分类为String
		 */
		@Test
		public void postSearchGetCommentListCategoryIsString() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", "dfds");
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类为String" + post);

			assertThat(post.get("status")).isEqualTo(400);
			//assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类为0
		 */
		@Test
		public void postSearchGetCommentListCategoryIs0() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 0);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类为0" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
			JSONObject body = (JSONObject)post.get("body");
			assertThat(body.get("total")).isEqualTo(0);
		
	}
		/**
		 * 分类为空
		 */
		@Test
		public void postSearchGetCommentListCategoryIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", "");
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类为空" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
	}
		/**
		 * 分类为空格
		 */
		@Test
		public void postSearchGetCommentListCategoryIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", " ");
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类为空格" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
	}
		/**
		 * 分类为null
		 */
		@Test
		public void postSearchGetCommentListCategoryIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", null);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类为null" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 分类不传参数
		 */
		@Test
		public void postSearchGetCommentListCategoryNonSubmissionParameters() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类不传参数" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");		
	}
		/**
		 * 分类为超长
		 */
		@Test
		public void postSearchGetCommentListCategoryIsLong() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 999999999999999999L);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类为超长" + post);

			assertThat(post.get("status")).isEqualTo(400);
			//assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类传1
		 */
		@Test
		public void postSearchGetCommentListCategoryIs1() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 1);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类传1" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
			JSONObject body = (JSONObject)post.get("body");
			assertThat(body.get("total")).isEqualTo(0);
	}
		/**
		 * 分类传2
		 */
		@Test
		public void postSearchGetCommentListCategoryIs2() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类传2" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
			
	}
		/**
		 * 分类传3
		 */
		@Test
		public void postSearchGetCommentListCategoryIs3() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 3);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类传3" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
			JSONObject body = (JSONObject)post.get("body");
			assertThat(body.get("total")).isEqualTo(0);
	}
		/**
		 * 用户名id传负数
		 */
		@Test
		public void postSearchGetCommentListUserIdIsNegativeNumber() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", -1000000);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("用户名id传负数" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("用户id值不正确!");
		
	}
		/**
		 * 用户名id传小数
		 */
		@Test
		public void postSearchGetCommentListUserIdIsDecimal() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", 12.3);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("用户名id传小数" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
			JSONObject body = (JSONObject)post.get("body");
			assertThat(body.get("total")).isEqualTo(0);
	}
		/**
		 * 用户名id传空
		 */
		@Test
		public void postSearchGetCommentListUserIdIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", "");
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("用户名id传空" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("用户id值不正确!");
		
	}
		/**
		 * 用户名id传空格
		 */
		@Test
		public void postSearchGetCommentListUserIdIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", " ");
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("用户名id传空格" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("用户id值不正确!");
		
	}
		/**
		 * 用户名id传null
		 */
		@Test
		public void postSearchGetCommentListUserIdIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", null);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("用户名id传null" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("用户id值不正确!");
		
	}
		/**
		 * 用户名id传0
		 */
		@Test
		public void postSearchGetCommentListUserIdIs0() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", 0);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("用户名id传0" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("用户id值不正确!");
	}
		/**
		 * 用户名id传String
		 */
		@Test
		public void postSearchGetCommentListUserIdIsString() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", "GRGDFH");
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("用户名id传String" + post);

			assertThat(post.get("status")).isEqualTo(400);
			//assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 用户名id不传参数
		 */
		@Test
		public void postSearchGetCommentListUserIdNonSubmissionParameters() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("用户名id不传参数" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("用户id值不正确!");
		
	}
		/**
		 * 用户名id传错误
		 */
		@Test
		public void postSearchGetCommentListUserIdIsError() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", 111);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("用户名id传错误" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
			JSONObject body = (JSONObject)post.get("body");
			assertThat(body.get("total")).isEqualTo(0);
	}
		/**
		 * 用户名id为未登录
		 */
		@Test
		public void postSearchGetCommentListUserIdNotLoggedIn() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", 10000004);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("用户名id为未登录" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 创建开始时间传错误格式
		 */
		@Test
		public void postSearchGetCommentListOperateStartTimeIsErrorFormat() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018/05/03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建开始时间传错误格式" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
		
	}
		/**
		 * 创建开始时间传时间戳
		 */
		@Test
		public void postSearchGetCommentListOperateStartTimeIsTimeStamp() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "1525305600000");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建开始时间传时间戳" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
		
	}
		/**
		 * 创建开始时间传数字
		 */
		@Test
		public void postSearchGetCommentListOperateStartTimeIsNumber() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "20180503");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建开始时间传数字" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
		
	}
		/**
		 * 创建开始时间传年月日
		 */
		@Test
		public void postSearchGetCommentListOperateStartTimeIsYMD() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建开始时间传年月日" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 创建开始时间传年月日最大值
		 */
		@Test
		public void postSearchGetCommentListOperateStartTimeIsYMDMax() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "9999-12-31");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建开始时间传年月日最大值" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
			JSONObject body = (JSONObject)post.get("body");
			assertThat(body.get("total")).isEqualTo(0);
	}
		/**
		 * 创建开始时间传时分秒
		 */
		@Test
		public void postSearchGetCommentListOperateStartTimeIsHMS() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "15:25:10");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建开始时间传时分秒" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
		
	}
		/**
		 * 创建开始时间传时分秒最大值
		 */
		@Test
		public void postSearchGetCommentListOperateStartTimeIsHMSMax() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "23:59:59");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建开始时间传时分秒最大值" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
		
	}
		/**
		 * 创建开始时间传 时分秒最小值
		 */
		@Test
		public void postSearchGetCommentListOperateStartTimeIsHMSMin() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "00:00:00");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建开始时间传 时分秒最小值" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
		
	}
		/**
		 * 创建开始时间传年月日最小值
		 */
		@Test
		public void postSearchGetCommentListOperateStartTimeIsYMDMin() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "0001-01-01");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建开始时间传年月日最小值" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 创建开始时间传0
		 */
		@Test
		public void postSearchGetCommentListOperateStartTimeIs0() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", 0);
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建开始时间传0" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
		
	}
		/**
		 * 创建开始时间传负数
		 */
		@Test
		public void postSearchGetCommentListOperateStartTimeIsNegativeNumber() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "-3");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建开始时间传负数" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
		
	}
		/**
		 * 创建开始时间传小数
		 */
		@Test
		public void postSearchGetCommentListOperateStartTimeIsDecimal() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "15.3");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建开始时间传小数" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
		
	}
		/**
		 * 创建开始时间传空
		 */
		@Test
		public void postSearchGetCommentListOperateStartTimeIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建开始时间传空" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 创建开始时间传空格
		 */
		@Test
		public void postSearchGetCommentListOperateStartTimeIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", " ");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建开始时间传空格" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
		
	}
		/**
		 * 创建开始时间传null
		 */
		@Test
		public void postSearchGetCommentListOperateStartTimeIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", null);
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建开始时间传null" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 创建开始时间大于创建结束时间
		 */
		@Test
		public void postSearchGetCommentListOperateStartTimeIsMoreOperateEndTime() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-10-23");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建开始时间大于创建结束时间" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
			JSONObject body = (JSONObject)post.get("body");
			assertThat(body.get("total")).isEqualTo(0);
	}
		/**
		 * 创建开始时间传字符串
		 */
		@Test
		public void postSearchGetCommentListOperateStartTimeIsString() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "dfsdf");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建开始时间传字符串" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
		
	}
		/**
		 * 创建开始时间传闰年2月29
		 */
		@Test
		public void postSearchGetCommentListOperateStartTimeIsLeapYear2Mon29() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2016-02-29");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建开始时间传闰年2月29" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 创建开始时间传非闰年2月29
		 */
		@Test
		public void postSearchGetCommentListOperateStartTimeIsNotLeapYear2Mon29() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-02-29");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建开始时间传非闰年2月29" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
		
	}
		/**
		 * 创建开始时间传年月日时分秒
		 */
		@Test
		public void postSearchGetCommentListOperateStartTimeIsYMDHMS() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03 08:25:13");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建开始时间传年月日时分秒" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 创建开始时间不传参数
		 */
		@Test
		public void postSearchGetCommentListOperateStartTimeNonSubmissionParameters() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建开始时间不传参数" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 创建结束时间传错误格式
		 */
		@Test
		public void postSearchGetCommentListOperateEndTimeIsErrorFormat() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2016-02-29");
			request.put("operateEndTime", "2018/06/20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建结束时间传错误格式" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
		
	}
		/**
		 * 创建结束时间传数字
		 */
		@Test
		public void postSearchGetCommentListOperateEndTimeIsNumber() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2016-02-29");
			request.put("operateEndTime", "20180620");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建结束时间传数字" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
		
	}
		/**
		 * 创建结束时间传字符串
		 */
		@Test
		public void postSearchGetCommentListOperateEndTimeIsString() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2016-02-29");
			request.put("operateEndTime", "fgdfg");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建结束时间传字符串" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
		
	}
		/**
		 * 创建结束时间传年月日
		 */
		@Test
		public void postSearchGetCommentListOperateEndTimeIsYMD() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建结束时间传年月日" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 创建结束时间传年月日最大时间
		 */
		@Test
		public void postSearchGetCommentListOperateEndTimeIsYMDMax() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "9999-12-31");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建结束时间传年月日最大时间" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 创建结束时间chuan 年月日最小时间
		 */
		@Test
		public void postSearchGetCommentListOperateEndTimeIsYMDMin() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2016-02-29");
			request.put("operateEndTime", "0001-01-01");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建结束时间传年月日最小时间" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
			JSONObject body = (JSONObject)post.get("body");
			assertThat(body.get("total")).isEqualTo(0);
	}
		/**
		 * 创建结束时间chuan 时分秒
		 */
		@Test
		public void postSearchGetCommentListOperateEndTimeIsHMS() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "12:33:11");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建结束时间传时分秒" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
		
	}
		/**
		 * 创建结束时间chuan 时分秒最大时间
		 */
		@Test
		public void postSearchGetCommentListOperateEndTimeIsHMSMax() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "23:59:59");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建结束时间传时分秒最大时间" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
		
	}
		/**
		 * 创建结束时间传时分秒最小时间
		 */
		@Test
		public void postSearchGetCommentListOperateEndTimeIsHMSMin() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "00:00:00");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建结束时间传时分秒最小时间" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
		
	}
		/**
		 * 创建结束时间传0
		 */
		@Test
		public void postSearchGetCommentListOperateEndTimeIs0() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2016-02-29");
			request.put("operateEndTime", 0);
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建结束时间传0" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
		
	}
		/**
		 * 创建结束时间传空
		 */
		@Test
		public void postSearchGetCommentListOperateEndTimeIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2016-02-29");
			request.put("operateEndTime", "");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建结束时间传空" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 创建结束时间传null
		 */
		@Test
		public void postSearchGetCommentListOperateEndTimeIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", null);
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建结束时间传null" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 创建结束时间传闰年2月29
		 */
		@Test
		public void postSearchGetCommentListOperateEndTimeIsLeapYear2Mon29() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2020-02-29");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建结束时间传闰年2月29" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 创建结束时间传非闰年2月29
		 */
		@Test
		public void postSearchGetCommentListOperateEndTimeIsMotLeapYear2Mon29() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2019-02-29");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建结束时间传非闰年2月29" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
		
	}
		/**
		 * 创建结束时间传超长
		 */
		@Test
		public void postSearchGetCommentListOperateEndTimeIsLong() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", 999999999999999999L);
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建结束时间传超长" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("开始日期输入有误!");
		
	}
		/**
		 * 创建结束时间传年月日时分秒
		 */
		@Test
		public void postSearchGetCommentListOperateEndTimeIsYMDHMS() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-06-20 15:21:45");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("创建结束时间传年月日时分秒" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 状态传0未处理
		 */
		@Test
		public void postSearchGetCommentListStatusIs0() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("状态传0未处理" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 状态传1正常
		 */
		@Test
		public void postSearchGetCommentListStatusIs1() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 1);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("状态传1正常" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
			JSONObject body = (JSONObject)post.get("body");
			assertThat(body.get("total")).isEqualTo(0);
	}
		/**
		 * 状态传2隐藏
		 */
		@Test
		public void postSearchGetCommentListStatusIs2() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 2);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("状态传2隐藏" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
			JSONObject body = (JSONObject)post.get("body");
			assertThat(body.get("total")).isEqualTo(0);
	}
		/**
		 * 状态传-1全部
		 */
		@Test
		public void postSearchGetCommentListStatusIsAll() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", -1);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("状态传-1全部" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 状态传错误
		 */
		@Test
		public void postSearchGetCommentListStatusIsError() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 9);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("状态传错误" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("状态值错误");
	}
		/**
		 * 状态传负数
		 */
    	@Test
		public void postSearchGetCommentListStatusIsNegativeNumber() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", -9);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("状态传负数" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("状态值错误");
	}
		/**
		 * 状态传小数
		 */
		@Test
		public void postSearchGetCommentListStatusIsDecimal() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 9.3);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("状态传小数" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("状态值错误");
	}
		/**
		 * 状态传String
		 */
		@Test
		public void postSearchGetCommentListStatusIsString() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", "vvxc");
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("状态传String" + post);

			assertThat(post.get("status")).isEqualTo(400);
			//assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 状态传空
		 */
		@Test
		public void postSearchGetCommentListStatusIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", "");
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("状态传空" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 状态传空格
		 */
		@Test
		public void postSearchGetCommentListStatusIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", " ");
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("状态传空格" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 状态传 null
		 */
		@Test
		public void postSearchGetCommentListStatusIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", null);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("状态传 null" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 状态传超长
		 */
		@Test
		public void postSearchGetCommentListStatusIsLong() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 999999999999999999L);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("状态传超长" + post);

			assertThat(post.get("status")).isEqualTo(400);
			//assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 状态不传参数
		 */
		@Test
		public void postSearchGetCommentListStatusNonSubmissionParameters() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("状态不传参数" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 评论内容关键字传空
		 */
		@Test
		public void postSearchGetCommentListKeyWordIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("keyWord", "");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论内容关键字传空" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 评论内容关键字传空格
		 */
		@Test
		public void postSearchGetCommentListKeyWordIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("keyWord", " ");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论内容关键字传空格" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 评论内容关键字传null
		 */
		@Test
		public void postSearchGetCommentListKeyWordIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("keyWord", null);
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论内容关键字传null" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 评论内容关键字传超长
		 */
		@Test
		public void postSearchGetCommentListKeyWordIsLong() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("keyWord", "dhghHjhkhfkdsh好的环境负荷的金属非金属防护等级划分富豪饭局附近的很好的减肥‘。dhghHjhkhfkdsh好的环境负荷的金属非金属防护等级划分富豪饭局附近的很好的减肥.dhghHjhkhfkdsh好的环境负荷的金属非金属防护等级划分富豪饭局附近的很好的减肥‘。dhghHjhkhfkdsh好的环境负荷的金属非金属防护等级划分富豪饭局附近的很好的减肥。dhghHjhkhfkdsh好的环境负荷的金属非金属防护等级划分富豪饭局附近的很好的减肥‘。dhghHjhkhfkdsh好的环境负荷的金属非金属防护等级划分富豪饭局附近的很好的减肥。dhghHjhkhfkdsh好的环境负荷的金属非金属防护等级划分富豪饭局附近的很好的减肥‘。dhghHjhkhfkdsh好的环境负荷的金属非金属防护等级划分富豪饭局附近的很好的减肥");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论内容关键字传超长" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");//传错时不做判断
		
	}
		/**
		 * 评论内容关键字传0
		 */
		@Test
		public void postSearchGetCommentListKeyWordIs0() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("keyWord", 0);
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论内容关键字传0" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");//keyWord传错时不做判断
	}
		/**
		 * 评论内容关键字传非法字符
		 */
		@Test
		public void postSearchGetCommentListKeyWordIsIllegalCharacters() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("keyWord", "<#$#$>");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论内容关键字传非法字符" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
			//JSONObject body = (JSONObject)post.get("body");
			//assertThat(body.get("total")).isEqualTo(0);
	}
		/**
		 * 评论内容关键字不传参数
		 */
		@Test
		public void postSearchGetCommentListKeyWordNonSubmissionParameters() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论内容关键字不传参数" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 发表评论人昵称传空
		 */
		@Test
		public void postSearchGetCommentListNickNameIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("发表评论人昵称传空" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 发表评论人昵称传空格
		 */
		@Test
		public void postSearchGetCommentListNickNameIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", " ");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("发表评论人昵称传空格" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 发表评论人昵称传null
		 */
		@Test
		public void postSearchGetCommentListNickNameIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", null);
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("发表评论人昵称传null" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 发表评论人昵称传超长
		 */
		@Test
		public void postSearchGetCommentListNickNameIsLong() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even酒的喝酒狂欢的环境看了就不得不v不断积累是的话就静静的");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("发表评论人昵称传超长" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
			JSONObject body = (JSONObject)post.get("body");
			assertThat(body.get("total")).isEqualTo(0);
	}
		/**
		 * 发表评论人昵称传0
		 */
		@Test
		public void postSearchGetCommentListNickNameIs0() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", 0);
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("发表评论人昵称传0" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
			JSONObject body = (JSONObject)post.get("body");
			assertThat(body.get("total")).isEqualTo(0);
	}
		/**
		 * 发表评论人昵称不传参数
		 */
		@Test
		public void postSearchGetCommentListNickNameNonSubmissionParameters() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("发表评论人昵称不传参数" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 被评论目标传超长
		 */
		@Test
		public void postSearchGetCommentListCommentUserIsLong() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "测试db报答你的加快进度报废年限每次，那么多的就大家觉得看见立刻大家就觉得看看");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("被评论目标传超长" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
			JSONObject body = (JSONObject)post.get("body");
			assertThat(body.get("total")).isEqualTo(0);
	}
		/**
		 * 被评论目标传空
		 */
		@Test
		public void postSearchGetCommentListCommentUserIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("被评论目标传空" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 被评论目标传空格
		 */
		@Test
		public void postSearchGetCommentListCommentUserIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", " ");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("被评论目标传空格" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 被评论目标传null
		 */
		@Test
		public void postSearchGetCommentListCommentUserIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", null);
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("被评论目标传null" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 被评论目标传0
		 */
		@Test
		public void postSearchGetCommentListCommentUserIs0() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", 0);
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("被评论目标传0" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
			JSONObject body = (JSONObject)post.get("body");
			assertThat(body.get("total")).isEqualTo(0);
	}
		/**
		 * 被评论目标不传参数
		 */
		@Test
		public void postSearchGetCommentListCommentUserNonSubmissionParameters() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("被评论目标不传参数" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 每页获取的条数传负数
		 */
		@Test
		public void postSearchGetCommentListPageSizeIsNegativeNumber() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", -1);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("每页获取的条数传负数" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("pageSize及pageNow 输入值不正确!");
		
	}
		/**
		 * 每页获取的条数传小数
		 */
		@Test
		public void postSearchGetCommentListPageSizeIsDecimal() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 6.3);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("每页获取的条数传小数" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
	}
		/**
		 * 每页获取的条数传0
		 */
		@Test
		public void postSearchGetCommentListPageSizeIs0() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 0);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("每页获取的条数传0" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
			JSONObject body = (JSONObject)post.get("body");
			assertThat(body.get("dynamicList").toString()).isEqualTo("[]");
	}
		/**
		 * 每页获取的条数传空
		 */
		@Test
		public void postSearchGetCommentListPageSizeIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", "");
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("每页获取的条数传空" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("pageSize及pageNow 输入值不正确!");
		
	}
		/**
		 * 每页获取的条数传空格
		 */
		@Test
		public void postSearchGetCommentListPageSizeIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", " ");
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("每页获取的条数传空格" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("pageSize及pageNow 输入值不正确!");
		
	}
		/**
		 * 每页获取的条数传String
		 */
		@Test
		public void postSearchGetCommentListPageSizeIsString() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", "DDJHDJ");
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("每页获取的条数传String" + post);

			assertThat(post.get("status")).isEqualTo(400);
			//assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 每页获取的条数传最大值
		 */
		@Test
		public void postSearchGetCommentListPageSizeIsMax() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 99999999);
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("每页获取的条数传最大值" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		/**
		 * 每页获取的条数不传
		 */
		@Test
		public void postSearchGetCommentListPageSizeNonSubmissionParameters() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageNow", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("每页获取的条数不传" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("pageSize及pageNow 输入值不正确!");
		
	}
		/**
		 * 当前请求第几页传负数
		 */
		@Test
		public void postSearchGetCommentListPageNowIsNegativeNumber() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", -1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("当前请求第几页传负数" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("pageSize及pageNow 输入值不正确!");
		
	}
		/**
		 * 当前请求第几页传小数
		 */
		@Test
		public void postSearchGetCommentListPageNowIsDecimal() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 3.3);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("当前请求第几页传小数" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
			JSONObject body = (JSONObject)post.get("body");
			assertThat(body.get("dynamicList").toString()).isEqualTo("[]");
	}
		/**
		 * 当前请求第几页传0
		 */
		@Test
		public void postSearchGetCommentListPageNowIs0() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 0);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("当前请求第几页传0" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
			JSONObject body = (JSONObject)post.get("body");
			assertThat(body.get("dynamicList").toString()).isEqualTo("[]");
	}
		/**
		 * 当前请求第几页传空格
		 */
		@Test
		public void postSearchGetCommentListPageNowIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", " ");
			JSONObject post = super.UNSPost(url, request);
			System.out.println("当前请求第几页传空格" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("pageSize及pageNow 输入值不正确!");
		
	}
		/**
		 * 当前请求第几页传空
		 */
		@Test
		public void postSearchGetCommentListPageNowIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", "");
			JSONObject post = super.UNSPost(url, request);
			System.out.println("当前请求第几页传空" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("pageSize及pageNow 输入值不正确!");
		
	}
		/**
		 * 当前请求第几页传null
		 */
		@Test
		public void postSearchGetCommentListPageNowIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", null);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("当前请求第几页传null" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("pageSize及pageNow 输入值不正确!");
		
	}
		/**
		 * 当前请求第几页传String
		 */
		@Test
		public void postSearchGetCommentListPageNowIsString() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", "DFDS");
			JSONObject post = super.UNSPost(url, request);
			System.out.println("当前请求第几页传String" + post);

			assertThat(post.get("status")).isEqualTo(400);
			//assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 当前请求第几页传最大值
		 */
		@Test
		public void postSearchGetCommentListPageNowIsMax() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			request.put("pageNow", 99999999);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("当前请求第几页传最大值" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
			JSONObject body = (JSONObject)post.get("body");
			assertThat(body.get("dynamicList").toString()).isEqualTo("[]");
	}
		/**
		 * 当前请求第几页不传参数
		 */
		@Test
		public void postSearchGetCommentListPageNowNonSubmissionParameters() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);
			request.put("category", 2);
			request.put("operateStartTime", "2018-05-03");
			request.put("operateEndTime", "2018-10-20");
			request.put("status", 0);
			request.put("kewWord", "点评");
			request.put("nickName", "梦想家Even");
			request.put("commentUser", "梦想家Even");
			request.put("pageSize", 10);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("当前请求第几页不传参数" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("pageSize及pageNow 输入值不正确!");
		
	}

}