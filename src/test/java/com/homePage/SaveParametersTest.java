package com.homePage;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.example.HttpUtil;

public class SaveParametersTest extends HttpUtil {
// 保存板块参数接口
	String url = "uu-admin/container/getContainerParam";


	/**
	 * 提交正确参数
	 */
	@Test
	public void postSaveParametersTestCorrectParameter() throws Exception {
		Map<String, Object> con = new HashMap<String, Object>();
		con.put("userId", "12495324");
		con.put("carousel", 1);
		con.put("bigGunCount", 1);
		con.put("goodsCount", 1);
		con.put("usedCount", 1);
		con.put("mixtureHigh", 1);
		con.put("bigGunHigh", 1);
		con.put("shopHigh", 1);
		con.put("goodsHigh", 1);
		con.put("usedHigh", 1);
		
		Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
		request.put("con", con);
		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		JSONObject head1 = (JSONObject) post.get("head");
	
		assertThat(head1.get("st")).isEqualTo(0);
		assertThat(head1.get("msg")).isEqualTo("成功");
	}
	
	
}