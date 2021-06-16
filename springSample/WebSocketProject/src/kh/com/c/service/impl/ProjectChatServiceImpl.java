package kh.com.c.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.c.dao.ProjectChatDao;
import kh.com.c.model.ChatDto;
import kh.com.c.model.ChatMemberDto;
import kh.com.c.service.ProjectChatService;

@Service
public class ProjectChatServiceImpl implements ProjectChatService {

	@Autowired
	ProjectChatDao projectChatDao;	
	
	@Override
	public ChatDto checkRoom(String name) {
		return projectChatDao.checkRoom(name);
	}

	@Override
	public void createChatRoom(ChatDto dto) {
		projectChatDao.createChatRoom(dto);
	}

	@Override
	public List<ChatDto> getRoomList() {
		return projectChatDao.getRoomList();
	}

	@Override
	public void addRoomMember(ChatMemberDto mem) {
		projectChatDao.addRoomMember(mem);
	}

	@Override
	public ChatMemberDto getRoomMember(ChatMemberDto mem) {
		return projectChatDao.getRoomMember(mem);
	}

	@Override
	public List<ChatMemberDto> sameRoomList(ChatMemberDto mem) {
		return projectChatDao.sameRoomList(mem);
	}

	@Override
	public void updateRoomMember(ChatMemberDto mem) {
		projectChatDao.updateRoomMember(mem);
	}

	@Override
	public void deleteRoomMember(ChatMemberDto mem) {
		projectChatDao.deleteRoomMember(mem);
	}

	@Override
	public void updateChatCountInc(ChatDto dto) {
		projectChatDao.updateChatCountInc(dto);
	}

	@Override
	public void updateChatCountDec(ChatDto dto) {
		projectChatDao.updateChatCountDec(dto);
	}

	@Override
	public void deleteChat() {
		projectChatDao.deleteChat();
	}

	@Override
	public List<ChatDto> searchRoomList(String name) {
		return projectChatDao.searchRoomList(name);
	}

	
}
