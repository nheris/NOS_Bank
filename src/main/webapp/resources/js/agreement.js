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
        console.log(this.checked);
    })
}

//jQuery
// $('#checkAll').click(()=>{
//     let v = $("#checkAll").prop("checked");

//     $('.checks').prop("checked", v);
// });

// $('.checks').click(function(){
//     console.log($(this).prop('checked'));
// })