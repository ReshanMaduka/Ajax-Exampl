/**
 * Created by Reshan on 28/09/2018.
 */
function initialize() {
    var myLatlng = new google.maps.LatLng(41.38, 2.18);
    var myOptions = {
        zoom: 13,
        center: myLatlng
    }
    var map = new google.maps.Map(document.getElementById("map"), myOptions);
    var geocoder = new google.maps.Geocoder();

    google.maps.event.addListener(map, 'click', function(event) {
        geocoder.geocode({
            'latLng': event.latLng
        }, function(results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                if (results[0]) {
                    alert(results[0].formatted_address);
                }
            }
        });
        alert()
    });
}