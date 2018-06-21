-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.26 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 test.tb_order 结构
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE IF NOT EXISTS `tb_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2p4n9ciui39792tk5qdpcxq1w` (`user_id`),
  CONSTRAINT `FK2p4n9ciui39792tk5qdpcxq1w` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- 正在导出表  test.tb_order 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `tb_order` DISABLE KEYS */;
INSERT INTO `tb_order` (`id`, `code`, `createDate`, `user_id`) VALUES
	(1, 'aadsa', '2017-10-18', 1),
	(2, 'sad', '2017-10-18', 1),
	(3, 'asf', '2017-10-18', 1),
	(4, '34asf', '2017-10-18', 1),
	(5, 'asdas', '2017-10-18', 1),
	(6, 'sadg', '2017-10-18', 1),
	(7, 'asdfgsag', '2017-10-18', 4),
	(8, 'asdgf', '2017-10-18', 8),
	(9, 'adsg', '2017-10-18', 1),
	(10, 'agds', '2017-10-18', 1),
	(11, 'adsga', '2017-10-18', 11),
	(12, 'dasdas', '2017-10-18', 11);
/*!40000 ALTER TABLE `tb_order` ENABLE KEYS */;

-- 导出  表 test.tb_user 结构
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE IF NOT EXISTS `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createDate` date DEFAULT NULL,
  `loginName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- 正在导出表  test.tb_user 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` (`id`, `createDate`, `loginName`, `password`) VALUES
	(1, '2017-10-15', 'admin', '123456'),
	(2, '2017-10-16', 'system', '1234565'),
	(3, '2017-10-16', 'a', '1234565'),
	(4, '2017-10-14', 'asda', '1234565'),
	(5, '2017-10-16', 'asdas', '1234565'),
	(6, '2017-10-18', 'sadfas', '1234565'),
	(7, '2017-10-15', 'safsaf', '1234565'),
	(8, '2017-10-18', 'asfasf', '1234565'),
	(9, '2017-10-16', 'asfasf', '1234565'),
	(10, '2017-10-15', 'asfasfda', '1234565'),
	(11, '2017-10-15', 'asfa', '1234565');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
