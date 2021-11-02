use archivio;

insert into amministratore (email, passwordAdmin) values
('paoloRossi80@gmail.com', 12345678),
('micheleBianchi77@gmail.com', 87654321);

insert into utente(email, passwordUtente, nome, cognome, dataNascita, telefono, inizioAbbonamento, fineAbbonamento) values
('robertoRossi60@gmail.com', '12345678', 'Roberto', 'Rossi', '1980-10-10', 1234567891, null, null),
('marioRossi60@gmail.com','12345678', 'Mario', 'Rossi', '1980-10-10', 1234567891, null, null);

insert into insegnante (id_insegnante, nome, cognome, ristorante) values
(1, 'Alfonso', 'Pepe',null),
(2, 'Benedetta', 'Rossi', null),
(3, 'Sonia', 'Peronaci', null),
(4, 'Stefano', 'Barbato', null),
(5, 'Max', 'Mariola', null),
(6, 'Luca', 'Pappagallo',null);

insert into video (titolo, categoria, gratuito, id_insegnante, email_admin) values
('Panettone di Alfonso Pepe', 'Dolci', true, 1, 'paoloRossi80@gmail.com'), /* si 1*/
/*('Sfogliatelle frolle di Alfonso Pepe', 'Dolci', false, 1, 'micheleBianchi77@gmail.com'),*/
('Colomba di pasqua di Alfonso Pepe', 'Dolci', true, 1, 'paoloRossi80@gmail.com'), /* si 3 */
/*('Crostata di marmellata di Benedetta Rossi', 'Dolci', true, 2, 'paoloRossi80@gmail.com'),*/
('Mustaccioli di Benedetta Rossi', 'Dolci', false, 2, 'micheleBianchi77@gmail.com'),  /*si 5 */
/*('Torta paradiso di Benedetta Rossi', 'Dolci', true, 2, 'paoloRossi80@gmail.com'),   */
('Pollo alla cacciatora di Sonia Peronaci', 'Secondi', false, 3, 'micheleBianchi77@gmail.com'), /* si 7*/
/*('Pollo ripieno con salsiccia di Sonia Peronaci', 'Secondi', true, 3, 'paoloRossi80@gmail.com'), */
/*('Anatra laccata al miele di Sonia Peronaci', 'Secondi', false, 3, 'micheleBianchi77@gmail.com'),*/
/*('Branzino di Stefano Barbato', 'Secondi', true, 4, 'paoloRossi80@gmail.com'),*/
/*('Anelli di calamari fritti di Stefano Barbato', 'Antipasti', false, 4, 'micheleBianchi77@gmail.com'),  */
/*('Pasta e ceci di Stefano Barbato', 'Primi', true, 4, 'paoloRossi80@gmail.com'), */
/*('Baccalà fritto di Stefano Barbato', 'Secondi', false, 4, 'micheleBianchi77@gmail.com'),*/
('Spaghetti alla carbonara di Stefano Barbato', 'Primi', true, 4, 'paoloRossi80@gmail.com'), /*si 14*/
/*('Spaghetti alle vongole di Stefano Barbato', 'Primi', false, 4, 'micheleBianchi77@gmail.com'),*/
/*('Tagliatelle ai funghi porcini di Stefano Barbato', 'Primi', true, 4, 'paoloRossi80@gmail.com'),*/
/*('Gamberoni saltati al vino bianco di Stefano Barbato', 'Antipasti', false, 4, 'micheleBianchi77@gmail.com'), */
/*('Arrosto di manzo di Max Mariola', 'Secondi', false, 5, 'micheleBianchi77@gmail.com'), */
('Cotoletta alla milanese di Max Mariola', 'Secondi', true, 5, 'paoloRossi80@gmail.com'), /*si* 19*/
/*('Bistecca fiorentina di Max Mariola', 'Secondi', false, 5, 'micheleBianchi77@gmail.com'),*/
('Pesce spada con pomodorini di Max Mariola', 'Secondi', true, 5, 'paoloRossi80@gmail.com'), /*si 21*/
/*('Salmone in padella di Max Mariola', 'Secondi', false, 5, 'micheleBianchi77@gmail.com'), */
/*('Pasta alla gricia di Max Mariola', 'Primi',true, 5, 'paoloRossi80@gmail.com'),    */
('Pasta al salmone affumicato di Max Mariola', 'Primi', false, 5, 'micheleBianchi77@gmail.com'), /* si 24*/
('Melanzane in padella di Luca Pappagallo', 'Contorni',true, 6, 'paoloRossi80@gmail.com'), /* si 25 */
/*('Cianfotta napoletana di Luca Pappagallo', 'Contorni',false, 6, 'micheleBianchi77@gmail.com'),*/
/*('Fagiolini con la panna di Luca Pappagallo', 'Contorni',true, 6, 'paoloRossi80@gmail.com'),*/
('Patate alla savoiarda di Luca Pappagallo', 'Antipasti',false, 6, 'micheleBianchi77@gmail.com'), /*si* 28 */
('Cavolfiore gratinato al forno di Luca Pappagallo', 'Antipasti',true, 6, 'paoloRossi80@gmail.com'),  /*si 29 */
('Cipolle fritte in pastella di Luca Pappagallo', 'Contorni',false, 6, 'micheleBianchi77@gmail.com'); /* si 30 */








