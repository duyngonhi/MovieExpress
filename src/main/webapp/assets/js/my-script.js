$(document).ready(function () {
    $('#btnCloneData').on('click', function (e) {
        e.preventDefault();
        var cityName = $("#cityName").val();
        $.ajax({
            url: "/clone-data/" + cityName, type: "GET", dataType: "text",
            data: {cityName: cityName.toString()},
            success: function (data) {
                $('#msg_success').text("Clone data at " +cityName+ " success")
            },
            error: function (data) {
                $('#msg_error').text("Clone data at " +cityName+ " fail")
            }
        });
    })
});
