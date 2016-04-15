insert into users(username,password) values('admin','jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg=');
insert into roles(rolename) values('ADMIN');
insert into roles(rolename) values('USER');
insert into roles(rolename) values('GUEST');
insert into users_roles(user_id,roles_id) values(1,1);
insert into users_roles(user_id,roles_id) values(1,2);
insert into users_roles(user_id,roles_id) values(1,3);