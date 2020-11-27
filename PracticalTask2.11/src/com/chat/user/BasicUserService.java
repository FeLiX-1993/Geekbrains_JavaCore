package com.chat.user;

import com.chat.database.DBService;
import com.chat.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BasicUserService implements UserService {

    @Override
    public boolean changeNickname(User user, String newNickname) {

        try (Connection conn = DBService.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(
                    "UPDATE users SET nickname=? WHERE nickname=?"
            );
            statement.setString(1, newNickname);
            statement.setString(2, user.getNickname());

            statement.executeUpdate();
            return true;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return false;
    }

}
