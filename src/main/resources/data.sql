INSERT INTO `user` (`createdon`, `email`, `enabled`, `password`, `username`) VALUES ('2019-09-10 06:44:32', 'swaraj2204@gmail.com', true, 'test123', 'swaraj');
INSERT INTO `user` (`createdon`, `email`, `enabled`, `password`, `username`) VALUES ('2019-09-10 06:45:56', 'test@gmail.com', true, 'test123', 'swaraj1');

INSERT INTO `role` (`name`) VALUES ('ADMIN');
INSERT INTO `role` (`name`) VALUES ('VALIDATOR');

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES (2, 2);
