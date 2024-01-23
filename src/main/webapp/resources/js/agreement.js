console.log("agreement");

//js
const checkAll = document.getElementById("checkAll");
const checks = document.getElementsByClassName("checks");

checkAll.addEventListener("click", ()=>{
    let v = checkAll.getAttribute("checked");
    v = checkAll.checked;
    console.log("CHECK : ", v); //true

    for(let check of checks){
        check.checked=v;
    }

})

for(let c of checks){
    c.addEventListener("click", function(){
        let flag = true;

        console.log(this.checked);
    })
}

//필수동의 후 회원가입
const a1 = document.getElementById("a1");
const a2 = document.getElementById("a2");
const a3 = document.getElementById("a3");
const btn = document.getElementsByClassName("btn");
btn.addEventListener("click", ()=>{
    if(a1.checked == false){
        alert("필수 동의 후 회원가입 가능")
        return;
    }
})




//jQuery
$('#checkAll').click(()=>{
    let v = $("#checkAll").prop("checked");

    $('.checks').prop("checked", v);
});

$('.checks').click(function(){
    //console.log($(this).prop('checked'));

    let flag = true;
    
    $('.checks').each(function(idx, c){
        console.log(idx);
        console.log($(c).prop('checked'));
    })
})

$()