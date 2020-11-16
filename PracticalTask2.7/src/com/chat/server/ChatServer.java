package com.chat.server;

import com.chat.auth.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer implements Server {
    private Set<ClientHandler> clients;
    private AuthenticationService authenticationService;

    public ChatServer() {
        try {
            System.out.println("Server is starting up...");
            ServerSocket serverSocket = new ServerSocket(8887);
            clients = new HashSet<>();
            authenticationService = new BasicAuthenticationService();
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
    public synchronized void broadcastMessage(String message) {
        for (ClientHandler client: clients) {
            client.sendMessage(message);
        }
    }

    @Override
    public synchronized void Message(String message, ClientHandler sender) {

        if (message.contains("/w")) {
            String[] splitMessage = message.split("\\s");
            ClientHandler recipient = getClientHandlerByName(splitMessage[1]);
            if (recipient != null)
                recipient.sendMessage(String.format("%s to %s: %s"
                        , sender.getName()
                        , recipient.getName()
                        , splitMessage[2]));
            return;
        }

        for (ClientHandler client : clients) {
            if (!client.getName().equals(sender.getName()))
                client.sendMessage(String.format("%s to all: %s", sender.getName(), message));
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

    private ClientHandler getClientHandlerByName(String name) {
        for (ClientHandler client: clients) {
            if (client.getName().equals(name))
                return client;
        }
        return null;
    }
}
