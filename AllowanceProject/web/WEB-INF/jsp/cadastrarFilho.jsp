<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <c:import url="head.jsp" />
    <body>
        <br/><br/>
        <div class="container">      
            <div class="jumbotron">
                <h2>Cadastro Filho</h2>
                <br/>
                <div class="container">
                    <form action="cadfilho" method="POST">
                        <div class="form-group">
                            <label for="text">Nome</label>
                            <input type="text" class="form-control" id="nome" placeholder="Nome" name="nome" required="">
                        </div>
                        <div class="form-group">
                            <label for="number">Valor da mesada</label>
                            <input type="number" class="form-control" id="mesada" placeholder="Ex: 100" name="mesada" required="">
                        </div>
                        <input type="hidden" name="emailp" value="${pai.email}">
                        <button type="submit" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-plus"></span> Cadastrar</button> 
                        <a href="home" class="btn btn-primary btn-lg " role="button" aria-pressed="true"><span class="glyphicon glyphicon-arrow-left"></span> Voltar</a>
                    </form>
                </div>
            </div>
            <c:import url="rodape.jsp" />
        </div>
    </body>
</html>
