<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form method="POST" modelAttribute="mail" action="/mailsend">
    <table>
        <tr>
            <td><form:label path="mailTo">Кому</form:label></td>
            <td><form:input path="mailTo" /></td>
        </tr>
        <tr>
            <td><form:label path="text">Текст</form:label></td>
            <td><form:textarea path="text"></form:textarea></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>