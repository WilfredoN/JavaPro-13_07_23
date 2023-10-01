SELECT *
FROM homework;

SELECT lesson.id,
       lesson.name,
       lesson.updated_At,
       homework.name        AS homework_name,
       homework.description AS homework_description
FROM lesson
         INNER JOIN homework ON homework.id = lesson.homework_id;

SELECT lesson.id,
       lesson.name,
       lesson.updated_At,
       homework.name        AS homework_name,
       homework.description AS homework_description
FROM lesson
         INNER JOIN homework ON homework.id = lesson.homework_id
ORDER BY lesson.updated_at DESC;

SELECT schedule.id,
       schedule.name,
       schedule.updated_At,
       lesson.name as lesson_name
FROM schedule
         INNER JOIN lesson_schedule on schedule.id = lesson_schedule.schedule_id
         INNER JOIN lesson on lesson_schedule.lesson_id = lesson.id;

SELECT schedule.id,
       COUNT(*) AS lesson_count
FROM schedule
         INNER JOIN lesson_schedule on schedule.id = lesson_schedule.schedule_id
GROUP BY schedule.id