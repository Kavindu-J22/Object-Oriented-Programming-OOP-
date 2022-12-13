<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>XPERT Events - Contact Us</title>
<link rel="stylesheet" href="css/styles.css" type="text/css" />
<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0" />
</head>
<body>
<div id="container">

  <jsp:directive.include file="/include/header.jsp" />

  <div id="body" class="width">
    <jsp:directive.include file="/include/sidemenu.jsp" />

    <section id="content" class="two-column">
         <article>
            
                <h2>Contact Us</h2>

                <div id="main-content" >
                  <form action="" method="post" name="contactus" class="two-column">
                    <table width="200" border="0" align="center">
                      <tr>
                        <td width="38%"><label id="1">First Name</label>&nbsp;</td>
                        <td width="62%"><input type="text" name="firstname" id="1"></td>
                      </tr>
                      <tr>
                        <td><label id="2">Last Name</label>&nbsp;</td>
                        <td><input type="text" name="lastname" id="2"></td>
                      </tr>
                      <tr>
                        <td><label id="3">Email Address</label>&nbsp;</td>
                        <td><input type="email" name="emailadd" id="3"></td>
                      </tr>
                      <tr>
                        <td><label id="4">Query</label>&nbsp;</td>
                        <td><textarea name="query" id="4"></textarea></td>
                      </tr>
                      <tr>
                        <td><input type="submit" style="margin-left: 2px;" class="formbutton" id="login-button" value="Submit" />&nbsp;</td>
                        <td>&nbsp;</td>
                      </tr>
                    </table>
                  </form>
                </div> <!-- end of main-content -->
                
          </article>
    </section>
 
    	<div class="clear"></div>
  </div> <!--end of body -->

  <jsp:directive.include file="/include/footer.html" />
</div>
</body>
</html>