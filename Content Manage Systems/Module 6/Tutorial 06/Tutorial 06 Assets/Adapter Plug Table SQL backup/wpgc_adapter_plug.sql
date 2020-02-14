-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 31, 2019 at 09:57 AM
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
-- Table structure for table `wpgc_adapter_plug`
--

CREATE TABLE `wpgc_adapter_plug` (
  `ID` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(255) NOT NULL,
  `size` int(11) NOT NULL,
  `color` varchar(40) NOT NULL,
  `cost` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `wpgc_adapter_plug`
--

INSERT INTO `wpgc_adapter_plug` (`ID`, `name`, `description`, `size`, `color`, `cost`) VALUES
(1, 'Adapter Plug Universal EU', 'US to LONDON in Travel Adapter Plug', 2, 'RED', 9.99),
(2, 'TopQPS', 'Adapter with Dual USB Ports', 7, 'GREEN', 24.99),
(3, 'WTP Adapter USB', 'Power Adapter with Built-In USB Charger', 8, 'BLUE', 4.95),
(4, 'US Outlet PA', 'Universal to U.S. Outlet Plug Adapter', 5, 'BLACK', 6),
(5, 'Type G 2-1', '2 in 1 Type G', 3, 'GREEN', 5.99),
(6, 'Type G 2-1', '2 in 1 Type G', 3, 'BLUE', 6);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `wpgc_adapter_plug`
--
ALTER TABLE `wpgc_adapter_plug`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `wpgc_adapter_plug`
--
ALTER TABLE `wpgc_adapter_plug`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
