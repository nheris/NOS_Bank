console.log("agreement");

//js
const checkAll = document.getElementById("checkAll");
let checks = document.getElementsByClassName("checks");

checkAll.addEventListener("click", ()=>{
    let v = checkAll.getAttribute("checked");
    console.log("CHECK : ",v);

    v= checkAll.checked;
    console.log("CHECK : ",v);

    for(let check of checks){
        check.checked=v;
    }

})

for(let c of checks){
    c.addEventListener("click",()=>{
        console.log(this.checks);
    })
}

//jQuery
// $('#checkAll').click(()=>{
//     let v = $("#checkAll").prop("checked");
//     $('.checks').prop("checked", v);
// });

// $('.checks').click(()=>{
//     console.log($(this).prop('checked'));
// })