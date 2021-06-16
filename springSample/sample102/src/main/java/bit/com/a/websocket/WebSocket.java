package bit.com.a.websocket;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocket extends TextWebSocketHandler {

	private Map<String, WebSocketSession> userMap = new ConcurrentHashMap<String, WebSocketSession>();
	
	public WebSocket() {
		System.out.println("EchoHandler 생성됨 " + new Date());
	}

	// 클라이언트와 접속이 성공했을 때 호출
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("연결됨 " + session.getId() + " " + new Date());
		userMap.put(session.getId(), session);
	}

	// 클라이언트와 접속이 끊겼을 때
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("연결 종료 " + session.getId() + " " + new Date());
		userMap.remove(session.getId());
	}

	// 메시지 수신(recv)&송신(send)
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		// 수신(recv)
		System.out.println("메시지 수신:" + message.getPayload() + " " + new Date());
		
		// 송신(send) - 모든 client에 전송	
		for(WebSocketSession s : userMap.values()) {
			s.sendMessage(message);			
		}
	}

	// 예외 발생
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		
		System.out.println(session.getId() + " 예외발생 " + new Date());
	}
	
	
}








