<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*"%>
<%@ page import ="javax.naming.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="refresh" content="600; url=controller?command=Main"></meta>
    
<%@ include file ="header.jsp" %>

<!-- 추천 게시판1 -->
<section class="about py-5" id="about">
	 <div class="notice01">
                    <h2>高評価</h2>
                    <div class="list_box">
                        <ul>
                        <c:forEach var="best" items="${Best}" begin="0" step="1" end="5" >
                            <li><a href="#">${best.title}</a><span class="date">${best.writedate }</span></li>
						</c:forEach>
                        </ul>
                        <a href="#" class="btn_more" title="더보기">더보기 +</a> </div>
                </div>
</section>
<!-- //추천 게시판 -->

<!-- 추천 게시판1 -->
<section class="about py-5" id="about">
	 <div class="notice01">
                    <h2>低評価</h2>
                    <div class="list_box">
                        <ul>
                        <c:forEach var="worst" items="${Worst}" begin="0" step="1" end="5">
                            <li><a href="#">${worst.title }</a><span class="date">${worst.writedate }</span></li>
						</c:forEach>
                        </ul>
                        <a href="#" class="btn_more" title="더보기">더보기 +</a> </div>
                </div>
</section>
<!-- //추천 게시판 -->

<!-- 추천 게시판1 -->
<section class="about py-5" id="about">
	 <div class="notice01">
                    <h2>アホ</h2>
                    <div class="list_box">
                        <ul>
                        <c:forEach var="aho" items="${Aho}" begin="0" step="1" end="5">
                            <li><a href="#">${aho.title }</a><span class="date">${aho.writedate }</span></li>
						</c:forEach>
                        </ul>
                        <a href="#" class="btn_more" title="더보기">더보기 +</a> </div>
                </div>
</section>
<!-- //추천 게시판 -->




<%@ include file ="popup.jsp" %>
<%@ include file ="footer.jsp" %>