package com.riwi.models;

import com.riwi.entities.Plane;
import com.riwi.persistence.configDb.MySqlConfig;
import com.riwi.persistence.imodel.IPlaneModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PlaneModelImpl implements IPlaneModel {

    @Override
    public Plane create(Plane request) {
        Connection connection = MySqlConfig.openConnection();

        String sqlQuery = "INSERT INTO Plane(model, capacity) values(?,?);";

        Plane plane = new Plane();

        int rowsAffected = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, request.getModel());
            preparedStatement.setInt(2, request.getCapacity());

            rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            MySqlConfig.closeConnection();
        }

        return rowsAffected == 1 ? request : plane;
    }

    @Override
    public void delete(Integer id) {
        Connection connection = MySqlConfig.openConnection();

        String sqlQuery = "DELETE FROM Plane WHERE id=?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            MySqlConfig.closeConnection();
        }
    }
}
