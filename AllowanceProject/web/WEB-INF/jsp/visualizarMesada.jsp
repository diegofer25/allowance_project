<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<html xmlns:h="http://java.sun.com/jsf/html" xmlns:f="http://java.sun.com/jsf/core">
    <c:import url="head.jsp"/>
    <body>
        <br/><br/>
        <div class="container">
            <div class="jumbotron">
                <h2>Mesada de ${filho.nome}</h2>
                <c:choose>
                    <c:when test="${empty mensagem}">                    
                    </c:when>
                    <c:otherwise>
                        <div class="alert alert-success" role="alert">${mensagem}</div>  
                        <c:remove var="mensagem"/>
                    </c:otherwise>
                </c:choose>
                <div class="container">
                    <h3>Valor da mesada: ${filho.valorMesada},00</h3>
                    <c:choose>
                        <c:when test="${not empty regras}">
                            <table class="table table-striped text-center">
                                <thead>
                                    <tr>
                                        <th class="text-center">Regra</th>
                                        <th class="text-center">Valor</th>
                                        <th class="text-center">Ocorrencia</th>
                                        <th class="text-center">Editar Regra</th>
                                        <th class="text-center">Excluir</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="regra" items="${regras}">
                                        <tr>
                                            <td>${regra.nomeregra}</td>
                                            <td>R$ ${regra.valor},00</td> 
                                            <td>${regra.ocorrencia}</td>                                                                                   
                                            <td>
                                                <form method="POST" action="obterRegra"> 
                                                    <input type="hidden" name="idregra" value="${regra.id}"/>
                                                    <button  class="btn btn-info" rel="tooltip" data-placement="botton" type="submit" >
                                                        <span class="glyphicon glyphicon-edit"></button>
                                                </form>
                                            </td>
                                            <td>
                                                <form method="POST" action="deletarRegra">  
                                                    <input type="hidden" name="idregra" value="${regra.id}"/>
                                                    <input type="hidden" name="idfilho" value="${regra.idfilho}"/>
                                                    <button  class="btn btn-info" rel="tooltip" data-placement="botton" type="submit"  
                                                             onclick="return confirm('Deseja mesmo excluir ${regra.nomeregra}?')" >
                                                        <span class="glyphicon glyphicon-trash"></button>
                                                </form>                                        
                                            </td>
                                        </tr>                                
                                    </c:forEach>
                                </tbody>
                            </table>
                            <div class="alert alert-success text-center" role="alert"><h2>Mesada parcial: R$ ${resultMesada},00</h2></div>                             
                            <div class="container">                
                                <br/>
                                <form action="cadastrarRegra" method="GET">   
                                    <input type="hidden" name="idfilho" value="${filho.id}">
                                    <button type="submit" class="btn btn-primary btn-lg" role="button" aria-pressed="true">
                                        <span class="glyphicon glyphicon-plus"></span> Cadastrar Regra</button> 
                                    <a href="home" class="btn btn-primary btn-lg" role="button" aria-pressed="true">
                                        <span class="glyphicon glyphicon-arrow-left"></span> Voltar</a>
                                </form>
                            </div>                        
                        </c:when>
                        <c:otherwise>
                            <h4>${filho.nome} ainda não tem nenhum regra cadastrada</h4>             
                            <br/>
                            <form action="cadastrarRegra" method="GET">   
                                <input type="hidden" name="idfilho" value="${filho.id}">
                                <button type="submit" class="btn btn-primary btn-lg" role="button" aria-pressed="true">
                                    <span class="glyphicon glyphicon-plus"></span> Cadastrar Regra</button>
                                    <a href="home" class="btn btn-primary btn-lg" role="button" aria-pressed="true">
                                        <span class="glyphicon glyphicon-arrow-left"></span> Voltar</a>
                            </form>
                        </c:otherwise>
                    </c:choose>      
                </div>                
            </div>  
            <c:import url="rodape.jsp" />
        </div>
    </body>
</html>
