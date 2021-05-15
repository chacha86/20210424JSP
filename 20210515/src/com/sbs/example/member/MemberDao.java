package com.sbs.example.member;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDao {
	SqlSessionFactory sqlSessionFactory;

	public MemberDao() throws IOException {
		// 경로
		String resource = "com/sbs/example/config/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		System.out.println(sqlSessionFactory);
	}
	
	public Member getMemberByLoginIdAndLoginPw(Member member) {
		Member result = null;
		SqlSession session = sqlSessionFactory.openSession();
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		result = mapper.getMemberByLoginIdAndLoginPw(member);
		
		return result;
		
	}
}
