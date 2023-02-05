package com.example.anar.repository;

import com.example.anar.domain.River;
import com.example.anar.utils.observer.ConcreteObservable;
import com.example.anar.utils.utils.ChangeEvent;
import com.example.anar.utils.utils.ChangeEventType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RiverRepository extends ConcreteObservable<ChangeEvent> {

    private final String url;
    private final String username;
    private final String password;

    public RiverRepository(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void updateRiverAverageElevation(River river, Float averageElevation){
        Connection connection = null;

        try{

            connection = DriverManager.getConnection(url, username, password);

            String query = "UPDATE rivers " +
                    "SET average_elevation = ? " +
                    "WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setFloat(1, averageElevation);
            statement.setLong(2, river.getId());

            statement.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
            DBUtils.closeConnection(connection);
        }
        this.notifyObserver(new ChangeEvent(ChangeEventType.UPDATE, river));
    }

    public Iterable<River> findAll(){
        Connection connection = null;
        ResultSet resultSet = null;
        List<River> rivers = new ArrayList<>();

        try{

            connection = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM rivers";
            PreparedStatement statement = connection.prepareStatement(query);

            resultSet = statement.executeQuery();
            while(resultSet.next()){

                Long ID = resultSet.getLong("id");
                String nume = resultSet.getString("name");
                float averageElevation = resultSet.getFloat("average_elevation");

                rivers.add(new River(ID, nume, averageElevation));
            }

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
            DBUtils.closeResultSet(resultSet);
            DBUtils.closeConnection(connection);
        }

        return rivers;
    }

}
