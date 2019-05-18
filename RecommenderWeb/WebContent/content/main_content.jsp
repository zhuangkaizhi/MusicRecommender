<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>

<div    class="container">
	
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
	                    <img ng-src="{{obj.imageCover}}" 
	                         ng-click="playMusic(obj)"
	                         alt="{{obj.albumName}}" 
	                         class="carousel-img"/>
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
                        <img ng-src="{{obj.imageCover}}" 
                             ng-click="playMusic(obj)"
                             alt="{{obj.albumName}}" 
                             class="carousel-img"/>
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
                        <img ng-src="{{obj.imageCover}}" 
                             ng-click="playMusic(obj)"
                             alt="{{obj.albumName}}" 
                             class="carousel-img"/>
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
                    
                    <div ng-repeat="obj in recommendSlide3" class="col-sm-3">
                        <img ng-src="{{obj.imageCover}}" 
                             ng-click="playMusic(obj)"
                             alt="{{obj.albumName}}" 
                             class="carousel-img"/>
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
                        <img ng-src="{{obj.imageCover}}" 
                             ng-click="playMusic(obj)"
                             alt="{{obj.albumName}}" 
                             class="carousel-img"/>
                        <h6><a href="<%=basePath%>{{obj.detailLink}}">{{obj.albumName}}</a></h6>
                        <p>{{obj.albumDescribe}}</p>
                    </div>

                </div>
            </div>
            <!--/.Second slide-->
            <!--Third slide-->
            <div class="carousel-item">
                <div class="row carousel-row">
                    
                   <div ng-repeat="obj in recommendSlide1" class="col-sm-3">
                        <img ng-src="{{obj.imageCover}}" 
                             ng-click="playMusic(obj)"
                             alt="{{obj.albumName}}" 
                             class="carousel-img"/>
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
</div>


<div class="row playBar">
    <audio controls id ="myAudio">
       <source id="myAudioSrouce" src="" type="audio/mpeg">
    </audio>
</div>
