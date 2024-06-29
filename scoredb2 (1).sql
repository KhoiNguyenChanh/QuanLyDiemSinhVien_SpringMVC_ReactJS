-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: scoredb
-- ------------------------------------------------------
-- Server version	8.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cot_diem_them`
--

DROP TABLE IF EXISTS `cot_diem_them`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cot_diem_them` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `diem` double DEFAULT NULL,
  `cotdiem_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cotdiem_id` (`cotdiem_id`),
  CONSTRAINT `cot_diem_them_ibfk_1` FOREIGN KEY (`cotdiem_id`) REFERENCES `score_sv` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cot_diem_them`
--

LOCK TABLES `cot_diem_them` WRITE;
/*!40000 ALTER TABLE `cot_diem_them` DISABLE KEYS */;
INSERT INTO `cot_diem_them` VALUES (1,'Điểm kiểm tra miệng',7,1),(2,'Điểm kiểm tra 15 phút',7,1);
/*!40000 ALTER TABLE `cot_diem_them` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dangkymonhoc`
--

DROP TABLE IF EXISTS `dangkymonhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dangkymonhoc` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `sinh_vien_id` bigint NOT NULL,
  `lop_hoc_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sinh_vien_lop_hoc_unique` (`sinh_vien_id`,`lop_hoc_id`),
  KEY `lop_hoc_id` (`lop_hoc_id`),
  CONSTRAINT `fk_sinhvien_lophoc` FOREIGN KEY (`sinh_vien_id`) REFERENCES `nguoidung` (`id`),
  CONSTRAINT `fk_sinhvien_lophoc_2` FOREIGN KEY (`lop_hoc_id`) REFERENCES `lophoc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dangkymonhoc`
--

LOCK TABLES `dangkymonhoc` WRITE;
/*!40000 ALTER TABLE `dangkymonhoc` DISABLE KEYS */;
INSERT INTO `dangkymonhoc` VALUES (1,3,1),(5,3,2),(7,3,3),(2,4,1),(6,4,2),(9,4,4),(3,5,1),(4,5,2),(8,5,3),(10,5,4);
/*!40000 ALTER TABLE `dangkymonhoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `danh_muc_mon_hoc`
--

DROP TABLE IF EXISTS `danh_muc_mon_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `danh_muc_mon_hoc` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ten_danh_muc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `mo_ta` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danh_muc_mon_hoc`
--

LOCK TABLES `danh_muc_mon_hoc` WRITE;
/*!40000 ALTER TABLE `danh_muc_mon_hoc` DISABLE KEYS */;
INSERT INTO `danh_muc_mon_hoc` VALUES (1,'Ngoại ngữ','Các môn học về ngôn ngữ'),(2,'Đại cương','Các môn học đại cương'),(3,'Chuyên ngành','Các môn học chuyên ngành'),(4,'Chính trị','Các môn học về chính trị'),(5,'Thể chất','Các môn học về thể chất');
/*!40000 ALTER TABLE `danh_muc_mon_hoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forums`
--

DROP TABLE IF EXISTS `forums`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `forums` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `lop_hoc_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `lop_hoc_id` (`lop_hoc_id`),
  CONSTRAINT `forums_ibfk_1` FOREIGN KEY (`lop_hoc_id`) REFERENCES `lophoc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forums`
--

LOCK TABLES `forums` WRITE;
/*!40000 ALTER TABLE `forums` DISABLE KEYS */;
INSERT INTO `forums` VALUES (1,1),(3,1),(2,2);
/*!40000 ALTER TABLE `forums` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lophoc`
--

DROP TABLE IF EXISTS `lophoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lophoc` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `mon_hoc_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mon_hoc_id` (`mon_hoc_id`),
  CONSTRAINT `lophoc_ibfk_1` FOREIGN KEY (`mon_hoc_id`) REFERENCES `monhoc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lophoc`
--

LOCK TABLES `lophoc` WRITE;
/*!40000 ALTER TABLE `lophoc` DISABLE KEYS */;
INSERT INTO `lophoc` VALUES (1,'Lập trình web Java',1),(2,'Công nghệ phần mềm',2),(3,'Lý luận chính trị',3),(4,'Tiếng Anh cơ bản',4),(5,'Giải tích 1',5);
/*!40000 ALTER TABLE `lophoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monhoc`
--

DROP TABLE IF EXISTS `monhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monhoc` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `mo_ta_mon_hoc` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `giang_vien_id` bigint DEFAULT NULL,
  `ten_giang_vien` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `danh_muc_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `monhoc_ibfk_1` (`giang_vien_id`),
  KEY `fk_danh_muc_id` (`danh_muc_id`),
  CONSTRAINT `fk_danh_muc_id` FOREIGN KEY (`danh_muc_id`) REFERENCES `danh_muc_mon_hoc` (`id`),
  CONSTRAINT `monhoc_ibfk_1` FOREIGN KEY (`giang_vien_id`) REFERENCES `nguoidung` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monhoc`
--

LOCK TABLES `monhoc` WRITE;
/*!40000 ALTER TABLE `monhoc` DISABLE KEYS */;
INSERT INTO `monhoc` VALUES (1,'Lập trình Java','Môn học về lập trình web bằng Java',2,'Dương Hữu Thành',3),(2,'Công nghệ phần mềm','Môn học về công nghệ phần mềm',2,'Dương Hữu Thành',3),(3,'Lý luận chính trị','Môn học về lý luận chính trị',6,'Trương Văn C',4),(4,'Tiếng Anh Cơ Bản','Môn học tiếng Anh dành cho người mới bắt đầu',7,'Nguyễn Văn A',1),(5,'Giải Tích 1','Môn học về giải tích',8,'Lê Thị B',2),(6,'Mạng Máy Tính','Môn học về mạng máy tính và các giao thức',2,'Dương Hữu Thành',3),(7,'Triết Học Mác-Lênin','Môn học về triết học Mác-Lênin',6,'Trương Văn C',4),(8,'Bóng Đá','Môn học về kỹ năng và luật chơi bóng đá',9,'Phạm Văn D',5),(9,'Lập Trình Python','Môn học về lập trình Python',2,'Dương Hữu Thành',3),(10,'Kinh Tế Vĩ Mô','Môn học về kinh tế vĩ mô',10,'Trần Thị E',2),(11,'Hóa Học Đại Cương','Môn học về hóa học cơ bản',11,'Nguyễn Thị F',2),(12,'Quản Trị Kinh Doanh','Môn học về quản trị kinh doanh',12,'Hoàng Văn G',3),(13,'Tư Tưởng Hồ Chí Minh','Môn học về tư tưởng Hồ Chí Minh',6,'Trương Văn C',4),(18,'Thêm 1 môn mới','thêm thử 1 môn mới',9,NULL,3);
/*!40000 ALTER TABLE `monhoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguoidung`
--

DROP TABLE IF EXISTS `nguoidung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguoidung` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `sdt` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `active` bit(1) DEFAULT b'1',
  `role` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoidung`
--

LOCK TABLES `nguoidung` WRITE;
/*!40000 ALTER TABLE `nguoidung` DISABLE KEYS */;
INSERT INTO `nguoidung` VALUES (1,'Do Anh Khoa','dokhoa@uni.edu.vn','123456789','dokhoa','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO',_binary '','admin',NULL),
(2,'Duong Huu Thanh','duongthanh@uni.edu.vn','987654321','duongthanh','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO',_binary '','giangvien',NULL),
(3,'Nguyen Chanh Khoi','nguyenkhoi@uni.edu.vn','654321789','nguyenkhoi','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO',_binary '','sinhvien','https://res.cloudinary.com/dbqaequqv/image/upload/v1718265744/student_ninfvs.png'),
(4,'Nguyen Sinh A','nguyena@uni.edu.vn','456789123','nguyena','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO',_binary '','sinhvien','https://res.cloudinary.com/dbqaequqv/image/upload/v1718265744/student_ninfvs.png'),
(5,'Ho Anh B','hob@uni.edu.vn','789123456','hob','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO',_binary '','sinhvien','https://res.cloudinary.com/dbqaequqv/image/upload/v1718265744/student_ninfvs.png'),
(6,'Truong Van C','truongc@uni.edu.vn','128478798','truongc','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO',_binary '','giangvien',NULL),
(7,'Nguyễn Văn A','nguyena@example.com','123456780','nguyena','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO',_binary '','giangvien',NULL),
(8,'Lê Thị B','leb@example.com','123456781','leb','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO',_binary '','giangvien',NULL),
(9,'Phạm Văn D','phamd@example.com','123456782','phamd','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO',_binary '','giangvien',NULL),
(10,'Trần Thị E','trane@example.com','123456783','trane','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO',_binary '','giangvien',NULL),
(11,'Nguyễn Thị F','nguyenf@example.com','123456784','nguyenf','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO',_binary '','giangvien',NULL),
(12,'Hoàng Văn G','hoangg@example.com','123456785','hoangg','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO',_binary '','giangvien',NULL),
(13,'Tô Văn H','toh@uni.edu.vn','123456786','toh','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO',_binary '','sinhvien','https://res.cloudinary.com/dbqaequqv/image/upload/v1718265744/student_ninfvs.png');
/*!40000 ALTER TABLE `nguoidung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `score_sv`
--

DROP TABLE IF EXISTS `score_sv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `score_sv` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `giua_ky` double DEFAULT NULL,
  `cuoi_ky` double DEFAULT NULL,
  `lop_hoc_id` bigint DEFAULT NULL,
  `sinh_vien_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `lop_hoc_id` (`lop_hoc_id`),
  KEY `sinh_vien_id` (`sinh_vien_id`),
  CONSTRAINT `score_sv_ibfk_1` FOREIGN KEY (`lop_hoc_id`) REFERENCES `lophoc` (`id`),
  CONSTRAINT `score_sv_ibfk_2` FOREIGN KEY (`sinh_vien_id`) REFERENCES `nguoidung` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `score_sv`
--

LOCK TABLES `score_sv` WRITE;
/*!40000 ALTER TABLE `score_sv` DISABLE KEYS */;
INSERT INTO `score_sv` VALUES (1,7.5,8,1,3),(2,7.5,9.5,1,4),(3,6,4,2,3);
/*!40000 ALTER TABLE `score_sv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tin_nhan_forum`
--

DROP TABLE IF EXISTS `tin_nhan_forum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tin_nhan_forum` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `noi_dung` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `tac_gia_id` bigint DEFAULT NULL,
  `thoi_gian` datetime DEFAULT NULL,
  `forum_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tac_gia_id` (`tac_gia_id`),
  KEY `forum_id` (`forum_id`),
  CONSTRAINT `tin_nhan_forum_ibfk_1` FOREIGN KEY (`tac_gia_id`) REFERENCES `nguoidung` (`id`),
  CONSTRAINT `tin_nhan_forum_ibfk_2` FOREIGN KEY (`forum_id`) REFERENCES `forums` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tin_nhan_forum`
--

LOCK TABLES `tin_nhan_forum` WRITE;
/*!40000 ALTER TABLE `tin_nhan_forum` DISABLE KEYS */;
INSERT INTO `tin_nhan_forum` VALUES (1,'Chào mọi người!',3,'2024-06-16 01:04:10',1),(2,'Môn này khó quá :(',4,'2024-06-16 01:04:10',1);
/*!40000 ALTER TABLE `tin_nhan_forum` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-23 21:40:24
