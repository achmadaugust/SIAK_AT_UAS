-- Valentina Studio --
-- MySQL dump --
-- ---------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- ---------------------------------------------------------


-- CREATE TABLE "t_mahasiswa" ------------------------------
-- CREATE TABLE "t_mahasiswa" ----------------------------------
CREATE TABLE `t_mahasiswa` ( 
	`npm` Int( 255 ) NOT NULL,
	`nama` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	`tmp_lahir` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	`tgl_lahir` Date NOT NULL,
	`jurusan` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	`jn_klamin` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	`alamat` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	PRIMARY KEY ( `npm` ) )
CHARACTER SET = utf8
COLLATE = utf8_general_ci
ENGINE = InnoDB;
-- -------------------------------------------------------------
-- ---------------------------------------------------------


-- CREATE TABLE "t_matakuliah" -----------------------------
-- CREATE TABLE "t_matakuliah" ---------------------------------
CREATE TABLE `t_matakuliah` ( 
	`id_mk` Int( 255 ) NOT NULL,
	`nama_mk` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	`sks` Int( 255 ) NOT NULL,
	PRIMARY KEY ( `id_mk` ) )
CHARACTER SET = utf8
COLLATE = utf8_general_ci
ENGINE = InnoDB;
-- -------------------------------------------------------------
-- ---------------------------------------------------------


-- CREATE TABLE "t_nilai" ----------------------------------
-- CREATE TABLE "t_nilai" --------------------------------------
CREATE TABLE `t_nilai` ( 
	`nomor` Int( 255 ) AUTO_INCREMENT NOT NULL,
	`npm` Int( 255 ) NOT NULL,
	`id_mk` Int( 255 ) NOT NULL,
	`nilai` Int( 255 ) NOT NULL,
	PRIMARY KEY ( `nomor` ),
	CONSTRAINT `nomor` UNIQUE( `nomor` ) )
CHARACTER SET = utf8
COLLATE = utf8_general_ci
ENGINE = InnoDB
AUTO_INCREMENT = 1;
-- -------------------------------------------------------------
-- ---------------------------------------------------------


-- Dump data of "t_mahasiswa" ------------------------------
INSERT INTO `t_mahasiswa`(`npm`,`nama`,`tmp_lahir`,`tgl_lahir`,`jurusan`,`jn_klamin`,`alamat`) VALUES ( '1402019', 'Evalia Annisa', 'Malang', '1998-05-01', 'T. Informatika', 'Wanita', 'Bandung' );
INSERT INTO `t_mahasiswa`(`npm`,`nama`,`tmp_lahir`,`tgl_lahir`,`jurusan`,`jn_klamin`,`alamat`) VALUES ( '1409015', 'Achmad Try A.', 'Bandung', '1997-08-03', 'T. Komputer     ', 'Pria  ', 'Bandung' );
INSERT INTO `t_mahasiswa`(`npm`,`nama`,`tmp_lahir`,`tgl_lahir`,`jurusan`,`jn_klamin`,`alamat`) VALUES ( '1410001', 'Siti Azizah Z.', 'Jakarta', '1997-07-07', 'T. Komputer  ', 'Wanita', 'Bandung' );
-- ---------------------------------------------------------


-- Dump data of "t_matakuliah" -----------------------------
INSERT INTO `t_matakuliah`(`id_mk`,`nama_mk`,`sks`) VALUES ( '1023', 'Algoritma & Struktur Data', '3' );
INSERT INTO `t_matakuliah`(`id_mk`,`nama_mk`,`sks`) VALUES ( '1024', 'Pemograman II (Java OOP)', '3' );
INSERT INTO `t_matakuliah`(`id_mk`,`nama_mk`,`sks`) VALUES ( '1025', 'B. Inggris II (Conversation)', '2' );
-- ---------------------------------------------------------


-- Dump data of "t_nilai" ----------------------------------
INSERT INTO `t_nilai`(`nomor`,`npm`,`id_mk`,`nilai`) VALUES ( '1', '1409015', '1023', '89' );
INSERT INTO `t_nilai`(`nomor`,`npm`,`id_mk`,`nilai`) VALUES ( '2', '1409015', '1024', '90' );
INSERT INTO `t_nilai`(`nomor`,`npm`,`id_mk`,`nilai`) VALUES ( '3', '1402019', '1023', '75' );
INSERT INTO `t_nilai`(`nomor`,`npm`,`id_mk`,`nilai`) VALUES ( '4', '1402019', '1025', '80' );
-- ---------------------------------------------------------


-- CREATE INDEX "lnk_t_mahasiswa_t_nilai" ------------------
-- CREATE INDEX "lnk_t_mahasiswa_t_nilai" ----------------------
CREATE INDEX `lnk_t_mahasiswa_t_nilai` USING BTREE ON `t_nilai`( `npm` );
-- -------------------------------------------------------------
-- ---------------------------------------------------------


-- CREATE INDEX "lnk_t_matakuliah_t_nilai" -----------------
-- CREATE INDEX "lnk_t_matakuliah_t_nilai" ---------------------
CREATE INDEX `lnk_t_matakuliah_t_nilai` USING BTREE ON `t_nilai`( `id_mk` );
-- -------------------------------------------------------------
-- ---------------------------------------------------------


-- CREATE LINK "lnk_t_mahasiswa_t_nilai" -------------------
-- CREATE LINK "lnk_t_mahasiswa_t_nilai" -----------------------
ALTER TABLE `t_nilai`
	ADD CONSTRAINT `lnk_t_mahasiswa_t_nilai` FOREIGN KEY ( `npm` )
	REFERENCES `t_mahasiswa`( `npm` )
	ON DELETE Cascade
	ON UPDATE Cascade;
-- -------------------------------------------------------------
-- ---------------------------------------------------------


-- CREATE LINK "lnk_t_matakuliah_t_nilai" ------------------
-- CREATE LINK "lnk_t_matakuliah_t_nilai" ----------------------
ALTER TABLE `t_nilai`
	ADD CONSTRAINT `lnk_t_matakuliah_t_nilai` FOREIGN KEY ( `id_mk` )
	REFERENCES `t_matakuliah`( `id_mk` )
	ON DELETE Cascade
	ON UPDATE Cascade;
-- -------------------------------------------------------------
-- ---------------------------------------------------------


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
-- ---------------------------------------------------------


