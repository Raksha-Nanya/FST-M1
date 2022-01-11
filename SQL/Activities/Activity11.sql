REM   Script: Activity11
REM   Activity 11 

select customer_id, customer_name from customers  
where customer_id in( select customer_id from orders group by customer_id having count(customer_id)>1) 
union 
select salesman_id, salesman_name from salesman  
where salesman_id in( select salesman_id from orders group by salesman_id having count(salesman_id)>1) 
order by customer_name;

SELECT a.salesman_id, a.salesman_name, order_no, 'highest on', order_date FROM salesman a, orders b 
WHERE a.salesman_id=b.salesman_id 
AND b.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = b.order_date) 
UNION 
SELECT a.salesman_id, salesman_name, order_no, 'lowest on', order_date FROM salesman a, orders b 
WHERE a.salesman_id=b.salesman_id 
AND b.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = b.order_date);

