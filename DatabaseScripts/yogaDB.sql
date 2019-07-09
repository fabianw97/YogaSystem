-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 08, 2019 at 04:49 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `yogaDB`
--
CREATE DATABASE IF NOT EXISTS `yogaDB` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `yogaDB`;

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `id` int(11) UNSIGNED NOT NULL,
  `customer_id` int(10) UNSIGNED NOT NULL,
  `class_id` int(10) UNSIGNED NOT NULL,
  `date_created` date NOT NULL,
  `date_start` date NOT NULL,
  `time_start` time NOT NULL,
  `time_end` time NOT NULL,
  `is_cancelled` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`id`, `customer_id`, `class_id`, `date_created`, `date_start`, `time_start`, `time_end`, `is_cancelled`) VALUES
(20, 14, 1, '2019-03-08', '2019-03-09', '16:00:00', '17:00:00', 0),
(21, 14, 4, '2019-03-08', '2019-03-15', '10:00:00', '11:00:00', 0);

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `id` int(11) UNSIGNED NOT NULL,
  `location_id` int(11) UNSIGNED NOT NULL,
  `class_type_id` int(11) UNSIGNED NOT NULL,
  `date_start` date NOT NULL,
  `date_end` date NOT NULL,
  `time_start` time NOT NULL,
  `duration` int(3) NOT NULL,
  `day_of_week` int(7) NOT NULL,
  `cancel_all` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`id`, `location_id`, `class_type_id`, `date_start`, `date_end`, `time_start`, `duration`, `day_of_week`, `cancel_all`) VALUES
(1, 1, 1, '2019-02-26', '2019-03-05', '13:00:00', 1, 2, 0),
(2, 1, 2, '2019-01-23', '2019-01-31', '11:30:00', 60, 2, 0),
(3, 1, 2, '2019-01-29', '2019-01-31', '10:00:00', 1, 3, 0),
(4, 2, 1, '2019-01-31', '2019-02-01', '08:00:00', 1, 2, 0),
(5, 2, 2, '2019-01-31', '2019-02-01', '08:00:00', 1, 2, 0),
(6, 2, 3, '2019-01-31', '2019-02-01', '08:00:00', 1, 2, 0),
(7, 3, 1, '2019-01-31', '2019-02-01', '08:00:00', 1, 2, 0),
(8, 3, 2, '2019-01-31', '2019-02-01', '08:00:00', 1, 2, 0),
(9, 3, 3, '2019-01-31', '2019-02-01', '08:00:00', 1, 2, 0),
(10, 3, 4, '2019-03-05', '2019-03-05', '10:00:00', 60, 2, 0),
(12, 1, 5, '2019-03-08', '2019-03-15', '10:00:00', 60, 5, 0),
(13, 1, 5, '2019-03-08', '2019-03-15', '08:10:00', 60, 5, 0);

-- --------------------------------------------------------

--
-- Table structure for table `class_type`
--

CREATE TABLE `class_type` (
  `id` int(10) UNSIGNED NOT NULL,
  `class_name` varchar(225) NOT NULL,
  `class_description` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `class_type`
--

INSERT INTO `class_type` (`id`, `class_name`, `class_description`) VALUES
(1, 'Yoga', 'Yoga uses breathing techniques, exercise and meditation. It helps to improve health and happiness. Yoga is the Sanskrit word for union. Patanjali was a pioneer of classical yoga. He defined yoga as \"the cessation of the modif'),
(2, 'Aerobics ', 'Aerobics '),
(3, 'Acro Yoga', 'acro yoga'),
(4, 'Restorative yoga', 'Restorative yoga Description'),
(5, 'Yin Yoga', 'Yin Yoga description '),
(12, 'Example Class', 'Example');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(225) NOT NULL,
  `address` varchar(225) NOT NULL,
  `postcode` varchar(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`id`, `name`, `address`, `postcode`) VALUES
(1, 'Venue1', '1,address street', 'M1 M11'),
(2, 'The Life Centre', '253 Deansgate Mews, Manchester ', 'M3 4EN'),
(3, 'MMU Sport', '99 Oxford Rd, Manchester', ' M1 7EL');

-- --------------------------------------------------------

--
-- Table structure for table `persistent_logins`
--

CREATE TABLE `persistent_logins` (
  `username` varchar(100) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `id` int(11) UNSIGNED NOT NULL,
  `first_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `phone_num` varchar(11) DEFAULT NULL,
  `uac` varchar(100) NOT NULL DEFAULT 'Customer'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`id`, `first_name`, `last_name`, `username`, `password`, `phone_num`, `uac`) VALUES
(1, 'Fabian', 'Woodman', 'test@test.com', 'password', '0771231234', 'Admin'),
(13, 'Tutor ', 'TutorExample', 'test@tutor.com', '1234', '07700900077', 'Tutor'),
(14, 'Customer', 'Surname', 'test@customer.com', '1234', '07700900022', 'Customer');

-- --------------------------------------------------------

--
-- Table structure for table `tutor`
--

CREATE TABLE `tutor` (
  `id` int(11) UNSIGNED NOT NULL,
  `user_id` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tutor`
--

INSERT INTO `tutor` (`id`, `user_id`) VALUES
(5, 13);

-- --------------------------------------------------------

--
-- Table structure for table `tutor_class`
--

CREATE TABLE `tutor_class` (
  `tutor_id` int(11) UNSIGNED NOT NULL,
  `class_id` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_authorities`
--

CREATE TABLE `user_authorities` (
  `id` int(11) UNSIGNED NOT NULL,
  `user_id` int(11) UNSIGNED NOT NULL,
  `authority` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_authorities`
--

INSERT INTO `user_authorities` (`id`, `user_id`, `authority`) VALUES
(1, 1, 'Admin'),
(13, 13, 'Tutor'),
(14, 14, 'Customer');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`id`),
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `class_id` (`class_id`);

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`id`),
  ADD KEY `location_id` (`location_id`,`class_type_id`),
  ADD KEY `fk_class_type_id` (`class_type_id`);

--
-- Indexes for table `class_type`
--
ALTER TABLE `class_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `persistent_logins`
--
ALTER TABLE `persistent_logins`
  ADD PRIMARY KEY (`series`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `tutor`
--
ALTER TABLE `tutor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `tutor_class`
--
ALTER TABLE `tutor_class`
  ADD PRIMARY KEY (`tutor_id`,`class_id`),
  ADD KEY `tutor_id` (`tutor_id`),
  ADD KEY `class_id` (`class_id`);

--
-- Indexes for table `user_authorities`
--
ALTER TABLE `user_authorities`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `class`
--
ALTER TABLE `class`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `class_type`
--
ALTER TABLE `class_type`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `tutor`
--
ALTER TABLE `tutor`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user_authorities`
--
ALTER TABLE `user_authorities`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `fk_class_id` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`),
  ADD CONSTRAINT `fk_customer_id` FOREIGN KEY (`customer_id`) REFERENCES `person` (`id`);

--
-- Constraints for table `class`
--
ALTER TABLE `class`
  ADD CONSTRAINT `fk_class_type_id` FOREIGN KEY (`class_type_id`) REFERENCES `class_type` (`id`),
  ADD CONSTRAINT `fk_location_id` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`);

--
-- Constraints for table `tutor`
--
ALTER TABLE `tutor`
  ADD CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `person` (`id`);

--
-- Constraints for table `tutor_class`
--
ALTER TABLE `tutor_class`
  ADD CONSTRAINT `fk_tutor_id` FOREIGN KEY (`tutor_id`) REFERENCES `tutor` (`id`),
  ADD CONSTRAINT `pkfk_class_id` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
