package mini.chat.minichat.service.impl;

import mini.chat.minichat.dto.UserCreateDTO;
import mini.chat.minichat.repository.IUserRepositoty;
import mini.chat.minichat.repository.entity.UserEntity;
import mini.chat.minichat.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepositoty userRepositoty;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void createUser(UserCreateDTO userCreateDTO) {
        UserEntity userEntity = modelMapper.map(userCreateDTO, UserEntity.class);
        userRepositoty.save(userEntity);
    }

}
