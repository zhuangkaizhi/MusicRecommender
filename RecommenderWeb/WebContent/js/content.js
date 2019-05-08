
$(document).ready(function() {
	
	$("#sidebar").mCustomScrollbar({
        theme: "minimal"
    });
    
    //
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar, #content').toggleClass('active');
        $('.collapse.in').toggleClass('in');
        $('a[aria-expanded=true]').attr('aria-expanded', 'false');
    });
    
    /*
    $('.carousel').carousel({
        interval: 1000
    })
    */

    ////contentPage = "conent/main_content.jsp";

});


function changeContent(divSector, value)
{
    var myElement = document.getElementById(divSector);
    myElement.innerHTML = value;
    //myElement.load();
    console.log("======");
}

function goToSignUp()
{
    //$('#content').load("user/login.jsp");
}

