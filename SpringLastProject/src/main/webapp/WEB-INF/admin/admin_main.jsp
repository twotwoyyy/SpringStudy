<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title -->
<title>SpringLastProject</title>

<!-- Favicon -->
<link rel="icon" href="../img/core-img/favicon.ico">

<!-- Core Stylesheet -->
<link href="../css/style.css" rel="stylesheet">

<!-- Responsive CSS -->
<link href="../css/responsive/responsive.css" rel="stylesheet">

<!-- Vue js -->
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>

<body>
    <!-- Preloader Start -->
    <!-- 
    <div id="preloader">
        <div class="yummy-load"></div>
    </div>
   -->
   
    <!-- Background Pattern Swither -->
    <div id="pattern-switcher">
        Bg Pattern
    </div>
    <div id="patter-close">
        <i class="fa fa-times" aria-hidden="true"></i>
    </div>

    <!-- ****** Top Header Area Start ****** -->
    <tiles:insertAttribute name="header"/>
    <!-- ****** Header Area End ****** -->
    <!-- ****** Breadcumb Area Start ****** -->
    <div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>관리자페이지</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="breadcumb-nav">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home" aria-hidden="true"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">관리자페이지</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <section class="archive_area section_padding_80">
        <div class="container">
            <div class="row">
            <!-- ****** Home Start ****** -->
            <div class="col-sm-4">
               <tiles:insertAttribute name="admin_menu"/>
            </div>
            <div class="col-sm-8">
               <tiles:insertAttribute name="admin_home"/>
            </div>
            <!-- ****** Home End ****** -->            
            </div>
        </div>
    </section>

   <!-- ****** Footer Start ****** -->
   <tiles:insertAttribute name="footer"/>
   <!-- ****** Footer End ****** -->

    <!-- Jquery-2.2.4 js -->
    <script src="../js/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="../js/bootstrap/popper.min.js"></script>
    <!-- Bootstrap-4 js -->
    <script src="../js/bootstrap/bootstrap.min.js"></script>
    <!-- All Plugins JS -->
    <script src="../js/others/plugins.js"></script>
    <!-- Active JS -->
    <script src="../js/active.js"></script>
</body>