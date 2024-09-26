<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- ****** Categories Area Start ****** -->
    <section class="categories_area clearfix" id="about">
        <div class="container">
            <div class="row">
                <div class="col-12 col-md-6 col-lg-4">
                    <div class="single_catagory wow fadeInUp" data-wow-delay=".3s">
                        <img src="../img/catagory-img/1.jpg" alt="">
                        <div class="catagory-title">
                            <a href="#">
                                <h5>맛집</h5>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-md-6 col-lg-4">
                    <div class="single_catagory wow fadeInUp" data-wow-delay=".6s">
                        <img src="../img/catagory-img/2.jpg" alt="">
                        <div class="catagory-title">
                            <a href="#">
                                <h5>레시피</h5>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-md-6 col-lg-4">
                    <div class="single_catagory wow fadeInUp" data-wow-delay=".9s">
                        <img src="../img/catagory-img/3.jpg" alt="">
                        <div class="catagory-title">
                            <a href="#">
                                <h5>서울여행</h5>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ****** Categories Area End ****** -->

    <!-- ****** Blog Area Start ****** -->
    <section class="blog_area section_padding_0_80">
        <div class="container">
            <div class="row justify-content-center">
				<div class="col-12 col-lg-8">
					<div class="row">
						<!-- Single Post -->
						<div class="col-12">
							<div class="single-post wow fadeInUp" data-wow-delay=".2s">
								<!-- Post Thumb -->
								<div class="post-thumb">
									<img src="${rvo.poster }" alt=""
										style="width: 750px; height: 350px;">
								</div>
								<!-- Post Content -->
								<div class="post-content">
									<div class="post-meta d-flex">
										<div class="post-author-date-area d-flex">
											<!-- Post Author -->
											<div class="post-author">
												<a href="#">${rvo.chef }</a>
											</div>
											<!-- Post Date -->
											<div class="post-date">
												<a href="#">May 19, 2017</a>
											</div>
										</div>
										<!-- Post Comment & Share Area -->
										<div class="post-comment-share-area d-flex">
											<!-- Post Favourite -->
											<div class="post-favourite">
												<a href="#"><i class="fa fa-heart-o" aria-hidden="true"></i>
													10</a>
											</div>
											<!-- Post Comments -->
											<div class="post-comments">
												<a href="#"><i class="fa fa-comment-o"
													aria-hidden="true"></i> 12</a>
											</div>
											<!-- Post Share -->
											<div class="post-share">
												<a href="#"><i class="fa fa-share-alt"
													aria-hidden="true"></i></a>
											</div>
										</div>
									</div>
									<a href="#">
										<h2 class="post-headline">${rvo.title }</h2>
									</a>
									<p>${rvo.content }</p>
									<a href="#" class="read-more">Continue Reading..</a>
								</div>
							</div>
						</div>

						<c:forEach var="vo" items="${rList }" varStatus="s">
							<c:if test="${s.index<4 }">
								<!-- Single Post -->
								<div class="col-12 col-md-6">
									<div class="single-post wow fadeInUp" data-wow-delay=".4s">
										<!-- Post Thumb -->
										<div class="post-thumb">
											<img src="${vo.poster }" alt="">
										</div>
										<!-- Post Content -->
										<div class="post-content">
											<div class="post-meta d-flex">
												<div class="post-author-date-area d-flex">
													<!-- Post Author -->
													<div class="post-author">
														<a href="#">${vo.chef }</a>
													</div>
													<!-- Post Date -->
													<div class="post-date">
														<a href="#">May 19, 2017</a>
													</div>
												</div>
												<!-- Post Comment & Share Area -->
												<div class="post-comment-share-area d-flex">
													<!-- Post Favourite -->
													<div class="post-favourite">
														<a href="#"><i class="fa fa-heart-o"
															aria-hidden="true"></i> 10</a>
													</div>
													<!-- Post Comments -->
													<div class="post-comments">
														<a href="#"><i class="fa fa-comment-o"
															aria-hidden="true"></i> 12</a>
													</div>
													<!-- Post Share -->
													<div class="post-share">
														<a href="#"><i class="fa fa-share-alt"
															aria-hidden="true"></i></a>
													</div>
												</div>
											</div>
											<a href="#">
												<h4 class="post-headline">${vo.title }</h4>
											</a>
										</div>
									</div>
								</div>
							</c:if>
						</c:forEach>
						<!-- ******* List Blog Area Start ******* -->

						<!-- Single Post -->
						<c:forEach var="vo" items="${rList }" varStatus="s">
							<c:if test="${s.index>3 }">
								<div class="col-12">
									<div class="list-blog single-post d-sm-flex wow fadeInUpBig"
										data-wow-delay=".2s">
										<!-- Post Thumb -->
										<div class="post-thumb">
											<img src="${vo.poster }" alt="">
										</div>
										<!-- Post Content -->
										<div class="post-content">
											<div class="post-meta d-flex">
												<div class="post-author-date-area d-flex">
													<!-- Post Author -->
													<div class="post-author">
														<a href="#">${vo.chef }</a>
													</div>

												</div>
												<!-- Post Comment & Share Area -->
												<div class="post-comment-share-area d-flex">
													<!-- Post Favourite -->
													<div class="post-favourite">
														<a href="#"><i class="fa fa-heart-o"
															aria-hidden="true"></i> ${vo.hit }</a>
													</div>
													<!-- Post Comments -->
													<div class="post-comments">
														<a href="#"><i class="fa fa-comment-o"
															aria-hidden="true"></i> 12</a>
													</div>
													<!-- Post Share -->
													<div class="post-share">
														<a href="#"><i class="fa fa-share-alt"
															aria-hidden="true"></i></a>
													</div>
												</div>
											</div>
											<a href="#">
												<h4 class="post-headline">${vo.title }</h4>
											</a>
											<p>${vo.content }</p>
											<a href="#" class="read-more">Continue Reading..</a>
										</div>
									</div>
								</div>
							</c:if>
						</c:forEach>
					</div>
				</div>
				<!-- ****** Blog Sidebar ****** -->
                <div class="col-12 col-sm-8 col-md-6 col-lg-4">
                    <div class="blog-sidebar mt-5 mt-lg-0">
                        <!-- Single Widget Area -->
                        <div class="single-widget-area about-me-widget text-center">
                            <div class="widget-title">
                                <h6>오늘의 쉐프</h6>
                            </div>
                            <div class="about-me-widget-thumb">
                                <img src="${cvo.poster }" alt="">
                            </div>
                            <h4 class="font-shadow-into-light">${cvo.chef }</h4>
                        </div>
                        <!-- Single Widget Area -->
                        <div class="single-widget-area popular-post-widget">
                            <div class="widget-title text-center">
                                <h6>인기 맛집</h6>
                            </div>
                            <!-- Single Popular Post -->
                            <c:forEach var="vo" items="${fList }">
	                            <div class="single-populer-post d-flex">
	                                <img src="http://www.menupan.com${vo.poster }" alt="">
	                                <div class="post-content">
	                                    <a href="#">
	                                        <h6>${vo.name }</h6>
	                                    </a>
	                                    <p>${vo.address }</p>
	                                </div>
	                            </div>
                            </c:forEach>
                        </div>

                        <!-- Single Widget Area -->
                        <div class="single-widget-area add-widget text-center">
                            <div class="add-widget-area">
                                <img src="../img/sidebar-img/6.jpg" alt="">
                                <div class="add-text">
                                    <div class="yummy-table">
                                        <div class="yummy-table-cell">
                                            <h2>Cooking Book</h2>
                                            <p>Buy Book Online Now!</p>
                                            <a href="#" class="add-btn">Buy Now</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Single Widget Area -->
                        <div class="single-widget-area newsletter-widget">
                            <div class="widget-title text-center">
                                <h6>맛집 뉴스</h6>
                            </div>
                            <div class="newsletter-form">
                                <form action="#" method="post">
                                    <input type="text" name="newsletter-email" id="email" placeholder="뉴스를 검색하세요">
                                    <button type="button"><i class="fa fa-paper-plane-o" aria-hidden="true"></i></button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ****** Blog Area End ****** -->

</body>
</html>