drop table if exists song;

CREATE TABLE song (
    pk bigserial PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    artist VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL
);

INSERT INTO song
    (pk, title, artist, category)
values
    (1, 'hope', 'NF', 'SONG::RAP');
INSERT INTO song
    (pk, title, artist, category)
values
    (2, 'the great deception', 'PsoGnar', 'SONG::ELECTRONIC');