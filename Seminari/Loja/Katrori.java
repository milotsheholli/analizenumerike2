import java.awt.Color;
import java.awt.Graphics;

public class Katrori {
	
	private int x,y,z,k;
	private Color ngjyra = Color.RED;
	
	public Katrori(int i, int j, int k2, int k3) {
		x = i;
		y = j;
		z = k2;
		k = k3;
	}

	public void paint(Graphics g){
		g.setColor(ngjyra);
		g.fillRect(x, y, z, k);
	}
	
	public int getZ(){
		return z;
	}
	
	public int getK(){
		return k;
	}
	
	public void changeColor(){
		if(ngjyra == Color.RED){
			ngjyra = Color.WHITE;
		}else{
			ngjyra = Color.RED;
		}
	}
	
	public Color getColor(){
		return ngjyra;
	}
	
	public void setColor(Color c){
		ngjyra = c;
	}

}
