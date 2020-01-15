  
INSERT INTO tbl_category VALUES (1, 'veg');
INSERT INTO tbl_category VALUES (2, 'chicken');
INSERT INTO tbl_category VALUES (3, 'beef');
INSERT INTO tbl_category VALUES (4, 'mutton');
INSERT INTO tbl_category VALUES (5, 'pork');
INSERT INTO tbl_category VALUES (6, 'seafood');
INSERT INTO tbl_category VALUES (7, 'mixed');
INSERT INTO tbl_category VALUES (8, 'italian');
INSERT INTO tbl_category VALUES (9, 'south-west');

INSERT INTO tbl_pizza VALUES (1, 'Margherita', 13.5, 'A hugely popular margherita, with a deliciously tangy single cheese topping', 1, 100, 0.0, 1);
INSERT INTO tbl_pizza VALUES (2, 'Farm House', 14.5, 'A pizza that goes ballistic on veggies! Check out this mouth watering overload of crunchy, crisp capsicum, succulent mushrooms and fresh tomatoes', 1, 100, 0.0, 1);
INSERT INTO tbl_pizza VALUES (3, 'Mexican Green Wave', 15.0, 'A pizza loaded with crunchy onions, crisp capsicum, juicy tomatoes and jalapeno with a liberal sprinkling of exotic Mexican herbs', 1, 100, 0.0, 1);
INSERT INTO tbl_pizza VALUES (4, 'Pepperoni', 15.0, 'Signature pizza sauce, pizza mozzarella and loads of pepperoni', 5, 100, 0.0, 1);
INSERT INTO tbl_pizza VALUES (5, 'Spicy Perogy', 13.5, 'Sour cream, bacon, Cactus Cut Potatoes, pizza mozzarella, cheddar, green onions and a dollop of sour cream', 3, 5, 0.0, 1);
INSERT INTO tbl_pizza VALUES (6, 'Tropical Chicken', 13.5, 'Alfredo sauce, pizza mozzarella, cheddar, bacon, spicy chicken breast and pineapple', 2, 5, 0.0, 1);

INSERT INTO tbl_pizza_category_map VALUES (1, 1, 8);
INSERT INTO tbl_pizza_category_map VALUES (2, 6, 9);
INSERT INTO tbl_pizza_category_map VALUES (3, 5, 9);