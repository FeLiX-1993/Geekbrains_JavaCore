package com.chat.history;

import com.chat.entity.User;
import com.chat.file.FileService;

public class BasicHistoryService implements HistoryService {

    @Override
    public void saveMessageHistory(String message, User user)  {
        FileService.appendToFile(getFileNameByUser(user), message);
    }

    @Override
    public String getMessageHistory(User user, int countOfMessage)  {
        return FileService.getLastLineFromFile(getFileNameByUser(user), countOfMessage);
    }

    private String getFileNameByUser(User user) {
        return String.format("history_%s.txt", user.getNickname());
    }
}
