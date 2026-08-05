-- inner join

SELECT p.name AS patient_name, a.appointment_date, d.name AS doctor_name
FROM appointments a
JOIN patients p ON a.patient_id = p.patient_id
JOIN doctors d ON a.doctor_id = d.doctor_id;


-- left join

select p.name, a.appointment_date
from Patients p
left join Appointments a
    on p.patient_id = a.patient_id;


-- right join

SELECT d.name AS doctor, a.appointment_date
FROM appointments a
right JOIN doctors d
    ON a.doctor_id = d.doctor_id;


-- full outer join

select p.name, a.appointment_date
from patients p
left join appointments a
    on p.patient_id = a.patient_id

UNION

SELECT p.name, a.appointment_date
FROM Patients p
RIGHT JOIN appointments a
    ON p.patient_id = a.patient_id;


-- self join

select d.name AS doctor, m.name AS mentor
from doctors d
join Doctors m
    on d.mentor_id = m.doctor_id;


-- cross join

SELECT d.name, ts.slot_time
FROM doctors d
cross join TimeSlots ts;


-- multiple table join

select p.name as patient,
       d.name as doctor,
       s.name as specialization,
       a.appointment_date,
       b.amount,
       b.payment_status
from Appointments a
join Patients p
    on a.patient_id = p.patient_id
join doctors d
    on a.doctor_id = d.doctor_id
join Specializations s
    on d.specialization_id = s.specialization_id
left join Billing b
    on a.appointment_id = b.appointment_id;


-- OUT parameter

DELIMITER //

create procedure GetPatientCount(out total int)
begin
    select count(*) into total
    from Patients;
end //

DELIMITER ;

call GetPatientCount(@count);
select @count;


-- INOUT parameter

DELIMITER //

CREATE PROCEDURE ApplyDiscount(INOUT amount DECIMAL(10,2))
BEGIN
    SET amount = amount - (amount * 0.10);
END //

DELIMITER ;

set @bill = 1000;

call ApplyDiscount(@bill);

select @bill;   -- 900


-- error handling

DELIMITER //

create procedure SafeInsertPatient(
    IN p_name varchar(100),
    IN p_phone varchar(15)
)
begin

    declare exit handler for sqlexception
    begin
        rollback;
        select 'Error: Could not insert patient' as message;
    end;

    start transaction;

    insert into Patients(name, phone)
    values (p_name, p_phone);

    commit;

end //

DELIMITER ;


-- triggers


-- 1. BEFORE INSERT

DELIMITER //

CREATE TRIGGER before_appointment_insert
BEFORE INSERT ON Appointments
FOR EACH ROW
BEGIN

    IF NEW.appointment_date < CURDATE() THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot book an appointment in the past';
    END IF;

END //

DELIMITER ;


-- 2. AFTER INSERT

DELIMITER //

create trigger after_appointment_insert
after insert on appointments
for each row
begin

    insert into AuditLog(
        action,
        table_name,
        record_id,
        action_time
    )
    values (
        'INSERT',
        'Appointments',
        NEW.appointment_id,
        NOW()
    );

end //

DELIMITER ;


-- 3. BEFORE UPDATE

DELIMITER //

create trigger before_billing_update
before update on Billing
for each row
begin

    if NEW.payment_status = 'Paid'
       and OLD.payment_status != 'Paid' then

        set NEW.bill_date = NOW();

    end if;

end //

DELIMITER ;


-- 4. AFTER UPDATE

DELIMITER //

CREATE TRIGGER after_appointment_update
AFTER UPDATE ON appointments
FOR EACH ROW
BEGIN

    IF NEW.status = 'Completed'
       AND OLD.status != 'Completed' THEN

        INSERT INTO VisitHistory(
            appointment_id,
            visit_date
        )
        VALUES (
            NEW.appointment_id,
            NOW()
        );

    END IF;

END //

DELIMITER ;


-- 5. BEFORE DELETE

DELIMITER //

create trigger before_patient_delete
before delete on Patients
for each row
begin

    if exists (
        select 1
        from Appointments
        where patient_id = OLD.patient_id
          and status = 'Confirmed'
    ) then

        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT =
        'Cannot delete a patient with active appointments';

    end if;

end //

DELIMITER ;


-- 6. AFTER DELETE

DELIMITER //

CREATE TRIGGER after_patient_delete
AFTER DELETE ON Patients
FOR EACH ROW
BEGIN

    INSERT INTO DeletedPatientsArchive(
        patient_id,
        name,
        deleted_at
    )
    VALUES (
        OLD.patient_id,
        OLD.name,
        NOW()
    );

END //

DELIMITER ;