/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var contentModule = angular.module('contentManager', ['ngAnimate']);

contentModule.controller('contentController', function ($scope, $http, $window ) 
{
	var urlBase="http://localhost:8080/recommender";
	
	$scope.exampleFunction = function exampleFunction(id)
	{
        var origin = $window.location;
        console.log("====================="+id);
        console.log("====================="+origin);
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

    
    $scope.playMusic = function playMusic( data )
	{
        play(data);
    }


	//==========================================
	$scope.formatDate = function formatDate(x, y) 
	{
	    var z = {
	        M: x.getMonth() + 1,
	        d: x.getDate(),
	        h: x.getHours(),
	        m: x.getMinutes(),
	        s: x.getSeconds()
	    };
	    y = y.replace(/(M+|d+|h+|m+|s+)/g, function(v) {
	        return ((v.length > 1 ? "0" : "") + eval('z.' + v.slice(-1))).slice(-2)
	    });

	    return y.replace(/(y+)/g, function(v) {
	        return x.getFullYear().toString().slice(-v.length)
	    });
	}
	
    Date.prototype.format = function(e) 
    {
        var a = function(m, l) 
        {
	        var n = ""
	          , k = (m < 0)
	          , j = String(Math.abs(m));
	        if (j.length < l) {
	            n = (new Array(l - j.length + 1)).join("0")
	        }
	        return (k ? "-" : "") + n + j
        };
        
	    if ("string" != typeof e) {
	        return this.toString()
        }
        
        var b = function(k, j) 
        {
	        e = e.replace(k, j)
        };
        
	    var f = this.getFullYear()
	      , d = this.getMonth() + 1
	      , i = this.getDate()
	      , g = this.getHours()
	      , c = this.getMinutes()
	      , h = this.getSeconds();
	    b(/yyyy/g, a(f, 4));
	    b(/yy/g, a(parseInt(f.toString().slice(2), 10), 2));
	    b(/MM/g, a(d, 2));
	    b(/M/g, d);
	    b(/dd/g, a(i, 2));
	    b(/d/g, i);
	    b(/HH/g, a(g, 2));
	    b(/H/g, g);
	    b(/hh/g, a(g % 12, 2));
	    b(/h/g, g % 12);
	    b(/mm/g, a(c, 2));
	    b(/m/g, c);
	    b(/ss/g, a(h, 2));
	    b(/s/g, h);
	    return e
    };
    

}
);
	
function play(obj)
{
   console.log(obj.playLink);
    var myAudio = document.getElementById("myAudio");
    var myAudioSrouce = document.getElementById("myAudioSrouce");
    myAudioSrouce.src = obj.playLink;
    myAudio.load();
    myAudio.play();
	
}