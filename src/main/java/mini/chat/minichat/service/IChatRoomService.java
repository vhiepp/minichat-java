package mini.chat.minichat.service;

import mini.chat.minichat.repository.entity.ChatRoomEntity;

import java.util.List;

public interface IChatRoomService {
    List<ChatRoomEntity> findChatRoomEntitiesById(Long id);
}
