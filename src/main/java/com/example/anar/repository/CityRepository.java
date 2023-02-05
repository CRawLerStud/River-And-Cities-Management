package com.example.anar.repository;

import com.example.anar.domain.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityRepository {

    private final String url;
    private final String username;
    private final String password;

    public CityRepository(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Iterable<City> findAllSmallRiskCities(){
        Connection connection = null;
        ResultSet resultSet = null;
        List<City> cities = new ArrayList<>();

        try{

            connection = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM cities C " +
                    "INNER JOIN rivers R on R.id = C.river " +
                    "WHERE minimum_elevation_risk > R.average_elevation";

            PreparedStatement statement = connection.prepareStatement(query);

            resultSet = statement.executeQuery();
            cities = getCitiesFromResultSet(resultSet);

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
            DBUtils.closeResultSet(resultSet);
            DBUtils.closeConnection(connection);
        }

        return cities;
    }

    public Iterable<City> findAllMediumRiskCities(){
        Connection connection = null;
        ResultSet resultSet = null;
        List<City> cities = new ArrayList<>();

        try{

            connection = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM cities C " +
                    "INNER JOIN rivers R on R.id = C.river " +
                    "WHERE minimum_elevation_risk <= R.average_elevation AND maximum_elevation_allowed > R.average_elevation";

            PreparedStatement statement = connection.prepareStatement(query);

            resultSet = statement.executeQuery();
            cities = getCitiesFromResultSet(resultSet);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
            DBUtils.closeResultSet(resultSet);
            DBUtils.closeConnection(connection);
        }

        return cities;
    }

    public Iterable<City> findAllHighRiskCities(){
        Connection connection = null;
        ResultSet resultSet = null;
        List<City> cities = new ArrayList<>();

        try{

            connection = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM cities C " +
                    "INNER JOIN rivers R on R.id = C.river " +
                    "WHERE C.maximum_elevation_allowed <= R.average_elevation";

            PreparedStatement statement = connection.prepareStatement(query);

            resultSet = statement.executeQuery();
            cities = getCitiesFromResultSet(resultSet);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
            DBUtils.closeResultSet(resultSet);
            DBUtils.closeConnection(connection);
        }

        return cities;
    }

    private List<City> getCitiesFromResultSet(ResultSet resultSet){
        List<City> cities = new ArrayList<>();

        try {
            while (resultSet.next()) {
                Long ID = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Long river_id = resultSet.getLong("river");
                float minimum_elevation_risk = resultSet.getFloat("minimum_elevation_risk");
                float maximum_elevation_allowed = resultSet.getFloat("maximum_elevation_allowed");

                cities.add(new City(ID, name, river_id, minimum_elevation_risk, maximum_elevation_allowed));
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return cities;
    }

}
