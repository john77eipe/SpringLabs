use store;

-- Password is 123
INSERT INTO tbl_user
VALUES
    (1, 'shan', 'shan', 'shan@gmail.com', '$2a$10$2L1ElfTdh4YzCrERdIsQSuKGOeOBGpfvXZWKbPy8zTTQ4wBAnqWbC', '2', '1990'),
    (2, 'mad', 'master', 'mad@gmail.com', '$2a$10$2L1ElfTdh4YzCrERdIsQSuKGOeOBGpfvXZWKbPy8zTTQ4wBAnqWbC', '1', '1980');

INSERT INTO tbl_authorities
VALUES
    (1, "ROLE_ADMIN", 1),
    (2, "ROLE_OWNER", 1),
    (3, "ROLE_CUSTOMER", 1),
    (4, "ROLE_OWNER", 2),
    (5, "ROLE_CUSTOMER", 2);

INSERT INTO tbl_pizza
VALUES
    (1, 'Margherita', 'A hugely popular margherita, with a deliciously tangy single cheese topping'),
    (2, 'Farm House', 'A pizza that goes ballistic on veggies! Check out this mouth watering overload of crunchy, crisp capsicum, succulent mushrooms and fresh tomatoes'),
    (3, 'Mexican Green Wave', 'A pizza loaded with crunchy onions, crisp capsicum, juicy tomatoes and jalapeno with a liberal sprinkling of exotic Mexican herbs'),
    (4, 'Pepperoni', 'Signature pizza sauce, pizza mozzarella and loads of pepperoni'),
    (5, 'Spicy Perogy', 'Sour cream, bacon, Cactus Cut Potatoes, pizza mozzarella, cheddar, green onions and a dollop of sour cream'),
    (6, 'Tropical Chicken', 'Alfredo sauce, pizza mozzarella, cheddar, bacon, spicy chicken breast and pineapple');

INSERT INTO tbl_pizza_variant
VALUES
    (1, 'SKU-01-MCC', 1, 325.00, 23.00, 100, 0, 1),
    (2, 'SKU-01-MTW', 1, 433.00, 23.00, 100, 0, 1),
    (3, 'SKU-02-LTO', 2, 654.00, 43.00, 60, 0, 1),
    (4, 'SKU-02-LTM', 2, 670.00, 43.00, 60, 0, 1);

INSERT INTO tbl_pizza_option
VALUES
    (1, 'CATEGORY', 'veg'),
    (2, 'CATEGORY', 'egg'),
    (3, 'CATEGORY', 'chicken'),
	(4, 'CATEGORY', 'beef'),
    (5, 'CATEGORY', 'seafood'),
    (6, 'CATEGORY', 'pork'),
    (7, 'SIZE', 'small'),
    (8, 'SIZE', 'medium'),
    (9, 'SIZE', 'large'),
    (10, 'SIZE', 'xlarge'),
    (11, 'CRUST', 'classic'),
    (12, 'CRUST', 'hand tossed'),
    (13, 'CRUST', 'thin'),
    (14, 'CRUST', 'cheese burst'),
    (15, 'BASE', 'classic'),
    (16, 'BASE', 'wheat'),
    (17, 'BASE', 'oat'),
    (18, 'BASE', 'multi-grain');

INSERT INTO tbl_pizza_variety
VALUES
	(1, 1, 1),
    (2, 1, 8),
    (3, 1, 15),
    (4, 2, 1),
    (5, 2, 8),
    (6, 2, 16),
    (7, 3, 1),
    (8, 3, 9),
    (9, 3, 1),
    (10, 4, 18),
    (11, 4, 9),
    (12, 4, 15);

