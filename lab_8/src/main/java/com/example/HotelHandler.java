package com.example;

import java.sql.*;

public class HotelHandler {

    public static void createRoom(Connection connection, int roomNumber, String type, double price) throws SQLException {
        String query = "INSERT INTO rooms (room_number, type, price) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, roomNumber);
            statement.setString(2, type);
            statement.setDouble(3, price);
            statement.executeUpdate();
        }
    }

    public static void readRooms(Connection connection) throws SQLException {
        String query = "SELECT * FROM rooms";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Room Number: " + resultSet.getInt("room_number"));
                System.out.println("Type: " + resultSet.getString("type"));
                System.out.println("Price: " + resultSet.getDouble("price"));
                System.out.println();
            }
        }
    }

    public static void updateRoom(Connection connection, int id, int roomNumber, String type, double price) throws SQLException {
        String query = "UPDATE rooms SET room_number = ?, type = ?, price = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, roomNumber);
            statement.setString(2, type);
            statement.setDouble(3, price);
            statement.setInt(4, id);
            statement.executeUpdate();
        }
    }

    public static void deleteRoom(Connection connection, int id) throws SQLException {
        String query = "DELETE FROM rooms WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public static void createBooking(Connection connection, int roomId, String guestName, Date checkIn, Date checkOut) throws SQLException {
        String query = "INSERT INTO bookings (room_id, guest_name, check_in, check_out) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, roomId);
            statement.setString(2, guestName);
            statement.setDate(3, checkIn);
            statement.setDate(4, checkOut);
            statement.executeUpdate();
        }
    }

    public static void readBookings(Connection connection) throws SQLException {
        String query = "SELECT * FROM bookings";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Room ID: " + resultSet.getInt("room_id"));
                System.out.println("Guest Name: " + resultSet.getString("guest_name"));
                System.out.println("Check-In: " + resultSet.getDate("check_in"));
                System.out.println("Check-Out: " + resultSet.getDate("check_out"));
                System.out.println();
            }
        }
    }

    public static void updateBooking(Connection connection, int id, int roomId, String guestName, Date checkIn, Date checkOut) throws SQLException {
        String query = "UPDATE bookings SET room_id = ?, guest_name = ?, check_in = ?, check_out = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, roomId);
            statement.setString(2, guestName);
            statement.setDate(3, checkIn);
            statement.setDate(4, checkOut);
            statement.setInt(5, id);
            statement.executeUpdate();
        }
    }

    public static void deleteBooking(Connection connection, int id) throws SQLException {
        String query = "DELETE FROM bookings WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
