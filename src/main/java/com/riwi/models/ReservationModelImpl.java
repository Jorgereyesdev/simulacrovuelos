package com.riwi.models;

import com.riwi.entities.Reservation;
import com.riwi.persistence.configDb.MySqlConfig;
import com.riwi.persistence.imodel.IReservationModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationModelImpl implements IReservationModel {

    @Override
    public List<Reservation> getAllReservationsByFlight(Integer idFlight) {
        Connection connection = MySqlConfig.openConnection();

        String sqlQuery = "SELECT * FROM reservation WHERE id_flight=?;";

        List<Reservation> reservations = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, idFlight);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setId(resultSet.getInt("id"));
                reservation.setDate(resultSet.getString("reservation_date"));
                reservation.setSeat(resultSet.getInt("seat"));
                reservation.setIdPassenger(resultSet.getInt("id_passenger"));
                reservation.setIdFlight(resultSet.getInt("id_flight"));

                reservations.add(reservation);
            }

            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        } finally {
            MySqlConfig.closeConnection();
        }

        return reservations;
    }

    @Override
    public Reservation create(Reservation request) {
        Connection connection = MySqlConfig.openConnection();

        String sqlQuery = "INSERT INTO reservation(reservation_date, seat, id_passenger, id_flight) values(?,?,?,?)";

        int rowsAffected = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, request.getDate());
            preparedStatement.setInt(2, request.getSeat());
            preparedStatement.setInt(3, request.getIdPassenger());
            preparedStatement.setInt(4, request.getIdFlight());

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
    public void delete(Integer integer) {
        Connection connection = MySqlConfig.openConnection();

        String sqlQuery = "DELETE FROM reservation WHERE id=?;";

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
    public Reservation update(Reservation request) {
        Connection connection = MySqlConfig.openConnection();

        String sqlQuery = "UPDATE reservation SET seat=? WHERE id=?;";

        int rowsAffected = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setInt(1, request.getSeat());
            preparedStatement.setInt(2, request.getId());

            rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        } finally {
            MySqlConfig.closeConnection();
        }

        return rowsAffected == 1? request : null;
    }
}
