CREATE TABLE `users`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `fullname` VARCHAR(255) NOT NULL,
    `avartar` VARCHAR(255) NOT NULL,
    `phone` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `gender` TINYINT NOT NULL DEFAULT '3' COMMENT '1: Nam, 2: Nữ, 3: Khác'
);
ALTER TABLE
    `users` ADD UNIQUE `users_phone_unique`(`phone`);
CREATE TABLE `user_frends`(
    `user_one_id` BIGINT UNSIGNED NOT NULL,
    `user_two_id` BIGINT UNSIGNED NOT NULL,
    `status` TINYINT NOT NULL DEFAULT '1' COMMENT '1: lời mời kết bạn chưa được chấp nhận,
2: đang là bạn bè',
    `created_at` DATETIME NOT NULL COMMENT 'Thời gian gửi lời mời kết bạn',
    PRIMARY KEY(`user_one_id`, `user_two_id`)
);
CREATE TABLE `chat_rooms`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `key` VARCHAR(255) NOT NULL
);
CREATE TABLE `user_chat_rooms`(
    `user_id` BIGINT UNSIGNED NOT NULL,
    `chat_room_id` BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY(`user_id`, `chat_room_id`)
);
CREATE TABLE `chat_messages`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `content` LONGTEXT NOT NULL,
    `user_id` BIGINT UNSIGNED NOT NULL,
    `chat_room_id` BIGINT UNSIGNED NOT NULL,
    `created_at` DATETIME NOT NULL
);
ALTER TABLE
    `chat_messages` ADD CONSTRAINT `chat_messages_chat_room_id_foreign` FOREIGN KEY(`chat_room_id`) REFERENCES `chat_rooms`(`id`);
ALTER TABLE
    `chat_messages` ADD CONSTRAINT `chat_messages_user_id_foreign` FOREIGN KEY(`user_id`) REFERENCES `users`(`id`);
ALTER TABLE
    `user_frends` ADD CONSTRAINT `user_frends_user_two_id_foreign` FOREIGN KEY(`user_two_id`) REFERENCES `users`(`id`);
ALTER TABLE
    `user_chat_rooms` ADD CONSTRAINT `user_chat_rooms_user_id_foreign` FOREIGN KEY(`user_id`) REFERENCES `users`(`id`);
ALTER TABLE
    `user_chat_rooms` ADD CONSTRAINT `user_chat_rooms_chat_room_id_foreign` FOREIGN KEY(`chat_room_id`) REFERENCES `chat_rooms`(`id`);
ALTER TABLE
    `user_frends` ADD CONSTRAINT `user_frends_user_one_id_foreign` FOREIGN KEY(`user_one_id`) REFERENCES `users`(`id`);