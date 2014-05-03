var keywords;
var locationParam;

var prevnummoikrug = 0;
var prevnumfreelansim = 0;
var prevnumgoldenline = 0;
var prevnumlinkedin = 0;

var nummoikrug;
var numfreelansim;
var numgoldenline;
var numlinkedin;

var flagmoikrug;
var flagfreelansim;
var flaggoldenline;
var flaglinkedin;

var formClass = "form-fullname form-location form-experience"
			+ " form-education form-skills form-contacts "
			+ "form-additional form-url";

function SaveProfile(event) {
	var btn = event.currentTarget;
	var requestProfile = {};
	$(btn).button('loading');
	var profileChild = btn.parentNode.parentNode.childNodes;
	for (var i = 0; i < profileChild.length; i++) {
		var formClassName = profileChild[i].className;
		if (formClassName != "" /*&& formClass.indexOf(formClassName) != -1*/)
			// добавил добавление контактов в существующий парметр form-contacts, закоментил второе утловие в цикле
			if (requestProfile[formClassName] != undefined) {
				requestProfile[formClassName] = requestProfile[formClassName]
						+ "," + profileChild[i].innerHTML;
			} else {
				requestProfile[formClassName] = profileChild[i].innerHTML;
			}
	}
	$.post("/Client/AddFavorite", requestProfile, function(response) {
		if (response == "error") {
			alert("error");
			$(btn).button('complete');
		} else {
			$(btn).remove();
		}
	});
}

jQuery(document).ready(function() {
	var height = $("#panelsettings").height();
	$("#panelrequest").height(height);
	$("#requestline").css("padding", (height / 3) + "px 10px 0 10px");
	// $("#listmoikrug").val(2);

	$(window).resize(function() {
		var height = $("#panelsettings").height();
		$("#requestline").css("padding", (height / 3) + "px 10px 0 10px");
		$("#panelrequest").height(height);
	});

	$('#switch-change-moikrug').on('switch-change', function(e, data) {
		if (data.value)
			$('#listmoikrug').prop('disabled', false);
		else
			$('#listmoikrug').prop('disabled', true);
	});

	$('#switch-change-freelansim').on('switch-change', function(e, data) {
		if (data.value)
			$('#listfreelansim').prop('disabled', false);
		else
			$('#listfreelansim').prop('disabled', true);
	});
	
	$('#switch-change-goldenline').on('switch-change', function(e, data) {
			if (data.value)
				$('#listgoldenline').prop('disabled', false);
			else
				$('#listgoldenline').prop('disabled', true);
	});

	$('#switch-change-linkedin').on('switch-change', function(e, data) {
		if (data.value)
			$('#listlinkedin').prop('disabled', false);
		else
			$('#listlinkedin').prop('disabled', true);
	});
	$('#btn').button('complete');
});

function NextPage() {
	var requestdata = {};
	requestdata.keywords = keywords;
	if (locationParam != "")
		requestdata.city = locationParam;
	if (!flagfreelansim) {
		requestdata.numfreelansim = numfreelansim;
		requestdata.prevnumfreelansim = prevnumfreelansim;
	}
	if (!flagmoikrug) {
		requestdata.nummoikrug = nummoikrug;
		requestdata.prevnummoikrug = prevnummoikrug;
	}
	if (!flaggoldenline) {
		requestdata.numgoldenline = numgoldenline;
		requestdata.prevnumgoldenline = prevnumgoldenline;
	}
	if(!flaglinkedin) {
		requestdata.numlinkedin = numlinkedin;
		requestdata.prevnumlinkedin = prevnumlinkedin;
	}
	$('#btn-more').button('loading');
	$.post("/Client/SendRequest", requestdata, function(response) {
		$('#btn-more').button('complete');
		if (response == "error")
			$('#auth-error').show();
		else {
			$("#panelresult").append(response);
			if (!flagfreelansim) {
				prevnumfreelansim += numfreelansim;
			}
			if (!flagmoikrug) {
				prevnummoikrug += nummoikrug;
			}
			if (!flaggoldenline) {
				prevnumgoldenline += numgoldenline;
			}
			if (!flaglinkedin) {
				prevnumlinkedin += prevnumlinkedin;
			}
		}
	});
}

function SubmitForm() {

	keywords = $('#keywords').val();
	locationParam = $('#location').val();
	flagfreelansim = $('#listfreelansim').prop("disabled");
	flagmoikrug = $('#listmoikrug').prop("disabled");
	flaggoldenline = $('#listgoldenline').prop("disabled");
	flaglinkedin = $('#listlinkedin').prop("disabled");

	if (keywords == "")
		$('#error').show();
	else if (flagfreelansim && flagmoikrug && flaggoldenline && flaglinkedin)
		$('#disable-error').show();
	else {
		$('#error').hide();
		$('#disable-error').hide();
		var requestdata = {};
		requestdata.keywords = keywords;
		if (locationParam != "")
			requestdata.city = locationParam;
		if (!flagfreelansim) {
			numfreelansim = parseInt($('#listfreelansim').val(), 10);
			requestdata.numfreelansim = numfreelansim;
			requestdata.prevnumfreelansim = prevnumfreelansim;
		}

		if (!flagmoikrug) {
			nummoikrug = parseInt($('#listmoikrug').val(), 10);
			requestdata.nummoikrug = nummoikrug;
			requestdata.prevnummoikrug = prevnummoikrug;
		}
		
		if(!flaglinkedin){
			numlinkedin = parseInt($('#listlinkedin').val(), 10);
			requestdata.numlinkedin = numlinkedin;
			requestdata.prevnumlinkedin = prevnumlinkedin;
		}
		
		
		if (!flaggoldenline) {
			numgoldenline = parseInt($('#listgoldenline').val(), 10);
			requestdata.numgoldenline = numgoldenline;
			requestdata.prevnumgoldenline = prevnumgoldenline;
		}
		$('#btn').button('loading');
		$.post("/Client/SendRequest", requestdata, function(response) {
			$('#btn').button('complete');
			if (response == "error")
				$('#auth-error').show();
			else {
				$("#showprofiles").show();
				$("#showfinder").hide();
				$("#panelresult").html(response);
				if (!flagfreelansim) {
					prevnumfreelansim += numfreelansim;
				}
				if (!flagmoikrug) {
					prevnummoikrug += nummoikrug;
				}
				if (!flaggoldenline) {
					prevnumgoldenline += numgoldenline;
				}
				if(!flaglinkedin){
					prevnumlinkedin+=numlinkedin;
				}
			}
		});
	}
}

function logOut() {

	$.get("/Client/Logout", function(response) {
		if (response == "ok") {
			window.location.href = "/Client/login.jsp";
		} else
			$('logout-error').show();
	});
}

$('.tooltip-demo').tooltip({
	selector : "[data-toggle=tooltip]",
	container : "body"
});

$("[data-toggle=popover]").popover();