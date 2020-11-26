import com.chat.database.DBService;

import java.sql.Connection;

public class main {
    public static void main(String[] args) {

        Connection conn = DBService.getConnection();

    }
}
