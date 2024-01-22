//js
const b1 = document.getElementById("b1");
const b2 = document.querySelector("#b2");

b1.addEventListener("click", ()=>{
    
})
let v = b1.innerHTML;
b1.innerHTML='test';

b1.속성명
b1.getAttribute("속성명");
b1.setAttribute("속성명", "값");

//jquery
//$("선택자").action()
$("#b1").click(function(){

});

$("#b2").on("click", ()=>{
    
});

$("#b1").html(); //text()
$("#b1").html("test");

//속성값이 동적으로 변하지 않을 때
$("#b1").attr("속성명");
$("#b1").attr("속성명", "값");
//속성값이 동적으로 변할때 ex) checked, selected
$("#b1").prop("속성명");
$("#b1").prop("속성명", "값");

$("#b1").val(); //값가져옴
$("#b1").val("값"); 
