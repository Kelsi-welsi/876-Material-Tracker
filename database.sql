-- Drop and recreate the materials database
DROP DATABASE IF EXISTS materials_db;
CREATE DATABASE materials_db;
USE materials_db;

-- Create a table for login credentials
CREATE TABLE login_credentials (
  user_id INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  user_type ENUM('Client', 'Admin', 'Quantity Surveyor', 'Supplier') NOT NULL,
  PRIMARY KEY (user_id)
);

-- Create a table for suppliers
CREATE TABLE suppliers (
  supplier_id INT NOT NULL AUTO_INCREMENT,
  supplier_name VARCHAR(50) NOT NULL,
  supplier_contact_name VARCHAR(50) NOT NULL,
  supplier_contact_email VARCHAR(50) NOT NULL,
  supplier_contact_phone VARCHAR(20) NOT NULL,
  PRIMARY KEY (supplier_id)
);

-- Create a table for shipping details
CREATE TABLE shipping_details (
  shipping_id INT NOT NULL AUTO_INCREMENT,
  client_name VARCHAR(50) NOT NULL,
  shipping_address VARCHAR(100) NOT NULL,
  shipping_date DATE NOT NULL,
  shipping_cost DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (shipping_id)
);

-- Create a table for projects
CREATE TABLE projects (
  project_id INT NOT NULL AUTO_INCREMENT,
  project_name VARCHAR(50) NOT NULL,
  project_description TEXT,
  project_status ENUM('Approved', 'Pending', 'Not Approved') NOT NULL,
  PRIMARY KEY (project_id)
);

-- Create the materials table
CREATE TABLE materials (
  material_number INT NOT NULL AUTO_INCREMENT,
  material_name VARCHAR(50) NOT NULL,
  description TEXT,
  material_cost INT NOT NULL,
  PRIMARY KEY (material_number)
);

-- Insert sample data into the login_credentials table
INSERT INTO login_credentials (username, password, user_type)
VALUES
  ('client1', 'password1', 'Client'),
  ('client2', 'password2', 'Client'),
  ('admin', 'adminpass', 'Admin'),
  ('surveyor1', 'surveyorpass1', 'Quantity Surveyor'),
  ('supplier1', 'supplierpass1', 'Supplier'),
  ('supplier2', 'supplierpass2', 'Supplier');

-- Insert sample data into the suppliers table
INSERT INTO suppliers (supplier_name, supplier_contact_name, supplier_contact_email, supplier_contact_phone)
VALUES
  ('ABC Company', 'John Smith', 'john@abccompany.com', '555-1234'),
  ('XYZ Inc.', 'Jane Doe', 'jane@xyzinc.com', '555-5678');

-- Insert sample data into the shipping_details table
INSERT INTO shipping_details (client_name, shipping_address, shipping_date, shipping_cost)
VALUES
  ('Client A', '123 Main St., Anytown USA', '2023-04-01', 25.00),
  ('Client B', '456 High St., Anytown USA', '2023-04-03', 35.00);

-- Insert sample data into the projects table
INSERT INTO projects (project_name, project_description, project_status)
VALUES
  ('Project 1', 'Description of Project 1', 'Approved'),
  ('Project 2', 'Description of Project 2', 'Pending'),
  ('Project 3', 'Description of Project 3', 'Not Approved');

INSERT INTO materials
VALUES
  (1, 'Steel', 'A strong and durable metal',12000),
  (2, 'Aluminum', 'A lightweight and corrosion-resistant metal',12000),
  (3, 'Copper', 'A good conductor of electricity and heat',12000),
  (4, 'Plastic', 'A synthetic material with a wide range of uses',12000),
  (5, 'Wood', 'A natural material used for building and furniture',12000),
  (6, 'Glass', 'A transparent and brittle material',12000),
  (7, 'Brass', 'An alloy of copper and zinc',12000),
  (8, 'Carbon fiber', 'A lightweight and strong material made from carbon atoms',12000),
  (9, 'Marble', 'A natural stone often used in architecture and sculpture',12000),
  (10, 'Leather', 'A material made from animal hides that is used for clothing and furniture',12000),
  (11, 'Concrete', 'A composite material made from cement, water, and aggregates',12000),
  (12, 'Rubber', 'A flexible material often used for tires and seals',12000),
  (13, 'Silicon', 'A chemical element used in electronic devices',12000),
  (14, 'Gold', 'A precious metal with high value and luster',12000),
  (15, 'Silver', 'A precious metal often used for jewelry and coins',12000),
  (16, 'Titanium', 'A lightweight and strong metal used in aerospace and medical industries',12000),
  (17, 'Nylon', 'A synthetic polymer with high tensile strength and durability',12000),
  (18, 'Polyester', 'A synthetic fiber commonly used in clothing and textiles',12000),
  (19, 'Fiberglass', 'A reinforced plastic material composed of glass fibers and resin',12000),
  (20, 'Zinc', 'A bluish-white metal used in alloys and as a coating for other metals',12000),
  (21, 'Bronze', 'An alloy of copper, tin, and other metals often used for sculptures and musical instruments',12000),
  (22, 'Graphene', 'A single layer of carbon atoms arranged in a hexagonal lattice with extraordinary properties',12000),
  (23, 'Platinum', 'A dense and rare metal with high resistance to corrosion and heat',12000),
  (24, 'Ceramic', 'A non-metallic material made from clay and hardened by heat',12000),
  (25, 'Quartz', 'A mineral composed of silicon and oxygen often used in watches and electronic devices',12000),
  (26, 'Kevlar', 'A strong and heat-resistant synthetic fiber used in body armor and tires',12000),
  (27, 'Bamboo', 'A fast-growing and sustainable natural material often used for flooring and furniture',12000),
  (28, 'Gypsum', 'A soft mineral commonly used in construction for wallboard and plaster',12000),
  (29, 'Magnetite', 'A mineral with magnetic properties used in compasses and as an iron ore',12000),
  (30, 'Tungsten', 'A dense and hard metal with high melting point often used in filaments and alloys',12000);
  
