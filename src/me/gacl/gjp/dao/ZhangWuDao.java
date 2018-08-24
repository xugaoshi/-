package me.gacl.gjp.dao;
/*
 * 实现对数据表数据的增删改查
 * dbuils工具类完成，
 */

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import me.gacl.gjp.domain.gjp;
import me.gacl.gjp.tools.JDBCtils;


public class ZhangWuDao {
   private QueryRunner qr=new QueryRunner(JDBCtils.getDataSource());
   
   
   
   public List<gjp> selectAll() {
	   
		String sql = "select * from gjp_zhangwu";
		
		try {
			
			return qr.query(sql, new BeanListHandler<gjp>(gjp.class));
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
	}
   
   public List<gjp> select(String start, String end) {
	   
		String sql = "select * from gjp_zhangwu where createtime between ? and ?";
		
		Object[] params = {start, end};
		try {
			
			return qr.query(sql, new BeanListHandler<gjp>(gjp.class), params);
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
	}
   public void addZhangWu(gjp zw) {
	   
		String sql = "insert into gjp_zhangwu(flname,money,zhanghu,createtime,description) values(?,?,?,?,?)";
		try {
			
			Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
			
			qr.update(sql, params);
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}	
	}
   public void editZhangWu(gjp zw) {
	   
		String sql = "update gjp_zhangwu set flname=?, money=?,zhanghu=?,createtime=?,description=? where zwid=?";
		
		try {
			
			Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
			
			qr.update(sql, params);
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}	
	}
   public void deleteZhangWu(int zwid) {
	   
		String sql = "delete from gjp_zhangwu where zwid=?";
		
		try {
			
			qr.update(sql, zwid);
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
			
		}
	}

}
