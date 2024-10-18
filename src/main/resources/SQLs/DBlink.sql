-- make sure to have this extension active
-- DBlink
-- CREATE EXTENSION dblink;

---------------------------------------------------------------------------------
-----             fill part               ---------------------------------------
---------------------------------------------------------------------------------

INSERT INTO world_cities_ddd (name,country,subcountry,geonameid)
SELECT *
FROM (
		select *
		from dblink('dbname=fromDBever user = postgres password = postgres',
		   'select
			name,
			country,
            subcountry,
			geonameid
			from world_cities'
		   ) as target
				   (
				   name varchar(50),
				   country varchar(256),
				   subcountry varchar(50),
				   geonameid int4
				   )
		   where subcountry in( 'Herat' , 'Styria' , 'Victoria')
	 )
---------------------------------------------------------------------------------
-----             update part               -------------------------------------
---------------------------------------------------------------------------------
update world_cities_ddd
set country = target.country
from(
select *
from dblink('dbname=fromDBever user = postgres password = postgres',
		   'select country,subcountry,geonameid from world_cities'
		   ) as target
		   (country varchar(256),
			subcountry varchar(50),
			geonameid int4
		   )
		   where subcountry in( 'Baki' , 'Dhaka')
		) as target
	where world_cities_ddd.subcountry = 'Herat'

