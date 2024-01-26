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

//후기댓글 replyAdd (Fetch사용)
const replyAdd = document.getElementById("replyAdd");
const replyForm = document.getElementById("replyForm");

let replyList = document.getElementById("replyList");

replyAdd.addEventListener("click",()=>{
    let form = new FormData(replyForm);
    
    fetch("../reply/add",{
        method:"POST",
        body:form
    })

    .then(res=>res.text())
    .then(res=>{console.log(res)
        
        
        replyList.innerHTML=res
        //$("#replyList").html(res)
        
        //새댓추가하고 폼 값 초기화
        replyForm.reset();

    })


})


//후기댓글들 상품에 뜨게
fetch("../reply/list?productNum="+update.getAttribute("data-product-num"), {
	method:"GET"
}).then(r=> r.text())
  .then(r=>document.getElementById("replyList").innerHTML=r)