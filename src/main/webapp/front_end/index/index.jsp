<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="com.*"%>
<%@ page import="com.member.model.MemberVO"%>
<%@ page import="com.store.model.StoreService"%>
<%@ page import="com.store.model.StoreVO"%>
<% 
HttpSession ss = request.getSession();
// String account = (String)ss.getAttribute("account");
// String account1 = (String)ss.getAttribute("account");
MemberVO member = (MemberVO)ss.getAttribute("account");

StoreService sc = new StoreService();
List<StoreVO> all = sc.getAll();
%>

<!doctype html>
<html lang="zh-tw">

<head>
  <title>Family Rent</title>
  <link rel="icon" href="<%= request.getContextPath()%>/html/icon/pngkey.com-gps-icon-png-5131691.png" type="image/x-icon" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700;900&display=swap" rel="stylesheet">

  <link rel="stylesheet" href="<%= request.getContextPath()%>/html/css/bootstrap-datepicker.css">

  <!-- 自己的css -->
  <link rel="stylesheet" href="<%= request.getContextPath()%>/html/css/head.css">
  <!-- MAIN CSS -->
  <link rel="stylesheet" href="<%= request.getContextPath()%>/html/css/style.css">
  <link rel="stylesheet" href="<%= request.getContextPath()%>/html/css/bootstrap.min.css">
  <link rel="stylesheet" href="<%= request.getContextPath()%>/html/css/jquery.datetimepicker.css">
  <style>
    @import url('https://fonts.googleapis.com/css2?family=Koulen&family=Teko:wght@300&display=swap');
  </style>

</head>

<body>


  <div class="site-wrap" id="home-section">
    <header class="site-navbar site-navbar-target" id="head" role="banner">
      <div class="container">
        <div class=" align-items-center logo">
          <div class="site-logo">
            <a href="/CGA102G4/index" class="nav-link">
              <h1 style="font-family: 'Koulen', cursive;font-size: 50px;">Family Rent</h1>
            </a>
          </div>


          <nav class="site-navigation text-right ml-auto d-none d-lg-block" role="navigation">
            <ul class="site-menu main-menu js-clone-nav ml-auto ">
              <li><a href="index.html" class="nav-link menuStyle">首頁</a></li>
              <li id="ch">
                <a href="" class="nav-link menuStyle" id="dropdownMenuLink" role="button" data-bs-toggle="dropdown"
                  style="padding-bottom: 0px;">租車</a>
                <ul class="dropdown-menu " aria-labelledby="dropdownMenuLink">
                  <li><a class="dropdown-item" href="#">立即看車</a></li>
                  <li><a class="dropdown-item" href="#">預約賞車</a></li>
                  <li><a class="dropdown-item" href="#">Something else here</a></li>
                </ul>
              </li>
              <li>
                <a href="" class="nav-link menuStyle" id="dropdownMenuLink" role="button" data-bs-toggle="dropdown"
                  style="padding-bottom: 0px;">中古車</a>
                <ul class="dropdown-menu " aria-labelledby="dropdownMenuLink">
                  <li><a class="dropdown-item" href="#">立即看車</a></li>
                  <li><a class="dropdown-item" href="#">預約賞車</a></li>
                  <li><a class="dropdown-item" href="#">Something else here</a></li>
                </ul>
              </li>
              <li><a href="" class="nav-link menuStyle" role="button">會員中心</a>
              </li>
              <li><a href="about.html" class="nav-link menuStyle">最新消息</a></li>
             <c:if test="${account == null}">
              	<li><a href="login.html" class="nav-link menuStyle">登入</a></li>
              </c:if>
              <c:if test="${account != null}">
              	  <li><a href="#" class="nav-link menuStyle"><%=member.getMeb_name()%></a></li>
            	  <li><a href="<%=request.getContextPath()%>/login" class="nav-link menuStyle">登出</a></li>
              </c:if>
              
            </ul>
          </nav>
        </div>
      </div>

    </header>


    <div class="hero" style="background-image: url('html/img/hero_1_a.jpg');">

      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-lg-8">
            <div class="row mb-5">
              <div class="col-lg-8 intro">
                <h1>租車</h1>
                <h2>更快，更方便，您的租車新選擇</h2>
              </div>
            </div>

            <form class="re-form" >
              <div class="row" style="align-items: center">
                <div style="width: 150px;">
                <p style="margin-bottom: 0px;">取車地點</p>
                  <select name="" id="" class="custom-select form-control">
                    <option value="">取車地點</option>
                 <c:forEach items="<%=all%>" var="store">
                 	<option value="${store.st_no}">${store.st_name}</option>
                 </c:forEach>
                  </select>
                </div>
                <div style="width: 150px;">
                <p style="margin-bottom: 0px;">還車地點</p>
                  <select name="" id="" class="custom-select form-control">
                    <option value="">還車車地點</option>
                 <c:forEach items="<%=all%>" var="store">
                 	<option value="${store.st_no}">${store.st_name}</option>
                 </c:forEach>
                  </select>
                </div>
                <div style="width: 200px;">
                  <div class="form-control-wrap">
                  <p style="margin-bottom: 0px;">租車時間</p>
                    <input type="Date" id="cf-3" placeholder="租車時間" class="form-control datepicker px-3">
                    <span class="icon icon-date_range"></span>

                  </div>
                </div>
                <div style="width: 200px;">
                  <div class="form-control-wrap">
                  <p style="margin-bottom: 0px;">還車時間</p>
                    <input type="Date" id="end" placeholder="還車時間" class="form-control datepicker px-3" required>
                    <span class="icon icon-date_range"></span>
                  </div>
                </div>
                <div style="width: 150px;">
                  <input type="submit" value="我要租車" class="btn btn-primary btn-block py-3" style="border-radius: 40px;">
                </div>
              </div>

            </form>

          </div>
        </div>
      </div>
    </div>




  </div>
  <div class="site-section">
    <div class="container">
      <h2 class="section-heading"><strong>如何租車?</strong></h2>
      <p class="mb-5">讓你有更好租車體驗</p>

      <div class="row mb-5">
        <div class="col-lg-4 mb-4 mb-lg-0">
          <div class="step">
            <span>1</span>
            <div class="step-inner">
              <span class="number text-primary">01.</span>
              <h3>選擇你想要的車輛</h3>
              <p>依照你喜好選擇車輛，時間，地點</p>
            </div>
          </div>
        </div>
        <div class="col-lg-4 mb-4 mb-lg-0">
          <div class="step">
            <span>2</span>
            <div class="step-inner">
              <span class="number text-primary">02.</span>
              <h3>送出你的訂單</h3>
              <p>可以查看訂單詳情，費用計算</p>
            </div>
          </div>
        </div>
        <div class="col-lg-4 mb-4 mb-lg-0">
          <div class="step">
            <span>3</span>
            <div class="step-inner">
              <span class="number text-primary">03.</span>
              <h3>付款</h3>
              <p>使用信用卡付款</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="site-section bg-light">
    <div class="container">
      <div class="row">
        <div class="col-lg-7">
          <h2 class="section-heading" style="font-size: 40px;font-weight:bold;">車輛</h2>
          <p class="mb-5" style="font-size: 15px;font-weight:bold;">選擇你要的車輛</p>
        </div>
      </div>

    <div class="row">
    
    
    
	
    <c:forEach items="${carList}" var="car">
    	<div class="col-md-6 col-lg-4 mb-4">
                <div class="listing d-block  align-items-stretch">
                  <div class="listing-img h-100 mr-4">
                    <img src="<%=request.getContextPath()%>/index?model_no=${car.model_no}" alt="Image" class="img-fluid" style="width: 500px; height:250px">
                  </div>
                  <div class="listing-contents h-100">
                    <h3>${car.model_name} ${car.model_no}</h3>
                    <div class="rent-price">
                      <strong>${car.model_price}</strong><span class="mx-1">/</span>日
                    </div>
                    <div class="d-block d-md-flex mb-3 border-bottom pb-3"
                      style="padding-top: 16px; justify-content: space-between;">
                      <div>
                        <span>行李:</span>
                        <span class="number">${car.model_baggage}</span>
                      </div>
                      <div>
                        <span>CC數:</span>
                        <span class="number">${car.model_cc}</span>
                      </div>
                      <div>
                        <span>人數:</span>
                        <span class="number">${car.model_seats}</span>
                      </div>
                    </div>
                    <div>
                      <p style="height: 100px;">
                      ${car.car_info}
                      </p>
                      <p><a href="#" class="btn btn-primary btn-sm">租車</a></p>
                    </div>
                  </div>
                </div>
              </div>
               
              
    </c:forEach>
    
    
        <%-- <% 
          List<CarModelVO> att = (List) request.getAttribute("carList");
        for(int i = 0; i < att.size(); i++) { %>
              <div class="col-md-6 col-lg-4 mb-4">
                <div class="listing d-block  align-items-stretch">
                  <div class="listing-img h-100 mr-4">
                    <img src="<%=request.getContextPath()%>/carModelServlet?model_no=<%=att.get(i).getModel_no()%>" alt="Image" class="img-fluid" style="width: 500px; height:250px" >
                  </div>
                  <div class="listing-contents h-100">
                    <h3><%=att.get(i).getModel_name()%> <%=att.get(i).getModel_no()%></h3>
                    <div class="rent-price">
                      <strong>$<%=att.get(i).getModel_price()%></strong><span class="mx-1">/</span>日
                    </div>
                    <div class="d-block d-md-flex mb-3 border-bottom pb-3"
                      style="padding-top: 16px; justify-content: space-between;">
                      <div>
                        <span>行李:</span>
                        <span class="number"><%=att.get(i).getModel_baggage()%></span>
                      </div>
                      <div>
                        <span>CC數:</span>
                        <span class="number"><%=att.get(i).getModel_cc()%></span>
                      </div>
                      <div>
                        <span>人數:</span>
                        <span class="number"><%=att.get(i).getModel_seats()%></span>
                      </div>
                    </div>
                    <div>
                      <p style="height: 100px;">
                      <%=att.get(i).getCar_info()%>
                      </p>
                      <p><a href="#" class="btn btn-primary btn-sm">租車</a></p>
                    </div>
                  </div>
                </div>
              </div>
            <%
            }
          %> --%>
      </div>
    </div>
  </div>


  <footer class="site-footer">
    <div class="container">
      <div class="" style="display:flex; justify-content: center;">

        <div class="col-lg-8">
          <div class="row">
            <div class="col-lg-3">
              <h2 class="footer-heading mb-4">Quick Links</h2>
              <ul class="list-unstyled">
                <li><a href="#">About Us</a></li>
                <li><a href="#">Testimonials</a></li>
                <li><a href="#">Terms of Service</a></li>
                <li><a href="#">Privacy</a></li>
                <li><a href="#">Contact Us</a></li>
              </ul>
            </div>
            <div class="col-lg-3">
              <h2 class="footer-heading mb-4">Resources</h2>
              <ul class="list-unstyled">
                <li><a href="#">About Us</a></li>
                <li><a href="#">Testimonials</a></li>
                <li><a href="#">Terms of Service</a></li>
                <li><a href="#">Privacy</a></li>
                <li><a href="#">Contact Us</a></li>
              </ul>
            </div>
            <div class="col-lg-3">
              <h2 class="footer-heading mb-4">Support</h2>
              <ul class="list-unstyled">
                <li><a href="#">About Us</a></li>
                <li><a href="#">Testimonials</a></li>
                <li><a href="#">Terms of Service</a></li>
                <li><a href="#">Privacy</a></li>
                <li><a href="#">Contact Us</a></li>
              </ul>
            </div>
            <div class="col-lg-3">
              <h2 class="footer-heading mb-4">Company</h2>
              <ul class="list-unstyled">
                <li><a href="#">About Us</a></li>
                <li><a href="#">Testimonials</a></li>
                <li><a href="#">Terms of Service</a></li>
                <li><a href="#">Privacy</a></li>
                <li><a href="#">Contact Us</a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <div class="row pt-5 mt-5 text-center">
        <div class="col-md-12">
          <div class="border-top pt-5">
            <p>
              Family Rent &copy;
              <script>document.write(new Date().getFullYear());</script>
            </p>
          </div>
        </div>

      </div>
    </div>
  </footer> 

  


  
  <script src="<%= request.getContextPath()%>/html/js/jquery-3.3.1.min.js"></script>
  <script src="<%= request.getContextPath()%>/html/js/bootstrap-datepicker.min.js"></script>
  <script src="<%= request.getContextPath()%>/html/js/jquery.datetimepicker.full.min.js"></script>
  <script
    src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/locales/bootstrap-datepicker.zh-CN.min.js"></script>
  <script src="<%= request.getContextPath()%>/html/js/bootstrap.bundle.min.js"></script>
  <script>

    // $("#cf-3").datepicker({ //日曆
    //   format: 'yyyy/mm/dd',
    //   startDate: '-0d',
    //   endDate: '+3m',
    //   language: 'zh-CN'
    // });

    // $("#cf-4").datepicker({
    //   format: 'yyyy/mm/dd',
    //   startDate: '-0d',
    //   endDate: '+3m'
    // });
    

    $('#cf-3').datetimepicker({
    	format:'Y-m-d', //設定日期 時間 格式
      timepicker:false,
      minDate: '-1970/01/01',// 設定當下日期
      maxDate: '+1970/03/03',// 限制最大可租日 3個月
      minTime: '8:00', //設定最小時間
      maxTime: '21:00', //設定最大時間 晚上8點
    });
    $.datetimepicker.setLocale('zh-TW');// 設定中文
    let day = '0';
    let date = '0';
    if(new Date().getUTCDate()>=10){
    	day = '';
    }else if((new Date().getMonth()+1) >= 10){
    	date = '';
    }
    
    let min = new Date().getFullYear() +'-'+date+(new Date().getMonth()+1)+'-'+day+new Date().getUTCDate();
    let max = new Date().getFullYear() +'-'+date+(new Date().getMonth()+4)+'-'+day+new Date().getUTCDate();
    $('#end').attr('min',min);
    $('#end').attr('max',max);
  </script>
</body>

</html>



