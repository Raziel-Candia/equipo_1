package integradora_poo_2026.controller;

import integradora_poo_2026.model.dao.AlumnoDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import integradora_poo_2026.model.Alumno;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AlumnoServlet", value = "/alumno")
public class AlumnoServlet extends HttpServlet {

    private final AlumnoDao alumnoDao = new AlumnoDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Alumno> lista = alumnoDao.getAll();
        request.setAttribute("listaAlumnos", lista);
        List<Alumno> lista = alumnoDao.getAll();
        request.setAttribute("listaAlumnos", lista);
        request.getRequestDispatcher("gestion-alumno.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String matricula = request.getParameter("matricula");
            String correo = request.getParameter("correo");
            String sexo = request.getParameter("sexo");

            Alumno nuevaAlumno = new Alumno();
            nuevaAlumno.setNombre(nombre);
            nuevaAlumno.setApellidos(apellidos);
            nuevaAlumno.setEdad(edad);
            nuevaAlumno.setMatricula(matricula);
            nuevaAlumno.setCorreo(correo);
            nuevaAlumno.setSexo(sexo);

            alumnoDao.create(nuevaAlumno);
        } catch (NumberFormatException e) {
            System.err.println("Error al transformar datos numéricos en el registro: " + e.getMessage());
            e.printStackTrace();
        }

        response.sendRedirect("alumno");
    }
}