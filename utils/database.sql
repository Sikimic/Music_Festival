-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 10, 2014 at 01:35 AM
-- Server version: 5.5.24-log
-- PHP Version: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `teatar`
--
CREATE DATABASE `music_fest` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `music_fest`;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `ime` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `telefon` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `repassword` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `user` (`username`, `password`, `ime`, `prezime`, `telefon`, `email`, `repassword`) VALUES
('admin', 'sifra123', 'Admin', 'Adminovic', '011/1112233', 'admin@etf.rs', 'sifra123'),
('bosko', 'sifra123', 'Bosko', 'Nikolic', '011/2013800', 'nbosko@etf.rs', 'sifra123'),
('drasko', 'sifra123', 'Drazen', 'Draskovic', '011/5557733', 'draskovic@etf.rs', 'sifra123'),
('nemanja', 'sifra123', 'Nemanja', 'Kojic', '011/2013700', 'nkojic@etf.rs', 'sifra123');

-- --------------------------------------------------------

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;