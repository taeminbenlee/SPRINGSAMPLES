package kh.com.c.service;

import java.util.List;

import kh.com.c.model.ChatDto;
import kh.com.c.model.ChatMemberDto;

public interface ProjectChatService {

	public ChatMemberDto getRoomMember(ChatMemberDto dto);
	
	public void addRoomMember(ChatMemberDto dto);
	
	public void updateRoomMember(ChatMemberDto dto);
	
	public ChatDto checkRoom(String cname);
	
	public void createChatRoom(ChatDto chat);
	
	public List<ChatDto> getRoomList();
	
	List<ChatMemberDto> sameRoomList(ChatMemberDto mem);
	
	public void deleteRoomMember(ChatMemberDto mem);
	
	void updateChatCountInc(ChatDto dto);
	
	void updateChatCountDec(ChatDto dto);
	
	void deleteChat();
	
	List<ChatDto> searchRoomList(String name);
}
