-- phpMyAdmin SQL Dump
-- version 4.7.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 09, 2020 at 11:21 PM
-- Server version: 5.6.40-84.0-log
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `abelm286_wp117`
--

-- --------------------------------------------------------

--
-- Table structure for table `wpq0_person`
--

CREATE TABLE `wpq0_person` (
  `ID` int(11) NOT NULL,
  `Name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Age` int(11) NOT NULL,
  `EyeColor` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `wpq0_person`
--

INSERT INTO `wpq0_person` (`ID`, `Name`, `Age`, `EyeColor`) VALUES
(1, 'Abel', 20, 'Brown'),
(2, 'Steve', 20, 'Blue'),
(3, 'Michael', 20, 'Brown'),
(4, 'Sleepy', 10, 'Black');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `wpq0_person`
--
ALTER TABLE `wpq0_person`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `wpq0_person`
--
ALTER TABLE `wpq0_person`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
