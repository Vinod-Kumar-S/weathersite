$(document).ready(function () {
        var latitude = '',
            longitude = '';

        $("#lat").change(function () {
            var validate = Validate("lat");
            $("#mes").html(validate);
            latitude = $(this).val();
            if (validate.length == 0 && $('#lon').val() != null) {

               getLatLong();
            }
        });

        $("#lon").change(function () {
            var validate = Validate("lon");
            $("#mes").html(validate);
            longitude = $(this).val();
            if (validate.length == 0 && $('#lat').val() != null) {

               getLatLong();
            }
        });

        var getLatLong = function(){
            const servletUrl = "/bin/weather/api/v1/hourlyweather";
            $.ajax({
                type: "GET",
                 url: servletUrl,
                 data: {lat: latitude, lon: longitude},
                dataType: "json",
                success: function (result, status, xhr) {
                    var humidity = result.current && result.current.humidity ? result.current.humidity : "Not Available";
                    var pressure = result.current && result.current.pressure ? result.current.pressure : "Not Available";
                    var sunrise = result.current && result.current.sunrise ? result.current.sunrise : "Not Available";
                    var sunset = result.current && result.current.sunset ? result.current.sunset : "Not Available";
                    var temp = result.current && result.current.temp ? result.current.temp : "Not Available";

                    $('#pressure').val("Pressure : "+ pressure);
                    $('#humiditylatlon').val("Humidity : "+ humidity);

                    $('#sunriselatlon').val("Sunrise  : " + sunrise);
                    $('#sunsetlatlon').val("Sun Set  : " + sunset);
                    $('#temp').val("Temperature in F : "+ temp);

                },
                error: function (xhr, status, error) {
                    console.log("Result: " + status + " " + error + " " + xhr.status + " " + xhr.statusText)
                }
            });
        }

    function Validate(type) {
        var errorMessage = "";
        if (type == "lat" && $("#lat").val() == null) {
            errorMessage = "Latitude is Incorrect";
        }
        if (type == "lon" && $("#lon").val() == null) {
            errorMessage = "Longitude is Incorrect";
        }
        return errorMessage;
    }
    });

    /*
    $(document).ready(function () {
            $("#citySel").change(function () {
                var validate = Validate();
                $("#message").html(validate);
                if (validate.length == 0) {
                    const servletUrl = "/bin/weather/api/v1/weatherfivedays";
                    $.ajax({
                        type: "GET",
                         url: servletUrl,
                         data: {q: $(this).val()},
                        dataType: "json",
                        success: function (result, status, xhr) {

                            $('#currentTemp').val("Current Temperature : " + result["main"]["temp"]);
                            $('#maxTemp').val("Maximum Temperature : "+ result["main"]["temp_max"]);
                            $('#minTemp').val("Minimum Temperature : "+ result["main"]["temp_min"]);
                            $('#humidity').val("Humidity : "+ result["main"]["humidity"]);
                            $('#description').val("Description : "+ result["weather"]["description"]);


                        },
                        error: function (xhr, status, error) {
                            console.log("Result: " + status + " " + error + " " + xhr.status + " " + xhr.statusText)
                        }
                    });
                }
            });

    */
    /*function getState(countryId)
    {
       var strURL="findState.php?country="+countryId;
       var req = getXMLHTTP();
       if (req)
       {
         req.onreadystatechange = function()
         {
          if (req.readyState == 4)
          {
         // only if "OK"
         if (req.status == 200)
             {
            document.getElementById('statediv').innerHTML=req.responseText;
         } else {
           alert("There was a problem while using XMLHTTP:\n" + req.statusText);
         }
           }
          }
       req.open("GET", strURL, true);
       req.send(null);
       }
    }*//*


        function Validate() {
            var errorMessage = "";
            if ($("#citySelect").val() == "Select") {
                errorMessage += "Select City";
            }
            return errorMessage;
        }
        });*/
    $(document).ready(function () {
            $("#cityname").change(function () {
                var validate = Validate();
                $("#msg").html(validate);
                if (validate.length == 0) {
                    const servletUrl = "/bin/weather/api/v1/weatherfivedays";
                    $.ajax({
                        type: "GET",
                         url: servletUrl,
                         data: {q: $(this).val()},
                        dataType: "json",
                        success: function (result, status, xhr) {


                            $('#sunrise').val("Sunrise  : " + result["city"]["sunrise"]);
                            $('#sunset').val("Sunset  : " + result["city"]["sunset"]);
                            $('#population').val("Population  : " + result["city"]["population"]);
                            $('#timezone').val("Timezone  : " + result["city"]["timezone"]);
    //                      $('#maxTemperature').val("Maximum Temperature : "+ result["list"]["main"]["temp_min"]);
    //                      $('#minTemperature').val("Minimum Temperature : "+ result["list"]["main"]["temp_max"]);
    //                      $('#humidity').val("humid : "+ result["list"]["main"]["humidity"]);
                        },
                        error: function (xhr, status, error) {
                            console.log("Result: " + status + " " + error + " " + xhr.status + " " + xhr.statusText)
                        }
                    });
                }
            });


        function Validate() {
            var errorMessage = "";
            if ($("#cityname").val() == "Select") {
                errorMessage += "Select City";
            }

            return errorMessage;
        }
        });

        $(document).ready(function () {
                $("#cityname").change(function () {
                    var validate = Validate();
                    $("#message").html(validate);
                    if (validate.length == 0) {
                        const servletUrl = "/bin/weather/api/v1/currentweather";
                        $.ajax({
                            type: "GET",
                             url: servletUrl,
                             data: {q: $(this).val()},
                            dataType: "json",
                            success: function (result, status, xhr) {


                                $('#currentTemp').val("Current Temperature : " + result["main"]["temp"]);
                                $('#maxTemp').val("Maximum Temperature : "+ result["main"]["temp_min"]);
                                $('#minTemp').val("Minimum Temperature : "+ result["main"]["temp_max"]);
                                $('#humidity').val("Humidity : "+ result["main"]["humidity"]);


                            },
                            error: function (xhr, status, error) {
                                console.log("Result: " + status + " " + error + " " + xhr.status + " " + xhr.statusText)
                            }
                        });
                    }
                });


            function Validate() {
                var errorMessage = "";
                if ($("#citySelect").val() == "Select") {
                    errorMessage += "Select City";
                }
                return errorMessage;
            }
            });