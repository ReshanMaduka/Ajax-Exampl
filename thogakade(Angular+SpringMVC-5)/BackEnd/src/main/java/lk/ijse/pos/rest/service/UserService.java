package lk.ijse.pos.rest.service;


public interface UserService {

    boolean canAuthenticate(String username, String password);

}
