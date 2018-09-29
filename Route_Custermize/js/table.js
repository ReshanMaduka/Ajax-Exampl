/**
 * Created by Reshan on 28/09/2018.
 */
var array = [];
var headers = [];
$('#dataTable th').each(function(index, item) {
    headers[index] = $(item).html();
});
$('#dataTable tr').has('td').each(function() {
    var arrayItem = {};
    $('td', $(this)).each(function(index, item) {
        arrayItem[headers[index]] = $(item).html();
    });
    array.push(arrayItem);
});

