USE materials_db; -- switch to the newly created database

SET SQL_SAFE_UPDATES = 0;

UPDATE materials
SET material_name = "Woody", description =" WOOODDYY"
WHERE material_name ="Wood" ;

SELECT * FROM materials;