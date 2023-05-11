ALTER TABLE category ADD COLUMN deleted Boolean ;

ALTER TABLE category ALTER COLUMN deleted SET DEFAULT false;