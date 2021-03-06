package cass.oli.orbit;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import cass.oli.simulation.Game;
import cass.oli.simulation.Launcher;

public class Orbit extends Game{
	ArrayList<Planet> planets = new ArrayList<Planet>();
	int id = 0;
	
	public Orbit() {
		name = "Orbit";
	}

	@Override
	protected void loadImages() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leftClick(int x, int y) {
		planets.add(new Planet(id, this, x, y));
		id++;
	}

	@Override
	public void rightClick(int x, int y) {
		planets.add(new Planet(id, this, x, y, true));
		id++;
	}

	@Override
	public void dragTo(int x, int y) {
		leftClick(x, y);
	}

	@Override
	protected void tick(float delta) {
		for(Planet planet : planets) planet.tick(delta);
	}

	@Override
	protected void render(Graphics2D g) {
		//Background
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		
		for(Planet planet : planets) planet.render(g);
	}
	
	public static void main(String[] args) {
		new Launcher(new Orbit());
	}
}
