$(".password").blur(function () {
	var val = jQuery(".password").val();
	if (val==$(".pass").val()){
		$(".span1").html("√√√√√√√√√√√√")
		$(".span1").css("color","green")
	}else {
		$(".span1").html("xxxxxxxxxxxxx")
		$(".span1").css("color","red")
	}
})


$(".password1").blur(function () {
	a();
	var password = $(".password").val();
	var password1 = $(".password1").val();
	if (password1.length<6||password1==password){
		$(".span2").html("xxxxxxxxxxxxx密码长度不能小于6位")
		$(".span2").css("color","red")
	}else {
		$(".span2").html("√√√√√√√√√√√√")
		$(".span2").css("color","green")
	}
})
$(".password2").blur(a)
function a() {
	var password1 = $(".password1").val();
	var password2 = $(".password2").val();
	if (password2!=password1||password2==""||password2.length<6){
		$(".span3").html("xxxxxxxxxxxxx两次密码输入不同")
		$(".span3").css("color","red")
	}else {
		$(".span3").html("√√√√√√√√√√√√")
		$(".span3").css("color","green")
	}
}
$(".input-button").click(function () {
	a()
	var AA=$(".span1").css("color")
	var BB=$(".span2").css("color")
	var CC=$(".span3").css("color")
	var password = $(".password").val();
	var password1 = $(".password1").val();
	var password2 = $(".password2").val();
	if (AA=="rgb(255, 0, 0)"||BB=="rgb(255, 0, 0)"||CC=="rgb(255, 0, 0)"||password==""||password1==""||password2==""){
		alert("输入的密码不符合规定！");
		event.preventDefault()
	}
})