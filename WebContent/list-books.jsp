<%@ page import="java.util.*,com.jspAssignment.*" %>
<!DOCTYPE html>
<html>
<head>
<title> Book Details Store </title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" >
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
   <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js"></script>
   <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/dataTables.bootstrap.min.css" />
  <script src="https://cdn.datatables.net/buttons/1.6.2/js/dataTables.buttons.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
   <script src="https://cdn.datatables.net/buttons/1.6.2/js/buttons.html5.min.js"></script>
   			<link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css" />
           <link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.6.3/css/buttons.dataTables.min.css" />
           <script src="https://cdn.datatables.net/buttons/1.6.3/js/buttons.print.min.js"></script>
</head>
<%
     List<Book> theBooks = (List<Book>) request.getAttribute("BOOK_LIST");

%>
<body>
<div class="panel panel-primary "> <!-- open panel -->
                    
                        <div class="panel-body"> <!-- open panel body -->
                      		<div style="padding: 60px;text-align: center;background: #1abc9c;color: white;font-size: 50px;">
								<h1>WEB APPLICATION ASSIGNMENT <br> BOOK STORE </h1>
                         	</div>
                        </div><!-- close panel body -->
         </div><!-- close panel -->

<div class="container"><!-- open container -->
    <div class="row"><!-- open row -->
        <div class="col-md-12"> <!-- open 12 col -->
                    <div class="panel panel-primary "> <!-- open panel -->
                        <div class="panel-heading"><i class="glyphicon glyphicon-home"></i> &nbsp All BOOK DETAILS </div>
                            <div class="panel-body"> <!-- open panel body -->
                                    <div class="table-responsive">
					    <table id="book_data" class="table table-striped table-bordered display" >
					        <thead>
					            <tr>
					                <th>Book Name</th>
					                <th>Author</th>
					                <th>Cost Price</th>
					                <th>Sales Price</th>
					            </tr>
					        </thead>
					    		<% for (Book tempBook : theBooks){ %>
				                 <tr>
				                   <td><%=tempBook.getTitle() %></td>
				                   <td><%=tempBook.getAuthor() %></td>
				                   <td><%=tempBook.getCost() %></td>
				                   <td><%=tempBook.getSales() %></td>

				                 </tr>
				                 
				                 <%} %>
					    </table>
					
					</div> 
                        </div><!-- close panel body -->
                    </div><!-- close panel -->

        </div><!-- close  12 col -->
    </div><!-- close  row -->
</div><!-- close container -->
<script>

$(document).ready( function () {
    $('#book_data').DataTable({ dom: 'lBfrtip', 
        buttons: [
            'copyHtml5',
            'excelHtml5',
            'csvHtml5',
            'pdfHtml5'
        ],
        "lengthMenu": [ [10, 25, 50, -1], [10, 25, 50, "All"] ] });

} );


</script>

</body>
     
</html>