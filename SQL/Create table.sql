--Запросы 
--1. Вывести все возможные пары строк преподавателей и групп. 
SELECT * 
FROM Teachers CROSS JOIN Groups

--2. Вывести названия факультетов, фонд финансирования кафедр которых превышает фонд финансирования факультета. 
SELECT f.name AS FacultyName
FROM Faculties f
WHERE EXISTS (
    SELECT 1
    FROM Departments d
    WHERE d.faculty_id = f.id AND d.financing > f.financing
)

--3. Вывести фамилии кураторов групп и названия групп, которые они курируют. 
SELECT c.surname AS CuratorSurname, g.name AS GroupName
FROM Curators c
JOIN GroupsCurators gc ON c.id = gc.curator_id
JOIN Groups g ON gc.group_id = g.id

--4. Вывести имена и фамилии преподавателей, которые читают лекции у группы “sociological”. 
SELECT DISTINCT t.name AS TeacherName, t.surname AS TeacherSurname
FROM Teachers t
JOIN Lectures l ON t.id = l.teacher_id
JOIN GroupsLectures gl ON l.id = gl.lectured_id
JOIN Groups g ON gl.group_id = g.id
WHERE g.name = 'sociological'

--5. Вывести фамилии преподавателей и названия факультетов на которых они читают лекции. 
SELECT DISTINCT t.surname AS TeacherSurname, f.name AS FacultyName
FROM Teachers t
JOIN Lectures l ON t.id = l.teacher_id
JOIN Subjects s ON l.subject_id = s.id
JOIN Departments d ON s.id = d.id 
JOIN Faculties f ON d.faculty_id = f.id

--6. Вывести названия кафедр и названия групп, которые к ним относятся. 
SELECT d.name AS DepartmentName, g.name AS GroupName
FROM Departments d
JOIN Groups g ON d.id = g.department_id

--7. Вывести названия дисциплин, которые читает преподаватель “Gussy Dimock”. 
SELECT DISTINCT s.name AS SubjectName
FROM Subjects s
JOIN Lectures l ON s.id = l.subject_id
JOIN Teachers t ON l.teacher_id = t.id
WHERE t.name = 'Gussy' AND t.surname = 'Dimock'

--8. Вывести названия кафедр, на которых читается дисциплина “Clinical Specialist”. 
SELECT DISTINCT d.name AS DepartmentName
FROM Departments d
JOIN Subjects s ON d.id = s.id 
JOIN Lectures l ON s.id = l.subject_id
WHERE s.name = 'Clinical Specialist'

--9. Вывести названия групп, которые относятся к факультету “Mathematical”. 
SELECT g.name AS GroupName
FROM Groups g
JOIN Departments d ON g.department_id = d.id
JOIN Faculties f ON d.faculty_id = f.id
WHERE f.name = 'Mathematical'

--10. Вывести названия групп 5-го курса, а также название факультетов, к которым они относятся. 
SELECT g.name AS GroupName, f.name AS FacultyName
FROM Groups g
JOIN Departments d ON g.department_id = d.id
JOIN Faculties f ON d.faculty_id = f.id
WHERE g.year = 5

--11. Вывести полные имена преподавателей и лекции, которые они читают (названия дисциплин и групп), причем отобрать только те лекции, которые читаются в аудитории “Gabapentin”.
SELECT t.name + ' ' + t.surname AS TeacherFullName, s.name AS SubjectName, g.name AS GroupName
FROM Teachers t
JOIN Lectures l ON t.id = l.teacher_id
JOIN Subjects s ON l.subject_id = s.id
JOIN GroupsLectures gl ON l.id = gl.lectured_id
JOIN Groups g ON gl.group_id = g.id
WHERE l.lecture_room = 'Gabapentin'
















--DROP DATABASE learning

--CREATE DATABASE learning
--GO 
--USE learning

--CREATE TABLE Curators 
--(
--id INT NOT NULL PRIMARY KEY ,
--name NVARCHAR(20) NOT NULL,
--surname NVARCHAR(20) NOT NULL
--)
----DROP TABLE Curators 
--SELECT * FROM Departments

--CREATE TABLE Departments 
--(
--id INT NOT NULL PRIMARY KEY ,
--financing MONEY NOT NULL DEFAULT 0 CHECK (Financing >= 0),
--name NVARCHAR(100) NOT NULL UNIQUE,
--faculty_id INT NOT NULL,
--FOREIGN KEY (faculty_id) REFERENCES Faculties(Id)
--)
----DROP TABLE Departments 

--CREATE TABLE Faculties
--(
--id INT NOT NULL PRIMARY KEY ,
--financing MONEY NOT NULL DEFAULT 0 CHECK (Financing >= 0),
--name NVARCHAR(100) NOT NULL UNIQUE
--)

----DROP TABLE Faculties
--CREATE TABLE Groups
--(
--id INT NOT NULL PRIMARY KEY ,
--name NVARCHAR(100) NOT NULL  UNIQUE ,
--[year] INT NOT NULL CHECK (year BETWEEN 1 AND 5),
--department_id INT NOT NULL,
-- FOREIGN KEY (department_id) REFERENCES Departments(Id)
--)
--DROP TABLE  Groups
--SELECT * FROM Groups

--CREATE TABLE GroupsCurators
--(
--id INT NOT NULL PRIMARY KEY,
--curator_id INT NOT NULL,
--group_id INT NOT NULL,
--FOREIGN KEY (curator_id) REFERENCES Curators(Id),
--FOREIGN KEY (group_id) REFERENCES Groups(Id)
--)
--DROP TABLE  GroupsCurators
--CREATE TABLE GroupsLectures
--(
--id INT NOT NULL PRIMARY KEY,
--group_id INT NOT NULL,
--lectured_id INT NOT NULL
--FOREIGN KEY (group_id) REFERENCES Groups(Id),
--FOREIGN KEY (lectured_id) REFERENCES Lectures(Id)
--)
--DROP TABLE  GroupsLectures
--CREATE TABLE Lectures
--(
--id INT NOT NULL PRIMARY KEY,
--lecture_room NVARCHAR(100) NOT NULL,
--subject_id INT NOT NULL, 
--teacher_id INT NOT NULL,
--FOREIGN KEY (subject_id) REFERENCES Subjects(Id),  
--FOREIGN KEY (teacher_id) REFERENCES Teachers(Id)
--)
--DROP TABLE  Lectures
select*from Lectures
--select*from  Lectures
--CREATE TABLE Subjects
--(
--id INT NOT NULL PRIMARY KEY ,
--name NVARCHAR(100) NOT NULL UNIQUE
--)
--DROP TABLE  Subjects
--CREATE TABLE Teachers
--(
--id INT NOT NULL PRIMARY KEY ,
--name NVARCHAR(100) NOT NULL,
--surname NVARCHAR(50) NOT NULL,
--salary MONEY NOT NULL CHECK (Salary > 0)
--)

--DROP TABLE  Teachers
--INSERT INTO Curators (id, name, surname) values (1, 'Zara', 'Samudio');
--insert into Curators (id, name, surname) values (2, 'Levy', 'De Ruggiero');
--insert into Curators (id, name, surname) values (3, 'Hale', 'Clarson');
--insert into Curators (id, name, surname) values (4, 'Caitlin', 'West');
--insert into Curators (id, name, surname) values (5, 'Raimondo', 'O'' Quirk');
--insert into Curators (id, name, surname) values (6, 'Elysia', 'Torbeck');
--insert into Curators (id, name, surname) values (7, 'Leeland', 'Gonzalo');
--insert into Curators (id, name, surname) values (8, 'Rosene', 'Greenhowe');
--insert into Curators (id, name, surname) values (9, 'Louisa', 'Dexter');
--insert into Curators (id, name, surname) values (10, 'Andrus', 'Bearblock');
--insert into Curators (id, name, surname) values (11, 'Heinrick', 'Capron');
--insert into Curators (id, name, surname) values (12, 'Risa', 'Mahady');
--insert into Curators (id, name, surname) values (13, 'Cayla', 'Ajam');
--insert into Curators (id, name, surname) values (14, 'Thor', 'Marrows');
--insert into Curators (id, name, surname) values (15, 'Kippie', 'Goldstein');
--insert into Curators (id, name, surname) values (16, 'Nevins', 'Whiten');
--insert into Curators (id, name, surname) values (17, 'Demeter', 'Gerler');
--insert into Curators (id, name, surname) values (18, 'Eulalie', 'Renfield');
--insert into Curators (id, name, surname) values (19, 'Luke', 'Kopacek');
--insert into Curators (id, name, surname) values (20, 'Franny', 'Thoumasson');



--insert into Departments (id, financing, name, faculty_id) values (1, '$9715.72', 'Account Coordinator', 11);
--insert into Departments (id, financing, name, faculty_id) values (2, '$4155.48', 'Desktop Support Technician', 9);
--insert into Departments (id, financing, name, faculty_id) values (3, '$1221.68', 'Structural Engineer', 14);
--insert into Departments (id, financing, name, faculty_id) values (4, '$8873.09', 'Developer IV', 15);
--insert into Departments (id, financing, name, faculty_id) values (5, '$261.88', 'Compensation Analyst', 7);
--insert into Departments (id, financing, name, faculty_id) values (6, '$5421.09', 'Media Manager II', 1);
--insert into Departments (id, financing, name, faculty_id) values (7, '$6028.67', 'Media Manager II', 16);
--insert into Departments (id, financing, name, faculty_id) values (8, '$3067.66', 'Information Systems Manager', 19);
--insert into Departments (id, financing, name, faculty_id) values (9, '$3124.05', 'Assistant Professor', 9);
--insert into Departments (id, financing, name, faculty_id) values (10, '$9121.37', 'Environmental Tech', 16);
--insert into Departments (id, financing, name, faculty_id) values (11, '$5900.87', 'Programmer II', 16);
--insert into Departments (id, financing, name, faculty_id) values (12, '$1010.39', 'Office Assistant II', 16);
--insert into Departments (id, financing, name, faculty_id) values (13, '$7380.10', 'Registered Nurse', 20);
--insert into Departments (id, financing, name, faculty_id) values (14, '$2280.95', 'GIS Technical Architect', 1);
--insert into Departments (id, financing, name, faculty_id) values (15, '$9761.01', 'Civil Engineer', 7);
--insert into Departments (id, financing, name, faculty_id) values (16, '$5737.68', 'Editor', 1);
--insert into Departments (id, financing, name, faculty_id) values (17, '$3326.64', 'Nurse', 14);
--insert into Departments (id, financing, name, faculty_id) values (18, '$9979.60', 'Sales Representative', 16);
--insert into Departments (id, financing, name, faculty_id) values (19, '$8835.84', 'Internal Auditor', 5);
--insert into Departments (id, financing, name, faculty_id) values (20, '$2549.80', 'Clinical Specialist', 17);

--insert into Faculties (id, financing, name) values (1, '$3247.71', 'Human Resources');
--insert into Faculties (id, financing, name) values (2, '$4641.25', 'biological');
--insert into Faculties (id, financing, name) values (3, '$680.59', 'Support');
--insert into Faculties (id, financing, name) values (4, '$2736.86', 'Legal');
--insert into Faculties (id, financing, name) values (5, '$7752.74', 'Accounting');
--insert into Faculties (id, financing, name) values (6, '$5986.41', 'Historical');
--insert into Faculties (id, financing, name) values (7, '$94.59', 'Mathematical');
--insert into Faculties (id, financing, name) values (8, '$6496.03', 'Economic');
--insert into Faculties (id, financing, name) values (9, '$3403.53', 'Research and Development');
--insert into Faculties (id, financing, name) values (10, '$2556.66', 'biotechnological');
--insert into Faculties (id, financing, name) values (11, '$5634.31', 'Training');
--insert into Faculties (id, financing, name) values (12, '$8772.33', 'Graduate School of Business');
--insert into Faculties (id, financing, name) values (13, '$3751.77', 'Product Management');
--insert into Faculties (id, financing, name) values (14, '$5998.87', 'Higher School of Public Administration');
--insert into Faculties (id, financing, name) values (15, '$3630.32', 'sociological');
--insert into Faculties (id, financing, name) values (16, '$4470.03', 'Faculty of Bioengineering and Bioinformatics');
--insert into Faculties (id, financing, name) values (17, '$9216.56', 'Faculty of Computational Mathematics and Cybernetics');
--insert into Faculties (id, financing, name) values (18, '$9450.52', 'Faculty of Journalism');
--insert into Faculties (id, financing, name) values (19, '$7463.99', 'Marketing');
--insert into Faculties (id, financing, name) values (20, '$6494.31', 'Sales');

--insert into Groups (id, name, year,department_id) values (1, 'sociological', 3,2);
--insert into Groups (id, name, year,department_id) values (2, 'Faculty of Bioengineering and Bioinformatics', 1,2);
--insert into Groups (id, name, year,department_id) values (3, 'Faculty of Computational Mathematics and Cybernetics', 1,3);
--insert into Groups (id, name, year,department_id) values (4, 'Faculty of Global Processes', 2,4);
--insert into Groups (id, name, year,department_id) values (5, 'Faculty of Public Administration', 5,6);
--insert into Groups (id, name, year,department_id) values (6, 'Faculty of Journalism', 1,5);
--insert into Groups (id, name, year,department_id) values (7, 'Faculty of Foreign Languages and Regional Studies', 1,8);
--insert into Groups (id, name, year,department_id) values (8, 'Faculty of Arts', 5,6);
--insert into Groups (id, name, year,department_id) values (9, 'Faculty of World Politics', 1,9);
--insert into Groups (id, name, year,department_id) values (10, 'Faculty of Materials Sciences', 4,9);
--insert into Groups (id, name, year,department_id) values (11, 'Faculty of Space Research', 4,10);
--insert into Groups (id, name, year,department_id) values (12, 'Faculty of Political Science', 2,11);
--insert into Groups (id, name, year,department_id) values (13, 'Faculty of Soil Science', 1,13);
--insert into Groups (id, name, year,department_id) values (14, 'Faculty of Psychology', 5,12);
--insert into Groups (id, name, year,department_id) values (15, 'Faculty of Fundamental Medicine', 1,14);
--insert into Groups (id, name, year,department_id) values (16, 'Faculty of Fundamental Physico-Chemical Engineering', 5,17);
--insert into Groups (id, name, year,department_id) values (17, 'physical', 3,15);
--insert into Groups (id, name, year,department_id) values (18, 'philological', 4,16);
--insert into Groups (id, name, year,department_id) values (19, 'philosophical', 1,19);
--insert into Groups (id, name, year,department_id) values (20, 'chemical', 3,20);


--insert into GroupsCurators (id, curator_id, group_id) values (1, 15, 5);
--insert into GroupsCurators (id, curator_id, group_id) values (2, 10, 3);
--insert into GroupsCurators (id, curator_id, group_id) values (3, 17, 2);
--insert into GroupsCurators (id, curator_id, group_id) values (4, 10, 8);
--insert into GroupsCurators (id, curator_id, group_id) values (5, 12, 4);
--insert into GroupsCurators (id, curator_id, group_id) values (6, 3, 12);
--insert into GroupsCurators (id, curator_id, group_id) values (7, 10, 4);
--insert into GroupsCurators (id, curator_id, group_id) values (8, 1, 3);
--insert into GroupsCurators (id, curator_id, group_id) values (9, 12, 4);
--insert into GroupsCurators (id, curator_id, group_id) values (10, 2, 1);
--insert into GroupsCurators (id, curator_id, group_id) values (11, 8, 20);
--insert into GroupsCurators (id, curator_id, group_id) values (12, 4, 17);
--insert into GroupsCurators (id, curator_id, group_id) values (13, 1, 12);
--insert into GroupsCurators (id, curator_id, group_id) values (14, 6, 3);
--insert into GroupsCurators (id, curator_id, group_id) values (15, 16, 7);
--insert into GroupsCurators (id, curator_id, group_id) values (16, 8, 5);
--insert into GroupsCurators (id, curator_id, group_id) values (17, 9, 15);
--insert into GroupsCurators (id, curator_id, group_id) values (18, 20, 16);
--insert into GroupsCurators (id, curator_id, group_id) values (19, 16, 9);
--insert into GroupsCurators (id, curator_id, group_id) values (20, 7, 18);

--insert into GroupsLectures (id, group_id, lectured_id) values (1, 18, 26);
--insert into GroupsLectures (id, group_id, lectured_id) values (2, 7, 12);
--insert into GroupsLectures (id, group_id, lectured_id) values (3, 19, 7);
--insert into GroupsLectures (id, group_id, lectured_id) values (4, 6, 41);
--insert into GroupsLectures (id, group_id, lectured_id) values (5, 16, 3);
--insert into GroupsLectures (id, group_id, lectured_id) values (6, 11, 21);
--insert into GroupsLectures (id, group_id, lectured_id) values (7, 11, 25);
--insert into GroupsLectures (id, group_id, lectured_id) values (8, 17, 14);
--insert into GroupsLectures (id, group_id, lectured_id) values (9, 2, 27);
--insert into GroupsLectures (id, group_id, lectured_id) values (10, 2, 3);
--insert into GroupsLectures (id, group_id, lectured_id) values (11, 6, 16);
--insert into GroupsLectures (id, group_id, lectured_id) values (12, 20, 12);
--insert into GroupsLectures (id, group_id, lectured_id) values (13, 3, 41);
--insert into GroupsLectures (id, group_id, lectured_id) values (14, 20, 15);
--insert into GroupsLectures (id, group_id, lectured_id) values (15, 14, 15);
--insert into GroupsLectures (id, group_id, lectured_id) values (16, 18, 38);
--insert into GroupsLectures (id, group_id, lectured_id) values (17, 5, 13);
--insert into GroupsLectures (id, group_id, lectured_id) values (18, 2, 37);
--insert into GroupsLectures (id, group_id, lectured_id) values (19, 13, 34);
--insert into GroupsLectures (id, group_id, lectured_id) values (20, 3, 28);
--insert into GroupsLectures (id, group_id, lectured_id) values (21, 8, 43);
--insert into GroupsLectures (id, group_id, lectured_id) values (22, 4, 16);
--insert into GroupsLectures (id, group_id, lectured_id) values (23, 14, 40);
--insert into GroupsLectures (id, group_id, lectured_id) values (24, 15, 25);
--insert into GroupsLectures (id, group_id, lectured_id) values (25, 10, 41);
--insert into GroupsLectures (id, group_id, lectured_id) values (26, 4, 20);
--insert into GroupsLectures (id, group_id, lectured_id) values (27, 18, 6);
--insert into GroupsLectures (id, group_id, lectured_id) values (28, 7, 33);
--insert into GroupsLectures (id, group_id, lectured_id) values (29, 12, 33);
--insert into GroupsLectures (id, group_id, lectured_id) values (30, 14, 3);
--insert into GroupsLectures (id, group_id, lectured_id) values (31, 13, 45);
--insert into GroupsLectures (id, group_id, lectured_id) values (32, 7, 39);
--insert into GroupsLectures (id, group_id, lectured_id) values (33, 13, 28);
--insert into GroupsLectures (id, group_id, lectured_id) values (34, 5, 50);
--insert into GroupsLectures (id, group_id, lectured_id) values (35, 15, 9);

--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (1, 'CORTISPORIN', 8, 16);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (2, 'Gabapentin', 2, 6);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (3, 'Clarins Sunscreen Care Radiant SPF 6 UVB/UVA', 10, 14);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (4, 'Equate Nicotine', 15, 29);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (5, 'GEMCITABINE', 1, 14);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (6, 'zaleplon', 4, 5);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (7, 'XtraCare Deep Cleaning Astringent', 1, 5);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (8, 'Oregon Ash', 15, 18);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (9, 'La Roche Posay Laboratoire Dermatologique', 12, 11);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (10, 'CLOMIPRAMINE HYDROCHLORIDE', 24, 14);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (11, 'lubricating plus eye', 9, 9);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (12, 'Pussy Willow', 21, 14);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (13, 'LOreal Paris Ideal Moisture Normal Skin Broad Spectrum SPF 25 Sunscreen', 11, 30);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (14, 'Blue Ice Analgesic', 21, 1);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (15, 'Glycopyrrolate', 11, 20);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (16, 'allergy relief', 13, 25);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (17, 'Respiratory Care / Congestion Pulmonaire Et Bronchique', 11, 19);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (18, 'Pylera', 13, 23);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (19, 'CPDA-1', 22, 11);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (20, 'Pentasa', 12, 3);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (21, 'PERFECTION LUMIERE', 6, 21);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (22, 'Haloperidol', 11, 21);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (23, 'Metoprolol Tartrate', 22, 29);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (24, 'Oxygen', 6, 4);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (25, 'Flu Relief Therapy Night Time', 1, 2);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (26, 'REMERON', 22, 12);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (27, 'Levomefolate Calcium, Acetylcysteine, Mecobalamin and Algal', 11, 14);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (28, 'Topcare Nicotine', 7, 16);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (29, '3M Avagard Foam', 12, 15);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (30, 'Ketorolac Tromethamine', 12, 21);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (31, 'CACTUS WHITENING SUN', 6, 30);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (32, 'Alba Sunblock Natural FF SPF 30', 12, 21);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (33, 'Sulwhasoo Lumitouch', 12, 13);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (34, 'risperidone', 10, 12);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (35, 'CULTIVATED CORN POLLEN', 12, 28);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (36, 'supernatural airbrushed canvas broad spectrum spf 15 sunscreen', 3, 9);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (37, 'ANTIBACTERIAL HAND SANITIZER', 17, 8);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (38, 'METRONIDAZOLE', 1, 12);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (39, 'COUMADIN', 19, 29);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (40, 'Keppra', 8, 22);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (41, 'CARBAMAZEPINE', 11, 21);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (42, 'Acacia Pollen', 8, 13);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (43, 'ROPINIROLE HYDROCHLORIDE', 12, 25);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (44, 'Temazepam', 2, 21);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (45, 'Hydralazine Hydrochloride', 21, 18);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (46, 'Oxygen', 16, 3);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (47, 'EVOXAC', 18, 10);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (48, 'RoC Multi Correxion 5 in 1 Perfecting', 6, 6);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (49, 'DEXTROAMPHETAMINE SULFATE', 17, 19);
--insert into Lectures (id, lecture_room , subject_id , teacher_id) values (50, 'benefit BIG EASY BROAD SPECTRUM SPF 35 SUNSCREEN multi-balancing complexion perfector - 02 LIGHT', 21, 12);

--insert into Subjects (id, name) values (1, 'Director of Sales');
--insert into Subjects (id, name) values (2, 'Information Systems Manager');
--insert into Subjects (id, name) values (3, 'Senior Editor');
--insert into Subjects (id, name) values (4, 'Electrical Engineer');
--insert into Subjects (id, name) values (5, 'General Manager');
--insert into Subjects (id, name) values (6, 'Clinical Specialist');
--insert into Subjects (id, name) values (7, 'VP Sales');
--insert into Subjects (id, name) values (8, 'Database Administrator II');
--insert into Subjects (id, name) values (9, 'Structural Engineer');
--insert into Subjects (id, name) values (10, 'Developer I');
--insert into Subjects (id, name) values (11, 'Mechanical Systems Engineer');
--insert into Subjects (id, name) values (12, 'Editor');
--insert into Subjects (id, name) values (13, 'Geological Engineer');
--insert into Subjects (id, name) values (14, 'Cost Accountant');
--insert into Subjects (id, name) values (15, 'Media Manager III');
--insert into Subjects (id, name) values (16, 'Junior Executive');
--insert into Subjects (id, name) values (17, 'Health Coach I');
--insert into Subjects (id, name) values (18, 'Assistant Media Planner');
--insert into Subjects (id, name) values (19, 'Staff Accountant II');
--insert into Subjects (id, name) values (20, 'Assistant Media Planner');
--insert into Subjects (id, name) values (21, 'Civil Engineer');
--insert into Subjects (id, name) values (22, 'Research Nurse');
--insert into Subjects (id, name) values (23, 'Automation Specialist IV');
--insert into Subjects (id, name) values (24, 'Computer Systems Analyst II');
--insert into Subjects (id, name) values (25, 'Software Consultant');

--insert into Teachers (id, name, surname, salary) values (1, 'Gussy', 'Dimock', '$25906.10');
--insert into Teachers (id, name, surname, salary) values (2, 'Tiler', 'Leopard', '$59166.94');
--insert into Teachers (id, name, surname, salary) values (3, 'Kimberli', 'Exter', '$31447.21');
--insert into Teachers (id, name, surname, salary) values (4, 'Ivy', 'Goolden', '$58949.54');
--insert into Teachers (id, name, surname, salary) values (5, 'Doyle', 'Shovelin', '$56134.74');
--insert into Teachers (id, name, surname, salary) values (6, 'Gabriele', 'Bowden', '$40751.71');
--insert into Teachers (id, name, surname, salary) values (7, 'Luce', 'Perkins', '$30570.12');
--insert into Teachers (id, name, surname, salary) values (8, 'Wanids', 'Hlavac', '$21820.49');
--insert into Teachers (id, name, surname, salary) values (9, 'Lenee', 'Folbige', '$58577.08');
--insert into Teachers (id, name, surname, salary) values (10, 'Cosimo', 'Shawdforth', '$55627.03');
--insert into Teachers (id, name, surname, salary) values (11, 'Klarrisa', 'Waite', '$31031.90');
--insert into Teachers (id, name, surname, salary) values (12, 'Bria', 'Burnside', '$53083.68');
--insert into Teachers (id, name, surname, salary) values (13, 'Osbourne', 'Hembrow', '$57793.62');
--insert into Teachers (id, name, surname, salary) values (14, 'Rodrick', 'Camock', '$12722.61');
--insert into Teachers (id, name, surname, salary) values (15, 'Theresina', 'McCorkell', '$55928.44');
--insert into Teachers (id, name, surname, salary) values (16, 'Leticia', 'Danshin', '$14648.10');
--insert into Teachers (id, name, surname, salary) values (17, 'Elora', 'Culshew', '$50829.42');
--insert into Teachers (id, name, surname, salary) values (18, 'Aldin', 'Padberry', '$35046.36');
--insert into Teachers (id, name, surname, salary) values (19, 'Elden', 'Sadd', '$40291.37');
--insert into Teachers (id, name, surname, salary) values (20, 'Nester', 'Larrad', '$39364.19');
--insert into Teachers (id, name, surname, salary) values (21, 'Norean', 'Maywood', '$16936.49');
--insert into Teachers (id, name, surname, salary) values (22, 'Zebulen', 'Talks', '$2411.62');
--insert into Teachers (id, name, surname, salary) values (23, 'Nicki', 'Keedwell', '$9415.79');
--insert into Teachers (id, name, surname, salary) values (24, 'Roshelle', 'Gribben', '$58701.88');
--insert into Teachers (id, name, surname, salary) values (25, 'Marty', 'Paz', '$6841.93');
--insert into Teachers (id, name, surname, salary) values (26, 'Astrix', 'Stokell', '$44031.31');
--insert into Teachers (id, name, surname, salary) values (27, 'Jammie', 'Barron', '$9520.57');
--insert into Teachers (id, name, surname, salary) values (28, 'Normy', 'Asty', '$35446.76');
--insert into Teachers (id, name, surname, salary) values (29, 'Alicia', 'Denness', '$39756.61');
--insert into Teachers (id, name, surname, salary) values (30, 'Lorelei', 'Laker', '$9539.31');
