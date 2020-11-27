import com.chat.database.DBService;
import com.chat.file.FileService;

import java.sql.Connection;

public class main {
    public static void main(String[] args) {

       String s = FileService.getLastLineFromFile("test.txt", 1);
       System.out.println(s);

    }
}
