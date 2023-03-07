DROP database IF EXISTS materials_db;
CREATE DATABASE materials_db; -- create a new database

USE materials_db; -- switch to the newly created database

CREATE TABLE materials (
  material_number INT NOT NULL auto_increment,
  material_name VARCHAR(50) NOT NULL,
  description TEXT,
  material_cost integer NOT NULL,
  PRIMARY KEY(material_number)
  
); -- create a table for materials with columns for material number, material name, and description

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
  
