CREATE SCHEMA IF NOT EXISTS DB2INST1;

SET SCHEMA
    DB2INST1;

CREATE TABLE IF NOT EXISTS CATEGORY (
    category_id INT PRIMARY KEY,
    name VARCHAR(25),
    last_update DATETIME
);

CREATE TABLE IF NOT EXISTS FILM (
    title INT PRIMARY KEY,
    description VARCHAR(255),
    release_year text,
    language_id smallint,
    original_language_id smallint,
    rental_duration smallint,
    rental_rate decimal(4, 2),
    length smallint,
    replacement_cost decimal(5, 2),
    rating varchar(10),
    special_features varchar(100),
    last_update datetime
);

INSERT INTO
    DB2INST1.FILM
VALUES
    (
        1,
        'ACADEMY DINOSAUR',
        'An Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies',
        '2006',
        1,
        null,
        6,
        0.99,
        86,
        20.99,
        'PG',
        'Deleted Scenes,Behind the Scenes',
        '2006-02-15'
    ),
    (
        2,
        'ACE GOLDFINGER',
        'A Astounding Epistle of a Database Administrator And a Explorer who must Find a Car in Ancient China',
        '2006',
        1,
        null,
        3,
        4.99,
        48,
        12.99,
        'G',
        'Trailers,Deleted Scenes',
        '2006-02-15'
    ),
    (
        3,
        'ADAPTATION HOLES',
        'A Astounding Reflection of a Lumberjack And a Car who must Sink a Lumberjack in A Baloon Factory',
        '2006',
        1,
        null,
        7,
        2.99,
        50,
        18.99,
        'NC-17',
        'Trailers,Deleted Scenes',
        '2006-02-15'
    );

INSERT INTO
    DB2INST1.CATEGORY
VALUES
    (1, 'Action', '2025-05-15 01:12:58'),
    (2, 'Animation', '2025-05-15 01:12:58'),
    (3, 'Children', '2025-05-15 01:12:58');