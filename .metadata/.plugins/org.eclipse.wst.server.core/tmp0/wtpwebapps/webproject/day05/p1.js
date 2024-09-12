		window.onload=function(){
			
			
			var obj1 = document.querySelector("#m_1");
			obj1.style.color= "red";
			
			var obj2 = document.querySelector("#m_2");
			obj2.className = "active";
			
			var obj3 = document.querySelectorAll("#m_3 img");
			for(let i = 0; i < obj3.length; i+=2){
				obj3[i].setAttribute("src", "ch3.png");
			}
			
			m_4.innerHTML += "<p>항목4</p>";
			
		 	var obj5 = document.querySelectorAll("#m_5 p");
		 	for(let i = 0; i < obj5.length; i++){
		 		if(obj5[i].innerText === "항목4"){
		 			obj5[i].parentNode.removeChild(obj5[i]);
		 		}
		 	}
		 	
		 	var obj6 = document.querySelector("#m_6").parentNode;
		 	obj6.parentNode.removeChild(obj6);
		}
		