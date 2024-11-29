package mini.chat.minichat.repository.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class UserFriendId {
        private Long userOneId;
        private Long userTwoId;

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
    }
