package kr.com.ezen;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class Mainclass {

	public static void main(String[] args) {
		
		try {
			String resource = "kr/com/ezen/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			System.out.println(sqlSessionFactory);
			
			SqlSession session = sqlSessionFactory.openSession(true);
			
			Mapperinterface mapper = session.getMapper(Mapperinterface.class);
			
			System.out.println("session : " + session);
			
			MemberVO vo = new MemberVO();
			
			vo.setId(1);
			vo.setName("장합");
			vo.setPhone("010-1111-3333");
			vo.setAddress("서울시 도봉구");
			
//			mapper.updateMember(vo);
			
			mapper.deleteMember(1);

			
			
//			int result = mapper.insertMember(vo);
//			System.out.println("성공이면 :" + result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}