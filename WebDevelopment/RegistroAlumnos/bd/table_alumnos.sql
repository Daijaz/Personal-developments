

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";



CREATE TABLE `table_alumnos` (
  `id` int(10) NOT NULL,
  `namefull` varchar(100) DEFAULT NULL,
  `cedula` int(20) DEFAULT NULL,
  `sexo` varchar(10) DEFAULT NULL,
  `section` varchar(5) DEFAULT NULL,
  `foto` varchar(50) DEFAULT NULL,
  `fechaRegistro` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


ALTER TABLE `table_alumnos`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `table_alumnos`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
COMMIT;


