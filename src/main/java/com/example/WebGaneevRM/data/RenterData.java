package com.example.WebGaneevRM.data;

import com.example.WebGaneevRM.DataBaseConnection;
import com.example.WebGaneevRM.dto.RenterDTO;

import java.sql.*;
import java.util.LinkedList;

public class RenterData {

    public static LinkedList<RenterDTO> selectRenter() {
        LinkedList<RenterDTO> listRenter = new LinkedList<RenterDTO>();
        try (Connection connection = DataBaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM renter ORDER BY id_renter ASC ");
            while (resultSet.next()) {
                RenterDTO renterDTO = new RenterDTO();
                renterDTO.setId_renter(Integer.parseInt(resultSet.getString(1)));
                renterDTO.setName_renter(resultSet.getString(2));
                renterDTO.setPhone(resultSet.getString(3));
                renterDTO.setEmail(resultSet.getString(4));
                listRenter.add(renterDTO);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return listRenter;
    }

    public static void addRenter(String nameRenter, String phoneRenter, String emailRenter){
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO renter VALUES (nextval('seq_id_renter'), ?, ?, ?);");
            preparedStatement.setString(1, nameRenter);
            preparedStatement.setString(2, phoneRenter);
            preparedStatement.setString(3, emailRenter);
            preparedStatement.executeUpdate();
            selectRenter();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void deleteRenter(int idRenter){
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM renter WHERE id_renter = ?;");
            preparedStatement.setInt(1, idRenter);
            preparedStatement.executeUpdate();
            selectRenter();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void editRenter(LinkedList<String> editedFields, int idRenter){
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE renter SET name_renter = ?;");
            selectRenter();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
