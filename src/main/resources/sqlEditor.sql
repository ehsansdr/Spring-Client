-- wich customer how much money pay in specific duration
with the_customer as (
select c.CustomerId,c.FirstName, c.LastName  from Customer c 
where c.CustomerId = 2
),
the_customer_invoice as (
select inv.InvoiceId,
inv.CustomerId,
inv.InvoiceDate,
IFNULL (c.FirstName,c.FirstName) as FirstName,
IFNULL(c.LastName,c.FirstName) as LastName,
COALESCE (sum(inv.total),0) as total
from invoice inv
right join the_customer c on c.CustomerId = inv.CustomerId
where InvoiceDate between "2007-01-01 00:00:00" and "2030-05-18 00:00:00"
),
the_customer_invoice_line as (
select c.FirstName
from InvoiceLine inv_li 
right join Customer c on inv_li.CustomerId = c.CustomerId
)
select COALESCE (ci.FirstName,ci.FirstName) as FirstName,
COALESCE (ci.LastName,ci.LastName) as LastName,
COALESCE (ci.total,0) as total
from the_customer_invoice ci
left join the_customer cus on cus.CustomerId = ci.CustomerId
group by ci.CustomerId
