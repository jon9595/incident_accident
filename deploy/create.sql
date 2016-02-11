CREATE TABLE IF NOT EXISTS `demographics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `name` varchar(64) NOT NULL,
  `gender` char(1) NOT NULL,
  `birth_date` date NOT NULL,
  `email` varchar(128) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  `address` varchar(512) DEFAULT NULL,
  `res_life_student` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1  COMMENT 'Details describing the person involved in the incident or accident.';


CREATE TABLE IF NOT EXISTS `account_description` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `acct_desc` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 COMMENT 'Details describing the account of the incident or accident from the member, responder, etc.';

CREATE TABLE IF NOT EXISTS `proper_notifications` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mupd_officer_name` varchar(128) DEFAULT  NULL,
  `mupd_officer_called` time DEFAULT  NULL,
  `mupd_officer_arrived` time DEFAULT  NULL,
  `mupd_officer_case_nbr` varchar(32) DEFAULT  NULL,
  `ems_contacted` char(1) NOT NULL DEFAULT 'N',
  `ems_entrance` varchar(32) DEFAULT NULL,
  `ems_called` time DEFAULT NULL,
  `ems_arrived` time DEFAULT NULL,
  `prof_staff_contacted` char(1) NOT NULL DEFAULT 'N',
  `prof_staff_name` varchar(128) DEFAULT NULL,
  `prof_staff_called` time DEFAULT NULL,
  `prof_staff_arrived` time DEFAULT NULL,
  `rpt_reviewed_by` varchar(64) DEFAULT  NULL,
  `rpt_reviewer_date` date DEFAULT  NULL,
  `res_life_cont_email_sent` char(1) DEFAULT 'N',
  `res_life_cont_date_sent` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `membership_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student` char(1) NOT NULL DEFAULT 'N',
  `student_id` varchar(32) DEFAULT NULL,
  `faculty_staff` char(1) NOT NULL DEFAULT 'N',
  `alumni` char(1) NOT NULL DEFAULT 'N',
  `guest` char(1) NOT NULL DEFAULT 'N',
  `tiger_xpress` char(1) NOT NULL DEFAULT 'N',
  `stop_out_student` char(1) NOT NULL DEFAULT 'N',
  `house_hold_adult` char(1) NOT NULL DEFAULT 'N',
  `other` char(1) NOT NULL DEFAULT 'N',
  `other_explain` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `program_activity_involved` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `informal_activity` char(1) NOT NULL DEFAULT 'N',
  `inf_act_desc` varchar(64) DEFAULT NULL,
  `club_rec_sports` char(1) NOT NULL DEFAULT 'N',
  `club_rec_team_name` varchar(64) DEFAULT NULL,
  `rec_sports` char(1) NOT NULL DEFAULT 'N',
  `rec_team_name` varchar(64) DEFAULT NULL,
  `swim_team_practice` char(1) NOT NULL DEFAULT 'N',
  `swim_team_name` varchar(64) DEFAULT NULL,
  `inter_athletics` char(1) NOT NULL DEFAULT 'N',
  `tigerx_pt` char(1) NOT NULL DEFAULT 'N',
  `tigerx_prg_name` varchar(64) DEFAULT NULL,
  `tigerx_pt_instructor` varchar(64) DEFAULT NULL,
  `spec_evt` char(1) NOT NULL DEFAULT 'N',
  `spec_evt_group` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;


CREATE TABLE IF NOT EXISTS `locations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `location` varchar(128) NOT NULL,
  `sub_location` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1  COMMENT 'The list of locations that the incident or accident can occurr.';


INSERT INTO `locations` (`location`, `sub_location`) VALUES
('Mizzou Aquatic Center', 'Competition Pool'),
('Mizzou Aquatic Center', 'Dive Well'),
('Mizzou Aquatic Center', 'Dive Well Hot Tub'),
('Mizzou Aquatic Center', 'Sauna'),
('Mizzou Aquatic Center', 'Steam Room'),
('Mizzou Aquatic Center', 'Tiger Grotto'),
('Mizzou Aquatic Center', 'Tiger Grotto Hot Tub'),
('Mizzou Aquatic Center', 'Truman''s Pond'),
('Student Recreation Complex', 'Brewer Court # 7'),
('Student Recreation Complex', 'Brewer Court # 8'),
('Student Recreation Complex', 'Brewer Court # 9'),
('Student Recreation Complex', 'Brewer Court # 10'),
('Student Recreation Complex', 'Climbing Wall'),
('Student Recreation Complex', 'General Lockers'),
('Student Recreation Complex', 'Indoor Track'),
('Student Recreation Complex', 'Jungle Gym'),
('Student Recreation Complex', 'Pump Room'),
('Student Recreation Complex', 'Jungle Annex'),
('Student Recreation Complex', 'Racquet Sports Court # 1'),
('Student Recreation Complex', 'Racquet Sports Court # 2'),
('Student Recreation Complex', 'Racquet Sports Court # 3'),
('Student Recreation Complex', 'Racquet Sports Court # 4'),
('Student Recreation Complex', 'Racquet Sports Court - Squash'),
('Student Recreation Complex', 'Rothwell Club'),
('Student Recreation Complex', 'SE Lobby-East Desk'),
('Student Recreation Complex', 'SRC Court # 1'),
('Student Recreation Complex', 'SRC Court # 2'),
('Student Recreation Complex', 'SRC Court # 3'),
('Student Recreation Complex', 'SRC Court # 4'),
('Student Recreation Complex', 'SRC Court # 5'),
('Student Recreation Complex', 'SRC Court # 6'),
('Student Recreation Complex', 'Stalcups Garage'),
('Student Recreation Complex', 'TigerX Studio: A'),
('Student Recreation Complex', 'TigerX Studio: B'),
('Student Recreation Complex', 'TigerX Studio: C'),
('Student Recreation Complex', 'Tiger Lair'),
('Student Recreation Complex', 'zouLIFE'),
('Student Recreation Complex', 'Clarks Boxing Gym'),
('Outdoor Facilities', 'Epple Tennis Park'),
('Outdoor Facilities', 'Hinkson Creek #1'),
('Outdoor Facilities', 'Hinkson Creek #2'),
('Outdoor Facilities', 'Hinkson Creek #3'),
('Outdoor Facilities', 'Hinkson Creek #4'),
('Outdoor Facilities', 'Stankowski #1'),
('Outdoor Facilities', 'Stankowski #2'),
('Outdoor Facilities', 'Stankowski #3');


CREATE TABLE IF NOT EXISTS `accident_location` (
  `accident_id` int(11) NOT NULL,
  `location_id` int(11) NOT NULL,
  PRIMARY KEY (`accident_id`,`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1  COMMENT 'Details describing the location that the accident occurred.';

CREATE TABLE IF NOT EXISTS `incident_location` (
  `incident_id` int(11) NOT NULL,
  `location_id` int(11) NOT NULL,
  PRIMARY KEY (`incident_id`,`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1  COMMENT 'Details describing the location that the incident occurred.';

CREATE TABLE IF NOT EXISTS `witness_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `phone` varchar(12) NOT NULL,
  `signature` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 COMMENT 'Details describing the witness.';

CREATE TABLE IF NOT EXISTS `signatures` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` longblob NOT NULL,
  `json_data` longtext NOT NULL,
  `created` datetime DEFAULT NULL,
  PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 COMMENT 'Signature Images and JSON polyline objects';

DROP TRIGGER IF EXISTS `SIGNATURES_CREATE_TIMESTAMP`;
DELIMITER //
CREATE TRIGGER `SIGNATURES_CREATE_TIMESTAMP` BEFORE INSERT ON `signatures`
 FOR EACH ROW SET NEW.CREATED = NOW()
//
DELIMITER ;

CREATE TABLE IF NOT EXISTS `refusal_of_care` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_sig` int(11) DEFAULT NULL,
  `staff_sig` int(11) DEFAULT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 COMMENT 'Member signature stating that they refuse care';


CREATE TABLE IF NOT EXISTS `accident_detail_description` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 COMMENT 'The list of issues an accident can have..';

INSERT INTO `accident_detail_description` (`description`) VALUES
('Aquatic Assist or Rescue'),
('Suspected Bone/ Joint Injury'),
('Bruise'),
('Laceration'),
('Breathing Emergency'),
('Cardiac Emergency');

CREATE TABLE IF NOT EXISTS `accident_details` (
  `accident_id` int(11) NOT NULL,
  `acc_det_desc_id` int(11) NOT NULL,
  PRIMARY KEY (`accident_id`,`acc_det_desc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT 'Details describing what detail the accident was.';

CREATE TABLE IF NOT EXISTS `injury_locations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `location` varchar(128) NOT NULL,
  `sub_location` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 COMMENT 'The list of possible locations an injury can occur..';

--
-- Dumping data for table `injury_locations`
--

INSERT INTO `injury_locations` (`location`, `sub_location`) VALUES
('Upper Arm', 'L'),
('Upper Arm', 'R'),
('Elbow', 'L'),
('Elbow', 'R'),
('Forearm', 'L'),
('Forearm', 'R'),
('Wrist', 'L'),
('Wrist', 'R'),
('Hand', 'L'),
('Hand', 'R'),
('Finger', 'L'),
('Finger', 'R'),
('Thigh', 'L'),
('Thigh', 'R'),
('Knee', 'L'),
('Knee', 'R'),
('Shin', 'L'),
('Shin', 'R'),
('Calf', 'L'),
('Calf', 'R'),
('Ankle', 'L'),
('Ankle', 'R'),
('Foot', 'L'),
('Foot', 'R'),
('Eye', 'L'),
('Eye', 'R'),
('Other', NULL),
('Nose', NULL),
('Jaw', NULL),
('Head', NULL),
('Neck', NULL),
('Chest', NULL),
('Groin', NULL),
('Back', NULL),
('Stomach', NULL);

CREATE TABLE IF NOT EXISTS `accident_injury_location` (
  `accident_id` int(11) NOT NULL,
  `injury_locations_id` int(11) NOT NULL,
  PRIMARY KEY (`accident_id`,`injury_locations_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Details describing the injury location for an accident.';

CREATE TABLE IF NOT EXISTS `specific_injury` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1  COMMENT 'Detailed description of a specific injury';

CREATE TABLE IF NOT EXISTS `specific_location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `spec_equip_piece` char(1) NOT NULL DEFAULT 'N' COMMENT 'Specific Equipment Piece',
  `spec_equip_piece_desc` varchar(64) DEFAULT NULL COMMENT 'Specific Equipment Piece Description',
  `other` char(1) NOT NULL DEFAULT 'N' COMMENT 'Other location',
  `other_desc` varchar(64) DEFAULT NULL COMMENT 'Other location description',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Location describing a specific equipment piece or other location not listed.' AUTO_INCREMENT=1 ;


CREATE TABLE IF NOT EXISTS `incident_nature` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COMMENT='Nature of Incident Options' AUTO_INCREMENT=1 ;


INSERT INTO `incident_nature` (`description`) VALUES
('Argument'),
('Damaged/Lost Equipment'),
('Facility Emergency'),
('Physical Altercation'),
('ID Violation'),
('Maintenance Emergency'),
('Policy Abuse'),
('Theft'),
('Threatening Behavior'),
('Sexual Misconduct'),
('Trespassing'),
('Verbal Altercation'),
('Vandalism'),
('Other');

CREATE TABLE IF NOT EXISTS `incident_incident_nature` (
  `incident_id` int(11) NOT NULL,
  `incident_nature_id` int(11) NOT NULL,
  PRIMARY KEY (`incident_id`,`incident_nature_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Describes the nature of the incident to the incident.';


CREATE TABLE IF NOT EXISTS `accident` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `demographics` int(11) NOT NULL COMMENT 'demographic information of the person involved',
  `membership_status` int(11) NOT NULL COMMENT 'membership status',
  `program_activity` int(11) NOT NULL COMMENT 'program or activity involved',
  `responder_acct` int(11) DEFAULT NULL COMMENT 'responder account of accident',
  `member_acct`  int(11) DEFAULT NULL COMMENT 'member account of accident',
  `refusal_of_care` int(11) DEFAULT NULL COMMENT 'refusal of care information',
  `witness_one` int(11) DEFAULT NULL  COMMENT 'first witness information',
  `witness_two` int(11) DEFAULT NULL COMMENT 'second witness information',
  `proper_notifications` int(11) NOT NULL COMMENT 'proper notifications information',
  `other_inj_desc` varchar(128) DEFAULT NULL COMMENT 'other injury description',
  `spec_inj_location` int(11) DEFAULT NULL COMMENT 'specific injury location',
  `specific_location` int(11) DEFAULT NULL COMMENT 'specific equipment piece or other location',
  `created` datetime DEFAULT NULL,
  `created_by` varchar(64) DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `modified_by` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 COMMENT 'Accident record.';

--
-- Triggers `accident`
--
DROP TRIGGER IF EXISTS `ACCIDENT_CREATE_TIMESTAMP`;
DELIMITER //
CREATE TRIGGER `ACCIDENT_CREATE_TIMESTAMP` BEFORE INSERT ON `accident`
 FOR EACH ROW SET NEW.CREATED = NOW()
//
DELIMITER ;
DROP TRIGGER IF EXISTS `ACCIDENT_UPDATE_TIMESTAMP`;
DELIMITER //
CREATE TRIGGER `ACCIDENT_UPDATE_TIMESTAMP` BEFORE UPDATE ON `accident`
 FOR EACH ROW SET NEW.MODIFIED = NOW()
//
DELIMITER ;


CREATE TABLE IF NOT EXISTS `incident` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `demographics` int(11) NOT NULL COMMENT 'demographic information of the person involved',
  `membership_status` int(11) NOT NULL COMMENT 'membership status',
  `program_activity` int(11) NOT NULL COMMENT 'program or activity involved',
  `responder_acct` int(11) DEFAULT NULL COMMENT 'responder account of incident',
  `member_acct`  int(11) DEFAULT NULL COMMENT 'member account of incident',
  `witness_acct` int(11) DEFAULT NULL COMMENT 'witness account of incident',
  `witness_info` int(11) DEFAULT NULL  COMMENT 'witness information',
  `proper_notifications` int(11) NOT NULL COMMENT 'proper notifications information',
  `specific_location` int(11) DEFAULT NULL COMMENT 'specific equipment piece or other location',
  `other_inc_nature_desc` varchar(128) DEFAULT NULL COMMENT 'Nature of Incident not specified by the other options.',
  `created` datetime DEFAULT NULL,
  `created_by` varchar(64) DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `modified_by` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 COMMENT 'Incident record.';

--
-- Triggers `incident`
--
DROP TRIGGER IF EXISTS `INCIDENT_CREATE_TIMESTAMP`;
DELIMITER //
CREATE TRIGGER `INCIDENT_CREATE_TIMESTAMP` BEFORE INSERT ON `incident`
 FOR EACH ROW SET NEW.CREATED = NOW()
//
DELIMITER ;
DROP TRIGGER IF EXISTS `INCIDENT_UPDATE_TIMESTAMP`;
DELIMITER //
CREATE TRIGGER `INCIDENT_UPDATE_TIMESTAMP` BEFORE UPDATE ON `incident`
 FOR EACH ROW SET NEW.MODIFIED = NOW()
//
DELIMITER ;

CREATE TABLE IF NOT EXISTS `users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `username` VARCHAR(50) NOT NULL COMMENT '',
  `password` VARCHAR(255) NOT NULL COMMENT '',
  `first_name` VARCHAR(50) NOT NULL COMMENT '',
  `last_name` VARCHAR(50) NOT NULL COMMENT '',
  `email` VARCHAR(100) NOT NULL COMMENT '',
  `activated` CHAR(1) NOT NULL DEFAULT 'N' COMMENT '',
  `new_password_key` VARCHAR(128) NULL DEFAULT NULL COMMENT '',
  `new_password_requested` DATETIME NULL DEFAULT NULL COMMENT '',
  `position` VARCHAR( 64 ) NOT NULL COMMENT 'User Position',
  `last_login` DATETIME DEFAULT NULL COMMENT '',
  `created` DATETIME DEFAULT NULL,
  `modified` DATETIME DEFAULT NULL,
  `created_by` varchar(64) DEFAULT NULL,
  `modified_by` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)  COMMENT 'User Table')
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

DROP TRIGGER IF EXISTS `USERS_CREATE_TIMESTAMP`;
DELIMITER //
CREATE TRIGGER `USERS_CREATE_TIMESTAMP` BEFORE INSERT ON `users`
 FOR EACH ROW SET NEW.CREATED = NOW()
//
DELIMITER ;
DROP TRIGGER IF EXISTS `USERS_UPDATE_TIMESTAMP`;
DELIMITER //
CREATE TRIGGER `USERS_UPDATE_TIMESTAMP` BEFORE UPDATE ON `users`
 FOR EACH ROW SET NEW.modified = NOW()
//
DELIMITER ;


CREATE TABLE IF NOT EXISTS `user_types` (
  `user_type_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `title` VARCHAR(255) NOT NULL COMMENT '',
  PRIMARY KEY (`user_type_id`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

INSERT INTO `user_types` (`title`) VALUES
('superadmin'),
('admin'),
('trainer'),
('instructor'),
('staff'),
('manager');


CREATE TABLE IF NOT EXISTS `user_roles` (
  `username` VARCHAR(50) NOT NULL COMMENT 'username',
  `role` VARCHAR(255) NOT NULL COMMENT 'role from user_types',
  PRIMARY KEY (`username`, `role`)  COMMENT '')
ENGINE = InnoDB
COMMENT 'Maps user to user roles.  Used for security realm';

INSERT INTO `users` (`username`, `password`, `first_name`, `last_name`, `email`, `activated`, `new_password_key`, `new_password_requested`, `last_login`, `created_by`) VALUES
('dirksm', 'cb93b5814e714ee979a006fc2d83987392fef1cbce01a714663e4c009a811925', 'Michael', 'Dirks', 'dirksm@gmail.com', 'Y', NULL, NULL, NULL, 'dirksm');
INSERT INTO `users` (`username`, `password`, `first_name`, `last_name`, `email`, `activated`, `new_password_key`, `new_password_requested`, `last_login`, `created_by`) VALUES
('testuser', '6ca13d52ca70c883e0f0bb101e425a89e8624de51db2d2392593af6a84118090', 'Test', 'User', 'test@email.net', 'Y', NULL, NULL, NULL, 'dirksm');

INSERT INTO `user_roles` (`username`, `role`) VALUES
('dirksm', 'admin');


