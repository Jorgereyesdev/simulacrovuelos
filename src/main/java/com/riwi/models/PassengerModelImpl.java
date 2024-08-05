package com.riwi.models;

import com.riwi.entities.Passenger;
import com.riwi.persistence.configDb.MySqlConfig;
import com.riwi.persistence.imodel.IPassengerModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassengerModelImpl implements IPassengerModel {

    @Override
    public Passenger create(Passenger request) {
        Connection connection = MySqlConfig.openConnection();

        String sqlQuery = "INSERT INTO Passenger(name, lastname, document) values(?, ?, ?)";

        int rowsAffected = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, request.getName());
            preparedStatement.setString(2, request.getLastname());
            preparedStatement.setString(3, request.getDocument());

            rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        } finally {
            MySqlConfig.closeConnection();
        }

        return rowsAffected == 1? request : null;
    }

    @Override
    public List<Passenger> findByName(String name) {
        Connection connection = MySqlConfig.openConnection();
        String sqlQuery = "SELECT * FROM passenger WHERE name LIKE ?;";
        List<Passenger> passengers = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, "%" + name + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Passenger passenger = new Passenger();
                passenger.setName(resultSet.getString("name"));
                passenger.setLastname(resultSet.getString("lastname"));
                passenger.setDocument(resultSet.getString("document"));
                passengers.add(passenger);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            MySqlConfig.closeConnection();
        }

        return passengers;
    }

    @Override
    public void delete(Integer integer) {
        Connection connection = MySqlConfig.openConnection();

        String sqlQuery = "DELETE FROM Passenger WHERE id=?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setInt(1, integer);

            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        } finally {
            MySqlConfig.closeConnection();
        }
    }

    @Override
    public Passenger update(Passenger request) {
        Connection connection = MySqlConfig.openConnection();

        String sqlQuery = "UPDATE Passenger SET name=?, lastname=?, document=? WHERE id=?;";

        int rowsAffected = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, request.getName());
            preparedStatement.setString(2, request.getLastname());
            preparedStatement.setString(3, request.getDocument());
            preparedStatement.setInt(4, request.getId());

            rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new IllegalArgumentException("Flight with ID " + request.getId() + " not found");
            }

            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        } finally {
            MySqlConfig.closeConnection();
        }

        return rowsAffected == 1 ? request : null;
    }
}
