package com.neusoft.autosearch.datavalidate.test;
import com.neusoft.autosearch.datavalidate.common.DButils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 测试DButils工具类
 */
public class testDButils {
  public static void main(String[] args){
      DButils db=DButils.getInstance();
      db.getConnection();

      String sql ="select id,cname,type,anum,pnum,app_ori,app_sid,pub_ori,pub_sid,seq from auto_search_validate where cname =? and type = ?";
      List<Map<String, Object>> resList=new ArrayList<Map<String, Object>>();
      List<Object> list=new ArrayList<Object>();
      list.add("中译语通科技股份有限公司");
      list.add("化学");
      try {
          //resList=db.executeQuery(sql,list);
          resList=db.executeQuery(sql,list);
          System.out.println(resList);

      } catch (Exception e) {
          e.printStackTrace();
      }finally{
                      db.closeDB();
               }

  }

}
