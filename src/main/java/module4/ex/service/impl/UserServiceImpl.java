package module4.ex.service.impl;

import lombok.RequiredArgsConstructor;
import module4.ex.common.UserConverter;
import module4.ex.model.dto.request.UserRequest;
import module4.ex.model.entity.User;
import module4.ex.repository.UserRepository;
import module4.ex.service.UserService;
import module4.ex.validation.UniqueUsername;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByFullName(String userName) {
        return userRepository.findUserByUsername(userName);
    }

    @Override
    public User insert(UserRequest request) throws DataException {
        User user = userRepository.findUserByUsername(request.getUsername());


        User u = userConverter.toUser(request);
        return userRepository.save(u);
    }

    @Override
    public User update(UserRequest request, Integer userId) {
        userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("User does not exist!"));
        User u = userConverter.toUser(request);
        u.setId(userId);
        return userRepository.save(u);
    }

    @Override
    public void delete(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findAccountsByFullNameContains(name);
    }
}
