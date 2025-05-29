--�������

--1. ������� ���������� �������������� ������� �Registered Nurse�. 
SELECT COUNT (Teachers.id) AS TeacherCount
FROM Teachers
JOIN Lectures  ON Teachers.id = Lectures.teacher_id
JOIN Subjects  ON Lectures.subject_id = Subjects.id 
JOIN Departments  ON Subjects.id = Departments.id    
WHERE Departments.name = 'Registered Nurse'

--2. ������� ���������� ������, ������� ������ ������������� �Gussy Dimock�. 
SELECT COUNT(Lectures.id) AS LectureCount
FROM Lectures 
JOIN Teachers  ON Lectures.teacher_id = Teachers.id
WHERE Teachers.name = 'Gussy' AND Teachers.surname = 'Dimock'

--3. ������� ���������� �������, ���������� � ��������� �zaleplon�. 
SELECT COUNT(Lectures.id) AS LectureCount
FROM Lectures 
WHERE Lectures.lecture_room = 'zaleplon'

--4. ������� �������� ��������� � ���������� ������, ���������� � ���. 
SELECT Lectures.lecture_room AS LectureRoom, COUNT(Lectures.id) AS LectureCount
FROM Lectures 
GROUP BY Lectures.lecture_room

--5. ������� ���������� ���������, ���������� ������ ������������� �Gussy Dimock�. 
SELECT COUNT(DISTINCT Groups.id) AS StudentCount 
FROM Groups 
JOIN GroupsLectures  ON Groups.id = GroupsLectures.group_id
JOIN Lectures  ON GroupsLectures.lectured_id = Lectures .id
JOIN Teachers  ON Lectures .teacher_id = Teachers.id
WHERE Teachers.name = 'Gussy' AND Teachers.surname = 'Dimock'

--6. ������� ������� ������ �������������� ���������� �c�. 
SELECT AVG(Teachers .salary) AS AverageSalary
FROM Teachers 
JOIN Lectures  ON Teachers.id = Lectures.teacher_id
JOIN Subjects  ON Lectures.subject_id = Subjects.id  
JOIN Departments  ON Subjects.id = Departments.id       
JOIN Faculties  ON Departments.faculty_id = Faculties.id
WHERE Faculties.name = 'Historical'

--7. ������� ����������� � ������������ ���������� ��������� ����� ���� �����. 
SELECT MIN(StudentCount) AS MinStudentCount, MAX(StudentCount) AS MaxStudentCount
FROM (SELECT COUNT(GroupsCurators.curator_id) AS StudentCount FROM GroupsCurators  GROUP BY GroupsCurators.group_id) AS GroupSizes

--8. ������� ������� ���� �������������� ������. 
SELECT AVG(Departments.financing) AS AverageFinancing
FROM Departments 

--9. ������� ������ ����� �������������� � ���������� �������� ��� ���������. 
SELECT Teachers.name + ' ' + Teachers.surname AS TeacherFullName, COUNT(DISTINCT Lectures.subject_id) AS SubjectCount
FROM Teachers 
JOIN Lectures  ON Teachers.id = Lectures.teacher_id
GROUP BY Teachers.name, Teachers.surname

--10. ������� ���������� ������ � ������ ���� ������. 
SELECT Lectures.DayOfWeek, COUNT(*) AS LectureCount
FROM Lectures 
GROUP BY Lectures.DayOfWeek
ORDER BY Lectures.DayOfWeek

--11. ������� ������ ��������� � ���������� ������, ��� ������ � ��� ��������.
SELECT Lectures.lecture_room, COUNT(DISTINCT Departments.id) AS DepartmentCount
FROM Lectures 
JOIN Subjects  ON Lectures.subject_id = Subjects.id
JOIN Departments  ON Subjects.id = Departments.id 
GROUP BY Lectures.lecture_room

--12.������� �������� ����������� � ���������� ���������, ������� �� ��� ��������.
SELECT Faculties.name AS FacultyName, COUNT(DISTINCT Subjects.id) AS SubjectCount
FROM Faculties 
JOIN Departments ON Faculties.id = Departments.faculty_id
JOIN Subjects  ON Departments.id = Subjects.id  
GROUP BY Faculties.name

--13. ������� ���������� ������ ��� ������ ���� �������������-���������.
SELECT Teachers.name + ' ' + Teachers.surname AS TeacherFullName, Lectures.lecture_room, COUNT(*) AS LectureCount
FROM Teachers 
JOIN Lectures  ON Teachers.id = Lectures.teacher_id
GROUP BY Teachers.name, Teachers.surname, Lectures.lecture_room

