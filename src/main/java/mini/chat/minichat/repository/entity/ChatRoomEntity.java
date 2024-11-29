package mini.chat.minichat.repository.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "chat_rooms")
public class ChatRoomEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false)
        private String room_key;

        @OneToMany(mappedBy = "chatRoom")
        private Set<ChatMessageEntity> chatMessages;

        @OneToMany(mappedBy = "chatRoom")
        private Set<UserChatRoomEntity> userChatRooms;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getKey() {
            return room_key;
        }

        public void setKey(String key) {
            this.room_key = key;
        }

        public Set<ChatMessageEntity> getChatMessages() {
            return chatMessages;
        }

        public void setChatMessages(Set<ChatMessageEntity> chatMessages) {
            this.chatMessages = chatMessages;
        }

        public Set<UserChatRoomEntity> getUserChatRooms() {
            return userChatRooms;
        }

        public void setUserChatRooms(Set<UserChatRoomEntity> userChatRooms) {
            this.userChatRooms = userChatRooms;
        }
}
