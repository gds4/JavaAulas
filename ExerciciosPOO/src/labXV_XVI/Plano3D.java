package labXV_XVI;

public class Plano3D {
	Ponto3D ponto1;
	Ponto3D ponto2;
	Ponto3D ponto3;
	
	
	public Plano3D(Ponto3D ponto1,Ponto3D ponto2,Ponto3D ponto3) {
		this.ponto1 = ponto1;
		this.ponto2 = ponto2;
		this.ponto3 = ponto3;
	}
	
	public boolean horizontal() {
		if(ponto1.getZ() == ponto2.getZ() && ponto1.getZ() == ponto3.getZ()) {
			return true;
		}
		return false;
	}
	public boolean vertical() {
		if(ponto1.getX() > ponto2.getZ() && ponto1.getZ() < ponto3.getZ() ||
			ponto2.getX() > ponto1.getZ() && ponto2.getZ() < ponto3.getZ() ||
			ponto3.getX() > ponto1.getZ() && ponto3.getZ() < ponto2.getZ()
			) {
			return true;
		}
		return false;
	}
	
	public boolean perpendicular() {
		if(this.horizontal() || this.vertical()) {
			return true;
		}
		return false;
	}
}
