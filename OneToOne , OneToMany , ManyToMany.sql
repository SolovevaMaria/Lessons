--Запросы
--1. Вывести количество преподавателей кафедры “Registered Nurse”. 
SELECT COUNT(t.id) AS TeacherCount
FROM Teachers t
JOIN Lectures l ON t.id = l.teacher_id
JOIN Subjects s ON l.subject_id = s.id 
JOIN Departments d ON s.id = d.id    
WHERE d.name = 'Registered Nurse'

--2. Вывести количество лекций, которые читает преподаватель “Gussy Dimock”. 
SELECT COUNT(l.id) AS LectureCount
FROM Lectures l
JOIN Teachers t ON l.teacher_id = t.id
WHERE t.name = 'Gussy' AND t.surname = 'Dimock'

--3. Вывести количество занятий, проводимых в аудитории “zaleplon”. 
SELECT COUNT(l.id) AS LectureCount
FROM Lectures l
WHERE l.lecture_room = 'zaleplon'

--4. Вывести названия аудиторий и количество лекций, проводимых в них. 
SELECT l.lecture_room AS LectureRoom, COUNT(l.id) AS LectureCount
FROM Lectures l
GROUP BY l.lecture_room

--5. Вывести количество студентов, посещающих лекции преподавателя “Gussy Dimock”. 
SELECT COUNT(DISTINCT g.id) AS StudentCount 
FROM Groups g
JOIN GroupsLectures gl ON g.id = gl.group_id
JOIN Lectures l ON gl.lectured_id = l.id
JOIN Teachers t ON l.teacher_id = t.id
WHERE t.name = 'Gussy' AND t.surname = 'Dimock'

--6. Вывести среднюю ставку преподавателей факультета “c”. 
SELECT AVG(t.salary) AS AverageSalary
FROM Teachers t
JOIN Lectures l ON t.id = l.teacher_id
JOIN Subjects s ON l.subject_id = s.id  
JOIN Departments d ON s.id = d.id       
JOIN Faculties f ON d.faculty_id = f.id
WHERE f.name = 'Historical'

--7. Вывести минимальное и максимальное количество студентов среди всех групп. 
SELECT MIN(StudentCount) AS MinStudentCount, MAX(StudentCount) AS MaxStudentCount
FROM (SELECT COUNT(gc.curator_id) AS StudentCount FROM GroupsCurators gc GROUP BY gc.group_id) AS GroupSizes

--8. Вывести средний фонд финансирования кафедр. 
SELECT AVG(d.financing) AS AverageFinancing
FROM Departments d

--9. Вывести полные имена преподавателей и количество читаемых ими дисциплин. 
SELECT t.name + ' ' + t.surname AS TeacherFullName, COUNT(DISTINCT l.subject_id) AS SubjectCount
FROM Teachers t
JOIN Lectures l ON t.id = l.teacher_id
GROUP BY t.name, t.surname

--10. Вывести количество лекций в каждый день недели. 
SELECT l.DayOfWeek, COUNT(*) AS LectureCount
FROM Lectures l
GROUP BY l.DayOfWeek
ORDER BY l.DayOfWeek

--11. Вывести номера аудиторий и количество кафедр, чьи лекции в них читаются.
SELECT l.lecture_room, COUNT(DISTINCT d.id) AS DepartmentCount
FROM Lectures l
JOIN Subjects s ON l.subject_id = s.id
JOIN Departments d ON s.id = d.id 
GROUP BY l.lecture_room

--12.Вывести названия факультетов и количество дисциплин, которые на них читаются.
SELECT f.name AS FacultyName, COUNT(DISTINCT s.id) AS SubjectCount
FROM Faculties f
JOIN Departments d ON f.id = d.faculty_id
JOIN Subjects s ON d.id = s.id  
GROUP BY f.name

--13. Вывести количество лекций для каждой пары преподаватель-аудитория.
SELECT t.name + ' ' + t.surname AS TeacherFullName, l.lecture_room, COUNT(*) AS LectureCount
FROM Teachers t
JOIN Lectures l ON t.id = l.teacher_id
GROUP BY t.name, t.surname, l.lecture_room

