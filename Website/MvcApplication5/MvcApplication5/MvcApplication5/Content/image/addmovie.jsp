<%-- 
    Document   : admin
    Created on : Jan 21, 2018, 8:40:25 PM
    Author     : Thinkpad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@page import="java.sql.*"%>
  <%
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
          
            try (Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Thinkpad\\Documents\\NetBeansProjects\\WebApplication1\\build\\web\\DB.accdb", "root", "root")
            ) {
                Statement ste1=null;
            ste1 = connection.createStatement();
            
                String sql1 = "select * from signup";
                ResultSet rs1 = ste1.executeQuery(sql1);
                %><center>
                <table style="width:25%"><%
                int num=1;
                while(rs1.next()){
                String name=rs1.getString("fname");
                String lname=rs1.getString("lname");
                String email = rs1.getString("email");
                String pass=rs1.getString("password");
                %>
                <tr>
                <td style="border:1px solid black"><%=num%></td>    
                <td style="border:1px solid black"><%=name%></td>
                <td style="border:1px solid black"><%=lname%></td>
                <td style="border:1px solid black"><%=email%></td>
                <td style="border:1px solid black"><%=pass%></td>
                
                </tr>
        <%
        num=num+1;
                }
                %></table>
                </center><%
               
            }
            %>
    </body>
</html>
