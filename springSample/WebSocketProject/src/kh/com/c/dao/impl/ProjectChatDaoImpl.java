package kh.com.c.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.c.dao.ProjectChatDao;
import kh.com.c.model.ChatDto;
import kh.com.c.model.ChatMemberDto;

@Repository
public class ProjectChatDaoImpl implements ProjectChatDao {
	
	@Autowired
	SqlSession sqlSession;
	
	String ns = "ProjectChat.";

	@Override
	public ChatMemberDto getRoomMember(ChatMemberDto dto) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns + "getRoomMember", dto);
	}

	@Override
	public void addRoomMember(ChatMemberDto dto) {
		// TODO Auto-generated method stub
		sqlSession.insert(ns + "addRoomMember", dto);
	}

	@Override
	public void updateRoomMember(ChatMemberDto dto) {
		// TODO Auto-generated method stub
		sqlSession.update(ns + "updateRoomMember", dto);
	}

	@Override
	public ChatDto checkRoom(String cname) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns+"getRoom", cname);
	}

	@Override
	public void createChatRoom(ChatDto chat) {
		sqlSession.insert(ns+"createChatRoom", chat);
	}

	
	
	
	@Override
	public List<ChatDto> getRoomList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(ns+"getRoomList");
	}

	@Override
	public List<ChatMemberDto> sameRoomList(ChatMemberDto mem) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(ns+"sameRoomList",mem);
	}

	@Override
	public void deleteRoomMember(ChatMemberDto mem) {
		sqlSession.delete(ns+"deleteRoomMember", mem);
	}

	@Override
	public void updateChatCountInc(ChatDto dto) {
		sqlSession.update(ns+"updateChatCountInc", dto);
	}

	@Override
	public void updateChatCountDec(ChatDto dto) {
		sqlSession.update(ns+"updateChatCountDec", dto);
	}

	@Override
	public void deleteChat() {
		sqlSession.delete(ns+"deleteChat");
	}

	@Override
	public List<ChatDto> searchRoomList(String name) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(ns+"searchRoomList", name);
	}

	
	
}
