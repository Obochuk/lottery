var loadFile = function (event) {
    var output = document.getElementById("loaded");
    output.src = URL.createObjectURL(event.target.files[0]);
    output.style.maxHeight = "450px";

    jQuery(document).ready(function () {
        output.hidden = false;

        jQuery('#loaded').Jcrop({
            allowSelect: false,
            allowMove: true,
            allowResize: true,
            aspectRatio: 1,
            minSize: [150, 150],
            setSelect: [0, 0, 150, 150],

            onSelect: setCoordinates,
            onChange: setCoordinates
        })
    })
};

function setCoordinates(c) {
    $('#x').val(c.x);
    $('#y').val(c.y);
    $('#w').val(c.w);
    $('#h').val(c.h);
}