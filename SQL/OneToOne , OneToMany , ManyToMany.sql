--Запросы

--1. Вывести количество преподавателей кафедры “Registered Nurse”. 
SELECT COUNT (Teachers.id) AS TeacherCount
FROM Teachers
JOIN Lectures  ON Teachers.id = Lectures.teacher_id
JOIN Subjects  ON Lectures.subject_id = Subjects.id 
JOIN Departments  ON Subjects.id = Departments.id    
WHERE Departments.name = 'Registered Nurse'

--2. Вывести количество лекций, которые читает преподаватель “Gussy Dimock”. 
SELECT COUNT(Lectures.id) AS LectureCount
FROM Lectures 
JOIN Teachers  ON Lectures.teacher_id = Teachers.id
WHERE Teachers.name = 'Gussy' AND Teachers.surname = 'Dimock'

--3. Вывести количество занятий, проводимых в аудитории “zaleplon”. 
SELECT COUNT(Lectures.id) AS LectureCount
FROM Lectures 
WHERE Lectures.lecture_room = 'zaleplon'

--4. Вывести названия аудиторий и количество лекций, проводимых в них. 
SELECT Lectures.lecture_room AS LectureRoom, COUNT(Lectures.id) AS LectureCount
FROM Lectures 
GROUP BY Lectures.lecture_room

--5. Вывести количество студентов, посещающих лекции преподавателя “Gussy Dimock”. 
SELECT COUNT(DISTINCT Groups.id) AS StudentCount 
FROM Groups 
JOIN GroupsLectures  ON Groups.id = GroupsLectures.group_id
JOIN Lectures  ON GroupsLectures.lectured_id = Lectures .id
JOIN Teachers  ON Lectures .teacher_id = Teachers.id
WHERE Teachers.name = 'Gussy' AND Teachers.surname = 'Dimock'

--6. Вывести среднюю ставку преподавателей факультета “c”. 
SELECT AVG(Teachers .salary) AS AverageSalary
FROM Teachers 
JOIN Lectures  ON Teachers.id = Lectures.teacher_id
JOIN Subjects  ON Lectures.subject_id = Subjects.id  
JOIN Departments  ON Subjects.id = Departments.id       
JOIN Faculties  ON Departments.faculty_id = Faculties.id
WHERE Faculties.name = 'Historical'

--7. Вывести минимальное и максимальное количество студентов среди всех групп. 
SELECT MIN(StudentCount) AS MinStudentCount, MAX(StudentCount) AS MaxStudentCount
FROM (SELECT COUNT(GroupsCurators.curator_id) AS StudentCount FROM GroupsCurators  GROUP BY GroupsCurators.group_id) AS GroupSizes

--8. Вывести средний фонд финансирования кафедр. 
SELECT AVG(Departments.financing) AS AverageFinancing
FROM Departments 

--9. Вывести полные имена преподавателей и количество читаемых ими дисциплин. 
SELECT Teachers.name + ' ' + Teachers.surname AS TeacherFullName, COUNT(DISTINCT Lectures.subject_id) AS SubjectCount
FROM Teachers 
JOIN Lectures  ON Teachers.id = Lectures.teacher_id
GROUP BY Teachers.name, Teachers.surname

--10. Вывести количество лекций в каждый день недели. 
SELECT Lectures.DayOfWeek, COUNT(*) AS LectureCount
FROM Lectures 
GROUP BY Lectures.DayOfWeek
ORDER BY Lectures.DayOfWeek

--11. Вывести номера аудиторий и количество кафедр, чьи лекции в них читаются.
SELECT Lectures.lecture_room, COUNT(DISTINCT Departments.id) AS DepartmentCount
FROM Lectures 
JOIN Subjects  ON Lectures.subject_id = Subjects.id
JOIN Departments  ON Subjects.id = Departments.id 
GROUP BY Lectures.lecture_room

--12.Вывести названия факультетов и количество дисциплин, которые на них читаются.
SELECT Faculties.name AS FacultyName, COUNT(DISTINCT Subjects.id) AS SubjectCount
FROM Faculties 
JOIN Departments ON Faculties.id = Departments.faculty_id
JOIN Subjects  ON Departments.id = Subjects.id  
GROUP BY Faculties.name

--13. Вывести количество лекций для каждой пары преподаватель-аудитория.
SELECT Teachers.name + ' ' + Teachers.surname AS TeacherFullName, Lectures.lecture_room, COUNT(*) AS LectureCount
FROM Teachers 
JOIN Lectures  ON Teachers.id = Lectures.teacher_id
GROUP BY Teachers.name, Teachers.surname, Lectures.lecture_room

