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
        String sql = "INSERT INTO ALUMNOS(nombre, apellidos, edad, matricula, correo, sexo) VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection con = SQLConnector.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getApellidos());
            ps.setInt(3, entidad.getEdad());
            ps.setString(4, entidad.getMatricula());
            ps.setString(5, entidad.getCorreo());
            ps.setString(6, entidad.getSexo());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Alumno> getAll() {
        List<Alumno> datos = new ArrayList<>();
        try (Connection con = SQLConnector.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM ALUMNOS");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Alumno a = new Alumno();
                a.setNombre(rs.getString("nombre"));
                a.setApellidos(rs.getString("apellidos"));
                a.setEdad(rs.getInt("edad"));
                a.setMatricula(rs.getString("matricula"));
                a.setCorreo(rs.getString("correo"));
                a.setSexo(rs.getString("sexo"));
                datos.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datos;
    }

    @Override
    public Alumno getById(String matricula) {
        String sql = "SELECT * FROM ALUMNOS WHERE matricula = ?";
        try (Connection con = SQLConnector.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, matricula);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Alumno a = new Alumno();
                    a.setNombre(rs.getString("nombre"));
                    a.setApellidos(rs.getString("apellidos"));
                    a.setEdad(rs.getInt("edad"));
                    a.setMatricula(rs.getString("matricula"));
                    a.setCorreo(rs.getString("correo"));
                    a.setSexo(rs.getString("sexo"));
                    return a;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Alumno entidad) {
        String sql = "UPDATE ALUMNOS SET nombre = ?, apellidos = ?, edad = ?, correo = ?, sexo = ? WHERE matricula = ?";
        try (Connection con = SQLConnector.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getApellidos());
            ps.setInt(3, entidad.getEdad());
            ps.setString(4, entidad.getCorreo());
            ps.setString(5, entidad.getSexo());
            ps.setString(6, entidad.getMatricula());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String matricula) {
        String sql = "DELETE FROM ALUMNOS WHERE matricula = ?";
        try (Connection con = SQLConnector.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, matricula);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}