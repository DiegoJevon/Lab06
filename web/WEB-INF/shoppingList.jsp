<%-- 
    Document   : shoppingList
    Created on : Jun 20, 2022, 7:52:54 PM
    Author     : Diego Maia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
            <p>Hello, ${username} 
             <a href="shoppingList?action=logout">Logout</a></p>
        
        
        <h2>List</h2>
        <form action="" method="post">
            <label>Add item:</label>
            <input type="text" name="item_name">
            <input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
        </form>
        <form action='' method ='post'>
            <table>          
                    <c:forEach var="item" items="${shopCart}">
                        <tr>
                            <td><input type='radio' name='to_delete' value='${item}'></td>
                            <td>${item}</td>
                        </tr>                    
                    </c:forEach>
            </table>
        <c:if test="${shopCart != null}">
                <input type='submit' value='Delete'>
                <input type='hidden' name='action' value='delete'>
             
        </c:if>   
        </form>
    </body>
</html>
