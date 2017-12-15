-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 12, 2017 at 08:46 PM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projectfinal`
--

-- --------------------------------------------------------

--
-- Table structure for table `patient_word`
--

CREATE TABLE `patient_word` (
  `Name` varchar(70) DEFAULT NULL,
  `patient_no` int(11) NOT NULL,
  `Word_no` int(20) NOT NULL,
  `Admitdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Release_Date` date DEFAULT NULL,
  `Is_Release` varchar(70) DEFAULT NULL,
  `Age` int(20) DEFAULT NULL,
  `gender` varchar(30) NOT NULL,
  `Address` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient_word`
--

INSERT INTO `patient_word` (`Name`, `patient_no`, `Word_no`, `Admitdate`, `Release_Date`, `Is_Release`, `Age`, `gender`, `Address`) VALUES
('tonni', 21, 31, '2017-10-13 00:38:24', '2017-10-13', 'Yes', 21, 'Female', 'rajbari'),
('hasan', 23, 31, '2016-09-05 02:06:27', NULL, 'No', 21, 'Male', 'rajbari'),
('zahid', 26, 21, '2016-09-05 11:31:36', NULL, 'No', 21, 'Male', 'asdkjh'),
('zahid', 27, 21, '2016-09-05 11:31:41', NULL, 'No', 21, 'Male', 'asdkjh');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(5) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `Username` varchar(100) NOT NULL,
  `Gender` varchar(20) NOT NULL,
  `Phone` int(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `firstname`, `lastname`, `email`, `Username`, `Gender`, `Phone`, `Password`) VALUES
(1, 'asdaasd', 'asdasd', 'asd', 'asd', 'Male', 12, '12'),
(2, 'Zahid', 'Hasan', 'aiubzahid@gmail.com', 'Zahid08', 'Male', 1741174838, '123'),
(3, 'Tanvir', 'Rahman', 'ta@gmail.com', 'ta08', 'Male', 1845877626, '123'),
(4, 'Taslima', 'akter', 'ta@gmail.com', 'ta12', 'Female', 185654225, '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `patient_word`
--
ALTER TABLE `patient_word`
  ADD PRIMARY KEY (`patient_no`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `patient_word`
--
ALTER TABLE `patient_word`
  MODIFY `patient_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
