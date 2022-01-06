# Host: localhost  (Version 5.5.5-10.4.8-MariaDB)
# Date: 2020-12-04 16:31:43
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "tbl_buku"
#

DROP TABLE IF EXISTS `tbl_buku`;
CREATE TABLE `tbl_buku` (
  `kd_buku` varchar(15) NOT NULL,
  `jdl_buku` varchar(40) NOT NULL,
  `tgl_terbit` date NOT NULL DEFAULT current_timestamp(),
  `pengarang` varchar(30) NOT NULL,
  PRIMARY KEY (`kd_buku`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "tbl_buku"
#

INSERT INTO `tbl_buku` VALUES ('KP021','Belajar Office','2020-11-11','Tono'),('KP032','Algoritma','2020-11-18','Maman');

#
# Structure for table "tbl_mahasiswa"
#

DROP TABLE IF EXISTS `tbl_mahasiswa`;
CREATE TABLE `tbl_mahasiswa` (
  `nim` varchar(10) NOT NULL DEFAULT '',
  `nama` varchar(30) NOT NULL,
  `tmpt_lahir` varchar(20) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `jurusan` varchar(25) NOT NULL,
  `tgl_masuk` date NOT NULL,
  PRIMARY KEY (`nim`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "tbl_mahasiswa"
#

INSERT INTO `tbl_mahasiswa` VALUES ('1911500518','Agung Ma\'ruf','Bogor','2020-11-01','Informatika','2018-11-15'),('1932500518','Marimas','Jawa','2009-11-20','FEB','2019-11-20');

#
# Structure for table "tbl_peminjam"
#

DROP TABLE IF EXISTS `tbl_peminjam`;
CREATE TABLE `tbl_peminjam` (
  `nim` varchar(10) NOT NULL DEFAULT '',
  `nama` varchar(30) NOT NULL,
  `kd_buku` varchar(15) NOT NULL,
  `jdl_buku` varchar(40) NOT NULL,
  `tgl_terbit` date NOT NULL,
  `tgl_pinjam` date NOT NULL,
  PRIMARY KEY (`nim`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "tbl_peminjam"
#

INSERT INTO `tbl_peminjam` VALUES ('1911500518','Agung Ma\'ruf','M023','Mahir Pemrograman Java','2013-11-14','2020-11-01'),('1932500518','Amanda ','M987','Mahir Accounting','2012-11-28','2020-11-03');
