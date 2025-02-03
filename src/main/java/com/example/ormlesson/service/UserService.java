package com.example.ormlesson.service;

import com.example.ormlesson.entity.User;
import com.example.ormlesson.exceptions.BaseException;
import com.example.ormlesson.model.StatusCode;
import com.example.ormlesson.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }


    public Page<User> findAll(int page, int size){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);

        //Page<User> userResponses =
        return userRepository.findAll(pageable);
    }

    public User findById(int id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new BaseException(HttpStatus.NOT_FOUND,
                        StatusCode.USER_NOT_FOUND));
    }


    public int calculate (int a, int b){
        return a / b;
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }
}