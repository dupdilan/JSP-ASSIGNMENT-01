
<%@ page import="java.util.*,com.jspAssignment.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" >
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  
</head>
<body> 
        <div class="panel panel-primary "> <!-- open panel -->
                    
                        <div class="panel-body"> <!-- open panel body -->
                      		<div style="padding: 60px;text-align: center;background: #1abc9c;color: white;font-size: 50px;">
								<h1>WEB APPLICATION ASSIGNMENT <br>ADD BOOKS INTO DB</h1>
                         	</div>
                        </div><!-- close panel body -->
         </div><!-- close panel -->
    


<div class="container"><!-- open container -->
<div class="row"><!-- open row -->
    
    <div class="col-md-12"> <!-- open 12 col -->

       
        <div class="panel panel-primary "> <!-- open panel -->
                    <div class="panel-heading"><i class="glyphicon glyphicon-home"></i> &nbsp BOOK DETAILS </div>
                        <div class="panel-body"> <!-- open panel body -->
                        <form class="form-horizontal" role="form" action="BookController" method="GET">
                        <input type="hidden" name="command" value="ADD" />
    <!-- Next Form Group -->
    <div class="form-group">
        <div class="col-md-12">
            <div class="form-group row">
                <label for="inputKey" class="col-md-3 control-label">BOOK TITLE:</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" id="txtBookTitle" name="txtBookTitle" placeholder="Input Book Title">
                </div>
         
            </div>
        </div>

    </div>
     <!-- Next Form Group -->
    <div class="form-group">
        <div class="col-md-12">
            <div class="form-group row">
                <label for="inputValue" class="col-md-3 control-label">AUTHOR :</label>
                <div class="col-md-6">
                <input type="text" class="form-control" id="txtBookAuthor" name="txtBookAuthor" placeholder="Select Athor" required>
                </div>
            </div>
        </div>

    </div>
                                                
    <!-- Next Form Group -->
    <div class="form-group">

        <div class="col-md-12">
            <div class="form-group row">
                <label for="inputKey" class="col-md-2 control-label">COST PRICE:</label>
                <div class="col-md-3">
                    <input type="number" class="form-control" id="txtCostPrice" name="txtCostPrice" placeholder="Input Cost Price" required>
                </div>
                <label for="inputValue" class="col-md-2 control-label">SALES PRICE :</label>
                <div class="col-md-3">
                    <input type="number" class="form-control" id="txtSalesPrice" name="txtSalesPrice" placeholder="Input Sales Price">
                </div>
            </div>
        </div>

    </div>


<!-- Next Form Group -->
                <div class="div-action pull pull-right ">
                    
                    <button type="submit" class="btn btn-success btn-lg" onclick="return confirm('Are you sure to Submit This ?')" id="btnAddBook" name="btnAddBook" value="AddBook" ><i class="glyphicon glyphicon-plus"></i> Submit &lt;F8&gt;</button>
                    <!-- <button type="submit" class="btn btn-secondary btn-lg" onclick="return confirm('Are you sure to Edit This ?')"  id="btnEditdepartment" name="btnEditdepartment" value="Editdepartment"  ><i class="glyphicon glyphicon-pencil"></i> Edit &lt;F10&gt;</button>
                    <button type="submit" class="btn btn-danger btn-lg" onclick="return confirm('Are you sure to Delete This ?')"  id="btnDeletedepartment" name="btnDeletedepartment" value="Deletedepartment" ><i class="glyphicon glyphicon-trash"></i>  Delete &lt;F4&gt;</button> -->
                    <button type="reset" class="btn btn-warning btn-lg"  id="btnclear" name="btnclear" value="clear"><i class="glyphicon glyphicon-remove"></i> Clear &lt;F12&gt;</button>
                </div>

   
</form>
        
                            
                        </div><!-- close panel body -->
                    </div><!-- close panel -->
    
        </div><!-- close  12 col -->

</div><!-- close  row -->
</div><!-- close container -->

</body>
</html>

