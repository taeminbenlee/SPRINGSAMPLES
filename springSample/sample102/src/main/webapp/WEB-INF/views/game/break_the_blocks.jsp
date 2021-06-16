<!DOCTYPE HTML>
<html>
<head>
<title>Break The Blocks</title>
<style>
label
{
	color: #33AB3D;
	line-height: 20px;
	text-align: center;
	font-weight:bold;
	

}
#gs
{
color: DARKBLUE;
	line-height: 30px;
	text-align: center;
	font-weight:bold;
}
#pattern
{
color: DARKBLUE;
	line-height: 30px;
	text-align: center;
	font-weight:bold;
	position:relative;
	
}
label:hover
{
	font-size:110%;
	color: GREEN;	
}

#game{

padding:20px 80px 90px 80px;;
border-radius: 10px;
border : solid 2px black;
position:fixed;

background:white;
}

#score
{
position:fixed;top:340px;left:500px;
	color: #F50C3F;
		
	text-wight:bold;
	color: #0F0F0F;
		font-size:250%;
text-shadow:  1px 1px #7A7B7D;
}
#select_tag{
position:fixed;top:273px;left:518px;
width: 95px;
}

#btn1
{
cursor: pointer;
	
	position:fixed;top:300px;left:520px;
	width: 85px;
	height: 35px;
	
	
	background: black;
	border-radius: 3px;
	box-shadow: 0px 4px rgba(0, 0, 0, 0.2);
	
	margin: 0 7px 11px 0;
	
	color: white;
	line-height: 36px;
	text-align: center;
	text-weight:bold;
	
	/* prevent selection of text inside keys */
	user-select: none;
	
	/* Smoothing out hover and active states using css3 transitions */
	transition: all 0.5s ease;
}
#btn1:hover {
background: lightgray;
border : 1 px;
	box-shadow: 0px 4px black;
	color: black;
	
	
	}
*{margin:0;padding:0;}

#multiplier
{
position:fixed;
font-family: 'Oswald';
font-size:15px;
font-weight:700;
left:5px;
background : #80B2FF;
border-radius: 2px;
padding:3px 10px;
bottom : 2px;
color:white;
}
#score1{
position:fixed;
font-family: 'Oswald';
font-size:15px;
font-weight:700;
right:5px;
background : #80B2FF;
border-radius: 2px;
padding:3px 10px;
bottom : 2px;
color:white;
}

.notransition {
  -webkit-transition: none !important;
  -moz-transition: none !important;
  -o-transition: none !important;
  -ms-transition: none !important;
  transition: none !important;
}

#image{
position:fixed;
}
#bar{
position:fixed;
bottom:30px;
}
#bottom{
position:fixed;
background:black;
}

</style>
<script src="./scripts/jquery.js" type="text/javascript"></script>

<script>
function disableF5(e) { if ((e.which || e.keyCode) == 116) e.preventDefault(); };
$(document).bind("keydown", disableF5);
$(document).on("keydown", disableF5);


window.onload=function(){
var W= window.innerWidth;
var H=window.innerHeight;
$("#image").css({visibility: "hidden"});
$("#bar").css({visibility: "hidden"});
$("#game").css({top:H/2-200,left:W/2-120});
$("#btn1").css({top:H/2-20,left:W/2-40});
$("#select_tag").css({top:H/2-50,left:W/2-40});
var select = document.getElementById("select_tag");
var options = new Array("Pattern 1","Pattern 2","Pattern 3","Pattern 4","Pattern 5");
for(var i = 0; i < options.length; i++) {
    var opt = options[i];
    var el = document.createElement("option");
    el.textContent = opt;
    el.value = opt;
    select.appendChild(el);
}
}

function btn(){

var canvas = document.getElementById("canvas");
var W = canvas.width = window.innerWidth;
var H = canvas.height = window.innerHeight-10;
var ctx = canvas.getContext("2d");
var d="right";
var posx=W/2-20;
var posy=H-30;
var ballx=posx+40;
var bally=posy-30;
var dirx=-5;
var diry=-5;
var loop;
var multiplier=1;
var interval_s=10;
var interval_f=5;
var interval_vf=1;
var score_add=1;
var score_count=1;
var interaval;

$("#image").css({visibility: "visible",height:"30px",width:"30px",left:ballx,top:bally});
$("#bar").css({visibility: "visible"});
ctx.fillStyle = "gray";
$("#bottom").css({bottom:0,width:W,height:"30px"});

var audioElement = document.createElement('audio');
        audioElement.setAttribute('src', 'sounds/TINK.wav');
		audioElement.setAttribute('id', 'audio');
        
		audioElement.setAttribute('volume', '0');
		
		
  
  audioElement.addEventListener("load", function() {
            audioElement.play();
        }, true);



 var score=0;
 var currentMousePos = {x:0,y:1};
 $("#multiplier").html("Level "+(multiplier));
 if(document.getElementById('s').checked)
interval=interval_s;
else if(document.getElementById('f').checked)
interval=interval_f;
else if(document.getElementById('vf').checked)
interval=interval_vf;
 
 
 var cw=20;
var length=W/100-1;
brick_array = []; 
var pattern = $('#select_tag').find(":selected").text();
select_pattern();

function select_pattern()
{
			
			
				if(pattern=="Pattern 1") 
				bricks1();
				else if(pattern=="Pattern 2") bricks2();
				else if(pattern=="Pattern 3") bricks3();
				else if(pattern=="Pattern 4") bricks4();
				else if(pattern=="Pattern 5") bricks5();
				
}
		
		
		function bricks1()
		{
			var valx;
			var valy;
			var ct;
			for(var i = 0; i<2; i++)			
			for(var j = 0; j<length; j++)
			
			{
					valx=j*100+10;
					valy=i*20;
					brick_array.push({x:valx, y:valy});	
			}
			for(var i = 0,ct=0; i<length; i++,ct+=2)
			{
			for(var j = 0; j<length-ct; j++)
			{
				
				
				if(j==0)
				{
					valx=j*100+i*100+10;
					valy=i*20+40;
					brick_array.push({x:valx, y:valy});
					
				}
				else
				{
				valx=valx+100;
				valy=i*20+40;
				brick_array.push({x:valx, y:valy});			
				}
				
				
			}
			
			}
			for(var i = 0; i<brick_array.length; i++)			
			{
				
				var c=brick_array[i];								
				paint_cell(c.x,c.y)
				
			}
		}
			
			function bricks2()
		{
			var valx;
			var valy;
			var ct;
			var lt=length/2;
			for(var i = 0; i<2; i++)			
			for(var j = 0; j<length; j++)
			
			{
					valx=j*100+10;
					valy=i*20;
					brick_array.push({x:valx, y:valy});	
			}
			
			
			
			for(var i = 0; i<lt; i++)
			{
			for(var j = 0; j<lt-i; j++)
			{			
					valx=j*100+10;
					valy=i*20+40;
					brick_array.push({x:valx, y:valy});			
				
			}
			
			}
			for(var i = 0; i<lt; i++)
			{
			for(var j = 0; j<lt-i; j++)
			{			
					
					valx=600+j*100+i*100+10;
					
					valy=i*20+40;
					brick_array.push({x:valx, y:valy});			
				
			}
			
			}
			
			
			for(var i = 0; i<brick_array.length; i++)			
			{
				
				var c=brick_array[i];								
				paint_cell(c.x,c.y)
				
			}
			
		}
		
			
			
			function bricks3()
		{
			
			for(var i = 0; i<5; i++)
			for(var j = 0; j<length; j++)
			{
				
				brick_array.push({x:j*100+10, y:i*20});			
				
			}
			
			
			for(var i = 0; i<brick_array.length; i++)			
			{
				
				var c=brick_array[i];								
				paint_cell(c.x,c.y)
				
			}
			
		}
		
		function bricks4()
		{
			var valx;
			var valy;
			var ct;
			var lt=length/2;
			for(var i = 0; i<2; i++)			
			for(var j = 0; j<length; j++)
			
			{
					valx=j*100+10;
					valy=i*20;
					brick_array.push({x:valx, y:valy});	
			}
			
			
			
			for(var i = 0; i<lt; i++)
			{
			for(var j = i; j<lt-i; j++)
			{			
					valx=j*100+10;
					valy=i*20+40;
					brick_array.push({x:valx, y:valy});	
						
				
			}
			
			}
			for(var i = 0; i<lt; i++)
			{
			for(var j = i; j<lt-i; j++)
			{			
					valx=500+j*100+10;
					valy=i*20+40;
					brick_array.push({x:valx, y:valy});			
				
			}
			
			}
			
			
			
			for(var i = 0; i<brick_array.length; i++)			
			{
				
				var c=brick_array[i];								
				paint_cell(c.x,c.y)
				
			}
			
		}
		
		function bricks5()
		{
			var valx;
			var valy;
			var ct;
			var lt=length/2;
			for(var i = 0; i<length-1; i++)			
			for(var j = 0; j<length-1; j++)
			
			{
					if(i%2==0)
					j++;
					else if(j>=0&&j%2!=0)
					j++;
					valx=j*100+10;
					valy=i*20;
					brick_array.push({x:valx, y:valy});	
					
					
			}
			for(var i = 0; i<brick_array.length; i++)			
			{
				
				var c=brick_array[i];								
				paint_cell(c.x,c.y)
				
			}
		
		}	
		
		function paint_cell(x,y)
		{		
		ctx.fillStyle = "#D63333";
		ctx.fillRect(x, y, 100, cw);
		ctx.strokeStyle = "white";
		ctx.strokeRect(x, y, 100, cw);		
		}
		function clear_cell(x,y)
		{		
		ctx.fillStyle = "white";
		ctx.fillRect(x, y, 100, cw);
		ctx.strokeStyle = "white";
		ctx.strokeRect(x, y, 100, cw);		
		}
  
function bar()
{
		
$("#bar").css({left:posx,top:posy});
}

function ball()
{	

	//ctx.drawImage(ball_image,ballx,bally,30,30);
	
	
	for(var i = 0; i<brick_array.length; i++)			
			{
				
				var c=brick_array[i];								
				
				if(ballx+15>=c.x&&ballx<=c.x+115&&bally<=c.y+20&&((bally+30)>=c.y))
				{
				clear_cell(c.x,c.y);
				brick_array.splice(i,1);
				score=score+score_add;
				score_count++;
				dirx*=-1;
				diry*=-1;	
				audioElement.play();				
				}
				
				
			}
	
	
		if(ballx<0)
		{
			ballx=20;
			dirx*=-1
		}
		if(bally<0)
		{
		bally=0;
		diry*=-1;
		}
		if(ballx>W-20)
		{
			ballx=W-20;
			dirx*=-1;
		}
		if((bally>posy-30)&&(ballx+15>=posx)&&(ballx<posx+100))
		{
			bally=posy-30;
			diry*=-1;
			
			
			if(score_count>=10&&score_count%10==0)
	{
	score_add++;
	if(dirx>=0)
	dirx++;
	else
	dirx--;
	if(diry>=0)
	diry++
	else
	diry--;
	$("#multiplier").show();
	
	
	
	$( "#multiplier" ).fadeTo( "slow" , 0.2);	
	$( "#multiplier" ).fadeTo( "slow" , 1);			
	$("#multiplier").html("Level "+(++multiplier));	
	
	}
	
		}
		if((bally>posy)&&(ballx<posx))
		{
		
		clearInterval(loop);
		game_over();
		}
		else if((bally>posy)&&(ballx>posx+100))
		{
		clearInterval(loop);
		game_over();
		
		}
		ballx+=dirx;
		bally+=diry;
	$("#image").css({left:ballx,top:bally});
	
}

function game_over(){	
		
	
	//	document.getElementById("score").innerHTML = "Score : "+score;
		$("#score").show();
		$("#game").show();
		
		
	}

function draw()
{
		
		$("#game").hide();
		
		if(posx<=0)
		{
		posx=0;		
		}
		if(posx>W-90)
		{
		posx=posx-20;
		}
		
		if(brick_array.length<=0&&score>0)
		{
			
			posx-W/2-20;
			ballx=posx+40;
			bally=posy-30;
			sleep(3000);
			var a = Math.floor((Math.random()*5)+1);			
			pattern="Pattern "+a;	
			select_pattern();
			
		}
		
	
		ctx.fillStyle="White";
		ctx.fillRect(W-150,H-30,150,30);
		ctx.fillStyle="Black"
		ctx.font = "20px Arial";
		
		$("#score1").html("Score: "+score);
		
		bar();		
		ball();
	
}
/*
$(document).keydown(function(e){

		var key=e.which;
		if(key=="37") {posx-=50;d="left"}
		else if(key=="39") {posx+=50; d="right"}
		

})

*/


function sleep(delay) {
    var start = new Date().getTime();
    while (new Date().getTime() < start + delay);
  }
$(document).mousemove(function(event) {
        currentMousePos.x = event.pageX;
        currentMousePos.y = event.pageY;
		posx=currentMousePos.x-50;
    });



loop=setInterval(draw,interval);
}
</script>
</head>
<body>
<div id="bottom"></div>
<div id="game" >
<span id="gs">Game Speed</span><br/>
<input type="radio" class="speed" name="s" id="s" value="Slow" checked> <label for="s" class="lbl" id="ls">Slow</label><br/>

<input type="radio" class="speed" name="s" id="f" value="Fast"> <label for="f" class="lbl"  id="lf">Fast</label><br/>

<input type="radio" class="speed" name="s" id="vf" value="Very Fast"><label for="vf" class="lbl"  id="lvf">Very Fast</label> <br/>
<span id="pattern">Select Pattern</span><br/>
<select id="select_tag"> 

</select>
<span id="btn1" onClick="btn()">Start Game</span>

<span id="score"></span>
<h1 id="score" style="font-weight:bold;position:fixed;top:440px;left:470px;"></h1></div>
  <span class="button blue">
			<a href="gamelist.do"><button type="button" id="btnSearch" >Back</button></a>
		</span>
<div id="multiplier">Level 1</div>
<div id="score1">Score 0</div>

<canvas id="canvas">
</canvas>
<img id="image" src="./images/ball.PNG" ></img>
<img id="bar" src="./images/bar.png" ></img>

</body>
</html>