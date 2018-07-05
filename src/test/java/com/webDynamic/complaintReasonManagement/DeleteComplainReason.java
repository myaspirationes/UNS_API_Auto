package com.webDynamic.complaintReasonManagement;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;
import com.webDynamic.complaintReasonManagement.AddAndEditComplainList;
import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteComplainReason extends HttpUtil {
	// 删除投诉原因接口
	String url = "/uu-admin/complainManage/deleteComplainReason";
	
	String dataType = "uedb";
	String selectSql = "SELECT * FROM T_AUDIT_MSG WHERE MSG_CONTENT = '自动化测试投诉原因'";
	String deleteSql = "DELETE FROM T_AUDIT_MSG WHERE MSG_CONTENT = '自动化测试投诉原因'";
	List<Map<String,Object>> list ;
	String userId;
	String reasionId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}
	@BeforeMethod
	public void  beforeMethod() throws Exception {
		new AddAndEditComplainList().postAddAndEditComplainListTestTypeIs0();
		list = MetaOper.read(selectSql, dataType);
		reasionId = list.get(0).get("MSG_ID").toString();
	}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postDeleteComplainReasonTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("reasionId", reasionId);
		request.put("userId", userId);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
		
		
		/**
		 * 提交reasionId为错误的
		 */
		@Test
		public void postDeleteComplainReasonTestReasionIdIsError() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("reasionId", 001);
			request.put("userId", userId);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交reasionId为错误的" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		
	}
		
		/**
		 * 提交reasionId为正确的String型
		 */
		@Test
		public void postDeleteComplainReasonTestReasionIdIsString() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("reasionId", "dgdfgd");
			request.put("userId", userId);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交reasionId为正确的String型" + post);

			assertThat(post.get("status")).isEqualTo(400);
			//assertThat(post.get("msg")).isEqualTo("成功");
		}
		
		/**
		 * 提交reasionId为负数
		 */
		@Test
		public void postDeleteComplainReasonTestReasionIdIsNegative() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("reasionId", -1);
			request.put("userId", userId);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交reasionId为负数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("原因Id输入有误");
		}
	
		/**
		 * 提交reasionId为小数
		 */
		@Test
		public void postDeleteComplainReasonTestReasionIdIsDecimal() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("reasionId", 2.1);
			request.put("userId", userId);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交reasionId为小数" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		}
	
		/**
		 * 提交reasionId为非法字符
		 */
		@Test
		public void postDeleteComplainReasonTestReasionIdIsIllegalCharacter() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("reasionId", "!#%#^&");
			request.put("userId", userId);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交reasionId为非法字符" + post);

			assertThat(post.get("status")).isEqualTo(400);
			//assertThat(post.get("msg")).isEqualTo("失败");
		}
		
		/**
		 * 提交reasionId为空格
		 */
		@Test
		public void postDeleteComplainReasonTestReasionIdIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("reasionId", " ");
			request.put("userId", userId);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交reasionId为空格" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("原因Id输入有误");
		}
		
		/**
		 * 提交reasionId为空
		 */
		@Test
		public void postDeleteComplainReasonTestReasionIdIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("reasionId", "");
			request.put("userId", userId);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交reasionId为空" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("原因Id输入有误");
		}
		
		/**
		 * 提交reasionId为null
		 */
		@Test
		public void postDeleteComplainReasonTestReasionIdIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("reasionId", null);
			request.put("userId", userId);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交reasionId为null" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("原因Id输入有误");
		}
		
		/**
		 * 不提交reasionId参数
		 */
		@Test
		public void postDeleteComplainReasonTestReasionIdNotCommitted() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("userId", userId);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("不提交reasionId参数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("原因Id输入有误");
		}
		
		/**
		 * 提交userId为错误的
		 */
		@Test
		public void postDeleteComplainReasonTestUserIdIsError() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("reasionId", reasionId);
			request.put("userId", 1002);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交userId为错误的" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("请求参数用户ID不存在！");
		}
		
		/**
		 * 提交userId为正确的String
		 */
		@Test
		public void postDeleteComplainReasonTestUserIdIsString() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("reasionId", reasionId);
			request.put("userId", "dfdsfs");

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交userId为正确的String" + post);

			assertThat(post.get("status")).isEqualTo(400);
			//assertThat(post.get("msg")).isEqualTo("请求参数userId为非法数据！");
		}
		
		/**
		 * 提交userId为小数
		 */
		@Test
		public void postDeleteComplainReasonTestUserIdIsDecimal() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("reasionId", reasionId);
			request.put("userId", 1.2);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交userId为小数" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("请求参数用户ID不存在！");
		}
	
		/**
		 * 提交userId为负数
		 */
		@Test
		public void postDeleteComplainReasonTestUserIdIsNegative() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("reasionId", reasionId);
			request.put("userId", -1);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交userId为负数" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("请求参数userId为非法数据！");
		}
		
		/**
		 * 提交userId为0
		 */
		@Test
		public void postDeleteComplainReasonTestUserIdIsZero() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("reasionId", reasionId);
			request.put("userId", 0);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交userId为0" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("请求参数用户ID不存在！");
		}
		
		/**
		 * 提交userId为非法字符
		 */
		@Test
		public void postDeleteComplainReasonTestUserIdIsIllegalCharacter() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("reasionId", reasionId);
			request.put("userId", "#$%^&");

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交userId为非法字符" + post);

			assertThat(post.get("status")).isEqualTo(400);
			//assertThat(post.get("msg")).isEqualTo("请求参数userId为非法数据！");
		}
		
		/**
		 * 提交userId为超长字符
		 */
		@Test
		public void postDeleteComplainReasonTestUserIdIsLong() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("reasionId", reasionId);
			request.put("userId","54312132132454513213456548678");

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交userId为超长字符" + post);

			assertThat(post.get("status")).isEqualTo(400);
			//assertThat(post.get("msg")).isEqualTo("请求参数userId为非法数据！");
		}
		
		/**
		 * 提交userId为空
		 */
		@Test
		public void postDeleteComplainReasonTestUserIdIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("reasionId", reasionId);
			request.put("userId","");

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交userId为空" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("请求参数userId为非法数据！");
		}
		
		/**
		 * 提交userId为空格
		 */
		@Test
		public void postDeleteComplainReasonTestUserIdIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("reasionId", reasionId);
			request.put("userId"," ");

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交userId为空格" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("请求参数userId为非法数据！");
		}
		
		/**
		 * 提交userId为null
		 */
		@Test
		public void postDeleteComplainReasonTestUserIdIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("reasionId", reasionId);
			request.put("userId",null);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交userId为null" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("请求参数userId为非法数据！");
		}
		
		/**
		 * 不提交userId
		 */
		@Test
		public void postDeleteComplainReasonTestUserIdNotCommitted() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("reasionId", reasionId);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("不提交userId" + post);

			assertThat(post.get("status")).isEqualTo(-3);
			assertThat(post.get("msg")).isEqualTo("请求参数userId为非法数据！");
		}

}