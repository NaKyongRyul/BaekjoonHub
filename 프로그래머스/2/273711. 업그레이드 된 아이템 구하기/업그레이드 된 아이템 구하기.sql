-- 코드를 작성해주세요
select a.item_id, a.item_name, a.rarity 
from item_info as a inner join item_tree as b
on a.item_id = b.item_id
where b.parent_item_id in (select item_id from item_info where rarity = 'RARE')
order by a.item_id desc