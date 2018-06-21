/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.6.26 : Database - test
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

USE `test`;

/*Table structure for table `tb_news` */

DROP TABLE IF EXISTS `tb_news`;

CREATE TABLE `tb_news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `modifyDate` date DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `tb_news` */

LOCK TABLES `tb_news` WRITE;

insert  into `tb_news`(`id`,`author`,`content`,`introduction`,`modifyDate`,`title`,`createDate`) values (1,'jack','xxxxx','xxxxx','2017-10-15','贵州遵义下期千年一遇的鹅毛大雪','2017-10-23'),(2,'jack','xxxxx','xxxxx','2017-10-15','遵义高铁','2017-10-13'),(3,'jack','xxxxx','xxxxx','2017-11-03','遵义火车站','2017-10-11'),(4,'jack','xxxxx','xxxxx','2017-10-15','遵义大数据千人培训中心','2017-10-01'),(5,'jack','xxxxx','xxxxx','2017-10-15','贵州互联网基地','2017-10-12'),(6,'enal','xxxx','xxxx','2017-10-15','遵义下鹅毛大雪了','2017-10-15');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
