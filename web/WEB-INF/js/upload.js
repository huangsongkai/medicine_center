/**
 * Created by song on 16/8/27.
 */
//        $("input[name ='imgUrl']").attr("readonly",true);
var files = [];
$(document)
    .on(
    "change",
    "#fileLoader",
    function (event) {
        files = event.target.files;
    })

$(document)
    .on(
    "click",
    "#fileSubmit",
    function () {
        processUpload();
    })

function processUpload() {
    var oMyForm = new FormData();
    oMyForm.append("file", files[0]);
    console.log(files[0]);
    $.ajax({
        dataType: 'json',
        url: "/upload/file",
        data: oMyForm,
        type: "POST",
        enctype: 'multipart/form-data',
        processData: false,
        contentType: false,
        success: function (result) {
            console.log(result);
            $("input[name ='imgUrl']").val(result);
        },
        error: function (result) {
            //...;
        }
    });
}