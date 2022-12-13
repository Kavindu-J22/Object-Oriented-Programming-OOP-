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
		<%
			response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");		
			if(request.getSession(false).getAttribute("UserId") == null){
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/login.jsp");
				dispatcher.forward(request,response);
			}
		%>
        <!-- /.nav -->
        <header id="header-1" class="soft-scroll header-1">
            <!-- Navbar -->
            <nav class="main-nav navbar-fixed-top headroom headroom--pinned">
                <div class="container">
                    <!-- Brand and toggle -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                       <img src="<%=request.getContextPath()%>/resources/images/brand.png" class="brand-img img-responsive">
                    </div>
                    <!-- Navigation -->
                    <div class="collapse navbar-collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <li class="nav-item">
                                <a href="<%=request.getContextPath()%>/views/userHome.jsp">HOME</a>
                            </li>
                            <li class="nav-item">
                                <a href="<%=request.getContextPath()%>/views/addBooking.jsp">ADD BOOKING</a>
                            </li>
                            <li class="active nav-item">
                                <a href="<%=request.getContextPath()%>/listBookingsController">VIEW BOOKING</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false" href="#">Pages <i class="fa fa-angle-down"></i></a>
                                <ul class="dropdown-menu">
                                     <li>
                                        <a href="#">About Us</a>
                                    </li>
                                    <li>
                                        <a href="#">Contact Us</a>
                                    </li>
                                    <li>
                                        <a href="#">Terms And Conditions</a>
                                    </li>
                                    <li>
                                        <a href="#">Privacy Policy</a>
                                    </li>
                                </ul>                                 
                            </li>
                            <!--//dropdown-->                             
                            <li class="nav-item">
                                <a href="<%=request.getContextPath()%>/views/logOut.jsp">LOG OUT</a>
                            </li>
                        </ul>
                        <!--//nav-->
                    </div>
                    <!--// End Navigation -->
                </div>
                <!--// End Container -->
            </nav>
            <!--// End Navbar -->
        </header>
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
       	<section id="content-2-1" class="content-block content-2-1 bg-deepocean bg-image-cover" style="background-image:url('<%=request.getContextPath()%>/resources/images/blur2.jpg');">
            <table class="table white bg-sienna-hover"> 
                <thead> 
                    <tr> 
                      <th>Event Name</th>
					  <th>Event Type</th>
					  <th>Event Date</th>
					  <th>Starting Time</th>
					  <th>Ending Time</th>
					  <th>No of Participants</th>
					  <th>Venue Booked</th>
					  <th>Meals</th>
					  <th>Decorations</th>
					  <th>Sounds and Lightings</th>
					  <th>Total Cost</th>
					  <th>Action</th>
					  <th>Status</th>
					</tr>                     
                </thead>                 

                <tbody> 
                <c:forEach items="${UserBookings}" var="bookings">
                    <tr> 
                       <td>${bookings.getEventName()}</td>
					   <td>${bookings.getEventType()}</td>
					   <td>${bookings.getEventDate()}</td>
					   <td>${bookings.getStartingTime()}</td>
					   <td>${bookings.getEndingTime()}</td>
					   <td>${bookings.getNoOfParticipants()}</td>
					   <td>${bookings.getVenueName()}</td>
					   <td>${bookings.getMeals()}</td>
					   <td>${bookings.getDecoration()}</td>
					   <td>${bookings.getSoundLighting()}</td>
					   <td>${bookings.getTotalCost()}</td>
					   <td>
						<form method="POST" action="${pageContext.request.contextPath}/UpdateBookingsController">
							<input type="hidden" name="BookingID" value="${bookings.getBookingID()}"></input> 
							<input type="hidden" name="redirectAction" value="redirectToUpdateBooking1"></input>
							<button class="btn btn-info" type="submit">Update</button>
						</form>

						<form method="POST" action="${pageContext.request.contextPath}/DeleteBookingsController">
							<input type="hidden" name="BookingID" value="${bookings.getBookingID()}"></input>
							<input type="hidden" name="VenueID" value="${bookings.getVenueID()}"></input>
							<input type="hidden" name="EventDate" value="${bookings.getEventDate()}"></input>
							<button class="btn btn-danger" type="submit">Delete</button>
						</form>
					   </td>
					<td>${bookings.getBookingStatus()}</td>
				  </tr>                     
				</c:forEach>
                              
                </tbody>
            </table>
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