WITH ranked_members AS (
    SELECT 
        MEMBER_ID,
        COUNT(*) as review_count,
        RANK() OVER (ORDER BY COUNT(*) DESC) as rnk
    FROM REST_REVIEW
    GROUP BY MEMBER_ID
)
SELECT 
    mp.MEMBER_NAME,
    rr.REVIEW_TEXT,
    DATE_FORMAT(rr.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM MEMBER_PROFILE mp
JOIN REST_REVIEW rr ON mp.MEMBER_ID = rr.MEMBER_ID
WHERE mp.MEMBER_ID IN (
    SELECT MEMBER_ID 
    FROM ranked_members 
    WHERE rnk = 1  -- 1등 모두 선택
)
ORDER BY rr.REVIEW_DATE ASC, rr.REVIEW_TEXT ASC;