package com.userManagement;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class UnLockedUserTest extends HttpUtil {
// 搜索获取日志列表接口
	String url = "/uu-admin/UUuserManage/unLockedUser";
	String userId;
	@BeforeClass
	public void beforeClass(){
		userId = new BackUserLoginTest().userId;
	}
	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetUserOperateLogTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("lockedUserId", 1);
		request.put("lockId", 0);

		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}


	
}