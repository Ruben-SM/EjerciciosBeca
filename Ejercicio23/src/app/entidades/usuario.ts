export class Usuario{
    private _nombre: string = ""
    private _password: string = ""


    constructor(nombre: string, password: string){
        this._nombre = nombre
        this._password = password
    }

    public get nombre(): string {
        return this._nombre
    }
    public set nombre(value: string) {
        this._nombre = value
    }

    public get password(): string {
        return this._password
    }
    public set password(value: string) {
        this._password = value
    }
    
}