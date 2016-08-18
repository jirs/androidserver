<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <h1>Редактирование Напоминания id: ${remind.id}</h1>
  <a href="/reminders">Вернуться к списку напоминаний</a>
  <form:form method="POST" modelAttribute="reminder" action="/reminder/edit">
      <table>
          <tr>
              <td><form:label path="title">Title</form:label></td>
              <td><form:input path="title" /></td>
          </tr>
          <tr>
              <td><form:label path="remindDate">RemindDate</form:label></td>
              <td><form:input path="remindDate" value="${date}" /></td>
          </tr>
          <tr>
              <td><form:label path="id">id</form:label></td>
              <td><form:input path="id" /></td>
          </tr>
          <tr>
              <td colspan="2">
                  <input type="submit" value="Submit"/>
              </td>
          </tr>
      </table>
  </form:form>
<form:form method="POST" modelAttribute="reminder" action="/reminder/delete">
    <form:input type="hidden" path="id" />
    <input type="submit" value="Delete"/>
</form:form>