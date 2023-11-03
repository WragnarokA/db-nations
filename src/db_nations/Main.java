package db_nations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/db_airport";
        String user = "root";
        String password = "";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            System.out.print("Departure airport: ");
            String userAirport = scanner.nextLine();
            System.out.print("Year: ");
            int userYear = Integer.parseInt(scanner.nextLine());







        }
    }

}