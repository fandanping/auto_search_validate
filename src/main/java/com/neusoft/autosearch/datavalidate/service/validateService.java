package com.neusoft.autosearch.datavalidate.service;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import com.neusoft.autosearch.datavalidate.common.DBUtil;
import com.neusoft.autosearch.datavalidate.common.IDGenerator;
import com.neusoft.autosearch.datavalidate.common.ReadExcelUtil;

/**
 * 
 * <p>
 * [描述信息：业务操作类]
 * </p>
 * 
 * @author 范丹平
 * @mail fandp@neusoft.com
 * @version 1.0 Created on 2018-8-15 下午01:58:29
 */
public class validateService {
	
	public static void add (Map<Integer, Map<Integer, Object>> map){	
		String sql="insert into auto_search_validate(id,seq,cname,type,anum,pnum,app_ori,app_sid,pub_ori,pub_sid) values (?,?,?,?,?,?,?,?,?,?)";
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement prest = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
			        ResultSet.CONCUR_READ_ONLY);
			conn.setAutoCommit(false);
			for(Integer key:map.keySet()){
			    Map<Integer, Object> m=map.get(key);
				for(Integer k :m.keySet()){
					 prest.setString(1, IDGenerator.generate());
					 prest.setString(2, (String) m.get(0));
					 prest.setString(3, (String) m.get(1));
					 prest.setString(4, (String) m.get(2));
					 prest.setString(5, (String) m.get(3));
					 prest.setString(6, (String) m.get(4));
					 prest.setString(7, (String) m.get(5));
					 prest.setString(8, (String) m.get(6));
					 prest.setString(9, (String) m.get(7));
					 prest.setString(10, (String) m.get(8));
					
				}				
				 prest.addBatch();
			}
	            prest.executeBatch();
	            conn.commit();
	            conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	static int count=0;
	public static void readFile(File dirFile) throws Exception {
		if (!dirFile.exists()) {
			System.out.println("文件目录不存在");
			return;
		}
		// 获取此目录下的所有文件名与目录名
		File[] fileList = dirFile.listFiles();
		for (int i = 0; i < fileList.length; i++) {
			if(fileList[i].isDirectory()){	//若是目录，则递归打印该目录下的文件
				readFile(fileList[i]);
			}else if(fileList[i].isFile()){
				String inOneFile = fileList[i].getAbsolutePath();
				System.out.println( inOneFile );
				count++;
				Map<Integer, Map<Integer, Object>> result =validate(inOneFile);
				//批量插入数据库
				add(result);
			}
		}
		
		System.out.println(count);
	}

	public static Map<Integer, Map<Integer, Object>> validate(String path)
			throws Exception {
		ReadExcelUtil readExcelUtil = new ReadExcelUtil(path);
		Map<Integer, Map<Integer, Object>> result = readExcelUtil
				.readExcelContent();
		return result;

	}

	public static void main(String[] args) throws Exception {
		readFile(new File("E:/validate"));
	}
}
