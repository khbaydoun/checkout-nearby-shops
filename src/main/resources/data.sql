-- Demo data. Coordinates are real places in Berlin and Munich.

INSERT INTO buyer (id, name, street, postal_code, city, latitude, longitude) VALUES
    (1, 'Anna',  'Oranienstr. 25',   '10999', 'Berlin', 52.5010, 13.4190),   -- Kreuzberg
    (2, 'Ben',   'Kastanienallee 10', '10435', 'Berlin', 52.5380, 13.4100),  -- Prenzlauer Berg
    (3, 'Carla', 'Hauptstr. 1',      '12345', 'Berlin', NULL,    NULL);      -- address could not be geocoded

INSERT INTO seller_location (seller_id, street, zip, city, lat, lng) VALUES
    (100, 'Boxhagener Str. 50', '10245', 'Berlin',  52.5100, 13.4600),      -- Friedrichshain
    (200, 'Marienplatz 8',      '80331', 'München', 48.1374, 11.5755);
    -- seller 300 has no location yet

INSERT INTO ad (id, title, price_cents, seller_id, status) VALUES
    (10, 'Fahrrad 28 Zoll',              15000, 100, 'ACTIVE'),
    (11, 'IKEA Kallax Regal',             2550, 100, 'ACTIVE'),
    (12, 'Lampe (schon verkauft)',        1500, 100, 'SOLD'),
    (20, 'Nintendo Switch mit 2 Spielen', 18999, 200, 'ACTIVE'),
    (30, 'Bücherpaket',                   1000, 300, 'ACTIVE');
