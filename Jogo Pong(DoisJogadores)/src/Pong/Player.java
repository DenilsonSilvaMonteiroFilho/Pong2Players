package Pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	
	public boolean right,left;
	public int width,height;
	public int x,y;
	
	public Player (int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 5;
	}
	
	public void tick() {
		if(right) {
			x = x+2;
		}
		else if(left) {
			x = x-2;
		}
		//Sistema de colisao
		if(x+width > Game.WIDTH) {
			x = Game.WIDTH - width;
		}
		else if(x < 0) {
			x = 0;
		}
		//
	}
	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		//Atualiza com as cordenadas que foram passadas no tick, que foram auteradas
		g.fillRect(x, y,width,height);
	}
}
