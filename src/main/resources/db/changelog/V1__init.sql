create table material_type
(
    id           serial
        primary key,
    created_at   timestamp(6),
    description  varchar(255) not null,
    icon         varchar(255) not null,
    max_capacity integer      not null,
    name         varchar(255) not null
);

alter table material_type
    owner to postgres;

create table warehouse
(
    id         serial
        primary key,
    created_at timestamp(6)
);

alter table warehouse
    owner to postgres;

create table material
(
    id               serial
        primary key,
    created_at       timestamp(6),
    quantity         integer not null,
    material_type_id integer
        constraint fkbi2x1y0wd21rwst858gdylxr7
            references material_type,
    warehouse_id     integer
        constraint fknl33wf7um0u6h3og6dm5syslc
            references warehouse
);

alter table material
    owner to postgres;