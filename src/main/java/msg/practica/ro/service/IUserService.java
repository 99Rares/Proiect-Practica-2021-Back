package msg.practica.ro.service;

import msg.practica.ro.dto.UserDTO;
import msg.practica.ro.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.IOException;

public interface IUserService {
    public UserDTO registerNewUserAccount(User user, String siteURL) throws IOException;
}
