 NewsTask where a user can add,delete,update and read news according to the level of access by the role of the users. The roles that can be in the system is ADMIN, PUBLISHER and READER.
ADMIN can delete,update, add and read news and also assign roles to the user. Publisher can add,update and read news. Reader can only read the news. 
The project is built using SpringBoot, JAVA, HTML and MySQL.
The Register Page in the appliation can only register user as "READER". For Roles of "ADMIN" and "PUBLISHER", add the roles through DB ( Add data to Users, Roles and User_Roles Table). The password is encrypted using BCryptPasswordEncoder. Copy the password by running that and use that password to save in DB.
Example SQL Query to save a user in DB: 
(INSERT INTO `tasknewsdb`.`users` (`last_name`, `email`, `first_name`, `password`, `username`) VALUES ('Preetam', 'preetam.@gmail.com', 'preetamm', '$2a$10$PQF9HJcldUb8uTAQJWxJmuMYQN4wtPVZ.6GKrOThwiBJACBIeq1fy', 'pree');)

INSERT INTO `tasknewsdb`.`roles` (`role_id`, `name`) VALUES ('1', 'ADMIN');

INSERT INTO `tasknewsdb`.`roles` (`role_id`, `name`) VALUES ('2', 'PUBLISHER');

INSERT INTO `tasknewsdb`.`roles` (`role_id`, `name`) VALUES ('3', 'READER');

INSERT INTO `tasknewsdb`.`users_roles` (`user_id`, `role_id`) VALUES ('1', '1');



