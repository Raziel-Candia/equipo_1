package integradora_poo_2026.controller;

import integradora_poo_2026.model.dao.AlumnoDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.integradora_poo_2026.model.Alumno;
import mx.edu.utez.integradora_poo_2026.model.dao.MascotaDao;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AlumnoServlet", value = "/alumno")
public class AlumnoServlet extends HttpServlet {

    private final AlumnoDao alumnoDao = new AlumnoDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
<<<<<<< HEAD:src/main/java/integradora_poo_2026/controller/MascotaServlet.java
        List<Mascota> lista = mascotaDao.getAll();
        request.setAttribute("listaMascotas", lista);
=======
        List<Alumno> lista = alumnoDao.getAll();
        request.setAttribute("listaAlumnos", lista);
>>>>>>> 91eefe9077bb1b43aa910bae3c13f44ef4752ee7:src/main/java/integradora_poo_2026/controller/AlumnoServlet.java
        request.getRequestDispatcher("gestion-alumno.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            String nombre = request.getParameter("nombre");
            String especie = request.getParameter("especie");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String personalidad = request.getParameter("personalidad");
            String foto = request.getParameter("foto");
            boolean vacunada = request.getParameter("vacunada") != null;

            Mascota nuevaMascota = new Mascota();
            nuevaMascota.setNombre(nombre);
            nuevaMascota.setEspecie(especie);
            nuevaMascota.setEdad(edad);
            nuevaMascota.setPersonalidad(personalidad);
            nuevaMascota.setFoto(foto);
            nuevaMascota.setVacunada(vacunada);

            mascotaDao.create(nuevaMascota);
        } catch (NumberFormatException e) {
            System.err.println("Error al transformar datos numéricos en el registro: " + e.getMessage());
            e.printStackTrace();
        }

        response.sendRedirect("mascota");
    }
}