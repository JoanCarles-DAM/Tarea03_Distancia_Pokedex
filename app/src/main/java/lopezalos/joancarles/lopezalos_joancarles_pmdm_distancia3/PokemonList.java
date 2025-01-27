package lopezalos.joancarles.lopezalos_joancarles_pmdm_distancia3;


public class PokemonList {
   private String nombre;
   private String url;

   private String image;
   private String tipo;
   private int indice;
   private double altura;
   private double peso;
   private boolean isCaptured; //Esta variable nos indica si el pokemon está capturado o no (para hacer cosas después)

    //primera petición GET
    public PokemonList(String nombre, String url) {
        this.nombre = nombre;
        this.url = url;
        this.isCaptured = false; //Por defecto NO está capturado
    }

    //Método para capturar el pokemon
    public void capturarPokemon() {
        this.isCaptured = true;
    }

    public Boolean isCaptured(){
        return isCaptured;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
