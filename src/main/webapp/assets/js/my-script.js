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


$(document).ready(function () {
    $('#film_tpHanoi').on('click', function () {
        var cityName = $("#filmHanoi").val();
        $.ajax({
            url: "/films/"+cityName, type: "GET", dataType: "text",
            data: {cityName: cityName.toString()},
            success: function (data) {
                window.history.pushState("", "", cityName);
                $('#listFilms').html(data);
            }
        });
    })
});

$(document).ready(function () {
    $('#film_tpHochiminh').on('click', function () {
        var cityName = $("#filmHochiminh").val();
        $.ajax({
            url: "/films/"+cityName, type: "GET", dataType: "text",
            data: {cityName: cityName.toString()},
            success: function (data) {
                window.history.pushState("", "", cityName);
                $('#listFilms').html(data);
            }
        });
    })
});

$(document).ready(function () {
    $('#film_tpHaiphong').on('click', function () {
        var cityName = $("#filmHaiphong").val();
        $.ajax({
            url: "/films/"+cityName, type: "GET", dataType: "text",
            data: {cityName: cityName.toString()},
            success: function (data) {
                window.history.pushState("", "", cityName);
                $('#listFilms').html(data);
            }
        });
    })
});

$(document).ready(function () {
    $('#film_tpDanang').on('click', function () {
        var cityName = $("#filmDanang").val();
        $.ajax({
            url: "/films/"+cityName, type: "GET", dataType: "text",
            data: {cityName: cityName.toString()},
            success: function (data) {
                window.history.pushState("", "", cityName);
                $('#listFilms').html(data);
            }
        });
    })
});

$(document).ready(function () {
    $('#film_tpNhatrang').on('click', function () {
        var cityName = $("#filmNhatrang").val();
        $.ajax({
            url: "/films/"+cityName, type: "GET", dataType: "text",
            data: {cityName: cityName.toString()},
            success: function (data) {
                window.history.pushState("", "", cityName);
                $('#listFilms').html(data);
            }
        });
    })
});

$(document).ready(function () {
    $('#film_tpDongnai').on('click', function () {
        var cityName = $("#filmDongnai").val();
        $.ajax({
            url: "/films/"+cityName, type: "GET", dataType: "text",
            data: {cityName: cityName.toString()},
            success: function (data) {
                window.history.pushState("", "", cityName);
                $('#listFilms').html(data);
            }
        });
    })
});