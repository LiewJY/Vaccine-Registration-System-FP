% Step 1: Read data from the txt document
read_file_lines(FileName, Lines) :-
    open(FileName, read, Stream),
    read_lines(Stream, Lines),
    close(Stream).
 
read_lines(Stream, []) :- at_end_of_stream(Stream).
read_lines(Stream, [Line|Rest]) :-
    \+ at_end_of_stream(Stream),
    read_line_to_string(Stream, Line),
    read_lines(Stream, Rest).
 
% Read the txt file lines and map it to VaccinationStatusRecords
get_appointment_records(VaccinationStatusRecords) :-
    read_file_lines('appointment.txt', Lines),
    maplist(parse_record, Lines, VaccinationStatusRecords).
 
parse_record(Line, Record) :-
    atomic_list_concat([Id, _, _,_, Dose, DoseStatus, ''], '//', Line),
    Record = vaccination_status_record(Id, Dose, DoseStatus).

% Step 2: Filter and query the wanted record
% Count the pending one dose vaccine numbers
count_pending_1_vaccination_status_records(VaccinationStatusRecords, Count) :-
    get_appointment_records(VaccinationStatusRecords),
    include(has_pending_1_status, VaccinationStatusRecords, PendingRecords),
    length(PendingRecords, Count).

has_pending_1_status(vaccination_status_record(_, Dose, Status)) :-
    Status = 'Pending',
    Dose = '1'.

% Count the completed one dose vaccine numbers
count_completed_1_vaccination_status_records(VaccinationStatusRecords, Count) :-
    get_appointment_records(VaccinationStatusRecords),
    include(has_completed_1_status, VaccinationStatusRecords, CompletedRecords),
    length(CompletedRecords, Count).

has_completed_1_status(vaccination_status_record(_, Dose, Status)) :-
    Status = 'Completed',
    Dose = '1'.

% Count the pending two dose vaccine numbers
count_pending_2_vaccination_status_records(VaccinationStatusRecords, Count) :-
    get_appointment_records(VaccinationStatusRecords),
    include(has_pending_2_status, VaccinationStatusRecords, PendingRecords),
    length(PendingRecords, Count).

has_pending_2_status(vaccination_status_record(_, Dose, Status)) :-
    Status = 'Pending',
    Dose = '2'.

% Count the completed two dose vaccine numbers
count_completed_2_vaccination_status_records(VaccinationStatusRecords, Count) :-
    get_appointment_records(VaccinationStatusRecords),
    include(has_completed_2_status, VaccinationStatusRecords, CompletedRecords),
    length(CompletedRecords, Count).

has_completed_2_status(vaccination_status_record(_, Dose, Status)) :-
    Status = 'Completed',
    Dose = '2'.