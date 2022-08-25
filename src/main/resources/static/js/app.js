var jsonStreamObject = null;


$(document).ready(function() {
	
	connectEventSource();
	
});

function connectEventSource() {
	
	if(jsonStreamObject!=null)
		jsonStreamObject.close();
	
	jsonStreamObject = new EventSource("http://localhost:8080/stockprice");
	
	jsonStreamObject.onmessage = function(e) {
		
		
			var message = JSON.parse(e.data);
			
			$("table tbody").empty();
			
			$.each(message, function(index, value) {
				
				var statusTd = "<td style='color:green;font-weight:bold;'>" + value.status+"</td>";
				if(value.status==="Low") {
					statusTd = "<td style='color:red;font-weight:bold;'>" + value.status+"</td>";
				}
				console.log(value.current);
				console.log(value.voltage);
				var markup = "<tr><td>" + value.current + "</td><td>" + value.voltage
				+ "</td>"+statusTd+"</tr>";
				
				$("table tbody").append(markup);
				
			});
		
	};
}