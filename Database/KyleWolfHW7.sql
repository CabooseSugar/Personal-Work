Kyle Wolf
HW #7

----------- PROBLEM 1 -----------
create or replace trigger student_casc_del_on_advs_takes
before delete on student 
referencing old as old_rows 
for each row 
begin 
    delete from advisor 
    where s_id = :old_rows.id; 
    delete from takes
    where ID = :old_rows.id;
end;

-- event
delete from student where dept_name ='Physics';

----------- PROBLEM 2 -----------
create or replace trigger instr_update_advs_teaches
before update of id on instructor 
referencing old as old_rows new as new_rows
for each row 
begin 
    update advisor 
    set advisor.i_id = :new_rows.id
    where advisor.i_id = :old_rows.id;
    update teaches
    set teaches.id = :new_rows.id
    where teaches.id = :old_rows.id;
end;

-- event
update instructor set id = id + 2 where dept_name = 'Computer Science';

----------- PROBLEM 3 -----------
create table problem3_log (
    user_id varchar(16),
    timestmp timestamp,
    student_id varchar(5),
    course_id varchar(8),
    section_id varchar (8),
    semester varchar (6),
    year numeric (4,0),
    old_grade varchar(2),
    new_grade varchar(2)
);

create or replace trigger log_takes 
after update on takes 
referencing old as old_rows new as new_rows
for each row
when(new_rows.grade <> old_rows.grade)
begin
    insert into problem3_log
    values(user, systimestamp, :old_rows.id, :old_rows.course_id, :old_rows.sec_id, :old_rows.semester, :old_rows.year, :old_rows.grade, :new_rows.grade);
end;

--event
update takes set grade = 'B' where id = '00128' and course_id = 'CS-101' and sec_id = '1' and semester = 'Fall' and year = '2019';


----------- PROBLEM 4 -----------
drop table temp;
create table temp as select * from course natural join takes;

create or replace trigger prevent_extreme_changes
before update or delete of grade on takes
referencing old as old_rows new as new_rows
for each row
when (((new_rows.grade <> 'F' or new_rows.grade is not null) and (old_rows.grade = 'F' or old_rows.grade is null))
    or ((old_rows.grade <> 'F' or old_rows.grade is not null) and (new_rows.grade = 'F' or new_rows.grade is null)))
declare
    cred number;
    difference number;
begin
   select sum(credits) into difference from temp where id = :new_rows.id;

    if (difference > 10) then
      raise_application_error(-20111,'Total credits change is too drastic.');
    end if;
    
    select credits into cred
    from course
    where course.course_id= :new_rows.course_id;
    
   update student
   set tot_cred = tot_cred + cred
   where student.id = :new_rows.id;
  
end;

-- event
update takes set grade = 'F' where id = '12345';
delete from takes where id ='12345';
insert into takes (ID, course_id, sec_id, semester, year, grade) 
values ('12345', '0', '0', '0', '0', 'F');


----------- PROBLEM 5 -----------
-- The attacker could use any true expression such as '1' = '1'; for the string AUTH_CODE to gain access to the entire table. 
-- This attack could be prevented by using procedures rather than just having the user enter the code directly into the query.