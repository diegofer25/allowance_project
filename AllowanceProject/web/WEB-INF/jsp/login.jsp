<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<html>
    <c:import url="head.jsp" />
    <body>        
        <br/><br/>
        <div class="container col-md-3"></div>
        <div class="container col-md-6">
            <div class="jumbotron">
                <h1 class="text-center">Allowance Login</h1>
                <div class="container">
                    <br/>
                    <c:choose>
                        <c:when test="${empty status}">
                            <h5>Digite email e senha para continuar</h5>
                        </c:when>
                        <c:otherwise>
                            ${status}
                            <c:remove var="status"/>
                        </c:otherwise>
                    </c:choose>  
                    <form action="login" method="POST">
                        <div class="form-group">
                            <label>Email</label>
                            <input type="email" class="form-control" id="email" placeholder="Email" name="email" required="">
                        </div>
                        <div class="form-group">
                            <label>Senha</label>
                            <input type="password" class="form-control" id="senha" placeholder="Senha" name="senha" required="">
                        </div>
                        <div class="checkbox">
                            <label><input type="checkbox" name="remember"> Lembrar</label>
                        </div>
                        <button type="submit" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-log-in"></span> Logar</button>
                        ou <a href="cadpai" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-pencil"></span> Cadastre-se</a>
                    </form>      
                </div>
            </div>
            <c:import url="rodape.jsp" />
        </div>
        <div class="container col-md-3"></div>
    </body>
</html>


