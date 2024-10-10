-- {
--     "id": 0,
--     "name": "Where My Dogs At Collar Tag",
--     "price": 5.99,
--     "description": "Ensure your furry friend always finds their way home with this Where My Dogs At Collar Tag. This tag is made of durable metal and features a fun design that will make your dog the talk of the town. It also includes a metal ring that makes it easy to attach to your dog's collar.",
--     "image": "/placeholder.png"
-- }

CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    price REAL NOT NULL,
    description TEXT NOT NULL,
    image TEXT NOT NULL
);

INSERT INTO product (name, price, description, image) VALUES ('Where My Dogs At Collar Tag', 5.99, 'Ensure your furry friend always finds their way home with this Where My Dogs At Collar Tag. This tag is made of durable metal and features a fun design that will make your dog the talk of the town.', '/placeholder.png');
