<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/index.css">
</head>
<body>
<div id="message"></div>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<script>
    /*
    if (window.EventSource) {
        let source = new EventSource('push');
        var s = '';
        source.addEventListener('message', e => {
            s += e.data + '<br/>';
            document.querySelector('#message').innerHTML = s;
        }, false)
        source.addEventListener('open', e => {
            console.log('open.')
        }, false);
        source.addEventListener('error', e => {
            if (e.readyState == EventSource.CLOSED) {
                console.log('closed');
            } else {
                console.log(e.readyState);
            }
        }, false)
    } else {
        console.error('浏览器不支持')
    }
    */
    $(function () {
        func()
        function func() {
            $.get('defer', function (data) {
                console.log(data)
                func()
            })
        }
    })
</script>
</body>
</html>