CREATE DATABASE materials_db; -- create a new database

USE materials_db; -- switch to the newly created database

CREATE TABLE materials (
  material_number INT PRIMARY KEY,
  material_name VARCHAR(50) NOT NULL,
  description TEXT
); -- create a table for materials with columns for material number, material name, and description

INSERT INTO materials (material_number, material_name, description)
VALUES
  (1, 'Steel', 'A strong and durable metal'),
  (2, 'Aluminum', 'A lightweight and corrosion-resistant metal'),
  (3, 'Copper', 'A good conductor of electricity and heat'),
  (4, 'Plastic', 'A synthetic material with a wide range of uses'),
  (5, 'Wood', 'A natural material used for building and furniture');
  (6, 'Glass', 'A transparent and brittle material'),
  (7, 'Brass', 'An alloy of copper and zinc'),
  (8, 'Carbon fiber', 'A lightweight and strong material made from carbon atoms'),
  (9, 'Marble', 'A natural stone often used in architecture and sculpture'),
  (10, 'Leather', 'A material made from animal hides that is used for clothing and furniture'),
  (11, 'Concrete', 'A composite material made from cement, water, and aggregates'),
  (12, 'Rubber', 'A flexible material often used for tires and seals'),
  (13, 'Silicon', 'A chemical element used in electronic devices'),
  (14, 'Gold', 'A precious metal with high value and luster'),
  (15, 'Silver', 'A precious metal often used for jewelry and coins');
  (16, 'Titanium', 'A lightweight and strong metal used in aerospace and medical industries'),
  (17, 'Nylon', 'A synthetic polymer with high tensile strength and durability'),
  (18, 'Polyester', 'A synthetic fiber commonly used in clothing and textiles'),
  (19, 'Fiberglass', 'A reinforced plastic material composed of glass fibers and resin'),
  (20, 'Zinc', 'A bluish-white metal used in alloys and as a coating for other metals'),
  (21, 'Bronze', 'An alloy of copper, tin, and other metals often used for sculptures and musical instruments'),
  (22, 'Graphene', 'A single layer of carbon atoms arranged in a hexagonal lattice with extraordinary properties'),
  (23, 'Platinum', 'A dense and rare metal with high resistance to corrosion and heat'),
  (24, 'Ceramic', 'A non-metallic material made from clay and hardened by heat'),
  (25, 'Quartz', 'A mineral composed of silicon and oxygen often used in watches and electronic devices');
  (26, 'Kevlar', 'A strong and heat-resistant synthetic fiber used in body armor and tires'),
  (27, 'Bamboo', 'A fast-growing and sustainable natural material often used for flooring and furniture'),
  (28, 'Gypsum', 'A soft mineral commonly used in construction for wallboard and plaster'),
  (29, 'Magnetite', 'A mineral with magnetic properties used in compasses and as an iron ore'),
  (30, 'Tungsten', 'A dense and hard metal with high melting point often used in filaments and alloys');