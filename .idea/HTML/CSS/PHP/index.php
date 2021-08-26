<?php
include "config.php";

// Check user login or not
if(!isset($_SESSION['uname'])){
    header('Location: login.php');
}

// logout
if(isset($_POST['but_logout'])){
    session_destroy();
    header('Location: login.php');
}
?>

<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
 <link rel="stylesheet" type="text/css" href="style.css" />
 
 <Style>
.switch {
  display: inline-block;
  height: 34px;
  position: relative;
  width: 60px;
}

.switch input {
  display:none;
}

.slider {
  background-color: #ccc;
  bottom: 0;
  cursor: pointer;
  left: 0;
  position: absolute;
  right: 0;
  top: 0;
  transition: .4s;
}

.slider:before {
  background-color: #fff;
  bottom: 4px;
  content: "";
  height: 26px;
  left: 4px;
  position: absolute;
  transition: .4s;
  width: 26px;
}

input:checked + .slider {
  background-color: #66bb6a;
}

input:checked + .slider:before {
  transform: translateX(26px);
}

.slider.round {
  border-radius: 34px;
}

.slider.round:before {
  border-radius: 50%;
}
</Style>

<head>

    <meta charset="utf-8" />

    <title>Smart Door Bell</title>
   

</head>

<meta name="viewport" content="width=device-width, initial-scale=1">

<body>

    <div  class="topnav">

        <h1 class="linear-wipe">&nbsp &nbsp<img src="/images/rapi_logo.png"> &nbsp DOORBELL</h1> 
        <form  method = "post">
        <button class="button1" name ="but_logout" >Logout</button>
        </form>



    </div>

    <div class="gradient-border" id="box"></div>

    <div class="overlay-content">

        <div class="cardscroll" >

<h1>NOTICATION </h1>

<p>Alle Türklingel-Aktivitäten</p>
   <?php 
    $tdcount = 1; $numtd = 1; // number of cells per row 
    print "<table>"; 
    
    $f = fopen("/var/www/html/docs/doorbell log.txt", "r");
    
     
    while (!feof($f)) { 
        $arrM = explode(",",fgets($f)); 
        $row = current ( $arrM );
        list ($sname) = explode(' ',$row);
        $info = substr(strstr($row," "), 1);
        
          
        if ($tdcount == 1) 
            print "<tr>"; print "<td> System <br>@$sname<br> $info </td>"; 
        if ($tdcount == $numtd) { 
            print "</tr>"; 
            $tdcount = 1; 
        } else { 
            $tdcount++; 
        } 
    } 
    if ($tdcount!= 1) { 
        while ($tdcount <= $numtd) { 
            print "<td>&nbsp;</td>"; $tdcount++; 
        } print "</tr>"; 
    } 
    print "</table>"; 
?>
            
               
               
               
               


        </div>
</div>

    <div class="card">

                 <h1>NAME & PIN BEARBEITEN</h1>
                 

<?php

$url_name_pin = "/var/www/html/docs/residents.txt";
if(isset($_POST['speichern'])){
        
    $text = $_POST['textbox'];        
  
    $text1 = $_POST['textbox1'];
	$text2 = $_POST['textbox2'];
	$text3 = $_POST['textbox3'];
	$text4 = $_POST['textbox4'];
	$text5 = $_POST['textbox5'];
	$text6 = $_POST['textbox6'];
	$text7 = $_POST['textbox7'];
	$text8 = $_POST['textbox8'];
	$text9 = $_POST['textbox9'];
	
	

$strings = file_get_contents($url_name_pin);
list($name1,$name2,$name3,$pin1,$pin2,$pin3,$rfid1,$rfid2,$rfid3) = explode("_", $strings);

$get_names = [$name1,$pin1,$rfid1,$name2,$pin2,$rfid2,$name3,$pin3,$rfid3];
$set_names = [$text1,$text2,$text3,$text4,$text5,$text6,$text7,$text8,$text9];
$strreplace = str_replace($get_names,$set_names,$strings);
            
  file_put_contents('/var/www/html/docs/residents.txt', $text);          
  file_put_contents($url_name_pin,$strreplace);
  
   //place "update" in update file 
    $old_url = '/var/www/html/docs/update.txt';
    $current = file_get_contents($old_url);
    $uper = file_get_contents('/var/www/html/docs/update.txt');
    $update = 'update';
    $update_replace = str_replace ($uper,$update,$current);
    file_put_contents($old_url,$update_replace);
  
}else{

$text = file_get_contents('/var/www/html/docs/doorText.txt');
$data = file_get_contents($url_name_pin);
list($name1, $name2,$name3,$pin1,$pin2,$pin3,$rfid1,$rfid2,$rfid3) = explode("_", $data);

}

?>
<br>
<form method="post">



<table>
    
                        <tbody>
<textarea name = "textbox"><?=$text?></textarea>
                            <tr>

                                <th>NAME</th>
                                <th>PIN</th>
                                <th>RFID</th>

                            </tr>

                            <tr>

                                <td><textarea name="textbox1"  cols="10" rows="1"><?php echo $name1?></textarea></td>
                                <td><textarea name="textbox2"  cols="10" rows="1"><?php echo $pin1?></textarea></td>
                                <td><textarea name="textbox3"  cols="15" rows="1"><?php echo $rfid1?></textarea></td>

                            </tr>

                            <tr>

                                <td><textarea name="textbox4" cols="10" rows="1"><?php echo $name2 ?></textarea></td>
                                <td><textarea name="textbox5" cols="10" rows="1"><?php echo $pin2 ?></textarea></td>
                                <td><textarea name="textbox6" cols="18" rows="1"><?php echo $rfid2 ?></textarea></td>

                            </tr>

                            <tr>
                                <td><textarea name="textbox7" cols="10" rows="1"><?php echo $name3 ?></textarea></td>
                                <td><textarea name="textbox8" cols="10" rows="1"><?php echo $pin3 ?></textarea></td>
                                <td><textarea name="textbox9" cols="10" rows="1"><?php echo $rfid3 ?></textarea></td>

                            </tr>

                       
                        </tbody>
    </table>
    
   


    <input style = "width: 94%;position: absolute;right:16px;bottom:12px;" class ="button" type = "submit" name = "speichern" value="Save settings!" onclick="window.location.reload();alert('changes Saved')"/>

    </form>

    </div>
    
    
    
<div class = "card">
<h1>Live-Vorführung</h1>

<p>Klicken Sie auf den Namen, um mit dem Live-Stream zu interagieren</p>
<?php
$live ="live";
$pins ="pins";
if(isset($_POST['demo_name1'])){
    
$demo1 = $name1;

file_put_contents('/var/www/html/docs/liveDemo.txt', $demo1);
file_put_contents('/var/www/html/docs/live.txt', $live);


}
if(isset($_POST['demo_name2'])){
    
$demo2 = $name2;
file_put_contents('/var/www/html/docs/liveDemo.txt', $demo2);
file_put_contents('/var/www/html/docs/live.txt', $live);

}
if(isset($_POST['demo_name3'])){
    
$demo3 = $name3;
file_put_contents('/var/www/html/docs/liveDemo.txt', $demo3);
file_put_contents('/var/www/html/docs/live.txt', $live);

}

if(isset($_POST['demo_name4'])){
    
$demo3 = $name3;
file_put_contents('/var/www/html/docs/liveDemo.txt', $pins);
file_put_contents('/var/www/html/docs/live.txt', $live);

}
if(isset($_POST['demo_name5'])){
   
$Pin = $_POST['code'];
file_put_contents('/var/www/html/docs/liveDemo.txt', $Pin);
file_put_contents('/var/www/html/docs/live.txt', $pins);

}

if(isset($_POST['demo_name6'])){
   
$close ='close';
file_put_contents('/var/www/html/docs/close.txt', $close);


}


?>
   
      
                <div>
                    <form method="post">
                    <button type="submit" name = "demo_name1" class="button1"style ="width: 600px"><?=$name1?></button>
                    </form>
                </div>
                <br></br>
                <div>
                    <form method="post">
                    <button type="submit" name = "demo_name2" class="button1" style ="width: 600px"><?=$name2?></button>
                    </form>
                </div>
                <div>
                    <form method="post">
                    <button type="submit" name = "demo_name3"  class="button1"  style ="width: 600px"><?=$name3?></button>
                     <button type="submit" name = "demo_name4"  class="button1"  style ="width: 600px">Open PIN Keypad</button>
                     
                     
                      
                    </form>
                </div> 
                 <div class="btn-group">
                
                </div>  
                <br></br>    
                <div>
                    <form method="post">
                   
                   
                    
                   
                    </form>
                </div>        
                
            
        </div>
        
                     
    

    <div class="card" style="background-image:url('http://derotech.info:8000/stream.mjpg')">

	<p id="time" style="color:white;, font-family:arial black;" >Live Stream   &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
    <span id='ct7' style="background-color: #FFFF00"></span>
    <span id="txt"></span></p>

    <div>
        <button class ="button" style = "width: 94%;position: absolute;right:16px;bottom:12px;">Open</button>
    </div> 
    
    </div>
    
    

    <div class="card" > 
     
                 
                 <h1> ABWESENHEITSINFO</h1>
                 
<?php

$url_checkB = "/var/www/html/docs/Cheak_user.txt";
$redirect_url = "/var/www/html/docs/redirect.txt";

if(isset($_POST['save_mesage'])){
    
    
    $checkB1 = $_POST["user1"];
	$checkB2 = $_POST["user2"];
	$checkB3 = $_POST["user3"];
    
    $msg_text1 = $_POST['msgbox1'];
	$msg_text2 = $_POST['msgbox2'];
	$msg_text3 = $_POST['msgbox3'];
    $redirect_text1 = $_POST['msgbox_1'];
	$redirect_text2 = $_POST['msgbox_2'];
	$redirect_text3 = $_POST['msgbox_3'];
    
    
    //save checkbox input
    
    
	$strings = file_get_contents($url_checkB);
	list($BellName1, $stat1,$BellName2, $stat2,$BellName3, $stat3) = explode("_", $strings);
	
	$get_checkB = [$stat1,$stat2,$stat3];
	$set_checkB = [ $checkB1[0],$checkB2[0],$checkB3[0]]; 
	$strreplace = str_replace($get_checkB,$set_checkB,$strings);  
  
    file_put_contents($url_checkB,$strreplace);
    
    //save messages
    $msg_url = "/var/www/html/docs/Messages.txt";
    $msg_strings = file_get_contents($msg_url);
    list($msg1, $msg2,$msg3) = explode("/", $msg_strings);
    
    $get_msg = [$msg1,$msg2,$msg3];
    $set_msg = [$msg_text1,$msg_text2,$msg_text3];
    $msgreplace = str_replace($get_msg,$set_msg,$msg_strings);
    
    file_put_contents($msg_url,$msgreplace);
    
    //save redirection
    
    
    
    $redirect_strings = file_get_contents($redirect_url);
    list($redirect1, $redirect2,$redirect3) = explode("_", $redirect_strings);
    
    $get_redirect = [$redirect1,$redirect2,$redirect3];
    $set_redirect = [$redirect_text1,$redirect_text2,$redirect_text3];
    $redirect_replace = str_replace($get_redirect,$set_redirect,$redirect_strings);
    file_put_contents($redirect_url,$redirect_replace);
    
    //place "update" in update file 
    $old_url = '/var/www/html/docs/update.txt';
    $current = file_get_contents($old_url);
    $uper = file_get_contents('/var/www/html/docs/update.txt');
    $update = 'update';
    $update_replace = str_replace ($uper,$update,$current);
    file_put_contents($old_url,$update_replace);
    
} 
    $msgs = file_get_contents('/var/www/html/docs/Messages.txt');
    list($msg1, $msg2,$msg3) = explode("/", $msgs);
    
    $strings = file_get_contents($url_checkB);
	list($BellName1, $stat1,$BellName2, $stat2,$BellName3, $stat3) = explode("_", $strings);
    
    $info = file_get_contents($redirect_url);
    list($redirect1, $redirect2,$redirect3) = explode("_", $info);

    $newstat1 = rtrim($stat1, "0 ");
    $newstat2 = rtrim($stat2, "1 ");
    $newstat3 = rtrim($stat3, "2 ");
?>
<div  id="checkbox-container" >
<form method="post">
<table>
    <tbody>

            <tr>
            <th>
            <label class="container">Away 
            <input type="checkbox" checked="checked" ;> &nbsp &nbsp &nbsp &nbsp Home  <input type="checkbox" onClick="uncheck(1)";>
            <span class="checkmark"></span>
            </label>
            </th>
            </tr>

    <tr>
    <td>
        <input  type='checkbox' id ='box1' name='user1[]' value='Away0'/> <?php echo $name1, "   (",$newstat1,")"?>
        <input  type='hidden'   name='user1[]' value='Home0'/> 
    <textarea id ="userText" name="msgbox1" style="width:575px;height:30px;"  ><?php echo $msg1?></textarea>
    <textarea  name="msgbox_1" style="width:575px;height:30px;"  ><?php echo $redirect1?></textarea></td>
    </td>
    </tr>
    
    <tr>
    <td>
    <input  type='checkbox' id ='box2' name='user2[]' value='Away1'/> 
    <input  type='hidden'   name='user2[]' value='Home1'/>  <?php echo $name2 , " (",$newstat2,")"?>
    <textarea id ="userText1" name="msgbox2" style="width:575px;height:30px;"  ><?php echo $msg2 ?></textarea>
    <textarea  name="msgbox_2" style="width:575px;height:30px;"  ><?php echo $redirect2?></textarea></td>
    </td>
    </tr>
    
    <tr>
    <td>
    <input  type='checkbox' id ='box3' name='user3[]' value='Away2'/> 
    <input  type='hidden'   name='user3[]' value='Home2'/>  <?php echo $name3, " (",$newstat3,")"?>
    <textarea id ="userText2" name="msgbox3" style="width:575px;height:30px;" ><?=$msg3?></textarea>
    <textarea  name="msgbox_3" style="width:575px;height:30px;"  ><?php echo $redirect3?></textarea></td>
    </td>
    </tr>
  
</table>

<input  style = "width: 94%;position: absolute;right:16px;bottom:12px;" class = " button"type = "submit" name = "save_mesage" value="Save Message!" onclick="window.location.reload();alert('Info Saved')"/>
  </form>    
  </div>           
                 </div>

	<div class ="card">
        <h1>QR code sampleImage</h1>
        <p>Um zum nächsten QR-Code zu gelangen, bewegen Sie den Mauszeiger auf den mittleren linken und rechten Rand des QR-Codes.</p>
  <?php
   $msgs = file_get_contents('/home/pi/Desktop/Messages.txt');
    list($msg1, $msg2,$msg3) = explode("/", $msgs);
  ?>      
<div class="slideshow-container">

<div class="mySlides fade">
  <div class="numbertext"><?=$msg1?></div>
  <img src="/images/usr1Qrc4html.png" style="width:100%">
  <div class="text"><?=$name1 ?></div>
</div>

<div class="mySlides fade">
  <div class="numbertext"><?=$msg2?></div>
  <img src="/images/usr2Qrc4html.png" style="width:100%"> 
  <div class="text"><?=$name2 ?></div>
</div>

<div class="mySlides fade">
  <div class="numbertext"><?=$msg3?></div>
  <img src="/images/usr3Qrc4html.png" style="width:100%"> 
  <div class="text"><?=$name3 ?></div>
</div>

<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
<a class="next" onclick="plusSlides(1)">&#10095;</a>

</div> 
<br>

<div style="text-align:center">
  <span class="dot" onclick="currentSlide(1)"></span> 
  <span class="dot" onclick="currentSlide(2)"></span> 
  <span class="dot" onclick="currentSlide(3)"></span> 
</div>


                 </div> 
 
</div>
</body>

</html>


<script>
  document.getElementById('userBox').onchange = function() {
    document.getElementById('userText').readonly = !this.checked;
    
};
document.getElementById('userBox1').onchange = function() {
    document.getElementById('userText1').readonly = !this.checked;
    
};
document.getElementById('userBox2').onchange = function() {
    document.getElementById('userText2').readonly = !this.checked;
    
};

    </script> 
 
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
    <script>
			 var checkboxValues = JSON.parse(localStorage.getItem('checkboxValues')) || {},
            $checkboxes = $("#checkbox-container :checkbox");

        $checkboxes.on("change", function () {
            $checkboxes.each(function () {
                checkboxValues[this.id] = this.checked;
            });

            localStorage.setItem("checkboxValues", JSON.stringify(checkboxValues));
        });

        // On page load
        $.each(checkboxValues, function (key, value) {
            $("#" + key).prop('checked', value);
        });
    </script>
<script>
var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " active";
}
 
window.onload=function(){getTime();}
function getTime(){  
var today=new Date();
var month = new Array();
  month[0] = "January";
  month[1] = "February";
  month[2] = "March";
  month[3] = "April";
  month[4] = "May";
  month[5] = "June";
  month[6] = "July";
  month[7] = "August";
  month[8] = "September";
  month[9] = "October";
  month[10] = "November";
  month[11] = "December";
  var d = today.getDate();
  var mm = month[today.getMonth()];
  var y = today.getFullYear();
  var h=today.getHours();  
  var m=today.getMinutes();  
  var s=today.getSeconds();
  var datetime = d +" "+mm+" "+y;
// add a zero in front of numbers<10  
m=checkTime(m);  
s=checkTime(s);  
document.getElementById('txt').innerHTML=datetime+" "+h+":"+m+":"+s;  
setTimeout(function(){getTime()},1000);  
}  
//setInterval("getTime()",1000);//another way  
function checkTime(i){  
if (i<10){  
  i="0" + i;  
 }  
return i;  
}  
</script> 
