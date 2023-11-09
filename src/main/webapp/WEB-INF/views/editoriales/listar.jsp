<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title><s:message code="editorial.lista"/></title>
  <jsp:include page="/WEB-INF/views/cabecera.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/menu.jsp"/>
<div class="container">
  <div class="row">
    <h3><s:message code="editorial.lista"/></h3>
  </div>
  <div class="row">
    <div class="col-md-10">
      <a class="btn btn-primary btn-md" href="<s:url
value="/editoriales/create"/>"><s:message code="editorial.nuevo"/></a>
      <br><br>
      <table class="table table-striped table-bordered table-hover"
             id="tabla">
        <thead>
        <tr>
          <th><s:message code="editorial.codigo"/></th>
          <th><s:message code="editorial.nombre"/></th>
          <th><s:message code="editorial.contacto"/></th>
          <th><s:message code="editorial.telefono"/></th>
          <th><s:message code="operaciones"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listaEditoriales}" var="editorial">
          <tr>
            <td>${editorial.codigoEditorial}</td>
            <td>${editorial.nombreEditorial}</td>
            <td>${editorial.contacto}</td>
            <td>${editorial.telefono}</td>
            <td>
              <a class="btn btn-primary" href="<s:url
value="/editoriales/edit/${editorial.codigoEditorial}"/> ">
                <span class="glyphicon glyphiconedit"></span><s:message code="editar"/></a>
              <a class="btn btn-danger"
                 href="javascript:eliminar('${editorial.codigoEditorial}')">
                <span class="glyphicon glyphicontrash"></span><s:message code="eliminar"/></a>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>
<jsp:include page="/WEB-INF/views/pie.jsp"/>
<script>
  $(document).ready(function(){
    $('#tabla').dataTable( {
      "language": {

              "url": "cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
  }
  });
  });
  function eliminar(id){
    alertify.confirm("<s:message code="editorial.confirmacionEliminar"/>", function
            (e){
      if(e){
        location.href="delete/"+id;
      }
    });
  }
</script>
</body>
</html>
