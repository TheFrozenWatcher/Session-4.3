package module4.ex.service;

import module4.ex.model.dto.request.UserRequest;
import module4.ex.model.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findByFullName(String userName);
    User insert(UserRequest request);
    User update(UserRequest request,Integer userId);
    void delete(Integer userId);
    List<User> findByName(String name);
}
