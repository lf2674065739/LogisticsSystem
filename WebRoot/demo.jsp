    <%@page pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <html>
    <head>
    </head>
    <body>
        <table width="60%" border="1" cellpadding="2" cellspacing="0">
            <tr>
                <th>EMPNO</th>
                <th>ENAME</th>
                <th>JOB</th>                     
                <th>SAL</th>            
            </tr>
            <c:forEach items="${emps }" var="emp">
                <tr>
                    <td>${emp.empno }</td>
                    <td>${emp.ename }</td>
                    <td>${emp.job }</td>                                
                    <td>${emp.sal }</td>
                  
                 
                </tr>
            </c:forEach>
        </table>
    </body>
    </html>