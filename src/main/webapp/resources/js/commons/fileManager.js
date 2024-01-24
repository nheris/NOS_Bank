console.log("FileManager");

{/* <div class="input-group">
        <input class="form-control" type="file" name="attachs">
        <span class="input-group-text text-danger">X</span>
    </div> */}

let count=0; //현재 count
let max=5;   //최대 갯수

//-------------------------js

// const filelist = document.getElementById("filelist");
// const fileAdd = document.getElementById("fileAdd");
// const del = document.getElementsByClassName("del");

// filelist.addEventListener("click", (e)=>{
//     //console.log(e) //이벤트 자체 
//     //console.log(e.target) //자식안에 실제 누른애들, 엘리먼트자체 전체 들고옴
//  	//console.log(e.target.classList.contains('del'))
//     if(e.target.classList.contains('del')){

//         //e.target.parentNode.remove();
//         let id = e.target.getAttribute("data-file-id");
//         document.getElementById(id).remove();
//         count--;
//     }
// })


// let idx=0;

// fileAdd.addEventListener("click", ()=>{
//     if(count>=max){
//         alert('파일은 최대 5개 까지 가능');
//         return;
//     }
//     count++;
//     idx++;
//     let div = document.createElement("div"); //<div></div>
//     let ac = document.createAttribute("class"); //class=
//     ac.value="input-group my-3";                     //class="input-group"
//     div.setAttributeNode(ac);                   // <div class="input-group"></div>

//     //id추가
//     ac = document.createAttribute("id");
//     ac.value="file"+idx;

//     div.setAttributeNode(ac);

//     let child = document.createElement("input"); //<input>

//     ac = document.createAttribute("class");
//     ac.value="form-control";
//     child.setAttributeNode(ac);

//     ac = document.createAttribute("type")
//     ac.value="file";
//     child.setAttributeNode(ac);

//     ac = document.createAttribute("name")
//     ac.value="attachs";
//     child.setAttributeNode(ac);

//     div.appendChild(child);

//     child=document.createElement("span");
//     ac = document.createAttribute("class")
//     ac.value="input-group-text text-danger del";
//     child.setAttributeNode(ac);

//     ac = document.createTextNode("X");
//     child.appendChild(ac);

//     ac = document.createAttribute("data-file-id")
//     ac.value="file"+idx;

//     child.setAttributeNode(ac);

//     div.appendChild(child);

//     filelist.appendChild(div);


// })


//-------------------------jquery

let ctncheck = 0;
max = $("#filelist").attr('.data-file-max');
console.log(max);
$("#fileAdd").click(()=>{

//     // let element = '<div class="input-group">';
//     // element+= '<input class="form-control" type="file" name="attachs">';
//     // element+='<span class="input-group-text text-danger" >X</span>';
//     // element+='</div>';
//     // $("#filelist").append(element);
    ctncheck++;
    if(ctncheck>=6){
        alert("최대 5개임");
        $(element).remove();
    }
    let element =`<div class="input-group">
    <input class="form-control" type="file" name="attachs">
    <span class="input-group-text text-danger del" >X</span>
    </div>`
    //`<-엔터도 포함?

    $("#filelist").append(element);
});


//$('.del').click()
$('.del').on("click", function(){
    alert("del");
});


