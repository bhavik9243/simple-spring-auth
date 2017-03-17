<%@page isELIgnored="false" %>
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
    <h3>SignUp</h3><br>
    <form class="form-horizontal" action="/signup" method="post">
        <div class="form-group">
            <label class="col-sm-2 control-label">Firstname</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="firstname" name="firstname" placeholder="Firstname">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Lastname</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Lastname">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Email</label>
            <div class="col-sm-4">
                <input type="email" class="form-control" id="email" name="email" placeholder="Email">
                <div class="result" id="result"></div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Password</label>
            <div class="col-sm-4">
                <input type="password" class="form-control" id="password" name="password" placeholder="Password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-4">
                <button type="submit" class="btn btn-primary">SignUp</button>
            </div>
        </div>
    </form>
</div>


    <script src="<c:url value="/resources/js/jquery-3.1.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/app.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>