<!DOCTYPE html>
<html>

<head>
<?php include "functions.php"; ?>
<link href="style.css" rel="stylesheet" type="text/css" />
<link rel="icon" href="images/favicon.ico" type="image/x-icon" />
<link href='http://fonts.googleapis.com/css?family=Lato&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="showads.js"></script>
<script src="script.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<style type="text/css">
  body {
   background-color: <?php getBackgroundColor(); ?>;
  }    
</style>

<title> Whats New | <?php writeTitle();?> Apk </title>
<?php writeOtherMeta("WhatsNew.txt"); ?>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
 
<body>
<?php addTagManager(); ?>
<div class="container" style="min-width:  1170px;">
	<div class="header">
		<h1 class="headerText" >Whats New | <?php writeTitle(); ?></h1>
	</div>
	<?php addMenuBar(); ?>
	<table class="content">
		<td class="leftSideBar"> 
			<div class="imageDiv">  
				<img src="images/image.jpg" <?php writeAltTag(); ?> style="width:300px;height:300px;">
			</div> 
			<div class="adZone"> 
				<?php writeAdArea(); ?>
		 	</div>
	 		<div class="adZone"> 				
				<?php writeAdArea(); ?>
	 		</div>
	 		<div class="links">
				<?php createLinks(); ?>
			</div>
		</td>
		<td class="rightSideBar">
			<div class="infoDiv"><h2>Whats New!</h2></div>
			<div class="infoDiv"> <?php writeWhatsNew(); ?></div>
		</td>
	</table>
	<div class="footer">
		<h4 class="footerText"> JMAT GAMES </h4>
		<span>Last Updated: <?php getDateMod(); ?></span>
	</div>
</div>
</body>
</html>