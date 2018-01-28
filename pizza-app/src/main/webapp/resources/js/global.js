$(document).ready(function(){

	$("#logout").click(function(e){
		e.preventDefault();
		$("#logout-form").submit();
	});
});


$(document).ready(function() {
    $("#toppingMeatball").click(function() {
        var checkBoxes = $("#toppingChicken");
        //checkBoxes.prop("checked", !checkBoxes.prop("checked"));
        $('input:checkbox[id=toppingChicken]').attr('checked',false);
    });                 
});

$(document).ready(function() {
    $("#toppingChicken").click(function() {
        var checkBoxes = $("#toppingMeatball");
        //checkBoxes.prop("checked", !checkBoxes.prop("checked"));
        $('input:checkbox[id=toppingMeatball]').attr('checked',false);
    });                 
});