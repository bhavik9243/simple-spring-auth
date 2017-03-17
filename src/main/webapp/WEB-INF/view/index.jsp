<%@page isELIgnored="false" %>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Hello..</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/> ">
</head>
<body>

    <jsp:include page="../view/partials/navbar.jsp"/>

    <div class="container">
            ${message}
        <h2>Welcome.. ${user_session}</h2><br>

    </div>



<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>