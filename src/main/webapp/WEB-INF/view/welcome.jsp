<%@page isELIgnored="false" %>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h2>Welcome.. <c:out value='${sessionScope.my_session}'/></h2><br>