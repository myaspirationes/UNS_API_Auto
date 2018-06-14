package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SetRoleAuthTreeAssignment {
	
//	通过key值判断修改哪个参数
	public Map<String, Object> setRoleRightListMenuId(String key,Object value,String userId) 
	{
		Map<String,Object> functions_view=new HashMap<String,Object>();
		functions_view.put("functioId", 13708);
		functions_view.put("functionName", "查看");
		functions_view.put("functionStatus", 1);
		
		Map<String,Object> functions_all=new HashMap<String,Object>();
		functions_all.put("functioId", 13709);
		functions_all.put("functionName", "全选");
		functions_all.put("functionStatus", 1);
		
		Map<String,Object> functions_modify=new HashMap<String,Object>();
		functions_modify.put("functioId", 13710);
		functions_modify.put("functionName", "修改");
		functions_modify.put("functionStatus", 1);
		
		Map<String,Object> functions_add=new HashMap<String,Object>();
		functions_add.put("functioId", 13711);
		functions_add.put("functionName", "新增");
		functions_add.put("functionStatus", 0);
		
		Map<String,Object> functions_delete=new HashMap<String,Object>();
		functions_delete.put("functioId", 13712);
		functions_delete.put("functionName", "删除");
		functions_delete.put("functionStatus", 1);
		
		Map<String,Object> functions_lock=new HashMap<String,Object>();
		functions_lock.put("functioId", 13713);
		functions_lock.put("functionName", "锁定");
		functions_lock.put("functionStatus", 0);
		
		Map<String,Object> functions_check=new HashMap<String,Object>();
		functions_check.put("functioId", 13714);
		functions_check.put("functionName", "审核");
		functions_check.put("functionStatus", 0);
		
//		 "subMenu": []
		ArrayList<Object> subMenuEmpty=new ArrayList<Object>();
		
				
		
//		工作台菜单
		
		Map<String,Object> functions_workbench=new HashMap<String,Object>();
		
//		***修改functioId***
		if(key.equals("functioId")) 
		{
			functions_workbench.put(key, value);
		}
		else 
			if(key.equals("functioIdNotCommitted"))
			{}
			else
			{
				functions_workbench.put("functioId", 13708);
			}
		
		
//		***修改functionName***
		if(key.equals("functionName")) 
		{
			functions_workbench.put(key, value);
		}
		else 
			if(key.equals("functionNameNotCommitted")){}
			else
			{
				functions_workbench.put("functionName", "查看");
			}
		
		
//		***修改functionStatus***
		if(key.equals("functionStatus")) 
		{
			functions_workbench.put(key, value);
		}		
		else 
			if(key.equals("functionStatusNotCommitted")){}
			else
			{
				functions_workbench.put("functionStatus", 1);
			}
			
				
		ArrayList<Map<String, Object>> functionsList_workbench=new ArrayList<Map<String, Object>>();
		functionsList_workbench.add(functions_view);
		
		Map<String,Object> subMenu_workbench=new HashMap<String,Object>();
		subMenu_workbench.put("menuId", 13709);
		subMenu_workbench.put("menuName", "工作台");
		subMenu_workbench.put("menuStatus", 1);
		subMenu_workbench.put("functions", functionsList_workbench);
		subMenu_workbench.put("subMenu",subMenuEmpty);
		
		ArrayList<Map<String, Object>> subMenu_workbench_L=new ArrayList<Map<String, Object>>();
		subMenu_workbench_L.add(subMenu_workbench);
		
		Map<String,Object> roleRight_workbench=new HashMap<String,Object>();
		
//		***修改menuId***
		if(key.equals("menuId")) 
		{
			roleRight_workbench.put(key, value);
		}
		else 
			if(key.equals("menuIdNotCommitted")){}
			else
			{
				roleRight_workbench.put("menuId", 13708);
			}
		
		
//		***修改menuName***
		if(key.equals("menuName")) 
		{
			roleRight_workbench.put(key, value);
		}
		else 
			if(key.equals("menuNameNotCommitted")){}
			else
			{
				roleRight_workbench.put("menuName", "工作台");
			}
		
		
//		***修改menuStatus***
		if(key.equals("menuStatus")) 
		{
			roleRight_workbench.put(key, value);
		}
		else 
			if(key.equals("menuStatusNotCommitted")){}
			else
			{
				roleRight_workbench.put("menuStatus", 1);
			}
		
		
//		***修改functions***
		if(key.equals("functions")) 
		{
			roleRight_workbench.put(key, value);
		}
		else 
			if(key.equals("functionsNotCommitted")){}
			else
			{
				roleRight_workbench.put("functions", null);
			}
		
		roleRight_workbench.put("subMenu", subMenu_workbench_L);
		
//		用户管理菜单
				
		ArrayList<Map<String, Object>> functionsList_user=new ArrayList<Map<String, Object>>();
		functionsList_user.add(functions_all);
		functionsList_user.add(functions_view);
		functionsList_user.add(functions_modify);
		functionsList_user.add(functions_add);
		functionsList_user.add(functions_delete);
		functionsList_user.add(functions_lock);
		
		Map<String,Object> subMenu_user=new HashMap<String,Object>();
		subMenu_user.put("menuId", 13711);
		subMenu_user.put("menuName", "用户列表");
		subMenu_user.put("menuStatus", 0);
		subMenu_user.put("functions", functionsList_user);
		subMenu_user.put("subMenu", subMenuEmpty);
		
		ArrayList<Map<String, Object>> subMenu_user_L=new ArrayList<Map<String, Object>>();
		subMenu_user_L.add(subMenu_user);
		
		Map<String,Object> roleRight_user=new HashMap<String,Object>();
		roleRight_user.put("menuId", 13710);
		roleRight_user.put("menuName", "用户管理");
		roleRight_user.put("menuStatus", 0);
		roleRight_user.put("functions", null);
		roleRight_user.put("subMenu", subMenu_user_L);
		
		
//		商户管理
		ArrayList<Map<String, Object>> functionsList_business=new ArrayList<Map<String, Object>>();
		functionsList_business.add(functions_all);
		functionsList_business.add(functions_view);
		functionsList_business.add(functions_modify);
		functionsList_business.add(functions_add);
		functionsList_business.add(functions_delete);
		functionsList_business.add(functions_lock);
		
		Map<String,Object> subMenu_business=new HashMap<String,Object>();
		subMenu_business.put("menuId", 13713);
		subMenu_business.put("menuName", "商户列表");
		subMenu_business.put("menuStatus", 0);
		subMenu_business.put("functions", functionsList_business);
		subMenu_business.put("subMenu", subMenuEmpty);
		
		ArrayList<Map<String, Object>> subMenu_business_L=new ArrayList<Map<String, Object>>();
		subMenu_business_L.add(subMenu_business);
						
		Map<String,Object> roleRight_business=new HashMap<String,Object>();
		roleRight_business.put("menuId", 13712);
		roleRight_business.put("menuName", "商户管理");
		roleRight_business.put("menuStatus", 1);
		roleRight_business.put("functions", null);
		roleRight_business.put("subMenu", subMenu_business_L);
		
//		审核管理
		ArrayList<Map<String, Object>> functionsList_check=new ArrayList<Map<String, Object>>();
		functionsList_check.add(functions_all);
		functionsList_check.add(functions_view);
		functionsList_check.add(functions_check);
		
		Map<String,Object> subMenu_check=new HashMap<String,Object>();
		subMenu_check.put("menuId", 13715);
		subMenu_check.put("menuName", "用户认证");
		subMenu_check.put("menuStatus", 0);
		subMenu_check.put("functions", functionsList_check);
		subMenu_check.put("subMenu", subMenuEmpty);
		
		ArrayList<Map<String, Object>> subMenu_check_L=new ArrayList<Map<String, Object>>();
		subMenu_check_L.add(subMenu_check);
				
		Map<String,Object> roleRight_check=new HashMap<String,Object>();
		roleRight_check.put("menuId", 13714);
		roleRight_check.put("menuName", "审核管理");
		roleRight_check.put("menuStatus", 0);
		roleRight_check.put("functions", null);
		roleRight_check.put("subMenu", subMenu_check_L);
		
//		钱包管理菜单
		
//		-账户管理
		ArrayList<Map<String, Object>> functionsList_account=new ArrayList<Map<String, Object>>();
		functionsList_account.add(functions_all);
		functionsList_account.add(functions_view);
		functionsList_account.add(functions_modify);
		functionsList_account.add(functions_add);
		functionsList_account.add(functions_delete);
		
		Map<String,Object> subMenu_account=new HashMap<String,Object>();
		subMenu_account.put("menuId", 13718);
		subMenu_account.put("menuName", "账户管理");
		subMenu_account.put("menuStatus", 0);
		subMenu_account.put("functions", functionsList_account);
		subMenu_account.put("subMenu", subMenuEmpty);
		
		ArrayList<Map<String, Object>> subMenu_account_list=new ArrayList<Map<String, Object>>();
		subMenu_account_list.add(subMenu_account);
		
		Map<String,Object> subMenu_account_L=new HashMap<String,Object>();
		subMenu_account_L.put("menuId", 13717);
		subMenu_account_L.put("menuName", "账户管理");
		subMenu_account_L.put("menuStatus", 0);
		subMenu_account_L.put("functions", null);
		subMenu_account_L.put("subMenu", subMenu_account_list);
		
		
//		-资金管理
//		 -- 资金流入
		ArrayList<Map<String, Object>> functionsList_money=new ArrayList<Map<String, Object>>();
		functionsList_money.add(functions_all);
		functionsList_money.add(functions_view);
		functionsList_money.add(functions_check);
		
		Map<String,Object> subMenu_money_in=new HashMap<String,Object>();
		subMenu_money_in.put("menuId", 13720);
		subMenu_money_in.put("menuName", "资金流入");
		subMenu_money_in.put("menuStatus", 0);
		subMenu_money_in.put("functions", functionsList_money);
		subMenu_money_in.put("subMenu", subMenuEmpty);
		
//		 -- 资金流出
		Map<String,Object> subMenu_money_out=new HashMap<String,Object>();
		subMenu_money_out.put("menuId", 13721);
		subMenu_money_out.put("menuName", "资金流出");
		subMenu_money_out.put("menuStatus", 0);
		subMenu_money_out.put("functions", functionsList_money);
		subMenu_money_out.put("subMenu", subMenuEmpty);
		
		
//		-- 退款管理
		ArrayList<Map<String, Object>> functionsList_refund=new ArrayList<Map<String, Object>>();
		functionsList_refund.add(functions_all);
		functionsList_refund.add(functions_view);
		functionsList_refund.add(functions_modify);
		functionsList_refund.add(functions_add);
		functionsList_refund.add(functions_check);
		
		Map<String,Object> subMenu_refund=new HashMap<String,Object>();
		subMenu_refund.put("menuId", 13722);
		subMenu_refund.put("menuName", "退款管理");
		subMenu_refund.put("menuStatus", 0);
		subMenu_refund.put("functions", functionsList_refund);
		subMenu_refund.put("subMenu", subMenuEmpty);
		
		
//		--保证金管理
		Map<String,Object> subMenu_margin=new HashMap<String,Object>();
		subMenu_margin.put("menuId", 13723);
		subMenu_margin.put("menuName", "保证金管理");
		subMenu_margin.put("menuStatus", 0);
		subMenu_margin.put("functions", functionsList_refund);
		subMenu_margin.put("subMenu", subMenuEmpty);
		
		
		
		ArrayList<Map<String, Object>> subMenu_money_manage=new ArrayList<Map<String, Object>>();
		subMenu_money_manage.add(subMenu_money_in);
		subMenu_money_manage.add(subMenu_money_out);
		subMenu_money_manage.add(subMenu_refund);
		subMenu_money_manage.add(subMenu_margin);
			
		
		Map<String,Object> subMenu_money_L=new HashMap<String,Object>();
		subMenu_money_L.put("menuId", 13719);
		subMenu_money_L.put("menuName", "资金管理");
		subMenu_money_L.put("menuStatus", 0);
		subMenu_money_L.put("functions", null);
		subMenu_money_L.put("subMenu", subMenu_money_manage);
		
		
//		-对账管理
//		--对账明细
		ArrayList<Map<String, Object>> functionsList_accountCheckDetail=new ArrayList<Map<String, Object>>();
		functionsList_accountCheckDetail.add(functions_all);
		functionsList_accountCheckDetail.add(functions_view);
		functionsList_accountCheckDetail.add(functions_check);
		
		Map<String,Object> subMenu_accountCheckDetail=new HashMap<String,Object>();
		subMenu_accountCheckDetail.put("menuId", 13725);
		subMenu_accountCheckDetail.put("menuName", "对账明细");
		subMenu_accountCheckDetail.put("menuStatus", 0);
		subMenu_accountCheckDetail.put("functions", functionsList_accountCheckDetail);
		subMenu_accountCheckDetail.put("subMenu", subMenuEmpty);
		
		
//		--调账明细
		ArrayList<Map<String, Object>> functionsList_accountRegulationDetail=new ArrayList<Map<String, Object>>();
		functionsList_accountRegulationDetail.add(functions_all);
		functionsList_accountRegulationDetail.add(functions_view);
		functionsList_accountRegulationDetail.add(functions_check);
		
		Map<String,Object> subMenu_accountRegulationDetail=new HashMap<String,Object>();
		subMenu_accountRegulationDetail.put("menuId", 13726);
		subMenu_accountRegulationDetail.put("menuName", "调账明细");
		subMenu_accountRegulationDetail.put("menuStatus", 0);
		subMenu_accountRegulationDetail.put("functions", functionsList_accountRegulationDetail);
		subMenu_accountRegulationDetail.put("subMenu", subMenuEmpty);
		
//		--商户对账
		ArrayList<Map<String, Object>> functionsList_businessAccountCheck=new ArrayList<Map<String, Object>>();
		functionsList_businessAccountCheck.add(functions_all);
		functionsList_businessAccountCheck.add(functions_view);
		functionsList_businessAccountCheck.add(functions_check);
		
		Map<String,Object> subMenu_businessAccountCheck=new HashMap<String,Object>();
		subMenu_businessAccountCheck.put("menuId", 13727);
		subMenu_businessAccountCheck.put("menuName", "商户对账");
		subMenu_businessAccountCheck.put("menuStatus", 0);
		subMenu_businessAccountCheck.put("functions", functionsList_businessAccountCheck);
		subMenu_businessAccountCheck.put("subMenu", subMenuEmpty);
		
//		--银生宝对账
		ArrayList<Map<String, Object>> functionsList_unspayAccountCheck=new ArrayList<Map<String, Object>>();
		functionsList_unspayAccountCheck.add(functions_all);
		functionsList_unspayAccountCheck.add(functions_view);
		functionsList_unspayAccountCheck.add(functions_check);
		
		Map<String,Object> subMenu_unspayAccountCheck=new HashMap<String,Object>();
		subMenu_unspayAccountCheck.put("menuId", 13728);
		subMenu_unspayAccountCheck.put("menuName", "银生宝对账");
		subMenu_unspayAccountCheck.put("menuStatus", 0);
		subMenu_unspayAccountCheck.put("functions", functionsList_unspayAccountCheck);
		subMenu_unspayAccountCheck.put("subMenu", subMenuEmpty);
		
		
		ArrayList<Map<String, Object>> subMenu_accountCheck_manage=new ArrayList<Map<String, Object>>();
		subMenu_accountCheck_manage.add(subMenu_accountCheckDetail);
		subMenu_accountCheck_manage.add(subMenu_accountRegulationDetail);
		subMenu_accountCheck_manage.add(subMenu_businessAccountCheck);
		subMenu_accountCheck_manage.add(subMenu_unspayAccountCheck);
			
		
		Map<String,Object> subMenu_accountCheck_L=new HashMap<String,Object>();
		subMenu_accountCheck_L.put("menuId", 13724);
		subMenu_accountCheck_L.put("menuName", "对账管理");
		subMenu_accountCheck_L.put("menuStatus", 0);
		subMenu_accountCheck_L.put("functions", null);
		subMenu_accountCheck_L.put("subMenu", subMenu_accountCheck_manage);
		
//		钱包管理菜单
		ArrayList<Map<String, Object>> subMenuList_wallet=new ArrayList<Map<String, Object>>();
		subMenuList_wallet.add(subMenu_account_L);
		subMenuList_wallet.add(subMenu_money_L);
		subMenuList_wallet.add(subMenu_accountCheck_L);
				
		Map<String,Object> roleRight_wallet=new HashMap<String,Object>();
		roleRight_wallet.put("menuId", 13716);
		roleRight_wallet.put("menuName", "钱包管理");
		roleRight_wallet.put("menuStatus", null);
		roleRight_wallet.put("functions", null);
		roleRight_wallet.put("subMenu", subMenuList_wallet);
		
		
		ArrayList<Map<String, Object>> roleRightList=new ArrayList<Map<String, Object>>();
		roleRightList.add(roleRight_workbench);
		roleRightList.add(roleRight_user);
		roleRightList.add(roleRight_wallet);
		
		Map<String,Object> request=new HashMap<String,Object>();
//		**修改userId**
		if(key.equals("userId")) 
		{
			request.put("userId", value);
		}
		else 
			if(key.equals("userIdNotCommitted")){}
			else
			{
				request.put("userId", userId);
			}
//		**修改roleId**
		if(key.equals("roleId")) 
		{
			request.put("roleId", value);
		}	
		else 
			if(key.equals("roleIdNotCommitted")){}
			else
			{
				request.put("roleId", "10000001");
			}
		
		request.put("roleRightList", roleRightList);
		
		return request;
		
	}
	

}
