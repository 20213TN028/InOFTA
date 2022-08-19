<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://kit.fontawesome.com/393eac67f8.js" crossorigin="anonymous"></script>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand btn btn-outline-success" href="#">ADMIN</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="get-people">
                        <i class="fas fa-users"></i> Docentes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="get-courses">
                        <i class="fa-solid fa-book-copy"></i> Talleres</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="get-places">
                        <i class="fa-solid fa-location-dot"></i> Espacios</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="get-quarters">
                        <i class="fa-solid fa-calendar-check"></i> Cuatrimestres</a>
                </li>
            </ul>
            <span class="navbar-text">
                <form novalidate action="logout" method="post">
                    <button type="submit" class="nav-link btn btn-outline-primary btn-sm">
                    <i class="fa-solid fa-right-from-bracket"></i> Cerrar Sesión</button>
                </form>
            </span>
        </div>
    </div>
</nav>
