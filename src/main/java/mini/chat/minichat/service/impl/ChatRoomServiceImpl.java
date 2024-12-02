package mini.chat.minichat.service.impl;

import mini.chat.minichat.repository.ChatRoomRepository;
import mini.chat.minichat.repository.entity.ChatRoomEntity;
import mini.chat.minichat.service.IChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatRoomServiceImpl implements IChatRoomService {
    @Autowired
    private ChatRoomRepository chatRoomRepository;

    @Override
    public List<ChatRoomEntity> findChatRoomEntitiesById(Long id) {
        return chatRoomRepository.findChatRoomEntitiesById(id);
    }
}