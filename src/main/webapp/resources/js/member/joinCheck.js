console.log("join check");

	//비번체크 

//------------------js
// const password = document.getElementById("password");
// const passwordResult = document.getElementById("passwordResult");
// const passwordCheck = document.getElementById("passwordCheck");
// const passwordCheckResult = document.getElementById("passwordCheckResult");
// const btn = document.getElementById("btn");

// let p1=false;//password check
// let p2=false;//passwordCheck check

// btn.addEventListener("click", function(){
//     if(p1 && p2){
//         alert('OK')
//     }else {
//         alert('pw check');
//     }

// });


// password.addEventListener('blur', function(){
//     let p = password.value;
//     if(p.length>7){
//         passwordResult.innerHTML='OK'
//         p1=true;
//     }else {
//         passwordResult.innerHTML='비번은 8글자 이상 이어야 함'
//         p1=false;
//     }
// })

// passwordCheck.addEventListener('keyup', function(){
//     if(passwordCheck.value==password.value){
//         passwordCheckResult.innerHTML='일치 한다'
//         p2=true;
//     }else {
//         passwordCheckResult.innerHTML='일치 하지 않는다'
//         p2=false;
//     }

// });

        

//------------------jquery
let checks ={p1:false, p2:false}

$('#btn').click(function(){
    let flag=true;
    for(p in checks){
        console.log(p);
        console.log(checks[p])
        if(!checks[p]){
           flag=false;
           break;
        }
    }

    if(flag){
        alert('ok');
    }else {
        alert('No-----------')
    }

})

$('#password').blur(function(){
    if($('#password').val().length>7){
        $('#passwordResult').html('OK');
        checks.p1=true;
    }else {
        $('#passwordResult').html('비번은 8글자 이상 이어야 함');
        checks.p1=false;
    }

        //비번 더입력했을때 비번확인 비움
    $('#passwordCheck').val('');
    checks.p2=false;
    $('#passwordCheckResult').html('');


});

$('#passwordCheck').keyup(function(){
    if($('#passwordCheck').val()==$('#password').val()){
        $('#passwordCheckResult').html('일치 한다')
        checks.p2=true;
    }else {
        $('#passwordCheckResult').html('일치하지 않는다')
        checks.p2=false;
    }

});

//===============아이디 중복검사
        
   $("#userName").blur(function(){
       fetch("./idCheck?userName="+$("#userName").val() , {
           method:"GET",
           //body:"userName="+$("#userName").val() 안됨
       })
       .then(response=>response.text())
       .then(res=>console.log(res.trim()))
   });
    
