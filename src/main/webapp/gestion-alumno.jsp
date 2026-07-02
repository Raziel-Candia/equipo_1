<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="layout/header.jsp" %>
<div class="row g-4">
    <div class="col-12">
        <h1 class="mb-4">Bienvenidos a la gestion alumno</h1>
    </div>

    <div class="col-md-7">
        <div class="row">
        <h4 class="text-secondary col-6">Aquí están todas los registro de los alumnos</h4>
        <a href="mascota" class="btn btn-primary col-6 align-content-center text-center carga"><i class="bi bi-arrow-clockwise"></i> Cargar alumnos</a>
        </div>

        <c:choose>
            <%-- Condición 1: Si la lista es nula o está vacía --%>
            <c:when test="${empty listaMascotas}">
                <div class="alert alert-info text-center mt-4" role="alert">
                    <i class="bi bi-info-circle-fill"></i> No hay mascotas registradas en este momento.
                </div>
            </c:when>

            <%-- Condición por defecto: Si la lista SÍ tiene datos --%>
            <c:otherwise>
                <div class="table-responsive">
                    <table class="table table-striped table-hover mt-4 align-middle">
                        <thead class="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>Nombres</th>
                            <th>Apellidos</th>
                            <th>Edad</th>
                            <th>Matricula</th>
                            <th>Correo electrónico</th>
                            <th>Sexo</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listaMascotas}" var="mascota">
                            <tr>
                                <td><strong>${mascota.id}</strong></td>
                                <td>${mascota.nombre}</td>
                                <td><span class="badge bg-secondary">${mascota.especie}</span></td>
                                <td>${mascota.edad} años</td>
                                <td>${mascota.personalidad}</td>
                                <td>
                                    <img src="${mascota.foto}" alt="${mascota.nombre}" class="img-thumbnail" style="width: 60px; height: 60px; object-fit: cover;">
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${mascota.vacunada}">
                                            <span class="text-success"><i class="bi bi-check-circle-fill"></i> Sí</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="text-danger"><i class="bi bi-x-circle-fill"></i> No</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
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
                <h4 class="card-title text-primary mb-4"><i class="bi bi-plus-circle-fill"></i> ¡Registra a tu mascota!</h4>

                <form action="mascota" method="POST">
                    <input type="hidden" name="action" value="create">

                    <div class="mb-3">
                        <label for="nombre" class="form-label">Nombre del alumno</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ej: Shaggy" required>
                    </div>
                    <div class="mb-3">
                        <label for="apellidos" class="form-label">Apellidos del alumno</label>
                        <input type="text" class="form-control" id="apellidos" name="Apellidos" placeholder="Ej: Peréz" required>
                    </div>

                    <div class="mb-3">
                        <label for="edad" class="form-label">Edad (Años)</label>
                        <input type="number" class="form-control" id="edad" name="edad" placeholder="Ej: 18">
                    </div>

                    <div class="mb-3">
                        <label for="correo" class="form-label">Correo electrónico</label>
                        <input type="text" class="form-control" id="correo" name="correo" placeholder="Ej: ejemplo@escuela.edu.mx" required>
                    </div>

                    <div class="mb-3">
                        <label for="sexo" class="form-label">sexo</label>
                        <select class="form-select" id="sexo" name="sexo" required>
                            <option value="" selected disabled>Selecciona una opción...</option>
                            <option value="Hombre">Hombre</option>
                            <option value="Mujer">Mujer</option>
                            <option value="Otro">Otro</option>
                        </select>
                    </div>
                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary carga"><i class="bi bi-save"></i> Guardar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%@ include file="layout/footer.jsp" %>