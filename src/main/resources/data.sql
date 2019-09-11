INSERT INTO `cl5_user_tbl` (`created_on`, `email`, `enabled`, `password`, `rvn`, `user_id`, `username`) VALUES ('2019-09-11 08:26:40', 'test@gmail.com', true, '$2a$10$Cb4jpAISVVTBeAgKk8vWkerjn/xZVAhPq7u27qS1QamgQR39ymJn.', 1, 'swaraj1', 'Swaraj');
INSERT INTO `cl5_user_tbl` (`created_on`, `email`, `enabled`, `password`, `rvn`, `user_id`, `username`) VALUES ('2019-09-11 08:27:26', 'test2@gmail.com', true, '$2a$10$Cb4jpAISVVTBeAgKk8vWkerjn/xZVAhPq7u27qS1QamgQR39ymJn.', 1, 'swaraj2', 'Swaraj');
INSERT INTO `cl5_role_tbl` (`role`, `role_id`, `rvn`) VALUES ('ADMIN', '1', 1);
INSERT INTO `cl5_user_role_tbl` (`user_id`, `role_id`) VALUES (1, 1);
