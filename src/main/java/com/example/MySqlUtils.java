package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Administrator 模板类DBUtils
 */
public final class MySqlUtils {
	// 参数定义
	// ?user=vine&password=dadiMSR1199&useUnicode=true&characterEncoding=utf-8
	private static String url = "jdbc:mysql://192.168.9.81:3306/wallet"; // 数据库地址
	private static String username = "wallet"; // 数据库用户名
	private static String password = "uns1066"; // 数据库密码

	private MySqlUtils() {

	}

	// 加载驱动
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载出错!");
		}
	}

	// 获得连接
	public static Connection getConnection(String dataType) throws SQLException {
		Connection con = null;
		if (dataType == "wallet81") {
			con = DriverManager.getConnection(url, username, password);
			// return DriverManager.getConnection(url, username, password);
		} /*
			 * else if(dataType == "yxc"){ con = DriverManager.getConnection(
			 * "jdbc:mysql://rm-uf63jqo1o12t445bqo.mysql.rds.aliyuncs.com:3306/repairtstdb?user=vine&password=pAssw0rd&useUnicode=true&characterEncoding=utf-8"
			 * ); }else if(dataType == "yxc_ddp"){ con =
			 * DriverManager.getConnection(
			 * "jdbc:mysql://rm-uf63jqo1o12t445bqo.mysql.rds.aliyuncs.com:3306/ddp?user=vine&password=pAssw0rd&useUnicode=true&characterEncoding=utf-8"
			 * ); }
			 */
		else {
			con = null;
		}
		return con;
	}

	// 释放连接
	public static void free(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null) {
				rs.close(); // 关闭结果集
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close(); // 关闭Statement
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close(); // 关闭连接
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

		}

	}

}