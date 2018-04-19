-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 20, 2018 at 01:57 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `testdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(20) COLLATE utf32_unicode_ci NOT NULL,
  `AGE` int(11) NOT NULL,
  `ADDRESS` char(25) COLLATE utf32_unicode_ci DEFAULT NULL,
  `SALARY` decimal(18,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`ID`, `NAME`, `AGE`, `ADDRESS`, `SALARY`) VALUES
(1, 'Ramesh', 32, 'Ahmedabad', '2000.00'),
(2, 'Khilan', 25, 'Delhi', '1500.00'),
(3, 'kaushik', 23, 'Kota', '2000.00'),
(4, 'Chaitali', 25, 'Mumbai', '6500.00'),
(5, 'Hardik', 27, 'Bhopal', '8500.00'),
(6, 'Komal', 22, 'VN', '10000.00'),
(7, 'Hieutran', 1, 'DaNang', '2000.00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
