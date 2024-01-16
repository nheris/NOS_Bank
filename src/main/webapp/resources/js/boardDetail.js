const update = document.getElementById("update");
const del = document.getElementById("delete");
const frm = document.getElementById("frm");

update.addEventListener("click",(e)=>{
    e.preventDefault();
    frm.submit();
})

del.addEventListener("click",function(e){
    e.preventDefault();
    // frm.action
    frm.attributes("action", "./delete");
    frm.attributes("method", "post");
    frm.submit();
})