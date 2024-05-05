package jogoForca;

import java.awt.Graphics;

import javax.swing.JPanel;

import enums.BaseForca;
import enums.CorpoHumano;


public class Forca extends JPanel{
	
	/**
	 * 
	 */
	
	private int contador = 7;
	
	public void aumenta() {
		this.contador++;
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawRect(BaseForca.BASE.getValor_1(), BaseForca.BASE.getValor_2(), BaseForca.BASE.getValor_3(), BaseForca.BASE.getValor_4());
		
		
		
		if(contador >= 1){
			g.drawOval(CorpoHumano.CABECA.getValor1(), CorpoHumano.CABECA.getValor2(), CorpoHumano.CABECA.getValor3(), CorpoHumano.CABECA.getValor4());
		}if(contador >= 2){
			g.drawLine(CorpoHumano.TRONCO.getValor1(), CorpoHumano.TRONCO.getValor2(), CorpoHumano.TRONCO.getValor3(), CorpoHumano.TRONCO.getValor4());
		}if(contador >= 3){
			g.drawLine(CorpoHumano.BRACOESQUERDO.getValor1(), CorpoHumano.BRACOESQUERDO.getValor2(), CorpoHumano.BRACOESQUERDO.getValor3(), CorpoHumano.BRACOESQUERDO.getValor4());
		}if(contador >= 4){
			g.drawLine(CorpoHumano.BRACODIREITO.getValor1(), CorpoHumano.BRACODIREITO.getValor2(), CorpoHumano.BRACODIREITO.getValor3(), CorpoHumano.BRACODIREITO.getValor4());
		}if(contador >= 5){
			g.drawLine(CorpoHumano.PERNAESQUERDA.getValor1(), CorpoHumano.PERNAESQUERDA.getValor2(), CorpoHumano.PERNAESQUERDA.getValor3(), CorpoHumano.PERNAESQUERDA.getValor4());
		}if(contador >= 6){
			g.drawLine(CorpoHumano.PERNADIREITA.getValor1(), CorpoHumano.PERNADIREITA.getValor2(), CorpoHumano.PERNADIREITA.getValor3(), CorpoHumano.PERNADIREITA.getValor4());
		}if(contador >= 7){
			g.drawOval(CorpoHumano.FORCA.getValor1(), CorpoHumano.FORCA.getValor2(), CorpoHumano.FORCA.getValor3(), CorpoHumano.FORCA.getValor4());
		}
		
		
	}
	
	public boolean morreu() {
		return this.contador == 7;
	}
}
