/*
  Создать таблицы, соответствующие иерархии из вашей диаграммы классов.
  Заполнить таблицы данными о животных, их командах и датами рождения.
*/

CREATE DATABASE IF NOT EXISTS human_friends;
USE human_friends;

CREATE TABLE IF NOT EXISTS category (
	category_id SERIAL PRIMARY KEY,
	name VARCHAR(100)
);

INSERT INTO category (name) VALUES
('вьючное'),
('домашнее');

CREATE TABLE IF NOT EXISTS subcategory (
	subcategory_id SERIAL PRIMARY KEY,
	name VARCHAR(100)
);

INSERT INTO subcategory (name) VALUES
('лошадь'),
('верблюд'),
('осёл'),
('собака'),
('кошка'),
('хомяк');

CREATE TABLE IF NOT EXISTS animal (
	animal_id SERIAL PRIMARY KEY,
	category_id BIGINT UNSIGNED NOT NULL,
	subcategory_id BIGINT UNSIGNED NOT NULL,
	name VARCHAR(100),
	birth_date DATE,
	FOREIGN KEY (category_id) REFERENCES category(category_id) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (subcategory_id) REFERENCES subcategory(subcategory_id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO animal (category_id, subcategory_id, name, birth_date) VALUES
(1, 1, 'Грозовой', '2019-05-04'),
(1, 2, 'Сэнди', '2021-08-02'),
(1, 3, 'Бурро', '2022-08-14'),
(2, 4, 'Бобик', '2018-04-05'),
(2, 5, 'Уголёк', '2023-11-23'),
(2, 6, 'Майк', '2023-11-25');

CREATE TABLE IF NOT EXISTS command (
	command_id SERIAL PRIMARY KEY,
	name VARCHAR(100)
);

INSERT INTO command (name) VALUES
('стоять'),
('сидеть'),
('лежать'),
('бежать');

CREATE TABLE IF NOT EXISTS animal_command (
	animal_id BIGINT UNSIGNED NOT NULL,
	command_id BIGINT UNSIGNED NOT NULL,
	PRIMARY KEY (animal_id, command_id),
	FOREIGN KEY (animal_id) REFERENCES animal(animal_id) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (command_id) REFERENCES command(command_id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO animal_command (animal_id, command_id) VALUES
(1, 4),
(2, 1),
(2, 4),
(3, 1),
(4, 1),
(4, 2),
(4, 3),
(4, 4),
(5, 2),
(5, 3),
(6, 4);

/*
  Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их
  возраст с точностью до месяца.
*/

USE human_friends;

SELECT
	name AS 'Имя',
	TIMESTAMPDIFF(MONTH, birth_date, CURRENT_DATE()) AS 'Возраст'
FROM animal
WHERE TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) BETWEEN 1 AND 3;

/*
  Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности
  к исходным таблицам.
*/

USE human_friends;

SELECT
	animal.animal_id AS 'Идентификатор животного',
	animal.category_id AS 'Вид',
	animal.subcategory_id AS 'Подвид',
	animal.name AS 'Имя',
	animal.birth_date AS 'Дата рождения',
	command.command_id AS 'Идентификатор команды',
	command.name 'Название команды'
FROM animal
JOIN category ON animal.category_id = category.category_id
JOIN subcategory ON animal.subcategory_id = subcategory.subcategory_id
JOIN animal_command ON animal.animal_id = animal_command.animal_id
JOIN command ON animal_command.command_id = command.command_id;
