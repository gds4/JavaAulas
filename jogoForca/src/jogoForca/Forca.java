package jogoForca;

import java.awt.Graphics;

import javax.swing.JPanel;

import enums.BaseForca;
import enums.CorpoHumano;


public class Forca extends JPanel{
	

	//descobrir como colocar esse atributo e os metodos associados a ele na classe Jogo
	private int contador = 0;
	
	public void aumentaContador() {
		this.contador++;
	}
	
	
	public int getContador() {
		return contador;
	}


	public void reiniciaContador() {
		this.contador = 0;
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//desenha a forca:
		
		g.drawRect(BaseForca.BASE.getValor1(), BaseForca.BASE.getValor2(), BaseForca.BASE.getValor3(), BaseForca.BASE.getValor4());
		g.drawRect(BaseForca.PILARVERTICAL.getValor1(), BaseForca.PILARVERTICAL.getValor2(), BaseForca.PILARVERTICAL.getValor3(), BaseForca.PILARVERTICAL.getValor4());
		g.drawRect(BaseForca.PILARHORIZONTAL.getValor1(), BaseForca.PILARHORIZONTAL.getValor2(), BaseForca.PILARHORIZONTAL.getValor3(), BaseForca.PILARHORIZONTAL.getValor4());
		g.drawLine(BaseForca.CORDA.getValor1(), BaseForca.CORDA.getValor2(), BaseForca.CORDA.getValor3(), BaseForca.CORDA.getValor4());

		//desenha a pessoa:
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
			g.drawOval(BaseForca.FORCA.getValor1(), BaseForca.FORCA.getValor2(), BaseForca.FORCA.getValor3(), BaseForca.FORCA.getValor4());
		}
		
		
	}
	
	public boolean morreu() {
		return this.contador == 7;
	}
}
