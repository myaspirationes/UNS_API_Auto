package com.publicModule.systemManagement;

import com.example.HttpUtil;
import com.example.MetaOper;
import com.example.SetRoleAuthTreeAssignment;
import com.publicModule.login.BackUserLoginTest;
import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class AssignPermissionsForRolesTest extends HttpUtil {
// 为角色配置权限接口
	String url = "/uu-admin/BackUser/setRoleAuthTree";
	String userId;
	@BeforeClass
	public void beforeClass(){
	userId =new BackUserLoginTest().userId;
}
	
	String updateSql_1="UPDATE UUDBSIT.TB_ROLE_MENU_FUNCTION SET MENU_FUNCTION_ID='13709',MENU_FUNCTION_AUTH='13708_1',MENU_STATUS='1' WHERE \"ID\"='17' AND ROLE_ID='10000001'";
	String updateSql_2="UPDATE UUDBSIT.TB_ROLE_MENU_FUNCTION SET MENU_FUNCTION_ID='13711', MENU_FUNCTION_AUTH='13709_1:13708_0:13710_1:13711_0:13712_1:13713_0', MENU_STATUS='1' WHERE \"ID\"='18' AND ROLE_ID='10000001'";
	String updateSql_3="UPDATE UUDBSIT.TB_ROLE_MENU_FUNCTION SET MENU_FUNCTION_ID='13713', MENU_FUNCTION_AUTH='13709_0:13708_0:13710_1:13711_0:13712_1:13714_1', MENU_STATUS='0' WHERE \"ID\"='19' AND ROLE_ID='10000001'";
	String updateSql_4="UPDATE UUDBSIT.TB_ROLE_MENU_FUNCTION SET MENU_FUNCTION_ID='13715', MENU_FUNCTION_AUTH='13709_0:13708_0:13714_0', MENU_STATUS='0' WHERE \"ID\"='20' AND ROLE_ID='10000001'";
	String updateSql_5="UPDATE UUDBSIT.TB_ROLE_MENU_FUNCTION SET MENU_FUNCTION_ID='13718', MENU_FUNCTION_AUTH='13709_0:13708_0:13710_1:13711_0:13712_0', MENU_STATUS='0' WHERE \"ID\"='21' AND ROLE_ID='10000001'";
	String updateSql_6="UPDATE UUDBSIT.TB_ROLE_MENU_FUNCTION SET MENU_FUNCTION_ID='13720', MENU_FUNCTION_AUTH='13709_0:13708_1:13714_0', MENU_STATUS='0' WHERE \"ID\"='22' AND ROLE_ID='10000001'";
	String updateSql_7="UPDATE UUDBSIT.TB_ROLE_MENU_FUNCTION SET MENU_FUNCTION_ID='13721', MENU_FUNCTION_AUTH='13709_0:13708_1:13714_0', MENU_STATUS='0' WHERE \"ID\"='23' AND ROLE_ID='10000001'";
	String updateSql_8="UPDATE UUDBSIT.TB_ROLE_MENU_FUNCTION SET MENU_FUNCTION_ID='13722', MENU_FUNCTION_AUTH='13709_0:13708_0:13710_0:13711_0:13714_0', MENU_STATUS='0' WHERE \"ID\"='24' AND ROLE_ID='10000001'";
	String updateSql_9="UPDATE UUDBSIT.TB_ROLE_MENU_FUNCTION SET MENU_FUNCTION_ID='13723', MENU_FUNCTION_AUTH='13709_0:13708_0:13710_0:13711_0:13714_0', MENU_STATUS='0' WHERE \"ID\"='25' AND ROLE_ID='10000001'";
	String updateSql_10="UPDATE UUDBSIT.TB_ROLE_MENU_FUNCTION SET  MENU_FUNCTION_ID='13725', MENU_FUNCTION_AUTH='13709_0:13708_1:13714_0', MENU_STATUS='0' WHERE \"ID\"='26' AND ROLE_ID='10000001'";
	String updateSql_11="UPDATE UUDBSIT.TB_ROLE_MENU_FUNCTION SET MENU_FUNCTION_ID='13726', MENU_FUNCTION_AUTH='13709_0:13708_0:13714_1', MENU_STATUS='0' WHERE \"ID\"='27' AND ROLE_ID='10000001'";
	String updateSql_12="UPDATE UUDBSIT.TB_ROLE_MENU_FUNCTION SET MENU_FUNCTION_ID='13727', MENU_FUNCTION_AUTH='13709_0:13708_0:13714_0', MENU_STATUS='0' WHERE \"ID\"='28' AND ROLE_ID='10000001'";
	String updateSql_13="UPDATE UUDBSIT.TB_ROLE_MENU_FUNCTION SET MENU_FUNCTION_ID='13728', MENU_FUNCTION_AUTH='13709_0:13708_0:13714_0', MENU_STATUS='0' WHERE \"ID\"='29' AND ROLE_ID='10000001'";
	String dataType = "perCenter81";
	
	String deleteSql="DELETE FROM UUDBSIT.TB_ROLE_MENU_FUNCTION WHERE ROLE_ID=10000001 AND MENU_FUNCTION_AUTH IS NULL";
	String selectMenuStatus="SELECT MENU_STATUS FROM UUDBSIT.TB_ROLE_MENU_FUNCTION WHERE ROLE_ID='10000001' AND MENU_FUNCTION_ID=13708";
	String selectFunctionStatus="SELECT MENU_FUNCTION_AUTH FROM UUDBSIT.TB_ROLE_MENU_FUNCTION WHERE ROLE_ID='10000001' AND MENU_FUNCTION_ID=13709";
	
	@AfterMethod
	public void afterMethod() 
	{
//		重置数据库用户角色菜单状态
		MetaOper.update(updateSql_1, dataType);
		MetaOper.update(updateSql_2, dataType);
		MetaOper.update(updateSql_3, dataType);
		MetaOper.update(updateSql_4, dataType);
		MetaOper.update(updateSql_5, dataType);
		MetaOper.update(updateSql_6, dataType);
		MetaOper.update(updateSql_7, dataType);
		MetaOper.update(updateSql_8, dataType);
		MetaOper.update(updateSql_9, dataType);
		MetaOper.update(updateSql_10, dataType);
		MetaOper.update(updateSql_11, dataType);
		MetaOper.update(updateSql_12, dataType);
		MetaOper.update(updateSql_13, dataType);
		MetaOper.delete(deleteSql, dataType);
	}
	
	SetRoleAuthTreeAssignment setRole=new SetRoleAuthTreeAssignment();
	
	/**
	 * 提交正确参数
	 */
	@Test
	public void postAssignPermissionsForRolesTestCorrectParameter() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("userId", userId,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("提交正确参数" + post);
		System.out.println("请求参数" + request);
	
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	
	/**
	 * 用户ID为错误ID
	 */
	@Test
	public void postAssignPermissionsForRolesTestUserIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("userId", 0001,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为错误ID" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 用户ID为非法字符
	 */
	@Test
	public void postAssignPermissionsForRolesTestUserIdIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("userId", "#$%^&",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
//		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为小数
	 */
	@Test
	public void postAssignPermissionsForRolesTestUserIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("userId", 123.456,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为小数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 用户ID为负数
	 */
	@Test
	public void postAssignPermissionsForRolesTestUserIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("userId", -1000000,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 用户ID为0
	 */
	@Test
	public void postAssignPermissionsForRolesTestUserIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("userId", 0,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为0" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 用户ID为String
	 */
	@Test
	public void postAssignPermissionsForRolesTestUserIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("userId", "10000000",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为String" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 用户ID为空格
	 */
	@Test
	public void postAssignPermissionsForRolesTestUserIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("userId", " ",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 用户ID为空
	 */
	@Test
	public void postAssignPermissionsForRolesTestUserIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("userId", "",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 用户ID为null
	 */
	@Test
	public void postAssignPermissionsForRolesTestUserIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("userId", null,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 用户ID不传该参数
	 */
	@Test
	public void postAssignPermissionsForRolesTestUserIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("userIdNotCommitted", userId,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID不传该参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 用户ID为超长
	 */
	@Test
	public void postAssignPermissionsForRolesTestUserIdIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("userId", 999999999999999999L,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("用户ID为超长" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("操作用户不存在");
	}
	/**
	 * 角色id为错误
	 */
	@Test
	public void postAssignPermissionsForRolesTestRoleIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("roleId", 1,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id为错误" + post);

//		删除错误的roleId
		MetaOper.delete("DELETE FROM UUDBSIT.TB_ROLE_MENU_FUNCTION WHERE ROLE_ID='1'", dataType);
		
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("权限值不存在");
		

	}
	/**
	 * 角色id为小数
	 */
	@Test
	public void postAssignPermissionsForRolesTestRoleIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("roleId", 0.01,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id为小数" + post);
//		删除错误的roleId
		MetaOper.delete("DELETE FROM UUDBSIT.TB_ROLE_MENU_FUNCTION WHERE ROLE_ID='0'", dataType);
		
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("权限值不存在");
	}
	
	/**
	 * 角色id为负数
	 */
	@Test
	public void postAssignPermissionsForRolesTestRoleIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("roleId", -1,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id为负数" + post);
//		删除错误的roleId
		MetaOper.delete("DELETE FROM UUDBSIT.TB_ROLE_MENU_FUNCTION WHERE ROLE_ID='-1'", dataType);
		
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("权限值为数值");
	}
	/**
	 * 角色id传非法字符
	 */
	@Test
	public void postAssignPermissionsForRolesTestRoleIdIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("roleId", "#$%^&",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id传非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
//		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色id传空
	 */
	@Test
	public void postAssignPermissionsForRolesTestRoleIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("roleId", "",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 角色id传空格
	 */
	@Test
	public void postAssignPermissionsForRolesTestRoleIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("roleId", " ",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 角色id传String
	 */
	@Test
	public void postAssignPermissionsForRolesTestRoleIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("roleId", "10000001",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id传String" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 角色id不传参数
	 */
	@Test
	public void postAssignPermissionsForRolesTestRoleIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("roleIdNotCommitted", 0,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("失败");
	}
	/**
	 * 角色id传0
	 */
	@Test
	public void postAssignPermissionsForRolesTestRoleIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("roleId", 0,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("角色id传0" + post);
//		删除错误的roleId
		MetaOper.delete("DELETE FROM UUDBSIT.TB_ROLE_MENU_FUNCTION WHERE ROLE_ID='0'", dataType);
		
		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("权限值不存在");
	}
	/**
	 * 菜单名称menuName传超长
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("menuName", "测试菜单ds的广东分公司郭德纲符合国家科技撒发射点发射点广泛大锅饭个",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单名称menuName传超长" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("");
	}
	/**
	 * 菜单名称menuName传空
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("menuName", "",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单名称menuName传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("");
	}
	/**
	 * 菜单名称menuName传空格
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("menuName", " ",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单名称menuName传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("");
	}
	/**
	 * 菜单名称menuName传null
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("menuName", null,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单名称menuName传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("");
	}
	/**
	 * 菜单名称menuName传错误值
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuNameIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("menuName", "测试菜单ds的广东分公司郭德纲符合国家科技撒发射点发射点广泛大锅饭个",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单名称menuName传错误值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("");
	}
	/**
	 * 菜单名称menuName不传参数
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("menuNameNotCommitted", "工作台",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单名称menuName不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("");
	}
	/**
	 * 菜单id传错误值
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("menuId", 1,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单id传错误值" + post);

		assertThat(post.get("status")).isEqualTo(500);
//		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单id传小数
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("menuId", 1.2,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单id传小数" + post);

		assertThat(post.get("status")).isEqualTo(500);
//		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单id传负数
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("menuId", -1,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单id传负数" + post);

		assertThat(post.get("status")).isEqualTo(500);
//		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单id传空
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("menuId", "",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单id传空" + post);

		assertThat(post.get("status")).isEqualTo(500);
//		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单id传空格
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("menuId", " ",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单id传空格" + post);

		assertThat(post.get("status")).isEqualTo(500);
//		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单id传null
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("menuId", null,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单id传null" + post);

		assertThat(post.get("status")).isEqualTo(500);
//		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单id不传参数
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("menuIdNotCommitted", null,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单id不传参数" + post);

		assertThat(post.get("status")).isEqualTo(500);
//		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单是否被选中menuStatus传错误值
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuStatusIError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("menuStatus", 99,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单是否被选中menuStatus传错误值" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("状态值有误");
	}
	/**
	 * 菜单是否被选中menuStatus传小数
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuStatusIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("menuStatus", 1.2,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单是否被选中menuStatus传小数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("状态值有误");
	}
	/**
	 * 菜单是否被选中menuStatus传负数
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuStatusIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("menuStatus", -1,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单是否被选中menuStatus传负数" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("状态值有误");
	}
	/**
	 * 菜单是否被选中menuStatus传空格
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuStatusIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("menuStatus", " ",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单是否被选中menuStatus传空格" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("状态值有误");
	}
	/**
	 * 菜单是否被选中menuStatus传null
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuStatusIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("menuStatus", null,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单是否被选中menuStatus传null" + post);

		assertThat(post.get("status")).isEqualTo(-3);
		assertThat(post.get("msg")).isEqualTo("状态值有误");
	}
	/**
	 * 菜单是否被选中menuStatus传非法字符
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuStatusIsIllegalCharacters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("menuStatus", "#$%^&",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单是否被选中menuStatus传非法字符" + post);

		assertThat(post.get("status")).isEqualTo(400);
//		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单是否被选中menuStatusbuchuan 不传参数
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuStatusNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("menuStatusNotCommitted", 1,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单是否被选中menuStatusbuchuan 不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 菜单是否被选中menuStatus传0未被选中
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuStatusIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("menuStatus", 0,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单是否被选中menuStatus传0未被选中" + post);

		List<Map<String,Object>> list ;
		list=MetaOper.read(selectMenuStatus, dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("MENU_STATUS").toString()).isEqualTo("0");
	}
	/**
	 * 菜单是否被选中menuStatus传1被选中
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuStatusIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("menuStatus", 1,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单是否被选中menuStatus传1被选中" + post);

		List<Map<String,Object>> list ;
		list=MetaOper.read(selectMenuStatus, dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("MENU_STATUS").toString()).isEqualTo("1");
	}
	/**
	 * 菜单是否被选中menuStatus先传1再传0
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuStatusIs1Again0() throws Exception {
		postAssignPermissionsForRolesTestMenuStatusIs1();
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("menuStatus", 0,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单是否被选中menuStatus先传1再传0" + post);

		List<Map<String,Object>> list ;
		list=MetaOper.read(selectMenuStatus, dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("MENU_STATUS").toString()).isEqualTo("0");
	}
	/**
	 * 菜单是否被选中menuStatus先传0再传1
	 */
	@Test
	public void postAssignPermissionsForRolesTestMenuStatusIs0Again1() throws Exception {
		postAssignPermissionsForRolesTestMenuStatusIs0();
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("menuStatus", 1,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("菜单是否被选中menuStatus先传0再传1" + post);

		List<Map<String,Object>> list ;
		list=MetaOper.read(selectMenuStatus, dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("MENU_STATUS").toString()).isEqualTo("1");
	}
	/**
	 * 功能描述function传超长
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("function", "测试功能描述dfs打个复活复活复活合格符合符合韩国的凤凰股份回购共和党和",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能描述function传超长" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能描述function传空
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("function", "",userId);		
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能描述function传空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能描述function传空格
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("function", " ",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能描述function传空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能描述function传null
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("function",null,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能描述function传null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能描述function传0
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("function", 0,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能描述function传0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能描述function不传参数
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("functionNotCommitted", null,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能描述function不传参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能名称funcitonName传超长字符
	 */
	@Test
	public void postAssignPermissionsForRolesTestFuncitonNameIsLong() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();		
		request=setRole.setRoleRightListMenuId("funcitonName", "测试功能名称的犯得上方法方法反对呱呱呱呱呱呱呱呱呱呱呱呱呱呱呱顶顶顶顶顶顶顶",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能名称funcitonName传超长字符" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能名称funcitonName传空
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionNameIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonName", "",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能名称funcitonName传空" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能名称funcitonName传空格
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionNameIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonName", " ",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能名称funcitonName传空格" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能名称funcitonName传null
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionNameIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonName", null,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能名称funcitonName传null" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能名称funcitonName不传参数
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionNameNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonNameNotCommitted", "",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能名称funcitonName不传参数" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能id传错误
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIdIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonId", 99,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能id传错误" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("");
	}
	/**
	 * 功能id传小数
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIdIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonId", 9.9,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能id传小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("");
	}
	
	/**
	 * 功能id传负数
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIdIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonId", -1,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能id传负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("");
	}
	/**
	 * 功能id传空
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIdIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonId", "",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能id传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("");
	}
	/**
	 * 功能id传空格
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIdIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonId", " ",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能id传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("");
	}
	/**
	 * 功能id传null
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIdIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonId", null,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能id传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("");
	}
	/**
	 * 功能id传String
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIdIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonId", "13708",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能id传String" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能id不传参数
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIdNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonIdNotCommitted", 13708,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能id不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能id传0
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionIdIsZero() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonId", 0,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能id传0" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态funcitonStatus传错误值
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIsError() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonStatus", 99,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态funcitonStatus传错误值" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态funcitonStatus传小数
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIsDecimal() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonStatus", 9.9,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态funcitonStatus传小数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态funcitonStatus传负数
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIsNegativeNumber() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonStatus", -1,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态funcitonStatus传负数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态funcitonStatus传空
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIsEmpty() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonStatus", "",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态funcitonStatus传空" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态funcitonStatus传空格
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIsSpace() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonStatus", " ",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态funcitonStatus传空格" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态funcitonStatus传null
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIsNull() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonStatus",null,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态funcitonStatus传null" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态funcitonStatus传String
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIsString() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonStatus", "1",userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态funcitonStatus传String" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态funcitonStatus不传参数
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusNonSubmissionParameters() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonStatusNotCommitted", 1,userId);
   		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态funcitonStatus不传参数" + post);

		assertThat(post.get("status")).isEqualTo(-1);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态funcitonStatus传1被选中
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIs1() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonStatus", 1,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态funcitonStatus传1被选中" + post);

		List<Map<String,Object>> list ;
		list=MetaOper.read(selectFunctionStatus, dataType);
		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
		assertThat(list.get(0).get("MENU_FUNCTION_AUTH").toString()).isEqualTo("13708_1");
	}
	/**
	 * 功能状态funcitonStatus传0未被选中
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIs0() throws Exception {
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonStatus", 0,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态funcitonStatus传0未被选中" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态funcitonStatus先传1再传0
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIs1Again0() throws Exception {
		postAssignPermissionsForRolesTestFunctionStatusIs1();
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonStatus", 0,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态funcitonStatus先传1再传0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态funcitonStatus先传0再传1
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIs0Again1() throws Exception {
		postAssignPermissionsForRolesTestFunctionStatusIs0();
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonStatus", 1,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态funcitonStatus先传0再传1" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态先传0再传0
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIs0Again0() throws Exception {
		postAssignPermissionsForRolesTestFunctionStatusIs0();
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonStatus", 0,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态先传0再传0" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
	/**
	 * 功能状态先传1再传1
	 */
	@Test
	public void postAssignPermissionsForRolesTestFunctionStatusIs1Again1() throws Exception {
		postAssignPermissionsForRolesTestFunctionStatusIs1();
		Map<String, Object> request = new HashMap<String, Object>();
		request=setRole.setRoleRightListMenuId("funcitonStatus", 1,userId);
		JSONObject post = super.UNSPost(url, request);
		System.out.println("功能状态先传1再传1" + post);

		assertThat(post.get("status")).isEqualTo(0);
		assertThat(post.get("msg")).isEqualTo("成功");
	}
}