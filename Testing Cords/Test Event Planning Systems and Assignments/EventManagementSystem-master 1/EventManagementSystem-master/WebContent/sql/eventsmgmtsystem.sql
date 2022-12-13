-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 22, 2016 at 09:24 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `eventsmgmtsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE IF NOT EXISTS `event` (
  `eventid` int(11) NOT NULL AUTO_INCREMENT,
  `eventname` varchar(80) NOT NULL,
  `eventtype` varchar(15) NOT NULL COMMENT 'customised / pre-set',
  `category` varchar(15) NOT NULL COMMENT 'corporate, social, private',
  `startdatetime` timestamp NULL DEFAULT NULL,
  `enddatetime` timestamp NULL DEFAULT NULL,
  `location` varchar(100) NOT NULL,
  `estimateguests` smallint(6) NOT NULL,
  `confirmedguests` smallint(6) DEFAULT '0',
  `cost` decimal(10,2) NOT NULL,
  `description` varchar(200) NOT NULL,
  `clientid` int(11) DEFAULT NULL,
  `clientname` varchar(100) DEFAULT NULL,
  `clientcontactnum` varchar(12) DEFAULT NULL,
  `clientemail` varchar(50) DEFAULT NULL,
  `presetid` int(11) DEFAULT NULL,
  `bookingdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`eventid`),
  KEY `clientid` (`clientid`,`presetid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`eventid`, `eventname`, `eventtype`, `category`, `startdatetime`, `enddatetime`, `location`, `estimateguests`, `confirmedguests`, `cost`, `description`, `clientid`, `clientname`, `clientcontactnum`, `clientemail`, `presetid`, `bookingdate`) VALUES
(1, 'Custom Event 1', 'custom', 'Corporate', '2016-01-28 13:30:00', '2016-01-28 15:45:00', 'Custom Event Hall', 50, 0, '2000.00', 'This is a sample custom event for view purposes.', 8, 'Clientfirst ClientLast', '07985693123', 'client1@email.com', NULL, '2016-01-22 14:22:39'),
(4, 'Custom2', 'custom', 'Social', '2016-02-03 00:00:00', '2016-02-03 00:00:00', 'Building', 30, 0, '1500.00', 'This is a sample event for add custom event.', NULL, 'Samplename Samplelast', '07985693123', 'sample@email.com', NULL, '2016-01-22 18:28:30'),
(5, 'Custom Event3', 'custom', 'Private', '2016-02-02 00:00:00', '2016-02-02 00:00:00', 'Spa Building', 3, 0, '500.00', 'This is a sample event for add custom event 2.', NULL, 'Clientfirst Clientlast', '07985693123', 'client1@email.com', NULL, '2016-01-22 18:36:11');

-- --------------------------------------------------------

--
-- Table structure for table `eventdetail`
--

CREATE TABLE IF NOT EXISTS `eventdetail` (
  `itemid` int(11) NOT NULL AUTO_INCREMENT,
  `itemname` varchar(80) NOT NULL,
  `itemtype` varchar(50) NOT NULL,
  `itemdescription` varchar(200) NOT NULL,
  `staffassigned` int(11) NOT NULL,
  `eventid` int(11) NOT NULL,
  `ispreset` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`itemid`),
  KEY `staffassigned` (`staffassigned`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `eventdetail`
--

INSERT INTO `eventdetail` (`itemid`, `itemname`, `itemtype`, `itemdescription`, `staffassigned`, `eventid`, `ispreset`) VALUES
(1, 'Speakers', 'AV', 'For le sounds', 10, 4, 1),
(2, 'Tables and Chairs', 'Furniture', ' To sit down, sit down. ', 3, 4, 1);

-- --------------------------------------------------------

--
-- Table structure for table `guest`
--

CREATE TABLE IF NOT EXISTS `guest` (
  `guestname` varchar(60) NOT NULL,
  `guestemail` varchar(50) NOT NULL,
  `extra` smallint(6) DEFAULT NULL,
  `eventid` int(11) NOT NULL,
  `clientid` int(11) NOT NULL,
  KEY `eventid` (`eventid`,`clientid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `presetevent`
--

CREATE TABLE IF NOT EXISTS `presetevent` (
  `presetid` int(11) NOT NULL AUTO_INCREMENT,
  `eventname` varchar(80) NOT NULL,
  `category` varchar(15) NOT NULL COMMENT 'corporate, social or private',
  `location` varchar(100) NOT NULL,
  `estimateguests` smallint(6) NOT NULL,
  `cost` decimal(10,2) NOT NULL,
  `description` varchar(200) NOT NULL,
  PRIMARY KEY (`presetid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `presetevent`
--

INSERT INTO `presetevent` (`presetid`, `eventname`, `category`, `location`, `estimateguests`, `cost`, `description`) VALUES
(1, 'Wedding', 'Private', 'City Hall', 200, '5000.00', 'This is a wedding pre-set event'),
(2, 'Product Launch', 'Corporate', 'Blah Blah Hall', 150, '3000.00', 'Corporate Product Launch'),
(3, 'Preset Event 1', 'Social', 'Private Hall', 12, '1000.00', 'This is a sample preset event for add preset.'),
(4, 'Preset Event Number 2', 'Social', 'Preset Building', 300, '2999.59', 'Sample preset event for insert test.');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(70) NOT NULL,
  `emailaddress` varchar(50) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `userrole` varchar(10) NOT NULL,
  `dateadded` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `contactnum` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userid`, `username`, `password`, `emailaddress`, `firstname`, `lastname`, `userrole`, `dateadded`, `contactnum`) VALUES
(3, 'username1', '$2a$10$EbI2AOZ5pIhhejv1b9FVP.ErZ4kZsTfeLApTN4wAIXalyvnDCa8yW', 'email@email.com', 'Firstname', 'Lastname', 'Employee', '2016-01-18 18:26:03', NULL),
(8, 'client1', '$2a$10$DyJEBTqPwVu5TGWRL5utd.fWmbflGBe61EEsjZogxZjkow5tObpvC', 'client1@email.com', 'Clientfirst', 'Clientlast', 'Client', '2016-01-18 20:48:48', '07985693123'),
(9, 'client2', '$2a$10$11BaMsBYIG6smBjJJ8OvDOm4goWPIRS9e9zgCpujPlz3jktfoEfm.', 'client2@email.com', 'ClientFirst2', 'ClientLast2', 'Client', '2016-01-18 20:49:31', '07876653432'),
(10, 'staff1', '$2a$10$hTsyEj5H3T/CfpII38t10O9V7CMkVR.jLOpYTiasMR08dooZ1fw9S', 'staff1@email.com', 'StaffFirst', 'StaffLast', 'Employee', '2016-01-19 14:14:49', NULL),
(11, 'AdminUsername', '$2a$10$jBXwXyzucFdvYuCq5GXsBOvAgK6X8JsLv6/jFyRnTY09rbvn0kkQy', 'admin@email.com', 'FirstAdmin', 'LastAdmin', 'Admin', '2016-01-19 18:03:27', NULL);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `event_ibfk_1` FOREIGN KEY (`clientid`) REFERENCES `user` (`userid`);

--
-- Constraints for table `eventdetail`
--
ALTER TABLE `eventdetail`
  ADD CONSTRAINT `eventdetail_ibfk_1` FOREIGN KEY (`staffassigned`) REFERENCES `user` (`userid`);

--
-- Constraints for table `guest`
--
ALTER TABLE `guest`
  ADD CONSTRAINT `guest_ibfk_1` FOREIGN KEY (`eventid`) REFERENCES `event` (`eventid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
