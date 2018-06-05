package feedbackManagement;

import com.example.HttpUtil;
import com.example.MetaOper;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GetModifyManagerCheckDetailTest extends HttpUtil {
	// 获取更换管理员审核详情接口
	String url = "/modifyManager/getModifyManagerDetail";

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("applyId", 4);
		request.put("status", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为未登录用户
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestUserIdNotLoggedIn() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495397);
		request.put("applyId", 4);
		request.put("status", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为未登录用户" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为错误用户
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1249);
		request.put("applyId", 4);
		request.put("status", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误用户" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestUserIdIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "<$%@#$%>");
		request.put("applyId", 4);
		request.put("status", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 1249.5396);
		request.put("applyId", 4);
		request.put("status", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", -12495396);
		request.put("applyId", 4);
		request.put("status", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", " ");
		request.put("applyId", 4);
		request.put("status", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "");
		request.put("applyId", 4);
		request.put("status", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", null);
		request.put("applyId", 4);
		request.put("status", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("applyId", 4);
		request.put("status", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestUserIdIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 0);
		request.put("applyId", 4);
		request.put("status", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 999999999999999999L);
		request.put("applyId", 4);
		request.put("status", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID传String
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", "vfgfdg");
		request.put("applyId", 4);
		request.put("status", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID传String" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 申请id为错误
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestApplyIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("applyId", 100);
		request.put("status", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请id为错误" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 申请id传小数
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestApplyIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("applyId", 4.23);
		request.put("status", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请id传小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 申请id传负数
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestApplyIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("applyId", -4);
		request.put("status", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请id传负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 申请id传非法字符
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestApplyIdIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("applyId", "<#@%%$%>");
		request.put("status", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请id传非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 申请id传String
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestApplyIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("applyId", "gsdfsd");
		request.put("status", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请id传String" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 申请id传0
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestApplyIdIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("applyId", 0);
		request.put("status", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请id传0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 申请id传最大值
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestApplyIdIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("applyId", 999999999999999999L);
		request.put("status", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请id传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 申请id不传参数
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestApplyIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("status", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请id不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 申请id传空
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestApplyIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("applyId", "");
		request.put("status", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请id传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 申请id传空格
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestApplyIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("applyId", " ");
		request.put("status", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("申请id传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态status传错误值
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestStatusIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("applyId", 4);
		request.put("status", 5);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传错误值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态status传小数
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestStatusIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("applyId", 4);
		request.put("status", 2.36);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态status传负数
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestStatusIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("applyId", 4);
		request.put("status", -3);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态status传空
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestStatusIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("applyId", 4);
		request.put("status", "");		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态status传null
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestStatusIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("applyId", 4);
		request.put("status", null);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态status传String
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestStatusIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("applyId", 4);
		request.put("status", "vdsvdsf");		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传String" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态status不传参数
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestStatusNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("applyId", 4);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态status传0待审核
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestStatusIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("applyId", 4);
		request.put("status", 0);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传0待审核" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态status传1审核通过
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestStatusIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("applyId", 4);
		request.put("status", 1);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传1审核通过" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态status传2审核失败
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestStatusIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("applyId", 4);
		request.put("status", 2);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传2审核失败" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 状态status传最大值
	 */
	@Test
	public void postGetModifyManagerCheckDetailTestStatusIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("userId", 12495396);
		request.put("applyId", 4);
		request.put("status", 999999999);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	

}