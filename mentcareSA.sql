-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 17, 2017 at 05:54 PM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mentcaresa`
--

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--
-- Creation: Oct 17, 2017 at 03:30 PM
--

CREATE TABLE IF NOT EXISTS `patient` (
  `patient_id` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `middle_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `social_sec` varchar(11) NOT NULL,
  `dob` date NOT NULL,
  `blood_type` enum('A+','A-','B+','B-','AB+','AB-','O+','O-') NOT NULL,
  `phone_num` varchar(15) NOT NULL,
  `mail_address1` varchar(50) NOT NULL,
  `mail_address2` varchar(50) NOT NULL,
  `city` varchar(30) NOT NULL,
  `state` varchar(2) NOT NULL,
  `country` varchar(50) NOT NULL,
  `zip` varchar(10) NOT NULL,
  `height` int(11) NOT NULL,
  `weight` int(11) NOT NULL,
  `organ_donor` tinyint(1) NOT NULL,
  `emer_contact_first_name` varchar(100) NOT NULL,
  `emer_contact_last_name` varchar(100) NOT NULL,
  `emer_contact_phone` varchar(15) NOT NULL,
  `emer_contact_email` varchar(100) NOT NULL,
  `condition_list` text NOT NULL,
  `treatment` text NOT NULL,
  `notes` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`patient_id`, `email`, `password`, `first_name`, `middle_name`, `last_name`, `social_sec`, `dob`, `blood_type`, `phone_num`, `mail_address1`, `mail_address2`, `city`, `state`, `country`, `zip`, `height`, `weight`, `organ_donor`, `emer_contact_first_name`, `emer_contact_last_name`, `emer_contact_phone`, `emer_contact_email`, `condition_list`, `treatment`, `notes`) VALUES
(1, '101josh10@gmail.com', 'test', 'Joshua', 'Matthew', 'Knight', '111-22-3333', '1995-07-24', 'O+', '706-201-9393', '82 College Cir', '', 'Dahlonega', 'GA', 'United States', '30529', 69, 195, 1, 'Rebecca', 'Baskins', '555-555-5555', 'fakeEmail@test.com', 'a little messed up in the head.\r\nHe''s craaaazy', 'Cant treat him', 'just test notes');

-- --------------------------------------------------------

--
-- Table structure for table `physician`
--
-- Creation: Oct 17, 2017 at 03:43 PM
--

CREATE TABLE IF NOT EXISTS `physician` (
  `physician_id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `middle_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `phone_num` varchar(50) NOT NULL,
  `blood_type` enum('A+','A-','B+','B-','AB+','AB-','O+','A-') NOT NULL,
  `npi` varchar(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `physician`
--

INSERT INTO `physician` (`physician_id`, `email`, `password`, `first_name`, `middle_name`, `last_name`, `phone_num`, `blood_type`, `npi`) VALUES
(1, '101josh10@gmail.com', 'test', 'Joshua', 'Matthew', 'Knight', '555-55-5555', 'O+', '1111233456');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`patient_id`);

--
-- Indexes for table `physician`
--
ALTER TABLE `physician`
  ADD PRIMARY KEY (`physician_id`),
  ADD UNIQUE KEY `npi` (`npi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `patient_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `physician`
--
ALTER TABLE `physician`
  MODIFY `physician_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
