CREATE TABLE post
(
    id     integer PRIMARY KEY,
    author VARCHAR NOT NULL,
    text   VARCHAR NOT NULL
);

CREATE TABLE comment
(
    id      integer PRIMARY KEY,
    text    VARCHAR      NOT NULL
);
