package me.gacl.gjp.service;

import java.util.List;

import me.gacl.gjp.dao.ZhangWuDao;
import me.gacl.gjp.domain.gjp;


/*
 * 调用dao层中的类
 */
public class zhangwuservice {
          private ZhangWuDao dao=new ZhangWuDao();
          
          public List<gjp> selectAll() {
        	  
      		return dao.selectAll();
      		
      		}
          
          public List<gjp> select(String start, String end) {
      		return dao.select(start, end);
      	}
          public void addZhangWu(gjp zw) {
        	  dao.addZhangWu(zw);
      	}
          public void editZhangWu(gjp zw) {
        	  dao.editZhangWu(zw);
      	}
          public void deleteZhangWu(int zwid) {
        	  dao.deleteZhangWu(zwid);
      	}
}
