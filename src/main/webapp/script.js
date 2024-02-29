var servlet = "/candy-shop";
var storePath = "/store";
var productPath = "/store/product"

async function getProductInfo(){
var name = document.getElementById("name").value;
var price = document.getElementById("price").value;
var amount = document.getElementById("amount").value;
var url = servlet + productPath;
var response = await fetch(url, {
             method: "GET" });

      if(response.ok){
     var body = await response.json();
      }
}

async function postProductNameToBuy(){

}

async function receiveProductsList(){
var url = servlet + storePath;
var response = await fetch(url , {
     mode: "cors",
     method: "GET";
});
     if(response.ok){
     var body = await response.json();
     const array = body.split("\n");

     //... needs to be finished

} else {
alert("the list hasn't been sent");
}
}


document.getElementById("sneakers_button").addEventListener("click", function () {
var newDiv = document.createElement("div");
newDiv.textContent = "sneakers";

document.getElementById("container").appendChild(newDiv);
});