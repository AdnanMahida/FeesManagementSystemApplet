-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 24, 2019 at 09:18 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `feesmanagment`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_details`
--

CREATE TABLE `admin_details` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin_details`
--

INSERT INTO `admin_details` (`id`, `username`, `password`) VALUES
(0, 'adnan', 'adnan');

-- --------------------------------------------------------

--
-- Table structure for table `cashier_details`
--

CREATE TABLE `cashier_details` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `address` text NOT NULL,
  `contectno` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cashier_details`
--

INSERT INTO `cashier_details` (`id`, `username`, `password`, `address`, `contectno`, `email`, `status`) VALUES
(1, 'cashier', 'cashier123', 'rajkot,gujarat,india', '9898989898', 'cashier123@abc.com', 1),
(2, 'cashier2', 'cashier123', 'rajkot', '7878787878', 'cashier123@gmail.com', 1);

-- --------------------------------------------------------

--
-- Table structure for table `course_details`
--

CREATE TABLE `course_details` (
  `course_id` int(11) NOT NULL,
  `course_name` varchar(40) NOT NULL,
  `course_fees` float NOT NULL,
  `course_description` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course_details`
--

INSERT INTO `course_details` (`course_id`, `course_name`, `course_fees`, `course_description`) VALUES
(1, 'spoken english basic', 10000, 'spoken english lauguage'),
(2, 'python 2', 10000, 'python'),
(3, 'spoken english', 10000, 'spoken english l'),
(4, 'spoken france 2', 10000, 'spoken france'),
(5, 'spoken arbic', 10000, 'spoken arbic');

-- --------------------------------------------------------

--
-- Table structure for table `student_details`
--

CREATE TABLE `student_details` (
  `grno` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `image` blob NOT NULL,
  `gender` varchar(10) NOT NULL,
  `dateofbirth` date NOT NULL,
  `address` text NOT NULL,
  `city` varchar(50) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `coursename` varchar(50) NOT NULL,
  `course_id` int(11) NOT NULL,
  `admissiondate` date NOT NULL,
  `status` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_details`
--

INSERT INTO `student_details` (`grno`, `name`, `image`, `gender`, `dateofbirth`, `address`, `city`, `contact`, `coursename`, `course_id`, `admissiondate`, `status`) VALUES
(1, 'adnan', 0x6e756c6c, 'Male', '2019-09-04', 'rajkot', 'rajkot', '9876544321', 'spoken english basic', 5, '2019-09-24', 'notactive'),
(2, 'prince', 0x6e756c6c, 'Male', '2019-09-10', 'rajkot', 'rajkot', '1234567890', 'python 2', 5, '2019-09-24', 'cancel'),
(3, 'moj', 0x6e756c6c, 'Male', '2019-09-04', 'rajkot', 'rajkot', '9876544322', 'python 2', 5, '2019-09-24', 'active');

-- --------------------------------------------------------

--
-- Table structure for table `student_fees`
--

CREATE TABLE `student_fees` (
  `receipt_no` int(11) DEFAULT NULL,
  `gr_no` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `selected_course` varchar(50) NOT NULL,
  `modeofpayment` varchar(50) DEFAULT NULL,
  `received_from` varchar(50) DEFAULT NULL,
  `mobileno` varchar(50) DEFAULT NULL,
  `bankname` varchar(50) DEFAULT NULL,
  `chequeno` varchar(50) DEFAULT NULL,
  `payment_company` varchar(50) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  `takenfees` float DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_fees`
--

INSERT INTO `student_fees` (`receipt_no`, `gr_no`, `name`, `selected_course`, `modeofpayment`, `received_from`, `mobileno`, `bankname`, `chequeno`, `payment_company`, `date`, `takenfees`, `remark`) VALUES
(2, 1, 'adnan', 'spoken english basic', 'cash', '', '', 'STATE BANK OF INDIA', '', 'Paytm', 'Tue Sep 24 00:00:00 IST 2019', 5000, ''),
(2, 2, 'prince', 'python 2', 'cash', '', '', 'STATE BANK OF INDIA', '', 'Paytm', 'Tue Sep 24 00:00:00 IST 2019', 5000, ''),
(2, 3, 'moj', 'python 2', 'cash', '', '', 'STATE BANK OF INDIA', '', 'Paytm', 'Tue Sep 24 00:00:00 IST 2019', 10000, '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_details`
--
ALTER TABLE `admin_details`
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `cashier_details`
--
ALTER TABLE `cashier_details`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `course_details`
--
ALTER TABLE `course_details`
  ADD PRIMARY KEY (`course_id`),
  ADD UNIQUE KEY `course_id` (`course_id`),
  ADD UNIQUE KEY `course_name` (`course_name`);

--
-- Indexes for table `student_details`
--
ALTER TABLE `student_details`
  ADD PRIMARY KEY (`grno`),
  ADD KEY `course_id` (`course_id`);

--
-- Indexes for table `student_fees`
--
ALTER TABLE `student_fees`
  ADD UNIQUE KEY `gr_no` (`gr_no`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `student_details`
--
ALTER TABLE `student_details`
  ADD CONSTRAINT `student_details_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course_details` (`course_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
