function go_cart(){
	if(document.formm.quantity.value ==""){
		alert("수량을 입력하세요");
		document.formm.quantity.focus();
	}else{
		document.formm.action = 'shop.do?command=cartInsert';
		document.formm.submit();
	}
	
}

function go_cart_delete(){
	// 자바스크립트에서 form 태그 내의 입력란들에게 접근할때 name 이 같은 것들은 배열로 인식된다.
	// document.cartFrm.cseq 들이 갯수만큼 배열로 인식됩니다 document.cartFrm.cseq[0] ~
	// 만약 해당이름의 태그가 한개라면 배열이 아니라 그냥 변수 처럼 인식
	// 배열이라면 .length 라는 속성을 쓸수가 있고, 배열이 아니라면 length 속성은 undefined 가 됩니다
	
	var count=0;
	// 혹시라도 체크박스에 체크를 하나도 안넣고 삭제버튼을 눌렀는지 검사합니다.
	if(document.cartFrm.cseq.length == undefined){
		// 체크박스가 한개라면, 체크박스가 단일 변수로 인식
		if(document.cartFrm.cseq.checked == true){
		count++;
	}
	}else{ 
		// 체크박스가 두개 이상이라면, 체크박스들이 배열이라면
		for(var i = 0; i<document.cartFrm.cseq.length; i++){
			if(document.cartFrm.cseq[i].checked == true ){
			count++;
			}
		}
	}
	
	if(count == 0){
		alert("삭제할 항목을 선택하세요");
	}else{
		var ans =confirm("선택한 항목을 삭제할까요?");
		if(ans){
			document.cartFrm.action = "shop.do?command=cartDelete";
			document.cartFrm.submit();
		}
		
	}
}


function go_order_insert(){
	
	var count=0;
	
	if(document.cartFrm.cseq.length == undefined){
	
		if(document.cartFrm.cseq.checked == true){
		count++;
	}
	}else{ 
		for(var i = 0; i<document.cartFrm.cseq.length; i++){
			if(document.cartFrm.cseq[i].checked == true ){
			count++;
			}
		}
	}
	
	if(count == 0){
		alert("주문할 항목을 선택하세요");
	}else{
		var ans =confirm("선택한 항목을 주문할까요?");
		if(ans){
			document.cartFrm.action = "shop.do?command=orderInsert";
			document.cartFrm.submit();
		}
		
	}
}

function go_order(){
	var ans =confirm("현재 상품을 주문할까요?");
	if(ans){
		document.formm.action ="shop.do?command=orderInsertOne";
		document.formm.submit();
	}
}

	
	
	