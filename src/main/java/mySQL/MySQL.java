package mySQL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.sql.*;

public class MySQL {
    WebDriver webDriver;

    public MySQL(WebDriver webdriver) {
        PageFactory.initElements(webdriver, this);
        this.webDriver = webdriver;
    }

    public static String getLoginAndPasswordOfMySQL(int columnIndex) {
        String url = "jdbc:mysql://localhost:3306/user?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "1111";
        String query = "select * from user.project;";
        String getLogin = null;

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                getLogin = resultSet.getString(columnIndex);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return getLogin;
    }
}