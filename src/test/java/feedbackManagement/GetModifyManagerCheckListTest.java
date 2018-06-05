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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
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
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间头传时分秒" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间头传空格
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyStartDateIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", " ");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间头传空格" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间头传数字qu掉中间格式（20180524）
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyStartDateIsNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "20180510");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间头传数字qu掉中间格式（20180524）" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间头传空
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyStartDateIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间头传空" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间头传null
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyStartDateIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", null);
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间头传null" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间头传负数
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyStartDateIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", -123456);
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间头传负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间头传年月日最大时间
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyStartDateIsYearMonthDayMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "9999-12-31");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间头传年月日最大时间" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间头传年月日最小时间
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyStartDateIsYearMonthDayLeast() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "0001-1-1");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间头传年月日最小时间" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间头传时分秒最大时间
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyStartDateIsHourMinSecMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "23:59:59");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间头传时分秒最大时间" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间头传时分秒最小时间
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyStartDateIsHourMinSecLeast() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "00:00:00");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间头传时分秒最小时间" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间头传年月日时分秒
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyStartDateIsYearMonthDayHourMinSec() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10 12:12:22");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间头传年月日时分秒" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间头不传参数
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyStartDateNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间头不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间尾applyEndDate传错误格式
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyEndDateIsErrorFormat() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018/5/18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间尾applyEndDate传错误格式" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间尾applyEndDate传时间戳
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyEndDateIsTimeStamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "1526624377");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间尾applyEndDate传时间戳" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间尾applyEndDate传年月日
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyEndDateIsYearMonthDay() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间尾applyEndDate传年月日" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间尾applyEndDate传时分秒
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyEndDateIsHourMinSec() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "12:12:22");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间尾applyEndDate传时分秒" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间尾applyEndDate传数字去掉中间格式
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyEndDateIsNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "20180518");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间尾applyEndDate传数字去掉中间格式" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间尾applyEndDate传空
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyEndDateIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间尾applyEndDate传空" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间尾applyEndDate传空格
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyEndDateIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", " ");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间尾applyEndDate传空格" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间尾applyEndDate传null
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyEndDateIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", null);
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间尾applyEndDate传null" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间尾applyEndDate传负数
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyEndDateIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "-1234565");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间尾applyEndDate传负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间尾applyEndDate传年月日最大时间
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyEndDateIsYearMonthDayMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "9999-12-31");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间尾applyEndDate传年月日最大时间" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间尾applyEndDate传年月日最小时间
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyEndDateIsYearMonthDayLeast() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "1-1-1");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间尾applyEndDate传年月日最小时间" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间尾applyEndDate传时分秒最大时间
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyEndDateIsHourMinSecMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "23:59:59");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间尾applyEndDate传时分秒最大时间" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间尾applyEndDate传时分秒最小时间
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyEndDateIsHourMinSecLeast() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "00:00:00");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间尾applyEndDate传时分秒最小时间" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间尾applyEndDate传年月日时分秒
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyEndDateIsYearMonthDayHourMinSec() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18 15:22:33");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间尾applyEndDate传年月日时分秒" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 提交时间尾applyEndDate不传参数
	 */
	@Test
	public void postGetModifyManagerCheckListTestApplyEndDateIsNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交时间尾applyEndDate不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间头auditStartDate传错误格式
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditStartDateIsErrorFormat() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018/5/19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间头auditStartDate传错误格式" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间头auditStartDate小于审核时间尾
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditStartDateIsLessAuditEndDate() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间头auditStartDate小于审核时间尾" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间头auditStartDate大于审核时间尾
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditStartDateIsMoreAuditEndDate() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-22");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间头auditStartDate大于审核时间尾" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间头auditStartDate小于提交时间尾
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditStartDateIsLessApplyEndDate() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-9");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间头auditStartDate小于提交时间尾" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间头auditStartDate传时间戳
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditStartDateIsTimeStamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "1526710777");
		request.put("auditStartDate", "2018-5-9");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间头auditStartDate传时间戳" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间头auditStartDate传年月日
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditStartDateIsYearMonthDay() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-9");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间头auditStartDate传年月日" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间头auditStartDate传时分秒
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditStartDateIsHourMinSec() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "22:15:12");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间头auditStartDate传时分秒" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间头auditStartDate传年月日最大时间
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditStartDateIsYearMonthDayMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "9999-12-31");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间头auditStartDate传年月日最大时间" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间头auditStartDate传年月日最小时间
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditStartDateIsYearMonthDayLeast() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "1-1-1");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间头auditStartDate传年月日最小时间" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间头auditStartDate传时分秒最大时间
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditStartDateIsHourMinSecMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "23:59:59");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间头auditStartDate传时分秒最大时间" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间头auditStartDate传时分秒最小时间
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditStartDateIsHourMinSecLeast() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "00:00:00");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间头auditStartDate传时分秒最小时间" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间头auditStartDate传空
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditStartDateIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间头auditStartDate传年月日最小时间" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间头auditStartDatechuan 空格
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditStartDateIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", " ");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间头auditStartDate传空格" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间头auditStartDate传null
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditStartDateIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", null);
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间头auditStartDate传null" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间头auditStartDatechuan 负数
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditStartDateIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "-123456789");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间头auditStartDate传负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间头auditStartDate传数字去掉中间格式
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditStartDateIsNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "20180519");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间头auditStartDate传数字去掉中间格式" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间头传年月日时分秒
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditStartDateIsYearMonthDayHourMinSec() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19 14:22:42");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间头传年月日时分秒" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间头auditStartDate不传参数
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditStartDateNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间头auditStartDate不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间尾auditStartDate传错误格式
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditEndDateIsErrorFormat() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018/5/21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间尾传错误格式" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间尾auditStartDate传年月日
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditEndDateIsYearMonthDay() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间尾传年月日" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间尾auditStartDate时分秒
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditEndDateIsHourMinSec() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "13:12:55");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间尾时分秒" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间尾auditStartDatechuan 年月日最大时间
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditEndDateIsYearMonthDayMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "9999-12-31");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间尾传年月日最大时间" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间尾auditStartDate传年月日最小时间
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditEndDateIsYearMonthDayLeast() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "1/1/1");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间尾auditStartDate传年月日最小时间" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间尾auditStartDate传时间戳
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditEndDateIsTimeStamp() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "1526883577");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间尾传时间戳" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间尾auditStartDate传时分秒最大时间
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditEndDateIsHourMinSecMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "23:59:59");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间尾传时分秒最大时间" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间尾auditStartDate传时分秒最小时间
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditEndDateIsHourMinSecLeast() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "00:00:00");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间尾auditStartDate传时分秒最小时间" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间尾auditStartDate传数字去掉中间格式。如201180524
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditEndDateIsNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "20180521");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间尾传数字去掉中间格式" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间尾auditStartDate传负数
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditEndDateIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", -20152222);
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间尾传时间戳" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间尾auditStartDate传空
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditEndDateIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间尾传空" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间尾传空格
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditEndDateIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", " ");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间尾传空格" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间尾auditStartDate传null
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditEndDateIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", null);
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间尾auditStartDate传null" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间尾auditStartDate传年月日时分秒
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditEndDateIsYearMonthDayHourMinSec() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21 16:12:55");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间尾传空" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间尾auditStartDate传String
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditEndDateIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "fgsfgdxxx");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间尾传String" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间尾小于审核时间头
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditEndDateIsLessAuditStartDate() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-12");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间尾小于审核时间头" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间尾小于提交时间头
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditEndDateIsLessApplyStartDate() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-9");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间尾小于提交时间头" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 审核时间尾auditStartDate不传参数
	 */
	@Test
	public void postGetModifyManagerCheckListTestAuditEndDateNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("pageNo", 1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("审核时间尾不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 当前页码pageNo传0
	 */
	@Test
	public void postGetModifyManagerCheckListTestPageNoIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-21");
		request.put("pageNo", 0);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码pageNo传0" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 当前页码pageNo传负数
	 */
	@Test
	public void postGetModifyManagerCheckListTestPageNoIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-12");
		request.put("pageNo", -1);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码pageNo传负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 当前页码pageNo传小数
	 */
	@Test
	public void postGetModifyManagerCheckListTestPageNoIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-12");
		request.put("pageNo", 1.23);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码pageNo传小数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 当前页码pageNo传String
	 */
	@Test
	public void postGetModifyManagerCheckListTestPageNoIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-12");
		request.put("pageNo", "gdsfdsfs");
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码pageNo传String" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 当前页码pageNo传空
	 */
	@Test
	public void postGetModifyManagerCheckListTestPageNoIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-12");
		request.put("pageNo", "");
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码pageNo传空" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 当前页码pageNo传空格
	 */
	@Test
	public void postGetModifyManagerCheckListTestPageNoIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-12");
		request.put("pageNo", " ");
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码pageNo传空格" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 当前页码pageNo传null
	 */
	@Test
	public void postGetModifyManagerCheckListTestPageNoIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-12");
		request.put("pageNo", null);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码pageNo传null" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 当前页码pageNo传最大值
	 */
	@Test
	public void postGetModifyManagerCheckListTestPageNoIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-12");
		request.put("pageNo", 999999999);
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码pageNo传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 当前页码pageNo不传
	 */
	@Test
	public void postGetModifyManagerCheckListTestPageNoNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-12");
		request.put("pageSize", 5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("当前页码pageNo不传" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 每页大小pageSize传0
	 */
	@Test
	public void postGetModifyManagerCheckListTestPageSizeIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-12");
		request.put("pageNo", 1);
		request.put("pageSize", 0);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页大小pageSize传0" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 每页大小pageSize传小数
	 */
	@Test
	public void postGetModifyManagerCheckListTestPageSizeIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-12");
		request.put("pageNo", 1);
		request.put("pageSize", 5.26);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页大小pageSize传小数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 每页大小pageSize传负数
	 */
	@Test
	public void postGetModifyManagerCheckListTestPageSizeIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-12");
		request.put("pageNo", 1);
		request.put("pageSize", -5);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页大小pageSize传负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 每页大小pageSize传String
	 */
	@Test
	public void postGetModifyManagerCheckListTestPageSizeIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-12");
		request.put("pageNo", 1);
		request.put("pageSize", "fsdfsdf");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页大小pageSize传String" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	
	/**
	 * 每页大小pageSize传空
	 */
	@Test
	public void postGetModifyManagerCheckListTestPageSizeIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-12");
		request.put("pageNo", 1);
		request.put("pageSize", "");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页大小pageSize传空" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 每页大小pageSize传空格
	 */
	@Test
	public void postGetModifyManagerCheckListTestPageSizeIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-12");
		request.put("pageNo", 1);
		request.put("pageSize", " ");
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页大小pageSize传空格" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 每页大小pageSize传null
	 */
	@Test
	public void postGetModifyManagerCheckListTestPageSizeIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-12");
		request.put("pageNo", 1);
		request.put("pageSize", null);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页大小pageSize传null" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 每页大小pageSize不传参数
	 */
	@Test
	public void postGetModifyManagerCheckListTestPageSizeNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-12");
		request.put("pageNo", 1);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页大小pageSize不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}
	/**
	 * 每页大小pageSize传最大值
	 */
	@Test
	public void postGetModifyManagerCheckListTestPageSizeIsMax() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request.put("status", 3);
		request.put("mobile", "12495396");
		request.put("applyStartDate", "2018-5-10");
		request.put("applyEndDate", "2018-5-18");
		request.put("auditStartDate", "2018-5-19");
		request.put("auditEndDate", "2018-5-12");
		request.put("pageNo", 1);
		request.put("pageSize", 999999999);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("每页大小pageSize传最大值" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("数据包错误！");
	}

}