select a.id, ifnull(cnt, 0) as child_count 
from ecoli_data as a 
left outer join
(select parent_id, count(*) as cnt from ecoli_data
group by parent_id
having parent_id is not null) as b
on a.id = b.parent_id
order by id 
