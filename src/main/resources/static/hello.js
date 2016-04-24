$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/spring-web-training/cors/training"
    }).then(function(data, status, jqxhr) {
       $('#trainingId').append(data.id);
       $('#trainingTitle').append(data.trainingTitle);
       $('#trainerName').append(data.trainerName);
       console.log(jqxhr);
    });
});
