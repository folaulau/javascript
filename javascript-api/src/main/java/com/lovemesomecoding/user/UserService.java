package com.lovemesomecoding.user;

public interface UserService {

    User signup(User user);

    User getUserById(Long id);

    User update(User user);

}
