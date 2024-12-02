package mini.chat.minichat.repository;

import mini.chat.minichat.repository.entity.ChatRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, Long> {
    List<ChatRoomEntity> findChatRoomEntitiesById(Long id);
}
