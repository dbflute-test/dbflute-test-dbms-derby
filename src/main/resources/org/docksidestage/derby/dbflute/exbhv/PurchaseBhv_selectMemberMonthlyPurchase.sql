/*
 [df:title]
 Example for group-by on Apache Derby
 
 [df:description]
 This SQL is an example for group-by of outsideSql.
 DBFlute functions are not related to group-by, purely SQL example.
*/
-- #df:entity#

-- !df:pmb!
-- !!AutoDetect!!

select mb.MEMBER_ID -- // grouping item
     -- , mb.MEMBER_NAME -- // non grouping item is NOT allowed on Apache Derby
     , date(substr(varchar(pur.PURCHASE_DATETIME), 1, 7) || '-01') as PURCHASE_MONTH -- // grouping item, depends on DBMS
     , avg(pur.PURCHASE_PRICE) as PURCHASE_PRICE_AVG -- // aggregation item
     , max(pur.PURCHASE_PRICE) as PURCHASE_PRICE_MAX -- // me too
     -- non grouping, executable until selecting one-to-many data on Apache Derby
     -- , pur.PURCHASE_COUNT
     -- , serv.SERVICE_POINT_COUNT -- // non grouping item (relationship 1:1 data) is NOT allowed on Apache Derby
  from PURCHASE pur
    left outer join MEMBER mb
      on pur.MEMBER_ID = mb.MEMBER_ID
    left outer join MEMBER_SERVICE serv
      on mb.MEMBER_ID = serv.MEMBER_ID
 /*BEGIN*/
 where
   /*IF pmb.memberId != null*/
   mb.MEMBER_ID = /*pmb.memberId*/3
   /*END*/
   /*IF pmb.memberNamePrefix != null*/
   and mb.MEMBER_NAME like /*pmb.memberNamePrefix*/'S%'
   /*END*/
   /*IF pmb.purchaseDatetimeFrom != null*/
   and pur.PURCHASE_DATETIME >= /*pmb.purchaseDatetimeFrom*/'1997-06-01 12:34:56' -- // for month search
   /*END*/
   /*IF pmb.monthFromBad != null*/
   and date(substr(varchar(pur.PURCHASE_DATETIME), 1, 7) || '-01') >= /*pmb.monthFromBad*/'1997-06-01' -- // very osoi
   /*END*/
 /*END*/

 -- using alias of select clause for group-by is NOT allowed on Apache Derby
 --  ERROR: Column 'PURCHASE_MONTH' is either not in any table in the FROM list or appears
 --         within a join specification and is outside the scope of the join specification
 --         or appears in a HAVING clause and is not in the GROUP BY list.
 --         If this is a CREATE or ALTER TABLE statement
 --         then 'PURCHASE_MONTH' is not a column in the target table.
 group by mb.MEMBER_ID, date(substr(varchar(pur.PURCHASE_DATETIME), 1, 7) || '-01')

 /*BEGIN*/
 -- using alias of select clause for having is NOT allowed on Apache Derby
 having
    /*IF pmb.monthToHaving != null*/
    date(substr(varchar(pur.PURCHASE_DATETIME), 1, 7) || '-01') <= /*pmb.monthToHaving*/'1997-06-01' -- grouping item, containing the to-month
   /*END*/
    /*IF pmb.priceMaxFrom != null*/
    and max(pur.PURCHASE_PRICE) >= /*pmb.priceMaxFrom*/100 -- aggregation item
   /*END*/
 /*END*/

 order by mb.MEMBER_ID asc, PURCHASE_MONTH asc -- basic grammer here