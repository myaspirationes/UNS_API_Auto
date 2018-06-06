package com.userManagement;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class GetUserLockedContentTest extends HttpUtil {
// 获取用户已锁定的内容列表接口
	String url = "uu-admin/UUuserManage/getUserLockedContent";
	String userId;
	@BeforeClass
	public void beforeClass(){
		userId = new BackUserLoginTest().userId;
	}

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetManagerParaSpecialTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", userId);
		request.put("operatorId", 12495396);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}


	
}