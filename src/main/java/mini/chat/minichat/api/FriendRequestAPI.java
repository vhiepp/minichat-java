package mini.chat.minichat.api;


import jakarta.transaction.Transactional;
import mini.chat.minichat.dto.UserFriendDTO;
import mini.chat.minichat.service.IUserFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
public class FriendRequestAPI {

    @Autowired
    private IUserFriendService userFriendService;

    @PostMapping("api/add-friend")
    public ResponseEntity<Void> addFriend(@RequestBody UserFriendDTO userFriendDTO) {
        userFriendService.addFriend(userFriendDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("api/accept-friend")
    public ResponseEntity<Void> acceptFriendRequest(@RequestParam Long userOneId, @RequestParam Long userTwoId) {
        userFriendService.acceptFriendRequest(userOneId, userTwoId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("api/friends")
    public ResponseEntity<List<UserFriendDTO>> getFriends(@RequestParam Long userId) {
        List<UserFriendDTO> friends = userFriendService.getFriends(userId);
        return ResponseEntity.ok(friends);
    }
}