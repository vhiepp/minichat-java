package mini.chat.minichat.repository.entity;

import jakarta.persistence.*;

import java.util.Set;
@Entity
@Table(name = "users")
public class UserEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = true)
        private String fullname;

        @Column(nullable = true, unique = true)
        private String userName;

        @Column(nullable = true)
        private String avartar;

        @Column(nullable = true, unique = true)
        private String phone;

        @Column(nullable = true)
        private String password;

        @Column(nullable = true, columnDefinition = "TINYINT DEFAULT 3")
        private int gender;

        public UserEntity() {
        }
        public UserEntity(Long id,String userName) {
            this.userName = userName;
        }

        @OneToMany(mappedBy = "user")
        private Set<ChatMessageEntity> chatMessages;

        @OneToMany(mappedBy = "user")
        private Set<UserChatRoomEntity> userChatRooms;

        @OneToMany(mappedBy = "userOne")
        private Set<UserFriendEntity> userFriendsOne;

        @OneToMany(mappedBy = "userTwo")
        private Set<UserFriendEntity> userFriendsTwo;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getAvartar() {
            return avartar;
        }

        public void setAvartar(String avartar) {
            this.avartar = avartar;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
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

        public Set<UserFriendEntity> getUserFriendsOne() {
            return userFriendsOne;
        }

        public void setUserFriendsOne(Set<UserFriendEntity> userFriendsOne) {
            this.userFriendsOne = userFriendsOne;
        }

        public Set<UserFriendEntity> getUserFriendsTwo() {
            return userFriendsTwo;
        }

        public void setUserFriendsTwo(Set<UserFriendEntity> userFriendsTwo) {
            this.userFriendsTwo = userFriendsTwo;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
}
