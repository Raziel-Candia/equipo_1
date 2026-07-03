package integradora_poo_2026.model.dao;

import integradora_poo_2026.model.Alumno;
import integradora_poo_2026.utils.SQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDao implements Dao<Alumno, String> {

    @Override
    public boolean create(Alumno entidad) {
        String sql = "INSERT INTO alumno (nombre, apellidos, edad, matricula, correoelectronico, sexo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = SQLConnector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getApellidos());
            ps.setInt(3, entidad.getEdad());
            ps.setString(4, entidad.getMatricula());
            ps.setString(5, entidad.getCorreoElectronico());
            ps.setString(6, entidad.getSexo());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Alumno> getAll() {
        List<Alumno> lista = new ArrayList<>();
        String sql = "SELECT nombre, apellidos, edad, matricula, correoelectronico, sexo FROM alumno";
        try (Connection conn = SQLConnector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Alumno alumno = new Alumno(
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getInt("edad"),
                        rs.getString("matricula"),
                        rs.getString("correoelectronico"),
                        rs.getString("sexo")
                );
                lista.add(alumno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public Alumno getById(String id) {
        String sql = "SELECT nombre, apellidos, edad, matricula, correoelectronico, sexo FROM alumno WHERE matricula = ?";
        try (Connection conn = SQLConnector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Alumno(
                            rs.getString("nombre"),
                            rs.getString("apellidos"),
                            rs.getInt("edad"),
                            rs.getString("matricula"),
                            rs.getString("correoelectronico"),
                            rs.getString("sexo")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Alumno entidad) {
        String sql = "UPDATE alumno SET nombre = ?, apellidos = ?, edad = ?, correoelectronico = ?, sexo = ? WHERE matricula = ?";
        try (Connection conn = SQLConnector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getApellidos());
            ps.setInt(3, entidad.getEdad());
            ps.setString(4, entidad.getCorreoElectronico());
            ps.setString(5, entidad.getSexo());
            ps.setString(6, entidad.getMatricula());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM alumno WHERE matricula = ?";
        try (Connection conn = SQLConnector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}