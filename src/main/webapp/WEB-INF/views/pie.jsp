<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <script>   
                                    
            <c:if test="${not empty exito}">
                alertify.success('${exito}');
            </c:if>  
                 <c:if test="${not empty fracaso}">
                alertify.error('${fracaso}');
            </c:if> 
 </script>
