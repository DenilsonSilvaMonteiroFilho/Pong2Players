package Pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	
	public double x,y;
	public int width,height;
	
	public double dx, dy;
	public double speed = 2;
	
	public Ball (double x, double y) {
		this.x = x;
		this.y = y;
		this.width = 4;
		this.height = 4;
		
		int angle = new Random().nextInt(120 - 45) + 45 + 1;
		dx = Math.cos(Math.toRadians(angle));
		dy = Math.sin(Math.toRadians(angle));
	}
	public void tick() {
		//Colosao com a parede
		if(x+(dx*speed) + width >= Game.WIDTH) {
			dx*=-1;
		}
		else if(x+(dx*speed) < 0) {
			dx*=-1;
		}
		//
		if(y >= Game.HEIGHT) {
			//Ponto inimigo
			System.out.println("Ponto do inimigo.");
			new Game();
			return;
		}
		else if(y < 0) {
			//Ponto do jogador
			System.out.println("Ponto seu XD.");
			new Game();
			return;
		}
		
		Rectangle bounds = new Rectangle((int)(x+(dx*speed)),(int)(y+(dy*speed)),width,height);
		
		Rectangle boundsPlayer = new Rectangle(Game.player.x,Game.player.y,Game.player.width,Game.player.height);
		Rectangle boundsPlayer2 = new Rectangle((int)Game.player2.x,(int)Game.player2.y,Game.player2.width,Game.player2.height);
		
		if(bounds.intersects(boundsPlayer)){
			int angle = new Random().nextInt(120 - 45) + 45 + 1;
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			if(dy > 0)
			dy*=-1;
		}
		else if(bounds.intersects(boundsPlayer2)){
			int angle = new Random().nextInt(120 - 45) + 45 + 1;
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			if(dy < 0)
			dy*=-1;
		}
		
		x += dx * speed;
		y += dy * speed;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect((int)x, (int)y,width,height);
	}
}
