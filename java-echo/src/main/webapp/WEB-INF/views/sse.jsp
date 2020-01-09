<%@ page pageEncoding="UTF-8" trimDirectiveWhitespaces="true" session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Starter Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <style>
        body {
            padding-top: 50px;
        }

        .starter-template {
            padding: 40px 15px;
            text-align: center;
        }
    </style>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

<div class="container">
    <h1>Echo Server</h1>
    <!--
    <div>
        <form>
            <input type="button" onclick="send_echo()" value="Press to send">
            <input type="text" id="textID" name="message" value="Hello Web Sockets">
        </form>
    </div>
    -->
    <div id="output"></div>
</div><!-- /.container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
    var source, output;

    function init() {
        output = document.querySelector('#output');
        send_echo()
    }

    function send_echo() {
        var wsUri = '/sse/message';
        source = new EventSource(wsUri);
        writeToScreen('Connecting to ' + wsUri);
        source.onopen = function (evt) {
            writeToScreen('Connected!');
            // doSend(textID.value)
        }
        source.onmessage = function (evt) {
            writeToScreen('Received message: ' + evt.data);
            //source.close();
        }
        source.onerror = function (evt) {
            writeToScreen('<span style="color: red;">Error: </span>' + evt.data);
            source.close();
        }
        source.onclose = function () {
            writeToScreen('<span style="color: blue;">Closed!</span>');
        }
    }

    function doSend(message) {
        echo_websocket.send(message);
        writeToScreen('Sent message: ' + message)
    }

    function writeToScreen(message) {
        var pre = document.createElement('p');
        pre.style.wordWrap = 'break-word';
        pre.innerHTML = message;
        output.appendChild(pre);
    }

    window.addEventListener('load', init , false);
</script>
</body>
</html>
