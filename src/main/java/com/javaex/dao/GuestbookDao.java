package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	// 필드
	@Autowired
	private SqlSession sqlSession;

	// 생성자

	// Gs

	// 일반
	// 리스트
	public List<GuestbookVo> getGuestList() {

		List<GuestbookVo> guestList = sqlSession.selectList("guestbook.selectList");

		return guestList;
	}

	public int addGuest(GuestbookVo guestbookVo) {

		return sqlSession.insert("guestbook.addGuest", guestbookVo);

	}

	public int guestDelete(int no) {

		return sqlSession.delete("guestbook.guestDelete", no);
	}
	
	public String guestPassword(int no) {
		
		return sqlSession.selectOne("guestbook.guestPassword", no);
	}
}
