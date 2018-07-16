package com.webOperateWallet.accountManagement;

import com.example.HttpUtil;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class AccountForzenTest extends HttpUtil {
// 账户冻结接口
	String url = "/BackUser/getUserOperateLogByWalletId";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postAccountForzenTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);		
		request.put("remark", "自动化测试");
		request.put("type", 1);
		request.put("operateType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 用户id为空
	 */
	@Test
	public void postAccountForzenTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", "");		
		request.put("remark", "自动化测试");
		request.put("type", 1);
		request.put("operateType", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 用户id为空格
	 */
	@Test
	public void postAccountForzenTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", " ");		
		request.put("remark", "自动化测试");
		request.put("type", 1);
		request.put("operateType", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 用户id为null
	 */
	@Test
	public void postAccountForzenTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", null);		
		request.put("remark", "自动化测试");
		request.put("type", 1);
		request.put("operateType", 1);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 用户id为不传
	 */
	@Test
	public void postAccountForzenTestUserIdNotCommitted() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);	
		request.put("remark", "自动化测试");
		request.put("type", 1);
		request.put("operateType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 用户id为最大值
	 */
	@Test
	public void postAccountForzenTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", "3164646887845415645645");
		request.put("remark", "自动化测试");
		request.put("type", 1);
		request.put("operateType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户id为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
	/**
	 * 钱包id为空
	 */
	@Test
	public void postAccountForzenTestWalletIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", "");
		request.put("userId", userId);
		request.put("remark", "自动化测试");
		request.put("type", 1);
		request.put("operateType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("钱包id为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 钱包id为空格
	 */
	@Test
	public void postAccountForzenTestWalletIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", " ");
		request.put("userId", userId);
		request.put("remark", "自动化测试");
		request.put("type", 1);
		request.put("operateType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("钱包id为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 钱包id为null
	 */
	@Test
	public void postAccountForzenTestWalletIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", null);
		request.put("userId", userId);
		request.put("remark", "自动化测试");
		request.put("type", 1);
		request.put("operateType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("钱包id为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 钱包id不传
	 */
	@Test
	public void postAccountForzenTestWalletIdIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("remark", "自动化测试");
		request.put("type", 1);
		request.put("operateType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("钱包id不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 钱包id为最大值
	 */
	@Test
	public void postAccountForzenTestWalletIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 999999999999999999L);
		request.put("userId", userId);
		request.put("remark", "自动化测试");
		request.put("type", 1);
		request.put("operateType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("钱包id为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * remark为空
	 */
	@Test
	public void postAccountForzenTestRemarkIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("remark", "");
		request.put("type", 1);
		request.put("operateType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("remark为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * remark为空格
	 */
	@Test
	public void postAccountForzenTestRemarkIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("remark", " ");
		request.put("type", 1);
		request.put("operateType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("remark为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * remark为null
	 */
	@Test
	public void postAccountForzenTestRemarkIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("remark", null);
		request.put("type", 1);
		request.put("operateType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("remark为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * remark不传
	 */
	@Test
	public void postAccountForzenTestRemarkIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("type", 1);
		request.put("operateType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("remark不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * remark为超长
	 */
	@Test
	public void postAccountForzenTestRemarkIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("remark", "赶回海口海口的好伐拉发截图额我若无开始的建行卡号咖啡机打开房间啊");
		request.put("type", 1);
		request.put("operateType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("remark为超长" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type为空
	 */
	@Test
	public void postAccountForzenTestTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("remark", "自动化测试");
		request.put("type", "");
		request.put("operateType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type为空格
	 */
	@Test
	public void postAccountForzenTestTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("remark", "自动化测试");
		request.put("type", " ");
		request.put("operateType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type为null
	 */
	@Test
	public void postAccountForzenTestTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("remark", "自动化测试");
		request.put("type", null);
		request.put("operateType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type为不传
	 */
	@Test
	public void postAccountForzenTestTypeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("remark", "自动化测试");
		request.put("operateType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type为最大值
	 */
	@Test
	public void postAccountForzenTestTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("remark", "自动化测试");
		request.put("type", 999999999);
		request.put("operateType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type为0个人
	 */
	@Test
	public void postAccountForzenTestTypeIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("remark", "自动化测试");
		request.put("type", 0);
		request.put("operateType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为0个人" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * type为1企业
	 */
	@Test
	public void postAccountForzenTestTypeIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("remark", "自动化测试");
		request.put("type", 1);
		request.put("operateType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("type为1企业" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * operateType为空
	 */
	@Test
	public void postAccountForzenTestOperateTypeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("remark", "自动化测试");
		request.put("type", 0);
		request.put("operateType", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operateType为空" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * operateType为空格
	 */
	@Test
	public void postAccountForzenTestOperateTypeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("remark", "自动化测试");
		request.put("type", 0);
		request.put("operateType", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operateType为空格" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * operateType为null
	 */
	@Test
	public void postAccountForzenTestOperateTypeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("remark", "自动化测试");
		request.put("type", 0);
		request.put("operateType", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operateType为null" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * operateType为不传
	 */
	@Test
	public void postAccountForzenTestOperateTypeIsNotCommit() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("remark", "自动化测试");
		request.put("type", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operateType为不传" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * operateType为最大值
	 */
	@Test
	public void postAccountForzenTestOperateTypeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("remark", "自动化测试");
		request.put("type", 0);
		request.put("operateType", 999999999);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operateType为最大值" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * operateType为0解冻
	 */
	@Test
	public void postAccountForzenTestOperateTypeIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("remark", "自动化测试");
		request.put("type", 0);
		request.put("operateType", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operateType为0解冻" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * operateType为1冻结
	 */
	@Test
	public void postAccountForzenTestOperateTypeIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 123);
		request.put("userId", userId);
		request.put("remark", "自动化测试");
		request.put("type", 0);
		request.put("operateType", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("operateType为1冻结" + post);
	
		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	
}
