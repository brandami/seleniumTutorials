
$(".menu").click(function() {
	if ($("header nav:visible").length) {
		$(".menu").attr('src', 'img/menu.png');
		$("header nav").hide();
	}
	else {
		$(".menu").attr('src', 'img/down.png');
		$("header nav").show();
	}
});

$("#absenden").click(function(event) {
	alert("Willkommen " + $("#anrede").val() + " " + $("#vorname").val() + " " + $("#nachname").val() + "!");
	event.preventDefault();
});