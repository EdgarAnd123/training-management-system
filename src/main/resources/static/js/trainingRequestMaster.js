window.onload = () => {
    document.getElementById("RequirementReceivedData").valueAsDate = new Date();

    let today = new Date().toISOString().split('T')[0];
    document.getElementById("RequestedTrainingStartDate").setAttribute('min', today);
}

const serializeForm = form => JSON.stringify(
    Array.from(new FormData(form).entries())
        .reduce((m, [ key, value ]) => Object.assign(m, { [key]: value }), {})
);

$('#trainingRequestForm').on('submit', function(event) {
    event.preventDefault();
    const data = serializeForm(this);

    if(data.includes("requirementID")) {
        $.ajax({
            type: 'PATCH',
            url: 'http://localhost:8081/trainingRequest/update',
            dataType: 'json',
            data: data,
            contentType: 'application/json',
            statusCode: {
                200: function(){
                    alert("Successfully saving");
                    location.href = "http://localhost:8081/dashboard"
                },
                500: function() {
                    alert("Error saving data");
                }
            }
        });
    } else {
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8081/trainingRequest/save',
            dataType: 'json',
            data: data,
            contentType: 'application/json',
            statusCode: {
                200: function(){
                    alert("Successfully saving");
                    location.href = "http://localhost:8081/dashboard"
                },
                500: function() {
                    alert("Error saving data");
                }
            }
        });
    }
});