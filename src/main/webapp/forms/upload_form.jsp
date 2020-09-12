<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload 上傳圖片</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css" integrity="sha384-cg6SkqEOCV1NbJoCu11+bm0NvBRc8IYLRGXkmNrqUBfTjmMYwNKPWBTIKyw9mHNJ" crossorigin="anonymous">
    </head>
    <body style="padding: 20px">
        <form method="post" class="pure-form" action="/JavaWeb0829/servlet/upload" encytpe="multipart/form-data">
            <fieldset>
                <legend>Upload 上傳圖片</legend>
                <input type="file"  name="myfile1" /><p />
                <input type="text" placeholder="請輸入圖片名稱" name="desc1" /><p />       
                <button type="submit" class="pure-button pure-button-primary">上傳</button>
            </fieldset>
        </form>

    </body>
</html>
