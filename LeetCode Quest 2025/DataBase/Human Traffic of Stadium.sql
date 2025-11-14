SELECT id, visit_date, people
FROM (
    SELECT 
        id,
        visit_date,
        people,
        LAG(people) OVER (ORDER BY id) AS prev_people,
        LEAD(people) OVER (ORDER BY id) AS next_people,
        LAG(id) OVER (ORDER BY id) AS prev_id,
        LEAD(id) OVER (ORDER BY id) AS next_id,
        LAG(people,2) OVER (ORDER BY id) AS prev2_people,
        LEAD(people,2) OVER (ORDER BY id) AS next2_people,
        LAG(id,2) OVER (ORDER BY id) AS prev2_id,
        LEAD(id,2) OVER (ORDER BY id) AS next2_id
    FROM Stadium
) t
WHERE
    -- Case 1: this row is the first in a 3-sequence
    (people >= 100 AND next_people >= 100 AND next2_people >= 100
     AND id + 1 = next_id AND id + 2 = next2_id)
OR
    -- Case 2: this row is the middle in a 3-sequence
    (people >= 100 AND prev_people >= 100 AND next_people >= 100
     AND id - 1 = prev_id AND id + 1 = next_id)
OR
    -- Case 3: this row is the last in a 3-sequence
    (people >= 100 AND prev_people >= 100 AND prev2_people >= 100
     AND id - 1 = prev_id AND id - 2 = prev2_id)
ORDER BY id;
