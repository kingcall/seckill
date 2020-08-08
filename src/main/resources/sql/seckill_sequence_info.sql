create table sequence_info
(
    table_name    varchar(30)   not null
        primary key,
    current_value int default 0 null,
    step          int default 1 null
)
    charset = utf8;

INSERT INTO seckill.sequence_info (table_name, current_value, step) VALUES ('order', 15, 1);