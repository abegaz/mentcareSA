-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 30, 2017 at 03:37 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mentcaredb`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `Username` varchar(6) NOT NULL,
  `Psswrd` varchar(20) DEFAULT NULL,
  `access` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`Username`, `Psswrd`, `access`) VALUES
('123456', 'doctor1', 1),
('213000', 'doctor4', 0),
('213452', 'doctor2', 0),
('234451', 'doctor3', 0),
('999999', 'snitzal', 0);

-- --------------------------------------------------------

--
-- Table structure for table `medication`
--

CREATE TABLE `medication` (
  `Med_Id` varchar(6) NOT NULL,
  `Prescribed_By` varchar(25) DEFAULT NULL,
  `Med_Name` varchar(15) DEFAULT NULL,
  `Dosage_Details` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `med_facility`
--

CREATE TABLE `med_facility` (
  `Fac_id` varchar(6) NOT NULL,
  `Fac_address` varchar(30) DEFAULT NULL,
  `Fac_name` varchar(25) DEFAULT NULL,
  `Fac_phone` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `med_facility`
--

INSERT INTO `med_facility` (`Fac_id`, `Fac_address`, `Fac_name`, `Fac_phone`) VALUES
('10', '123 Main St', 'Braircliff Hospital', '5555555555'),
('11', '432 Maple St', 'Greenlawn Hospital', '2222222222'),
('12', '561 Clay Road', 'GoldValley Hospital', '1111111111');

-- --------------------------------------------------------

--
-- Table structure for table `pat_emergency`
--

CREATE TABLE `pat_emergency` (
  `Em_Id` varchar(6) NOT NULL,
  `Pat_Id` varchar(6) DEFAULT NULL,
  `Ename` varchar(25) DEFAULT NULL,
  `EEmail` varchar(25) DEFAULT NULL,
  `Relation` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `pat_info`
--

CREATE TABLE `pat_info` (
  `Pat_Id` varchar(6) NOT NULL,
  `Pname` varchar(25) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `Gender` tinyint(1) DEFAULT NULL,
  `SSN` int(11) DEFAULT NULL,
  `Blood_Type` varchar(3) DEFAULT NULL,
  `Pphone` varchar(15) DEFAULT NULL,
  `PEmail` varchar(20) DEFAULT NULL,
  `Organ_donor` tinyint(1) DEFAULT NULL,
  `PAddress` varchar(45) DEFAULT NULL,
  `Weight` int(11) DEFAULT NULL,
  `Height` int(11) DEFAULT NULL,
  `Notes` varchar(45) DEFAULT NULL,
  `AssignedDoctorId` varchar(6) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pat_info`
--

INSERT INTO `pat_info` (`Pat_Id`, `Pname`, `DOB`, `Gender`, `SSN`, `Blood_Type`, `Pphone`, `PEmail`, `Organ_donor`, `PAddress`, `Weight`, `Height`, `Notes`, `AssignedDoctorId`, `PASSWORD`) VALUES
('999999', 'Hans Gruber', '1959-09-09', 1, 999999999, 'A+', '9999999999', 'NeinHans@ss.de', 0, 'Germany', 199, 99, 'Thinks he is Hitler', '123456', 'hi');

-- --------------------------------------------------------

--
-- Table structure for table `pcondition`
--

CREATE TABLE `pcondition` (
  `Cond_Id` varchar(6) NOT NULL,
  `Cond_Name` varchar(25) DEFAULT NULL,
  `Date_Diagnosed` date DEFAULT NULL,
  `Diagnosed_By` varchar(6) DEFAULT NULL,
  `Treat_Id` varchar(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `physician_info`
--

CREATE TABLE `physician_info` (
  `Phys_id` varchar(6) NOT NULL,
  `Phys_name` varchar(25) DEFAULT NULL,
  `Phys_email` varchar(30) DEFAULT NULL,
  `Phys_phone` varchar(15) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `physician_info`
--

INSERT INTO `physician_info` (`Phys_id`, `Phys_name`, `Phys_email`, `Phys_phone`, `PASSWORD`) VALUES
('123456', 'Dr. John Smith', 'drjohnsmith@email.com', '5552223333', 'goodbye'),
('213000', 'Dr. Rebecca Regan', 'drrebeccaregan@email.com', '1119998888', NULL),
('213452', 'Dr. Jane Black', 'drjaneblack@email.com', '7776668888', NULL),
('234451', 'Dr. Doug Dunbar', 'drdougdunbar@email.com', '2223334444', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `prescribed`
--

CREATE TABLE `prescribed` (
  `Treatment_Treat_Id` varchar(6) DEFAULT NULL,
  `Medication_Med_Id` varchar(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `treatment`
--

CREATE TABLE `treatment` (
  `Treat_Id` varchar(6) NOT NULL,
  `Treat_Name` varchar(20) DEFAULT NULL,
  `Details` varchar(45) DEFAULT NULL,
  `Date_Started` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `works_at`
--

CREATE TABLE `works_at` (
  `Phys_id` varchar(6) DEFAULT NULL,
  `Fac_id` varchar(6) DEFAULT NULL,
  `Off_phone` varchar(15) DEFAULT NULL,
  `Room_no` varchar(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `works_at`
--

INSERT INTO `works_at` (`Phys_id`, `Fac_id`, `Off_phone`, `Room_no`) VALUES
('123456', '10', '5552224444', '255'),
('213452', '10', '5551112222', '264'),
('234451', '11', '2221114343', '104'),
('213000', '12', '1112324444', '301');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`Username`);

--
-- Indexes for table `medication`
--
ALTER TABLE `medication`
  ADD PRIMARY KEY (`Med_Id`),
  ADD KEY `Prescribed_By` (`Prescribed_By`);

--
-- Indexes for table `med_facility`
--
ALTER TABLE `med_facility`
  ADD PRIMARY KEY (`Fac_id`);

--
-- Indexes for table `pat_emergency`
--
ALTER TABLE `pat_emergency`
  ADD PRIMARY KEY (`Em_Id`),
  ADD KEY `Pat_Id` (`Pat_Id`);

--
-- Indexes for table `pat_info`
--
ALTER TABLE `pat_info`
  ADD PRIMARY KEY (`Pat_Id`),
  ADD UNIQUE KEY `password` (`Pat_Id`,`Pname`),
  ADD KEY `AssignedDoctorId` (`AssignedDoctorId`);

--
-- Indexes for table `pcondition`
--
ALTER TABLE `pcondition`
  ADD PRIMARY KEY (`Cond_Id`),
  ADD KEY `Diagnosed_By` (`Diagnosed_By`),
  ADD KEY `Treat_Id` (`Treat_Id`);

--
-- Indexes for table `physician_info`
--
ALTER TABLE `physician_info`
  ADD PRIMARY KEY (`Phys_id`);

--
-- Indexes for table `prescribed`
--
ALTER TABLE `prescribed`
  ADD KEY `Treatment_Treat_Id` (`Treatment_Treat_Id`),
  ADD KEY `Medication_Med_Id` (`Medication_Med_Id`);

--
-- Indexes for table `treatment`
--
ALTER TABLE `treatment`
  ADD PRIMARY KEY (`Treat_Id`);

--
-- Indexes for table `works_at`
--
ALTER TABLE `works_at`
  ADD KEY `Phys_id` (`Phys_id`),
  ADD KEY `Fac_id` (`Fac_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `medication`
--
ALTER TABLE `medication`
  ADD CONSTRAINT `medication_ibfk_1` FOREIGN KEY (`Prescribed_By`) REFERENCES `physician_info` (`Phys_id`);

--
-- Constraints for table `pat_emergency`
--
ALTER TABLE `pat_emergency`
  ADD CONSTRAINT `pat_emergency_ibfk_1` FOREIGN KEY (`Pat_Id`) REFERENCES `pat_info` (`Pat_Id`);

--
-- Constraints for table `pat_info`
--
ALTER TABLE `pat_info`
  ADD CONSTRAINT `pat_info_ibfk_1` FOREIGN KEY (`AssignedDoctorId`) REFERENCES `physician_info` (`Phys_id`);

--
-- Constraints for table `pcondition`
--
ALTER TABLE `pcondition`
  ADD CONSTRAINT `pcondition_ibfk_1` FOREIGN KEY (`Diagnosed_By`) REFERENCES `physician_info` (`Phys_id`),
  ADD CONSTRAINT `pcondition_ibfk_2` FOREIGN KEY (`Treat_Id`) REFERENCES `treatment` (`Treat_Id`);

--
-- Constraints for table `prescribed`
--
ALTER TABLE `prescribed`
  ADD CONSTRAINT `prescribed_ibfk_1` FOREIGN KEY (`Treatment_Treat_Id`) REFERENCES `treatment` (`Treat_Id`),
  ADD CONSTRAINT `prescribed_ibfk_2` FOREIGN KEY (`Medication_Med_Id`) REFERENCES `medication` (`Med_Id`);

--
-- Constraints for table `works_at`
--
ALTER TABLE `works_at`
  ADD CONSTRAINT `works_at_ibfk_1` FOREIGN KEY (`Phys_id`) REFERENCES `physician_info` (`Phys_id`),
  ADD CONSTRAINT `works_at_ibfk_2` FOREIGN KEY (`Fac_id`) REFERENCES `med_facility` (`Fac_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
