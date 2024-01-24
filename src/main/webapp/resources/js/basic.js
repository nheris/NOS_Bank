// //js
// const b1 = document.getElementById("b1");
// const b2 = document.querySelector("#b2");

// b1.addEventListener("click", ()=>{
    
// })
// let v = b1.innerHTML;
// b1.innerHTML='test';

// b1.속성명
// b1.getAttribute("속성명");
// b1.setAttribute("속성명", "값");

// //jquery
// //$("선택자").action()
// $("#b1").click(function(){

// });

// $("#b2").on("click", ()=>{
    
// });

// $("#b1").html(); //text()
// $("#b1").html("test");

// //속성값이 동적으로 변하지 않을 때
// $("#b1").attr("속성명");
// $("#b1").attr("속성명", "값");
// //속성값이 동적으로 변할때 ex) checked, selected
// $("#b1").prop("속성명");
// $("#b1").prop("속성명", "값");

// $("#b1").val(); //값가져옴
// $("#b1").val("값"); 

//----------------------------------------------


let btn = document.getElementById("btn");
let btn2 = document.getElementById("btn2");

//페이지 이동없이 공지사항 글쓰기??
btn2.addEventListener("click", function(){
    let t = document.getElementById("title").value;
    let c = document.getElementById("contents").value;

    fetch("/notice/add", {
        method:"POST",
        // headers : 헤더 값 전달 //Post 요청시 파라미터 
        headers:{
            "Content-type":"application/x-www-form-urlencoded"
        },
        body:"boardTitle="+t+"&boardContents="+c
    })
    .then(response => response.text())
    .then(response => console.log(response));
    
    ;

})



btn.addEventListener("click", function(){
    console.log("Ajax 시작");

    fetch("/notice/list", {
        method:"GET"
    })
    //응답객체에서 Data 추출
    //.then(response=>response.text())
    .then(response=>{return response.text()})
    ////추출한 Data 사용
    .then((res)=>{
        document.getElementById("result").innerHTML=res;

    })
    //Arrow Function
    //function(){}  -> ()=>console.log
    
    ;

    console.log("끝");

})