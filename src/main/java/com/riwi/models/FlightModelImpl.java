package com.riwi.models;

import com.riwi.entities.Flight;
import com.riwi.persistence.configDb.MySqlConfig;
import com.riwi.persistence.imodel.IFlightModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightModelImpl implements IFlightModel {

    private List<Flight> flights = new ArrayList<>();

    @Override
    public Flight create(Flight request) {
        Connection connection = MySqlConfig.openConnection();
        Flight flight = new Flight();
        String sqlQuery = "INSERT INTO Flight(destination, departure_date, departure_hour, id_plane) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, request.getDestination());
            preparedStatement.setString(2, request.getDepartureDate());
            preparedStatement.setTime(3, request.getDepartureHour());
            preparedStatement.setInt(4, request.getIdPlane());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 1) {
                // Retrieve the generated key
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        request.setId(generatedKeys.getInt(1));
                    }
                }
                flight = request;
            }

        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        } finally {
            MySqlConfig.closeConnection();
        }

        return flight;
    }

    @Override
    public void delete(Integer flightId) {
        Connection connection = MySqlConfig.openConnection();

        String sqlQuery = "DELETE FROM Flight WHERE id = ?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, flightId);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new IllegalArgumentException("Flight with ID " + flightId + " not found");
            }

            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        } finally {
            MySqlConfig.closeConnection();
        }
    }

    @Override
    public Flight update(Flight request) {
        Connection connection = MySqlConfig.openConnection();

        String sqlQuery = "UPDATE Flight SET destination =?, departure_date =?, departure_hour =?, id_plane =? WHERE id =?;";

        int rowsAffected = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, request.getDestination());
            preparedStatement.setString(2, request.getDepartureDate());
            preparedStatement.setTime(3, request.getDepartureHour());
            preparedStatement.setInt(4, request.getIdPlane());
            preparedStatement.setInt(5, request.getId());

            rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new IllegalArgumentException("Flight with ID " + request.getId() + " not found");
            }

            preparedStatement.close();
        }  catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        } finally {
            MySqlConfig.closeConnection();
        }

        return rowsAffected == 1 ? request : null;
    }

    @Override
    public List<Flight> readByDestination(String destination) {
        Connection connection = MySqlConfig.openConnection();

        List<Flight> result = new ArrayList<>();

        String sqlQuery = "SELECT * FROM flight WHERE destination =?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, destination);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Flight flight = new Flight(
                        resultSet.getInt("id"),
                        resultSet.getString("destination"),
                        resultSet.getString("departure_date"),
                        resultSet.getTime("departure_hour"),
                        resultSet.getInt("id_plane")
                );

                result.add(flight);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        } finally {
            MySqlConfig.closeConnection();
        }

        return result;
    }
}
