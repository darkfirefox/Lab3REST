$("#editModal").on('show.bs.modal', function(event) {
    var patientId = $(event.relatedTarget).data('patient-id');
    var cols = $('#patientId-' + patientId + ' td');
    fillCrudPatient(patientId, cols, false)
});

$("#editModal").on('hidden.bs.modal', function() {
    var form = $(this).find('form');
    form[0].reset();
});

function fillCrudPatient(id, cols, isDel) {
    var firstname = $(cols[0]).text();
    var fathername = $(cols[1]).text();
    var lastname = $(cols[2]).text();
    var phone = $(cols[3]).text();
    if (isDel) {
        $('#idDel').val(id);
        $('#firstnameDel').val(firstname);
        $('#fathernameDel').val(fathername);
        $('#lastnameDel').val(lastname);
        $('#phoneDel').val(phone)
    } else {
        $('#idEdit').val(id);
        $('#firstnameEdit').val(firstname);
        $('#fathernameEdit').val(fathername);
        $('#lastnameEdit').val(lastname);
        $('#phoneEdit').val(phone)
    }
}

function deleteRow(id) {
    var cols = $('#patientId-' + id + ' td');
    fillCrudPatient(id, cols, true);
    document.forms["removePatient"].submit();
}

$('document').ready(function () {
    $('#dtBasicExample').DataTable();
    $('.dataTables_length').addClass('bs-select');
})