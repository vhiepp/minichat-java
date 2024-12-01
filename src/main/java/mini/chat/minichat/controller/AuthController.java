package mini.chat.minichat.controller;
import mini.chat.minichat.model.AuthResponse;
import mini.chat.minichat.model.LoginRequest;
import mini.chat.minichat.repository.entity.UserEntity;
import mini.chat.minichat.service.IUserService;
import mini.chat.minichat.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        UserEntity user = userService.findUserEntityByUserName(loginRequest.getUsername());
        if (user.getUserName().equals(loginRequest.getUsername()) && user.getPassword().equals(loginRequest.getPassword())) {
            String token = JwtUtil.generateToken(loginRequest.getUsername());
            return ResponseEntity.ok(new AuthResponse(token, loginRequest.getUsername()));
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
