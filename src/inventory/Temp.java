package inventory;

import inventory.dao.JdbcParty;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Temp {

    public static void main(String[] args) throws SQLException {
        System.out.println("Hellop Word");
        List<String> list = Arrays.asList(JdbcParty.getParty("Mav"));
        System.out.println(list);
    }
}
