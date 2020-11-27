package com.chat.server;

import com.chat.auth.*;
import com.chat.history.BasicHistoryService;
import com.chat.history.HistoryService;
import com.chat.user.BasicUserService;
import com.chat.user.UserService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ChatServer implements Server {

    private Set<ClientHandler> clients;
    private AuthenticationService authenticationService;
    private UserService userService;
    private HistoryService historyService;

    public ChatServer() {
        try {
            System.out.println("Server is starting up...");
            ServerSocket serverSocket = new ServerSocket(8889);
            clients = new HashSet<>();
            authenticationService = new BasicAuthenticationService();
            userService = new BasicUserService();
            historyService = new BasicHistoryService();

            System.out.println("Server is started up...");

            while (true) {
                System.out.println("Server is listening for clients...");
                Socket socket = serverSocket.accept();
                System.out.println("Client accepted: " + socket);
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            throw new RuntimeException("SWW", e);
        }
    }

    @Override
    public synchronized void sendBroadcastMessage(String message) {
        for (ClientHandler client: clients) {
            client.sendServiceMessage(message);
        }
    }

    @Override
    public synchronized void sendMessage(String message, ClientHandler sender) {

        if (message.contains("/w")) {
            String[] splitMessage = message.split("\\s");
            ClientHandler recipient = getClientHandlerByName(splitMessage[1]);
            if (recipient != null)
                sendMessage(splitMessage[2], sender, recipient);
            return;
        }

        for (ClientHandler client : clients) {
                client.sendMessage(String.format("[%s] %s : %s",
                        new SimpleDateFormat("yyyy.MM.dd HH:mm").format(new Date()),
                        sender.getName(),
                        message)
                );
        }
    }

    @Override
    public synchronized void sendMessage(String message, ClientHandler sender, ClientHandler recipient) {

        ArrayList<ClientHandler> sr = new ArrayList<>();
        sr.add(sender);
        sr.add(recipient);

        for (ClientHandler c: sr) {
            c.sendMessage(String.format("[%s] %s: %s",
                    new SimpleDateFormat("yyyy.MM.dd HH:mm").format(new Date()),
                    c.getName(),
                    message));
        }

    }

    @Override
    public synchronized boolean isLoggedIn(String nickname) {
        return clients.stream()
                .filter(clientHandler -> clientHandler.getName().equals(nickname))
                .findFirst()
                .isPresent();
    }

    @Override
    public synchronized void subscribe(ClientHandler client) {
        clients.add(client);
    }

    @Override
    public synchronized void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    @Override
    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

    @Override
    public UserService getUserService() {
        return userService;
    }

    @Override
    public HistoryService getHistoryService() {
        return historyService;
    }

    private ClientHandler getClientHandlerByName(String name) {
        for (ClientHandler client: clients) {
            if (client.getName().equals(name))
                return client;
        }
        return null;
    }
}
