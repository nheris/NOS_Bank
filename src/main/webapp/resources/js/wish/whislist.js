//js
const checkAll = document.getElementById("checkAll");
const checks = document.getElementsByClassName("checks");
const del = document.getElementById("del");

checkAll.addEventListener("click",()=>{
    let v = checkAll.checked
    console.log("CHECK : ", v); //true,false

    for(let check of checks){
        check.checked = v;
    }
});

for(let check of checks){
    check.addEventListener("click", function(){
        let flag = true;
        for(let ch of checks){
            if(!ch.checked){
                flag=!flag;
                break;
            }
        }
        checkAll.checked=flag;
    })
}

del.addEventListener("click",()=>{
    let nums = [];
    let checkElement=[];
    for(let check of checks){
        if(check.checked){
            nums.push(check.value);
            checkElement.push(check);
        }
    }

    fetch("./delete", {
        method:"POST",
        headers:{
            "Content-type":"application/x-www-form-urlencoded"
        },
        body: "productNum="+nums
    })
    .then(response=>response.text())
    .then(res=>{
        console.log(res)
        if(res.trim()>0){
        	
        	alert('삭제 성공');
            //삭제하고 그 리스트 안보이게
			//1. location.reload();
			//2. Element들 삭제
            checkElement.forEach((ele)=>{
                ele.parentNode.parentNode.parentNode.remove();
            })
			//3. DB에서 조회를 다시 해서 html()
        }

    })

    .catch(()=>alert('알수없는 에러 발생 관리자에 문의'))
});




//jquery
// $("#del").click(function(){

//     let nums = [];
//     let checkElement=[];
//     $(".checks").each(function(idx, item){
//         if($(item).prop("checked")){
//            nums.push($(item).val());
//            checkElement.push(item);
//         }
//     });

//     $.ajax({
//         method:"post",
//         url:"./delete",
//         traditional:true,
//         data:{
//             productNum:nums, 
//         },
//         success:function(result){
//             if(result.trim()>0){
//                //1. location.reload();

//                //2. Element들 삭제
//             //    checkElement.forEach((element)=>{
//             //         $(element).parent().parent().parent().remove();
//             //    })
//                 //3. DB에서 조회를 다시 해서 html()

//             }
//         },
//         error:function(){
//             alert('알수없는 에러 발생 관리자에 문의');
//         }
//     })
//     console.log(nums);

// });

// $('#checkAll').click(()=>{
//     let v = $("#checkAll").prop("checked");

//     $('.checks').prop("checked", v);
// });

// $('.checks').click(function(){
//     let flag=true;

//     $('.checks').each(function(idx, c){

//         if(!$(c).prop('checked')){
//             flag=!flag;
//             return false;
//         }
//     });

//     $("#checkAll").prop("checked", flag);
// })