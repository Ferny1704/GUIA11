<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><s:message code="libro.lista"/></title>
        <jsp:include page="/WEB-INF/views/cabecera.jsp"/>
    </head>
    <body>
    <jsp:include page="/WEB-INF/views/menu.jsp"/>
    <div class="container">
        <div class="row">
            <h3><s:message code="libro.lista"/></h3>
        </div>
        <div class="row">
            <div class="col-md-12">
                <a class="btn btn-primary btn-md" href="<s:url value="/libros/create"/>">
                    <s:message code="libro.nuevo"/>
                </a>
                <br><br>
                <table class="table table-striped table-bordered table-hover" id="tabla">
                    <thead>
                    <tr>
                        <th><s:message code="libro.codigo"/></th>
                        <th><s:message code="libro.nombre"/></th>
                        <th><s:message code="libro.existencias"/></th>
                        <th><s:message code="libro.precio"/> ($)</th>
                        <th><s:message code="libro.editorial"/></th>
                        <th><s:message code="libro.autor"/></th>
                        <th><s:message code="libro.genero"/></th>
                        <th><s:message code="operaciones"/></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.listaLibros}" var="libro">
                    <tr>
                        <td>${libro.codigoLibro}</td>
                        <td>${libro.nombreLibro}</td>
                        <td>${libro.existencias}</td>
                        <td>${libro.precio}</td>
                        <td>${libro.editorialesByCodigoEditorial.nombreEditorial}</td>
                        <td>${libro.autoresByCodigoAutor.nombreAutor}</td>
                        <td>${libro.generosByIdGenero.nombreGenero}</td>
                        <td>
                            <a class="btn btn-primary" href="<s:url value="/libros/edit/${libro.codigoLibro}"/> ">
                                <span class="glyphicon glyphiconedit"></span><s:message code="editar"/></a>
                            <a class="btn btn-danger"
                               href="javascript:eliminar('${libro.codigoLibro}')">
                                <span class="glyphicon glyphicontrash"></span><s:message code="eliminar"/></a>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function(){
            $('#tabla').dataTable( {
                "language": {

                    "url": "cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
                }
            });
        });
        function eliminar(id){
            alertify.confirm("<s:message code="libro.confirmacionEliminar"/>", function
                (e){
                if(e){
                    location.href="delete/"+id;
                }
            });
        }
    </script>
    </body>
</html>