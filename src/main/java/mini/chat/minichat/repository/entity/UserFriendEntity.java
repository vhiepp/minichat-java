package mini.chat.minichat.repository.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "user_frends")
public class UserFriendEntity {

    @EmbeddedId
    private UserFriendId id;

    @ManyToOne
    @MapsId("userOneId")
    @JoinColumn(name = "user_one_id")
    private UserEntity userOne;

    @ManyToOne
    @MapsId("userTwoId")
    @JoinColumn(name = "user_two_id")
    private UserEntity userTwo;

    @Column(nullable = false, columnDefinition = "TINYINT DEFAULT 1")
    private int status;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public UserFriendId getId() {
        return id;
    }

    public void setId(UserFriendId id) {
        this.id = id;
    }

    public UserEntity getUserOne() {
        return userOne;
    }

    public void setUserOne(UserEntity userOne) {
        this.userOne = userOne;
    }

    public UserEntity getUserTwo() {
        return userTwo;
    }

    public void setUserTwo(UserEntity userTwo) {
        this.userTwo = userTwo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
