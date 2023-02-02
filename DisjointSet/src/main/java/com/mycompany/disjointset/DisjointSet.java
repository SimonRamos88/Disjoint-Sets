

package com.mycompany.disjointset;


public class DisjointSet {
    
    /*DADO QUE USAMOS DINAMIC ARRAYS, PODEMOS CREAR CONJUNTOS DE CUALQUIER TAMANIO 
    YA QUE NO DEBEMOS LIMITARNOS AL ESPECIFICAR EL TAMANIO DEL CONJUNTO A LA HORA
    DE INSTANCIARLO*/
    
    private DinamicArray<Integer> parents;
    private DinamicArray<Integer> rank;
    
    
    //CONSTRUCTORES
    
    public DisjointSet(int capacity ){
        this.parents = new DinamicArray(capacity);
        this.rank = new DinamicArray(capacity);
        //Debemos agregarle elementos al arraylist si o si
        for(int i=0; i<capacity; i++){
            this.parents.pushBack(-1);
            this.rank.pushBack(-1);
        }
        this.parents.setSize(0);
        this.rank.setSize(0);
    }
    
    public DisjointSet(){
        this(2);
    }
    
    
    
    //METODOS
    
    //MakeSet
    public void makeSet(int x){
        //POr si queremos agregar un elemento fuera de las dimensiones del array
        if( x >= this.parents.size() ){
            System.out.println("ENTROO");
            if( x >= this.parents.getCapacity()){
                makeSpace(x);
            }
            this.parents.setSize(x+1); //Ahora el ultimo elemento sera el nuevo, pues se hizo todo el espacio para que el cupiera
            this.rank.setSize(x +1);
            
        }
        
        this.parents.set(x, x);
        this.rank.set(x, 0);
    }
    
    /*En dado caso que el elemento a agregar exceda la capacidad del arreglo, hay que aumentar esta hasta que el elemento x
    pueda agregarse*/
    
    public void makeSpace(int x){
        System.out.println("ENTRO RESIZE");
        while(x >= this.parents.getCapacity()){ //Solo comprobamos para uno, pues parents y rank tienen el mismo length
            this.parents.resize();
            this.rank.resize();
            
            //Debemos darle valores para que no quede empty
            for(int i= this.parents.size(); i<this.parents.getCapacity(); i++){
                this.parents.pushBack(-1);
                this.rank.pushBack(-1);
            }
        }
        
        System.out.println("size: " +  this.parents.size() + " capacity: " + this.parents.getCapacity());
    }
    
    
    //PathCompression
    
    //Find
    
    public int find(int x){
        boolean bandera = x>=0;
        while(bandera ){
            if(x ==  this.parents.get(x) || this.parents.get(x) <0){
                bandera = false;
            }
            x =  this.parents.get(x);
        }
        return x;
    }
    
    //PathCompression
    
     public int findCompression(int x){
        if(x>=0 && x != this.parents.get(x)){
            this.parents.set(x, findCompression( this.parents.get(x) ));          
        }
        return this.parents.get(x);
        
    }
    
    
    
    //Union
    public void union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);
        
        int ranParX = this.rank.get(parentX);
        int ranParY = this.rank.get(parentY);
        
        if(parentX != parentY){ //SI no estan en el mismo conjunto
            if(this.rank.get(ranParX) > this.rank.get(ranParY) ){           
                this.parents.set(parentY, parentX);

            }else{
                this.parents.set(parentX, parentY); // entonces y>= x
                if( this.rank.get(ranParY) == this.rank.get(ranParX) ){ //Si son iguales hay que cambiar el rank
                    this.rank.set(parentY, ranParY + 1);
                }
            }
        }
        
    
    }
    
    
    
    //GETTERS AND SETTERS

    public DinamicArray getParents() {
        return parents;
    }

    public void setParents(DinamicArray parents) {
        this.parents = parents;
    }

    public DinamicArray getRank() {
        return rank;
    }

    public void setRank(DinamicArray rank) {
        this.rank = rank;
    }
    
    
    
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
