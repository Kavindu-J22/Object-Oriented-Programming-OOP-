<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>XPERT Events - Login</title>
<link rel="stylesheet" href="css/styles.css" type="text/css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0" />
</head>
<body>
<div id="container">

  <jsp:directive.include file="/include/header.jsp" />

  <div id="body" class="width">

    <section id="content" class="two-column">

         <article>
            
            <h2 style="margin-left: 500px;" class="formbutton">Login</h2>

            <div id="main-content">
              <fieldset style="margin-left: 400px;" class="formbutton">
                <form action="${pageContext.request.contextPath}/LoginController" method="post">
                  
                  <p>
                    <label for="name">Username</label><input name="username" id="username" type="text" maxlength="20" required autofocus 
                        pattern="^([a-zA-Z0-9_ ]){8,20}*$" />
                    <label for="Password">Password</label><input name="password" id="password" type="password" maxlength="20" required 
                        pattern="(?=^.{8,20}$)^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$"/>
                  </p>
                  <span id="validationrules">${loginerror}</span>
                  <p>
                    <input name="loginbutton" id="loginbutton" style="margin-left: 2px;" class="formbutton" value="Login" type="submit" />
                  </p>

                </form>

              </fieldset>
            </div>
                
          </article>
    </section>
          
    <div class="clear"></div>
  </div> <!--end of body -->

  <jsp:directive.include file="/include/footer.html" />
</div>
</body>
</html>