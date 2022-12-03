
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html> 
<html lang="en" style="height:100%;">
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
                    <div class="col-md-8 col-md-offset-2 text-center">
                        <div class="editContent">
                            <h1>Event Planning System</h1>
                        </div>
                        <div class="editContent">
                            <p class="lead headerP">Welcome to the one stop solution for planning your favorite events</p>
                        </div>
                    </div>
                    <div class="col-md-6 col-md-offset-3 text-center">
                        <div class="col-md-6">
                            <a href="#" class="btn btn-info btn-block">SIGN IN</a>
                        </div>
                        <div class="col-md-6">
                            <a href="<%=request.getContextPath()%>/views/login.jsp" class="btn btn-danger btn-block">Log IN</a>
                        </div>
                    </div>
                 </div>
             </section>
          </header>
          
       	<section id="content-1-3"
				class="content-block content-1-3 bg-image-cover"
				style="background-image:url('<%=request.getContextPath()%>/resources/images/descrback.jpg');">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<div class="underlined-title">
								<h1 class="deepocean featureSectionHeading">Every service
									under one roof</h1>
								<hr>
							</div>
							<div class="services-wrapper">
								<div class="col-md-4">
									<div class="icon bg-image-cover"
										style="background-image:url('<%=request.getContextPath()%>/resources/images/venueIcon.jpg')">
									</div>
									<h4 class="featureSectionOption">Venues</h4>
									<p class="featureSectionDesc">Check venue availability and
										select venues according to your requirement</p>
								</div>
								<div class="col-md-4">
									<div class="icon bg-image-cover"
										style="background-image:url('<%=request.getContextPath()%>/resources/images/Catering_Icon.jpg')">
									</div>
									<h4 class="featureSectionOption">Service Providers</h4>
									<p class="featureSectionDesc">Select services for the event
										you are going to plan from variety of Service Providers</p>
								</div>
								<div class="col-md-4">
									<div class="icon bg-image-cover"
										style="background-image:url('<%=request.getContextPath()%>/resources/images/eventPlan.jpg')">
									</div>
									<h4 class="featureSectionOption">Event Planning</h4>
									<p class="featureSectionDesc">Plan event according to your
										requirements</p>
								</div>
							</div>
						</div>
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container -->
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
    