package mini.chat.minichat.api;

import jakarta.transaction.Transactional;
import mini.chat.minichat.builder.UserCreateBuilder;
import mini.chat.minichat.dto.UserCreateDTO;
import mini.chat.minichat.repository.entity.UserEntity;
import mini.chat.minichat.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
public class UserAPI {
    // crate user
    @Autowired
    private IUserService userService;
    @PostMapping("api/user")
    public ResponseEntity<Void> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        userService.createUser(userCreateDTO);
        return ResponseEntity.ok().build();
    }
}
