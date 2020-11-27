package com.chat.server;

import com.chat.auth.*;
import com.chat.history.BasicHistoryService;
import com.chat.history.HistoryService;
import com.chat.user.UserService;

public interface Server {
    void sendBroadcastMessage(String message);
    void sendMessage(String message, ClientHandler sender);
    void sendMessage(String message, ClientHandler sender, ClientHandler recipient);
    boolean isLoggedIn(String nickname);
    void subscribe(ClientHandler client);
    void unsubscribe(ClientHandler client);
    AuthenticationService getAuthenticationService();
    UserService getUserService();
    HistoryService getHistoryService();
}
