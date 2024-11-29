package mini.chat.minichat.repository;
import mini.chat.minichat.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IUserRepositoty extends JpaRepository<UserEntity, Long> {
    <S extends UserEntity> S save(S entity);
}
