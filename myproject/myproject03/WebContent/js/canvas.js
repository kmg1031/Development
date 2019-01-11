
	var box=document.getElementById("box");
	var screen=document.getElementById("screen");
	var cnvs=document.getElementById("cnvs");
	var con1=document.getElementById("con1");
	var con2=document.getElementById("con2");
	var con3=document.getElementById("con3");
	var con4=document.getElementById("con4");
	var aspect=1; //앞면
	var ctx;
	
	var px1=0; //이동후
	var px2=0; //이동전
	var acX=50; //x 속도
	var brakX=1; // 감속
	
	var n=Math.PI/2; //90도
	var N=n/2; // 각도로찾기
	
	var x=cnvs.width/2;
	var y=cnvs.height*3/4;
	var R=200; //도형의 반지름
	
	var on=false; //마우스상태
	
	
	window.onload=function(){
	
		if(cnvs.getContext){
			ctx=cnvs.getContext('2d');
		}

		//setInterval("start()",1000/60); // 초당 60프레임
		start();
	}
	
	screen.addEventListener('mousedown',down);
	screen.addEventListener('mousemove',move);
	screen.addEventListener('mouseup',up);
	screen.addEventListener('mouseout',up);
	
	function down(){
		on=true;
		px1=px2=event.offsetX;
		acX+=n;
	}
	function move(){
		if(on){
			px1=event.offsetX;
		}
	}
	function up(){
		on=false;
	}
	
	function start(){ //setIntervel
		point(); // x좌표 계산
		drowing();	 // 그리기
		requestAnimationFrame(start);
	}
	
	function point(){
		
		if(on){ //속도저장
			acX=px2-px1;
			if(acX>100)acX=100;
			if(acX<-100)acX=-100;
		}else if(acX<10 && acX>-10){ // 블록맞추기
			sortBox();
		}else{ //감속
			acX=acX<0?acX+brakX:acX;			
			acX=acX>0?acX-brakX:acX;
		}
		px2=px1;
		
		N=N+(acX/100);	 //N 45 ~ 135 (90도)
		
		if(N*2>=n*3){
			N-=n;
			while(N*2>=n*3){
				N-=n;	
			}
			aspect++;
			aspect=aspect>4?1:aspect;
		}
		if(N*2<n){
			N+=n;
			while(N*2<n){
				N+=n;	
			}
			
			aspect--;
			aspect=aspect<1?4:aspect;
		}
		
	}
	function sortBox(){
	
		// btnN 0~360 에서 
		// 속도가 일정 값이하로 떨어질때 작동
		// 마우스 up 상태에서 작동
		// N=45 로 정지하도록 유도
		
			if(N>n){ //N 90 기준 45, 135
				if(Math.round((N*4)-(n*6))==0){
					acX=0;
					N=n*3/2;
				}else{
					acX++;
				}
			}else{
				if(Math.round((N*4)-(n*2))==0){
					acX=0;
					N=n/2;
				}else{
					acX--;
				}
			}
		
	}
	
	
	function calculate(N){  
		
		x1=Math.round(Math.cos(N)*R)+x;
		y1=Math.round(Math.sin(N)*R)+y;
		
		x2=Math.round(Math.cos(N+n)*R)+x;
		y2=Math.round(Math.sin(N+n)*R)+y;
		
		x3=Math.round(Math.cos(N+(2*n))*R)+x;
		y3=Math.round(Math.sin(N+(2*n))*R)+y;
		
		x4=Math.round(Math.cos(N+(n*3))*R)+x;
		y4=Math.round(Math.sin(N+(n*3))*R)+y;
		
		y1/=4;
		y2/=4;
		y3/=4;
		y4/=4;
		
		
	}
	function btnView(){
		if(N==n/2){
			if(acX > -5 && acX <5){
					if(aspect==1){ //btn 활성화
						con1.style.display="block";
					}
					if(aspect==2){ 
						con2.style.display="block";
					}
					if(aspect==3){ 
						con3.style.display="block";
					}
					if(aspect==4){ 
						con4.style.display="block";
					}
			}
			
		}else{
			con1.style.display="none";
			con2.style.display="none";
			con3.style.display="none";
			con4.style.display="none";
		}
	}
	function drowing(){
		
		btnView();
		
		calculate(N);
		
		cnvs.width=cnvs.width;	
		
		ctx.beginPath();

		ctx.moveTo(x1,y1); //11
		ctx.lineTo(x2,y2); //12
		ctx.lineTo(x3,y3); //13
		ctx.lineTo(x4,y4); //14
		ctx.lineTo(x1,y1); //11
		ctx.lineTo(x1,y1+200) //21
		ctx.moveTo(x4,y4); //14
		ctx.lineTo(x4,y4+200); //24
		ctx.moveTo(x2,y2); //12
		ctx.lineTo(x2,y2+200) //22
		ctx.lineTo(x1,y1+200) //21
		ctx.lineTo(x4,y4+200) //24
		
		ctx.stroke();
		
	}

