<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <c:import url="head.jsp" />
    <body>
        <br/><br/>
        <div class="container">
            <div class="container col-sm-2"></div>
            <div class="container col-sm-8">
                <div class="jumbotron">
                    <h1 class="text-center">Allowance Menu</h1>
                    <h3 class="text-center">Bem Vindo ${pai.nome}</h3>
                    <br/>
                    <c:choose>
                        <c:when test="${empty mensagem}">                    
                        </c:when>
                        <c:otherwise>
                            <div class="alert alert-success" role="alert">${mensagem}</div>                            
                            <c:remove var="mensagem"/>
                        </c:otherwise>
                    </c:choose>
                    <div class="container">                
                        <br/>
                        <form action="cadfilho" method="GET">   
                            <input type="hidden" name="paiemail" value="${pai.email}">
                            <button type="submit" class="btn btn-primary btn-lg col-sm-12" 
                                    role="button" aria-pressed="true"><span class="glyphicon glyphicon-plus"></span> Cadastrar Filho</button>
                        </form>
                    </div>
                    <br/>
                    <div class="container">
                        <form action="gerfilho" method="GET">   
                            <input type="hidden" name="emailp" value="${pai.email}">
                            <button type="submit" class="btn btn-primary btn-lg col-sm-12" 
                                    role="button" aria-pressed="true"><span class="glyphicon glyphicon-user"></span> Gerenciar Filhos</button>
                        </form>                  
                    </div>
                    <br/>
                    <div class="container">
                        <a href="/AllowanceProject/login" class="btn btn-primary btn-lg col-sm-12" 
                           role="button" aria-pressed="true"><span class="glyphicon glyphicon-log-out"></span> Log Out</a>
                    </div>
                </div>
                <c:import url="rodape.jsp" />
            </div>

        </div>
        <div class="container col-sm-2"></div>

    </div>
</body>
</html>
