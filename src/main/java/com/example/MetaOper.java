package com.example;

import java.sql.Connection;
//import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator 
 * MetaOper: 通过ResultSetMetaData元数据,设置灵活查询语句
 * 
 */
public class MetaOper {
	public static void main(String[] args) {
		
		String dataType = "perCenter81";
		
		String selectSql = "SELECT * FROM T_ADDRESS_INFO WHERE USER_ID = '12495324'";
		String insertIntoSql = "INSERT INTO T_ADDRESS_INFO (\"ADDRESS_ID\",\"USER_ID\",\"CONTACT_NAME\", \"CONTACT_INFO\", \"PROVINCE_CODE\", \"CITY_CODE\", \"COUNTY_CODE\", \"DETAILED_ADDRESS\", \"IS_DEFAULT\", \"IS_DELETE\", \"MODIFY_TIME\", \"CREATE_TIME\", \"LABEL\", \"BRIEF_ADDRESS\") VALUES (T_ADDRESS_INFO_SEQ.nextval,'12495324', '测试君', '13524001140', '上海市', '上海市', '浦东新区', '会一直了', '0', '1', TO_DATE('2016-12-02 13:19:54', 'SYYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-02 10:59:05', 'SYYYY-MM-DD HH24:MI:SS'), NULL, NULL)";
		System.out.println("insertIntoSql=="+insertIntoSql);
		MetaOper.insert(insertIntoSql, dataType);
		/*MetaOper.read(selectSql, dataType);
			//System.out.println(MetaOper.read(selectSql, dataType).get(0));
			/*List<Map<String, Object>> list = MetaOper.read(sql, dataType);
			for (Map<String, Object> map : list) {
				orderNo =orderNo+map.get("orderNo").toString()+",";
			}*/
				List<Map<String,Object>> list ;
			list =MetaOper.read(selectSql,dataType);
			System.out.println("list======="+list);
			String CODE = list.get(0).get("USER_ID").toString();
			System.out.println("CODE==="+CODE);
 }


	 public static  void update(String sql ,String dataType) {		//更新
		Connection conn = null;		
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection(dataType);
            ps = conn.prepareStatement(sql);
            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
        	// System.out.println("执行finally");
            DBUtils.free(rs, ps, conn);
           // System.out.println("释放成功");
        }
            
	 }


 public static  void insert(String sql,String dataType) {  //插入
	 Connection conn = null;
     PreparedStatement ps = null;
     ResultSet rs = null;
     try {
         conn = DBUtils.getConnection(dataType);
         ps = conn.prepareStatement(sql);
         ps.executeUpdate();
       	
     } catch (Exception e) {
    	 e.printStackTrace();
         throw new RuntimeException();
     } finally {
     	// System.out.println("执行finally");
         DBUtils.free(rs, ps, conn);
        //System.out.println("释放成功");
	 }
 }
 public static  void delete(String sql,String dataType) { //删除
	 Connection conn = null;
     PreparedStatement ps = null;
     ResultSet rs = null;
     try {
         conn = DBUtils.getConnection(dataType);
         ps = conn.prepareStatement(sql);
         ps.execute();
     } catch (Exception e) {
         throw new RuntimeException();
     } finally {
     	// System.out.println("执行finally");
         DBUtils.free(rs, ps, conn);
         //System.out.println("释放成功");
	 }
 }
	
    // 通过结果集元数据封装List结果集
    public static List<Map<String, Object>> read(String sql,String dataType) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection(dataType);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = ps.getMetaData();

            // 取得结果集列数
            int columnCount = rsmd.getColumnCount();

            // 构造泛型结果集
            List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();
            Map<String, Object> data = null;

            // 循环结果集
            //System.out.println(rs.next());
            while (rs.next()) {
                data = new HashMap<String, Object>();
                // 每循环一条将列名和列值存入Map
                for (int i = 1; i < columnCount; i++) {
                	try {
                		  data.put(rsmd.getColumnLabel(i), rs.getObject(rsmd
                                  .getColumnLabel(i)));
					} catch (Exception e) {
					//	System.out.println("数据存储："+rsmd.getColumnLabel(i));
						e.printStackTrace();
					}
                  
                }
                // 将整条数据的Map存入到List中
                datas.add(data);
            }
          //  System.out.println("准备释放");
            return datas;
        } catch (Exception e) {
        	e.printStackTrace();
            throw new RuntimeException();
        } finally {
        	// System.out.println("执行finally");
            DBUtils.free(rs, ps, conn);
          //  System.out.println("释放成功");
        }
    }

   /* // 通过数据库元数据获得服务器信息
    public static void DbMeta(String dataType) {
        Connection conn = null;
        try {
            conn = DBUtils.getConnection(dataType);
            DatabaseMetaData dbma = conn.getMetaData();
            //System.out.println("----------数据库信息------------");
          //  System.out.println("数据库名称: " + dbma.getDatabaseProductName());
          //  System.out.println("驱动版本: " + dbma.getDriverVersion());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }*/

}