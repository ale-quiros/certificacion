package pojo;

public class PrecioProductosData {
    private String producto;
    private double precioDolar;
    private double precioPound;
    private double precioEuro;


    public PrecioProductosData(String _producto, double _precioDolar, double _precioPound, double _precioEuro){
        this.setProducto(_producto);
        this.setPrecioDolar(_precioDolar);
        this.setPrecioPound(_precioPound);
        this.setPrecioEuro(_precioEuro);
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPrecioDolar() {
        return precioDolar;
    }

    public void setPrecioDolar(double precioDolar) {
        this.precioDolar = precioDolar;
    }

    public double getPrecioPound() {
        return precioPound;
    }

    public void setPrecioPound(double precioPound) {
        this.precioPound = precioPound;
    }

    public double getPrecioEuro() {
        return precioEuro;
    }

    public void setPrecioEuro(double precioEuro) {
        this.precioEuro = precioEuro;
    }
}
