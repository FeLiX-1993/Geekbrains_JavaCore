package com.chat.history;

import com.chat.entity.User;

public interface HistoryService {
    void saveMessageHistory(String message, User user);
    String getMessageHistory(User user, int countOfMessage);
}
