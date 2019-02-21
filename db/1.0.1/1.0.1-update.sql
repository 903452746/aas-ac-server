ALTER TABLE `tb_ac_client`
ADD COLUMN `domain` varchar(255) NULL COMMENT '域名地址' AFTER `white_ip`;