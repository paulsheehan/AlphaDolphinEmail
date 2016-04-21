<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Alpha Dolphin</title>
    <link rel="stylesheet" href="https://bootswatch.com/paper/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
</head>
<body>
	<!-- Modal for Logout -->
	<div id="myModal" class="modal fade" tabindex="-1" role="dialog">
		<div class="modal-dialog">
		
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title">Are you sure you want to finish your session?</h4>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal">Yes</button>
					<button type="button" class="btn btn-danger">No</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Beginning of the Web Page -->
	<nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><img src="image/logo.png"/> <b>Dolphin</b> Your e-mail platform</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li><button class="btn btn-primary navbar-btn" data-toggle="modal" data-target="#myModal">Logout</button></li>
                </ul>
            </div>
        </div>
    </nav>
	
	<div class="container settings">
	<!-- left part of the screen -->
	<div class="col-md-2 left">
			<img src="http://thesocialmediamonthly.com/wp-content/uploads/2015/08/photo.png" class="img-thumbnail" alt="Cinque Terre" width="204" height="136">
			<div class="buttons">
				<form action="FrontController" method="post" id="viewInbox">
							<input type="hidden" name="action" value="ShowEmails" />
							<input type="hidden" name="folder" value="inbox" />
				</form>
				<button type="submit" form="viewInbox" class="btn btn-block btn-side btn-info" data-toggle="tooltip" data-placement="bottom" title="Click here to see your list of e-mails."><i class="fa fa-envelope"></i><b>My E-mails</b></button>
				
				<form action="composeEmail.html" method="post" id="newEmail">
							<input type="hidden" name="action" value="compose" />
				</form>
				<button type="submit" form="newEmail" class="btn btn-block btn-side btn-info" data-toggle="tooltip" data-placement="bottom" title="Click here to write e-mails."><i class="fa fa-pencil"></i><b>Write E-mails</b></button>
				
				<form action="FrontController" method="post" id="viewDraft">
							<input type="hidden" name="action" value="ShowEmails" />
							<input type="hidden" name="folder" value="draft" />
				</form>
				<button type="submit" form="viewDraft" class="btn btn-block btn-side btn-info" data-toggle="tooltip" data-placement="bottom" title="Click here to continue writing your unfinished e-mails."><i class="fa fa-book"></i><b>Draft E-mails</b></button>
				
				<form action="FrontController" method="post" id="viewTrash">
							<input type="hidden" name="action" value="ShowEmails" />
							<input type="hidden" name="folder" value="trash" />
				</form>
				<button type="submit" form="viewTrash" class="btn btn-block btn-side btn-info" data-toggle="tooltip" data-placement="bottom" title="Click here to check and recover deleted e-mails."><i class="fa fa-trash"></i><b>Bin</b></button>
				
				<form action="settings.html" method="post" id="toSettings">
							<input type="hidden" name="action" value="settings" />
				</form>
				<button type=submit" form="toSettings" class="btn btn-block btn-side btn-info" data-toggle="tooltip" data-placement="bottom" title="Click here to manage your account."><i class="fa fa-cog"></i><b>Settings</b></button>

			</div>
			<p class="storage-capacity"><b>Storage Capacity:</b></p>
			<div class="progress">
				<div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 75%;">
					75%
				</div>
			</div>
	</div>	
		
		<!-- right -->
		<div class="col-md-10 right">
			<div class="panel panel-default btn-grid ">
				<div class="panel-body">
					<form action="action_page.php">
					
					<div class="list-group">

						<table>
							<tr>
								<a href="#" class="list-group-item">
									<div class="checkbox hidden-xs hidden-sm visible-md-inline-block visible-lg-inline-block">
										<label>
											<input type="checkbox">
										</label>
									</div>
									<!-- Name of Sender -->
									<span class="name">John Doe<small class="hidden-xs hidden-sm"><JohnDoe@gmail.com></small></span> 
									<!-- Email Header -->
									<span class="title">This is big title</span> 
									<!-- Preview Text -->
									<span class="text-muted text">- Hi hello how r u ?</span>
									<!-- Time Stamp -->
									<span class="badge" data-toggle="tooltip" data-placement="bottom" title="Recieved Email">12:10 AM</span> 
									<span class="pull-right">
									<span class="glyphicon glyphicon-lock hidden-xs hidden-sm" data-toggle="tooltip" data-placement="bottom" title="Click To Save Email">
								</a>
							</tr>
							<tr>
								<a href="#" class="list-group-item">
									<div class="checkbox hidden-xs hidden-sm visible-md-inline-block visible-lg-inline-block">
										<label>
											<input type="checkbox">
										</label>
									</div>
									<!-- Name of Sender -->
									<span class="name">John Doe<small class="hidden-xs hidden-sm"><JohnDoe@gmail.com></small></span> 
									<!-- Email Header -->
									<span class="title">This is big title</span> 
									<!-- Preview Text -->
									<span class="text-muted text">- Hi hello how r u ?</span>
									<!-- Time Stamp -->
									<span class="badge" data-toggle="tooltip" data-placement="bottom" title="Recieved Email">12:10 AM</span> 
									<span class="pull-right">
									<span class="glyphicon glyphicon-lock hidden-xs hidden-sm" data-toggle="tooltip" data-placement="bottom" title="Click To Save Email">
								</a>
							</tr>
						</table>
						
					</div>
				</div>
			
			</div>	
			<div class="updates">
				<button type="button" class="btn btn-default btn-sm"><i class="fa fa-refresh"></i> Look for new emails</button>
				<div class="pull-right">
					<button type="button" class="btn btn-default btn-sm"><i class="fa fa-arrow-left"></i> Previous page</button>
					<button type="button" class="btn btn-default btn-sm"><i class="fa fa-arrow-right"></i> Next page</button>		
				</div>
			</div>
		</div>
	</div>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script>
$(function () {
  $('[data-toggle="tooltip"]').tooltip()
})
</script>
</body>	
	
	
	
	
	
	
	
</html>
	
	
	
	
	
	
	
</html>