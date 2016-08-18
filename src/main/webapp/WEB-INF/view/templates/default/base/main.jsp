<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><tiles:getAsString name="title"/></title>
</head>
<body>
    <div class="header"><tiles:insertAttribute name="header" /></div>
    <div class="body"><tiles:insertAttribute name="body" /></div>
    <div class="footer"><tiles:insertAttribute name="footer" /></div>
</body>
</html>
