<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title> JSON Data to TMobile UI </title>
	<script src="../../resources/jquery/jquery-3.3.1.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>
	<div class="container">
		<div class="table-responsive">
			<h1>T Mobile HAproxy Config</h1>
			<br/>
			<table class="table table-bordered table-striped" id="haproxy-table">
				<tr>
					<td>Select a File to Load:</td>
					<td><input type="file" id="fileToLoad"></td>
					<td><button onclick="loadFileAsText()">Load Selected File</button><td>
				</tr>
			</table>
		</div>
	</div>
</body>
<script>
	function loadFileAsText(){
		var fileToLoad = document.getElementById("fileToLoad").files[0];
		alert(fileToLoad.val())
		var fileReader = new FileReader();
		fileReader.onload = function(fileLoadedEvent){
			var textFromFileLoaded = fileLoadedEvent.target.result;
			document.getElementById("inputTextToSave").value = textFromFileLoaded;
		};

		fileReader.readAsText(fileToLoad, "UTF-8");
	}
</script>
</html>