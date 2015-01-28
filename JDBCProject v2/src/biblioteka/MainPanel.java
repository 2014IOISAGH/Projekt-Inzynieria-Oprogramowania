package biblioteka;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainPanel extends JFrame
{
	public MainPanel()
	{
		setTitle("Biblioteka");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		initKsiazkaTextBox();
		initLocation();
	
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	protected void initKsiazkaTextBox()
	{
		tytulKsiazki = new JTextField();
		autorKsiazki = new JTextField();
		imieCzytelnika = new JTextField();
		nazwiskoCzytelnika = new JTextField();
		peselCzytelnika = new JTextField();
		idCzytelnika = new JTextField();
		idKsiazki = new JTextField();
		idCzytelnikaDoUsuniecia = new JTextField();
		idKsiazkiDoUsuniecia = new JTextField();
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(26,1));
		northPanel.add(new JLabel("Tytul ksiazki:", SwingConstants.CENTER));
		northPanel.add(tytulKsiazki);
		northPanel.add(new JLabel("Autor ksiazki:", SwingConstants.CENTER));
		northPanel.add(autorKsiazki);
		dodajKsiazke = new JButton("Dodaj ksia¿ke");
		northPanel.add(dodajKsiazke);
		northPanel.add(new JLabel("Imie czytelnika:", SwingConstants.CENTER));
		northPanel.add(imieCzytelnika);
		northPanel.add(new JLabel("Nazwisko czytelnika:", SwingConstants.CENTER));
		northPanel.add(nazwiskoCzytelnika);
		northPanel.add(new JLabel("Pesel czytelnika:", SwingConstants.CENTER));
		northPanel.add(peselCzytelnika);
		dodajCzytelnika = new JButton("Dodaj czytelnika");
		northPanel.add(dodajCzytelnika);
		wyswietlBaze = new JButton("Wyswietl baze");
		northPanel.add(wyswietlBaze);
		northPanel.add(new JLabel("Id czytelnika:", SwingConstants.CENTER));
		northPanel.add(idCzytelnika);
		northPanel.add(new JLabel("Id ksiazki:", SwingConstants.CENTER));
		northPanel.add(idKsiazki);
		rezerwacja = new JButton("Wypozycz ksiazke");
		northPanel.add(rezerwacja);
		//add(northPanel ,BorderLayout.NORTH);
		
		northPanel.add(new JLabel("Usuwanie rezerwacji:", SwingConstants.CENTER));
		northPanel.add(new JLabel("Id czytelnika:", SwingConstants.CENTER));
		northPanel.add(idCzytelnikaDoUsuniecia);
		northPanel.add(new JLabel("Id ksiazki:", SwingConstants.CENTER));
		northPanel.add(idKsiazkiDoUsuniecia);
		usunRezerwacje = new JButton("Usun rezerwacje");
		northPanel.add(usunRezerwacje);
		add(northPanel ,BorderLayout.NORTH);
	}
	
	
	protected void initButton(String nazwa)
	{
		JPanel southPanel = new JPanel();
		dodajKsiazke = new JButton(nazwa);
		southPanel.add(dodajKsiazke);
		add(southPanel, BorderLayout.SOUTH);
	}
	
	protected void initLocation()
	{
		setLocation(400,200);
		setVisible(true);
		setResizable(false);
	}
	
	
	public void addDodajKsiazkeListener(ActionListener listener)
	{
		this.dodajKsiazke.addActionListener(listener);
	}
	
	public void addDodajCzytelnikaListener(ActionListener listener)
	{
		this.dodajCzytelnika.addActionListener(listener);
	}
	
	public void showBaseListener(ActionListener listener)
	{
		this.wyswietlBaze.addActionListener(listener);
	}
	
	public void rezerwacjaListener(ActionListener listener)
	{
		this.rezerwacja.addActionListener(listener);
	}
	
	public void usunRezerwacjeListener(ActionListener listener)
	{
		this.usunRezerwacje.addActionListener(listener);
	}
	
	public String getTytulKsiazki()
	{
		return this.tytulKsiazki.getText();
	}
	
	public String getAutorKsiazki()
	{
		return this.autorKsiazki.getText();
	}
	public String getImieCzytelnika()
	{
		return this.imieCzytelnika.getText();
	}
	
	public String getNazwiskoCzytelnika()
	{
		return this.nazwiskoCzytelnika.getText();
	}
	public String getPeselCzytelnika()
	{
		return this.peselCzytelnika.getText();
	}
	public String getIdCzytelnika()
	{
		return this.idCzytelnika.getText();
	}
	public String getIdKsiazki()
	{
		return this.idKsiazki.getText();
	}
	
	public String getIdCzytelnikaDoUsuniecia()
	{
		return this.idCzytelnikaDoUsuniecia.getText();
	}
	public String getIdKsiazkiDoUsuniecia()
	{
		return this.idKsiazkiDoUsuniecia.getText();
	}
	
	private JTextField tytulKsiazki;
	private JTextField autorKsiazki;
	
	private JTextField imieCzytelnika;
	private JTextField nazwiskoCzytelnika;
	private JTextField peselCzytelnika;
	
	private JTextField idCzytelnika;
	private JTextField idKsiazki;
	
	private JTextField idCzytelnikaDoUsuniecia;
	private JTextField idKsiazkiDoUsuniecia;
	
	private JButton dodajKsiazke;
	private JButton dodajCzytelnika;
	private JButton wyswietlBaze;
	private JButton rezerwacja;
	private JButton usunRezerwacje;
	
	protected static int DEFAULT_WIDTH = 400;
	protected static int DEFAULT_HEIGHT = 700;
}

