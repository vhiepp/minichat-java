package mini.chat.minichat.repository.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "user_chat_rooms")
public class UserChatRoomEntity {
        @EmbeddedId
        private UserChatRoomId id;

        @ManyToOne
        @MapsId("userId")
        @JoinColumn(name = "user_id")
        private UserEntity user;

        @ManyToOne
        @MapsId("chatRoomId")
        @JoinColumn(name = "chat_room_id")
        private ChatRoomEntity chatRoom;

        public UserChatRoomId getId() {
            return id;
        }

        public void setId(UserChatRoomId id) {
            this.id = id;
        }

        public UserEntity getUser() {
            return user;
        }

        public void setUser(UserEntity user) {
            this.user = user;
        }

        public ChatRoomEntity getChatRoom() {
            return chatRoom;
        }

        public void setChatRoom(ChatRoomEntity chatRoom) {
            this.chatRoom = chatRoom;
        }
}
