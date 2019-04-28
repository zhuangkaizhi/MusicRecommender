<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
    <!-- Angular JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
    <script src="<%=basePath%>/js/content_manager.js"></script>
</head>
<body>
<div    class="container" 
        ng-app="contentManager" 
        ng-controller="contentController" 
        ng-init="loadRecommendAlbum()">
	
	<!-- >table style="border: thick; border-width: 5px; background-color: blue;" >
        <tr ng-repeat="obj in recommendItems">
            <td>{{obj.albumId}}</td>

            <td>{{obj.albumName}}</td>
        </tr>

    </table -->
    
    <!-- First Row -->
    <div class="row">
        
        <div class="carouselTitle">
            <div class="carouselTitle-title"><h4>Recommended Music</h4></div>
            <div class="carouselTitle-control">
                <!--Controls-->
                <a class="carousel-control-prev" href="#carouselRecommend" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <!-- i class="fas fa-chevron-left"></i -->
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselRecommend" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <!-- i class="fas fa-chevron-right"></i -->
                    <span class="sr-only">Next</span>
                </a>
                <!--/.Controls-->
            </div>
        </div>
        <div class="line"></div>
        
        <div id="carouselRecommend" class="carousel slide carousel-muti-items" 
             data-ride="carousel" 
             data-interval="false">
          
          <!--Indicators-->
          <ol class="carousel-indicators">
            <li data-target="#carouselRecommend" data-slide-to="0" class="active"></li>
            <li data-target="#carouselRecommend" data-slide-to="1"></li>
            <li data-target="#carouselRecommend" data-slide-to="2"></li>
          </ol>
          <!--/.Indicators-->
          
          <!--Slides-->
          <div class="carousel-inner" role="listbox">
            <!--First slide-->
            <div class="carousel-item active">
                <div class="row carousel-row">
                    <div ng-repeat="obj in recommendSlide1" class="col-sm-3">
	                    <img ng-src="{{obj.imageCover}}" alt="{{obj.albumName}}" class="carousel-img"/>
                        <h6><a href="<%=basePath%>{{obj.detailLink}}">{{obj.albumName}}</a></h6>
                        <p>{{obj.albumDescribe}}</p>
                    </div>
                </div>
            </div>
            <!--/.First slide-->
            <!--Second slide-->
            <div class="carousel-item">
                <div class="row carousel-row">
                    
                    <div ng-repeat="obj in recommendSlide2" class="col-sm-3">
                        <img ng-src="{{obj.imageCover}}" alt="{{obj.albumName}}" class="carousel-img"/>
                        <h6><a href="<%=basePath%>{{obj.detailLink}}">{{obj.albumName}}</a></h6>
                        <p>{{obj.albumDescribe}}</p>
                    </div>
                    
                </div>
            </div>
            <!--/.Second slide-->
            <!--Third slide-->
            <div class="carousel-item">
                <div class="row carousel-row">
                    
                    <div ng-repeat="obj in recommendSlide3" class="col-sm-3">
                        <img ng-src="{{obj.imageCover}}" alt="{{obj.albumName}}" class="carousel-img"/>
                        <h6><a href="<%=basePath%>{{obj.detailLink}}">{{obj.albumName}}</a></h6>
                        <p>{{obj.albumDescribe}}</p>
                    </div>
                    
                </div>
            </div>
            <!--/.Third slide-->
            
          </div>
          <!--/.Slides-->
           
          
          
        </div>
    
    </div>

    <!-- Second Row -->
    <div class="row">
        <div class="carouselTitle">
            <div class="carouselTitle-title"><h4>Popular Music</h4></div>
            <div class="carouselTitle-control">
              <!--Controls-->
              <a class="carousel-control-prev" href="#carouselPopular" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <!-- i class="fas fa-chevron-left"></i -->
                    <span class="sr-only">Previous</span>
              </a>
              <a class="carousel-control-next" href="#carouselPopular" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <!-- i class="fas fa-chevron-right"></i -->
                    <span class="sr-only">Next</span>
              </a>
              <!--/.Controls-->
            </div>
        </div>
        <div class="line"></div>
        
        <div id="carouselPopular" class="carousel slide carousel-muti-items" 
             data-ride="carousel"
             data-interval="false">
          <!--Indicators-->
          <ol class="carousel-indicators">
            <li data-target="#carouselPopular" data-slide-to="0" class="active"></li>
            <li data-target="#carouselPopular" data-slide-to="1"></li>
            <li data-target="#carouselPopular" data-slide-to="2"></li>
          </ol>
          <!--/.Indicators-->
          
          <!--Slides-->
          <div class="carousel-inner" role="listbox">
            <!--First slide-->
            <div class="carousel-item active">
                <div class="row carousel-row">
                    
                    <div class="col-sm-3">
                      <img class="carousel-img" 
                           src="https://cdns-images.dzcdn.net/images/cover/2e018122cb56986277102d2041a592c8/250x250-000000-80-0-0.jpg" 
                           alt="1 slide"/>
                      <h6><a href="http://www.google.com">AAAAAAAA</a></h6>
                      <p>This is an example of an Artist and Album</p>
                    </div>
                    
                </div>
            </div>
            <!--/.First slide-->
            <!--Second slide-->
            <div class="carousel-item">
                <div class="row carousel-row">

                    <div class="col-sm-3">
                      <img class="carousel-img" 
                           src="https://cdns-images.dzcdn.net/images/cover/2e018122cb56986277102d2041a592c8/250x250-000000-80-0-0.jpg" 
                           alt="1 slide"/>
                      <h6><a href="http://www.google.com">AAAAAAAA</a></h6>
                      <p>This is an example of an Artist and Album</p>
                    </div>

                </div>
            </div>
            <!--/.Second slide-->
            <!--Third slide-->
            <div class="carousel-item">
                <div class="row carousel-row">
                    
                    <div class="col-sm-3">
                      <img class="carousel-img" 
                           src="https://cdns-images.dzcdn.net/images/cover/2e018122cb56986277102d2041a592c8/250x250-000000-80-0-0.jpg" 
                           alt="1 slide"/>
                      <h6><a href="http://www.google.com">AAAAAAAA</a></h6>
                      <p>This is an example of an Artist and Album</p>
                    </div>

                </div>
            </div>
            <!--/.Third slide-->
          </div>
          <!--/.Slides-->
        </div>
    </div>
    
    
    
</div>
</body>
</html>