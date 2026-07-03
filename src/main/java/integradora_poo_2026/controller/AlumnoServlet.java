package integradora_poo_2026.controller;

import integradora_poo_2026.model.Alumno;
import integradora_poo_2026.model.dao.AlumnoDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/AlumnoServlet")
public class AlumnoServlet extends HttpServlet {
    private AlumnoDao alumnoDao = new AlumnoDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Buscamos los alumnos en la Base de Datos usando tu DAO
        List<Alumno> listaAlumnos = alumnoDao.getAll();

        // 2. Guardamos la lista en la petición bajo el nombre "alumnos"
        //    (para que coincida con el <c:forEach items="${alumnos}"> de tu index.jsp)
        request.setAttribute("alumnos", listaAlumnos);

        // 3. ¡AQUÍ LO PONES! Despachas el control y los datos a tu index.jsp
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recuperamos los datos que enviaste desde el formulario de tu index.jsp
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String matricula = request.getParameter("matricula");
        String correoElectronico = request.getParameter("correoElectronico"); // Recuerda cambiar el name="correo" a name="correoElectronico" en tu formulario
        String sexo = request.getParameter("sexo");

        // Creamos el objeto Alumno con los datos del formulario
        Alumno nuevoAlumno = new Alumno(nombre, apellidos, edad, matricula, correoElectronico, sexo);

        // Lo insertamos en la BD
        alumnoDao.create(nuevoAlumno);

        // Al terminar, volvemos a llamar al doGet para que refresque la tabla
        response.sendRedirect("AlumnoServlet");
    }
}