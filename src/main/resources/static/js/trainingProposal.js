window.onload = () => {
    let requestedDate = document.getElementById("RequestedTrainingStartDate").value;

    document.getElementById("ProposedDate").setAttribute('min', requestedDate);
}

function hideShowElements(status) {
    if( status ) {
        document.getElementById("form__message").classList.add('d-none');
        document.getElementById("form__inputs").classList.remove('d-none');
    } else {
        document.getElementById("form__message").classList.remove('d-none');
        document.getElementById("form__inputs").classList.add('d-none');
    }
}

const serializeForm = form => JSON.stringify(
    Array.from(new FormData(form).entries())
        .reduce((m, [ key, value ]) => Object.assign(m, { [key]: value }), {})
);

$('#trainingProposalForm').on('submit', function(event) {
    event.preventDefault();
    const data = serializeForm(this);

    if(data.includes("proposalID")) {
        $.ajax({
            type: 'PATCH',
            url: 'http://localhost:8081/trainingProposal/update',
            dataType: 'json',
            data: data,
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
            data: data,
            contentType: 'application/json',
            success: function() {
                location.href = "http://localhost:8081/dashboard"
            },
            error: function() {
                console.log("Error in the save");
                location.href = "http://localhost:8081/dashboard"
            }
        });
    }
});