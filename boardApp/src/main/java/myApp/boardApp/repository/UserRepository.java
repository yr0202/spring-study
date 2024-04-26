package myApp.boardApp.repository;

import myApp.boardApp.dto.UserDTO;
import myApp.boardApp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    static public ArrayList<UserDTO> users;

    static{
        users = new ArrayList<>();
        users.add(new UserDTO("test1", "kim","1234"));
        users.add(new UserDTO("test2", "lee","0987"));
        users.add(new UserDTO("test3", "park","5678"));
    }
    public UserDTO insertUser(UserDTO user){
        users.add(user);
        return user;
    }
    public List<UserDTO> getAllUsers(){
        return users;
    }

    public UserDTO getUserByUserId(String userId){
        return users.stream()
                .filter(userDTO -> userDTO.getUserId().equals(userId))
                .findAny()
                .orElse(new UserDTO("","",""));
    }

    public void updateUserPwd(String userId, UserDTO user){
        users.stream()
                .filter(userDTO -> userDTO.getUserId().equals(userId))
                .findAny()
                .orElse(new UserDTO("","",""))
                .setUserPwd(user.getUserPwd());
    }

    public void deleteUser(String userId){
        users.removeIf(userDTO -> userDTO.getUserId().equals(userId));
    }

}
