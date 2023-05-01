package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private static QueryRunner runner = new QueryRunner();

    private DBHelper() {
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/data", "app", "pass");
        //return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }

    public static DataHelper.CardStatus getCardStatus(String payType) {
       String codeSQL;
        if (payType.equals("payment")) {
            codeSQL = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
        } else if (payType.equals("credit_request")) {
            codeSQL = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1";
        } else {
            return null;
        }

        try (Connection conn = getConnection()) {
            var status = runner.query(conn, codeSQL, new ScalarHandler<String>());
            return new DataHelper.CardStatus(status);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @SneakyThrows
    public static void cleanDB() {
        Connection conn = getConnection();
        runner.execute(conn, "DELETE FROM credit_request_entity");
        runner.execute(conn, "DELETE FROM payment_entity");
        runner.execute(conn, "DELETE FROM order_entity");
    }
}
