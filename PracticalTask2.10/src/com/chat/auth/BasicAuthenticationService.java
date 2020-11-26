package com.chat.auth;

import com.chat.database.DBService;
import com.chat.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class BasicAuthenticationService implements AuthenticationService {

    @Override
    public Optional<User> doAuth(String login, String password)  {

        try (Connection conn = DBService.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(
                    "SELECT * FROM users WHERE nickname=? AND password=?"
            );
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User(
                        resultSet.getString("nickname"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                );
                return Optional.of(user);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return Optional.empty();
    }
}
