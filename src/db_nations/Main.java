package db_nations;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/dump_nations";
        String user = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url,user, password)) {
            System.out.println(connection.getCatalog());

            String query =
                    "select c.name as country_name , c.country_id , r.name as region_name , c2.name as continent_name "
                           + "from countries c "
                           + "join regions r on c.region_id = r.region_id "
                           + "join continents c2 on r.continent_id = c2.continent_id "
                           + "order by c.name;";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)){

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {

                        String countryName = resultSet.getString("country_name");
                        int idCountry = resultSet.getInt("country_id");
                        String regionName = resultSet.getString("region_name");
                        String continentName = resultSet.getString("continent_name");

                        System.out.println(continentName + " " + idCountry + " " + regionName + " " + countryName);

                     }
                } catch (SQLException e) {
                    System.out.println("Unable to execute query ");
                    e.printStackTrace();
                }

            } catch (SQLException e) {
                System.out.println("Unable to prepare statement");
                e.printStackTrace();
            }

        } catch (SQLException e) {
            System.out.print("Unable to open connection");
            e.printStackTrace();
        }

    }
}
