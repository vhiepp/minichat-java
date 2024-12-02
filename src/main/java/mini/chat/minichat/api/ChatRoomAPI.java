package mini.chat.minichat.api;

import jakarta.transaction.Transactional;
import mini.chat.minichat.dto.UserFriendDTO;
import mini.chat.minichat.repository.entity.ChatRoomEntity;
import mini.chat.minichat.service.IChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
public class ChatRoomAPI {
    @Autowired
    private IChatRoomService chatRoomService;
    @GetMapping("api/chatroom")
    public ResponseEntity<List<ChatRoomEntity>> getChatRooms(@RequestParam Long Id) {
        List<ChatRoomEntity> chatrooms = chatRoomService.findChatRoomEntitiesById(Id);
        return ResponseEntity.ok(chatrooms);
    }



}
