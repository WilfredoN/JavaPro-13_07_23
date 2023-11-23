package jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUserByUid(String uid) {
        return userRepository.findByUid(uid);
    }

    public User mapUser(User user) {
        return User.builder()
                .id(user.getId())
                .uid(user.getUid())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    public User createUser(User user) {
        var savedUser = userRepository.save(User.builder()
                .id(user.getId())
                .uid(UUID.randomUUID().toString())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole().equals(UserRole.ADMIN) ? UserRole.ADMIN : UserRole.CUSTOMER)
                .build());
        return mapUser(savedUser);
    }
}
