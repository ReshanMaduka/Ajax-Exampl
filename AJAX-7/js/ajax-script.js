// $("#btnSave").click(function(){
//
//     var httpRequest = new XMLHttpRequest();
//
//     httpRequest.onreadystatechange = function(){
//         if (httpRequest.readyState === 4 & httpRequest.status === 200){
//             alert(httpRequest.responseText);
//         }
//     };
//
//     httpRequest.open('POST','save-customer.php',true);
//
//     httpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
//
//
//     var queryString = $("#frmCustomer").serialize();
//
//     httpRequest.send(queryString);
// });

$("#btnSave").click(function () {

    var ajaxConfing={
        method:"POST",
        url:"save-customer.php",
        async: true
    };

    $.ajax(ajaxConfing).done(function (response) {
        console.log(response);

    }).fail(function () {
        alert("how")
    });

});