package service.api;

import model.dto.UserDto;
import model.entity.User;
import model.enumeration.Role;

import java.util.List;

public interface UserService {
    User login(String username, String password);
    User register(String username, String password, Role role);
    List<UserDto> findUsers();
    boolean deleteUser(String username);
    void updateUser(Long id, String username, String password);
    User findByUsername(String username);
    void setCurrentUsername(String userName);
}
