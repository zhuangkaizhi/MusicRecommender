/**
 * If you want to call one controller into another there are four methods available
    $rootScope.$emit() and $rootScope.$broadcast()
    If Second controller is child ,you can use Parent child communication .
    Use Services
    Kind of hack - with the help of angular.element()
*/
var urlBase="http://localhost:8080/recommender";
var homeModule = angular.module('homeManager', ['ngAnimate']);
var sessionUserId = "userId";
var sessionUserName = "userName";
var contentMainPage = "content/main_content.jsp";
var contentSignInPage = "user/signIn.jsp";
var contentSignUpPage = "user/signUp.jsp";


homeModule.factory('mySharedService', function($rootScope) 
{
  var sharedService = {};
  sharedService.contentPageName = '';
  sharedService.prepForRederectContentPage = function(pageName) 
  {
    this.contentPageName = pageName;
    $rootScope.$broadcast('broadcastContentPage');
  };
  
  return sharedService;
});


homeModule.factory('sessionService', function($window) 
{
   var sessionService = {};
   
   sessionService.set = function(key, value)
   {
        $window.sessionStorage.setItem(key,value);
   };
    
   sessionService.get = function(key)
   {
        return $window.sessionStorage.getItem(key);
   };

   sessionService.remove = function(key)
   {
        $window.sessionStorage.removeItem(key);
   };
   
   return sessionService;
  
});

homeModule.controller('headerController', function (mySharedService,sessionService, $scope) 
{
    var local_UId = "";
    var local_UName = "";
    
	$scope.initFunction = function initFunction()
	{
        //console.log("== Header -> initFunction ");
        local_UId = sessionService.get(sessionUserId);
        local_UName= sessionService.get(sessionUserName);
        if (local_UId != null && local_UId != "" && local_UId !="undefined")
        {
            $scope.loginStaus = true;
            $scope.userId = local_UId;
            $scope.userName = local_UName;
        }else
        {
            $scope.loginStaus = false;
        }
        
    }
    
    $scope.goToSignUp = function goToSignUp() 
    {
        //console.log("== click signUp Function");
        mySharedService.prepForRederectContentPage(contentSignUpPage);
    }

    $scope.goToSignIn = function goToSignIn()
    {
        mySharedService.prepForRederectContentPage(contentSignInPage);
    }

    $scope.$on("broadcastContentPage", function ()
    {
        if (mySharedService.contentPageName == contentMainPage)
        {
            $scope.initFunction();
        }
        
    })

    $scope.loginOut  = function loginOut()
    {
        sessionService.remove(sessionUserId);
        sessionService.remove(sessionUserName);
        mySharedService.prepForRederectContentPage(contentMainPage);
    }   

    
});

//=========================//
homeModule.controller('sliderController', function ($scope) 
{
    
	$scope.initFunction = function initFunction()
	{
       console.log("== Slider -> initFunction ");
    }
    
});


//=========================//
homeModule.controller('contentController', function (mySharedService,sessionService, $scope, $http, $location) 
{
    //
    $scope.initFunction = function initFunction()
	{
        console.log("== Content -> initFunction ");
        $scope.f_changeContent(contentMainPage);
        $scope.loadRecommendAlbum();
    }
    //
    $scope.initRegForm = function initRegForm()
    {
       $scope.myUser={};
       $scope.initBirthDate();
    }
    //
    $scope.initLoginForm = function  initLoginForm()
    {
       $scope.myUser={};
	   $scope.myUser.userEmail="";
	   $scope.myUser.firstPassword="";
    }
    //

    $scope.$on("broadcastContentPage", function ()
    {
        $scope.f_changeContent(mySharedService.contentPageName);
        $scope.initRegForm();
    })

    $scope.f_changeContent = function f_changeContent(value)
	{
       $scope.contentUrl=value;
    }

    $scope.loadRecommendAlbum = function loadRecommendAlbum()
	{
		var newUrl = urlBase+'/rAlbum';
		//
		$http({
			method: 'GET',
			url: newUrl
		}).then(function successCallback(response) {
            
            
             $scope.recommendSlide1 = response.data.rAlbumSide1;
             $scope.recommendSlide2 = response.data.rAlbumSide2;
             $scope.recommendSlide3 = response.data.rAlbumSide3;
              

		}, function errorCallback(response) {

			//console.log(response.data);	  
		});
    }

    //
    $scope.validationForm = function validationForm()
    {
        var retValue = true;
        var firstP = $scope.myUser.firstPassword;
        var secodP = $scope.myUser.secondPassword;
        if (firstP=="")
        {
            addClassToElement("firstPassword","is-invalid")
            return false;
        }
        if (firstP != secodP || secodP =="")
        {
            addClassToElement("secondPassword","is-invalid")
            retValue = false;    
        }
        
        return retValue;
    }

    //
    $scope.submitRegForm  = function submitRegForm ()
    {

        console.log("==================Create Account=============");
        if ($scope.validationForm() == false)
        {
            return;
        }

        var localUrl = urlBase+'/regUser';
        console.log($scope.myUser);	
        $http({
            method: 'POST',
            url: 	localUrl,
            data:	$scope.myUser
        }).then(function successCallback(response){
            
           //console.log("====ok===="+response.data);
           $scope.submitLoginForm();

        },function errorCallback(response){
            
           //console.log("====not====" + +response.data);
           $scope.regFail = true;
            
        });

    }
    
    //
    $scope.submitLoginForm  = function submitLoginForm ()
    {
        var localUrl = urlBase+'/loginUser';
        //console.log($scope.myUser);	
        $http({
            method: 'POST',
            url: 	localUrl,
            data:	$scope.myUser
        }).then(function successCallback(response)
        {
            console.log("==================Sign Succ=============");
            sessionService.set(sessionUserId,response.data.userId);
            sessionService.set(sessionUserName,response.data.userName);
            mySharedService.prepForRederectContentPage(contentMainPage);

            //console.log("==================Sign Succ=============" +sessionService.get(sessionUserName));
            
        },function errorCallback(response)
        {
            $scope.loginFail = true;
        });
    }


    //
    $scope.playMusic = function playMusic( data )
	{
        //console.log(data);
        var localUrl = urlBase+'/play?';
        localUrl = localUrl + 'albumId='+ data.albumId;
        localUrl = localUrl + '&trackId=';
        
        var localUId = sessionService.get(sessionUserId);
        
        if (localUId != null)
        {
            localUrl = localUrl + "&userId=" + localUId;
            //
            $http({
                method: 'GET',
                url: localUrl
            }).then(function successCallback(response) {
                

            }, function errorCallback(response) {

            });
        }

        play(data);
    }

    //
    $scope.initBirthDate = function initBirthDate()
    {
         
        var i;
        var strI="";
        var arrDays = [];
        var arrMonths =[];
        var arrYears =[];
        for (i = 1; i <= 31; i++) 
        { 
            var item={label:'',value:''};
            if (i<10)
            {
                strI = "0"+i;
            }else
            {
                strI = i;
            }
            item.label = strI;
            item.value = strI;
            arrDays.push(item);
        }
        $scope.arrDays = arrDays;

        
        for (i = 1; i <= 12; i++) 
        { 
            var item={label:'',value:''};
            if (i<10)
            {
                strI = "0"+i;
            }else
            {
                strI = i;
            }
            item.label = strI;
            item.value = strI;
            arrMonths.push(item);
        }
        $scope.arrMonths = arrMonths;
        //
        for (i = 1950; i <= 2010; i++) 
        {
            var item={label:'',value:''};
            strI = i;
            item.label = strI;
            item.value = strI;
            arrYears.push(item);
        }
        $scope.arrYears = arrYears;
    }

});

function play(obj)
{
    console.log(obj.playLink);
    var myAudio = document.getElementById("myAudio");
    var myAudioSrouce = document.getElementById("myAudioSrouce");
    myAudioSrouce.src = obj.playLink;
    myAudio.load();
    myAudio.play();
}

function addClassToElement(elementId, className)
{
    var v_element = document.getElementById(elementId);
    if (v_element == "" || v_element == "undefined")
    {
        return ;
    }

    if ( document.getElementById(elementId).classList.contains(className) )
    {
       ;
    }else
    {
       v_element.classList.add(className);
    }
}


/*
function test()
{
    //document.getElementById("MyElement").classList.add('MyClass');
        //document.getElementById("MyElement").classList.remove('MyClass');
        //if ( document.getElementById("MyElement").classList.contains('MyClass') )
        //  document.getElementById("MyElement").classList.toggle('MyClass');
        //var v_userName = $document[0].getElementById("username");
        //var v_nameValue = v_userName.value;
        if ( v_nameValue == "" || v_nameValue.length<3 || v_nameValue.length > 12)
        {
           v_userName.classList.add("is-invalid");
           return false;
        }else
        {
            if ( v_userName.classList.contains('is-invalid') )
            {
                v_userName.classList.remove('is-invalid');
                v_userName.classList.add('is-valid');
            }
        }

        var v_email    = $scope.email;
        var v_gender   = $scope.gender;
        var v_dob      = $scope.dateOfBirth;
        var v_pass1    = $scope.firstPassword;
        var v_pass2    = $scope.secondPassword;
}

*/



  
