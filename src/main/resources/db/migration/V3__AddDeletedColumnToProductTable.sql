ALTER TABLE product ADD COLUMN deleted Boolean ;

ALTER TABLE product ALTER COLUMN deleted SET DEFAULT false;