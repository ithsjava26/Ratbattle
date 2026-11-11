# 🗡️👑🐀🔫 RatBattle 👑🐀🔫🗡️

## Projektbeskrivning.

Detta grupparbete består av ett textbaserat konsollspel. En hjälte skall möta råttor av olika rang
för att besegra dem en efter en. Hjälten går genom fem rum och möter råttorna på vägen. För varje rått-ras hjälten besegrar ökar motståndet.
Överlever hjälten till slutet av spelet så möter hen där den stora Rått-Kungen som blir den sista att besegra.

Till sina attacker har hjälten vapen i form av en kniv för att hugga ihjäl råttorna, denna kniv har obegränsat antal 
hugg. En pistol som har begränsat antal skott men som däremot är kraftfullare än kniven i sin attack. Hjälten har en 
viss procents chans att få in en super-attack på råttan som gör dubbelt med skada, men även en viss procents risk att
missa råttan helt med sin attack. Råttorna försvarar sig med att göra skada tillbaka på hjälten, råttans attack träffar 
alltid med samma förinställda skada.
För varje besegrad råtta delas en belöning ut till hjälten i form av en hälsodryck eller extra skott till pistolen. 
Dessa inventarier kan hjälten sedan välja att använda under spelets gång. 

I projektet har även JUnit-tester implementerats för att säkerhetsställa att kod fungerar på önskvärt sätt. 


## Instruktioner för att köra spelet.

Projektet är utvecklat i Java med IntelliJ IDEA och Maven.
1. Klona projektet från GitHub eller öppna projektet i IntelliJ IDEA.
2. Kontrollera att rätt Java JDK är instalerat och valt i projektet.
3. Öppna klassen Main.java i paketet org.example.
4. Kör programmets main()-metod.
5. Spelets huvudmeny visas i konsollen.

Hjälten börjar med 100 HP, sex pistolskott och tre hälsodrycker.
En hälsodryck återställer med 50 HP men hjältens totala HP kan aldrig överstiga 100 HP. 
Dricker hjälten en hälsodryck motsvarar det en attack mot fienden. 


## Ansvarsområden.

Uppstart och grundplanering: Björn & Elise  
battle: Björn  
elise: Elise    
inventory: Björn  
items: Björn  
org.example: Ahmad    
ratworld: Ahmad  
weapons: Björn  
README: Elise  


## Designmönster och varför.  
Factory --> RatFactory ansvarar för att skapa råttfiende-objekten baserat på vilket rum som skickas in i metoden.
GameEngin-klassen anropar metoden för att få rätt råtta till det aktuella rummet.
På detta sätt får vi en tydlig ansvarsfördelning där RatFactory ansvarar för att skapa fienderna medan GameEngin
ansvarar för spelets gång. Om vi i framtiden vill lägga till fler fiender kan vi göra det genom att utöka RatFactory
utan att behöva ändra logiken för hur fiender skapas i GameEngine. 


## Gruppreflektion kring Git-samarbetet.

Dynamiken i gruppen har varit bra och sammarbetet har också fungerat bra, våra starka sidor har speciellt varit 
lyhördheten, engagemanget och tålamodet hos alla tre gruppdeltagare. Områden att jobba på anser vi mer vara de teoretiska
snarare än de personliga. Mer kunskap kring program och funktioner hade underlättat, men då detta arbete går ut på att
vi skall lära oss dessa delar känner vi oss nöjda med vårt arbte och vad vi har åstadkomit. Att arbeta i grupp har varit 
enormt lärorikt och roligt.

Vi har använt oss av Git och GitHub för vår versionshantering och vårat samarbete. Vi har arbetat med separata brancher 
för att kunna utveckla olika delar av spelet utan att direkt ändra i huvudbranchen main. När en gruppmedlem har pushat 
kod till GitHub har denna även gjort en pull request som sedan en annan gruppmedlem har granskat och mergat in till main.

Vid speciellt två tillfällen har vi stött på patrull. Vid första tillfället uppstod problem i form av att lokal kod inte 
syntes på GitHub när vi gjorde en push. När vi gjorde pull försvann viss nyskriven lokal kod och vi fick gå tillbaka i 
comitterna för att återfå koden och kunna återställa den senaste lokala branchen. Gällande GitHub upptäckte vi att det 
fanns olika sätt att pusha upp kod till GitHub, beroende på vilken branch vi arbetade med, och därmed olika saker att
tänka på när koden skulle mergas in i main. Tack vare tålmodigt sammarbete löste vi detta tillsammans via teams.

Andra tillfället vi stötte på problem gällde även det att pusha rätt kod till GitHub. I detta fall fanns det inget lokalt
repo på den aktuella datorn och vi fick kalla in Martin för att be om hjälp med att lösa problemet. 