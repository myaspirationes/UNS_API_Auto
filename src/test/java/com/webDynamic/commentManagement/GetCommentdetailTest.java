package com.webDynamic.commentManagement;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GetCommentdetailTest extends HttpUtil {
	// 搜索获取评论列表接口
	String url = "/uu-admin/SystemManager/getUserList";
	
	String dataType = "perCenter81";
	
	BackUserLoginTest login = new BackUserLoginTest();
	String userId=login.userId;
	
	
			
	
	/**
	 * 提交正确参数
	 */
//	@Test
	public void postGetCommentdetailTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("commentId", 1453);
		request.put("category", 1);
		request.put("classify", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}	
		/**
		 * 评论id为负数
		 */
//		@Test
		public void postGetCommentdetailCommentIdIsNegativeNumber() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", -1453);
			request.put("category", 9);
			request.put("classify", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论id为负数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论id为错误
		 */
//		@Test
		public void postGetCommentdetailCommentIdIsError() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", -1111);
			request.put("category", 9);
			request.put("classify", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论id为错误" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论id为小数
		 */
//		@Test
		public void postGetCommentdetailCommentIdIsDecimal() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1.23);
			request.put("category", 9);
			request.put("classify", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论id为小数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论id为String
		 */
//		@Test
		public void postGetCommentdetailCommentIdIsString() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", "bdbd");
			request.put("category", 9);
			request.put("classify", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论id为String" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论id为0
		 */
//		@Test
		public void postGetCommentdetailCommentIdIs0() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 0);
			request.put("category", 9);
			request.put("classify", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论id为0" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论id为空
		 */
//		@Test
		public void postGetCommentdetailCommentIdIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", "");
			request.put("category", 9);
			request.put("classify", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论id为空" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论id为空格
		 */
//		@Test
		public void postGetCommentdetailCommentIdIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", " ");
			request.put("category", 9);
			request.put("classify", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论id为空格" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论id为null
		 */
//		@Test
		public void postGetCommentdetailCommentIdIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", null);
			request.put("category", 9);
			request.put("classify", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论id为null" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论id不传参数
		 */
//		@Test
		public void postGetCommentdetailCommentIdNonSubmissionParameters() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("category", 9);
			request.put("classify", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论id不传参数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 评论id为超长
		 */
//		@Test
		public void postGetCommentdetailCommentIdIsLong() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 999999999999999999L);
			request.put("category", 9);
			request.put("classify", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("评论id为超长" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类category传负数
		 */
//		@Test
		public void postGetCommentdetailCategoryIsNegativeNumber() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", -9);
			request.put("classify", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类category传负数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类category传小数
		 */
//		@Test
		public void postGetCommentdetailCategoryIsDecimal() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 9.3);
			request.put("classify", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类category传小数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类category传空
		 */
//		@Test
		public void postGetCommentdetailCategoryIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", "");
			request.put("classify", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类category传空" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类category传空格
		 */
//		@Test
		public void postGetCommentdetailCategoryIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", " ");
			request.put("classify", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类category传空格" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类category传null
		 */
//		@Test
		public void postGetCommentdetailcategoryIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", null);
			request.put("classify", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类category传null" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类category传0
		 */
//		@Test
		public void postGetCommentdetailCategoryIs0() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类category传0" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类category传String
		 */
//		@Test
		public void postGetCommentdetailCategorysString() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类category传String" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类category传错误
		 */
//		@Test
		public void postGetCommentdetailCategoryIsError() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 99);
			request.put("classify", 0);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类category传错误" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类category为传最大值
		 */
//		@Test
		public void postGetCommentdetailCategoryIsMax() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 999999999);
			request.put("classify", 0);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类category为传最大值" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类category传1二手商品
		 */
//		@Test
		public void postGetCommentdetailCategoryIs1() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 1);
			request.put("classify", 0);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类category传1二手商品" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类category传2社交
		 */
//		@Test
		public void postGetCommentdetailCategoryIs2() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 2);
			request.put("classify", 0);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类category传2社交" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类category传3电商
		 */
//		@Test
		public void postGetCommentdetailCategoryIs3() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 3);
			request.put("classify", 0);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类category传3电商" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类category传4企业明信片
		 */
//		@Test
		public void postGetCommentdetailCategoryIs4() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 4);
			request.put("classify", 0);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类category传4企业明信片" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类classify传1动态
		 */
//		@Test
		public void postGetCommentdetailClassifyIs1() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 1);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类classify传1动态" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类classify传2用户
		 */
//		@Test
		public void postGetCommentdetailClassifyIs2() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 2);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类classify传2用户" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类classify传3商品
		 */
//		@Test
		public void postGetCommentdetailClassifyIs3() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 3);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类classify传3商品" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类classify传4企业
		 */
//		@Test
		public void postGetCommentdetailClassifyIsYMD() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 4);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类classify传4企业" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类classify传5品牌故事
		 */
//		@Test
		public void postGetCommentdetailClassifyIs5() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 5);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类classify传5品牌故事" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类classify传负数
		 */
//		@Test
		public void postGetCommentdetailClassifyIsHMS() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", -5);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类classify传负数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类classify传空格
		 */
//		@Test
		public void postGetCommentdetailClassifyIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", "");
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类classify传空格" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类classify传空
		 */
//		@Test
		public void postGetCommentdetailClassifyIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", "");
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类classify传空" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类classify传null
		 */
//		@Test
		public void postGetCommentdetailClassifyIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", null);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类classify传null" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类classify传错误值
		 */
//		@Test
		public void postGetCommentdetailClassifyIsError() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", "55");
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类classify传错误值" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类classify传最大值
		 */
//		@Test
		public void postGetCommentdetailClassifyIsMax() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 99999999);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类classify传最大值" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类classify不传参数
		 */
//		@Test
		public void postGetCommentdetailCclassifyIsDecimal() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类classify不传参数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		/**
		 * 分类classify传0
		 */
//		@Test
		public void postGetCommentdetailOperateStartTimeIs0() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("commentId", 1453);
			request.put("category", 0);
			request.put("classify", 0);
			JSONObject post = super.UNSPost(url, request);
			System.out.println("分类classify传0" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		

}