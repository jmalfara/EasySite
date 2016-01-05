<?php

function writeDescription() {
	$myfile = fopen("text/AppInfo.txt", "r") or die("Unable to open file!");
	// Output one line until end-of-file
	while(!feof($myfile)) {
 	echo fgets($myfile) . "<br>";
	}
	fclose($myfile);
}

function writeCrackedDescription() {
	$myfile = fopen("text/crackedDes.txt", "r") or die("Unable to open file!");
	// Output one line until end-of-file
	while(!feof($myfile)) {
 	echo fgets($myfile) . "<br>";
	}
	fclose($myfile);
}

function writeVersion() {
	$myfile = fopen("text/currentVersion.txt", "r") or die("Unable to open file!");
	// Output one line until end-of-file
	while(!feof($myfile)) {
 	echo fgets($myfile) . "<br>";
	}
	fclose($myfile);
}

function writeTitle() {
	$myfile = fopen("text/AppName.txt", "r") or die("Unable to open file!");
	// Output one line until end-of-file
	while(!feof($myfile)) {
 	echo fgets($myfile);
	}
	fclose($myfile);
}

function writePublisher() {
	$myfile = fopen("text/Publisher.txt", "r") or die("Unable to open file!");
	// Output one line until end-of-file
	while(!feof($myfile)) {
 	echo fgets($myfile);
	}
	fclose($myfile);
}

function writeRating() {
	$myfile = fopen("text/Rating.txt", "r") or die("Unable to open file!");
	// Output one line until end-of-file
	while(!feof($myfile)) {
 	echo fgets($myfile);
	}
	fclose($myfile);
}

function writeAltTag() {
	$myfile = fopen("text/AppName.txt", "r") or die("Unable to open file!");
	// Output one line until end-of-file
	while(!feof($myfile)) {
 	echo "alt=\"" . fgets($myfile) . " Icon\"";
	}
	fclose($myfile);
}

function writeGenre() {
	$myfile = fopen("text/AppGenre.txt", "r") or die("Unable to open file!");
	// Output one line until end-of-file
	while(!feof($myfile)) {
 	echo fgets($myfile) . "<br>";
	}
	fclose($myfile);
}

function getBackgroundColor() {
	$myfile = fopen("text/ColorValue.txt", "r") or die("Unable to open file!");
	// Output one line until end-of-file
	while(!feof($myfile)) {
 	echo fgets($myfile);
	}
	fclose($myfile);
}

function getDateMod() {
	$myfile = fopen("text/DateMod.txt", "r") or die("Unable to open file!");
	// Output one line until end-of-file
	while(!feof($myfile)) {
 	echo fgets($myfile);
	}
	fclose($myfile);
}

function getVideoLink() {
	echo '<iframe width="420" height="315"';
	$myfile = fopen("text/videoLink.txt", "r") or die("Unable to open file!");
	// Output one line until end-of-file
	while(!feof($myfile)) {
 	echo 'src="' . fgets($myfile) . '">';
	}
	fclose($myfile);
	echo "</iframe>";
}

function createGooglePlayLink() {
	$myfile = fopen("text/Url.txt", "r") or die("Unable to open file!");
	// Output one line until end-of-file
	while(!feof($myfile)) {
 		echo "<a href=\"" . fgets($myfile) . "\">";
	}
	fclose($myfile);

	$myfile = fopen("text/AppName.txt", "r") or die("Unable to open file!");
	// Output one line until end-of-file
	while(!feof($myfile)) {
 		echo fgets($myfile) . "</a>";
	}
	fclose($myfile);
}
// Carosal //

function createDots() {
	// integer starts at 0 before counting
	$i = 0; 
	$dir = 'images/screenshots/';
	if ($handle = opendir($dir)) {
	    while (($file = readdir($handle)) !== false){
	        if (!in_array($file, array('.', '..')) && !is_dir($dir.$file)) {
	      		if ($i == 0) {
					echo "<li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li>";
	      		} else {
	      			echo "<li data-target=\"#myCarousel\" data-slide-to=\""; 
	      			echo "$i\"></li>";
	      		}
	            $i++;
	        }
	    }
	    closedir($handle);
	}
}

function createImages() {
	$i = 0; 
    $dir = 'images/screenshots/';
    if ($handle = opendir($dir)) {
      	while (($file = readdir($handle)) !== false){
    	 	if (!in_array($file, array('.', '..')) && !is_dir($dir.$file)) {
      			if ($i == 0) {
					echo "<div class=\"item active\">
			        	<img src=\"$dir$file\" alt=\"";
			        echo "$i files \" width=\"150\" height=\"200\">
			     		</div>";
      			} else {
      				echo "<div class=\"item\">
			        	<img src=\"$dir$file\" alt=\"";
			        echo "$i files \" width=\"150\" height=\"200\">
			     		</div>";
      			}
           		$i++;
        	}
    	}
    closedir($handle);
    }
}

function createDownloadButton($downloadText) {
	$myfile = fopen("text/AppName.txt", "r") or die("Unable to open file!");
	// Output one line until end-of-file
 	$String = fgets($myfile);
 	$String = preg_replace('/\s+/', '_', $String);

	echo "<form method=\"get\" action=\"";
	echo "$String.apk\">";
	echo "<button class=\"btn btn-success\" id=\"noBlock\" type=\"submit\">";
	echo "$downloadText </button>
		</form>";

	echo "<button class=\"btn btn-success\" id=\"block\" type=\"submit\" onClick=\"alertAdblock();\">";
	echo "$downloadText </button>";

	echo "<script>
      checkIfAdblock(window.canRunAds);
	</script>";
	fclose($myfile);
}

function writeMetaDescription() {
	$max = 155;
	$myfile = fopen("text/AppInfo.txt", "r") or die("Unable to open file!");
	// Output one line until end-of-file
	while(!feof($myfile)) {
 		$String = fgets($myfile) . "<br>";
	}
	fclose($myfile);

	$myfile = fopen("text/AppName.txt", "r") or die("Unable to open file!");
	// Output one line until end-of-file
	while(!feof($myfile)) {
 		$name = fgets($myfile);
	}
	fclose($myfile);

	$initial = "Download $name here! ";

	$current = $max - strlen($initial);
	$smallString = substr($String, 0, $current);
	echo "<meta name=\"description\" content=\"$initial$smallString\">";
}

function writeOtherMeta($file) {
	$max = 155;
	$myfile = fopen("text/$file", "r") or die("Unable to open file!");
	// Output one line until end-of-file
	while(!feof($myfile)) {
 		$String = fgets($myfile) . "<br>";
	}
	fclose($myfile);

	$smallString = substr($String, 0, $max);
	echo "<meta name=\"description\" content=\"$smallString\">";
}

function writeContactBio() {
	$myfile = fopen("text/ids/contact.bio", "r") or die("Unable to open file!");
	// Output one line until end-of-file
	while(!feof($myfile)) {
 		echo fgets($myfile);
	}
	fclose($myfile);
}

function writeAdArea() {
	$myfile = fopen("text/ids/adFile.ad", "r") or die("Unable to open file!");
	// Output one line until end-of-file
	while(!feof($myfile)) {
 		echo fgets($myfile);
	}
	fclose($myfile);
}

function createLinks() {
	echo '<h3> Quick Links! <h3><div class="linkDiv" style="overflow-y: scroll; height:150px;">';
	$myfile = fopen("text/links.txt", "r") or die("Unable to open file!");
	// Output one line until end-of-file
	while(!feof($myfile)) {
		$String = fgets($myfile);
 		echo "<h4> <a href=\"http://" . $String . "\"> $String </a> </h4>";
	}
	fclose($myfile);
	echo "</div>";
}

function addTagManager() {
	$myfile = fopen("text/ids/tagManager.tm", "r") or die("Unable to open file!");
	// Output one line until end-of-file
	while(!feof($myfile)) {
		echo fgets($myfile);
	}
	fclose($myfile);
}

function addMenuBar() {
	echo '<div class="testmenu">
    <ul class="menu-items">
        <li class="menu-item ';

    echo isUrl("") . isUrl("cracked.php") . '"> <a href="/">Home</a>

        </li>
        <li class="menu-item ';

    echo isUrl("whats_new.php") .  '"> <a href="/whats_new.php">Whats New</a>

        </li>
        <li class="menu-item ';

    echo isUrl("contact.php") . '"> <a href="/contact.php">Contact</a>

        </li>
        <li class="menu-item ';

    echo isUrl("about.php") . '"> <a href="/about.php">About</a>
        </li>
        <li class="menu-item ';

    echo isUrl("video.php") . '"> <a href="/video.php">App Trailer</a>
        </li>
    </ul>
</div>';
}

function isUrl($url) {
	if($_SERVER['REQUEST_URI'] == "/$url"){
    	echo "active";
	}
}

function writeAboutBio() {
	$myfile = fopen("text/ids/about.bio", "r") or die("Unable to open file!");
	// Output one line until end-of-file
	while(!feof($myfile)) {
		echo fgets($myfile);
	}
	fclose($myfile);
}

function writeContactForm () {
	$action=$_REQUEST['action'];
	if ($action=="")    /* display the contact form */ {
	    echo '<form  action="" method="POST" enctype="multipart/form-data">
	    <input type="hidden" name="action" value="submit">
	    Your name:<br>
	    <input name="name" type="text" value="" size="30"/><br>
	    Your email:<br>
	    <input name="email" type="text" value="" size="30"/><br>
	    Your message:<br>
	    <textarea name="message" rows="7" cols="30"></textarea><br>
	    <input type="submit" value="Send email"/>
	    </form>';
	} else                /* send the submitted data */ {
	    $name=$_REQUEST['name'];
	    $email=$_REQUEST['email'];
	    $message=$_REQUEST['message'];
	    if (($name=="")||($email=="")||($message==""))
	        {
	        echo "All fields are required, please fill <a href=\"\">the form</a> again.";
	        }
	    else{        
	        $from="From: $name<$email>\r\nReturn-path: $email";
	        $subject="Message sent using your contact form";
	        mail('', $subject, $message, $from);
	        echo "Email sent! We will look at this soon";
	    }
	}  
}

function writeWhatsNew() {
	$myfile = fopen("text/WhatsNew.txt", "r") or die("Unable to open file!");
	// Output one line until end-of-file
	while(!feof($myfile)) {
		echo fgets($myfile);
	}
	fclose($myfile);
}

function addNav() {
	echo '<table class="nav">
				<td class="homeDiv ';

	echo isUrl("") . '"> <a href="/" class="fill-div"> Classic </a> </td>
				<td class="oldDiv ';

	echo isUrl("cracked.php") . '"> <a href="cracked.php" class="fill-div"> Cracked Version </a> </td>
	</table>';
}

function addFacebook() {
	$myfile = fopen("text/ids/facebookScript.fb", "r") or die("Unable to open file!");
	// Output one line until end-of-file
	while(!feof($myfile)) {
		echo fgets($myfile);
	}
	fclose($myfile);
}

function writeCommentBox() {
	echo '<div class="fb-comments" data-href="';
	echo basename(__DIR__);
	echo '" data-numposts="5"></div>';
	// $myfile = fopen("text/ids/facebookComment.fb", "r") or die("Unable to open file!");
	// // Output one line until end-of-file
	// while(!feof($myfile)) {
	// 	echo fgets($myfile);
	// }
	// fclose($myfile);
}

?>