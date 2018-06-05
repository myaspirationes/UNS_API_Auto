package feedbackManagement;

import com.example.HttpUtil;
import com.example.MetaOper;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GetModifyManagerCheckListTest extends HttpUtil {
	// 获取更换管理员审核列表接口
	String url = "/modifyManager/getModifyManagerCheckList";

	/**
	 * 提交正确参数
	 */
	@Test
	public void postGetModifyManagerCheckListTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495324");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}

	/**
	 * 状态status为错误值
	 */
	@Test
	public void postGetModifyManagerCheckListTestStatusIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 99);
		request.put("mobile", "12495324");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status为错误值" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 状态status为小数
	 */
	@Test
	public void postGetModifyManagerCheckListTestStatusIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3.23);
		request.put("mobile", "12495324");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status为小数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 状态status为负数
	 */
	@Test
	public void postGetModifyManagerCheckListTestStatusIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", -12);
		request.put("mobile", "12495324");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status为负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 状态status为String
	 */
	@Test
	public void postGetModifyManagerCheckListTestStatusIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", "FGD");
		request.put("mobile", "12495324");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status为String" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 状态status为空格
	 */
	@Test
	public void postGetModifyManagerCheckListTestStatusIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", " ");
		request.put("mobile", "12495324");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status为空格" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 状态status为空
	 */
	@Test
	public void postGetModifyManagerCheckListTestStatusIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", "");
		request.put("mobile", "12495324");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status为空" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 状态status为null
	 */
	@Test
	public void postGetModifyManagerCheckListTestStatusIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", null);
		request.put("mobile", "12495324");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status为null" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 状态status为超长
	 */
	@Test
	public void postGetModifyManagerCheckListTestStatusIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 999999999999999999L);
		request.put("mobile", "12495324");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status为超长" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 状态status不传
	 */
	@Test
	public void postGetModifyManagerCheckListTestStatusNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("mobile", "12495324");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status不传" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 状态status传0待审核
	 */
	@Test
	public void postGetModifyManagerCheckListTestStatusIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 0);
		request.put("mobile", "12495324");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传0待审核" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 状态status传1审核通过
	 */
	@Test
	public void postGetModifyManagerCheckListTestStatusIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 1);
		request.put("mobile", "12495324");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传1审核通过" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 状态status传2审核失败
	 */
	@Test
	public void postGetModifyManagerCheckListTestStatusIs2() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 2);
		request.put("mobile", "12495324");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传2审核失败" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 状态status传3全查
	 */
	@Test
	public void postGetModifyManagerCheckListTestStatusIs3() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495324");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("状态status传3全查" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 手机号mobile错误
	 */
	@Test
	public void postGetModifyManagerCheckListTestMobileIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495324");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号mobile错误" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 手机号mobile超长
	 */
	@Test
	public void postGetModifyManagerCheckListTestMobileIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", 999999999999999999L);
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号mobile超长" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 手机号mobile小于11位
	 */
	@Test
	public void postGetModifyManagerCheckListTestMobileIsLeast11() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", 123);
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号mobile小于11位" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 手机号mobile前加00
	 */
	@Test
	public void postGetModifyManagerCheckListTestMobileIsBeforeAdd00() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "0012495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号mobile小于11位" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 手机号mobile前+86
	 */
	@Test
	public void postGetModifyManagerCheckListTestMobileIsBeforeAdd86() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "8612495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号mobile前+86" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 输入11位的固话（固话+区号）
	 */
	@Test
	public void postGetModifyManagerCheckListTestMobileIsTelephone() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "02136174886");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号mobile小于11位" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 手机号mobile存在小数
	 */
	@Test
	public void postGetModifyManagerCheckListTestMobileIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", 12.022226623);
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号mobile存在小数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 手机号mobile存在负数
	 */
	@Test
	public void postGetModifyManagerCheckListTestMobileIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "-12334567891");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号mobile存在负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 手机号mobile存在非法字符
	 */
	@Test
	public void postGetModifyManagerCheckListTestMobileIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "<@$@#@#>");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号mobile存在非法字符" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 手机号mobile为空
	 */
	@Test
	public void postGetModifyManagerCheckListTestMobileIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号mobile为空" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 手机号mobile为null
	 */
	@Test
	public void postGetModifyManagerCheckListTestMobileIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", null);
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号mobile为null" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 手机号mobile为空格
	 */
	@Test
	public void postGetModifyManagerCheckListTestMobileIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", " ");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号mobile为空格" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 手机号mobile不传参数
	 */
	@Test
	public void postGetModifyManagerCheckListTestMobileNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 1);
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("手机号mobile不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间头传错误格式
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyStartDateIsErrorFormat() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018/5/10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间头传错误格式" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间头小于提交时间尾
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyStartDateIsLessApplyEndDate() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间头小于提交时间尾" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间头大于提交时间尾
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyStartDateMoreApplyEndDate() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-20");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间头大于提交时间尾" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间头传时间戳
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyStartDateIsTimeStamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "1525501177");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间头传时间戳" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间头传年月日
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyStartDateIsYearMonthDay() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间头传年月日" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间头传时分秒
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyStartDateIsHourMinSec() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "12:12:11");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditStartDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间头传时分秒" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	

}