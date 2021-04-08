<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <!--<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">-->
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <!--최상단 아이콘 이미지-->
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/Logo.png">
   
    <title>We'Re Cycle</title>

    <!-- css파일-->
    <link href="${pageContext.request.contextPath}/resources/css/address.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
    
       <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
       <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
       <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

  </head>
  <body>
    
    <!-- 헤더부분.-->
    <header>

        <!-- 네비게이션바를 최상단에 고정, 및 밑색을 검정 글씨를 흰색으로 설정-->
        
        <nav class="navbar navbar-expand-fluid navbar-light fixed-top bg-light">
            
            <!--좌측상단 아이콘과, 아이콘의 크기-->
            <a href="home"><img src= "${pageContext.request.contextPath}/resources/images/We'Re Cycle.png" style="height:80px;"></a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <div class="container ">
                    <ul class="navbar-nav mr-sm-auto",class="nave nave-pills">
                        <li class="nav-item ">
                            <a class="nav-link" href="#" >재질별 분리배출 방법 </a> 
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="#" >최근이슈</a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="#">이벤트 정보</a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="#">친환경 매장</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link " href="#" style="color:rgb(82, 247, 6);">지역 정보</a>
                        </li>  
                        <li class="nav-item ">
                            <a class="nav-link" href="#">질문 게시판</a>
                        </li>  
                    </ul>
                   
                </div>
            </div>
        </nav>
    </header>
    <main>
        <div class="container main-border">
            <!--상단 검색바 -->
            <!-- 요부분에 전체 dropdown 목록 db에서 활용부탁드립니다.-->
            <!-- dropdown 목록& 검색기능 추가부탁드립니다.-->
            <form method="get" action="<c:url value="/facilities"/>">
            <div class="search">
                <select name="address" id="address">
                    <option value="none" selected>전체</option>
                    <c:forEach var="city" items="${cities}">
                    	<option value="${city.cityName}">${city.cityName}</option>
                    </c:forEach>
                </select>
             <input class="form-control ml-2 mr-2" type="text" placeholder="Search" aria-label="Search">
			 <button class="btn btn-outline-info" type="submit">Search</button>
            </div>
            <!-- 여기까지가 상단 검색기능-->
            
            <table class="opption table table-striped">
            <thead>
                <tr>
                    <th class="center_border">지역</th>
                    <th>전화번호</th>
                </tr>
            </thead>
            <!-- 여기서부터 지역 이름과 지역별 전화번호 불러와주세요! 
            임의로 정보 넣어둔겁니다 지우시고 저위치에 넣어주시면되요!
            <i>테그는 아이콘이니 그뒤에 한글/숫자만 지우시면 되요-->
            <tbody>
            
            <c:forEach var="facility" items="${facilities}">
                <tr>
                    <td class="center_border"><i class="fa fa-map-marker-alt fa-md"></i><c:out value="${facility.name}"/></td>
                    <td><i class="fa fa-phone-volume fa-md"></i><c:out value="${facility.tel}"/></td>
                </tr>
            </c:forEach>
            </tbody>
            </table>
            <!-- 여기까지 지역이름과, 지역별 전화번호-->
            <!-- 정보가 많으면 1페이지 2페이지 나오도록 설정하고 싶은데 여부분은 잘모르겠어서 나중에 찾아보도록 할게요-->
            <div class="controller text-center">
                <span>&#60</span>
                <a href="#" style="color:black"><span>1</span></a>
                <a href="#" style="color:black"><span>2</span></a>
                <a href="#" style="color:black"><span>3</span></a>
                <a href="#" style="color:black"><span>...</span></a>
                <span>&#62</span>
            </div>
            <!-- 여기까지가 정보 개수별 페이지-->
            </form>
        </div>
    </main>
  </body>
</html>