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
                <h2>Gerenciar Filhos</h2>            
                <div class="container">
                    <c:choose>
                        <c:when test="${empty mensagem}">                    
                        </c:when>
                        <c:otherwise>
                            ${mensagem}
                            <c:remove var="mensagem"/>
                        </c:otherwise>
                    </c:choose>
                    <br/>
                    <table class="table text-center">
                        <thead>
                            <tr >
                                <th><h3 class="text-center">Filho</h3></th>
                                <th><h3 class="text-center">Valor Mesada</h3></th>
                                <th><h3 class="text-center">Gerenciar Mesada</h3></th>
                                <th><h3 class="text-center">Excluir</h3></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${filhos}" var="filho"> 
                                <tr>
                                    <td><h4>${filho.nome}</h4></td>
                                    <td><h4>R$ ${filho.valorMesada},00</h4></td>
                                    <td>
                                        <form action="visualizarmesada" method="GET">
                                            <input type="hidden" name="filhoid" value="${filho.id}">
                                            <button type="submit" class="btn btn-info"><span class="glyphicon glyphicon-list-alt"></span></button>                                
                                        </form>                                        
                                    </td>
                                    <td>
                                        <form action="excluirmesada" method="GET">
                                            <input type="hidden" name="filhoid" value="${filho.id}">
                                            <button  class="btn btn-info" rel="tooltip" data-placement="botton" type="submit"  
                                                     onclick="return confirm('Deseja mesmo excluir a mesada de ${filho.nome}?')" >
                                                <span class="glyphicon glyphicon-trash"></span></button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <br/><br/>
                    <form action="cadfilho" method="GET">   
                        <input type="hidden" name="paiemail" value="${pai.email}">
                        <button type="submit" class="btn btn-primary btn-lg" role="button" aria-pressed="true">
                            <span class="glyphicon glyphicon-plus"></span> Cadastrar Novo Filho</button> 
                        <a href="home" class="btn btn-primary btn-lg" role="button" aria-pressed="true">
                            <span class="glyphicon glyphicon-arrow-left"></span> Voltar</a>
                    </form><br/>
                </div>
            </div>
            <c:import url="rodape.jsp" />
        </div>       
    </body>
</html>
