$(document).ready(function () {
    bootbox.setDefaults({'locale': 'id'});
    $(".alert").addClass("in").fadeOut(4500);

    /* swap open/close side menu icons */
    $('[data-toggle=collapse]').click(function () {
        // toggle icon
        $(this).find("i").toggleClass("glyphicon-chevron-right glyphicon-chevron-down");
    });
});

function selectAllItems() {
    $('input[id=checkItem]').map(function () {
        $(this).prop('checked', $('input[id=checkAll]').is(':checked'));
    });
}
;

function itemSelected(countItem) {
    if (!countItem)
        countItem = 10;

    if ($('input[id=checkItem]').length < countItem) {
        countItem = $('input[id=checkItem]').length;
    }

    $('input[id=checkAll]').prop('checked', $('input[id=checkItem]:checked').length == countItem);
}

function showError(obj){
    if(obj && obj.message){
        bootbox.alert(obj.message);
    } else {
        bootbox.alert("System Error");
    }
}