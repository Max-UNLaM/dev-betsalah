package ar.edu.unlam.tallerweb1.servicios.inicializador;

import ar.edu.unlam.tallerweb1.dao.EquipoDao;
import ar.edu.unlam.tallerweb1.dao.JugadorDao;
import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioCargaJugadores {
    @Autowired
    private JugadorDao jugadorDao;
    @Autowired
    private EquipoDao equipoDao;

    public void cargarJugadoresSiNoExisten(){
        if(!jugadoresExistenEnBaseDeDatos()){
            List<Jugador> jugadores = crearJugadores();
            cargarJugadoresEnBaseDeDatos(jugadores);
        }
    }

    private Boolean jugadoresExistenEnBaseDeDatos(){
        return jugadorDao.obtenerTodosLosJugadores() != null;
    }

    private List<Jugador> crearJugadores(){
        Equipo rusia = equipoDao.obtenerEquipoPorNombre("Rusia");
        Equipo arabiaSaudita = equipoDao.obtenerEquipoPorNombre("Arabia Saudita");
        Equipo egipto = equipoDao.obtenerEquipoPorNombre("Egipto");
        Equipo uruguay = equipoDao.obtenerEquipoPorNombre("Uruguay");
        Equipo portugal = equipoDao.obtenerEquipoPorNombre("Portugal");
        Equipo espana = equipoDao.obtenerEquipoPorNombre("España");
        Equipo marruecos = equipoDao.obtenerEquipoPorNombre("Marruecos");
        Equipo iran = equipoDao.obtenerEquipoPorNombre("Irán");
        Equipo francia = equipoDao.obtenerEquipoPorNombre("Francia");
        Equipo australia = equipoDao.obtenerEquipoPorNombre("Australia");
        Equipo peru = equipoDao.obtenerEquipoPorNombre("Perú");
        Equipo dinamarca = equipoDao.obtenerEquipoPorNombre("Dinamarca");
        Equipo argentina = equipoDao.obtenerEquipoPorNombre("Argentina");
        Equipo islandia = equipoDao.obtenerEquipoPorNombre("Islandia");
        Equipo croacia = equipoDao.obtenerEquipoPorNombre("Croacia");
        Equipo nigeria = equipoDao.obtenerEquipoPorNombre("Nigeria");
        Equipo brasil = equipoDao.obtenerEquipoPorNombre("Brasil");
        Equipo suiza = equipoDao.obtenerEquipoPorNombre("Suiza");
        Equipo costaRica = equipoDao.obtenerEquipoPorNombre("Costa Rica");
        Equipo serbia = equipoDao.obtenerEquipoPorNombre("Serbia");
        Equipo alemania = equipoDao.obtenerEquipoPorNombre("Alemania");
        Equipo mexico = equipoDao.obtenerEquipoPorNombre("México");
        Equipo suecia = equipoDao.obtenerEquipoPorNombre("Suecia");
        Equipo coreaDelSur = equipoDao.obtenerEquipoPorNombre("Corea del Sur");
        Equipo belgica = equipoDao.obtenerEquipoPorNombre("Bélgica");
        Equipo panama = equipoDao.obtenerEquipoPorNombre("Panamá");
        Equipo tunez = equipoDao.obtenerEquipoPorNombre("Túnez");
        Equipo inglaterra = equipoDao.obtenerEquipoPorNombre("Inglaterra");
        Equipo polonia = equipoDao.obtenerEquipoPorNombre("Polonia");
        Equipo senegal = equipoDao.obtenerEquipoPorNombre("Senegal");
        Equipo colombia = equipoDao.obtenerEquipoPorNombre("Colombia");
        Equipo japon = equipoDao.obtenerEquipoPorNombre("Japón");

        List<Jugador> jugadores = new ArrayList<>();

        //Rusia
        jugadores.add(new Jugador("Ígor Akinféev", rusia));
        jugadores.add(new Jugador("Vladímir Gabúlov ", rusia));
        jugadores.add(new Jugador("Andréi Luniov", rusia));
        jugadores.add(new Jugador("Vladímir Granat", rusia));
        jugadores.add(new Jugador("Fiódor Kudriashov", rusia));
        jugadores.add(new Jugador("Iliá Kutépov", rusia));
        jugadores.add(new Jugador("Semenov", rusia));
        jugadores.add(new Jugador("Ígor Smólnikov", rusia));
        jugadores.add(new Jugador("Mário Fernandes ", rusia));
        jugadores.add(new Jugador("Serguéi Ignashévich", rusia));
        jugadores.add(new Jugador("Yuri Gazinskiy", rusia));
        jugadores.add(new Jugador("Alexandr Golovin", rusia));
        jugadores.add(new Jugador("Alán Dzagóev", rusia));
        jugadores.add(new Jugador("Alexandr Yerokhin", rusia));
        jugadores.add(new Jugador("Yuri Zhirkov", rusia));
        jugadores.add(new Jugador("Román Zobnin", rusia));
        jugadores.add(new Jugador("Daler Kuzyáev", rusia));
        jugadores.add(new Jugador("Antón Miranchuk", rusia));
        jugadores.add(new Jugador("Alexandr Samédov ", rusia));
        jugadores.add(new Jugador("Denís Chéryshev", rusia));
        jugadores.add(new Jugador("Artiom Dzyuba", rusia));
        jugadores.add(new Jugador("Alexéi Miranchuk ", rusia));
        jugadores.add(new Jugador("Fiódor Smólov", rusia));

        //Uruguay
        jugadores.add(new Jugador("Fernando Muslera", uruguay));
        jugadores.add(new Jugador("Martín Silva", uruguay));
        jugadores.add(new Jugador("Martín Campaña", uruguay));
        jugadores.add(new Jugador("Diego Godín", uruguay));
        jugadores.add(new Jugador("José María Giménez", uruguay));
        jugadores.add(new Jugador("Sebastián Coates", uruguay));
        jugadores.add(new Jugador("Maximiliano Pereira", uruguay));
        jugadores.add(new Jugador("Guillermo Varela", uruguay));
        jugadores.add(new Jugador("Gastón Silva ", uruguay));
        jugadores.add(new Jugador("Martín Cáceres", uruguay));
        jugadores.add(new Jugador("Nahitan Nández", uruguay));
        jugadores.add(new Jugador("Matías Vecino", uruguay));
        jugadores.add(new Jugador("Rodrigo Bentancur", uruguay));
        jugadores.add(new Jugador("Cristian Rodríguez", uruguay));
        jugadores.add(new Jugador("Carlos Sánchez", uruguay));
        jugadores.add(new Jugador("Giorgian De Arrascaeta", uruguay));
        jugadores.add(new Jugador("Jonathan Urretaviscaya", uruguay));
        jugadores.add(new Jugador("Lucas Torreira", uruguay));
        jugadores.add(new Jugador("Diego Laxalt", uruguay));
        jugadores.add(new Jugador("Luis Suárez", uruguay));
        jugadores.add(new Jugador("Edinson Cavani", uruguay));
        jugadores.add(new Jugador("Cristhian Stuani ", uruguay));
        jugadores.add(new Jugador("Maximiliano Gómez", uruguay));

        //Egipto
        jugadores.add(new Jugador("Essam El Hadary", egipto));
        jugadores.add(new Jugador("Mohamed El Shenaw", egipto));
        jugadores.add(new Jugador("Sherif Ekramy", egipto));
        jugadores.add(new Jugador("Ahmed Fathi", egipto));
        jugadores.add(new Jugador("Saad Samir", egipto));
        jugadores.add(new Jugador("Ayman Ashraf", egipto));
        jugadores.add(new Jugador("Ahmed Hegazi", egipto));
        jugadores.add(new Jugador("Ali Gabr", egipto));
        jugadores.add(new Jugador("Ahmed Elmohamady", egipto));
        jugadores.add(new Jugador("Mohamed Abdel-Shafi", egipto));
        jugadores.add(new Jugador("Omar Gaber", egipto));
        jugadores.add(new Jugador("Mahmoud Hamdy", egipto));
        jugadores.add(new Jugador("Mohamed Elneny", egipto));
        jugadores.add(new Jugador("Tarek Hamed", egipto));
        jugadores.add(new Jugador("Sam Morsy", egipto));
        jugadores.add(new Jugador("Mahmoud Abdel Razek", egipto));
        jugadores.add(new Jugador("Abdallah El Said", egipto));
        jugadores.add(new Jugador("Mahmoud Hassan", egipto));
        jugadores.add(new Jugador("Ramadan Sobhi", egipto));
        jugadores.add(new Jugador("Amr Warda", egipto));
        jugadores.add(new Jugador("Mahmoud Abdel-Moneim", egipto));
        jugadores.add(new Jugador("Mohamed Salah", egipto));
        jugadores.add(new Jugador("Marwan Mohsen", egipto));

        //Arabia Saudita
        jugadores.add(new Jugador("Mohammed Al-Owais", arabiaSaudita));
        jugadores.add(new Jugador("Yasser Al-Musailem ", arabiaSaudita));
        jugadores.add(new Jugador("Abdullah Al-Mayuf", arabiaSaudita));
        jugadores.add(new Jugador("Mansoor Al-Harbi", arabiaSaudita));
        jugadores.add(new Jugador("Yasser Al-Shahrani", arabiaSaudita));
        jugadores.add(new Jugador("Mohammed Al-Breik", arabiaSaudita));
        jugadores.add(new Jugador("Motaz Hawsawi", arabiaSaudita));
        jugadores.add(new Jugador("Omar Hawsawi", arabiaSaudita));
        jugadores.add(new Jugador("Ali Al-Bulaihi", arabiaSaudita));
        jugadores.add(new Jugador("Abdullah Al-Khaibari", arabiaSaudita));
        jugadores.add(new Jugador("Abdulmalek Al-Khaibri", arabiaSaudita));
        jugadores.add(new Jugador("Abdullah Otayf", arabiaSaudita));
        jugadores.add(new Jugador("Taiseer Al-Jassim", arabiaSaudita));
        jugadores.add(new Jugador("Houssain Al-Mogahwi Nawaf", arabiaSaudita));
        jugadores.add(new Jugador("Mohamed Kanno", arabiaSaudita));
        jugadores.add(new Jugador("Hattan Bahebri", arabiaSaudita));
        jugadores.add(new Jugador("Mohammed Al-Kwikbi", arabiaSaudita));
        jugadores.add(new Jugador("Salem Al-Dawsari", arabiaSaudita));
        jugadores.add(new Jugador("Yehya Al-Shehri", arabiaSaudita));
        jugadores.add(new Jugador("Fahad Al-Muwallad", arabiaSaudita));
        jugadores.add(new Jugador("Mohammad Al-Sahlawi ", arabiaSaudita));
        jugadores.add(new Jugador("Muhannad Assiri", arabiaSaudita));

        //Portugal
        jugadores.add(new Jugador("Anthon", portugal));
        jugadores.add(new Jugador("Lopes", portugal));
        jugadores.add(new Jugador("Beto ", portugal));
        jugadores.add(new Jugador("Rui Patrício", portugal));
        jugadores.add(new Jugador("Bruno Alves", portugal));
        jugadores.add(new Jugador("Cédric Soares", portugal));
        jugadores.add(new Jugador("José Fonte", portugal));
        jugadores.add(new Jugador("Mário Rui", portugal));
        jugadores.add(new Jugador("Pepe", portugal));
        jugadores.add(new Jugador("Raphael Guerreiro", portugal));
        jugadores.add(new Jugador("Ricardo Pereira ", portugal));
        jugadores.add(new Jugador("Rúben Dias", portugal));
        jugadores.add(new Jugador("Adrien Silva", portugal));
        jugadores.add(new Jugador("Bruno Fernandes", portugal));
        jugadores.add(new Jugador("João Mário", portugal));
        jugadores.add(new Jugador("João Moutinho", portugal));
        jugadores.add(new Jugador("Manuel Fernandes ", portugal));
        jugadores.add(new Jugador("William Carvalho", portugal));
        jugadores.add(new Jugador("André Silva", portugal));
        jugadores.add(new Jugador("Bernardo Silva", portugal));
        jugadores.add(new Jugador("Cristiano Ronaldo", portugal));
        jugadores.add(new Jugador("Gelson Martins", portugal));
        jugadores.add(new Jugador("Gonçalo Guedes ", portugal));
        jugadores.add(new Jugador("Ricardo Quaresma", portugal));

        //España
        jugadores.add(new Jugador("Kepa", espana));
        jugadores.add(new Jugador("David De Gea ", espana));
        jugadores.add(new Jugador("Pepe Reina", espana));
        jugadores.add(new Jugador("Jordi Alba", espana));
        jugadores.add(new Jugador("Cesar Azpilicueta", espana));
        jugadores.add(new Jugador("Dani Carvajal", espana));
        jugadores.add(new Jugador("Nacho", espana));
        jugadores.add(new Jugador("Monreal", espana));
        jugadores.add(new Jugador("Odriozola", espana));
        jugadores.add(new Jugador("Piqué", espana));
        jugadores.add(new Jugador("Ramos", espana));
        jugadores.add(new Jugador("Isco", espana));
        jugadores.add(new Jugador("Thiago", espana));
        jugadores.add(new Jugador("Busquets", espana));
        jugadores.add(new Jugador("Silva", espana));
        jugadores.add(new Jugador("Andrés Iniesta", espana));
        jugadores.add(new Jugador("Saúl", espana));
        jugadores.add(new Jugador("Koke", espana));
        jugadores.add(new Jugador("Asensio", espana));
        jugadores.add(new Jugador("Iago Aspas", espana));
        jugadores.add(new Jugador("Diego Costa", espana));
        jugadores.add(new Jugador("Rodrigo ", espana));
        jugadores.add(new Jugador("Lucas", espana));

        //Marruecos
        jugadores.add(new Jugador("Munir", marruecos));
        jugadores.add(new Jugador("Bono", marruecos));
        jugadores.add(new Jugador("Ahmed Reda Tagnaouti", marruecos));
        jugadores.add(new Jugador("Mehdi Benatia", marruecos));
        jugadores.add(new Jugador("Romain Saiss", marruecos));
        jugadores.add(new Jugador("Manuel Da Costa", marruecos));
        jugadores.add(new Jugador("Badr Benoun", marruecos));
        jugadores.add(new Jugador("Nabil Dirar", marruecos));
        jugadores.add(new Jugador("Achraf Hakimi", marruecos));
        jugadores.add(new Jugador("Hamza Mendyl", marruecos));
        jugadores.add(new Jugador("Mbark Boussoufa", marruecos));
        jugadores.add(new Jugador("Karim El Ahmadi", marruecos));
        jugadores.add(new Jugador("Youssef Ait Bennasser", marruecos));
        jugadores.add(new Jugador("Sofian Amrabat", marruecos));
        jugadores.add(new Jugador("Younes Belhanda", marruecos));
        jugadores.add(new Jugador("Fayçal Fajr", marruecos));
        jugadores.add(new Jugador("Amine Harit", marruecos));

        //Irán
        jugadores.add(new Jugador("Alireza Beiranvand", iran));
        jugadores.add(new Jugador("Rashid Mazaheri ", iran));
        jugadores.add(new Jugador("Amir Abedzadeh", iran));
        jugadores.add(new Jugador("Majid Hosseini", iran));
        jugadores.add(new Jugador("Milad Mohammadi", iran));
        jugadores.add(new Jugador("Mohammad Khanzadeh", iran));
        jugadores.add(new Jugador("Morteza Pouraliganji", iran));
        jugadores.add(new Jugador("Pejman Montazeri", iran));
        jugadores.add(new Jugador("Ramin Rezaeian", iran));
        jugadores.add(new Jugador("Roozbeh Cheshmi", iran));
        jugadores.add(new Jugador("Ehsan Haji Safi", iran));
        jugadores.add(new Jugador("Karim Ansarifard", iran));
        jugadores.add(new Jugador("Masoud Shojaei", iran));
        jugadores.add(new Jugador("Mehdi Torabi", iran));
        jugadores.add(new Jugador("Omid Ebrahimi ", iran));
        jugadores.add(new Jugador("Saeid Ezatolahi", iran));
        jugadores.add(new Jugador("Alireza Jahanbakhsh", iran));
        jugadores.add(new Jugador("Ashkan Dejageh", iran));
        jugadores.add(new Jugador("Mehdi Taremi", iran));
        jugadores.add(new Jugador("Reza Ghoochannejhad", iran));
        jugadores.add(new Jugador("Saman Ghoddos", iran));
        jugadores.add(new Jugador("Sardar Azmoun ", iran));
        jugadores.add(new Jugador("Vahid Amiri", iran));

        //Francia
        jugadores.add(new Jugador("Areola", francia));
        jugadores.add(new Jugador("Lloris ", francia));
        jugadores.add(new Jugador("Mandanda", francia));
        jugadores.add(new Jugador("Lucas Hernández", francia));
        jugadores.add(new Jugador("Kimpembe", francia));
        jugadores.add(new Jugador("Mendy", francia));
        jugadores.add(new Jugador("Pavard", francia));
        jugadores.add(new Jugador("Rami", francia));
        jugadores.add(new Jugador("Sidibe", francia));
        jugadores.add(new Jugador("Umtiti ", francia));
        jugadores.add(new Jugador("Varane", francia));
        jugadores.add(new Jugador("Kanté", francia));
        jugadores.add(new Jugador("Matuidi", francia));
        jugadores.add(new Jugador("N'Zonzi", francia));
        jugadores.add(new Jugador("Pogba ", francia));
        jugadores.add(new Jugador("Tolisso", francia));
        jugadores.add(new Jugador("Dembélé", francia));
        jugadores.add(new Jugador("Fekir", francia));
        jugadores.add(new Jugador("Giroud", francia));
        jugadores.add(new Jugador("Griezmann", francia));
        jugadores.add(new Jugador("Lemar", francia));
        jugadores.add(new Jugador("Mbappé ", francia));
        jugadores.add(new Jugador("Thauvin", francia));

        //Australia
        jugadores.add(new Jugador("Mat Ryan", australia));
        jugadores.add(new Jugador("Brad Jones ", australia));
        jugadores.add(new Jugador("Dann", australia));
        jugadores.add(new Jugador("Vukovic", australia));
        jugadores.add(new Jugador("Trent Sainsbury", australia));
        jugadores.add(new Jugador("Matthew Jurman", australia));
        jugadores.add(new Jugador("Milos Degenek", australia));
        jugadores.add(new Jugador("Joshua Risdon", australia));
        jugadores.add(new Jugador("Aziz Behich", australia));
        jugadores.add(new Jugador("James Meredith", australia));
        jugadores.add(new Jugador("Mile Jedinak", australia));
        jugadores.add(new Jugador("Aaron Mooy", australia));
        jugadores.add(new Jugador("Tom Rogic", australia));
        jugadores.add(new Jugador("Massimo Luongo", australia));
        jugadores.add(new Jugador("Jackson Irvine", australia));
        jugadores.add(new Jugador("Dimi Petratos ", australia));
        jugadores.add(new Jugador("Mark Milligan", australia));
        jugadores.add(new Jugador("Tim Cahill", australia));
        jugadores.add(new Jugador("Tomi Juric", australia));
        jugadores.add(new Jugador("Mathew Leckie", australia));
        jugadores.add(new Jugador("Daniel Arzani", australia));
        jugadores.add(new Jugador("Andrew Nabbout", australia));
        jugadores.add(new Jugador("Robbie Kruse ", australia));
        jugadores.add(new Jugador("Jamie Maclaren", australia));

        //Peru
        jugadores.add(new Jugador("Carlos Caceda", peru));
        jugadores.add(new Jugador("José Carvallo", peru));
        jugadores.add(new Jugador("Pedro Gallese", peru));
        jugadores.add(new Jugador("Luis Advíncula", peru));
        jugadores.add(new Jugador("Pedro Aquino", peru));
        jugadores.add(new Jugador("Miguel Araujo", peru));
        jugadores.add(new Jugador("André Carrillo", peru));
        jugadores.add(new Jugador("Aldo Corzo", peru));
        jugadores.add(new Jugador("Christian Cueva", peru));
        jugadores.add(new Jugador("Jefferson Farfán", peru));
        jugadores.add(new Jugador("Edison Flores", peru));
        jugadores.add(new Jugador("Paolo Hurtado", peru));
        jugadores.add(new Jugador("Nilson Loyola", peru));
        jugadores.add(new Jugador("And", peru));
        jugadores.add(new Jugador("Polo", peru));
        jugadores.add(new Jugador("Christian Ramos", peru));
        jugadores.add(new Jugador("Alberto Rodríguez", peru));
        jugadores.add(new Jugador("Raúl Ruidíaz", peru));
        jugadores.add(new Jugador("Anderson Santamaría", peru));
        jugadores.add(new Jugador("Renato Tapia", peru));
        jugadores.add(new Jugador("Miguel Trauco", peru));
        jugadores.add(new Jugador("Paolo Guerrero ", peru));
        jugadores.add(new Jugador("Yoshimar Yotún", peru));

        //Dinamarca
        jugadores.add(new Jugador("Frederik Ronnow", dinamarca));
        jugadores.add(new Jugador("Jonas Lossl ", dinamarca));
        jugadores.add(new Jugador("Kasper Schmeichel", dinamarca));
        jugadores.add(new Jugador("Andreas Christensen", dinamarca));
        jugadores.add(new Jugador("Henrik Dalsgaard", dinamarca));
        jugadores.add(new Jugador("Jannik Vestergaard", dinamarca));
        jugadores.add(new Jugador("Jens Stryger Larsen", dinamarca));
        jugadores.add(new Jugador("Jonas Knudsen", dinamarca));
        jugadores.add(new Jugador("Mathias Jorgensen ", dinamarca));
        jugadores.add(new Jugador("Simon Kjaer", dinamarca));
        jugadores.add(new Jugador("Christian Eriksen", dinamarca));
        jugadores.add(new Jugador("Lasse Schoene", dinamarca));
        jugadores.add(new Jugador("Lukas Lerager", dinamarca));
        jugadores.add(new Jugador("Michael Krohn-Dehli", dinamarca));
        jugadores.add(new Jugador("Thomas Delaney", dinamarca));
        jugadores.add(new Jugador("William Vitved Kvist", dinamarca));
        jugadores.add(new Jugador("Andreas Cornelius", dinamarca));
        jugadores.add(new Jugador("Kasper Dolberg", dinamarca));
        jugadores.add(new Jugador("Martin Braithwaite ", dinamarca));
        jugadores.add(new Jugador("Nicolai Jorgensen", dinamarca));
        jugadores.add(new Jugador("Pione Sisto", dinamarca));
        jugadores.add(new Jugador("Viktor Fischer", dinamarca));
        jugadores.add(new Jugador("Yussuf Yurar", dinamarca));
        jugadores.add(new Jugador("Poulsen", dinamarca));

        //Argentina
        jugadores.add(new Jugador("Sergio Romero", argentina));
        jugadores.add(new Jugador("Wilfredo Caballero", argentina));
        jugadores.add(new Jugador("Franco Armani", argentina));
        jugadores.add(new Jugador("Gabriel Mercado", argentina));
        jugadores.add(new Jugador("Nicolás Otamendi", argentina));
        jugadores.add(new Jugador("Federico Fazio", argentina));
        jugadores.add(new Jugador("Nicolás Tagliafico", argentina));
        jugadores.add(new Jugador("Marcos Rojo", argentina));
        jugadores.add(new Jugador("Marcos Acuña", argentina));
        jugadores.add(new Jugador("Cristian Ansaldi ", argentina));
        jugadores.add(new Jugador("Eduardo Salvio", argentina));
        jugadores.add(new Jugador("Javier Mascherano", argentina));
        jugadores.add(new Jugador("Ángel Di María", argentina));
        jugadores.add(new Jugador("Ever Banega", argentina));
        jugadores.add(new Jugador("Lucas Biglia", argentina));
        jugadores.add(new Jugador("Enzo Pérez", argentina));
        jugadores.add(new Jugador("Giovani Lo Celso", argentina));
        jugadores.add(new Jugador("Leandro Paredes ", argentina));
        jugadores.add(new Jugador("Maximiliano Meza", argentina));
        jugadores.add(new Jugador("Lionel Messi", argentina));
        jugadores.add(new Jugador("Sergio Agüero", argentina));
        jugadores.add(new Jugador("Gonzalo Higuaín", argentina));
        jugadores.add(new Jugador("Paulo Dybala ", argentina));
        jugadores.add(new Jugador("Cristian Pavón", argentina));

        //Islandia
        jugadores.add(new Jugador("Hannes Thor Halldorsson", islandia));
        jugadores.add(new Jugador("Runar Alex Runarsson ", islandia));
        jugadores.add(new Jugador("Frederik Schram", islandia));
        jugadores.add(new Jugador("Kari Arnason", islandia));
        jugadores.add(new Jugador("Ari Freyr Skulason", islandia));
        jugadores.add(new Jugador("Birkir Mar Saevarsson", islandia));
        jugadores.add(new Jugador("Sverrir Ingi Ingason", islandia));
        jugadores.add(new Jugador("Hordur Magnusson", islandia));
        jugadores.add(new Jugador("Holmar Orn Eyjolfsson ", islandia));
        jugadores.add(new Jugador("Ragnar Sigurdsson", islandia));
        jugadores.add(new Jugador("Johann Berg Gudmundsson", islandia));
        jugadores.add(new Jugador("Birkir Bjarnason", islandia));
        jugadores.add(new Jugador("Arnor Ingvi Traustason", islandia));
        jugadores.add(new Jugador("Emil Hallfredsson", islandia));
        jugadores.add(new Jugador("Gylfi Sigurdsson", islandia));
        jugadores.add(new Jugador("Olafur Ingi Skulason", islandia));
        jugadores.add(new Jugador("Rurik Gislason", islandia));
        jugadores.add(new Jugador("Samuel Fridjonsson ", islandia));
        jugadores.add(new Jugador("Aron Gunnarsson", islandia));
        jugadores.add(new Jugador("Alfred Finnbogason", islandia));
        jugadores.add(new Jugador("Bjorn Bergmann Sigurdarson", islandia));
        jugadores.add(new Jugador("Jon Dadi Bodvarsson ", islandia));
        jugadores.add(new Jugador("Albert Gudmundsson", islandia));

        //Croacia
        jugadores.add(new Jugador("Danijel Subasic", croacia));
        jugadores.add(new Jugador("Lovre Kalinic ", croacia));
        jugadores.add(new Jugador("Dominik Livakovic", croacia));
        jugadores.add(new Jugador("Domagoj Vida", croacia));
        jugadores.add(new Jugador("Dejan Lovren", croacia));
        jugadores.add(new Jugador("Sime Vrsaljko", croacia));
        jugadores.add(new Jugador("Josip Pivaric", croacia));
        jugadores.add(new Jugador("Matej Mitrovic", croacia));
        jugadores.add(new Jugador("Ivan Strinic", croacia));
        jugadores.add(new Jugador("Vedran Corluka", croacia));
        jugadores.add(new Jugador("Tin Jedvaj ", croacia));
        jugadores.add(new Jugador("Duje Caleta-Car", croacia));
        jugadores.add(new Jugador("Luka Modric", croacia));
        jugadores.add(new Jugador("Ivan Rakitic", croacia));
        jugadores.add(new Jugador("Milan Badelj", croacia));
        jugadores.add(new Jugador("Filip Bradaric", croacia));
        jugadores.add(new Jugador("Mateo Kovacic ", croacia));
        jugadores.add(new Jugador("Marcelo Brozovic", croacia));
        jugadores.add(new Jugador("Mario Mandzukic", croacia));
        jugadores.add(new Jugador("Ivan Perisic", croacia));
        jugadores.add(new Jugador("Nikola Kalinic", croacia));
        jugadores.add(new Jugador("Andrej Kramaric", croacia));
        jugadores.add(new Jugador("Ante Rebic ", croacia));
        jugadores.add(new Jugador("Marko Pjaca", croacia));

        //Nigeria
        jugadores.add(new Jugador("Ikechukwu Ezenwa", nigeria));
        jugadores.add(new Jugador("Daniel Akpeyi ", nigeria));
        jugadores.add(new Jugador("Francis Uzoho", nigeria));
        jugadores.add(new Jugador("William Troost-Ekong", nigeria));
        jugadores.add(new Jugador("Leon Balogun", nigeria));
        jugadores.add(new Jugador("Kenneth Omeruo", nigeria));
        jugadores.add(new Jugador("Bryan Idowu", nigeria));
        jugadores.add(new Jugador("Chidozie Awaziem", nigeria));
        jugadores.add(new Jugador("Abdullahi Shehu", nigeria));
        jugadores.add(new Jugador("Elderson Echiejile ", nigeria));
        jugadores.add(new Jugador("Tyronne Ebuehi", nigeria));
        jugadores.add(new Jugador("John Obi Mikel", nigeria));
        jugadores.add(new Jugador("Ogenyi Onazi", nigeria));
        jugadores.add(new Jugador("John Ogu", nigeria));
        jugadores.add(new Jugador("Wilfred Ndidi", nigeria));
        jugadores.add(new Jugador("Oghenekaro Etebo ", nigeria));
        jugadores.add(new Jugador("Joel Obi", nigeria));
        jugadores.add(new Jugador("Odion Ighalo", nigeria));
        jugadores.add(new Jugador("Ahmed Musa", nigeria));
        jugadores.add(new Jugador("Victor Moses", nigeria));
        jugadores.add(new Jugador("Alex Iwobi", nigeria));
        jugadores.add(new Jugador("Kelechi Iheanacho ", nigeria));
        jugadores.add(new Jugador("Simeon Nwankwo", nigeria));

        //Brasil
        jugadores.add(new Jugador("Alisson", brasil));
        jugadores.add(new Jugador("Ederson", brasil));
        jugadores.add(new Jugador("Cassio", brasil));
        jugadores.add(new Jugador("Marcelo", brasil));
        jugadores.add(new Jugador("Danilo", brasil));
        jugadores.add(new Jugador("Filipe Luis", brasil));
        jugadores.add(new Jugador("Fagner", brasil));
        jugadores.add(new Jugador("Marquinhos", brasil));
        jugadores.add(new Jugador("Thiago Silva", brasil));
        jugadores.add(new Jugador("Miranda", brasil));
        jugadores.add(new Jugador("Pedro Geromel", brasil));
        jugadores.add(new Jugador("Willian", brasil));
        jugadores.add(new Jugador("Fernandinho", brasil));
        jugadores.add(new Jugador("Paulinho", brasil));
        jugadores.add(new Jugador("Casemiro", brasil));
        jugadores.add(new Jugador("Philippe Coutinho", brasil));
        jugadores.add(new Jugador("Renato Augusto ", brasil));
        jugadores.add(new Jugador("Fred", brasil));
        jugadores.add(new Jugador("Neymar", brasil));
        jugadores.add(new Jugador("Gabriel Jesus", brasil));
        jugadores.add(new Jugador("Roberto Firmino", brasil));
        jugadores.add(new Jugador("Douglas Costa ", brasil));
        jugadores.add(new Jugador("Taison", brasil));

        //Costa Rica
        jugadores.add(new Jugador("Keylor Navas", costaRica));
        jugadores.add(new Jugador("Patrick Pemberton", costaRica));
        jugadores.add(new Jugador("Leonel Moreira", costaRica));
        jugadores.add(new Jugador("Giancarlo González", costaRica));
        jugadores.add(new Jugador("Bryan Oviedo", costaRica));
        jugadores.add(new Jugador("Rónald Matarrita", costaRica));
        jugadores.add(new Jugador("Kendall Watson", costaRica));
        jugadores.add(new Jugador("Ian Smith", costaRica));
        jugadores.add(new Jugador("Cristian Gamboa", costaRica));
        jugadores.add(new Jugador("Óscar Duarte", costaRica));
        jugadores.add(new Jugador("Francisco Calvo", costaRica));
        jugadores.add(new Jugador("Jonnhy Acosta", costaRica));
        jugadores.add(new Jugador("Yeltsin Tejeda", costaRica));
        jugadores.add(new Jugador("Celso Borges", costaRica));
        jugadores.add(new Jugador("David Guzmán", costaRica));
        jugadores.add(new Jugador("Cristian Bolaños", costaRica));
        jugadores.add(new Jugador("Bryan Ruiz", costaRica));
        jugadores.add(new Jugador("Daniel Colindres", costaRica));
        jugadores.add(new Jugador("Rodney Wallace", costaRica));
        jugadores.add(new Jugador("Randall Azofeifa", costaRica));
        jugadores.add(new Jugador("Marco Ureña", costaRica));
        jugadores.add(new Jugador("Joel Campbell", costaRica));
        jugadores.add(new Jugador("Johan Vanegas", costaRica));

        //Serbia
        jugadores.add(new Jugador("Vladimir Stojkovic", serbia));
        jugadores.add(new Jugador("Predrag Rajkovic", serbia));
        jugadores.add(new Jugador("Marko Dmitrovic", serbia));
        jugadores.add(new Jugador("Aleksandar Kolarov", serbia));
        jugadores.add(new Jugador("Branislav Ivanovic", serbia));
        jugadores.add(new Jugador("Dusko Tosic", serbia));
        jugadores.add(new Jugador("Antonio Rukavina", serbia));
        jugadores.add(new Jugador("Milos Veljkovic", serbia));
        jugadores.add(new Jugador("Milan Rodic", serbia));
        jugadores.add(new Jugador("Uros Spajic", serbia));
        jugadores.add(new Jugador("Nikola Milenkovic", serbia));
        jugadores.add(new Jugador("Nemanja Matic", serbia));
        jugadores.add(new Jugador("Luka Milivojevic", serbia));
        jugadores.add(new Jugador("Sergej Milinkovic-Savic", serbia));
        jugadores.add(new Jugador("Marko Grujic", serbia));
        jugadores.add(new Jugador("Adem Ljajic", serbia));
        jugadores.add(new Jugador("Dusan Tadic", serbia));
        jugadores.add(new Jugador("Filip Kostic", serbia));
        jugadores.add(new Jugador("Andrija Zivkovic", serbia));
        jugadores.add(new Jugador("Nemanja Radonjic", serbia));
        jugadores.add(new Jugador("Aleksandar Mitrovic", serbia));
        jugadores.add(new Jugador("Aleksandar Prijovic", serbia));
        jugadores.add(new Jugador("Luka Jovic", serbia));

        //Costa Rica
        jugadores.add(new Jugador("Keylor Navas", costaRica));
        jugadores.add(new Jugador("Patrick Pemberton", costaRica));
        jugadores.add(new Jugador("Leonel Moreira", costaRica));
        jugadores.add(new Jugador("Cristian Gamboa", costaRica));
        jugadores.add(new Jugador("Ian Smith", costaRica));
        jugadores.add(new Jugador("Ronald Matarrita", costaRica));
        jugadores.add(new Jugador("Bryan Oviedo", costaRica));
        jugadores.add(new Jugador("Oscar Duarte", costaRica));
        jugadores.add(new Jugador("Giancarlo Gonzalez", costaRica));
        jugadores.add(new Jugador("Francisco Calvo", costaRica));
        jugadores.add(new Jugador("Kendall Waston", costaRica));
        jugadores.add(new Jugador("Johnny Acosta", costaRica));
        jugadores.add(new Jugador("David Guzman", costaRica));
        jugadores.add(new Jugador("Yeltsin Tejeda", costaRica));
        jugadores.add(new Jugador("Celso Borges", costaRica));
        jugadores.add(new Jugador("Randall Azofeifa", costaRica));
        jugadores.add(new Jugador("Rodne", costaRica));
        jugadores.add(new Jugador("Wallace ", costaRica));
        jugadores.add(new Jugador("Bryan Ruiz", costaRica));
        jugadores.add(new Jugador("Daniel Colindres", costaRica));
        jugadores.add(new Jugador("Christian Bolanos", costaRica));
        jugadores.add(new Jugador("Johan Venegas", costaRica));
        jugadores.add(new Jugador("Joel Campbell ", costaRica));
        jugadores.add(new Jugador("Marco Ureña", costaRica));

        //Alemania
        jugadores.add(new Jugador("Manuel Neuer", alemania));
        jugadores.add(new Jugador("Marc-Andre ter Stegen ", alemania));
        jugadores.add(new Jugador("Kevin Trapp", alemania));
        jugadores.add(new Jugador("Jerome Boateng", alemania));
        jugadores.add(new Jugador("Matthias Ginter", alemania));
        jugadores.add(new Jugador("Jonas Hector", alemania));
        jugadores.add(new Jugador("Mats Hummels", alemania));
        jugadores.add(new Jugador("Joshua Kimmich", alemania));
        jugadores.add(new Jugador("Marvin Plattenhardt", alemania));
        jugadores.add(new Jugador("Antonio Rüdiger ", alemania));
        jugadores.add(new Jugador("Niklas Süle", alemania));
        jugadores.add(new Jugador("Julian Brandt", alemania));
        jugadores.add(new Jugador("Julian Draxler", alemania));
        jugadores.add(new Jugador("Ilkay Gündogan", alemania));
        jugadores.add(new Jugador("Leon Goretzka", alemania));
        jugadores.add(new Jugador("Sami Khedira", alemania));
        jugadores.add(new Jugador("Toni Kroos", alemania));
        jugadores.add(new Jugador("Mesut Özil ", alemania));
        jugadores.add(new Jugador("Sebastian Rudy", alemania));
        jugadores.add(new Jugador("Mario Gomez", alemania));
        jugadores.add(new Jugador("Thomas Müller", alemania));
        jugadores.add(new Jugador("Marco Reus", alemania));
        jugadores.add(new Jugador("Timo Werner", alemania));

        //México
        jugadores.add(new Jugador("Guillermo Ochoa", mexico));
        jugadores.add(new Jugador("Jesús Corona ", mexico));
        jugadores.add(new Jugador("Alfredo Talavera", mexico));
        jugadores.add(new Jugador("Edson Álvarez", mexico));
        jugadores.add(new Jugador("Hugo Ayala", mexico));
        jugadores.add(new Jugador("Jesús Gallardo", mexico));
        jugadores.add(new Jugador("Miguel Layún", mexico));
        jugadores.add(new Jugador("Rafa Márquez", mexico));
        jugadores.add(new Jugador("Héctor Moreno", mexico));
        jugadores.add(new Jugador("Erick Gutiérrez ", mexico));
        jugadores.add(new Jugador("Carlos Salcedo", mexico));
        jugadores.add(new Jugador("Jonathan Dos Santos", mexico));
        jugadores.add(new Jugador("Marco Fabián", mexico));
        jugadores.add(new Jugador("Andrés Guardado", mexico));
        jugadores.add(new Jugador("Héctor Herrera", mexico));
        jugadores.add(new Jugador("Javier Aquino", mexico));
        jugadores.add(new Jugador("Jesús Corona ", mexico));
        jugadores.add(new Jugador("Gio Dos Santos", mexico));
        jugadores.add(new Jugador("Chicharito Hernández", mexico));
        jugadores.add(new Jugador("Raúl Jiménez", mexico));
        jugadores.add(new Jugador("Hirving Lozano", mexico));
        jugadores.add(new Jugador("Oribe Peralta ", mexico));
        jugadores.add(new Jugador("Carlos Vela", mexico));

        //Suecia
        jugadores.add(new Jugador("Robin Olsen", suecia));
        jugadores.add(new Jugador("Karl-Johan Johnsson ", suecia));
        jugadores.add(new Jugador("Kristoffer Nordfeldt", suecia));
        jugadores.add(new Jugador("Mikael Lustig", suecia));
        jugadores.add(new Jugador("Victor Lindelof", suecia));
        jugadores.add(new Jugador("Andreas Granqvist", suecia));
        jugadores.add(new Jugador("Martin Olsson", suecia));
        jugadores.add(new Jugador("Ludwig Augustinsson", suecia));
        jugadores.add(new Jugador("Filip Helander", suecia));
        jugadores.add(new Jugador("Emil Krafth", suecia));
        jugadores.add(new Jugador("Pontus Jansson", suecia));
        jugadores.add(new Jugador("Sebastian Larsson", suecia));
        jugadores.add(new Jugador("Albin Ekdal", suecia));
        jugadores.add(new Jugador("Emil Forsberg", suecia));
        jugadores.add(new Jugador("Gustav Svensson", suecia));
        jugadores.add(new Jugador("Oscar Hiljemark", suecia));
        jugadores.add(new Jugador("Viktor Claesson", suecia));
        jugadores.add(new Jugador("Marcus Rohden", suecia));
        jugadores.add(new Jugador("Jimmy Durmaz", suecia));
        jugadores.add(new Jugador("Marcus Berg", suecia));
        jugadores.add(new Jugador("John Guidetti", suecia));
        jugadores.add(new Jugador("Ola Toivonen", suecia));
        jugadores.add(new Jugador("Isaac Kiese Thelin", suecia));


        //Corea del Sur
        jugadores.add(new Jugador("Kim Seunggyu", coreaDelSur));
        jugadores.add(new Jugador("Kim Jinhyeon ", coreaDelSur));
        jugadores.add(new Jugador("Jo Hyeonwoo", coreaDelSur));
        jugadores.add(new Jugador("Go Yohan", coreaDelSur));
        jugadores.add(new Jugador("Kim Minwoo", coreaDelSur));
        jugadores.add(new Jugador("Kim Younggwon", coreaDelSur));
        jugadores.add(new Jugador("Park Jooho", coreaDelSur));
        jugadores.add(new Jugador("Oh Bansuk", coreaDelSur));
        jugadores.add(new Jugador("Yun Youngsun", coreaDelSur));
        jugadores.add(new Jugador("Lee Yong Jang Hyunsoo", coreaDelSur));
        jugadores.add(new Jugador("Jeong Seunghyeon", coreaDelSur));
        jugadores.add(new Jugador("Hong Chul", coreaDelSur));
        jugadores.add(new Jugador("Koo Jacheol", coreaDelSur));
        jugadores.add(new Jugador("Ki Sungyeong", coreaDelSur));
        jugadores.add(new Jugador("Moon Seonmin", coreaDelSur));
        jugadores.add(new Jugador("Lee Seungwoo", coreaDelSur));
        jugadores.add(new Jugador("Lee Jaesung", coreaDelSur));
        jugadores.add(new Jugador("Jeong Wooyoung ", coreaDelSur));
        jugadores.add(new Jugador("Ju Sejong", coreaDelSur));
        jugadores.add(new Jugador("Kim Shinwook", coreaDelSur));
        jugadores.add(new Jugador("Son Heungmin ", coreaDelSur));
        jugadores.add(new Jugador("Hwang Heechan", coreaDelSur));

        //Inglaterra
        jugadores.add(new Jugador("Jordan Pickford", inglaterra));
        jugadores.add(new Jugador("Nick Pope", inglaterra));
        jugadores.add(new Jugador("Jack Butland", inglaterra));
        jugadores.add(new Jugador("Kyle Walker", inglaterra));
        jugadores.add(new Jugador("Kieran Trippier", inglaterra));
        jugadores.add(new Jugador("Trent Alexander-Arnold", inglaterra));
        jugadores.add(new Jugador("Gary Cahill", inglaterra));
        jugadores.add(new Jugador("Danny Rose", inglaterra));
        jugadores.add(new Jugador("John Stones", inglaterra));
        jugadores.add(new Jugador("Harry Maguire", inglaterra));
        jugadores.add(new Jugador("Phil Jones", inglaterra));
        jugadores.add(new Jugador("Ashley Young", inglaterra));
        jugadores.add(new Jugador("Eric Dier", inglaterra));
        jugadores.add(new Jugador("Fabian Delph", inglaterra));
        jugadores.add(new Jugador("Jordan Henderson", inglaterra));
        jugadores.add(new Jugador("Dele Alli", inglaterra));
        jugadores.add(new Jugador("Ruben Loftus-Cheek", inglaterra));
        jugadores.add(new Jugador("Raheem Sterling", inglaterra));
        jugadores.add(new Jugador("Jesse Lingard", inglaterra));
        jugadores.add(new Jugador("Harry Kane", inglaterra));
        jugadores.add(new Jugador("Jamie Vardy", inglaterra));
        jugadores.add(new Jugador("Marcus Rashford", inglaterra));
        jugadores.add(new Jugador("Danny Welbeck", inglaterra));

        //Túnez
        jugadores.add(new Jugador("Aymen Mathlouthi", tunez));
        jugadores.add(new Jugador("Mouez Hassen ", tunez));
        jugadores.add(new Jugador("Farouk Ben Mustapha", tunez));
        jugadores.add(new Jugador("Yassine Meriah", tunez));
        jugadores.add(new Jugador("Syam Ben Youssef", tunez));
        jugadores.add(new Jugador("Beb Alouane Yohan", tunez));
        jugadores.add(new Jugador("Bedoui Rami", tunez));
        jugadores.add(new Jugador("Ali Maaloul", tunez));
        jugadores.add(new Jugador("Khalil Chemmam", tunez));
        jugadores.add(new Jugador("Oussama Haddadi ", tunez));
        jugadores.add(new Jugador("Dylan Bronn", tunez));
        jugadores.add(new Jugador("Ellyes Skhiri", tunez));
        jugadores.add(new Jugador("Ferjani Sassi", tunez));
        jugadores.add(new Jugador("Ahmed Khalil", tunez));
        jugadores.add(new Jugador("Ben Amour Mohamed", tunez));
        jugadores.add(new Jugador("Mohamed Larbi", tunez));
        jugadores.add(new Jugador("Anice Badri ", tunez));
        jugadores.add(new Jugador("Saif-Eddine Khaoui", tunez));
        jugadores.add(new Jugador("Saber Khalifa", tunez));
        jugadores.add(new Jugador("Naim Sliti", tunez));
        jugadores.add(new Jugador("Fakhreddine Ben Youssef", tunez));
        jugadores.add(new Jugador("Wahbi Khazri ", tunez));
        jugadores.add(new Jugador("Bassem Srarfi", tunez));

        //Bélgica
        jugadores.add(new Jugador("Koen Casteels", belgica));
        jugadores.add(new Jugador("Thibaut Courtois ", belgica));
        jugadores.add(new Jugador("Simon Mignolet", belgica));
        jugadores.add(new Jugador("Toby Alderweireld", belgica));
        jugadores.add(new Jugador("Dedryck Boyata", belgica));
        jugadores.add(new Jugador("Vincent Kompany", belgica));
        jugadores.add(new Jugador("Thomas Meunier", belgica));
        jugadores.add(new Jugador("Thomas Vermaelen ", belgica));
        jugadores.add(new Jugador("Jan Vertonghen", belgica));
        jugadores.add(new Jugador("Nacer Chadli", belgica));
        jugadores.add(new Jugador("Kevin De Bruyne", belgica));
        jugadores.add(new Jugador("Mousa Dembele", belgica));
        jugadores.add(new Jugador("Leander Dendoncker", belgica));
        jugadores.add(new Jugador("Marouane Fellaini", belgica));
        jugadores.add(new Jugador("Youri Tielemans ", belgica));
        jugadores.add(new Jugador("Axel Witsel", belgica));
        jugadores.add(new Jugador("Michy Batshuayi", belgica));
        jugadores.add(new Jugador("Yannick Carrasco", belgica));
        jugadores.add(new Jugador("Eden Hazard", belgica));
        jugadores.add(new Jugador("Thorgan Hazard", belgica));
        jugadores.add(new Jugador("Adnan Januzaj", belgica));
        jugadores.add(new Jugador("Romelu Lukaku ", belgica));
        jugadores.add(new Jugador("Dries Mertens", belgica));

        //Panamá
        jugadores.add(new Jugador("José Calderón", panama));
        jugadores.add(new Jugador("Jaime Penedo ", panama));
        jugadores.add(new Jugador("Alex Rodríguez", panama));
        jugadores.add(new Jugador("Azmahar Ariano", panama));
        jugadores.add(new Jugador("Felipe Baloy", panama));
        jugadores.add(new Jugador("Harold Cummings", panama));
        jugadores.add(new Jugador("Eric Davis", panama));
        jugadores.add(new Jugador("Fidel Escobar", panama));
        jugadores.add(new Jugador("Adolfo Machado", panama));
        jugadores.add(new Jugador("Michael Murillo", panama));
        jugadores.add(new Jugador("Luis Ovalle", panama));
        jugadores.add(new Jugador("Román Torres", panama));
        jugadores.add(new Jugador("Edgar Barcenas", panama));
        jugadores.add(new Jugador("Armando Cooper", panama));
        jugadores.add(new Jugador("Aníbal Godoy", panama));
        jugadores.add(new Jugador("Gabriel Gómez", panama));
        jugadores.add(new Jugador("Valentín Pimentel", panama));
        jugadores.add(new Jugador("Alberto Quintero", panama));
        jugadores.add(new Jugador("José Luis Rodríguez", panama));
        jugadores.add(new Jugador("Abdiel Arroyo", panama));
        jugadores.add(new Jugador("Ismael Díaz", panama));
        jugadores.add(new Jugador("Blas Pérez", panama));
        jugadores.add(new Jugador("Luis Tejada", panama));
        jugadores.add(new Jugador("Gabriel Torres", panama));

        //Polonia
        jugadores.add(new Jugador("Bartosz Białkowski", polonia));
        jugadores.add(new Jugador("Łukasz Fabiański ", polonia));
        jugadores.add(new Jugador("Wojciech Szczęsny", polonia));
        jugadores.add(new Jugador("Jan Bednarek", polonia));
        jugadores.add(new Jugador("Bartosz Bereszyński", polonia));
        jugadores.add(new Jugador("Thiago Cionek", polonia));
        jugadores.add(new Jugador("Kamil Glik", polonia));
        jugadores.add(new Jugador("Artur Jędrzejczyk", polonia));
        jugadores.add(new Jugador("Michał Pazdan ", polonia));
        jugadores.add(new Jugador("Łukasz Piszczek", polonia));
        jugadores.add(new Jugador("Jakub Błaszczykowski", polonia));
        jugadores.add(new Jugador("Jacek Góralski", polonia));
        jugadores.add(new Jugador("Kamil Grosicki", polonia));
        jugadores.add(new Jugador("Grzegorz Krychowiak", polonia));
        jugadores.add(new Jugador("Rafał Kurzawa", polonia));
        jugadores.add(new Jugador("Karol Linetty", polonia));
        jugadores.add(new Jugador("Sławomir Peszko", polonia));
        jugadores.add(new Jugador("Maciej Rybus", polonia));
        jugadores.add(new Jugador("Piotr Zieliński ", polonia));
        jugadores.add(new Jugador("Dawid Kownacki", polonia));
        jugadores.add(new Jugador("Robert Lewandowski", polonia));
        jugadores.add(new Jugador("Arkadiusz Milik ", polonia));
        jugadores.add(new Jugador("Łukasz Teodorczyk", polonia));

        //Colombia
        jugadores.add(new Jugador("David Ospina", colombia));
        jugadores.add(new Jugador("Camilo Vargas ", colombia));
        jugadores.add(new Jugador("Jose Fernando Cuadrado", colombia));
        jugadores.add(new Jugador("Cristian Zapata", colombia));
        jugadores.add(new Jugador("Davinson Sanchez", colombia));
        jugadores.add(new Jugador("Santiago Arias", colombia));
        jugadores.add(new Jugador("Oscar Murillo", colombia));
        jugadores.add(new Jugador("Johan Mojica ", colombia));
        jugadores.add(new Jugador("Yerr", colombia));
        jugadores.add(new Jugador("Mina", colombia));
        jugadores.add(new Jugador("Wilmar Barrios", colombia));
        jugadores.add(new Jugador("Carlos Sanchez", colombia));
        jugadores.add(new Jugador("Jefferson Lerma", colombia));
        jugadores.add(new Jugador("James Rodriguez", colombia));
        jugadores.add(new Jugador("Abel Aguilar", colombia));
        jugadores.add(new Jugador("Mateus Uribe", colombia));
        jugadores.add(new Jugador("Juan Fernando Quintero ", colombia));
        jugadores.add(new Jugador("Juan Guillermo Cuadrado", colombia));
        jugadores.add(new Jugador("Radamel Falcao Garcia", colombia));
        jugadores.add(new Jugador("Miguel Borja", colombia));
        jugadores.add(new Jugador("Carlos Bacca ", colombia));
        jugadores.add(new Jugador("Luis Fernando Muriel", colombia));
        //Senegal
        jugadores.add(new Jugador("Abdoulaye Diallo", senegal));
        jugadores.add(new Jugador("Khadim Ndiaye ", senegal));
        jugadores.add(new Jugador("Alfred Gomis", senegal));
        jugadores.add(new Jugador("Kalidou Koulibal", senegal));
        jugadores.add(new Jugador("Lamine Gassama", senegal));
        jugadores.add(new Jugador("Kara Mbodj", senegal));
        jugadores.add(new Jugador("Moussa Wagué", senegal));
        jugadores.add(new Jugador("Youssouf Sabaly", senegal));
        jugadores.add(new Jugador("Saliou Ciss", senegal));
        jugadores.add(new Jugador("Salif Sané", senegal));
        jugadores.add(new Jugador("Pape Alioune Ndiaye", senegal));
        jugadores.add(new Jugador("Idrissa Gana Gueye", senegal));
        jugadores.add(new Jugador("Cheikhou Kouyaté", senegal));
        jugadores.add(new Jugador("Cheikh Ndoye", senegal));
        jugadores.add(new Jugador("Alfred Ndiaye", senegal));
        jugadores.add(new Jugador("Sadio Mané", senegal));
        jugadores.add(new Jugador("Keita Baldé Diao", senegal));
        jugadores.add(new Jugador("Diafra Sakho", senegal));
        jugadores.add(new Jugador("Moussa Konaté", senegal));
        jugadores.add(new Jugador("Ismaila Sarr", senegal));
        jugadores.add(new Jugador("Mbaye Niang", senegal));
        jugadores.add(new Jugador("Moussa Sow ", senegal));
        jugadores.add(new Jugador("Mame Biram Diouf", senegal));

        //Japón
        jugadores.add(new Jugador("Eiji Kawashima", japon));
        jugadores.add(new Jugador("Masaaki Higashiguchi ", japon));
        jugadores.add(new Jugador("Kosuke Nakamura", japon));
        jugadores.add(new Jugador("Yuto Nagatomo", japon));
        jugadores.add(new Jugador("Tomoaki Makino", japon));
        jugadores.add(new Jugador("Maya Yoshida", japon));
        jugadores.add(new Jugador("Hiroki Sakai", japon));
        jugadores.add(new Jugador("Gotoku Sakai", japon));
        jugadores.add(new Jugador("Gen Shoji", japon));
        jugadores.add(new Jugador("Wataru Endo ", japon));
        jugadores.add(new Jugador("Naomichi Ueda", japon));
        jugadores.add(new Jugador("Makoto Hasebe", japon));
        jugadores.add(new Jugador("Keisuke Honda", japon));
        jugadores.add(new Jugador("Takashi Inui", japon));
        jugadores.add(new Jugador("Hotaru Yamaguchi", japon));
        jugadores.add(new Jugador("Shinji Kagawa", japon));
        jugadores.add(new Jugador("Genki Haraguchi", japon));
        jugadores.add(new Jugador("Takashi Usami", japon));
        jugadores.add(new Jugador("Gaku Shibasaki ", japon));
        jugadores.add(new Jugador("Ryota Ohshima", japon));
        jugadores.add(new Jugador("Shinji Okazaki", japon));
        jugadores.add(new Jugador("Yuya Osako", japon));
        jugadores.add(new Jugador("Yoshinori Muto", japon));

        return jugadores;
    }

    private void cargarJugadoresEnBaseDeDatos(List<Jugador> jugadores){
        for(Jugador jugador : jugadores){
            jugadorDao.guardarJugadorEnBaseDeDatos(jugador);
        }
    }
}
