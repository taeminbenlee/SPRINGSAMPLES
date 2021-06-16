package kh.com.c.dao;

import java.util.List;

import kh.com.c.model.ChatDto;
import kh.com.c.model.ChatMemberDto;

public interface ProjectChatDao {
	
	ChatMemberDto getRoomMember(ChatMemberDto dto);
	
	void addRoomMember(ChatMemberDto dto);
	
	void updateRoomMember(ChatMemberDto dto);
	
	ChatDto checkRoom(String cname);
	
	void createChatRoom(ChatDto chat);
	
	
	public List<ChatDto> getRoomList();
	
	List<ChatMemberDto> sameRoomList(ChatMemberDto mem);
	
	public void deleteRoomMember(ChatMemberDto mem);
	
	void updateChatCountInc(ChatDto dto);
	
	void updateChatCountDec(ChatDto dto);
	
	void deleteChat();
	
	List<ChatDto> searchRoomList(String name);
}
