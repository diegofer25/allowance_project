<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <c:import url="head.jsp" />
    <body>
        <br/><br/>
        <div class="container col-md-3"></div>
        <div class="container col-md-6">
            <div class="jumbotron">                
                <h2>Cadastro Pai</h2>
                <c:choose>
                        <c:when test="${empty mensagem}">                    
                        </c:when>
                        <c:otherwise>
                            <div class="alert alert-danger" role="alert">${mensagem}</div>                         
                            <c:remove var="mensagem"/>
                        </c:otherwise>
                    </c:choose>
                <div class="container">
                    <form action="cadpai" method="POST">
                        <div class="form-group">
                            <label for="text">Nome</label>
                            <input type="text" class="form-control" placeholder="Nome" name="nome" required="">
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" placeholder="Email" name="email" required="">
                        </div>
                        <div class="form-group">
                            <label for="pwd">Senha</label>
                            <input type="password" class="form-control" placeholder="Senha" name="senha" required="">
                        </div>
                        <div class="form-group">
                            <label for="pwd">Confirmar Senha</label>
                            <input type="password" class="form-control" placeholder="Confirmar Senha" name="senhaConfirmar" required="">
                        </div> 
                        <br/>
                        <button type="submit" class="btn btn-primary btn-lg">
                            <span class="glyphicon glyphicon-plus"></span> Cadastrar</button> 
                        <a href="/AllowanceProject/login" class="btn btn-primary btn-lg " 
                           role="button" aria-pressed="true">
                            <span class="glyphicon glyphicon-arrow-left"></span> Voltar para Login</a>
                    </form>
                </div>
            </div>
            <c:import url="rodape.jsp" />
        </div>   
        <div class="container col-md-3"></div>
    </body>
</html>
