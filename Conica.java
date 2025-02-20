import java.awt.*;  
import java.net.URL;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Conica extends Frame{   
	Toolkit tool;
	int ww, hh;  
	public Image backg, info;
	
	public MainPanel mainPanel;
	public SimPanel simPanel;  
	public InfoPanel infoPanel;
	
	Font f=new Font("TimesRoman", 1,12);
	public TextField Tf1, Tf2, Tf3, Tf4, Tf5, Tf6;   // casetele de text pt.valorile coeficientilor
	Button start ; 
	
	public static void main(String args[])
	{ new Conica();}
	
	public Conica()
	{
		tool=getToolkit();
		Dimension res=tool.getScreenSize();
		ww= res.width;
		hh= res.height;
		setResizable(false);
		setTitle("Conica de ecuatie generala");
		setIconImage(tool.getImage(GetResources("images/ico.gif")));
		setBackground(new Color(255, 255, 255));   //culoarea simPanel este alba in backg 
		setLayout(null);
		loadImage(); 
		
		
		mainPanel= new MainPanel(this);  //panel cu cele 6 casete de text si butonul deseneaza
		add(mainPanel);
		mainPanel.setBounds(25,100,600,275);
		
		infoPanel= new InfoPanel(this);    //panel cu detalii despre conica
		add(infoPanel);
		infoPanel.setBounds(25,380,600,275);
		
		simPanel= new SimPanel(this);   //panel in care se deseneaza graficul conicei
		add(simPanel);
		simPanel.setBounds(645,100,600,600);  
		
		setSize(ww,hh);
		setLocation(0,0);
		setVisible(true);
		
		Tf1=new TextField();
		Tf1.setForeground(Color.black);  
		Tf1.setFont(f);
		Tf1.requestFocus(); 
		mainPanel.add( Tf1 );
		
		Tf2=new TextField();
		Tf2.setForeground(Color.black);  
		Tf2.setFont(f);
		mainPanel.add( Tf2 );
		
     	Tf3=new TextField();
		Tf3.setForeground(Color.black);  
		Tf3.setFont(f);
		mainPanel.add( Tf3 );
		
		Tf4=new TextField();
		Tf4.setForeground(Color.black);  
		Tf4.setFont(f);
		mainPanel.add( Tf4 );
		
		Tf5=new TextField();
		Tf5.setForeground(Color.black);  
		Tf5.setFont(f);
		mainPanel.add( Tf5 );
		
		
	    Tf6=new TextField();
		Tf6.setForeground(Color.black); 
		Tf6.setFont(f);
		mainPanel.add( Tf6 );
		  
		 start= new Button("Deseneaza");	
	     mainPanel.add(start);
		 start.setBounds(300,150, 80, 30); //pozitia, lungimea si latimea
		 
		start.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  simPanel.simulare(Tf1.getText(), Tf2.getText(),Tf3.getText(),Tf4.getText(),Tf5.getText(),Tf6.getText());
             }
        });
		  
}
	
	public java.net.URL GetResources(String s)
	{return  this.getClass().getResource(s);}
	
	public void loadImage()
	{
		try {
			MediaTracker mediatracker = new MediaTracker(this);
			backg= tool.getImage(GetResources("images/backg.jpg"));
			mediatracker.addImage(backg, 0);
			mediatracker.waitForAll();
		}
		catch(Throwable throwable) {}
	}
		
		public void paint(Graphics g)
		{
			for(int i=0; i<=(int)(ww/200); i++)
				for(int j=0; j<=(int)(hh/20);j++)
					g.drawImage(backg, i*200, j*200, this);
				
				g.setColor(Color.black);
				g.setFont(f);
				
				g.drawImage(info, 655, 135, this);
				
		}
		
/* 	 public boolean handleEvent(Event e)
    {
	 	 
		 if(e.id==Event.WINDOW_DESTROY){System.exit(0);} 
          switch(e.id)
		{
			default: break;
			case 1001:
			if(e.target == start)
          simPanel.simulare(Tf1.getText(), Tf2.getText(),Tf3.getText(),Tf4.getText(),Tf5.getText(),Tf6.getText());
		break;
		}
		return super.handleEvent(e);  
	} */

}

class MainPanel extends Panels
{
	Conica conica;
	 Font f;
	 Color color1= Color.black;  //culoarea literelor 
		 
	public MainPanel( Conica conica)
	{ super(conica.backg);
	  this.f=conica.f;
	  this.conica=conica;
	 }
	 	
	public void paint(Graphics g)
	 {
		 super.paint(g);
		 g.setFont(f);
		 int w=25;
		 
		 g.setColor(color1);
		 g.drawString("Coeficientii :", w, 30);
	     g.drawString("a11: ", w, 60);
	     g.drawString("a12: ", w, 90);	
	     g.drawString("a22: ", w,  120);	
         g.drawString("a13: ", w,  150);		
         g.drawString("a23: ", w,  180);			
		 g.drawString("a33: ", w,  210);	
		 
		 conica.Tf1.setBounds(75,33, 80,25);
		 conica.Tf2.setBounds(75, 66, 80,25);
	     conica.Tf3.setBounds(75, 99, 80,25);
	   	 conica.Tf4.setBounds(75, 132, 80,25);
		 conica.Tf5.setBounds(75, 165, 80,25);
		 conica.Tf6.setBounds(75, 198, 80,25);
	 }

}
	
 class InfoPanel extends Panels   //panel cu explicatii despre conica
 {
	 Conica conica;
	 Font f;
	 Color col1= Color.black;  //culoare litere

	 public String gen_conica, tip_conica;
	 public String nume_conica; 
	 public static int cent_x, cent_y;
	 public String traceA, val_detA, val_deltaD;

	 public InfoPanel( Conica conica)
	 {
		 super(conica.backg);
		 this.f=conica.f;
		 
		 gen_conica=" " ;
		 tip_conica= " ";
		 nume_conica= " " ;
		 cent_x = 0; cent_y=0; 
		 traceA= " " ;
		 val_detA=" " ;
		 val_deltaD=" " ;
		
	 }
	 
	 public void paint(Graphics g)
	 {
		 super.paint(g);
		 g.setFont(f);
		 int w=25;
		 int k=25;
		 
		 g.setColor(col1);
		 g.drawString("Denumire conica: ", w, 25);  
		 g.drawString("" +  this.nume_conica, w+250, 25+3*k);
		 g.drawString("Tipul conicei : ", w, 50 +3* k);
		 g.drawString("" + this.tip_conica, w+250, 50+3*k);
		 g.drawString("Genul conicei : ", w, 75 + 3* k);
		 g.drawString("" + this.gen_conica, w+250,75+3*k);
		 g.drawString("Centrul conicei: ", w, 100 + 3*k);
		 g.drawString("(" + this.cent_x + "," + this.cent_y + ")", w+250, 100+3*k);
		 g.drawString("TraceA:" , w, 125+3*k);
		 g.drawString("" +this.traceA, w+250, 125+3*k);
		 g.drawString("Val_detA:" , w, 150+3*k);
		 g.drawString("" +this.val_detA, w+250, 150+3*k);
		 g.drawString("Val_deltaD:" , w, 175+3*k);
		 g.drawString("" +this.val_deltaD, w+250, 175+3*k);
		 
		 
	 }
	 
	 public void setInfo(int a11, int a12,int a22,int a13,int a23, int a33)
	 {
		int I=a11+a22;   //I=trace A
		int detA= a11*a22-((a12/2)*(a12/2));   //det matricii A
	    int deltaD= a11*a22*a33+(a12/2)*(a23/2)*(a13/2)+(a12/2)*(a23/2)*(a13/2)-((a13/2)*a22*(a13/2))-(a11*(a23/2)*(a23/2))-((a12/2)*(a12/2)*a33);
		
		int transpusaD= I*deltaD;
		
		if(detA > 0  && deltaD!=0 && transpusaD < 0)
		{   
         	nume_conica="Elipsa";
			gen_conica="eliptic";
			tip_conica="Nedegenerat";
		    traceA=String.valueOf(I);
			val_detA=String.valueOf(detA);
			val_deltaD=String.valueOf(deltaD);
	
     	//aflam coodonatele centrului elipsei
		    cent_x= (a22*(a13/2) - (a12/2)*(a23/2)) /(((a12/2)*(a12/2)) - a11*a22);
		    cent_y= (a11*(a23/2) - (a12/2)*(a13/2)) / (((a12/2)*(a12/2)) - a11*a22);        
			 
		}
	
     	if(detA > 0  && deltaD!=0 && transpusaD > 0)
		{  
	        nume_conica="elipsa imaginara";
			gen_conica="eliptic";
			tip_conica="nedegenerat";
		    traceA=String.valueOf(I);
			val_detA=String.valueOf(detA);
			val_deltaD=String.valueOf(deltaD);
			 
		    cent_x= (a22*(a13/2) - (a12/2)*(a23/2)) /(((a12/2)*(a12/2)) - a11*a22);
		    cent_y= (a11*(a23/2) - (a12/2)*(a13/2)) / (((a12/2)*(a12/2)) - a11*a22);        
		}
		
		if(detA > 0  && deltaD==0)
		{  
	        nume_conica="punct dublu";
			gen_conica="eliptic";
			tip_conica="degenerat";
			traceA=String.valueOf(I);
			val_detA=String.valueOf(detA);
		    val_deltaD=String.valueOf(deltaD);
		}
		
		if(detA < 0  && deltaD!=0)
		{  
	        nume_conica="hiperbola";
			gen_conica="hiperbolic";
			tip_conica="nedegenerat";
			traceA=String.valueOf(I);
			val_detA=String.valueOf(detA);
			val_deltaD=String.valueOf(deltaD);
			 
		 //aflam coodonatele centrului hiperbolei
		    cent_x= (a22*(a13/2) - (a12/2)*(a23/2)) /(((a12/2)*(a12/2)) - a11*a22);
		    cent_y= (a11*(a23/2) - (a12/2)*(a13/2)) / (((a12/2)*(a12/2)) - a11*a22);     
		}
		
	      if(detA < 0  && deltaD==0)
		{  
	        nume_conica="drepte concurente";
			gen_conica="hiperbolic";
			tip_conica="degenerat";
			 traceA=String.valueOf(I);
			 val_detA=String.valueOf(detA);
			 val_deltaD=String.valueOf(deltaD);
		}
		
		   if(detA == 0  && deltaD!=0)
		{  
	        nume_conica="parabola";
			gen_conica="parabolic";
			tip_conica="nedegenerat";
			 traceA=String.valueOf(I);
			 val_detA=String.valueOf(detA);
			 val_deltaD=String.valueOf(deltaD);
		}
		   if(detA == 0  && deltaD==0 )
		{  
	        nume_conica="drepte paralele, duble sau paralele imaginare";
			gen_conica="parabolic";
			tip_conica="degenerat";
			traceA=String.valueOf(I);
			val_detA=String.valueOf(detA);
			val_deltaD=String.valueOf(deltaD);
		}
		repaint();
	 }
 }
 
  //panel in care se fac calculele despre conica pt a afisa graficul conicei 

    class SimPanel extends Panel{    
		Conica conica;
		Color col = Color.red;  //culoarea pentru desenul conicei
	    int a11,a12, a22, a13,a23,a33 ;
		boolean desenareActiva = false; // flag: false = nu se deseneaza, true = se deseneaza
		
	public SimPanel(Conica conica)
	{
		new Panels(conica.backg);
		this.conica= conica;
	}
	
     public void simulare(String nr1, String nr2, String nr3, String nr4, String nr5, String nr6)
	{
		try 
		{
			a11= Integer.parseInt(nr1);
			a12= Integer.parseInt(nr2);
			a22= Integer.parseInt(nr3);
			a13= Integer.parseInt(nr4);
			a23= Integer.parseInt(nr5);
		    a33= Integer.parseInt(nr6);
	    }catch(NumberFormatException e){}
		
	   desenareActiva = true; // setam flag-ul la true dupa ce am primit coeficientii
	   simulare(a11,a12,a22,a13,a23,a33);
	}
	void simulare(int nr1, int nr2, int nr3, int nr4, int nr5, int nr6)
	{
		repaint();
	}
	
	public void paint(Graphics g)
	{
			 super.paint(g);
		     g.setColor(Color.black);
			 
	    	//axele de coordonate Ox si Oy  
		  g.drawLine(0,300,600,300);  
		  g.drawLine(300,0,300,600);
		  
		  //sagetile de la cele doua axe de coordonate
		  g.drawLine(300,0,295,10);
		  g.drawLine(300,0,305,10);
		  g.drawLine(600,300,590,295);
		  g.drawLine(600,300,590,305);
		  
		 conica.infoPanel.setInfo( a11, a12, a22,a13, a23,  a33);
		 g.setColor(col); //rosu pt conica
		 
		//Afisare ecuatie conica in panou
        g.drawString("Ecuatia conicei este:", 30, 30);
        g.drawString(getEquationString(), 30, 50);

			
		// Desenam conica doar daca flag-ul este activ
        if (desenareActiva) {
            double k = 0.01;
		// Eliminam verificarea coeficientilor pentru desen
		for(double x = -26.5; x <= 26; x += k) {
			for(double y = -21; y <= 21; y += k) {
				double ec = a11 * x * x + a12 * x * y + a22 * y * y + a13 * x + a23 * y + a33;
				if (Math.abs(ec) < 0.1) {
					g.fillOval((int) Math.round(300 + x * 10), (int) Math.round(300 - y * 10), 4, 4);
				}
			}
		}
		}
	}
	  // Metoda care genereaza sirul ecuatiei conicei in format frumos
     private String getEquationString() {
        StringBuilder eq = new StringBuilder();
        
        if (a11 != 0) eq.append(a11).append("x^2 ");
        if (a12 != 0) eq.append(formatTerm(a12, "xy"));
        if (a22 != 0) eq.append(formatTerm(a22, "y^2"));
        if (a13 != 0) eq.append(formatTerm(a13, "x"));
        if (a23 != 0) eq.append(formatTerm(a23, "y"));
        if (a33 != 0) eq.append(formatTerm(a33, ""));
        
        return eq.toString().trim() + " = 0";
    }
    private String formatTerm(int coef, String term) {
        if (coef > 0) return "+ " + coef + term + " ";
        else return "- " + Math.abs(coef) + term + " ";
    }
}
	
	class Panels extends Panel { 
		public Image im, im1;
		public Panels(Image im)
		{
			this.im= im;
		}
		
		public void update(Graphics g)
		{paint(g);}
		
		public void paint(Graphics g)
		{ super.paint(g);
		Dimension dimension= getSize();
		im1= createImage(dimension.width, dimension.height);
		pan(im1.getGraphics());
		g.drawImage(im1, 0,0, this);
		}

    public void pan(Graphics g)
	{ 
		Dimension dimension= getSize();
		int w=dimension.width;
		int h=dimension.height;

		Color color= getBackground();
		g.setColor(color);
		g.fillRect(0,0,w,h);

		for(int k=0;k<w;k+= im.getWidth(this))
			for(int l=0;l<h; l+=im.getHeight(this))
				g.drawImage(im,k,l,this);

		g.setColor(color.brighter());
		g.drawRect(1,1,w-2,h-2);
		g.setColor(color.darker());
		g.drawRect(0,0,w-2,h-2);
	}
}
	
		 
			
		
	 
		 
		 


