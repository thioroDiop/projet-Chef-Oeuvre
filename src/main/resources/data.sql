
insert into role ( id,description) values (nextval('role_id_seq'),'Demoiselles d honneur');
insert into role ( id,description) values (nextval('role_id_seq'),'Garçon d honneur');
insert into role (id, description) values (nextval('role_id_seq'),'Enfants d honneur');
insert into role ( id,description) values (nextval('role_id_seq'),'Invité');
insert into role ( id,description) values (nextval('role_id_seq'),'Témoin des mariés');

insert into task (id, description) values (nextval('task_id_seq'),'suivi organisationnel');
insert into task (id, description) values (nextval('task_id_seq'),'Coordination');
insert into task (id, description) values (nextval('task_id_seq'),'Preparation Salle Reception');
insert into task (id, description) values (nextval('task_id_seq'),'DJ');
insert into task ( id,description) values (nextval('task_id_seq'),'Animation');
insert into task (id, description) values (nextval('task_id_seq'),'Desing Floral');
insert into task (id, description) values (nextval('task_id_seq'),'Emméne la mariée la la mairie');

insert into relation_ship (id, relation_type) values (nextval('relation_id_seq'),'Parents mariés');
insert into relation_ship (id, relation_type) values (nextval('relation_id_seq'),'Oncle et Tante');
insert into relation_ship (id, relation_type) values (nextval('relation_id_seq'),'Amis Proches');
insert into relation_ship (id, relation_type) values (nextval('relation_id_seq'),'Famille');
insert into relation_ship (id, relation_type) values (nextval('relation_id_seq'),'Copain');
insert into relation_ship (id, relation_type) values (nextval('relation_id_seq'),'Collegue');

insert into gift (id, name, description,price,image_url) values (nextval('gift_id_seq'),'Parure Lit','set de lit : housse de couette, drap de fond et taies d''oreiller',60,'https://www.kadolog.com/sites/default/files/styles/large/public/bookmark/1317635822_64328b475ee099d29e914cdeeb8b168c.jpg?itok=t4w8Kykl');
insert into gift ( id,name, description,price,image_url) values (nextval('gift_id_seq'),'Cours de cuisine pour 2','Pour se faire de bons petits plats ensemble',110,'https://www.kadolog.com/sites/default/files/styles/large/public/2015/55113/cuisine.jpg?itok=VEs1Gw1r');
insert into gift ( id,name, description,price,image_url) values (nextval('gift_id_seq'),'Aspirateur balai Dyson','Aspirateur balai Cyclone V10 Absolute Pro Jusqu’a 60 minutes d aspiration puissante.Puissance d aspiration élevée pour le nettoyage partout
*Autonomie maximale en mode d’aspiration 1 avec une brosse non motorisée.',449,'https://www.kadolog.com/sites/default/files/styles/large/public/bookmark/1721936098_570x450.21005787_01.png?itok=Rgu4x4fe');
insert into gift ( id,name, description,price,image_url) values (nextval('gift_id_seq'),'Miroir rond doré','Un miroir qui trônera au dessus de notre cheminée',80,'https://www.kadolog.com/sites/default/files/styles/large/public/bookmark/630127754_miroir-rond-dore-d81-1000-2-33-204172_1.jpg?itok=nFlHg9Gk');
insert into gift ( id,name, description,price,image_url) values (nextval('gift_id_seq'),'6 verres à eau','Il y aura des verres à vin aussi, pas de panique !',17.94,'https://www.kadolog.com/sites/default/files/styles/large/public/bookmark/702587055_gobelet-en-verre-1000-15-28-107489_2.jpg?itok=H0kaRcMd');
insert into gift (id, name, description,price,image_url) values (nextval('gift_id_seq'),'Bougeoirs','Eveillez vos sens dans un decord parfait',77,'https://www.kadolog.com/sites/default/files/styles/large/public/bookmark/1985494208_1819421457_bou.jpg?itok=ptJsEZNk');
insert into gift ( id,name, description,price,image_url) values (nextval('gift_id_seq'),'Tablier','Tablier de couple',23,'https://www.kadolog.com/sites/default/files/styles/large/public/bookmark/1343109439_61RqKcLFILL._SX679_.jpg?itok=Cnj-HtkC');
insert into gift ( id,name, description,price,image_url) values (nextval('gift_id_seq'),'Apéritif de Luxe','Un apéritif de Luxe pendant notre voyage de noces',50,'https://www.kadolog.com/sites/default/files/styles/large/public/bookmark/1283751834_coconut-drinks-on-beach-in-maldives--vacation-in-paradise--sunny-day-in-topical-island-693332440-5a95c55418ba010037e2718b.jpg?itok=S9X3RoFW');
insert into gift ( id,name, description,price,image_url) values (nextval('gift_id_seq'),'Activité pendant notre voyage de noce.','Vous souhaitez essayer la plongée sous-marine mais vous ne vous sentez pas encore prêt(e) pour le grand saut d un cours avec certification? Notre formule d initiation à la plongée est faite pour vous.
Cette formule vous apportera toutes les sensations d une véritable plongée sous-marine.',50,'https://www.kadolog.com/sites/default/files/styles/large/public/2020/108602/sans_titre.png?itok=z8alM57p');
insert into gift (id, name, description,price,image_url) values (nextval('gift_id_seq'),'Massage voyage de noces','Petit massage en duo lors de notre voyage de noces',60,'https://www.kadolog.com/sites/default/files/styles/large/public/2019/107091/massage-therapy.jpg?itok=EHyde-6x');
insert into gift (id, name, description,price,image_url) values (nextval('gift_id_seq'),'Diner en bord de mer','UN DÎNER ROMANTIQUE EN BORD DE MER SUR LA COSTA BRAVA ... le lieu parfait pour profiter de la cuisine catalane traditionnelle après une promenade dans la vieille ville ou en bord de mer.',150,'https://www.kadolog.com/sites/default/files/styles/large/public/bookmark/2039363809_capture_decran_2019-01-27_a_17.42.08.png?itok=15UtjZd4');
insert into gift (id, name, description,price,image_url) values (nextval('gift_id_seq'),'Thermomix TM6','Its just a amazing utensil! And we ll be able to cook you delicious meals!',1300,'https://www.kadolog.com/sites/default/files/styles/large/public/2020/123625/thermomix.png?itok=vUitjuf1');

insert into wedding_table (id, table_name,image_url ) values (nextval('table_id_seq'),'https://fontmeme.com/permalink/210914/61aee281518c3f3e5e04957de8a69da1.png','http://www.caboucadin.com/coloriage/albums/animaux/animaux-de-la-jungle/girafe/dessin-girafe-10.jpg');
insert into wedding_table (id, table_name,image_url ) values (nextval('table_id_seq'),'https://fontmeme.com/permalink/210914/aa058ad5a2edaa1218b4ee2064d666d4.png','https://img.redro.pl/plakaty/field-graphic-black-white-landscape-vertical-sketch-illustration-vector-400-198277024.jpg');
insert into wedding_table (id, table_name,image_url ) values (nextval('table_id_seq'),'https://fontmeme.com/permalink/210916/a4b18df9aacfae1dc82a117e99a8f113.png','https://media1.chapellerie-traclet.com/22922-large/chapeau-melon-anglais.jpg');
insert into wedding_table (id, table_name,image_url ) values (nextval('table_id_seq'),'https://fontmeme.com/permalink/210914/92537e23f2bbf62e1af0b565eedaa331.png','https://i.pinimg.com/originals/43/bc/e3/43bce3d487f64cfa9a8bff8ac622302d.png');
insert into wedding_table (id, table_name,image_url ) values (nextval('table_id_seq'),'https://fontmeme.com/permalink/210914/ae3922103ae8c32b294b70c7a2fb0f10.png','https://th.bing.com/th/id/OIP.CGr8c6VwJ_kbmkwfpI4agQAAAA?pid=ImgDet&rs=1');
insert into wedding_table (id, table_name,image_url ) values (nextval('table_id_seq'),'https://fontmeme.com/permalink/210914/783c278c94bc98a3a921c757dcd3a00e.png' ,'http://emeraude1977.e.m.pic.centerblog.net/574ceda6.jpg');
insert into wedding_table (id, table_name,image_url ) values (nextval('table_id_seq'),'https://fontmeme.com/permalink/210914/aa83fb3005950bd0f90fa5ad6f4a295a.png','https://i.pinimg.com/736x/ae/b9/49/aeb9495b8822694296bcc6024ec74f39.jpg');
insert into wedding_table (id, table_name,image_url ) values (nextval('table_id_seq'),'https://fontmeme.com/permalink/210914/db5ee2862d8ca5608c8e10c841f223d8.png','http://www.lesgribouillagesdenico.com/images/dessin-de-kangourou_4.jpg');
insert into wedding_table (id, table_name,image_url ) values (nextval('table_id_seq'),'https://fontmeme.com/permalink/210914/890a0bdcc118d22474f2f749b3eaaf5a.png','https://st2.depositphotos.com/1000419/10459/v/950/depositphotos_104596248-stock-illustration-indian-goddess-shakti-sketch-for.jpg');

insert into bridal_couple (id, name,table_marie_id) values (nextval('bridal_id_seq'),'FerNando',1);
insert into bridal_couple (id, name,table_marie_id) values (nextval('bridal_id_seq'),'Isabelle',1);


insert into guest (id, last_name,first_name,role_id,relation_ship_id, email, accommodation,task_id,bridal_id,gift_id,table_id,amount_participation) values(nextval('guest_id_seq'),'Tourne','Jean',4,4,'tournejean@gmail.fr','Hotel',	1,1,1,3          ,60);
insert into guest (id,last_name,first_name,role_id,relation_ship_id, email, accommodation,task_id,bridal_id,gift_id,table_id ,amount_participation) values(nextval('guest_id_seq'),'Martin','christelle',1,2,'marinchristelle@gmail.fr','Auberge',1,2,8,3,50);
insert into guest (id,last_name,first_name,role_id,relation_ship_id, email, accommodation,task_id,bridal_id,gift_id,table_id ,amount_participation) values(nextval('guest_id_seq'),'Dupond','charles',2,6,'dupondcharles@gmail.fr','Auberge',2,1,5,3     ,17.94);
insert into guest (id, last_name,first_name,role_id,relation_ship_id, email, accommodation,task_id,bridal_id,gift_id,table_id,amount_participation) values(nextval('guest_id_seq'),'Duroc','Anna',4,3,'durocAnna@gmail.fr','Auberge',3,1,2,5             ,50);
insert into guest (id, last_name,first_name,role_id,relation_ship_id, email, accommodation,task_id,bridal_id,gift_id,table_id,amount_participation) values(nextval('guest_id_seq'),'Sarr','Simon',4,3,'SarrSimon@gmail.fr','Auberge',3,2,6,5             ,77);
insert into guest (id, last_name,first_name,role_id,relation_ship_id, email, accommodation,task_id,bridal_id,gift_id,table_id,amount_participation) values(nextval('guest_id_seq'),'Diatta','Charles',4,5,'DiattaCharles@gmail.fr','Auberge',4,2,7,9     ,23);
insert into guest (id, last_name,first_name,role_id,relation_ship_id, email, accommodation,task_id,bridal_id,gift_id,table_id,amount_participation) values(nextval('guest_id_seq'),'Gomis','Gisèle',1,4,'GomisGisèle@gmail.fr','Auberge',5,1,9,9         ,50);
insert into guest (id, last_name,first_name,role_id,relation_ship_id, email, accommodation,task_id,bridal_id,gift_id,table_id,amount_participation) values(nextval('guest_id_seq'),'Kureem','Laura',4,3,'KureemLaura@gmail.fr','Hotel',6,2,10,4          ,60);
insert into guest (id,last_name,first_name,role_id,relation_ship_id, email, accommodation,task_id,bridal_id,gift_id,table_id ,amount_participation) values(nextval('guest_id_seq'),'Anselmi','chantal',4,1,'Anselmichantal@gmail.fr','Hotel',2,2,12,2    ,100);
insert into guest (id, last_name,first_name,role_id,relation_ship_id, email, accommodation,task_id,bridal_id,gift_id,table_id,amount_participation) values(nextval('guest_id_seq'),'Anselmi','Patrique',4,1,'AnselmiPatrique@gmail.fr','Hotel',7,2,12,2  ,100);
insert into guest (id, last_name,first_name,role_id,relation_ship_id, email, accommodation,task_id,bridal_id,gift_id,table_id,amount_participation) values(nextval('guest_id_seq'),'Ducroq','Bernard',4,1,'DucroqBernard@gmail.fr','Hotel',2,1,3,2       ,50);
insert into guest (id,last_name,first_name,role_id,relation_ship_id, email, accommodation,task_id,bridal_id,gift_id,table_id ,amount_participation) values(nextval('guest_id_seq'),'Ducroq','Brigitte',4,1,'DucroqBrigitte@gmail.fr','Hotel',2,1,3,2     ,60);
