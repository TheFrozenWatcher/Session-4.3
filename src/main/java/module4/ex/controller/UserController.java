package module4.ex.controller;

import jakarta.validation.Valid;
import module4.ex.model.dto.request.UserRequest;
import module4.ex.model.dto.response.DataResponse;
import module4.ex.model.entity.User;
import module4.ex.service.UserService;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<DataResponse<List<User>>> getAll(){
        return new ResponseEntity<>(new DataResponse<>(userService.findAll(), HttpStatus.OK),HttpStatus.OK);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<DataResponse<User>> getUserByUsername(@PathVariable String userName){
        return new ResponseEntity<>(new DataResponse<>(userService.findByFullName(userName),HttpStatus.OK),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataResponse<User>> insertUser(@Valid @RequestBody UserRequest request) throws DataException {
        return new ResponseEntity<>(new DataResponse<>(userService.insert(request),HttpStatus.OK), HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<DataResponse<User>> updateUser(@Valid @RequestBody UserRequest request, @PathVariable Integer userId){
        return new ResponseEntity<>(new DataResponse<>(userService.update(request,userId),HttpStatus.OK), HttpStatus.OK);
    }
}
