select
    user_id,
    role_id,
    count(*) as duplicates_count
from users_roles
group by user_id, role_id
having count(*) > 1;

select
    user_id,
    role_id,
    row_number() over (
        partition by user_id, role_id
        order by user_id, role_id
    ) as rn
from users_roles;

select *
from (
    select
        user_id,
        role_id,
        row_number() over (
            partition by user_id, role_id
            order by user_id, role_id
        ) as rn
    from users_roles
) duplicates
where rn > 1;