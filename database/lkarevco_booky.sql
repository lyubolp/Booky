-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Sep 28, 2018 at 09:46 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 5.6.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lkarevco_booky`
--

-- --------------------------------------------------------

--
-- Table structure for table `achievement`
--

CREATE TABLE `achievement` (
  `id` int(11) NOT NULL COMMENT 'Used to identify each different achievement',
  `name_bg` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Name of the achievement in Bulgarian',
  `name_en` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Name of the achievement in English',
  `description_bg` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Description of the achievement in Bulgarian',
  `description_en` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Description of the achievement in English',
  `picture` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Link to the picture for that achievement'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `id` int(11) NOT NULL COMMENT 'Used to identify each author',
  `name_original` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Original name of the author',
  `name_bg` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Name of the author in Bulgarian',
  `name_en` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Name of the author in English',
  `born_date` date NOT NULL COMMENT 'Date when the author was born',
  `died_date` date NOT NULL COMMENT 'Date when the author died',
  `country` int(11) NOT NULL COMMENT 'ID of the country where the author was born',
  `genre_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Genre IDs which the author has written separated by |',
  `type_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Type IDs which the author has written separated by |',
  `book_count` tinyint(4) NOT NULL COMMENT 'Number of books the author has written (which are in the database)',
  `series_count` tinyint(4) NOT NULL COMMENT 'Number of series the author has (which are in the databas)',
  `pen_name_original` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Original pen name ',
  `pen_name_bg` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Pen name in Bulgarian',
  `pen_name_en` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Pen name in English'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `author_genre`
--

CREATE TABLE `author_genre` (
  `author_id` int(11) NOT NULL COMMENT 'ID of the author which these genres are for'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='What genres has the author written';

-- --------------------------------------------------------

--
-- Table structure for table `author_type`
--

CREATE TABLE `author_type` (
  `author_id` int(11) NOT NULL COMMENT 'ID of the author which these types are for'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL COMMENT 'Used to identify each different book',
  `genre` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Genre IDs separated by |',
  `chapters` smallint(6) NOT NULL COMMENT 'Number of chapters the book has',
  `series_id` int(11) NOT NULL COMMENT 'ID of the series to which the book belongs to',
  `author_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Author IDs separated by |',
  `publish_year` smallint(6) NOT NULL COMMENT 'Year when the book was published',
  `publish_month` tinyint(4) NOT NULL COMMENT 'Month when the book was published',
  `publish_day` tinyint(4) NOT NULL COMMENT 'Day of the month when the book was published',
  `language_id` int(11) NOT NULL COMMENT 'ID of the language the original book was written in',
  `translated_id` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Language IDs separated by | in which the book is translated',
  `country_id` int(11) NOT NULL COMMENT 'ID of the country where the book was written and published',
  `type_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Type IDs separated by |',
  `rating` int(11) NOT NULL COMMENT 'Accumulated rating from all users who have rated the book',
  `finished_count` int(11) NOT NULL COMMENT 'Number of people who have finished the book',
  `reading_count` int(11) NOT NULL COMMENT 'Number of people who are reading the book',
  `wishlist_count` int(11) NOT NULL COMMENT 'Number of people who have the book in their wishlist',
  `dropped_count` int(11) NOT NULL COMMENT 'Number of people who have dropped the book',
  `onhold_count` int(11) NOT NULL COMMENT 'Number of people who have the book in their onhold list',
  `summary_id` int(11) NOT NULL COMMENT 'Id of the summary of the book',
  `review_count` smallint(6) NOT NULL COMMENT 'Number of reviews the book has',
  `cover` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Link to the book`s cover picture',
  `character_id` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Character IDs separated by |',
  `name_original` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Original name in the original language of the book',
  `name_bg` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Name of the book in Bulgarian',
  `name_en` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Name of the book in English'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `book_character`
--

CREATE TABLE `book_character` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `book_genre`
--

CREATE TABLE `book_genre` (
  `id` int(11) NOT NULL COMMENT 'Used to identify each different genre',
  `name_bg` int(11) NOT NULL COMMENT 'Genre name in Bulgarian',
  `name_en` int(11) NOT NULL COMMENT 'Genre name in English'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `book_review`
--

CREATE TABLE `book_review` (
  `id` int(11) NOT NULL COMMENT 'Used to identify each different review',
  `book_id` int(11) NOT NULL COMMENT 'ID of the book this review is for',
  `user_id` int(11) NOT NULL COMMENT 'ID of the uer who wrote this review',
  `language_id` int(11) NOT NULL COMMENT 'ID of the language the review is written in',
  `text` varchar(4000) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Actual content of the review',
  `rating` int(11) NOT NULL COMMENT 'Accumulated rating from all users who have rated the review'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `book_status`
--

CREATE TABLE `book_status` (
  `id` int(11) NOT NULL COMMENT 'Used to identify each different status (e.g. finished/wishlist/etc.)',
  `name_bg` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'The status name in Bulgarian',
  `name_en` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'The status name in English'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `book_summary`
--

CREATE TABLE `book_summary` (
  `book_id` int(11) NOT NULL COMMENT 'This field is a copy of the book ID from table book. (e.g. Book with ID 2 will have ID 2 here)',
  `text_bg` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'The summary in Bulgarian',
  `text_en` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'The summary in English'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `book_type`
--

CREATE TABLE `book_type` (
  `id` int(11) NOT NULL COMMENT 'Used to identify each different book type',
  `name_bg` int(11) NOT NULL COMMENT 'Name of the type in Bulgarian',
  `name_en` int(11) NOT NULL COMMENT 'Name of the type in English'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE `country` (
  `id` int(11) NOT NULL COMMENT 'Used to identify each different country',
  `name_bg` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Name of the country in Bulgarian',
  `name_en` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'name of the country in English'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `friend`
--

CREATE TABLE `friend` (
  `user1_id` int(11) NOT NULL,
  `user2_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `language`
--

CREATE TABLE `language` (
  `id` int(11) NOT NULL COMMENT 'Used to identify each different language',
  `name_bg` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'The language written in Bulgarian',
  `name_en` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'The language written in English'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rank`
--

CREATE TABLE `rank` (
  `id` int(11) NOT NULL COMMENT 'Used to identify each different rank',
  `name_bg` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Display name of the rank in Bulgarian',
  `name_en` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Display name of the rank in English'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `series`
--

CREATE TABLE `series` (
  `id` int(11) NOT NULL COMMENT 'Used to identify each different series',
  `book_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Book IDs that belong to the series separated by |',
  `name_original` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Original name in the original language of the series',
  `name_bg` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Name of the series in Bulgarian',
  `name_en` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Name of the series in English'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `settings`
--

CREATE TABLE `settings` (
  `user_id` int(11) NOT NULL COMMENT 'This ID is a copy of the user ID from table user. (e.g. user with ID 2 has settings ID 2)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL COMMENT 'Used to identify each different user',
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Email and username',
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Encrypted password',
  `nickname` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Display name',
  `rank` tinyint(4) NOT NULL COMMENT 'Permission level',
  `achievement_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Achievement IDs separated by |',
  `favorite_book_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Book IDs separated by |',
  `favorite_author_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Author IDs separated by |',
  `favorite_genre_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Genre IDs separated by |',
  `favorite_type_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Type IDs separated by |',
  `city` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'City of residence',
  `join_date` date NOT NULL COMMENT 'Date when the user joined',
  `last_online` datetime NOT NULL COMMENT 'Date when the user was last online',
  `finished_count` smallint(6) NOT NULL COMMENT 'Number of finished books',
  `reading_count` smallint(6) NOT NULL COMMENT 'Number of books the user is reading',
  `wishlist_count` smallint(6) NOT NULL COMMENT 'Number of books the user wants to read',
  `dropped_count` smallint(6) NOT NULL COMMENT 'Number of books the user has dropped',
  `onhold_count` smallint(6) NOT NULL COMMENT 'Number of books the user has on hold',
  `friend_count` smallint(6) NOT NULL COMMENT 'Number of friends the user has',
  `avatar` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Link to the user`s avatar picture',
  `birth_year` smallint(6) NOT NULL COMMENT 'Year of birth',
  `birth_month` tinyint(4) NOT NULL COMMENT 'Month of birth',
  `birth_day` tinyint(4) NOT NULL COMMENT 'Day of birth',
  `review_count` int(11) NOT NULL COMMENT 'Number of reviews the person has written',
  `level` int(11) NOT NULL COMMENT 'Level of the user'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Contains users with their personal information';

-- --------------------------------------------------------

--
-- Table structure for table `user_author`
--

CREATE TABLE `user_author` (
  `id` int(11) NOT NULL COMMENT 'Used to identify each different user author',
  `user_id` int(11) NOT NULL COMMENT 'ID of the user who has voted for the author',
  `author_id` int(11) NOT NULL COMMENT 'ID of the author the user has voted on',
  `rating` tinyint(4) NOT NULL COMMENT 'Rating that the user has given to the author'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user_book`
--

CREATE TABLE `user_book` (
  `id` int(11) NOT NULL COMMENT 'Used to identify each different user book',
  `user_id` int(11) NOT NULL COMMENT 'ID of the user whom this book belongs to',
  `book_id` int(11) NOT NULL COMMENT 'ID of the book this user book is for',
  `rating` tinyint(4) NOT NULL COMMENT 'The rating which the user has selected for the given book',
  `status_id` int(11) NOT NULL COMMENT 'The status of the book (reading/wishlist/etc.)',
  `note` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'A personal note each user can leave for himself',
  `reread_count` tinyint(4) NOT NULL COMMENT 'How many times the user has reread the book',
  `reread_value` tinyint(4) NOT NULL COMMENT 'How much the user has enjoyed rereading the book'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user_review`
--

CREATE TABLE `user_review` (
  `id` int(11) NOT NULL COMMENT 'Used to identify each user review',
  `user_id` int(11) NOT NULL COMMENT 'ID of the user who has voted for a review',
  `review_id` int(11) NOT NULL COMMENT 'ID of the review the user has voted on',
  `rating` tinyint(4) NOT NULL COMMENT 'Rating that the user has given to the review'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Used to track which user has liked/disliked which review';

--
-- Indexes for dumped tables
--

--
-- Indexes for table `achievement`
--
ALTER TABLE `achievement`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book_character`
--
ALTER TABLE `book_character`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book_genre`
--
ALTER TABLE `book_genre`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book_review`
--
ALTER TABLE `book_review`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book_status`
--
ALTER TABLE `book_status`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book_summary`
--
ALTER TABLE `book_summary`
  ADD PRIMARY KEY (`book_id`);

--
-- Indexes for table `book_type`
--
ALTER TABLE `book_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `friend`
--
ALTER TABLE `friend`
  ADD KEY `user1_id` (`user1_id`),
  ADD KEY `user2_id` (`user2_id`);

--
-- Indexes for table `language`
--
ALTER TABLE `language`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rank`
--
ALTER TABLE `rank`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `series`
--
ALTER TABLE `series`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `settings`
--
ALTER TABLE `settings`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_book`
--
ALTER TABLE `user_book`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `achievement`
--
ALTER TABLE `achievement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Used to identify each different achievement';

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Used to identify each author';

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Used to identify each different book';

--
-- AUTO_INCREMENT for table `book_character`
--
ALTER TABLE `book_character`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `book_genre`
--
ALTER TABLE `book_genre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Used to identify each different genre';

--
-- AUTO_INCREMENT for table `book_review`
--
ALTER TABLE `book_review`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Used to identify each different review';

--
-- AUTO_INCREMENT for table `book_status`
--
ALTER TABLE `book_status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Used to identify each different status (e.g. finished/wishlist/etc.)';

--
-- AUTO_INCREMENT for table `book_summary`
--
ALTER TABLE `book_summary`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'This field is a copy of the book ID from table book. (e.g. Book with ID 2 will have ID 2 here)';

--
-- AUTO_INCREMENT for table `book_type`
--
ALTER TABLE `book_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Used to identify each different book type';

--
-- AUTO_INCREMENT for table `country`
--
ALTER TABLE `country`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Used to identify each different country';

--
-- AUTO_INCREMENT for table `language`
--
ALTER TABLE `language`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Used to identify each different language';

--
-- AUTO_INCREMENT for table `rank`
--
ALTER TABLE `rank`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Used to identify each different rank';

--
-- AUTO_INCREMENT for table `series`
--
ALTER TABLE `series`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Used to identify each different series';

--
-- AUTO_INCREMENT for table `settings`
--
ALTER TABLE `settings`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'This ID is a copy of the user ID from table user. (e.g. user with ID 2 has settings ID 2)';

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Used to identify each different user';

--
-- AUTO_INCREMENT for table `user_book`
--
ALTER TABLE `user_book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Used to identify each different user book';
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
