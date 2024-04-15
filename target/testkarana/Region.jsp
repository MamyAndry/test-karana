<%
    Exception error = (Exception) request.getAttribute("error");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <%if(error != null) {%>
        <p style="color: red;"><%=error.getCause().getMessage()%></p>    
    <%}%>
    <form action="save-region2.do" method="post">
        <div class="mb-3"> 
             <label class="form-label">Nom Region</label> 
             <input class="form-control" type="text" name="nomRegion" />
        </div>
        
        <div class="mb-3">
        <Button variant="primary" type= "submit" >
            Save Changes
        </Button>
        </div>
    </form>
</body>
</html>