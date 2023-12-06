-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 06, 2023 at 06:30 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pickandgo`
--

-- --------------------------------------------------------

--
-- Table structure for table `applications`
--

CREATE TABLE `applications` (
  `application_id` bigint(20) NOT NULL,
  `package_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `applications`
--

INSERT INTO `applications` (`application_id`, `package_id`, `user_id`) VALUES
(4, 2, 3),
(6, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `contact_info`
--

CREATE TABLE `contact_info` (
  `name` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `package`
--

CREATE TABLE `package` (
  `package_id` bigint(20) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `package`
--

INSERT INTO `package` (`package_id`, `city`, `description`, `name`, `user_id`) VALUES
(2, 'New York, NY, USA', 'vdvf', 'New York', 2),
(3, 'Miami, FL, USA', 'Had fun swimming with Gators and sharks.', 'Florida Tour', 2),
(4, 'Los Angeles, CA, USA', 'Drank beer with Keanu Reeves!\r\n', 'LA beer fest', 2);

-- --------------------------------------------------------

--
-- Table structure for table `tourpackage`
--

CREATE TABLE `tourpackage` (
  `package_id` bigint(20) NOT NULL,
  `capacity` int(11) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `service` text DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tourpackage`
--

INSERT INTO `tourpackage` (`package_id`, `capacity`, `city`, `contact`, `description`, `name`, `service`, `user_id`) VALUES
(2, 10, 'Paris, France', 'Example@gmail.com', 'Best Tour in France', 'Tour of Paris', 'Morning: Eiffel Tower\n\nStart your day early by visiting the Eiffel Tower. Enjoy the panoramic views of Paris from the top. It\'s best to book tickets in advance to avoid long lines.\nLate Morning: Seine River Cruise\n\nAfter exploring the Eiffel Tower, take a relaxing cruise on the Seine River. This offers a unique perspective of the city and views of several landmarks along the riverbanks.\nAfternoon: Lunch in the Latin Quarter\n\nHead to the Latin Quarter for lunch. This area is known for its charming cafes and bistros. You can also explore the narrow streets and find unique shops.\nEarly Afternoon: Notre-Dame Cathedral and Île de la Cité\n\nVisit the iconic Notre-Dame Cathedral. Although it suffered a significant fire in 2019, its restoration is underway, and the exterior is still a magnificent sight. Stroll around the Île de la Cité, the island in the Seine where Paris was founded.\nLate Afternoon: Louvre Museum\n\nSpend the late afternoon at the Louvre Museum. Home to thousands of works of art, including the Mona Lisa and the Venus de Milo, it\'s one of the world\'s largest and most famous museums.\nEvening: Montmartre and Sacré-Cœur\n\nIn the evening, explore the bohemian district of Montmartre. Walk up to the Sacré-Cœur Basilica, enjoy the stunning view of Paris at sunset, and perhaps catch a glimpse of street artists at work.\nDinner: Champs-Élysées\n\nEnd your day with dinner at one of the restaurants along the Champs-Élysées, one of the most famous avenues in the world, known for its theatres, cafés, and luxury shops.\nNight: Optional Cabaret Show\n\nIf you\'re still up for more, consider attending a cabaret show at a famous venue like the Moulin Rouge.\nThis tour offers a blend of historical, cultural, and architectural experiences, providing a comprehensive overview of the diverse allure of Paris. Remember, each site might require a significant amount of time to fully appreciate, so it\'s important to manage your time efficiently and perhaps make reservations where necessary.', 1),
(3, 15, 'Bali, Indonesia', 'bobbuilds@gmail.com', 'Enjoy a nice time in Bali!', 'Tour of Bali', 'Morning: Visit to Tegallalang Rice Terraces\r\n\r\nStart your day with a visit to the Tegallalang Rice Terraces near Ubud. These terraces offer some of the most stunning landscapes in Bali, showcasing the traditional Balinese irrigation system known as subak. It\'s a great spot for photography and enjoying the fresh morning air.\r\nMid-Morning: Sacred Monkey Forest Sanctuary\r\n\r\nNext, head to the Sacred Monkey Forest Sanctuary in Ubud. It\'s a nature reserve and Hindu temple complex where you can see hundreds of long-tailed macaques in their natural habitat and explore ancient temple ruins.\r\nLunch: Traditional Balinese Cuisine in Ubud\r\n\r\nEnjoy a lunch of traditional Balinese cuisine at one of Ubud\'s many restaurants. You can try dishes like Babi Guling (suckling pig) or Bebek Betutu (slow-cooked duck).\r\nEarly Afternoon: Tirta Empul Temple\r\n\r\nVisit the Tirta Empul Temple, a Hindu Balinese water temple famous for its holy spring water. People come here for ritual purification, and it\'s a unique cultural experience to witness.\r\nMid-Afternoon: Coffee Plantation Visit\r\n\r\nStop by a local coffee plantation to learn about traditional Balinese coffee production, including the famous Luwak coffee. You can enjoy tastings and see how the coffee is made.\r\nLate Afternoon: Tanah Lot Temple\r\n\r\nIn the late afternoon, head to the iconic Tanah Lot Temple, one of Bali\'s most important landmarks, famed for its unique offshore setting and sunset backdrops. It\'s an ancient Hindu shrine perched on top of an outcrop amidst constantly crashing waves.\r\nDinner: Seafood Dinner at Jimbaran Bay\r\n\r\nFor dinner, go to Jimbaran Bay, known for its beautiful beach and seafood restaurants. Enjoy a fresh seafood dinner on the beach while watching the sunset.\r\nEvening: Relaxation or Optional Cultural Show\r\n\r\nAfter dinner, you might relax at your hotel or attend a traditional Balinese dance performance, like the Kecak dance, if available in the area', 1),
(6, 10, 'Los Angeles, CA, USA', 'bobbuilds@gmail.com', 'Have the best of your life!', 'Tour of Los Angeles', 'Early Afternoon: Getty Center\r\n\r\nSpend the early afternoon at the Getty Center, where you can enjoy impressive art collections, stunning architecture, and beautiful gardens. The views of Los Angeles from here are also spectacular.\r\nLate Afternoon: Santa Monica Pier and Beach\r\n\r\nIn the late afternoon, head to Santa Monica. Walk along the famous Santa Monica Pier, enjoy the beach, and if time allows, take a ride on the Ferris wheel for an incredible ocean view.\r\nDinner: Venice Beach\r\n\r\nFor dinner, go to Venice Beach. This eclectic beachfront neighborhood is famous for its bohemian spirit, street performers, and Muscle Beach outdoor gym. There are many great restaurants nearby offering fresh and local cuisine.\r\nEvening: Sunset at El Matador State Beach\r\n\r\nIf you\'re up for a bit of a drive, end your day with a sunset at El Matador State Beach in Malibu. It\'s one of the most beautiful beaches in L.A., known for its sea caves and rock formations.\r\nNight: Hollywood Nightlife or Concert\r\n\r\nTo experience L.A.\'s vibrant nightlife, consider exploring the bars and clubs in Hollywood. Alternatively, check if there are any concerts or shows happening in one of L.A.\'s famous venues like the Hollywood Bowl or The Greek Theatre.', 1),
(7, 10, 'Miami, FL, USA', 'Example@gmail.com', 'Best tour', 'SOmething', 'SOmething better', 6),
(9, 3, 'McLeansville, NC, USA', 'Example@gmail.com', 'd', 'Place', 'ds', 6);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `tag` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `email`, `password`, `tag`, `username`) VALUES
(1, 'here@gmail.com', '$2a$10$z.Su0PhOkLwnWugCO2SAxujjIgHazE9ZTivaqGA9ohijUJb4w.4sW', 'TOURGUIDE', 'Bobby'),
(2, 'marcus@gmail.com', '$2a$10$YbMgCtLhqbGgSHr3eWdJ6uT613mVB7PHYqiHs6eljlMraf79uTTCq', 'USER', 'Marcus'),
(3, 'use@gmail.com', '$2a$10$aBsR03HFVVXhARtxb5c4Buw6gT816m00OKydYkfBUJAYrCTqChesm', 'USER', 'Phil'),
(4, 'try@gmail.com', '$2a$10$KsFp0Ki5gC4x52hMJVNur.YU8OwqeKjNj36WZu55jGd6c3YWbHQAa', 'TOURGUIDE', 'Greg'),
(5, 'admin@gmail.com', '$2a$10$D462VNMTxYaxouVEFply4url0O7FacLv1.X/IJ0Bap1at6vv26Is.', 'ADMIN', 'Admin'),
(6, 'jim@gmail.com', '$2a$10$epwNuLDSzDc5MyjHymZQGesIXtpmgS5hq84asW0nQcng0oF/5ipLq', 'TOURGUIDE', 'jim');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `applications`
--
ALTER TABLE `applications`
  ADD PRIMARY KEY (`application_id`),
  ADD KEY `FK8hynh8jattvs2v48l6qm62wgj` (`package_id`),
  ADD KEY `FKscheukp0vov0q7r1ayi0w4k61` (`user_id`);

--
-- Indexes for table `contact_info`
--
ALTER TABLE `contact_info`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `package`
--
ALTER TABLE `package`
  ADD PRIMARY KEY (`package_id`),
  ADD KEY `FKccrkbpdejkopmpkfi582awamv` (`user_id`);

--
-- Indexes for table `tourpackage`
--
ALTER TABLE `tourpackage`
  ADD PRIMARY KEY (`package_id`),
  ADD KEY `FK5uq38i79jcf6o4ka1qi1yt4g` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `applications`
--
ALTER TABLE `applications`
  MODIFY `application_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `package`
--
ALTER TABLE `package`
  MODIFY `package_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tourpackage`
--
ALTER TABLE `tourpackage`
  MODIFY `package_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `applications`
--
ALTER TABLE `applications`
  ADD CONSTRAINT `FK8hynh8jattvs2v48l6qm62wgj` FOREIGN KEY (`package_id`) REFERENCES `tourpackage` (`package_id`),
  ADD CONSTRAINT `FKscheukp0vov0q7r1ayi0w4k61` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `package`
--
ALTER TABLE `package`
  ADD CONSTRAINT `FKccrkbpdejkopmpkfi582awamv` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `tourpackage`
--
ALTER TABLE `tourpackage`
  ADD CONSTRAINT `FK5uq38i79jcf6o4ka1qi1yt4g` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
