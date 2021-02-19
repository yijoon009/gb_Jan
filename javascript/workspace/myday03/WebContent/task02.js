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
var inputTag = document.getElementById("input");
var textArea = document.getElementById("textarea");


var imgTag = document.getElementById("img");
var isOn=false;

SuperCar.showInput = function(){
	inputTag.style.visibility="visible";
	
	if(!isOn){
		//시동을 켤 수 있는 상태
		inputTag.placeholder="비밀번호 입력"
	}else{
		//시동이 이미 켜져있는 상태
		textArea.innerHTML="이미 켜져 있습니다.";
	}
}

//프로토타입의 메소드 사용 방법
//SuperCar.engineStart()
SuperCar.engineStart = function(){
	//비밀번호 검사(SuperCar.prototype.pw: 초기 비밀번호)
	//연속 3회 오류 시 경찰 출동
	var cnt=0;
	if(SuperCar.prototype.pw == inputTag.value){
		textArea.innerHTML="시동 켜짐";
		imgTag.src="시동켜기.gif";
		isOn=true;
	}else{
		cnt++;
		if(cnt==3){
			textArea.innerHTML="경찰 출동 충";
			imgTag.src="경찰.png";
			return;
		}
		textArea.innerHTML="비밀번호 오류: "+cnt+"회";
	}
	
}

SuperCar.engineStop = function(){
	//시동을 끌 수 있는 상태
	//시동이 이미 꺼져있는 상태
}
