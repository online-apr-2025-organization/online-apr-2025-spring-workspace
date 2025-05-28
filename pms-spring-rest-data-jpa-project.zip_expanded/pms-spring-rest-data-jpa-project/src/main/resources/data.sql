insert into product_details(prod_name, prod_description, prod_category, prod_cost, prod_image_url) values('Laptop', 'A new Laptop', 'Electronics', 70000, '');
insert into product_details(prod_name, prod_description, prod_category, prod_cost, prod_image_url) values('Mobile', 'A brand new Mobile', 'Electronics', 50000, '');
insert into product_details(prod_name, prod_description, prod_category, prod_cost, prod_image_url) values('Tops', 'A brand new Top', 'Apparels', 500, '');

insert into review_details(review_rating, review_description, review_product_id) values(5, 'Good', 1);
insert into review_details(review_rating, review_description, review_product_id) values(4, 'Nice', 1);
insert into review_details(review_rating, review_description, review_product_id) values(2, 'Not good', 2);
insert into review_details(review_rating, review_description, review_product_id) values(3, 'Okay', 2);
insert into review_details(review_rating, review_description, review_product_id) values(3, 'Fine', 2);

insert into order_details(order_date) values ('2025-02-02');
insert into order_details(order_date) values ('2025-04-01');

insert into product_order_details(order_id, product_id) values (1, 1);
insert into product_order_details(order_id, product_id) values (2, 2);
insert into product_order_details(order_id, product_id) values (2, 1);