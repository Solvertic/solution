# 솔루션

## 통과한 코드

<카테고리 별 도서 판매량 집계하기>

```mysql
SELECT BOOK.CATEGORY AS CATEGORY,SUM(BOOK_SALES.SALES) AS TOTAL_SALES
FROM BOOK AS BOOK
LEFT JOIN BOOK_SALES AS BOOK_SALES ON BOOK.BOOK_ID = BOOK_SALES.BOOK_ID
WHERE MONTH(BOOK_SALES.SALES_DATE)=1
GROUP BY BOOK.CATEGORY
ORDER BY BOOK.CATEGORY

```

<조건에 맞는 사용자와 총 거래금액 조회하기>

```mysql
SELECT UGB.WRITER_ID AS USER_ID, MAX(UGU.NICKNAME) AS NICKNAME, SUM(UGB.PRICE) AS TOTAL_SALES
FROM USED_GOODS_BOARD AS UGB
LEFT OUTER JOIN USED_GOODS_USER AS UGU ON UGB.WRITER_ID = UGU.USER_ID
WHERE STATUS='DONE'
GROUP BY UGB.WRITER_ID
HAVING SUM(UGB.PRICE)>=700000
ORDER BY TOTAL_SALES
```

<대여 기록이 존재하는 자동차 리스트 구하기>

```mysql
SELECT DISTINCT CRCRH.CAR_ID
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS CRCRH
LEFT OUTER JOIN CAR_RENTAL_COMPANY_CAR AS CRCC ON CRCRH.CAR_ID = CRCC.CAR_ID
WHERE CRCC.CAR_TYPE = '세단' AND MONTH(CRCRH.START_DATE) = 10
ORDER BY CRCRH.CAR_ID DESC
```

<조건에 맞는 사용자 정보 조회하기>

```mysql
    SELECT UGU.USER_ID, UGU.NICKNAME, CONCAT(UGU.CITY,' ',UGU.STREET_ADDRESS1,' ',UGU.STREET_ADDRESS2) AS '전체주소', CONCAT(LEFT(UGU.TLNO,3),'-',MID(UGU.TLNO,4,4),'-',RIGHT(UGU.TLNO,4)) AS '전화번호'
FROM (SELECT UGB.WRITER_ID AS USER_ID
        FROM USED_GOODS_BOARD AS UGB
        GROUP BY UGB.WRITER_ID
        HAVING COUNT(UGB.WRITER_ID) >= 3) AS UG
LEFT OUTER JOIN USED_GOODS_USER AS UGU ON UG.USER_ID=UGU.USER_ID
ORDER BY UGU.USER_ID DESC
```

## 풀이 해설

재미있었어요 ㅎㅎㅎ 3레벨이지만 수준이 그렇게 높지 않아서 그런 것 같습니다.

## 부족한 점

오늘은 무난하게 풀었는데, 다음에는 더 재밌는 문제를 풀어보고 싶네요!