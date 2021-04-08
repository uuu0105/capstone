<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
    <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" type="text/css" >
    <link rel="canonical" href="https://getbootstrap.com/docs/4.6/examples/carousel/">

       <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
       <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
       <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

   
  </head>
<body onload="time()">
    <script>
        $(function () {
            $('[data-toggle="tooltip"]').tooltip()
          })
    </script>
        <!--상단 로고,카메라 기능-->
      <div class="container">
        <div class="background text-center">
            
            <div class="Logo">
                <a href="#"><img src= "${pageContext.request.contextPath}/resources/images/We'Re Cycle.png" style="max-width:100%; height:auto;"></a>
            </div>
            <div class="container">
                <div class="card-group menu">
                    <div class="card">
                        <img src="${pageContext.request.contextPath}/resources/images/camera.png" alt="Card image" style="max-width:100%; height:auto;" >                               
                    </div>
                    <div class="card">
                        <img src="${pageContext.request.contextPath}/resources/images/upload.png" alt="Card image"style="max-width:100%; height:auto;" >                         
                    </div>
                    
                </div>
            </div>
        <!-- 카페고리 구분-->
                <!-- Three columns of text below the carousel -->
            <div class="container ">
                <div class="row ">
                    <div class="col-lg-4 col-sm-2">
                            <div class="card ">    
                                <img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/분리배출.png" data-toggle="tooltip" title="재질별 분리수거 방법"alt="Card image" >                                 
                                <div class="d-none d-lg-block">
                                    <div class="card-body ">
                                        <button type="button" class="btn btn-block btn-dark">재질별 분리수거 방법</button>
                                    </div>
                                    </div>
                            </div>
                        
                    </div>
                    <div class="col-lg-4 col-sm-2">
                        <div class="card">    
                            <img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/이슈.png" alt="Card image" data-toggle="tooltip" title="최근 이슈">                                 
                            <div class="d-none d-lg-block">
                                <div class="card-body">
                                    <button type="button" class="btn btn-block btn-dark">최근 이슈</button>
                                </div>
                             </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-sm-2">
                        <div class="card">    
                            <img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/이벤트.png" alt="Card image" data-toggle="tooltip" title="이벤트 정보">                                 
                            <div class="d-none d-lg-block">
                                <div class="card-body">
                                    <button type="button" class="btn btn btn-block btn-dark">이벤트 정보</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-sm-2">
                        <div class="card">    
                            <img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/매장.png" alt="Card image" data-toggle="tooltip" title="친환경 매장">                                 
                            <div class="d-none d-lg-block">
                                <div class="card-body">
                                    <button type="button" class="btn btn-md btn-block btn-dark">친환경 매장</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-sm-2">
                        <div class="card">
                            <a href="facilities"><img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/위치.png" alt="Card image" data-toggle="tooltip" title="지역 정보"> </a>                            
                            <div class="d-none d-lg-block">
                                <div class="card-body">
                                    <button type="button" class="btn btn-md btn-block btn-dark" onclick="location.href='${pageContext.request.contextPath}/facilities'">지역 정보</button>
                                </div>
                            </div>
                        </div>   
                    </div>       
                    <div class="col-lg-4 col-sm-2">
                        <div class="card">    
                            <img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/QA.png" alt="Card image" data-toggle="tooltip" title="질문 게시판">                                 
                            <div class="d-none d-lg-block">
                                <div class="card-body">
                                    <button type="button" class="btn btn-md btn-block btn-dark">질문 게시판</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card" >
                    <script language="javascript">
                        function time(){
                         var time= new Date(); //시간받기위해서 new date
                             document.getElementById("now").innerHTML=time.getHours()+"시"+time.getMinutes()+"분"+time.getSeconds()+"초";
                            setInterval("time()",1000);     //1초 지난후 time()실행
                         }
                    </script>
                    <h2> 현재 시간: <span id="now"></span></h2>
                    </div>


            </div>
        </div>
      </div> 
</body>

    
  
       
   


</html>
