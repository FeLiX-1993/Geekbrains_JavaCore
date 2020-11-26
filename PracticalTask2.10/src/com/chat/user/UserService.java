package com.chat.user;

import com.chat.entity.User;

public interface UserService {

    boolean changeNickname(User user, String newNickname);

}
