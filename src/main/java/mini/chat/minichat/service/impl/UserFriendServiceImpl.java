package mini.chat.minichat.service.impl;

import mini.chat.minichat.dto.UserFriendDTO;
import mini.chat.minichat.repository.IUserFriendRepository;
import mini.chat.minichat.repository.IUserRepositoty;
import mini.chat.minichat.repository.entity.UserEntity;
import mini.chat.minichat.repository.entity.UserFriendEntity;
import mini.chat.minichat.repository.entity.UserFriendId;
import mini.chat.minichat.service.IUserFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserFriendServiceImpl implements IUserFriendService {

    @Autowired
    private IUserFriendRepository userFriendRepository;
    @Autowired
    private IUserRepositoty userRepository;

    @Override
    public void addFriend(UserFriendDTO userFriendDTO) {
        UserFriendId id = new UserFriendId(userFriendDTO.getUserOneId(), userFriendDTO.getUserTwoId());
        UserFriendEntity userFriend = new UserFriendEntity();
        userFriend.setId(id);
        UserEntity userOne = userRepository.findUserEntityByUserName(userFriendDTO.getUserOne());
        UserEntity userTwo = userRepository.findUserEntityByUserName(userFriendDTO.getUserTwo());
        userFriend.setUserOne(userOne);
        userFriend.setUserTwo(userTwo);
        userFriend.setStatus(1);
        userFriend.setCreatedAt(LocalDateTime.now());
        userFriendRepository.save(userFriend);
    }

    @Override
    public void acceptFriendRequest(Long userOneId, Long userTwoId) {
        UserFriendId id = new UserFriendId(userOneId, userTwoId);
        Optional<UserFriendEntity> userFriendOpt = userFriendRepository.findById(id);
        if (userFriendOpt.isPresent()) {
            UserFriendEntity userFriend = userFriendOpt.get();
            userFriend.setStatus(2); // Status 2 means they are friends
            userFriendRepository.save(userFriend);
        }
    }

    @Override
    public List<UserFriendDTO> getFriends(Long userId) {
        List<UserFriendEntity> friends = userFriendRepository.findByUserOneIdAndStatus(userId, 2);
        return friends.stream().map(userFriendEntity -> {
            UserFriendDTO userFriendDTO = new UserFriendDTO();
            userFriendDTO.setUserOne(userFriendEntity.getUserOne().getUserName());
            userFriendDTO.setUserTwo(userFriendEntity.getUserTwo().getUserName());
            return userFriendDTO;
        }).collect(Collectors.toList());
    }
}