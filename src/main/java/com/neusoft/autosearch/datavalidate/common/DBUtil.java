package com.neusoft.autosearch.datavalidate.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * 
 * <p>[描述信息：数据库连接工具类]</p>
 *
 * @author 范丹平
 * @mail fandp@neusoft.com
 * @version 1.0 Created on 2018-8-15 下午01:36:35
 */
public class DBUtil {
	  static Connection connection = null;// 创建一个数据库连接
      PreparedStatement ps = null;
      ResultSet rs = null;
	  static
	    {
	        try
	        {
	            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();// 加载Oracle驱动程序
	            //System.out.println("oracle驱动程序加载中！");
	        }
	        catch(InstantiationException e1)
	        {
	            System.out.println("实例异常");
	        }
	        catch(IllegalAccessException e2)
	        {
	            System.out.println("访问异常");
	        }
	        catch(ClassNotFoundException e3)
	        {
	            System.out.println("MySQL驱动类找不到");
	        }
	    }

	    /***
	     * 返回一个数据库连接
	     */     
	    public static Connection getConnection()
	    {
	      
	        try
	        {
	          //  System.out.println("开始尝试连接数据库！");
	            String url = "jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS_LIST =(ADDRESS = (PROTOCOL = TCP)(HOST = 10.50.146.154)(PORT = 1521))(ADDRESS = (PROTOCOL = TCP)(HOST = 10.50.146.155)(PORT = 1521))(FAILOVER = on)(LOAD_BALANCE = yes))(CONNECT_DATA =(SERVER = DEDICATED)(SERVICE_NAME = ssdb)))";//Oracle的默认数据库名
	            String user = "sipo_prosearch";// 系统默认的用户名
	            String password = "sipo_prosearch";// 安装时设置的密码
	            connection = DriverManager.getConnection(url, user, password);// 获取连接
	           // System.out.println(url);
	            //System.out.println("用户名："+user+"\t"+"密码：******");
	           // System.out.println("数据库连接成功！");
	            return connection;
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    /** 
	     * 关闭连接 
	     */  
	    public void closeAll(ResultSet rs, PreparedStatement ps, Connection con){
	        try {
				if(rs != null){
					rs.close();
				}if(ps != null){
					ps.close();
				}if(con != null){
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }

}
