package mini.chat.minichat.repository.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserChatRoomId implements Serializable {
    private Long userId;
    private Long chatRoomId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(Long chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserChatRoomId that = (UserChatRoomId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(chatRoomId, that.chatRoomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, chatRoomId);
    }
}