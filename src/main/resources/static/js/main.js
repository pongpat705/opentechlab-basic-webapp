window.addEventListener('load', init(), false );
function init() {
    getData();
}

function getData(){

    fetch("/api/v1/map?name=mao", {
      method: "POST", // or 'PUT'
      headers: {
        "Content-Type": "application/json",
      },
      body: '',
    }).then((response) => response.json())
      .then((data) => {
        console.log("Success:", data);
        let element = document.getElementById("data");
        element.innerText = data.result;
      })
      .catch((error) => {
        console.error("Error:", error);
      });

}