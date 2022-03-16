class Jugador {

    private _id: string
    private _nombre: string
    private _edad: number
    private _pais: string
    private _historial: Historial

    constructor(id: string, nombre: string, edad: number, pais: string ){
        this._id = id
        this._nombre = nombre
        this._edad = edad
        this._pais = pais

        this._historial=null
    }

    public get id(): string {
        return this._id
    }
    public set id(value: string) {
        this._id = value
    }

    public get nombre(): string {
        return this._nombre
    }
    public set nombre(value: string) {
        this._nombre = value
    }

    public get edad(): number {
        return this._edad
    }
    public set edad(value: number) {
        this._edad = value
    }

    public get pais(): string {
        return this._pais
    }
    public set pais(value: string) {
        this._pais = value
    }

    public get historial(): Historial {
        return this._historial
    }
    
    public set historial(value: Historial) {
        this._historial = value
    }

}

class Equipo {
    
    private _id: string
    private _nombre: string
    private _fecha: Date
    private _jugadoresAsociados: Array<Jugador>

    constructor(id: string, nombre: string, fecha: Date){
        this._id = id
        this.nombre = nombre
        this._fecha = fecha
        this._jugadoresAsociados = []
    }

    public get id(): string {
        return this._id
    }
    public set id(value: string) {
        this._id = value
    }

    public get nombre(): string {
        return this._nombre
    }
    public set nombre(value: string) {
        this._nombre = value
    }

    public get fecha(): Date {
        return this._fecha
    }
    public set fecha(value: Date) {
        this._fecha = value
    }

    public get jugadoresAsociados(): Array<Jugador> {
        return this._jugadoresAsociados
    }
    public set jugadoresAsociados(value: Array<Jugador>) {
        this._jugadoresAsociados = value
    }
    
}

class Historial {
    private _id: string
    private _nGoles: number
    private _nAmarillas: number
    private _nRojas: number

    constructor(id: string, nGoles: number, nAmarillas: number, nRojas: number){
        this._id = id
        this._nGoles = nGoles
        this._nAmarillas = nAmarillas
        this._nRojas = nRojas
    }

    public get id(): string {
        return this._id
    }
    public set id(value: string) {
        this._id = value
    }

    public get nGoles(): number {
        return this._nGoles
    }
    public set nGoles(value: number) {
        this._nGoles = value
    }

    public get nAmarillas(): number {
        return this._nAmarillas
    }
    public set nAmarillas(value: number) {
        this._nAmarillas = value
    }

    public get nRojas(): number {
        return this._nRojas
    }
    public set nRojas(value: number) {
        this._nRojas = value
    }
}

// Crea el equipo con 2 jugadores con sus respectivos historiales

let equipo1: Equipo = new Equipo("E1","Real Madrid", new Date(1902,2,6))

let jugador1: Jugador = new Jugador("5325355R","Karim Benzema",34,"Francia")
let historial1: Historial = new Historial("H1",20,1,0)

let jugador2: Jugador = new Jugador("6363633A","Vinicius JR",21,"Brasil")
let historial2: Historial = new Historial("H1",13,6,0)

jugador1.historial = historial1
equipo1.jugadoresAsociados.push(jugador1)

jugador2.historial = historial2
equipo1.jugadoresAsociados.push(jugador2)


// Muestra un resultado partiendo de la informacion del equipo para probar relaciones

let RMadrid: Equipo = equipo1
let Benzema: Jugador = RMadrid.jugadoresAsociados[0]
let BenzemaHist: Historial = Benzema.historial

console.log("El jugador "+Benzema.nombre +" lleva "+ BenzemaHist.nGoles + " goles y juega en el "+ RMadrid.nombre )


