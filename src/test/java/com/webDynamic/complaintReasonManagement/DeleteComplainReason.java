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
	String complaintId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}
	@BeforeMethod
	public void  beforeMethod() throws Exception {
		new AddAndEditComplainList().postAddAndEditComplainListTestTypeIs0();
		list = MetaOper.read(selectSql, dataType);
		complaintId = list.get(0).get("MSG_ID").toString();
	}
	//@AfterMethod
	public void afterMethod()
	{
		MetaOper.delete(deleteSql, dataType);
	}
	//@AfterClass
	public void afterClass(){
		MetaOper.delete(deleteSql, dataType);
	}
	
			
	
	/**
	 * 提交正确参数
	 */
	@Test
	public void postDeleteComplainReasonTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("reasionId", 13953);
		request.put("userId", userId);

		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
		
		
		/**
		 * 提交complaintId为错误的
		 */
//		@Test
		public void postDeleteComplainReasonTestComplaintIdIsError() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("complaintId", 001);
			request.put("operateUserId", userId);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交complaintId为错误的" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		
	}
		
		/**
		 * 提交complaintId为正确的String型
		 */
//		@Test
		public void postDeleteComplainReasonTestComplaintIdIsString() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("complaintId", "100000621");
			request.put("operateUserId", userId);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交complaintId为正确的String型" + post);

			assertThat(post.get("status")).isEqualTo(0);
			assertThat(post.get("msg")).isEqualTo("成功");
		}
		
		/**
		 * 提交complaintId为负数
		 */
//		@Test
		public void postDeleteComplainReasonTestComplaintIdIsNegative() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("complaintId", -1);
			request.put("operateUserId", userId);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交complaintId为负数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		}
	
		/**
		 * 提交complaintId为小数
		 */
//		@Test
		public void postDeleteComplainReasonTestComplaintIdIsDecimal() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("complaintId", 1.1);
			request.put("operateUserId", userId);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交complaintId为小数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		}
	
		/**
		 * 提交complaintId为非法字符
		 */
//		@Test
		public void postDeleteComplainReasonTestComplaintIdIsIllegalCharacter() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("complaintId", "!#%#^&");
			request.put("operateUserId", userId);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交complaintId为非法字符" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		}
		
		/**
		 * 提交complaintId为空格
		 */
//		@Test
		public void postDeleteComplainReasonTestComplaintIdIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("complaintId", " ");
			request.put("operateUserId", userId);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交complaintId为空格" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		}
		
		/**
		 * 提交complaintId为空
		 */
//		@Test
		public void postDeleteComplainReasonTestComplaintIdIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("complaintId", "");
			request.put("operateUserId", userId);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交complaintId为空" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		}
		
		/**
		 * 提交complaintId为null
		 */
//		@Test
		public void postDeleteComplainReasonTestComplaintIdIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("complaintId", null);
			request.put("operateUserId", userId);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交complaintId为null" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		}
		
		/**
		 * 不提交complaintId参数
		 */
//		@Test
		public void postDeleteComplainReasonTestComplaintIdNotCommitted() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("operateUserId", userId);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("不提交complaintId参数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		}
		
		/**
		 * 提交operateUserId为错误的
		 */
//		@Test
		public void postDeleteComplainReasonTestOperateUserIdIsError() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("complaintId", complaintId);
			request.put("operateUserId", 1002);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交operateUserId为错误的" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		}
		
		/**
		 * 提交operateUserId为正确的String
		 */
//		@Test
		public void postDeleteComplainReasonTestOperateUserIdIsString() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("complaintId", complaintId);
			request.put("operateUserId", "1000000");

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交operateUserId为正确的String" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		}
		
		/**
		 * 提交operateUserId为小数
		 */
//		@Test
		public void postDeleteComplainReasonTestOperateUserIdIsDecimal() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("complaintId", complaintId);
			request.put("operateUserId", 1.2);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交operateUserId为小数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		}
	
		/**
		 * 提交operateUserId为负数
		 */
//		@Test
		public void postDeleteComplainReasonTestOperateUserIdIsNegative() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("complaintId", complaintId);
			request.put("operateUserId", -1);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交operateUserId为负数" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		}
		
		/**
		 * 提交operateUserId为0
		 */
//		@Test
		public void postDeleteComplainReasonTestOperateUserIdIsZero() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("complaintId", complaintId);
			request.put("operateUserId", 0);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交operateUserId为0" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		}
		
		/**
		 * 提交operateUserId为非法字符
		 */
//		@Test
		public void postDeleteComplainReasonTestOperateUserIdIsIllegalCharacter() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("complaintId", complaintId);
			request.put("operateUserId", "#$%^&");

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交operateUserId为非法字符" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		}
		
		/**
		 * 提交operateUserId为超长字符
		 */
//		@Test
		public void postDeleteComplainReasonTestOperateUserIdIsLong() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("complaintId", complaintId);
			request.put("operateUserId","54312132132454513213456548678");

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交operateUserId为超长字符" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		}
		
		/**
		 * 提交operateUserId为空
		 */
//		@Test
		public void postDeleteComplainReasonTestOperateUserIdIsEmpty() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("complaintId", complaintId);
			request.put("operateUserId","");

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交operateUserId为空" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		}
		
		/**
		 * 提交operateUserId为空格
		 */
//		@Test
		public void postDeleteComplainReasonTestOperateUserIdIsSpace() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("complaintId", complaintId);
			request.put("operateUserId"," ");

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交operateUserId为空格" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		}
		
		/**
		 * 提交operateUserId为null
		 */
//		@Test
		public void postDeleteComplainReasonTestOperateUserIdIsNull() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("complaintId", complaintId);
			request.put("operateUserId",null);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("提交operateUserId为null" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		}
		
		/**
		 * 不提交operateUserId
		 */
//		@Test
		public void postDeleteComplainReasonTestOperateUserIdNotCommitted() throws Exception {
			Map<String, Object> request = new HashMap<String, Object>();
			request.put("complaintId", complaintId);

			JSONObject post = super.UNSPost(url, request);
			System.out.println("不提交operateUserId" + post);

			assertThat(post.get("status")).isEqualTo(-1);
			assertThat(post.get("msg")).isEqualTo("失败");
		}

}