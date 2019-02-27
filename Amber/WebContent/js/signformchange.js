$(function ()
{
        $('.change a').click(function ()
        {
            $('.signform').animate({height: 'toggle', opacity: 'toggle'}, 'slow');
        });
})
$("#login-latter").hover(
	function(){
		$('user-function').style.display="";
	}	
);

function start() {
document.getElementById('signform').style.display=""
}

function signclose() {
    document.getElementById('signform').style.display="none"
    document.getElementById('registerform').style.display="none"
}
function loading() {
    document.getElementById('registerloading').style.display=""
}
function show() {
	document.getElementById('user-function').style.display=""
}
function close(){
	alert("发生了")
    document.getElementById('user-function').style.display="none";
}