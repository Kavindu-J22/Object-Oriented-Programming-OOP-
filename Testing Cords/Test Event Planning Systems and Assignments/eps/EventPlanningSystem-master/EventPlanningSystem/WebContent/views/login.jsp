<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
<link rel="shortcut icon" href="ico/favicon.png"> 
<!-- Core CSS -->         
<link href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"> 
<link href="<%=request.getContextPath()%>/resources/css/font-awesome.min.css" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,300,600,700" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet">
<!-- Style Library -->         
<link href="<%=request.getContextPath()%>/resources/css/style-library-1.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/plugins.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/blocks.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/custom.css" rel="stylesheet">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->         
 <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]--> 
</head>
<body data-spy="scroll" data-target="nav">
        <header id="header-3" class="soft-scroll header-3">
        	<section class="hero pad-bottom15">
            	<div class="container">
                	<div class="col-md-8 col-md-offset-2 text-center headerStyle">
                    	<div class="editContent">
                        	<h1 style="margin-top:0px;">Event Planning System</h1>
                   		</div>
                    	<div class="editContent">
                        	<p class="lead descp">Welcome to the one stop solution for planning your favorite events</p>
                    	</div>
                	</div>
            	</div>
            </section>
        </header>
        <section id="content-2-1" class="content-block content-2-1 bg-transparent bg-image-cover" style="background-image:url('<%=request.getContextPath()%>/resources/images/blur2.jpg');">
           <div class="row"> 
              <div class="col-md-12">
				<form class="bookingFormContainer mb-3" action="${pageContext.request.contextPath}/loggingController" method="POST">
					<div class="card">
						<div class="card-header"><h4 style="color: #F4E256; text-align : center;">Login In here</h4></div>
						<div class="card-body">
							<div class="form-group">
								<input type="text" name="email" class="form-control"
									placeholder="Enter email" autocomplete="off" />
							</div>
							<div class="form-group">
								<input type="password" name="password" class="form-control"
									placeholder="Enter Password" />
							</div>
						</div>
						<div class="card-footer text-center">
							<input type="submit" value="Login" class="btn btn-primary">
						</div>
					</div>
				</form>

			</div>                 
          </div>  
        </section>
        <section class="content-block-nopad bg-deepocean footer-wrap-1-3">
            <div class="container footer-1-3">
                <div class="col-md-4 pull-left">
                    <ul class="social social-light">
                        <li>
                            <a href="#"><i class="fa fa-2x fa-facebook"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-2x fa-twitter"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-2x fa-google-plus"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-2x fa-pinterest"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-2x fa-behance"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-2x fa-dribbble"></i></a>
                        </li>
                    </ul>
                    <!-- /.social -->
                </div>
                <div class="col-md-3 pull-right">
                    <p class="address-bold-line">We <i class="fa fa-heart pomegranate"></i> our amazing customers</p>
                    <p class="address small">SLIIT Malabe Campus,<br>New Kandy Road,<br>Malabe</p>
                </div>
                <div class="col-xs-12 footer-text">
                    <p>Please take a few minutes to read our <a href="#">Terms & Conditions</a> and <a href="#">Privacy Policy</a></p>
                </div>
            </div>
            <!-- /.container -->
        </section>
        <div class="copyright-bar bg-black">
            <div class="container text-center">
                <p class="small">©&nbsp; eventPlanningSystem</p>
            </div>
        </div>
         <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.11.1.min.js"></script>         
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>         
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/plugins.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bskit-scripts.js"></script>         
</body>
</html>