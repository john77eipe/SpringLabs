use store;

-- INSERT INTO tbl_category
-- VALUES
--     (1, 'veg'),
--     (2, 'chicken'),
--     (3, 'beef'),
--     (4, 'mutton'),
--     (5, 'pork'),
--     (6, 'seafood'),
--     (7, 'mixed'),
--     (8, 'italian'),
--     (9, 'south-west');
-- 
-- INSERT INTO tbl_pizza
-- VALUES
--     (1, 'Margherita', 13.5, 'A hugely popular margherita, with a deliciously tangy single cheese topping', 1, 100, 0.0, 1),
--     (2, 'Farm House', 14.5, 'A pizza that goes ballistic on veggies! Check out this mouth watering overload of crunchy, crisp capsicum, succulent mushrooms and fresh tomatoes', 1, 100, 0.0, 1),
--     (3, 'Mexican Green Wave', 15.0, 'A pizza loaded with crunchy onions, crisp capsicum, juicy tomatoes and jalapeno with a liberal sprinkling of exotic Mexican herbs', 1, 100, 0.0, 1),
--     (4, 'Pepperoni', 15.0, 'Signature pizza sauce, pizza mozzarella and loads of pepperoni', 5, 100, 0.0, 1),
--     (5, 'Spicy Perogy', 13.5, 'Sour cream, bacon, Cactus Cut Potatoes, pizza mozzarella, cheddar, green onions and a dollop of sour cream', 3, 5, 0.0, 1),
--     (6, 'Tropical Chicken', 13.5, 'Alfredo sauce, pizza mozzarella, cheddar, bacon, spicy chicken breast and pineapple', 2, 5, 0.0, 1);
-- 
-- INSERT INTO tbl_pizza_category_map
-- VALUES
--     (1, 1, 8),
--     (2, 6, 9),
--     (3, 5, 9);

-- Password is 123
INSERT INTO tbl_user
VALUES
    (1, 'shan', 'shan', 'shan@gmail.com', '$2a$10$2L1ElfTdh4YzCrERdIsQSuKGOeOBGpfvXZWKbPy8zTTQ4wBAnqWbC', '2', '1990'),
    (2, 'mad', 'master', 'mad@gmail.com', '$2a$10$2L1ElfTdh4YzCrERdIsQSuKGOeOBGpfvXZWKbPy8zTTQ4wBAnqWbC', '1', '1980');

-- INSERT INTO tbl_option_group
-- VALUES
--     (1,'size'),
--     (2,'crust'),
--     (3,'base');
-- 
-- INSERT INTO tbl_option
-- VALUES
--     (1,'small',1),
--     (2,'medium',1),
--     (3,'large',1),
--     (4,'gigantic',1),
--     (5,'classic',2),
--     (6,'hand tossed',2),
--     (7,'thin',2),
--     (8,'cheese burst',2),
--     (9,'fresh pan',2),
--     (10,'wheat',3),
--     (11,'classic',3),
--     (12,'oat',3),
--     (13,'multi-grain',3);
-- 
-- INSERT INTO tbl_pizza_option_group
-- VALUES
--     (1,1,1),
--     (2,1,2),
--     (3,1,3),
--     (4,2,1),
--     (5,2,2),
--     (6,2,3),
--     (7,3,1),
--     (8,3,2),
--     (9,4,1),
--     (10,4,2),
--     (11,5,1),
--     (12,5,2),
--     (13,5,3),
--     (14,6,1);
-- 
-- INSERT INTO tbl_pizza_variant
-- VALUES
--     (1,'SKU-01-MCC',325.00,23.00,100,0,1,1),
--     (2,'SKU-01-MTW',390.00,25.00,100,0,1,1),
--     (3,'SKU-02-LTO',500.00,50.75,60,0,1,2),
--     (4,'SKU-02-LTM',525.00,52.00,60,0,1,2);
-- 
-- INSERT INTO tbl_pizza_variant_option_map
-- VALUES
--     (1,1,2),
--     (2,1,5),
--     (3,1,11),
--     (4,2,2),
--     (5,2,7),
--     (6,2,10),
--     (7,3,3),
--     (8,3,7),
--     (9,3,12),
--     (10,4,3),
--     (11,4,7),
--     (12,4,13);


INSERT INTO tbl_authorities
VALUES
    (1, "ROLE_ADMIN", 1),
    (2, "ROLE_OWNER", 1),
    (3, "ROLE_CUSTOMER", 1),
    (4, "ROLE_OWNER", 2),
    (5, "ROLE_CUSTOMER", 2);
