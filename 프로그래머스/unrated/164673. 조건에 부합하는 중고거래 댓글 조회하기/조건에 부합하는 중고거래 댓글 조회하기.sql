--    게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일

select TITLE, b.BOARD_ID, REPLY_ID, r.WRITER_ID, r.CONTENTS, DATE_FORMAT(r.created_date, '%Y-%m-%d') as CREATED_DATE
from used_goods_board b inner join used_goods_reply r on b.BOARD_ID = r.BOARD_ID
where year(b.CREATED_DATE) = "2022" and month(b.CREATED_DATE) = "10"
order by r.created_date asc, b.TITLE asc;