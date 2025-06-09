insert into product_details(prod_name, prod_description, prod_category, prod_cost, prod_image_url) values('Laptop', 'A new Laptop', 'Electronics', 70000, 'https://images.unsplash.com/photo-1496181133206-80ce9b88a853?q=80&w=3542&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');
insert into product_details(prod_name, prod_description, prod_category, prod_cost, prod_image_url) values('Mobile', 'A brand new Mobile', 'Electronics', 50000, 'https://images.unsplash.com/photo-1512941937669-90a1b58e7e9c?q=80&w=3540&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');
insert into product_details(prod_name, prod_description, prod_category, prod_cost, prod_image_url) values('Shirt', 'A brand new Shirt', 'Apparels', 500, 'https://images.unsplash.com/photo-1596755094514-f87e34085b2c?q=80&w=3064&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');
insert into product_details(prod_name, prod_description, prod_category, prod_cost, prod_image_url) values('Jeans', 'A brand new Jeans', 'Apparels', 1500, 'https://images.unsplash.com/photo-1602293589930-45aad59ba3ab?q=80&w=2787&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');
insert into product_details(prod_name, prod_description, prod_category, prod_cost, prod_image_url) values('Tablet', 'A brand new Tablet', 'Electronics', 2500, 'https://images.unsplash.com/photo-1648737966636-2fc3a5fffc8a?q=80&w=3540&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');
insert into product_details(prod_name, prod_description, prod_category, prod_cost, prod_image_url) values('T-Shirt', 'A brand new T-Shirt', 'Apparels', 400, 'https://plus.unsplash.com/premium_photo-1718913936342-eaafff98834b?q=80&w=3544&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');
insert into product_details(prod_name, prod_description, prod_category, prod_cost, prod_image_url) values('Smart Watch', 'A brand new Smart Watch', 'Apparels', 5500, 'https://images.unsplash.com/photo-1508685096489-7aacd43bd3b1?q=80&w=3376&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');

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

insert into role_details(role_name) values ('ADMIN');
insert into role_details(role_name) values ('USER');

insert into user_details(user_name, user_password) values ('aaa', '$2a$12$c2STFXyjywPV5U9bjShGHOX0BpRsPcwi8Q/bmWAXavwKiZXvblCCm');
insert into user_details(user_name, user_password) values ('uuu', '$2a$12$Gb4rp0ZurvTIdgWMF4Jev.bWaDYPxHE9zwJL37rliHNVy6am6mBBe');
insert into user_details(user_name, user_password) values ('auau', '$2a$12$p/T2n4TcYYSNamEi8lNLz.sTqravjOHiscnb6epIjBrzQ5YCZJzA.');

insert into user_role_details(user_id, role_id) values(1, 1);
insert into user_role_details(user_id, role_id) values(2, 2);
insert into user_role_details(user_id, role_id) values(3, 1);
insert into user_role_details(user_id, role_id) values(3, 2);