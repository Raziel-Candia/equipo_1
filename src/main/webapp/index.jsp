<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="layout/header.jsp" %>
<div class="row g-4">

    <div class="col-12">
        <h1 class="mb-4">Bienvenidos a Registro Alumnos</h1>
    </div>

    <div class="col-md-7">
        <div class="row">
            <h4 class="text-secondary col-6">Aquí están todos los alumnos</h4>
            <a href="AlumnoServlet" class="btn btn-primary col-6 align-content-center text-center"><i class="bi bi-arrow-clockwise"></i> Cargar Alumnos</a>
        </div>

        <c:choose>
            <c:when test="${empty alumnos}">
                <div class="alert alert-info text-center mt-4" role="alert">
                    <i class="bi bi-info-circle-fill"></i> No hay Alumnos registrados en este momento o necesitas pulsar "Cargar Alumnos".
                </div>
            </c:when>

            <c:otherwise>
                <div class="table-responsive">
                    <table class="table table-striped table-hover mt-4 align-middle">
                        <thead class="table-dark">
                        <tr>
                            <th>Matrícula</th>
                            <th>Nombre o nombres</th>
                            <th>Apellidos</th>
                            <th>Edad</th>
                            <th>Correo electrónico</th>
                            <th>Sexo</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${alumnos}" var="alumno">
                            <tr>
                                <td><span class="badge bg-secondary">${alumno.matricula}</span></td>
                                <td>${alumno.nombre}</td>
                                <td>${alumno.apellidos}</td>
                                <td>${alumno.edad}</td>
                                <td>${alumno.correoElectronico}</td>
                                <td>${alumno.sexo}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:otherwise>
        </c:choose>
    </div>

    <div class="col-md-5">
        <div class="card shadow-sm">
            <div class="card-body">
                <h4 class="card-title text-primary mb-4"><i class="bi bi-plus-circle-fill"></i> ¡Registra un Alumno!</h4>

                <form action="AlumnoServlet" method="POST">

                    <div class="mb-3">
                        <label for="nombre" class="form-label">Nombre o nombres</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ej: Juan Carlos" required>
                    </div>

                    <div class="mb-3">
                        <label for="apellidos" class="form-label">Apellidos</label>
                        <input type="text" class="form-control" id="apellidos" name="apellidos" placeholder="Ej: Pérez Gómez" required>
                    </div>

                    <div class="mb-3">
                        <label for="edad" class="form-label">Edad</label>
                        <input type="number" class="form-control" id="edad" name="edad" placeholder="Ej: 20" required min="1" max="120">
                    </div>

                    <div class="mb-3">
                        <label for="matricula" class="form-label">Matrícula</label>
                        <input type="text" class="form-control" id="matricula" name="matricula" placeholder="Ej: AL202610" required>
                    </div>

                    <div class="mb-3">
                        <label for="correo" class="form-label">Correo electrónico</label>
                        <input type="email" class="form-control" id="correo" name="correoElectronico" placeholder="ejemplo@universidad.com" required>
                    </div>

                    <div class="mb-3">
                        <label for="sexo" class="form-label">Sexo</label>
                        <input type="text" class="form-control" id="sexo" name="sexo" placeholder="Ej. H" required>
                    </div>

                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary"><i class="bi bi-save"></i> Guardar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>
<%@ include file="layout/footer.jsp" %>