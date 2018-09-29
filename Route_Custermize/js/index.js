var geocoder;
var map;


function initialize() {

    var latitude =  7.8731; // YOUR LATITUDE VALUE
    var longitude = 85.3239605; // YOUR LONGITUDE VALUE

    var myLatLng = {lat: latitude, lng: longitude};

    var directionsDisplay;
    var directionsService = new google.maps.DirectionsService();
    var locations = [
        ['Nalagasdeniya',6.1378, 80.1139] ,
        ['Hikkaduwa', 6.1395, 80.1063],
        ['Galle',6.0250, 80.2180]
    ];
    directionsDisplay = new google.maps.DirectionsRenderer();


    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 8,
        center: myLatLng,
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        disableDoubleClickZoom: true, // disable the default map zoom on double click
    });
    directionsDisplay.setMap(map);
    var infowindow = new google.maps.InfoWindow();

    var marker, i;
    var request = {
        travelMode: google.maps.TravelMode.DRIVING
    };
    for (i = 0; i < locations.length; i++) {
        marker = new google.maps.Marker({
            position: new google.maps.LatLng(locations[i][1], locations[i][2]),
        });

        google.maps.event.addListener(marker, 'click', (function(marker, i) {
            return function() {
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
    // Create new marker on double click event on the map
    google.maps.event.addListener(map, 'dblclick', function (event) {
        var marker = new google.maps.Marker({
            position: event.latLng,
            map: map,
            title: event.latLng.lat() + ', ' + event.latLng.lng()
        });
        alert('lat:'+event.latLng.lat()+'lang'+ event.latLng.lng());

        // Update lat/long value of div when the marker is clicked
        marker.addListener('click', function () {
            document.getElementById('latclicked').innerHTML = event.latLng.lat();
            document.getElementById('longclicked').innerHTML = event.latLng.lng();
        });
    });


    directionsService.route(request, function(result, status) {
        if (status == google.maps.DirectionsStatus.OK) {
            directionsDisplay.setDirections(result);
        }
    });
}