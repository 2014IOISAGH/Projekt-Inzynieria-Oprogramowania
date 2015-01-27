
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.List;
 



import javax.swing.JOptionPane;

import model.Czytelnik;
import model.Ksiazka;
import model.Wypozyczenie;
import biblioteka.Biblioteka;
import biblioteka.MainPanel;
 
public class JdbcTest {
 
    public static void main(String[] args) {
    	
    	new JdbcTest();
    }
	private List<Czytelnik> czytelnicy;
	private List<Ksiazka> ksiazki;
	private List<Wypozyczenie> rezerwacje;
    
    public JdbcTest()
    {

       b = new Biblioteka();
     
        
        panelDodawania = new MainPanel();
       
    	//DodajKsiazkeAction action = singleInstance.DodajKsiazkeAction;
    	panelDodawania.addDodajKsiazkeListener(new DodajKsiazkeAction());
    	panelDodawania.setVisible(true);
    	panelDodawania.addDodajCzytelnikaListener(new DodajCzytelnikaAction());
    	//dodawanieCzytelnika.setVisible(true);
    	panelDodawania.showBaseListener(new wyswietlajBazeAction());
    	panelDodawania.rezerwacjaListener(new DodajRezerwacjeAction());
    	panelDodawania.usunRezerwacjeListener(new UsunRezerwacjeAction());
    	//dodawanieKsiazki.setVisible(true);
        
        
 
        //b.closeConnection();
    }
    
    private void printData()
    {
    	czytelnicy = b.selectCzytelnicy();
        ksiazki = b.selectKsiazki();
        rezerwacje = b.selectRezerwacja();
    	
    	System.out.println("Lista czytelników: ");
        for(Czytelnik c: czytelnicy)
            System.out.println(c);
 
        System.out.println("Lista ksi¹¿ek:");
        for(Ksiazka k: ksiazki)
            System.out.println(k);
        
        System.out.println("Lista ksi¹¿ek:");
        for(Ksiazka k: ksiazki)
            System.out.println(k);
        
        System.out.println("Lista rezerwacji:");
        System.out.println("[id_rezerwacji] - id_czytelnika - id_ksiazki");
        for(Wypozyczenie r: rezerwacje)
            System.out.println(r);
        
    }
    
    private class DodajKsiazkeAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			b.insertKsiazka(panelDodawania.getTytulKsiazki(), panelDodawania.getAutorKsiazki());
			//printData();
		}
		
	}
    private class DodajCzytelnikaAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			b.insertCzytelnik(panelDodawania.getImieCzytelnika(), panelDodawania.getNazwiskoCzytelnika(), panelDodawania.getPeselCzytelnika());
			//printData();
		}
		
	}
    private class wyswietlajBazeAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			printData();
		}
		
	}
    
    private class DodajRezerwacjeAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			b.insertWypozycz(Integer.parseInt(panelDodawania.getIdCzytelnika()), 
					Integer.parseInt(panelDodawania.getIdKsiazki()));
			//printData();
		}
		
	}
    
    private class UsunRezerwacjeAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			b.deleteWypozycz(Integer.parseInt(panelDodawania.getIdCzytelnikaDoUsuniecia()), 
					Integer.parseInt(panelDodawania.getIdKsiazkiDoUsuniecia()));
			//printData();
		}
		
	}
    
    private MainPanel panelDodawania;
    private Biblioteka b;
}
