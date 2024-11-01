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

