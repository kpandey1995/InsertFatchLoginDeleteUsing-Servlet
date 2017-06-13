<%-- 
    Document   : newjspregister
    Created on : Jun 13, 2017, 6:34:01 PM
    Author     : ignite259
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="2">
            <tr>
                <td>S.no</td>
                <td>Email</td>
                <td>Password</td>
                <td>Action</td>
            </tr>
            <tbody id="data">

            </tbody>
        </table>

        <script src="jquery.min.js" type="text/javascript"></script>
        <script>
            $(document).ready(function () {
                $.ajax({
                    method: "POST",
                    url: "FetchData",
                    success: function (data) {
                        console.log(data);
                        data = JSON.parse(data);
                        console.log(data);
//$("tbody").ht();
                        var htm = "";
                        for (var i = 0; i < data.length; i++) {
                            console.log(i);
                            htm += "<tr><td>" + data[i].UserId + "</td><td>" + data[i].Email + "</td><td>" + data[i].Password + "</td><td><button type='button' value=\"" + data[i].UserId + "\" name='delete'>Delete</button></td></tr>";


                        }
                        $("#data").append(htm);
                    }
                });
            });
        </script>
    </body>


</html>
