window.addEventListener('load', init(), false );
function init() {
    getData();
}

function getData(){

    fetch("/api/v1/map", {
      method: "POST", // or 'PUT'
      headers: {
        "Content-Type": "application/json",
      },
      body: '',
    }).then((response) => response.json())
      .then((data) => {
        console.log("Success:", data);
        let element = document.getElementById("data");
        element.innerText = data.name;
      })
      .catch((error) => {
        console.error("Error:", error);
      });

}