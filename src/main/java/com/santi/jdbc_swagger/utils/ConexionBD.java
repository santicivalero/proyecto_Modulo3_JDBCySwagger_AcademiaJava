package com.santi.jdbc_swagger.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/turnosdb";
    private static final String USER = "root";
    private static final String PASS = "12345678";

    private static Connection conexion;

    private ConexionBD() {
    }

    public static Connection obtenerConexion() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            conexion = DriverManager.getConnection(URL, USER, PASS);
        }
        return conexion;
    }
}
