package mini.chat.minichat.service;


import mini.chat.minichat.dto.UserFriendDTO;

import java.util.List;

public interface IUserFriendService {
    void addFriend(UserFriendDTO userFriendDTO);
    void acceptFriendRequest(Long userOneId, Long userTwoId);
    List<UserFriendDTO> getFriends(Long userId);
}