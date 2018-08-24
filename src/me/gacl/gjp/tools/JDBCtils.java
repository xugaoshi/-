package me.gacl.gjp.tools;

import org.apache.commons.dbcp.BasicDataSource;

public class JDBCtils {

	private static  BasicDataSource datasource =new BasicDataSource();
	
	static{
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/gjp");
		datasource.setUsername("root");
		datasource.setPassword("123456");
	}
	public static BasicDataSource getDataSource(){
		return datasource;
	}
}
