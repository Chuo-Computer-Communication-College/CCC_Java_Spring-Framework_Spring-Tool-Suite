/**
 * 
 */
function action()
{
    var price = document.getElementById("txtPrice").value;
    var resolution = parseInt(price * ((100 + [[${tax}]]) / 100));

    document.getElementById("msg").innerHTML = "Include Tax: " + resolution;
}