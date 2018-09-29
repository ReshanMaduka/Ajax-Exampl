var geocoder;
var map;
function initialize() {
    var latitude = 6.1395; // YOUR LATITUDE VALUE
    var longitude = 80.1063; // YOUR LONGITUDE VALUE
    var directionsService = new google.maps.DirectionsService();
    var directionsDisplay = new google.maps.DirectionsRenderer();
    var myLatLng = {lat: latitude, lng: longitude};

    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 18,
        center: myLatLng,
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        disableDoubleClickZoom: true // disable the default map zoom on double click
    });
    // ..
    var mainmarker = new google.maps.Marker({
        position: myLatLng,
        map: map,
        //title: 'Hello World'

        // setting latitude & longitude as title of the marker
        // title is shown when you hover over the marker
        title: latitude + ', ' + longitude
    });

    //get Address
    google.maps.event.addListener(map, 'click', function (event) {
        var geocoder = new google.maps.Geocoder();
        geocoder.geocode({
            'latLng': event.latLng
        }, function(results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                if (results[0]) {
                    alert(results[0].formatted_address);
                }
            }
        });
    });
    // Create new marker on double click event on the map
    google.maps.event.addListener(map, 'dblclick', function (event) {

        directionsDisplay.setMap(map);
        var infowindow = new google.maps.InfoWindow();

        var geocoder = new google.maps.Geocoder();

         marker = new google.maps.Marker({
             position: myLatLng,
            map: map,
            title: event.latLng.lat() + ', ' + event.latLng.lng()
        });

        var locations = [
            // ['Nalagasdeniya',6.1378, 80.1139] ,
            ['Hikkaduwa', 6.1395, 80.1063],
            ['address',6.14053399051958 ,80.10008421546195],
            ['address',6.14053399051958 ,80.10008421546195],
        ];

        var table = document.getElementById("myTable");
        var row = table.insertRow(0);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        cell1.innerHTML = 'address';
        cell2.innerHTML = event.latLng.lat();
        cell3.innerHTML = event.latLng.lng();

        $("table#myTable tr").each(function() {
            var arrayOfThisRow = [];
            var tableData = $(this).find('td');
            if (tableData.length > 0) {
                tableData.each(function() { arrayOfThisRow.push($(this).text()); });
                locations.push(['cds',event.latLng.lat(),event.latLng.lng()]);
            }
        });
        // alert(locations);
        // alert(locations.length);
        var marker, i;
        var request = {
            travelMode: google.maps.TravelMode.DRIVING
        };

        for (i = 0; i < locations.length; i++) {
            marker = new google.maps.Marker({
                position: new google.maps.LatLng(locations[i][1], locations[i][2]),
            });

            google.maps.event.addListener(marker, 'click', (function (marker, i) {
                return function () {
                    infowindow.setContent(locations[i][0]);
                    infowindow.open(map, marker);
                }
            })(marker, i));

            if (i == 0) request.origin = marker.getPosition();
            else if (i == locations.length - 1) request.destination = marker.getPosition();
            else {
                if (!request.waypoints) request.waypoints = [];
                request.waypoints.push({
                    location: marker.getPosition(),
                    stopover: true
                });
            }

        }
        directionsService.route(request, function (result, status) {
            if (status == google.maps.DirectionsStatus.OK) {
                directionsDisplay.setDirections(result);
            }
        });
        // Update lat/long value of div when the marker is clicked
        marker.addListener('click', function () {
            document.getElementById('latclicked').innerHTML = event.latLng.lat();
            document.getElementById('longclicked').innerHTML = event.latLng.lng();
        });
    });
}



