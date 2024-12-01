package mini.chat.minichat.repository;

import mini.chat.minichat.repository.entity.UserFriendEntity;
import mini.chat.minichat.repository.entity.UserFriendId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserFriendRepository extends JpaRepository<UserFriendEntity, UserFriendId> {
    <S extends UserFriendEntity> S save(S entity);
    List<UserFriendEntity> findByUserOneIdAndStatus(Long userOneId, int status);
}