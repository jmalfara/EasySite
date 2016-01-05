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


<title> Cracked Download | <?php writeTitle();?> Cracked Apk </title>
<?php writeMetaDescription(); ?>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>	
<?php addFacebook(); ?>
<?php addTagManager(); ?>
<div class="container" style="min-width:  1170px;">
	<div class="header">
		<h1 class="headerText" >Cracked Apk Download | <?php writeTitle(); ?></h1>
	</div>
	<?php addMenuBar(); ?>
	<table class="content">
		<td class="leftSideBar"> 
			<div class="imageDiv">  
				<img src="images/image.jpg" <?php writeAltTag(); ?> style="width:300px;height:300px;">
			</div> 
			<div> 
				<?php createDownloadButton("Download Cracked APK <br> Here"); ?>
			</div>
			<div> Or Use Google Play: <?php createGooglePlayLink(); ?></div>
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
			<?php addNav(); ?>
			<div class="infoDiv"><h2>Description:</h2></div>
			<div class="infoDiv" id="text" style="overflow-y: scroll; height:400px;"> <?php writeCrackedDescription(); ?></div>
			<div class="infoDiv genre" style="
    			text-decoration: underline;">Genre:</div>
			<div class="infoDiv genre type" id="genre"><?php writeGenre(); ?></div>
			<div class="infoDiv genre" style="
    			text-decoration: underline;">Version:</div>
			<div class="infoDiv genre type"><?php writeVersion(); ?></div>
			<br>
			<div class="infoDiv genre" style="
    			text-decoration: underline;">Rating:</div>
			<div class="infoDiv genre type" id="genre"><?php writeRating(); ?></div>
			<div class="infoDiv genre" style="
    			text-decoration: underline;">Publisher:</div>
			<div class="infoDiv genre type"><?php writePublisher(); ?></div>


			  <br>
			  <div id="myCarousel" class="carousel slide" data-ride="carousel">
			    <!-- Indicators -->
			    <ol class="carousel-indicators">
			    	<?php createDots(); ?>
			    </ol>

			    <!-- Wrapper for slides -->
			    <div class="carousel-inner" role="listbox">
			    	<?php createImages(); ?>
			    </div>

			    <!-- Left and right controls -->
			    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
			      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			      <span class="sr-only">Previous</span>
			    </a>
			    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
			      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			      <span class="sr-only">Next</span>
			    </a>
			  </div>

		</td>
	</table>
	<div class="footer">
		<?php writeCommentBox(); ?>
		<h4 class="footerText"> JMAT GAMES </h4>
		<span>Last Updated: <?php getDateMod(); ?></span>
	</div>
</div>
</body>
</html>