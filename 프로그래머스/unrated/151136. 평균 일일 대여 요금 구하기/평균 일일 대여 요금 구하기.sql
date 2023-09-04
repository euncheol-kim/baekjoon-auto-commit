-- 자동차 종류가 'SUV'인 자동차들의 평균 일일 대여 요금을 출력하는 SQL문을 작성
-- 이때 평균 일일 대여 요금은 소수 첫 번째 자리에서 반올림하고, 컬럼명은 AVERAGE_FEE 로 지정

-- 핵심 반올림 : ROUND(값, 반올림 위치)

select ROUND(avg(daily_fee), 0) as 'AVERAGE_FEE'
from CAR_RENTAL_COMPANY_CAR
where CAR_TYPE = 'SUV';
