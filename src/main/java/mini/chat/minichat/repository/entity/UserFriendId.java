package mini.chat.minichat.repository.entity;


import java.io.Serializable;
import java.util.Objects;

public class UserFriendId implements Serializable {
    private Long userOneId;
    private Long userTwoId;

    // Public no-argument constructor
    public UserFriendId() {}

    public UserFriendId(Long userOneId, Long userTwoId) {
        this.userOneId = userOneId;
        this.userTwoId = userTwoId;
    }

    public Long getUserOneId() {
        return userOneId;
    }

    public void setUserOneId(Long userOneId) {
        this.userOneId = userOneId;
    }

    public Long getUserTwoId() {
        return userTwoId;
    }

    public void setUserTwoId(Long userTwoId) {
        this.userTwoId = userTwoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserFriendId that = (UserFriendId) o;
        return Objects.equals(userOneId, that.userOneId) && Objects.equals(userTwoId, that.userTwoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userOneId, userTwoId);
    }
}