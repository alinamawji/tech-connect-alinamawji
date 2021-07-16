-- in this model, members are not required to be part of an interest_group (0 to many)
--                members are not required to attend an event (0 to many)
--                members can be a part of more than one group
--                members can attend more than one event

BEGIN TRANSACTION;

DROP TABLE IF EXISTS member, interest_group, event, event_attendees, group_members;

CREATE TABLE member (
    member_number serial,
    last_name varchar(50) NOT NULL,
    first_name varchar(50) NOT NULL,
    email_address varchar(50) NOT NULL,
    phone_number varchar(12),
    date_of_birth date NOT NULL,
    flag_reminder_emails boolean NOT NULL,
	CONSTRAINT PK_member PRIMARY KEY(member_number)
);

CREATE TABLE interest_group (
    group_number serial,
	name varchar(50) NOT NULL,
    CONSTRAINT PK_interest_group PRIMARY KEY(group_number),
    CONSTRAINT UQ_interest_group_name UNIQUE(name)
);

CREATE TABLE event (
    event_number serial,
    name varchar(50) NOT NULL,
    description varchar(300) NOT NULL,
    start_date date NOT NULL,
    start_time time NOT NULL,
    duration int NOT NULL,
    host_group_number int,
    CONSTRAINT PK_event PRIMARY KEY(event_number),
    CONSTRAINT CHK_event_duration CHECK(duration >= 30)
);

CREATE TABLE event_attendees (
    event_number int NOT NULL,
    member_number int NOT NULL,
    CONSTRAINT PK_event_attendees PRIMARY KEY(event_number, member_number)
);

CREATE TABLE group_members (
    group_number int NOT NULL,
    member_number int NOT NULL,
    CONSTRAINT PK_group_members PRIMARY KEY(group_number, member_number)
);

-- four events
INSERT INTO event(name, description, start_date, start_time, duration, host_group_number) values('Hackathon', 'Work on a project for 24 hours', '2021-07-16', '12:00:00', 1440, 1);
INSERT INTO event(name, description, start_date, start_time, duration, host_group_number) values('Marathon', 'Running a 3K', '2021-07-17', '9:00:00', 90, 2);
INSERT INTO event(name, description, start_date, start_time, duration, host_group_number) values('Painting', 'Paint a picture of a starry night', '2021-07-18', '18:00:00', 60, 3);
INSERT INTO event(name, description, start_date, start_time, duration, host_group_number) values('Ice Cream Social', 'Socialize with coworkers over ice cream', '2021-07-19', '20:00:00', 30, 1);

-- three groups
INSERT INTO interest_group(name) values('Programmers');
INSERT INTO interest_group(name) values('Runners');
INSERT INTO interest_group(name) values('Painters');

-- eight members
INSERT INTO member(last_name, first_name, email_address, phone_number, date_of_birth, flag_reminder_emails) values('Apple', 'Adonis', 'adonisapple@gmail.com', '512-123-4567', '1993-05-14', false);
INSERT INTO member(last_name, first_name, email_address, phone_number, date_of_birth, flag_reminder_emails) values('Baker', 'Buddy', 'buddybaker@gmail.com', '281-123-4567', '1990-08-30', true);
INSERT INTO member(last_name, first_name, email_address, phone_number, date_of_birth, flag_reminder_emails) values('Cake', 'Catherine', 'cattycake@yahoo.com', '469-123-4567', '1995-10-24', false);
INSERT INTO member(last_name, first_name, email_address, date_of_birth, flag_reminder_emails) values('Denton', 'Dan', 'dandent@gmail.com', '1980-01-15', false);
INSERT INTO member(last_name, first_name, email_address, date_of_birth, flag_reminder_emails) values('Egg', 'Edgar', 'edgareggs412@gmail.com', '1995-04-12', true);
INSERT INTO member(last_name, first_name, email_address, phone_number, date_of_birth, flag_reminder_emails) values('Fry', 'Felicia', 'byefelicia@yahoo.com', '817-123-4567', '1992-07-12', true);
INSERT INTO member(last_name, first_name, email_address, phone_number, date_of_birth, flag_reminder_emails) values('Garza', 'Ginger', 'gingarza2015@yahoo.com', '430-123-4567', '2000-06-20', false);
INSERT INTO member(last_name, first_name, email_address, phone_number, date_of_birth, flag_reminder_emails) values('Hasbros', 'Han', 'gamemaker@yahoo.com', '235-123-4567', '1989-03-09', false);

-- add members to events
-- event 1
INSERT INTO event_attendees(event_number, member_number) values(1, 1);
INSERT INTO event_attendees(event_number, member_number) values(1, 2);
INSERT INTO event_attendees(event_number, member_number) values(1, 3);

-- event 2
INSERT INTO event_attendees(event_number, member_number) values(2, 4);
INSERT INTO event_attendees(event_number, member_number) values(2, 5);

-- event 3
INSERT INTO event_attendees(event_number, member_number) values(3, 6);
INSERT INTO event_attendees(event_number, member_number) values(3, 7);
INSERT INTO event_attendees(event_number, member_number) values(3, 8);

-- event 4
INSERT INTO event_attendees(event_number, member_number) values(4, 1);
INSERT INTO event_attendees(event_number, member_number) values(4, 2);
INSERT INTO event_attendees(event_number, member_number) values(4, 7);
INSERT INTO event_attendees(event_number, member_number) values(4, 8);

-- add members to groups
-- group 1
INSERT INTO group_members(group_number, member_number) values(1, 1);
INSERT INTO group_members(group_number, member_number) values(1, 2);
INSERT INTO group_members(group_number, member_number) values(1, 7);
INSERT INTO group_members(group_number, member_number) values(1, 8);

-- group 2
INSERT INTO group_members(group_number, member_number) values(2, 3);
INSERT INTO group_members(group_number, member_number) values(2, 4);
INSERT INTO group_members(group_number, member_number) values(2, 5);
INSERT INTO group_members(group_number, member_number) values(2, 6);

-- group 3
INSERT INTO group_members(group_number, member_number) values(3, 5);
INSERT INTO group_members(group_number, member_number) values(3, 6);
INSERT INTO group_members(group_number, member_number) values(3, 7);
INSERT INTO group_members(group_number, member_number) values(3, 8);

-- foreign keys
-- event table: host_group_number
ALTER TABLE event ADD CONSTRAINT FK_event FOREIGN KEY(host_group_number) REFERENCES interest_group(group_number);

-- event_attendees table: event_number, member_number
ALTER TABLE event_attendees ADD CONSTRAINT FK_event FOREIGN KEY(event_number) REFERENCES event(event_number);
ALTER TABLE event_attendees ADD CONSTRAINT FK_member FOREIGN KEY(member_number) REFERENCES member(member_number);

-- group_members table: group_number, member_number
ALTER TABLE group_members ADD CONSTRAINT FK_group FOREIGN KEY(group_number) REFERENCES interest_group(group_number);
ALTER TABLE group_members ADD CONSTRAINT FK_member FOREIGN KEY(member_number) REFERENCES member(member_number);

COMMIT;