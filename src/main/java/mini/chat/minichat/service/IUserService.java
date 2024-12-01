package mini.chat.minichat.service;

import mini.chat.minichat.builder.UserCreateBuilder;
import mini.chat.minichat.dto.UserCreateDTO;
import mini.chat.minichat.repository.entity.UserEntity;

public interface IUserService {
    void createUser(UserCreateDTO userCreateDTO);
    UserEntity findUserEntityByUserName(String username);
    UserEntity findUserEntityByPhone(String username);

}
