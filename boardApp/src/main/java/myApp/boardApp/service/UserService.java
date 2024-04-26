package myApp.boardApp.service;

import myApp.boardApp.dto.UserDTO;
import myApp.boardApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserDTO insertUser(UserDTO user){
        return userRepository.insertUser(user);
    }

    public List<UserDTO> getAllUsers(){
        return userRepository.getAllUsers();
    }
    public UserDTO getUserByUserId(String userId){
        return userRepository.getUserByUserId(userId);
    }

    public void updateUserPwd(String userId,UserDTO user){
        userRepository.updateUserPwd(userId, user);
    }

    public void deleteUser(String userId){
        userRepository.deleteUser(userId);
    }
}
