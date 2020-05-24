--
-- @lc app=leetcode.cn id=197 lang=mysql
--
-- [197] 上升的温度
--
-- https://leetcode-cn.com/problems/rising-temperature/description/
--
-- database
-- Easy (45.72%)
-- Likes:    75
-- Dislikes: 0
-- Total Accepted:    15.9K
-- Total Submissions: 34.7K
-- Testcase Example:  '{"headers": {"Weather": ["Id", "RecordDate", "Temperature"]}, "rows": {"Weather": [[1, "2015-01-01", 10], [2, "2015-01-02", 25], [3, "2015-01-03", 20], [4, "2015-01-04", 30]]}}'
--
-- 给定一个 Weather 表，编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 Id。
-- 
-- +---------+------------------+------------------+
-- | Id(INT) | RecordDate(DATE) | Temperature(INT) |
-- +---------+------------------+------------------+
-- |       1 |       2015-01-01 |               10 |
-- |       2 |       2015-01-02 |               25 |
-- |       3 |       2015-01-03 |               20 |
-- |       4 |       2015-01-04 |               30 |
-- +---------+------------------+------------------+
-- 
-- 例如，根据上述给定的 Weather 表格，返回如下 Id:
-- 
-- +----+
-- | Id |
-- +----+
-- |  2 |
-- |  4 |
-- +----+
-- 
--
# Write your MySQL query statement below
-- 1130 ms
-- select Id from Weather as w1
-- where Temperature > (
--     select Temperature from Weather w2
--     where  w1.RecordDate = date_add(w2.RecordDate, interval 1 day)
-- );

-- 1693 ms 
-- select Id from Weather as w1
-- where Temperature > (
--     select Temperature from Weather w2
--     where  datediff(w1.RecordDate, w2.RecordDate) = 1
-- );


-- 533 ms
select w1.Id as Id
from 
    Weather w1 
    join 
    Weather w2 
    on datediff(w1.RecordDate,w2.RecordDate) = 1 and
        w1.Temperature > w2.Temperature
;

