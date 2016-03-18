<html>

<head>
<script type="text/javascript" src="js/jquery-1.12.1.min.js"></script>

<script type="text/javascript">
	$(document).ready(
			function() {

				var raceRunning = false;

				setInterval(function() {
					btnRefresh();
				}, 500);

				$("#startRace").click(
						function() {
							$.ajax({
								url : "webapi/startRace/" + $("#cars").val()
										+ "/" + $("#rounds").val(),
								success : function(result) {
									btnRefresh();
								}
							});
						});

				$("#stopRace").click(function() {
					$.ajax({
						url : "webapi/stopRace",
						success : function(result) {
							btnRefresh();
							alert("race stopped");
						}
					});
				});

				$("#clearCache").click(function() {
					$.ajax({
						url : "webapi/clearCache",
						success : function() {
						}
					});
				});

				function btnRefresh() {
					$.ajax({
						url : "webapi/checkRaceRunning",
						success : function(result) {
							if (result == true) {
								raceRunning = true;
							} else {
								raceRunning = false;
							}
						}
					});
					$.ajax({
						url : "webapi/quantityOfLaps",
						success : function(result) {
							$("#quantityOfLaps").text(
									"Laps waiting in cache: " + result);
						}
					});
					$.ajax({
						url : "webapi/checkNewLaps",
						success : function(result) {
							if (result == true) {
								raceCache = true;
								$("#warningCache").css("display", "block");
							} else {
								raceCache = false;
								$("#warningCache").css("display", "none");
							}
						}
					});

					setStyles();
				}

				function setStyles() {
					if (raceRunning) {
						$(".raceStarted").css("display", "block");
						$(".raceStopped").css("display", "none");
					} else {
						$(".raceStarted").css("display", "none");
						$(".raceStopped").css("display", "block");
					}
				}

			});
</script>
</head>

<body>
	<h1>Race Simulator</h1>
	<p id="warningRunning" style="background-color: red; display: none"
		class="raceStarted">
		A race is already running...<br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;...please wait until it's finished
	</p>
	<p id="warningCache" style="background-color: orange;">
		laps waiting in cache to be fetched...<br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;...please wait until it's cleared
	</p>
	Cars:
	<input id="cars" value="3" /> Rounds:
	<input id="rounds" value="2" />
	<br />
	<button id="startRace" class="raceStopped">start race</button>
	<p id="quantityOfLaps"></p>
	<button id="stopRace" class="raceStarted">stop race</button>
	<button id="clearCache" class="raceStopped">clear cache</button>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />---------------------------
	<p>
		Impressum:<br />Diese Seite dient lediglich <strong>privater Zwecke</strong> und ist daher von der Impressumspflicht befreit. 
	</p>
</body>

</html>
