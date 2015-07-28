# openjpa-ws-db2-rownumber

doc a faire
SELECT * 
    FROM (SELECT rr.*, ROW_NUMBER() OVER(ORDER BY ORDER OF rr) AS rn FROM 
        (SELECT t0.CGGEST, t0.CLOREG, t0.NUMERA, t0.DCRENR, t0.DDEVAL, 
        t0.DFIVAL, t0.DMODEN, t2.CLOREG, t2.CCVTAB, t2.ILOREG, 
        t2.LLOREG, t0.CMACRE, t0.CMAMOD, t1.LLOREG FROM 
        DBM01.SIGR_0732_TERRITOIRE_CP t0 LEFT OUTER JOIN DBM01.UTI00732 
        t1 ON t0.CLOREG = t1.CLOREG LEFT OUTER JOIN DBM01.UTI00732 t2 
        ON t0.CLOREG = t2.CLOREG 
    WHERE (t0.CGGEST = 1 AND t0.NUMERA = 302145) 
    ORDER BY t1.LLOREG DESC) AS rr) AS r WHERE rn > 0 AND rn <= 2


|-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|
|CGGEST |CLOREG |NUMERA |DCRENR |DDEVAL |DFIVAL |DMODEN |CLOREG |CCVTAB |ILOREG |LLOREG |CMACRE |CMAMOD |LLOREG |RN     |
|-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|
|1      |54     |302145 |UNREAD |UNREAD |UNREAD |UNREAD |UNREAD |UNREAD |UNREAD |UNREAD |UNREAD |UNREAD |UNREAD |UNREAD |
|1      |2      |302145 |UNREAD |UNREAD |UNREAD |UNREAD |UNREAD |UNREAD |UNREAD |UNREAD |UNREAD |UNREAD |UNREAD |UNREAD |
|-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|