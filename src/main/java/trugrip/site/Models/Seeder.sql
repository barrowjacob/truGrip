DROP DATABASE tru_grip_db;
USE tru_grip_db;

INSERT INTO users(email, is_admin, phone_number) VALUES
('jacob@gmail.com',  true, '8086832239');

TRUNCATE school_classes;
INSERT INTO school_classes(date, price, seats_available, user_id, title, body) VALUES
('Feb. 1 -- 9AM - 3PM', 100.00, 12, 1, 'CHL Qualification', 'This is the comprehensive concealed carry course which includes a 6-hour block of instruction, a required written exam and 2 hours for range time...'),
('Feb. 3 -- 9AM - 3PM', 150.00, 12, 1, 'Active Shooter Course', 'Transform your workplace with this thorough guide to active shooter response. Keep your kids safe, your employees secure with this comprehensive guide...')
