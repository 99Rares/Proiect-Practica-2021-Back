package msg.practica.ro.mapper;

import msg.practica.ro.dto.UserDTO;
import msg.practica.ro.model.User;

public final class UserMapper {
    //convertDTOtoEntity si invers

    public static UserDTO convertEntitytoDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }

}