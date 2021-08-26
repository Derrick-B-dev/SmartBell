
<!DOCTYPE html>



<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<Style>

	
   
    .login-page {
        width: 560px;
        padding: 8% 0 0;
        margin: auto;
		
    }

    .form {
		border-radius: 6px;
        position: relative;
        z-index: 1;
        background: #FFFFFF;
        max-width: 360px;
        margin: 0 auto 100px;
        padding: 45px;
        text-align: center;
        box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
    }

        .form input {
            font-family: "Roboto", sans-serif;
            outline: 0;
            background: #f2f2f2;
            width: 100%;
            border: 0;
            margin: 0 0 15px;
            padding: 15px;
            box-sizing: border-box;
            font-size: 14px;
        }

        .form button {
            font-family: "Roboto", sans-serif;
            text-transform: uppercase;
            outline: 0;
            background:linear-gradient(to bottom, #00A8EA 1%, #0077C1 60%,#0167B4 100%);
            width: 100%;
            border: 0;
            padding: 15px;
            color: #FFFFFF;
            font-size: 14px;
            -webkit-transition: all 0.3 ease;
            transition: all 0.3 ease;
            cursor: pointer;
        }

            .form button:hover, .form button:active, .form button:focus {
                background:linear-gradient(to bottom, #00A8EA 1%, #0077C1 40%,#0167B4 100%);
            }

        .form .message {
            margin: 15px 0 0;
            color: #b3b3b3;
            font-size: 12px;
        }

            .form .message a {
                color: #4CAC50;
                text-decoration: none;
            }

        .form .register-form {
            display: none;
        }

    .container {
        position: relative;
        z-index: 1;
        max-width: 300px;
        margin: 0 auto;
    }

        .container:before, .container:after {
            content: "";
            display: block;
            clear: both;
        }

        .container .info {
            margin: 50px auto;
            text-align: center;
        }

            .container .info h1 {
                margin: 0 0 15px;
                padding: 0;
                font-size: 36px;
                font-weight: 300;
                color: #1a1a1a;
            }

            .container .info span {
                color: #4d4d4d;
                font-size: 12px;
            }

                .container .info span a {
                    color: #000000;
                    text-decoration: none;
                }

                .container .info span .fa {
                    color: #EF3B3A;
                }

    body {
        
        background:lightblue;
        font-family: "Roboto", sans-serif;
       
    }

</Style>
<?php
include "config.php";


if(isset($_POST['login'])){

    $uname = mysqli_real_escape_string($con,$_POST['loginid']);
    $password = mysqli_real_escape_string($con,$_POST['loginpw']);


    if ($uname != "" && $password != ""){

        $sql_query = "select count(*) as cntUser from users where username='".$uname."' and password='".$password."'";
        $result = mysqli_query($con,$sql_query);
        $row = mysqli_fetch_array($result);

        $count = $row['cntUser'];

        if($count > 0){
            $_SESSION['uname'] = $uname;
            header('Location: index.php');
        }else{
            echo "Invalid username and password";
        }

    }

}
?>
<head>
    <meta charset="utf-8" />
    <title></title>
</head>
<body>
    <div class="login-page">
        <div class="form">
            <form  method = "post" class="login-form">
				<h1><img src="/images/rapi_logo.png"> Door Login</h1>
                <input type="text" class="textbox" id="txt_uname" name="loginid" placeholder="Username" />
                <input type="password" class="textbox" id="txt_uname" name="loginpw" placeholder="Password"/>
               <button type="submit" value="Submit" name="login" id="but_submit" />Login</button>
                <p class="message">Contact me derrick.mubbale@outlook.com</p>
            </form>
        </div>
    </div>

</body>
</html>
