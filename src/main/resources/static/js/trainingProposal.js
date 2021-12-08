let formStatus = true;

window.onload = () => {
    let requestedDate = document.getElementById("RequestedTrainingStartDate").value;

    document.getElementById("ProposedDate").setAttribute('min', requestedDate);
}

function hideShowElements(status) {
    if( status ) {
        document.getElementById("form__message").classList.add('d-none');
        document.getElementById("form__inputs").classList.remove('d-none');
        formStatus = true;
    } else {
        document.getElementById("form__message").classList.remove('d-none');
        document.getElementById("form__inputs").classList.add('d-none');
        formStatus = false;
    }
}

$('#trainingProposalForm').on('submit', function(event) {
    event.preventDefault();

    if(!formStatus) {
        document.getElementById("ProposedDate").value = "";
        document.getElementById("ProposedDuration").value = "";
        document.getElementById("ProposedTime").value = "";
    } else {
        document.getElementById("RejectDescription").value = "";
    }

    const formData = serializeForm(this);
    console.log(formData);

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8081/trainingProposal/save',
        dataType: 'json',
        data: formData,
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
    /*if(formData.includes("proposalID")) {
        $.ajax({
            type: 'PATCH',
            url: 'http://localhost:8081/trainingProposal/update',
            dataType: 'json',
            data: formData,
            contentType: 'application/json',
            success: function() {
                location.href = "http://localhost:8081/dashboard"
            },
            error: function() {
                location.href = "http://localhost:8081/dashboard"
            }
        });
    } else {
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8081/trainingProposal/save',
            dataType: 'json',
            data: formData,
            contentType: 'application/json',
            success: function() {
                location.href = "http://localhost:8081/dashboard"
            },
            error: function() {
                console.log("Error in the save");
                location.href = "http://localhost:8081/dashboard"
            }
        });
    }*/
});

function serializeForm(form) {
    return JSON.stringify(
        Array.from(new FormData(form).entries())
            .reduce((m, [ key, value ]) => Object.assign(m, { [key]: value }), {})
    );
}