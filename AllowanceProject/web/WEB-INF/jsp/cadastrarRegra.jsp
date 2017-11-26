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
                <h2>Cadastrar Regra</h2>  
                <form action="cadastrarRegra" method="POST">
                    <div class="form-group col-md-7">
                        <label>Regra</label>
                        <input type="text" class="form-control" name="regra" placeholder="Ex: Reclamar para tomar banho" required="">
                    </div>
                    <div class="form-group col-md-2">
                        <label>Valor</label>
                        <input type="number" class="form-control" name="valor" placeholder="Ex: -1" required="">
                    </div>
                    <div class="form-group col-md-2">
                        <label>Ocorrência</label>
                        <input type="number" class="form-control" name="ocorrencia" value="0" required="">
                    </div>
                    <input type="hidden" name="filhoid" value="${filho.id}">
                    <button type="submit" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-plus"></span> Cadastrar</button> 
                    <a href="home" class="btn btn-primary btn-lg" role="button" aria-pressed="true"><span class="glyphicon glyphicon-arrow-left"></span> Voltar</a>
                </form>
            </div>
            <c:import url="rodape.jsp" />
        </div>
    </body>
</html>
