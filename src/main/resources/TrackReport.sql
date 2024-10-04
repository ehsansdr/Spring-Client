-- the total of the track selling
with invoice_report as(
SELECT
i.InvoiceId ,
i.InvoiceDate ,
sum(i.Total ) as total
from Invoice i
where i.invoiceId in (1,214)
),
invoice_line_report as (
SELECT
il.InvoiceId,
il.TrackId
from InvoiceLine il
where il.TrackId = 2
)
select t.TrackId ,
t.Name ,
ir.invoiceId,
ir.total
from Track t
left join invoice_line_report ilr on ilr.TrackId = t.TrackId
left join invoice_report ir on ir.InvoiceId = t.TrackId
where t.TrackId = 2


--SELECT COUNT(*)
--from InvoiceLine il
--where il.UnitPrice = 3.96
-- 10.89
--SELECT *
--from InvoiceLine il
--where il.TrackId = 2
--
--
--SELECT
--i.InvoiceId ,
--i.InvoiceDate ,
--sum(i.Total )
--from Invoice i
--where i.invoiceId in (1,214)




