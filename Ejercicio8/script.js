class Jugador {
    constructor(id, nombre, edad, pais) {
        this._id = id;
        this._nombre = nombre;
        this._edad = edad;
        this._pais = pais;
        this._historial = null;
    }
    get id() {
        return this._id;
    }
    set id(value) {
        this._id = value;
    }
    get nombre() {
        return this._nombre;
    }
    set nombre(value) {
        this._nombre = value;
    }
    get edad() {
        return this._edad;
    }
    set edad(value) {
        this._edad = value;
    }
    get pais() {
        return this._pais;
    }
    set pais(value) {
        this._pais = value;
    }
    get historial() {
        return this._historial;
    }
    set historial(value) {
        this._historial = value;
    }
}
class Equipo {
    constructor(id, nombre, fecha) {
        this._id = id;
        this.nombre = nombre;
        this._fecha = fecha;
        this._jugadoresAsociados = [];
    }
    get id() {
        return this._id;
    }
    set id(value) {
        this._id = value;
    }
    get nombre() {
        return this._nombre;
    }
    set nombre(value) {
        this._nombre = value;
    }
    get fecha() {
        return this._fecha;
    }
    set fecha(value) {
        this._fecha = value;
    }
    get jugadoresAsociados() {
        return this._jugadoresAsociados;
    }
    set jugadoresAsociados(value) {
        this._jugadoresAsociados = value;
    }
}
class Historial {
    constructor(id, nGoles, nAmarillas, nRojas) {
        this._id = id;
        this._nGoles = nGoles;
        this._nAmarillas = nAmarillas;
        this._nRojas = nRojas;
    }
    get id() {
        return this._id;
    }
    set id(value) {
        this._id = value;
    }
    get nGoles() {
        return this._nGoles;
    }
    set nGoles(value) {
        this._nGoles = value;
    }
    get nAmarillas() {
        return this._nAmarillas;
    }
    set nAmarillas(value) {
        this._nAmarillas = value;
    }
    get nRojas() {
        return this._nRojas;
    }
    set nRojas(value) {
        this._nRojas = value;
    }
}
// Crea el equipo con 2 jugadores con sus respectivos historiales
let equipo1 = new Equipo("E1", "Real Madrid", new Date(1902, 2, 6));
let jugador1 = new Jugador("5325355R", "Karim Benzema", 34, "Francia");
let historial1 = new Historial("H1", 20, 1, 0);
let jugador2 = new Jugador("6363633A", "Vinicius JR", 21, "Brasil");
let historial2 = new Historial("H1", 13, 6, 0);
jugador1.historial = historial1;
equipo1.jugadoresAsociados.push(jugador1);
jugador2.historial = historial2;
equipo1.jugadoresAsociados.push(jugador2);
// Muestra un resultado partiendo de la informacion del equipo para probar relaciones
let RMadrid = equipo1;
let Benzema = RMadrid.jugadoresAsociados[0];
let BenzemaHist = Benzema.historial;
console.log("El jugador " + Benzema.nombre + " lleva " + BenzemaHist.nGoles + " goles y juega en el " + RMadrid.nombre);
