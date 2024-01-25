const update = document.getElementById("update");
const del = document.getElementById("delete");
const frm = document.getElementById("frm");

update.addEventListener("click",(e)=>{
    e.preventDefault();
    frm.submit();
})

del.addEventListener("click", (e)=>{
    e.preventDefault();
    frm.setAttribute("action", "./delete");
    frm.setAttribute("method", "post");
    frm.submit();
});


// 찜
const wishlist = document.getElementById("wishlist");

wishlist.addEventListener("click",()=>{
    let pn = document.getElementById("productNum").value;
    
    fetch("../wishlist/add?productNum="+pn , {
        method:"GET",
    })
    .then(res => res.text())
    .then(res => {
        console.log(res)
        
        if(res==1){
            let move = confirm("등록 성공. 관심목록 리스트로 이동하시겠습니까?");
            if(move){
                location.href="../wishlist/list"
            }
        }else{
            alert('등록 실패 하였습니다.');
        }
    })
})