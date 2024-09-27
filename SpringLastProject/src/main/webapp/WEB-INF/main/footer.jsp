<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- ****** Cookie Start ****** -->
    <div class="instargram_area owl-carousel section_padding_100_0 clearfix" id="portfolio">
       <c:forEach var="vo" items="${cList }">
        <!-- Instagram Item -->
        <div class="instagram_gallery_item">
            <!-- Instagram Thumb -->
            <img src="http://www.menupan.com${vo.poster }" alt="">
            <!-- Hover -->
            <div class="hover_overlay">
                <div class="yummy-table">
                    <div class="yummy-table-cell">
                        <div class="follow-me text-center">
                            <a href="../food/detail.do?fno=${vo.fno }"><i class="fa fa-instagram" aria-hidden="true"></i> ${vo.name }</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>
     </div>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <!-- Copywrite Text -->
                    <div class="copy_right_text text-center">
                        <p>제작 : 강북쌍용교육센터<i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">D강의장</a></p>
                    </div>
                </div>
            </div>
        </div>
    </footer>
</body>
</html>