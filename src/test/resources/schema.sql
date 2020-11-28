CREATE TABLE IF NOT EXISTS ask_sandbox
(
    id            uuid PRIMARY KEY,
    create_date   timestamp,
    room    varchar ,
    temperature integer ,
    humidity integer
);



