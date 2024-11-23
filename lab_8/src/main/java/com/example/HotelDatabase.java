package com.example;
import java.sql.*;


public class HotelDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/hotel";
    private static final String USER = "root";
    private static final String PASSWORD = "root_password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD))
        {
            connection.setAutoCommit(false);

            HotelHandler.createRoom(connection, 101, "Single", 100.00);
            HotelHandler.createRoom(connection, 102, "Double", 150.00);
            HotelHandler.createRoom(connection, 103, "Suite", 200.00);
            HotelHandler.createRoom(connection, 104, "Deluxe", 250.00);
            HotelHandler.createRoom(connection, 105, "Presidential", 300.00);
            connection.commit();

            HotelHandler.readRooms(connection);

            HotelHandler.updateRoom(connection, 1, 101, "Single Deluxe", 120.00);
            connection.commit();

            HotelHandler.deleteRoom(connection, 1);
            connection.commit();

            HotelHandler.createBooking(connection, 2, "John Doe", Date.valueOf("2023-10-01"), Date.valueOf("2023-10-05"));
            HotelHandler.createBooking(connection, 3, "Jane Smith", Date.valueOf("2023-10-02"), Date.valueOf("2023-10-06"));
            HotelHandler.createBooking(connection, 4, "Alice Johnson", Date.valueOf("2023-10-03"), Date.valueOf("2023-10-07"));
            HotelHandler.createBooking(connection, 5, "Bob Brown", Date.valueOf("2023-10-04"), Date.valueOf("2023-10-08"));
            HotelHandler.createBooking(connection, 6, "Charlie Davis", Date.valueOf("2023-10-05"), Date.valueOf("2023-10-09"));
            connection.commit();

            HotelHandler.readBookings(connection);

            HotelHandler.updateBooking(connection, 1, 2, "John Doe", Date.valueOf("2023-10-01"), Date.valueOf("2023-10-10"));
            connection.commit();

            HotelHandler.deleteBooking(connection, 1);
            connection.commit();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}