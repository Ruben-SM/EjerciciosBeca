export class Usuario{
    private _nombre: string = ""
    private _pass: string = ""


    constructor(nombre: string, pass: string){
        this._nombre = nombre
        this._pass = pass
    }

    public get nombre(): string {
        return this._nombre
    }
    public set nombre(value: string) {
        this._nombre = value
    }

    public get pass(): string {
        return this._pass
    }
    public set pass(value: string) {
        this._pass = value
    }
    
}