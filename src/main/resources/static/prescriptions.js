$("#editModal").on('show.bs.modal', function(event) {
    var prescriptionId = $(event.relatedTarget).data('prescription-id');
    var cols = $('#prescriptionId-' + prescriptionId + ' td');
    fillCrudPatient(prescriptionId, cols, false)
});

$("#editModal").on('hidden.bs.modal', function() {
    var form = $(this).find('form');
    form[0].reset();
});

function fillCrudPatient(id, cols, isDel) {
    var doctor = $(cols[0]).text().split(' ')[0];
    var patient = $(cols[1]).text().split(' ')[0];
    var datetime = $(cols[2]).text().replace(' ', 'T');
    var description = $(cols[3]).text();
    var priority = $(cols[4]).text();

    if (isDel) {
        $('#idDel').val(id);
        $('#doctorDel').val(doctor);
        $('#patientDel').val(patient);
        $('#descriptionDel').val(description);
        $('#priorityDel').val(priority);
        $('#datetimeDel').val(datetime);
    } else {
        $('#idEdit').val(id);
        $('#doctorEdit').val(doctor);
        $('#patientEdit').val(patient);
        $('#descriptionEdit').val(description);
        $('#priorityEdit').val(priority);
        $('#datetimeEdit').val(datetime);
    }
}

function deleteRow(id) {
    var cols = $('#prescriptionId-' + id + ' td');
    fillCrudPatient(id, cols, true);
    document.forms["removePrescription"].submit();
}

$('document').ready(function () {
    $('#dtBasicExample').DataTable();
    $('.dataTables_length').addClass('bs-select');
});