# Write your MySQL query statement below
select MAX(salary) AS SecondHighestSalary from employee 
where salary<(select MAX(salary) from employee);