package com.webDynamic.commentManagement;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class DisposeCommentTest extends HttpUtil {
	// 处理评论接口
	String url = "/uu-admin/commentManage/queryCommentDesc";
	
	String dataType = "perCenter81";
	
	BackUserLoginTest login = new BackUserLoginTest();
	String userId=login.userId;
	
	
			
	
	/**
	 * 提交正确参数
	 */
//	@Test
	public void postDisposeCommentTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("commentId", 1453);
		request.put("category", 1);
		request.put("classify", 1);
		request.put("userId", 1234567);
		request.put("userName", "测试");
		request.put("auditContent", "审核说明");
		request.put("auditMsg", 13770);
		request.put("auditOption", 0);
		request.put("commentUserId", 12495005);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}	
		/**
		 * 评论id为负数
		 */
//		@Test
		public void postDisposeCommentTestCommentIdIsNegativeNumber() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", -1453);
			request.put("category", 9);
			request.put("classify", 1);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论id为负数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论id为错误
		 */
//		@Test
		public void postDisposeCommentTestCommentIdIsError() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1111);
			request.put("category", 9);
			request.put("classify", 1);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论id为错误" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论id为小数
		 */
//		@Test
		public void postDisposeCommentTestCommentIdIsDecimal() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1.23);
			request.put("category", 9);
			request.put("classify", 1);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论id为小数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论id为String
		 */
//		@Test
		public void postDisposeCommentTestCommentIdIsString() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", "bdbd");
			request.put("category", 9);
			request.put("classify", 1);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论id为String" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论id为0
		 */
//		@Test
		public void postDisposeCommentTestCommentIdIs0() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 0);
			request.put("category", 9);
			request.put("classify", 1);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论id为0" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论id为空
		 */
//		@Test
		public void postDisposeCommentTestCommentIdIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", "");
			request.put("category", 9);
			request.put("classify", 1);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论id为空" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论id为空格
		 */
//		@Test
		public void postDisposeCommentTestCommentIdIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", " ");
			request.put("category", 9);
			request.put("classify", 1);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论id为空格" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论id为null
		 */
//		@Test
		public void postDisposeCommentTestCommentIdIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", null);
			request.put("category", 9);
			request.put("classify", 1);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论id为null" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论id不传参数
		 */
//		@Test
		public void postDisposeCommentTestCommentIdNonSubmissionParameters() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("category", 9);
			request.put("classify", 1);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论id不传参数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论id为超长
		 */
//		@Test
		public void postDisposeCommentTestCommentIdIsLong() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 999999999999999999L);
			request.put("category", 9);
			request.put("classify", 1);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论id为超长" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 大分类category传负数
		 */
//		@Test
		public void postDisposeCommentTestCategoryIsNegativeNumber() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", -9);
			request.put("classify", 1);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("大分类category传负数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 大分类category传小数
		 */
//		@Test
		public void postDisposeCommentTestCategoryIsDecimal() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 9.3);
			request.put("classify", 1);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("大分类category传小数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 大分类category传空
		 */
//		@Test
		public void postDisposeCommentTestCategoryIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", "");
			request.put("classify", 1);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("大分类category传空" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 大分类category传空格
		 */
//		@Test
		public void postDisposeCommentTestCategoryIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", " ");
			request.put("classify", 1);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("大分类category传空格" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 大分类category传null
		 */
//		@Test
		public void postDisposeCommentTestcategoryIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", null);
			request.put("classify", 1);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("大分类category传null" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 大分类category传0
		 */
//		@Test
		public void postDisposeCommentTestCategoryIs0() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 1);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("大分类category传0" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 大分类category传String
		 */
//		@Test
		public void postDisposeCommentTestCategorysString() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 1);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("大分类category传String" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 大分类category传错误
		 */
//		@Test
		public void postDisposeCommentTestCategoryIsError() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 99);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("大分类category传错误" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 大分类category为传最大值
		 */
//		@Test
		public void postDisposeCommentTestCategoryIsMax() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 999999999);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("大分类category为传最大值" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 大分类category传1二手商品
		 */
//		@Test
		public void postDisposeCommentTestCategoryIs1() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 1);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("大分类category传1二手商品" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 大分类category传2社交
		 */
//		@Test
		public void postDisposeCommentTestCategoryIs2() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 2);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("大分类category传2社交" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 大分类category传3电商
		 */
//		@Test
		public void postDisposeCommentTestCategoryIs3() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 3);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("大分类category传3电商" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 大分类category传4企业明信片
		 */
//		@Test
		public void postDisposeCommentTestCategoryIs4() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 4);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("大分类category传4企业明信片" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 二级分类classify传1动态评论
		 */
//		@Test
		public void postDisposeCommentTestClassifyIs1() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 1);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("二级分类classify传1动态评论" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 二级分类classify传2商品评论
		 */
//		@Test
		public void postDisposeCommentTestClassifyIs2() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 2);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("二级分类classify传2商品评论" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 二级分类classify传3企业明信片评论
		 */
//		@Test
		public void postDisposeCommentTestClassifyIs3() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 3);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("二级分类classify传3企业明信片评论" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 二级分类classify传4二手商品评论
		 */
//		@Test
		public void postDisposeCommentTestClassifyIsYMD() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 4);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("二级分类classify传4二手商品评论" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
	
		/**
		 * 二级分类classify传负数
		 */
//		@Test
		public void postDisposeCommentTestClassifyIsHMS() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", -5);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("二级分类classify传负数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 二级分类classify传空格
		 */
//		@Test
		public void postDisposeCommentTestClassifyIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", " ");
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("二级分类classify传空格" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 二级分类classify传空
		 */
//		@Test
		public void postDisposeCommentTestClassifyIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", "");
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("二级分类classify传空" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 二级分类classify传null
		 */
//		@Test
		public void postDisposeCommentTestClassifyIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", null);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("二级分类classify传null" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 二级分类classify传错误值
		 */
//		@Test
		public void postDisposeCommentTestClassifyIsError() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 55);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("二级分类classify传错误值" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 二级分类classify传最大值
		 */
//		@Test
		public void postDisposeCommentTestClassifyIsMax() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 99999999);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("二级分类classify传最大值" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 二级分类classify不传参数
		 */
//		@Test
		public void postDisposeCommentTestCclassifyIsDecimal() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("二级分类classify不传参数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 二级分类classify传0
		 */
//		@Test
		public void postDisposeCommentTestOperateStartTimeIs0() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("二级分类classify传0" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核人id传未登录
		 */
//		@Test
		public void postDisposeCommentTestUserIdNotLoggedIn() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 12345678);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核人id传未登录" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核人id传错误用户
		 */
//		@Test
		public void postDisposeCommentTestUserIdIsError() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核人id传错误用户" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核人id传0
		 */
//		@Test
		public void postDisposeCommentTestUserIdIs0() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 0);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核人id传0" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核人id传负数
		 */
//		@Test
		public void postDisposeCommentTestUserIdIsNegativeNumber() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", -12345678);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核人id传负数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核人id传小数
		 */
//		@Test
		public void postDisposeCommentTestUserIdIsDecimal() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 123.456);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核人id传小数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核人id传空
		 */
//		@Test
		public void postDisposeCommentTestUserIdIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", "");
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核人id传空" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核人id传空格
		 */
//		@Test
		public void postDisposeCommentTestUserIdIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", " ");
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核人id传空格" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核人id传null
		 */
//		@Test
		public void postDisposeCommentTestUserIdIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", null);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核人id传null" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核人id传String
		 */
//		@Test
		public void postDisposeCommentTestUserIdIsString() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", "DFDF");
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核人id传String" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核人id传最大值
		 */
//		@Test
		public void postDisposeCommentTestUserIdIsMax() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 99999999);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核人id传最大值" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核人id不传参数
		 */
//		@Test
		public void postDisposeCommentTestUserIdNonSubmissionParameters() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核人id不传参数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核人姓名传错误
		 */
//		@Test
		public void postDisposeCommentTestUserNameIsError() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试1");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核人姓名传错误" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核人姓名传超长
		 */
//		@Test
		public void postDisposeCommentTestUserNameIsLong() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试1斤斤计较的放大方法楼梯哦人技术的妇女看电视剧的房间里速度快");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核人姓名传超长" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核人姓名传0
		 */
//		@Test
		public void postDisposeCommentTestUserNameIs0() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", 0);
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核人姓名传0" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核人姓名传空
		 */
//		@Test
		public void postDisposeCommentTestUserNameIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核人姓名传空" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核人姓名传空格
		 */
//		@Test
		public void postDisposeCommentTestUserNameIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", " ");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核人姓名传空格" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核人姓名传null
		 */
//		@Test
		public void postDisposeCommentTestUserNameIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", null);
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核人姓名传null" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核人姓名不传参数
		 */
//		@Test
		public void postDisposeCommentTestUserNameNonSubmissionParameters() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核人姓名不传参数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核说明传超长
		 */
//		@Test
		public void postDisposeCommentTestAuditContentIsLong() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明海军的活动经费的房间里i欸珀雷破vbmxn,mkcjds;fl的肌肤的数据反馈及时看风景");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核说明传超长" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核说明传空
		 */
//		@Test
		public void postDisposeCommentTestAuditContentIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核说明传空" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核说明传空格
		 */
//		@Test
		public void postDisposeCommentTestAuditContentIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", " ");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核说明传空格" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核说明传null
		 */
//		@Test
		public void postDisposeCommentTestAuditContentIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", null);
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核说明传null" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核说明传非法字符
		 */
//		@Test
		public void postDisposeCommentTestAuditContentIsIllegalCharacters() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "<@$#%^%*&>");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核说明传非法字符" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核说明不传参数
		 */
//		@Test
		public void postDisposeCommentTestAuditContentNonSubmissionParameters() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核说明不传参数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核说明传空处理意见为1
		 */
//		@Test
		public void postDisposeCommentTestAuditContentIsEmptyAuditOptionIs1() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "");
			request.put("auditMsg", 13770);
			request.put("auditOption", 1);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核说明传空处理意见为1" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核说明传空格处理意见为1
		 */
//		@Test
		public void postDisposeCommentTestAuditContentIsSpaceAuditOptionIs1() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", " ");
			request.put("auditMsg", 13770);
			request.put("auditOption", 1);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核说明传空格处理意见为1" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核说明传null处理意见为1
		 */
//		@Test
		public void postDisposeCommentTestAuditContentIsNullAuditOptionIs1() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "<@$#%^%*&>");
			request.put("auditMsg", 13770);
			request.put("auditOption", 1);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核说明传null处理意见为1" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 审核说明不传参数处理意见为1
		 */
//		@Test
		public void postDisposeCommentTestAuditContentNonSubmissionParametersAuditOptionIs1() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditMsg", 13770);
			request.put("auditOption", 1);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("审核说明不传参数处理意见为1" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 处理意见传错误
		 */
//		@Test
		public void postDisposeCommentTestAuditMsgIsError() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 1377002);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("处理意见传错误" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 处理意见传负数
		 */
//		@Test
		public void postDisposeCommentTestAuditMsgIsNegativeNumber() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", -12);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("处理意见传负数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 处理意见传小数
		 */
//		@Test
		public void postDisposeCommentTestAuditMsgIsDecimal() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 1.3);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("处理意见传小数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 处理意见传0
		 */
//		@Test
		public void postDisposeCommentTestAuditMsgIs0() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 0);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("处理意见传0" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 处理意见传String
		 */
//		@Test
		public void postDisposeCommentTestAuditMsgIsString() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", "hkhj");
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("处理意见传String" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 处理意见传空
		 */
//		@Test
		public void postDisposeCommentTestAuditMsgIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", "");
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("处理意见传空" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 处理意见传空格
		 */
//		@Test
		public void postDisposeCommentTestAuditMsgIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", " ");
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("处理意见传空格" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 处理意见传null
		 */
//		@Test
		public void postDisposeCommentTestAuditMsgIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", null);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("处理意见传null" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 处理意见传超长
		 */
//		@Test
		public void postDisposeCommentTestAuditMsgIsLong() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 999999999999999999L);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("处理意见传超长" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 处理意见不传参数
		 */
//		@Test
		public void postDisposeCommentTestAuditMsgNonSubmissionParameters() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("处理意见不传参数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 处理意见id传0正常
		 */
//		@Test
		public void postDisposeCommentTestAuditOptionIs0() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("处理意见id传0正常" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 处理意见id传1隐藏
		 */
//		@Test
		public void postDisposeCommentTestAuditOptionIs1() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 1);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("处理意见id传1隐藏" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 处理意见id传错误值
		 */
//		@Test
		public void postDisposeCommentTestAuditOptionIsError() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 8);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("处理意见id传错误值" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 处理意见id传负数
		 */
//		@Test
		public void postDisposeCommentTestAuditOptionIsNegativeNumber() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", -1);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("处理意见id传负数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 处理意见id传小数
		 */
//		@Test
		public void postDisposeCommentTestAuditOptionIsDecimal() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 1.3);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("处理意见id传小数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 处理意见id传空
		 */
//		@Test
		public void postDisposeCommentTestAuditOptionIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", "");
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("处理意见id传空" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 处理意见id传空格
		 */
//		@Test
		public void postDisposeCommentTestAuditOptionIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", " ");
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("处理意见id传空格" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 处理意见id传null
		 */
//		@Test
		public void postDisposeCommentTestAuditOptionIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", null);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("处理意见id传null" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 处理意见id传String
		 */
//		@Test
		public void postDisposeCommentTestAuditOptionIsString() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", "DGDSG");
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("处理意见id传String" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 处理意见id传最大值
		 */
//		@Test
		public void postDisposeCommentTestAuditOptionIsMax() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 99999999);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("处理意见id传最大值" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 处理意见id不传参数
		 */
//		@Test
		public void postDisposeCommentTestAuditOptionNonSubmissionParameters() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("commentUserId", 12495005);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("处理意见id不传参数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论人id传错误值
		 */
//		@Test
		public void postDisposeCommentTestCommentUserIdIsError() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495009);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论人id传错误值" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论人id传未登录
		 */
//		@Test
		public void postDisposeCommentTestCommentUserIdIsNotLoggedIn() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12495009);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论人id传未登录" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论人id传最大值
		 */
//		@Test
		public void postDisposeCommentTestCommentUserIdIsMax() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 99999999);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论人id传最大值" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论人id传空
		 */
//		@Test
		public void postDisposeCommentTestCommentUserIdIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", "");
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论人id传空" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论人id传空格
		 */
//		@Test
		public void postDisposeCommentTestCommentUserIdIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", " ");
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论人id传空格" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论人id传null
		 */
//		@Test
		public void postDisposeCommentTestCommentUserIdIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", null);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论人id传null" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论人id传0
		 */
//		@Test
		public void postDisposeCommentTestCommentUserIdIs0() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 0);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论人id传0" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论人id传负数
		 */
//		@Test
		public void postDisposeCommentTestCommentUserIdIsNegativeNumber() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", -123);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论人id传负数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论人id传小数
		 */
//		@Test
		public void postDisposeCommentTestCommentUserIdIsDecimal() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", 12.3);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论人id传小数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论人id传String
		 */
//		@Test
		public void postDisposeCommentTestCommentUserIdIsString() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			request.put("commentUserId", "dfsff");
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论人id传String" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论人id不传参数
		 */
//		@Test
		public void postDisposeCommentTestCommentUserIdNonSubmissionParameters() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			request.put("userId", 1234567);
			request.put("userName", "测试");
			request.put("auditContent", "审核说明");
			request.put("auditMsg", 13770);
			request.put("auditOption", 0);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论人id不传参数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
}