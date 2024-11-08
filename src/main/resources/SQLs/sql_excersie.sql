------ show the table that show the game between the team without having duplicate match
/* teams table
CSK,chennai super kings
DC,Delhi capital
GT,Gurat Titans
*/
with matches as (select row_number() over (order by team_name) as ID, t.team_code, t.team_name
                 from teams as t)
select *
from matches team
         join matches opponent on team.ID < opponent.ID

-- out put
/*
۱,CSK,chennai super kings,۲,DC,Delhi capital
۱,CSK,chennai super kings,۳,GT,Gurat Titans
۲,DC,Delhi capital,۳,GT,Gurat Titans
*/

----------------------------------------------------------------------------------------------------
-- https://techtfq.com/blog/30daysqlquerychallenge-query-1
-- Q1
with cte as (select * ,
            case
                when brand1 < brand2 then concat(brand1,brand2,year)
                else concat(brand2,brand1,year)
            end as pair_id
            from brands),
    cte_rn as (
    select * , row_number() over(partition by pair_id order by pair_id) as rn
    from cte
    )
select *
from cte_rn
where rn = 1
   or (custom1 <> custom3 and custom2 <> custom4)

