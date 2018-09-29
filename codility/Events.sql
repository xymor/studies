-- write your code in PostgreSQL 9.4
SELECT distinct a.sensor_id, a.event_type, a.value 
from events a
inner join (
    select sensor_id, event_type, max(time) as max_time
    from events
    group by sensor_id, event_type
) b
on a.time=b.max_time and a.sensor_id=b.sensor_id and a.event_type=b.event_type
order by sensor_id, event_type
