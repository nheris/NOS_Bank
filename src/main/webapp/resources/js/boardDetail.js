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


//후기댓글 등록 replyAdd (Fetch사용)
const replyAdd = document.getElementById("replyAdd");
const replyForm = document.getElementById("replyForm");

let replyList = document.getElementById("replyList");

replyAdd.addEventListener("click",()=>{
    let form = new FormData(replyForm);
    
    fetch("../reply/add",{
        method:"POST",
        body:form
    })

    .then(res=>res.json())
    .then(res=>{console.log(res)
        
        
        replyList.innerHTML="";
		makeList(r);
        
        //새댓추가하고 입력한 폼 값 초기화
        replyForm.reset();

    })


})


//후기댓글들 상품에 뜨게
// fetch("../reply/list?productNum="+update.getAttribute("data-product-num"), {
// 	method:"GET"
// }).then(r=> r.text())
//   .then(r=>document.getElementById("replyList").innerHTML=r)
  
  
  
//후기댓 더보기(페이징) 
const more = document.getElementById("more");

getReplyList(1, update.getAttribute("data-product-num"));

more.addEventListener("click", ()=>{

	let p = more.getAttribute("data-replyList-page");//현재 페이지 번호
	let a = more.getAttribute("data-replyList-totalPage");//전체 페이지 번호

	if(p>a){
		alert('마지막 페이지 입니다');
	}

    getReplyList(p, update.getAttribute("data-product-num"))
})

function getReplyList(page, num){
	fetch("../reply/list?page="+page+"&productNum="+num, {
		method:"GET"
	})
    .then(r => r.json())
	.then(r => {
        console.log('=================')
        console.log(r)

        makeList(r);
    })
    
    
};

function makeList(r){
    more.setAttribute("data-replyList-page", r.pager.page*1+1);
    more.setAttribute("data-replyList-totalPage", r.pager.totalPage);
    let userName = replyList.getAttribute("data-user");
    r=r.datas;
    for(let i=0;i<r.length;i++){
        let tr = document.createElement("tr");

        let td = document.createElement("td");
        td.innerHTML=r[i].userName;
        tr.append(td);

        td = document.createElement("td");
        td.innerHTML=r[i].replyContents;
        tr.append(td);

        td = document.createElement("td");
        let d = new Date(r[i].replyDate);
        td.innerHTML=d.getFullYear()+"."+(d.getMonth()+1)+"."+d.getDate();
        tr.append(td);

        td = document.createElement("td");
        td.innerHTML=r[i].replyJumsu;
        tr.append(td);

        if(userName == r[i].userName){
			td = document.createElement("td");
			let b = document.createElement("button")
			b.innerHTML="삭제";
			b.setAttribute("class", "del")
			b.setAttribute("data-replyNum", r[i].replyNum)
			td.append(b);
			tr.append(td)

			td = document.createElement("td");
			b = document.createElement("button")
			b.innerHTML="수정";
			b.setAttribute("class", "update")
			b.setAttribute("data-replyNum", r[i].replyNum)
			td.append(b);
			tr.append(td)
		}
        replyList.append(tr);



    }
}

//삭제 버튼
$("#replyList").on("click", ".del", function(){
    let n = $(this).attr("data-replyNum")
	console.log("replyNum : ", n)
    
	
	fetch("../reply/delete",{
        method:"post",
		headers : {"Content-type": 'application/x-www-form-urlencoded;charset=utf-8'},
		body:"replyNum="+n+"&productNum="+ update.getAttribute("data-product-num")
	})
	.then(r=>r.json())
	.then(r=>{
        replyList.innerHTML="";
		makeList(r);
	})
})


