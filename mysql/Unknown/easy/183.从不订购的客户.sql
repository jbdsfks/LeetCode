--
-- @lc app=leetcode.cn id=183 lang=mysql
--
-- [183] 从不订购的客户
--
-- https://leetcode-cn.com/problems/customers-who-never-order/description/
--
-- database
-- Easy (62.20%)
-- Likes:    102
-- Dislikes: 0
-- Total Accepted:    26.4K
-- Total Submissions: 42.4K
-- Testcase Example:  '{"headers": {"Customers": ["Id", "Name"], "Orders": ["Id", "CustomerId"]}, "rows": {"Customers": [[1, "Joe"], [2, "Henry"], [3, "Sam"], [4, "Max"]], "Orders": [[1, 3], [2, 1]]}}'
--
-- 某网站包含两个表，Customers 表和 Orders 表。编写一个 SQL 查询，找出所有从不订购任何东西的客户。
-- 
-- Customers 表：
-- 
-- +----+-------+
-- | Id | Name  |
-- +----+-------+
-- | 1  | Joe   |
-- | 2  | Henry |
-- | 3  | Sam   |
-- | 4  | Max   |
-- +----+-------+
-- 
-- 
-- Orders 表：
-- 
-- +----+------------+
-- | Id | CustomerId |
-- +----+------------+
-- | 1  | 3          |
-- | 2  | 1          |
-- +----+------------+
-- 
-- 
-- 例如给定上述表格，你的查询应返回：
-- 
-- +-----------+
-- | Customers |
-- +-----------+
-- | Henry     |
-- | Max       |
-- +-----------+
-- 
-- 
--
# Write your MySQL query statement below

-- 505 ms
-- select c.Name as Customers
-- from Customers c left join Orders o on c.id = o.CustomerId
-- where o.id is null;

-- 476 ms
select Name as Customers
from Customers 
where Id not in (
    select DISTINCT CustomerId from Orders
);

