console.log("FileManager");

{/* <div class="input-group">
        <input class="form-control" type="file" name="attachs">
        <span class="input-group-text text-danger">X</span>
    </div> */}

// const filelist = document.getElementById("filelist");
// const fileAdd = document.getElementById("fileAdd");

// let num = 0;

// fileAdd.addEventListener("click",()=>{
//     num++;

//     console.log("aaaaaa");

//     let div = document.createElement("div");
//     let dc = document.createAttribute("class");
//     dc.value="input-group my-3";
//     div.setAttribute(dc);
//     filelist.setAttribute(div);

//     let input = document.createElement("input");
//     let ic = document.createAttribute("class");
//     ic.value="form-control";
//     let it = document.createAttribute("type");
//     it.value="file";
//     let name = document.createAttribute("name");
//     name.value="attachs";
//     input.setAttribute(ic);
//     input.setAttribute(it);
//     input.setAttribute(name);
//     div.appendChild(input);

//     let span = document.createElement("span");
//     let spanAttr = document.createAttribute("class");
//     spanAttr.value="input-group-text text-danger del";
//     span.setAttribute(spanAttr);

//     let x = document.createTextNode("X");

//     div.appendChild(span);
//     span.appendChild(x);


// })


//-------------------------jquery

let num = 0;

$("#fileAdd").click(()=>{
    // let element = '<div class="input-group my-2">';
    // element= element+ '<input class="form-control" type="file" name="attachs"></input>';
    // element= element+ '<span class="input-group-text text-danger del">X</span>';
    // element= element+ '</div>';

    num++;
    if(num>5){
        alert('5개까지만 추가가능');
        return false;
    };

    let element = 
    `<div class="input-group">
        <input class="form-control" type="file" name="attachs">
        <span class="input-group-text text-danger">X</span>
    </div>`

    //`<-엔터도 포함?`

    $("#filelist").append(element);
})

$(".del").click(()=>{
    alert("Del Click");
})