export class Videojuego{
    private _id: number = 0
    private _titulo: String = ""
    private _compania: String = ""
    private _valoracion: number = 0

    private static contador : number = 1;


    constructor(titulo: String, compania: String, valoracion: number){
        this._id = Videojuego.contador++;
        this._titulo = titulo
        this._compania = compania
        this._valoracion = valoracion
    }

    public get id(): number {
        return this._id
    }
    public set id(value: number) {
        this._id = value
    }

    public get titulo(): String {
        return this._titulo
    }
    public set titulo(value: String) {
        this._titulo = value
    }

    public get compania(): String {
        return this._compania
    }
    public set compania(value: String) {
        this._compania = value
    }

    public get valoracion(): number {
        return this._valoracion
    }
    public set valoracion(value: number) {
        this._valoracion = value
    }

    public toString() : string {
        return `ID: ${this._id}, Título: ${this._titulo}, Compañia:  ${this._compania}, Valoración: ${this._valoracion}`
    }
    
}