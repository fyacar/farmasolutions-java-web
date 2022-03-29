package interfaces;

import java.util.ArrayList;

import beans.CabeceraBoletaDTO;
import beans.DetalleBoletaDTO;
import beans.ProductoDTO;
import beans.VentaDTO;

public interface VentaDAO {
	
	public String generaBoleta();
	public int realizarVenta(CabeceraBoletaDTO cab, ArrayList<DetalleBoletaDTO> det);
	
}
