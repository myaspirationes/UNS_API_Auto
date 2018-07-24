package com.webOperateWallet.accountManagement;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class AccountThawTest extends HttpUtil {
// 账户解冻接口
	String url = "/uu-admin/walletAuditEnterprise/updaeAccountStatus";
	String userId;
	String selEnterpriseWalletInfo = "SELECT * FROM T_ENTERPRISE_WALLET_INFO WHERE WALLET_ID = '4' ";
 
	String delSql = "DELETE FROM T_USER_OPERATE WHERE WALLET_ID = 4";
	String selSql = "select * from T_USER_OPERATE WHERE WALLET_ID = 4";
	String dataType = "wallet81";
	List<Map<String,Object>> list ;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}

	/**
	 * 提交正确参数:解冻企业账户
	 */
	@Test
	public void postAccountThawTestCorrectParameter1() throws Exception {
		new AccountForzenTest().postAccountForzenTestCorrectParameter();
		userId =new BackUserLoginTest().userId;
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 4);
		request.put("userId", userId);		
		request.put("remark", "自动化测试");
		request.put("type", 1);
		request.put("operateType", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数:解冻企业账户" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo(" 成功");
		list = MetaOper.read(selEnterpriseWalletInfo, dataType);
		assertThat(list.get(0).get("IS_FROZEN")).isEqualTo(0);
	}
	/**
	 * 提交正确参数:解冻个人账户
	 */
	@Test
	public void postAccountThawTestCorrectParameter2() throws Exception {
		new AccountForzenTest().postAccountForzenTestOperateTypeIs1();
		userId =new BackUserLoginTest().userId;
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("walletId", 10000016);
		request.put("userId", userId);		
		request.put("remark", "自动化测试");
		request.put("type", 0);
		request.put("operateType", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数:解冻个人账户" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo(" 成功");
		list = MetaOper.read("select * from t_wallet where WALLET_ID = 10000016",dataType);
		assertThat(list.get(0).get("IS_FROZEN")).isEqualTo(0);
	}
	/**
	 * 用户id为空
	 */
	@Test
	public void postAccountThawTestUserIdIsEmpty() throws Exception {
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
	public void postAccountThawTestUserIdIsSpace() throws Exception {
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
	public void postAccountThawTestUserIdIsNull() throws Exception {
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
	public void postAccountThawTestUserIdNotCommitted() throws Exception {
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
	public void postAccountThawTestUserIdIsLong() throws Exception {
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
	public void postAccountThawTestWalletIdIsEmpty() throws Exception {
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
	public void postAccountThawTestWalletIdIsSpace() throws Exception {
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
	public void postAccountThawTestWalletIdIsNull() throws Exception {
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
	public void postAccountThawTestWalletIdIsNotCommit() throws Exception {
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
	public void postAccountThawTestWalletIdIsMax() throws Exception {
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
	public void postAccountThawTestRemarkIsEmpty() throws Exception {
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
	public void postAccountThawTestRemarkIsSpace() throws Exception {
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
	public void postAccountThawTestRemarkIsNull() throws Exception {
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
	public void postAccountThawTestRemarkIsNotCommit() throws Exception {
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
	public void postAccountThawTestRemarkIsLong() throws Exception {
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
	public void postAccountThawTestTypeIsEmpty() throws Exception {
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
	public void postAccountThawTestTypeIsSpace() throws Exception {
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
	public void postAccountThawTestTypeIsNull() throws Exception {
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
	public void postAccountThawTestTypeIsNotCommit() throws Exception {
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
	public void postAccountThawTestTypeIsMax() throws Exception {
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
	public void postAccountThawTestTypeIs0() throws Exception {
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
	public void postAccountThawTestTypeIs1() throws Exception {
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
	public void postAccountThawTestOperateTypeIsEmpty() throws Exception {
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
	public void postAccountThawTestOperateTypeIsSpace() throws Exception {
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
	public void postAccountThawTestOperateTypeIsNull() throws Exception {
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
	public void postAccountThawTestOperateTypeIsNotCommit() throws Exception {
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
	public void postAccountThawTestOperateTypeIsMax() throws Exception {
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
	public void postAccountThawTestOperateTypeIs0() throws Exception {
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
	public void postAccountThawTestOperateTypeIs1() throws Exception {
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
