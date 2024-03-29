-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

insert into
    vhs_movie (
        price, inventoryAmount, category, imageUrl, description, deleted, name
    )
values (
        199.99, 9, 'Action|Thriller', 'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/uzxdKGVLPoCGsGZ9Oga92fG6rLi.jpg', 'Högt över Los Angeles har en grupp terrorister intagit en byggnad, tagit gisslan och förklarat krig. Men en man har lyckats undgå att bli upptäckt...en polisman som inte är i tjänst. Han är ensam...trött...och det sista hoppet för alla.', false, 'Die Hard'
    );

insert into
    vhs_movie (
        price, inventoryAmount, category, imageUrl, description, deleted, name
    )
values (
        199.99, 155, 'Action|Thriller|Science Fiction', 'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qvktm0BHcnmDpul4Hz01GIazWPr.jpg', 'År 2029 ligger planeten jorden i ruiner efter ett kärnvapenkrig. Maskinerna har tagit över makten och människorna förvisats till underjorden.', false, 'Terminator'
    );

insert into
    vhs_movie (
        price, inventoryAmount, category, imageUrl, description, deleted, name
    )
values (
        556.55, 217, 'Drama|Action|Äventyr', 'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xUuHj3CgmZQ9P2cMaqQs4J0d4Zc.jpg', 'Top Gun handlar om de faror och den spänning som väntar den som blir pilot på marinens prestigefyllda skola för jaktflyg. Tom Cruise är utmärkt i rollen som den våghalsige, unge piloten Maverick Mitchell som gör allt för att bli bäst.', false, 'Top Gun'
    );

insert into
    vhs_movie (
        price, inventoryAmount, category, imageUrl, description, deleted, name
    )
values (
        199.99, 215, 'Thriller|Action|Äventyr|Krig', 'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/a9sa6ERZCpplbPEO7OMWE763CLD.jpg', 'John Rambo är en veteran från Vietnam-kriget. Han luffar runt i Amerika och hälsar på sina vänner från kriget. En dag hamnar han i en bortglömd stad. Stadens sheriff är inte alls glad över att ha fått en främling i staden.', false, 'First Blood'
    );

insert into
    vhs_movie (
        price, inventoryAmount, category, imageUrl, description, deleted, name
    )
values (
        199.99, 795, 'Drama', 'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/2sfb8ldcdQ3y224q3cyEivBp5Mz.jpg', 'Underhållande drama om en fattig och lite bortkommen boxares problem och slutliga succé i en avslutande stormatch. Publiksuccé blev det också vilket bekräftas av de fyra uppföljarna.', false, 'Rocky'
    );

insert into
    vhs_movie (
        price, inventoryAmount, category, imageUrl, description, deleted, name
    )
values (
        199.99, 579, 'Drama|Kriminal', 'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ekstpH614fwDX8DUln1a2Opz0N8.jpg', 'Travis Bickle är taxichaufför i New York. Han kan inte sova. I sin paranoia kör han runt och runt i staden och äcklas av våldet, hororna och alla de hemlösa. En dag kommer regnet och sköljer bort all skit, säger han. Men det kommer inget regn.', true, 'Taxi Driver'
    );

insert into
    vhs_movie (
        price, inventoryAmount, category, imageUrl, description, deleted, name
    )
values (
        199.99, 771, 'Action|Kriminal|Drama', 'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iDABT5GD9OQmFiXM3wR0DJIxtkY.jpg', 'Redan i uppsamlingslägret i Miami lär sig den unge kubanen Tony Montana den brutala sanningen. Det är bara brott som lönar sig för en fattig flykting. Den blomstrande kokainsmugglingen blir hans språngbräda till framgång.', false, 'Scarface'
    );

insert into
    vhs_movie (
        price, inventoryAmount, category, imageUrl, description, deleted, name
    )
values (
        199.99, 792, 'Science Fiction|Drama|Thriller', 'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/63N9uy8nd9j7Eog2axPQ8lbr3Wj.jpg', 'År 2019 nedstiger en grupp förrymda replikanter på jorden i jakt på sin skapare, Dr Eldon Tyrell. Replikanter – genframställda människor – har visat sig vara farliga för människan eftersom de efter en tid utvecklar sina egna känslor.', false, 'Blade Runner'
    );

insert into
    vhs_movie (
        price, inventoryAmount, category, imageUrl, description, deleted, name
    )
values (
        199.99, 410, 'Skräck|Science Fiction', 'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vfrQk5IPloGg1v9Rzbh2Eg3VGyM.jpg', 'Skräcken börjar när besättningen på rymdskeppet Nostromo undersöker en sändning från en avlägsen planet, och gör den fasansfulla upptäckten att där finns en livsform som uppstår och förökar sig inuti människokroppar.', false, 'Alien'
    );

insert into
    vhs_movie (
        price, inventoryAmount, category, imageUrl, description, deleted, name
    )
values (
        199.99, 656, 'Skräck|Thriller', 'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/dsiWHj9RUoQeA6uViUEZRlBwSUJ.jpg', 'Vackra stränder med vackra människor. Det fridfulla stället Amity i Massachusetts har hela tiden levt på turisterna så att de klarar sig på vinterhalvåret. Men när en badare blir dödad av en jättestor haj så får Sheriff Brody ta ett svårt beslut: Att stänga stranden precis före den värsta sommarruschen i juli. Men det är inte mycket han kan göra om hajen inte ger sig av. ', false, 'Hajen'
    );

insert into
    vhs_movie (
        price, inventoryAmount, category, imageUrl, description, deleted, name
    )
values (
        199.99, 673, 'Drama|Science Fiction', 'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iTk59x6Tap1sG2q0tnEGhiVjFnZ.jpg', 'En helt vanlig natt börjar plötsligt ett helt samhälle att läggas i mörker och ovanliga ljusfenomn börjar att uppträda på natthimlen. Från elverket skickas Roy Neary ut för att försöka reparera felen, men på väg till en av nätstationerna kör han vilse. Plötsligt skakas hela bilen fruktansvärt och han bländas av ett oerhört starkt sken.', false, 'Närkontakt av tredje graden'
    );

insert into
    vhs_movie (
        price, inventoryAmount, category, imageUrl, description, deleted, name
    )
values (
        199.99, 305, 'Action|Äventyr', 'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/dIYc5PqinJva1611VUDIdVXatOi.jpg', 'Den handlingskraftige arkeologen ger sig tillsammans med sin självständiga och något svårhanterliga ex-flickvän Marion Ravenwood iväg för att finna den sägenomspunna heliga arken före nazisterna. Den halsbrytande kapplöpningen går genom Sydamerikas djungler, Kairos myllrande gator och en topphemlig ubåtsbas, och Indy tvingas utstå gift, fällor, ormar och förrädare för att nå målet.', false, 'Jakten på den försvunna skatten'
    );

insert into
    vhs_movie (
        price, inventoryAmount, category, imageUrl, description, deleted, name
    )
values (
        199.99, 612, 'Action|Familj|Drama', 'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/5hhXYYB9Q4hcqCuNSNueNtvfIVB.jpg', 'Daniel flyttar till en ny stad och blir genast trakasserad av den f.d. pojkvännen till den tjej han är intresserad av. Daniel bestämmer sig för att börja träna karate och av en händelse är Miyagi, vicevärden i hans hyreshus, en gammal karate-mästare.', false, 'Sanningens ögonblick - Karate Kid'
    );

insert into
    vhs_movie (
        price, inventoryAmount, category, imageUrl, description, deleted, name
    )
values (
        199.99, 418, 'Äventyr|Science Fiction', 'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oU7Oq2kFAAlGqbU4VoAE36g4hoI.jpg', 'En rik entreprenör skapar i hemlighet en nöjespark med levande dinosaurier från förhistoriskt DNA. Före öppningsdagen bjuder han ner ett team av experter och sina två ivriga barnbarn för att uppleva parken och bidra till att lugna oroliga investerare. Dock är parken allt annat än roande eftersom säkerhetssystemen fallerar och dinosaurierna rymmer.', false, 'Jurassic Park'
    );

insert into
    vhs_movie (
        price, inventoryAmount, category, imageUrl, description, deleted, name
    )
values (
        199.99, 521, 'Äventyr|Komedi|Science Fiction', 'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9XbEMSZNpPmN9IQOg3j4ZZCjgtt.jpg', 'För att komma undan ett gäng terrorister hoppar Marty in i en sportbil som hans vän och uppfinnare har tillverkat. Bilen är ombyggd till en tidsmaskin och snart befinner sig Marty 30 år tillbaka i tiden där han möter sina föräldrar som unga. Men plutoniumet som krävs för att driva bilen tar slut och Marty måste uppsöka uppfinnaren som ung för att försöka ordna så att han kan återvända till 1985.', false, 'Tillbaka till framtiden'
    );

insert into
    vhs_movie (
        price, inventoryAmount, category, imageUrl, description, deleted, name
    )
values (
        199.99, 964, 'Fantasy|Skräck|Komedi', 'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/3iUgvvtB01BuTntPOBcG64kYk6y.jpg', 'Låt den aldrig bli blöt. Håll den borta från starkt ljus. Och hur mycket den än gråter, hur mycket den än ber… ge den aldrig mat efter midnatt, med dessa instruktioner så får Billy Peltzer ett nytt kramigt djur i sin ägo. Billy kommer att få mycket mer än han räknade med.', false, 'Gremlins'
    );




   



INSERT INTO
    vhs_player (
        price, name, inventoryAmount, imageUrl, description, deleted
    )
VALUES (
        799, "VHS PLAYER 9000", 7, 'https://cdn.pixabay.com/photo/2016/02/26/01/00/video-1223304_1280.jpg', "Handmade by LEFFE of Sweden", false
    );

INSERT INTO
    vhs_player (
        price, name, inventoryAmount, imageUrl, description, deleted
    )
VALUES (
        32.2, "Spelare ett", 1, 'https://images.pexels.com/photos/14923853/pexels-photo-14923853.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', "Din första VHS-spelare", false
    );

INSERT INTO
    vhs_player (
        price, name, inventoryAmount, imageUrl, description, deleted
    )
VALUES (
        9000.1, "Over 9000!", 764, 'https://cdn.pixabay.com/photo/2020/02/22/21/50/record-4871720_1280.jpg', "The best player for Dragon Ball Z", false
    );