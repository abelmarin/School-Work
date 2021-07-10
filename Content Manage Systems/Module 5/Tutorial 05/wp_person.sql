-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 10, 2020 at 12:29 AM
-- Server version: 5.7.23-0ubuntu0.16.04.1
-- PHP Version: 7.2.11-2+ubuntu16.04.1+deb.sury.org+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `wordpress`
--

-- --------------------------------------------------------

--
-- Table structure for table `wp_person`
--

CREATE TABLE `wp_person` (
  `ID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Age` int(11) NOT NULL,
  `EyeColor` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `wp_person`
--

INSERT INTO `wp_person` (`ID`, `Name`, `Age`, `EyeColor`) VALUES
(1, 'Devee', 21, 'Blue'),
(2, 'T.Rex', 65000000, 'Brown'),
(3, 'Tony', 54, 'Brown'),
(4, 'Case', 23, 'Green');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `wp_person`
--
ALTER TABLE `wp_person`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `wp_person`
--
ALTER TABLE `wp_person`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
