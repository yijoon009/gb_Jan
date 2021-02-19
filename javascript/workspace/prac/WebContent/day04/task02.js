/**
 * 자동차 주행에 필요한 js
 */


function SuperCar(){
	this.brand = "Ferrari";
	this.color = "red";
	this.price = 15000;
}

function activeEnter(){
	if(window.event.keyCode == 13){
		//시동 켜기
		SuperCar.engineStart();
	}
}

SuperCar.prototype.pw = prompt("자동차 초기 비밀번호 입력");

var isOn = false;
var pw = $("#pw");
var result = $("#result")
var cnt=0;
var img = $("#img");

SuperCar.showInput = function(){
	if(!isOn){
		//시동을 켤 수 있는 상태
		$("#pw").css("visibility", "visible");
	}else{
		//시동이 이미 켜져있는 상태
		result.text("이미 시동이 켜져있습니다.");
	}
}

//프로토타입의 메소드 사용 방법
//SuperCar.engineStart()

SuperCar.engineStart = function(){
	//비밀번호 검사(SuperCar.prototype.pw : 초기비밀번호)
	//연속 3회 오류 시 경찰 출동
	if(SuperCar.prototype.pw == pw.val()){
		cnt=0;
		img.attr("src","시동켜기.gif");
		pw.val("비밀번호 입력");
		pw.css("visibility","hidden");
		result.text("시동 켜짐");
		isOn=true;
	}else{
		cnt++;
		if(cnt==3){
			img.attr("src","경찰.png");
			$("#on").css("display","none");
			$("#off").css("display","none");
			$("#pw").css("display","none");
			result.text("경찰 출동");
		}else{
			result.text("비밀번호 오류: "+cnt+" 회");
		}
	}
}

SuperCar.engineStop = function(){
	//시동을 끌 수 있는 상태
	//시동이 이미 꺼져있는 상태
	if(isOn){
		img.attr("src","시동끄기.gif");
		result.text("시동 꺼짐");
		isOn=false;
	}else{
		result.text("이미 시동이 꺼져있습니다.");
	}
}

















