package co.yedam.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {
	private static SqlSessionFactory sqlSessionFactory;
	private DataSource() {
		
	}
	// mybatis 환경파일을 읽어와서 클래스를 만든다
	public static SqlSessionFactory geInstance() {
		String resource = "config/mybatis-config.xml";
		InputStream is = null;	
		try {
			is = Resources.getResourceAsStream(resource);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		
		return sqlSessionFactory;
	}
}
