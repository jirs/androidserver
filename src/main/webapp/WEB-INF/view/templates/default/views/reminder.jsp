<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <h1>Напоминание ${reminder.id}</h1>
  <a href="/reminders">Вернуться к списку напоминаний</a>
  <table>
        <tr>
            <td>${reminder.id}</td>
            <td>${reminder.title}</td>
            <td>${reminder.remindDate}</td>
        </tr>
  </table>

