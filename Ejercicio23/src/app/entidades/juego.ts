export class Juego{

    private _id: number = 0
    private _titulo: string = ""
    private _compania: string = ""
    private _icono: string = ""
    private _valoracion: number = 0 

    constructor( id: number, titulo: string, compania: string, icono: string, valoracion: number ){
        this._id = id
        this._titulo = titulo
        this._compania = compania
        this._icono = icono
        this._valoracion = valoracion
    }

    public get id(): number {
        return this._id
    }
    public set id(value: number) {
        this._id = value
    }

    public get titulo(): string {
        return this._titulo
    }
    public set titulo(value: string) {
        this._titulo = value
    }

    public get compania(): string {
        return this._compania
    }
    public set compania(value: string) {
        this._compania = value
    }

    public get icono(): string {
        return this._icono
    }
    public set icono(value: string) {
        this._icono = value
    }

    public get valoracion(): number {
        return this._valoracion
    }
    public set valoracion(value: number) {
        this._valoracion = value
    }
}
