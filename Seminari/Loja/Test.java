import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.Random;

public class Test extends Applet implements MouseListener{
	
	private Image i;
 	private Graphics doubleG;
 	static int numriKlikimeve = 0;
	Katrori[][] k = new Katrori[6][6];
	boolean stop = false;
	Random r = new Random();
	boolean winner = false;
	static int mode = 2;
	
	public void init(){
		addMouseListener(this);
		setSize(900,600);
		
		for(int i = 0;i < 6;i += 1){
			for(int j = 0 ; j < 6;j+= 1){
				k[i][j] = new Katrori(j*100,i*100,100,100);	
			}
		}
	
	}	
		
	public void paint(Graphics g){
		if(numriKlikimeve > 49){
			stop = true;
		}
		
		if(test() == true){
			winner = true;
		}
		
		g.setColor(Color.BLACK);
		g.fillRect(600, 0, 300, this.getHeight());
		
		Font font2 = new Font("Arial",30,35);
		g.setFont(font2);
		g.setColor(Color.WHITE);
		g.drawString("Numri klikimeve: ", 621, 60);
		Font font = new Font("Arial" , 30, 70);
		g.setFont(font);
		g.drawString(numriKlikimeve + "", 621, 160);
		
		for(int i = 0; i < 6; i++){
			for(int j = 0;j < 6; j++){
				k[i][j].paint(g);
			}
		}
			
		g.setColor(Color.BLACK);
		
		for(int i = 0; i <this.getWidth(); i+=100){
			g.drawLine(0, i, this.getWidth(), i);
		}
			
		for(int i = 0; i <this.getHeight(); i+=100){
			g.drawLine(i, 0,i, this.getHeight());
		}
		
		g.setColor(Color.BLACK);
		g.setFont(font);
		if(stop == true){
			g.drawString("GAME OVER", 100, 300);
		}
		
		if(winner == true){
			Font font3 = new Font("Arial", 30 , 130);
			g.setFont(font3);
			g.drawString("WINNER", 50, 300);
		}
		
		//katrori per restart
		g.setColor(Color.RED);
		g.fillRect( 670 , 400 , 200 , 50);
		
		Font font4 = new Font("Arial" , 30,20);
		g.setFont(font4);
		g.drawString("Zgjedhni llojin: ", 670, 200);
		g.drawString("Lloji aktual: " + mode, 670, 300);
		
		g.fillRect(670, 220, 50, 50);
		g.fillRect(740, 220, 50, 50);
		
		g.setFont(font2);
		g.setColor(Color.WHITE);
		g.drawString("1", 680, 260);
		g.drawString("2", 750, 260);
		
		//tekti restart
		g.drawString("RESTART", 690, 435);
	}
	
	//a ka perfundu loja
	public boolean test(){
		boolean x = true;
		for(int i = 0;i<6;i++){
			for(int j = 0;j<6;j++){		
				if(k[i][j].getColor() != Color.WHITE){
					x = false;
				}
			}
		}
		return x;
	}
	
	public void restart(){
		for(int p = 0;p<6;p++){
			for(int q = 0;q<6;q++){
				if(r.nextInt(2) != 0){
					k[p][q].changeColor();
				}
			}
		}	
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(stop == false && winner == false){
			if(e.getX()< 600){
				if(e.getX() > 99 && e.getY() > 99){
					char t1= ("" + e.getX()).charAt(0);
					char p1 = ("" + e.getY()).charAt(0);
					String s1 = "" + t1;
					String s2 = "" + p1;
					int a = new Integer(s1).intValue();
					int	b = new Integer(s2).intValue();
					k[b][a].changeColor();
					if(b+1 < 6){
						k[b+1][a].changeColor();
					}	
					if(a+1 < 6){
						k[b][a+1].changeColor();
					}
					k[b-1][a].changeColor();
					k[b][a-1].changeColor();
				}
				
				if(e.getX() < 100 && e.getY() < 100){
					k[0][0].changeColor();
					k[0][1].changeColor();
					k[1][0].changeColor();
				}
				
				if(e.getX() > 99 && e.getY() < 100){
					char p2 = ("" + e.getX()).charAt(0);
					String s3 = "" + p2;
					int	a1 = new Integer(s3).intValue();
					k[0][a1].changeColor();
					k[0][a1-1].changeColor();
					k[1][a1].changeColor();
					if(a1+1<6){
						k[0][a1+1].changeColor();
					}
				}
				
				if(e.getY() > 99 && e.getX() < 100){
					char p3 = ("" + e.getY()).charAt(0);
					String s4 = "" + p3;
					int	a2 = new Integer(s4).intValue();
					k[a2][0].changeColor();
					k[a2-1][0].changeColor();
					k[a2][1].changeColor();
					if(a2+1<6){
						k[a2+1][0].changeColor();
					}
				}
				numriKlikimeve++;
			}
		}

		if(e.getX() > 670 && e.getX() < 870 && e.getY() > 400 && e.getY() < 450){
			if(mode == 1){
				for(int i = 0;i<6;i++){
					for(int j = 0; j< 6;j++){
						k[i][j].setColor(Color.RED);
					}
				}
			}else if(mode == 2){
				restart();
			}
			stop = false;
			winner = false;
			numriKlikimeve = 0;
		}
	
		if(e.getX() > 670 && e.getX() < 720 && e.getY() > 220 && e.getY() < 270){
			mode = 1;
		}
		
		if(e.getX() > 740 && e.getX() < 790 && e.getY() > 220 && e.getY() < 270){
			mode = 2;
		}
		
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void update(Graphics g){
		if(i==null){
			i = createImage(this.getSize().width, this.getSize().height);
			doubleG = i.getGraphics();
		}
		doubleG.setColor(getBackground());
		doubleG.fillRect(0,0,this.getSize().width,this.getSize().height);
		
		doubleG.setColor(getForeground());
		paint(doubleG);
		
		g.drawImage(i,0,0,this);
	}
	
}
