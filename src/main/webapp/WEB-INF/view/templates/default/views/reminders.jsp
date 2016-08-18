<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <table>
    <c:forEach items="${reminders}" var="reminder">
        <tr>
            <td><a href="/reminder/edit/${reminder.id}">Редактировать</a></td>
            <td><a href="/reminder/${reminder.id}">${reminder.id}</a></td>
            <td>${reminder.title}</td>
            <td>${reminder.remindDate}</td>
        </tr>
    </c:forEach>
  </table>
